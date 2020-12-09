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
package org.eclipse.bpel.ui.commands;

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.uiextensionmodel.PartnerLinkExtension;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * Adds a PartnerLink to the Process.
 */
public class AddPartnerLinkCommand extends AddToListCommand {

	Process process;
	PartnerLink partnerLink;
	PartnerLinkExtension extension = null;
	Scope scope;
	
	
	
	public AddPartnerLinkCommand (EObject eObj, PartnerLink partnerLink, PartnerLinkExtension extension) {
		super(ModelHelper.getContainingScope( eObj ), partnerLink, IBPELUIConstants.CMD_ADD_PARTNERLINK);
		if (target instanceof Process) {
			this.process = (Process)target;
		} else if (target instanceof Scope) {
			this.scope = (Scope)target;
		}
		this.partnerLink = partnerLink;
		this.extension = extension;
	}
	

	public AddPartnerLinkCommand (EObject eObj, PartnerLink partnerLink ) {
		this(eObj,partnerLink,null);				
	}

	@Override
	protected EList<PartnerLink> getList() {
		if (process != null) {
			return process.getPartnerLinks().getChildren();
		} else if (scope != null) {
			return scope.getPartnerLinks().getChildren();
		} 
		throw new IllegalStateException("Container must either be a scope or a process"); //$NON-NLS-1$
	}

	
	@Override
	public void doExecute() {
		if (extension != null) {
			ModelHelper.getBPELEditor(process).getExtensionMap().put(partnerLink, extension);
		}
		super.doExecute();
	}
}
