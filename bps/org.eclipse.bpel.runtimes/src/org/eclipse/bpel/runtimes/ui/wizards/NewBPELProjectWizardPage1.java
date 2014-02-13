/*******************************************************************************
 * Copyright (c) 2006 University College London Software Systems Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Bruno Wassermann - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.runtimes.ui.wizards;

import org.eclipse.bpel.runtimes.IBPELModuleFacetConstants;
import org.eclipse.bpel.runtimes.IRuntimesUIConstants;
import org.eclipse.bpel.runtimes.RuntimesPlugin;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.web.ui.internal.wizards.DataModelFacetCreationWizardPage;

/**
 * <code>DataModelFacetCreationWizardPage</code> for setting up a new BPEL
 * project.
 *
 * @author Bruno Wassermann, written Jun 29, 2006
 */
public class NewBPELProjectWizardPage1 extends DataModelFacetCreationWizardPage {

	public NewBPELProjectWizardPage1(IDataModel dataModel, String pageName) {
		super(dataModel, pageName);
		//setTitle(org.eclipse.bpel.runtimes.ui.wizards.Messages.NewProjectWizard_1);
		//setDescription(org.eclipse.bpel.runtimes.ui.wizards.Messages.NewProjectWizardPage1_1);
		setTitle(org.eclipse.bpel.runtimes.ui.wizards.Messages.NewProjectWizard_1);
		setDescription(org.eclipse.bpel.runtimes.ui.wizards.Messages.NewProjectWizardPage1_1);		
		setImageDescriptor(RuntimesPlugin.getPlugin().getImageDescriptor(IRuntimesUIConstants.ICON_NEWPRJ_WIZARD_BANNER));
	}
	
	protected String getModuleFacetID() {
		return IBPELModuleFacetConstants.BPEL20_MODULE_TYPE;
	}

	protected String getModuleTypeID() {
		return IBPELModuleFacetConstants.BPEL20_PROJECT_FACET;
	}
	
}
