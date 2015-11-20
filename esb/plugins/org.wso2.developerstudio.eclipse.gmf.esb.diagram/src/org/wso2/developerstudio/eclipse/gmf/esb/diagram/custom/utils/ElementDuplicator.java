/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.xml.SendMediatorFactory;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ConnectionUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SlidingBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.DeserializerUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.EsbDeserializerRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.IEsbNodeDeserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbLinkEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

/**
 * 
 */
public class ElementDuplicator {
	/**
	 * Working project
	 */
	private IProject project;
	
	private List<EsbNode> esbNodes=new LinkedList<EsbNode>();
	private Map<EObject,ShapeNodeEditPart> editPartMap = new HashMap<EObject, ShapeNodeEditPart>();
	private Map<EObject,InputConnector> outSequenceFirstConnectorMap = new HashMap<EObject, InputConnector>();
	private HashMap<EndPoint,Sequence> nodesMap=new HashMap<EndPoint,Sequence>();
	private LinkedList<Sequence> currentSequence =new LinkedList<Sequence>();

	
	/**
	 * DeveloperStudio logger
	 * */
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * 
	 * @param project
	 * @param diagramEditor
	 */
	public ElementDuplicator(IProject project,EsbDiagramEditor diagramEditor) {
		this(project);
		EsbDeserializerRegistry.getInstance().init(diagramEditor);
	}
	
	/**
	 * 
	 * @param project
	 */
	public ElementDuplicator(IProject project) {
		if (project != null) {
			this.project = project;
		} else {
			throw new IllegalArgumentException("Project cannot be null");
		}
	}
	
	public void updateAssociatedDiagrams(EsbMultiPageEditor currentEditor) {
		EsbDiagram diagram = (EsbDiagram) currentEditor.getDiagram().getElement();
		EsbServer server = diagram.getServer();
		IFileEditorInput input = (IFileEditorInput) currentEditor.getEditorInput();
		IFile file = input.getFile();
		switch (server.getType()) {
		case PROXY:
			deleteElements(currentEditor);
			duplicateElemets(file, currentEditor);
			break;
		case MAIN_SEQUENCE:
			deleteElements(currentEditor);
			duplicateElemets(file, currentEditor);
			break;
		case API:
			deleteElements(currentEditor);
			duplicateElemets(file, currentEditor);
			break;			
		}
	}
	
