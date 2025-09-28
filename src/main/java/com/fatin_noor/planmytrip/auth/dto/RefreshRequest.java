package com.fatin_noor.planmytrip.auth.dto;

import lombok.Builder;

@Builder
public record RefreshRequest(
    String refreshToken
) {
}
