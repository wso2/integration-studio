package org.wso2.developerstudio.eclipse.esb.cloud.exceptions;

/**
 * Exception thrown when network is unavailable
 *
 */
public class NetworkUnavailableException extends Exception {

    private static final String message = "No internet connection available!";

    public NetworkUnavailableException() {
        super(message);
    }

    public NetworkUnavailableException(String message) {
        super(message);
    }

    public NetworkUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetworkUnavailableException(Throwable cause) {
        super(cause);
    }

    protected NetworkUnavailableException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
