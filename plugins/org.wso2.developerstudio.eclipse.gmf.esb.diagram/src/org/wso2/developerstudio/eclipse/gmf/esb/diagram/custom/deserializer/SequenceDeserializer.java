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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.synapse.Mediator;
import org.apache.synapse.aspects.statistics.StatisticsConfigurable;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.apache.synapse.mediators.filters.InMediator;
import org.apache.synapse.mediators.filters.OutMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.ElementDuplicator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.TemplateTemplateCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

import org.apache.commons.lang.StringUtils;

/**
 *  Sequence mediator deserializer
 */
public class SequenceDeserializer extends AbstractEsbNodeDeserializer<SequenceMediator, EsbNode> {

	@Override
	public EsbNode createNode(IGraphicalEditPart part,SequenceMediator sequence) {
		EsbNode node = null;
		if(sequence.getKey()!=null){
			Sequence sequenceModel = (Sequence) DeserializerUtils.createNode(part, EsbElementTypes.Sequence_3503);
			setCommonProperties(sequence, sequenceModel);
			executeSetValueCommand(sequenceModel, SEQUENCE__NAME, sequence.getKey().getKeyValue());
			if (sequence.getKey().getExpression()!=null) {
								executeSetValueCommand(sequenceModel, SEQUENCE__REFERRING_SEQUENCE_TYPE, KeyType.DYNAMIC);
								NamespacedProperty namespacedProperty = createNamespacedProperty(sequence.getKey().getExpression());
								executeSetValueCommand(sequenceModel, SEQUENCE__DYNAMIC_REFERENCE_KEY,namespacedProperty);
								//executeSetValueCommand(sequenceModel, SEQUENCE__NAME, sequence.getKey().getExpression());
							}else{
								executeSetValueCommand(sequenceModel, SEQUENCE__NAME, sequence.getKey().getKeyValue());
							}
			
			node = sequenceModel;
		} else if(sequence.getName()!=null){
			if ("main".equals(sequence.getName())) {
				node = deserializeMainSequence(part,sequence);
			} else{
				setReversed(false);
				IElementType sequencesType = (part instanceof TemplateTemplateCompartmentEditPart) ? EsbElementTypes.Sequences_3665
						: EsbElementTypes.Sequences_3614;
				Sequences sequenceModel = (Sequences) DeserializerUtils.createNode(part,
						sequencesType);
				executeSetValueCommand(sequenceModel, SEQUENCES__NAME, sequence.getName());
				if(StringUtils.isNotBlank(sequence.getErrorHandler())){
					executeSetValueCommand(sequenceModel.getOnError(),
							REGISTRY_KEY_PROPERTY__KEY_VALUE, sequence.getErrorHandler());
				}
				// Fixing TOOLS-2652
				if (sequence.getTraceState() == 1) {
					executeSetValueCommand(sequenceModel,SEQUENCES__TRACE_ENABLED, new Boolean(true));
				} else {
					executeSetValueCommand(sequenceModel,SEQUENCES__TRACE_ENABLED, new Boolean(false));
				}
				
		        StatisticsConfigurable  statisticsConfigurable = sequence.getAspectConfiguration();
				if (statisticsConfigurable != null && statisticsConfigurable.isStatisticsEnable()) {
					executeSetValueCommand(sequenceModel,SEQUENCES__STATISTICS_ENABLED, new Boolean(true));
				}else{
					executeSetValueCommand(sequenceModel,SEQUENCES__STATISTICS_ENABLED, new Boolean(false));
				}
				refreshEditPartMap();
				addRootInputConnector(sequenceModel.getInputConnector());
				IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(
						sequenceModel.getMediatorFlow()).getChildren().get(0);
				setRootCompartment((GraphicalEditPart)compartment);
				deserializeSequence(compartment, sequence, sequenceModel.getOutputConnector());
				deserializeSequence(compartment, new SequenceMediator(),
						sequenceModel.getInputConnector());
				addPairMediatorFlow(sequenceModel.getOutputConnector(),
						sequenceModel.getInputConnector());
				node = sequenceModel;
			}
		} else{
			Assert.isTrue(false, "Unsupported sequence mediator configuration");
		}
		
		return node;
		
		
	}

