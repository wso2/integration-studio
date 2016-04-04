/*******************************************************************************
 * Copyright (c) 2007, 2012 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Oleg Danilov, Intel - Initial API and Implementation
 *
 *******************************************************************************/

package org.eclipse.bpel.ui.adapters;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.bpel.ui.adapters.messages"; //$NON-NLS-1$
	public static String ForEachAdapter_0;
	public static String ForEachAdapter_1;
	public static String ForEachAdapter_2;
	public static String PARTNER_LINK;
	public static String INPUT;
	public static String OUTPUT;
	public static String CONDITION;
	public static String LANGUAGE;
	public static String MY_ROLE;
	public static String PARTNER_ROLE;
	public static String NONE;
	public static String OPERATION;

	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
