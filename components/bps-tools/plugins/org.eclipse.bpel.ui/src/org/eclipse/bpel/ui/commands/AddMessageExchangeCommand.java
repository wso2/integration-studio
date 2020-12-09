/**
 * <copyright>
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 */

package org.eclipse.bpel.ui.commands;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * Add messageExchange to process
 * 
 * @author Miriam Grundig (MGrundig@de.ibm.com)
 */
public class AddMessageExchangeCommand extends AddToListCommand {

	Process process;
	Scope scope;
	
	public AddMessageExchangeCommand (EObject eObj, MessageExchange messageExchange) {
		super(ModelHelper.getContainingScope( eObj ), messageExchange, IBPELUIConstants.CMD_ADD_MESSAGEEXCHANGE);
		if (target instanceof Process) {
			this.process = (Process)target;
		} else if (target instanceof Scope) {
			this.scope = (Scope)target;
		}
	}
	
	/**
	 * List in which to insert new element
	 */
	@Override
	protected EList<MessageExchange> getList() {
		if (process != null) {
			if (process.getMessageExchanges() != null)
				return process.getMessageExchanges().getChildren();
			else return null;
		} else if (scope != null) {
			if(scope.getMessageExchanges() != null)
				return scope.getMessageExchanges().getChildren();
			else return null;
		} 
		throw new IllegalStateException("Container must either be a scope or a process"); //$NON-NLS-1$
	}
	
	/**
	 * Called before adding to the list, if getList() returns null or if it returns an empty list.
	 */
	@Override
	protected void createList() {
		if (process != null) {
			if (process.getMessageExchanges() == null)
				process.setMessageExchanges(BPELFactory.eINSTANCE.createMessageExchanges());
		} else if (scope != null) {
			if(scope.getMessageExchanges() == null)
				scope.setMessageExchanges(BPELFactory.eINSTANCE.createMessageExchanges());
		} 
	}
}
