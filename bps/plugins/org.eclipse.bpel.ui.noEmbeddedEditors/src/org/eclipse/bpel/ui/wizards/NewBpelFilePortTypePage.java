/******************************************************************************
 * Copyright (c) 2011, 2012, EBM WebSourcing
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     EBM WebSourcing - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.ui.wizards;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.common.ui.details.viewers.ComboViewer;
import org.eclipse.bpel.common.wsdl.helpers.UriAndUrlHelper;
import org.eclipse.bpel.common.wsdl.parsers.WsdlParser;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Fault;
import org.eclipse.wst.wsdl.Input;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Output;
import org.eclipse.wst.wsdl.PortType;

/**
 * The page of the wizard to select the contract to implement.
 * <p>
 * This page could have to deal with several contracts to implement.
 * </p>
 * <p>
 * Notice that this class uses WSDL4j to parse WSDL files, and not EMF.
 * The reason is that EMF does not cross file inclusions and thus results in incomplete
 * parsing or in failures with valid WSDL definitions.
 * </p>
 *
 * @author Michal Chmielewski - Oracle
 * @author Vincent Zurczak - EBM WebSourcing
 */
public class NewBpelFilePortTypePage extends WizardPage {

	/**
	 * The page's name, so that it can be referenced from other pages.
	 */
	public static final String PAGE_NAME = "port-type-page";

	/**
	 * The WSDL URL.
	 */
	private String wsdlUrl;

	/**
	 * The selected port type in the WSDL.
	 */
	private PortType portType;

	/**
	 * True to import the selected WSDL at the end.
	 */
	private boolean importWsdl = true;

	/**
	 * The images used by this page.
	 */
	private final Image workspaceImg, fileSystemImg, parseImg;


