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

package org.wso2.developerstudio.eclipse.esb.project.servlets.utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.google.gson.Gson;

public class DeployedServicesServletUtil {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    /**
     * Write given error message to the response.
     * 
     * @param errorMessage message to set
     * @param response servlet response
     * @throws IOException 
     */
    public static void setErrorMessage(String errorMessage, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        setMessage("error", errorMessage, response);
        log.error(errorMessage);
    }
    
    
    /**
     * Write a given message to the response.
     * 
     * @param messageKey key of the message
     * @param messageValue message to set
     * @param response servlet response
     * @throws IOException
     */
    public static void setMessage(String messageKey, String messageValue, HttpServletResponse response)
            throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put(messageKey, messageValue);
        response.setContentType("application/json");
        response.getWriter().println(new Gson().toJson(data, Map.class));
    }
}
