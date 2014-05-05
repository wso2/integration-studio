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
package org.eclipse.bpel.ui.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ISection;



/**
 * An IDetailsSection representing a panel of widgets for one specifying one kind
 * of From/To contents.  Subclasses of AssignCategory can answer whether they apply
 * to the contents of a particular From or To, and they provide widgets specific to
 * that kind of contents.
 * 
 */
public interface IAssignCategory extends ISection {

	/** Get the composite on which the section had been created
	 *  
	 * @return the composite on which this section had been created.
	 */
	
	public Composite getComposite ();
	
	
	/**
	 * Answer if hidden.
	 * 
	 * @return true of hidden, false if not.
	 */
	public boolean isHidden();
	
	/**
	 * Returns a label for the category (e.g. to show in a combo).
	 * @return name
	 */
	public String getName();

	/**
	 * Returns true if the state in the toOrFrom object can be represented by this category.
	 * If isFrom is true, toOrFrom will be a From object, otherwise it will be a To object.
	 * @param aModel the model object.
	 * @return true if this is the category for this model object, false otherwise.
	 */
	
	public boolean isCategoryForModel (EObject aModel);

	/**
	 * Used in the same way as BPELPropertySection.getUserContext(), except that this is
	 * normally called by AssignImplDetails rather than directly by the wrapped Command.
	 * 
	 * This is because an AssignCategory should not use itself as the detailsSection
	 * when it wraps a Command--it should use its ownerSection.
	 * 
	 * @return the user context object   
	 */
	public Object getUserContext();
	
	/**
	 * Used in the same way as BPELPropertySection.getUserContext(), except that this is
	 * normally called by AssignImplDetails rather than directly by the wrapped Command.
	 * 
	 * This is because an AssignCategory should not use itself as the detailsSection
	 * when it wraps a Command--it should use its ownerSection.
	 * 
	 * @param userContext the user context object
	 * 
	 * @see BPELPropertySection#restoreUserContext(Object) 
	 */
	public void restoreUserContext(Object userContext);

	
	/**
	 * This is just a workaround to keep the AssignCategory from changing too much.
	 * TODO: get rid of these!
	 * 
	 * @param aModel the model object
	 */
	public void setInput(EObject aModel);
}
