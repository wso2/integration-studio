package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class SequenceOpenEditPolicy extends OpenEditPolicy {

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	protected Command getOpenCommand(Request request) {
		if (getTargetEditPart(request) instanceof SequenceEditPart) {

			try {
				((SequenceEditPart) getTargetEditPart(request)).createDialogBox();
			} catch (Exception e) {
				log.error("Cannot open sequence file " , e);
				MessageDialog.openError(Display.getCurrent().getActiveShell(), "Cannot open sequence file ",
						e.getLocalizedMessage());
			}
		}
		return  null;
	}

}
