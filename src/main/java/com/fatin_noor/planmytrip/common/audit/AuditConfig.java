package com.fatin_noor.planmytrip.common.audit;


import com.fatin_noor.planmytrip.auth.service.AuthService;
import com.fatin_noor.planmytrip.user.entity.User;
import com.fatin_noor.planmytrip.user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditConfig {

    @Bean
    public AuditorAware<User> auditorProvider(AuthService authService) {
        return () -> {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null || !auth.isAuthenticated()) {
                return Optional.empty();
            }
            // Extract user ID from your security context
            // Adjust based on your User implementation
            return Optional.ofNullable(authService.getCurrentUser()); // Replace with actual user ID extraction
        };
    }
}