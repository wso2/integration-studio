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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Templates;
import org.eclipse.bpel.ui.Templates.Template;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The page of the wizard to deal with the WSDL to create.
 * @author Michal Chmielewski - Oracle
 * @author Bob Brodt - Red Hat
 * @author Vincent Zurczak - EBM WebSourcing
 */
public class NewBpelFileTemplatePage extends WizardPage {

	/**
	 * The page's name, so that it can be referenced from other pages.
	 */
	public static final String PAGE_NAME = "wsdl-creation-page";

	private static final String SOAP_BINDING = "SOAP";
	private static final String HTTP_BINDING = "HTTP";
	private static final String SOAP_NAMESPACE="http://schemas.xmlsoap.org/wsdl/soap/";
	private static final String HTTP_NAMESPACE="http://schemas.xmlsoap.org/wsdl/http/";

	private String processTemplateName, serviceName, address, binding, portName;
	private Text serviceNameText, portNameText, addressText;
	private final Map<String,String> processTemplateProperties;


	/**
	 * Constructor.
	 */
	public NewBpelFileTemplatePage() {
		super( PAGE_NAME );
		this.processTemplateProperties = new HashMap<String,String> ();

		setTitle( Messages.NewFileWizard_WSDLCustomPage_Title );
		setDescription( Messages.NewFileWizard_WSDLCustomPage_Description );
		setImageDescriptor( BPELUIPlugin.INSTANCE.getImageDescriptor( IBPELUIConstants.ICON_WIZARD_BANNER ));

		this.binding = SOAP_BINDING;
		String[] tplNames = BPELUIPlugin.INSTANCE.getTemplates().getTemplateNames();
		if( tplNames != null && tplNames.length > 0 )
			this.processTemplateName = tplNames[ 0 ];
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


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage
	 * #createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl( Composite parent ) {

		// Create the container
		Composite container = new Composite( parent, SWT.NONE );
		initializeDialogUnits( parent );
		container.setLayout( new GridLayout( 2, false ));
		container.setLayoutData( new GridData( GridData.FILL_BOTH ));
		setControl( container );


		// Create the form
		Label l = new Label( container, SWT.NONE );
		l.setText( Messages.NewFileWizardPage1_7 );
		l.setToolTipText( "The template to use for the creation of the new process" );

		final Combo processTemplateCombo = new Combo( container, SWT.DROP_DOWN | SWT.SIMPLE | SWT.READ_ONLY );
		processTemplateCombo.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		processTemplateCombo.setItems( BPELUIPlugin.INSTANCE.getTemplates().getTemplateNames());


		// Show the description of the selected template
		final Text descriptionText = new Text( container, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI | SWT.WRAP );
		descriptionText.setBackground( getShell().getDisplay().getSystemColor( SWT.COLOR_WHITE ));
		GridData layoutData = new GridData( GridData.FILL_HORIZONTAL );
		layoutData.heightHint = 100;
		layoutData.widthHint = 500;
		layoutData.horizontalSpan = 2;
		descriptionText.setLayoutData( layoutData );


		// Add a group for the properties of the template
		final Group propertiesGroup = new Group( container, SWT.SHADOW_ETCHED_OUT );
		propertiesGroup.setText( "Template Properties" );

		propertiesGroup.setLayout( new GridLayout( 2, false ));
		layoutData = new GridData( GridData.FILL_HORIZONTAL );
		layoutData.horizontalSpan = 2;
		layoutData.verticalIndent = 16;
		propertiesGroup.setLayoutData( layoutData );


		// Update the UI when the selected template changes
		processTemplateCombo.addSelectionListener( new SelectionListener() {
			@Override
			public void widgetSelected( SelectionEvent e ) {
				widgetDefaultSelected( e );
			}

			@Override
			public void widgetDefaultSelected( SelectionEvent e ) {
				NewBpelFileTemplatePage.this.processTemplateName = processTemplateCombo.getText();

				Template tpl = getSelectedTemplate();
				String desc = tpl == null ? "No description was found." : tpl.getDescription();
				descriptionText.setText( desc );

				refreshTemplateWidgets( propertiesGroup );
				updateStatus();
			}
		});


		// Initialize the remaining stuff
		processTemplateCombo.select( 0 );
		processTemplateCombo.notifyListeners( SWT.Selection, new Event());

		if( getErrorMessage() != null ) {
			setPageComplete( false );
			setErrorMessage( null );
		}
	}