	private void deleteElements(IEditorPart editor) {		
		EObject parent = null;
		List<EsbLink> firstLinks = new ArrayList<EsbLink>();
		List<EsbLinkEditPart> firstLinksEditparts=new ArrayList<EsbLinkEditPart>();
		List<EObject> elements = new ArrayList<EObject>();
		Map registry = ((EsbMultiPageEditor) editor).getDiagramEditPart().getViewer().getEditPartRegistry();
		Collection<Object> values = new ArrayList<Object>();
		values.addAll(registry.values());
		OUTER:
		for (int j = 0; j < values.size(); ++j) {
			EditPart element = (EditPart) values.toArray()[j];
			if (element instanceof SendMediatorEditPart) {
				org.wso2.developerstudio.eclipse.gmf.esb.SendMediator sendMediator = (org.wso2.developerstudio.eclipse.gmf.esb.SendMediator) ((org.eclipse.gmf.runtime.notation.Node) ((SendMediatorEditPart) element)
						.getModel()).getElement();
				// if(sendMediator.getReceivingSequenceType().getValue()==1){
				OutputConnector outputConnector = sendMediator.getOutputConnector();
				if (outputConnector !=null && outputConnector.getOutgoingLink() != null) {
					EObject node = outputConnector.getOutgoingLink().getTarget().eContainer();
					if (node instanceof EndPoint) {
						parent = node.eContainer();
						
						if(((EndPoint)node).isReversed()){
							continue;
						}

						EList<EObject> child = node.eContents();
						for (int i = 0; i < child.size(); ++i) {
							if (child.get(i) instanceof OutputConnector) {
								outputConnector = (OutputConnector) child.get(i);
								break;
							}
						}

						EsbLinkEditPart firstLinkEditPart = getFirstLinkEditpart(element);
						if (firstLinkEditPart != null) {
							if(sendMediator.getReceivingSequenceType().getValue()==0){
								EObject targetElement=((org.eclipse.gmf.runtime.notation.Node)firstLinkEditPart.getTarget().getParent().getModel()).getElement();
								if(targetElement instanceof Sequence){
									if(((Sequence)targetElement).isDuplicate()){
										firstLinksEditparts.add(firstLinkEditPart);
									}
								}
							}else{
								firstLinksEditparts.add(firstLinkEditPart);
							}
						}

						collectElementsToBeDeleted(firstLinks, elements, outputConnector);

						/*
						 * firstLinks.add(outputConnector.getOutgoingLink());
						 * 
						 * 
						 * Collect elements to be deleted.
						 * 
						 * while ((outputConnector.getOutgoingLink() !=
						 * null)&&(!
						 * isOutSequenceStarted(outputConnector.getOutgoingLink
						 * ()))) {
						 * 
						 * node =
						 * outputConnector.getOutgoingLink().getTarget().eContainer
						 * (); if(elements.contains(node)){ break; }
						 * elements.add(node); child = node.eContents(); for
						 * (int i = 0; i < child.size(); ++i) { if (child.get(i)
						 * instanceof OutputConnector) { outputConnector =
						 * (OutputConnector) child.get(i); break; } } }
						 */
					}
				}
			} else if (element instanceof SequenceEditPart) {
				Sequence sequence = (Sequence) ((org.eclipse.gmf.runtime.notation.Node) element
						.getModel()).getElement();
				if (sequence.getReferringSequenceType() == KeyType.DYNAMIC ||(sequence.getReferringSequenceType()==KeyType.STATIC && sequence.getName().matches("^(conf:|gov:|/).*"))) {
											continue OUTER;
							}
				if (!sequence.isDuplicate()) {
					ArrayList<OutputConnector> outputConnectors = new ArrayList<OutputConnector>();
					parent = sequence.eContainer();
					EList<EObject> child = sequence.eContents();
					for (int i = 0; i < child.size(); ++i) {
						if (child.get(i) instanceof OutputConnector) {
							outputConnectors.add((OutputConnector) child.get(i));
						}
					}
					for(int k=0;k<outputConnectors.size();++k){
						OutputConnector outputConnector=outputConnectors.get(k);
						if (outputConnector != null) {
							if((outputConnector.getOutgoingLink()!=null)&&(outputConnector.getOutgoingLink().getTarget().eContainer() instanceof EndPoint)){
								collectElementsToBeDeleted(firstLinks, elements, outputConnector);
	/*							for(int i=0;i<element.getChildren().size();++i){
									if(element.getChildren().get(i) instanceof SequenceOutputConnectorEditPart){
										firstLinksEditparts.add((EsbLinkEditPart) ((SequenceOutputConnectorEditPart)element.getChildren().get(i)).getSourceConnections().get(0));
									}
								}*/
							}
						}					
					}
					for(int i=0;i<element.getChildren().size();++i){
						if(element.getChildren().get(i) instanceof SequenceOutputConnectorEditPart){
							List sourceConnections = ((SequenceOutputConnectorEditPart)element.getChildren().get(i)).getSourceConnections();
							if(sourceConnections.size()!=0){
								if(((org.eclipse.gmf.runtime.notation.Node)((EsbLinkEditPart)sourceConnections.get(0)).getTarget().getModel()).getElement().eContainer() instanceof EndPoint){
									firstLinksEditparts.add((EsbLinkEditPart) sourceConnections.get(0));
								}
							}
						}
					}
				}
			}
		}
		CompoundCommand resultCommand = new CompoundCommand();
		TransactionalEditingDomain domain = ((EsbMultiPageEditor) editor).getDiagramEditPart()
				.getEditingDomain();
		IDiagramEditDomain editDomain=((EsbMultiPageEditor) editor).getDiagramEditPart().getDiagramEditDomain();
		/*
		 * We have to delete first link from the model by force.(It's view will get deleted while other elements getting deleted.)
		 */
		Collection col = new ArrayList();
		col.addAll(firstLinks);
		org.eclipse.emf.edit.command.DeleteCommand del = new org.eclipse.emf.edit.command.DeleteCommand(
				domain, col);
		if (del.canExecute()) {
			domain.getCommandStack().execute(del);
		}
		
		for(int i=0;i<firstLinksEditparts.size();++i){
			DeleteCommand delCmd = new DeleteCommand(((EsbLinkEditPart)firstLinksEditparts.get(i))
					.getNotationView());
			org.eclipse.gef.commands.CompoundCommand dl = new org.eclipse.gef.commands.CompoundCommand("Delete Link");
			dl.add(new ICommandProxy(delCmd));
			if (delCmd.canExecute()) {
				editDomain.getDiagramCommandStack().execute(dl);
			}
		}
		
		/*
		 * Delete elements recursively. 
		 */
		for (int j = 0; j < elements.size(); ++j) {
			RemoveCommand removeCmd = new RemoveCommand(domain, elements.get(j).eContainer(),
					EsbPackage.Literals.MEDIATOR_FLOW__CHILDREN, elements.get(j));
			resultCommand.append(removeCmd);
		}

		if (resultCommand.canExecute()) {
			domain.getCommandStack().execute(resultCommand);
		}
	}
	
