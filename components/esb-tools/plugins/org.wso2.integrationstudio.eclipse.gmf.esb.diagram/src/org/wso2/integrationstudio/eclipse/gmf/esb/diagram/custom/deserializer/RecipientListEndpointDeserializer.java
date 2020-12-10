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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.END_POINT__END_POINT_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.RECIPIENT_LIST_END_POINT__MAX_CACHE;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.RecipientListEndpoint;
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
import org.wso2.integrationstudio.eclipse.gmf.esb.Member;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RecipientListEndpointType;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.utils.ComplexEndpointDeserializerUtils;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.RecipientListEndpointFormPage;

public class RecipientListEndpointDeserializer extends AbstractEndpointDeserializer {

    public AbstractEndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object)
            throws DeserializerException {
        Assert.isTrue(object instanceof org.apache.synapse.endpoints.RecipientListEndpoint,
                "Unsupported endpoint passed in for deserialization at " + this.getClass());

        org.apache.synapse.endpoints.RecipientListEndpoint endpoint = (org.apache.synapse.endpoints.RecipientListEndpoint) object;
        IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart
                || part instanceof EndpointDiagramEndpointCompartmentEditPart)
                        ? EsbElementTypes.RecipientListEndPoint_3696
                        : EsbElementTypes.RecipientListEndPoint_3692;
        org.wso2.integrationstudio.eclipse.gmf.esb.RecipientListEndPoint model = (org.wso2.integrationstudio.eclipse.gmf.esb.RecipientListEndPoint) DeserializerUtils
                .createNode(part, endpointType);
        setElementToEdit(model);

        for (Iterator<MediatorProperty> i = endpoint.getProperties().iterator(); i.hasNext();) {
            MediatorProperty next = i.next();
            EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
            property.setName(next.getName());
            property.setValue(next.getValue());
            if (next.getScope() != null) {
                property.setScope(EndPointPropertyScope.get(next.getScope().toLowerCase()));
            } else {
                property.setScope(EndPointPropertyScope.SYNAPSE);
            }
            executeAddValueCommand(model.getProperties(), property, false);
        }

        if (endpoint.getDynamicEnpointSet() != null) {
            if (StringUtils.isNotBlank(endpoint.getDynamicEnpointSet().getKeyValue())) {
                executeSetValueCommand(RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE, RecipientListEndpointType.VALUE);
                executeSetValueCommand(RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE,
                        endpoint.getDynamicEnpointSet().getKeyValue());
                executeSetValueCommand(RECIPIENT_LIST_END_POINT__MAX_CACHE, endpoint.getCurrentPoolSize());
            } else if (endpoint.getDynamicEnpointSet().getExpression() != null) {
                SynapsePath xpath = endpoint.getDynamicEnpointSet().getExpression();
                NamespacedProperty namespaceProp = createNamespacedProperty(xpath);
                executeSetValueCommand(RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE, RecipientListEndpointType.XPATH);
                executeSetValueCommand(RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION, namespaceProp);
                executeSetValueCommand(RECIPIENT_LIST_END_POINT__MAX_CACHE, endpoint.getCurrentPoolSize());
            }
        } else {
            executeSetValueCommand(RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE, RecipientListEndpointType.INLINE);
//            deserializeComplexEndpoint(endpoint, part);
        }

        if (StringUtils.isNotBlank(endpoint.getName())) {
            executeSetValueCommand(END_POINT__END_POINT_NAME, endpoint.getName());
        }

        return (AbstractEndPoint) endpoint;
    }

    @Override
    public void createNode(FormEditor formEditor, AbstractEndpoint endpointObject) {

        ESBFormEditor recipientListEPFormEditor = (ESBFormEditor) formEditor;
        EndpointFormPage endpointPage = (EndpointFormPage) recipientListEPFormEditor
                .getFormPageForArtifact(ArtifactType.ENDPOINT);

        RecipientListEndpoint endpoint = (RecipientListEndpoint) endpointObject;

        RecipientListEndpointFormPage recipientListEndpointPage = (RecipientListEndpointFormPage) endpointPage;

        setTextValue(recipientListEndpointPage.getEndpointName(), endpoint.getName());

        setTextValue(recipientListEndpointPage.getEP_Description(), endpoint.getDescription());

        if (endpoint.getProperties().size() > 0) {
            List<EndPointProperty> existingProperties = recipientListEndpointPage.getEndPointPropertyList();
            recipientListEndpointPage.setEndPointPropertyList(
                    ComplexEndpointDeserializerUtils.getProperties(endpoint, existingProperties));

        } else {
            recipientListEndpointPage.setEndPointPropertyList(null);
        }

        if (endpoint.getChildren() != null && !endpoint.getChildren().isEmpty()) {
            recipientListEndpointPage.setEndpointList(ComplexEndpointDeserializerUtils.getTableEntries(endpoint));
        } else {
            recipientListEndpointPage.setEndpointList(null);
        }

        if (endpoint.getMembers() != null && endpoint.getMembers().size() > 0) {
            List<Member> existingMembers = recipientListEndpointPage.getMemberList();
            recipientListEndpointPage
                    .setMemberList(ComplexEndpointDeserializerUtils.getMembers(endpoint, existingMembers));
        } else {
            recipientListEndpointPage.setMemberList(null);
        }
        super.createNode(formEditor, endpointObject);
    }
    
}
