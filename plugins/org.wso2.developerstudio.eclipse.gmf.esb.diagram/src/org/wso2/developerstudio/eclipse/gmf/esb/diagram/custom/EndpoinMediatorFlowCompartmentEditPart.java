package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.internal.ui.palette.editparts.ToolEntryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.NamedEndpointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbPaletteFactory.NodeToolEntry;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class EndpoinMediatorFlowCompartmentEditPart extends AbstractMediatorCompartmentEditPart {


	protected static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public EndpoinMediatorFlowCompartmentEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	public String getCompartmentName() {
		//return Messages.MediatorFlowMediatorFlowCompartment19EditPart_title;
		return null;
	}
	
	
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(false);
		// Override default border.
		LineBorder border = new LineBorder(new Color(null, 224, 224, 224), 1, SWT.BORDER_DASH);
		result.setBorder(border);
		result.setToolTip((String) null);
		return result;
	}
	
	protected void addChild(EditPart child, int index) {
		super.addChild(child, index);
		if (child instanceof NamedEndpointEditPart) {
			NamedEndpointEditPart namedEndPointEditPart = (NamedEndpointEditPart) child;
			EditPart editpart = (EditPart) ((StructuredSelection) namedEndPointEditPart.getViewer()
					.getEditDomain().getPaletteViewer().getSelection()).getFirstElement();
			if (editpart instanceof ToolEntryEditPart) {
				if (((ToolEntryEditPart) editpart).getModel() instanceof NodeToolEntry) {
					String label = ((NodeToolEntry) ((ToolEntryEditPart) editpart).getModel())
							.getLabel();
					if ((!label.equals("")) && (!label.equals("Named EndPoint"))) {
						try {
							((NamedEndpoint) ((View) namedEndPointEditPart.getModel()).getElement())
									.setName(label);
						} catch (java.lang.IllegalStateException e) {
							log.error("This is occured while undo operation..", e);
						}
					}
				}
			}
		}
	}
	

	
	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	public boolean isSelectable() {
		// TODO This or using ResizableEditpolicy?
		return false;
	}

}
