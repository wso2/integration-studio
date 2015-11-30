/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.dialogs;

import org.eclipse.bpel.model.messageproperties.MessagepropertiesFactory;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.model.messageproperties.Query;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.bpel.ui.properties.ExpressionSection;
import org.eclipse.bpel.ui.util.BrowseUtil;
import org.eclipse.bpel.ui.util.WSDLImportHelper;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDTypeDefinition;


/**
 * Dialog for creating or editing a property alias.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
 * https://jira.jboss.org/browse/JBIDE-7107
 * This has been completely reworked to support Properties of Message Types, XSD Simple Types and
 * XSD Elements (previous version only supported Message Types).
 *
 * This also incorporates the XPath Expression editor for use in editing the Query expression.
 */
public class EditPropertyAliasDialog extends Dialog {
	protected static final int BID_USE_TYPE = IDialogConstants.CLIENT_ID + 30;
	protected static final int BID_USE_ELEMENT = IDialogConstants.CLIENT_ID + 31;
	protected static final int BID_USE_MESSAGE = IDialogConstants.CLIENT_ID + 32;

	// True if a new propertyAlias is being created (as opposed to an existing being edited)
	protected boolean isNew;
	protected BPELEditor bpelEditor;
	protected Property property;
	protected PropertyAlias alias;
	
	protected EObject activeTypeElementOrMessage;
	protected Query activeQuery;
	
	protected XSDTypeDefinition xsdTypeDefinition;
	protected Query xsdTypeQuery;
	
	protected XSDElementDeclaration xsdElementDeclaration;
	protected Query xsdElementQuery;
	
	protected Message message;
	protected String messagePart;
	protected Query messageQuery;
	
	protected Label typeElementOrMessageNameLabel;
	protected Label typeElementOrMessageNameText;
	private Button typeRadio;
	private Button elementRadio;
	private Button messageRadio;
	private int typeElementOrMessage;
	
	private QueryEditor queryEditor;

	protected Button browseTypeButton;
	
	protected TabbedPropertySheetWidgetFactory wf;
	
	public class QueryEditor extends ExpressionSection {
	
		public void create(Composite parent)
		{
			createControls(parent, null);
		}
		
		public void setInput(EObject obj)
		{
			basicSetInput(obj);
		}
		
		public String getQuery()
		{
			if (getExpressionEditor()!=null)
				return getExpressionEditor().getEditorContent();
			return null;
		}
		
		public String getQueryLanguage()
		{
			Object elm = selectedExpressionLanguage();
			if (elm == NO_EXPRESSION || elm == null )
				return null;
			return getExpressionLanguage(elm);
		}
		
		@Override
		protected String getExpressionType() { 
			return IEditorConstants.ET_ANY; 
		}
		
		@Override
		public BPELEditor getBPELEditor() {
			return bpelEditor;
		}
		
		@Override
		public TabbedPropertySheetWidgetFactory getWidgetFactory() {
			return wf;
		}
		
		@Override
		protected EStructuralFeature getStructuralFeature () {
			fStructuralFeature = MessagepropertiesPackage.eINSTANCE.getPropertyAlias_Query();
			return fStructuralFeature;
		}

		@Override
		protected void setStructuralFeature ( EStructuralFeature feature ) {
			fStructuralFeature = feature;
		}

		@Override
		protected EStructuralFeature getStructuralFeature ( EObject eObject ) {
			if (eObject != null)
				return MessagepropertiesPackage.eINSTANCE.getPropertyAlias_Query();
			return null;
		}

		@Override
		protected Command wrapInShowContextCommand(Command inner) {
			EditPropertyAliasDialog.this.updateWidgets();
			return null;
		}

	}
	
	public EditPropertyAliasDialog(Shell parentShell, Property property, PropertyAlias alias, BPELEditor bpelEditor, TabbedPropertySheetWidgetFactory wf) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.isNew = (alias == null);
		this.alias = alias;
		this.property = property;
		this.bpelEditor = bpelEditor;
		this.wf = wf;
		if (isNew) {
			typeElementOrMessage = BID_USE_MESSAGE;
			this.alias = MessagepropertiesFactory.eINSTANCE.createPropertyAlias();
		}
		else  {
			if (alias.getMessageType() != null) {
				typeElementOrMessage = BID_USE_MESSAGE;
				message = (Message)alias.getMessageType();
				messagePart = alias.getPart();
				messageQuery = alias.getQuery();
			}
			else if (alias.getType() != null) {
				typeElementOrMessage = BID_USE_TYPE;
				xsdTypeDefinition = (XSDTypeDefinition)alias.getType();
				xsdTypeQuery = alias.getQuery();
			}
			else if (alias.getXSDElement() != null) {
				typeElementOrMessage = BID_USE_ELEMENT;
				xsdElementDeclaration = (XSDElementDeclaration)alias.getXSDElement();
				xsdElementQuery = alias.getQuery();
			}
		}
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = (GridLayout) composite.getLayout();
		layout.makeColumnsEqualWidth = false;
		layout.numColumns = 3;

