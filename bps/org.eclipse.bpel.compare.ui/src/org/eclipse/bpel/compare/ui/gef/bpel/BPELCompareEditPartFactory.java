package org.eclipse.bpel.compare.ui.gef.bpel;

import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPartViewer;

public class BPELCompareEditPartFactory extends
		org.eclipse.bpel.ui.editparts.util.BPELEditPartFactory {

	String GRAPHICAL_ROLE = "GraphicalEditPolicy";
	
	private static WeakHashMap<EObject, EditPart> model2editPart = 
		new WeakHashMap<EObject, EditPart>();
	
	public static EditPart getEditPart(EObject model) {
		return model2editPart.get(model);
	}
	
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart editPart = super.createEditPart(context, model);
		model2editPart.put((EObject) editPart.getModel(), editPart);
		updateEditPolicy(editPart);
		return editPart;
	}

	private void updateEditPolicy(EditPart editPart) {
		if (editPart == null) {
			return;
		}
		editPart.installEditPolicy(GRAPHICAL_ROLE, new BPELCompareEditPolicy());
		editPart.addEditPartListener(new EditPartListener.Stub() {
			@Override
			public void selectedStateChanged(EditPart editpart) {
				if (editpart.getSelected() != EditPart.SELECTED_NONE) {
					EditPartViewer viewer = editpart.getViewer();
					EditPartFactory uiFactory = viewer.getEditPartFactory();
					if (uiFactory instanceof BPELCompareEditPartFactory) {
						BPELContentMergeViewer mergeViewer =
							BPELContentMergeViewer.getBPELContentMergeViewer(
								(BPELCompareEditPartFactory) uiFactory);
						mergeViewer.selectionChanged(viewer);
					}
				}
			}
		});
		
		for (Object child : editPart.getChildren()) {
			if (child instanceof EditPart) {
				updateEditPolicy((EditPart) child);
			}
		}
	}

}
