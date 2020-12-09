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
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.LOAD_BALANCE_END_POINT__ALGORITHM;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.LOAD_BALANCE_END_POINT__SESSION_TYPE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.LOAD_BALANCE_END_POINT__BUILD_MESSAGE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.LOAD_BALANCE_END_POINT__FAILOVER;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.LoadbalanceEndpoint;
import org.apache.synapse.endpoints.dispatch.Dispatcher;
import org.apache.synapse.endpoints.dispatch.HttpSessionDispatcher;
import org.apache.synapse.endpoints.dispatch.SimpleClientSessionDispatcher;
import org.apache.synapse.endpoints.dispatch.SoapSessionDispatcher;
import org.apache.synapse.mediators.MediatorProperty;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.integrationstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.LoadBalanceSessionType;
import org.wso2.integrationstudio.eclipse.gmf.esb.Member;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.utils.ComplexEndpointDeserializerUtils;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.LoadbalanceEndpointFormPage;

public class LoadBalanceEndpointDeserializer extends AbstractEndpointDeserializer {

    @Override
    public EndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object) throws DeserializerException {

        Assert.isTrue(object instanceof org.apache.synapse.endpoints.LoadbalanceEndpoint,
                "Unsupported endpoint passed in for deserialization at " + this.getClass());

        org.apache.synapse.endpoints.LoadbalanceEndpoint loadbalanceEndpoint = (org.apache.synapse.endpoints.LoadbalanceEndpoint) object;

        IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart
                || part instanceof EndpointDiagramEndpointCompartmentEditPart)
                        ? EsbElementTypes.LoadBalanceEndPoint_3656
                        : EsbElementTypes.LoadBalanceEndPoint_3613;
        
        
        org.wso2.integrationstudio.eclipse.gmf.esb.LoadBalanceEndPoint visualEndPoint = (org.wso2.integrationstudio.eclipse.gmf.esb.LoadBalanceEndPoint) DeserializerUtils.createNode(part, endpointType);
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
        
        executeSetValueCommand(LOAD_BALANCE_END_POINT__FAILOVER, loadbalanceEndpoint.isFailover());
        
        if (loadbalanceEndpoint.getAlgorithm() != null) {
            executeSetValueCommand(LOAD_BALANCE_END_POINT__ALGORITHM,
                loadbalanceEndpoint.getAlgorithm().getClass().getName());
        }
        
        if (loadbalanceEndpoint.getChildren() != null && !loadbalanceEndpoint.getChildren().isEmpty()) {

            List<Endpoint> synpaseChildren = loadbalanceEndpoint.getChildren();

            for (Endpoint synpaseChild : synpaseChildren) {

                IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(synpaseChild);
                org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint child = ((AbstractEndpointDeserializer) deserializer)
                        .createUIEndpoint(synpaseChild);

                TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(visualEndPoint);
                if (domain != null) {
                    domain.getCommandStack().execute(new RecordingCommand(domain) {

                        @Override
                        protected void doExecute() {
                            visualEndPoint.getChildren().add(child);
                        }
                    });
                } else {
                    visualEndPoint.getChildren().add(child);
                }
            }

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

        if (StringUtils.isNotBlank(loadbalanceEndpoint.getName())) {
            executeSetValueCommand(END_POINT__END_POINT_NAME, loadbalanceEndpoint.getName());
        }

        return visualEndPoint;
    }

    @Override
    public void createNode(FormEditor formEditor, AbstractEndpoint endpointObject) {

        ESBFormEditor loadEPFormEditor = (ESBFormEditor) formEditor;
        EndpointFormPage endpointPage = (EndpointFormPage) loadEPFormEditor
                .getFormPageForArtifact(ArtifactType.ENDPOINT);

        LoadbalanceEndpoint endpoint = (LoadbalanceEndpoint) endpointObject;

        LoadbalanceEndpointFormPage loadEndpointPage = (LoadbalanceEndpointFormPage) endpointPage;

        setTextValue(loadEndpointPage.getEndpointName(), endpoint.getName());

        if (endpoint.getAlgorithm() instanceof org.apache.synapse.endpoints.algorithms.RoundRobin) {
            loadEndpointPage.getEndpointAlgorithmn().select(0);
            
        } else if (endpoint.getAlgorithm() instanceof org.apache.synapse.endpoints.algorithms.WeightedRRLCAlgorithm) {
            loadEndpointPage.getEndpointAlgorithmn().select(1);
            
        } else if (endpoint.getAlgorithm() instanceof org.apache.synapse.endpoints.algorithms.WeightedRoundRobin) {
            loadEndpointPage.getEndpointAlgorithmn().select(2);
            
        } else {
            loadEndpointPage.getEndpointAlgorithmn().select(0);
            
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
        
        if (endpoint instanceof org.apache.synapse.endpoints.SALoadbalanceEndpoint) {
            org.apache.synapse.endpoints.SALoadbalanceEndpoint saloadbalanceEndpoint = 
                    (org.apache.synapse.endpoints.SALoadbalanceEndpoint) endpoint;
            Long sessionTimeout = saloadbalanceEndpoint.getSessionTimeout();
            Dispatcher dispatcher = saloadbalanceEndpoint.getDispatcher();
            
            if (dispatcher instanceof SoapSessionDispatcher) {
                loadEndpointPage.getEndpointSessionType().select(2);
                setTextValue(loadEndpointPage.getSessionTimeout(), sessionTimeout.toString());
                
            } else if (dispatcher instanceof HttpSessionDispatcher) {
                loadEndpointPage.getEndpointSessionType().select(1);
                setTextValue(loadEndpointPage.getSessionTimeout(), sessionTimeout.toString());
                
            } else if (dispatcher instanceof SimpleClientSessionDispatcher) {
                loadEndpointPage.getEndpointSessionType().select(3);
                setTextValue(loadEndpointPage.getSessionTimeout(), sessionTimeout.toString());
                
            } else {
                loadEndpointPage.getEndpointSessionType().select(0);
                setTextValue(loadEndpointPage.getSessionTimeout(), "");
            }
            
        } else {
            loadEndpointPage.getEndpointSessionType().select(0);
            setTextValue(loadEndpointPage.getSessionTimeout(), "");
        }

        if (endpoint.getProperties().size() > 0) {
            List<EndPointProperty> existingProperties = loadEndpointPage.getEndPointPropertyList();
            loadEndpointPage.setEndPointPropertyList(
                    ComplexEndpointDeserializerUtils.getProperties(endpoint, existingProperties));

        } else {
            loadEndpointPage.setEndPointPropertyList(null);
        }

        if (endpoint.getChildren() != null && !endpoint.getChildren().isEmpty()) {
            loadEndpointPage.setEndpointList(ComplexEndpointDeserializerUtils.getTableEntries(endpoint));
        } else {
            loadEndpointPage.setEndpointList(null);
        }

        if (endpoint.getMembers() != null && endpoint.getMembers().size() > 0) {
            List<Member> existingMembers = loadEndpointPage.getMemberList();
            loadEndpointPage.setMemberList(ComplexEndpointDeserializerUtils.getMembers(endpoint, existingMembers));
        } else {
            loadEndpointPage.setMemberList(null);
        }
        super.createNode(formEditor, endpointObject);
    }

}
