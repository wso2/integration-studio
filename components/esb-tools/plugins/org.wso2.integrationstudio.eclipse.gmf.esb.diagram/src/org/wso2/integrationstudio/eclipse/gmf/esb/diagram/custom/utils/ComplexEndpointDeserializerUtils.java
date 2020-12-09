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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.endpoints.AddressEndpointSerializer;
import org.apache.synapse.config.xml.endpoints.DefaultEndpointSerializer;
import org.apache.synapse.config.xml.endpoints.FailoverEndpointSerializer;
import org.apache.synapse.config.xml.endpoints.HTTPEndpointSerializer;
import org.apache.synapse.config.xml.endpoints.LoadbalanceEndpointSerializer;
import org.apache.synapse.config.xml.endpoints.TemplateEndpointSerializer;
import org.apache.synapse.config.xml.endpoints.WSDLEndpointSerializer;
import org.apache.synapse.endpoints.AbstractEndpoint;
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
import org.apache.synapse.mediators.MediatorProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.Member;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.esb.form.editors.article.providers.ComplexEndpointWizardUtils;
import org.wso2.integrationstudio.esb.form.editors.article.providers.EndpointTableEntry;

public class ComplexEndpointDeserializerUtils {

    public static List<EndpointTableEntry> getTableEntries(AbstractEndpoint endpoint) {

        List<EndpointTableEntry> endpointTableEntries = new ArrayList<>();
        List<Endpoint> childern = endpoint.getChildren();
        for (int i = 0; i < childern.size(); i++) {
            Endpoint child = childern.get(i);

            OMElement omElement = null;
            if (child instanceof AddressEndpoint) {
                AddressEndpoint addressEndpoint = (AddressEndpoint) child;
                omElement = AddressEndpointSerializer.getElementFromEndpoint(addressEndpoint);

            } else if (child instanceof HTTPEndpoint) {
                HTTPEndpoint httpEndpoint = (HTTPEndpoint) child;
                omElement = HTTPEndpointSerializer.getElementFromEndpoint(httpEndpoint);

            } else if (child instanceof DefaultEndpoint) {
                DefaultEndpoint defaultEndpoint = (DefaultEndpoint) child;
                omElement = DefaultEndpointSerializer.getElementFromEndpoint(defaultEndpoint);

            } else if (child instanceof WSDLEndpoint) {
                WSDLEndpoint wsdlEndpoint = (WSDLEndpoint) child;
                omElement = WSDLEndpointSerializer.getElementFromEndpoint(wsdlEndpoint);

            } else if (child instanceof LoadbalanceEndpoint) {
                LoadbalanceEndpoint lbEndpoint = (LoadbalanceEndpoint) child;
                omElement = LoadbalanceEndpointSerializer.getElementFromEndpoint(lbEndpoint);

            } else if (child instanceof RecipientListEndpoint) {
                RecipientListEndpoint rlEndpoint = (RecipientListEndpoint) child;
                omElement = LoadbalanceEndpointSerializer.getElementFromEndpoint(rlEndpoint);

            } else if (child instanceof FailoverEndpoint) {
                FailoverEndpoint foEndpoint = (FailoverEndpoint) child;
                omElement = FailoverEndpointSerializer.getElementFromEndpoint(foEndpoint);

            } else if (child instanceof IndirectEndpoint) {
                IndirectEndpoint indirectEndpoint = (IndirectEndpoint) child;
                EndpointTableEntry tempEntry = new EndpointTableEntry(false, indirectEndpoint.getKey());
                endpointTableEntries.add(tempEntry);
                
            } else if (child instanceof TemplateEndpoint) {
            	TemplateEndpoint templateEndpoint = (TemplateEndpoint) child;
            	omElement = TemplateEndpointSerializer.getElementFromEndpoint(templateEndpoint);
            }

            if (omElement != null) {
                ComplexEndpointWizardUtils.removeIndentations(omElement);
                EndpointTableEntry tempEntry = new EndpointTableEntry(true, omElement.toString());
                endpointTableEntries.add(tempEntry);
            }
        }

        return endpointTableEntries;
    }

