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
package org.eclipse.bpel.ui.proposal.providers;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * This proposal registers itself as a listener of the 
 * entity on which the proposal mechanism is installed on.
 * 
 * It serves as both the executor of the proposal and the provider
 * of the proposal.
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 25, 2006
 *
 */

public abstract class RunnableProposal 
	extends AbstractContentProposal 
	implements IContentProposalListener, Runnable {

	
	/**
	 * @see org.eclipse.bpel.ui.proposal.providers.AbstractContentProposal#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {		
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_COMMAND_16);
	}

	/** (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposalListener#proposalAccepted(org.eclipse.jface.fieldassist.IContentProposal)
	 */
	public void proposalAccepted (IContentProposal proposal) {
		if (this.equals( proposal )) {
			run();
		}		
	}
	
	

	 
}
