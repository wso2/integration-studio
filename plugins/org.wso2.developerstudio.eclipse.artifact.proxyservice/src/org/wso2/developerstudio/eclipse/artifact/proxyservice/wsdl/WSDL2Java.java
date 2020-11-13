/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.proxyservice.wsdl;

import com.ibm.wsdl.BindingImpl;
import com.ibm.wsdl.BindingOperationImpl;
import org.apache.axis2.util.XMLUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class WSDL2Java {
    private static final String QNAME_ACTION = "Action";

    /**
     * Retrieves the WSDL from the given URL, parse and get the WSDL definitions
     *
     * @param wsdlUrl URL to retrieve WSDL
     * @return parsed wsdl definition
     */
    public static Definition readWSDL(String wsdlUrl)
            throws IOException, ParserConfigurationException, SAXException, WSDLException {
        URL wsdlURL = new URL(wsdlUrl);
        InputStream in = wsdlURL.openConnection().getInputStream();
        Document doc = XMLUtils.newDocument(in);
        WSDLReader reader = WSDLFactory.newInstance().newWSDLReader();
        reader.setFeature("javax.wsdl.importDocuments", true);
        return reader.readWSDL(getBaseURI(wsdlURL.toString()), doc);
    }

    /**
     * Retrieves ServiceNames from the WSDL definitions
     *
     * @param definition WSDL definitions to analyze
     * @return List of Service names found in the WSDL definition
     */
    public static List<String> getServiceNames(Definition definition) {
        Map map = definition.getAllServices();
        List<QName> serviceQnames = new ArrayList<QName>(map.keySet());
        List<String> serviceNames = new ArrayList<String>();
        for (QName qName : serviceQnames) {
            serviceNames.add(qName.getLocalPart());
        }
        return serviceNames;
    }

    /**
     * Retrieves the SoapActions listed from the Binding Operations
     *
     * @param definitions WSDL definitions to analyze
     * @return List of Operation names found in the WSDL definition
     */
    public static List<String> getBindingSoapActions(Definition definitions) {
        Set<String> soapActions = new HashSet<String>();
        if (definitions.getAllBindings() != null && definitions.getAllBindings().values() != null) {
            for (Object bindingObj : definitions.getAllBindings().values()) {
                if (bindingObj instanceof BindingImpl) {
                    BindingImpl binding = (BindingImpl) bindingObj;
                    for (Object bindingOperation : binding.getBindingOperations()) {
                        if (bindingOperation instanceof BindingOperationImpl) {
                            BindingOperationImpl bindingOp = (BindingOperationImpl) bindingOperation;
                            javax.wsdl.Input input = bindingOp.getOperation().getInput();
                            Map extensionAttr = input.getExtensionAttributes();
                            for (Object qnameObj : extensionAttr.keySet()) {
                                if (qnameObj instanceof QName) {
                                    QName qname = (QName) qnameObj;
                                    if (QNAME_ACTION.equals(qname.getLocalPart())) {
                                        Object qNameObj = extensionAttr.get(qnameObj);
                                        if (qNameObj instanceof QName) {
                                            String actionValue = ((QName) extensionAttr.get(qnameObj)).getLocalPart();
                                            if (StringUtils.isNotEmpty(actionValue)) {
                                                soapActions.add(actionValue);
                                            } ;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<String>(soapActions);
    }

    private static String getBaseURI(String currentURI) {
        try {
            File file = new File(currentURI);
            if (file.exists()) {
                return file.getCanonicalFile().getParentFile().toURI().toString();
            }
            String uriFragment = currentURI.substring(0, currentURI.lastIndexOf("/"));
            return uriFragment + (uriFragment.endsWith("/") ? "" : "/");
        } catch (IOException e) {
            return null;
        }
    }
}