package me.mprieto.baton.common.exceptions;

public class BatonException extends RuntimeException {

    public BatonException() {
    }

    public BatonException(String message) {
        super(message);
    }

    public BatonException(String message, Throwable cause) {
        super(message, cause);
    }

    public BatonException(Throwable cause) {
        super(cause);
    }

    public BatonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
