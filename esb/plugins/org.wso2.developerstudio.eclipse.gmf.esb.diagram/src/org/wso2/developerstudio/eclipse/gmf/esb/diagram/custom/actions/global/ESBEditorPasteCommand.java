package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.actions.global;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DuplicateRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ConnectionUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbLinkEditPart;

public class ESBEditorPasteCommand extends org.eclipse.gmf.runtime.common.core.command.AbstractCommand{
	
	private AbstractConnectorEditPart target;
	private AbstractConnectorEditPart source;	
	private Map<AbstractConnectorEditPart,AbstractConnectorEditPart> connectors=new HashMap<AbstractConnectorEditPart, AbstractConnectorEditPart>();
	List targetConnections=null;
	List sourceConnections=null;	
	
	public ESBEditorPasteCommand(String label, IGraphicalEditPart target) {
		super(label);		
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		if(ESBClipboard.hasThingsToCopy()){
			duplicate();	
		}		
		return null;
	}

	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		return null;
	}

	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		return null;
	}	
	
	private void duplicate() {
		DuplicateRequest request = new DuplicateRequest();
		List<IGraphicalEditPart> editParts = new ArrayList<IGraphicalEditPart>();
		editParts = ESBClipboard.getToCopyEditParts();
		removeLinks(editParts);
		((DuplicateRequest) request).setEditParts(editParts);

		IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
				.getActivePart();

		if (part instanceof IDiagramWorkbenchPart) {
			Command cmd = ((IDiagramWorkbenchPart) part).getDiagramEditPart().getCommand(
					(Request) request);
			if (cmd != null && cmd.canExecute()) {
				editParts.get(0).getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
			}
		}else {
		}
		if(!ESBClipboard.isCut()){
			connect();
		}else{
			deleteElement(editParts);
			ESBClipboard.setCut(false);
			ESBClipboard.getToCopyEditParts().clear();
		}
	}
	
	private List<IGraphicalEditPart> removeLinks(List<IGraphicalEditPart> list){
		for(IGraphicalEditPart editPart:list){
			for(Object child: editPart.getChildren()){
				if(child instanceof AbstractConnectorEditPart){	
					
					targetConnections=((AbstractConnectorEditPart)child).getTargetConnections();					
					storeAndDelete(targetConnections, editPart);				
					
					sourceConnections=((AbstractConnectorEditPart)child).getSourceConnections();
					storeAndDelete(sourceConnections, editPart);	
				}				
			}
			
		}
		return list;
	}
	
	private void storeAndDelete(List<EsbLinkEditPart> connections,IGraphicalEditPart editPart){
		if(!connections.isEmpty()){
			if(connections.size()>1){
				/*
				 * There was a concurrent exception due to 'for-each' loop. So that we have put a 'if-else' for aviod disturbance for elements having
				 * only one link. But now we have get rid of 'for-each' and have put old 'for' loop. But didn't remove if-else. We can remove 'if-else' after doing 
				 * adequate testing.     
				 */
				for(int i=0;i<connections.size();++i){
					target=(AbstractConnectorEditPart) ((EsbLinkEditPart)connections.get(i)).getTarget();
					source=(AbstractConnectorEditPart) ((EsbLinkEditPart)connections.get(i)).getSource();	
					connectors.put(target, source);
					
					deleteLink((EsbLinkEditPart)connections.get(i),editPart);
				}							
			}else{
				target=(AbstractConnectorEditPart) ((EsbLinkEditPart)connections.get(0)).getTarget();
				source=(AbstractConnectorEditPart) ((EsbLinkEditPart)connections.get(0)).getSource();	
				connectors.put(target, source);
				
				deleteLink((EsbLinkEditPart)connections.get(0),editPart);
			}
			
		}
	}
	
	
	private void deleteLink(EsbLinkEditPart link,IGraphicalEditPart editPart){
		Collection col = new ArrayList();
		col.add(((org.eclipse.gmf.runtime.notation.impl.ConnectorImpl) link
				.getModel()).getElement());

		org.eclipse.emf.edit.command.DeleteCommand del = new org.eclipse.emf.edit.command.DeleteCommand(
				editPart.getEditingDomain(), col);
		if (del.canExecute()) {
			editPart.getEditingDomain().getCommandStack().execute(del);
		}

		DeleteCommand delCmd = new DeleteCommand(link
				.getNotationView());
		CompoundCommand dl = new CompoundCommand("Delete Link");
		dl.add(new ICommandProxy(delCmd));
		if (delCmd.canExecute()) {
			editPart.getDiagramEditDomain().getDiagramCommandStack().execute(dl);
		}
	}
	
	private void deleteElement(List<IGraphicalEditPart> editParts) {
		for (int i = 0; i < editParts.size(); ++i) {
			Collection<EObject> col = new ArrayList<EObject>();
			col.add(((Node) editParts.get(i).getModel()).getElement());
			org.eclipse.emf.edit.command.DeleteCommand del = new org.eclipse.emf.edit.command.DeleteCommand(
					editParts.get(i).getEditingDomain(), col);
			if (del.canExecute()) {
				editParts.get(i).getEditingDomain().getCommandStack().execute(del);
			}
		}
	}
	
	private void connect(){		
		for(int i=0;i<connectors.keySet().toArray().length;++i){
			ConnectionUtils.createConnection((AbstractConnectorEditPart) connectors.keySet().toArray()[i],connectors.get(connectors.keySet().toArray()[i]));
		}
	}
	
}
