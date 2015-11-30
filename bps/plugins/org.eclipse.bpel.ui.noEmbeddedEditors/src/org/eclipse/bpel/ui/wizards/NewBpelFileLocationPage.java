/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
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
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * The wizard page to define the location of the new BPEL process to create.
 * @author Michal Chmielewski - Oracle
 * @author Vincent Zurczak - EBM WebSourcing
 */
public class NewBpelFileLocationPage extends WizardNewFileCreationPage {

	/**
	 * The page's name, so that it can be referenced from other pages.
	 */
	public static final String PAGE_NAME = "location-page";

	private IContainer resourceContainer;


	/**
	 * Constructor.
	 */
  	public NewBpelFileLocationPage( IStructuredSelection selection ) {
        super( PAGE_NAME, selection );

		setTitle( Messages.NewFileWizardPage2_3 );
		setDescription( Messages.NewFileWizardPage2_0 );
        setImageDescriptor( BPELUIPlugin.INSTANCE.getImageDescriptor( IBPELUIConstants.ICON_WIZARD_BANNER ));

        setFileExtension( "bpel" );
        setAllowExistingResources( false );
    }


	/*
  	 * (non-Javadoc)
  	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage
  	 * #setVisible(boolean)
  	 */
  	@Override
  	public void setVisible( boolean visible ) {

  		// Update some fields
  		String pName = getWizard().getDialogSettings().get( NewBpelFileWizard.DIALOG_SETTINGS_PROCESS_NAME );
  		if( pName != null )
  			setFileName( pName + ".bpel" );

  		// Do the usual work
  		super.setVisible( visible );
  	}


	/**
	 * @return the container in which the resources will be created
	 */
	public IContainer getResourceContainer() {
		return this.resourceContainer;
	}


	/**
	 * @return the process file to create
	 */
	public IFile getProcessFile() {
		return this.resourceContainer.getFile( new Path( getFileName()));
	}


	/*
  	 * (non-Javadoc)
  	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage
  	 * #validatePage()
  	 */
  	@Override
  	protected boolean validatePage() {

  		setMessage( null, WizardPage.WARNING );
  		boolean valid = super.validatePage();
  		if( valid ) {

  			// Get the container
  			IPath path = getContainerFullPath();
  			if( path.segmentCount() == 1 )
  				this.resourceContainer = ResourcesPlugin.getWorkspace().getRoot().getProject( path.segment( 0 ));
  			else
  				this.resourceContainer = ResourcesPlugin.getWorkspace().getRoot().getFolder( path );

  			// Validate it
  			if( ! BPELUtil.isBPELProject( this.resourceContainer.getProject())) {
				setMessage( Messages.NewFileWizard_Not_A_BPELFaceted_Project, WizardPage.WARNING );
     			valid = true;
			}
  			else if( ! this.resourceContainer.equals( BPELUtil.getBPELContentFolder( this.resourceContainer.getProject()))) {
				setMessage( Messages.NewFileWizard_Not_A_BPELContent_Folder, WizardPage.WARNING );
				valid = true;
			}
  		}

  		return valid;
  	}
}
