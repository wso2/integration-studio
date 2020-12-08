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

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
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

public class RegistryResourceArtifactMoveParticipant extends MoveParticipant {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private IResource originalResource;
	private IContainer destination;

	public RefactoringStatus checkConditions(IProgressMonitor arg0, CheckConditionsContext arg1)
	                                                                                            throws OperationCanceledException {
		return RefactoringStatus.createWarningStatus("You are about to move a Registry Resource Artifact");
	}

	public Change createPreChange(IProgressMonitor arg0) throws CoreException,
	                                                    OperationCanceledException {
		CompositeChange change = new CompositeChange("Registry Artifact Move");

		// If originalResource is a file
		if (originalResource instanceof IFile) {
			String originalNameWithoutExtension =
			                                      FilenameUtils.removeExtension(originalResource.getName());
			String esbFileName = getEsbFile(originalNameWithoutExtension);
			String esbDiagramFileName = getEsbDiagramFile(originalNameWithoutExtension);

			// graphical resource move operation
			// Move .esb file
			IFile esbIFile =
			                 originalResource.getProject()
			                                 .getFile(originalResource.getParent()
			                                                          .getProjectRelativePath() +
			                                                  "/" + esbFileName);
			if (esbIFile.exists()) {
				change.add(new RegistryResourceArtifactMoveChange(esbIFile, destination));
			}

			// Move .esb_diagram file
			IFile esbDiagramIFile =
			                        originalResource.getProject()
			                                        .getFile(originalResource.getParent()
			                                                                 .getProjectRelativePath() +
			                                                         "/" + esbDiagramFileName);
			if (esbDiagramIFile.exists()) {
				change.add(new RegistryResourceArtifactMoveChange(esbDiagramIFile, destination));
			}
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

	private String getEsbDiagramFile(String fileName) {
		String prefix = getDirectoryPrefix();
		return prefix + fileName + ".esb_diagram";
	}

	private String getEsbFile(String fileName) {
		String prefix = getDirectoryPrefix();
		return prefix + fileName + ".esb";
	}

	private String getDirectoryPrefix() {

		String directoryPrefix = "";

		try {
			if (originalResource instanceof IFile) {
				InputStream in = ((IFile) originalResource).getContents(true);
				OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(in);
				OMElement documentElement = builder.getDocumentElement();
				directoryPrefix = documentElement.getLocalName() + "_";
			}
		} catch (CoreException e) {
			log.error("Error occured while getting directory prefix", e);
		}

		return directoryPrefix;
	}

	public String getName() {
		return "RegistryResourceArtifactMove";
	}

	protected boolean initialize(Object arg0) {
		// Similar to check initial conditions
		if (arg0 instanceof IResource) {
			originalResource = (IResource) arg0;
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
