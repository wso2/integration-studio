package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CallTemplateMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DataMapperMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.NamedEndpointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;



public class OpenSeparatelyEditPolicy extends OpenEditPolicy {

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	protected Command getOpenCommand(Request request) {
		if (getTargetEditPart(request) instanceof SequenceEditPart) {
			String name=((Sequence)((Node)((SequenceEditPart)getTargetEditPart(request)).getModel()).getElement()).getName();
			if(!"{XPath}".equals(name) && ! (name.startsWith("conf:") || name.startsWith("gov:"))){
				if(!name.contains(System.getProperty("file.separator"))){
					try {
						((SequenceEditPart) getTargetEditPart(request)).createDialogBox();
					} catch (Exception e) {
						log.error("Cannot open sequence file ", e);
						MessageDialog.openError(Display.getCurrent().getActiveShell(), "Cannot open sequence file ",
								e.getLocalizedMessage());
					}
				}else {
					MessageDialog
					.openError(
							Display.getCurrent().getActiveShell(),
							"Invalid sequence name ! ",
							"Cannot open the file with name \""+name+"\". Try removing file separator from the name if exists.");
				}				
			}
			
		}else if(getTargetEditPart(request) instanceof NamedEndpointEditPart){
			String name=((NamedEndpoint)((Node)((NamedEndpointEditPart)getTargetEditPart(request)).getModel()).getElement()).getName();
			if(name!=null){
				if(!"{XPath}".equals(name) && !(name.startsWith("conf:") || name.startsWith("gov:"))){					
					if(!name.contains(System.getProperty("file.separator"))){
						((NamedEndpointEditPart) getTargetEditPart(request)).createDialogBox();
					}else {
						MessageDialog
						.openError(
								Display.getCurrent().getActiveShell(),
								"Invalid endpoint name ! ",
								"Cannot open the file with name \""+name+"\". Try removing file separator from the name if exists.");
					}					
				}
			}else{
				((NamedEndpointEditPart) getTargetEditPart(request)).createDialogBox();
			}
			
		}else if(getTargetEditPart(request) instanceof ComplexFiguredAbstractEndpoint){
			((ComplexFiguredAbstractEndpoint)getTargetEditPart(request)).openPage();
		}else if (getTargetEditPart(request) instanceof CallTemplateMediatorEditPart) {
			String targetTemplate=((CallTemplateMediator)((Node)((CallTemplateMediatorEditPart)getTargetEditPart(request)).getModel()).getElement()).getTargetTemplate();
				if(!targetTemplate.contains(System.getProperty("file.separator"))){
					((CallTemplateMediatorEditPart) getTargetEditPart(request)).createDialogBox();
				}else {
					MessageDialog
					.openError(
							Display.getCurrent().getActiveShell(),
							"Invalid Template name ! ",
							"Cannot open the file with name \""+targetTemplate+"\". Try removing file separator from the name if exists.");
				}
			
		}else if (getTargetEditPart(request) instanceof DataMapperMediatorEditPart) {

			((DataMapperMediatorEditPart)getTargetEditPart(request)).openDataMapperDiagram();

		}
		return  null;
	}

}
