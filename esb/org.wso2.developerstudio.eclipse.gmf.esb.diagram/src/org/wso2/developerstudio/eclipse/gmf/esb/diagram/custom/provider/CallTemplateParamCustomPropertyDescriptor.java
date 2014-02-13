package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.CallTemplateParamDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.ConfigureLogMediatorDialog;

public class CallTemplateParamCustomPropertyDescriptor extends PropertyDescriptor {

	public CallTemplateParamCustomPropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
	}
   
	public CellEditor createPropertyEditor(Composite parent) {
		return new ExtendedDialogCellEditor(parent, getLabelProvider()) {
			
			protected Object openDialogBox(Control cellEditorWindow) {
				Display display = Display.getDefault();
				Shell shell = new Shell(display);
				Mediator mediator =(Mediator)object;
				if(mediator instanceof CallTemplateMediator){
					mediator = (CallTemplateMediator)mediator;
				}else if(mediator instanceof CloudConnectorOperation){
					mediator = (CloudConnectorOperation)mediator;
				}
			
				CallTemplateParamDialog callTemplateParamDialog = new CallTemplateParamDialog(shell,
						mediator,TransactionUtil.getEditingDomain(mediator));
				callTemplateParamDialog.setBlockOnOpen(true);
				callTemplateParamDialog.open();
				return null;
			}
		};
	}
}
