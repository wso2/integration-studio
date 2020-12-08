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

package org.wso2.developerstudio.eclipse.carbonserver44microei12.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jst.server.generic.core.internal.GenericServer;
import org.eclipse.jst.server.generic.servertype.definition.ServerRuntime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
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
import org.wso2.developerstudio.eclipse.carbonserver44microei12.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.register.product.servers.MicroIntegratorInstance;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.util.EmbeddedServerManagementAPIUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import net.consensys.cava.toml.Toml;

import net.consensys.cava.toml.TomlParseResult;

@SuppressWarnings("restriction")
public class CarbonServer44eiUtils implements CarbonServerXUtils {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String CONFIG_PROPERTIES_FILE = "config.properties";
    private static final String SERVER_CONFIG_LOCATION = File.separator + ".metadata" + File.separator
            + "ServerConfigs";
    private static final String TEMP_SERVER_CONFIGURATION_PATH = ResourcesPlugin.getWorkspace().getRoot().getLocation()
            .toOSString() + SERVER_CONFIG_LOCATION;
    private static final String MI_API_API_URL= "/management/apis";
    private static final String MI_PROXY_API_URL= "/management/proxy-services";
    private static final String MI_DATASERVICES_API_URL= "/management/data-services";
    private static final String DEP_SERVICES_PROPERTIES_PATH = ResourcesPlugin.getWorkspace().getRoot().getLocation()
            .toOSString() + File.separator + ".metadata" + File.separator + "deployed_services.properties";

    @Override
    public String getServerVersion() {
        return CarbonServerCommonConstants.getCarbonVersion(Activator.PLUGIN_ID);
    }

    @Override
    public boolean updateTransportPorts(IServer server) {
        return true;
    }

    @Override
    public URL getServerURL(IServer server) {
        return null;
    }

    @Override
    public ServerPort[] getServerPorts(String serverHome) {
        return null;
    }

    @Override
    public String getWebContextRoot(IServer server) {
        return null;
    }

    @Override
    public NamespaceContext getCarbonNamespace() {
        return null;
    }

    @Override
    public void setTrustoreProperties(IServer server) {
        // TODO update with deployment.toml if needed
        String transportsXml = FileUtils.addNodesToPath(CarbonServerManager.getServerHome(server).toOSString(),
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
        } catch (FileNotFoundException | XPathExpressionException e) {
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

        } catch (ParserConfigurationException | SAXException | IOException | TransformerFactoryConfigurationError e) {
            log.error(e);
        }
        return nodeValue;
    }

    @Override
    public boolean updateAndSaveCarbonXml(String serverXmlPath, String repoPath, IServer server) {
        return true;
    }

