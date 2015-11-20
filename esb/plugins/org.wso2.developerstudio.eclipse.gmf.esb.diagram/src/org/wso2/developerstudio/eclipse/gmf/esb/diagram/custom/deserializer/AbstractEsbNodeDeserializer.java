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


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CommentMediator;
//import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
//import org.wso2.developerstudio.eclipse.gmf.esb.AddressingEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LogCategory;
//import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
//import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorFlowEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractSequencesEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ConnectionUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.complexFiguredAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceInSequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbLinkEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointOnErrorSequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointOnErrorSequenceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointSequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointSequenceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequencesEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequencesInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequencesOutputConnectorEditPart;
//import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequencesInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
//import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

/**
 * This class provides a skeletal implementation of the IEsbNodeDeserializer
 * interface, deserializers are used to deserialize the objects from synapse to
 * an EMF object that can be of any type that the developer wants.
 * 
 * Instances of AbstractEsbNodeDeserializer are not safe for use by multiple
 * threads and should NOT be initialized by multiple editor instances
 * 
 * @param <T>
 *            Input synapse object
 * @param <R>
 *            Return type of createNode()
 */
public abstract class AbstractEsbNodeDeserializer<T,R extends EsbNode> implements IEsbNodeDeserializer<T,R> {
	private static EsbDiagramEditor diagramEditor;
	private static Map<EsbConnector, LinkedList<EsbNode>> connectionFlowMap = new LinkedHashMap<EsbConnector, LinkedList<EsbNode>>();
	private static Map<EObject,ShapeNodeEditPart> editPartMap = new HashMap<EObject, ShapeNodeEditPart>();
	private static Map<EsbConnector, EsbConnector> pairMediatorFlowMap = new HashMap<EsbConnector, EsbConnector>();
	private static List<EObject> reversedNodes = new ArrayList<EObject>();
	private static Map<EsbConnector, LinkedList<EsbNode>> complexFiguredReversedFlows = new HashMap<EsbConnector, LinkedList<EsbNode>>();
	private static Map<EsbNode, Rectangle> nodeBounds = new HashMap<EsbNode, Rectangle>();
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private static GraphicalEditPart rootCompartment;
	private static List<EsbConnector> rootInputConnectors = new ArrayList<EsbConnector>();
	private static List<EditPart> startNodes = new ArrayList<EditPart>();
	private EObject elementToEdit;
	private boolean reversed;
	private static boolean hasInlineEndPoint;
	private static boolean addedAddressingEndPoint;
	
	public void setElementToEdit(EObject elementToEdit) {
		this.elementToEdit = elementToEdit;
	}

	private static Map<EsbConnector, Rectangle> currentLocation ;
	
	public static EsbDiagramEditor getDiagramEditor() {
		/* Always refers EsbDiagramEditor from EsbDeserializerRegistry unless it is NULL
		 * This ensures that the operations are executed by deserializer performs against the EsbDiagramEditor
		 * initialized in EsbDeserializerRegistry 
		 * */
		EsbDiagramEditor diagramEditorRef = EsbDeserializerRegistry.getInstance().getDiagramEditor();
		if(diagramEditorRef!=null){
			diagramEditor = diagramEditorRef;
			return diagramEditorRef;
		}
		return diagramEditor;
	}

	public void setDiagramEditor(EsbDiagramEditor diagramEditor) {
		AbstractEsbNodeDeserializer.diagramEditor = diagramEditor;
	}

	/**
	 * Deserialize a sequence
	 * @param mediatorFlow
	 * @param sequence
	 * @param connector
	 */
	protected void deserializeSequence(IGraphicalEditPart part, SequenceMediator sequence, EsbConnector connector) {
		deserializeSequence(part, sequence, connector, isReversed());
	}
	
