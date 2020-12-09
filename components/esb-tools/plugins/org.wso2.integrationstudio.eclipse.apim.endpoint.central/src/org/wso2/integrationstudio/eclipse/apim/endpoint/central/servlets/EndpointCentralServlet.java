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
package org.wso2.integrationstudio.eclipse.apim.endpoint.central.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wso2.integrationstudio.eclipse.apim.endpoint.central.handler.EndpointCentralServletRequestHandler;
import org.wso2.integrationstudio.eclipse.apim.endpoint.central.resources.EndpointCentralServletConstants;

/**
 * The servlet class used to serve requests from the endpoint central service catalog.
 */
public class EndpointCentralServlet extends HttpServlet {

    /**
     * Handles post requests.
     * 
     * @param request post request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operationTypeHeader = request
                .getHeader(EndpointCentralServletConstants.RequestHeaders.HEADER_OPERATION_TYPE);

        if (EndpointCentralServletConstants.RequestHeaders.LOGIN.equals(operationTypeHeader)) {
            EndpointCentralServletRequestHandler.login(request, response);
        } else if (EndpointCentralServletConstants.RequestHeaders.CREATE_REGISTRY_ENTRY.equals(operationTypeHeader)) {
            EndpointCentralServletRequestHandler.createRegistryEntry(request, response);
        } else if (EndpointCentralServletConstants.RequestHeaders.IMPORT_API.equals(operationTypeHeader)) {
            EndpointCentralServletRequestHandler.importAPI(request, response);
        } else if (EndpointCentralServletConstants.APIMCTLRequestHeaders.LOGIN.equals(operationTypeHeader)) {
            EndpointCentralServletRequestHandler.loginToCTL(request, response);
        } else if (EndpointCentralServletConstants.APIMCTLRequestHeaders.PUSH_API.equals(operationTypeHeader)) {
            EndpointCentralServletRequestHandler.pushAPIThroughCTL(request, response);
        }
    }

    /**
     * Handles get requests.
     * 
     * @param request get request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operationTypeHeader = request
                .getHeader(EndpointCentralServletConstants.RequestHeaders.HEADER_OPERATION_TYPE);

        if (EndpointCentralServletConstants.RequestHeaders.CHECK_LOGIN.equals(operationTypeHeader)) {
            EndpointCentralServletRequestHandler.checkLogin(request, response);
        } else if (EndpointCentralServletConstants.RequestHeaders.GET_REGISTRY_ENTRIES.equals(operationTypeHeader)) {
            EndpointCentralServletRequestHandler.getRegistryEntries(request, response);
        } else if (EndpointCentralServletConstants.RequestHeaders.GET_PROJECTS.equals(operationTypeHeader)) {
            EndpointCentralServletRequestHandler.getProjects(request, response);
        } else if (EndpointCentralServletConstants.RequestHeaders.LOGOUT.equals(operationTypeHeader)) {
            EndpointCentralServletRequestHandler.logOutUser(request, response);
        } else if (EndpointCentralServletConstants.RequestHeaders.PROFILE_DATA.equals(operationTypeHeader)) {
            EndpointCentralServletRequestHandler.getProfileData(request, response);
        }
    }
}
