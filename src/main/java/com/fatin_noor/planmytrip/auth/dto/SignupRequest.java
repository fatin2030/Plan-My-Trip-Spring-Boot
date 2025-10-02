package com.fatin_noor.planmytrip.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public record SignupRequest(
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    String email,

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
//             message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    String password,

    @NotBlank(message = "Role is required")
    //@Pattern(regexp = "^(USER|ADMIN)$", message = "Role must be either USER or ADMIN")
    String role,

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name can only contain letters and spaces")
    String name,


    String phone,
    MultipartFile profileImageUrl,

    String country,
    String city,
    String street


) {}