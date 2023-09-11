/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.artifact.synapse.api.ui.wizard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.endpoints.EndpointSerializer;
import org.apache.synapse.config.xml.rest.APIFactory;
import org.apache.synapse.config.xml.rest.APISerializer;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.endpoints.WSDLEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.CallMediator;
import org.apache.synapse.mediators.builtin.PropertyMediator;
import org.apache.synapse.mediators.builtin.RespondMediator;
import org.apache.synapse.mediators.transform.HeaderMediator;
import org.apache.synapse.mediators.transform.PayloadFactoryMediator;
import org.apache.synapse.mediators.transform.pfutils.FreeMarkerTemplateProcessor;
import org.apache.synapse.api.API;
import org.apache.synapse.api.Resource;
import org.apache.synapse.api.dispatch.URLMappingHelper;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.json.simple.JSONValue;
import org.wso2.carbon.rest.api.APIException;
import org.wso2.carbon.rest.api.service.RestApiAdmin;
import org.wso2.integrationstudio.artifact.synapse.api.Activator;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.SwaggerDefinitionProcessingException;
import org.wso2.integrationstudio.artifact.synapse.api.model.APIArtifactModel;
import org.wso2.integrationstudio.artifact.synapse.api.model.APIMAPIArtifactModel;
import org.wso2.integrationstudio.artifact.synapse.api.util.APIImageUtils;
import org.wso2.integrationstudio.artifact.synapse.api.util.ArtifactConstants;
import org.wso2.integrationstudio.artifact.synapse.api.util.MetadataUtils;
import org.wso2.integrationstudio.capp.maven.utils.MavenConstants;
import org.wso2.integrationstudio.esb.core.ESBMavenConstants;
import org.wso2.integrationstudio.esb.core.exceptions.BuildArtifactCreationException;
import org.wso2.integrationstudio.esb.core.utils.SynapseConstants;
import org.wso2.integrationstudio.esb.core.utils.SynapseUtils;
import org.wso2.integrationstudio.esb.project.artifact.ESBArtifact;
import org.wso2.integrationstudio.esb.project.artifact.ESBProjectArtifact;
import org.wso2.integrationstudio.general.project.artifact.GeneralProjectArtifact;
import org.wso2.integrationstudio.general.project.artifact.RegistryArtifact;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryCollection;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryDump;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryElement;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryItem;
import org.wso2.integrationstudio.gmf.esb.APIVersionType;
import org.wso2.integrationstudio.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.platform.ui.editor.Openable;
import org.wso2.integrationstudio.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.integrationstudio.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.integrationstudio.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.integrationstudio.platform.ui.wizard.pages.ProjectOptionsPage;
import org.wso2.integrationstudio.registry.core.utils.RegistryResourceInfo;
import org.wso2.integrationstudio.registry.core.utils.RegistryResourceInfoDoc;
import org.wso2.integrationstudio.registry.core.utils.RegistryResourceUtils;
import org.wso2.integrationstudio.utils.file.FileUtils;
import org.wso2.integrationstudio.utils.project.ProjectUtils;
import org.wso2.soaptorest.SOAPToRESTConverter;
import org.wso2.soaptorest.models.SOAPRequestElement;
import org.wso2.soaptorest.models.SOAPtoRESTConversionData;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

/**
 * WSO2 ESB API creation wizard class
 */
public class SynapseAPICreationWizard extends AbstractWSO2ProjectCreationWizard {

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Synapse API";
    private static final String DIR_DOT_METADATA = ".metadata";
    private static final String DIR_SOAPTOREST= "SoapToREST";
    private static final String IF_PLACEHOLDER = "ifPlaceholder";
    private static final String FREEMARKER_IF = "#if";
    private static final String QUESTION_MARK_PLACEHOLDER = "questionPlaceholder";
    private static final String ATTRIBUTE_REGEX = "attributePlaceholder=\"(.*?)\"";
    
    
    private final APIArtifactModel artifactModel;
    private IFile artifactFile;
    private ESBProjectArtifact esbProjectArtifact;
    private IProject esbProject;
    private List<File> fileLst = new ArrayList<File>();
    private static final int REGISTRY_RESOURCE = 0;
    private static final int REGISTRY_COLLECTION = 1;
    private static final int REGISTRY_DUMP = 2;
    private static final String EMPTY_STRING = "";
    private static final String WHITE_SPACE = " ";
    private static final String METADATA_TYPE = "synapse/metadata";
    private static final String REGISTRY_RESOURCE_PATH = "/_system/governance/swagger_files";
    private static final String SOAP_BODY_PREFIX = "<soapenv:Envelope xmlns:soapenv"
            + "=\"http://www.w3.org/2003/05/soap-envelope\">\r\n<soapenv:Header/>\r\n<soapenv:Body>\r\n";
    private static final String SOAP_BODY_POSTFIX = "</soapenv:Body>\r\n</soapenv:Envelope>\r\n";
    private String version;

    private ImportPublisherAPIWizardPage importPublisherAPIWizard;
    private APIMAPIArtifactModel aPIMAPIArtifactModel;
    private IWizardPage[] pages;

    public SynapseAPICreationWizard() {
        artifactModel = new APIArtifactModel();
        setModel(artifactModel);
        setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
        setDefaultPageImageDescriptor(APIImageUtils.getInstance().getImageDescriptor("synapseAPILarge.png"));
        
        aPIMAPIArtifactModel = new APIMAPIArtifactModel();
        importPublisherAPIWizard = new ImportPublisherAPIWizardPage(aPIMAPIArtifactModel);
    }

    @Override
    public IResource getCreatedResource() {
        return artifactFile;
    }

