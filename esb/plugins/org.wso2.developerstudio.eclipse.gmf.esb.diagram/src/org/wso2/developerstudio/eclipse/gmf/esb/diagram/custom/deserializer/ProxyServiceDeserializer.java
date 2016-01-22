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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.aspects.statistics.StatisticsConfigurable;
import org.apache.synapse.core.axis2.ProxyService;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.PolicyInfo;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServicePolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWSDLResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWsdlType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class ProxyServiceDeserializer extends AbstractEsbNodeDeserializer<ProxyService,org.wso2.developerstudio.eclipse.gmf.esb.ProxyService> {

	@Override
	public org.wso2.developerstudio.eclipse.gmf.esb.ProxyService createNode(IGraphicalEditPart editPart,ProxyService object) {
		org.wso2.developerstudio.eclipse.gmf.esb.ProxyService proxy = (org.wso2.developerstudio.eclipse.gmf.esb.ProxyService) DeserializerUtils
				.createNode(editPart, EsbElementTypes.ProxyService_3001);
		
		setElementToEdit(proxy);
		refreshEditPartMap();
		
		executeSetValueCommand(PROXY_SERVICE__NAME,object.getName());
		
		// Fixing TOOLS-2033.
		if (object.getTraceState() == 1) {
			executeSetValueCommand(PROXY_SERVICE__TRACE_ENABLED, new Boolean(true));
		} else {
			executeSetValueCommand(PROXY_SERVICE__TRACE_ENABLED, new Boolean(false));
		}
		
		//Fixing TOOLS-2735
		StatisticsConfigurable statisticsConfigurable = object.getAspectConfiguration();
		if (statisticsConfigurable != null && statisticsConfigurable.isStatisticsEnable()) {
			executeSetValueCommand(PROXY_SERVICE__STATISTICS_ENABLED, new Boolean(true));
		}else{
			executeSetValueCommand(PROXY_SERVICE__STATISTICS_ENABLED, new Boolean(false));
		}
		
		executeSetValueCommand(PROXY_SERVICE__START_ON_LOAD, object.isStartOnLoad());
		
		boolean hasPublishWsdl=true;
		
		if(object.getWsdlURI()!=null){
			executeSetValueCommand(PROXY_SERVICE__WSDL_TYPE, ProxyWsdlType.SOURCE_URL);
			executeSetValueCommand(PROXY_SERVICE__WSDL_URL, object.getWsdlURI().toString());
		}else if(object.getWSDLKey()!=null){
			executeSetValueCommand(PROXY_SERVICE__WSDL_TYPE, ProxyWsdlType.REGISTRY_KEY);
			RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			keyProperty.setKeyValue(object.getWSDLKey());
			executeSetValueCommand(PROXY_SERVICE__WSDL_KEY, keyProperty);
		}else if(object.getInLineWSDL()!=null){
			executeSetValueCommand(PROXY_SERVICE__WSDL_TYPE, ProxyWsdlType.INLINE);
			executeSetValueCommand(PROXY_SERVICE__WSDL_XML, object.getInLineWSDL().toString());
		}else if(object.getPublishWSDLEndpoint() != null){
 			executeSetValueCommand(PROXY_SERVICE__WSDL_TYPE, ProxyWsdlType.ENDPOINT);
 			RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
 			keyProperty.setKeyValue(object.getPublishWSDLEndpoint());
 			executeSetValueCommand(PROXY_SERVICE__WSDL_ENDPOINT, keyProperty);
		}else{
			executeSetValueCommand(PROXY_SERVICE__WSDL_TYPE, ProxyWsdlType.NONE);
			hasPublishWsdl=false;
		}
		
		Endpoint targetInLineEndpoint = object.getTargetInLineEndpoint();
		if(targetInLineEndpoint!=null){
			setHasInlineEndPoint(true);
		} else if(StringUtils.isNotBlank(object.getTargetEndpoint())){
			setHasInlineEndPoint(true);
		}
		
		
		if(hasPublishWsdl && object.getResourceMap()!=null){
			Map<String, String> resourcesMap = object.getResourceMap().getResources();
			EList<ProxyWSDLResource> wsdlResourceList= new BasicEList<ProxyWSDLResource>();
			for (Entry<String, String> entry : resourcesMap.entrySet()) {
				ProxyWSDLResource resource= EsbFactory.eINSTANCE.createProxyWSDLResource();
				resource.getKey().setKeyValue(entry.getValue());
				resource.setLocation(entry.getKey());
				wsdlResourceList.add(resource);
			}
			executeSetValueCommand(PROXY_SERVICE__WSDL_RESOURCES, wsdlResourceList);
		}
		
		if(object.getTransports()!=null && object.getTransports().size()>0){
			executeSetValueCommand(PROXY_SERVICE__TRANSPORTS,DeserializerUtils.join(object.getTransports(), ","));
		}
		
		if(object.getServiceGroup()!=null){
			executeSetValueCommand(PROXY_SERVICE__SERVICE_GROUP,object.getServiceGroup());
		}
		
		if(object.getPinnedServers().size()>0){
			executeSetValueCommand(PROXY_SERVICE__PINNED_SERVERS,DeserializerUtils.join(object.getPinnedServers(), ","));
		}
		
		executeSetValueCommand(PROXY_SERVICE__SECURITY_ENABLED, object.isWsSecEnabled());
		executeSetValueCommand(PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED, object.isWsRMEnabled());	
		
		EList<ProxyServiceParameter> parameters = new BasicEList<ProxyServiceParameter>();
		for (Map.Entry<String, Object> entry : object.getParameterMap().entrySet()) {
			ProxyServiceParameter parameter = EsbFactory.eINSTANCE.createProxyServiceParameter();
			parameter.setName(entry.getKey());
			parameter.setValue(entry.getValue().toString());
			parameters.add(parameter);
		}
		if(parameters.size()>0){
			executeSetValueCommand(PROXY_SERVICE__SERVICE_PARAMETERS,parameters);
		}		
		
		EList<ProxyServicePolicy> policies = new BasicEList<ProxyServicePolicy>();
		for (PolicyInfo entry : object.getPolicies()) {
			ProxyServicePolicy policy = EsbFactory.eINSTANCE.createProxyServicePolicy();
			policy.getPolicyKey().setKeyValue(entry.getPolicyKey());
			policies.add(policy);
		}
		if(policies.size()>0){
			executeSetValueCommand(PROXY_SERVICE__SERVICE_POLICIES,policies);
		}		
		
		addRootInputConnector(proxy.getInputConnector());
		MediatorFlow mediatorFlow = proxy.getContainer().getSequenceAndEndpointContainer().getMediatorFlow();
		SequenceMediator inSequence = object.getTargetInLineInSequence();
		GraphicalEditPart compartment = (GraphicalEditPart)((getEditpart(mediatorFlow)).getChildren().get(0));
		setRootCompartment(compartment);
		
		if(inSequence!=null){	
			if(StringUtils.isNotBlank(inSequence.getErrorHandler())) {
				RegistryKeyProperty inSeqOnErrorKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				inSeqOnErrorKeyProperty.setKeyValue(inSequence.getErrorHandler());
				executeSetValueCommand(PROXY_SERVICE__IN_SEQUENCE_ON_ERROR, inSeqOnErrorKeyProperty);
			}
			deserializeSequence(compartment, inSequence, proxy.getOutputConnector());
			
		} else{
			String inSequenceName = object.getTargetInSequence();
			if(inSequenceName!=null){
				if(inSequenceName.startsWith("/") || inSequenceName.startsWith("conf:") || inSequenceName.startsWith("gov:")){
					executeSetValueCommand(PROXY_SERVICE__IN_SEQUENCE_TYPE, SequenceType.REGISTRY_REFERENCE);
					RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
					keyProperty.setKeyValue(inSequenceName);
					executeSetValueCommand(PROXY_SERVICE__IN_SEQUENCE_KEY, keyProperty);
				} else{
					executeSetValueCommand(PROXY_SERVICE__IN_SEQUENCE_TYPE, SequenceType.NAMED_REFERENCE);
					executeSetValueCommand(PROXY_SERVICE__IN_SEQUENCE_NAME, inSequenceName);
				}
			}
		}
		
		/*if(object.getTargetInLineEndpoint() == null){
			String endpointName = object.getTargetEndpoint();
			if(StringUtils.isNotBlank(endpointName)){
				if(endpointName.startsWith("/") || endpointName.startsWith("conf:") || endpointName.startsWith("gov:")){
					executeSetValueCommand(PROXY_SERVICE__ENDPOINT_TYPE, SequenceType.REGISTRY_REFERENCE);
					RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
					keyProperty.setKeyValue(endpointName);
					executeSetValueCommand(PROXY_SERVICE__ENDPOINT_KEY, keyProperty);
				} else{
					executeSetValueCommand(PROXY_SERVICE__ENDPOINT_TYPE, SequenceType.NAMED_REFERENCE);
					executeSetValueCommand(PROXY_SERVICE__ENDPOINT_NAME, endpointName);
				}
			}
		}*/
		
		if (hasInlineEndPoint()) {
			if (object.getTargetEndpoint() != null) {
				IndirectEndpoint indirectEndpoint = new IndirectEndpoint();
				indirectEndpoint.setKey(object.getTargetEndpoint());
				targetInLineEndpoint = indirectEndpoint;
			}
			@SuppressWarnings("rawtypes")
			IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance()
					.getDeserializer(targetInLineEndpoint);

			if (deserializer != null) {
				LinkedList<EsbNode> connectionFlow = getConnectionFlow(proxy.getOutputConnector());
				if (connectionFlow.size() > 0 && connectionFlow.getLast() instanceof SendMediator) {
					EditPart sendMediatorFlow = getEditpart(((SendMediator)connectionFlow.getLast()).getMediatorFlow());
					@SuppressWarnings("unchecked")
					EndPoint endPointModel = (EndPoint) deserializer.createNode(
							(IGraphicalEditPart) sendMediatorFlow.getChildren().get(0),targetInLineEndpoint);
					executeSetValueCommand(endPointModel, END_POINT__IN_LINE,true);
					connectionFlow.add(endPointModel);
					
				} else{
					SendMediator sendModel = (SendMediator) DeserializerUtils.createNode(getRootCompartment(), EsbElementTypes.SendMediator_3515);
					executeSetValueCommand(sendModel, SEND_MEDIATOR__SKIP_SERIALIZATION, true);
					refreshEditPartMap();
					EditPart sendMediatorFlow=getEditpart(sendModel.getMediatorFlow());
					connectionFlow.add(sendModel);
					
					@SuppressWarnings("unchecked")
					EndPoint endPointModel = (EndPoint) deserializer.createNode(
							(IGraphicalEditPart) sendMediatorFlow.getChildren().get(0), targetInLineEndpoint);
					executeSetValueCommand(endPointModel, END_POINT__IN_LINE, true);
					connectionFlow.add(endPointModel);
				}
			
			}
		}
		
		setHasInlineEndPoint(false);
		setRootCompartment(null);	
		setAddedAddressingEndPoint(false);
		
		SequenceMediator outSequence = object.getTargetInLineOutSequence();
		if(outSequence!=null){
			setRootCompartment(compartment);
			if(StringUtils.isNotBlank(outSequence.getErrorHandler())) {
				RegistryKeyProperty outSeqOnErrorKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				outSeqOnErrorKeyProperty.setKeyValue(outSequence.getErrorHandler());
				executeSetValueCommand(PROXY_SERVICE__OUT_SEQUENCE_ON_ERROR, outSeqOnErrorKeyProperty);
			}
			deserializeSequence(compartment, outSequence, proxy.getInputConnector());
			setRootCompartment(null);
		} else{
			String outSequenceName = object.getTargetOutSequence();
			if(outSequenceName!=null){
				if(outSequenceName.startsWith("/") || outSequenceName.startsWith("conf:") || outSequenceName.startsWith("gov:")){
					executeSetValueCommand(PROXY_SERVICE__OUT_SEQUENCE_TYPE, SequenceType.REGISTRY_REFERENCE);
					RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
					keyProperty.setKeyValue(outSequenceName);
					executeSetValueCommand(PROXY_SERVICE__OUT_SEQUENCE_KEY, keyProperty);
				} else{
					executeSetValueCommand(PROXY_SERVICE__OUT_SEQUENCE_TYPE, SequenceType.NAMED_REFERENCE);
					executeSetValueCommand(PROXY_SERVICE__OUT_SEQUENCE_NAME, outSequenceName);
				}
			}
			deserializeSequence(compartment, new SequenceMediator(), proxy.getInputConnector());
		}
		
		SequenceMediator faultSequence = object.getTargetInLineFaultSequence();
		MediatorFlow faultmediatorFlow = proxy.getContainer().getFaultContainer().getMediatorFlow();
		GraphicalEditPart faultCompartment = (GraphicalEditPart)((getEditpart(faultmediatorFlow)).getChildren().get(0));
		if(faultSequence!=null){
			
			setRootCompartment(compartment);
			if(StringUtils.isNotBlank(faultSequence.getErrorHandler())) {
				RegistryKeyProperty faultSeqOnErrorKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				faultSeqOnErrorKeyProperty.setKeyValue(faultSequence.getErrorHandler());
				executeSetValueCommand(PROXY_SERVICE__FAULT_SEQUENCE_ON_ERROR, faultSeqOnErrorKeyProperty);
			}
			deserializeSequence(faultCompartment, faultSequence, proxy.getFaultInputConnector());
			setRootCompartment(null);
		} else{
			String faultSequenceName = object.getTargetFaultSequence();
			if(faultSequenceName!=null){
				if(faultSequenceName.startsWith("/") || faultSequenceName.startsWith("conf:") || faultSequenceName.startsWith("gov:")){
					executeSetValueCommand(PROXY_SERVICE__FAULT_SEQUENCE_TYPE, SequenceType.REGISTRY_REFERENCE);
					RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
					keyProperty.setKeyValue(faultSequenceName);
					executeSetValueCommand(PROXY_SERVICE__FAULT_SEQUENCE_KEY, keyProperty);
				} else{
					executeSetValueCommand(PROXY_SERVICE__FAULT_SEQUENCE_TYPE, SequenceType.NAMED_REFERENCE);
					executeSetValueCommand(PROXY_SERVICE__FAULT_SEQUENCE_NAME, faultSequenceName);
				}
			}
			deserializeSequence(faultCompartment, new SequenceMediator(), proxy.getFaultInputConnector());
		}
		
		addPairMediatorFlow(proxy.getOutputConnector(),proxy.getInputConnector());
		
		//TODO : deserialize other  properties
		
		return proxy;
	}



}
