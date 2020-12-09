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
package org.eclipse.bpel.common.ui.details;

import org.eclipse.swt.widgets.Text;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 27, 2007
 *
 */

public class TextIValue implements IValue {
	
	Text fWidget;

	/**
	 * @param w
	 */
	public TextIValue ( Text w ) {
		fWidget = w;
	}

	/**
	 * @see org.eclipse.bpel.common.ui.details.IValue#get()
	 */
	public Object get() {
		return fWidget.getText().trim();
	}

	/** 
	 * @see org.eclipse.bpel.common.ui.details.IValue#set(java.lang.Object)
	 */
	@SuppressWarnings("nls")
	public void set( Object text ) {
		if (text == null) {
			fWidget.setText("");
		} else {
			fWidget.setText( text.toString() );
		}
	}
	
	
}