	/**
	 * Deserialize a sequence
	 * @param mediatorFlow
	 * @param sequence
	 * @param connector
	 * @param reversed
	 */
	protected void deserializeSequence(IGraphicalEditPart part, SequenceMediator sequenceMediator, EsbConnector connector, boolean reversed) {
		LinkedList<EsbNode> nodeList = new LinkedList<EsbNode>();
		
		SequenceMediator sequence = EditorUtils.stripUnsupportedMediators(sequenceMediator);
	
		TransactionalEditingDomain domain = part.getEditingDomain();

		if(connector instanceof OutputConnector){
			for (int i = 0; i < sequence.getList().size(); ++i) {
				AbstractMediator mediator = (AbstractMediator) sequence.getList().get(i);
				if(reversedNodes.contains(connector.eContainer())){
					executeMediatorDeserializer(part, nodeList, domain, mediator,true);					
					reversedNodes.addAll(nodeList);
				} else{
					executeMediatorDeserializer(part, nodeList, domain, mediator,reversed);
					if(reversed){
						reversedNodes.addAll(nodeList);
					}
				}
			}
			
			/*safe to remove : not valid in current implementation/UI*/ 
			/*
			if (!reversed) {
								if (!nodeList.isEmpty()) {
									EsbNode last = nodeList.getLast();
									if (last instanceof Sequence) {
										Sequence seq = (Sequence) last;
										if (seq.getReferringSequenceType() == KeyType.DYNAMIC ||(seq.getReferringSequenceType()==KeyType.STATIC && seq.getName().matches("^(conf:|gov:|/).*"))) {
										AddressingEndpoint visualEndPoint = (AddressingEndpoint) DeserializerUtils
													.createNode(
															getRootCompartment(),
															EsbElementTypes.AddressingEndpoint_3689);
											setAddedAddressingEndPoint(true);
											nodeList.add(visualEndPoint);
											
										}
									}
								}
							}
			*/
			connectionFlowMap.put(connector, nodeList);
		} else if(connector instanceof InputConnector){
			for (int i = sequence.getList().size() -1; i >= 0; --i) {
				AbstractMediator mediator = (AbstractMediator) sequence.getList().get(i);
				executeMediatorDeserializer(part, nodeList, domain, mediator,true);
			}
			connectionFlowMap.put(connector, nodeList);
			reversedNodes.addAll(nodeList);
		}
		
	}

	/**
	 * Execute deserializer
	 * @param mediatorFlow
	 * @param nodeList
	 * @param domain
	 * @param mediator
	 * @param reversed
	 */
	private void executeMediatorDeserializer(IGraphicalEditPart part,
			LinkedList<EsbNode> nodeList, TransactionalEditingDomain domain,
			AbstractMediator mediator,boolean reversed) {
		@SuppressWarnings("rawtypes")
		IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(
				mediator);
		if (deserializer != null) {
			deserializer.setReversed(reversed);
			@SuppressWarnings("unchecked")
			EsbNode node = deserializer.createNode(part, mediator);
			if (node!=null) {	
				// If there is any comment mediator(XML comment) in the source,
				// we will add
				// that into previous output connector's comment mediator list.
				// So that comment mediators have been encapsulated inside
				// output connectors which will prevent editor representing
				// comment mediators graphically.
				if (node instanceof CommentMediator) {
					AbstractOutputConnectorEditPart abstractOutputConnectorEditPart = getPreviousOutputConnector(part,
							nodeList);
					if (abstractOutputConnectorEditPart != null) {
						executeAddValueCommand(
								((OutputConnector) ((Node) abstractOutputConnectorEditPart.getModel()).getElement())
										.getCommentMediators(),
								(CommentMediator) node);
					}
				} else {
					nodeList.add(node);
				}
				if (node instanceof SendMediator/* && !reversed*/) {
					if (getRootCompartment() != null) {
						SendMediator sendMediator = (SendMediator) node;
						EndPoint endPoint = sendMediator.getNextNode();
						// Extract the endPoint info from the sendMediator
						if (endPoint != null) {
							if(reversed){
								nodeList.add(nodeList.size(), endPoint);
							} else{
								nodeList.add(endPoint);
							}
							
						}
					}
				}
			}

		}
	}
	
	/**
	 * This method will return the OutputConnector of previous mediator in the
	 * mediator list. If the mediator list is empty, this will return the output
	 * connector associated with that mediatorFlow
	 * 
	 * @param part
	 * @param nodeList
	 * @return
	 */
	private AbstractOutputConnectorEditPart getPreviousOutputConnector(IGraphicalEditPart part, LinkedList<EsbNode> nodeList){
		if(nodeList.isEmpty()){
			EditPart mediatorFlow = part.getParent();
			if(mediatorFlow instanceof AbstractMediatorFlowEditPart){
				return ((AbstractMediatorFlowEditPart)mediatorFlow).getAssociatedOutputConnector();
			}else{
				return null;
			}
		}else{
			org.wso2.developerstudio.eclipse.gmf.esb.Mediator mediator = (org.wso2.developerstudio.eclipse.gmf.esb.Mediator) nodeList.getLast();
			refreshEditPartMap();
			return EditorUtils.getMediatorOutputConnector((ShapeNodeEditPart) getEditpart(mediator));
		}
	}
	
	protected void addPairMediatorFlow(EsbConnector startEnd,EsbConnector stopEnd) {
		pairMediatorFlowMap.put(startEnd, stopEnd);
	}
	
