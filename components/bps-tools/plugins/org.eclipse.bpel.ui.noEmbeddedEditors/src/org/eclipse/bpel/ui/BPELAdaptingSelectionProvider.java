/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.bpel.common.ui.tray.AdaptingSelectionProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;


/**
 * A version of AdaptingSelectionProvider with extra support for also using EditPart-based
 * selections, which are needed by some of our actions.  (Basically some code copied from
 * MultiViewerSelectionProvider!)
 */
public class BPELAdaptingSelectionProvider extends AdaptingSelectionProvider {

	protected IStructuredSelection cachedEditPartSelection;
	
	/**
	 * Brand new shiny BPELAdaptingSelectionProvider ...
	 * @param viewer
	 */
	
	public BPELAdaptingSelectionProvider(EditPartViewer viewer) {
		super(viewer);
	}
	
	
	/**
	 * Brand new shiny BPELAdaptingSelectionProvider ...
	 */
	public BPELAdaptingSelectionProvider() {
		super();
	}

	/**
	 * @see org.eclipse.bpel.common.ui.tray.MultiViewerSelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setSelection (ISelection selection) {
		if (selection instanceof IStructuredSelection == false) {
			return;
		}
		
		cachedSelection = calculateSelection((IStructuredSelection) selection);
		internalSetSelection(cachedSelection);
		cachedEditPartSelection = calculateEditPartSelection();
		fireSelectionChanged(this, cachedSelection);
	}
	
	
	protected IStructuredSelection calculateEditPartSelection() {
		
		List<EditPart> result = new ArrayList<EditPart>();		
		Set<Object> modelObjectSet = new HashSet<Object>();
		
		for(EditPartViewer v  : viewers ) {
			List<EditPart> viewerParts = v.getSelectedEditParts();
						
			// NOTE: filter out duplicate edit parts, so that we only return
			// one edit part per model object.
			for(EditPart ep : viewerParts) {
				Object model = ep.getModel();
				if (modelObjectSet.add(model)) {
					result.add(ep);
				}
			}
		}
		if (result.isEmpty()) {
			return StructuredSelection.EMPTY;
		}
		return new StructuredSelection(result);
	}
	
	/**
	 * This is for the benefit of our actions which require an EditPart-based selection. 
	 * @return the selection of edit parts. 
	 */ 
	
	public IStructuredSelection getEditPartSelection() {
		if (cachedEditPartSelection == null) {
			cachedEditPartSelection = calculateEditPartSelection();
		}
		return cachedEditPartSelection;
	}
}
