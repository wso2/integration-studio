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
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
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
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTPropertyPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class XSLTPropertyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, XSLTPropertyPropertiesEditionPart {

	protected Text propertyName;
	protected EMFComboViewer propertyValueType;
	protected Text propertyValue;
	// Start of user code  for propertyExpression widgets declarations
    protected NamespacedProperty propertyExpression;
    protected Text propertyExpressionText;
    protected Control [] propertyExpressionElements;
    protected Control [] propertyNameElements;
    protected Control [] properyValueElements;
    protected Control [] propertyValueTypeElements;
    protected Group propertiesGroup;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public XSLTPropertyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence xSLTPropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = xSLTPropertyStep.addStep(EsbViewsRepository.XSLTProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.XSLTProperty.Properties.propertyName);
		propertiesStep.addStep(EsbViewsRepository.XSLTProperty.Properties.propertyValueType);
		propertiesStep.addStep(EsbViewsRepository.XSLTProperty.Properties.propertyValue);
		propertiesStep.addStep(EsbViewsRepository.XSLTProperty.Properties.propertyExpression);
		
		
		composer = new PartComposer(xSLTPropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.XSLTProperty.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.XSLTProperty.Properties.propertyName) {
					return createPropertyNameText(parent);
				}
				if (key == EsbViewsRepository.XSLTProperty.Properties.propertyValueType) {
					return createPropertyValueTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.XSLTProperty.Properties.propertyValue) {
					return createPropertyValueText(parent);
				}
				// Start of user code for propertyExpression addToPart creation
				if (key == EsbViewsRepository.XSLTProperty.Properties.propertyExpression) {
                    return createPropertyExpressionText(parent);
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
		propertiesGroup.setText(EsbMessages.XSLTPropertyPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createPropertyNameText(Composite parent) {
		Control propertyNameLabel = createDescription(parent, EsbViewsRepository.XSLTProperty.Properties.propertyName, EsbMessages.XSLTPropertyPropertiesEditionPart_PropertyNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
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
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
				}
			}

		});
		EditingUtils.setID(propertyName, EsbViewsRepository.XSLTProperty.Properties.propertyName);
		EditingUtils.setEEFtype(propertyName, "eef::Text"); //$NON-NLS-1$
		Control propertyNameHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTProperty.Properties.propertyName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyNameText
		propertyNameElements = new Control [] {propertyNameLabel, propertyName, propertyNameHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPropertyValueTypeEMFComboViewer(Composite parent) {
		Control propertyValueTypeLabel = createDescription(parent, EsbViewsRepository.XSLTProperty.Properties.propertyValueType, EsbMessages.XSLTPropertyPropertiesEditionPart_PropertyValueTypeLabel);
		propertyValueType = new EMFComboViewer(parent);
		propertyValueType.setContentProvider(new ArrayContentProvider());
		propertyValueType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyValueTypeData = new GridData(GridData.FILL_HORIZONTAL);
		propertyValueType.getCombo().setLayoutData(propertyValueTypeData);
                propertyValueType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		propertyValueType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTProperty.Properties.propertyValueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyValueType()));
			}

		});
		propertyValueType.setID(EsbViewsRepository.XSLTProperty.Properties.propertyValueType);
		Control propertyValueTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTProperty.Properties.propertyValueType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyValueTypeEMFComboViewer
		propertyValueType.addSelectionChangedListener(new ISelectionChangedListener() {

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
		propertyValueTypeElements = new Control [] {propertyValueTypeLabel, propertyValueType.getCombo(), propertyValueTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPropertyValueText(Composite parent) {
		Control properyValueTextLabel = createDescription(parent, EsbViewsRepository.XSLTProperty.Properties.propertyValue, EsbMessages.XSLTPropertyPropertiesEditionPart_PropertyValueLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
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
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
				}
			}

		});
		EditingUtils.setID(propertyValue, EsbViewsRepository.XSLTProperty.Properties.propertyValue);
		EditingUtils.setEEFtype(propertyValue, "eef::Text"); //$NON-NLS-1$
		Control propertyTextHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTProperty.Properties.propertyValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyValueText
		properyValueElements = new Control [] {properyValueTextLabel, propertyValue, propertyTextHelp};
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTPropertyPropertiesEditionPart#getPropertyName()
	 * 
	 */
	public String getPropertyName() {
		return propertyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTPropertyPropertiesEditionPart#setPropertyName(String newValue)
	 * 
	 */
	public void setPropertyName(String newValue) {
		if (newValue != null) {
			propertyName.setText(newValue);
		} else {
			propertyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTProperty.Properties.propertyName);
		if (eefElementEditorReadOnlyState && propertyName.isEnabled()) {
			propertyName.setEnabled(false);
			propertyName.setToolTipText(EsbMessages.XSLTProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyName.isEnabled()) {
			propertyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTPropertyPropertiesEditionPart#getPropertyValueType()
	 * 
	 */
	public Enumerator getPropertyValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyValueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTPropertyPropertiesEditionPart#initPropertyValueType(Object input, Enumerator current)
	 */
	public void initPropertyValueType(Object input, Enumerator current) {
		propertyValueType.setInput(input);
		propertyValueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTProperty.Properties.propertyValueType);
		if (eefElementEditorReadOnlyState && propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(false);
			propertyValueType.setToolTipText(EsbMessages.XSLTProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTPropertyPropertiesEditionPart#setPropertyValueType(Enumerator newValue)
	 * 
	 */
	public void setPropertyValueType(Enumerator newValue) {
		propertyValueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTProperty.Properties.propertyValueType);
		if (eefElementEditorReadOnlyState && propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(false);
			propertyValueType.setToolTipText(EsbMessages.XSLTProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTPropertyPropertiesEditionPart#getPropertyValue()
	 * 
	 */
	public String getPropertyValue() {
		return propertyValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTPropertyPropertiesEditionPart#setPropertyValue(String newValue)
	 * 
	 */
	public void setPropertyValue(String newValue) {
		if (newValue != null) {
			propertyValue.setText(newValue);
		} else {
			propertyValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTProperty.Properties.propertyValue);
		if (eefElementEditorReadOnlyState && propertyValue.isEnabled()) {
			propertyValue.setEnabled(false);
			propertyValue.setToolTipText(EsbMessages.XSLTProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValue.isEnabled()) {
			propertyValue.setEnabled(true);
		}	
		
	}






	// Start of user code for propertyExpression specific getters and setters implementation
	   @Override
	    public NamespacedProperty getExpressionValue() {
	        return propertyExpression;
	    }

	    @Override
	    public void setExpressionValue(NamespacedProperty nameSpacedProperty) {
	        if (nameSpacedProperty != null) {
	            propertyExpressionText.setText(nameSpacedProperty.getPropertyValue());
	            propertyExpression = nameSpacedProperty;
	        }
	    }
	    // 
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.XSLTProperty_Part_Title;
	}

	// Start of user code additional methods
	/**
     * @generated NOT
     */
    protected Composite createPropertyExpressionText(final Composite parent) {
        Control propertyExpressionTextLabel = createDescription(parent,
                EsbViewsRepository.XSLTProperty.Properties.propertyExpression,
                EsbMessages.XSLTPropertyPropertiesEditionPart_PropertyExpressionLabel);
        propertyExpressionText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY); // $NON-NLS-1$
        propertyExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
        propertyExpressionText.setLayoutData(propertyValueData);
        if(propertyExpression==null) {
            propertyExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        propertyExpressionText.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            XSLTPropertyPropertiesEditionPartImpl.this,
                            EsbViewsRepository.XSLTProperty.Properties.propertyExpression, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getExpressionValue()));
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(XSLTPropertyPropertiesEditionPartImpl.this,
                                    EsbViewsRepository.XSLTProperty.Properties.propertyExpression,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    getExpressionValue()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            XSLTPropertyPropertiesEditionPartImpl.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        propertyExpressionText.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, propertyExpression);
                    // valueExpression.setPropertyValue(valueExpressionText.getText());
                    nspd.open();
                    propertyExpressionText.setText(propertyExpression.getPropertyValue());

                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            XSLTPropertyPropertiesEditionPartImpl.this,
                            EsbViewsRepository.XSLTProperty.Properties.propertyExpression,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getExpressionValue()));
                }
            }
        });
        EditingUtils.setID(propertyExpressionText, EsbViewsRepository.XSLTProperty.Properties.propertyExpression);
        EditingUtils.setEEFtype(propertyExpressionText, "eef::Text"); //$NON-NLS-1$
        Control propertyExpressionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.XSLTProperty.Properties.propertyExpression, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createPropertyValueText
        propertyExpressionElements = new Control[] { propertyExpressionTextLabel, propertyExpressionText,
                propertyExpressionHelp };// mouse
        propertyExpressionText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, propertyExpression);
                // valueExpression.setPropertyValue(valueExpressionText.getText());
                nspd.open();
                propertyExpressionText.setText(propertyExpression.getPropertyValue());

                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        XSLTPropertyPropertiesEditionPartImpl.this,
                        EsbViewsRepository.XSLTProperty.Properties.propertyExpression, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getExpressionValue()));
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
            eu.showEntry(propertyValueTypeElements, false);
            eu.showEntry(propertyNameElements, false);
            if (getPropertyValueType().getName().equals("EXPRESSION")) {
                eu.showEntry(propertyExpressionElements, false);
            } else {
                eu.showEntry(properyValueElements, false);
            }
            
            view.layout(true, true);
        }

        // End of user code


}