	private static void pairMediatorFlows() {
		for (Map.Entry<EsbConnector, EsbConnector> pair : pairMediatorFlowMap.entrySet()) {
		
			EditPart firstPart = (EditPart) getEditpart(pair.getKey());
			EditPart secondPart = (EditPart) getEditpart(pair.getValue());
			AbstractConnectorEditPart sourceConnector = null;
			AbstractConnectorEditPart targetConnector = null;
			
			if (firstPart instanceof SequencesOutputConnectorEditPart && secondPart instanceof SequencesInputConnectorEditPart) {
				
				AbstractSequencesEditPart sequence = EditorUtils.getSequence((SequencesOutputConnectorEditPart)firstPart);
				IGraphicalEditPart mediatorFlow = (IGraphicalEditPart)sequence.getChildren().get(0); //assuming mediatorflow is the first child
				IGraphicalEditPart mediatorFlowCompartment = (IGraphicalEditPart)mediatorFlow.getChildren().get(0);
				int numOfChildren = mediatorFlowCompartment.getChildren().size();
				if (numOfChildren >= 1) {
					//get last child and connect its output connector to secuenceinputconnector (right hand side)
					//Assuming getChildren().get(numOfChildren - 1) gives the last element in the flow
					ShapeNodeEditPart lastChild = (ShapeNodeEditPart) mediatorFlowCompartment.getChildren().get(numOfChildren - 1);
					AbstractOutputConnectorEditPart lastOutputConnector = EditorUtils.getMediatorOutputConnector(lastChild);
					sourceConnector =  lastOutputConnector;
					targetConnector = (AbstractConnectorEditPart) secondPart;
				}
			} else if ((firstPart instanceof InboundEndpointSequenceOutputConnectorEditPart && secondPart instanceof InboundEndpointSequenceInputConnectorEditPart)
					|| (firstPart instanceof InboundEndpointOnErrorSequenceOutputConnectorEditPart && secondPart instanceof InboundEndpointOnErrorSequenceInputConnectorEditPart)) {
				LinkedList<EsbNode> seq = connectionFlowMap.get(pair.getKey());
				if (seq != null && seq.size() > 0 && seq.getLast() instanceof Sequence) {
					sourceConnector = (AbstractConnectorEditPart) getEditpart(((Sequence) seq.getLast())
							.getOutputConnector().get(0));
					targetConnector = (AbstractConnectorEditPart) secondPart;
				}
			} else {
				if (firstPart instanceof ProxyOutputConnectorEditPart
						&& secondPart instanceof ProxyInputConnectorEditPart) {
					LinkedList<EsbNode> seq = connectionFlowMap.get(pair.getKey());
					if (seq != null && seq.size() > 0 && seq.getLast() instanceof SendMediator) {
						sourceConnector = (AbstractConnectorEditPart) getEditpart(((SendMediator) seq.getLast())
								.getOutputConnector());
						EList<ProxyInSequenceInputConnector> inputConnectors = ((ProxyService) ((Node) EditorUtils
								.getProxy(secondPart).getModel()).getElement()).getInSequenceInputConnectors();
						for (ProxyInSequenceInputConnector con : inputConnectors) {
							if (con.getIncomingLinks().size() == 0) {
								targetConnector = (AbstractConnectorEditPart) getEditpart(con);
								break;
							}
						}
					}
					LinkedList<EsbNode> outSeq = connectionFlowMap.get(pair.getValue());
					if (outSeq == null || outSeq.size() == 0) {
						continue;
					}

					sourceConnector = EditorUtils.getProxyOutSequenceOutputConnector((ShapeNodeEditPart) EditorUtils
							.getAbstractBaseFigureEditPart((EditPart) getEditpart(outSeq.getLast())));
					if (outSeq.size() > 0 && outSeq.getLast() != null) {
						targetConnector = EditorUtils.getInputConnector((ShapeNodeEditPart) getEditpart(outSeq
								.getLast()));
					} else {
						if (pair.getValue() instanceof AbstractConnectorEditPart) {
							targetConnector = (AbstractConnectorEditPart) pair.getValue();
						} else
							continue;

					}
					
				} else if (firstPart instanceof APIResourceOutputConnectorEditPart
						&& secondPart instanceof APIResourceInputConnectorEditPart) {
					LinkedList<EsbNode> seq = connectionFlowMap.get(pair.getKey());
					if (seq != null && seq.size() > 0 && seq.getLast() instanceof SendMediator) {
						sourceConnector = (AbstractConnectorEditPart) getEditpart(((SendMediator) seq.getLast())
								.getOutputConnector());
						EList<APIResourceInSequenceInputConnector> inputConnectors = ((APIResource) ((Node) EditorUtils
								.getAPIResource((AbstractConnectorEditPart) secondPart).getModel()).getElement()).getInSequenceInputConnectors();
						for (APIResourceInSequenceInputConnector con : inputConnectors) {
							if (con.getIncomingLinks().size() == 0) {
								targetConnector = (AbstractConnectorEditPart) getEditpart(con);
								break;
							}
						}
					}
					LinkedList<EsbNode> outSeq = connectionFlowMap.get(pair.getValue());
					if (outSeq == null || outSeq.size() == 0) {
						continue;
					}

					sourceConnector = EditorUtils.getProxyOutSequenceOutputConnector((ShapeNodeEditPart) EditorUtils
							.getAbstractBaseFigureEditPart((EditPart) getEditpart(outSeq.getLast())));
					if (outSeq.size() > 0 && outSeq.getLast() != null) {
						targetConnector = EditorUtils.getInputConnector((ShapeNodeEditPart) getEditpart(outSeq
								.getLast()));
					} else {
						if (pair.getValue() instanceof AbstractConnectorEditPart) {
							targetConnector = (AbstractConnectorEditPart) pair.getValue();
						} else
							continue;

					}
				}else {
					LinkedList<EsbNode> outSeq = connectionFlowMap.get(pair.getValue());
					if (outSeq == null || outSeq.size() == 0) {
						continue;
					}

					sourceConnector = EditorUtils.getProxyOutSequenceOutputConnector((ShapeNodeEditPart) EditorUtils
							.getAbstractBaseFigureEditPart((EditPart) getEditpart(outSeq.getLast())));
					if (outSeq.size() > 0 && outSeq.getLast() != null) {
						targetConnector = EditorUtils.getInputConnector((ShapeNodeEditPart) getEditpart(outSeq
								.getLast()));
					} else {
						if (pair.getValue() instanceof AbstractConnectorEditPart) {
							targetConnector = (AbstractConnectorEditPart) pair.getValue();
						} else
							continue;

					}
				}
			}
			
			if (sourceConnector != null && targetConnector != null) {
				ConnectionUtils.createConnection(targetConnector,sourceConnector);
			}
		}
		
/*		for (Map.Entry<EsbConnector, EsbConnector> pair : pairMediatorFlowMap.entrySet()) {
			LinkedList<EsbNode> inSeq = connectionFlowMap.get(pair.getKey());
			LinkedList<EsbNode> outSeq = connectionFlowMap.get(pair.getValue());
			
			if (inSeq == null || outSeq == null) {
				continue;
			}
			
			if (inSeq.size() > 0 && inSeq.getLast() instanceof EndPoint) {
				EsbNode last = inSeq.getLast();
				AbstractConnectorEditPart sourceConnector = EditorUtils
						.getOutputConnector((ShapeNodeEditPart) getEditpart(last));
				AbstractConnectorEditPart targetConnector = null;
				if(outSeq.size() > 0 && outSeq.getLast() != null){
					targetConnector = EditorUtils
					.getInputConnector((ShapeNodeEditPart) getEditpart(outSeq.getLast()));
				} else{
					if(pair.getValue() instanceof AbstractConnectorEditPart){
						targetConnector = (AbstractConnectorEditPart) pair.getValue();
					} else continue;
					
				}
				
				if (sourceConnector != null && targetConnector != null) {
					ConnectionUtils.createConnection(targetConnector,sourceConnector);
				}
			}
		}
		//looking for other possible connections  : around 1
		//Connecting endpoints to last node of out-sequence  
		Iterator<EsbConnector> iterator = getRootInputConnectors().iterator();
		while (iterator.hasNext()) {
			EsbConnector rootConnector = iterator.next();
				for (LinkedList<EsbNode> nodes : connectionFlowMap.values()) {
					if (!pairMediatorFlowMap.values().contains(nodes)) {
						if (nodes.size() > 0 && (nodes.getLast() instanceof EndPoint || 
								rootConnector.eContainer() instanceof Sequences)) {
							LinkedList<EsbNode> outSeq = connectionFlowMap.get(rootConnector);
							AbstractConnectorEditPart targetConnector = null;
							EsbNode last = nodes.getLast();
							AbstractConnectorEditPart sourceConnector = EditorUtils
									.getOutputConnector((ShapeNodeEditPart) getEditpart(last));
							if (outSeq!=null &&( outSeq.size() > 0 && outSeq.getLast() != null)) {
								targetConnector = EditorUtils
										.getInputConnector((ShapeNodeEditPart) getEditpart(outSeq
												.getLast()));
							} else {
								targetConnector = (AbstractConnectorEditPart) getEditpart(rootConnector);
							}

							if (sourceConnector != null && targetConnector != null) {								
								if(targetConnector instanceof SequencesInputConnectorEditPart){
									if(sourceConnector.getParent().getParent().getParent().getParent().equals(targetConnector.getParent())){
										ConnectionUtils.createConnection(targetConnector, sourceConnector);
									}
								}else{
									ConnectionUtils.createConnection(targetConnector, sourceConnector);
								}
							}
						}
					}
				}
		}
		
		//looking for other possible connections : around 2
		//Connecting send mediators to an inline endpoint or a dummy endpoint
		EsbNode targetNode = null;
		List<EsbNode> sourceNodes = new LinkedList<EsbNode>();
		for (LinkedList<EsbNode> nodes : connectionFlowMap.values()) {
			if (targetNode==null) {
				if (nodes.size() > 0 && nodes.getLast() instanceof AbstractEndPoint) {
					AbstractEndPoint endPoint = (AbstractEndPoint) nodes.getLast();
					if (endPoint instanceof AddressingEndpoint || endPoint.isInLine()) {
						targetNode = endPoint;
					}
				}
			}
			
			if (nodes.size() > 0 && nodes.getLast() instanceof SendMediator) {
				sourceNodes.add(nodes.getLast());
			}
		}
		
		if(targetNode!=null && sourceNodes.size()>0){
			AbstractConnectorEditPart targetConnector = EditorUtils
			.getInputConnector((ShapeNodeEditPart) getEditpart(targetNode));
			for (EsbNode sourceNode : sourceNodes) {
				AbstractConnectorEditPart sourceConnector = EditorUtils
				.getOutputConnector((ShapeNodeEditPart) getEditpart(sourceNode));
				if (sourceConnector != null && targetConnector != null) {
					ConnectionUtils.createConnection(targetConnector, sourceConnector);
				}
			}
		}*/

	}
	
