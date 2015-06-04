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

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.dispatch.Dispatcher;
import org.apache.synapse.endpoints.dispatch.HttpSessionDispatcher;
import org.apache.synapse.endpoints.dispatch.SimpleClientSessionDispatcher;
import org.apache.synapse.endpoints.dispatch.SoapSessionDispatcher;
import org.apache.synapse.mediators.MediatorProperty;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceSessionType;
import org.wso2.developerstudio.eclipse.gmf.esb.Member;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class LoadBalanceEndpointDeserializer extends AbstractComplexEndPointDeserializer{//AbstractEsbNodeDeserializer<AbstractEndpoint, LoadBalanceEndPoint>{
	
	@Override
	public LoadBalanceEndPoint createNode(IGraphicalEditPart part,AbstractEndpoint object) {
		
		Assert.isTrue(object instanceof org.apache.synapse.endpoints.LoadbalanceEndpoint, "Unsupported endpoint passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.endpoints.LoadbalanceEndpoint loadbalanceEndpoint = (org.apache.synapse.endpoints.LoadbalanceEndpoint)object;
		
		IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart ||
				part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.LoadBalanceEndPoint_3656
				: EsbElementTypes.LoadBalanceEndPoint_3613;
		
		LoadBalanceEndPoint visualEndPoint = (LoadBalanceEndPoint) DeserializerUtils.createNode(part,endpointType);
		setElementToEdit(visualEndPoint);
		
		if(object instanceof org.apache.synapse.endpoints.SALoadbalanceEndpoint){
			org.apache.synapse.endpoints.SALoadbalanceEndpoint saloadbalanceEndpoint = (org.apache.synapse.endpoints.SALoadbalanceEndpoint)object;
			Long sessionTimeout = saloadbalanceEndpoint.getSessionTimeout();
			executeSetValueCommand(LOAD_BALANCE_END_POINT__SESSION_TIMEOUT, sessionTimeout);
			Dispatcher dispatcher = saloadbalanceEndpoint.getDispatcher();
			if(dispatcher instanceof SoapSessionDispatcher){
				executeSetValueCommand(LOAD_BALANCE_END_POINT__SESSION_TYPE, LoadBalanceSessionType.SOAP);
			}else if(dispatcher instanceof HttpSessionDispatcher){
				executeSetValueCommand(LOAD_BALANCE_END_POINT__SESSION_TYPE, LoadBalanceSessionType.TRANSPORT);
			}else if(dispatcher instanceof SimpleClientSessionDispatcher){
				executeSetValueCommand(LOAD_BALANCE_END_POINT__SESSION_TYPE, LoadBalanceSessionType.CLIENT_ID);
			}
		}
		
		for (Iterator<MediatorProperty> i = loadbalanceEndpoint.getProperties().iterator(); i.hasNext();) {
			MediatorProperty next = i.next();
			EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
			property.setName(next.getName());
			property.setValue(next.getValue());
			if(next.getScope()!=null){
				property.setScope(EndPointPropertyScope.get(next.getScope().toLowerCase()));
			} else{
				property.setScope(EndPointPropertyScope.SYNAPSE);
			}
			executeAddValueCommand(visualEndPoint.getProperties(), property);
		}
		
		executeSetValueCommand(LOAD_BALANCE_END_POINT__ALGORITHM, loadbalanceEndpoint.getAlgorithm().getClass().getName());
		if (loadbalanceEndpoint.getChildren() != null && !loadbalanceEndpoint.getChildren().isEmpty()) {
			deserializeComplexEndpoint(loadbalanceEndpoint,part);
			
		} else if (loadbalanceEndpoint.getMembers() != null && !loadbalanceEndpoint.getMembers().isEmpty()) {

			for (org.apache.axis2.clustering.Member member : loadbalanceEndpoint.getMembers()) {

				Member vishualMember = EsbFactory.eINSTANCE.createMember();
				
				if (member.getHostName() != null && !member.getHostName().equals("")) {

					vishualMember.setHostName(member.getHostName());
				}

				vishualMember.setHttpPort(Integer.toString(member.getHttpPort()));

				vishualMember.setHttpsPort(Integer.toString(member.getHttpsPort()));

				executeAddValueCommand(visualEndPoint.getMember(),vishualMember);

			}

		}
		
		if(StringUtils.isNotBlank(loadbalanceEndpoint.getName())){
            executeSetValueCommand(END_POINT__END_POINT_NAME, loadbalanceEndpoint.getName());
		}

		return visualEndPoint;
	}

}
