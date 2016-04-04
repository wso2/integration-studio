/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.tray;

import org.eclipse.bpel.common.ui.decorator.EditPartMarkerDecorator;
import org.eclipse.bpel.common.ui.layouts.AlignedFlowLayout;
import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;


/**
 * Main EditPart for the Tray.
 */
public class MainTrayEditPart extends TrayContainerEditPart {

	/**
	 * 
	 */
	public static final int SCROLL_STEP = 20;
	
	protected class MainTrayTitleFigure extends SelectionBorderFigure implements HandleBounds {
		/**
		 * 
		 */
		public MainTrayTitleFigure() {
			super();
			setOpaque(true);
			AlignedFlowLayout titleLayout = new AlignedFlowLayout();
			titleLayout.setHorizontal(true);
			titleLayout.setHorizontalSpacing(2);
			titleLayout.setVerticalAlignment(AlignedFlowLayout.ALIGN_CENTER);
			titleLayout.setHorizontalAlignment(AlignedFlowLayout.ALIGN_CENTER);
			setLayoutManager(titleLayout);
			setBorder(new MarginBorder(new Insets(3)));
		}
		/**
		 * @see org.eclipse.gef.handles.HandleBounds#getHandleBounds()
		 */
		public Rectangle getHandleBounds() {
			return getClientArea();
		}
	}
	
	protected class MainTraySelectionEditPolicy extends TraySelectionEditPolicy {
		@Override
		protected Handle createHandle(GraphicalEditPart owner) {
			return new TraySelectionHandle(owner, mainTrayTitleFigure);
		}
	}
	
	/**
	 * Figure that implements scrolling.
	 */
	public class MainTrayContainerFigure extends TrayContainerFigure {

		protected class MainTrayContainerFigureLayout extends AbstractLayout {
			@Override
			protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
				if (titleFigure == null || childrenScrollPane == null) return new Dimension(wHint, hHint);
				Dimension titleSize = titleFigure.getPreferredSize(wHint, hHint);
				Dimension scrollPaneSize = childrenScrollPane.getPreferredSize(wHint, hHint);
				int width = Math.max(titleSize.width, scrollPaneSize.width);
				return new Dimension(width, container.getSize().height);
			}
			/**
			 * @see org.eclipse.draw2d.LayoutManager#layout(org.eclipse.draw2d.IFigure)
			 */
			public void layout(IFigure container) {
				if (titleFigure == null || childrenScrollPane == null) return;
				Rectangle area = container.getClientArea().getCopy();
				Dimension size = titleFigure.getPreferredSize();
				titleFigure.setBounds(new Rectangle(area.x, area.y, area.width, size.height));
				area.y += size.height;
				int height = area.height - size.height;
				childrenScrollPane.setBounds(new Rectangle(area.x, area.y, area.width, height));
			}
			
			/**
			 * @see org.eclipse.draw2d.AbstractLayout#getMinimumSize(org.eclipse.draw2d.IFigure, int, int)
			 */
			@Override
			public Dimension getMinimumSize(IFigure container, int wHint, int hHint) {
				Dimension result = getPreferredSize(container, wHint, hHint);
				result.width = 80; // magic number
				return result;
			}
		}
		
		protected ScrollPane childrenScrollPane;
		
		/**
		 * 
		 */
		public MainTrayContainerFigure() {
			super();
			setLayoutManager(new MainTrayContainerFigureLayout());
		}
		
		/**
		 * @see org.eclipse.bpel.common.ui.tray.TrayContainerEditPart.TrayContainerFigure#setChildrenFigure(org.eclipse.draw2d.IFigure)
		 */
		@Override
		public void setChildrenFigure(IFigure target) {
			if (childrenScrollPane == null) {
				childrenScrollPane = createScrollpane();
				add(childrenScrollPane);
			}
			childrenFigure = target;
			childrenScrollPane.setContents(target);
		}
		protected ScrollPane createScrollpane() {
			ScrollPane scrollpane = new ScrollPane();
			scrollpane.getViewport().setContentsTracksWidth(true);
			scrollpane.getViewport().setContentsTracksHeight(true);
			scrollpane.setMinimumSize(new Dimension(0, 0));
			scrollpane.setHorizontalScrollBarVisibility(ScrollPane.NEVER);
			scrollpane.setVerticalScrollBar(new TrayScrollBar());
			scrollpane.getVerticalScrollBar().setStepIncrement(SCROLL_STEP);
			scrollpane.setLayoutManager(new TrayScrollPaneLayout());
			return scrollpane;
		}
		
		/**
		 * @return the scroll pane.
		 */
		public ScrollPane getChildrenScrollPane() {
			return childrenScrollPane;
		}
	}
	
	protected EditPartMarkerDecorator decorator;
	protected Label nameLabel;
	protected MainTrayTitleFigure mainTrayTitleFigure;
	
	/**
	 * 
	 */
	public MainTrayEditPart() {
		super();
	}

	@Override
	protected IFigure createTitleFigure() {
		mainTrayTitleFigure = new MainTrayTitleFigure();
		mainTrayTitleFigure.add(new ImageFigure(getLabelProvider().getImage(getModel())));
		nameLabel = new Label(getLabelProvider().getText(getModel()));
		mainTrayTitleFigure.add(nameLabel);
		decorator = createEditPartMarkerDecorator();
		return decorator.createFigure(mainTrayTitleFigure);
	}
	
	protected EditPartMarkerDecorator createEditPartMarkerDecorator ( ) {
		return new TrayMarkerDecorator((EObject)getModel(), new ToolbarLayout()); 
	}
	
	@Override
	protected TrayContainerFigure createMainFigure() {
		return new MainTrayContainerFigure();
	}
	
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		nameLabel.setText(getLabelProvider().getText(getModel()));
		decorator.refresh();
	}

	@Override
	protected void createEditPolicies() {
		// Show selection handles
		MainTraySelectionEditPolicy selectionEditPolicy = new MainTraySelectionEditPolicy();
		selectionEditPolicy.setDragAllowed(false);
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, selectionEditPolicy);
	}
	
	/**
	 * @see org.eclipse.bpel.common.ui.tray.TrayEditPart#getDirectEditLabel()
	 */
	@Override
	public Label getDirectEditLabel() {
		return nameLabel;
	}

	/**
	 * Returns a model object if one is available or null.
	 */
	protected Object getModelObjectFromSelection(ISelection target) {
		if (target instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)target;
			Object element = selection.getFirstElement();
			if (element != null) {
				return (element instanceof EditPart) ? ((EditPart)element).getModel() : element;
			}
		}
		return null;
	}
}