	/**
	 * Connect all mediator-flows according to sequence 
	 */
	public static synchronized void connectMediatorFlows(){
		refreshEditPartMap();
		for(EObject node : reversedNodes){
			EditPart editpart = getEditpart(node);
			if(editpart instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator){
				((org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator)editpart).reverseConnectors();
			}
		}
		currentLocation = new HashMap<EsbConnector, Rectangle>();
		for (Map.Entry<EsbConnector, LinkedList<EsbNode>> flow : connectionFlowMap.entrySet()) {
			relocateFlow(flow.getKey(), flow.getValue());
			EObject container = flow.getKey().eContainer();
			if(reversedNodes.contains(container)){
				EditPart editpart = getEditpart(container);
				if (editpart instanceof complexFiguredAbstractMediator){
					complexFiguredReversedFlows.put(flow.getKey(), flow.getValue());
				}
			}
		}
		clearLinks();
		for (Map.Entry<EsbConnector, LinkedList<EsbNode>> flow : complexFiguredReversedFlows.entrySet()) {
			reverseComplexFlow(flow.getKey(), flow.getValue());
		}
		refreshEditPartMap();
		for (Map.Entry<EsbConnector, LinkedList<EsbNode>> flow : connectionFlowMap.entrySet()) {
			connectMediatorFlow(flow.getKey(), flow.getValue());
		}
		pairMediatorFlows();
		cleanupData();
	}
	
