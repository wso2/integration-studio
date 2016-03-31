/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver.base.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IRuntimeClasspathEntry;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jst.server.generic.core.internal.GenericServer;
import org.eclipse.jst.server.generic.core.internal.GenericServerBehaviour;
import org.eclipse.jst.server.generic.core.internal.GenericServerRuntime;
import org.eclipse.jst.server.generic.core.internal.Trace;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerPort;
import org.eclipse.wst.server.core.util.SocketUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.wso2.developerstudio.eclipse.carbonfeatures.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerBehavior;
import org.wso2.developerstudio.eclipse.carbonserver.base.monitor.CarbonPingThread;
import org.wso2.developerstudio.eclipse.carbonserver.base.utils.CarbonServerScriptParser;
import org.wso2.developerstudio.eclipse.carbonserver.base.utils.CarbonServerUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.xml.sax.InputSource;

public abstract class CarbonServerBehaviour extends GenericServerBehaviour implements ICarbonServerBehavior {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	String originalWSASServerRepo = null;
	private boolean serverisStillStarting = false;

	public void stop(boolean force) {
		doServerStoppedTasks();
		if (force) {
			terminate();
			return;
		}
		int state = getServer().getServerState();
		if (state == IServer.STATE_STOPPED)
			return;
		else {
			terminate();
			return;
		}
	}

	protected List serverClasspath(String cpRef) {
		List classpathEntries = super.serverClasspath(cpRef);
		ArrayList newClasspathEntries = new ArrayList();
		for (Object o : classpathEntries) {
			IRuntimeClasspathEntry runtimeClassPathEntry = (IRuntimeClasspathEntry) o;
			String path = runtimeClassPathEntry.getPath().toOSString();
			File classPath = new File(path);
			newClasspathEntries.add(runtimeClassPathEntry);
			if (classPath.isDirectory()) {
				for (String cpath : classPath.list()) {
					Path newCPath = new Path(FileUtils.addAnotherNodeToPath(path, cpath));
					String fileExtension = newCPath.getFileExtension();
					if (fileExtension != null && fileExtension.equalsIgnoreCase("jar"))
						newClasspathEntries.add(JavaRuntime.newArchiveRuntimeClasspathEntry(newCPath));
				}
			}
		}
		return newClasspathEntries;
	}

	public static ServerPort[] getServerPorts(IServer server) {
		GenericServer gserver = (GenericServer) server.getAdapter(GenericServer.class);
		return gserver.getServerPorts();
	}

	protected abstract String[] getPingURLList();

	protected void startPingThread() {
		try {
			setServerisStillStarting(true);
			String url = "http://" + getServer().getHost();
			String[] urls = getPingURLList();;
			if (urls == null || urls.length == 0) {
				Trace.trace(Trace.SEVERE, "Can't ping for server startup.");
				return;
			}
			ping = new CarbonPingThread(getServer(), urls, this);
		} catch (Exception e) {
			Trace.trace(Trace.SEVERE, "Can't ping for server startup.");
		}
	}

	public void setServerStarted() {
		if (isServerisStillStarting()) {
			setServerisStillStarting(false);
			doServerStartedTasks();
			super.setServerStarted();
		}
	}

	private boolean isRemote() {
		return (getServer().getServerType().supportsRemoteHosts() && !SocketUtil.isLocalhost(getServer().getHost()));
	}

	protected List getStartClasspath() {
		String cpRef = getServerDefinition().getStart().getClasspathReference();
		return serverClasspath(cpRef);
	}

	private String getWorkingDirectory() {
		return getServerDefinition().getResolver().resolveProperties(getServerDefinition().getStart()
		                                                                                  .getWorkingDirectory());
	}