	private EsbLinkEditPart getFirstLinkEditpart(EditPart element){
		AbstractEndpointOutputConnectorEditPart abstractEndpointOutputConnectorEditPart=getEndpointOutputConnector(element);
			if((abstractEndpointOutputConnectorEditPart!=null)&&(abstractEndpointOutputConnectorEditPart.getSourceConnections().size()!=0)){
				return (EsbLinkEditPart) abstractEndpointOutputConnectorEditPart.getSourceConnections().get(0);
			}else{
				return null;
			}
	}
	
	private AbstractEndpointOutputConnectorEditPart getEndpointOutputConnector(EditPart element){
		AbstractMediatorOutputConnectorEditPart abstractMediatorOutputConnectorEditPart=EditorUtils.getMediatorOutputConnector((SendMediatorEditPart)element);
		EditPart targetEditPart=null;
		AbstractEndpointOutputConnectorEditPart abstractEndpointOutputConnectorEditPart=null;
		if(abstractMediatorOutputConnectorEditPart!=null && abstractMediatorOutputConnectorEditPart.getSourceConnections().size()!=0){
			targetEditPart=((EsbLinkEditPart)abstractMediatorOutputConnectorEditPart.getSourceConnections().get(0)).getTarget();
			abstractEndpointOutputConnectorEditPart=EditorUtils.getEndpointOutputConnector((ShapeNodeEditPart) targetEditPart.getParent());
			return abstractEndpointOutputConnectorEditPart;
		}else{
			return null;
		}
	}
	
	private void collectElementsToBeDeleted(List<EsbLink> firstLinks,List<EObject> elements,OutputConnector outputConnector){
		EObject node=null;
		EList<EObject> child=null;
		if(outputConnector.getOutgoingLink() !=null){
			EObject targetElement=outputConnector.getOutgoingLink().getTarget().eContainer();
			if(outputConnector.eContainer() instanceof org.wso2.developerstudio.eclipse.gmf.esb.SendMediator){
				org.wso2.developerstudio.eclipse.gmf.esb.SendMediator send=(org.wso2.developerstudio.eclipse.gmf.esb.SendMediator)outputConnector.eContainer();
				if(send.getReceivingSequenceType().getValue()==0){
					if(targetElement instanceof Sequence){
						if(((Sequence)targetElement).isDuplicate()){
							firstLinks.add(outputConnector.getOutgoingLink());
						}
					}
				}else{
					firstLinks.add(outputConnector.getOutgoingLink());
				}
			}	
		}
		
		/*
		 * Collect elements to be deleted. 
		 */
		deleteRecursively(elements,outputConnector);
/*		while ((outputConnector.getOutgoingLink() != null)&&(!isOutSequenceStarted(outputConnector.getOutgoingLink()))) {

			node = outputConnector.getOutgoingLink().getTarget().eContainer();
			if(elements.contains(node)){
				break;
			}
			elements.add(node);
			System.out.println("Delete  "+node);
			child = node.eContents();
			for (int i = 0; i < child.size(); ++i) {
				if (child.get(i) instanceof OutputConnector) {
					outputConnector = (OutputConnector) child.get(i);
					break;
				}
			}					
		}*/
	}
	
