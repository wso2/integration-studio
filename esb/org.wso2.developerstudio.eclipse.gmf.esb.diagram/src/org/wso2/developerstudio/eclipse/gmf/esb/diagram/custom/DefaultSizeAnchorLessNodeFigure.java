package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

public class DefaultSizeAnchorLessNodeFigure extends DefaultSizeNodeFigure {
	
	public DefaultSizeAnchorLessNodeFigure(int width, int height) {
		super(width, height);
	}
	
	public ConnectionAnchor getSourceConnectionAnchorAt(Point p) {
		return null;
	}

	public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
		return null;
	}	
}