	/**
	 * Setup for starting the server. Checks all ports available
	 * and sets server state and mode.
	 * 
	 * @param launch
	 *            ILaunch
	 * @param launchMode
	 *            String
	 * @param monitor
	 *            IProgressMonitor
	 */
	protected void setupLaunch(ILaunch launch, String launchMode, IProgressMonitor monitor) throws CoreException {
		if ("true".equals(launch.getLaunchConfiguration().getAttribute(ATTR_STOP, "false"))) //$NON-NLS-1$ //$NON-NLS-2$
			return;
		checkPorts();
		setServerState(IServer.STATE_STARTING);
		setMode(launchMode);
	}

	protected void checkPorts() throws CoreException {
		String host = getServer().getHost();
		Integer[] ports = getAllPortsServerWillUse(getServer());
		if (SocketUtil.isLocalhost(host)) {
			for (int port : ports) {
				if (SocketUtil.isPortInUse(port, 5)) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0,
					                                   "Server port is in use: " + port, null));
				}
			}
		}
	}

	public void setupLaunchConfiguration(ILaunchConfigurationWorkingCopy workingCopy, IProgressMonitor monitor)
	                                                                                                           throws CoreException {
		if (isRemote())// No launch for remote servers.
			return;
		workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, getStartClassName());

		GenericServerRuntime runtime = getRuntimeDelegate();

		IVMInstall vmInstall = runtime.getVMInstall();
		workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_VM_INSTALL_TYPE, runtime.getVMInstallTypeId());
		workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_VM_INSTALL_NAME, vmInstall.getName());

		setupLaunchClasspath(workingCopy, vmInstall, getStartClasspath());

		workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_WORKING_DIRECTORY, getWorkingDirectory());

		Map environVars = getEnvironmentVariables(getServerDefinition().getStart());
		environVars.put("JAVA_HOME", "/home/saminda/software/jdk1.6.0_20");
		if (!environVars.isEmpty()) {
			workingCopy.setAttribute(ILaunchManager.ATTR_ENVIRONMENT_VARIABLES, environVars);
		}

		String existingProgArgs =
		                          workingCopy.getAttribute(IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS,
		                                                   (String) null);
		String serverProgArgs = getProgramArguments();
		if (existingProgArgs == null) {
			workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, serverProgArgs);
		}
		String previousVMArgument = workingCopy.getAttribute("earlier_vmarguments", (String) null);
		String serverVMArgs = getVmArguments();
		String existingVMArgs = null;
		if (serverVMArgs.equals(previousVMArgument)) {
			existingVMArgs =
			                 workingCopy.getAttribute(IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS,
			                                          (String) null);
		} else {
			workingCopy.setAttribute("earlier_vmarguments", serverVMArgs);
		}
		if (existingVMArgs == null) {
			workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS, serverVMArgs);
		}
	}

	protected String getVmArguments() {
		String defaultVMParameters =
		                             getServerDefinition().getResolver()
		                                                  .resolveProperties(getServerDefinition().getStart()
		                                                                                          .getVmParametersAsString());
		String serverLocalWorkspacePath = CarbonServerUtils.getCarbonServerHome(getServer()).toOSString();
		CarbonServerScriptParser parser = new CarbonServerScriptParser(serverLocalWorkspacePath);
		Map<String, String> serverVMParamaters = parser.getVMParamaters();
		String[] array = defaultVMParameters.split(" ");

		for (int i = 0; i < array.length; i++) {
			if (array[i].contains(CarbonServerScriptParser.MIN_MEMORY_STRING)) {
				array[i] =
				           CarbonServerScriptParser.MIN_MEMORY_STRING +
				                   serverVMParamaters.get(CarbonServerScriptParser.MIN_MEMORY_STRING);
			} else if (array[i].contains(CarbonServerScriptParser.MAX_MEMORY_STRING)) {
				array[i] =
				           CarbonServerScriptParser.MAX_MEMORY_STRING +
				                   serverVMParamaters.get(CarbonServerScriptParser.MAX_MEMORY_STRING);
			} else if (array[i].contains(CarbonServerScriptParser.MAX_PERM_SIZE_STRING)) {
				array[i] =
				           CarbonServerScriptParser.MAX_PERM_SIZE_STRING + "=" +
				                   serverVMParamaters.get(CarbonServerScriptParser.MAX_PERM_SIZE_STRING);
			}
		}

		StringBuffer buffer = new StringBuffer();
		for (String string : array) {
			buffer.append(string).append(" ");
		}
		return buffer.toString();
	}

	public void publishModule(int kind, int deltaKind, IModule[] module, IProgressMonitor monitor) throws CoreException {
	}

	protected void doServerStartedTasks() {
	}

	private void doServerStoppedTasks() {
	}

	public void setServerisStillStarting(boolean serverisStillStarting) {
		this.serverisStillStarting = serverisStillStarting;
	}

	public boolean isServerisStillStarting() {
		return serverisStillStarting;
	}

	protected Integer[] getAllPortsServerWillUse(IServer server) {
		List<Integer> ports = new ArrayList<Integer>();

		String axis2FilePath = getAxis2FilePath();
		String transportsXmlPath = getTransportXmlFilePath();
		String carbonXmlPath = getCarbonXmlFilePath();

		addServletTransportPorts(ports, transportsXmlPath);
		addAxis2XmlPorts(ports, axis2FilePath);

		return ports.toArray(new Integer[] {});
	}

	protected abstract String getCarbonXmlFilePath();

	/**
	 * Added to support C4 but will keep the Backward compatibility
	 * 
	 * @return
	 */
	protected String getCatelinaXmlFilePath() {
		return null;
	}

	protected abstract String getTransportXmlFilePath();

	protected abstract String getAxis2FilePath();

	protected void addAxis2XmlPorts(List<Integer> ports, String axis2FilePath) {
		XPathFactory factory = XPathFactory.newInstance();
		try {
			File xmlDocument = new File(axis2FilePath);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(xmlDocument);
			XPath xPath = factory.newXPath();
			Node httpNode =
			                (Node) xPath.evaluate("/axisconfig/transportReceiver[@class='org.apache.synapse.transport.nhttp.HttpCoreNIOListener']/parameter[@name='port']",
			                                      document, XPathConstants.NODE);
			Node httpsNode =
			                 (Node) xPath.evaluate("/axisconfig/transportReceiver[@class='org.apache.synapse.transport.nhttp.HttpCoreNIOSSLListener']/parameter[@name='port']",
			                                       document, XPathConstants.NODE);
			if (httpNode != null) {
				ports.add(Integer.parseInt(httpNode.getTextContent()));
			}
			if (httpsNode != null) {
				ports.add(Integer.parseInt(httpsNode.getTextContent()));
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	protected void addServletTransportPorts(List<Integer> ports, String transportsXmlPath) {
		XPathFactory factory = XPathFactory.newInstance();
		File xmlDocument = new File(transportsXmlPath);
		try {
			InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));
			XPath xPath = factory.newXPath();
			XPathExpression xPathExpression =
			                                  xPath.compile("/transports/transport[@name='http']/parameter[@name='port']");
			String evaluate = xPathExpression.evaluate(inputSource);
			int port = Integer.parseInt(evaluate);
			ports.add(Integer.parseInt(evaluate));
			inputSource = new InputSource(new FileInputStream(xmlDocument));
			xPathExpression = xPath.compile("/transports/transport[@name='https']/parameter[@name='port']");
			evaluate = xPathExpression.evaluate(inputSource);
			ports.add(Integer.parseInt(evaluate));
		} catch (NumberFormatException e) {
			log.error(e);
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (XPathExpressionException e) {
			log.error(e);
		}
	}

	protected void addServletTransportPorts(List<Integer> ports, String transportsXmlPath, String catelinaXmlPath) {
		// Empty implementation to support C4 but not to break other versions
	}

}
