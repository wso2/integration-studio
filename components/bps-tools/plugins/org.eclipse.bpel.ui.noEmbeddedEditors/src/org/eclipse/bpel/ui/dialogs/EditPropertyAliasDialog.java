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
		public void setInput(EObject obj) {
			basicSetInput(obj);
		}

		public String getQuery() {
			return this.expressionText.getText().trim();
		}

		@Override
		protected String getExpressionType() {
			return IEditorConstants.ET_ANY;
		}

		@Override
		public BPELEditor getBPELEditor() {
			return EditPropertyAliasDialog.this.bpelEditor;
		}

		@Override
		public TabbedPropertySheetWidgetFactory getWidgetFactory() {
			return EditPropertyAliasDialog.this.wf;
		}

		@Override
		protected EStructuralFeature getStructuralFeature ( EObject eObject ) {
			return eObject != null ? MessagepropertiesPackage.eINSTANCE.getPropertyAlias_Query() : null;
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
		if (this.isNew) {
			this.typeElementOrMessage = BID_USE_MESSAGE;
			this.alias = MessagepropertiesFactory.eINSTANCE.createPropertyAlias();
		}
		else  {
			if (alias.getMessageType() != null) {
				this.typeElementOrMessage = BID_USE_MESSAGE;
				this.message = (Message)alias.getMessageType();
				this.messagePart = alias.getPart();
				this.messageQuery = alias.getQuery();
			}
			else if (alias.getType() != null) {
				this.typeElementOrMessage = BID_USE_TYPE;
				this.xsdTypeDefinition = (XSDTypeDefinition)alias.getType();
				this.xsdTypeQuery = alias.getQuery();
			}
			else if (alias.getXSDElement() != null) {
				this.typeElementOrMessage = BID_USE_ELEMENT;
				this.xsdElementDeclaration = (XSDElementDeclaration)alias.getXSDElement();
				this.xsdElementQuery = alias.getQuery();
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
		this.messageRadio = createRadioButton(typeElementOrMessageRadioGroup,Messages.EditMessagePropertyDialog_13, BID_USE_MESSAGE, this.typeElementOrMessage == BID_USE_MESSAGE);
		this.typeRadio = createRadioButton(typeElementOrMessageRadioGroup,Messages.EditMessagePropertyDialog_11, BID_USE_TYPE, this.typeElementOrMessage == BID_USE_TYPE);
		this.elementRadio = createRadioButton(typeElementOrMessageRadioGroup,Messages.EditMessagePropertyDialog_12, BID_USE_ELEMENT, this.typeElementOrMessage == BID_USE_ELEMENT);
		this.messageRadio.addListener(SWT.Selection, enablementListener);
		this.typeRadio.addListener(SWT.Selection, enablementListener);
		this.elementRadio.addListener(SWT.Selection, enablementListener);

		// type label and text
		this.typeElementOrMessageNameLabel = new Label(composite, SWT.NONE);
		this.typeElementOrMessageNameText = new Label(composite, SWT.NONE);
		this.browseTypeButton = new Button(composite, SWT.PUSH);
		this.browseTypeButton.setText(Messages.EditMessagePropertyDialog_18);
		this.browseTypeButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				browsePropertyType();
			}
		});


		// layout widgets
		GridData data;

		this.queryEditor = new QueryEditor();
		Group queryGroup = new Group(composite,SWT.SHADOW_ETCHED_IN);
		queryGroup.setText("Query");
		layout = new GridLayout();
		layout.makeColumnsEqualWidth = true;
		layout.numColumns = 1;
		queryGroup.setLayout(layout);
		data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 3;
		queryGroup.setLayoutData(data);
		this.queryEditor.createControls( queryGroup, null );

		data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 3;
