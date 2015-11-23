package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.ConfigureCloneMediatorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.ConfigureURLrewriteruleDialog;

public class ConfigureURLRewriteMediatorAction  extends ConfigureEsbNodeAction  {
	public static final String URLREWRITE_MEDIATOR_ACTION_CONFIGURATOR_ID = "configure-urlRewrite-mediator-action-id";
	public ConfigureURLRewriteMediatorAction(IWorkbenchPart part) {
		super(part);
		setId(URLREWRITE_MEDIATOR_ACTION_CONFIGURATOR_ID);
		setText("Configure...");
		setToolTipText("Configure  URLRewrite mediator.");
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();		
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		EditPart selectedEP = getSelectedEditPart();
		Assert.isNotNull(selectedEP, "Empty selection.");
		
		EObject selectedObj = ((View) selectedEP.getModel()).getElement();
		Assert.isTrue(selectedObj instanceof URLRewriteMediator, "Invalid selection.");

		Display display = Display.getDefault();
		Shell shell = new Shell(display);	
		
		Dialog urlMediatorConfigurDialog = new ConfigureURLrewriteruleDialog(shell,(URLRewriteMediator)selectedObj,TransactionUtil.getEditingDomain(selectedObj));
		
		urlMediatorConfigurDialog.setBlockOnOpen(true);
		urlMediatorConfigurDialog.open();
		
	}

}
