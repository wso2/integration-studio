package org.wso2.developerstudio.eclipse.gmf.keyhandlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ESBKeyHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public ESBKeyHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//EsbMultiPageEditor x;
		IEditorPart editorReferences[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditors();
		for (int i = 0; i < editorReferences.length; i++) {
		  IEditorPart editor = editorReferences[i];
		  if (editor instanceof EsbMultiPageEditor) {
			  ((EsbMultiPageEditor) editor).focusToolbar();
		  }
		}

		return null;
	}
}
