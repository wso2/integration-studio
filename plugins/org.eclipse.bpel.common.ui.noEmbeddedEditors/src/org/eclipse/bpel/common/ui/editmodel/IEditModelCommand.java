/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.editmodel;

import org.eclipse.emf.ecore.resource.Resource;
/**
 * All commands used within EditModelCommandStack must
 * implement this interface. It enables the command stack
 * to track dirty resources and support validate edit.
 */
public interface IEditModelCommand {

/**
 * Returns the list of emf resource that this command my change.
 * Called before the command is executed to validate edit.
 */
public abstract Resource[] getResources();
/**
 * Returns a list of resource that this command has modified.
 * Usually returns the same list as in <code>getResources</code>
 * but it may return a subset if, for example, a compound command 
 * was not fully executed.
 */
public abstract Resource[] getModifiedResources();
}
