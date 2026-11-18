package org.example.exception;

public class MultipleUsersException extends RuntimeException {
    public MultipleUsersException(String message) {
        super(message);
    }
}
