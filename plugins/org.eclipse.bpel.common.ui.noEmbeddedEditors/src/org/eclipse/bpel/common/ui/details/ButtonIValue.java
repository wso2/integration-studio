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

import org.eclipse.swt.widgets.Button;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 27, 2007
 *
 */

public class ButtonIValue implements IValue {
	
	Button fWidget;

	/**
	 * @param w
	 */
	public ButtonIValue ( Button w ) {
		fWidget = w;
	}

	/**
	 * @see org.eclipse.bpel.common.ui.details.IValue#get()
	 */
	@SuppressWarnings("boxing")
	public Object get() {
		return fWidget.getSelection();
	}

	/** 
	 * @see org.eclipse.bpel.common.ui.details.IValue#set(java.lang.Object)
	 */
	@SuppressWarnings({ "nls", "boxing" })
	public void set( Object object ) {
		if (object instanceof Boolean) {
			Boolean b = (Boolean) object;
			fWidget.setSelection(b);
		} else if (object instanceof String) {
			Boolean b = Boolean.valueOf((String) object);
			fWidget.setSelection(b);
		} else if (object == null) {
			fWidget.setSelection(false);
		}
	}
	
	
}
