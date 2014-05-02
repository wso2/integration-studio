package org.wso2.developerstudio.datamapper.diagram.custom.part;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DiagramGraphicalViewerKeyHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.datamapper.diagram.part.DeleteElementAction;

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
			deleteAction.run(null);		
			return true; 			
		}	
		
		return super.keyPressed(event);
	}
	
	
}
