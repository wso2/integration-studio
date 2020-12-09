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
public class RepeatEveryValidator extends ForValidator {
	
	/**
	 * Parent node names.
	 */
	
	@SuppressWarnings("hiding")
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_ON_ALARM );

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.ConditionValidator#start()
	 */
	@Override
	protected void start() {		
		super.start();
	}	
	
	/**
	 * A quick rule to make sure that we are part of anAlarm 
	 * within the event handlers
	 *
	 */
	
	public void rule_CheckIfRightParentParent_1 () {
		INode parentParentNode = mNode.parentNode().parentNode();
		
		if (parentParentNode.nodeName().equals( ND_EVENT_HANDLERS) == false) {
			// problem.
		}
	}
	
}
