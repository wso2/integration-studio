/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.swt.graphics.Image;

/**
 * @author mchmiele
 *
 */
public class XSDSimpleTypeDefinitionAdapter extends XSDAbstractAdapter  {

	@Override
	public Image getSmallImage(Object object) {		
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_XSD_SIMPLE_TYPE_DEFINITION_16);
	}
		
	@Override
	public String getTypeLabel(Object object) {
		return Messages.XSDSimpleTypeDefinitionAdapter_0; 
	}	
}
