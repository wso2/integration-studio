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

import org.eclipse.bpel.ui.Messages;

/**
 * An AssignCategory presenting a tree from which the user can select any of:
 *  - a Variable (though it will mysteriously switch to VariablePartAssignCategory ..)
 *  - a Property of a Variable
 *  - some XSD element within the type of a Property of a Variable.
 */
public class VariablePropertyAssignCategory extends VariablePartAssignCategory {

	protected VariablePropertyAssignCategory (BPELPropertySection ownerSection ) {
		super(ownerSection );
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.VariablePartAssignCategory#getName()
	 */
	@Override
	public String getName() { 
		return Messages.VariablePropertyAssignCategory_Property_of_a_Variable_1; 
	} 
	
	@Override
	protected boolean isPropertyTree() { 
		return true; 
	}
}