		Listener enablementListener = new Listener() {
			public void handleEvent(Event e) {
				updateEnablement();
			}
		};
		
		// create widgets
		String groupText = Messages.EditMessagePropertyDialog_10;
		// PropertyAlias must have either XSD Type or XSD Element or (message type and part): create radio button group
		Group typeElementOrMessageRadioGroup = new Group(composite,SWT.SHADOW_ETCHED_IN);
		typeElementOrMessageRadioGroup.setText(groupText);
		layout = new GridLayout();
		layout.makeColumnsEqualWidth = true;		
		layout.numColumns = 1;		
		typeElementOrMessageRadioGroup.setLayout(layout);
		messageRadio = createRadioButton(typeElementOrMessageRadioGroup,Messages.EditMessagePropertyDialog_13, BID_USE_MESSAGE, typeElementOrMessage == BID_USE_MESSAGE);
		typeRadio = createRadioButton(typeElementOrMessageRadioGroup,Messages.EditMessagePropertyDialog_11, BID_USE_TYPE, typeElementOrMessage == BID_USE_TYPE);
		elementRadio = createRadioButton(typeElementOrMessageRadioGroup,Messages.EditMessagePropertyDialog_12, BID_USE_ELEMENT, typeElementOrMessage == BID_USE_ELEMENT);
		messageRadio.addListener(SWT.Selection, enablementListener);
		typeRadio.addListener(SWT.Selection, enablementListener);
		elementRadio.addListener(SWT.Selection, enablementListener);

		// type label and text
		typeElementOrMessageNameLabel = new Label(composite, SWT.NONE);
		typeElementOrMessageNameText = new Label(composite, SWT.NONE);
		browseTypeButton = new Button(composite, SWT.PUSH);
		browseTypeButton.setText(Messages.EditMessagePropertyDialog_18); 
		browseTypeButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				browsePropertyType();
			}
		});

		
		// layout widgets
		GridData data;
		
		queryEditor = new QueryEditor();
		Group queryGroup = new Group(composite,SWT.SHADOW_ETCHED_IN);
		queryGroup.setText("Query");
		layout = new GridLayout();
		layout.makeColumnsEqualWidth = true;		
		layout.numColumns = 1;		
		queryGroup.setLayout(layout);
		data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 3;
		queryGroup.setLayoutData(data);
		queryEditor.create(queryGroup);
		
		data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 3;
