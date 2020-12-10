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
import org.eclipse.bpel.validator.model.NodeNameFilter;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jan 18, 2007
 *
 */

public class CatchAllValidator extends CValidator {

	/**
	 * The parent nodes in which catchAll can live
	 */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_FAULT_HANDLERS , ND_INVOKE );
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	
	@Override
	public void checkChildren () {
		super.checkChildren();
		checkChild(Filters.ACTIVITIES,1,1);				
	}

}
