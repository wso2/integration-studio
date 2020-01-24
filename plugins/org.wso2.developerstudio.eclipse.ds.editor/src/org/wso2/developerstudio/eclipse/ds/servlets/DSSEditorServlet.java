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

package org.wso2.developerstudio.eclipse.ds.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.ds.editors.DSSMultiPageEditor;
import org.wso2.developerstudio.eclipse.ds.presentation.util.DSSVisualEditorConstants;
import org.wso2.developerstudio.eclipse.ds.wizards.util.DSSEditorUtils;

/**
 * The servlet class used to serve requests from the DSS editor.
 *
 */
public class DSSEditorServlet extends HttpServlet {
    
    DSSMultiPageEditor editor = null;
    
    static final String PAYLOAD_XML_CONTENT_PARAM_NAME = "xmlcontent";
    static final String DS_ID_SEPARATOR = "\\?";
    static final String DS_METADATA_SEPARATOR = "\\,";
    
    DSSEditorUtils editorUtils = DSSEditorUtils.getInstance();
    
    /**
     * This method will return the DSS configuration
     * 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().
                        getActivePage().getActiveEditor();
                editor = (DSSMultiPageEditor) editorPart;
            }
        });
        
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println(editor.getDsXmlContent());
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String operationTypeHeader = request.getHeader(DSSVisualEditorConstants.RequestHeaders.HEADER_OPERATION_TYPE);
        final String payload = request.getParameter(PAYLOAD_XML_CONTENT_PARAM_NAME);
        
        // If operation type is save all
        if (DSSVisualEditorConstants.RequestHeaders.HEADER_VALUE_SAVE_ALL.equals(operationTypeHeader)) {
            Display.getDefault().syncExec(new Runnable() {
                public void run() {
                    IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().
                            getActivePage().getActiveEditor();
                    editor = (DSSMultiPageEditor) editorPart;
                    editor.setDsXmlContent(payload);
                    editor.getTextEditor().getDocumentProvider().getDocument(editor.getEditorInput()).set(payload);
                }
            });
            
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (DSSVisualEditorConstants.RequestHeaders.HEADER_VALUE_SAVE_DS_METADATA.equals(operationTypeHeader)) {
            // If the operation type is save DS metadata. This is to persist additional data of data sources such as
            // RDBMS type, database engine etc.
            // The format of the string will be: <datasource_ID>?<data_key>:<data_value>,<data_key>:<data_value>...
            String[] dsMetadataArr = payload.split(DS_ID_SEPARATOR);
            editorUtils.saveProperty(dsMetadataArr[0], dsMetadataArr[1], null);
            
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter writer = response.getWriter();
            writer.close();
        } else if (DSSVisualEditorConstants.RequestHeaders.HEADER_VALUE_RETRIEVE_DS_METADATA.equals(operationTypeHeader)) {
            // If the operation type is get DS metadata.
            String metadata = editorUtils.getDSDetails(payload);
            response.setContentType("text/plain");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter writer = response.getWriter();
            writer.println(metadata);
            writer.close();
        }
        
    }

}
