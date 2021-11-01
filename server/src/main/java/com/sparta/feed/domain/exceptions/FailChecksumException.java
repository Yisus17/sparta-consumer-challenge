package com.sparta.feed.domain.exceptions;

public class FailChecksumException extends RuntimeException {
    public FailChecksumException(Long expected, Long actual) {
        super(String.format("Invalid checksum for Message, expected::[%s] , actual::[%s]",
            expected,
            actual));
    }

}
