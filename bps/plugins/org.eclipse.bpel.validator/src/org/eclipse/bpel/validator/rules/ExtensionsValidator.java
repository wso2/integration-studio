/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.validator.rules;

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;




/**
 * Validates Extensions  nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 5, 2006
 *
 */


public class ExtensionsValidator extends CContainerValidator {
			
	/**
	 * Parent node names.
	 */
	
	static public IFilter<INode> PARENTS = Filters.PROCESS;
	
			
	/** Check children
	 * @see org.eclipse.bpel.validator.rules.CContainerValidator#checkChildren()
	 */
	@Override
	public void checkChildren ( ) {
		super.checkChildren ();
		checkChild(ND_EXTENSION,1,Integer.MAX_VALUE);			
	}
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
