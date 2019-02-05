/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.wso2.developerstudio.datamapper.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.wso2.developerstudio.datamapper.servlets.Utils.DatamapperUtils;

/**
 * This is the servlet used to serve requests coming from Datamapper test window.
 * 
 * @author lahiru
 *
 */
public class RegistryReaderServlet extends HttpServlet {

    private static final String OPERATION_PROCESS = "process";
    private static final String OPERATION_GET_INPUT_SCHEMA = "getInputSchema";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String payload = IOUtils.toString(request.getInputStream());
        String[] strArray = payload.split(" ");

        String operation = strArray[0];
        // "process" operation will do the Datamaper mediation and return the results.
        if (operation.equals(OPERATION_PROCESS)) {
            response.setStatus(HttpServletResponse.SC_OK);

            File dmcFile = new File(DataMapperConfigHolder.getInstance().getDmcPath());
            InputStream DMC = FileUtils.openInputStream(dmcFile);

            File inputSchemaFile = new File(DataMapperConfigHolder.getInstance().getInputSchemaPath());
            InputStream inputSchema = FileUtils.openInputStream(inputSchemaFile);

            File outputSchemaFile = new File(DataMapperConfigHolder.getInstance().getOutputSchemaPath());
            InputStream outputSchema = FileUtils.openInputStream(outputSchemaFile);

            String inputType = strArray[1];
            String outputType = strArray[2];

            // setting content types depending on the result
            switch (outputType) {
                case "JSON": {
                    response.setContentType("application/json;charset=utf-8");
                    break;
                }
                case "XML": {
                    response.setContentType("application/xml;charset=utf-8");
                    break;
                }
                case "CSV": {
                    response.setContentType("text/xml;charset=utf-8");
                    break;
                }
            }
            String input = payload.replace("process", "").replaceFirst(inputType, "").replaceFirst(outputType, "");
            String result = "";
            try {
                result = DatamapperUtils.processDatamapper(inputType, outputType, inputSchema, outputSchema, DMC,
                        input);
            } catch (Exception e) {
                // If error occurred return the exact error message coming from Datamapper mediator.
                result = e.getMessage();
                response.setContentType("text/plain;charset=utf-8");
            }
            response.getWriter().println(result);
        } else if (operation.equals(OPERATION_GET_INPUT_SCHEMA)) {
            // "getInputSchema" operation will read and return the input_schema.json
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            File inputSchemaFile = new File(DataMapperConfigHolder.getInstance().getInputSchemaPath());
            InputStream inputSchema = FileUtils.openInputStream(inputSchemaFile);
            String result = IOUtils.toString(inputSchema);
            response.getWriter().println(result);
        }
    }
}