package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolygonDecoration;
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
		return new PolylineConnectionEx();
		/*		PolylineConnectionEx figure = new PolylineConnectionEx();
		 PolygonDecoration decoration = new PolygonDecoration();
		 decoration.setScale(12, 4);
		 decoration.setAlpha(250);
		 decoration.setBackgroundColor(new Color(null, 50, 50, 50));
		 decoration.setOutline(false);
		 figure.setTargetDecoration(decoration);
		 figure.setAlpha(150);
		 figure.setLineWidthFloat(0.5f);

		 // Need to execute this operation as a command.
		 AbstractEMFOperation command = new AbstractEMFOperation(getEditingDomain(),
		 "change-esb-link-routing-style") {
		 protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
		 throws ExecutionException {
		 RoutingStyle style = (RoutingStyle) ((View) getModel())
		 .getStyle(NotationPackage.Literals.ROUTING_STYLE);
		 style.setRouting(Routing.RECTILINEAR_LITERAL);
		 style.setRoundedBendpointsRadius(5);
		 return Status.OK_STATUS;
		 }
		 };

		 try {
		 OperationHistoryFactory.getOperationHistory().execute(command, null, null);
		 } catch (ExecutionException ex) {
		 // Ignore.
		 }

		 return figure;*/
	}

	/**
	 * @generated
	 */
	public PolylineConnectionEx getPrimaryShape() {
		return (PolylineConnectionEx) getFigure();
	}

}
