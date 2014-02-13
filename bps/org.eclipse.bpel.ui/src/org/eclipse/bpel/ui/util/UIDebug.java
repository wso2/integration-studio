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
package org.eclipse.bpel.ui.util;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Nov 7, 2006
 *
 */

@SuppressWarnings("nls")

public class UIDebug {
	
	/**
	 * Dump the widget structure for the control.
	 * 
	 * @param control
	 */
	static public final void dump (Control control) {
		dump(control,0);
	}
	
	/**
	 * Dump the widget structure of the control. 
	 * Level is just how much indentation on the output there should
	 * be.
	 * 
	 * @param control
	 * @param level
	 */
	
	static public final void dump (Control control, int level) {
		
		p(level,"+-");
		p(level,"+- ctrl: {0}",control); 
				
		p(level,"+- data={0}",control.getLayoutData() );
		p(level,"+- location={0},size={1}", control.getLocation(), control.getSize());
		if (control instanceof Composite) {
			Composite composite = (Composite) control;	
			Control [] children = composite.getChildren();
			p(level,"+- layout={0}",composite.getLayout());
			if (children.length > 0) {
				p(level,"+- childCount={0}",children.length);
				for(int i=0; i < children.length; i++) {
					dump ( children[i], level + 3);
				}
			}
		}
	}
		
	static final void p (int level, String format, Object ... args) {
		for(int i=0; i<level;i++) {
			System.out.print(' ');
		}
		System.out.println(java.text.MessageFormat.format(format, args));
	}
}
