/****************************************************************************
 *
 * Copyright (c) 2010-2011, EBM WebSourcing
 *
 * This source code is available under agreement available at
 * http://www.petalslink.com/legal/licenses/petals-studio
 *
 * You should have received a copy of the agreement along with this program.
 * If not, write to EBM WebSourcing (4, rue Amelie - 31200 Toulouse, France).
 *
 *****************************************************************************/

package org.eclipse.bpel.common.wsdl.wizards;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.common.wsdl.SoaWsdlCommonPlugin;
import org.eclipse.bpel.common.wsdl.importhelpers.WsdlImportHelper;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.wizards.newresource.BasicNewFileResourceWizard;

/**
 * A wizard to import a WSDL file in a project or a project's directory.
 * @author Vincent Zurczak - EBM WebSourcing
 */
public class WsdlImportWizard extends Wizard implements IImportWizard {

	private UriResourceImportWizardPage page;
	private IStructuredSelection selection;
	private IWorkbenchWindow window;

	private String initialWsdlUri;
	private IContainer initialContainer;
	private File wsdlFileAfterImport;


	/**
	 * Constructor.
	 */
	public WsdlImportWizard() {
		super();
		setNeedsProgressMonitor( true );
		setWindowTitle( "WSDL Import" );
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard
	 * #addPages()
	 */
	@Override
	public void addPages() {

		if( this.initialContainer != null )
			this.selection = new StructuredSelection( this.initialContainer );

		this.page = new UriResourceImportWizardPage(
					this.selection, "WSDL",
					new String[] { "WSDL (*.wsdl)" },
					new String[] { "*.wsdl" });

		this.page.setTitle( "WSDL Import" );
		this.page.setDescription( "Import a WSDL and all its dependencies." );
		this.page.setInitialUri( this.initialWsdlUri );
		addPage( this.page );
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard
	 * #performFinish()
	 */
	@Override
	public boolean performFinish() {

		// Define the wizard completion process
		final Map<String,File> uriToFile = new HashMap<String,File> ();
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			@Override
			protected void execute( IProgressMonitor monitor )
			throws CoreException, InvocationTargetException, InterruptedException {
				try {
					String wsdlUri = WsdlImportWizard.this.page.getUriToImport().toString();
					monitor.beginTask( "Importing " + wsdlUri, IProgressMonitor.UNKNOWN );
					File outputContainer = WsdlImportWizard.this.page.getOutputContainer().getLocation().toFile();
					uriToFile.putAll( new WsdlImportHelper().importWsdlOrXsdAndDependencies( outputContainer, wsdlUri ));

				} catch( Exception e ) {
					throw new InvocationTargetException( e );

				} finally {
					monitor.done();
				}
			}
		};

		// Run the operation
		IContainer outputContainer = this.page.getOutputContainer();
		try {
			getContainer().run( true, false, op );
			try {
				outputContainer.refreshLocal( IResource.DEPTH_INFINITE, new NullProgressMonitor ());
			} catch( CoreException e ) {
				// nothing
			}

			this.wsdlFileAfterImport = uriToFile.get( this.page.getUriToImport().toString());
			if( this.wsdlFileAfterImport != null ) {
				IPath path = new Path( this.wsdlFileAfterImport.getAbsolutePath());
				IFile f = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation( path );
				if( f != null )
					BasicNewFileResourceWizard.selectAndReveal( f, this.window );
			}

		} catch( InterruptedException e ) {

			// Delete imported resources
			for( File f : uriToFile.values()) {
				if( ! f.delete())
					SoaWsdlCommonPlugin.log( "Could not delete " + f.getAbsolutePath() + ".", IStatus.WARNING );
			}

			try {
				outputContainer.refreshLocal( IResource.DEPTH_INFINITE, new NullProgressMonitor ());
			} catch( CoreException ee ) {
				// nothing
			}

		} catch( InvocationTargetException e ) {
			SoaWsdlCommonPlugin.log( "A WSDL file could not be imported (" + this.page.getUriToImport().toString() + ".", IStatus.ERROR );
			MessageDialog.openError( getShell(), "Import Error", "The WSDL file could not be imported." );
		}

		return true;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard
	 * #init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init( IWorkbench workbench, IStructuredSelection selection ) {
		this.selection = selection;
		this.window = workbench.getActiveWorkbenchWindow();
	}


	/**
	 * @param initialWsdlUri the initialWsdlUri to set
	 */
	public void setInitialWsdlUri( String initialWsdlUri ) {
		this.initialWsdlUri = initialWsdlUri;
	}


	/**
	 * @param initialContainer the initialContainer to set
	 */
	public void setInitialContainer( IContainer initialContainer ) {
		this.initialContainer = initialContainer;
	}


	/**
	 * @return the wsdlFileAfterImport
	 */
	public File getWsdlFileAfterImport() {
		return this.wsdlFileAfterImport;
	}
}
