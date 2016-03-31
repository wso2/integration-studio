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

package org.wso2.developerstudio.eclipse.carbonserver.remote.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jst.server.generic.core.internal.GenericServer;
import org.eclipse.jst.server.generic.servertype.definition.ServerRuntime;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerPort;
import org.eclipse.wst.server.core.model.ServerDelegate;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.wso2.developerstudio.eclipse.carbon.server.model.util.CarbonServerCommonConstants;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver.base.utils.CarbonServerUtils;
import org.wso2.developerstudio.eclipse.carbonserver.remote.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.remote.internal.RemoteCarbonRuntimeDeligate;
import org.wso2.developerstudio.eclipse.carbonserver.remote.internal.RemoteCarbonServer;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

@SuppressWarnings("restriction")
public class RemoteCarbonServerUtils {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public static ServerPort[] getServerPorts(String serverHome) {
		String transportsXml = FileUtils.addNodesToPath(serverHome, new String[] { "conf", "transports.xml" });
		XPathFactory factory = XPathFactory.newInstance();
		File xmlDocument = new File(transportsXml);
		ServerPort[] serverPorts = new ServerPort[2];
		try {
			InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));
			XPath xPath = factory.newXPath();
			XPathExpression xPathExpression =
			                                  xPath.compile("/transports/transport[@name='http']/parameter[@name='port']");
			String evaluate = xPathExpression.evaluate(inputSource);
			serverPorts[0] = new ServerPort("server", "", Integer.parseInt(evaluate), "http");
			inputSource = new InputSource(new FileInputStream(xmlDocument));
			xPathExpression = xPath.compile("/transports/transport[@name='https']/parameter[@name='port']");
			evaluate = xPathExpression.evaluate(inputSource);
			serverPorts[1] = new ServerPort("server", "", Integer.parseInt(evaluate), "https");
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (XPathExpressionException e) {
			log.error(e);
		}
		return serverPorts;
	}

	public static void setTrustoreProperties(IServer server) {
		String transportsXml =
		                       FileUtils.addNodesToPath(CarbonServerManager.getServerHome(server).toOSString(),
		                                                new String[] { "conf", "server.xml" });
		XPathFactory factory = XPathFactory.newInstance();
		File xmlDocument = new File(transportsXml);
		try {
			InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));
			XPath xPath = factory.newXPath();
			XPathExpression xPathExpression = xPath.compile("/Server/Security/KeyStore/Location");
			String evaluate = xPathExpression.evaluate(inputSource);
			String trustoreLocation = resolveProperties(server, evaluate);
			inputSource = new InputSource(new FileInputStream(xmlDocument));
			xPathExpression = xPath.compile("/Server/Security/KeyStore/Password");
			evaluate = xPathExpression.evaluate(inputSource);
			String trustStorePassword = resolveProperties(server, evaluate);
			System.setProperty("javax.net.ssl.trustStore", trustoreLocation);
			System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (XPathExpressionException e) {
			log.error(e);
		}
	}

	public static ServerPort[] getServerPorts(IServer server) {
		return server.getServerPorts(new NullProgressMonitor());
	}

	public static String getRepositoryPath(String serverXmlPath) {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		String nodeValue = "";
		try {
			docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.parse(serverXmlPath);

			NodeList nodeList = doc.getElementsByTagName("RepositoryLocation");
			Node node = nodeList.item(0);
			nodeValue = node.getFirstChild().getNodeValue();

		} catch (ParserConfigurationException e) {
			log.error(e);
		} catch (SAXException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} catch (TransformerFactoryConfigurationError e) {
			log.error(e);
		}
		return nodeValue;
	}

	public static boolean updateAndSaveCarbonXml(String serverXmlPath, String repoPath, IServer server) {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.parse(serverXmlPath);

			NodeList nodeList = doc.getElementsByTagName("RepositoryLocation");
			Node node = nodeList.item(0);
			node.getFirstChild().setNodeValue(repoPath);
			Transformer t = TransformerFactory.newInstance().newTransformer();
			File confPath = new File((new File(serverXmlPath)).getParent());
			if (!confPath.exists())
				confPath.mkdirs();
			Result result = new StreamResult(new File(serverXmlPath));
			Source source = new DOMSource(doc);
			t.transform(source, result);
			return true;
		} catch (ParserConfigurationException e) {
			log.error(e);
		} catch (SAXException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} catch (TransformerConfigurationException e) {
			log.error(e);
		} catch (TransformerFactoryConfigurationError e) {
			log.error(e);
		} catch (TransformerException e) {
			log.error(e);
		}
		return false;
	}

	public static String getServerXmlPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo), new String[] { "carbon.xml" });
	}

	public static String getConfPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(workspaceRepo, new String[] { "repository", "conf" });
	}

	public static String getRepositoryPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(workspaceRepo, new String[] { "repository", "deployment", "server" });
	}

	public static String getTransportsXmlPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo),
		                                new String[] { "mgt-transports.xml" });
	}

	public static String getAxis2XmlPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo), new String[] { "axis2.xml" });
	}

	public static String resolveProperties(IServer server, String property) {
		String propertyValue;
		if (RemoteCarbonServerUtils.getServerConfigMapValue(server, property) != null) {
			return RemoteCarbonServerUtils.getServerConfigMapValue(server, property).toString();
		}
		GenericServer gserver = (GenericServer) server.loadAdapter(ServerDelegate.class, null);
		if (gserver == null || gserver.getServerDefinition() == null ||
		    gserver.getServerDefinition().getResolver() == null)
			return null;
		if (!property.startsWith("${"))
			property = "${" + property + "}";
		ServerRuntime serverDefinition = gserver.getServerDefinition();
		propertyValue = serverDefinition.getResolver().resolveProperties(property);
		return propertyValue;
	}

	public static boolean updateAndSaveAxis2Ports(String axis2Xml, IServer server) {
		loadServerInstanceProperties(server);
		XPathFactory factory = XPathFactory.newInstance();
		ServerPort[] serverPorts = CarbonServerManager.getInstance().getServerPorts(server);
		try {
			File xmlDocument = new File(axis2Xml);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(xmlDocument);
			XPath xPath = factory.newXPath();
			Node httpNode =
			                (Node) xPath.evaluate("/axisconfig/transportReceiver[@name='http']/parameter[@name='port']",
			                                      document, XPathConstants.NODE);
			Node httpsNode =
			                 (Node) xPath.evaluate("/axisconfig/transportReceiver[@name='https']/parameter[@name='port']",
			                                       document, XPathConstants.NODE);
			for (ServerPort serverPort : serverPorts) {
				ServerPort port = serverPort;
				int i = CarbonServerCommonConstants.getPortcaptions(Activator.PLUGIN_ID).indexOf(serverPort.getName());
				if (i != -1) {
					port =
					       new ServerPort(CarbonServerCommonConstants.getPortids(Activator.PLUGIN_ID).get(i), serverPort.getName(),
					                      serverPort.getPort(), serverPort.getProtocol());
				}
				if (port.getId().equalsIgnoreCase("synapse.transport.http"))
					httpNode.setTextContent(Integer.toString(serverPort.getPort()));
				if (port.getId().equalsIgnoreCase("synapse.transport.https"))
					httpsNode.setTextContent(Integer.toString(serverPort.getPort()));
			}
			Transformer t = TransformerFactory.newInstance().newTransformer();
			Result result = new StreamResult(new File(axis2Xml));
			Source source = new DOMSource(document);
			t.transform(source, result);
			return true;
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
		} catch (TransformerConfigurationException e) {
			log.error(e);
		} catch (TransformerFactoryConfigurationError e) {
			log.error(e);
		} catch (TransformerException e) {
			log.error(e);
		}
		return false;
	}

	public static boolean updateAndSaveTransportsXml(String transportsXml, IServer server) {
		loadServerInstanceProperties(server);
		XPathFactory factory = XPathFactory.newInstance();
		ServerPort[] serverPorts = CarbonServerManager.getInstance().getServerPorts(server);
		try {
			File xmlDocument = new File(transportsXml);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(xmlDocument);
			XPath xPath = factory.newXPath();
			Node httpNode =
			                (Node) xPath.evaluate("/transports/transport[@name='http']/parameter[@name='port']",
			                                      document, XPathConstants.NODE);
			Node httpsNode =
			                 (Node) xPath.evaluate("/transports/transport[@name='https']/parameter[@name='port']",
			                                       document, XPathConstants.NODE);
			for (ServerPort serverPort : serverPorts) {
				ServerPort port = serverPort;
				int i = CarbonServerCommonConstants.getPortcaptions(Activator.PLUGIN_ID).indexOf(serverPort.getName());
				if (i != -1) {
					port =
					       new ServerPort(CarbonServerCommonConstants.getPortids(Activator.PLUGIN_ID).get(i), serverPort.getName(),
					                      serverPort.getPort(), serverPort.getProtocol());
				}
				if (port.getId().equalsIgnoreCase("carbon.http"))
					httpNode.setTextContent(Integer.toString(serverPort.getPort()));
				if (port.getId().equalsIgnoreCase("carbon.https"))
					httpsNode.setTextContent(Integer.toString(serverPort.getPort()));
			}
			Transformer t = TransformerFactory.newInstance().newTransformer();
			File confPath = new File((new File(transportsXml)).getParent());
			if (!confPath.exists())
				confPath.mkdirs();
			Result result = new StreamResult(new File(transportsXml));
			Source source = new DOMSource(document);
			t.transform(source, result);
			return true;
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
		} catch (TransformerConfigurationException e) {
			log.error(e);
		} catch (TransformerFactoryConfigurationError e) {
			log.error(e);
		} catch (TransformerException e) {
			log.error(e);
		}
		return false;
	}

	public static boolean updateAxis2XML(IServer server) {
		String serverLocalWorkspacePath = CarbonServerManager.getServerLocalWorkspacePath(server);
		return RemoteCarbonServerUtils.updateAndSaveAxis2Ports(RemoteCarbonServerUtils.getAxis2XmlPathFromLocalWorkspaceRepo(serverLocalWorkspacePath),
		                                                       server);
	}

	public static boolean updateTransportXML(IServer server) {
		String serverLocalWorkspacePath = CarbonServerManager.getServerLocalWorkspacePath(server);
		return RemoteCarbonServerUtils.updateAndSaveTransportsXml(RemoteCarbonServerUtils.getTransportsXmlPathFromLocalWorkspaceRepo(serverLocalWorkspacePath),
		                                                          server);
	}

	private static boolean isHotUpdateEnabled(IServer server) {
		String axis2Xml = getAxis2FilePath(server);
		XPathFactory factory = XPathFactory.newInstance();
		try {
			File xmlDocument = new File(axis2Xml);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(xmlDocument);
			XPath xPath = factory.newXPath();
			Node httpNode =
			                (Node) xPath.evaluate("/axisconfig/parameter[@name='hotupdate']", document,
			                                      XPathConstants.NODE);
			return httpNode.getTextContent().toString().equalsIgnoreCase("true");
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
		} catch (TransformerFactoryConfigurationError e) {
			log.error(e);
		}
		return false;
	}

	public static String getAxis2FilePath(IServer server) {
		IPath serverHome = CarbonServerManager.getServerHome(server);
		String axis2Xml =
		                  FileUtils.addNodesToPath(serverHome.toOSString(), new String[] { "repository", "conf",
		                                                                                  "axis2.xml" });
		return axis2Xml;
	}

	public static void setServerHotUpdate(IServer server, boolean enable) {
		if (enable) {
			setServerConfigMapValue(server, "carbon.hotupdate", "true");
		} else {
			setServerConfigMapValue(server, "carbon.hotupdate", "false");
		}
		setHotUpdateEnabled(server, enable);
	}

	public static Boolean isServerHotUpdate(IServer server) {
		String value = RemoteCarbonServerUtils.getServerConfigMapValue(server, "carbon.hotupdate");
		if (value == null) {
			return false;
		}
		boolean enabled = value.toString().equalsIgnoreCase("true");
		if (enabled != isHotUpdateEnabled(server)) {
			setHotUpdateEnabled(server, enabled);
		}
		return enabled;
	}

	private static boolean setHotUpdateEnabled(IServer server, boolean enabled) {
		if (isHotUpdateEnabled(server) == enabled)
			return true;
		String axis2Xml = getAxis2FilePath(server);
		XPathFactory factory = XPathFactory.newInstance();
		try {
			File xmlDocument = new File(axis2Xml);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(xmlDocument);
			XPath xPath = factory.newXPath();
			Node httpNode =
			                (Node) xPath.evaluate("/axisconfig/parameter[@name='hotupdate']", document,
			                                      XPathConstants.NODE);
			httpNode.setTextContent(enabled ? "true" : "false");
			Transformer t = TransformerFactory.newInstance().newTransformer();
			File confPath = new File((new File(axis2Xml)).getParent());
			if (!confPath.exists())
				confPath.mkdirs();
			Result result = new StreamResult(new File(axis2Xml));
			Source source = new DOMSource(document);
			t.transform(source, result);
			return true;
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
		} catch (TransformerConfigurationException e) {
			log.error(e);
		} catch (TransformerFactoryConfigurationError e) {
			log.error(e);
		} catch (TransformerException e) {
			log.error(e);
		}
		return false;
	}

	public static String getServerConfigMapValue(IServer server, String key) {
		String loaded = "loaded";
		GenericServer gserver = (GenericServer) server.getAdapter(GenericServer.class);
		if (gserver == null || gserver.getServerInstanceProperties() == null)
			return null;
		if (gserver.getServerInstanceProperties().get(loaded) == null) {
			loadServerInstanceProperties(server);
		}
		Object object = gserver.getServerInstanceProperties().get(key);
		if (object != null)
			return object.toString();
		return null;
	}

	public static void setServerStartWithOSGiConsole(IServer server, boolean showConsole) {
		if (showConsole) {
			setServerConfigMapValue(server, "osgi.console", "true");
		} else {
			setServerConfigMapValue(server, "osgi.console", "false");
		}
	}

	public static Boolean isServerStartWithOSGiConsole(IServer server) {
		String value = RemoteCarbonServerUtils.getServerConfigMapValue(server, "osgi.console");
		return value == null ? null : value.toString().equalsIgnoreCase("true");
	}

	public static void setServerStartBrowserPopup(IServer server, boolean popup) {
		if (popup) {
			setServerConfigMapValue(server, "carbon.browser", "true");
		} else {
			setServerConfigMapValue(server, "carbon.browser", "false");
		}
	}

	public static Boolean isServerStartBrowserPopup(IServer server) {
		String value = RemoteCarbonServerUtils.getServerConfigMapValue(server, "carbon.browser");
		return value == null ? null : value.toString().equalsIgnoreCase("true");
	}

	@SuppressWarnings("unchecked")
	public static void setServerConfigMapValue(IServer server, String key, String value) {
		GenericServer gserver = (GenericServer) server.getAdapter(GenericServer.class);
		if (gserver != null) {
			Map<String, String> serverInstanceProperties = gserver.getServerInstanceProperties();
			serverInstanceProperties.put(key, value);
			gserver.configurationChanged();
			saveServerInstanceProperties(server);
		}
	}

	@SuppressWarnings("unchecked")
	private static void loadServerInstanceProperties(IServer server) {
		GenericServer gserver = (GenericServer) server.getAdapter(GenericServer.class);
		if (gserver == null) {
			return;
		}
		ObjectInputStream obj_in = null;
		try {
			String serverLocalWorkspacePath = CarbonServerManager.getServerLocalWorkspacePath(server);
			String objConfigPath =
			                       FileUtils.addNodesToPath(serverLocalWorkspacePath, new String[] { "repository",
			                                                                                        "conf", "config" });
			if (new File(objConfigPath).exists()) {
				FileInputStream f_in = new FileInputStream(objConfigPath);
				obj_in = new ObjectInputStream(f_in);
				Map<String, String> obj = (Map<String, String>) obj_in.readObject();
				gserver.getServerInstanceProperties().putAll(obj);
			}
		} catch (IOException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		} finally {
			if (obj_in != null) {
				try {
					obj_in.close();
				} catch (IOException e) {
					log.error("Error occured while closing a stream", e);
				}
			}
		}
	}

	private static void saveServerInstanceProperties(IServer server) {
		GenericServer gserver = (GenericServer) server.getAdapter(GenericServer.class);
		if (gserver == null) {
			return;
		}
		FileOutputStream f_out = null;
		ObjectOutputStream obj_out = null;
		try {
			String serverLocalWorkspacePath = CarbonServerManager.getServerLocalWorkspacePath(server);
			String objConfigPath =
			                       FileUtils.addNodesToPath(serverLocalWorkspacePath, new String[] { "repository",
			                                                                                        "conf", "config" });
			f_out = new FileOutputStream(objConfigPath);
			obj_out = new ObjectOutputStream(f_out);
			obj_out.writeObject(gserver.getServerInstanceProperties());
		} catch (IOException e) {
			log.error(e);
		} finally {
			if (obj_out != null) {
				try {
					obj_out.close();
				} catch (IOException e) {
					log.error("Error occured while closing a stream", e);
				}
			}

			if (f_out != null) {
				try {
					f_out.close();
				} catch (IOException e) {
					log.error("Error occured while closing a stream", e);
				}
			}
		}
	}

	public static String getServerTimestamp(IServer server) {
		String timestampStr = "carbon.timestamp";
		String timestampVal = getServerConfigMapValue(server, timestampStr);
		if (timestampVal == null) {
			timestampVal = String.valueOf((new Date()).getTime());
			setServerConfigMapValue(server, timestampStr, timestampVal);
		}
		return timestampVal;
	}

	public static String getRegistryRoot(IServer server) {
		String timestampVal = getServerTimestamp(server);
		String registryRoot = "/eclipse/server_" + timestampVal;
		return registryRoot;
	}

	public static URL getServerURL(IServer server) {
		RemoteCarbonServer serverDelegate = (RemoteCarbonServer) server.loadAdapter(RemoteCarbonServer.class, null);
		return serverDelegate.getServerURL();
	}

	public static Map<String, String> getServerCredentials(IServer server) {
		Map<String, String> credentials = new HashMap<String, String>();
		RemoteCarbonServer rcs = (RemoteCarbonServer) server.loadAdapter(RemoteCarbonServer.class, null);
		String username = rcs.getUsername();
		String password = rcs.getPassword();
		if (username == null) {
			username = "admin";
		}
		if (password == null) {
			password = "admin";
		}
		credentials.put(CarbonServerCommonConstants.getEsbUsername(), username);
		credentials.put(CarbonServerCommonConstants.getEsbPassword(), password);
		return credentials;
	}

	public static String getServerCookie(IServer server, String httpsPort) throws Exception {
		String sessionCookie = "";
		return sessionCookie;
	}

	public static void setServerUsername(IServer server, String username) {
		setServerConfigMapValue(server, CarbonServerCommonConstants.getEsbUsername(), username);
	}

	public static void setServerPassword(IServer server, String password) {
		setServerConfigMapValue(server, CarbonServerCommonConstants.getEsbPassword(), password);
	}

	public static String getPortId(String name) {
		String id = "carbon.https";
		if (name.equalsIgnoreCase(CarbonServerCommonConstants.getEsbConsoleHttpsDesc()))
			id = CarbonServerCommonConstants.getEsbConsoleHttps();
		if (name.equalsIgnoreCase(CarbonServerCommonConstants.getEsbTransportHttpDesc()))
			id = CarbonServerCommonConstants.getEsbTransportHttp();
		if (name.equalsIgnoreCase(CarbonServerCommonConstants.getEsbTransportHttpsDesc()))
			id = CarbonServerCommonConstants.getEsbTransportHttps();
		return id;
	}

	public static File getCappMonitorBundle() {
		URL resource =
		               Platform.getBundle(Activator.PLUGIN_ID)
		                       .getResource("lib" + File.separator + "org.wso2.carbon.capp.monitor-3.0.0.jar");
		IPath path = Activator.getDefault().getStateLocation();
		IPath libFolder = path.append("lib");
		String[] paths = resource.getFile().split(File.separator);
		IPath library = libFolder.append(paths[paths.length - 1]);
		File libraryFile = new File(library.toOSString());
		if (libraryFile.exists()) {
			return libraryFile;
		}
		try {
			writeToFile(libraryFile, resource.openStream());
		} catch (IOException e) {
			log.error(e);
			return null;
		}
		return libraryFile;
	}

	private static void writeToFile(File file, InputStream stream) throws IOException {
		file.getParentFile().mkdirs();
		OutputStream out = new FileOutputStream(file);
		byte buf[] = new byte[1024];
		int len;
		while ((len = stream.read(buf)) > 0)
			out.write(buf, 0, len);
		out.close();
		stream.close();
	}

	public static void validateURL(URL remoteServerURL) throws Exception {
		URLConnection conn = remoteServerURL.openConnection();

		int responseCode;
		try {
			responseCode = ((HttpsURLConnection) conn).getResponseCode();
		} catch (Exception e) {
			throw new Exception("Unable to connect with the server", e);
		}
		if (responseCode != 200 && responseCode != 302) {
			throw new Exception("Server is has not fully started or incorrect URL");
		}
	}

	public static void validateCredentials(String serverURL, String username, String pwd) throws Exception {
		URL url = new URL(serverURL);
		validateURL(url);
		String sessionCookie = CarbonServerUtils.createSessionCookie(serverURL, username, pwd);
		if (sessionCookie == null) {
			throw new Exception("Invalid credentials");

		}

	}

}
