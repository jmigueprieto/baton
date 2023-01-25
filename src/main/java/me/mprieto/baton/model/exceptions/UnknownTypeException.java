package me.mprieto.baton.model.exceptions;

public class UnknownTypeException extends BatonException{

    public UnknownTypeException() {
        super();
    }

    public UnknownTypeException(String message) {
        super(message);
    }

    public UnknownTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownTypeException(Throwable cause) {
        super(cause);
    }

    public UnknownTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
