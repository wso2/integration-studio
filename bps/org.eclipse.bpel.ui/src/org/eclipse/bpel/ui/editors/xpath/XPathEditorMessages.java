/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.editors.xpath;



import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Nov 1, 2006
 *
 */

final class XPathEditorMessages extends NLS {

	
	static final String BUNDLE_FOR_CONSTRUCTED_KEYS; 
	static final ResourceBundle fgBundleForConstructedKeys;
	
	static {
		BUNDLE_FOR_CONSTRUCTED_KEYS = XPathEditorMessages.class.getPackage().getName() + ".ConstructedEditorMessages"; //$NON-NLS-1$
		
		fgBundleForConstructedKeys = ResourceBundle.getBundle(BUNDLE_FOR_CONSTRUCTED_KEYS);
	}
			
	/**
	 * Returns the message bundle which contains constructed keys.
	 *
	 * @since 3.1
	 * @return the message bundle
	 */
	public static ResourceBundle getBundleForConstructedKeys() {
		return fgBundleForConstructedKeys;
	}

	private static final String BUNDLE_NAME = XPathEditorMessages.class.getName();

	private XPathEditorMessages() {
		// Do not instantiate
	}


	static {
		NLS.initializeMessages(BUNDLE_NAME, XPathEditorMessages.class);
	}
}

