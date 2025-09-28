package com.fatin_noor.planmytrip.auth.service.impl;

import com.fatin_noor.planmytrip.auth.dto.SignupRequest;
import com.fatin_noor.planmytrip.auth.dto.LoginRequest;
import com.fatin_noor.planmytrip.auth.dto.LoginResponse;
import com.fatin_noor.planmytrip.auth.dto.RefreshRequest;
import com.fatin_noor.planmytrip.auth.entity.RefreshToken;
import com.fatin_noor.planmytrip.auth.exception.ApiException;
import com.fatin_noor.planmytrip.auth.repository.RefreshTokenRepository;
import com.fatin_noor.planmytrip.auth.service.AuthService;
import com.fatin_noor.planmytrip.auth.util.JwtUtil;
import com.fatin_noor.planmytrip.auth.util.TokenHashUtil;
import com.fatin_noor.planmytrip.user.entity.Role;
import com.fatin_noor.planmytrip.user.entity.User;
import com.fatin_noor.planmytrip.user.repository.RoleRepository;
import com.fatin_noor.planmytrip.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void registerUser(SignupRequest req) {
        if (userRepository.existsByEmail(req.email())) {
            throw new ApiException("Email already in use", 400);
        }

        Role userRole = roleRepository.findByRoleName("USER")
                .orElseGet(() -> {
                    Role newRole = Role.builder().roleName("USER").build();
                    return roleRepository.save(newRole);
                });

        User user = User.builder()
                .email(req.email())
                .password(passwordEncoder.encode(req.password()))
                .name(req.name())
                .role(userRole)
                .build();

        userRepository.save(user);
    }

    @Override
    @Transactional
    public LoginResponse login(LoginRequest req) {
        User user = userRepository.findByEmail(req.email())
                .orElseThrow(() -> new ApiException("Invalid credentials", 401));

        if (!passwordEncoder.matches(req.password(), user.getPassword())) {
            throw new ApiException("Invalid credentials", 401);
        }

        var claims = Map.<String, Object>of("role", user.getRole().getRoleName());

        String accessToken = jwtUtil.generateAccessToken(user.getEmail(), claims);
        String refreshToken = jwtUtil.generateRefreshToken(user.getEmail());

        String refreshTokenHash = TokenHashUtil.sha256(refreshToken);

        RefreshToken rt = RefreshToken.builder()
                .tokenHash(refreshTokenHash)
                .user(user)
                .expiresAt(Instant.now().plusSeconds(jwtUtil.getRefreshTokenValiditySeconds()))
                .revoked(false)
                .build();
        refreshTokenRepository.save(rt);

        return new LoginResponse(accessToken, refreshToken, "Bearer", jwtUtil.getAccessTokenValiditySeconds());
    }

    @Override
    @Transactional
    public LoginResponse refreshToken(RefreshRequest req) {
        String incoming = req.refreshToken();

        if (!jwtUtil.validateRefreshToken(incoming)) {
            throw new ApiException("Invalid refresh token", 401);
        }

        String email = jwtUtil.extractUsername(incoming);
        String hash = TokenHashUtil.sha256(incoming);

        RefreshToken stored = refreshTokenRepository.findByTokenHash(hash)
                .orElseThrow(() -> new ApiException("Refresh token not found", 401));

        if (stored.isRevoked() || stored.getExpiresAt().isBefore(Instant.now())) {
            throw new ApiException("Refresh token expired or revoked", 401);
        }

        stored.setRevoked(true);
        refreshTokenRepository.save(stored);

        User user = stored.getUser();
        var claims = Map.<String, Object>of("role", user.getRole().getRoleName());

        String newAccess = jwtUtil.generateAccessToken(user.getEmail(), claims);
        String newRefresh = jwtUtil.generateRefreshToken(user.getEmail());
        String newHash = TokenHashUtil.sha256(newRefresh);

        RefreshToken newStored = RefreshToken.builder()
                .tokenHash(newHash)
                .user(user)
                .expiresAt(Instant.now().plusSeconds(jwtUtil.getRefreshTokenValiditySeconds()))
                .revoked(false)
                .build();
        refreshTokenRepository.save(newStored);

        return new LoginResponse(newAccess, newRefresh, "Bearer", jwtUtil.getAccessTokenValiditySeconds());
    }

    @Override
    @Transactional
    public void revokeRefreshToken(String token) {
        String hash = TokenHashUtil.sha256(token);
        refreshTokenRepository.findByTokenHash(hash)
                .ifPresent(rt -> {
                    rt.setRevoked(true);
                    refreshTokenRepository.save(rt);
                });
    }
}
