package tech.silva.classNotesAPI.web.dto;

import tech.silva.classNotesAPI.entity.UserEntity;

public record UserResponseDto(Long id,
                              String username,
                              String password,
                              String name) {

    public UserResponseDto(Long id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public static UserResponseDto toUserResponse(UserEntity userEntity){
        return new UserResponseDto(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getName()
        );
    }
}
