/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.model.adapters.AbstractAdapter;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.editparts.EndNodeEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;


public class EndNodeAdapter extends AbstractAdapter implements EditPartFactory, ILabeledElement {

	/* ILabeledElement */
	
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(
			IBPELUIConstants.ICON_ENDNODE_16_GIF);
	}

	public Image getLargeImage(Object object) {
		// There is no large image.
		return null;
	}	

	public String getLabel(Object object) {
		return getTypeLabel(object);
	}
	
	public String getTypeLabel(Object object) {
		return Messages.EndNodeAdapter_End_1; 
	}

	/* EditPartFactory */

	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new EndNodeEditPart();
		result.setModel(model);
		return result;
	}
}