	/**
	 * Refreshes the widgets with options for the templates.
	 * @param container the parent container
	 */
	private void refreshTemplateWidgets( Composite container ) {

		// Remove the widgets
		for( Control c : container.getChildren())
			c.dispose();


		// Add the widgets: first, the service name
		Label l = new Label( container, SWT.NONE );
		l.setText( Messages.NewFileWizard_WSDLCustomPage_ServiceLable );

		this.serviceNameText = new Text( container, SWT.BORDER | SWT.SINGLE );
		this.serviceNameText.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		if( this.serviceName != null )
			this.serviceNameText.setText( this.serviceName );

		this.serviceNameText.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				NewBpelFileTemplatePage.this.serviceName = ((Text) e.widget).getText();
				updateStatus();
			}
		});


		// Other widgets do not have to be shown for the "empty" template
		// https://issues.jboss.org/browse/JBIDE-7165
		Template tpl = getSelectedTemplate();
		String tplKey = tpl == null ? null : tpl.getKey();
		if( ! Templates.TEMPLATE_KEY_EMPTY.equals( tplKey )) {

			// The port name
			l = new Label( container, SWT.NONE );
			l.setText( Messages.NewFileWizard_WSDLCustomPage_PortLabel );

			this.portNameText = new Text( container, SWT.BORDER | SWT.SINGLE );
			this.portNameText.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
			if( this.portName != null )
				this.portNameText.setText( this.portName );

			this.portNameText.addModifyListener( new ModifyListener() {
				@Override
				public void modifyText( ModifyEvent e ) {
					NewBpelFileTemplatePage.this.portName = ((Text) e.widget).getText();
					updateStatus();
				}
			});


			// The address
			l = new Label( container, SWT.NONE );
			l.setText( Messages.NewFileWizard_WSDLCustomPage_AddressLabel );

			this.addressText = new Text( container, SWT.BORDER | SWT.SINGLE );
			this.addressText.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
			if( this.address != null )
				this.addressText.setText( this.address );

			this.addressText.addModifyListener( new ModifyListener() {
				@Override
				public void modifyText( ModifyEvent e ) {
					NewBpelFileTemplatePage.this.address = ((Text) e.widget).getText();
					updateStatus();
				}
			});


			// The binding
			l = new Label( container, SWT.NONE );
			l.setText( Messages.NewFileWizard_WSDLCustomPage_BindingLabel );

			Combo bindingCombo = new Combo( container, SWT.BORDER | SWT.DROP_DOWN | SWT.SIMPLE | SWT.READ_ONLY );
			GridData layoutData = new GridData();
			layoutData.widthHint = 200;
			bindingCombo.setLayoutData( layoutData );
			bindingCombo.setItems( new String[] { SOAP_BINDING, HTTP_BINDING });

			int index = HTTP_BINDING.equals( this.binding ) ? 1 : 0;
			bindingCombo.select( index );
			bindingCombo.notifyListeners( SWT.Selection, new Event());
			bindingCombo.addModifyListener( new ModifyListener() {
				@Override
				public void modifyText( ModifyEvent e ) {
					NewBpelFileTemplatePage.this.binding = ((Combo) e.widget).getText();
					updateStatus();
				}
			});
		}


		// Lay out the parent
		container.layout();
		container.getParent().layout();
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.DialogPage
	 * #setVisible(boolean)
	 */
	@Override
	public void setVisible( boolean visible ) {

		// Update some fields
		if( this.serviceNameText != null && ! this.serviceNameText.isDisposed()) {
			String pName = getWizard().getDialogSettings().get( NewBpelFileWizard.DIALOG_SETTINGS_PROCESS_NAME );
			if( pName != null ) {
				this.serviceNameText.setText( pName + "Service" );

				if( this.portNameText != null && ! this.portNameText.isDisposed())
					this.portNameText.setText( pName + "Port" );

				if( this.addressText != null && ! this.addressText.isDisposed())
					this.addressText.setText( "http://localhost:8080/" + pName );
			}
		}

		// Do the usual work
		super.setVisible( visible );
	}


	/**
	 * @return the processTemplateProperties
	 */
	public Map<String, String> getProcessTemplateProperties() {
		return this.processTemplateProperties;
	}


	/**
	 * @return the selected template or null if no template was selected
	 */
	public Template getSelectedTemplate() {
		return this.processTemplateName == null ? null : BPELUIPlugin.INSTANCE.getTemplates().getTemplateByName( this.processTemplateName );
	}


	/**
	 * Validates the page data and updates the page state in consequence.
	 */
	private void updateStatus() {

		String errorMsg = validatePage();
		setPageComplete( errorMsg == null );
		setErrorMessage( errorMsg );

		// Specific behavior for the empty template
		// The created file will be marked as invalid
		String msg = null;
		Template tpl = getSelectedTemplate();
		String tplKey = tpl == null ? null : tpl.getKey();
		if( Templates.TEMPLATE_KEY_EMPTY.equals( tplKey ))
			msg = "Beware, empty processes are marked as invalid by the BPEL validator.";

		setMessage( msg, IMessageProvider.WARNING );
	}


	/**
	 * Validates the page data and stores valid values for further use.
	 * @return an error message or null if everything is right
	 */
	private String validatePage() {

		String errorMsg = null;

		// Validate the page fields
		Template tpl;
		if(( tpl = getSelectedTemplate()) == null )
			errorMsg = "The selected template does not match a concrete one.";	// Should never happen, but...

		else if( this.serviceName == null || this.serviceName.trim().length() == 0 )
			errorMsg = "You have to specify the service name.";

		else if( this.serviceName.matches( "\\s" ))
			errorMsg = "The service name cannot contain spaces or white characters.";

		if( this.portName == null || this.portName.trim().length() == 0 )
			errorMsg = "You have to specify the port name.";

		else if( this.portName.matches( "\\s" ))
			errorMsg = "The port name cannot contain spaces or white characters.";

		if( this.address == null || this.address.trim().length() == 0 )
			errorMsg = "You have to specify the service address.";

		else if( this.address.matches( "\\s" ))
			errorMsg = "The address cannot contain spaces or white characters.";

		// No error => store properties for the templates
		if( errorMsg == null ) {

			this.processTemplateProperties.put( Templates.PROPERTY_NAME, this.processTemplateName );
			this.processTemplateProperties.put( Templates.PROPERTY_KEY, tpl.getKey());	// https://jira.jboss.org/browse/JBIDE-7165
			this.processTemplateProperties.put( "serviceName", this.serviceName ); //$NON-NLS-1$
			this.processTemplateProperties.put( "portName", this.portName ); //$NON-NLS-1$
			this.processTemplateProperties.put( "address", this.address ); //$NON-NLS-1$
			this.processTemplateProperties.put( "protocol", this.binding.toLowerCase()); //$NON-NLS-1$
			if( SOAP_BINDING.equals( this.binding ))
				this.processTemplateProperties.put( "protocolNamespace", SOAP_NAMESPACE );
			else
				this.processTemplateProperties.put( "protocolNamespace", HTTP_NAMESPACE );
		}

		return errorMsg;
	}
}
