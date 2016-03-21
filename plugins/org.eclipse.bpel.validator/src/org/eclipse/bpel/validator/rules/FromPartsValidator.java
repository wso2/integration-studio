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

import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.NodeNameFilter;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 7, 2006
 *
 */
public class FromPartsValidator extends CContainerValidator {

	/** Nodes which can be our parents */
	static public IFilter<INode> PARENTS = new NodeNameFilter( 
			ND_ON_EVENT, ND_RECEIVE, ND_ON_MESSAGE , ND_INVOKE 
	);
		
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CContainerValidator#checkChildren()
	 */
	
	@Override
	public void checkChildren() {
		super.checkChildren();
		checkChild(ND_FROM_PART, 1, Integer.MAX_VALUE);
	}
}
