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
package org.eclipse.bpel.runtimes.ui.wizards;

import org.eclipse.osgi.util.NLS;

/**
 * Internationalization, internationalisation...
 *
 *
 * @author Bruno Wassermann, written Jun 30, 2006
 */
public final class Messages extends NLS {
	
	private static final String BUNDLE_NAME = "org.eclipse.bpel.runtimes.ui.wizards.messages"; //$NON-NLS-1$

	private Messages() {
	}
	
	// new project wizard
	public static String NewProjectWizard_1;
	public static String NewProjectWizardPage1_1;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
