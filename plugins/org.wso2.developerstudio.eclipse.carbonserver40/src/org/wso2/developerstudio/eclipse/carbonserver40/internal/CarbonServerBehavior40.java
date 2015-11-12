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

package org.wso2.developerstudio.eclipse.carbonserver40.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

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
import org.eclipse.wst.server.core.ServerPort;
import org.eclipse.wst.server.core.internal.DeletedModule;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.carbon.server.model.util.CarbonServerCommonConstants;
import org.wso2.developerstudio.eclipse.carbon.server.model.util.CarbonServerCommonUtils;
import org.wso2.developerstudio.eclipse.carbonserver.base.impl.CarbonServerBehaviour;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver.base.service.util.CarbonUploadServiceRequestUtil;
import org.wso2.developerstudio.eclipse.carbonserver40.Activator;
import org.wso2.developerstudio.eclipse.carbonserver40.operations.CommonOperations;
import org.wso2.developerstudio.eclipse.carbonserver40.util.CarbonServer40Utils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.server.base.core.ServerController;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CarbonServerBehavior40 extends CarbonServerBehaviour {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private CommonOperations commonOperations = new CommonOperations();
	private CarbonServer40Utils carbonServer40Utils= new CarbonServer40Utils();

	private void checkClosed(IModule[] module) throws CoreException {
		for (int i = 0; i < module.length; i++) {
			if (module[i] instanceof DeletedModule) {
				IStatus status =
				                 new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID, 0,
				                            NLS.bind(GenericServerCoreMessages.canNotPublishDeletedModule,
				                                     module[i].getName()), null);
				throw new CoreException(status);
			}
		}
	}

	public void publishModule(int kind, int deltaKind, IModule[] module, IProgressMonitor monitor) throws CoreException {
		IModule m = module[module.length - 1];
		if (deltaKind == ADDED) {
			checkClosed(module);
			ServerController.getInstance().getServerManager()
			                .publishServiceModule(getServer().getId(), "", m.getName());
		} else if (deltaKind == REMOVED) {
			ServerController.getInstance().getServerManager()
			                .unpublishServiceModule(getServer().getId(), "", m.getName());
		} else {
			checkClosed(module);
			// To add any new services
			ServerController.getInstance().getServerManager()
			                .hotUpdateServiceModule(getServer().getId(), "", m.getName());
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
		doBrowserPopup();
	}

	protected void doServerStoppedTasks() {
	}

	private void doBrowserPopup() {
		Boolean popupBrowser = CarbonServerCommonUtils.isServerStartBrowserPopup(getServer());
		if (popupBrowser != null && popupBrowser) {
			CarbonUploadServiceRequestUtil uoloadServiceRequestUtil = CarbonUploadServiceRequestUtil.getInstance();
			uoloadServiceRequestUtil.popupExternalBrowser(commonOperations .getLocalServerPort(getServer()) +
			                                              carbonServer40Utils.getWebContextRoot(getServer()) +
			                                              "/carbon");
		}

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
			List<String> urls = new ArrayList<String>();
			ServerPort[] ports = getServerPorts(getServer());
			ServerPort sp = null;
			int port = 0;
			int offSet = 0;

			for (int i = 0; i < ports.length; i++) {
				int j = CarbonServerCommonConstants.getPortcaptions(Activator.PLUGIN_ID).indexOf(ports[i].getName());
				if (j != -1 && CarbonServerCommonConstants.getPortids(Activator.PLUGIN_ID).get(j).equals("carbon.http")) {
					sp = ports[i];
					port = sp.getPort();
				} else if (j != -1 && CarbonServerCommonConstants.getPortids(Activator.PLUGIN_ID).get(j).equals("carbon.offset")) {
					sp = ports[i];
					offSet = sp.getPort();
				}
			}

			String newUrl = url;
			if (port != 80) {
				newUrl = newUrl + ":" + (port + offSet); //$NON-NLS-1$
			}
			newUrl = newUrl + carbonServer40Utils.getWebContextRoot(getServer()) + "/carbon";
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
		return carbonServer40Utils.getServerXmlPathFromLocalWorkspaceRepo(serverHome.toOSString());
	}

	protected String getCatelinaXmlFilePath() {
		IPath serverHome = CarbonServerManager.getServerHome(getServer());
		return carbonServer40Utils.getCatelinaXmlPathFromLocalWorkspaceRepo(serverHome.toOSString());
	}

	protected String getTransportXmlFilePath() {
		IPath serverHome = CarbonServerManager.getServerHome(getServer());
		String transportsXmlPath =
				carbonServer40Utils.getTransportsXmlPathFromLocalWorkspaceRepo(serverHome.toOSString());
		return transportsXmlPath;
	}

	protected String getAxis2FilePath() {
		return CarbonServerCommonUtils.getAxis2FilePath(getServer());
	}

	protected Integer[] getAllPortsServerWillUse(IServer server) {
		List<Integer> ports = new ArrayList<Integer>();

		String axis2FilePath = getAxis2FilePath();
		String carbonXmlPath = getCarbonXmlFilePath();
		String catelinaXmlFilePath = getCatelinaXmlFilePath();

		addServletTransportPorts(ports, carbonXmlPath, catelinaXmlFilePath);
		addAxis2XmlPorts(ports, axis2FilePath);

		return ports.toArray(new Integer[] {});
	}

	protected void addServletTransportPorts(List<Integer> ports, String carbonXmlPath, String catelinaXmlPath) {
		int port = 0;
		XPathFactory factory = XPathFactory.newInstance();
		NamespaceContext cntx = carbonServer40Utils.getCarbonNamespace();
		File xmlDocument = new File(carbonXmlPath);
		File catelineXmlDocument = new File(catelinaXmlPath);
		try {
			InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));
			InputSource catelineSource = new InputSource(new FileInputStream(catelineXmlDocument));
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			DocumentBuilder catelineBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(xmlDocument);
			Document catelinaDocument = catelineBuilder.parse(catelineXmlDocument);
			XPath xPath = factory.newXPath();
			XPath catelineXPath = factory.newXPath();
			xPath.setNamespaceContext(cntx);

			int offSet =
			             Integer.parseInt((String) xPath.evaluate("/Server/Ports/Offset", document,
			                                                      XPathConstants.STRING));
			String evaluate =
			                  (String) catelineXPath.evaluate("/Server/Service/Connector[@sslProtocol=\"TLS\"]/@port",
			                                                  catelinaDocument, XPathConstants.STRING);

			if (!evaluate.equals("")) {
				port = Integer.parseInt(evaluate) + offSet;
			} else {
				port = getPortfromTransportXML("https");
			}
			ports.add(port);
			inputSource = new InputSource(new FileInputStream(xmlDocument));
			evaluate =
			           (String) catelineXPath.evaluate("/Server/Service/Connector[1]/@port", catelinaDocument,
			                                           XPathConstants.STRING);

			if (!evaluate.equals("")) {
				port = Integer.parseInt(evaluate) + offSet;
			} else {
				port = getPortfromTransportXML("http");
			}
			ports.add(port);

		} catch (NumberFormatException e) {
			log.error(e);
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (XPathExpressionException e) {
			log.error(e);
		} catch (ParserConfigurationException e) {
			log.error(e);
		} catch (SAXException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}

	private int getPortfromTransportXML(String protocolType) {
		int port = 0;
		String transportsXmlPath = getTransportXmlFilePath();
		XPathFactory factory = XPathFactory.newInstance();
		File xmlDocument = new File(transportsXmlPath);
		try {
			InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));
			XPath xPath = factory.newXPath();
			XPathExpression xPathExpression =
			                                  xPath.compile("/transports/transport[@name='" + protocolType +
			                                                "']/parameter[@name='port']");
			String evaluate = xPathExpression.evaluate(inputSource);
			port = Integer.parseInt(evaluate);
		} catch (NumberFormatException e) {
			log.error(e);
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (XPathExpressionException e) {
			log.error(e);
		}
		return port;

	}
}
