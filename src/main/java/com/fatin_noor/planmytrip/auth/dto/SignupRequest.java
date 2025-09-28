package com.fatin_noor.planmytrip.auth.dto;

public record SignupRequest(
    String email,
    String password,
    String name

) {}
