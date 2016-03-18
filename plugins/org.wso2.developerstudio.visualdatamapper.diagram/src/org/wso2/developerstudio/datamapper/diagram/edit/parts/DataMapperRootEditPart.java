package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.common.ui.services.action.global.GetGlobalActionHandlerOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.DataMapperRootCanonicalEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.DataMapperRootItemSemanticEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;

/**
 * @generated
 */
public class DataMapperRootEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "DataMapper"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public DataMapperRootEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DataMapperRootItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new DataMapperRootCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
				DataMapperVisualIDRegistry.TYPED_INSTANCE));
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

/*  
 * Set color theme from preference store colors
 *   protected IFigure createFigure() {
		  IFigure fig = super.createFigure();
		  fig.setBackgroundColor(new Color(null, 246,255,255));
		  fig.setOpaque(true);
		 
		  return fig;
		}*/


}
