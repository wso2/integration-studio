package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.ThrottlePolicyEntryDialog;

public class ThrottlePolicyEntryPropertyDescriptor extends PropertyDescriptor {

	public ThrottlePolicyEntryPropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
		
	}
	
	public CellEditor createPropertyEditor(Composite parent) {
		return new ExtendedDialogCellEditor(parent, getLabelProvider()) {
			
			protected Object openDialogBox(Control cellEditorWindow) {
				Display display = Display.getDefault();
				Shell shell = new Shell(display);
				
				ThrottleMediator throttleMediator = (ThrottleMediator)object;
				
		        ThrottlePolicyEntryDialog policyEntryDialog = new ThrottlePolicyEntryDialog(shell,throttleMediator);
		        policyEntryDialog.setBlockOnOpen(true);
		        policyEntryDialog.open();
				return null;
			}
		};
	}

}
