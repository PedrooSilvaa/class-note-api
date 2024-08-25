package tech.silva.classNotesAPI.web.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.silva.classNotesAPI.exception.InvalidCredencialException;
import tech.silva.classNotesAPI.exception.ObjectNotFoundException;
import tech.silva.classNotesAPI.exception.UserUniqueViolationException;

@RestControllerAdvice
public class ApiHandlerException {

    //User
    @ExceptionHandler(UserUniqueViolationException.class)
    public ResponseEntity<ErrorMessage> userUniqueViolationException(RuntimeException ex, HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorMessage> objectNotFoundException(RuntimeException ex, HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(InvalidCredencialException.class)
    public ResponseEntity<ErrorMessage> invalidCredencialException(RuntimeException ex, HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));
    }
}
