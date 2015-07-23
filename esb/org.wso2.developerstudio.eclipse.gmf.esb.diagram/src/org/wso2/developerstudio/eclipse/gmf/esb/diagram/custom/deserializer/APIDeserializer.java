/*
 * Copyright 2012-2015 WSO2, Inc. (http://wso2.com)
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

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.rest.API;
import org.apache.synapse.rest.Handler;
import org.apache.synapse.rest.Resource;
import org.apache.synapse.rest.dispatch.DispatcherHelper;
import org.apache.synapse.rest.dispatch.URITemplateHelper;
import org.apache.synapse.rest.dispatch.URLMappingHelper;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.APIHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.APIHandlerProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ApiResourceUrlStyle;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.Protocol;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.DummyHandler;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

/**
 * Synapse API deserializer
 */
public class APIDeserializer extends AbstractEsbNodeDeserializer<API, SynapseAPI> {

	@Override
	public SynapseAPI createNode(IGraphicalEditPart part,API api) {
		SynapseAPI synapseAPI = (SynapseAPI) DeserializerUtils.createNode(part, EsbElementTypes.SynapseAPI_3668);
		setElementToEdit(synapseAPI);
		refreshEditPartMap();
		
		executeSetValueCommand(SYNAPSE_API__API_NAME, api.getAPIName());
		executeSetValueCommand(SYNAPSE_API__CONTEXT, api.getContext());
		if (api.getHost() != null) {
			executeSetValueCommand(SYNAPSE_API__HOST_NAME, api.getHost());
		}
		if (api.getPort() > 0) {
			executeSetValueCommand(SYNAPSE_API__PORT, api.getPort());
		}
		GraphicalEditPart apiCompartment = (GraphicalEditPart) getEditpart(synapseAPI).getChildren().get(0);
		Resource[] resources = api.getResources();
		
		int locationY = 0;
		
		for (int i = 0; i < resources.length; i++) {
			
			APIResource resource = (APIResource) DeserializerUtils.createNode(apiCompartment, EsbElementTypes.APIResource_3669);
			
			refreshEditPartMap();
			setElementToEdit(resource);
			
			List<String> methodList = Arrays.asList(resources[i].getMethods());
			executeSetValueCommand(API_RESOURCE__ALLOW_GET, methodList.contains("GET"));
			executeSetValueCommand(API_RESOURCE__ALLOW_POST, methodList.contains("POST"));
			executeSetValueCommand(API_RESOURCE__ALLOW_OPTIONS, methodList.contains("OPTIONS"));
			executeSetValueCommand(API_RESOURCE__ALLOW_DELETE, methodList.contains("DELETE"));
			executeSetValueCommand(API_RESOURCE__ALLOW_PUT, methodList.contains("PUT"));
			executeSetValueCommand(API_RESOURCE__ALLOW_HEAD, methodList.contains("HEAD"));
			executeSetValueCommand(API_RESOURCE__ALLOW_PATCH, methodList.contains("PATCH"));
			
			
			
			DispatcherHelper dispatcherHelper = resources[i].getDispatcherHelper();
			if(dispatcherHelper instanceof URITemplateHelper){
				URITemplateHelper helper = (URITemplateHelper) dispatcherHelper;
				executeSetValueCommand(API_RESOURCE__URL_STYLE, ApiResourceUrlStyle.URI_TEMPLATE);
				executeSetValueCommand(API_RESOURCE__URI_TEMPLATE, helper.getString());
			} else if(dispatcherHelper instanceof URLMappingHelper){
				URLMappingHelper helper = (URLMappingHelper) dispatcherHelper; 
				executeSetValueCommand(API_RESOURCE__URL_STYLE,ApiResourceUrlStyle.URL_MAPPING);
				executeSetValueCommand(API_RESOURCE__URL_MAPPING, helper.getString());
			} else{
				executeSetValueCommand(API_RESOURCE__URL_STYLE,ApiResourceUrlStyle.NONE);
			}
			
			addRootInputConnector(resource.getInputConnector());
			MediatorFlow mediatorFlow = resource.getContainer().getSequenceAndEndpointContainer().getMediatorFlow();
			GraphicalEditPart compartment = (GraphicalEditPart)((getEditpart(mediatorFlow)).getChildren().get(0));

			int protocol = resources[i].getProtocol();
			if (protocol == 2) {
				executeSetValueCommand(API_RESOURCE__PROTOCOL, Protocol.HTTPS);
			} else {
				executeSetValueCommand(API_RESOURCE__PROTOCOL, Protocol.HTTP);
			}
			
			SequenceMediator inSequence = resources[i].getInSequence();
			if(inSequence!=null){	
				setRootCompartment(compartment);
				deserializeSequence(compartment, inSequence, resource.getOutputConnector());
				setRootCompartment(null);
			} else{
				String inSequenceName = resources[i].getInSequenceKey();
				if(inSequenceName!=null){
					if(inSequenceName.startsWith("/") || inSequenceName.startsWith("conf:") || inSequenceName.startsWith("gov:")){
						resource.setInSequenceType(SequenceType.REGISTRY_REFERENCE);
						RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
						keyProperty.setKeyValue(inSequenceName);
						executeSetValueCommand(API_RESOURCE__IN_SEQUENCE_KEY, keyProperty);
					} else{
						executeSetValueCommand(API_RESOURCE__IN_SEQUENCE_TYPE, SequenceType.NAMED_REFERENCE);
						executeSetValueCommand(API_RESOURCE__IN_SEQUENCE_NAME, inSequenceName);
					}
				}
			}
			
			SequenceMediator outSequence = resources[i].getOutSequence();
			if(outSequence!=null){
				setRootCompartment(compartment);
				deserializeSequence(compartment, outSequence, resource.getInputConnector());
				setRootCompartment(null);
			} else{
				String outSequenceName = resources[i].getOutSequenceKey();
				if(outSequenceName!=null){
					if(outSequenceName.startsWith("/") || outSequenceName.startsWith("conf:") || outSequenceName.startsWith("gov:")){
						resource.setOutSequenceType(SequenceType.REGISTRY_REFERENCE);
						RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
						keyProperty.setKeyValue(outSequenceName);
						executeSetValueCommand(API_RESOURCE__OUT_SEQUENCE_KEY, keyProperty);
					} else{
						executeSetValueCommand(API_RESOURCE__OUT_SEQUENCE_TYPE, SequenceType.NAMED_REFERENCE);
						executeSetValueCommand(API_RESOURCE__OUT_SEQUENCE_NAME, outSequenceName);
					}
				}
			}
			
			SequenceMediator faultSequence = resources[i].getFaultSequence();
			if(faultSequence!=null){
				MediatorFlow faultMediatorFlow = resource.getContainer().getFaultContainer().getMediatorFlow();
				GraphicalEditPart faultCompartment = (GraphicalEditPart)((getEditpart(faultMediatorFlow)).getChildren().get(0));
				setRootCompartment(faultCompartment);
				deserializeSequence(faultCompartment, faultSequence, resource.getFaultInputConnector());
				setRootCompartment(null);
			} else{
				String faultSequenceName = resources[i].getFaultSequenceKey();
				if(faultSequenceName!=null){
					if(faultSequenceName.startsWith("/") || faultSequenceName.startsWith("conf:") || faultSequenceName.startsWith("gov:")){
						resource.setFaultSequenceType(SequenceType.REGISTRY_REFERENCE);
						RegistryKeyProperty keyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
						keyProperty.setKeyValue(faultSequenceName);
						executeSetValueCommand(API_RESOURCE__FAULT_SEQUENCE_KEY, keyProperty);
					} else{
						executeSetValueCommand(API_RESOURCE__FAULT_SEQUENCE_TYPE, SequenceType.NAMED_REFERENCE);
						executeSetValueCommand(API_RESOURCE__FAULT_SEQUENCE_NAME, faultSequenceName);
					}
				}
			}
			
			addPairMediatorFlow(resource.getOutputConnector(),resource.getInputConnector());
			
			IGraphicalEditPart graphicalNode = (IGraphicalEditPart) AbstractEsbNodeDeserializer.getEditpart(resource);
			if(graphicalNode!=null){
				Rectangle rect = new Rectangle(new Point(), graphicalNode.getFigure().getPreferredSize()).getCopy();
				rect.x = 0;
				rect.y = locationY;
				SetBoundsCommand sbc = new SetBoundsCommand(graphicalNode.getEditingDomain(),
						"change location", new EObjectAdapter((View) graphicalNode.getModel()), rect);
				graphicalNode.getDiagramEditDomain().getDiagramCommandStack()
						.execute(new ICommandProxy(sbc));
				locationY += rect.height; 
				locationY += 25;
			}
		}
		
		for(Handler handler : api.getHandlers()) {
			APIHandler apiHandler = EsbFactory.eINSTANCE.createAPIHandler();			

			if(handler instanceof DummyHandler) {
				DummyHandler dummyHandler = (DummyHandler) handler;
				apiHandler.setClassName(dummyHandler.getClassName());
			} else {
				apiHandler.setClassName(handler.getClass().getName());
			}
				
			Iterator itr = handler.getProperties().keySet().iterator();
			while (itr.hasNext()) {
				APIHandlerProperty handlerProperty = EsbFactory.eINSTANCE.createAPIHandlerProperty();
				String propertyName = (String) itr.next();
				handlerProperty.setName(propertyName);
				handlerProperty.setValue((String)handler.getProperties().get(propertyName));
				apiHandler.getProperties().add(handlerProperty);
				
			}
			executeAddValueCommand(synapseAPI.getHandlers(),apiHandler);
		}
		
		return synapseAPI;
	}

}
