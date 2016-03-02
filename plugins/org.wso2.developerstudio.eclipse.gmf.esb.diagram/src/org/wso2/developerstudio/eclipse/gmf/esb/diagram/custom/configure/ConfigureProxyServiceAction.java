package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.ConfigureProxyServiceDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.ConfigureSwitchMediatorDialog;

public class ConfigureProxyServiceAction extends ConfigureEsbNodeAction{

	public ConfigureProxyServiceAction(IWorkbenchPart part) {
		super(part);
		setId("configure-proxy-service-action-id");
		setText("Configure...");
		setToolTipText("Configure proxy service.");
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();		
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	
	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();
		Assert.isNotNull(selectedEP, "Empty selection.");
		
		EObject selectedObj = ((View) selectedEP.getModel()).getElement();
		Assert.isTrue(selectedObj instanceof ProxyService, "Invalid selection.");

		Display display = Display.getDefault();
		Shell shell = new Shell(display);		
		Dialog ConfigureProxyServiceDialog = new ConfigureProxyServiceDialog(shell, (ProxyService) selectedObj);
		ConfigureProxyServiceDialog.setBlockOnOpen(true);
		ConfigureProxyServiceDialog.open();
		
	}

}
