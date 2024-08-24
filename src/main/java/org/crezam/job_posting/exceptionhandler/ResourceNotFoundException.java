package org.crezam.job_posting.exceptionhandler;

public class ResourceNotFoundException extends RuntimeException {

    // Constructor with message only
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
