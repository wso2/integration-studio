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
package org.eclipse.bpel.common.ui.editmodel;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 30, 2007
 *
 */
public interface IResourceSetProvider {

	/**
	 * Get the resource set for the given resource.
	 * 
	 * @param resource
	 * @return the resource set.
	 */
	
	ResourceSet getResourceSet( IResource resource );	
}