//		data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
//		topLabel.setLayoutData(data);
		typeElementOrMessageRadioGroup.setLayoutData(data);
		data = new GridData(GridData.FILL_HORIZONTAL);
		this.messageRadio.setLayoutData(data);
		data = new GridData(GridData.FILL_HORIZONTAL);
		this.typeRadio.setLayoutData(data);
		data = new GridData(GridData.FILL_HORIZONTAL);
		this.elementRadio.setLayoutData(data);

		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		this.typeElementOrMessageNameLabel.setLayoutData(data);
		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL);
		this.typeElementOrMessageNameText.setLayoutData(data);
		data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		this.browseTypeButton.setLayoutData(data);

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
			this.typeElementOrMessage = id;
			break;

		default :
			break;
		}


		if (bRefresh) {
			updateWidgets();
		}
	}

	protected void updateWidgets() {
//		String s = this.queryEditor.getQuery();
//		if (s!=null && this.activeQuery!=null) {
//			this.activeQuery.setValue(s);
//			this.activeQuery.setQueryLanguage(this.queryEditor.getQueryLanguage());
//		}

		if (this.typeElementOrMessage == BID_USE_TYPE) {
			this.typeRadio.setSelection(true);
			this.elementRadio.setSelection(false);
			this.messageRadio.setSelection(false);
			this.activeTypeElementOrMessage = this.xsdTypeDefinition;
			if (this.xsdTypeQuery == null) {
				this.xsdTypeQuery = MessagepropertiesFactory.eINSTANCE.createQuery();
			}
			this.activeQuery = this.xsdTypeQuery;
			this.typeElementOrMessageNameLabel.setText(Messages.EditMessagePropertyDialog_Type_1);

			this.alias.setMessageType(null);
			this.alias.setPart(null);
			this.alias.setType(this.xsdTypeDefinition);
			this.alias.setXSDElement(null);
		}
		else if (this.typeElementOrMessage == BID_USE_ELEMENT) {
			this.typeRadio.setSelection(false);
			this.elementRadio.setSelection(true);
			this.messageRadio.setSelection(false);
			this.activeTypeElementOrMessage = this.xsdElementDeclaration;
			if (this.xsdElementQuery == null) {
				this.xsdElementQuery = MessagepropertiesFactory.eINSTANCE.createQuery();
			}
			this.activeQuery = this.xsdElementQuery;
			this.typeElementOrMessageNameLabel.setText(Messages.EditMessagePropertyDialog_Element_1);

			this.alias.setMessageType(null);
			this.alias.setPart(null);
			this.alias.setType(null);
			this.alias.setXSDElement(this.xsdElementDeclaration);
		}
		else if (this.typeElementOrMessage == BID_USE_MESSAGE) {
			this.typeRadio.setSelection(false);
			this.elementRadio.setSelection(false);
			this.messageRadio.setSelection(true);
			this.activeTypeElementOrMessage = this.message;
			if (this.messageQuery == null) {
				this.messageQuery = MessagepropertiesFactory.eINSTANCE.createQuery();
			}
			this.activeQuery = this.messageQuery;
			this.typeElementOrMessageNameLabel.setText(Messages.EditMessagePropertyDialog_Message_1);

			this.alias.setMessageType(this.message);
			this.alias.setPart(this.messagePart);
			this.alias.setType(null);
			this.alias.setXSDElement(null);
		}
		this.alias.setQuery(this.activeQuery);
		this.queryEditor.setInput(this.alias);

		updateTypeElementOrMessageName();
		updateEnablement();
	}

	protected void updateTypeElementOrMessageName() {
		if (this.activeTypeElementOrMessage instanceof XSDTypeDefinition) {
			this.xsdTypeDefinition = (XSDTypeDefinition) this.activeTypeElementOrMessage;
			this.xsdTypeQuery = this.activeQuery;
			this.typeElementOrMessageNameText.setText(this.xsdTypeDefinition.getName());
		} else if (this.activeTypeElementOrMessage instanceof XSDElementDeclaration) {
			this.xsdElementDeclaration = (XSDElementDeclaration) this.activeTypeElementOrMessage;
			this.xsdElementQuery = this.activeQuery;
			this.typeElementOrMessageNameText.setText(this.xsdElementDeclaration.getName());
		} else if (this.activeTypeElementOrMessage instanceof Message) {
			this.message = (Message) this.activeTypeElementOrMessage;
			String s = this.message.getQName().getLocalPart();
			this.messageQuery = this.activeQuery;
			if (this.messagePart!=null) {
				s += "." + this.messagePart;
			}
			this.typeElementOrMessageNameText.setText(s);
		}
		else
		{
			this.typeElementOrMessageNameText.setText("");
		}
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		if (this.isNew) {
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
		if (this.typeElementOrMessage == BID_USE_TYPE)
			result = BrowseUtil.browseForXSDType(this.bpelEditor.getProcess(), getShell());
		else if (this.typeElementOrMessage == BID_USE_ELEMENT)
			result = BrowseUtil.browseForXSDElement(this.bpelEditor.getProcess(), getShell(), true);
		else {
			result = BrowseUtil.browseForMessageType(this.bpelEditor.getProcess(), getShell(), true);
		}
		if (result!=null) {
			if (result.length>=1) {

				type = result[0];
				int index = 1;
				if (type instanceof Message) {
					this.message = (Message) type;
					if (result.length>=2 && result[1] instanceof Part) {
						part = ((Part)result[1]).getName();
						index = 2;
					}
				}

				// build the query string
				// NOTE: The namespace for the XSD type may be different from the message namespace
				// e.g. the message is defined in a WSDL and the XSD type is defined in externally
				// with a different namespace.
				Definition definition = this.property.getEnclosingDefinition();
				if (definition==null) {
					IFile targetFile = this.bpelEditor.getEditModelClient().getArtifactsResourceInfo().getFile();
					URI uri = URI.createPlatformResourceURI( targetFile.getFullPath().toString(), true );
					Resource resource = this.bpelEditor.getResourceSet().getResource(uri, true);
					definition = (Definition) resource.getContents().get(0);
				}

				query = "";
				while (index<result.length) {
					if (result[index] instanceof XSDComponent) {
						XSDNamedComponent nc = (XSDNamedComponent)result[index];
						WSDLImportHelper.addImportAndNamespace(definition, nc.getSchema(),
								this.bpelEditor.getEditModelClient().getPrimaryResourceInfo().getFile());
						String prefix = definition.getPrefix(nc.getTargetNamespace());
						if (prefix!=null)
							query = query + "/" + prefix + ":" + nc.getName();
						else
							query = query + "/" + nc.getName();
					}
					++index;
				}
			}

			this.activeTypeElementOrMessage = (EObject)type;
			if (query!=null)
				this.activeQuery.setValue(query.toString());
			else
				this.activeQuery.setValue("");

			if (this.typeElementOrMessage == BID_USE_TYPE) {
				this.xsdTypeDefinition = (XSDTypeDefinition) type;
				this.xsdTypeQuery = this.activeQuery;
			}
			else if (this.typeElementOrMessage == BID_USE_ELEMENT) {
				this.xsdElementDeclaration = (XSDElementDeclaration) type;
				this.xsdElementQuery = this.activeQuery;
			}
			else {
				this.message = (Message)type;
				if (part!=null)
					this.messagePart = part.toString();
				this.messageQuery = this.activeQuery;
			}

			// hack: don't fetch query from XPath Expression Editor
			// because it will overwrite the currently selected element
			this.activeQuery = null;
			updateWidgets();
		}
	}

	/**
	 * @return Returns the alias.
	 */
	public PropertyAlias getPropertyAlias() {
		return this.alias;
	}

	@Override
	protected void okPressed() {
		this.alias.setPropertyName(this.property);
		if (this.typeElementOrMessage == BID_USE_TYPE) {
			this.alias.setType(this.xsdTypeDefinition);
			if (this.xsdTypeQuery!=null && (this.xsdTypeQuery.getValue()==null || this.xsdTypeQuery.getValue().trim().equals("")) )
				this.xsdTypeQuery = null;
			this.alias.setQuery(this.xsdTypeQuery);
		}
		else if (this.typeElementOrMessage == BID_USE_ELEMENT) {
			this.alias.setXSDElement(this.xsdElementDeclaration);
			if (this.xsdElementQuery!=null && (this.xsdElementQuery.getValue()==null || this.xsdElementQuery.getValue().trim().equals("")) )
				this.xsdElementQuery = null;
			this.alias.setQuery(this.xsdElementQuery);
		}
		else {
			this.alias.setMessageType(this.message);
			this.alias.setPart(this.messagePart);
			if (this.messageQuery!=null && (this.messageQuery.getValue()==null || this.messageQuery.getValue().trim().equals("")) )
				this.messageQuery = null;
			this.alias.setQuery(this.messageQuery);
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