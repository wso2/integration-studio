package org.eclipse.bpel.ui.editparts.borders;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Image;

/**
 * Basically a container border which is able to add some 
 * extra vertical space based on the orientation of a pick
 * @author ascharf
 *
 */
public class PickBorder extends ContainerBorder {
	
	private boolean horizontal;
	
	static final int marginLeft = 20;
	static final int marginRight = 0;
	
	public PickBorder(IFigure parentFigure, Image image, String labelText){
		super(parentFigure, image, labelText);
	}
	
	
	public Insets getInsets(IFigure figure) {
		Insets ins = super.getInsets(figure);
		if(horizontal){
			ins.left += marginLeft;
			ins.right += marginRight;
		}
		return ins;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
}
