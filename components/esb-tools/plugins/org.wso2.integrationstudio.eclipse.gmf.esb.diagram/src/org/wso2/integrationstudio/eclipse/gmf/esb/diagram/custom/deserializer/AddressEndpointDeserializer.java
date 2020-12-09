/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.ADDRESS_END_POINT__URI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.AddressEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.mediators.MediatorProperty;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.integrationstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.AddressEndPointImpl;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.AddressEndpointFormPage;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;

public class AddressEndpointDeserializer extends AbstractEndpointDeserializer {

    @Deprecated
    public AbstractEndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object) {
        Assert.isTrue(object instanceof org.apache.synapse.endpoints.AddressEndpoint,
                "Unsupported endpoint passed in for deserialization at " + this.getClass());

        org.apache.synapse.endpoints.AddressEndpoint addressEndpoint = (org.apache.synapse.endpoints.AddressEndpoint) object;
        IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart
                || part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.AddressEndPoint_3646
                        : EsbElementTypes.AddressEndPoint_3610;
        AbstractEndPoint endPoint = (AbstractEndPoint) DeserializerUtils.createNode(part, endpointType);
        setElementToEdit(endPoint);
        deserializeEndpoint(addressEndpoint, endPoint);

        if (addressEndpoint.getDefinition() != null) {
            executeSetValueCommand(ADDRESS_END_POINT__URI, addressEndpoint.getDefinition().getAddress());
        }
        executeAddAllCommand(endPoint.getCommentsList(), object.getCommentsList());

        return endPoint;
    }

    public org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint createUIEndpoint(Endpoint synapseEndpoint) {
        Assert.isTrue(synapseEndpoint instanceof org.apache.synapse.endpoints.AddressEndpoint,
                "Unsupported endpoint has been passed to create the UI object at " + this.getClass());

        org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint endpoint = new AddressEndPointImpl();

        AddressEndpoint addressEndpoint = (AddressEndpoint) synapseEndpoint;

        EndpointDefinition endpointDefinition = addressEndpoint.getDefinition();

        ((AddressEndPointImpl) endpoint).setURI(endpointDefinition.getAddress());
        ((AddressEndPointImpl) endpoint).setSuspendInitialDuration(endpointDefinition.getInitialSuspendDuration());
        ((AddressEndPointImpl) endpoint).setSuspendProgressionFactor(endpointDefinition.getSuspendProgressionFactor());

        return endpoint;
    }
    
    @Override
    public void createNode(FormEditor formEditor, AbstractEndpoint endpointObject) {

        ESBFormEditor addressEPFormEditor = (ESBFormEditor) formEditor;
        EndpointFormPage endpointPage = (EndpointFormPage) addressEPFormEditor
                .getFormPageForArtifact(ArtifactType.ENDPOINT);

        AddressEndpoint endpoint = (AddressEndpoint) endpointObject;

        AddressEndpointFormPage addressEndpointPage = (AddressEndpointFormPage) endpointPage;

        setTextValue(addressEndpointPage.getAddressEP_URI(), endpoint.getDefinition().getAddress());
        setTextValue(addressEndpointPage.getEP_Description(), endpoint.getDescription());
        deserializeEndpoint(addressEPFormEditor, endpointObject);
        addressEndpointPage.setEndpointCommentList(endpoint.getCommentsList());

        if (endpoint.getProperties().size() > 0) {
            List<EndPointProperty> existingProperties = addressEndpointPage.endpointPropertyList;
            addressEndpointPage.endpointPropertyList = getProperties(endpoint, existingProperties);

        } else {
            addressEndpointPage.endpointPropertyList = null;
        }
        super.createNode(formEditor, endpointObject);
    }

    /**
     * Get properties
     * 
     * @param endpoint endpoint
     * @param existingProperties existing properties
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<EndPointProperty> getProperties(AddressEndpoint endpoint, List<EndPointProperty> existingProperties) {

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
