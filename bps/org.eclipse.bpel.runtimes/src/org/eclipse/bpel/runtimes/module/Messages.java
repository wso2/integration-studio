/*******************************************************************************
 * Copyright (c) 2006, 2012 University College London Software Systems Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Bruno Wassermann - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.runtimes.module;

import org.eclipse.osgi.util.NLS;

/**
 * Module-related messages. 
 *
 * @author Bruno Wassermann, written 17 Jul 2006
 */
public class Messages extends NLS {
	
	private static final String BUNDLE_NAME = "org.eclipse.bpel.runtimes.module.messages"; //$NON-NLS-1$

	private Messages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	// module validation
	public static String InvalidFileExtension;
}
