package com.sparta.feed.domain.exceptions;

public class FailedConnectionVolatileDBException extends RuntimeException {
    public FailedConnectionVolatileDBException(String repository, String message) {
        super(String.format("Cannot connect to repository::[%s] , ::[%s]", repository, message));
    }

}
