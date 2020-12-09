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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.bpel.model.messageproperties.MessagepropertiesFactory;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.AddImportCommand;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.details.providers.ColumnTableProvider;
import org.eclipse.bpel.ui.details.providers.ModelLabelProvider;
import org.eclipse.bpel.ui.details.providers.PropertyAliasContentProvider;
import org.eclipse.bpel.ui.details.providers.PropertyAliasFilter;
import org.eclipse.bpel.ui.util.BrowseUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.WSDLImportHelper;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.internal.impl.DefinitionImpl;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDConstants;


/**
 * Dialog for creating or editing message properties.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
 * https://jira.jboss.org/browse/JBIDE-7107
 * This has been completely reworked to support Properties of both XSD Simple Types and
 * XSD Elements (previous version only supported Simple Types).
 */
public class EditMessagePropertyDialog extends Dialog {
	protected static final int BID_USE_TYPE = IDialogConstants.CLIENT_ID + 30;
	protected static final int BID_USE_ELEMENT = IDialogConstants.CLIENT_ID + 31;

	// True if a new property is being created (as opposed to an existing being edited)
	protected boolean isNew;
	// True if the given propery will be replaced
	protected boolean isReplacement;
	protected Property property;
	protected Object propertyType;
	protected XSDTypeDefinition xsdTypeDefinition;
	protected XSDElementDeclaration xsdElementDeclaration;
	protected IFile targetFile;
	protected URI propertyTypeFileURI;
	protected BPELEditor bpelEditor;

	protected List newAliasesList = new ArrayList();
	
	// widgets
	protected Text propertyNameText;
	protected Label typeOrElementNameLabel;
	protected Label typeOrElementNameText;
	private Button typeRadio;
	private Button elementRadio;
	private int typeOrElement;

	protected Button browseTypeButton;
	protected Button newAliasButton;
	protected Button editAliasButton;
	protected Button removeAliasButton;
	protected Table aliasesTable;
	protected ColumnTableProvider aliasesTableProvider;
	protected TableViewer aliasesTableViewer;
	protected PropertyAliasFilter aliasesFilter;
	protected Set existingPropertyNames;
	protected TabbedPropertySheetWidgetFactory wf;

	/** inner classes **/

	public class MessageTypeColumn extends ColumnTableProvider.Column implements ILabelProvider {
		@Override
		public String getHeaderText() { return Messages.EditMessagePropertyDialog_1; } 
		@Override
		public String getProperty() { return "aliasMsgType"; } //$NON-NLS-1$
		@Override
		public int getInitialWeight() { return 50; }

		ModelLabelProvider labelProvider = new ModelLabelProvider();

		public String getText(Object element) {
			PropertyAlias alias = (PropertyAlias)element;
			String part = alias.getPart();
			Object message = ((PropertyAlias)element).getMessageType();
			String s = "";
			if (message!=null) {
				s = labelProvider.getText(message) + (part==null? "" : ("."+part) ); 
				if (part!=null && alias.getQuery() != null) {
					String query = alias.getQuery().getValue();
					if (query != null && !"".equals(query)) { //$NON-NLS-1$
						s += NLS.bind(Messages.EditMessagePropertyDialog_4, (new Object[] { query })); 
					}
				}
			}
			return s;
		}
	}

	public class XSDElementColumn extends ColumnTableProvider.Column implements ILabelProvider {
		@Override
		public String getHeaderText() { return Messages.EditMessagePropertyDialog_15; } 
		@Override
		public String getProperty() { return "aliasElement"; } //$NON-NLS-1$
		@Override
		public int getInitialWeight() { return 25; }

		public String getText(Object element) {
			PropertyAlias alias = (PropertyAlias)element;
			XSDNamedComponent xsdElem = (XSDNamedComponent)alias.getXSDElement();
			String s = (xsdElem==null? "":xsdElem.getName()); 
			if (xsdElem!=null && alias.getQuery() != null) {
				String query = alias.getQuery().getValue();
				if (query != null && !"".equals(query)) { //$NON-NLS-1$
					s += NLS.bind(Messages.EditMessagePropertyDialog_4, (new Object[] { query })); 
				}
			}
			return s;
		}
	}

	public class XSDTypeColumn extends ColumnTableProvider.Column implements ILabelProvider {
		@Override
		public String getHeaderText() { return Messages.EditMessagePropertyDialog_16; } 
		@Override
		public String getProperty() { return "aliasType"; } //$NON-NLS-1$
		@Override
		public int getInitialWeight() { return 25; }

