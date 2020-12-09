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

import org.eclipse.bpel.common.ui.editmodel.AbstractEditModelCommand;
import org.eclipse.bpel.model.adapters.INamespaceMap;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;


/** 
 * Generic "model-setting" command.  Subclasses only need to implement get() and set()
 * in terms of the particular model property they set.
 */
public class SetNamespaceMappingCommand extends AbstractEditModelCommand {


	/** Target */
	protected EObject fTarget;
	String fNamespace;
	String fPrefix;
	String fPreviousNS;
	

	/**
	 * Brand new shiny SetNamespaceMappingCommand command.	 
	 * 
	 * @param aTarget the target EMF object
	 * @param ns the namespace
	 * @param prefix the prefix.
	 */
	
	public SetNamespaceMappingCommand (EObject aTarget, String ns, String prefix )  {				
		fTarget = aTarget;
		fNamespace = ns;
		fPrefix = prefix;
	}
	
	/**
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return BPELUtils.isValidPrefixName(fPrefix);
	}


	/**
	 * @see org.eclipse.gef.commands.Command#dispose()
	 */
	@Override
	public void dispose() {
		fTarget = null;
		fPrefix = null;
		fNamespace = null;
		super.dispose();
	}


	/**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		INamespaceMap<String, String> nsMap = BPELUtils.getNamespaceMap(fTarget);
		fPreviousNS = nsMap.put(fPrefix, fNamespace);
	}


	/**
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		INamespaceMap<String, String> nsMap = BPELUtils.getNamespaceMap(fTarget);
		if (fPreviousNS == null) {
			nsMap.remove(fPrefix);
		} else {
			nsMap.put(fPrefix,fPreviousNS);
		}		
	}

	/**
	 * @see org.eclipse.bpel.common.ui.editmodel.AbstractEditModelCommand#getModifiedResources()
	 */
	@Override
	public Resource[] getModifiedResources() {
		
		Resource resource = fTarget.eResource();
		if (resource != null) {
			return new Resource[] { resource };
		}
		return EMPTY_RESOURCE_ARRAY;
	}

	
}