	/**
	 * Reverse nodes in inside complexFigured mediators of out-sequence 
	 * @param connector
	 * @param nodes
	 */
	public static void reverseComplexFlow(EsbConnector connector,
			LinkedList<EsbNode> nodes) {
		
		Rectangle containerBounds = currentLocation.get(connector);
		
		if (containerBounds!=null) {
			for (Iterator<EsbNode> i = nodes.iterator(); i.hasNext();) {
				EsbNode node = i.next();
				GraphicalEditPart editpart = (GraphicalEditPart) getEditpart(node);
				Rectangle rect = nodeBounds.get(node);
				if (rect!=null) {
					rect.x = containerBounds.x - (rect.x + rect.width);
					SetBoundsCommand sbc = new SetBoundsCommand(editpart.getEditingDomain(),
							"change location", new EObjectAdapter((View) editpart.getModel()), rect);
					editpart.getDiagramEditDomain().getDiagramCommandStack()
							.execute(new ICommandProxy(sbc));
				}
			}
		}
		
	}

	/**
	 * Cleanup everything used by deserializers
	 */
	public static void cleanupData() {
		if(connectionFlowMap!=null){
			connectionFlowMap.clear();
		}
			
		if(reversedNodes!=null){
			reversedNodes.clear();
		}
		
		if(pairMediatorFlowMap!=null){
			pairMediatorFlowMap.clear();
		}
		
		if(rootInputConnectors!=null){
			rootInputConnectors.clear();
		}
		
		if(complexFiguredReversedFlows!=null){
			complexFiguredReversedFlows.clear();
		}
		
		if(nodeBounds!=null){
			nodeBounds.clear();
		}
		
		rootCompartment =null;
		hasInlineEndPoint=false;
		addedAddressingEndPoint=false;
	}
	
	
	/**
	 * Connect mediator-flow to a connector
	 * @param connector
	 * @param nodeList
	 */
	private static void connectMediatorFlow(EsbConnector connector, LinkedList<EsbNode> nodeList) {
		AbstractConnectorEditPart sourceConnector = null;
		AbstractConnectorEditPart targetConnector = null;
		
		boolean reversedMode = (connector instanceof InputConnector);

		EditPart sourceConnectorEditpart = getEditpart(connector);
		if (sourceConnectorEditpart instanceof AbstractConnectorEditPart) {
			sourceConnector = (AbstractConnectorEditPart) getEditpart(connector);
		}

		Iterator<EsbNode> iterator = nodeList.iterator();

		while (iterator.hasNext()) {
			EsbNode mediatornode = iterator.next();
			AbstractConnectorEditPart nextSourceConnector = null;
			targetConnector = null;

			EditPart editpart = getEditpart(mediatornode);
			if (editpart instanceof ShapeNodeEditPart) {
				if(reversedMode){
					targetConnector = getOutputConnector((ShapeNodeEditPart) editpart);
					nextSourceConnector = EditorUtils.getInputConnector((ShapeNodeEditPart) editpart);
				} else{
					targetConnector = EditorUtils.getInputConnector((ShapeNodeEditPart) editpart);
					nextSourceConnector = getOutputConnector((ShapeNodeEditPart) editpart);
				}
			}

			if (targetConnector != null && sourceConnector != null) {				
				if(reversedMode){
					ConnectionUtils.createConnection(sourceConnector,targetConnector);
				} else{
					ConnectionUtils.createConnection(targetConnector, sourceConnector);
				}
				sourceConnector = nextSourceConnector;
			}
			//sourceConnector = nextSourceConnector;
		}
	}

