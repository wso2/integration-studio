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
import java.util.HashSet;

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.INode;



/**
 * Validates Empty nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */


@SuppressWarnings("nls")
public class FlowValidator extends CActivityValidator {
				
	static protected String LINKS_SET = "links.set";
	
	static protected String SOURCE_MAP = "source.map";
	
	static protected String TARGET_MAP = "target.map";
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CContainerValidator#start()
	 */
	@Override
	protected void start() {
		super.start();		
		setValue(LINKS_SET, new HashSet<String>());
		setValue(SOURCE_MAP, new HashMap<String,INode>());
		setValue(TARGET_MAP, new HashMap<String,INode>());
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {
		super.checkChildren();
		checkChild(ND_LINKS,0,1);
		
		checkChild(Filters.ACTIVITIES,1,Integer.MAX_VALUE);
	}

	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
