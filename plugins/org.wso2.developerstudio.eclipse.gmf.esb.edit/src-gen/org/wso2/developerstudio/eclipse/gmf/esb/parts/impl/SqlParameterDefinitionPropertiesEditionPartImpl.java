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
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlParameterDefinitionPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class SqlParameterDefinitionPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SqlParameterDefinitionPropertiesEditionPart {

	protected EMFComboViewer dataType;
	protected EMFComboViewer valueType;
	protected Text valueLiteral;
	// Start of user code  for valueExpression widgets declarations
	protected NamespacedProperty valueExpression;
	protected Text valueExpressionText;
	
	protected Control[] valueExpressionElements;
	protected Control[] dbTypeElements;
	protected Control[] valueTypeElements;
	protected Control[] valueLiteralElements;
	
	protected Group propertiesGroup;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SqlParameterDefinitionPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence sqlParameterDefinitionStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = sqlParameterDefinitionStep.addStep(EsbViewsRepository.SqlParameterDefinition.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.SqlParameterDefinition.Properties.dataType);
		propertiesStep.addStep(EsbViewsRepository.SqlParameterDefinition.Properties.valueType);
		propertiesStep.addStep(EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral);
		propertiesStep.addStep(EsbViewsRepository.SqlParameterDefinition.Properties.valueExpression);
		
		
		composer = new PartComposer(sqlParameterDefinitionStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.SqlParameterDefinition.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.SqlParameterDefinition.Properties.dataType) {
					return createDataTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.SqlParameterDefinition.Properties.valueType) {
					return createValueTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral) {
					return createValueLiteralText(parent);
				}
				// Start of user code for valueExpression addToPart creation
				if (key == EsbViewsRepository.SqlParameterDefinition.Properties.valueExpression) {
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
		propertiesGroup.setText(EsbMessages.SqlParameterDefinitionPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createDataTypeEMFComboViewer(Composite parent) {
		Control dataTypeLabel = createDescription(parent, EsbViewsRepository.SqlParameterDefinition.Properties.dataType, EsbMessages.SqlParameterDefinitionPropertiesEditionPart_DataTypeLabel);
		dataType = new EMFComboViewer(parent);
		dataType.setContentProvider(new ArrayContentProvider());
		dataType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData dataTypeData = new GridData(GridData.FILL_HORIZONTAL);
		dataType.getCombo().setLayoutData(dataTypeData);
                dataType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		dataType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlParameterDefinitionPropertiesEditionPartImpl.this, EsbViewsRepository.SqlParameterDefinition.Properties.dataType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDataType()));
			}

		});
		dataType.setID(EsbViewsRepository.SqlParameterDefinition.Properties.dataType);
		Control dataTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SqlParameterDefinition.Properties.dataType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDataTypeEMFComboViewer
		dbTypeElements = new Control[] {dataTypeLabel, dataType.getCombo(), dataTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createValueTypeEMFComboViewer(Composite parent) {
		Control valueTypeLabel = createDescription(parent, EsbViewsRepository.SqlParameterDefinition.Properties.valueType, EsbMessages.SqlParameterDefinitionPropertiesEditionPart_ValueTypeLabel);
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
			    validate();
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlParameterDefinitionPropertiesEditionPartImpl.this, EsbViewsRepository.SqlParameterDefinition.Properties.valueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
			}

		});
		valueType.setID(EsbViewsRepository.SqlParameterDefinition.Properties.valueType);
		Control valueTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SqlParameterDefinition.Properties.valueType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueTypeEMFComboViewer
		valueTypeElements = new Control[] {valueTypeLabel, valueType.getCombo(), valueTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createValueLiteralText(Composite parent) {
		Control valueLiteralLabel = createDescription(parent, EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral, EsbMessages.SqlParameterDefinitionPropertiesEditionPart_ValueLiteralLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlParameterDefinitionPropertiesEditionPartImpl.this, EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
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
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlParameterDefinitionPropertiesEditionPartImpl.this, EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
				}
			}

		});
		EditingUtils.setID(valueLiteral, EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral);
		EditingUtils.setEEFtype(valueLiteral, "eef::Text"); //$NON-NLS-1$
		Control valueLiteralHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlParameterDefinitionPropertiesEditionPart#getDataType()
	 * 
	 */
	public Enumerator getDataType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) dataType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlParameterDefinitionPropertiesEditionPart#initDataType(Object input, Enumerator current)
	 */
	public void initDataType(Object input, Enumerator current) {
		dataType.setInput(input);
		dataType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SqlParameterDefinition.Properties.dataType);
		if (eefElementEditorReadOnlyState && dataType.isEnabled()) {
			dataType.setEnabled(false);
			dataType.setToolTipText(EsbMessages.SqlParameterDefinition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dataType.isEnabled()) {
			dataType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlParameterDefinitionPropertiesEditionPart#setDataType(Enumerator newValue)
	 * 
	 */
	public void setDataType(Enumerator newValue) {
		dataType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SqlParameterDefinition.Properties.dataType);
		if (eefElementEditorReadOnlyState && dataType.isEnabled()) {
			dataType.setEnabled(false);
			dataType.setToolTipText(EsbMessages.SqlParameterDefinition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dataType.isEnabled()) {
			dataType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlParameterDefinitionPropertiesEditionPart#getValueType()
	 * 
	 */
	public Enumerator getValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) valueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlParameterDefinitionPropertiesEditionPart#initValueType(Object input, Enumerator current)
	 */
	public void initValueType(Object input, Enumerator current) {
		valueType.setInput(input);
		valueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SqlParameterDefinition.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.SqlParameterDefinition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlParameterDefinitionPropertiesEditionPart#setValueType(Enumerator newValue)
	 * 
	 */
	public void setValueType(Enumerator newValue) {
		valueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SqlParameterDefinition.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.SqlParameterDefinition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlParameterDefinitionPropertiesEditionPart#getValueLiteral()
	 * 
	 */
	public String getValueLiteral() {
		return valueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlParameterDefinitionPropertiesEditionPart#setValueLiteral(String newValue)
	 * 
	 */
	public void setValueLiteral(String newValue) {
		if (newValue != null) {
			valueLiteral.setText(newValue);
		} else {
			valueLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral);
		if (eefElementEditorReadOnlyState && valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(false);
			valueLiteral.setToolTipText(EsbMessages.SqlParameterDefinition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(true);
		}	
		
	}






	// Start of user code for valueExpression specific getters and setters implementation
    @Override
    public void setValueExpression(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
            valueExpressionText.setText(nameSpacedProperty.getPropertyValue());
            valueExpression = nameSpacedProperty;
        }
    }

    @Override
    public NamespacedProperty getValueExpression() {
        return valueExpression;
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.SqlParameterDefinition_Part_Title;
	}

	// Start of user code additional methods
	
	protected Composite createValueExpression(final Composite parent) {
        Control valueExpressionLabel = createDescription(parent, EsbViewsRepository.SqlParameterDefinition.Properties.valueExpression, EsbMessages.SqlParameterDefinitionPropertiesEditionPart_ValueExpressionLabel);
        if(valueExpression == null) {
            valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        valueExpressionText = SWTUtils.createScrollableText(parent, SWT.BORDER);
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
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlParameterDefinitionPropertiesEditionPartImpl.this, EsbViewsRepository.SqlParameterDefinition.Properties.valueExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueExpression()));
           
            }
            
            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        EditingUtils.setID(valueExpressionText, EsbViewsRepository.SqlParameterDefinition.Properties.valueExpression);
        EditingUtils.setEEFtype(valueExpressionText, "eef::Text");
        Control valueExpressionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SqlParameterDefinition.Properties.valueExpression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        valueExpressionElements = new Control[] {valueExpressionLabel, valueExpressionText, valueExpressionHelp};
        return parent;
    }
	
	public void validate() {
	    EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { propertiesGroup });
        
        eu.showEntry(dbTypeElements, false);
        eu.showEntry(valueTypeElements, false);
        
        if (getValueType() != null && getValueType().getName().equals(SqlParameterValueType.LITERAL.getName())) {
            eu.showEntry(valueLiteralElements, false);

        } else if (getValueType() != null && getValueType().getName().equals(SqlParameterValueType.EXPRESSION.getName())) {
            eu.showEntry(valueExpressionElements, false);
        }
        view.layout(true, true);
	}
	
	// End of user code


}
