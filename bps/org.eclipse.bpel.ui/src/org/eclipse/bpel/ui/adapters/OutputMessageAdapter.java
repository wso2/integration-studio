/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wst.wsdl.Output;

public class OutputMessageAdapter extends MessageAdapter  {
	
	
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_OUTPUT_16);
	}
	
	
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_OUTPUT_32);
	}	
	
	
	public String getTypeLabel(Object object) {
		return Messages.OutputMessageAdapter_0; 
	}	
	
	
	public String getLabel (Object object) {
		Output output = (Output) object;
		return super.getLabel ( output.getMessage() );
	}
}
