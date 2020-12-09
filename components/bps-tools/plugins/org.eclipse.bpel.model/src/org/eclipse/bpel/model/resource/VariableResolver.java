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
package org.eclipse.bpel.model.resource;

import org.eclipse.bpel.model.Variable;
import org.eclipse.emf.ecore.EObject;

/**
 * Interface VariableResolver provides an extension mechanism for resolution
 * of a variable with a given name.
 */
public interface VariableResolver {
	public Variable getVariable(EObject eObject, String variableName);
}
