/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui;

import org.eclipse.core.resources.IFile;

/**
 * Similar to IResourceChangeListener but with more specific events.
 */
public interface IFileChangeListener {
	/**
	 * Called after a file is moved or renamed.
	 * 
	 * @param source the previous file
	 * @param destination the new file
	 */
	void moved(IFile source, IFile destination);
	
	/**
	 * Called after a file is deleted.
	 */
	void deleted(IFile file);
}