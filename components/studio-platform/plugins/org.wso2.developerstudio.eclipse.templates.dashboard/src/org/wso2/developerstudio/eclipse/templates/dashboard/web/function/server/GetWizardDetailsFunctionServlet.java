/**
 * Copyright 2009-2018 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

public class GetWizardDetailsFunctionServlet extends HttpServlet {
    
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSEmbeddedFunctions jsf = new JSEmbeddedFunctions();
        String wizardid = request.getParameter("status");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        String responseString = "{}";
        try {
            responseString = jsf.getDescription(wizardid);
            response.getWriter().println(responseString);
        } catch (CoreException e) {
            log.error("Couldn't retrieve wizard description for this wizard", e);
        }
    }
}