	private void deleteRecursively(List<EObject> elements,OutputConnector outputConnector){
		EObject node=null;
		EList<EObject> child=null;
		while ((outputConnector.getOutgoingLink() != null)&&(!isOutSequenceStarted(outputConnector.getOutgoingLink()))) {

			node = outputConnector.getOutgoingLink().getTarget().eContainer();
			if(elements.contains(node)){
				break;
			}
			elements.add(node);
			child = node.eContents();
			for (int i = 0; i < child.size(); ++i) {
				if (child.get(i) instanceof OutputConnector) {
					outputConnector = (OutputConnector) child.get(i);
					deleteRecursively(elements,outputConnector);
				}
			}					
		}
	}
	
	private void duplicateElemets(IFile file, IEditorPart editor) {
		List<EsbNode> esbNodes = new LinkedList<EsbNode>();
		Map registry = ((EsbMultiPageEditor) editor).getDiagramEditPart().getViewer()
				.getEditPartRegistry();
		Collection<Object> values = new ArrayList<Object>();
		values.addAll(registry.values());

		for (int j = 0; j < values.size(); ++j) {
			EditPart element = (EditPart) values.toArray()[j];
			if (element instanceof SequenceEditPart) {
				Sequence sequence=(Sequence)((org.eclipse.gmf.runtime.notation.Node)element.getModel()).getElement();
				if(!sequence.isDuplicate()){
					GraphicalEditPart rootCompartment = EditorUtils.getSequenceAndEndpointCompartmentEditPart(element);
					currentSequence.addLast((Sequence)((org.eclipse.gmf.runtime.notation.Node)element.getModel()).getElement());
					esbNodes.add((Sequence)((org.eclipse.gmf.runtime.notation.Node)element.getModel()).getElement());
					esbNodes.addAll(duplicateElements(rootCompartment, ((Sequence)((org.eclipse.gmf.runtime.notation.Node)element.getModel()).getElement()).getName()));
					relocateNodes(esbNodes,editor,(GraphicalEditPart) element);
					if(isOutSequenceFirstConnectorMapEmplty()){
						setOutSequenceFirstConnector(EditorUtils.getRootContainerModel(sequence));
					}
					createLinks(esbNodes, editor);	
				}				
			} else if (element instanceof SendMediatorEditPart) {
				if (((org.wso2.developerstudio.eclipse.gmf.esb.SendMediator) ((org.eclipse.gmf.runtime.notation.Node) ((SendMediatorEditPart) element)
						.getModel()).getElement()).getReceivingSequenceType().getValue() == 1) {
					AbstractMediatorOutputConnectorEditPart sendMediatorOutputConnector = EditorUtils
							.getMediatorOutputConnector((SendMediatorEditPart) element);
					if (sendMediatorOutputConnector.getSourceConnections().size() != 0) {
						String name = ((org.wso2.developerstudio.eclipse.gmf.esb.SendMediator) ((org.eclipse.gmf.runtime.notation.Node) ((SendMediatorEditPart) element)
								.getModel()).getElement()).getStaticReceivingSequence()
								.getKeyValue();
						GraphicalEditPart rootCompartment = EditorUtils
								.getSequenceAndEndpointCompartmentEditPart(element);
						esbNodes = duplicateElementsForReceivingSequence(rootCompartment, name);
						relocateNodes(esbNodes,editor,(GraphicalEditPart) element);
						createLinksForReceivingSequence(esbNodes, editor, (SendMediatorEditPart) element);						
					}else{
						MessageDialog
						.openError(
								Display.getCurrent().getActiveShell(),
								"Diagram Incomplete ! ",
								"Output connector of the send mediator must be connected to an endpoint since send mediator has a receiving sequence.");
					}
				}else{
					refreshEditPartMap(editor);
					EObject root=((org.eclipse.gmf.runtime.notation.Node)EditorUtils.getRootContainer(element).getModel()).getElement();
					InputConnector inputConnector =outSequenceFirstConnectorMap.get(root);
					EditPart connector=getEditpart(inputConnector);
					if(connector instanceof AbstractConnectorEditPart){
						AbstractEndpointOutputConnectorEditPart endpointOutputConnector = getEndpointOutputConnector(element);
						if(endpointOutputConnector instanceof AbstractEndpointOutputConnectorEditPart){
							EObject obj = ((NodeImpl)endpointOutputConnector.getParent().getModel()).getElement(); 
							if(obj instanceof EndPoint){
								if(!((EndPoint)obj).isReversed()){
									ConnectionUtils.createConnection(
											(AbstractConnectorEditPart) connector, endpointOutputConnector);
								}
							}
						}
					}
				}
			}
		}

	}
	
