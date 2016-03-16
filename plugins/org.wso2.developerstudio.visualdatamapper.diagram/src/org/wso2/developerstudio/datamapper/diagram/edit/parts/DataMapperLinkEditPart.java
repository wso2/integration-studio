package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.custom.CustomNonResizableEditPolicyEx;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.DataMapperLinkItemSemanticEditPolicy;

/**
 * @generated
 */
public class DataMapperLinkEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;
	
	/**
	 * @generated NOT
	 */
	protected int alpha = 255;

	/**
	 * @generated
	 */
	public DataMapperLinkEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.DataMapperLinkItemSemanticEditPolicy());

		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new CustomNonResizableEditPolicyEx()); // remove selection

		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated NOT
	 */
	protected Connection createConnectionFigure() {
		PolylineConnection connection = new PolylineConnection() {

			@Override
			public void paintFigure(Graphics graphics) {
				graphics.setAlpha(alpha);
				graphics.setLineWidth(3);
				Color black = new Color(null, 0, 0, 0);
				graphics.setBackgroundColor(black);
				graphics.setForegroundColor(black);
				super.paintFigure(graphics);
			}

			public PointList getPoints() {
				
				boolean startLeft = false;
				boolean targetLeft = true;

				PointList list = super.getPoints();
				if (list.size() == 0)
					return list;
				Point start = getStart();
				int slength = 20;
				int tlength = 20;
				if (startLeft) {
					slength = (-slength);
				}
				if (targetLeft) {
					tlength = (-tlength);
				}

				Point start2 = new Point(start.x + slength, start.y);
				Point end = getEnd();
				Point end2 = new Point(end.x + tlength, end.y);
				list.removeAllPoints();
				list.addPoint(start);
				list.addPoint(start2);
				list.addPoint(end2);///new Color(null, 0, 125, 133)
				list.addPoint(end);
				return list;
			}
			
			
		};
//		connection.setBackgroundColor(new Color(null, 0, 0, 0));
//		connection.setForegroundColor(new Color(null, 0, 125, 133));
		connection.setConnectionRouter(new ManhattanConnectionRouter());
		return connection;
	}
	
	/**
	 * @generated
	 */
	public PolylineConnectionEx getPrimaryShape() {
		return (PolylineConnectionEx) getFigure();
	}

}
