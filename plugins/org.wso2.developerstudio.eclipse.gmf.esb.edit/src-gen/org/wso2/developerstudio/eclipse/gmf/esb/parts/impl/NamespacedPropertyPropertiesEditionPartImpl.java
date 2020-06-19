/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class NamespacedPropertyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, NamespacedPropertyPropertiesEditionPart {

	protected Text prettyName;
	protected Text propertyName;
	protected Text propertyValue;
	protected Text namespaces;
	protected Button supportsDynamicXPaths;
	protected Button dynamic;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public NamespacedPropertyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence namespacedPropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = namespacedPropertyStep.addStep(EsbViewsRepository.NamespacedProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.NamespacedProperty.Properties.prettyName);
		propertiesStep.addStep(EsbViewsRepository.NamespacedProperty.Properties.propertyName);
		propertiesStep.addStep(EsbViewsRepository.NamespacedProperty.Properties.propertyValue);
		propertiesStep.addStep(EsbViewsRepository.NamespacedProperty.Properties.namespaces);
		propertiesStep.addStep(EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths);
		propertiesStep.addStep(EsbViewsRepository.NamespacedProperty.Properties.dynamic);
		
		
		composer = new PartComposer(namespacedPropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.NamespacedProperty.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.NamespacedProperty.Properties.prettyName) {
					return createPrettyNameText(parent);
				}
				if (key == EsbViewsRepository.NamespacedProperty.Properties.propertyName) {
					return createPropertyNameText(parent);
				}
				if (key == EsbViewsRepository.NamespacedProperty.Properties.propertyValue) {
					return createPropertyValueText(parent);
				}
				if (key == EsbViewsRepository.NamespacedProperty.Properties.namespaces) {
					return createNamespacesText(parent);
				}
				if (key == EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths) {
					return createSupportsDynamicXPathsCheckbox(parent);
				}
				if (key == EsbViewsRepository.NamespacedProperty.Properties.dynamic) {
					return createDynamicCheckbox(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.NamespacedPropertyPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createPrettyNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NamespacedProperty.Properties.prettyName, EsbMessages.NamespacedPropertyPropertiesEditionPart_PrettyNameLabel);
		prettyName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData prettyNameData = new GridData(GridData.FILL_HORIZONTAL);
		prettyName.setLayoutData(prettyNameData);
		prettyName.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NamespacedPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NamespacedProperty.Properties.prettyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, prettyName.getText()));
			}

		});
		prettyName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NamespacedPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NamespacedProperty.Properties.prettyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, prettyName.getText()));
				}
			}

		});
		EditingUtils.setID(prettyName, EsbViewsRepository.NamespacedProperty.Properties.prettyName);
		EditingUtils.setEEFtype(prettyName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NamespacedProperty.Properties.prettyName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPrettyNameText

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NamespacedProperty.Properties.propertyName, EsbMessages.NamespacedPropertyPropertiesEditionPart_PropertyNameLabel);
		propertyName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData propertyNameData = new GridData(GridData.FILL_HORIZONTAL);
		propertyName.setLayoutData(propertyNameData);
		propertyName.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NamespacedPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NamespacedProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
			}

		});
		propertyName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NamespacedPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NamespacedProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
				}
			}

		});
		EditingUtils.setID(propertyName, EsbViewsRepository.NamespacedProperty.Properties.propertyName);
		EditingUtils.setEEFtype(propertyName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NamespacedProperty.Properties.propertyName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyNameText

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NamespacedProperty.Properties.propertyValue, EsbMessages.NamespacedPropertyPropertiesEditionPart_PropertyValueLabel);
		propertyValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
		propertyValue.setLayoutData(propertyValueData);
		propertyValue.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NamespacedPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NamespacedProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
			}

		});
		propertyValue.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NamespacedPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NamespacedProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
				}
			}

		});
		EditingUtils.setID(propertyValue, EsbViewsRepository.NamespacedProperty.Properties.propertyValue);
		EditingUtils.setEEFtype(propertyValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NamespacedProperty.Properties.propertyValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyValueText

		// End of user code
		return parent;
	}

	
	protected Composite createNamespacesText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NamespacedProperty.Properties.namespaces, EsbMessages.NamespacedPropertyPropertiesEditionPart_NamespacesLabel);
		namespaces = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData namespacesData = new GridData(GridData.FILL_HORIZONTAL);
		namespaces.setLayoutData(namespacesData);
		namespaces.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NamespacedPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NamespacedProperty.Properties.namespaces, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespaces.getText()));
			}

		});
		namespaces.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NamespacedPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NamespacedProperty.Properties.namespaces, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespaces.getText()));
				}
			}

		});
		EditingUtils.setID(namespaces, EsbViewsRepository.NamespacedProperty.Properties.namespaces);
		EditingUtils.setEEFtype(namespaces, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NamespacedProperty.Properties.namespaces, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNamespacesText

		// End of user code
		return parent;
	}

	
	protected Composite createSupportsDynamicXPathsCheckbox(Composite parent) {
		supportsDynamicXPaths = new Button(parent, SWT.CHECK);
		supportsDynamicXPaths.setText(getDescription(EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths, EsbMessages.NamespacedPropertyPropertiesEditionPart_SupportsDynamicXPathsLabel));
		supportsDynamicXPaths.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NamespacedPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(supportsDynamicXPaths.getSelection())));
			}

		});
		GridData supportsDynamicXPathsData = new GridData(GridData.FILL_HORIZONTAL);
		supportsDynamicXPathsData.horizontalSpan = 2;
		supportsDynamicXPaths.setLayoutData(supportsDynamicXPathsData);
		EditingUtils.setID(supportsDynamicXPaths, EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths);
		EditingUtils.setEEFtype(supportsDynamicXPaths, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSupportsDynamicXPathsCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createDynamicCheckbox(Composite parent) {
		dynamic = new Button(parent, SWT.CHECK);
		dynamic.setText(getDescription(EsbViewsRepository.NamespacedProperty.Properties.dynamic, EsbMessages.NamespacedPropertyPropertiesEditionPart_DynamicLabel));
		dynamic.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NamespacedPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NamespacedProperty.Properties.dynamic, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(dynamic.getSelection())));
			}

		});
		GridData dynamicData = new GridData(GridData.FILL_HORIZONTAL);
		dynamicData.horizontalSpan = 2;
		dynamic.setLayoutData(dynamicData);
		EditingUtils.setID(dynamic, EsbViewsRepository.NamespacedProperty.Properties.dynamic);
		EditingUtils.setEEFtype(dynamic, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NamespacedProperty.Properties.dynamic, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDynamicCheckbox

		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#getPrettyName()
	 * 
	 */
	public String getPrettyName() {
		return prettyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#setPrettyName(String newValue)
	 * 
	 */
	public void setPrettyName(String newValue) {
		if (newValue != null) {
			prettyName.setText(newValue);
		} else {
			prettyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NamespacedProperty.Properties.prettyName);
		if (eefElementEditorReadOnlyState && prettyName.isEnabled()) {
			prettyName.setEnabled(false);
			prettyName.setToolTipText(EsbMessages.NamespacedProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !prettyName.isEnabled()) {
			prettyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#getPropertyName()
	 * 
	 */
	public String getPropertyName() {
		return propertyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#setPropertyName(String newValue)
	 * 
	 */
	public void setPropertyName(String newValue) {
		if (newValue != null) {
			propertyName.setText(newValue);
		} else {
			propertyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NamespacedProperty.Properties.propertyName);
		if (eefElementEditorReadOnlyState && propertyName.isEnabled()) {
			propertyName.setEnabled(false);
			propertyName.setToolTipText(EsbMessages.NamespacedProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyName.isEnabled()) {
			propertyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#getPropertyValue()
	 * 
	 */
	public String getPropertyValue() {
		return propertyValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#setPropertyValue(String newValue)
	 * 
	 */
	public void setPropertyValue(String newValue) {
		if (newValue != null) {
			propertyValue.setText(newValue);
		} else {
			propertyValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NamespacedProperty.Properties.propertyValue);
		if (eefElementEditorReadOnlyState && propertyValue.isEnabled()) {
			propertyValue.setEnabled(false);
			propertyValue.setToolTipText(EsbMessages.NamespacedProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValue.isEnabled()) {
			propertyValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#getNamespaces()
	 * 
	 */
	public String getNamespaces() {
		return namespaces.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#setNamespaces(String newValue)
	 * 
	 */
	public void setNamespaces(String newValue) {
		if (newValue != null) {
			namespaces.setText(newValue);
		} else {
			namespaces.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NamespacedProperty.Properties.namespaces);
		if (eefElementEditorReadOnlyState && namespaces.isEnabled()) {
			namespaces.setEnabled(false);
			namespaces.setToolTipText(EsbMessages.NamespacedProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !namespaces.isEnabled()) {
			namespaces.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#getSupportsDynamicXPaths()
	 * 
	 */
	public Boolean getSupportsDynamicXPaths() {
		return Boolean.valueOf(supportsDynamicXPaths.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#setSupportsDynamicXPaths(Boolean newValue)
	 * 
	 */
	public void setSupportsDynamicXPaths(Boolean newValue) {
		if (newValue != null) {
			supportsDynamicXPaths.setSelection(newValue.booleanValue());
		} else {
			supportsDynamicXPaths.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths);
		if (eefElementEditorReadOnlyState && supportsDynamicXPaths.isEnabled()) {
			supportsDynamicXPaths.setEnabled(false);
			supportsDynamicXPaths.setToolTipText(EsbMessages.NamespacedProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !supportsDynamicXPaths.isEnabled()) {
			supportsDynamicXPaths.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#getDynamic()
	 * 
	 */
	public Boolean getDynamic() {
		return Boolean.valueOf(dynamic.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart#setDynamic(Boolean newValue)
	 * 
	 */
	public void setDynamic(Boolean newValue) {
		if (newValue != null) {
			dynamic.setSelection(newValue.booleanValue());
		} else {
			dynamic.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NamespacedProperty.Properties.dynamic);
		if (eefElementEditorReadOnlyState && dynamic.isEnabled()) {
			dynamic.setEnabled(false);
			dynamic.setToolTipText(EsbMessages.NamespacedProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dynamic.isEnabled()) {
			dynamic.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.NamespacedProperty_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
