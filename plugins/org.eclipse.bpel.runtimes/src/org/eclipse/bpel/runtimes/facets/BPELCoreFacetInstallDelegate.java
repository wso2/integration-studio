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
package org.eclipse.bpel.runtimes.facets;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.runtimes.IBPELModuleFacetConstants;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jst.common.project.facet.WtpUtils;
import org.eclipse.wst.common.componentcore.internal.util.IComponentImplFactory;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.project.facet.core.IDelegate;
import org.eclipse.wst.common.project.facet.core.IProjectFacetVersion;


/**
 * BPEL Facet implementation of <code>IDelegate</code>. 
 * <p>
 * Note: Must not call IFacetedProject.modify() to install facet as this is
 * a prohibited operation from a delegate and will throw <code>CoreException</code>.
 *
 * @author Bruno Wassermann, written Jun 7, 2006
 */
public class BPELCoreFacetInstallDelegate implements IDelegate {

	/**
	 * At the moment, there does not appear to be any opportunity to do some
	 * common setup of stuff here (e.g., set up a WEB-INF folder, etc.). 
	 * Maybe some common requirements will become apparent at some later stage.
	 */
	
	/** (non-Javadoc)
	 * @see org.eclipse.wst.common.project.facet.core.IDelegate#execute(org.eclipse.core.resources.IProject, org.eclipse.wst.common.project.facet.core.IProjectFacetVersion, java.lang.Object, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@SuppressWarnings("nls")
	public void execute(IProject proj, 
						IProjectFacetVersion ver, 
						Object obj,
						IProgressMonitor progMon) 
		throws CoreException 
	{
		progMon.beginTask( "Configuring ...", 300 ); //$NON-NLS-1$
		IDataModel model = (IDataModel)obj;
		String contentRoot = (String)model.getProperty(BPELFacetInstallDataModelProvider.BPEL_CONTENT_FOLDER);
		contentRoot = (contentRoot == null || "".equals(contentRoot)) ? IBPELModuleFacetConstants.BPEL_CONTENT_DEFAULT_FOLDER : contentRoot;
		
        // add natures
        WtpUtils.addNatures(proj);

        // Create the content folder
        IFolder bpelContent = proj.getFolder(contentRoot);
        if (!bpelContent.exists())
        	bpelContent.create(true,true, null);
        
        // create the virtual component
        IComponentImplFactory factory = new BPELVirtualComponent();
        IVirtualComponent newComponent = factory.createComponent(proj);
        newComponent.create(0, null);
        progMon.worked(100);

        // Add the resource mapping to bpelContent
        newComponent.getRootFolder().createLink(new Path("/" + contentRoot), 0, null);
		progMon.worked(100);
		// Add builder
		addBuilder(proj, new SubProgressMonitor(progMon, 100));
		progMon.done();
	}
	protected void addBuilder(IProject proj, IProgressMonitor monitor) throws CoreException {
		// Add the builder to the project description
		IProjectDescription description = proj.getDescription();

		// Our builder name
		String builderName = "org.eclipse.bpel.validator.builder"; //$NON-NLS-1$

		// Install the builder (validator)

		ICommand buildCommand = description.newCommand();

		// We only support 1 argument now, its "debug"
		Map<String, String> args = new HashMap<String, String>();
		args.put("debug", "false");
		buildCommand.setArguments(args);

		buildCommand.setBuilderName(builderName);

		ICommand[] commands = description.getBuildSpec();

		if (commands == null) {
			description.setBuildSpec(new ICommand[] { buildCommand });
			proj.setDescription(description, IResource.KEEP_HISTORY, monitor);

		} else {

			boolean bFound = false;
			for (ICommand c : commands) {
				if (builderName.equals(c.getBuilderName())) {
					bFound = true;
					break;
				}
			}

			// not found
			if (bFound == false) {
				int i = commands.length;
				ICommand[] newCommands = new ICommand[i + 1];
				System.arraycopy(commands, 0, newCommands, 0, i);
				newCommands[i] = buildCommand;
				description.setBuildSpec(newCommands);
				proj.setDescription(description, IResource.KEEP_HISTORY, monitor);
			}
		}
	}
}
