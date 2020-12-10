/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

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
	// Start of user code  for attributeExpression widgets declarations
	protected Text attributeExpressionText;
	protected NamespacedProperty attributeExpression;
	protected Control [] attributeExpressionElements;
	protected Control [] attributeNameElements;
	protected Control [] attributeValueTypeElements;
	protected Control [] attributeValueElements;
	protected Control [] attributeTypeElements;
	protected Control [] defaultValueElements;
	protected Group propertiesGroup;
	// End of user code




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
	 * generated NOT
	 */
	public void createControls(Composite view) { 
		CompositionSequence publishEventMediatorAttributeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = publishEventMediatorAttributeStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeExpression);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue);
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
				// Start of user code for attributeExpression addToPart creation
				if (key == EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeExpression) {
                    return createAttributeExpressionText(parent);
                }
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * @generated NOT
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createAttributeNameText(Composite parent) {
		Control attributeNameLabel = createDescription(parent, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName, EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_AttributeNameLabel);
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
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, attributeName.getText()));
				}
			}

		});
		EditingUtils.setID(attributeName, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName);
		EditingUtils.setEEFtype(attributeName, "eef::Text"); //$NON-NLS-1$
		Control attributeNameHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAttributeNameText
		attributeNameElements = new Control [] {attributeNameLabel, attributeName, attributeNameHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createAttributeValueTypeEMFComboViewer(Composite parent) {
		Control attributeValueTypeLabel = createDescription(parent, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType, EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_AttributeValueTypeLabel);
		attributeValueType = new EMFComboViewer(parent);
		attributeValueType.setContentProvider(new ArrayContentProvider());
		attributeValueType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData attributeValueTypeData = new GridData(GridData.FILL_HORIZONTAL);
		attributeValueType.getCombo().setLayoutData(attributeValueTypeData);
                attributeValueType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
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
		Control attributeValeTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAttributeValueTypeEMFComboViewer
        attributeValueTypeElements = new Control[] { attributeValueTypeLabel, attributeValeTypeHelp,
                attributeValueType.getCombo() };
        attributeValueType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                validate();
            }

        });
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */ 
	protected Composite createAttributeValueText(Composite parent) {
		Control attributeValueLabel = createDescription(parent, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue, EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_AttributeValueLabel);
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
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, attributeValue.getText()));
				}
			}

		});
		EditingUtils.setID(attributeValue, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue);
		EditingUtils.setEEFtype(attributeValue, "eef::Text"); //$NON-NLS-1$
		Control attributeValueHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAttributeValueText
        attributeValueElements = new Control[] { attributeValueLabel, attributeValue, attributeValueHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createAttributeTypeEMFComboViewer(Composite parent) {
		Control attributeTypeLabel = createDescription(parent, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType, EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_AttributeTypeLabel);
		attributeType = new EMFComboViewer(parent);
		attributeType.setContentProvider(new ArrayContentProvider());
		attributeType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData attributeTypeData = new GridData(GridData.FILL_HORIZONTAL);
		attributeType.getCombo().setLayoutData(attributeTypeData);
                attributeType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
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
		Control attributeTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAttributeTypeEMFComboViewer
        attributeTypeElements = new Control[] { attributeTypeLabel, attributeTypeHelp, attributeType.getCombo() };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createDefaultValueText(Composite parent) {
		Control defaultValueLabel = createDescription(parent, EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue, EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_DefaultValueLabel);
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
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValue.getText()));
				}
			}

		});
		EditingUtils.setID(defaultValue, EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue);
		EditingUtils.setEEFtype(defaultValue, "eef::Text"); //$NON-NLS-1$
		Control defaultValueHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDefaultValueText
        defaultValueElements = new Control[] { defaultValueLabel, defaultValueHelp, defaultValue };
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#getAttributeName()
	 * 
	 */
	public String getAttributeName() {
		return attributeName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#setAttributeName(String newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#getAttributeValueType()
	 * 
	 */
	public Enumerator getAttributeValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) attributeValueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#initAttributeValueType(Object input, Enumerator current)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#setAttributeValueType(Enumerator newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#getAttributeValue()
	 * 
	 */
	public String getAttributeValue() {
		return attributeValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#setAttributeValue(String newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#getAttributeType()
	 * 
	 */
	public Enumerator getAttributeType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) attributeType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#initAttributeType(Object input, Enumerator current)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#setAttributeType(Enumerator newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#getDefaultValue()
	 * 
	 */
	public String getDefaultValue() {
		return defaultValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart#setDefaultValue(String newValue)
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






	// Start of user code for attributeExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getAttributeExpression() {
        return attributeExpression;
    }

    @Override
    public void setAttributeExpression(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            attributeExpressionText.setText(nameSpacedProperty.getPropertyValue());
            attributeExpression = nameSpacedProperty;
        }
    }
	// End of user code

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
    protected Composite createAttributeExpressionText(final Composite parent) {
        Control attributeExpressionTextLabel = createDescription(parent,
                EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeExpression,
                EsbMessages.PublishEventMediatorAttributePropertiesEditionPart_AttributeExpressionLabel);
        attributeExpressionText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY); // $NON-NLS-1$
        attributeExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
        attributeExpressionText.setLayoutData(propertyValueData);
        if(attributeExpression==null) {
            attributeExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        attributeExpressionText.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            PublishEventMediatorAttributePropertiesEditionPartImpl.this,
                            EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeExpression, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getAttributeExpression()));
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this,
                                    EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeExpression,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    getAttributeExpression()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            PublishEventMediatorAttributePropertiesEditionPartImpl.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        attributeExpressionText.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(PublishEventMediatorAttributePropertiesEditionPartImpl.this,
                                        EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeExpression,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        getAttributeExpression()));
                }
            }
        });
        EditingUtils.setID(attributeExpressionText, EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeExpression);
        EditingUtils.setEEFtype(attributeExpressionText, "eef::Text"); //$NON-NLS-1$
        Control attributeExpressionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeExpression, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createPropertyValueText
        attributeExpressionElements = new Control[] { attributeExpressionTextLabel, attributeExpressionText,
                attributeExpressionHelp };// mouse
        attributeExpressionText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseDown(MouseEvent e) {
                // TODO Auto-generated method stub
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, attributeExpression);
                // valueExpression.setPropertyValue(valueExpressionText.getText());
                nspd.open();
                attributeExpressionText.setText(attributeExpression.getPropertyValue());

                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        PublishEventMediatorAttributePropertiesEditionPartImpl.this,
                        EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeExpression, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getAttributeExpression()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        return parent;
    }
        @Override
        public void refresh() {
            super.refresh();
            validate();
        }
    
        public void validate() {
            EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
            eu.clearElements(new Composite[] { propertiesGroup });
            eu.showEntry(attributeNameElements, false);
            eu.showEntry(attributeTypeElements, false);
            eu.showEntry(attributeValueTypeElements, false);
            eu.showEntry(defaultValueElements, false);

            if (getAttributeValueType().getName().equals("EXPRESSION")) {
                eu.showEntry(attributeExpressionElements, false);
            } else {
                eu.showEntry(attributeValueElements, false);
            }
            
            view.layout(true, true);
        }

	// End of user code

}