		public String getText(Object element) {
			PropertyAlias alias = (PropertyAlias)element;
			XSDNamedComponent xsdElem = (XSDNamedComponent)alias.getType();
			String s = (xsdElem==null? "":xsdElem.getName()); 
			if (xsdElem!=null && alias.getQuery() != null) {
				String query = alias.getQuery().getValue();
				if (query != null && !"".equals(query)) { //$NON-NLS-1$
					s += NLS.bind(Messages.EditMessagePropertyDialog_4, (new Object[] { query })); 
				}
			}
			return s;
		}
	}

	
	public EditMessagePropertyDialog(Shell parentShell, Property property, String newPropertyName, BPELEditor bpelEditor, TabbedPropertySheetWidgetFactory wf) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.bpelEditor = bpelEditor;
		this.property = property;
		this.wf = wf;
		isNew = (property == null);
		isReplacement = (property!=null && property.eIsProxy());
		if (isReplacement)
			newPropertyName = property.getName();
		if (isNew || isReplacement) {
			targetFile = bpelEditor.getEditModelClient().getArtifactsResourceInfo().getFile();
			this.property = MessagepropertiesFactory.eINSTANCE.createProperty();
			this.property.setName(newPropertyName);
			typeOrElement = BID_USE_TYPE;
		} else {
			Object type = property.getType();
			if (type instanceof XSDTypeDefinition) {
				this.propertyType = type;
				this.xsdTypeDefinition = (XSDTypeDefinition)type;
				typeOrElement = BID_USE_TYPE;
			}
			else if (type instanceof XSDElementDeclaration) {
				this.propertyType = type;
				this.xsdElementDeclaration = (XSDElementDeclaration)type;
				typeOrElement = BID_USE_ELEMENT;
			}
			else {
				typeOrElement = BID_USE_TYPE;
			}
		}
	}

	/**
	 * @return Returns the property.
	 */
	public Property getProperty() {
		return property;
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
		Label propertyNameLabel = new Label(composite, SWT.NONE);
		propertyNameLabel.setText(Messages.EditMessagePropertyDialog_14); 
		propertyNameText = new Text(composite, SWT.BORDER);
		if (property != null) {
			String s = property.getName();
			propertyNameText.setText((s == null)? "" : s); //$NON-NLS-1$
		}
		// TODO: if the property name changes we need to update the aliases as well
		propertyNameText.addListener(SWT.Modify, enablementListener);
		if (isReplacement)
			propertyNameText.setEnabled(false);

		String groupText = Messages.EditMessagePropertyDialog_10;
		// Property must have either XSD Type or XSD Element: create radio button group
		Group typeOrElementRadioGroup = new Group(composite,SWT.SHADOW_ETCHED_IN);
		typeOrElementRadioGroup.setText(groupText);
		layout = new GridLayout();
		layout.makeColumnsEqualWidth = false;		
		layout.numColumns = 1;		
		typeOrElementRadioGroup.setLayout(layout);
		typeRadio = createRadioButton(typeOrElementRadioGroup,Messages.EditMessagePropertyDialog_11, BID_USE_TYPE, typeOrElement == BID_USE_TYPE);
		elementRadio = createRadioButton(typeOrElementRadioGroup,Messages.EditMessagePropertyDialog_12, BID_USE_ELEMENT, typeOrElement == BID_USE_ELEMENT);
		typeRadio.addListener(SWT.Selection, enablementListener);
		elementRadio.addListener(SWT.Selection, enablementListener);
		
		typeOrElementNameLabel = new Label(composite, SWT.NONE);
		typeOrElementNameText = new Label(composite, SWT.NONE);
		browseTypeButton = new Button(composite, SWT.PUSH);
		browseTypeButton.setText(Messages.EditMessagePropertyDialog_18); 
		browseTypeButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				browsePropertyType();
			}
		});
		
		Label separator = new Label(composite, SWT.SEPARATOR|SWT.HORIZONTAL|SWT.BOLD);
		Label aliasesLabel = new Label(composite, SWT.NONE);
		aliasesLabel.setText(Messages.EditMessagePropertyDialog_20); 
		Composite c2 = new Composite(composite, SWT.NONE);
		newAliasButton = new Button(c2, SWT.PUSH);
		newAliasButton.setText(Messages.EditMessagePropertyDialog_21); 
		newAliasButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				createAlias();
			}
		});
		editAliasButton = new Button(c2, SWT.PUSH);
		editAliasButton.setText(Messages.EditMessagePropertyDialog_22); 
		editAliasButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				IStructuredSelection sel = (IStructuredSelection)aliasesTableViewer.getSelection();
				PropertyAlias alias = (PropertyAlias) sel.getFirstElement();
				editAlias(alias);
			}
		});
		removeAliasButton = new Button(c2, SWT.PUSH);
		removeAliasButton.setText(Messages.EditMessagePropertyDialog_23); 
		removeAliasButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				IStructuredSelection sel = (IStructuredSelection)aliasesTableViewer.getSelection();
				PropertyAlias alias = (PropertyAlias) sel.getFirstElement();
				Definition definition = property.getEnclosingDefinition();
				if (definition != null) {
					definition.getEExtensibilityElements().remove(alias);
				} else {
					newAliasesList.remove(alias);
				}
				updatePropertyAliasTable();
			}
		});
		
		aliasesTable = new Table(composite, SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
		aliasesTable.setLinesVisible(true);
		aliasesTable.setHeaderVisible(true);
		aliasesTableProvider = new ColumnTableProvider();
		aliasesTableProvider.add(new MessageTypeColumn());
		aliasesTableProvider.add(new XSDElementColumn());
		aliasesTableProvider.add(new XSDTypeColumn());
		aliasesTableViewer = new TableViewer(aliasesTable);
		aliasesTableProvider.createTableLayout(aliasesTable);
		aliasesTableViewer.setLabelProvider(aliasesTableProvider);
		// Content provider that combines aliases from the actual model and newAliasesList.
		aliasesTableViewer.setContentProvider(new PropertyAliasContentProvider() {
			@Override
			public Object[] getElements(Object input) {
				Object[] superResult = super.getElements(input);
				Object[] result = new Object[superResult.length + newAliasesList.size()];
				System.arraycopy(superResult, 0, result, 0, superResult.length);
				int i = superResult.length;
				for (Iterator it = newAliasesList.iterator(); it.hasNext(); ) {
					result[i++] = it.next();
				}
				return result;
			}
		});
		aliasesTableViewer.setColumnProperties(aliasesTableProvider.getColumnProperties());
		aliasesFilter = new PropertyAliasFilter();
		aliasesTableViewer.addFilter(aliasesFilter);
		aliasesTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updateEnablement();
			}
		});
		
		// update type widgets
		updateTypeWidgets();
		updatePropertyAliasTable();
		updateTypeFileText();

		// layout widgets
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		data.horizontalSpan = 1;
		propertyNameLabel.setLayoutData(data);
		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		propertyNameText.setLayoutData(data);

		data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 3;
