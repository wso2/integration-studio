package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.internal.ui.palette.editparts.ToolEntryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.extensions.CustomPaletteToolTransferDropTargetListener;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.layout.XYRepossition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloudConnectorOperationEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloudConnectorOperationEditPart.CloudConnectorOperationFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbPaletteFactory.NodeToolEntry;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class AbstractMediatorFlowCompartmentEditPart extends ShapeCompartmentEditPart {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private AbstractMediatorFlowCompartmentEditPart instance;
	public Complexity complexity=null;
	public enum Complexity{SINGLE,DOUBLE,MULTIPLE};  
	
	public AbstractMediatorFlowCompartmentEditPart(View view) {
		super(view);
		instance=this;
	}
	
	public void addInSequenceInputConnector(SendMediatorEditPart sendMediatorEditPart) {
		InputConnector inputConnector=null;
			
		AbstractBaseFigureEditPart abstractBaseFigureEditPart = EditorUtils.getAbstractBaseFigureEditPart(this);
		if(abstractBaseFigureEditPart !=null){
			EStructuralFeature eStructuralFeature=null;
			if(abstractBaseFigureEditPart instanceof ProxyServiceEditPart){
				inputConnector = EsbFactory.eINSTANCE.createProxyInSequenceInputConnector();	
				eStructuralFeature=EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_INPUT_CONNECTORS;	
			}else if(abstractBaseFigureEditPart instanceof APIResourceEditPart){
				inputConnector = EsbFactory.eINSTANCE.createAPIResourceInSequenceInputConnector();
				eStructuralFeature=EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS;
			}
			
			AddCommand addCommand = new AddCommand(getEditingDomain(), ((Node) abstractBaseFigureEditPart.getModel()).getElement(),
					eStructuralFeature,inputConnector);
			if (addCommand.canExecute()) {
				getEditingDomain().getCommandStack().execute(addCommand);
			}
			abstractBaseFigureEditPart.getSendMediatorAndInSequenceInputConnectorMap()
					.put(inputConnector, sendMediatorEditPart);
		}
	}
	
	public void removeInSequenceInputConnector(SendMediatorEditPart sendMediatorEditPart) {
		Object baseFigureInSequenceInputConnector = null;
		AbstractBaseFigureEditPart abstractBaseFigureEditPart = EditorUtils.getAbstractBaseFigureEditPart(this);
		if(abstractBaseFigureEditPart !=null){
			Map<InputConnector, SendMediatorEditPart> map = EditorUtils
					.getAbstractBaseFigureEditPart(this)
					.getSendMediatorAndInSequenceInputConnectorMap();
			Iterator<InputConnector> inputconnectors = map.keySet().iterator();
			while (inputconnectors.hasNext()) {
				Object next = inputconnectors.next();
				if (sendMediatorEditPart.equals(map.get(next))) {
					baseFigureInSequenceInputConnector = next;
				}
			}	
		
			EStructuralFeature eStructuralFeature=null;
			if(abstractBaseFigureEditPart instanceof ProxyServiceEditPart){
				eStructuralFeature=EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_INPUT_CONNECTORS;	
			}else if(abstractBaseFigureEditPart instanceof APIResourceEditPart){
				eStructuralFeature=EsbPackage.Literals.API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS;
			}	
			
			RemoveCommand removeCmd = new RemoveCommand(getEditingDomain(), ((Node) abstractBaseFigureEditPart.getModel()).getElement(),
					eStructuralFeature,
					baseFigureInSequenceInputConnector);
			if (removeCmd.canExecute()) {
				getEditingDomain().getCommandStack().execute(removeCmd);
			}
		}
	}
	
		
	protected void removeChild(EditPart child) {
		connectRemainingElements(child);
		Display.getCurrent().asyncExec(new Runnable() {			
			@Override
			public void run() {		
				XYRepossition.resizeContainers((IGraphicalEditPart) instance);		
				XYRepossition.reArrange((IGraphicalEditPart) instance);
			}
		});
		super.removeChild(child);	
	}
	
	protected void addChild(EditPart child, int index) {
		super.addChild(child, index);
		
		if (child instanceof SendMediatorEditPart) {
			if (((SendMediator) ((Node) ((SendMediatorEditPart) child).getModel()).getElement())
					.getOutputConnector().getOutgoingLink() == null
					&& !((SendMediator) ((Node) ((SendMediatorEditPart) child).getModel())
							.getElement()).isReverse()) {
				if (this instanceof MediatorFlowMediatorFlowCompartmentEditPart) {
					addInSequenceInputConnector((SendMediatorEditPart) child);
				} else if (EditorUtils.getMediator(this) != null
						&& !EditorUtils.getMediator(this).reversed) {
					addInSequenceInputConnector((SendMediatorEditPart) child);
				}
			}
		}
		
		if (child instanceof SequenceEditPart) {
			SequenceEditPart sequenceEditPart = (SequenceEditPart) child;
			String sequenceName=null;
			String defaultName=sequenceEditPart.calculateDefaultName();
			EditPart editpart = (EditPart) ((StructuredSelection) sequenceEditPart
					.getViewer().getEditDomain().getPaletteViewer()
					.getSelection()).getFirstElement();
			if (editpart instanceof ToolEntryEditPart) {
				if (((ToolEntryEditPart) editpart).getModel() instanceof NodeToolEntry) {
					String label = ((NodeToolEntry) ((ToolEntryEditPart) editpart)
							.getModel()).getLabel();
					if ((!label.equals("")) && (!label.equals("Sequence Mediator"))) {
						sequenceName=label;
					}else{
						sequenceName=defaultName;
					}
					try{
						((Sequence) ((View) sequenceEditPart.getModel())
							.getElement()).setName(sequenceName);		
					}catch(java.lang.IllegalStateException e){
						log.error("This is occured while undo operation..", e);
					}
				} else if (((ToolEntryEditPart) editpart).getModel() instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart.NodeToolEntry) {
					String label = ((org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart.NodeToolEntry) ((ToolEntryEditPart) editpart)
							.getModel()).getLabel();
					if ((!label.equals("")) && (!label.equals("Sequence Mediator"))) {
						sequenceName=label;
					}else{
						sequenceName=defaultName;
					}
					((Sequence) ((View) sequenceEditPart.getModel())
							.getElement()).setName(sequenceName);
				}
			}
			
			EObject sequence = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (sequenceEditPart)
					.getModel()).getElement();
				if (((Sequence) sequence).getOutputConnector().size() == 0) {
					AddCommand addCmd = new AddCommand(getEditingDomain(), sequence,
							EsbPackage.Literals.SEQUENCE__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE.createSequenceOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
		}
		
		if(child instanceof CloudConnectorOperationEditPart){
			CloudConnectorOperationEditPart cloudConnectorOperationEditPart = (CloudConnectorOperationEditPart) child;
			EditPart editpart = (EditPart) ((StructuredSelection) cloudConnectorOperationEditPart
					.getViewer().getEditDomain().getPaletteViewer()
					.getSelection()).getFirstElement();
			
			IEditorPart editorpart = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
			if(editorpart!=null && !EditorUtils.isLockmode(((EsbMultiPageEditor)editorpart).getGraphicalEditor())){			
				if (editpart instanceof ToolEntryEditPart) {
					if (((ToolEntryEditPart) editpart).getModel() instanceof NodeToolEntry) {
						String id = ((NodeToolEntry) ((ToolEntryEditPart) editpart)
								.getModel()).getId();
						try{
							String[] splittedString = id.split("-");
							String groupName="";
							if(splittedString.length>1){
								groupName = splittedString[1];
							}						
							((CloudConnectorOperation) ((View) cloudConnectorOperationEditPart.getModel())
								.getElement()).setConnectorName(getCloudConnectorDirectoryTraverser(groupName.toLowerCase()).getCloudConnectorName());	
							
							((CloudConnectorOperation) ((View) cloudConnectorOperationEditPart.getModel())
									.getElement()).setCloudConnectorName(groupName.toLowerCase());	
							
							((CloudConnectorOperation) ((View) cloudConnectorOperationEditPart.getModel())
									.getElement()).setOperationName(((NodeToolEntry) ((ToolEntryEditPart) editpart).getModel()).getLabel());	
			
							((CloudConnectorOperation) ((View) cloudConnectorOperationEditPart.getModel())
									.getElement()).setDescription(((NodeToolEntry) ((ToolEntryEditPart) editpart).getModel()).getLabel());	
							
							cloudConnectorOperationEditPart.fillConnectorOperationParameters();						
							
						}catch(java.lang.IllegalStateException e){
							log.error("This is occured while undo operation..", e);
						}
					}
				}
			}
			cloudConnectorOperationEditPart.setIconPath();
			CloudConnectorOperationFigure localPrimaryShape = (CloudConnectorOperationFigure)cloudConnectorOperationEditPart.tempPrimaryShape;
			if(localPrimaryShape !=null){				
				localPrimaryShape.setCloudConnectorImage();
			}
		}
	}
	
	
	private CloudConnectorDirectoryTraverser getCloudConnectorDirectoryTraverser(String droppedCloudConnector){
		IEditorPart editorpart = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();
		EsbEditorInput input = (EsbEditorInput) editorpart.getEditorInput();
		IFile file = input.getXmlResource();
		IProject activeProject = file.getProject();
		//String connectorPath = activeProject.getLocation().toOSString() + File.separator
		//		+ "cloudConnectors" + File.separator + droppedCloudConnector+"-connector";
		String connectorPath = CloudConnectorDirectoryTraverser.getInstance()
				.getConnectorDirectoryPathFromConnectorName(
						activeProject.getWorkspace().getRoot().getLocation().toOSString(),
						droppedCloudConnector);
		return CloudConnectorDirectoryTraverser.getInstance(connectorPath);
	}
	
	
	private void connectRemainingElements(EditPart child){	
		if(child instanceof AbstractMediator){
		ConnectionUtils.createConnection(((AbstractMediator)child).getConnectedInputConnector(), ((AbstractMediator)child).getConnectedOutputConnector());
		}
	}
}

