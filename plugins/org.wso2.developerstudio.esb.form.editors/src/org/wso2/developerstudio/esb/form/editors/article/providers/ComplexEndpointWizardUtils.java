/*
 * Copyright (c) 2019 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.esb.form.editors.article.providers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMText;
import org.apache.axiom.om.impl.OMNamespaceImpl;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.xml.endpoints.AddressEndpointFactory;
import org.apache.synapse.config.xml.endpoints.DefaultEndpointFactory;
import org.apache.synapse.config.xml.endpoints.FailoverEndpointFactory;
import org.apache.synapse.config.xml.endpoints.HTTPEndpointFactory;
import org.apache.synapse.config.xml.endpoints.IndirectEndpointFactory;
import org.apache.synapse.config.xml.endpoints.LoadbalanceEndpointFactory;
import org.apache.synapse.config.xml.endpoints.RecipientListEndpointFactory;
import org.apache.synapse.config.xml.endpoints.TemplateEndpointFactory;
import org.apache.synapse.config.xml.endpoints.WSDLEndpointFactory;
import org.apache.synapse.endpoints.AddressEndpoint;
import org.apache.synapse.endpoints.DefaultEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.FailoverEndpoint;
import org.apache.synapse.endpoints.HTTPEndpoint;
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.endpoints.LoadbalanceEndpoint;
import org.apache.synapse.endpoints.RecipientListEndpoint;
import org.apache.synapse.endpoints.TemplateEndpoint;
import org.apache.synapse.endpoints.WSDLEndpoint;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class ComplexEndpointWizardUtils {
    
    private final static String SYNAPSE_NS = "http://ws.apache.org/ns/synapse";
    
    public static int openMessageBox(Shell shell, String title, String message, int style) {
        MessageBox exportMsg = new MessageBox(shell, style);
        exportMsg.setText(title);
        exportMsg.setMessage(message);

        return exportMsg.open();
    }

    /**
     * Helper function to remove indentations.
     * 
     * @param element
     */
    public static void removeIndentations(OMElement element) {
        List<OMText> removables = new ArrayList<OMText>();
        removeIndentations(element, removables);
        for (OMText node : removables) {
            node.detach();
        }
    }

    /**
     * Helper function to remove indentations.
     * 
     * @param element
     * @param removables
     */
    private static void removeIndentations(OMElement element, List<OMText> removables) {

        Iterator children = element.getChildren();
        while (children.hasNext()) {
            Object next = children.next();
            if (next instanceof OMText) {
                OMText text = (OMText) next;
                if (text.getText().trim().equals("")) {
                    removables.add(text);
                }
            } else if (next instanceof OMElement) {
                removeIndentations((OMElement) next, removables);
            }
        }

    }
    
    public static void setNamespaceForChildren(OMElement omElement) {
        Iterator childern = omElement.getChildren();
        OMElement currentElement = null;
        while (childern.hasNext()) {
            Object child = childern.next();
            if (child instanceof OMElement) {
                currentElement = (OMElement) child;
                currentElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NS, ""));
                if (currentElement.getChildren().hasNext()) {
                    setNamespaceForChildren(currentElement);
                }

            }
        }
    }
    
    public static List<Endpoint> getEndpointList(List<EndpointTableEntry> endpointsList) {
        List<Endpoint> synapseEndpointList = new ArrayList<>();
        if (endpointsList != null) {
            for (int i = 0; i < endpointsList.size(); i++) {

                EndpointTableEntry endpointTableEntry = endpointsList.get(i);
                String endpointContent = endpointTableEntry.getEndpointValue();

                if (endpointTableEntry.isInline()) {
                    try {
                        OMElement element = AXIOMUtil.stringToOM(endpointContent);
                        if (element.getChildrenWithLocalName("address").hasNext()) {
                            if (!element.getChildrenWithName(new QName(SYNAPSE_NS, "address")).hasNext()) {
                                Iterator children = element.getChildrenWithLocalName("address");
                                while (children.hasNext()) {
                                    OMElement child = (OMElement) children.next();
                                    child.setNamespace(new OMNamespaceImpl(SYNAPSE_NS, ""));
                                    setNamespaceForChildren(child);
                                }
                            }

                            AddressEndpoint addressEndpoint = (AddressEndpoint) AddressEndpointFactory
                                    .getEndpointFromElement(element, false, null);
                            synapseEndpointList.add(addressEndpoint);

                        } else if (element.getChildrenWithLocalName("http").hasNext()) {
                            if (!element.getChildrenWithName(new QName(SYNAPSE_NS, "http")).hasNext()) {
                                Iterator children = element.getChildrenWithLocalName("http");
                                while (children.hasNext()) {
                                    OMElement child = (OMElement) children.next();
                                    child.setNamespace(new OMNamespaceImpl(SYNAPSE_NS, ""));
                                    setNamespaceForChildren(child);
                                }
                            }

                            HTTPEndpoint httpEndpoint = (HTTPEndpoint) HTTPEndpointFactory
                                    .getEndpointFromElement(element, false, null);
                            synapseEndpointList.add(httpEndpoint);

                        } else if (element.getChildrenWithLocalName("default").hasNext()) {
                            if (!element.getChildrenWithName(new QName(SYNAPSE_NS, "default")).hasNext()) {
                                Iterator children = element.getChildrenWithLocalName("default");
                                while (children.hasNext()) {
                                    OMElement child = (OMElement) children.next();
                                    child.setNamespace(new OMNamespaceImpl(SYNAPSE_NS, ""));
                                    setNamespaceForChildren(child);
                                }
                            }

                            DefaultEndpoint defaultEndpoint = (DefaultEndpoint) DefaultEndpointFactory
                                    .getEndpointFromElement(element, false, null);
                            synapseEndpointList.add(defaultEndpoint);

                        } else if (element.getChildrenWithLocalName("wsdl").hasNext()) {
                            if (!element.getChildrenWithName(new QName(SYNAPSE_NS, "wsdl")).hasNext()) {
                                Iterator children = element.getChildrenWithLocalName("wsdl");
                                while (children.hasNext()) {
                                    OMElement child = (OMElement) children.next();
                                    child.setNamespace(new OMNamespaceImpl(SYNAPSE_NS, ""));
                                    setNamespaceForChildren(child);
                                }
                            }

                            WSDLEndpoint wsdlEndpoint = (WSDLEndpoint) WSDLEndpointFactory
                                    .getEndpointFromElement(element, false, null);
                            synapseEndpointList.add(wsdlEndpoint);

                        } else if (element.getChildrenWithLocalName("loadbalance").hasNext()) {
                            if (!element.getChildrenWithName(new QName(SYNAPSE_NS, "loadbalance")).hasNext()) {
                                Iterator children = element.getChildrenWithLocalName("loadbalance");
                                while (children.hasNext()) {
                                    OMElement child = (OMElement) children.next();
                                    child.setNamespace(new OMNamespaceImpl(SYNAPSE_NS, ""));
                                    setNamespaceForChildren(child);
                                }
                            }

                            LoadbalanceEndpoint lbEndpoint = (LoadbalanceEndpoint) LoadbalanceEndpointFactory
                                    .getEndpointFromElement(element, false, null);
                            synapseEndpointList.add(lbEndpoint);

                        } else if (element.getChildrenWithLocalName("failover").hasNext()) {
                            if (!element.getChildrenWithName(new QName(SYNAPSE_NS, "failover")).hasNext()) {
                                Iterator children = element.getChildrenWithLocalName("failover");
                                while (children.hasNext()) {
                                    OMElement child = (OMElement) children.next();
                                    child.setNamespace(new OMNamespaceImpl(SYNAPSE_NS, ""));
                                    setNamespaceForChildren(child);
                                }
                            }

                            FailoverEndpoint foEndpoint = (FailoverEndpoint) FailoverEndpointFactory
                                    .getEndpointFromElement(element, false, null);
                            synapseEndpointList.add(foEndpoint);

                        } else if (element.getChildrenWithLocalName("recipientlist").hasNext()) {
                            if (!element.getChildrenWithName(new QName(SYNAPSE_NS, "recipientlist")).hasNext()) {
                                Iterator children = element.getChildrenWithLocalName("recipientlist");
                                while (children.hasNext()) {
                                    OMElement child = (OMElement) children.next();
                                    child.setNamespace(new OMNamespaceImpl(SYNAPSE_NS, ""));
                                    setNamespaceForChildren(child);
                                }
                            }

                            RecipientListEndpoint rlEndpoint = (RecipientListEndpoint) RecipientListEndpointFactory
                                    .getEndpointFromElement(element, false, null);
                            synapseEndpointList.add(rlEndpoint);

                        } else {
                        	if (!element.getChildrenWithName(new QName(SYNAPSE_NS, "parameter")).hasNext()) {
                                Iterator children = element.getChildrenWithLocalName("parameter");
                                while (children.hasNext()) {
                                    OMElement child = (OMElement) children.next();
                                    child.setNamespace(new OMNamespaceImpl(SYNAPSE_NS, ""));
                                    setNamespaceForChildren(child);
                                }
                            }
                        	
                        	TemplateEndpoint templateEndpoint = (TemplateEndpoint) 
                        			TemplateEndpointFactory.getEndpointFromElement(element, false, null);
                        	synapseEndpointList.add(templateEndpoint);
                        }

                    } catch (XMLStreamException e) {
                        // TODO Auto-generated catch block
                    }

                } else {
                    String endpointString = "<endpoint key=\"" + endpointContent + "\" />";
                    OMElement element = null;
                    try {
                        element = AXIOMUtil.stringToOM(endpointString);
                    } catch (XMLStreamException e) {
                        // TODO Auto-generated catch block
                    }
                    if (element != null) {
                        IndirectEndpoint indirectEndpoint = (IndirectEndpoint) IndirectEndpointFactory
                                .getEndpointFromElement(element, false, null);
                        synapseEndpointList.add(indirectEndpoint);
                    }
                }

            }
        }
        return synapseEndpointList;
    }
}
