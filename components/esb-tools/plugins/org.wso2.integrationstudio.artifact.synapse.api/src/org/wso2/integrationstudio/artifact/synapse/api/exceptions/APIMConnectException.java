package org.wso2.integrationstudio.artifact.synapse.api.exceptions;

/**
 * Exception thrown when an fails to connect APIM server.
 */
public class APIMConnectException extends Exception {
    public APIMConnectException() {
        super();
    }

    public APIMConnectException(String message) {
        super(message);
    }

    public APIMConnectException(String message, Throwable cause) {
        super(message, cause);
    }

    public APIMConnectException(Throwable cause) {
        super(cause);
    }

    protected APIMConnectException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
