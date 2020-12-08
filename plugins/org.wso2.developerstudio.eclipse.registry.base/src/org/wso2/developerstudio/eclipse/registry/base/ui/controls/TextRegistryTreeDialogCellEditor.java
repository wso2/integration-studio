package org.wso2.developerstudio.eclipse.registry.base.ui.controls;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.ui.dialog.RegistryTreeBrowserDialog;
import org.wso2.developerstudio.eclipse.ui.widgets.TextAndDialogCellEditor;

public class TextRegistryTreeDialogCellEditor extends TextAndDialogCellEditor{
	private RegistryNode registryNode;
	public TextRegistryTreeDialogCellEditor(Composite parent, ILabelProvider lp, RegistryNode registryNode) {
		super(parent, lp);
		setRegistryNode(registryNode);
	}

	protected Object openDialogBox(Control arg0) {
		RegistryTreeBrowserDialog dialog = new RegistryTreeBrowserDialog(getControl().getShell(), RegistryTreeBrowserDialog.SELECT_REGISTRY_PATH | RegistryTreeBrowserDialog.SELECT_REGISTRY_RESOURCE);
		dialog.create();
		dialog.addRegistryNode(getRegistryNode().getRegistryUrlInfo(), getRegistryNode().getPassword());	
		if (dialog.open()==Window.OK){
			RegistryResourceNode node = dialog.getSelectedRegistryResourceNode()==null?dialog.getSelectedRegistryResourceNodeResource():dialog.getSelectedRegistryResourceNode();
			return node.getRegistryResourcePath();
		}else{
			return null;
		}
	}

	public void setRegistryNode(RegistryNode registryNode) {
		this.registryNode = registryNode;
	}

	public RegistryNode getRegistryNode() {
		return registryNode;
	}

}
