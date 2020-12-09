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

import javax.xml.namespace.QName;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 * @param <T> The of the factory
 * @date Jan 5, 2007
 *
 */
public interface IFactory<T> {
	
	/**
	 * Generic factory to create something based on a QName.
	 * 
	 * @param qname the QName of the node.
	 * @return the node validator for this QName 
	 */
	
	T create ( QName qname ) ;	
}
