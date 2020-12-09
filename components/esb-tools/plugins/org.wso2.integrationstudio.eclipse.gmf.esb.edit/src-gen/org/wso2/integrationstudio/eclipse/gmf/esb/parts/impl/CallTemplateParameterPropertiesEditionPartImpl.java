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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CallTemplateParameterPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CallTemplateParameterPropertiesEditionPart {

	protected Text parameterName;
	protected EMFComboViewer templateParameterType;
	protected Text parameterValue;
	// Start of user code  for parameterExpression widgets declarations
    protected NamespacedProperty parameterExpression;
    protected Text parameterExpressionText;
    protected Control[] parameterValueElements;
    protected Control[] parameterExpressionElements;
    protected Control[] parameterTypeElements;
    protected Control[] parameterNameElements;
    protected Group propertiesGroup;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CallTemplateParameterPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence callTemplateParameterStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = callTemplateParameterStep.addStep(EsbViewsRepository.CallTemplateParameter.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateParameter.Properties.parameterName);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateParameter.Properties.parameterValue);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateParameter.Properties.parameterExpression);
		
		
		composer = new PartComposer(callTemplateParameterStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CallTemplateParameter.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.CallTemplateParameter.Properties.parameterName) {
					return createParameterNameText(parent);
				}
				if (key == EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType) {
					return createTemplateParameterTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CallTemplateParameter.Properties.parameterValue) {
					return createParameterValueText(parent);
				}
				// Start of user code for parameterExpression addToPart creation
                if (key == EsbViewsRepository.CallTemplateParameter.Properties.parameterExpression) {
                    return createParameterExpressionWidget(parent);
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
		propertiesGroup.setText(EsbMessages.CallTemplateParameterPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createParameterNameText(Composite parent) {
		Control parameterNameLabel = createDescription(parent, EsbViewsRepository.CallTemplateParameter.Properties.parameterName, EsbMessages.CallTemplateParameterPropertiesEditionPart_ParameterNameLabel);
		parameterName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData parameterNameData = new GridData(GridData.FILL_HORIZONTAL);
		parameterName.setLayoutData(parameterNameData);
		parameterName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateParameterPropertiesEditionPartImpl.this, EsbViewsRepository.CallTemplateParameter.Properties.parameterName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterName.getText()));
			}

		});
		parameterName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateParameterPropertiesEditionPartImpl.this, EsbViewsRepository.CallTemplateParameter.Properties.parameterName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterName.getText()));
				}
			}

		});
		EditingUtils.setID(parameterName, EsbViewsRepository.CallTemplateParameter.Properties.parameterName);
		EditingUtils.setEEFtype(parameterName, "eef::Text"); //$NON-NLS-1$
		Control parameterNameHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallTemplateParameter.Properties.parameterName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createParameterNameText
		parameterNameElements = new Control[] {parameterNameLabel, parameterName, parameterNameHelp};        
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createTemplateParameterTypeEMFComboViewer(Composite parent) {
		Control parameterTypeLabel = createDescription(parent, EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType, EsbMessages.CallTemplateParameterPropertiesEditionPart_TemplateParameterTypeLabel);
		templateParameterType = new EMFComboViewer(parent);
		templateParameterType.setContentProvider(new ArrayContentProvider());
		templateParameterType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData templateParameterTypeData = new GridData(GridData.FILL_HORIZONTAL);
		templateParameterType.getCombo().setLayoutData(templateParameterTypeData);
                templateParameterType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		templateParameterType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateParameterPropertiesEditionPartImpl.this, EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTemplateParameterType()));
			}

		});
		templateParameterType.setID(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType);
		Control parameterTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTemplateParameterTypeEMFComboViewer
		parameterTypeElements = new Control[] {parameterTypeLabel, templateParameterType.getCombo(), parameterTypeHelp};        
		templateParameterType.addSelectionChangedListener(new ISelectionChangedListener() {
	            
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
	protected Composite createParameterValueText(Composite parent) {
		Control parameterValueLabel = createDescription(parent, EsbViewsRepository.CallTemplateParameter.Properties.parameterValue, EsbMessages.CallTemplateParameterPropertiesEditionPart_ParameterValueLabel);
		parameterValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData parameterValueData = new GridData(GridData.FILL_HORIZONTAL);
		parameterValue.setLayoutData(parameterValueData);
		parameterValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateParameterPropertiesEditionPartImpl.this, EsbViewsRepository.CallTemplateParameter.Properties.parameterValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterValue.getText()));
			}

		});
		parameterValue.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				
			}
			
			@Override
                        public void keyReleased(KeyEvent e) {
                            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                    CallTemplateParameterPropertiesEditionPartImpl.this,
                                    EsbViewsRepository.CallTemplateParameter.Properties.parameterValue,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterValue.getText()));
                        }

		});
		EditingUtils.setID(parameterValue, EsbViewsRepository.CallTemplateParameter.Properties.parameterValue);
		EditingUtils.setEEFtype(parameterValue, "eef::Text"); //$NON-NLS-1$
		Control parameterValueHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallTemplateParameter.Properties.parameterValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createParameterValueText
		parameterValueElements = new Control[] {parameterValueLabel, parameterValue, parameterValueHelp};
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#getParameterName()
	 * 
	 */
	public String getParameterName() {
		return parameterName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#setParameterName(String newValue)
	 * 
	 */
	public void setParameterName(String newValue) {
		if (newValue != null) {
			parameterName.setText(newValue);
		} else {
			parameterName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateParameter.Properties.parameterName);
		if (eefElementEditorReadOnlyState && parameterName.isEnabled()) {
			parameterName.setEnabled(false);
			parameterName.setToolTipText(EsbMessages.CallTemplateParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterName.isEnabled()) {
			parameterName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#getTemplateParameterType()
	 * 
	 */
	public Enumerator getTemplateParameterType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) templateParameterType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#initTemplateParameterType(Object input, Enumerator current)
	 */
	public void initTemplateParameterType(Object input, Enumerator current) {
		templateParameterType.setInput(input);
		templateParameterType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType);
		if (eefElementEditorReadOnlyState && templateParameterType.isEnabled()) {
			templateParameterType.setEnabled(false);
			templateParameterType.setToolTipText(EsbMessages.CallTemplateParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !templateParameterType.isEnabled()) {
			templateParameterType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#setTemplateParameterType(Enumerator newValue)
	 * 
	 */
	public void setTemplateParameterType(Enumerator newValue) {
		templateParameterType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType);
		if (eefElementEditorReadOnlyState && templateParameterType.isEnabled()) {
			templateParameterType.setEnabled(false);
			templateParameterType.setToolTipText(EsbMessages.CallTemplateParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !templateParameterType.isEnabled()) {
			templateParameterType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#getParameterValue()
	 * 
	 */
	public String getParameterValue() {
		return parameterValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#setParameterValue(String newValue)
	 * 
	 */
	public void setParameterValue(String newValue) {
		if (newValue != null) {
			parameterValue.setText(newValue);
		} else {
			parameterValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateParameter.Properties.parameterValue);
		if (eefElementEditorReadOnlyState && parameterValue.isEnabled()) {
			parameterValue.setEnabled(false);
			parameterValue.setToolTipText(EsbMessages.CallTemplateParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterValue.isEnabled()) {
			parameterValue.setEnabled(true);
		}	
		
	}






	// Start of user code for parameterExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getParameterExpression() {
        return parameterExpression;
    }

    @Override
    public void setParameterExpression(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
            parameterExpressionText.setText(nameSpacedProperty.getPropertyValue());
            parameterExpression = nameSpacedProperty;
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
		return EsbMessages.CallTemplateParameter_Part_Title;
	}



	// Start of user code additional methods
	protected Composite createParameterExpressionWidget(final Composite parent) {
        Control parameterExpressionLabel = createDescription(parent, EsbViewsRepository.CallTemplateParameter.Properties.parameterExpression, EsbMessages.CallTemplateParameterPropertiesEditionPart_ParameterExpressionLabel);
        parameterExpressionText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        GridData parameterExpressionData = new GridData(GridData.FILL_HORIZONTAL);
        parameterExpressionText.setLayoutData(parameterExpressionData);
	    if(parameterExpression == null) {
	        parameterExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = parameterExpression.getPropertyValue().isEmpty() ? "/default/expression" : parameterExpression.getPropertyValue();
        parameterExpressionText.setText(initValueExpression);
        parameterExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        parameterExpressionText.addMouseListener(new MouseListener(){

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, parameterExpression);
                nspd.open();
                parameterExpressionText.setText(parameterExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateParameterPropertiesEditionPartImpl.this, EsbViewsRepository.CallTemplateParameter.Properties.parameterExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getParameterExpression()));

                
            }

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });
        
        parameterExpressionText.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, parameterExpression);
	                nspd.open();
	                parameterExpressionText.setText(parameterExpression.getPropertyValue());
	                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateParameterPropertiesEditionPartImpl.this, EsbViewsRepository.CallTemplateParameter.Properties.parameterExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getParameterExpression()));

				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        EditingUtils.setID(parameterExpressionText, EsbViewsRepository.AggregateMediator.OnComplete.aggregationExpression);
        EditingUtils.setEEFtype(parameterExpressionText, "eef::Text");
        Control parameterExpressionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallTemplateParameter.Properties.parameterExpression, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
        parameterExpressionElements = new Control[] {parameterExpressionLabel, parameterExpressionText, parameterExpressionHelp};
        return parent;
    }
	
	@Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite [] {propertiesGroup});
        epv.showEntry(parameterNameElements, false);
        epv.showEntry(parameterTypeElements, false);
        if(getTemplateParameterType().getName().equals("EXPRESSION")) {
            epv.showEntry(parameterExpressionElements, false);
        } else {
            epv.showEntry(parameterValueElements, false);
        }
        view.layout(true, true);
    }


	// End of user code


}