//		data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
//		topLabel.setLayoutData(data);
		typeOrElementRadioGroup.setLayoutData(data);
		data = new GridData(GridData.FILL_HORIZONTAL);
		typeRadio.setLayoutData(data);
		data = new GridData(GridData.FILL_HORIZONTAL);
		elementRadio.setLayoutData(data);

		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 3;
		separator.setLayoutData(data);
		
		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		typeOrElementNameLabel.setLayoutData(data);
		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL);
		typeOrElementNameText.setLayoutData(data);
		data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		browseTypeButton.setLayoutData(data);
		
		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		aliasesLabel.setLayoutData(data);
		data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		data.horizontalSpan = 2;
		c2.setLayoutData(data);
		layout = new GridLayout(3, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		c2.setLayout(layout);
		data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		newAliasButton.setLayoutData(data);
		data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		editAliasButton.setLayoutData(data);
		data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		removeAliasButton.setLayoutData(data);
		
		data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 3;
		data.verticalSpan = 3;
		data.heightHint = 200;
		data.widthHint = 500;
		aliasesTable.setLayoutData(data);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			parent, IHelpContextIds.PROPERTY_DIALOG);
		
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
			if (!checked)
				return;
			typeOrElement = id;
			break;
		
		default : 			
			break;
		}
	
	
		if (bRefresh) {
			updateTypeWidgets();
		}
	}
	
	protected void updatePropertyAliasTable() {
		aliasesFilter.setProperty(property);
		//aliasesTableViewer.setInput(definition);
		aliasesTableViewer.setInput(bpelEditor.getProcess());
	}

	protected void updateTypeFileText() {
		if (propertyType instanceof XSDTypeDefinition) {
			xsdTypeDefinition = (XSDTypeDefinition) propertyType;
			typeOrElementNameText.setText(xsdTypeDefinition.getName());
		} else if (propertyType instanceof XSDElementDeclaration) {
			xsdElementDeclaration = (XSDElementDeclaration) propertyType;
			typeOrElementNameText.setText(xsdElementDeclaration.getName());
		}
		else
		{
			typeOrElementNameText.setText("");
		}
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		if (isNew) {
			newShell.setText(Messages.EditMessagePropertyDialog_26); 
		} else {
			newShell.setText(Messages.EditMessagePropertyDialog_27); 
		}
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
		if ((targetFile == null && property.eResource() == null)
			|| !isPropertyNameValid()
			|| propertyType == null) {
				isOK = false;
		}
		Button okButton = getButton(IDialogConstants.OK_ID);
		if (okButton != null) {
			okButton.setEnabled(isOK);
		}
		newAliasButton.setEnabled(isOK);
		isOK &= !aliasesTableViewer.getSelection().isEmpty();
		editAliasButton.setEnabled(isOK);
		removeAliasButton.setEnabled(isOK);
	}

	protected boolean isPropertyNameValid() {
		String name = propertyNameText.getText();
		if (name == null) return false;
		if ("".equals(name)) return false; //$NON-NLS-1$
		if (propertyNameExists(name)) return false;
		return true;
	}
	
	protected boolean propertyNameExists(String name) {
		if (!isNew && name.equals(property.getName())) return false;
		return !isReplacement && getExistingPropertyNames().contains(name);
	}
	
	protected Set getExistingPropertyNames() {
		if (existingPropertyNames == null) {
			Set properties = ModelHelper.getAvailableProperties(bpelEditor.getProcess());
			existingPropertyNames = new HashSet();
			for (Iterator iter = properties.iterator(); iter.hasNext();) {
				Property prop = (Property) iter.next();
				existingPropertyNames.add(prop.getName());
			}
		}
		return existingPropertyNames;
	}
	
	protected void updateTypeWidgets() {
		// update type from file
		if (typeOrElement == BID_USE_ELEMENT ) {
			typeOrElementNameLabel.setText(Messages.EditMessagePropertyDialog_Element_1);
			typeRadio.setSelection(false);
			elementRadio.setSelection(true);
			propertyType = xsdElementDeclaration;
		}
		else {
			typeOrElementNameLabel.setText(Messages.EditMessagePropertyDialog_Type_1);
			typeRadio.setSelection(true);
			elementRadio.setSelection(false);
			propertyType = xsdTypeDefinition;
		}
		typeOrElementNameLabel.pack();
		updateTypeFileText();
	}

	/**
	 * Opens a dialog and let the user browse for an XSD type or element.
	 * Updates the property type according to the user choice.
	 */
	protected void browsePropertyType() {
		Object type = null;
		Object result[] = null;
		if (typeOrElement == BID_USE_TYPE)
			result = BrowseUtil.browseForXSDType(bpelEditor.getProcess(), getShell());
		else
			result = BrowseUtil.browseForXSDElement(bpelEditor.getProcess(), getShell(),false);

		if (result!=null && result.length>=1)
			type = result[0];
		
		if (type != null) {
			propertyType = type;
			if (typeOrElement == BID_USE_ELEMENT)
				xsdElementDeclaration = (XSDElementDeclaration) type;
			else
				xsdTypeDefinition = (XSDTypeDefinition) type;
			
			updateTypeFileText();
	    	updateEnablement();
	    }
	}

	protected URI getTargetFileURI() {
		if (targetFile != null) {
			return URI.createPlatformResourceURI(targetFile.getFullPath().toString());
		}
		return property.eResource().getURI();
	}
	
	@Override
	protected void okPressed() {
		createProperty();
		super.okPressed();
	}

	/**
	 * Creates the necessary property (in the Resource in memory only).
	 */
	protected void createProperty() {
		URI uri = getTargetFileURI();
		
		final Resource resource = bpelEditor.getResourceSet().getResource(uri, true);
		final Definition definition = (Definition) resource.getContents().get(0);

		bpelEditor.getCommandFramework().execute(new AutoUndoCommand(definition) {
			@Override
			public void doExecute() {
				if (isNew) {
					definition.getEExtensibilityElements().add(property);
					property.setEnclosingDefinition(definition);
					// add any aliases we're creating too.
					for (Iterator it = newAliasesList.iterator(); it.hasNext(); ) {
						PropertyAlias alias = (PropertyAlias)it.next(); 
						definition.getEExtensibilityElements().add(alias);
						alias.setEnclosingDefinition(definition);
					}
					newAliasesList.clear();
				}
				else if (isReplacement) {
					boolean found = false;
					for (Object obj : definition.getEExtensibilityElements()) {
						if (obj instanceof Property && ((Property)obj).getName().equals(property.getName())) {
							property = (Property)obj;
							found = true;
							break;
						}
					}
					if (!found) {
						definition.getEExtensibilityElements().add(property);
						property.setEnclosingDefinition(definition);
					}
				}
				property.setName(propertyNameText.getText());
				property.setType(propertyType);
				
				WSDLImportHelper.addAllImportsAndNamespaces(definition,
					bpelEditor.getEditModelClient().getPrimaryResourceInfo().getFile());
				// This property must be a simple type. Make sure the namespace is already in the wsdl file.
				if (definition.getPrefix(XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001) == null) {
					// TODO: what if it already had this prefix??
					definition.addNamespace("xs", XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001); //$NON-NLS-1$
				}

				// https://issues.jboss.org/browse/JBIDE-8075
				// create the artifacts resource if it doesn't already exist
				if (targetFile!=null && !targetFile.exists()) {
					// add the import if not already being imported by this process
					AddImportCommand cmd = new AddImportCommand(bpelEditor.getProcess(), definition, null);
					if (cmd.canDoExecute() && cmd.wouldCreateDuplicateImport() == false) {
						bpelEditor.getCommandStack().execute(cmd);
					}
					try {
						resource.setModified(true);
						resource.save(resource.getResourceSet().getLoadOptions());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Opens a dialog and let the user create a new property alias.
	 */
	protected void createAlias() {
		EditPropertyAliasDialog dialog = new EditPropertyAliasDialog(getShell(), property, null, bpelEditor, wf);
		if (dialog.open() == Window.OK) {

			final PropertyAlias alias = dialog.getPropertyAlias();
			if (alias != null) {
				URI uri = getTargetFileURI();
				Resource resource = bpelEditor.getResourceSet().getResource(uri, true);
				final Definition definition = (Definition) resource.getContents().get(0);
				bpelEditor.getCommandFramework().execute(new AutoUndoCommand(definition) {
					@Override
					public void doExecute() {
						if (isNew) {
							// save the alias and add them later
							newAliasesList.add(alias);
						} else {
							// add the alias now
							if (isReplacement) {
								alias.setPropertyName(property);
							}
							alias.setEnclosingDefinition(definition);
							definition.getEExtensibilityElements().add(alias);
						}

						Object imported = null;
						Object messageTypeObject = alias.getMessageType();
						Object xsdElementObject = alias.getXSDElement();
						Object typeObject = alias.getType();
						if (messageTypeObject instanceof Message) {
							imported = ((Message)messageTypeObject).getEnclosingDefinition();
						}
						else if (xsdElementObject instanceof XSDElementDeclaration) {
							EObject top = (XSDElementDeclaration)xsdElementObject;
							while (top.eContainer() != null) {
								top = top.eContainer();
								if (top instanceof Definition) {
									imported = top;
									break;
								}
							}		
						}
						else if (typeObject instanceof XSDTypeDefinition) {
							EObject top = (XSDTypeDefinition)typeObject;
							while (top.eContainer() != null) {
								top = top.eContainer();
								if (top instanceof Definition) {
									imported = top;
									break;
								}
							}		
						}
						if (imported instanceof Definition) {
							WSDLImportHelper.addImportAndNamespace(definition, (Definition)imported);
						}
						else if (imported instanceof XSDSchema) {
							WSDLImportHelper.addImportAndNamespace(definition, (XSDSchema)imported,
									bpelEditor.getEditModelClient().getPrimaryResourceInfo().getFile());
						}
						// This doesn't seem to introduce an updateElement automatically,
						// so do it manually now, so that RolePortTypes (for example) who
						// are affected by the new namespace will know about it.
						((DefinitionImpl)definition).updateElement();
					}
				});
				
				updatePropertyAliasTable();
			}
		}
	}

	/**
	 * Opens a dialog and let the user edit an existing property alias.
	 */
	protected void editAlias(PropertyAlias alias) {
		if (alias != null) {
			EditPropertyAliasDialog dialog = new EditPropertyAliasDialog(getShell(), property, alias, bpelEditor, wf);
			if (dialog.open() == Window.OK) {
				updatePropertyAliasTable();
			}
		}
	}
}
