/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.esb.core.internal.impl;

import java.io.InputStream;
import java.util.Iterator;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.AbstractXmlDocMediaTypeResolver;

public class TemplateEndpointMediaTypeResolver extends AbstractXmlDocMediaTypeResolver {

    @Override
    public boolean isMediaType(InputStream dataStream) {
        String tagName = "template";
        boolean isEndpointTemplate = false;
        try {
            OMElement root = getXmlDoc(dataStream);
            if(root.getLocalName().equals(tagName)){
                Iterator endpointElementItrtr = root.getChildrenWithLocalName("endpoint");
                isEndpointTemplate = endpointElementItrtr.hasNext(); 
            }
        } catch (Exception e) {
            isEndpointTemplate = false;
        }
        return isEndpointTemplate;
    }
}
