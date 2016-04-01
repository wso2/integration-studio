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

import java.util.List;

import org.eclipse.bpel.common.ui.decorator.EditPartMarkerDecorator;
import org.eclipse.bpel.common.ui.decorator.IMarkerConstants;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.handles.HandleBounds;

/**
 * An EditPart marker decorator for TrayCategoryEntryEditPart.
 */
public class TrayMarkerDecorator extends EditPartMarkerDecorator {

	/**
	 * Figure that holds the decoration layer. This figure is necessary in order
	 * to get selection handles in the correct place.
	 */

	protected class DecoratorHolderFigure extends Figure implements
			HandleBounds {
		protected HandleBounds handleBoundsReference;

		/**
		 * Brand new shiny DecoratorHolderFigure.
		 * 
		 * @param boundsReference
		 */
		public DecoratorHolderFigure (HandleBounds boundsReference) {
			super();
			this.handleBoundsReference = boundsReference;
			setLayoutManager(new ToolbarLayout());
		}

		/**
		 * @see org.eclipse.gef.handles.HandleBounds#getHandleBounds()
		 */
		public Rectangle getHandleBounds() {
			return handleBoundsReference.getHandleBounds();
		}
	}

	/**
	 * Brand new shiny TrayMarkerDecorator with the model object given.
	 * 
	 * @param aModelObject
	 *            the model object.
	 */
	public TrayMarkerDecorator(EObject aModelObject) {
		super(aModelObject);
	}

	/**
	 * Brand new shiny TrayMarkerDecorator with a list of model objects.
	 * 
	 * @param aListOfModelObjects
	 *            the model object list.
	 */

	public TrayMarkerDecorator(List<EObject> aListOfModelObjects) {
		super(aListOfModelObjects);
	}

	/**
	 * Brand new shiny TrayMarkerDecorator with a model object and a layout.
	 * 
	 * @param aModelObject
	 * @param aLayout
	 *            the layout to use.
	 */

	public TrayMarkerDecorator(EObject aModelObject, AbstractLayout aLayout) {
		super(aModelObject, aLayout);
	}

	/**
	 * Brand new shiny TrayMarkerDecorator with a list of model objects and a
	 * layout.
	 * 
	 * @param aListOfModelObjects
	 *            the list of model objects
	 * @param aLayout
	 *            the layout to use.
	 */
	public TrayMarkerDecorator(List<EObject> aListOfModelObjects,
			AbstractLayout aLayout) {
		super(aListOfModelObjects, aLayout);
	}

	/**
	 * @see org.eclipse.bpel.common.ui.decorator.EditPartMarkerDecorator#createFigure(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public IFigure createFigure(IFigure figure) {
		IFigure layers = super.createFigure(figure);
		if (figure instanceof HandleBounds) {
			IFigure result = new DecoratorHolderFigure((HandleBounds) figure);
			result.add(layers);
			return result;
		}
		return layers;
	}

	@Override
	protected Object getConstraint(IMarker marker) {
		try {
			// problem markers are always placed in the top left
			if (marker.isSubtypeOf(IMarker.PROBLEM)) {
				return IMarkerConstants.BOTTOM_LEFT;
			}
		} catch (CoreException e) {
			// Just ignore exceptions getting marker info.
			// It is possible that the marker no longer exists.
			// Eventually the UI will be notified that the
			// marker is removed and it will update.
		}
		return super.getConstraint(marker);
	}

}
