package org.wso2.integrationstudio.datamapper.diagram.edit.parts.custom;


import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ElementEditPart;

public class CustomSelectionEditPolicy extends SelectionEditPolicy{
	protected void showSelection() {
		setselected(true);
	}

	protected void hideSelection() {
		setselected(false);
	}
		
	private void setselected(boolean isselected) {
		
		if (isselected) { 
			if(getHost() instanceof ElementEditPart) {
				ElementEditPart ElementEditPart = (ElementEditPart)getHost();
				ElementEditPart.highlightElementItem();
			}
		} else {
			if(getHost() instanceof ElementEditPart) {
				ElementEditPart ElementEditPart = (ElementEditPart)getHost();
				ElementEditPart.removeHighlightOnElem();
			}
		}
		
	}

}
