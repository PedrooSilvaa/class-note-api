package tech.silva.classNotesAPI.exception;

public class InvalidCredencialException extends RuntimeException {
    public InvalidCredencialException(String message) {
        super(message);
    }
}