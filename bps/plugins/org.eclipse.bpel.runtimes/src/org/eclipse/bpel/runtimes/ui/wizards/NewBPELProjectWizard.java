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
package org.eclipse.bpel.runtimes.ui.wizards;

import org.eclipse.bpel.runtimes.IBPELModuleFacetConstants;
import org.eclipse.bpel.runtimes.IRuntimesUIConstants;
import org.eclipse.bpel.runtimes.RuntimesPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.INewWizard;
import org.eclipse.wst.common.componentcore.datamodel.FacetProjectCreationDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.project.facet.core.IFacetedProjectTemplate;
import org.eclipse.wst.common.project.facet.core.ProjectFacetsManager;
import org.eclipse.wst.web.ui.internal.wizards.NewProjectDataModelFacetWizard;

/**
 * <code>INewWizard</code> implementation for new BPEL project wizard 
 * installing the BPEL facet by default. 
 *
 * @author Bruno Wassermann, written Jun 28, 2006
 */
public class NewBPELProjectWizard extends NewProjectDataModelFacetWizard
		implements INewWizard 
{

	/**
	 * Default constructor.
	 */
	public NewBPELProjectWizard() {
		super();
		setWindowTitle(Messages.NewProjectWizard_1);
	}
	
	/**
	 * Constructor settings this wizard's <code>IDataModel</code>.
	 * 
	 * @see <code>IDataModel</code>
	 * @param model <code>IDataModel</code> 
	 */
	public NewBPELProjectWizard(IDataModel model) {
		super(model);
		setWindowTitle(Messages.NewProjectWizard_1);
	}
	
	/**
	 * Creates an instance of the <code>FacetProjectCreationDataModelProvider</code>
	 * for BPEL projects. Used to associate common facet information such as
	 * runtimes with particular a project. 
	 * 
	 * @see <code>FacetProjectCreationDataModelProvider</code>
	 * @return <code>IDataModel</code>
	 */
	@Override
	protected IDataModel createDataModel() {
		
		/*
		 * There does not seem to be a need for any custom implementation for
		 * BPEL projects at this stage. May have to reconsider at some point and
		 * build a BPELFacetProjectCreationDataModelProvider.
		 */
		return DataModelFactory.createDataModel(new FacetProjectCreationDataModelProvider());
	}

	/**
	 * Getting image descriptor to be used as wizard banner.
	 * 
	 * @return <code>ImageDescriptor</code>
	 */
	@Override
	protected ImageDescriptor getDefaultPageImageDescriptor() {
		return RuntimesPlugin.getPlugin().getImageDescriptor(IRuntimesUIConstants.ICON_NEWPRJ_WIZARD_BANNER);
	}

	/**
	 * Getting the <code>IFacetedProjectTemplate</code> for a BPEL project. 
	 * Is used to retrieve the set of fixed facets for a particular project 
	 * type.
	 * 
	 * @see org.eclipse.wst.common.project.core.IFacetedProjectTemplate
	 * @return org.eclipse.wst.common.project.core.IFacetedProjectTemplate
	 * 
	 */
	@Override
	protected IFacetedProjectTemplate getTemplate() {
		return ProjectFacetsManager.getTemplate(IBPELModuleFacetConstants.BPEL20_FACET_TEMPLATE); 
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.wst.web.ui.internal.wizards.NewProjectDataModelFacetWizard#createFirstPage()
	 */
	@Override
	protected IWizardPage createFirstPage() {
		return new NewBPELProjectWizardPage1(model, "newBPELProject"); // $NON-NLS-1$
	}
	
	protected String getFinalPerspectiveID() {
		return "org.eclipse.bpel.ui.perspective"; //$NON-NLS-1$
	}
}
