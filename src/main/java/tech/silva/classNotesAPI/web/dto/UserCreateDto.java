package tech.silva.classNotesAPI.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import tech.silva.classNotesAPI.entity.UserEntity;

public record UserCreateDto(@NotBlank
                            String name,
                            @NotBlank
                            @Email(regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
                            String username,
                            @NotBlank
                            @Size(min = 6)
                            String password) {

    public UserEntity toUser(){
        return new UserEntity(
                name,
                username,
                password
        );
    }

}
