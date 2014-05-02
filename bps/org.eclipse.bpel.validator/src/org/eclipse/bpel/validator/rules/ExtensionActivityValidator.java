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
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.extensions.BPELExtensionRegistry;
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;




/**
 * Validates Extension activities
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */


public class ExtensionActivityValidator extends CActivityValidator {
			
			
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

	public ExtensionActivityValidator()
	{
		super();
	}

	// Bugzilla 324115
	@Override
	@ARule(
			sa = -1,
			desc = "Check the extensionActivity",
			author = "michal.chmielewski@oracle.com",
			date = "02/15/2007",
			warnings="BPELC_UNKNOWN_EXTENSION__ACTIVITY",
			errors="BPELC_MISSING_EXTENSION__ACTIVITY"
		)
	protected void start() {
		super.start();
		BPELExtensionRegistry extensionRegistry = BPELExtensionRegistry.getInstance();
		if (mNode.children().size() == 1) {
			INode child = mNode.children().get(0);
			// We found a child element. Look up a deserializer for this activity
			BPELActivityDeserializer deserializer = extensionRegistry.getActivityDeserializer(child.nodeName());
			if (deserializer == null)
			{
				IProblem problem = this.createWarning();
				String node = toString(child.nodeName());
				String name = child.getAttribute(new QName("name"));
				if (name==null || name.length()==0)
					name = "";
				problem.fill("BPELC_UNKNOWN_EXTENSION__ACTIVITY",node,name);
			}
		}
		else
		{
			IProblem problem = this.createError();
			String node = toString(mNode.nodeName());
			String name = mNode.getAttribute(new QName("name"));
			if (name==null || name.length()==0)
				name = "";
			problem.fill("BPELC_MISSING_EXTENSION__ACTIVITY",node,name);
		}
	}
}
