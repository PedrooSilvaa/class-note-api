package tech.silva.classNotesAPI.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserLoginDto(@NotBlank
                           @Email(regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
                           String username,
                           @NotBlank
                           String password) {
}
