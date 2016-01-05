package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;


import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DiagramGraphicalViewerKeyHandler;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;

public class CustomDiagramGraphicalViewerKeyHandler extends DiagramGraphicalViewerKeyHandler{	
	private DeleteElementAction deleteAction;
	IWorkbenchPart part;	
	
	public CustomDiagramGraphicalViewerKeyHandler(IWorkbenchPart part,GraphicalViewer viewer) {
		super(viewer);
		this.part=part;
		deleteAction = new DeleteElementAction(part);
		deleteAction.init();
		deleteAction.setAccelerator(SWT.DEL);
		//viewer.getContents().getViewer()viewer.getEditDomain().get
		// TODO Auto-generated constructor stub
	}
	
	public boolean keyPressed(KeyEvent event) {
		
		
		switch (event.keyCode) {
		case SWT.DEL :
			ESBDebuggerUtil.setDeleteOperationPerformed(true);
			deleteAction.run(null);		
			return true; 			
		}	
		
		return super.keyPressed(event);
	}
	
	
}
