/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.general.project.refactor;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.MoveArguments;
import org.eclipse.ltk.core.refactoring.participants.MoveParticipant;
import org.wso2.developerstudio.eclipse.general.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class RegistryArtifactMetadataMoveParticipant extends MoveParticipant {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private IResource originalResource;
	private IContainer destination;
	private IProject registryProject;

	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
	                                                                                            throws OperationCanceledException {
		return RefactoringStatus.createWarningStatus("You are about to move a Registry Resource Artifact");
	}

	public Change createPreChange(IProgressMonitor arg0) throws CoreException,
	                                                    OperationCanceledException {
		CompositeChange change = new CompositeChange("Registry Artifact Move");

		// If originalResource is a folder and sub folders contain artifacts
		// artifact.xml content change
		if (originalResource instanceof IFolder) {
			IFolder iFolder = (IFolder) originalResource;
			ArrayList<IResource> fList = listFiles(iFolder, new ArrayList<IResource>());
			Iterator<IResource> iterator = fList.iterator();

			while (iterator.hasNext()) {
				IResource res = iterator.next();
				if (res instanceof IFile) {
					String relativePath =
					                      FileUtils.getRelativePath(originalResource.getParent()
					                                                                .getLocation()
					                                                                .toFile(),
					                                                res.getParent().getLocation()
					                                                   .toFile());
					IFolder newDestination =
					                         registryProject.getFolder(destination.getProjectRelativePath() +
					                                                   "/" + relativePath);
					change.add(new RegistryMetadataArtifactMoveChange(
					                                                  registryProject.getName(),
					                                                  registryProject.getFile("artifact.xml"),
					                                                  res, newDestination));

				}
			}
		} else {
			// artifact.xml content change
			change.add(new RegistryMetadataArtifactMoveChange(
			                                                  registryProject.getName(),
			                                                  registryProject.getFile("artifact.xml"),
			                                                  originalResource, destination));
		}

		return change;
	}

	public ArrayList<IResource> listFiles(IResource resource, ArrayList<IResource> list) {

		if (resource instanceof IFolder) {
			IResource[] fList = null;
			try {
				fList = ((IFolder) resource).members();
			} catch (CoreException e) {
				log.error("Error occured while listing subfolders and files", e);
			}
			for (IResource res : fList) {
				if (res instanceof IFile &&
				    !(FilenameUtils.getExtension(res.getName()).equals("esb") || FilenameUtils.getExtension(res.getName())
				                                                                              .equals("esb_diagram"))) {
					list.add(res);
				} else if (res instanceof IFolder && !(res.getName().equalsIgnoreCase(".meta"))) {
					list.addAll(listFiles(res, new ArrayList<IResource>()));
				}
			}
		}

		return list;
	}

	public String getName() {
		return "RegistryResourceArtifactMove";
	}

	protected boolean initialize(Object arg0) {
		// Similar to check initial conditions
		if (arg0 instanceof IResource) {
			originalResource = (IResource) arg0;
			registryProject = originalResource.getProject();
			MoveArguments arguments = getArguments();
			destination = (IContainer) arguments.getDestination();
			return true;
		}
		return false;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException,
	                                               OperationCanceledException {
		return null;
	}

}
