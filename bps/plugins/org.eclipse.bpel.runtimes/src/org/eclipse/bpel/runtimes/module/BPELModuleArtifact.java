/*******************************************************************************
 * Copyright (c) 2006, 2012 University College London Software Systems Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Bruno Wassermann - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.runtimes.module;

import org.eclipse.core.resources.IFile;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IModuleArtifact;

/**
 * Representing a simple BPEL module as an <code>IModuleArtifact</code>. Not
 * sure at this stage what is needed to actually launch deployed BPEL process,
 * so this implementation is going to change considerably in the near future.
 *
 * @author Bruno Wassermann, written Aug 14, 2006
 */
public class BPELModuleArtifact implements IModuleArtifact {

	private IModule module;
	private IFile file;
	
	/**
	 *  Constructor accepting module and corresponding bpel file.
	 * 
	 * @param module <code>IModule</code>
	 * @param file <code>IFile</code> the corresponding bpel file
	 */
	public BPELModuleArtifact(IModule module, IFile file) {
		super();
		this.module = module;
		this.file = file;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.wst.server.core.IModuleArtifact#getModule()
	 */
	public IModule getModule() {
		return module;
	}
	
	public IFile getFile() {
		return file;
	}
	
	/**
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return "BPELModuleArtifact [module=" + module + "]";
	}

}
