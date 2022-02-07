package org.wso2.integrationstudio.artifact.synapse.api.exceptions;

/**
 * Exception thrown when an error occurs during a HTTP call.
 */
public class HttpClientException extends Exception {
    public HttpClientException() {
        super();
    }

    public HttpClientException(String message) {
        super(message);
    }

    public HttpClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpClientException(Throwable cause) {
        super(cause);
    }

    protected HttpClientException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

