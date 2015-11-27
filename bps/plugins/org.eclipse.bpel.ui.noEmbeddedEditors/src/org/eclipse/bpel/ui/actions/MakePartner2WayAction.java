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
package org.eclipse.bpel.ui.actions;

import java.util.List;

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;


/**
 * Transforms an Interface partner link into a 2-way partner link.
 */
public class MakePartner2WayAction extends SelectionAction {

	public static final String ID = "org.eclipse.bpel.ui.actions.MakePartner2WayAction"; //$NON-NLS-1$
	
	public MakePartner2WayAction(IWorkbenchPart part) {
		super(part);
		setId(ID);
		setText(Messages.MakePartner2WayAction_0); 
	}

	@Override
	protected boolean calculateEnabled() {
		PartnerLink partner = getPartnerLink();
		if (partner != null) {
			return ModelHelper.isInterfacePartnerLink(partner) 
				&& !ModelHelper.isReferencePartnerLink(partner);
		}
		return false;
	}
	
	protected PartnerLink getPartnerLink() {
		List selected = getSelectedObjects();
		// we do not allow multi-selection
		if (selected.size() == 1 && (selected.get(0) instanceof PartnerLink)) {
			return (PartnerLink)selected.get(0);
		}
		return null;
	}

	@Override
	public void run() {
		PartnerLink partner = getPartnerLink();
		PartnerLinkType plt = partner.getPartnerLinkType();
		if (plt == null) return;
		Command command = ModelHelper.createSetRoleCommand(partner, plt, ModelHelper.PARTNER_ROLE);
		BPELEditor editor = (BPELEditor)getWorkbenchPart();
		editor.getCommandStack().execute(command);
	}
}