	/**
	 * Look up OutputConnector by EditPart
	 * @param editpart
	 * @return
	 */
	private static AbstractConnectorEditPart getOutputConnector(ShapeNodeEditPart editpart) {
		return EditorUtils.getOutputConnector(editpart,
				AbstractMediatorOutputConnectorEditPart.class);
	}

	/**
	 * @param reversedMode
	 * @param editpart
	 */
	private static void relocateNode(final Rectangle location, EditPart editpart) {
		
		GraphicalEditPart gEditpart = (GraphicalEditPart)editpart;
		
		if(editpart instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator){
			Rectangle rect = new Rectangle(new Point(), gEditpart.getFigure().getPreferredSize())
					.getCopy();
			Rectangle rectCopy = rect.getCopy();
			if (editpart instanceof complexFiguredAbstractMediator) {
				@SuppressWarnings("rawtypes")
				List children = gEditpart.getChildren();
				int pointY= 50;
				for (Object child : children) {
					if (child instanceof AbstractOutputConnectorEditPart) {
						EsbConnector connector = (EsbConnector) ((Node) ((EditPart) child)
								.getModel()).getElement();
						Rectangle point = currentLocation.get(connector);
						if (point != null) {
							rectCopy.width = Math.max(rectCopy.width, point.x + 50);
							pointY += (point.y + point.height) + 20; 
							rectCopy.height = Math.max(rectCopy.height, pointY);
						}
						if(((complexFiguredAbstractMediator)editpart).reversed){
							rect.width +=50; // no effect on width
						}
					}
				}
			}
			rect.x = location.x;
			rect.y = location.y;
			SetBoundsCommand sbc = new SetBoundsCommand(gEditpart.getEditingDomain(),
					"change location", new EObjectAdapter((View) editpart.getModel()), rect);
			nodeBounds.put((EsbNode)((View)editpart.getModel()).getElement(), rect.getCopy());

			gEditpart.getDiagramEditDomain().getDiagramCommandStack()
					.execute(new ICommandProxy(sbc));
			location.x = location.x + rectCopy.width + 40;
			location.height = Math.max(location.height, rectCopy.height);
		}
		
	}
	
	private static Iterator<EsbNode> getNodeIterator(LinkedList<EsbNode> nodeList) {
		Iterator<EsbNode> iterator = nodeList.iterator();
		
		if (nodeList.size() > 0) {
			EditPart editpart = getEditpart(nodeList.getFirst());
			if (editpart != null) {
				if (editpart.getParent() instanceof AbstractMediatorCompartmentEditPart) {
					if (editpart.getParent().getParent() instanceof ShapeNodeEditPart) {
						EditPart container = editpart.getParent().getParent().getParent();
						if (container instanceof complexFiguredAbstractMediator) {
							if (((complexFiguredAbstractMediator) container).reversed) {
								iterator = nodeList.descendingIterator();
							}
						}
					}
				}
			}
		}

		return iterator;
	}
	
	private static void relocateFlow(EsbConnector connector, LinkedList<EsbNode> nodeList) {
		if(!currentLocation.containsKey(connector)){
			currentLocation.put(connector, new Rectangle(25, getInitialY(connector, nodeList), 0, 0));
		}
		
		Rectangle point = currentLocation.get(connector);
		Iterator<EsbNode> iterator = getNodeIterator(nodeList);
		int count=0;
		while (iterator.hasNext()) {
			EsbNode mediatornode = iterator.next();
			EditPart editpart = getEditpart(mediatornode);
			if(++count==1){
				startNodes.add(editpart);
			}
			relocateNode(point, editpart);
		}
		
		EsbConnector pairConnector = pairMediatorFlowMap.get(connector);
		if(pairConnector!=null){
			currentLocation.put(pairConnector, new Rectangle(25, Math.max(200, point.height+30),0,0));
		}
	
	}
	
