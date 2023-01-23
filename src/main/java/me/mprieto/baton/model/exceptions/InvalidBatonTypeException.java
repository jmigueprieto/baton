package me.mprieto.baton.model.exceptions;

public class InvalidBatonTypeException extends BatonException {
    public InvalidBatonTypeException() {
    }

    public InvalidBatonTypeException(String message) {
        super(message);
    }

    public InvalidBatonTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBatonTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidBatonTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
