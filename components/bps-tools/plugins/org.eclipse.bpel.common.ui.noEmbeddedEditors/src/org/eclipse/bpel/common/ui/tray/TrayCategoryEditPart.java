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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.common.ui.ICommonUIConstants;
import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.details.IDetailsColors;
import org.eclipse.bpel.common.ui.details.widgets.NoBorderButton;
import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.KeyEvent;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.tools.SelectEditPartTracker;


/**
 * Represents a category in the Tray.
 */
public abstract class TrayCategoryEditPart extends TrayContainerEditPart {
	protected SelectionBorderFigure titleFigure;
	
	protected class TrayCategoryEntrySelectionEditPolicy extends TraySelectionEditPolicy {
		@Override
		protected Handle createHandle(GraphicalEditPart owner) {
			return new TraySelectionHandle(owner, titleFigure);
		}
	}
	/**
	 * A layout for the title of this edit part:
	 * 	ICON LABEL ADD_BUTTON REMOVE_BUTTON
	 */
	protected class TitleLayout extends AbstractLayout {
		private static final int SPACING = 2;
		public void layout(IFigure container) {
			List elements = container.getChildren();
			ImageFigure icon = (ImageFigure)elements.get(0);
			Label text = (Label)elements.get(1);
			Figure removeButton = (Figure)elements.get(2);
			Figure addButton = (Figure)elements.get(3);
			
			Rectangle containerBounds = container.getBounds();
			int x = containerBounds.x + SPACING;
			int y = containerBounds.y;
			int height = containerBounds.height;
			
			Dimension size = icon.getPreferredSize();
			Rectangle bounds = new Rectangle(x, y, size.width, height);
			icon.setBounds(bounds);
			
			size = removeButton.getPreferredSize();
			x = (containerBounds.x + containerBounds.width) - size.width;
			bounds = new Rectangle(x, y, size.width, height);
			removeButton.setBounds(bounds);

			size = addButton.getPreferredSize();
			x = x - size.width;
			bounds = new Rectangle(x, y, size.width, height);
			addButton.setBounds(bounds);

			x = icon.getBounds().x + icon.getBounds().width;
			x = x + SPACING;
			int width = containerBounds.width - (icon.getBounds().width + removeButton.getBounds().width + addButton.getBounds().width);
			bounds = new Rectangle(x, y, width, height);
			text.setBounds(bounds);
		}
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
			Dimension result = new Dimension(0, hHint);
			for (Iterator<IFigure> iter = container.getChildren().iterator(); iter.hasNext();) {
				IFigure	child = iter.next();
				Dimension size = (child instanceof Label) ? child.getMinimumSize() : child.getPreferredSize();
				result.height = Math.max(result.height, size.height);
				result.width += size.width;
			}
			result.height += (SPACING*2); // give it some extra pixels
			return result;
		}
	}
	
	/**
	 * The figure representing the title of this container.
	 */
	protected class TitleFigure extends SelectionBorderFigure {
		protected Label textLabel;
		protected NoBorderButton addButton;
		protected NoBorderButton removeButton;
		public TitleFigure() {
			super();
			setLayoutManager(new TitleLayout());
			setOpaque(true);
			setBackgroundColor(CommonUIPlugin.getDefault().getColorRegistry().get(IDetailsColors.COLOR_LIGHT_BACKGROUND));
			add(new ImageFigure(getLabelProvider().getImage(getModel())));
			textLabel = new Label(getLabelProvider().getText(getModel()));
			textLabel.setLabelAlignment(PositionConstants.LEFT);
			add(textLabel);
			
			removeButton = new NoBorderButton(CommonUIPlugin.getDefault().getImageRegistry().get(ICommonUIConstants.ICON_TRAY_CATEGORY_REMOVE_BUTTON)) {
				@Override
				public void handleKeyPressed(KeyEvent event) {
					// Do nothing - the button can only be pressed with a mouse
				}
				@Override
				public void handleKeyReleased(KeyEvent event) {
					// Do nothing - the button can only be pressed with a mouse
				}
			};
			removeButton.setOpaque(false);
			removeButton.setToolTip(getRemoveToolTip());
			removeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					removeEntry();
				}
			});
			
			addButton = new NoBorderButton(CommonUIPlugin.getDefault().getImageRegistry().get(ICommonUIConstants.ICON_TRAY_CATEGORY_ADD_BUTTON)) {
				@Override
				public void handleKeyPressed(KeyEvent event) {
					// Do nothing - the button can only be pressed with a mouse
				}
				@Override
				public void handleKeyReleased(KeyEvent event) {
					// Do nothing - the button can only be pressed with a mouse
				}
			};
			addButton.setOpaque(false);
			addButton.setToolTip(getAddToolTip());
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					addEntry();
				}
			});
			
			add(removeButton);
			add(addButton);
		}
		public Label getTextLabel() {
			return textLabel;
		}
	}

	/**
	 * Adds a new entry to the category. Returns the new model object.
	 */
	protected Object addEntry() {
		CreateRequest request = new CreateRequest();
		request.setFactory(getCreationFactory());
		Command command = getCommand(request);
		getCommandStack().execute(command);
		Object newObject = request.getNewObject();
		// Select the new item after creation
		selectEditPart(newObject);
		return newObject;
	}
	
	/**
	 * Adds a new entry to the category. Returns the new model object.
	 * Used by the AddChildInTrayAction.
	 */
	public Object publicAddEntry() {
		return addEntry();
	}
	
	/**
	 * Called by the remove button to remove the currently selected entry.
	 */
	protected void removeEntry() {
		List selectedParts = getViewer().getSelectedEditParts();
		if (selectedParts.size() == 0) return; // nothing to be done
		
		// we can only delete edit parts that are children of this edit part
		List<EditPart> condemned = new ArrayList<EditPart>();
		for (Iterator<EditPart> iter = selectedParts.iterator(); iter.hasNext();) {
			EditPart part = iter.next();
			if (part.getParent() == TrayCategoryEditPart.this) {
				condemned.add(part);
			}
		}
		if (condemned.isEmpty()) return; // nothing to be done

		// gets the index to be used in the post-deletion selection
		EditPart indexPart = condemned.get(0);
		int index = getModelChildren().indexOf(indexPart.getModel());
		
		// remove all the valid selected edit parts
		GroupRequest request = new GroupRequest(RequestConstants.REQ_DELETE);
		CompoundCommand deletions = new CompoundCommand();
		for (Iterator<EditPart> iter = condemned.iterator(); iter.hasNext();) {
			EditPart part = iter.next();
			deletions.add(part.getCommand(request));
		}
		getCommandStack().execute(deletions);
		
		// Select the next edit part if one is available
		int size = getModelChildren().size();
		if (size == 0) return; // nothing to be done
		if (size > index) {
			selectEditPart(getModelChildren().get(index));
		} else {
			selectEditPart(getModelChildren().get(size-1));
		}
	}
	
	public TrayCategoryEditPart() {
		super();
	}

	@Override
	protected TrayContainerFigure createMainFigure() {
		return new TrayContainerFigure() {
			@Override
			protected void paintBorder(Graphics graphics) {
				graphics.setForegroundColor(CommonUIPlugin.getDefault().getColorRegistry().get(IDetailsColors.COLOR_DARK_SHADOW));
				Rectangle area = getClientArea().getCopy();
				area.height--;
				graphics.drawLine(area.getTopLeft(), area.getTopRight());
			}
		};
	}
	
	@Override
	protected IFigure createTitleFigure() {
		return titleFigure = new TitleFigure();
	}
	
	/**
	 * As part of our layout, the entries and the category should have
	 * the same x-coordinate for their texts. This is the figure used
	 * by the entries to calculate the position of their text.
	 */
	public IFigure getLabelPositionReference() {
		return ((TitleFigure)getTitleFigure()).getTextLabel();
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new TrayCategoryEntrySelectionEditPolicy());
	}

	/**
	 * Subclasses need to provide a creation factory for the category entry creation.
	 */
	protected abstract CreationFactory getCreationFactory();

	/* (non-Javadoc)
	 * @see org.eclipse.gef.EditPart#getDragTracker(org.eclipse.gef.Request)
	 */
	@Override
	public DragTracker getDragTracker(Request request) {
		return new SelectEditPartTracker(this);
	}
	
	@Override
	public Label getDirectEditLabel() {
		return null;
	}
	
	/**
	 * Return the label to be used as the tooltip for the Add button.
	 * Subclasses may override.
	 */
	protected IFigure getAddToolTip() {
	    return new Label("Add");
	}
	
	/**
	 * Return the label to be used as the tooltip for the Add button.
	 * Subclasses may override.
	 */
	protected IFigure getRemoveToolTip() {
	    return new Label("Remove");
	}	
}
