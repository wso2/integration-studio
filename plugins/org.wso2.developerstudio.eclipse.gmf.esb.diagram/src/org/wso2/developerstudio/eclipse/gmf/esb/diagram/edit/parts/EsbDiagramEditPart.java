package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.EsbDiagramCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.EsbDiagramItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated
 */
public class EsbDiagramEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Esb"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public EsbDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EsbDiagramItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new EsbDiagramCanonicalEditPolicy());
		final FigureCanvas canvas = (FigureCanvas) getViewer().getControl();
		canvas.addControlListener(new ControlListener() {

			public void controlResized(ControlEvent e) {
				canvas.getViewport().repaint();

			}

			public void controlMoved(ControlEvent e) {
				canvas.getViewport().repaint();
			}
		});

		canvas.getHorizontalBar().addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				canvas.getViewport().repaint();
				super.widgetSelected(e);
			}
		});
		canvas.getVerticalBar().addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				canvas.getViewport().repaint();
				super.widgetSelected(e);
			}
		});

		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	/**
	 * @generated NOT
	 */
	/*package-local*/
	static class NodeLabelDragPolicy extends NonResizableEditPolicy {
	}

}
