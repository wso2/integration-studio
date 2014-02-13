/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Zend Technologies
 *******************************************************************************/
package org.eclipse.php.internal.core.language;

import org.eclipse.php.internal.core.PHPVersion;

/**
 * This is a container for predefined Jaggery variables
 * 
 */
public class JaggeryVariables {

	private final static String[] JAGGERY_VARIABLES = {
			"request", "response", "session", "application", "webSocket" }; //$NON-NLS-1$ //$NON-NLS-2$

	public static String[] getVariables(PHPVersion phpVersion) {
		return JAGGERY_VARIABLES; // for now the variables set is the same for
									// all
									// PHP versions
	}
}
