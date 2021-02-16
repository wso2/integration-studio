/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.integrationstudio.general.project.artifact;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.integrationstudio.general.project.Activator;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryCollection;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryDump;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryElement;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryItem;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.core.manifest.AbstractXMLDoc;

/**
 * This class represents the .artifact.xml file which keeps the metadata of the
 * artifacts included in an registry resource project.
 * Structure of the file is as follows.
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <artifacts>
 * 	<artifact name="testEndpoint2" version="1.0.0" type="synapse/endpoint"
 * 			groupId="com.example.resource" serverRole="EnterpriseServiceBus">
 *     <item>
 *         <file>AdminService.wsdl</file>
 *         <path>/_system/config/repository/wso2con/wsdl</path>
 *         <mediaType>application/wsdl+xml</mediaType>
 *         <properties>
 *             <property key='keyValue1' value='propertyValue1'/>
 *             <property key='keyValue2' value='propertyValue2'/>
 *         </properties>
 *     </item>
 * 	</artifact>
 * 	<artifact name="testEndpoint3" version="1.0.0" type="synapse/endpoint"
 * 			groupId="com.example.resource" serverRole="EnterpriseServiceBus">
 *      <collection>
 *         <directory>emptyFolder_4</directory>
 *         <path>/_system/governance/custom/emptyFolder_4</path>
 *         <properties>
 *             <property key='keyValue1' value='propertyValue1'/>
 *             <property key='keyValue2' value='propertyValue2'/>
 *         </properties>
 *     </collection>
 * 	</artifact>
 * </artifacts>
 * 
 * Feb 15, 2021
 * 
 */
public class GeneralProjectArtifact extends RegistryInfoProvider {
    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    private List<RegistryArtifact> registryArtifacts = new ArrayList<RegistryArtifact>();
    private static final String NAME = "name";
    private static final String VERSION = "version";
    private static final String TYPE = "type";
    private static final String SERVER_ROLE = "serverRole";
    private static final String GROUP_ID = "groupId";
    private static final String ARTIFACT = "artifact";
    private static final String ARTIFACTS = "artifacts";

    protected void deserialize(OMElement documentElement) throws Exception {
        List<OMElement> artifactElements = getChildElements(documentElement, ARTIFACT);
        for (OMElement omElement : artifactElements) {
            RegistryArtifact artifact = new RegistryArtifact();
            artifact.setName(getAttribute(omElement, NAME));
            artifact.setVersion(getAttribute(omElement, VERSION));
            artifact.setType(getAttribute(omElement, TYPE));
            artifact.setServerRole(getAttribute(omElement, SERVER_ROLE));
            artifact.setGroupId(getAttribute(omElement, GROUP_ID));

            List<OMElement> itemElements = getChildElements(omElement, ITEM);

            for (OMElement omElement2 : itemElements) {
                RegistryItem item = getRegistryItem(omElement2);
                artifact.addRegistryElement(item);
            }

            List<OMElement> itemElements1 = getChildElements(omElement, COLLECTION);

            for (OMElement omElement2 : itemElements1) {
                RegistryCollection item = getRegistryCollection(omElement2);
                artifact.addRegistryElement(item);
            }
            
            List<OMElement> dumpElements = getChildElements(omElement, DUMP);
            
            for (OMElement dumpElement : dumpElements) {
                RegistryDump dump = getRegistryDump(dumpElement);
                artifact.addRegistryElement(dump);
            }
            
            registryArtifacts.add(artifact);
        }
    }

    protected String serialize() {
        String result = null;
        OMDocument document = factory.createOMDocument();
        OMElement documentElement = getDocumentElement();
        document.addChild(documentElement);
        try {
            result = getPretifiedString(documentElement);
        } catch (Exception e) {
            log.error("cannot serialize document", e);
            return null;
        }
        return result;
    }

    protected String getDefaultName() {
        return null;
    }
    
    public void addArtifact(RegistryArtifact artifact){
        registryArtifacts.add(artifact);
    }
    
    public boolean removeArtifact(RegistryArtifact artifact){
        return registryArtifacts.remove(artifact);
    }
    
    public List<RegistryArtifact> getAllArtifacts(){
        return Collections.unmodifiableList(registryArtifacts);
    }
    
    public OMElement getDocumentElement() {
        OMElement documentElement = getElement(ARTIFACTS, EMPTY_STRING);

        for (RegistryArtifact esbArtifact : registryArtifacts) {
            OMElement artifactElement = getElement(ARTIFACT, EMPTY_STRING);

            if (!esbArtifact.isAnonymous()) {
                addAttribute(artifactElement, NAME, esbArtifact.getName());
            }

            if (!esbArtifact.isAnonymous() && esbArtifact.getGroupId() != null) {
                addAttribute(artifactElement, GROUP_ID, esbArtifact.getGroupId());
            }

            if (!esbArtifact.isAnonymous() && esbArtifact.getVersion() != null) {
                addAttribute(artifactElement, VERSION, esbArtifact.getVersion());
            }

            if (esbArtifact.getType() != null) {
                addAttribute(artifactElement, TYPE, esbArtifact.getType());
            }

            if (esbArtifact.getServerRole() != null) {
                addAttribute(artifactElement, SERVER_ROLE, esbArtifact.getServerRole());
            }

            for (RegistryElement item : esbArtifact.getAllRegistryItems()) {
                OMElement element = getRegistryElementInfo(item);
                if (element != null) {
                    artifactElement.addChild(element);
                }
            }

            documentElement.addChild(artifactElement);
        }

        return documentElement;
    }
}
