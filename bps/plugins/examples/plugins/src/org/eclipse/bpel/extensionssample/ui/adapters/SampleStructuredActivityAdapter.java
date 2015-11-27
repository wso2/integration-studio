package org.eclipse.bpel.extensionssample.ui.adapters;

import org.eclipse.bpel.extensionsample.model.ModelPackage;
import org.eclipse.bpel.ui.adapters.ContainerActivityAdapter;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.delegates.ActivityContainer;
import org.eclipse.bpel.ui.editparts.SequenceEditPart;
import org.eclipse.gef.EditPart;

public class SampleStructuredActivityAdapter extends ContainerActivityAdapter {

	@Override
	protected IContainer createContainerDelegate() {
		return new ActivityContainer(ModelPackage.eINSTANCE.getSampleStructuredActivity_Activity());
	}
	
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new SequenceEditPart();
		result.setModel(model);
		return result;
	}

}
