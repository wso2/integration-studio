/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.END_POINT__END_POINT_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.LOAD_BALANCE_END_POINT__ALGORITHM;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.LOAD_BALANCE_END_POINT__SESSION_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.LOAD_BALANCE_END_POINT__BUILD_MESSAGE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.endpoints.AddressEndpointFactory;
import org.apache.synapse.config.xml.endpoints.AddressEndpointSerializer;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.AddressEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.LoadbalanceEndpoint;
import org.apache.synapse.endpoints.dispatch.Dispatcher;
import org.apache.synapse.endpoints.dispatch.HttpSessionDispatcher;
import org.apache.synapse.endpoints.dispatch.SimpleClientSessionDispatcher;
import org.apache.synapse.endpoints.dispatch.SoapSessionDispatcher;
import org.apache.synapse.mediators.MediatorProperty;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceSessionType;
import org.wso2.developerstudio.eclipse.gmf.esb.Member;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.esb.form.editors.article.providers.ConfigureEndpointsWizard;
import org.wso2.developerstudio.esb.form.editors.article.providers.EndpointTableEntry;
import org.wso2.developerstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.LoadbalanceEndpointFormPage;

public class LoadBalanceEndpointDeserializer extends AbstractEndpointDeserializer {

    @Override
    public AbstractEndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object)
            throws DeserializerException {

        Assert.isTrue(object instanceof org.apache.synapse.endpoints.LoadbalanceEndpoint,
                "Unsupported endpoint passed in for deserialization at " + this.getClass());

        org.apache.synapse.endpoints.LoadbalanceEndpoint loadbalanceEndpoint = (org.apache.synapse.endpoints.LoadbalanceEndpoint) object;

        IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart
                || part instanceof EndpointDiagramEndpointCompartmentEditPart)
                        ? EsbElementTypes.LoadBalanceEndPoint_3656
                        : EsbElementTypes.LoadBalanceEndPoint_3613;

        org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint visualEndPoint = (org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint) DeserializerUtils.createNode(part, endpointType);
        setElementToEdit(visualEndPoint);

        if (object instanceof org.apache.synapse.endpoints.SALoadbalanceEndpoint) {
            org.apache.synapse.endpoints.SALoadbalanceEndpoint saloadbalanceEndpoint = (org.apache.synapse.endpoints.SALoadbalanceEndpoint) object;
            Long sessionTimeout = saloadbalanceEndpoint.getSessionTimeout();
            executeSetValueCommand(LOAD_BALANCE_END_POINT__SESSION_TIMEOUT, sessionTimeout);
            Dispatcher dispatcher = saloadbalanceEndpoint.getDispatcher();
            if (dispatcher instanceof SoapSessionDispatcher) {
                executeSetValueCommand(LOAD_BALANCE_END_POINT__SESSION_TYPE, LoadBalanceSessionType.SOAP);
            } else if (dispatcher instanceof HttpSessionDispatcher) {
                executeSetValueCommand(LOAD_BALANCE_END_POINT__SESSION_TYPE, LoadBalanceSessionType.TRANSPORT);
            } else if (dispatcher instanceof SimpleClientSessionDispatcher) {
                executeSetValueCommand(LOAD_BALANCE_END_POINT__SESSION_TYPE, LoadBalanceSessionType.CLIENT_ID);
            }
        }

        for (Iterator<MediatorProperty> i = loadbalanceEndpoint.getProperties().iterator(); i.hasNext();) {
            MediatorProperty next = i.next();
            EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
            property.setName(next.getName());
            property.setValue(next.getValue());
            if (next.getScope() != null) {
                property.setScope(EndPointPropertyScope.get(next.getScope().toLowerCase()));
            } else {
                property.setScope(EndPointPropertyScope.SYNAPSE);
            }
            executeAddValueCommand(visualEndPoint.getProperties(), property, false);
        }

        executeSetValueCommand(LOAD_BALANCE_END_POINT__BUILD_MESSAGE, loadbalanceEndpoint.isBuildMessageAtt());
        if (loadbalanceEndpoint.getAlgorithm() != null) {
            executeSetValueCommand(LOAD_BALANCE_END_POINT__ALGORITHM,
                loadbalanceEndpoint.getAlgorithm().getClass().getName());
        }
        if (loadbalanceEndpoint.getChildren() != null && !loadbalanceEndpoint.getChildren().isEmpty()) {
//            deserializeComplexEndpoint(loadbalanceEndpoint, part);

        } else if (loadbalanceEndpoint.getMembers() != null && !loadbalanceEndpoint.getMembers().isEmpty()) {

            for (org.apache.axis2.clustering.Member member : loadbalanceEndpoint.getMembers()) {

                Member vishualMember = EsbFactory.eINSTANCE.createMember();

                if (member.getHostName() != null && !member.getHostName().equals("")) {

                    vishualMember.setHostName(member.getHostName());
                }

                vishualMember.setHttpPort(Integer.toString(member.getHttpPort()));

                vishualMember.setHttpsPort(Integer.toString(member.getHttpsPort()));

                executeAddValueCommand(visualEndPoint.getMember(), vishualMember, false);

            }

        }
        
        AbstractEndPoint endPoint = (AbstractEndPoint) DeserializerUtils.createNode(part, endpointType);
        setElementToEdit(endPoint);
        deserializeEndpoint(loadbalanceEndpoint, endPoint);

        if (StringUtils.isNotBlank(loadbalanceEndpoint.getName())) {
            executeSetValueCommand(END_POINT__END_POINT_NAME, loadbalanceEndpoint.getName());
        }

        return endPoint;
    }

    @Override
    public void createNode(FormEditor formEditor, AbstractEndpoint endpointObject) {

        ESBFormEditor loadEPFormEditor = (ESBFormEditor) formEditor;
        EndpointFormPage endpointPage = (EndpointFormPage) loadEPFormEditor
                .getFormPageForArtifact(ArtifactType.ENDPOINT);

        LoadbalanceEndpoint endpoint = (LoadbalanceEndpoint)endpointObject;

        LoadbalanceEndpointFormPage loadEndpointPage = (LoadbalanceEndpointFormPage) endpointPage;

        setTextValue(loadEndpointPage.getEndpointName(), endpoint.getName());
        
        if (endpoint.getAlgorithm() instanceof org.apache.synapse.endpoints.algorithms.RoundRobin) {
            loadEndpointPage.getEndpointAlgorithmn().select(0);
        } else {
            loadEndpointPage.getEndpointAlgorithmn().select(1);
        }
        
        if (endpoint.isFailover()) {
            loadEndpointPage.getEndpointFailover().select(0);
        } else {
            loadEndpointPage.getEndpointFailover().select(1);
        }
        
        if (endpoint.isBuildMessageAtt()) {
            loadEndpointPage.getEndpointBuildMessage().select(0);
        } else {
            loadEndpointPage.getEndpointBuildMessage().select(1);
        }
        
        setTextValue(loadEndpointPage.getEP_Description(), endpoint.getDescription());

        if (endpoint.getProperties().size() > 0) {
            List<EndPointProperty> existingProperties = loadEndpointPage.getEndPointPropertyList();
            loadEndpointPage.setEndPointPropertyList(getProperties(endpoint, existingProperties));

        } else {
            loadEndpointPage.setEndPointPropertyList(null);
        }
        
        if (endpoint.getChildren() != null && !endpoint.getChildren().isEmpty()) {
            List<EndpointTableEntry> endpointTableEntries = new ArrayList<>();
            List<Endpoint> childern = endpoint.getChildren();
            for (int i = 0; i < childern.size(); i++) {
                Endpoint child = childern.get(i);
                if (child instanceof AddressEndpoint) {
                    AddressEndpoint addressEndpoint = (AddressEndpoint)child;
                    OMElement omElement = AddressEndpointSerializer.getElementFromEndpoint(addressEndpoint);
                    ConfigureEndpointsWizard.removeIndentations(omElement);
                    EndpointTableEntry tempEntry = new EndpointTableEntry(true, omElement.toString());
                    endpointTableEntries.add(tempEntry);
                }
            }
            loadEndpointPage.setEndpointList(endpointTableEntries);
        }
        
        
        if (endpoint.getMembers() != null && endpoint.getMembers().size() > 0) {
            List<Member> existingMembers = loadEndpointPage.getMemberList();
            loadEndpointPage.setMemberList(getMembers(endpoint, existingMembers));
        } else {
            loadEndpointPage.setMemberList(null);
        }
        super.createNode(formEditor, endpointObject);
    }

    private List<Member> getMembers(LoadbalanceEndpoint endpoint, List<Member> existingMembers) {
        List<Member> newlyAddedMembers = new ArrayList<Member>();
        List<Member> removedMembers = new ArrayList<Member>();
        List<Member> newMembers = new ArrayList<Member>();

        for (Iterator<org.apache.axis2.clustering.Member> i = endpoint.getMembers().iterator(); i.hasNext();) {
            org.apache.axis2.clustering.Member next = i.next();
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

    /**
     * Get properties
     * 
     * @param endpoint endpoint
     * @param existingProperties existing properties
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<EndPointProperty> getProperties(LoadbalanceEndpoint endpoint, List<EndPointProperty> existingProperties) {

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
        // new
        // list, DEVTOOLESB-505
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
}
