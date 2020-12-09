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
import org.eclipse.swt.events.KeyListener;
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
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class EndPointPropertyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EndPointPropertyPropertiesEditionPart {

	protected Text name;
	protected Text value;
	protected EMFComboViewer scope;
	protected EMFComboViewer valueType;
	// Start of user code  for valueExpression widgets declarations
	protected NamespacedProperty valueExpression;
	protected Text valueExpressionText;
	
	protected Control[] valueExpressionElements;
	protected Control[] nameElements;
	protected Control[] valueElements;
	protected Control[] scopeElements;
	protected Control[] valueTypeElements;
	
	protected Group propertiesGroup;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EndPointPropertyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence endPointPropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = endPointPropertyStep.addStep(EsbViewsRepository.EndPointProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.EndPointProperty.Properties.name);
		propertiesStep.addStep(EsbViewsRepository.EndPointProperty.Properties.scope);
		propertiesStep.addStep(EsbViewsRepository.EndPointProperty.Properties.valueType);
		propertiesStep.addStep(EsbViewsRepository.EndPointProperty.Properties.value);
		propertiesStep.addStep(EsbViewsRepository.EndPointProperty.Properties.valueExpression);
		
		
		composer = new PartComposer(endPointPropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.EndPointProperty.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.EndPointProperty.Properties.name) {
					return createNameText(parent);
				}
				if (key == EsbViewsRepository.EndPointProperty.Properties.value) {
					return createValueText(parent);
				}
				if (key == EsbViewsRepository.EndPointProperty.Properties.scope) {
					return createScopeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.EndPointProperty.Properties.valueType) {
					return createValueTypeEMFComboViewer(parent);
				}
				// Start of user code for valueExpression addToPart creation
				if ( key == EsbViewsRepository.EndPointProperty.Properties.valueExpression) {
                    return createValueExpression(parent);
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
		propertiesGroup.setText(EsbMessages.EndPointPropertyPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createNameText(Composite parent) {
		Control nameLabel = createDescription(parent, EsbViewsRepository.EndPointProperty.Properties.name, EsbMessages.EndPointPropertyPropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndPointPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EndPointProperty.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndPointPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EndPointProperty.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EsbViewsRepository.EndPointProperty.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		Control nameHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EndPointProperty.Properties.name, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText
		nameElements = new Control[] {nameLabel, name, nameHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createValueText(Composite parent) {
		Control valueLabel = createDescription(parent, EsbViewsRepository.EndPointProperty.Properties.value, EsbMessages.EndPointPropertyPropertiesEditionPart_ValueLabel);
		value = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		value.setLayoutData(valueData);
		value.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndPointPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EndPointProperty.Properties.value, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, value.getText()));
			}

		});
		value.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndPointPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EndPointProperty.Properties.value, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, value.getText()));
				}
			}

		});
		EditingUtils.setID(value, EsbViewsRepository.EndPointProperty.Properties.value);
		EditingUtils.setEEFtype(value, "eef::Text"); //$NON-NLS-1$
		Control valueHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EndPointProperty.Properties.value, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueText
		valueElements = new Control[] {valueLabel, value, valueHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createScopeEMFComboViewer(Composite parent) {
		Control scopeLabel = createDescription(parent, EsbViewsRepository.EndPointProperty.Properties.scope, EsbMessages.EndPointPropertyPropertiesEditionPart_ScopeLabel);
		scope = new EMFComboViewer(parent);
		scope.setContentProvider(new ArrayContentProvider());
		scope.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData scopeData = new GridData(GridData.FILL_HORIZONTAL);
		scope.getCombo().setLayoutData(scopeData);
                scope.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		scope.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndPointPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EndPointProperty.Properties.scope, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getScope()));
			}

		});
		scope.setID(EsbViewsRepository.EndPointProperty.Properties.scope);
		Control scopeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EndPointProperty.Properties.scope, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createScopeEMFComboViewer
		scopeElements = new Control[] {scopeLabel, scope.getCombo(), scopeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createValueTypeEMFComboViewer(Composite parent) {
		Control valueTypeLabel = createDescription(parent, EsbViewsRepository.EndPointProperty.Properties.valueType, EsbMessages.EndPointPropertyPropertiesEditionPart_ValueTypeLabel);
		valueType = new EMFComboViewer(parent);
		valueType.setContentProvider(new ArrayContentProvider());
		valueType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData valueTypeData = new GridData(GridData.FILL_HORIZONTAL);
		valueType.getCombo().setLayoutData(valueTypeData);
                valueType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		valueType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			    if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndPointPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EndPointProperty.Properties.valueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
			    validate();
			}

		});
		valueType.setID(EsbViewsRepository.EndPointProperty.Properties.valueType);
		Control valueTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EndPointProperty.Properties.valueType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueTypeEMFComboViewer
		valueTypeElements = new Control[] {valueTypeLabel, valueType.getCombo(), valueTypeHelp};
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EndPointProperty.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EsbMessages.EndPointProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart#getValue()
	 * 
	 */
	public String getValue() {
		return value.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart#setValue(String newValue)
	 * 
	 */
	public void setValue(String newValue) {
		if (newValue != null) {
			value.setText(newValue);
		} else {
			value.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EndPointProperty.Properties.value);
		if (eefElementEditorReadOnlyState && value.isEnabled()) {
			value.setEnabled(false);
			value.setToolTipText(EsbMessages.EndPointProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !value.isEnabled()) {
			value.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart#getScope()
	 * 
	 */
	public Enumerator getScope() {
		Enumerator selection = (Enumerator) ((StructuredSelection) scope.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart#initScope(Object input, Enumerator current)
	 */
	public void initScope(Object input, Enumerator current) {
		scope.setInput(input);
		scope.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EndPointProperty.Properties.scope);
		if (eefElementEditorReadOnlyState && scope.isEnabled()) {
			scope.setEnabled(false);
			scope.setToolTipText(EsbMessages.EndPointProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scope.isEnabled()) {
			scope.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart#setScope(Enumerator newValue)
	 * 
	 */
	public void setScope(Enumerator newValue) {
		scope.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EndPointProperty.Properties.scope);
		if (eefElementEditorReadOnlyState && scope.isEnabled()) {
			scope.setEnabled(false);
			scope.setToolTipText(EsbMessages.EndPointProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scope.isEnabled()) {
			scope.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart#getValueType()
	 * 
	 */
	public Enumerator getValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) valueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart#initValueType(Object input, Enumerator current)
	 */
	public void initValueType(Object input, Enumerator current) {
		valueType.setInput(input);
		valueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EndPointProperty.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.EndPointProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart#setValueType(Enumerator newValue)
	 * 
	 */
	public void setValueType(Enumerator newValue) {
		valueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EndPointProperty.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.EndPointProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}






	// Start of user code for valueExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getValueExpression() {
        return valueExpression;
    }

    @Override
    public void setValueExpression(NamespacedProperty namespacedProperty) {
        if (namespacedProperty != null) {
            valueExpression = namespacedProperty;
            valueExpressionText.setText(namespacedProperty.getPropertyValue());
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
		return EsbMessages.EndPointProperty_Part_Title;
	}

	// Start of user code additional methods
	@Override
    public void refresh() {
        super.refresh();
        validate();
    }
	
	public void validate() {
	    EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { propertiesGroup });
        
        eu.showEntry(nameElements, false);
        eu.showEntry(scopeElements, false);
        eu.showEntry(valueTypeElements, false);
        if (getValueType() != null && getValueType().getName().equals(PropertyValueType.LITERAL.getName())) {
            eu.showEntry(valueElements, false);
        } else if (getValueType() != null && getValueType().getName().equals(PropertyValueType.EXPRESSION.getName())) {
            eu.showEntry(valueExpressionElements, false);
        }
        
        view.layout(true, true);
	}
	
	protected Composite createValueExpression(final Composite parent) {
        Control valueExpressionLabel = createDescription(parent, EsbViewsRepository.EndPointProperty.Properties.valueExpression,
                EsbMessages.EndPointPropertyPropertiesEditionPart_ValueExpressionLabel);

        if (valueExpression == null) {
            valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }

        valueExpressionText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        valueExpressionText.setLayoutData(valueData);
        valueExpressionText.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void mouseDown(MouseEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, valueExpression);
                nspd.open();
                valueExpressionText.setText(valueExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndPointPropertyPropertiesEditionPartImpl.this, 
                        EsbViewsRepository.EndPointProperty.Properties.valueExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                        null, getValueExpression()));
            }
            
            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        
        valueExpressionText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, valueExpression);
                nspd.open();
                valueExpressionText.setText(valueExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(
                        new PropertiesEditionEvent(EndPointPropertyPropertiesEditionPartImpl.this,
                                EsbViewsRepository.EndPointProperty.Properties.valueExpression,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueExpression()));
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });

        EditingUtils.setID(valueExpressionText, EsbViewsRepository.EndPointProperty.Properties.valueExpression);
        EditingUtils.setEEFtype(valueExpressionText, "eef::Text");
        Control valueExpressionHelp = SWTUtils
                .createHelpButton(parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.EndPointProperty.Properties.valueExpression, EsbViewsRepository.FORM_KIND),
                        null);
        valueExpressionElements = new Control[] { valueExpressionLabel, valueExpressionText, valueExpressionHelp };
        return parent;
    }

	
	// End of user code


}