    @Override
    public boolean canFinish() {
        // If it is options page, cannot finish.
        if (getContainer().getCurrentPage().getTitle().equals("API Artifact Creation Options")) {
            return false;
        }
        if (getModel().getSelectedOption().equals("create.api")
                && (artifactModel.getName().equals(EMPTY_STRING) || artifactModel.getContext().equals(EMPTY_STRING))) {
            // If option to create a new API is selected,
            // can finish only if both context and name is given.
            return false;
        } else if (getModel().getSelectedOption().equals("import.api")
                && getModel().getImportFile().getName().equals(EMPTY_STRING)) {
            // If option to import artifact is selected,
            // can finish only if artifact file is selected.
            return false;
        } else if (getModel().getSelectedOption().equals("create.swagger")
                && (artifactModel.getSwaggerFile().getPath().equals(EMPTY_STRING)
                        || artifactModel.getSwaggerAPIName().equals(EMPTY_STRING)
                        || artifactModel.getSwaggerAPIName().contains(WHITE_SPACE))) {
            // If option to generate API from swagger definition is selected,
            // can finish only if swagger definition is selected.
            return false;
        } else if (getModel().getSelectedOption().equals("import.api.publisher")) {
               
            return true;
            
		} else if (getModel().getSelectedOption().equals("create.api.from.wsdl")
				&& (artifactModel.getName().equals(EMPTY_STRING)
				|| (StringUtils.isEmpty(artifactModel.getAPIWSDLurl()) && artifactModel.getAPIWSDLFile() == null))) {
			// If option to generate API from swagger definition is selected,
			// can finish only if swagger definition is selected.
			return false;
		}
        return true;
    }

