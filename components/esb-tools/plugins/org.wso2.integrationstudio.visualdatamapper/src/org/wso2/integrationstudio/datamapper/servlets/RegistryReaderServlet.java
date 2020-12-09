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

package org.wso2.integrationstudio.datamapper.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.integrationstudio.datamapper.servlets.Utils.DatamapperUtils;

import com.google.gson.JsonObject;

/**
 * This is the servlet used to serve requests coming from Datamapper test window.
 * 
 * @author lahiru
 *
 */
public class RegistryReaderServlet extends HttpServlet {

    private static final String OPERATION_PROCESS = "process";
    private static final String OPERATION_GET_INPUT_SCHEMA = "getInputSchema";
    private static final String DATAMAPPER_DIAGRAM_FILE_EXTENSION = "datamapper_diagram";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Save schema changes only if the output schema is available
        if (checkForSchema()) {
            saveChanges();
        }
        
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

            // Trim and remove extra whitespaces and new lines from XML
            if (inputType.equals("XML")) {
                input = input.trim().replace("\n", "").replaceAll("( *)<", "<");
            }
            
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

            // Retrieve input schema
            File inputSchemaFile = new File(DataMapperConfigHolder.getInstance().getInputSchemaPath());
            InputStream inputSchema = FileUtils.openInputStream(inputSchemaFile);

            // Create response object
            JsonObject responseObj = new JsonObject();
            responseObj.addProperty("schema", IOUtils.toString(inputSchema));

            if (null != DataMapperConfigHolder.getInstance().getInputFile()) {
                // Retrieve input file
                File inputSampleFile = new File(DataMapperConfigHolder.getInstance().getInputFile());

                // If the input file exists send the sample input
                if (inputSampleFile.exists()) {
                    InputStream inputSample = FileUtils.openInputStream(inputSampleFile);
                    responseObj.addProperty("sample", IOUtils.toString(inputSample));
                }
            }

            response.getWriter().println(responseObj.toString());
        }
        
    }

    /**
     * Checks if the schema are available
     * 
     * @return true if the input and output schema is available, else returns false
     */
    private boolean checkForSchema() {
        File inputFile = new File(DataMapperConfigHolder.getInstance().getInputSchemaPath());
        File outputFile = new File(DataMapperConfigHolder.getInstance().getOutputSchemaPath());
        return (inputFile.length() != 0 && outputFile.length() != 0);
    }

    /**
     * Saves schema changes to file in the datamapper editor
     * 
     */
    private void saveChanges() {
        Display.getDefault().syncExec(new Runnable() {
            @Override
            public void run() {
                // Retrieves all unsaved editors
                IEditorPart[] editors = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .getDirtyEditors();

                for (int i = 0; i < editors.length; i++) {
                    // Check if the editor is a datamapper editor
                    if (editors[i].getEditorInput().getName().contains(DATAMAPPER_DIAGRAM_FILE_EXTENSION)) {
                        editors[i].doSave(new NullProgressMonitor());
                        break;
                    }
                }
            }
        });
    }
        
}
