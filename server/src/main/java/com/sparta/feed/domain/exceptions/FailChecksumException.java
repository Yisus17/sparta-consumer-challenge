package com.sparta.feed.domain.exceptions;

public class FailChecksumException extends RuntimeException {

    /**
     * @param expected expected checksum value
     * @param actual actual checksum value that causes the exception
     */
    public FailChecksumException(Long expected, Long actual) {
        super(String.format("Invalid checksum for Message, expected::[%s] , actual::[%s]",
            expected,
            actual));
    }

}
