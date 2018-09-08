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

package org.wso2.developerstudio.eclipse.templates.dashboard.handlers;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.ui.IStartup;
import org.wso2.developerstudio.eclipse.carbonserver.base.util.ServerExtensionsRegistryUtils;
import org.wso2.developerstudio.eclipse.carbonserver40.register.product.servers.DynamicServer40ExtensionGenerator;
import org.wso2.developerstudio.eclipse.carbonserver42.register.product.servers.DynamicServer42ExtensionGenerator;
import org.wso2.developerstudio.eclipse.carbonserver44.register.product.servers.DynamicServer44ExtensionGenerator;
import org.wso2.developerstudio.eclipse.carbonserver44ei.register.product.servers.DynamicServer44eiExtensionGenerator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.templates.dashboard.Activator;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.FunctionServerConstants;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.GetWizardsFunctionServlet;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.JSEmbeddedFunctions;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.OpenIDEFunctionServlet;

/**
 * This is the early startup handler of the developer studio platform, all
 * methods that needs to run at eclipse startup should be implemented here and
 * called in early startup.
 *
 */
public class PlatformEarlyStartUpHandler implements IStartup {
    
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * This method queries all servers registered for developer studio and
     * register them to be available on eclipse default server option.
     */
    private void registerProductServers() {
        ServerExtensionsRegistryUtils serverExtensionsRegistryUtils = new ServerExtensionsRegistryUtils();
        IConfigurationElement[] registeredServers = serverExtensionsRegistryUtils.retrieveRegisteredProductServers();

        DynamicServer44eiExtensionGenerator dynamicEIServerExtensionGenerator = new DynamicServer44eiExtensionGenerator();
        dynamicEIServerExtensionGenerator.readProductServerExtensions(registeredServers, serverExtensionsRegistryUtils);

        DynamicServer44ExtensionGenerator dynamicServerExtensionGenerator = new DynamicServer44ExtensionGenerator();
        dynamicServerExtensionGenerator.readProductServerExtensions(registeredServers, serverExtensionsRegistryUtils);
        DynamicServer42ExtensionGenerator dynamicServer42ExtensionGenerator = new DynamicServer42ExtensionGenerator();
        dynamicServer42ExtensionGenerator.readProductServerExtensions(registeredServers, serverExtensionsRegistryUtils);
        DynamicServer40ExtensionGenerator dynamicServer40ExtensionGenerator = new DynamicServer40ExtensionGenerator();
        dynamicServer40ExtensionGenerator.readProductServerExtensions(registeredServers, serverExtensionsRegistryUtils);
    }

    /**
     * This method starts embedded jetty server at eclipse startup. This embedded jetty server is used to fulfill the 
     * dashboard page requests.
     * @param port port which the jetty server is started
     */
    private void startEmbeddedJetty(int port) {
        Server server = new Server(port);
        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);
        //Bind the servlet classes which serves the js functions to server context paths. So these functionalities can be
        //triggered with ajax calls from js
        servletHandler.addServletWithMapping(OpenIDEFunctionServlet.class, "/openide");
        servletHandler.addServletWithMapping(GetWizardsFunctionServlet.class, "/getwizards");
        servletHandler.addServletWithMapping(OpenIDEFunctionServlet.class, "/getwizarddetails");
        
        JSEmbeddedFunctions jsf = new JSEmbeddedFunctions();
        jsf.setPortGlobalVariable(port);
        try {
            server.start();
            server.join();
        } catch (java.net.BindException e) {
            //The given port is already in use so retrying with next port
            log.info("Address already in use, trying on next available port");
            try {
                server.stop();
                port++; //increment port value
                //jsf.writePortValue(port);
                startEmbeddedJetty(port);
            } catch (Exception e1) {
                log.error("Error in server port failover", e1);
            }

        } catch (Exception e2) {
            log.error("Error starting dashboard server ", e2);
        }
    }

    @Override
    public void earlyStartup() {
        //This method fires before startup and we use this to register carbon servers and start embedded jetty
        registerProductServers();
        startEmbeddedJetty(FunctionServerConstants.EMBEDDED_SERVER_PORT);
    }

}
