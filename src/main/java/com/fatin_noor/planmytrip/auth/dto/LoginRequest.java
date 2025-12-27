package com.fatin_noor.planmytrip.auth.dto;

public record LoginRequest(
    String email,
    String password
) {}
