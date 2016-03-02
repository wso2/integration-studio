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
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.CallTemplateParamDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.ConfigureProxyWSDLResourceDialog;

public class ProxyServiceWSDLResourcePropertyDescriptor extends PropertyDescriptor {

	public ProxyServiceWSDLResourcePropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
		// TODO Auto-generated constructor stub
	}
	
	public CellEditor createPropertyEditor(Composite parent) {
		return new ExtendedDialogCellEditor(parent, getLabelProvider()) {
			
			protected Object openDialogBox(Control cellEditorWindow) {
				Display display = Display.getDefault();
				Shell shell = new Shell(display);
				ProxyService proxy = (ProxyService)object;
			
				ConfigureProxyWSDLResourceDialog callTemplateParamDialog = new ConfigureProxyWSDLResourceDialog(shell,proxy);
				callTemplateParamDialog.setBlockOnOpen(true);
				callTemplateParamDialog.open();
				return null;
			}
		};
	}

}