	private void relocateNodes(List<EsbNode> nodes, IEditorPart editor,
			GraphicalEditPart editPart) {
		Rectangle medRect = editPart.getFigure().getBounds().getCopy();
		GraphicalEditPart parent = (GraphicalEditPart)editPart.getParent();
		Rectangle parentRect = parent.getFigure().getBounds().getCopy();
		refreshEditPartMap(editor);
		GraphicalEditPart container = (GraphicalEditPart) EditorUtils.getRootContainer(editPart); 
		Rectangle containerRect = container.getFigure().getBounds().getCopy();
		int initialYPos= medRect.y + medRect.height;
		for (EsbNode node : nodes) {
			
			if(((View)editPart.getModel()).getElement().equals(node)){
				continue;
			}
			
			EditPart nodeEditPart=getEditpart(node);
			if(!(nodeEditPart instanceof GraphicalEditPart)){
				continue;
			}
			GraphicalEditPart editpart = (GraphicalEditPart) nodeEditPart;
			Rectangle rect = new Rectangle(new Point(), editpart.getFigure().getPreferredSize()).getCopy();
			
			initialYPos += 50;
			rect.y = initialYPos;
			if(node instanceof EndPoint){
				SlidingBorderItemLocator.setPredefinedYValue(editpart.getFigure(),rect.y + containerRect.y);
			} else{
				initialYPos += 60;
				rect.x = ((medRect.x + parentRect.width) / 2) - 75;
			}
			
			
			SetBoundsCommand sbc = new SetBoundsCommand(editpart.getEditingDomain(),
					"change location", new EObjectAdapter((View) editpart.getModel()), rect);

			editpart.getDiagramEditDomain().getDiagramCommandStack()
					.execute(new ICommandProxy(sbc));
			
		}
		
		if(initialYPos> parentRect.height){
			
			containerRect.height += (initialYPos - parentRect.height);
			containerRect.height += 40;
			containerRect.width += 100;
				SetBoundsCommand sbc = new SetBoundsCommand(container.getEditingDomain(),
						"change location", new EObjectAdapter((View) container.getModel()), containerRect);

				container.getDiagramEditDomain().getDiagramCommandStack()
						.execute(new ICommandProxy(sbc));
			}
		
	}
	
	public void refreshEditPartMap(IEditorPart editor){
		EsbDiagramEditor diagramEditor=null;
		if (editor instanceof EsbMultiPageEditor){
			diagramEditor=((EsbMultiPageEditor)editor).getGraphicalEditor();
		}
		editPartMap.clear();
		if(diagramEditor==null)
			return;
		
		@SuppressWarnings("rawtypes")
		Map editPartRegistry = diagramEditor.getDiagramEditPart().getViewer().getEditPartRegistry();
		for (Object object : editPartRegistry.keySet()) {
			if(object instanceof org.eclipse.gmf.runtime.notation.Node){
				org.eclipse.gmf.runtime.notation.Node nodeImpl = (org.eclipse.gmf.runtime.notation.Node) object;
					Object ep = editPartRegistry.get(nodeImpl);
					if(ep instanceof ShapeNodeEditPart){
						editPartMap.put(nodeImpl.getElement(), (ShapeNodeEditPart)ep);
					}
			}
		}
	}
	
