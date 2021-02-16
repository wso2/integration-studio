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

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryCollection;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryElement;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <resources>
 *  <item>
 *      <file>AdminService.wsdl</file>
 *      <path>/_system/config/repository/wso2con/wsdl</path>
 *      <mediaType>application/wsdl+xml</mediaType>
 *      <properties>
 *          <property key='keyValue1' value='propertyValue1'/>
 *          <property key='keyValue2' value='propertyValue2'/>
 *      </properties>
 *  </item>
 * </resources>
 * or
 * </resources>
 *  <collection>
 *      <directory>emptyFolder_4</directory>
 *       <path>/_system/governance/custom/emptyFolder_4</path>
 *      <properties>
 *          <property key='keyValue1' value='propertyValue1'/>
 *          <property key='keyValue2' value='propertyValue2'/>
 *      </properties>
 *  </collection>
 * <resources>
 * Oct 27, 2020
 *
 */
public class RegistryInfo extends RegistryInfoProvider{
    
    List<RegistryElement> registryArtifacts=new ArrayList<RegistryElement>();
    
    protected void deserialize(OMElement documentElement) throws Exception {
        List<OMElement> artifactElements = getChildElements(documentElement, ITEM);

        for (OMElement omElement : artifactElements) {
            RegistryItem item = getRegistryItem(omElement);
            registryArtifacts.add(item);
        }

        List<OMElement> itemElements1 = getChildElements(documentElement, COLLECTION);

        for (OMElement omElement2 : itemElements1) {
            RegistryCollection item = getRegistryCollection(omElement2);
            registryArtifacts.add(item);
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
            e.printStackTrace();
            return null;
        }
        return result;
    }
    
    public void addESBArtifact(RegistryItem artifact){
        registryArtifacts.add(artifact);
    }
    
    public boolean removeESBArtifact(RegistryArtifact artifact){
        return registryArtifacts.remove(artifact);
    }
    
    public List<RegistryElement> getAllESBArtifacts(){
        return Collections.unmodifiableList(registryArtifacts);
    }
    
    public OMElement getDocumentElement() {
        OMElement documentElement = getElement("resources", EMPTY_STRING);
        
//      for (RegistryElement esbArtifact : registryArtifacts) {
//              OMElement element = getElement("item", "");
//              
//              OMElement element2 = getElement("file", esbArtifact.getFile());
//              OMElement element3 = getElement("path", esbArtifact.getPath());
//
//              element.addChild(element2);
//              element.addChild(element3);
//
//              documentElement.addChild(element);
//        }
        
        for (RegistryElement item : registryArtifacts) {
            OMElement element = getRegistryElementInfo(item);
            if (element != null) {
                documentElement.addChild(element);
            }
        }
        return documentElement;
    }

}
