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
package org.eclipse.bpel.ui.dnd;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 18, 2007
 *
 */
public class BPELTemplateTransferDropTargetListener extends TemplateTransferDropTargetListener  {

	/**
	 * @param arg0
	 */
	public BPELTemplateTransferDropTargetListener(EditPartViewer arg0) {
		super(arg0);
	}		
	
}
