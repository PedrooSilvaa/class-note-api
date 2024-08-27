package tech.silva.classNotesAPI.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tech.silva.classNotesAPI.entity.UserEntity;
import tech.silva.classNotesAPI.jwt.JwtUserDetails;
import tech.silva.classNotesAPI.service.UserService;
import tech.silva.classNotesAPI.web.dto.PasswordChangeDto;
import tech.silva.classNotesAPI.web.dto.UserCreateDto;
import tech.silva.classNotesAPI.web.dto.UserResponseDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    //Method to create new user
    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody @Valid UserCreateDto createDto){
        UserEntity user = userService.saveUser(createDto.toUser());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDto.toUserResponse(user));
    }

    //Method to search user by username
    @GetMapping("/username")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponseDto> findByUsername(@RequestParam String username){
        UserEntity user = userService.findByUsername(username);
        return ResponseEntity.ok().body(UserResponseDto.toUserResponse(user));
    }

    //Method to update logged in user password
    @PutMapping
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<Void> changePassword(@AuthenticationPrincipal JwtUserDetails userDetails,
                                               @RequestBody @Valid PasswordChangeDto changeDto){
        userService.changePassword(changeDto, userDetails.getId());
        return ResponseEntity.noContent().build();
    }
}
