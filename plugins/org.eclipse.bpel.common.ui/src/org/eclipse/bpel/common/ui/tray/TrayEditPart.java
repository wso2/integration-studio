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

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gef.tools.SelectEditPartTracker;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

/**
 * An edit part for the Tray framework.
 */
public abstract class TrayEditPart extends AbstractGraphicalEditPart {

	protected Adapter adapter;
	protected ILabelProvider labelProvider;
	protected DirectEditManager directEditManager;
	protected AccessibleEditPart acc;

	public TrayEditPart() {
		super();
		adapter = createAdapter();
	}
	
	protected Adapter createAdapter() {
		return new Adapter() {
			public void notifyChanged(Notification notification) {
				refresh();
			}
			public Notifier getTarget() {return null;}
			public void setTarget(Notifier newTarget) {}
			public boolean isAdapterForType(Object type) {return false;}
		};
	}

	@Override
	public void activate() {
		super.activate();
		EObject modelObject = (EObject)getModel();
		modelObject.eAdapters().add(adapter);
	}

	@Override
	public void deactivate() {
		super.deactivate();
		EObject modelObject = (EObject)getModel();
		modelObject.eAdapters().remove(adapter);
	}

	/**
	 * Provides the label and text for the edit part.
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * Overwrite the default behaviour since these edit parts
	 * should not move.
	 */
	@Override
	public DragTracker getDragTracker(Request request) {
		return new SelectEditPartTracker(this);
	}

	/**
	 * Override to handle direct edit requests
	 */
	@Override
	public void performRequest(Request request) {
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			performDirectEdit((DirectEditRequest)request);
		} else {
			super.performRequest(request);
		}
	}

	protected void performDirectEdit(DirectEditRequest request) {
		// check if we support direct edit
		if (getEditPolicy(EditPolicy.DIRECT_EDIT_ROLE) == null) return; // there is nothing to be done
		
		if(directEditManager == null) {
			directEditManager = new TrayCategoryEntryEditPartDirectEditManager(this, 
					TextCellEditor.class, new CellEditorLocator() {
						public void relocate(CellEditor celleditor) {
							Text text = (Text) celleditor.getControl();
							Point sel = text.getSelection();
							Point pref = text.computeSize(-1, -1);
							Label label = getDirectEditLabel();
							Rectangle rect = label.getTextBounds().getCopy();
							label.translateToAbsolute(rect);
							text.setBounds(rect.x - 4, rect.y - 1, Math.min(pref.x + 1, text.getParent().getSize().x - 20), pref.y + 1);
							text.setSelection(0);
							text.setSelection(sel);
						}
					});
		}
		directEditManager.show();
	}
	
	/**
	 * Returns the Label to be used for direct edit.
	 */
	public abstract Label getDirectEditLabel();

	@Override
	protected AccessibleEditPart getAccessibleEditPart() {
		if (acc == null) acc = createAccessible();
		return acc;
	}
	
	protected AccessibleEditPart createAccessible() {
		return new TrayAccessibleEditPart(this);
	}

	@Override
	public Object getAdapter(Class key) {
		if (key == AccessibleEditPart.class) {
			return getAccessibleEditPart();
		}
		return super.getAdapter(key);
	}
}