	private ProxyService deserializeMainSequence(IGraphicalEditPart part, SequenceMediator sequence) {
		ProxyService sequenceModel = (ProxyService) DeserializerUtils.createNode(part,
				EsbElementTypes.ProxyService_3001);

		setElementToEdit(sequenceModel);
		refreshEditPartMap();
		executeSetValueCommand(PROXY_SERVICE__NAME,"main");
		executeSetValueCommand(PROXY_SERVICE__MAIN_SEQUENCE,true);
		
		addRootInputConnector(sequenceModel.getInputConnector());
		MediatorFlow mediatorFlow = sequenceModel.getContainer().getSequenceAndEndpointContainer()
				.getMediatorFlow();
		GraphicalEditPart compartment = (GraphicalEditPart) ((getEditpart(mediatorFlow))
				.getChildren().get(0));
		
		if(StringUtils.isNotBlank(sequence.getErrorHandler())){
			RegistryKeyProperty onErrorSeq = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			onErrorSeq.setKeyValue(sequence.getErrorHandler());
			executeSetValueCommand(PROXY_SERVICE__ON_ERROR, onErrorSeq);
		}

		// Fixing TOOLS-2652
		if (sequence.getTraceState() == 1) {
			executeSetValueCommand(SEQUENCES__TRACE_ENABLED, new Boolean(true));
		} else {
			executeSetValueCommand(SEQUENCES__TRACE_ENABLED, new Boolean(false));
		}
		
        StatisticsConfigurable  statisticsConfigurable = sequence.getAspectConfiguration();
		if (statisticsConfigurable != null && statisticsConfigurable.isStatisticsEnable()) {
			executeSetValueCommand(SEQUENCES__STATISTICS_ENABLED, new Boolean(true));
		}else{
			executeSetValueCommand(SEQUENCES__STATISTICS_ENABLED, new Boolean(false));
		}
		InMediator inMediator = getInMediator(sequence);
		SequenceMediator inSequence = new SequenceMediator();
		inSequence.addAll(inMediator.getList());
		setRootCompartment(compartment);
		deserializeSequence(compartment, inSequence, sequenceModel.getOutputConnector());
		setRootCompartment(null);

		OutMediator outMediator = getOutMediator(sequence);
		SequenceMediator outSequence = new SequenceMediator();
		if (outMediator.getList().size() > 0) {
			outSequence.addAll(outMediator.getList());
		}
		setRootCompartment(compartment);
		deserializeSequence(compartment, outSequence, sequenceModel.getInputConnector());
		setRootCompartment(null);
		
		addPairMediatorFlow(sequenceModel.getOutputConnector(),sequenceModel.getInputConnector());
		
		return sequenceModel;
	}
	
	private InMediator getInMediator(SequenceMediator sequence) {
		InMediator inMediator = null;
		List<Mediator> mediatorList = sequence.getList();
		for(Iterator<Mediator> i = mediatorList.iterator();i.hasNext();){
			Mediator next = i.next();
			if(next instanceof InMediator){
				inMediator = (InMediator) next;
				break;
			}
		}
		if(inMediator == null){
			inMediator = new InMediator();
		} 
		
		for(Iterator<Mediator> i = mediatorList.iterator();i.hasNext();){
			Mediator next = i.next();
			if(!(next instanceof OutMediator || next instanceof InMediator)){
				inMediator.addChild(next);
			}
		}
		
		/* TOOLS-1510
		LinkedList<Mediator> inMediatorList = new LinkedList<Mediator>(); 
		inMediatorList.addAll(inMediator.getList());
		Mediator last = null;
		if(inMediatorList.size()>0){
			last = inMediatorList.getLast();
		} 
		if (last == null || !(last instanceof SendMediator)) {
			inMediator.addChild(new SendMediator());
		}*/
		return inMediator;
	}
	
	private OutMediator getOutMediator(SequenceMediator sequence) {
		OutMediator outMediator = null;
		List<Mediator> mediatorList = sequence.getList();
		for(Iterator<Mediator> i = mediatorList.iterator();i.hasNext();){
			Mediator next = i.next();
			if(next instanceof OutMediator){
				outMediator = (OutMediator) next;
				break;
			}
		}
		if(outMediator == null){
			outMediator = new OutMediator();
		} else {
			for(Iterator<Mediator> i = mediatorList.iterator();i.hasNext();){
				Mediator next = i.next();
				if(!(next instanceof InMediator || next instanceof OutMediator)){
					outMediator.addChild(next);
				}
			}
		}
		
		/* TOOLS-1510 
		LinkedList<Mediator> outMediatorList = new LinkedList<Mediator>(); 
		outMediatorList.addAll(outMediator.getList());

		Mediator last = null;
		if(outMediatorList.size()>0){
			last = outMediatorList.getLast();
		} 
		if (last == null || !(last instanceof SendMediator)) {
			outMediator.addChild(new SendMediator());
		}*/
		return outMediator;
	}
	

	private void duplicatorEndPoints(GraphicalEditPart rootCompartment, String key) {
		FileEditorInput input = (FileEditorInput) getDiagramEditor().getEditorInput();
		ElementDuplicator duplicator = new ElementDuplicator(input.getFile().getProject());
		//duplicator.duplicateEndPoints(rootCompartment, key);
		
	}

}
