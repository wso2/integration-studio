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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.ds.editors.DSSMultiPageEditor;

/**
 * The servlet class used to serve requests from the DSS editor.
 *
 */
public class DSSEditorServlet extends HttpServlet {
    
    DSSMultiPageEditor editor = null;
    
    /**
     * This method will return the DSS configuration
     * 
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException  {
        
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().
                        getActivePage().getActiveEditor();
                editor = (DSSMultiPageEditor) editorPart;
            }
        });
        
        res.setContentType("text/plain");    
        PrintWriter out = res.getWriter();
        out.println(editor.getDsXmlContent());
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
