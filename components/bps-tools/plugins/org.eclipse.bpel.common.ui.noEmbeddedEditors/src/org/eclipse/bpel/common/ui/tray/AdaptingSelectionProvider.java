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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * The adapting selection provider is used by the BPEL graphical editor
 * so that it can provide its selection in terms of model objects rather
 * than in terms of EditPart objects. This class takes care of converting
 * from model objects to EditParts, and vice versa, when necessary.
 */
public class AdaptingSelectionProvider extends MultiViewerSelectionProvider {

	/**
	 * Brand new shiny AdaptingSelectionProvider ...
	 * @param viewer
	 */
	public AdaptingSelectionProvider(EditPartViewer viewer) {
		super(viewer);
	}
	
	/**
	 * Brand new shiny AdaptingSelectionProvider ...
	 */
	public AdaptingSelectionProvider() {
		super();
	}
	
	
	@Override
	protected IStructuredSelection calculateSelection (IStructuredSelection selection) {
		
		if (selection == null || selection.isEmpty()) {
			return StructuredSelection.EMPTY;
		}
		
		List<EObject> list = new ArrayList<EObject>();		
		Set<EObject>  newSet = new HashSet<EObject>();
		
		for (Object model : selection.toArray()) {							
			if (model instanceof EditPart) {
				model = ((EditPart)model).getModel();
			} 
			if (model instanceof EObject) { 
				EObject eObj = (EObject) model;
				if (newSet.add(eObj)) {
					list.add(eObj);
				}
			}			
		}
		if (list.isEmpty()) {
			return StructuredSelection.EMPTY;
		}
		return new StructuredSelection( list );
	}
	
	/**
	 * Set selection to each of the viewers and make sure we ignore callbacks
	 * 
	 */
	
	@Override
	protected void internalSetSelection(IStructuredSelection selection) {
		
		if (selection == null || selection.isEmpty() ) {
			return;
		}
		try {
			changingSelection = true;
			for(EditPartViewer viewer : viewers ) {
				List<EditPart> newList = new ArrayList<EditPart>();
				Map<Object,EditPart> registry = viewer.getEditPartRegistry();
				
				for(Object o : selection.toArray()) {					
					EditPart editPart = registry.get(o);
					if (editPart != null) {
						newList.add(editPart);
					}
				}
				viewer.setSelection(new StructuredSelection(newList));
			}	
		} finally {
			changingSelection = false;
		}
	}	
}