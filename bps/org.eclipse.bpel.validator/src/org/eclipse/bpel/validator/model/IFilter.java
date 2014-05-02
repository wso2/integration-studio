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
package org.eclipse.bpel.validator.model;

/**
 * A simple filter to select nodes from a list of nodes. Used in selector.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @param <T> The type name of for the filter object
 * @date Sep 20, 2006
 */

public interface IFilter<T> {
	
	/**
	 * If this filter returns true, this the node passed in the argument
	 * is selected and added to whatever container the filter is attached to.
	 * 
	 * @param node
	 * @return true to keep the node, false to throw it away
	 */
	
	boolean select ( T node );	
}
