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
 * @date Dec 6, 2006
 *
 */
public class ForValidator extends ConditionValidator {
	
	/**
	 * Parent node names.
	 */
	
	@SuppressWarnings("hiding")
	static public IFilter<INode> PARENTS = new NodeNameFilter( 
			ND_WAIT , ND_ON_ALARM 
	);

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.ConditionValidator#start()
	 */
	@Override
	protected void start() {		
		super.start();
	}	
}
