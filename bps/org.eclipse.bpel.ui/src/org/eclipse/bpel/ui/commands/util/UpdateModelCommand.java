/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.commands.util;

import org.eclipse.bpel.ui.Messages;
import org.eclipse.emf.ecore.EObject;

/** 
 * Generic "model-setting" command.  
 * 
 * Subclasses need to override doExecute()
 */

public class UpdateModelCommand extends AutoUndoCommand {

	/** Target */
	protected EObject fTarget;
	
	/** The command target */
	protected String fLabel;
	
	/**
	 * @param aTarget
	 * @param aLabel 
	 */
	public UpdateModelCommand ( EObject aTarget , String aLabel)  {
		super(aTarget);	
		fTarget = aTarget;
		fLabel = aLabel;
	}

	/**
	 * Return the default command label. 
	 * @return  the default label
	 */
	
	@SuppressWarnings("nls")
	@Override
	public String getLabel() { 
		if (fLabel == null) {
			return Messages.SetCommand_Change_1;
		}
		return fLabel;			
	} 
}