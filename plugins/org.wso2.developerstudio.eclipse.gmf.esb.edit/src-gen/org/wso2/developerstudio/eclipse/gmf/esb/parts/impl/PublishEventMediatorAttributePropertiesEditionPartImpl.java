/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

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

import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class PublishEventMediatorAttributePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PublishEventMediatorAttributePropertiesEditionPart {

	protected Text attributeName;
	protected EMFComboViewer attributeValueType;
	protected Text attributeValue;
	protected EMFComboViewer attributeType;
	protected Text defaultValue;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public PublishEventMediatorAttributePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence publishEventMediatorAttributeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = publishEventMediatorAttributeStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue);
		
		
		composer = new PartComposer(publishEventMediatorAttributeStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.PublishEventMediatorAttribute.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName) {
					return createAttributeNameText(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType) {
					return createAttributeValueTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue) {
					return createAttributeValueText(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType) {
					return createAttributeTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue) {
					return createDefaultValueText(parent);
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
		propertiesGroup.setText(EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createAttributeNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName, EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_AttributeNameLabel);
		attributeName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData attributeNameData = new GridData(GridData.FILL_HORIZONTAL);
		attributeName.setLayoutData(attributeNameData);
		attributeName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, attributeName.getText()));
			}

		});
		attributeName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, attributeName.getText()));
				}
			}

		});
		EditingUtils.setID(attributeName, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName);
		EditingUtils.setEEFtype(attributeName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAttributeNameText

		// End of user code
		return parent;
	}

	
	protected Composite createAttributeValueTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType, EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_AttributeValueTypeLabel);
		attributeValueType = new EMFComboViewer(parent);
		attributeValueType.setContentProvider(new ArrayContentProvider());
		attributeValueType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData attributeValueTypeData = new GridData(GridData.FILL_HORIZONTAL);
		attributeValueType.getCombo().setLayoutData(attributeValueTypeData);
		attributeValueType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAttributeValueType()));
			}

		});
		attributeValueType.setID(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAttributeValueTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createAttributeValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue, EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_AttributeValueLabel);
		attributeValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData attributeValueData = new GridData(GridData.FILL_HORIZONTAL);
		attributeValue.setLayoutData(attributeValueData);
		attributeValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, attributeValue.getText()));
			}

		});
		attributeValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, attributeValue.getText()));
				}
			}

		});
		EditingUtils.setID(attributeValue, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue);
		EditingUtils.setEEFtype(attributeValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAttributeValueText

		// End of user code
		return parent;
	}

	
	protected Composite createAttributeTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType, EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_AttributeTypeLabel);
		attributeType = new EMFComboViewer(parent);
		attributeType.setContentProvider(new ArrayContentProvider());
		attributeType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData attributeTypeData = new GridData(GridData.FILL_HORIZONTAL);
		attributeType.getCombo().setLayoutData(attributeTypeData);
		attributeType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAttributeType()));
			}

		});
		attributeType.setID(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAttributeTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDefaultValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue, EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_DefaultValueLabel);
		defaultValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData defaultValueData = new GridData(GridData.FILL_HORIZONTAL);
		defaultValue.setLayoutData(defaultValueData);
		defaultValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValue.getText()));
			}

		});
		defaultValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValue.getText()));
				}
			}

		});
		EditingUtils.setID(defaultValue, EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue);
		EditingUtils.setEEFtype(defaultValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDefaultValueText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#getAttributeName()
	 * 
	 */
	public String getAttributeName() {
		return attributeName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#setAttributeName(String newValue)
	 * 
	 */
	public void setAttributeName(String newValue) {
		if (newValue != null) {
			attributeName.setText(newValue);
		} else {
			attributeName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName);
		if (eefElementEditorReadOnlyState && attributeName.isEnabled()) {
			attributeName.setEnabled(false);
			attributeName.setToolTipText(EsbMessages.PublishEventMediatorAttribute_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !attributeName.isEnabled()) {
			attributeName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#getAttributeValueType()
	 * 
	 */
	public Enumerator getAttributeValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) attributeValueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#initAttributeValueType(Object input, Enumerator current)
	 */
	public void initAttributeValueType(Object input, Enumerator current) {
		attributeValueType.setInput(input);
		attributeValueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType);
		if (eefElementEditorReadOnlyState && attributeValueType.isEnabled()) {
			attributeValueType.setEnabled(false);
			attributeValueType.setToolTipText(EsbMessages.PublishEventMediatorAttribute_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !attributeValueType.isEnabled()) {
			attributeValueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#setAttributeValueType(Enumerator newValue)
	 * 
	 */
	public void setAttributeValueType(Enumerator newValue) {
		attributeValueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType);
		if (eefElementEditorReadOnlyState && attributeValueType.isEnabled()) {
			attributeValueType.setEnabled(false);
			attributeValueType.setToolTipText(EsbMessages.PublishEventMediatorAttribute_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !attributeValueType.isEnabled()) {
			attributeValueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#getAttributeValue()
	 * 
	 */
	public String getAttributeValue() {
		return attributeValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#setAttributeValue(String newValue)
	 * 
	 */
	public void setAttributeValue(String newValue) {
		if (newValue != null) {
			attributeValue.setText(newValue);
		} else {
			attributeValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue);
		if (eefElementEditorReadOnlyState && attributeValue.isEnabled()) {
			attributeValue.setEnabled(false);
			attributeValue.setToolTipText(EsbMessages.PublishEventMediatorAttribute_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !attributeValue.isEnabled()) {
			attributeValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#getAttributeType()
	 * 
	 */
	public Enumerator getAttributeType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) attributeType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#initAttributeType(Object input, Enumerator current)
	 */
	public void initAttributeType(Object input, Enumerator current) {
		attributeType.setInput(input);
		attributeType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType);
		if (eefElementEditorReadOnlyState && attributeType.isEnabled()) {
			attributeType.setEnabled(false);
			attributeType.setToolTipText(EsbMessages.PublishEventMediatorAttribute_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !attributeType.isEnabled()) {
			attributeType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#setAttributeType(Enumerator newValue)
	 * 
	 */
	public void setAttributeType(Enumerator newValue) {
		attributeType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType);
		if (eefElementEditorReadOnlyState && attributeType.isEnabled()) {
			attributeType.setEnabled(false);
			attributeType.setToolTipText(EsbMessages.PublishEventMediatorAttribute_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !attributeType.isEnabled()) {
			attributeType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#getDefaultValue()
	 * 
	 */
	public String getDefaultValue() {
		return defaultValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#setDefaultValue(String newValue)
	 * 
	 */
	public void setDefaultValue(String newValue) {
		if (newValue != null) {
			defaultValue.setText(newValue);
		} else {
			defaultValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue);
		if (eefElementEditorReadOnlyState && defaultValue.isEnabled()) {
			defaultValue.setEnabled(false);
			defaultValue.setToolTipText(EsbMessages.PublishEventMediatorAttribute_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !defaultValue.isEnabled()) {
			defaultValue.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.PublishEventMediatorAttribute_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
