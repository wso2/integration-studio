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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.common.ui.details.viewers.ComboViewer;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The first page of the wizard to create a new BPEL process.
 * <p>
 * This page deals with the creation mode and the general properties of the BPEL to create.
 * </p>
 *
 * @author Michal Chmielewski - Oracle
 * @author Vincent Zurczak - EBM WebSourcing
 */
public class NewBpelFileFirstPage extends WizardPage {

	/**
	 * The page's name, so that it can be referenced from other pages.
	 */
	public static final String PAGE_NAME = "bpel-first-page";

	/**
	 * The creation mode.
	 */
	private BpelCreationMode creationMode;

	/**
	 * The process name and name space.
	 */
	private String processName, processNamespace;

	/**
	 * True to create an abstract process, false otherwise.
	 */
	private boolean abstractProcess;

	/**
	 * The properties to pass to the template.
	 */
	private final Map<String,Object> processTemplateProperties;

	/**
	 * Images used in the wizard.
	 */
	private Image wsdlImg, arrowImg, bpelImg, tplImg;


	/**
	 * Constructor.
	 */
	public NewBpelFileFirstPage() {
		super( PAGE_NAME );

		setTitle( Messages.NewFileWizardPage1_2 );
		setDescription( Messages.NewFileWizardPage1_3 );
		setImageDescriptor( BPELUIPlugin.INSTANCE.getImageDescriptor( IBPELUIConstants.ICON_WIZARD_BANNER ));

		this.processTemplateProperties = new HashMap<String,Object> ();
		try {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin( BPELUIPlugin.PLUGIN_ID, "icons/misc/wsdl.png" );
			this.wsdlImg = desc.createImage();

		} catch( Exception e ) {
			BPELUIPlugin.log( e, IStatus.WARNING );
		}

		try {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin( BPELUIPlugin.PLUGIN_ID, "icons/misc/bpel-skeleton-2.png" );
			this.bpelImg = desc.createImage();

		} catch( Exception e ) {
			BPELUIPlugin.log( e, IStatus.WARNING );
		}

		try {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin( BPELUIPlugin.PLUGIN_ID, "icons/misc/arrow.png" );
			this.arrowImg = desc.createImage();

		} catch( Exception e ) {
			BPELUIPlugin.log( e, IStatus.WARNING );
		}

		try {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin( BPELUIPlugin.PLUGIN_ID, "icons/misc/templates.png" );
			this.tplImg = desc.createImage();

		} catch( Exception e ) {
			BPELUIPlugin.log( e, IStatus.WARNING );
		}
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.DialogPage
	 * #dispose()
	 */
	@Override
	public void dispose() {

		if( this.wsdlImg != null && ! this.wsdlImg.isDisposed())
			this.wsdlImg.dispose();

		if( this.arrowImg != null && ! this.arrowImg.isDisposed())
			this.arrowImg.dispose();

		if( this.bpelImg != null && ! this.bpelImg.isDisposed())
			this.bpelImg.dispose();

		if( this.tplImg != null && ! this.tplImg.isDisposed())
			this.tplImg.dispose();

		super.dispose();
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.WizardPage
	 * #getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {

		IWizardPage nextPage;
		if( this.creationMode == BpelCreationMode.CREATE_NEW_BPEL )
			nextPage = getWizard().getPage( NewBpelFileTemplatePage.PAGE_NAME );
		else
			nextPage = getWizard().getPage( NewBpelFilePortTypePage.PAGE_NAME );

		nextPage.setPreviousPage( this );
		return nextPage;
	}


	/**
	 * @return the abstractProcess
	 */
	public boolean isAbstractProcess() {
		return this.abstractProcess;
	}


	/**
	 * @return the properties for the templates
	 */
	public Map<String,Object> getProcessTemplateProperties() {
		return this.processTemplateProperties;
	}


	/**
	 * @return the creationMode
	 */
	public BpelCreationMode getCreationMode() {
		return this.creationMode;
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


		// Add a combo to select the creation mode
		Label label = new Label( container, SWT.NONE );
		label.setText( "Creation Mode:" );
		label.setToolTipText( "Select the way to create a new BPEL process" );

		final ComboViewer creationViewer = new ComboViewer( container, SWT.BORDER | SWT.DROP_DOWN | SWT.READ_ONLY );
		creationViewer.setContentProvider( new ArrayContentProvider());
		creationViewer.setLabelProvider( new LabelProvider());
		creationViewer.setInput( BpelCreationMode.values());


		// Add the other common widgets
		Label l = new Label( container, SWT.NONE );
		l.setText( Messages.NewFileWizardPage1_5 );
		l.setToolTipText( "The name of the BPEL process" );

		Text processNameText = new Text( container, SWT.BORDER | SWT.SINGLE );
		processNameText.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		if( this.processName != null )
			processNameText.setText( this.processName );

		processNameText.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				NewBpelFileFirstPage.this.processName = ((Text) e.widget).getText();
				updateStatus();
			}
		});


		l = new Label( container, SWT.NONE );
		l.setText( Messages.NewFileWizardPage1_6 );
		l.setToolTipText( "The target namespace of the BPEL process" );

		Combo processNamespaceCombo = new Combo( container, SWT.DROP_DOWN | SWT.SIMPLE );
		processNamespaceCombo.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		processNamespaceCombo.setItems( BPELUIPlugin.INSTANCE.getTemplates().getNamespaceNames());
		if( this.processNamespace != null )
			processNamespaceCombo.setText( this.processNamespace );

		processNamespaceCombo.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				NewBpelFileFirstPage.this.processNamespace = ((Combo) e.widget).getText();
				updateStatus();
			}
		});


		new Label( container, SWT.NONE );
		final Button abstractProcessButton = new Button( container, SWT.CHECK );
		abstractProcessButton.setText( "Abstract Process" );
		abstractProcessButton.setToolTipText( "Make the created process abstract" );
		abstractProcessButton.addSelectionListener( new SelectionListener() {
			@Override
			public void widgetSelected( SelectionEvent e ) {
				widgetDefaultSelected( e );
			}

			@Override
			public void widgetDefaultSelected( SelectionEvent e ) {
				NewBpelFileFirstPage.this.abstractProcess = ((Button) e.widget).getSelection();
				updateStatus();
			}
		});


		// Add an image to illustrate the creation mode
		Composite imageContainer = new Composite( container, SWT.BORDER );
		imageContainer.setBackground( getShell().getDisplay().getSystemColor( SWT.COLOR_WHITE ));
		GridLayout layout = new GridLayout( 3, false );
		layout.horizontalSpacing = 0;
		layout.marginTop = 12;
		imageContainer.setLayout( layout );

		GridData layoutData = new GridData( GridData.FILL_HORIZONTAL );
		layoutData.horizontalSpan = 2;
		layoutData.verticalIndent = 21;
		imageContainer.setLayoutData( layoutData );

		final Label imgLeftLabel = new Label( imageContainer, SWT.NONE );
		imgLeftLabel.setBackground( getShell().getDisplay().getSystemColor( SWT.COLOR_WHITE ));

		Label imgCenterLabel = new Label( imageContainer, SWT.NONE );
		imgCenterLabel.setBackground( getShell().getDisplay().getSystemColor( SWT.COLOR_WHITE ));
		imgCenterLabel.setLayoutData( new GridData( SWT.CENTER, SWT.CENTER, true, true ));
		imgCenterLabel.setImage( this.arrowImg );

		Label imgRightLabel = new Label( imageContainer, SWT.NONE );
		imgRightLabel.setBackground( getShell().getDisplay().getSystemColor( SWT.COLOR_WHITE ));
		imgRightLabel.setImage( this.bpelImg );

		final Text explainationText = new Text( imageContainer, SWT.MULTI | SWT.READ_ONLY | SWT.WRAP );
		explainationText.setBackground( getShell().getDisplay().getSystemColor( SWT.COLOR_WHITE ));
		layoutData = new GridData( GridData.FILL_HORIZONTAL  );
		layoutData.horizontalSpan = 3;
		layoutData.verticalIndent = 21;
		explainationText.setLayoutData( layoutData );


		// Detect when the creation mode changes
		creationViewer.addSelectionChangedListener( new ISelectionChangedListener() {
			@Override
			public void selectionChanged( SelectionChangedEvent event ) {
				NewBpelFileFirstPage.this.creationMode = (BpelCreationMode) ((IStructuredSelection) creationViewer.getSelection()).getFirstElement();
				explainationText.setText( NewBpelFileFirstPage.this.creationMode.getDescription());
				if( NewBpelFileFirstPage.this.creationMode == BpelCreationMode.GENERATE_BPEL_FROM_WSDL )
					imgLeftLabel.setImage( NewBpelFileFirstPage.this.wsdlImg );
				else
					imgLeftLabel.setImage( NewBpelFileFirstPage.this.tplImg );

				imgLeftLabel.getParent().layout();
				imgLeftLabel.getParent().getParent().layout();
				updateStatus();
			}
		});


		// Initialize all the stuff
		creationViewer.setSelection( new StructuredSelection( BpelCreationMode.CREATE_NEW_BPEL ));
		creationViewer.getCombo().notifyListeners( SWT.Selection, new Event());
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
		IStatus nameStatus;
		if( this.processName == null || this.processName.trim().length() == 0 )
			errorMsg = "You have to specify the process name.";

		else if( this.processName.matches( "\\s" ))
			errorMsg = "The process name cannot contain spaces or white characters.";

		else if( ! ( nameStatus = ResourcesPlugin.getWorkspace().validateName( this.processName, IResource.FILE )).isOK())
			errorMsg = nameStatus.getMessage();

		else if( this.processNamespace == null || this.processNamespace.trim().length() == 0 )
			errorMsg = "You have to specify the process namespace.";


		//  No error => store properties for the templates
		if( errorMsg == null
				&& this.creationMode == BpelCreationMode.CREATE_NEW_BPEL ) {

			String bpelNamespace = this.abstractProcess ? BPELConstants.NAMESPACE_ABSTRACT_2007 : BPELConstants.NAMESPACE;
			this.processTemplateProperties.put( "processName", this.processName ); //$NON-NLS-1$
			this.processTemplateProperties.put( "namespace", this.processNamespace ); //$NON-NLS-1$
			this.processTemplateProperties.put( "bpelNamespace", bpelNamespace ); //$NON-NLS-1$
			this.processTemplateProperties.put( "date", new Date()); //$NON-NLS-1$
		}


		// Save some fields for further use
		IDialogSettings settings = getWizard().getDialogSettings();
		if( settings != null )
			settings.put( NewBpelFileWizard.DIALOG_SETTINGS_PROCESS_NAME, this.processName );

		return errorMsg;
	}


	/**
	 * The different modes to create a new BPEL to edit.
	 */
	public static enum BpelCreationMode {
		CREATE_NEW_BPEL, GENERATE_BPEL_FROM_WSDL;

		/*
		 * (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {

			String result;
			switch( this ) {
			case CREATE_NEW_BPEL:
				result = "Create a BPEL process from a template";
				break;
			case GENERATE_BPEL_FROM_WSDL:
				result = "Create a BPEL process from a service description";
				break;
			default:
				result = "";
			}

			return result;
		};


		/**
		 * @return a more detailed description
		 */
		public String getDescription() {

			String result;
			switch( this ) {
			case CREATE_NEW_BPEL:
				result = "This will generate a skeleton of BPEL process.\nThis skeleton is based on pre-defined templates.";
				break;

			case GENERATE_BPEL_FROM_WSDL:
				result = "This will generate a skeleton of BPEL process to implement a given WSDL contract.\n"
				+ "\t \u2666 \tThe resulting process starts with a pick activity.\n"
				+ "\t \u2666 \tMessage dispatching depends on the invoked operation.";
				break;
			default:
				result = "";
			}

			return result;
		}
	}
}
