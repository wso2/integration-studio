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
package org.eclipse.bpel.ui.expressions;

import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * @author IBM Original Contribution.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 16, 2007
 *
 */
public interface IExpressionEditor {
	
	/**
	 * Goto the text marker indicated.
	 * 
	 * @param marker the marker
	 * @param codeType code type
	 * @param modelObject the model object
	 */
	public void gotoTextMarker(IMarker marker, String codeType, Object modelObject);

	/**
	 * Creates the editor widgets.
	 * @param parent the parent composite
	 * @param tk a {@link FormToolkit}, retrieved for example from the host {@link BPELPropertySection}
	 */
	void createControls(Composite parent, FormToolkit tk);

	/**
	 * Dispose of the editor.
	 */
	
	void dispose();

	/**
	 * Notifies the editor that its controls are about to be hidden.
	 */
	void aboutToBeHidden();

	/**
	 * Notifies the editor that its controls are about to be shown.
	 * Any widget state could be updated at this point.
	 */
	void aboutToBeShown();
	
	/**
	 * This method is used just like IDetailsSection.getUserContext().
	 * @return the user context 	 
	 */
	Object getUserContext();
	
	/**
	 * This method is used just like IDetailsSection.restoreUserContext().
	 * @param userContext the user context 
	 * 
	 */
	void restoreUserContext (Object userContext);
	
	/**
	 * Return the editor content
	 * @return return the body of the edited expression 
	 */
	String getEditorContent ();
	
	/**
	 * Set the editor content
	 * @param body the content of the editor.
	 */
	void setEditorContent (String body);
	
	/**
	 * Add a listener
	 * 
	 * @param listener the listener to add.
	 */
	void addListener(Listener listener);
	
	/**
	 * Remove a listener.
	 * @param listener the listener to remove.
	 */
	void removeListener(Listener listener);
	
	/**
	 * The listener interface. 
	 */
	
	public static interface Listener {
		/**
		 * Notify that we have changed.
		 */
		public void notifyChanged();
		public void focusOut();
		public void focusIn();
	}
	
	/**
	 * Allow the editor to modify 
	 * @param compoundCommand
	 */
	void addExtraStoreCommands(CompoundCommand compoundCommand);
	
	/**
	 * Get the default body.
	 * @return the default body 
	 */
	
	public String getDefaultContent ();	
	
	/**
	 * Returns true if this editor supports this expression type.
	 * 
	 * @param exprType the expression type.
	 * @return true if the expression type is supported.
	 */
	boolean supportsExpressionType(String exprType);
	
	/**
	 * Informs the editor of the expression type it will be editing.
	 * The supportsExpressionType() method will always be called first to make sure
	 * the editor actually supports this exprType combination.
	 * @param exprType the expression type
	 */
	void setExpressionType ( String exprType );

	/**
	 * Informs the editor of the underlying model object in which this expression
	 * will be stored.  The model object's type and relationship to other objects
	 * may depend on the expression type and context provided above (for example: the
	 * model for a transition condition is a Link, but the model for a join condition
	 * is an Activity). 
	 * 
	 * @param modelObject 
	 */
	void setModelObject (Object modelObject);
	
	/**
	 * Tells the editor to consider itself clean.
	 */
	void markAsClean();
}
