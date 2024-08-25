package tech.silva.classNotesAPI.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.silva.classNotesAPI.entity.UserEntity;
import tech.silva.classNotesAPI.service.UserService;
import tech.silva.classNotesAPI.web.dto.UserCreateDto;
import tech.silva.classNotesAPI.web.dto.UserResponseDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserCreateDto createDto){
        UserEntity user = userService.saveUser(createDto.toUser());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDto.toUserResponse(user));
    }

}
