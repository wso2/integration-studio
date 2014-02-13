package org.eclipse.bpel.ui.actions;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;

public class CreatePartnerLinkAction extends AbstractDeclarationAction {

	public CreatePartnerLinkAction(EditPart anEditPart) {
		super(anEditPart);
	}

	
	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_PARTNERLINK);
	}

	
	public EObject getParent() {
		EStructuralFeature feature = ((EObject)modelObject).eClass().getEStructuralFeature("partnerLinks");
		if (feature!=null) {
			parent = (EObject) ((EObject)modelObject).eGet(feature);
		}
		return parent;
	}

	
	public EObject getChild() {
		if (child==null)
			child = BPELFactory.eINSTANCE.createPartnerLink();
		return child;
	}
}
