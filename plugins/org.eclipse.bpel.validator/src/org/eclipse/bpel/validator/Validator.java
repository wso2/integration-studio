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
package org.eclipse.bpel.validator;

import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.wst.validation.internal.core.ValidationException;
import org.eclipse.wst.validation.internal.provisional.core.IMessage;
import org.eclipse.wst.validation.internal.provisional.core.IReporter;
import org.eclipse.wst.validation.internal.provisional.core.IValidationContext;
import org.eclipse.wst.validation.internal.provisional.core.IValidator;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Mar 12, 2007
 * 
 */

@SuppressWarnings({"nls","restriction"})

public class Validator implements IValidator {

	boolean bDebug = true;
	
	int     mechanism = 1;
	
	Builder fBuilder = new Builder();
	
	IAdapterManager fAdapterManager = Platform.getAdapterManager();
	
	/**
	 * Create a brand new shiny validator.
	 */
	
	public Validator () {	
		fBuilder.bDebug = bDebug;		
	}
	
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.validation.internal.provisional.core.IValidator#cleanup(org.eclipse.wst.validation.internal.provisional.core.IReporter)
	 */
	public void cleanup (IReporter reporter) {

	}

	/**
	 * @see org.eclipse.wst.validation.internal.provisional.core.IValidator#validate(org.eclipse.wst.validation.internal.provisional.core.IValidationContext,
	 *      org.eclipse.wst.validation.internal.provisional.core.IReporter)
	 */
	
	
	
	public void validate (IValidationContext helper, IReporter reporter)
			throws ValidationException {

		reporter.removeAllMessages(this);
		
		String s[] = helper.getURIs();
		
		if (s.length < 1) {
			return ;
		}		
				
		for (String f : s) {	

			p("Starting validation of " + f );
			IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(f);
			if (resource == null || resource.getType() != IResource.FILE) {
				p("File " + f + " does not exist and cannot be validated.");
				continue ;
			}
			
			//because the validate will validate its referenced artefacts, if those referenced 
			//file was changed, clear the catch to make sure those referenced file to be reloaded.
			fBuilder.clearCach();			
			
			if (mechanism == 1) {
				// delegate all the "builder"
				p("Using mechanism 1: Calling Builder");
				try {
					fBuilder.validate(resource, new NullProgressMonitor() );
				} catch (CoreException ce) {
					Activator.log(ce);
				}
			} else if (mechanism == 2) {
				p("Using mechanism 2: Using reporter and message");
				IProblem problems[] = fBuilder.validate( (IFile) resource, new NullProgressMonitor());
				for(IProblem p : problems) {
					IMessage msg = (IMessage) fAdapterManager.getAdapter(p, IMessage.class);
					if (msg != null) {
						reporter.addMessage(this, msg);
					}
				}
			}
		}
	}

	
	
	
	void p(String msg) {
		if (bDebug) {
			System.out.printf("[%1$s]>> %2$s\n", getClass().getName(),msg);	
			System.out.flush();
		}
	}

}
