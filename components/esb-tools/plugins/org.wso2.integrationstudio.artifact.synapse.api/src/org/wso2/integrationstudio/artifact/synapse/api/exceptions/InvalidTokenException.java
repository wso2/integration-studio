package org.wso2.integrationstudio.artifact.synapse.api.exceptions;

/**
 * Exception thrown when the authentication token is invalid / expired.
 */
public class InvalidTokenException extends Exception {
    public InvalidTokenException() {
        super();
    }

    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTokenException(Throwable cause) {
        super(cause);
    }

    protected InvalidTokenException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
