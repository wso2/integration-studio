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
package org.eclipse.bpel.ui.wizards;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.util.filedialog.FileSelectionGroup;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.wst.common.componentcore.ModuleCoreNature;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 20, 2006
 *
 */
public class NewFileWizardPage2 extends WizardPage {

	private FileSelectionGroup fResourceComposite;
	private String processName;

	/**
	 * New File Wizard, page 2.
	 * 
	 * @param pageName
	 */

  	public NewFileWizardPage2(String pageName) 
    {
        super(pageName);
        setPageComplete(false);
        
		setTitle(Messages.NewFileWizardPage2_3);
		setDescription(Messages.NewFileWizardPage2_0);
		
        setImageDescriptor( BPELUIPlugin.INSTANCE.getImageDescriptor( IBPELUIConstants.ICON_WIZARD_BANNER ));
    }
  
	/** (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl (Composite parent) {
		
		final NewFileWizard wiz = (NewFileWizard) getWizard();
		Composite composite = new Composite(parent, SWT.NULL);

		initializeDialogUnits(parent);

		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Start Resource Variant
		fResourceComposite = new FileSelectionGroup(composite,
			new Listener() {
				public void handleEvent(Event event) {
					IResource resource = fResourceComposite.getSelectedResource();
					setPageComplete(validatePage(resource));
					if (resource instanceof IContainer)
						wiz.setBPELContainer((IContainer)resource);
				}
			},
			Messages.NewFileWizardPage2_1,
			Messages.NewFileWizardPage2_2);
		// https://issues.jboss.org/browse/JBIDE-8591
		// update wizard so first page gets the new resource location
		fResourceComposite.setSelectedResource(wiz.getBPELContainer());
		setControl(composite);
	}
	
	private boolean validatePage(IResource resource){
		if (resource instanceof IContainer) {
			IContainer container = (IContainer)resource;
			// https://issues.jboss.org/browse/JBIDE-8591
			if (!ModuleCoreNature.isFlexibleProject(resource.getProject())) {
				setMessage(Messages.NewFileWizard_Not_A_Faceted_Project, WizardPage.WARNING);
				return false;
			}
			
			if ( container.findMember(processName +".bpel") != null ) { //$NON-NLS-1$
				setMessage(Messages.NewFileWizardPage1_12, WizardPage.ERROR);
				return false;
			}
			setMessage(null);
			return true;
		}
		return false;
	}
	
	/**
	 * Return the selected resource container for the BPEL project.
	 * @return the resource container.
	 */
	
	public IContainer getResourceContainer () {
		IResource resource = fResourceComposite.getSelectedResource();
		if (resource != null && resource instanceof IContainer) {
			return (IContainer) resource;
		}
		return null;		
	}	
	
	public void setProcessName(String processName) {
		this.processName = processName;
	}

	
	public boolean isPageComplete() {
		
		IContainer container = getResourceContainer();
		if (container==null)
			return false;
		
		if (!ModuleCoreNature.isFlexibleProject(container.getProject()))
			return false;
		
		if ( container.findMember(processName +".bpel") != null ) //$NON-NLS-1$
			return false;
		
		if (!super.isPageComplete())
			return false;
		
		return true;
	}
}
