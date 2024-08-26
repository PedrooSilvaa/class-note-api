package tech.silva.classNotesAPI.web.dto;

import tech.silva.classNotesAPI.entity.UserEntity;

public record UserResponseDto(Long id,
                              String name,
                              String username,
                              String role) {

    public UserResponseDto(Long id, String name, String username, String role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.role = role;
    }

    public static UserResponseDto toUserResponse(UserEntity userEntity){
        return new UserResponseDto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getUsername(),
                userEntity.getRole().name()
        );
    }
}
