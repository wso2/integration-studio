/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation
 *******************************************************************************/

package org.eclipse.bpel.ui.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.wizards.NewBpelFileFirstPage.BpelCreationMode;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

/**
 * The creation wizard for a new BPEL process.
 * @author Michal Chmielewski - Oracle
 * @author Edwin Khodabakchian - Oracle
 * @author Vincent Zurczak - EBM WebSourcing
 */
public class NewBpelFileWizard extends Wizard implements INewWizard {

	static final String DIALOG_SETTINGS_PROCESS_NAME = "process-name";
	static final String DIALOG_SETTINGS_PROCESS_TPL_KEY = "process-template-key";

	private IStructuredSelection selection;
	private IWorkbench fWorkbench;

	private NewBpelFileFirstPage firstPage;
	private NewBpelFileLocationPage locationPage;
	private NewBpelFileTemplatePage wsdlPage;
	private NewBpelFilePortTypePage portTypePage;


	/**
	 * Constructor.
	 */
	public NewBpelFileWizard() {
		this.setWindowTitle( Messages.NewFileWizard_1 );

		setDialogSettings( BPELUIPlugin.INSTANCE.getDialogSettingsFor( this ));
		setHelpAvailable( false );
		setNeedsProgressMonitor( true );
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard
	 * #init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		this.fWorkbench = workbench;
		this.selection = currentSelection;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard
	 * #addPages()
	 */
	@Override
	public void addPages() {

		this.firstPage = new NewBpelFileFirstPage();
		this.locationPage = new NewBpelFileLocationPage( this.selection );
		this.wsdlPage = new NewBpelFileTemplatePage();
		this.portTypePage = new NewBpelFilePortTypePage();

		// Add all the pages
		// The pages will then decide which one follows them
		addPage( this.firstPage );
		addPage( this.portTypePage );
		addPage( this.wsdlPage );
		addPage( this.locationPage );
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard
	 * #canFinish()
	 */
	@Override
	public boolean canFinish() {

		boolean complete = this.firstPage.isPageComplete() && this.locationPage.isPageComplete();
		if( complete ) {
			if( this.firstPage.getCreationMode() == BpelCreationMode.CREATE_NEW_BPEL )
				complete = this.wsdlPage.isPageComplete();
			else
				complete = this.portTypePage.isPageComplete();
		}

		return complete;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard
	 * #performFinish()
	 */
	@Override
	public boolean performFinish() {

		// Prepare the operation
		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			@Override
			public void run( IProgressMonitor monitor )
			throws InvocationTargetException, InterruptedException {

				try {
					monitor.beginTask( "Creating the process...", IProgressMonitor.UNKNOWN );
					NewBpelFileWizardUtils utils = new NewBpelFileWizardUtils(
							NewBpelFileWizard.this.firstPage,
							NewBpelFileWizard.this.wsdlPage,
							NewBpelFileWizard.this.portTypePage,
							NewBpelFileWizard.this.locationPage.getProcessFile());

					if( NewBpelFileWizard.this.firstPage.getCreationMode() == BpelCreationMode.GENERATE_BPEL_FROM_WSDL )
						utils.createResourcesFromWsdl( monitor );
					else
						utils.createResourcesFromTemplate( monitor );

				} catch( IOException e ) {
					throw new InvocationTargetException( e );

				} catch( CoreException e ) {
					throw new InvocationTargetException( e );

				} finally {
					monitor.done();
				}
			}
		};


		// Execute it
		final IFile bpelFile = this.locationPage.getProcessFile();
		boolean success = true;
		try {
			getContainer().run( false, true, runnable );

		} catch( InvocationTargetException e ) {
			success = true;
			BPELUIPlugin.log( e );

		} catch( InterruptedException e ) {
			success = true;
			BPELUIPlugin.log( e );

		} finally {
			// Refresh the workspace
			try {
				bpelFile.getProject().refreshLocal( IResource.DEPTH_INFINITE, null );
			} catch( CoreException e ) {
				BPELUIPlugin.log( e );
			}
		}


		// Open the file?
		if( success ) {
			final IWorkbenchPage page = this.fWorkbench.getActiveWorkbenchWindow().getActivePage();
			getShell().getDisplay().asyncExec( new Runnable() {
				@Override
				public void run() {
					try {
						IDE.openEditor( page, bpelFile );

					} catch( PartInitException e ) {
						BPELUIPlugin.log( e );
					}
				}
			});

			BasicNewResourceWizard.selectAndReveal( bpelFile, page.getWorkbenchWindow());
		}

		return success;
	}
}
