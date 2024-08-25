package tech.silva.classNotesAPI.exception;


public class UserUniqueViolationException  extends RuntimeException {

    public UserUniqueViolationException(String message) {
        super(message);
    }
}
