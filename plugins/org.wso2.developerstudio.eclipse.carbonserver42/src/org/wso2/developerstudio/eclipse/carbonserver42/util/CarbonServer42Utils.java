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

package org.wso2.developerstudio.eclipse.carbonserver42.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;
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
import org.wso2.developerstudio.eclipse.carbon.server.model.util.CarbonServerCommonConstants;
import org.wso2.developerstudio.eclipse.carbon.server.model.util.CarbonServerCommonUtils;
import org.wso2.developerstudio.eclipse.carbon.server.model.util.CarbonServerXUtils;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver42.Activator;
import org.wso2.developerstudio.eclipse.carbonserver42.internal.CarbonServer42;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@SuppressWarnings("restriction")
public class CarbonServer42Utils implements CarbonServerXUtils {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public String getServerVersion() {
		return CarbonServerCommonConstants.getCarbonVersion(Activator.PLUGIN_ID);
	}

	@Override
	public boolean updateTransportPorts(IServer server) {
		String serverLocalWorkspacePath = CarbonServerManager.getServerLocalWorkspacePath(server);
		return updateAndSaveTransportsPorts(getCarbonXmlPathFromLocalWorkspaceRepo(serverLocalWorkspacePath),
		                                    getCatelinaXmlPathFromLocalWorkspaceRepo(serverLocalWorkspacePath), server);
	}

	@Override
	public URL getServerURL(IServer server) {
		CarbonServer42 serverDelegate = (CarbonServer42) server.loadAdapter(CarbonServer42.class, null);

		ServerPort[] serverPorts = getServerPorts(server);
		int httpsPort = 9443;
		int offset = 0;
		for (ServerPort serverPort : serverPorts) {
			if (serverPort.getName().equals("Carbon web console port (HTTPS)") &&
			    serverPort.getProtocol().equals("https")) {
				httpsPort = serverPort.getPort();
			} else if (serverPort.getName().equals("Carbon Server Offset")) {
				offset = serverPort.getPort();
			}
		}
		try {
			return new URL("https://localhost:" + (httpsPort + offset));
		} catch (MalformedURLException e) {
			log.error(e);
		}
		return null;
	}

