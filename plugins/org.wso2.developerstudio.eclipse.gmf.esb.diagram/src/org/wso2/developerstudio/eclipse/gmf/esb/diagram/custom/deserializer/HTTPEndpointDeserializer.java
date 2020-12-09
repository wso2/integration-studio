/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__HTTP_METHOD;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__URI_TEMPLATE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.axis2.Constants;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.HTTPEndpoint;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.rest.RESTConstants;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.HttpMethodType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.HttpEndpointFormPage;

public class HTTPEndpointDeserializer extends AbstractEndpointDeserializer {

    @Deprecated
    public AbstractEndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object) {
        Assert.isTrue(object instanceof org.apache.synapse.endpoints.HTTPEndpoint,
                "Unsupported endpoint passed in for deserialization at " + this.getClass());

        org.apache.synapse.endpoints.HTTPEndpoint httpEndpoint = (org.apache.synapse.endpoints.HTTPEndpoint) object;
        IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart
                || part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.HTTPEndpoint_3712
                        : EsbElementTypes.HTTPEndpoint_3709;
        AbstractEndPoint endPoint = (AbstractEndPoint) DeserializerUtils.createNode(part, endpointType);
        setElementToEdit(endPoint);
        deserializeEndpoint(httpEndpoint, endPoint);

        if (httpEndpoint.getUriTemplate() != null) {
            executeSetValueCommand(HTTP_ENDPOINT__URI_TEMPLATE, httpEndpoint.getUriTemplate().getTemplate());
        }
        String httpMethod = httpEndpoint.getHttpMethod();
        if (httpMethod != null) {
            if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_POST)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.POST);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_GET)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.GET);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PUT)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.PUT);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_DELETE)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.DELETE);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_HEAD)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.HEAD);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PATCH)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.PATCH);
            } else if (httpMethod.equalsIgnoreCase(RESTConstants.METHOD_OPTIONS)) {
                executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.OPTIONS);
            }
        } else {
            executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.LEAVE_AS_IS);
        }
        return endPoint;
    }

    @Override
    public void createNode(FormEditor formEditor, AbstractEndpoint endpointObject) {
        ESBFormEditor addressEPFormEditor = (ESBFormEditor) formEditor;
        EndpointFormPage endpointPage = (EndpointFormPage) addressEPFormEditor
                .getFormPageForArtifact(ArtifactType.ENDPOINT);

        HTTPEndpoint endpoint = (HTTPEndpoint) endpointObject;

        HttpEndpointFormPage httpEndpointPage = (HttpEndpointFormPage) endpointPage;
        deserializeEndpoint(formEditor, endpointObject);
        // setTextValue(httpEndpointPage.httpEP_Properties, endpoint.getDefinition().get);
        setTextValue(httpEndpointPage.getEP_Description(), endpoint.getDescription());
        httpEndpointPage.setEndpointCommentList(endpoint.getCommentsList());
        if (endpoint.getUriTemplate() != null) {
            setTextValue(httpEndpointPage.httpEP_UriTemplate, endpoint.getUriTemplate().getTemplate());
        } else {
            setTextValue(httpEndpointPage.httpEP_UriTemplate, "");
        }
        String httpMethod = endpoint.getHttpMethod();
        if (httpMethod != null) {// {"LEAVE_AS_IS", "GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "PATCH"};
            if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_POST)) {
                httpEndpointPage.httpEP_Method.select(2);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_GET)) {
                httpEndpointPage.httpEP_Method.select(1);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PUT)) {
                httpEndpointPage.httpEP_Method.select(3);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_DELETE)) {
                httpEndpointPage.httpEP_Method.select(4);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_HEAD)) {
                httpEndpointPage.httpEP_Method.select(5);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PATCH)) {
                httpEndpointPage.httpEP_Method.select(7);
            } else if (httpMethod.equalsIgnoreCase(RESTConstants.METHOD_OPTIONS)) {
                httpEndpointPage.httpEP_Method.select(6);
            }
        } else {
            httpEndpointPage.httpEP_Method.select(0);
        }

        if (endpoint.getProperties().size() > 0) {
            List<EndPointProperty> existingProperties = httpEndpointPage.endpointPropertyList;
            httpEndpointPage.endpointPropertyList = getProperties(endpoint, existingProperties);

        } else {
            httpEndpointPage.endpointPropertyList = null;
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
    public List<EndPointProperty> getProperties(HTTPEndpoint endpoint, List<EndPointProperty> existingProperties) {

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
