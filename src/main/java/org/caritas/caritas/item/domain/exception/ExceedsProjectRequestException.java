package org.caritas.caritas.item.domain.exception;

public class ExceedsProjectRequestException extends RuntimeException {

    public ExceedsProjectRequestException(String message) {
        super(message);
    }

    public ExceedsProjectRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