	/**
	 * This is to avoid RJS0007E Semantic refresh failed issue appears in
	 * compartments, which has only one node. This should be replaced with the
	 * better approach
	 */
	public static void relocateStartNodes(){
		for (Iterator<EditPart> it = startNodes.iterator(); it.hasNext();) {
			
			try {
				EditPart next = it.next();

				GraphicalEditPart gEditpart = (GraphicalEditPart) next;
				Rectangle rect = gEditpart.getFigure().getBounds().getCopy();
				rect.x++;
				SetBoundsCommand sbc = new SetBoundsCommand(gEditpart.getEditingDomain(),
						"change location", new EObjectAdapter((View) next.getModel()), rect);

				gEditpart.getDiagramEditDomain().getDiagramCommandStack()
						.execute(new ICommandProxy(sbc));
				
				Thread.sleep(50);
			} catch (Exception e) {
				break;
			}

		}
		startNodes = new ArrayList<EditPart>();
	}
	
	private static int getInitialY(EsbConnector connector, LinkedList<EsbNode> nodeList) {
		int y = 10;

		EObject eContainer = connector.eContainer();

		if (eContainer != null) {
			//FIXME : Remove hard-coded values
			if (eContainer instanceof ProxyService || eContainer instanceof APIResource) {
				y = 95; // Initial y of proxy, api resource output connector 
			} else if (eContainer instanceof Sequences) {
				y = 146; // Initial y of sequence output connector 
			} else {
				return y;
			}
			if (nodeList.size() > 0) {
				EditPart editpart = getEditpart(nodeList.getFirst());
				if (editpart != null) {
					if (!(editpart instanceof complexFiguredAbstractMediator)) {
						GraphicalEditPart gEditpart = (GraphicalEditPart) editpart;
						y = y - (gEditpart.getFigure().getPreferredSize().height / 2);
					}
				}
			}
		}

		return y;
	}

