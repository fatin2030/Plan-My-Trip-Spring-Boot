package com.fatin_noor.planmytrip.auth.service;

import com.fatin_noor.planmytrip.auth.dto.SignupRequest;
import com.fatin_noor.planmytrip.auth.dto.LoginRequest;
import com.fatin_noor.planmytrip.auth.dto.LoginResponse;
import com.fatin_noor.planmytrip.auth.dto.RefreshRequest;

public interface AuthService {
    void registerUser(SignupRequest user);
    LoginResponse login(LoginRequest req);
    LoginResponse refreshToken(RefreshRequest req);
    void revokeRefreshToken(String token);
}
