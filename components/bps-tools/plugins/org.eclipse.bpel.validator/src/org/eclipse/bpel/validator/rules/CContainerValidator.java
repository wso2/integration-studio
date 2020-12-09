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

import java.util.HashMap;

import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;

/**
 * This is the base class for Variables,PartnerLinks, etc. 
 * all the container based elements to do some basic sanity checking.
 * <p>
 * Such containers  just have 1 type of child element.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 6, 2006
 *
 */

public abstract class  CContainerValidator extends CValidator {
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.Validator#start()
	 */
	@Override
	protected void start() {
		super.start();		
	}

	
	/**
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren() {
		super.checkChildren();
	}
	
	
	
	
	/**
	 * Checks if a child element has a duplicate name
	 *
	 */
	
	@SuppressWarnings("nls")
	public void checkDuplicateName () {
		
		HashMap<String,INode> map = new HashMap<String,INode>();
		
		for(INode next : fChildren ) {
			
			String name = next.getAttribute(AT_NAME);
			INode present = map.get(next.getAttribute(AT_NAME) );
			if (present == null) {
				map.put(name,next);
			} else {
				IProblem problem = createError( next );
				problem.setAttribute(IProblem.CONTEXT, AT_NAME);
				problem.fill( "BPELC_DUPLICATE_NAME",
						toString(mNode.nodeName()), 
						toString(next.nodeName()),  
						name); 
			}			
		}
		
		map.clear();
	}
		
	
	
}
