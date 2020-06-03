/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.apim.endpoint.central.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.APIMCTLException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.CTLAPI;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.CTLEnvironment;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.APIMCTLConstants;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.utils.JsonUtils;

public class APIMCTLClient {

    private static APIMCTLClient apimctlClient;

    private APIMCTLClient() {
    }

    public static APIMCTLClient getInstance() {
        if (apimctlClient == null) {
            apimctlClient = new APIMCTLClient();
        }
        return apimctlClient;
    }

    /**
     * Login to APIM through APIM Controller.
     * 
     * @param username name of the user
     * @param password password of the account
     * @param hostUrl url of the APIM instance
     * @throws IOException error reading response
     * @throws APIMCTLException failures executing commands
     */
    public void login(String username, String password, String hostUrl) throws IOException, APIMCTLException {
        String apiControllerPath = getAPIControllerPath();

        // Retrieve environments.
        String[] listEnvironmentCommand = { apiControllerPath, APIMCTLConstants.Commands.LIST,
                APIMCTLConstants.Commands.ENVIRONMENTS, APIMCTLConstants.Params.FORMAT,
                APIMCTLConstants.Params.JSON_FORMAT };
        Process process = Runtime.getRuntime().exec(listEnvironmentCommand);
        List<String> responses = getCTLResponseLinesSeperated(process);
        List<CTLEnvironment> environments = JsonUtils.getCTLEnvironmentListFromJson(responses);

        // Check if default environment exists.
        CTLEnvironment environment = null;
        for (CTLEnvironment ctlEnvironment : environments) {
            if (ctlEnvironment.getName().equals(APIMCTLConstants.Environment.DEFAULT_ENV_NAME)) {
                environment = ctlEnvironment;
                break;
            }
        }

        // Create an environment if not exist.
        if (null == environment) {
            String[] addEnvironmentCommand = { apiControllerPath, APIMCTLConstants.Commands.ADD_ENV,
                    APIMCTLConstants.Params.ENVIRONMENT, APIMCTLConstants.Environment.DEFAULT_ENV_NAME,
                    APIMCTLConstants.Params.APIM_ENDPOINT, hostUrl, APIMCTLConstants.Params.TOKEN_ENDPOINT,
                    hostUrl + APIMCTLConstants.TOKEN_PATH };
            process = Runtime.getRuntime().exec(addEnvironmentCommand);
            String response = getCTLResponse(process);
            if (!response.contains(APIMCTLConstants.CTLResponses.SUCCESSFULLY_ADDED_ENVIRONMENT)) {
                throw new APIMCTLException(response);
            }
        }

        // Login to the default environment.
        String[] loginCommand = { apiControllerPath, APIMCTLConstants.Commands.LOGIN,
                APIMCTLConstants.Environment.DEFAULT_ENV_NAME, APIMCTLConstants.Params.USERNAME, username,
                APIMCTLConstants.Params.PASSWORD, password, APIMCTLConstants.Params.MINUS_K };
        process = Runtime.getRuntime().exec(loginCommand);
        List<String> response = getCTLResponseLinesSeperated(process);
        if (!containsMessage(response, APIMCTLConstants.CTLResponses.LOGGED_IN)) {
            throw new APIMCTLException(getErrorMessage(response));
        }
    }

    /**
     * Get all the APIs from the APIM controller.
     * 
     * @return list of APIs
     * @throws IOException
     */
    public List<CTLAPI> getAPIs() throws IOException {
        String apiControllerPath = getAPIControllerPath();
        String[] listAPIsCommand = { apiControllerPath, APIMCTLConstants.Commands.LIST, APIMCTLConstants.Commands.APIS,
                APIMCTLConstants.Params.ENVIRONMENT, APIMCTLConstants.Environment.DEFAULT_ENV_NAME,
                APIMCTLConstants.Params.FORMAT, APIMCTLConstants.Params.JSON_FORMAT };
        Process process = Runtime.getRuntime().exec(listAPIsCommand);
        List<String> responses = getCTLResponseLinesSeperated(process);
        return JsonUtils.getCTLAPIListFromJson(responses);
    }

    /**
     * Push given API to through APIM Controller.
     * 
     * @param definitionFile api definition
     * @throws IOException exception reading response
     */
    public void pushAPI(String definitionFile) throws IOException {
        List<CTLAPI> apis = getAPIs();
        // Implementation
    }

    /**
     * Method of getting apictl path based on the OS type.
     * 
     * @return apictl path
     */
    private String getAPIControllerPath() {
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String microInteratorPath;
        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            // check if EI Tooling is in Application folder for MAC
            File macOSEIToolingAppFile = new File(APIMCTLConstants.TOOLING_PATH_MAC);
            if (macOSEIToolingAppFile.exists()) {
                microInteratorPath = APIMCTLConstants.TOOLING_PATH_MAC + File.separator 
                        + APIMCTLConstants.APICTL_FOLDER + File.separator + APIMCTLConstants.APICTL;
            } else {
                java.nio.file.Path path = Paths.get(APIMCTLConstants.EMPTY_STRING);
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator
                        + APIMCTLConstants.APICTL_FOLDER + File.separator + APIMCTLConstants.APICTL;
            }
        } else {
            java.nio.file.Path path = Paths.get(APIMCTLConstants.EMPTY_STRING);
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator 
                    + APIMCTLConstants.APICTL_FOLDER + File.separator + APIMCTLConstants.APICTL_EXE;
        }
        return microInteratorPath;
    }

    /**
     * Read response from the CTL.
     * 
     * @param process process of execution
     * @return response
     * @throws IOException errors while reading response
     */
    private String getCTLResponse(Process process) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = APIMCTLConstants.EMPTY_STRING;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    /**
     * Read response from the CTL and give lines separately.
     * 
     * @param process process of execution
     * @return response lines
     * @throws IOException errors while reading response
     */
    private List<String> getCTLResponseLinesSeperated(Process process) throws IOException {
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = APIMCTLConstants.EMPTY_STRING;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.startsWith(APIMCTLConstants.QUOTES)) {
                line = line.substring(1);
            }
            if (line.endsWith(APIMCTLConstants.QUOTES)) {
                line = line.substring(0, line.length() - 1);
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Check whether given message is in the response.
     * 
     * @param response response lines
     * @param message message to check
     * @return availability
     */
    private boolean containsMessage(List<String> response, String message) {
        for (String line : response) {
            if (line.contains(message)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Extract error message from response.
     * 
     * @param response response lines
     * @return error message
     */
    private String getErrorMessage(List<String> response) {
        StringBuilder builder = new StringBuilder();
        for (String line : response) {
            if (!line.contains(APIMCTLConstants.CTLResponses.WARNING)) {
                builder.append(line);
            }
        }
        if (builder.length() == 0) {
            for (String line : response) {
                builder.append(line);
            }
        }
        return builder.toString();
    }

}