//		data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
//		topLabel.setLayoutData(data);
		typeElementOrMessageRadioGroup.setLayoutData(data);
		data = new GridData(GridData.FILL_HORIZONTAL);
		messageRadio.setLayoutData(data);
		data = new GridData(GridData.FILL_HORIZONTAL);
		typeRadio.setLayoutData(data);
		data = new GridData(GridData.FILL_HORIZONTAL);
		elementRadio.setLayoutData(data);
		
		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		typeElementOrMessageNameLabel.setLayoutData(data);
		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL);
		typeElementOrMessageNameText.setLayoutData(data);
		data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		browseTypeButton.setLayoutData(data);

		// update widgets
		updateWidgets();
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			parent, IHelpContextIds.PROPERTY_ALIAS_DIALOG);	
		
		composite.pack();
		
		return composite;
	}
	
	protected Button createRadioButton(Composite parent, String label, int id, boolean checked) {
		
		Button button = new Button(parent,SWT.RADIO);
		button.setText(label);
		button.setFont(JFaceResources.getDialogFont());
		button.setData( Integer.valueOf( id ));		
		button.setSelection( checked );
		
		button.addSelectionListener (new SelectionAdapter() {
			@Override
			public void widgetSelected (SelectionEvent event) {
				Button b = (Button) event.widget;
				int val = ((Integer) b.getData()).intValue();
				
				buttonPressed(val, b.getSelection(), true );
			}
		});
		
		return button;
	
	}

	/**
	 * Handle the check button and radio button callbacks.
	 * 
	 * @param id
	 * @param checked
	 * @param refresh unless this is set, no refresh is done.
	 */
	
	protected void buttonPressed(int id, boolean checked, boolean bRefresh) {
				
		switch (id) {
		
		case BID_USE_ELEMENT:
		case BID_USE_TYPE:
		case BID_USE_MESSAGE:
			if (!checked)
				return;
			typeElementOrMessage = id;
			break;
		
		default : 			
			break;
		}
	
	
		if (bRefresh) {
			updateWidgets();
		}
	}

	protected void updateWidgets() {
		String s = queryEditor.getQuery();
		if (s!=null && activeQuery!=null) {
			activeQuery.setValue(s);
			activeQuery.setQueryLanguage(queryEditor.getQueryLanguage());
		}
		
		if (typeElementOrMessage == BID_USE_TYPE) {
			typeRadio.setSelection(true);
			elementRadio.setSelection(false);
			messageRadio.setSelection(false);
			activeTypeElementOrMessage = xsdTypeDefinition;
			if (xsdTypeQuery == null) {
				xsdTypeQuery = MessagepropertiesFactory.eINSTANCE.createQuery();
			}
			activeQuery = xsdTypeQuery;
			typeElementOrMessageNameLabel.setText(Messages.EditMessagePropertyDialog_Type_1);
			
			alias.setMessageType(null);
			alias.setPart(null);
			alias.setType(xsdTypeDefinition);
			alias.setXSDElement(null);
		}
		else if (typeElementOrMessage == BID_USE_ELEMENT) {
			typeRadio.setSelection(false);
			elementRadio.setSelection(true);
			messageRadio.setSelection(false);
			activeTypeElementOrMessage = xsdElementDeclaration;
			if (xsdElementQuery == null) {
				xsdElementQuery = MessagepropertiesFactory.eINSTANCE.createQuery();
			}
			activeQuery = xsdElementQuery;
			typeElementOrMessageNameLabel.setText(Messages.EditMessagePropertyDialog_Element_1);

			alias.setMessageType(null);
			alias.setPart(null);
			alias.setType(null);
			alias.setXSDElement(xsdElementDeclaration);
		}
		else if (typeElementOrMessage == BID_USE_MESSAGE) {
			typeRadio.setSelection(false);
			elementRadio.setSelection(false);
			messageRadio.setSelection(true);
			activeTypeElementOrMessage = message;
			if (messageQuery == null) {
				messageQuery = MessagepropertiesFactory.eINSTANCE.createQuery();
			}
			activeQuery = messageQuery;
			typeElementOrMessageNameLabel.setText(Messages.EditMessagePropertyDialog_Message_1);

			alias.setMessageType(message);
			alias.setPart(messagePart);
			alias.setType(null);
			alias.setXSDElement(null);
		}
		alias.setQuery(activeQuery);
		queryEditor.setInput(alias);

		updateTypeElementOrMessageName();
		updateEnablement();
	}
	
	protected void updateTypeElementOrMessageName() {
		if (activeTypeElementOrMessage instanceof XSDTypeDefinition) {
			xsdTypeDefinition = (XSDTypeDefinition) activeTypeElementOrMessage;
			xsdTypeQuery = activeQuery;
			typeElementOrMessageNameText.setText(xsdTypeDefinition.getName());
		} else if (activeTypeElementOrMessage instanceof XSDElementDeclaration) {
			xsdElementDeclaration = (XSDElementDeclaration) activeTypeElementOrMessage;
			xsdElementQuery = activeQuery;
			typeElementOrMessageNameText.setText(xsdElementDeclaration.getName());
		} else if (activeTypeElementOrMessage instanceof Message) {
			message = (Message) activeTypeElementOrMessage;
			String s = message.getQName().getLocalPart();
			messageQuery = activeQuery;
			if (messagePart!=null) {
				s += "." + messagePart;
			}
			typeElementOrMessageNameText.setText(s);
		}
		else
		{
			typeElementOrMessageNameText.setText("");
		}
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		if (isNew) {
			newShell.setText(Messages.EditPropertyAliasDialog_9); 
		} else {
			newShell.setText(Messages.EditPropertyAliasDialog_10); 
		}
	}

	/**
	 * Opens a dialog and let the user browse for an XSD type or element.
	 * Updates the property type according to the user choice.
	 */
	protected void browsePropertyType() {
		
		Object type = null;
		Object part = null;
		Object query = null;
		Object result[] = null;
		if (typeElementOrMessage == BID_USE_TYPE)
			result = BrowseUtil.browseForXSDType(bpelEditor.getProcess(), getShell());
		else if (typeElementOrMessage == BID_USE_ELEMENT)
			result = BrowseUtil.browseForXSDElement(bpelEditor.getProcess(), getShell(), true);
		else {
			result = BrowseUtil.browseForMessageType(bpelEditor.getProcess(), getShell(), true);
		}
		if (result!=null) {
			if (result.length>=1) {
				
				type = result[0];
				int index = 1;
				if (type instanceof Message) {
					message = (Message) type;
					if (result.length>=2 && result[1] instanceof Part) {
						part = ((Part)result[1]).getName();
						index = 2;
					}
				}
				
				// build the query string
				// NOTE: The namespace for the XSD type may be different from the message namespace
				// e.g. the message is defined in a WSDL and the XSD type is defined in externally
				// with a different namespace.
				Definition definition = property.getEnclosingDefinition();
				if (definition==null) {
					IFile targetFile = bpelEditor.getEditModelClient().getArtifactsResourceInfo().getFile();
					URI uri = URI.createPlatformResourceURI(targetFile.getFullPath().toString());
					Resource resource = bpelEditor.getResourceSet().getResource(uri, true);
					definition = (Definition) resource.getContents().get(0);
				}
				query = "";
				while (index<result.length) {
					if (result[index] instanceof XSDComponent) {
						XSDNamedComponent nc = (XSDNamedComponent)result[index];
						WSDLImportHelper.addImportAndNamespace(definition, nc.getSchema(),
								bpelEditor.getEditModelClient().getPrimaryResourceInfo().getFile());
						String prefix = definition.getPrefix(nc.getTargetNamespace());
						if (prefix!=null)
							query = query + "/" + prefix + ":" + nc.getName();
						else
							query = query + "/" + nc.getName();
					}
					++index;
				}
			}
			
			activeTypeElementOrMessage = (EObject)type;
			if (query!=null)
				activeQuery.setValue(query.toString());
			else
				activeQuery.setValue("");
			
			if (typeElementOrMessage == BID_USE_TYPE) {
				xsdTypeDefinition = (XSDTypeDefinition) type;
				xsdTypeQuery = activeQuery;
			}
			else if (typeElementOrMessage == BID_USE_ELEMENT) {
				xsdElementDeclaration = (XSDElementDeclaration) type;
				xsdElementQuery = activeQuery;
			}
			else {
				message = (Message)type;
				if (part!=null)
					messagePart = part.toString();
				messageQuery = activeQuery;
			}
			
			// hack: don't fetch query from XPath Expression Editor
			// because it will overwrite the currently selected element
			activeQuery = null;
			updateWidgets();
		}
	}
	
	/**
	 * @return Returns the alias.
	 */
	public PropertyAlias getPropertyAlias() {
		return alias;
	}

	@Override
	protected void okPressed() {
		alias.setPropertyName(property);
		if (typeElementOrMessage == BID_USE_TYPE) {
			alias.setType(xsdTypeDefinition);
			if (xsdTypeQuery!=null && (xsdTypeQuery.getValue()==null || xsdTypeQuery.getValue().trim().equals("")) )
				xsdTypeQuery = null;
			alias.setQuery(xsdTypeQuery);
		}
		else if (typeElementOrMessage == BID_USE_ELEMENT) {
			alias.setXSDElement(xsdElementDeclaration);
			if (xsdElementQuery!=null && (xsdElementQuery.getValue()==null || xsdElementQuery.getValue().trim().equals("")) )
				xsdElementQuery = null;
			alias.setQuery(xsdElementQuery);
		}
		else {
			alias.setMessageType(message);
			alias.setPart(messagePart);
			if (messageQuery!=null && (messageQuery.getValue()==null || messageQuery.getValue().trim().equals("")) )
				messageQuery = null;
			alias.setQuery(messageQuery);
		}
		
		super.okPressed();
	}

	@Override
	protected Control createContents(Composite parent) {
		Control result = super.createContents(parent);
		updateEnablement();
		return result;
	}

	protected void updateEnablement() {
		// update the OK button
		boolean isOK = true;
//		if (variableTypeSelector.getVariableType() == null
//			|| (messagePartViewer.getSelection() == null) || (messagePartViewer.getSelection().isEmpty())) {
//			isOK = false;
//		}
		Button okButton = getButton(IDialogConstants.OK_ID);
		if (okButton != null) {
			okButton.setEnabled(isOK);
		}
	}
}