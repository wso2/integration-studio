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

import org.eclipse.bpel.common.ui.command.ICommandFramework;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.swt.graphics.Image;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 25, 2006
 *
 */
public class CommandProposal extends AbstractContentProposal
	implements IContentProposalListener
{

	protected Command fCmd ;
	protected ICommandFramework fCmdFramework;
	
	/**
	 * @param cmdFramework
	 */
	public CommandProposal ( ICommandFramework cmdFramework ) {
		super();
		fCmdFramework = cmdFramework;		
	}

	/** 
	 * @return the command
	 */
	public Command getCommand () {
		return fCmd;
	}
	
	/**
	 * @param cmd
	 */
	public void setCommand ( Command cmd ) {
		fCmd = cmd;
	}
	
	/**
	 * @see org.eclipse.bpel.ui.proposal.providers.AbstractContentProposal#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_COMMAND_16);		
	}

	/**
	 * @see org.eclipse.bpel.ui.proposal.providers.AbstractContentProposal#getLabel()
	 */
	@Override
	public String getLabel()
	{
		Command cmd = getCommand ();
		if (cmd != null ) {
			return cmd.getLabel();
		}
		return "???"; //$NON-NLS-1$
	}
	

	
	/** (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposalListener#proposalAccepted(org.eclipse.jface.fieldassist.IContentProposal)
	 */
	
	public void proposalAccepted (IContentProposal proposal) {
		// we have been chosen
		if (proposal.equals ( this )) {			
			fCmdFramework.execute( getCommand() );			
		}		
	}					
}
