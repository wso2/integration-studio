/*
* Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbon.server.model.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jst.server.generic.core.internal.GenericServer;
import org.eclipse.wst.server.core.IServer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.wso2.developerstudio.eclipse.carbon.server.model.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.xml.sax.SAXException;

@SuppressWarnings("restriction")
public class CarbonServerCommonUtils {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public static void writeToFile(File file, InputStream stream) throws IOException {
		file.getParentFile().mkdirs();
		OutputStream out = new FileOutputStream(file);
		byte buf[] = new byte[1024];
		int len;
		while ((len = stream.read(buf)) > 0)
			out.write(buf, 0, len);
		out.close();
		stream.close();
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

	public static Map<String, String> getServerCredentials(IServer server) {
		Map<String, String> credentials = new HashMap<String, String>();
		String username = getServerConfigMapValue(server, CarbonServerCommonConstants.getEsbUsername());
		String password = getServerConfigMapValue(server, CarbonServerCommonConstants.getEsbPassword());
		if (username == null) {
			username = "admin";
			setServerConfigMapValue(server, CarbonServerCommonConstants.getEsbUsername(), username);
		}
		if (password == null) {
			password = "admin";
			setServerConfigMapValue(server, CarbonServerCommonConstants.getEsbPassword(), password);
		}

		credentials.put(CarbonServerCommonConstants.getEsbUsername(), username);
		credentials.put(CarbonServerCommonConstants.getEsbPassword(), password);
		return credentials;
	}

	public static String getServerCookie(IServer server, String httpsPort) throws Exception {
		String sessionCookie = "";
		return sessionCookie;
	}

	public static String getAxis2FilePath(IServer server) {
		IPath serverHome = CarbonServerManager.getServerHome(server);
		String axis2Xml =
		                  FileUtils.addNodesToPath(serverHome.toOSString(), new String[] { "repository", "conf",
		                                                                                  "axis2", "axis2.xml" });
		return axis2Xml;
	}

	private static boolean isHotUpdateEnabled(IServer server) {
		String axis2Xml = getAxis2FilePath(server);
		XPathFactory factory = XPathFactory.newInstance();
		try {
			File xmlDocument = new File(axis2Xml);
			if (xmlDocument.exists()) {
				DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = builder.parse(xmlDocument);
				XPath xPath = factory.newXPath();
				Node httpNode =
				                (Node) xPath.evaluate("/axisconfig/parameter[@name='hotupdate']", document,
				                                      XPathConstants.NODE);
				return httpNode.getTextContent().toString().equalsIgnoreCase("true");
			} else {
				return false;
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
		} catch (TransformerFactoryConfigurationError e) {
			log.error(e);
		}
		return false;
	}

	public static String getServerConfigMapValue(IServer server, String key) {
		String loaded = "loaded";
		GenericServer gserver = (GenericServer) server.getAdapter(GenericServer.class);
		if (gserver == null || gserver.getServerInstanceProperties() == null)
			return null;
		Object object = gserver.getServerInstanceProperties().get(key);
		if (object != null)
			return object.toString();
		return null;
	}

	public static Boolean isServerHotUpdate(IServer server) {
		String value = CarbonServerCommonUtils.getServerConfigMapValue(server, "carbon.hotupdate");
		if (value == null) {
			return null;
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
			if (f_out != null) {
				try {
					f_out.close();
				} catch (IOException e) {
					log.error("Error while closing stream", e);
				}
			}

			if (obj_out != null) {
				try {
					obj_out.close();
				} catch (IOException e) {
					log.error("Error while closing stream", e);
				}
			}
		}
	}

	public static void setServerUsername(IServer server, String username) {
		setServerConfigMapValue(server, CarbonServerCommonConstants.getEsbUsername(), username);
	}

	public static void setServerPassword(IServer server, String password) {
		setServerConfigMapValue(server, CarbonServerCommonConstants.getEsbPassword(), password);
	}

	public static void setServerStartBrowserPopup(IServer server, boolean popup) {
		if (popup) {
			setServerConfigMapValue(server, "carbon.browser", "true");
		} else {
			setServerConfigMapValue(server, "carbon.browser", "false");
		}
	}

	public static void setServerHotUpdate(IServer server, boolean enable) {
		if (enable) {
			setServerConfigMapValue(server, "carbon.hotupdate", "true");
		} else {
			setServerConfigMapValue(server, "carbon.hotupdate", "false");
		}
		setHotUpdateEnabled(server, enable);
	}

	public static void setServerStartWithOSGiConsole(IServer server, boolean showConsole) {
		if (showConsole) {
			setServerConfigMapValue(server, "osgi.console", "true");
		} else {
			setServerConfigMapValue(server, "osgi.console", "false");
		}
	}

	public static Boolean isServerStartWithOSGiConsole(IServer server) {
		String value = CarbonServerCommonUtils.getServerConfigMapValue(server, "osgi.console");
		return value == null ? null : value.toString().equalsIgnoreCase("true");
	}

	public static Boolean isServerStartBrowserPopup(IServer server) {
		String value = CarbonServerCommonUtils.getServerConfigMapValue(server, "carbon.browser");
		return value == null ? null : value.toString().equalsIgnoreCase("true");
	}

}
