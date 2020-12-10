package org.wso2.integrationstudio.eclipse.esb.cloud.resources;

/**
 * Messages shown to the user
 *
 */
public class ResponseMessageConstants {

    // Error messages returned by the WSO2 Integration Cloud API
    public static class ErrorMessages {
        public static final String VERSION_EXISTS = "This version already exists. Please create a new version.";
        public static final String APPLICATION_EXISTS = "Application with same name and version already exists!";
        public static final String NO_RESOURCES_ERROR = "There are no resources available in the cloud to deploy the application!";
        public static final String AUTHENTICATION_FAILURE = "Failed to authenticate user - Please log in!";
        public static final String REQUEST_FAILURE = "Failed to complete request..!";
        public static final String ENDPOINTS_ARE_LOADING = "Endpoints are still loading, please try again later";
    }
}
