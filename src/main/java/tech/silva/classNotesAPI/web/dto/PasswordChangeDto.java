package tech.silva.classNotesAPI.web.dto;

import jakarta.validation.constraints.NotBlank;

public record PasswordChangeDto (@NotBlank
                                 String currentPassword,
                                 @NotBlank
                                 String newPassword,
                                 @NotBlank
                                 String confirmPassword){
}
