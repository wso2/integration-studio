/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

import java.util.ArrayList;

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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
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
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheType;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.XQueryVariableValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms.CacheMediatorPropertiesEditionPartForm;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms.HeaderMediatorPropertiesEditionPartForm;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class XQueryVariablePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, XQueryVariablePropertiesEditionPart {

	protected Text variableName;
	protected EMFComboViewer variableType;
	protected EMFComboViewer valueType;
	protected Text valueLiteral;
	// Start of user code  for valueExpression widgets declarations
	protected NamespacedProperty valueExpression;
	
	protected Text valueExpressionText;
	// End of user code

	// Start of user code  for valueKey widgets declarations
	protected RegistryKeyProperty valueKey;
	
	protected Text valueKeyText;
	
	protected Group propertiesGroup;
	
	protected Control[] variableNameElements;
	protected Control[] variableTypeElements;
	protected Control[] valueTypeElements;
	protected Control[] valueLiteralElements;
	protected Control[] valueKeyElements;
	protected Control[] valueExpressionElements;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public XQueryVariablePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence xQueryVariableStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = xQueryVariableStep.addStep(EsbViewsRepository.XQueryVariable.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.variableName);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.variableType);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.valueType);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.valueLiteral);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.valueExpression);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.valueKey);
		
		
		composer = new PartComposer(xQueryVariableStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.XQueryVariable.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.XQueryVariable.Properties.variableName) {
					return createVariableNameText(parent);
				}
				if (key == EsbViewsRepository.XQueryVariable.Properties.variableType) {
					return createVariableTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.XQueryVariable.Properties.valueType) {
					return createValueTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.XQueryVariable.Properties.valueLiteral) {
					return createValueLiteralText(parent);
				}
				// Start of user code for valueExpression addToPart creation
				if (key == EsbViewsRepository.XQueryVariable.Properties.valueExpression) {
                    return createValueExpression(parent);
                }
				// End of user code
				// Start of user code for valueKey addToPart creation
				if (key == EsbViewsRepository.XQueryVariable.Properties.valueKey) {
                    return createValueKey(parent);
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
		propertiesGroup.setText(EsbMessages.XQueryVariablePropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createVariableNameText(Composite parent) {
		Control variableNameLabel = createDescription(parent, EsbViewsRepository.XQueryVariable.Properties.variableName, EsbMessages.XQueryVariablePropertiesEditionPart_VariableNameLabel);
		variableName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData variableNameData = new GridData(GridData.FILL_HORIZONTAL);
		variableName.setLayoutData(variableNameData);
		variableName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartImpl.this, EsbViewsRepository.XQueryVariable.Properties.variableName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, variableName.getText()));
			}

		});
		variableName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartImpl.this, EsbViewsRepository.XQueryVariable.Properties.variableName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, variableName.getText()));
				}
			}

		});
		EditingUtils.setID(variableName, EsbViewsRepository.XQueryVariable.Properties.variableName);
		EditingUtils.setEEFtype(variableName, "eef::Text"); //$NON-NLS-1$
		Control variableNameHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryVariable.Properties.variableName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createVariableNameText
		variableNameElements = new Control[] {variableNameLabel, variableName, variableNameHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createVariableTypeEMFComboViewer(Composite parent) {
		Control variableTypeLabel = createDescription(parent, EsbViewsRepository.XQueryVariable.Properties.variableType, EsbMessages.XQueryVariablePropertiesEditionPart_VariableTypeLabel);
		variableType = new EMFComboViewer(parent);
		variableType.setContentProvider(new ArrayContentProvider());
		variableType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData variableTypeData = new GridData(GridData.FILL_HORIZONTAL);
		variableType.getCombo().setLayoutData(variableTypeData);
                variableType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		variableType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartImpl.this, EsbViewsRepository.XQueryVariable.Properties.variableType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVariableType()));
			}

		});
		variableType.setID(EsbViewsRepository.XQueryVariable.Properties.variableType);
		Control variableTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryVariable.Properties.variableType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createVariableTypeEMFComboViewer
		variableTypeElements = new Control[] {variableTypeLabel, variableType.getCombo(), variableTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createValueTypeEMFComboViewer(Composite parent) {
		Control valueTypeLabel = createDescription(parent, EsbViewsRepository.XQueryVariable.Properties.valueType, EsbMessages.XQueryVariablePropertiesEditionPart_ValueTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartImpl.this, EsbViewsRepository.XQueryVariable.Properties.valueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
				validate();
			}

		});
		valueType.setID(EsbViewsRepository.XQueryVariable.Properties.valueType);
		Control valueTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryVariable.Properties.valueType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueTypeEMFComboViewer
		valueTypeElements = new Control[] {valueTypeLabel, valueType.getCombo(), valueTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createValueLiteralText(Composite parent) {
		Control valueLiteralLabel = createDescription(parent, EsbViewsRepository.XQueryVariable.Properties.valueLiteral, EsbMessages.XQueryVariablePropertiesEditionPart_ValueLiteralLabel);
		valueLiteral = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData valueLiteralData = new GridData(GridData.FILL_HORIZONTAL);
		valueLiteral.setLayoutData(valueLiteralData);
		valueLiteral.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartImpl.this, EsbViewsRepository.XQueryVariable.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
			}

		});
		valueLiteral.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartImpl.this, EsbViewsRepository.XQueryVariable.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
				}
			}

		});
		EditingUtils.setID(valueLiteral, EsbViewsRepository.XQueryVariable.Properties.valueLiteral);
		EditingUtils.setEEFtype(valueLiteral, "eef::Text"); //$NON-NLS-1$
		Control valueLiteralHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryVariable.Properties.valueLiteral, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueLiteralText
		valueLiteralElements = new Control[] {valueLiteralLabel, valueLiteral, valueLiteralHelp};
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#getVariableName()
	 * 
	 */
	public String getVariableName() {
		return variableName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#setVariableName(String newValue)
	 * 
	 */
	public void setVariableName(String newValue) {
		if (newValue != null) {
			variableName.setText(newValue);
		} else {
			variableName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.variableName);
		if (eefElementEditorReadOnlyState && variableName.isEnabled()) {
			variableName.setEnabled(false);
			variableName.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !variableName.isEnabled()) {
			variableName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#getVariableType()
	 * 
	 */
	public Enumerator getVariableType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) variableType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#initVariableType(Object input, Enumerator current)
	 */
	public void initVariableType(Object input, Enumerator current) {
		variableType.setInput(input);
		variableType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.variableType);
		if (eefElementEditorReadOnlyState && variableType.isEnabled()) {
			variableType.setEnabled(false);
			variableType.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !variableType.isEnabled()) {
			variableType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#setVariableType(Enumerator newValue)
	 * 
	 */
	public void setVariableType(Enumerator newValue) {
		variableType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.variableType);
		if (eefElementEditorReadOnlyState && variableType.isEnabled()) {
			variableType.setEnabled(false);
			variableType.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !variableType.isEnabled()) {
			variableType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#getValueType()
	 * 
	 */
	public Enumerator getValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) valueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#initValueType(Object input, Enumerator current)
	 */
	public void initValueType(Object input, Enumerator current) {
		valueType.setInput(input);
		valueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#setValueType(Enumerator newValue)
	 * 
	 */
	public void setValueType(Enumerator newValue) {
		valueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#getValueLiteral()
	 * 
	 */
	public String getValueLiteral() {
		return valueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#setValueLiteral(String newValue)
	 * 
	 */
	public void setValueLiteral(String newValue) {
		if (newValue != null) {
			valueLiteral.setText(newValue);
		} else {
			valueLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.valueLiteral);
		if (eefElementEditorReadOnlyState && valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(false);
			valueLiteral.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(true);
		}	
		
	}






	// Start of user code for valueExpression specific getters and setters implementation
    @Override
    public void setValueExpression(NamespacedProperty namespacedProperty) {
        if (namespacedProperty != null) {
            valueExpression = namespacedProperty;
            valueExpressionText.setText(namespacedProperty.getPropertyValue());
        }
    }

    @Override
    public NamespacedProperty getValueExpression() {
        return valueExpression;
    }
	// End of user code

	// Start of user code for valueKey specific getters and setters implementation
    @Override
    public void setValueKey(RegistryKeyProperty registryKeyProperty) {
        if (valueKey != null) {
            valueKey = registryKeyProperty;
            valueKeyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getValueKey() {
        return valueKey;
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.XQueryVariable_Part_Title;
	}





	// Start of user code additional methods
	protected Composite createValueKey(final Composite parent) {
        Control valueKeyLabel = createDescription(parent, EsbViewsRepository.XQueryVariable.Properties.valueKey,
                EsbMessages.XQueryVariablePropertiesEditionPart_ValueKeyLabel);

        if (valueKey == null) {
            valueKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        valueKeyText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        valueKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        valueKeyText.setLayoutData(valueData);
        valueKeyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, valueKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                valueKeyText.setText(valueKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartImpl.this,
                                EsbViewsRepository.XQueryVariable.Properties.valueKey, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getValueKey()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        EditingUtils.setID(valueKeyText, EsbViewsRepository.XQueryVariable.Properties.valueKey);
        EditingUtils.setEEFtype(valueKeyText, "eef::Text");
        Control valueKeyHelp = SWTUtils.createHelpButton(parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.XQueryVariable.Properties.valueKey, EsbViewsRepository.FORM_KIND),
                        null);
        valueKeyElements = new Control[] { valueKeyLabel, valueKeyText, valueKeyHelp };
        return parent;
    }

	protected Composite createValueExpression(final Composite parent) {
        Control valueExpressionLabel = createDescription(parent, EsbViewsRepository.XQueryVariable.Properties.valueExpression,
                EsbMessages.XQueryVariablePropertiesEditionPart_ValueExpressionLabel);
        if (valueExpression == null) {
            valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initHeaderName = valueExpression.getPropertyValue().isEmpty() ? "" : valueExpression.getPropertyValue();
        valueExpressionText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        valueExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        
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
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartImpl.this,
                        EsbViewsRepository.XQueryVariable.Properties.valueExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueExpression()));
            }
            
            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        EditingUtils.setID(valueExpressionText, EsbViewsRepository.XQueryVariable.Properties.valueExpression);
        EditingUtils.setEEFtype(valueExpressionText, "eef::Text");
        Control valueExpressionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryVariable.Properties.valueExpression,
                EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        valueExpressionElements = new Control[] {valueExpressionLabel, valueExpressionText, valueExpressionHelp};
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
        
        eu.showEntry(variableNameElements, false);
        eu.showEntry(variableTypeElements, false);
        eu.showEntry(valueTypeElements, false);
        
        if (getValueType() != null && getValueType().getName().equals(XQueryVariableValueType.LITERAL.getName())) {
            eu.showEntry(valueLiteralElements, false);
            
        } else if (getValueType() != null && getValueType().getName().equals(XQueryVariableValueType.EXPRESSION.getName())) {
            eu.showEntry(valueExpressionElements, false);
        }
        
        eu.showEntry(valueKeyElements, false);
        view.layout(true, true);
    }
	// End of user code


}
