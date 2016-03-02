package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.NamespacedPropertyEditorDialog;
 
public class EnrichSourceXPathPropertyDescriptor extends PropertyDescriptor {
 
	public EnrichSourceXPathPropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
	}
 
	
	public CellEditor createPropertyEditor(Composite parent) {
		return new ExtendedDialogCellEditor(parent, getLabelProvider()) {
			
			protected Object openDialogBox(Control cellEditorWindow) {
				Display display = Display.getDefault();
				Shell shell = new Shell(display);
				EnrichMediator enrichMediator = (EnrichMediator) object;
				 //.getEditingDomain()
				NamespacedPropertyEditorDialog enrichMediatorConfigurationDialog = new NamespacedPropertyEditorDialog(shell, enrichMediator.getSourceXpath());
				//enrichMediatorConfigurationDialog.setBlockOnOpen(true);
				enrichMediatorConfigurationDialog.open();
				return null;
			}
		};
	}
 
}