	@Override
	public ServerPort[] getServerPorts(String serverHome) {
		String transportsXml = FileUtils.addNodesToPath(serverHome, new String[] { "conf", "carbon.xml" });
		XPathFactory factory = XPathFactory.newInstance();
		File xmlDocument = new File(transportsXml);
		ServerPort[] serverPorts = new ServerPort[2];
		try {
			InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));
			XPath xPath = factory.newXPath();
			XPathExpression xPathExpression = xPath.compile("/:Server/:Ports/:ServletTransports/:HTTP");
			String evaluate = xPathExpression.evaluate(inputSource);
			serverPorts[0] = new ServerPort("server", "", Integer.parseInt(evaluate), "http");
			inputSource = new InputSource(new FileInputStream(xmlDocument));
			xPathExpression = xPath.compile("/:Server/:Ports/:ServletTransports/:HTTPS");
			evaluate = xPathExpression.evaluate(inputSource);
			serverPorts[1] = new ServerPort("server", "", Integer.parseInt(evaluate), "https");
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (XPathExpressionException e) {
			log.error(e);
		}
		return serverPorts;
	}

	@Override
	public String getWebContextRoot(IServer server) {
		String transportsXml =
		                       FileUtils.addNodesToPath(CarbonServerManager.getServerHome(server).toOSString(),
		                                                new String[] { "repository", "conf", "carbon.xml" });
		XPathFactory factory = XPathFactory.newInstance();
		File xmlDocument = new File(transportsXml);
		String webContextRoot = null;
		NamespaceContext ctx = new NamespaceContext() {
			public String getNamespaceURI(String prefix) {
				return "http://wso2.org/projects/carbon/carbon.xml";
			}

			public String getPrefix(String arg0) {
				return null;
			}

			public Iterator getPrefixes(String arg0) {
				return null;
			}
		};

		try {
			InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));
			XPath xPath = factory.newXPath();
			xPath.setNamespaceContext(ctx);
			XPathExpression xPathExpression = xPath.compile("/:Server/:WebContextRoot");
			webContextRoot = xPathExpression.evaluate(inputSource);
			webContextRoot = webContextRoot.equals("/") ? "" : webContextRoot;
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (XPathExpressionException e) {
			log.error(e);
		}
		return webContextRoot;
	}

	@Override
	public NamespaceContext getCarbonNamespace() {
		NamespaceContext ctx = new NamespaceContext() {
			public String getNamespaceURI(String prefix) {
				return "http://wso2.org/projects/carbon/carbon.xml";
			}

			public String getPrefix(String arg0) {
				return null;
			}

			public Iterator getPrefixes(String namespaceURI) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return ctx;
	}

	@Override
	public void setTrustoreProperties(IServer server) {
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

	@Override
	public ServerPort[] getServerPorts(IServer server) {
		return server.getServerPorts(new NullProgressMonitor());
	}

	@Override
	public String getRepositoryPath(String serverXmlPath) {
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

	@Override
	public boolean updateAndSaveCarbonXml(String serverXmlPath, String repoPath, IServer server) {
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

	@Override
	public String getServerXmlPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo), new String[] { "carbon.xml" });
	}

	@Override
	public String getCatelinaXmlPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo),
		                                new String[] { "tomcat", "catalina-server.xml" });
	}

	@Override
	public String getConfPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(workspaceRepo, new String[] { "repository", "conf" });
	}

	@Override
	public String getRepositoryPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(workspaceRepo, new String[] { "repository", "deployment", "server" });
	}

	@Override
	public String getTransportsXmlPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo),
		                                new String[] { "mgt-transports.xml" });
	}

	@Override
	public String getCarbonXmlPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo), new String[] { "carbon.xml" });
	}

	@Override
	public String getAxis2XmlPathFromLocalWorkspaceRepo(String workspaceRepo) {
		return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo), new String[] { "axis2",
		                                                                                                "axis2.xml" });
	}

	@Override
	public String resolveProperties(IServer server, String property) {
		String propertyValue;
		if (CarbonServerCommonUtils.getServerConfigMapValue(server, property) != null) {
			return CarbonServerCommonUtils.getServerConfigMapValue(server, property).toString();
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

	@Override
	public boolean updateAndSaveAxis2Ports(String axis2Xml, IServer server) {
		XPathFactory factory = XPathFactory.newInstance();
		ServerPort[] serverPorts = CarbonServerManager.getInstance().getServerPorts(server);
		try {

			File xmlDocument = new File(axis2Xml);
			if (xmlDocument.exists()) {
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
					int i =
					        CarbonServerCommonConstants.getPortcaptions(Activator.PLUGIN_ID)
					                                   .indexOf(serverPort.getName());
					if (i != -1) {
						port =
						       new ServerPort(CarbonServerCommonConstants.getPortids(Activator.PLUGIN_ID).get(i),
						                      serverPort.getName(), serverPort.getPort(), serverPort.getProtocol());
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
			}
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

	@Override
	public File getCappMonitorBundle() {
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
			CarbonServerCommonUtils.writeToFile(libraryFile, resource.openStream());
		} catch (IOException e) {
			log.error(e);
			return null;
		}
		return libraryFile;
	}

	@Override
	public String getPortId(String name) {
		String id = "carbon.https";
		if (name.equalsIgnoreCase(CarbonServerCommonConstants.getEsbConsoleHttpsDesc()))
			id = CarbonServerCommonConstants.getEsbConsoleHttps();
		if (name.equalsIgnoreCase(CarbonServerCommonConstants.getEsbTransportHttpDesc()))
			id = CarbonServerCommonConstants.getEsbTransportHttp();
		if (name.equalsIgnoreCase(CarbonServerCommonConstants.getEsbTransportHttpsDesc()))
			id = CarbonServerCommonConstants.getEsbTransportHttps();
		return id;
	}

	@Override
	public void loadServerInstanceProperties(IServer server) {
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
					log.error("Error while closing stream", e);
				}
			}
		}

	}

	@Override
	public boolean updateAxis2XML(IServer server) {
		String serverLocalWorkspacePath = CarbonServerManager.getServerLocalWorkspacePath(server);
		return updateAndSaveAxis2Ports(getAxis2XmlPathFromLocalWorkspaceRepo(serverLocalWorkspacePath), server);
	}

	@Override
	public boolean updateAndSaveTransportsPorts(String carbonXml, String catelinaXml, IServer server) {
		NamespaceContext cntx = getCarbonNamespace();
		XPathFactory factory = XPathFactory.newInstance();
		ServerPort[] serverPorts = CarbonServerManager.getInstance().getServerPorts(server);
		try {
			File xmlDocument = new File(carbonXml);
			File catelinaXmlDocument = new File(catelinaXml);
			if (xmlDocument.exists() && catelinaXmlDocument.exists()) {
				DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				DocumentBuilder catelinaBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = builder.parse(xmlDocument);
				Document catelinaDocument = catelinaBuilder.parse(catelinaXmlDocument);
				XPath xPath = factory.newXPath();
				XPath catelinaXPath = factory.newXPath();
				xPath.setNamespaceContext(cntx);
				Node httpNode =
				                (Node) catelinaXPath.evaluate("/Server/Service/Connector[1]/@port", catelinaDocument,
				                                              XPathConstants.NODE);
				Node httpsNode =
				                 (Node) catelinaXPath.evaluate(CarbonServerCommonConstants.getCatalinaXpathExpressionForSslEnabledPort(Activator.PLUGIN_ID),
				                                               catelinaDocument, XPathConstants.NODE);
				Node offSet = (Node) xPath.evaluate("/Server/Ports/Offset", document, XPathConstants.NODE);
				for (ServerPort serverPort : serverPorts) {
					ServerPort port = serverPort;
					int i =
					        CarbonServerCommonConstants.getPortcaptions(Activator.PLUGIN_ID)
					                                   .indexOf(serverPort.getName());
					if (i != -1) {
						port =
						       new ServerPort(CarbonServerCommonConstants.getPortids(Activator.PLUGIN_ID).get(i),
						                      serverPort.getName(), serverPort.getPort(), serverPort.getProtocol());
					}
					if (port.getId().equalsIgnoreCase("carbon.http"))
						httpNode.setTextContent(Integer.toString(serverPort.getPort()));
					if (port.getId().equalsIgnoreCase("carbon.https"))
						httpsNode.setTextContent(Integer.toString(serverPort.getPort()));
					if (port.getId().equalsIgnoreCase("carbon.offset")) {
						int port2 = serverPort.getPort();
						String strPort = Integer.toString(port2);
						offSet.setTextContent(strPort);
					}
				}
				Transformer t = TransformerFactory.newInstance().newTransformer();
				Transformer t1 = TransformerFactory.newInstance().newTransformer();
				File confPath = new File((new File(carbonXml)).getParent());
				File catelinaConfPath = new File((new File(catelinaXml)).getParent());
				if (!confPath.exists()) {
					confPath.mkdirs();
				}
				if (!catelinaConfPath.exists()) {
					catelinaConfPath.mkdirs();
				}
				Result result = new StreamResult(new File(carbonXml));
				Result result1 = new StreamResult(new File(catelinaXml));
				Source source = new DOMSource(document);
				Source source1 = new DOMSource(catelinaDocument);
				t.transform(source, result);
				t1.transform(source1, result1);
				return true;
			}
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
}
