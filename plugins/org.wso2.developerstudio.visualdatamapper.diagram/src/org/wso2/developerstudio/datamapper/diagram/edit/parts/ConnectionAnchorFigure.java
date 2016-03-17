package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class ConnectionAnchorFigure extends Figure implements ConnectoinAnchor {
	  private RectangleFigure rectangle;
	  private ConnectionAnchor connectionAnchor;
	   
	  public ConnectionAnchorFigure() {
	    setLayoutManager(new XYLayout());
	    rectangle = new RectangleFigure();
	    add(rectangle);
	  }
	 
	  @Override protected void paintFigure(Graphics graphics) {
	    Rectangle r = getBounds().getCopy();
	    setConstraint(rectangle, new Rectangle(0, 0, r.width, r.height));
	    rectangle.invalidate();
	  }
	   
	  public ConnectionAnchor getConnectionAnchor() {
	    if (connectionAnchor == null) {
	      connectionAnchor = new ChopboxAnchor(this);
	    }
	    return connectionAnchor;
	  }
	


}
