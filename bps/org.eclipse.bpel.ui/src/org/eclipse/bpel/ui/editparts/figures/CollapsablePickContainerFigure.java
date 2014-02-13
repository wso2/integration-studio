package org.eclipse.bpel.ui.editparts.figures;

import org.eclipse.bpel.ui.editparts.borders.PickBorder;
import org.eclipse.swt.graphics.Image;

/**
 * A CollapsableContainerFigure which has a new PickBorder.
 * @author ascharf
 *
 */
public class CollapsablePickContainerFigure extends CollapsableContainerFigure {
	
	public CollapsablePickContainerFigure(Object modelObject, Image image, String text){
		super(modelObject, image, text);
	}

	
	protected void initializeBorder() {
		this.border = new PickBorder(this, this.borderImage, this.borderText);
	}
}
