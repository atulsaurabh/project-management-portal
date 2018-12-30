package org.parul.pmp.exception;

public class UserNotExistException extends Exception {


    public UserNotExistException() {
        super("User is not available in the system");
    }

    public UserNotExistException(String message) {
        super(message);
    }

    public UserNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
