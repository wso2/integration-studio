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

package org.wso2.developerstudio.eclipse.carbonserver44microei12.internal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jst.server.generic.core.internal.CorePlugin;
import org.eclipse.jst.server.generic.core.internal.GenericServerCoreMessages;
import org.eclipse.jst.server.generic.core.internal.GenericServerRuntime;
import org.eclipse.jst.server.generic.core.internal.Trace;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.internal.DeletedModule;
import org.wso2.developerstudio.eclipse.carbon.server.model.util.CarbonServerCommonUtils;
import org.wso2.developerstudio.eclipse.carbonserver.base.impl.CarbonServerBehaviour;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.util.CarbonServer44eiUtils;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.util.ServerConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.server.base.core.ServerController;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import net.consensys.cava.toml.TomlParseResult;

public class CarbonServerBehavior44microei12 extends CarbonServerBehaviour {
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private CarbonServer44eiUtils carbonServer44eiUtils = new CarbonServer44eiUtils();

    private void checkClosed(IModule[] module) throws CoreException {
        for (int i = 0; i < module.length; i++) {
            if (module[i] instanceof DeletedModule) {
                IStatus status = new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID, 0,
                        NLS.bind(GenericServerCoreMessages.canNotPublishDeletedModule, module[i].getName()), null);
                throw new CoreException(status);
            }
        }
    }

    public void publishModule(int kind, int deltaKind, IModule[] module, IProgressMonitor monitor)
            throws CoreException {
        IModule m = module[module.length - 1];
        if (deltaKind == ADDED) {
            checkClosed(module);
            ServerController.getInstance().getServerManager().publishServiceModule(getServer().getId(), "",
                    m.getName());
        } else if (deltaKind == REMOVED) {
            ServerController.getInstance().getServerManager().unpublishServiceModule(getServer().getId(), "",
                    m.getName());
        }
        setModulePublishState(module, null);
    }

    private void setModulePublishState(IModule[] module, IStatus[] status) throws CoreException {
        if (module == null)
            return;
        for (int i = 0; i < module.length; i++) {
            if (status == null || status.length < i || status[i] == null || status[i].getSeverity() == IStatus.OK) {
                setModulePublishState(module, IServer.PUBLISH_STATE_NONE);
            } else {
                if (IStatus.ERROR == status[i].getSeverity()) {
                    setModulePublishState(module, IServer.PUBLISH_STATE_UNKNOWN);
                    throw new CoreException(status[i]);
                }
            }
        }
    }

    protected void doServerStartedTasks() {
        super.doServerStartedTasks();
    }

    protected void doServerStoppedTasks() {

    }

    protected String getVmArguments() {
        String vmArguments = super.getVmArguments();
        Boolean enableOSGIConsole = CarbonServerCommonUtils.isServerStartWithOSGiConsole(getServer());
        if (enableOSGIConsole != null && enableOSGIConsole) {
            vmArguments = vmArguments + " -DosgiConsole";
        }
        return vmArguments;
    }

    protected String[] getPingURLList() {
        try {
            setServerisStillStarting(true);
            String url = "http://" + getServer().getHost();
            String carbonHome = carbonServer44eiUtils.resolveProperties(getServer(), ServerConstants.PROP_CARBON_HOME);
			CarbonServer44eiUtils carbonServer44eiUtils = new CarbonServer44eiUtils();
			String offsetString = carbonServer44eiUtils.readTomlValue(carbonServer44eiUtils.getTomlResults(carbonHome),
					ServerConstants.TOML_PORTOFFSET, "10");

            if (offsetString == null || offsetString.equals("")) {
                offsetString = "10";
            }

            List<String> urls = new ArrayList<String>();
            int port = 9191; // default Prometheus API port
            int offSet = Integer.valueOf(offsetString);

            String newUrl = url;
            newUrl = newUrl + ":" + (port + offSet);

            // Prometheus API is used as the ping server
            newUrl = newUrl + "/metric-service/metrics";
            urls.add(newUrl);

            return urls.toArray(new String[] {});

        } catch (Exception e) {
            Trace.trace(Trace.SEVERE, "Can't ping for server startup.");
        }
        return null;
    }

    protected List getStartClasspath() {
        List startClasspath = super.getStartClasspath();
        GenericServerRuntime runtime = getRuntimeDelegate();

        IVMInstall vmInstall = runtime.getVMInstall();
        File jdkLib = new File(vmInstall.getInstallLocation(), "lib");

        if (jdkLib.exists() && jdkLib.isDirectory()) {
            for (String cpath : jdkLib.list()) {
                Path newCPath = new Path(new File(jdkLib, cpath).toString());
                String fileExtension = newCPath.getFileExtension();
                if (fileExtension != null && fileExtension.equalsIgnoreCase("jar"))
                    startClasspath.add(JavaRuntime.newArchiveRuntimeClasspathEntry(newCPath));
            }
        }
        return startClasspath;
    }

    protected String getCarbonXmlFilePath() {
        IPath serverHome = CarbonServerManager.getServerHome(getServer());
        return carbonServer44eiUtils.getServerXmlPathFromLocalWorkspaceRepo(serverHome.toOSString());
    }

    protected String getCatelinaXmlFilePath() {
        IPath serverHome = CarbonServerManager.getServerHome(getServer());
        return carbonServer44eiUtils.getCatelinaXmlPathFromLocalWorkspaceRepo(serverHome.toOSString());
    }

    protected String getTransportXmlFilePath() {
        IPath serverHome = CarbonServerManager.getServerHome(getServer());
        String transportsXmlPath = carbonServer44eiUtils
                .getTransportsXmlPathFromLocalWorkspaceRepo(serverHome.toOSString());
        return transportsXmlPath;
    }

    protected String getAxis2FilePath() {
        String axis2Xml = FileUtils.addNodesToPath(CarbonServerManager.getServerConfDir(getServer()).toOSString(),
                new String[] { "axis2", "axis2.xml" });
        return axis2Xml;
    }

    protected Integer[] getAllPortsServerWillUse(IServer server) {
        List<Integer> ports = new ArrayList<>();

        String carbonHome = CarbonServerManager.getServerLocalWorkspacePath(server);
        addAxis2XmlPorts(ports, carbonHome);

        return ports.toArray(new Integer[] {});
    }

    protected void addAxis2XmlPorts(List<Integer> ports, String carbonHome) {

        try {
            TomlParseResult tomlResults = carbonServer44eiUtils.getTomlResults(carbonHome);

            String passthroughHttpPort = carbonServer44eiUtils.readTomlValue(tomlResults,
                    ServerConstants.TOML_HTTP_LISTENER, "8280");

            String passthroughHttpsPort = carbonServer44eiUtils.readTomlValue(tomlResults,
                    ServerConstants.TOML_HTTPS_LISTENER, "8243");

            ports.add(Integer.parseInt(passthroughHttpPort));
            ports.add(Integer.parseInt(passthroughHttpsPort));
        } catch (IOException e) {
            log.error("Error while parsing the tomal file.", e);
        }
    }

    protected void addServletTransportPorts(List<Integer> ports, String carbonXmlPath) {

    }
}