	/**
	 * Clear links 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void clearLinks() {
		Collection values = getDiagramEditor().getDiagramGraphicalViewer().getEditPartRegistry().values();
		Iterator iterator = values.iterator();
		CompoundCommand ccModel = new CompoundCommand();
		org.eclipse.gef.commands.CompoundCommand ccView = new org.eclipse.gef.commands.CompoundCommand();
		
		while (iterator.hasNext()) {
			Object editPart = iterator.next();
			if (editPart instanceof EsbLinkEditPart ) {
				EsbLinkEditPart linkEditPart = (EsbLinkEditPart) editPart;
				/*
				 * We shouldn't remove EsbLinkEditParts if the target of the link is a AbstractEndpointInputConnectorEditPart.
				 * Because these kind of links will not be get regenerated again according to the current implementation.     
				 */
				if(linkEditPart.getTarget() instanceof AbstractEndpointInputConnectorEditPart){
					continue;
				}
				Collection linkCollection = new ArrayList();
				linkCollection.add(((ConnectorImpl) linkEditPart.getModel()).getElement());
				org.eclipse.emf.edit.command.DeleteCommand modelDeleteCommand = new org.eclipse.emf.edit.command.DeleteCommand(
						getDiagramEditor().getEditingDomain(), linkCollection);
				if (modelDeleteCommand.canExecute()) {
					ccModel.append(modelDeleteCommand);
				}
				DeleteCommand viewDeleteCommand = new DeleteCommand(linkEditPart.getNotationView());
				if (viewDeleteCommand.canExecute()) {
					ccView.add(new ICommandProxy(viewDeleteCommand));
				}
			}
		}

		if (ccModel.canExecute()) {
			getDiagramEditor().getEditingDomain().getCommandStack().execute(ccModel);
		}
		if (ccView.canExecute()) {
			getDiagramEditor().getDiagramEditDomain().getDiagramCommandStack()
					.execute(ccView);
		}
	}
	
	/**
	 * Refresh EditPartMap
	 */
	public static void refreshEditPartMap(){
		editPartMap.clear();
		
		if(getDiagramEditor()==null)
			return;
		
		@SuppressWarnings("rawtypes")
		Map editPartRegistry = getDiagramEditor().getDiagramEditPart().getViewer().getEditPartRegistry();
		for (Object object : editPartRegistry.keySet()) {
			if(object instanceof Node){
				Node nodeImpl = (Node) object;
					Object ep = editPartRegistry.get(nodeImpl);
					if(ep instanceof ShapeNodeEditPart){
						editPartMap.put(nodeImpl.getElement(), (ShapeNodeEditPart)ep);
					}
			}
		}
	}
	
	/**
	 * Get corresponding EditPart of EObject
	 * @param node
	 * @return
	 */
	public static EditPart getEditpart(EObject node) {
		if(editPartMap.containsKey(node)){
			return editPartMap.get(node);
		}
		return null;
	}

	public static IDeveloperStudioLog getLog() {
		return log;
	}

	public static void setRootCompartment(GraphicalEditPart compartment) {
		AbstractEsbNodeDeserializer.rootCompartment = compartment;
	}

	public static GraphicalEditPart getRootCompartment() {
		return rootCompartment;
	}

	public static void addRootInputConnector(EsbConnector rootInputConnector) {
		rootInputConnectors.add(rootInputConnector);
	}

	public static List<EsbConnector> getRootInputConnectors() {
		return rootInputConnectors;
	}
	
	/*
	 * If you are going to use this method, you must set "elementToEdit" attribute first.
	 */
	protected boolean executeSetValueCommand(EStructuralFeature feature, Object value){
		return executeSetValueCommand(elementToEdit,feature,value);
	}
		
	protected boolean executeSetValueCommand(EObject elementToEdit,
			EStructuralFeature feature, Object value) {
		SetRequest reqSet = new SetRequest(getDiagramEditor().getEditingDomain(),
				elementToEdit, feature, value);
		SetValueCommand operation = new SetValueCommand(reqSet);
		if (operation.canExecute()) {
			getDiagramEditor().getDiagramEditDomain().getDiagramCommandStack()
					.execute(new ICommandProxy(operation));
			return true;
		}
		return false;		
	}
		
	protected <E extends EObject> boolean executeAddValueCommand(final EList<E> list, final E value) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		RecordingCommand command = new RecordingCommand(editingDomain) {
			protected void doExecute() {
				list.add(value);
			}
		};
		if (command.canExecute()) {
			editingDomain.getCommandStack().execute(command);
			return true;
		}
		return false;
	}
	
	protected <E extends Object> boolean executeAddAllCommand(final EList<E> list, final List<E> valueList) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		RecordingCommand command = new RecordingCommand(editingDomain) {
			protected void doExecute() {
				list.addAll(valueList);
			}
		};
		if (command.canExecute()) {
			editingDomain.getCommandStack().execute(command);
			return true;
		}
		return false;
	}
	
	protected NamespacedProperty createNamespacedProperty(SynapseXPath xpath) {			
		NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();				
		nsp.setPropertyValue(xpath.toString());				
		if (xpath.getNamespaces() != null) {
			@SuppressWarnings("unchecked")
			Map<String, String> map = xpath.getNamespaces();
			nsp.setNamespaces(map);
		}
		return nsp;
	}
	
	protected NamespacedProperty createNamespacedProperty(SynapsePath path) {			
		NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();	
		nsp.setPropertyValue(path.toString());
		if(path.getPathType()==SynapsePath.X_PATH){
			//nsp.setPropertyValue(path.getExpression());	
			if (path.getNamespaces() != null) {
				@SuppressWarnings("unchecked")
				Map<String, String> map = path.getNamespaces();
				nsp.setNamespaces(map);
			}
		}else if(path.getPathType()==SynapsePath.JSON_PATH){
			//nsp.setPropertyValue(path.getExpression());	
		}	
		return nsp;
	}
	
	protected NamespacedProperty createNamespacedProperty(String xpath,Map<String, String> namespaces) {			
		NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();				
		nsp.setPropertyValue(xpath.toString());				
		if (namespaces != null) {
			nsp.setNamespaces(namespaces);
		}
		return nsp;
	}

	public boolean isReversed() {
		return reversed;
	}

	public void setReversed(boolean reversed) {
		this.reversed = reversed;
	}

	protected static LinkedList<EsbNode> getConnectionFlow(EsbConnector connector) {
		LinkedList<EsbNode> nodes = new LinkedList<EsbNode>();
		if(connectionFlowMap.containsKey(connector)){
			nodes = connectionFlowMap.get(connector);
		} else{
			connectionFlowMap.put(connector, nodes);
		}
		return nodes;
	}

	protected static void setHasInlineEndPoint(boolean hasInlineEndPoint) {
		AbstractEsbNodeDeserializer.hasInlineEndPoint = hasInlineEndPoint;
	}

	protected static boolean hasInlineEndPoint() {
		return hasInlineEndPoint;
	}

	protected static void setAddedAddressingEndPoint(boolean addedAddressingEndPoint) {
		AbstractEsbNodeDeserializer.addedAddressingEndPoint = addedAddressingEndPoint;
	}

	protected static boolean isAddedAddressingEndPoint() {
		return addedAddressingEndPoint;
	}
	
	protected void setCommonProperties(Mediator mediator,org.wso2.developerstudio.eclipse.gmf.esb.Mediator visualElement){
		executeSetValueCommand(visualElement,ESB_ELEMENT__DESCRIPTION, mediator.getShortDescription());
		executeAddAllCommand(visualElement.getCommentsList(), ((AbstractMediator)mediator).getCommentsList());
	}
	
}
