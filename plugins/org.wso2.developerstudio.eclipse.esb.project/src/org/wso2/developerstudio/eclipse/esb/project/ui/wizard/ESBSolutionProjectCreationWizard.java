/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.esb.project.ui.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.wso2.developerstudio.eclipse.artifact.connector.ui.wizard.ConnectorCreationWizard;
import org.wso2.developerstudio.eclipse.distribution.project.model.DistributionProjectModel;
import org.wso2.developerstudio.eclipse.distribution.project.ui.wizard.DistributionProjectWizard;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.model.ESBSolutionProjectModel;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBImageUtils;
import org.wso2.developerstudio.eclipse.general.project.ui.wizard.GeneralProjectWizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;

/**
 * This wizard class is to create ESB, Registry, Connector Exporter, Composite
 * projects as an ESB solution project
 * 
 */
public class ESBSolutionProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private IProject project;
	private ESBSolutionProjectModel esbSolutionProjectModel;

	public ESBSolutionProjectCreationWizard() {
		setEsbSolutionProjectModel(new ESBSolutionProjectModel());
		setModel(esbSolutionProjectModel);
		setDefaultPageImageDescriptor(ESBImageUtils.getInstance().getImageDescriptor("esb-project-wizard.png"));
	}

	public boolean performFinish() {
		String projectName = esbSolutionProjectModel.getProjectName();
		// Creating ESB project
		ESBProjectWizard esbProjectWizard = new ESBProjectWizard();
		esbProjectWizard.setEsbProjectModel(esbSolutionProjectModel);
		esbProjectWizard.setModel(esbSolutionProjectModel);
		esbProjectWizard.performFinish();

		// Creating Registry Project
		GeneralProjectWizard generalProjectWizard = new GeneralProjectWizard();
		try {
			esbSolutionProjectModel.setProjectName(projectName + "RegistryProject");
		} catch (ObserverFailedException e1) {
			log.error("Failed to set project name : " + projectName, e1);
		}
		generalProjectWizard.setModel(esbSolutionProjectModel);
		generalProjectWizard.performFinish();

		// Creating connector Exporter Project
		ConnectorCreationWizard connectorWizard = new ConnectorCreationWizard();
		try {
			esbSolutionProjectModel.setProjectName(projectName + "ConnectorExporterProject");
		} catch (ObserverFailedException e1) {
			log.error("Failed to set project name : " + projectName, e1);
		}
		connectorWizard.setModel(esbSolutionProjectModel);
		connectorWizard.performFinish();

		// Creating Composite Project
		DistributionProjectWizard distributionProjectWizard = new DistributionProjectWizard();
		DistributionProjectModel distributionModel = new DistributionProjectModel();
		try {
			esbSolutionProjectModel.setProjectName(projectName + "CompositeProject");
			distributionModel.setProjectName(projectName + "CompositeProject");
			distributionModel.setGroupId(esbSolutionProjectModel.getGroupId());
			distributionModel.setIsUserDefine(esbSolutionProjectModel.isUserSet());
			distributionModel.setLocation(esbSolutionProjectModel.getLocation());
			distributionModel.setMavenInfo(esbSolutionProjectModel.getMavenInfo());
			distributionModel.setSelectedOption(esbSolutionProjectModel.getSelectedOption());
			distributionModel.setSelectedWorkingSets(esbSolutionProjectModel.getSelectedWorkingSets());
		} catch (ObserverFailedException e) {
			log.error("Failed to set properties for project : " + projectName, e);
		}
		distributionProjectWizard.setModel(distributionModel);
		distributionProjectWizard.performFinish();

		return true;
	}

	public ESBSolutionProjectModel getEsbSolutionProjectModel() {
		return esbSolutionProjectModel;
	}

	public void setEsbSolutionProjectModel(ESBSolutionProjectModel esbProjectModel) {
		this.esbSolutionProjectModel = esbProjectModel;
	}

	public IResource getCreatedResource() {
		return project;
	}

	public void setCurrentSelection(ISelection currentSelection) {
		// TODO Auto-generated method stub
		super.setCurrentSelection(currentSelection);
	}

}