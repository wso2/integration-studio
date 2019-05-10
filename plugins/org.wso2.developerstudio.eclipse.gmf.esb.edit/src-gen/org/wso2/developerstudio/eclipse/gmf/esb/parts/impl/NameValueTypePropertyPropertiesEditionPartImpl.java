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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.NameValueTypePropertyPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class NameValueTypePropertyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, NameValueTypePropertyPropertiesEditionPart {

	protected Text propertyName;
	protected Text propertyValue;
	protected EMFComboViewer propertyType;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public NameValueTypePropertyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence nameValueTypePropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = nameValueTypePropertyStep.addStep(EsbViewsRepository.NameValueTypeProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.NameValueTypeProperty.Properties.propertyName);
		propertiesStep.addStep(EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue);
		propertiesStep.addStep(EsbViewsRepository.NameValueTypeProperty.Properties.propertyType);
		
		
		composer = new PartComposer(nameValueTypePropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.NameValueTypeProperty.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.NameValueTypeProperty.Properties.propertyName) {
					return createPropertyNameText(parent);
				}
				if (key == EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue) {
					return createPropertyValueText(parent);
				}
				if (key == EsbViewsRepository.NameValueTypeProperty.Properties.propertyType) {
					return createPropertyTypeEMFComboViewer(parent);
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
		propertiesGroup.setText(EsbMessages.NameValueTypePropertyPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createPropertyNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NameValueTypeProperty.Properties.propertyName, EsbMessages.NameValueTypePropertyPropertiesEditionPart_PropertyNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NameValueTypePropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NameValueTypeProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NameValueTypePropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NameValueTypeProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
				}
			}

		});
		EditingUtils.setID(propertyName, EsbViewsRepository.NameValueTypeProperty.Properties.propertyName);
		EditingUtils.setEEFtype(propertyName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NameValueTypeProperty.Properties.propertyName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyNameText

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue, EsbMessages.NameValueTypePropertyPropertiesEditionPart_PropertyValueLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NameValueTypePropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NameValueTypePropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
				}
			}

		});
		EditingUtils.setID(propertyValue, EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue);
		EditingUtils.setEEFtype(propertyValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyValueText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createPropertyTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.NameValueTypeProperty.Properties.propertyType, EsbMessages.NameValueTypePropertyPropertiesEditionPart_PropertyTypeLabel);
		propertyType = new EMFComboViewer(parent);
		propertyType.setContentProvider(new ArrayContentProvider());
		propertyType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyTypeData = new GridData(GridData.FILL_HORIZONTAL);
		propertyType.getCombo().setLayoutData(propertyTypeData);
                propertyType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		propertyType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NameValueTypePropertyPropertiesEditionPartImpl.this, EsbViewsRepository.NameValueTypeProperty.Properties.propertyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyType()));
			}

		});
		propertyType.setID(EsbViewsRepository.NameValueTypeProperty.Properties.propertyType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NameValueTypeProperty.Properties.propertyType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyTypeEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NameValueTypePropertyPropertiesEditionPart#getPropertyName()
	 * 
	 */
	public String getPropertyName() {
		return propertyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NameValueTypePropertyPropertiesEditionPart#setPropertyName(String newValue)
	 * 
	 */
	public void setPropertyName(String newValue) {
		if (newValue != null) {
			propertyName.setText(newValue);
		} else {
			propertyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NameValueTypeProperty.Properties.propertyName);
		if (eefElementEditorReadOnlyState && propertyName.isEnabled()) {
			propertyName.setEnabled(false);
			propertyName.setToolTipText(EsbMessages.NameValueTypeProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyName.isEnabled()) {
			propertyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NameValueTypePropertyPropertiesEditionPart#getPropertyValue()
	 * 
	 */
	public String getPropertyValue() {
		return propertyValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NameValueTypePropertyPropertiesEditionPart#setPropertyValue(String newValue)
	 * 
	 */
	public void setPropertyValue(String newValue) {
		if (newValue != null) {
			propertyValue.setText(newValue);
		} else {
			propertyValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue);
		if (eefElementEditorReadOnlyState && propertyValue.isEnabled()) {
			propertyValue.setEnabled(false);
			propertyValue.setToolTipText(EsbMessages.NameValueTypeProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValue.isEnabled()) {
			propertyValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NameValueTypePropertyPropertiesEditionPart#getPropertyType()
	 * 
	 */
	public Enumerator getPropertyType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NameValueTypePropertyPropertiesEditionPart#initPropertyType(Object input, Enumerator current)
	 */
	public void initPropertyType(Object input, Enumerator current) {
		propertyType.setInput(input);
		propertyType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NameValueTypeProperty.Properties.propertyType);
		if (eefElementEditorReadOnlyState && propertyType.isEnabled()) {
			propertyType.setEnabled(false);
			propertyType.setToolTipText(EsbMessages.NameValueTypeProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyType.isEnabled()) {
			propertyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.NameValueTypePropertyPropertiesEditionPart#setPropertyType(Enumerator newValue)
	 * 
	 */
	public void setPropertyType(Enumerator newValue) {
		propertyType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NameValueTypeProperty.Properties.propertyType);
		if (eefElementEditorReadOnlyState && propertyType.isEnabled()) {
			propertyType.setEnabled(false);
			propertyType.setToolTipText(EsbMessages.NameValueTypeProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyType.isEnabled()) {
			propertyType.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.NameValueTypeProperty_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
