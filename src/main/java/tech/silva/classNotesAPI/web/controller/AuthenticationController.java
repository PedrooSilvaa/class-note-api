package tech.silva.classNotesAPI.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.silva.classNotesAPI.exception.InvalidCredencialException;
import tech.silva.classNotesAPI.jwt.JwtToken;
import tech.silva.classNotesAPI.jwt.JwtUserDetailsService;
import tech.silva.classNotesAPI.web.dto.UserLoginDto;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

    private final JwtUserDetailsService detailsService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationController(JwtUserDetailsService detailsService, AuthenticationManager authenticationManager) {
        this.detailsService = detailsService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(path = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authentication(@RequestBody @Valid UserLoginDto dto, HttpServletRequest request) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(dto.username(), dto.password());

            authenticationManager.authenticate(authenticationToken);

            JwtToken token = detailsService.getTokenAuthenticated(dto.username());

            return ResponseEntity.ok(token);
        }catch (AuthenticationException ex) {
            throw new InvalidCredencialException("Invalid credencial " + dto.username());
        }
    }

}
