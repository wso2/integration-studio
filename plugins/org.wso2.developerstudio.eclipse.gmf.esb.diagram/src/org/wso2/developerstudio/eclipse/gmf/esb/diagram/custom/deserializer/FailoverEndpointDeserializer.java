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
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.FAILOVER_END_POINT__BUILD_MESSAGE;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.FailoverEndpoint;
import org.apache.synapse.mediators.MediatorProperty;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.ComplexEndpointDeserializerUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.FailoverEndPointImpl;
import org.wso2.developerstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.FailoverEndpointFormPage;

public class FailoverEndpointDeserializer extends AbstractEndpointDeserializer {

    public EndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object) throws DeserializerException {
        Assert.isTrue(object instanceof org.apache.synapse.endpoints.FailoverEndpoint,
                "Unsupported endpoint passed in for deserialization at " + this.getClass());

        org.apache.synapse.endpoints.FailoverEndpoint failoverEndpoint = (org.apache.synapse.endpoints.FailoverEndpoint) object;
        IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart
                || part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.FailoverEndPoint_3649
                        : EsbElementTypes.FailoverEndPoint_3611;
        FailoverEndPoint endPoint = (FailoverEndPoint) DeserializerUtils.createNode(part, endpointType);
        setElementToEdit(endPoint);

        for (Iterator<MediatorProperty> i = failoverEndpoint.getProperties().iterator(); i.hasNext();) {
            MediatorProperty next = i.next();
            EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
            property.setName(next.getName());
            property.setValue(next.getValue());
            if (next.getScope() != null) {
                property.setScope(EndPointPropertyScope.get(next.getScope().toLowerCase()));
            } else {
                property.setScope(EndPointPropertyScope.SYNAPSE);
            }
            executeAddValueCommand(endPoint.getProperties(), property, false);
        }
        
        if (failoverEndpoint.getChildren() != null && failoverEndpoint.getChildren().size() > 0) {
            List<Endpoint> synpaseChildren = failoverEndpoint.getChildren();

            for (Endpoint synpaseChild : synpaseChildren) {

                IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(synpaseChild);
                org.wso2.developerstudio.eclipse.gmf.esb.EndPoint child = ((AbstractEndpointDeserializer) deserializer)
                        .createUIEndpoint(synpaseChild);

                TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(endPoint);
                if (domain != null) {
                    domain.getCommandStack().execute(new RecordingCommand(domain) {

                        @Override
                        protected void doExecute() {
                            endPoint.getChildren().add(child);
                        }
                    });
                } else {
                    endPoint.getChildren().add(child);
                }
            }
        }

        if (StringUtils.isNotBlank(failoverEndpoint.getName())) {
            executeSetValueCommand(END_POINT__END_POINT_NAME, failoverEndpoint.getName());
        }
        
        executeSetValueCommand(FAILOVER_END_POINT__BUILD_MESSAGE, failoverEndpoint.isBuildMessageAtt());
        
        return endPoint;
    }

    @Override
    public void createNode(FormEditor formEditor, AbstractEndpoint endpointObject) {

        ESBFormEditor failoverEPFormEditor = (ESBFormEditor) formEditor;
        EndpointFormPage endpointPage = (EndpointFormPage) failoverEPFormEditor
                .getFormPageForArtifact(ArtifactType.ENDPOINT);

        org.apache.synapse.endpoints.FailoverEndpoint endpoint = (org.apache.synapse.endpoints.FailoverEndpoint) endpointObject;

        FailoverEndpointFormPage failoverEndpointPage = (FailoverEndpointFormPage) endpointPage;

        setTextValue(failoverEndpointPage.getEndpointName(), endpoint.getName());

        if (endpoint.isBuildMessageAtt()) {
            failoverEndpointPage.getEndpointBuildMessage().select(0);
        } else {
            failoverEndpointPage.getEndpointBuildMessage().select(1);
        }

        setTextValue(failoverEndpointPage.getEP_Description(), endpoint.getDescription());

        if (endpoint.getProperties().size() > 0) {
            List<EndPointProperty> existingProperties = failoverEndpointPage.getEndPointPropertyList();
            failoverEndpointPage.setEndPointPropertyList(
                    ComplexEndpointDeserializerUtils.getProperties((AbstractEndpoint) endpoint, existingProperties));

        } else {
            failoverEndpointPage.setEndPointPropertyList(null);
        }

        if (endpoint.getChildren() != null && !endpoint.getChildren().isEmpty()) {
            failoverEndpointPage
                    .setEndpointList(ComplexEndpointDeserializerUtils.getTableEntries((AbstractEndpoint) endpoint));
        } else {
            failoverEndpointPage.setEndpointList(null);
        }

        super.createNode(formEditor, endpointObject);
    }
    
    public org.wso2.developerstudio.eclipse.gmf.esb.EndPoint createUIEndpoint(Endpoint synapseEndpoint) {
        Assert.isTrue(synapseEndpoint instanceof org.apache.synapse.endpoints.FailoverEndpoint,
                "Unsupported endpoint has been passed to create the UI object at " + this.getClass());

        org.wso2.developerstudio.eclipse.gmf.esb.EndPoint endpoint = new FailoverEndPointImpl();

        FailoverEndpoint failoverEndpoint = (FailoverEndpoint) synapseEndpoint;

        if (failoverEndpoint.getChildren() != null && failoverEndpoint.getChildren().size() > 0) {
            List<Endpoint> synpaseChildren = failoverEndpoint.getChildren();

            for (Endpoint synpaseChild : synpaseChildren) {

                IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(synpaseChild);
                org.wso2.developerstudio.eclipse.gmf.esb.EndPoint child = ((AbstractEndpointDeserializer) deserializer)
                        .createUIEndpoint(synpaseChild);

                TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(((FailoverEndPointImpl) endpoint));
                if (domain != null) {
                    domain.getCommandStack().execute(new RecordingCommand(domain) {

                        @Override
                        protected void doExecute() {
                        	((FailoverEndPointImpl) endpoint).getChildren().add(child);
                        }
                    });
                } else {
                	((FailoverEndPointImpl) endpoint).getChildren().add(child);
                }
            }
        }

        return endpoint;
    }

}