	public EditPart getEditpart(EObject node) {
		if(editPartMap.containsKey(node)){
			return editPartMap.get(node);
		}
		return null;
	}
	
	
	private void createLinksForReceivingSequence(List<EsbNode> nodes, IEditorPart editor,
			SendMediatorEditPart sendMediatorEditPart) {
		AbstractMediatorOutputConnectorEditPart sendMediatorOutputConnector = EditorUtils
				.getMediatorOutputConnector(sendMediatorEditPart);
		ShapeNodeEditPart endpoint = (ShapeNodeEditPart) ((EsbLinkEditPart) sendMediatorOutputConnector
				.getSourceConnections().get(0)).getTarget().getParent();
		
		
		if(((EndPoint)((NodeImpl)endpoint.getModel()).getElement()).isReversed()){
			return;
		}
		AbstractEndpointOutputConnectorEditPart endpointOutputConnector = EditorUtils
				.getEndpointOutputConnector(endpoint);
		refreshEditPartMap(editor);

		EditPart nodeEditPart=getEditpart(nodes.get(0));
		if(nodeEditPart instanceof ShapeNodeEditPart){
			AbstractMediatorInputConnectorEditPart sequenceInputConnector = EditorUtils
					.getMediatorInputConnector((ShapeNodeEditPart) nodeEditPart);
			ConnectionUtils.createConnection(sequenceInputConnector, endpointOutputConnector);
		}
		createLinks(nodes,editor);
	}
	
	private void createLinks(List<EsbNode> nodes, IEditorPart editor) {		
		LinkedList<AbstractConnectorEditPart> sourceConnectors = new LinkedList<AbstractConnectorEditPart>();
		AbstractConnectorEditPart targetConnector = null;
		
		refreshEditPartMap(editor);
		Iterator<EsbNode> iterator = ((LinkedList<EsbNode>) nodes).iterator();
		while (iterator.hasNext()) {
			EsbNode mediatornode = iterator.next();
			if(mediatornode instanceof EndPoint){				
				AbstractConnectorEditPart nextSourceConnector = null;
				targetConnector = null;
				
				if(((EndPoint)mediatornode).isReversed()){
					continue;
				}

				EditPart editpart = getEditpart(mediatornode);
				if (editpart instanceof ShapeNodeEditPart) {
					targetConnector = EditorUtils.getInputConnector((ShapeNodeEditPart) editpart);
					nextSourceConnector = EditorUtils.getOutputConnector((ShapeNodeEditPart) editpart);
				}
				if (targetConnector != null) {
					Sequence parentSequence=nodesMap.get(mediatornode);
					EsbLink outgoingLink = parentSequence.getOutputConnector().get(0).getOutgoingLink();
					if((outgoingLink ==null)||(outgoingLink.getTarget().eContainer().equals(mediatornode))){
						/*
						 * If outgoingLink.getTarget().eContainer().equals(mediatornode) expression is true in the above line, 
						 * following line of code doesn't create a connection as there is a created connection already. 
						 */
						EditPart connector=getEditpart(parentSequence.getOutputConnector().get(0));
						if(connector instanceof AbstractConnectorEditPart){
							ConnectionUtils.createConnection(targetConnector, (AbstractConnectorEditPart) connector);
						}
					}else{
						AddCommand addCmd = new AddCommand(((IGraphicalEditPart)editpart).getEditingDomain(), parentSequence,
								EsbPackage.Literals.SEQUENCE__OUTPUT_CONNECTOR,
								EsbFactory.eINSTANCE.createSequenceOutputConnector());
						if (addCmd.canExecute()) {
							((IGraphicalEditPart)editpart).getEditingDomain().getCommandStack().execute(addCmd);							
						}
						SequenceOutputConnector sequenceOutputConnector = parentSequence.getOutputConnector().get(parentSequence.getOutputConnector().size()-1);
						refreshEditPartMap(editor);	
						EditPart connection=getEditpart(sequenceOutputConnector);
						if(connection instanceof AbstractConnectorEditPart){
							ConnectionUtils.createConnection(targetConnector, (AbstractConnectorEditPart) connection);
						}
					}					
				}
				sourceConnectors.addLast(nextSourceConnector);	
				
			}else if(mediatornode instanceof Sequence){					
				targetConnector = null;

				EditPart editpart = getEditpart(mediatornode);
				if (editpart instanceof ShapeNodeEditPart) {
					targetConnector = EditorUtils.getInputConnector((ShapeNodeEditPart) editpart);
				}
				if (targetConnector != null && sourceConnectors.size()!=0 ) {
					ConnectionUtils.createConnection(targetConnector, sourceConnectors.getLast());
					sourceConnectors.removeLast();
				}
			}
		}
		for(int i=0;i<sourceConnectors.size();++i){
			if (EditorUtils.getEndpoint(sourceConnectors.get(i)) != null) {
				EObject root=((org.eclipse.gmf.runtime.notation.Node)EditorUtils.getRootContainer(sourceConnectors.get(i)).getModel()).getElement();
				InputConnector inputConnector =outSequenceFirstConnectorMap.get(root);
				refreshEditPartMap(editor);
				EditPart connector=getEditpart(inputConnector);
				if(connector instanceof AbstractConnectorEditPart){
					ConnectionUtils.createConnection(
							(AbstractConnectorEditPart) connector, sourceConnectors.get(i));
				}
			}
		}
		nodes.clear();
	}	
	