    @Override
    public boolean performFinish() {
        try {
            boolean isNewArtifact = true;
            esbProject = artifactModel.getSaveLocation().getProject();
            IContainer location = esbProject.getFolder("src/main/synapse-config/api");
            IContainer endpointLocation = esbProject.getFolder("src/main/synapse-config/endpoints");
            File pomfile = esbProject.getFile("pom.xml").getLocation().toFile();
            if (!pomfile.exists()) {
                createPOM(pomfile);
            }
            version = MavenUtils.getMavenProject(pomfile).getVersion().replace("-SNAPSHOT", "");
            esbProjectArtifact = new ESBProjectArtifact();
            esbProjectArtifact.fromFile(esbProject.getFile("artifact.xml").getLocation().toFile());
            IContainer buildArtifactsLocation = esbProject.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER);
            if (!buildArtifactsLocation.exists()) {
                updatePom();
            }
            esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            String mavenGroupId = getMavenGroupId(pomfile);
            String groupId = mavenGroupId + ".api";
            String endpointGroupId = mavenGroupId + ".endpoint";
            String metadataGroupId = mavenGroupId + ".metadata";
            IContainer metadataLocation = esbProject.getFolder("src/main/resources/metadata");
            // no medatadata folder-> old project structure
            boolean meadataEnabled = metadataLocation.exists();
            RestApiAdmin restAPIAdmin = new RestApiAdmin();
            String apiFileName = null;
            String apiId = null;
            API synapseApi = null;
            if (getModel().getSelectedOption().equals("import.api")) {
                IFile api = location.getFile(new Path(getModel().getImportFile().getName()));
                if (api.exists()) {
                    if (!MessageDialog.openQuestion(getShell(), "WARNING",
                            "Do you like to override exsiting project in the workspace")) {
                        return false;
                    }
                    isNewArtifact = false;
                }
                copyImportFile(location, isNewArtifact, groupId, buildArtifactsLocation);
                if (meadataEnabled) {
                    File file = api.getLocation().toFile();
                    String fileContent = FileUtils.getContentAsString(file);
                    OMElement omElement = AXIOMUtil.stringToOM(fileContent);
                    synapseApi = APIFactory.createAPI(omElement);
                    apiFileName = api.getName().substring(0, api.getName().indexOf(".xml"));
                    String swagger = restAPIAdmin.generateSwaggerFromSynapseAPIByFormat(synapseApi, false);
                    IFile swaggerFile = metadataLocation.getFile(new Path(apiFileName + "_swagger.yaml"));
                    FileUtils.createFile(swaggerFile.getLocation().toFile(), swagger);

                    addMetadataArtifactDetails(metadataLocation, apiFileName, metadataGroupId, version, true,
                            buildArtifactsLocation);
                }
            } else if (getModel().getSelectedOption().equals("create.swagger")) {
                String apiName = artifactModel.getSwaggerAPIName();
                artifactModel.setName(apiName);
                artifactFile = location.getFile(new Path(apiName + ".xml"));
                File destFile = artifactFile.getLocation().toFile();
                String swaggerYaml = getSwaggerFileAsYAML(artifactModel.getSwaggerFile(), apiName);
                OMElement omElement = getSynapseAPIFromSwagger(swaggerYaml, apiName);
                FileUtils.createFile(destFile, omElement.toString());
                fileLst.add(destFile);

                addESBArtifactDetails(location, apiName, groupId, version, null, esbProjectArtifact,
                        buildArtifactsLocation);

                // Copy swagger file to the registry
                if (artifactModel.getSwaggerRegistryLocation() != null
                        && artifactModel.getSwaggerRegistryLocation().exists()) {
                    createRegistryResource(artifactModel.getSwaggerRegistryLocation(), artifactModel.getSwaggerFile(),
                            REGISTRY_RESOURCE_PATH);
                }

                if (meadataEnabled) {
                    synapseApi = APIFactory.createAPI(omElement);
                    IFile swaggerFile = metadataLocation.getFile(new Path(apiName + "_swagger.yaml"));
                    FileUtils.createFile(swaggerFile.getLocation().toFile(), swaggerYaml);

                    apiFileName = apiName;
                    addMetadataArtifactDetails(metadataLocation, apiName, metadataGroupId, version, true,
                            buildArtifactsLocation);
                }
            } else if (getModel().getSelectedOption().equals("import.api.publisher")) {
              
                apiId = aPIMAPIArtifactModel.getSelectedApiId();
                String swaggerYaml = aPIMAPIArtifactModel.getAPISwagger(
                        aPIMAPIArtifactModel.getUserName(),
                        aPIMAPIArtifactModel.getPassword(),
                        aPIMAPIArtifactModel.getApimHostUrl(),
                        aPIMAPIArtifactModel.getSelectedApiId());
                String apiName = aPIMAPIArtifactModel.getApiNameFromSwagger(swaggerYaml);
                artifactModel.setName(apiName);
                artifactFile = location.getFile(new Path(apiName + ".xml"));
                File destFile = artifactFile.getLocation().toFile();
                
                OMElement omElement = getSynapseAPIFromSwagger(swaggerYaml, apiName);
                FileUtils.createFile(destFile, omElement.toString());
                fileLst.add(destFile);

                addESBArtifactDetails(location, apiName, groupId, version, apiId, esbProjectArtifact,
                        buildArtifactsLocation);

                // Copy swagger file to the registry
                if (artifactModel.getSwaggerRegistryLocation() != null
                        && artifactModel.getSwaggerRegistryLocation().exists()) {
                    createRegistryResource(artifactModel.getSwaggerRegistryLocation(), artifactModel.getSwaggerFile(),
                            REGISTRY_RESOURCE_PATH);
                } 

                if (meadataEnabled) {
                    synapseApi = APIFactory.createAPI(omElement);
                    IFile swaggerFile = metadataLocation.getFile(new Path(apiName + "_swagger.yaml"));
                    FileUtils.createFile(swaggerFile.getLocation().toFile(), swaggerYaml);
                    apiFileName = apiName;
                    addMetadataArtifactDetails(metadataLocation, apiName, metadataGroupId, version, true,
                            buildArtifactsLocation);
                } 

            } else if (getModel().getSelectedOption().equals("create.api.from.wsdl")) {
                String apiName = artifactModel.getName();
                artifactModel.setName(apiName);
                artifactFile = location.getFile(new Path(apiName + ".xml"));
                File destFile = artifactFile.getLocation().toFile();
                SOAPtoRESTConversionData soaPtoRESTConversionData = null;
                boolean initSuccess = true;

                try {
                    if (artifactModel.getAPIWSDLType().equals(ArtifactConstants.API_TYPE_WSDL_URL)) {
                        URL url = new URL(artifactModel.getAPIWSDLurl());
                        soaPtoRESTConversionData = SOAPToRESTConverter.getSOAPtoRESTConversionData(url, apiName,
                                "1.0.0");
                    } else {
                        String wsdlFilePath = null;
                        if (artifactModel.getAPIWSDLFile().getAbsolutePath().endsWith(".zip")) {
                            String parentDirectoryPath = ResourcesPlugin.getWorkspace().getRoot().getLocation()
                                    .toOSString() + File.separator + DIR_DOT_METADATA + File.separator + DIR_SOAPTOREST
                                    + File.separator + apiName;
                            File outputDir = new File(parentDirectoryPath);
                            if (!outputDir.exists()) {
                                outputDir.mkdir();
                            }

                            try (ZipFile zipFile = new ZipFile(artifactModel.getAPIWSDLFile())) {
                                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                                while (entries.hasMoreElements()) {
                                    ZipEntry entry = entries.nextElement();
                                    File entryDestination = new File(outputDir, entry.getName());
                                    if (entry.isDirectory()) {
                                        entryDestination.mkdirs();
                                    } else {
                                        entryDestination.getParentFile().mkdirs();
                                        try (InputStream in = zipFile.getInputStream(entry);
                                                OutputStream out = new FileOutputStream(entryDestination)) {
                                            IOUtils.copy(in, out);
                                        }
                                    }
                                }
                            } catch (IOException e) {
                                log.error("Error while unziping wsdl zip", e);
                                initSuccess = false;
                            }

                            Collection<File> foundWSDLFiles = org.apache.commons.io.FileUtils.listFiles(outputDir,
                                    new String[] { "wsdl" }, true);
                            for (File file : foundWSDLFiles) {
                                wsdlFilePath = file.getAbsolutePath();
                                // set the first found WSDL as wsdlDefinition assuming that it is the root WSDL
                                break;
                            }
                        } else {
                            wsdlFilePath = artifactModel.getAPIWSDLFile().getAbsolutePath();
                        }
                        soaPtoRESTConversionData = SOAPToRESTConverter.getSOAPtoRESTConversionData(wsdlFilePath,
                                apiName, "1.0.0");
                    }
                } catch (Exception e) {
                    log.error("Could not generate REST API from provided WSDL File", e);
                    MessageDialog.openError(getShell(), "Could not generate REST API from provided WSDL File", e.getMessage());
                    initSuccess = false;
                }

                if (initSuccess) {
                    // Create WSDL end-point
                    String synapseWSDLEndpointName = apiName + "_SOAP_ENDPOINT";
                    String synapseWSDLEndpointFileName = apiName + "_SOAP_ENDPOINT.xml";
                    
                    String endpoint = artifactModel.getApiWSDLEndpoint();
                    
                    WSDLEndpoint wsdlEndpoint = new WSDLEndpoint();
                    wsdlEndpoint.setName(synapseWSDLEndpointName);
                    //Check the user provided WSDL end-point and set default one if empty
                    if(StringUtils.isEmpty(endpoint)) {
                    	endpoint = "http://yoursoapep.com?wsdl";
                    }
                    if (!endpoint.endsWith("wsdl")) {
                        endpoint = endpoint.concat("?wsdl");
                    }
                    wsdlEndpoint.setWsdlURI(endpoint);
                    wsdlEndpoint.setServiceName(soaPtoRESTConversionData.getSoapService());
                    wsdlEndpoint.setPortName(soaPtoRESTConversionData.getSoapPort());
                    
                    EndpointDefinition endpointDefinition = new EndpointDefinition();
                    wsdlEndpoint.setDefinition(endpointDefinition);

                    IFile endpointArtifactFile = endpointLocation
                            .getFile(new Path(synapseWSDLEndpointFileName));
                    File endpointDestFile = endpointArtifactFile.getLocation().toFile();
                    FileUtils.createFile(endpointDestFile,
                            EndpointSerializer.getElementFromEndpoint(wsdlEndpoint).toString());
                    String relativePathForEP = FileUtils
                            .getRelativePath(esbProject.getLocation().toFile(),
                                    new File(endpointLocation.getLocation().toFile(), synapseWSDLEndpointFileName))
                            .replaceAll(Pattern.quote(File.separator), "/");
                    esbProjectArtifact.addESBArtifact(createArtifactForEndpoint(synapseWSDLEndpointName,
                            endpointGroupId, version, relativePathForEP));
                    createEndpointConfigBuildArtifactPom(endpointGroupId, synapseWSDLEndpointName, version,
                            synapseWSDLEndpointName, buildArtifactsLocation, relativePathForEP);

                    // Generate Synapse API from WSDL File
                    String swaggerYaml = soaPtoRESTConversionData.getOASString();
                    OMElement omElement = getSynapseAPIFromSwagger(swaggerYaml, apiName);
                    API api = APIFactory.createAPI(omElement);

                    TransformerFactory tf = TransformerFactory.newInstance();
                    Transformer transformer = tf.newTransformer();
                    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

                    Set<Entry<String, SOAPRequestElement>> soapElementEntry = soaPtoRESTConversionData.getAllSOAPRequestBodies();
                    for (Entry<String, SOAPRequestElement> requestElementEntry : soapElementEntry) {
                        SOAPRequestElement soapRequestElement = requestElementEntry.getValue();

                        Resource[] resources = api.getResources();
                        for (Resource resource : resources) {
                            String resourcePath = ((URLMappingHelper) resource.getDispatcherHelper()).getString();
                            if (resourcePath.toLowerCase().contains(requestElementEntry.getKey().toLowerCase())) {
                                StringWriter writer = new StringWriter();
                                transformer.transform(new DOMSource(soapRequestElement.getSoapRequestBody()),
                                        new StreamResult(writer));
                                String soapPayload = writer.getBuffer().toString();
                                soapPayload = soapPayload.replaceAll(IF_PLACEHOLDER, FREEMARKER_IF)
                                        .replaceAll(QUESTION_MARK_PLACEHOLDER, "?");
                                Pattern pattern = Pattern.compile(ATTRIBUTE_REGEX);
                                Matcher matcher = pattern.matcher(soapPayload);
                                soapPayload = matcher.replaceAll("$1");
                                SequenceMediator sequence = new SequenceMediator();

                                if (StringUtils.isNotBlank(soapRequestElement.getSoapAction())) {
                                    HeaderMediator headerMediator = new HeaderMediator();
                                    headerMediator.setDescription("SOAPAction");
                                    headerMediator.setScope("transport");
                                    headerMediator.setValue(soapRequestElement.getSoapAction());
                                    headerMediator.setQName(new QName("SOAPAction"));
                                    sequence.addChild(headerMediator);
                                }
                                PropertyMediator propertyMediator1 = new PropertyMediator();
                                propertyMediator1.setName("REST_URL_POSTFIX");
                                propertyMediator1.setScope("axis2");
                                propertyMediator1.setAction(PropertyMediator.ACTION_REMOVE);
                                sequence.addChild(propertyMediator1);

                                PayloadFactoryMediator payloadFactoryMediator = new PayloadFactoryMediator();
                                payloadFactoryMediator.setTemplateType("freemarker");
                                payloadFactoryMediator.setTemplateProcessor(new FreeMarkerTemplateProcessor());
                                payloadFactoryMediator.setType("xml");
                                payloadFactoryMediator.setFormat(SOAP_BODY_PREFIX + soapPayload + SOAP_BODY_POSTFIX);
                                sequence.addChild(payloadFactoryMediator);

                                PropertyMediator propertyMediator2 = new PropertyMediator();
                                propertyMediator2.setName("messageType");
                                propertyMediator2.setScope("axis2");
                                propertyMediator2.setValue("application/soap+xml", "STRING");
                                sequence.addChild(propertyMediator2);

                                IndirectEndpoint indirectEndpoint = new IndirectEndpoint();
                                indirectEndpoint.setKey(synapseWSDLEndpointName);

                                CallMediator callMediator = new CallMediator();
                                callMediator.setEndpoint(indirectEndpoint);
                                sequence.addChild(callMediator);

                                PropertyMediator propertyMediator3 = new PropertyMediator();
                                propertyMediator3.setName("messageType");
                                propertyMediator3.setScope("axis2");
                                propertyMediator3.setValue("application/json", "STRING");
                                sequence.addChild(propertyMediator3);

                                RespondMediator respondMediator = new RespondMediator();
                                sequence.addChild(respondMediator);
                                resource.setInSequence(sequence);

                                resource.setOutSequence(new SequenceMediator());
                            }
                        }
                    }

                    FileUtils.createFile(destFile, APISerializer.serializeAPI(api).toString());
                    fileLst.add(destFile);

                    addESBArtifactDetails(location, apiName, groupId, version, null, esbProjectArtifact,
                            buildArtifactsLocation);

                    if (meadataEnabled) {
                        synapseApi = APIFactory.createAPI(omElement);
                        IFile swaggerFile = metadataLocation.getFile(new Path(apiName + "_swagger.yaml"));
                        FileUtils.createFile(swaggerFile.getLocation().toFile(), swaggerYaml);
                        apiFileName = apiName;
                        addMetadataArtifactDetails(metadataLocation, apiName, metadataGroupId, version, true,
                                buildArtifactsLocation);
                    }
                }
            } else {
                String resolvedArtifactName = artifactModel.getName();
                if (artifactModel.getVersion() != "") {
                    artifactFile = location
                            .getFile(new Path(artifactModel.getName() + "_" + artifactModel.getVersion() + ".xml"));
                    resolvedArtifactName = resolvedArtifactName + "_" + artifactModel.getVersion();
                    version = artifactModel.getVersion();
                } else {
                    artifactFile = location.getFile(new Path(artifactModel.getName() + ".xml"));
                }
                File destFile = artifactFile.getLocation().toFile();
                FileUtils.createFile(destFile, getTemplateContent());
                fileLst.add(destFile);

                addESBArtifactDetails(location, resolvedArtifactName, groupId, version, null, esbProjectArtifact,
                        buildArtifactsLocation);

                if (meadataEnabled) {
                    String fileContent = FileUtils.getContentAsString(destFile);
                    OMElement omElement = AXIOMUtil.stringToOM(fileContent);
                    synapseApi = APIFactory.createAPI(omElement);
                    String swagger = restAPIAdmin.generateSwaggerFromSynapseAPIByFormat(synapseApi, false);
                    IFile swaggerFile = null;
                    if (synapseApi.getVersion() != "") {
                        swaggerFile = metadataLocation.getFile(
                                new Path(synapseApi.getAPIName() + "_" + synapseApi.getVersion() + "_swagger.yaml"));
                    } else {
                        swaggerFile = metadataLocation.getFile(new Path(synapseApi.getAPIName() + "_swagger.yaml"));
                    }
                    FileUtils.createFile(swaggerFile.getLocation().toFile(), swagger);
                    String apiName = artifactModel.getName();
                    if (artifactModel.getVersion() != "") {
                        apiName = apiName + "_" + artifactModel.getVersion();
                    }

                    addMetadataArtifactDetails(metadataLocation, apiName, metadataGroupId, version, true,
                            buildArtifactsLocation);
                    apiFileName = apiName;

                }
            }
            if (meadataEnabled) {
                // Create the metadata file and update the artifact.xml file
                MetadataUtils.createMedataFile(metadataLocation, synapseApi, apiFileName, apiId);
                addMetadataArtifactDetails(metadataLocation, apiFileName, metadataGroupId, version, false,
                        buildArtifactsLocation);
            }
            esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            for (File file : fileLst) {
                if (file.exists()) {
                    openEditor(file);
                }
            }
        } catch (SwaggerDefinitionProcessingException e) {
            MessageDialog.openError(getShell(), "Error while creating the API", e.getMessage());
        } catch (CoreException e) {
            log.error("CoreException has occurred", e);
        } catch (Exception e) {
            log.error("An unexpected error has occurred", e);
        }
        return true;
    }

    private void createMetadataArtifactEntry(IContainer metadataLocation, String apiName, String metadataGroupId,
            String metaRelativePath, boolean isSwagger) throws Exception {

        esbProjectArtifact.addESBArtifact(createArtifact(apiName + getMetadataArtifactNamePostFix(isSwagger),
                metadataGroupId, version, metaRelativePath, METADATA_TYPE, null));
        esbProjectArtifact.toFile();
    }

    private String getMetaRelativePath(IProject esbProject, IContainer metadataLocation, String apiName,
            boolean isSwagger) {
        String namePostfix = getMetadataArtifactNamePostFix(isSwagger);
        String filePathPostfix = getMetadataArtifactFilePathPostfix(namePostfix);

        return FileUtils
                .getRelativePath(esbProject.getLocation().toFile(),
                        new File(metadataLocation.getLocation().toFile(), apiName + filePathPostfix))
                .replaceAll(Pattern.quote(File.separator), "/");
    }

    private void createAPIConfigBuildArtifactPom(String groupId, String artifactId, String version, String apiName,
            IContainer buildArtifactsLocation, String relativePathToRealArtifact)
            throws BuildArtifactCreationException {
        try {
            SynapseUtils.createSynapseConfigBuildArtifactPom(groupId, artifactId, version,
                    SynapseConstants.API_CONFIG_TYPE, apiName, SynapseConstants.API_FOLDER, buildArtifactsLocation,
                    relativePathToRealArtifact);
        } catch (IOException | XmlPullParserException e) {
            throw new BuildArtifactCreationException("Error while creating the build artifacts for API config "
                    + apiName + " at " + buildArtifactsLocation.getFullPath(), e);
        }
    }

    private void createEndpointConfigBuildArtifactPom(String groupId, String artifactId, String version,
            String endpointName, IContainer buildArtifactsLocation, String relativePathToRealArtifact)
            throws BuildArtifactCreationException {
        try {
            SynapseUtils.createSynapseConfigBuildArtifactPom(groupId, artifactId, version,
                    SynapseConstants.ENDPOINT_CONFIG_TYPE, endpointName, SynapseConstants.ENDPOINT_FOLDER,
                    buildArtifactsLocation, relativePathToRealArtifact);
        } catch (IOException | XmlPullParserException e) {
            throw new BuildArtifactCreationException("Error while creating the build artifacts for API config "
                    + endpointName + " at " + buildArtifactsLocation.getFullPath(), e);
        }
    }

    private String getMetadataArtifactNamePostFix(boolean isSwagger) {
        String namePostfix = "_metadata";
        if (isSwagger) {
            namePostfix = "_swagger";
        }
        return namePostfix;
    }

    private String getMetadataArtifactFilePathPostfix(String namePostfix) {
        return namePostfix + ".yaml";
    }

    private void createMetadataArtifactPom(String groupId, String apiName, String artifactVersion,
            IContainer cappArtifactsLocation, String metaRelativePath, boolean isSwagger)
            throws IOException, XmlPullParserException {

        String artifactName = apiName + getMetadataArtifactNamePostFix(isSwagger);
        SynapseUtils.createMetadataBuildArtifactPom(groupId, artifactName, artifactVersion, METADATA_TYPE, artifactName,
                SynapseConstants.METADATA_FOLDER, cappArtifactsLocation, "../../../" + metaRelativePath);
    }

    private void addESBArtifactDetails(IContainer location, String apiName, String groupId, String version,
            String apiId, ESBProjectArtifact esbProjectArtifact, IContainer buildArtifactsLocation) throws Exception {
        String relativePath = FileUtils
                .getRelativePath(esbProject.getLocation().toFile(),
                        new File(location.getLocation().toFile(), apiName + ".xml"))
                .replaceAll(Pattern.quote(File.separator), "/");
        esbProjectArtifact.addESBArtifact(createArtifact(apiName, groupId, version, relativePath, apiId));
        esbProjectArtifact.toFile();
        createAPIConfigBuildArtifactPom(groupId, apiName, version, apiName, buildArtifactsLocation,
                "../../../" + relativePath);
    }

    private void addMetadataArtifactDetails(IContainer metadataLocation, String apiName, String groupId, String version,
            boolean isSwagger, IContainer buildArtifactsLocation) throws Exception {
        String metaRelativePath = getMetaRelativePath(esbProject, metadataLocation, apiName, isSwagger);
        createMetadataArtifactEntry(metadataLocation, apiName, groupId, metaRelativePath, isSwagger);
        createMetadataArtifactPom(groupId, apiName, version, buildArtifactsLocation, metaRelativePath, isSwagger);
    }

    private ESBArtifact createArtifact(String name, String groupId, String version, String path, String type, String apiId) {
        ESBArtifact artifact = createArtifact(name, groupId, version, path, apiId);
        if (!StringUtils.isEmpty(type)) {
            artifact.setType(type);
        }
        return artifact;
    }

    protected boolean isRequireProjectLocationSection() {
        return false;
    }

    protected boolean isRequiredWorkingSet() {
        return false;
    }

    private String getTemplateContent() {
        StringBuilder content = new StringBuilder();
        /*
         * FIXME: use template extension-point instead of hard-coding template
         * content
         */
        content.append("<api xmlns=\"http://ws.apache.org/ns/synapse\" context=\"");
        if (artifactModel.getContext().startsWith("/")) {
            content.append(artifactModel.getContext());
        } else {
            content.append("/").append(artifactModel.getContext());
        }
        content.append("\" name=\"").append(artifactModel.getName()).append("\"");
        if (!artifactModel.getPublishSwagger().equals("")) {
            content.append(" publishSwagger=\"").append(artifactModel.getPublishSwagger()).append("\"");
        }
        if (artifactModel.getHostname() != null && artifactModel.getHostname().length() > 0) {
            content.append(" hostname=\"").append(artifactModel.getHostname()).append("\"");
        }
        if (artifactModel.getPort() > 0) {
            content.append(" port=\"").append(artifactModel.getPort()).append("\"");
        }
        if (!artifactModel.getVersionType().equalsIgnoreCase(APIVersionType.NONE.getLiteral())) {
            content.append(" version-type=\"").append(artifactModel.getVersionType()).append("\" version=\"")
                    .append(artifactModel.getVersion()).append("\"");
        }
        content.append(
                ">\n<resource methods=\"GET\"><inSequence/><outSequence/><faultSequence/>" + "</resource>\n</api>");
        return content.toString();
    }

    private OMElement getSynapseAPIFromSwagger(String swaggerYaml, String apiName)
            throws SwaggerDefinitionProcessingException {
        RestApiAdmin restAPIAdmin = new RestApiAdmin();

        try {
            String generatedAPI = restAPIAdmin.generateAPIFromSwaggerByFormat(swaggerYaml, false);
            OMElement element = AXIOMUtil.stringToOM(generatedAPI);
            // Inject the publish swagger property to the synapse api artifact
            if (artifactModel.getSwaggerRegistryLocation() != null
                    && artifactModel.getSwaggerRegistryLocation().exists()) {
                OMFactory fac = OMAbstractFactory.getOMFactory();
                element.addAttribute(fac.createOMAttribute("publishSwagger",
                        fac.createOMNamespace(XMLConfigConstants.NULL_NAMESPACE, ""),
                        REGISTRY_RESOURCE_PATH + "/" + artifactModel.getSwaggerFile().getName().replaceAll(" ", "_")));
            }
            return element;
        } catch (APIException | XMLStreamException e) {
            log.error("Exception occured while generating API using swagger file", e);
            throw new SwaggerDefinitionProcessingException("Failed to generate API from the definition.", e);
        }
    }

    public void copyImportFile(IContainer importLocation, boolean isNewAritfact, String groupId,
                               IContainer buildArtifactsLocation) throws Exception {
        File importFile = getModel().getImportFile();
        File destFile = null;
        List<OMElement> selectedAPIsList = ((APIArtifactModel) getModel()).getSelectedAPIsList();
        if (selectedAPIsList != null && selectedAPIsList.size() > 0) {
            for (OMElement element : selectedAPIsList) {
                String name = element.getAttributeValue(new QName("name"));
                destFile = new File(importLocation.getLocation().toFile(), name + ".xml");
                FileUtils.createFile(destFile, element.toString());
                fileLst.add(destFile);
                if (isNewAritfact) {
                    addESBArtifactDetails(importLocation, name, groupId, version, null, esbProjectArtifact,
                            buildArtifactsLocation);
                }
            }

        } else {
            destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
            FileUtils.copy(importFile, destFile);
            fileLst.add(destFile);
            String name = importFile.getName().replaceAll(".xml$", "");
            if (isNewAritfact) {
                addESBArtifactDetails(importLocation, name, groupId, version, null, esbProjectArtifact,
                        buildArtifactsLocation);
            }
        }
        try {
            esbProjectArtifact.toFile();
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
    
    private ESBArtifact createArtifact(String name, String groupId, String version, String path, String apiId) {
        ESBArtifact artifact = new ESBArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType(SynapseConstants.API_CONFIG_TYPE);
        artifact.setServerRole("EnterpriseServiceBus");
        artifact.setGroupId(groupId);
        if (!StringUtils.isEmpty(apiId)) {
            artifact.setApiId(apiId);
        }
        artifact.setFile(path);
        return artifact;
    }
    
    private ESBArtifact createArtifactForEndpoint(String name, String groupId, String version, String path) {
        ESBArtifact artifact = new ESBArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType(SynapseConstants.ENDPOINT_CONFIG_TYPE);
        artifact.setServerRole("EnterpriseServiceBus");
        artifact.setGroupId(groupId);
        artifact.setFile(path);
        return artifact;
    }

    /**
     * Converts a given YAML content to JSON.
     * 
     * @param yamlSource yaml content
     * @return converted JSON content
     */
    public static String convertYamlToJson(String yamlSource) {
        Yaml yaml = new Yaml();
        Object object = yaml.load(yamlSource);
        return JSONValue.toJSONString(object);
    }

    public static String convertJSONtoYaml(String jsonSource) throws Exception {
        try {
            Yaml yaml = new Yaml();
            Map<String, Object> obj = yaml.load(jsonSource);
            DumperOptions options = new DumperOptions();
            options.setIndent(2);
            options.setPrettyFlow(true);
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml output = new Yaml(options);
            return output.dump(obj);
        } catch (Exception e) {
            log.error("Exception while converting json to yaml", e);
            throw new Exception(e);
        }
    }

    private String getSwaggerFileAsYAML(File swaggerFile, String apiName) {
        String swaggerContent = "";
        try {
            swaggerContent = new String(Files.readAllBytes(Paths.get(swaggerFile.getAbsolutePath())));
            if (FilenameUtils.getExtension(swaggerFile.getAbsolutePath()).equals("json")) {
                swaggerContent = convertJSONtoYaml(swaggerContent);
            }
            RestApiAdmin restAPIAdmin = new RestApiAdmin();
            swaggerContent = restAPIAdmin.updateNameInSwagger(apiName, swaggerContent);
        } catch (IOException e) {
            log.error("Exception occured while reading swagger file", e);
        } catch (APIException e) {
            log.error("Exception occured while updating swagger name", e);
        } catch (Exception e) {
            log.error("Exception occured while converting swagger JSON to YAML", e);
        }
        return swaggerContent;
    }

    /*
     * This method will create a resource inside the given registry project
     * 
     * @param regProject the registry project
     * 
     * @param importFile the file that needs to add to the registry project
     * 
     * @param registryPath the path to the resource inside the registry project
     * 
     * @return the status of the operation
     */
    public boolean createRegistryResource(IContainer regProject, File importFile, String registryPath) {
        try {
            IProject project = regProject.getProject();
            RegistryResourceInfoDoc regResInfoDoc = new RegistryResourceInfoDoc();
            String resourceFileName = importFile.getName().replaceAll(" ", "_");
            IFile resourceFile = regProject.getFile(new Path(resourceFileName));
            File destFile = resourceFile.getLocation().toFile();
            FileUtils.copy(importFile, destFile);
            RegistryResourceUtils.createMetaDataForFolder(registryPath, destFile.getParentFile());
            RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc, regProject.getLocation().toFile(),
                    registryPath);

            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            getModel().getMavenInfo().setPackageName("registry/resource");
            updatePOM(project);
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            File pomLocation = project.getFile("pom.xml").getLocation().toFile();
            String groupId = getMavenGroupId(pomLocation);
            groupId += ".resource";
            MavenProject mavenProject = MavenUtils.getMavenProject(pomLocation);
            String version = mavenProject.getVersion().replace("-SNAPSHOT", "");
            // Adding the metadata about the endpoint to the metadata store.
            GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
            generalProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());

            RegistryArtifact artifact = new RegistryArtifact();
            artifact.setName(ProjectUtils.fileNameWithExtension(resourceFileName));
            artifact.setVersion(version);
            artifact.setType("registry/resource");
            artifact.setServerRole("EnterpriseIntegrator");
            artifact.setGroupId(groupId);

            List<RegistryResourceInfo> registryResources = regResInfoDoc.getRegistryResources();
            for (RegistryResourceInfo registryResourceInfo : registryResources) {
                RegistryElement item = null;
                if (registryResourceInfo.getType() == REGISTRY_RESOURCE) {
                    item = new RegistryItem();

                    ((RegistryItem) item).setFile(registryResourceInfo.getResourceBaseRelativePath()
                            .replaceAll(Pattern.quote(File.separator), "/"));
                    ((RegistryItem) item).setMediaType(registryResourceInfo.getMediaType());
                } else if (registryResourceInfo.getType() == REGISTRY_COLLECTION) {
                    item = new RegistryCollection();
                    ((RegistryCollection) item).setDirectory(registryResourceInfo.getResourceBaseRelativePath()
                            .replaceAll(Pattern.quote(File.separator), "/"));
                } else if (registryResourceInfo.getType() == REGISTRY_DUMP) {
                    item = new RegistryDump();
                    ((RegistryDump) item).setFile(registryResourceInfo.getResourceBaseRelativePath()
                            .replaceAll(Pattern.quote(File.separator), "/"));
                }
                if (item != null) {
                    item.setPath(registryResourceInfo.getDeployPath().replaceAll("/$", ""));
                    artifact.addRegistryElement(item);
                }
            }
            generalProjectArtifact.addArtifact(artifact);
            generalProjectArtifact.toFile();

            SynapseUtils.createRegsitryResourceBuildArtifactPom(groupId,
                    ProjectUtils.fileNameWithoutExtension(resourceFileName), version,
                    SynapseConstants.REGISTRY_RESOURCE_TYPE, ProjectUtils.fileNameWithoutExtension(resourceFileName),
                    SynapseConstants.REGISTRY_RESOURCE_FOLDER,
                    project.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER));

            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            return true;

        } catch (IOException e) {
            log.error("Error occured while creating registry resource", e);
        } catch (CoreException e) {
            log.error("Error occured while creating registry resource", e);
        } catch (XmlPullParserException e) {
            log.error("Error occured while creating registry resource", e);
        } catch (FactoryConfigurationError e) {
            log.error("Error occured while creating registry resource", e);
        } catch (Exception e) {
            log.error("Error occured while creating registry resource", e);
        }

        return false;
    }

    private void updatePOM(IProject project) throws IOException, XmlPullParserException {
        MavenProject mavenProject;
        File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
        if (!mavenProjectPomLocation.exists()) {
            mavenProject = MavenUtils.createMavenProject("org.wso2.carbon." + project.getName(), project.getName(),
                    "1.0.0", "pom");
        } else {
            mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
        }

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-general-project-plugin")) {
            return;
        }

        Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-general-project-plugin",
                MavenConstants.WSO2_GENERAL_PROJECT_VERSION, true);
        PluginExecution pluginExecution;
        pluginExecution = new PluginExecution();
        pluginExecution.addGoal("copy-registry-dependencies");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId("registry");
        plugin.addExecution(pluginExecution);

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        Xpp3Dom outputLocationNode = MavenUtils.createXpp3Node(configurationNode, "outputLocation");
        outputLocationNode.setValue(SynapseConstants.BUILD_ARTIFACTS_FOLDER);
        pluginExecution.setConfiguration(configurationNode);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }

    public void updatePom() throws IOException, XmlPullParserException {
        File mavenProjectPomLocation = esbProject.getFile("pom.xml").getLocation().toFile();
        MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

        // Skip changing the pom file if group ID and artifact ID are matched
        boolean apiPluginExists = MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-api-plugin");
        boolean metaPluginExists = MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven",
                "wso2-esb-metadata-plugin");
        boolean endpointPluginExists = MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven",
                "wso2-esb-endpoint-plugin");

        if (!apiPluginExists) {
            Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-api-plugin",
                    ESBMavenConstants.WSO2_ESB_API_VERSION, true);
            PluginExecution pluginExecution = new PluginExecution();
            pluginExecution.addGoal("pom-gen");
            pluginExecution.setPhase("process-resources");
            pluginExecution.setId("api");

            Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
            Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
            artifactLocationNode.setValue(".");
            Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
            typeListNode.setValue("${artifact.types}");
            pluginExecution.setConfiguration(configurationNode);
            plugin.addExecution(pluginExecution);
            MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
        }
        if (!metaPluginExists) {
            Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-metadata-plugin",
                    ESBMavenConstants.WSO2_ESB_METADATA_VERSION, true);
            PluginExecution pluginExecution = new PluginExecution();
            pluginExecution.addGoal("pom-gen");
            pluginExecution.setPhase("process-resources");
            pluginExecution.setId("metadata");

            Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
            Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
            artifactLocationNode.setValue(".");
            Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
            typeListNode.setValue("${artifact.types}");
            pluginExecution.setConfiguration(configurationNode);
            plugin.addExecution(pluginExecution);
            MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
        }
        if (!endpointPluginExists) {
            Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-endpoint-plugin",
                    ESBMavenConstants.WSO2_ESB_ENDPOINT_VERSION, true);
            PluginExecution pluginExecution = new PluginExecution();
            pluginExecution.addGoal("pom-gen");
            pluginExecution.setPhase("process-resources");
            pluginExecution.setId("endpoint");

            Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
            Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
            artifactLocationNode.setValue(".");
            Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
            typeListNode.setValue("${artifact.types}");
            pluginExecution.setConfiguration(configurationNode);
            plugin.addExecution(pluginExecution);
            MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
        }
    }

    @Override
    public void openEditor(File file) {
        try {
            refreshDistProjects();
            IFile dbsFile = ResourcesPlugin.getWorkspace().getRoot()
                    .getFileForLocation(Path.fromOSString(file.getAbsolutePath()));
            /* IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),dbsFile); */
            String path = dbsFile.getParent().getFullPath() + "/";
            String source = FileUtils.getContentAsString(file);
            Openable openable = ESBGraphicalEditor.getOpenable();
            openable.editorOpen(file.getName(), ArtifactType.API.getLiteral(), path, source);
        } catch (Exception e) {
            log.error("Cannot open the editor", e);
        }
    }

	@Override
	public void addPages() {
		super.addPages();
		aPIMAPIArtifactModel.setLocation(artifactModel.getLocation());
		addPage(importPublisherAPIWizard);
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = null;
		IWizardPage currentPage = getContainer().getCurrentPage();
		if (page instanceof ProjectOptionsPage) {
			ProjectOptionsPage projectOptionsPage = (ProjectOptionsPage) page;
			if (projectOptionsPage.getSelectedProjectOption().getId().equals("import.api.publisher")) {
				nextPage = importPublisherAPIWizard;
				importPublisherAPIWizard.initilizeText.setVisible(false);
			}
			else if (currentPage instanceof ProjectOptionsPage) {
				nextPage = super.getNextPage(page);
			}
		}
		return nextPage;
	}

}
