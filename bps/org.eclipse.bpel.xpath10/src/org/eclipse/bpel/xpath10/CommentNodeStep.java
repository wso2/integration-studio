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

package org.eclipse.bpel.xpath10;

/**
 * The comment() element of the XPath location path.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */

@SuppressWarnings("nls")

public class CommentNodeStep extends Step {
	
	/**
	 * Bran new shiny comment node step.
	 * @param axis
	 */
	public CommentNodeStep (int axis) {
		super(axis);
	}

	/**
	 * @see org.eclipse.bpel.xpath10.Step#getText()
	 */
	@Override
	public String getText() {
		return asString();
	}
	
		
	@Override
	protected String asString () {
		return "comment()";
	}
}
