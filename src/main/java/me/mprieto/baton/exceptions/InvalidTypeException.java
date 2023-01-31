package me.mprieto.baton.exceptions;

public class InvalidTypeException extends BatonException {
    public InvalidTypeException() {
    }

    public InvalidTypeException(String message) {
        super(message);
    }

    public InvalidTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