	public List<EsbNode> duplicateElementsForReceivingSequence(GraphicalEditPart rootCompartment,String sequenceKey){
		Value recievingSequence=new Value(sequenceKey);
		org.apache.synapse.mediators.base.SequenceMediator sequenceMediator=null;
		if(recievingSequence!=null){
			sequenceMediator=new SequenceMediator();
			sequenceMediator.setKey(recievingSequence);
			IEsbNodeDeserializer SequenceMediatorDeserializer = EsbDeserializerRegistry.getInstance().getDeserializer(sequenceMediator);
			if(SequenceMediatorDeserializer!=null){
				Sequence sequence = (Sequence) SequenceMediatorDeserializer.createNode(rootCompartment, sequenceMediator);
				EditingDomain editingDomain=rootCompartment.getEditingDomain();
				SetCommand setCmd=new SetCommand(editingDomain, sequence,SEQUENCE__DUPLICATE , true);
				if(setCmd.canExecute()){
					editingDomain.getCommandStack().execute(setCmd);
					esbNodes.add(sequence);
					currentSequence.addLast(sequence);
				}				
				//FIXME: set inline
			}
		}
		List<EsbNode> duplicateElements = duplicateElements(rootCompartment,sequenceKey);
		currentSequence.removeLast();
		return duplicateElements;
	}
	
	public List<EsbNode> duplicateElements(GraphicalEditPart rootCompartment,String sequenceKey){					
		
		List<SendMediator> sendMediators = getSendMediators(sequenceKey);
		for (SendMediator sendMediator : sendMediators) {
			try {
				@SuppressWarnings("rawtypes")
				Object endpoint=sendMediator.getEndpoint();
				EndPoint visualEndPoint=null;
				if(endpoint==null){
					IElementType endpointType = EsbElementTypes.AddressingEndpoint_3689;
					visualEndPoint = (AbstractEndPoint) DeserializerUtils.createNode(rootCompartment, endpointType);
				}else{
					IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(endpoint);
					if(deserializer!=null){
						visualEndPoint = (EndPoint) deserializer.createNode(rootCompartment, endpoint);
					}
				}				
				EditingDomain editingDomain=rootCompartment.getEditingDomain();
				SetCommand setCmd=new SetCommand(editingDomain, visualEndPoint,END_POINT__DUPLICATE , true);
				if(setCmd.canExecute()){
					editingDomain.getCommandStack().execute(setCmd);
					esbNodes.add(visualEndPoint);
					nodesMap.put(visualEndPoint,currentSequence.getLast());
				}				
				if(sendMediator.getReceivingSequence()!=null){
					duplicateElementsForReceivingSequence(rootCompartment,sendMediator.getReceivingSequence().getKeyValue());
				}
				
			} catch (NullPointerException e) {
				log.error("EsbDeserializerRegistry must be initialized before it can be used",e);
			}	
			
		}
		return esbNodes;
	}
	
	
	private boolean isOutSequenceStarted(EsbLink link){
		OutputConnector	outputConnector=null;
		InputConnector inputConnector=null;
		EObject rootContainer=null;
		EObject node = link.getTarget().eContainer();
		if(node instanceof EndPoint){
			return false;
		}
		EList<EObject> child = node.eContents();
		for (int i = 0; i < child.size(); ++i) {
			if (child.get(i) instanceof OutputConnector) {
				outputConnector = (OutputConnector) child.get(i);
			}
			else if(child.get(i) instanceof InputConnector){
				rootContainer=EditorUtils.getRootContainerModel(child.get(i));
				inputConnector=(InputConnector) child.get(i);				
			}
		}
		if((node instanceof Sequence) && ((Sequence)node).isDuplicate()){
			return false;
		}
		if((outputConnector!=null)&&(outputConnector.getOutgoingLink()!=null)&&(outputConnector.getOutgoingLink().getTarget().eContainer() instanceof EndPoint)){
			return false;
		}
		outSequenceFirstConnectorMap.put(rootContainer, inputConnector);		
		return true;
	}
	
