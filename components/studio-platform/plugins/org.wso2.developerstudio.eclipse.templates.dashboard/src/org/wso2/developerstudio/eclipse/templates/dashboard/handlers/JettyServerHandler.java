/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.developerstudio.eclipse.templates.dashboard.handlers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.templates.dashboard.Activator;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.FunctionServerConstants;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.GetWelcomeDisplayConfigServlet;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.GetWizardsFunctionServlet;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.JSEmbeddedFunctions;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.OpenBrowserServlet;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.OpenIDEFunctionServlet;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.UpdateWelcomeDisplayConfigServlet;

public class JettyServerHandler {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static JettyServerHandler jettyServerHandler;
    public static boolean serverStarted;
    private static HandlerCollection contexts;

    public HandlerCollection getHandlerCollection() {
        return contexts;
    }

    private JettyServerHandler() {
        super();
    }

    public static JettyServerHandler getInstance() {
        if (jettyServerHandler == null) {
            org.eclipse.jetty.util.log.Log.setLog(new NoLogging());

            jettyServerHandler = new JettyServerHandler();
            // Once the server started handler collection becomes immutable.
            // We are using "true" here to keep it mutable
            contexts = new HandlerCollection(true);
        }
        
        return jettyServerHandler;
    }

    /**
     * This method starts embedded jetty server at eclipse startup. This embedded jetty server is used to fulfill the
     * dashboard page requests.
     *
     * @param port port which the jetty server is started
     */
    public void startEmbeddedJetty(int port) {

        if (port == 0) {
            port = FunctionServerConstants.EMBEDDED_SERVER_PORT;
        }

        Server server = new Server(port);
        configServer(server);
        JSEmbeddedFunctions jsf = new JSEmbeddedFunctions();
        jsf.setPortGlobalVariable(port);
        try {
            server.start();
            // server.join();
            serverStarted = true;
        } catch (java.net.BindException e) {
            // The given port is already in use so retrying with next port
            log.info("Address already in use, trying on next available port");
            try {
                server.stop();
                port++; // increment port value
                // jsf.writePortValue(port);
                startEmbeddedJetty(port);
            } catch (Exception e1) {
                log.error("Error in server port failover", e1);
            }

        } catch (Exception e2) {
            log.error("Error starting dashboard server ", e2);
        }
    }

    private void configServer(Server server) {
        // uncomment to use servletHandler instead of ServletContext handler
        // ServletHandler servletHandler = new ServletHandler();
        // triggered with ajax calls from js
        // servletHandler.addServletWithMapping(OpenIDEFunctionServlet.class, "/openide");
        // servletHandler.addServletWithMapping(GetWizardsFunctionServlet.class, "/getwizards");
        // servletHandler.addServletWithMapping(OpenIDEFunctionServlet.class, "/getwizarddetails");

        // Add Cors support for the server
        FilterHolder holder = new FilterHolder(CORSFilter.class);
        holder.setInitParameter("Access-Control-Allow-Origin", "*");
        holder.setInitParameter("Access-Control-Allow-Methods", "GET,POST,HEAD");
        holder.setInitParameter("Access-Control-Allow-Headers", "X-Requested-With,Content-Type,Accept,Origin");
        holder.setName("cross-origin");

        JSEmbeddedFunctions jsf = new JSEmbeddedFunctions();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //context.addFilter(holder, "*", null);
        // Context path where static webpages are hosted
        context.setContextPath("/welcome");
        String webAppPath = "WelcomeDashboard";
        try {
            // Get web app path from current bundle
            webAppPath = jsf.getWebAppPath();
        } catch (URISyntaxException uriException) {
            log.error("Error resolving web app path", uriException);
        } catch (IOException ioException) {
            log.error("Error resolving web app path", ioException);
        }
        context.setResourceBase(webAppPath);

        // Context path where servlets are hosted
        ServletContextHandler wsContext = new ServletContextHandler();
        wsContext.setContextPath("/servlet");
        
        contexts.addHandler(wsContext);
        contexts.addHandler(context);

        server.setHandler(contexts);
        // All the static web page requests are handled through DefaultServlet
        context.addServlet(DefaultServlet.class, "/");

        // Bind the servlet classes which serves the js functions to server context paths. So these functionalities can
        // be
        wsContext.addServlet(OpenIDEFunctionServlet.class, "/openide");
        wsContext.addServlet(GetWizardsFunctionServlet.class, "/getwizards");
        wsContext.addServlet(UpdateWelcomeDisplayConfigServlet.class, "/savewelcomeconfig");
        wsContext.addServlet(GetWelcomeDisplayConfigServlet.class, "/getwelcomeconfig");
        wsContext.addServlet(OpenBrowserServlet.class, "/openbrowser");
    }
}