    @Override
    public String getServerXmlPathFromLocalWorkspaceRepo(String workspaceRepo) {
        return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo),
                new String[] { "carbon.xml" });
    }

    @Override
    public String getCatelinaXmlPathFromLocalWorkspaceRepo(String workspaceRepo) {
        return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo),
                new String[] { "tomcat", "catalina-server.xml" });
    }

    @Override
    public String getConfPathFromLocalWorkspaceRepo(String workspaceRepo) {
        return FileUtils.addNodesToPath(workspaceRepo, new String[] { "conf" });
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
        return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo),
                new String[] { "carbon.xml" });
    }

    @Override
    public String getAxis2XmlPathFromLocalWorkspaceRepo(String workspaceRepo) {
        return FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(workspaceRepo),
                new String[] { "axis2", "axis2.xml" });
    }

    @Override
    public String resolveProperties(IServer server, String property) {
        if (CarbonServerCommonUtils.getServerConfigMapValue(server, property) != null) {
            return CarbonServerCommonUtils.getServerConfigMapValue(server, property).toString();
        }
        GenericServer gserver = (GenericServer) server.loadAdapter(ServerDelegate.class, null);
        if (gserver == null || gserver.getServerDefinition() == null
                || gserver.getServerDefinition().getResolver() == null)
            return null;
        if (!property.startsWith("${"))
            property = "${" + property + "}";
        ServerRuntime serverDefinition = gserver.getServerDefinition();
        return serverDefinition.getResolver().resolveProperties(property);
    }

    @Override
    public boolean updateAndSaveAxis2Ports(String axis2Xml, IServer server) {
        return true;
    }

    @Override
    public File getCappMonitorBundle() {
        URL resource = Platform.getBundle(Activator.PLUGIN_ID)
                .getResource("lib/org.wso2.carbon.capp.monitor-3.0.0.jar");
        IPath path = Activator.getDefault().getStateLocation();
        IPath libFolder = path.append("lib");
        String[] paths = resource.getFile().split("\\" + File.separator);
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
            String objConfigPath = FileUtils.addNodesToPath(serverLocalWorkspacePath,
                    new String[] { "repository", "conf", "config" });
            if (new File(objConfigPath).exists()) {
                FileInputStream f_in = new FileInputStream(objConfigPath);
                obj_in = new ObjectInputStream(f_in);
                Map<String, String> obj = (Map<String, String>) obj_in.readObject();
                gserver.getServerInstanceProperties().putAll(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
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
        return true;
    }

    public TomlParseResult getTomlResults(String carbonHomePath) throws IOException {
        String tomlFilePath = FileUtils.addNodesToPath(getConfPathFromLocalWorkspaceRepo(carbonHomePath),
                new String[] { "deployment.toml" });
        return Toml.parse(Paths.get(tomlFilePath));
    }

    private String getStringOfTomlObject(Object object) {
        if (object == null) {
            return "";
        }

        if (object instanceof Long) {
            return String.valueOf(object);
        }

        if (object instanceof String) {
            return ((String) object);
        }

        if (object instanceof Boolean) {
            return object.toString();
        }

        return "";
    }

    public String readTomlValue(TomlParseResult tomlResults, String key, String defaultValue) {
        String tomlValue = "";
        Object offsetObject = tomlResults.get(key);
        tomlValue = getStringOfTomlObject(offsetObject);
        if (tomlValue.equals("")) {
            return defaultValue;
        }
        return tomlValue;
    }
    
    public static boolean hasEmbeddedConfigsChanged() {
        String configPropertiesPath = TEMP_SERVER_CONFIGURATION_PATH + File.separator + CONFIG_PROPERTIES_FILE;
        try (InputStream inStream = Files.newInputStream(Paths.get(configPropertiesPath))) {
            if (inStream != null) {
                Properties properties = new Properties();
                properties.load(inStream);
                boolean updatePropertiesfile = false;

                String newTomlMd5sum = properties.getProperty(ServerConstants.NEW_TOML_MD5SUM);
                String currentTomlMd5sum = properties.getProperty(ServerConstants.CURRENT_TOML_MD5SUM);
                if (newTomlMd5sum != null && !newTomlMd5sum.equals(currentTomlMd5sum)) {
                    properties.setProperty(ServerConstants.CURRENT_TOML_MD5SUM, newTomlMd5sum);
                    updatePropertiesfile = true;
                }

                String newJarMd5sum = properties.getProperty(ServerConstants.NEW_JAR_MD5SUM);
                String currentJarMd5sum = properties.getProperty(ServerConstants.CURRENT_JAR_MD5SUM);
                if (newJarMd5sum != null && !newJarMd5sum.equals(currentJarMd5sum)) {
                    properties.setProperty(ServerConstants.CURRENT_JAR_MD5SUM, newJarMd5sum);
                    updatePropertiesfile = true;
                }
                
                String newDropinsMd5sum = properties.getProperty(ServerConstants.NEW_DROPINS_MD5SUM);
                String currentDropinsMd5sum = properties.getProperty(ServerConstants.CURRENT_DROPINS_MD5SUM);
                if (newDropinsMd5sum != null && !newDropinsMd5sum.equals(currentDropinsMd5sum)) {
                    properties.setProperty(ServerConstants.CURRENT_DROPINS_MD5SUM, newDropinsMd5sum);
                    updatePropertiesfile = true;
                }

                if (updatePropertiesfile) {
                    properties.store(new FileOutputStream(configPropertiesPath), null);
                    return true;
                }
            }
        } catch (IOException e) {
            // ignore the error as there wont be a config.properties file until any change is made to the embedded
            // server configurations
        }
        return false;
    }

    public static boolean isHotDeploymentEnabled(MicroIntegratorInstance microIntegratorInstance) {
        String workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
        try {
            String serverConfigDirectoryPath = workspace + File.separator + ".metadata" + File.separator
                    + "ServerConfigs";
            File serverConfigurationDirectory = new File(serverConfigDirectoryPath);
            String tomlFilePath = serverConfigDirectoryPath + File.separator + "deployment.toml";
            File customizedTomlFile = new File(tomlFilePath);
            if (serverConfigurationDirectory.exists() && customizedTomlFile.exists()) {
                TomlParseResult tomlResults = Toml.parse(Paths.get(tomlFilePath));
                Object hotDeploymentObject = tomlResults.get("server.hot_deployment");
                if ((hotDeploymentObject instanceof String && ((String) hotDeploymentObject).equals("false"))
                        || (hotDeploymentObject instanceof Boolean && !((Boolean) hotDeploymentObject))) {
                    return false;
                }

            } else {
                return microIntegratorInstance.isHotDeploymentEnabled();
            }
        } catch (IOException e) {
            log.error("An error occured while backup default server configurations", e);
        }
        return true;
    }
    
    public static void updateDeployedServices() {
        String deployedApiMd5sum = null;
        String deployedProxyMd5sum = null;
        String deployedDataserviceMd5sum = null;
        try (InputStream propertiesFileStream = Files.newInputStream(Paths.get(DEP_SERVICES_PROPERTIES_PATH))) {
            if (propertiesFileStream != null) {
                Properties existingProperties = new Properties();
                existingProperties.load(propertiesFileStream);

                deployedApiMd5sum = existingProperties.getProperty("deployed.md5sum.api");
                deployedProxyMd5sum = existingProperties.getProperty("deployed.md5sum.proxy");
                deployedDataserviceMd5sum = existingProperties.getProperty("deployed.md5sum.dataservice");
            }
        } catch (IOException | IllegalArgumentException e) {
            log.error("Error while setting the md5sum values of embedded server configurations.", e);
        }

        int offSet = EmbeddedServerManagementAPIUtils.getOffset(10);
        String newDeployedApiMd5sum = null;
        String newDeployedProxyMd5sum = null;
        String newDeployedDataserviceMd5sum = null;
        String currentDeployedApiMd5sum = null;
        String currentDeployedProxyMd5sum = null;
        String currentDeployedDataserviceMd5sum = null;
        String port = String.valueOf(9154 + offSet);
        boolean hasChanged = false;
        boolean hasNewChanges = false;
        boolean exitLoop = false;
        try {
            String accessToken = EmbeddedServerManagementAPIUtils.generateAccessToken(port);
            Thread.sleep(1000);
            int count = 0;
            do {
                Thread.sleep(1000);
                count++;
                currentDeployedApiMd5sum = DigestUtils.md5Hex(
                        EmbeddedServerManagementAPIUtils.getDeployedServices(port, MI_API_API_URL, accessToken));
                currentDeployedProxyMd5sum = DigestUtils.md5Hex(
                        EmbeddedServerManagementAPIUtils.getDeployedServices(port, MI_PROXY_API_URL, accessToken));
                currentDeployedDataserviceMd5sum = DigestUtils.md5Hex(EmbeddedServerManagementAPIUtils
                        .getDeployedServices(port, MI_DATASERVICES_API_URL, accessToken));

                hasChanged = md5HasChanged(deployedApiMd5sum, deployedProxyMd5sum, deployedDataserviceMd5sum,
                        currentDeployedApiMd5sum, currentDeployedProxyMd5sum, currentDeployedDataserviceMd5sum);

                if (hasChanged) {
                    do {
                        Thread.sleep(1000);
                        count++;
                        newDeployedApiMd5sum = DigestUtils.md5Hex(EmbeddedServerManagementAPIUtils
                                .getDeployedServices(port, MI_API_API_URL, accessToken));
                        newDeployedProxyMd5sum = DigestUtils.md5Hex(EmbeddedServerManagementAPIUtils
                                .getDeployedServices(port, MI_PROXY_API_URL, accessToken));
                        newDeployedDataserviceMd5sum = DigestUtils.md5Hex(EmbeddedServerManagementAPIUtils
                                .getDeployedServices(port, MI_DATASERVICES_API_URL, accessToken));

                        hasNewChanges = md5HasChanged(currentDeployedApiMd5sum, currentDeployedProxyMd5sum,
                                currentDeployedDataserviceMd5sum, newDeployedApiMd5sum, newDeployedProxyMd5sum,
                                newDeployedDataserviceMd5sum);
                        if (!hasNewChanges) {
                            exitLoop = true;
                        }
                    } while (hasNewChanges && count < 5);
                }
            } while (!exitLoop && count < 20);
        } catch (IOException | InterruptedException e) {
            log.error("Error while invoking the embedded integrator management API.", e);
        }

        if (hasChanged) {
            Display.getDefault().asyncExec(new Runnable() {
                public void run() {
                    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                    IViewPart view = page.findView(ServerConstants.DEPLOYED_SERVICES_VIEW);
                    page.hideView(view);
                    try {
                        page.showView(ServerConstants.DEPLOYED_SERVICES_VIEW);
                    } catch (PartInitException e) {
                        log.error("Error while initializing deployed services view.", e);
                    }
                }
            });
        }
    }

    private static boolean md5HasChanged(String deployedApiMd5sum, String deployedProxyMd5sum,
            String deployedDataserviceMd5sum, String currentDeployedApiMd5sum, String currentDeployedProxyMd5sum,
            String currentDeployedDataserviceMd5sum) {
        if (!deployedApiMd5sum.equals(currentDeployedApiMd5sum)) {
            return true;
        }
        if (!deployedProxyMd5sum.equals(currentDeployedProxyMd5sum)) {
            return true;
        }
        if (!deployedDataserviceMd5sum.equals(currentDeployedDataserviceMd5sum)) {
            return true;
        }
        return false;
    }
}
