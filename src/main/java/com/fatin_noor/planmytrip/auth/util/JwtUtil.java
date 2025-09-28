package com.fatin_noor.planmytrip.auth.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
    @Value("${JWT_SECRET}")
    private String SECRET_KEY;

    @Value("${ACCESS_TOKEN_VALIDITY:900000}") // default 15 min in ms
    private long accessTokenValidityMillis;

    private static final long REFRESH_TOKEN_VALIDITY_MILLIS = 1000 * 60 * 60 * 24 * 7; // 7 days

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Generate Access Token
    public String generateAccessToken(String username, Map<String, Object> claims) {
        return Jwts.builder()
                .subject(username)
                .claims(claims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + accessTokenValidityMillis))
                .signWith(getSigningKey())
                .compact();
    }

    // Generate Refresh Token
    public String generateRefreshToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_VALIDITY_MILLIS))
                .signWith(getSigningKey())
                .compact();
    }

    // Extract Username (subject)
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract Role
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    // Validate Access Token
    public boolean validateAccessToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (username.equals(extractedUsername) && !isTokenExpired(token));
    }

    // Validate Refresh Token (only checks expiry & signature)
    public boolean validateRefreshToken(String token) {
        try {
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public long getAccessTokenValiditySeconds() {
        return accessTokenValidityMillis / 1000;
    }

    public long getRefreshTokenValiditySeconds() {
        return REFRESH_TOKEN_VALIDITY_MILLIS / 1000;
    }
}
