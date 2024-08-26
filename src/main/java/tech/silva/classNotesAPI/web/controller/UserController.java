package tech.silva.classNotesAPI.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody @Valid UserCreateDto createDto){
        UserEntity user = userService.saveUser(createDto.toUser());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDto.toUserResponse(user));
    }

    @GetMapping("/username")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponseDto> findByUsername(@RequestParam String username){
        System.out.println("ola");
        UserEntity user = userService.findByUsername(username);
        return ResponseEntity.ok().body(UserResponseDto.toUserResponse(user));
    }

}
