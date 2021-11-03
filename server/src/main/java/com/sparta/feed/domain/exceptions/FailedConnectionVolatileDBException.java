package com.sparta.feed.domain.exceptions;

public class FailedConnectionVolatileDBException extends RuntimeException {

    /**
     * @param repository repository name that causes the exception
     * @param message exception message
     */
    public FailedConnectionVolatileDBException(String repository, String message) {
        super(String.format("Cannot connect to repository::[%s] , ::[%s]", repository, message));
    }

}
