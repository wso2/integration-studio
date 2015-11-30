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
package org.eclipse.bpel.common.ui.assist;

import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.fieldassist.ContentAssistCommandAdapter;

/**
 * This is a field assist adapter which extends the core SWT content
 * assist adapter and allows programmatic opening of the assist dialog 
 * as well as automatic width sizing.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 9, 2006
 *
 */
public class FieldAssistAdapter extends ContentAssistCommandAdapter {

	
	/**
	 * @param control
	 * @param controlContentAdapter
	 * @param proposalProvider
	 * @param commandId
	 * @param autoActivationCharacters
	 */
	public FieldAssistAdapter(Control control, IControlContentAdapter controlContentAdapter, IContentProposalProvider proposalProvider, String commandId, char[] autoActivationCharacters) {
		super(control, controlContentAdapter, proposalProvider, commandId,
				autoActivationCharacters);
	}

	/**
	 * @param control
	 * @param controlContentAdapter
	 * @param proposalProvider
	 * @param commandId
	 * @param autoActivationCharacters
	 * @param installDecoration
	 */
	public FieldAssistAdapter(Control control, IControlContentAdapter controlContentAdapter, IContentProposalProvider proposalProvider, String commandId, char[] autoActivationCharacters, boolean installDecoration) {
		super(control, controlContentAdapter, proposalProvider, commandId,
				autoActivationCharacters, installDecoration);
	}

	public void  openProposals () {
		openProposalPopup();
		getControl().setFocus();
	}
	
	
	@Override
	protected void openProposalPopup () {
		
		Point popupSize = getPopupSize();
		popupSize.x = getProposalWidth();
		
		super.openProposalPopup();
	}
	
	public int getProposalWidth () {
		Point size = getControl().getSize();
		return size.x + 20;
	}
}
