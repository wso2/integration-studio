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
import java.net.URI;
import java.util.ArrayList;

import org.eclipse.bpel.common.wsdl.helpers.UriAndUrlHelper;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * A wizard page to import a resource in the workspace.
 * @author Vincent Zurczak - EBM WebSourcing
 * FIXME: is there an existing page we could reuse?
 */
public class UriResourceImportWizardPage extends WizardPage {

	private URI uri;
	private IContainer outputContainer;
	private boolean complete = false;

	private String initialUri;
	private final String shortName;
	private final String[] filterNames, filterExtensions;


	/**
	 * Constructor.
	 * @param selection
	 * @param shortName
	 * @param filterNames
	 * @param filterExtensions
	 */
	public UriResourceImportWizardPage(
				IStructuredSelection selection,
				String shortName,
				String[] filterNames,
				String[] filterExtensions ) {

		super( "Import Page" );
		this.shortName = shortName;
		this.filterNames = filterNames;
		this.filterExtensions = filterExtensions;

		if( ! selection.isEmpty()) {
			Object o = selection.getFirstElement();
			IResource res = (IResource) getAdapter( o, IResource.class );
			if( res instanceof IContainer )
				this.outputContainer = (IContainer) res;
			else if( res != null )
				this.outputContainer = res.getParent();
		}
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage
	 * #createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl( Composite parent ) {

		Composite container = new Composite( parent, SWT.NONE );
		GridLayout layout = new GridLayout( 2, false );
		container.setLayout( layout );
		container.setLayoutData( new GridData( GridData.FILL_BOTH ));


		// WSDL field
		Label l = new Label( container, SWT.NONE );
		l.setText( this.shortName + " URI:" );

		GridData layoutData = new GridData();
		layoutData.verticalIndent = 6;
		layoutData.horizontalSpan = 2;
		l.setLayoutData( layoutData );

		final Text text = new Text( container, SWT.BORDER | SWT.SINGLE );
		text.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		text.addModifyListener( new ModifyListener () {

			@Override
			public void modifyText( ModifyEvent e ) {
				String uri = text.getText();
				if( uri.trim().length() == 0 )
					return;

				try {
					UriResourceImportWizardPage.this.uri = UriAndUrlHelper.urlToUri( uri );

				} catch( Exception e1 ) {
					UriResourceImportWizardPage.this.uri = null;
				}

				validate();
			}
		});

		if( this.initialUri != null )
			text.setText( this.initialUri );

		Button b = new Button( container, SWT.PUSH );
		b.setText( "Browse..." );
		b.addSelectionListener( new SelectionAdapter () {
			@Override
			public void widgetDefaultSelected( SelectionEvent e ) {
				widgetSelected( e );
			}

			@Override
			public void widgetSelected( SelectionEvent e ) {

				FileDialog dlg = new FileDialog( text.getShell(), SWT.SINGLE );
				dlg.setFilterNames( UriResourceImportWizardPage.this.filterNames );
				dlg.setFilterExtensions( UriResourceImportWizardPage.this.filterExtensions );
				String path = dlg.open();

				if( path != null ) {
					String uri = new File( path ).toURI().toString();
					text.setText( uri );
					text.setSelection( uri.length());
					text.setFocus();
				}
			}
		});


		// Container selection
		l = new Label( container, SWT.NONE );
		l.setText( "Select the container in which the " + this.shortName + " will be imported." );

		layoutData = new GridData();
		layoutData.verticalIndent = 10;
		layoutData.horizontalSpan = 2;
		l.setLayoutData( layoutData );

		TreeViewer viewer = new TreeViewer( container, SWT.SINGLE | SWT.V_SCROLL | SWT.V_SCROLL | SWT.BORDER );
		layoutData = new GridData( GridData.FILL_BOTH );
		layoutData.heightHint = 200;
		layoutData.horizontalSpan = 2;
		viewer.getTree().setLayoutData( layoutData );
		viewer.setLabelProvider( new WorkbenchLabelProvider ());

		viewer.setContentProvider( new WorkbenchContentProvider () {
			@Override
			public Object[] getChildren( Object o ) {

				if( o instanceof IContainer ) {
					IResource[] members;
					try {
						members = ((IContainer) o).members();
					} catch( Exception e ) {
						return new Object[ 0 ];
					}

					ArrayList<IResource> results = new ArrayList<IResource> ();
					for( IResource member : members ) {
						if( member instanceof IContainer )
							results.add( member);
					}

					return results.toArray();
				}

				return new Object[ 0 ];
			}
		});


		// Set page input
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		viewer.setInput( root );
		if( this.outputContainer != null ) {
			viewer.setSelection( new StructuredSelection( this.outputContainer ), true );
			viewer.expandToLevel( this.outputContainer, 1 );
			viewer.reveal( this.outputContainer.getProject());
		}

		viewer.addSelectionChangedListener( new ISelectionChangedListener () {
			@Override
			public void selectionChanged( SelectionChangedEvent event ) {

				IStructuredSelection s = (IStructuredSelection) event.getSelection();
				if( !s.isEmpty())
					UriResourceImportWizardPage.this.outputContainer = (IContainer) s.getFirstElement();
				else
					UriResourceImportWizardPage.this.outputContainer = null;
				validate();
			}
		});

		text.setFocus();
		setControl( container );
	}


	/**
	 * Validates the page entries.
	 */
	private void validate() {

		if( this.uri == null ) {
			setErrorMessage( "The " + this.shortName + "'s URI is invalid." );
			setPageComplete( false );
			return;
		}

		if( "file".equals( this.uri.getScheme())
					&& ! new File( this.uri ).exists()) {
			setErrorMessage( "This URI points to a file that does not exist." );
			setPageComplete( false );
			return;
		}

		if( this.outputContainer == null ) {
			setErrorMessage( "You must select the destination container." );
			setPageComplete( false );
			return;
		}

		setErrorMessage( null );
		setPageComplete( true );
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.WizardPage
	 * #isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		return this.complete;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.WizardPage
	 * #setPageComplete(boolean)
	 */
	@Override
	public void setPageComplete( boolean complete ) {
		this.complete = complete;
		super.setPageComplete( complete );
	}


	/**
	 * @return the outputContainer
	 */
	public IContainer getOutputContainer() {
		return this.outputContainer;
	}


	/**
	 * @return the uri
	 */
	public URI getUriToImport() {
		return this.uri;
	}


	/**
	 * @param initialUri the initial URI to set
	 */
	public void setInitialUri( String initialUri ) {
		this.initialUri = initialUri;
	}


	/**
	 * Gets the appropriate adapter.
	 * @param sourceObject
	 * @param adapterType
	 * @return
	 */
	public static Object getAdapter( Object sourceObject, Class<?> adapterType ) {

		Assert.isNotNull(adapterType);
		if (sourceObject == null) {
			return null;
		}
		if (adapterType.isInstance(sourceObject)) {
			return sourceObject;
		}

		if (sourceObject instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) sourceObject;

			Object result = adaptable.getAdapter(adapterType);
			if (result != null) {
				// Sanity-check
				Assert.isTrue(adapterType.isInstance(result));
				return result;
			}
		}

		if (!(sourceObject instanceof PlatformObject)) {
			Object result = Platform.getAdapterManager().getAdapter(sourceObject, adapterType);
			if (result != null) {
				return result;
			}
		}

		return null;
	}
}
