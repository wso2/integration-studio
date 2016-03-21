/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;



/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 4, 2007
 *
 */
public abstract class EditAction extends SelectionAction {

	protected List<EObject> fSelection = new ArrayList<EObject>();
	
	static protected EObject [] EMPTY_EOBJECT_ARRAY = {};
	
	/**
	 * Brand new shiny edit action.
	 * 
	 * @param aPart
	 */
	public EditAction(IWorkbenchPart aPart) {
		super(aPart);		
	}
	

	/**
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled () {
		fSelection.clear();
		
		List<?> selection = getSelectedObjects();
		if (selection.isEmpty()) {
			return false;
		}
		
		for(Object obj : selection) {

			if (obj instanceof EObject) {
				EObject eObj = (EObject) obj;				
				fSelection.add(eObj);
			} else {
				fSelection.clear();
				break;
			}
		}		
		return fSelection.size() > 0;
	}


	protected abstract Command getCommand () ;
	
	
	/**
	 * Trims the selection to the list of "parent" objects. So if you select a sequence and an
	 * activity within it, the result is the sequence element.  
	 * 
	 * @param aList a list of currently selected objects.
	 * 
	 * @return the trimmed list.
	 */
	
	
	protected List<EObject> trimSelection (List<EObject> aList) {
		// 
		ArrayList<EObject> trimmedList = new ArrayList<EObject>( aList.size() );
		
		for(EObject next : aList) {
			
			boolean skipNext = false;
			for(EObject parent : aList) {
				if (next != parent && ModelHelper.isChildContainedBy(parent, next)) {
					skipNext = true;
					break;
				}
			}
			
			if (skipNext) {
				continue;
			}
			
			trimmedList.add(next);
		}
		return trimmedList;
	}
	
	
	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run () {
		execute (getCommand());
	}
	
}
