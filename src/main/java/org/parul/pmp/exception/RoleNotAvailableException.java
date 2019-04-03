package org.parul.pmp.exception;

public class RoleNotAvailableException extends Exception {

    public RoleNotAvailableException(){}

    public RoleNotAvailableException(String message) {
        super(message);
    }

    public RoleNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleNotAvailableException(Throwable cause) {
        super(cause);
    }

    public RoleNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