	/**
	 * Constructor.
	 */
	public NewBpelFilePortTypePage() {
		super( PAGE_NAME );

		setTitle( "Service Contract" );
		setDescription( "Select the service contract the BPEL process must implement." );
		setImageDescriptor( BPELUIPlugin.INSTANCE.getImageDescriptor( IBPELUIConstants.ICON_WIZARD_BANNER ));

		this.workspaceImg = BPELUIPlugin.createImage( "icons/obj16/workspace.gif" );
		this.fileSystemImg = BPELUIPlugin.createImage( "icons/obj16/file_system.gif" );
		this.parseImg = BPELUIPlugin.createImage( "icons/obj16/parse.gif" );
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.DialogPage
	 * #dispose()
	 */
	@Override
	public void dispose() {

		if( this.fileSystemImg != null && ! this.fileSystemImg.isDisposed())
			this.fileSystemImg.dispose();

		if( this.workspaceImg != null && ! this.workspaceImg.isDisposed())
			this.workspaceImg.dispose();

		if( this.parseImg != null && ! this.parseImg.isDisposed())
			this.parseImg.dispose();

		super.dispose();
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.WizardPage
	 * #getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {

		// We need to do that since the page order depends on user choices
		IWizardPage nextPage = getWizard().getPage( NewBpelFileLocationPage.PAGE_NAME );
		nextPage.setPreviousPage( this );
		return nextPage;
	}


	/**
	 * @return the wsdlUrl
	 */
	public String getWsdlUrl() {
		return this.wsdlUrl;
	}


	/**
	 * @return the importWsdl
	 */
	public boolean isImportWsdl() {
		return this.importWsdl;
	}


	/**
	 * @return the portType
	 */
	public PortType getPortType() {
		return this.portType;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage
	 * #createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl( Composite parent ) {

		// Create the container
		final Composite container = new Composite( parent, SWT.NONE );
		container.setFont( parent.getFont());
		initializeDialogUnits( parent );
		container.setLayout( new GridLayout( 2, false ));
		container.setLayoutData( new GridData( GridData.FILL_BOTH ));
		setControl( container );


		// WSDL location (as an URL)
		Label l = new Label( container, SWT.NONE );
		l.setText( "WSDL URL:" );
		l.setToolTipText( "The URL of the service description (WSDL)" );
		l.setLayoutData( new GridData( SWT.TOP, SWT.DEFAULT, false, false ));

		final Text wsdlUrlText = new Text( container, SWT.SINGLE | SWT.BORDER );
		wsdlUrlText.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		wsdlUrlText.setToolTipText( "Press the 'Tab' key to parse this WSDL" );
		if( this.wsdlUrl != null )
			wsdlUrlText.setText( this.wsdlUrl );

		wsdlUrlText.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				NewBpelFilePortTypePage.this.wsdlUrl = ((Text) e.widget).getText();
				updateStatus();
			}
		});

		final ControlDecoration wsdlTextDecoration = new ControlDecoration( wsdlUrlText, SWT.LEFT | SWT.BOTTOM );
		wsdlTextDecoration.setImage( PlatformUI.getWorkbench().getSharedImages().getImage( ISharedImages.IMG_OBJS_INFO_TSK ));
		wsdlTextDecoration.setDescriptionText( wsdlUrlText.getToolTipText());
		wsdlTextDecoration.hide();


		// Helpers to browse for WSDL files
		new Label( container, SWT.NONE );	// Bad but so convenient!
		Composite subContainer = new Composite( container, SWT.NONE );
		GridLayout layout = new GridLayout( 2, false );
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.marginBottom = 13;
		subContainer.setLayout( layout );
		subContainer.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));

		new Label( subContainer, SWT.NONE ).setImage( this.fileSystemImg );
		Link browseFileSystemLink = new Link( subContainer, SWT.NONE );
		browseFileSystemLink.setText( "<A>Browse the file system...</A>" );

		new Label( subContainer, SWT.NONE ).setImage( this.workspaceImg );
		Link browseWorkspaceLink = new Link( subContainer, SWT.NONE );
		browseWorkspaceLink.setText( "<A>Browse the workspace...</A>" );

		new Label( subContainer, SWT.NONE ).setImage( this.parseImg );
		Link parseWsdlLink = new Link( subContainer, SWT.NONE );
		parseWsdlLink.setText( "<A>Parse the given WSDL</A>" );


		// Port type to use for the generation
		l = new Label( container, SWT.NONE );
		l.setText( "Service Contract:" );
		l.setToolTipText( "The port type (service contract) to implement with BPEL" );

		final ComboViewer portTypeCombo = new ComboViewer( container, SWT.BORDER | SWT.DROP_DOWN | SWT.READ_ONLY );
		portTypeCombo.getCombo().setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		portTypeCombo.setContentProvider( new ArrayContentProvider());
		portTypeCombo.setLabelProvider( new LabelProvider() {
			@Override
			public String getText( Object element ) {
				QName name = ((PortType) element).getQName();
				return name.getLocalPart() + " - " + name.getNamespaceURI();
			}
		});


		// The button to import the WSDL
		new Label( container, SWT.NONE );
		Button importButton = new Button( container, SWT.CHECK );
		importButton.setText( "Import the WSDL file with its dependencies" );
		importButton.setSelection( this.importWsdl );
		importButton.addSelectionListener( new SelectionListener() {
			@Override
			public void widgetSelected( SelectionEvent e ) {
				widgetDefaultSelected( e );
			}

			@Override
			public void widgetDefaultSelected( SelectionEvent e ) {
				NewBpelFilePortTypePage.this.importWsdl = ((Button) e.widget).getSelection();
			}
		});


		// The viewer for a quick overview of the operations
		subContainer = new Composite( container, SWT.NONE );
		layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginTop = 11;
		subContainer.setLayout( layout );
		GridData layoutData = new GridData( GridData.FILL_BOTH );
		layoutData.horizontalSpan = 2;
		subContainer.setLayoutData( layoutData );

		l = new Label( subContainer, SWT.NONE );
		l.setText( "Select a service contract (port type) and see its operations below." );

		final TreeViewer operationsViewer = new TreeViewer( subContainer, SWT.BORDER );
		operationsViewer.getTree().setLayoutData( new GridData( GridData.FILL_BOTH ));
		operationsViewer.setLabelProvider( new LabelProvider () {
			@Override
			public Image getImage( Object element ) {

				Image result = null;
				if( element instanceof Operation )
					result = BPELUIPlugin.INSTANCE.getImage( IBPELUIConstants.ICON_OPERATION_16 );
				else if( element instanceof Input )
					result = BPELUIPlugin.INSTANCE.getImage( IBPELUIConstants.ICON_INPUT_16 );
				else if( element instanceof Output )
					result = BPELUIPlugin.INSTANCE.getImage( IBPELUIConstants.ICON_OUTPUT_16 );
				else if( element instanceof Fault )
					result = BPELUIPlugin.INSTANCE.getImage( IBPELUIConstants.ICON_FAULT_16 );

				return result;
			}

			@Override
			public String getText( Object element ) {

				String result = "";
				if( element instanceof Operation ) {
					result = ((Operation) element).getName();
					result = result == null || result.trim().length() == 0 ? "?" : result;

				} else if( element instanceof Input ) {
					result = ((Input) element).getName();
					result = result == null || result.trim().length() == 0 ? "Input" : result;

				} else if( element instanceof Output ) {
					result = ((Output) element).getName();
					result = result == null || result.trim().length() == 0 ? "Output" : result;

				} else if( element instanceof Fault ) {
					result = ((Fault) element).getName();
					result = result == null || result.trim().length() == 0 ? "Fault" : result;
				}

				return result;
			}
		});

		operationsViewer.setContentProvider( new ITreeContentProvider() {
			@Override
			public void dispose() {
				// nothing
			}

			@Override
			public void inputChanged( Viewer viewer, Object oldInput, Object newInput ) {
				// nothing
			}

			@Override
			public Object[] getElements( Object inputElement ) {
				return ((PortType) inputElement).getOperations().toArray();
			}

			@SuppressWarnings( "unchecked" )
			@Override
			public Object[] getChildren( Object pa ) {

				List<Object> result = new ArrayList<Object> ();
				if( pa instanceof Operation ) {
					Operation op = (Operation) pa;
					if( op.getInput() != null )
						result.add( op.getInput());

					if( op.getOutput() != null )
						result.add( op.getOutput());

					if( op.getFaults() != null )
						result.addAll( op.getFaults().values());
				}

				return result.toArray();
			}

			@Override
			public Object getParent( Object element ) {
				return null;
			}

			@Override
			public boolean hasChildren( Object element ) {
				return element instanceof Operation;
			}
		});


		// Listeners
		portTypeCombo.addSelectionChangedListener( new ISelectionChangedListener() {
			@Override
			public void selectionChanged( SelectionChangedEvent event ) {
				NewBpelFilePortTypePage.this.portType = (PortType) ((IStructuredSelection) portTypeCombo.getSelection()).getFirstElement();
				operationsViewer.setInput( NewBpelFilePortTypePage.this.portType );
				operationsViewer.refresh();

				if( NewBpelFilePortTypePage.this.portType != null ) {
					if( NewBpelFilePortTypePage.this.portType.getOperations().size() < 4 )
						operationsViewer.expandAll();
					else
						operationsViewer.expandToLevel( 2 );
				}

				updateStatus();
			}
		});


		// WSDL parsing
		final List<PortType> portTypes = new ArrayList<PortType> ();
		final IRunnableWithProgress wsdlParsingOperation = new IRunnableWithProgress() {
			@Override
			public void run( IProgressMonitor monitor )
			throws InvocationTargetException, InterruptedException {

				monitor.beginTask( "Parsing the WSDL...", 5 );
				try {
					portTypes.clear();
					monitor.worked( 1 );

					URI emfUri = URI.createURI( NewBpelFilePortTypePage.this.wsdlUrl );
					Collection<Definition> definitions = WsdlParser.loadAllWsdlDefinitions( emfUri, WsdlParser.createBasicResourceSetForWsdl());
					for( Definition def : definitions ) {
						for( Object o : def.getPortTypes().values())
							portTypes.add((PortType) o );
					}

					monitor.worked( 3 );

				} finally {
					monitor.done();
				}
			}
		};

		wsdlUrlText.addTraverseListener( new TraverseListener() {
			@Override
			public void keyTraversed( TraverseEvent e ) {

				if( NewBpelFilePortTypePage.this.wsdlUrl == null )
					return;

				try {
					// Parse
					getContainer().run( true, false, wsdlParsingOperation );

					// Update the UI
					portTypeCombo.setInput( portTypes );
					portTypeCombo.refresh();
					if( portTypes.size() > 0 )
						portTypeCombo.getCombo().select( 0 );
					portTypeCombo.getCombo().notifyListeners( SWT.Selection, new Event());

				} catch( InvocationTargetException e1 ) {
					BPELUIPlugin.log( e1 );

				} catch( InterruptedException e1 ) {
					BPELUIPlugin.log( e1 );
				}
			}
		});

		wsdlUrlText.addFocusListener( new FocusListener() {
			@Override
			public void focusLost( FocusEvent e ) {
				wsdlTextDecoration.hide();
			}

			@Override
			public void focusGained( FocusEvent e ) {
				wsdlTextDecoration.show();
			}
		});


		// "Browse" call-backs
		browseFileSystemLink.addSelectionListener( new SelectionListener() {
			@Override
			public void widgetSelected( SelectionEvent e ) {
				widgetDefaultSelected( e );
			}

			@Override
			public void widgetDefaultSelected( SelectionEvent e ) {
				FileDialog dlg = new FileDialog( getShell());
				dlg.setFilterExtensions( new String[] { "*.wsdl" });
				dlg.setFilterNames( new String[] { "WSDL (*.wsdl)" });
				dlg.setText( "Select a service description (WSDL)." );

				String path = dlg.open();
				if( path != null ) {
					File f = new File( path );
					wsdlUrlText.setText( f.toURI().toString());
					wsdlUrlText.notifyListeners( SWT.Traverse, new Event());
				}
			}
		});

		parseWsdlLink.addSelectionListener( new SelectionListener() {
			@Override
			public void widgetSelected( SelectionEvent e ) {
				wsdlUrlText.notifyListeners( SWT.Traverse, new Event());
			}

			@Override
			public void widgetDefaultSelected( SelectionEvent e ) {
				wsdlUrlText.notifyListeners( SWT.Traverse, new Event());
			}
		});

		browseWorkspaceLink.addSelectionListener( new SelectionListener() {
			@Override
			public void widgetSelected( SelectionEvent e ) {
				widgetDefaultSelected( e );
			}

			@Override
			public void widgetDefaultSelected( SelectionEvent e ) {

				// Prepare the initial selection
				IFile currentWsdl = null;
				if( NewBpelFilePortTypePage.this.wsdlUrl != null ) {
					try {
						java.net.URI uri = UriAndUrlHelper.urlToUri( NewBpelFilePortTypePage.this.wsdlUrl );
						File f = new File( uri );
						IPath path = new Path( f.getAbsolutePath());
						currentWsdl = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation( path );

					} catch( Exception e1 ) {
						BPELUIPlugin.log( e1, IStatus.WARNING );
					}
				}

				// Open a dialog that only shows the WSDL files in the workspace - and their ancestors/containers
				final List<IFile> workspaceWsdlFiles = getFiles( "wsdl", Arrays.asList( ResourcesPlugin.getWorkspace().getRoot()));
				ElementTreeSelectionDialog dlg = new ElementTreeSelectionDialog(
						getShell(),
						new WorkbenchLabelProvider(),
						new WorkbenchContentProvider() {

							@Override
							public Object[] getChildren( Object element ) {

								Object[] result = super.getChildren( element );
								if( result == null )
									result = new Object[ 0 ];

								List<Object> filteredResult = new ArrayList<Object>();
								for( Object o : result ) {
									if( o instanceof IFile
											&& workspaceWsdlFiles.contains( o ))
										filteredResult.add( o );

									else if( o instanceof IContainer ) {
										IPath containerPath = ((IContainer) o).getFullPath();
										for( IFile wsdlFile : workspaceWsdlFiles ) {
											if( containerPath.isPrefixOf( wsdlFile.getFullPath())) {
												filteredResult.add( o );
												break;
											}
										}
									}
								}

								return filteredResult.toArray();
							}
				});

				dlg.setInput( ResourcesPlugin.getWorkspace().getRoot());
				dlg.setTitle( "WSDL Selection" );
				dlg.setMessage( "Select a WSDL file located in the workspace." );
				if( currentWsdl != null )
					dlg.setInitialElementSelections( Arrays.asList( currentWsdl ));

				// Open it and update the text widget if necessary
				if( dlg.open() == Window.OK ) {
					IFile selectedFile = (IFile) dlg.getResult()[ 0 ];
					wsdlUrlText.setText( selectedFile.getLocation().toFile().toURI().toString());
					wsdlUrlText.notifyListeners( SWT.Traverse, new Event());
				}
			}
		});


		// Initialize the port type...
		if( this.portType != null )
			portTypeCombo.setSelection( new StructuredSelection( this.portType ));

		else if( portTypeCombo.getCombo().getItemCount() > 0 ) {
			portTypeCombo.getCombo().select( 0 );
			portTypeCombo.getCombo().notifyListeners( SWT.Selection, new Event());
		}


		// ... and the page's state
		updateStatus();
		if( getErrorMessage() != null ) {
			setPageComplete( false );
			setErrorMessage( null );
		}
	}


	/**
	 * Validates the page data and updates the page state in consequence.
	 */
	private void updateStatus() {
		String errorMsg = validatePage();
		setPageComplete( errorMsg == null );
		setErrorMessage( errorMsg );
	}


	/**
	 * Validates the page data and stores valid values for further use.
	 * @return an error message or null if everything is right
	 */
	private String validatePage() {

		String errorMsg = null;

		// Validate the page fields
		if( this.wsdlUrl == null || this.wsdlUrl.trim().length() == 0 )
			errorMsg = "You must specify the URL of a service description (WSDL).";
		else if( this.portType == null )
			errorMsg = "You must select a port type (contract) to implement in the BPEL process.";

		return errorMsg;
	}


	/**
	 * Gets all the files whose extension is <b>extension</b> and present in <b>containers</b>.
	 * @param extension the file extension. Use "*" for any extension. Not null.
	 * @param containers the containers to explore
	 * @return all the IFile contained into this container (with no limit in the level).
	 */
	private static List<IFile> getFiles( String extension, Collection<? extends IContainer> containers ) {

		List<IFile> result = new ArrayList<IFile> ();
		if( containers == null )
			return result;

		for( IContainer container : containers ) {
			try {
				IResource[] resources = container.members();
				for( IResource resource : resources ) {
					switch( resource.getType()) {

					case IResource.FILE:
						if( "*".equals( extension )
									|| extension.equalsIgnoreCase( resource.getFileExtension()))
							result.add((IFile) resource);
						break;

					case IResource.FOLDER:
						IFolder subFolder = (IFolder) resource;
						result.addAll( getFiles( extension, Arrays.asList( subFolder )));
						break;

					case IResource.PROJECT:
						IProject project = (IProject) resource;
						if( project.isAccessible())
							result.addAll( getFiles( extension, Arrays.asList( project )));
						break;

					default:
						break;
					}
				}

			} catch( CoreException e ) {
				BPELUIPlugin.log( e, IStatus.ERROR );
			}
		}

		return result;
	}
}