	private boolean isOutSequenceFirstConnectorMapEmplty(){
		return outSequenceFirstConnectorMap.isEmpty();
	}

	private void setOutSequenceFirstConnector(EObject rootContainer){
		if(rootContainer instanceof ProxyService){
			InputConnector inputConnector=((ProxyService)rootContainer).getInputConnector();
			while(!inputConnector.getIncomingLinks().isEmpty()){
				
					inputConnector= getInputConnector(inputConnector.getIncomingLinks().get(0).getSource().eContainer().eContents());
                    if (inputConnector.eContainer() instanceof ProxyService) {
                    	break;
                    }
			}
			
			outSequenceFirstConnectorMap.put(rootContainer, inputConnector);
			
		}
		
	}
	
	private InputConnector getInputConnector(EList<EObject> eList){
		for(int i=0;i<eList.size();++i){
			if(eList.get(i) instanceof InputConnector){
				return (InputConnector)eList.get(i);
			}
		}
		return null;
	}

	private String getFileLocation(String key) {
		IFolder endpointsDir = project.getFolder("src/main/synapse-config/sequences");
		if (endpointsDir.exists()) {
			IFile file = endpointsDir.getFile(key.concat(".xml"));
			if (file.exists()) {
				return file.getLocation().toOSString();
			}
		}
		return null;
	}
	
	private List<SendMediator> getSendMediators(String key) {
		List<SendMediator> sendList = new LinkedList<SendMediator>();
		
		String fileLocation = getFileLocation(key); 
		if(fileLocation==null) {
			log.error("Cannot find sequence '" + key + "'");
			return Collections.EMPTY_LIST;
		}

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		NamespaceContext ctx = new NamespaceContext() {
			public String getNamespaceURI(String prefix) {
				return "http://ws.apache.org/ns/synapse";
			}

			public String getPrefix(String str) {
				return null;
			}

			public Iterator<?> getPrefixes(String str) {
				return null;
			}
		};
		try {
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			Document doc = builder.parse(fileLocation);
			XPath xpath = XPathFactory.newInstance().newXPath();
			xpath.setNamespaceContext(ctx);
			
			XPathExpression expr = xpath.compile("//:send");

			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				try {
					Node item = nodes.item(i);
					StringWriter writer = new StringWriter();
					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					transformer.transform(new DOMSource(item), new StreamResult(writer));
					OMElement element = AXIOMUtil.stringToOM(writer.toString());
					SendMediatorFactory factory=new SendMediatorFactory();					
					sendList.add((SendMediator) factory.createMediator(element, new Properties()));
				} catch (Exception e) {
					//FIXME: log real error message
					log.error("An unexpected error has occurred",e);
				} 
			}
			
/*			expr = xpath.compile("//:sequence[@key]");

			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				try {
					if(nodes.item(i) instanceof Attr){
						Attr attr = (Attr) nodes.item(i);
						sendList.addAll(getSendMediators(attr.getValue()));
					}
				} catch (Exception e) {
					//FIXME: log real error message
					log.error("An unexpected error has occurred",e);
				} 
			}*/
		} catch (Exception e) {
			//FIXME: log real error message
			log.error("error",e);
		}

		return sendList;
	}

}
