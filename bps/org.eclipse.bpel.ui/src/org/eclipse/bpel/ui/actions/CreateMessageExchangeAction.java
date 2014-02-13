package org.eclipse.bpel.ui.actions;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;

public class CreateMessageExchangeAction extends AbstractDeclarationAction {

	public CreateMessageExchangeAction(EditPart anEditPart) {
		super(anEditPart);
	}

	
	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_MESSAGEEXCHANGE_16);
	}

	
	public EObject getParent() {
		EStructuralFeature feature = ((EObject)modelObject).eClass().getEStructuralFeature("messageExchanges");
		if (feature!=null) {
			parent = (EObject) ((EObject)modelObject).eGet(feature);
		}
		return parent;
	}

	
	public EObject getChild() {
		if (child==null)
			child = BPELFactory.eINSTANCE.createMessageExchange();
		return child;
	}
}