    /**
     * Get properties
     * 
     * @param endpoint endpoint
     * @param existingProperties existing properties
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<EndPointProperty> getProperties(AbstractEndpoint endpoint,
            List<EndPointProperty> existingProperties) {

        List<EndPointProperty> newlyAddedProperties = new ArrayList<EndPointProperty>();
        List<EndPointProperty> removedProperties = new ArrayList<EndPointProperty>();
        List<EndPointProperty> newProperties = new ArrayList<EndPointProperty>();

        for (Iterator<MediatorProperty> i = endpoint.getProperties().iterator(); i.hasNext();) {
            MediatorProperty next = i.next();
            EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
            property.setName(next.getName());

            if (next.getExpression() != null) {
                property.setValueType(PropertyValueType.EXPRESSION);
                NamespacedProperty valueXPath = EsbFactory.eINSTANCE.createNamespacedProperty();
                valueXPath.setPropertyValue(next.getExpression().toString());
                Map<String, String> namespaces = (Map<String, String>) next.getExpression().getNamespaces();
                valueXPath.setNamespaces(namespaces);
                property.setValueExpression(valueXPath);
            } else if (next.getValue() != null) {
                property.setValueType(PropertyValueType.LITERAL);
                property.setValue(next.getValue());
            }

            if (next.getScope() != null) {
                property.setScope(EndPointPropertyScope.get(next.getScope().toLowerCase()));
            } else {
                property.setScope(EndPointPropertyScope.SYNAPSE);
            }

            if (existingProperties != null) {
                for (EndPointProperty propertyItem : existingProperties) {
                    // When updating the existing properties from source view, then remove the property
                    // from old list and add to new list
                    if (propertyItem.getName().equals(next.getName())) {
                        existingProperties.remove(propertyItem);
                        newlyAddedProperties.add(property);
                        break;
                    }
                }
            }
            // When adding a new property from source then add it to the new list
            if (!newlyAddedProperties.contains(property)) {
                newlyAddedProperties.add(property);
            }
        }
        // If old properties contain any property values, then remove the value and add the property to the
        // new list
        if (existingProperties != null) {
            for (EndPointProperty prop : existingProperties) {
                String value = prop.getName();
                if (StringUtils.isNotEmpty(value)) {
                    // Add the property to removed list
                    removedProperties.add(prop);
                }
            }
        }
        // First remove the removed properties from existing properties
        if (removedProperties.size() > 0) {
            existingProperties.removeAll(removedProperties);
        }
        // Adds the new properties
        if (newProperties.size() > 0) {
            newlyAddedProperties.addAll(newProperties);
        }
        // Adds the existing old properties (which didn't get updated)
        // to the new list
        if (existingProperties != null) {
            newlyAddedProperties.addAll(existingProperties);
        }
        return newlyAddedProperties;

    }

    public static List<Member> getMembers(AbstractEndpoint endpoint, List<Member> existingMembers) {
        List<Member> newlyAddedMembers = new ArrayList<Member>();
        List<Member> removedMembers = new ArrayList<Member>();
        List<Member> newMembers = new ArrayList<Member>();

        Iterator<org.apache.axis2.clustering.Member> iterator = null;
        if (endpoint instanceof LoadbalanceEndpoint) {
            iterator = ((LoadbalanceEndpoint) endpoint).getMembers().iterator();

        } else if (endpoint instanceof RecipientListEndpoint) {
            iterator = ((RecipientListEndpoint) endpoint).getMembers().iterator();
        }

        if (iterator != null) {
            while (iterator.hasNext()) {
                org.apache.axis2.clustering.Member next = iterator.next();
                Member member = EsbFactory.eINSTANCE.createMember();
                member.setHostName(next.getHostName());
                member.setHttpPort(Integer.toString(next.getHttpPort()));
                member.setHttpsPort(Integer.toString(next.getHttpsPort()));

                if (existingMembers != null) {
                    for (Member memberItem : existingMembers) {
                        if (memberItem.getHostName().equals(next.getHostName())) {
                            existingMembers.remove(memberItem);
                            newlyAddedMembers.add(member);
                            break;
                        }
                    }
                }

                if (!newlyAddedMembers.contains(member)) {
                    newlyAddedMembers.add(member);
                }
            }
        }

        if (existingMembers != null) {
            for (Member mem : existingMembers) {
                String value = mem.getHostName();
                if (StringUtils.isNotEmpty(value)) {
                    removedMembers.add(mem);
                }
            }
        }

        if (removedMembers.size() > 0) {
            existingMembers.removeAll(removedMembers);
        }

        if (newMembers.size() > 0) {
            newlyAddedMembers.addAll(newMembers);
        }

        if (existingMembers != null) {
            newlyAddedMembers.addAll(existingMembers);
        }
        return newlyAddedMembers;
    }
}
