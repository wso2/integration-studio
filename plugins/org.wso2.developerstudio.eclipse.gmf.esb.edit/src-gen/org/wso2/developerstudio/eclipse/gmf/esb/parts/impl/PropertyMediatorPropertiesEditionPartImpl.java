/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyAction;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyName;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.forms.PropertyMediatorPropertiesEditionPartForm;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamespacedPropertyEditorDialog;

import java.util.HashMap;
import java.util.Map;
// End of user code

/**
 * 
 * 
 */
public class PropertyMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PropertyMediatorPropertiesEditionPart {

	protected EMFComboViewer propertyName;
	protected EMFComboViewer propertyDataType;
	protected EMFComboViewer propertyAction;
	protected EMFComboViewer propertyScope;
	protected EMFComboViewer valueType;
	protected Text value;
	protected Text expression;
	protected Text namespacePrefix;
	protected Text namespace;
	protected Button boolean_;
	protected Text oM;
	protected Text valueStringPattern;
	protected Text valueStringCapturingGroup;
	protected Text newPropertyName;
	// Start of user code  for valueExpression widgets declarations
	protected NamespacedProperty valueExpression;
	protected Text valueExpressionText;
	protected Control[] propertyNameElements;
	protected Control[] propertyDataTypeElements;
	protected Control[] propertyActionElements;
	protected Control[] propertyScopeElements;
	protected Control[] valueTypeElements;
	protected Control[] valueElements;
	protected Control[] expressionElements;
	protected Control[] booleanElements;
	protected Control[] omTextElements;
	protected Control[] valueStringPatternElements;
	protected Control[] valueStringCapturingGroupElements;
	protected Control[] newPropertyNameElements;
	protected Control[] valueExpressionElements;
	protected Control[] descriptionElements;
	protected Group propertiesGroup;

	private Map<String, PropertyScope> propertyNameScopeMap = new HashMap<String, PropertyScope>();
	// End of user code

	protected Text description;

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * @generated NOT
	 */
	public PropertyMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
		populatePropertyNameScopeMap();
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
		CompositionSequence propertyMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = propertyMediatorStep.addStep(EsbViewsRepository.PropertyMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.propertyName);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.newPropertyName);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.propertyDataType);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.propertyAction);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.propertyScope);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.valueType);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.valueExpression);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.value);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.expression);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.namespacePrefix);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.namespace);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.boolean_);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.oM);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.valueStringPattern);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.description);
		
		composer = new PartComposer(propertyMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.PropertyMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.propertyName) {
					return createPropertyNameEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.propertyDataType) {
					return createPropertyDataTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.propertyAction) {
					return createPropertyActionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.propertyScope) {
					return createPropertyScopeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.valueType) {
					return createValueTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.value) {
					return createValueText(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.expression) {
					return createExpressionText(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.namespacePrefix) {
					return createNamespacePrefixText(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.namespace) {
					return createNamespaceText(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.boolean_) {
					return createBoolean_Checkbox(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.oM) {
					return createOMText(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.valueStringPattern) {
					return createValueStringPatternText(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup) {
					return createValueStringCapturingGroupText(parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.newPropertyName) {
					return createNewPropertyNameText(parent);
				}
				// Start of user code for valueExpression addToPart creation
                if(key == EsbViewsRepository.PropertyMediator.Properties.valueExpression) {
                    return createValueExpressionWidget(parent);
                }
				// End of user code
				if (key == EsbViewsRepository.PropertyMediator.Properties.description) {
					return createDescriptionText(parent);
				}
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
		propertiesGroup.setText(EsbMessages.PropertyMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createPropertyNameEMFComboViewer(Composite parent) {
	    Control propertyNameLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.propertyName, EsbMessages.PropertyMediatorPropertiesEditionPart_PropertyNameLabel);
		propertyName = new EMFComboViewer(parent);
		propertyName.setContentProvider(new ArrayContentProvider());
		propertyName.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyNameData = new GridData(GridData.FILL_HORIZONTAL);
		propertyName.getCombo().setLayoutData(propertyNameData);
                propertyName.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		propertyName.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyName()));
				    refresh();
			}

		});
		propertyName.setID(EsbViewsRepository.PropertyMediator.Properties.propertyName);
		Control propertyNameHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.propertyName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyNameEMFComboViewer
        propertyNameElements = new Control[] {propertyNameLabel, propertyName.getCombo(), propertyNameHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */ 
	protected Composite createPropertyDataTypeEMFComboViewer(Composite parent) {
	    Control propertyDataTypeLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.propertyDataType, EsbMessages.PropertyMediatorPropertiesEditionPart_PropertyDataTypeLabel);
		propertyDataType = new EMFComboViewer(parent);
		propertyDataType.setContentProvider(new ArrayContentProvider());
		propertyDataType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyDataTypeData = new GridData(GridData.FILL_HORIZONTAL);
		propertyDataType.getCombo().setLayoutData(propertyDataTypeData);
                propertyDataType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		propertyDataType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.propertyDataType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyDataType()));
				validate();
			}

		});
		propertyDataType.setID(EsbViewsRepository.PropertyMediator.Properties.propertyDataType);
		Control propertyDataTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.propertyDataType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyDataTypeEMFComboViewer
        propertyDataTypeElements = new Control[] {propertyDataTypeLabel, propertyDataType.getCombo(), propertyDataTypeHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */ 	
	protected Composite createPropertyActionEMFComboViewer(Composite parent) {
	    Control propertyActionLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.propertyAction, EsbMessages.PropertyMediatorPropertiesEditionPart_PropertyActionLabel);
		propertyAction = new EMFComboViewer(parent);
		propertyAction.setContentProvider(new ArrayContentProvider());
		propertyAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyActionData = new GridData(GridData.FILL_HORIZONTAL);
		propertyAction.getCombo().setLayoutData(propertyActionData);
                propertyAction.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		propertyAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.propertyAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyAction()));
				validate();
			}

		});
		propertyAction.setID(EsbViewsRepository.PropertyMediator.Properties.propertyAction);
		Control propertyActionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.propertyAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyActionEMFComboViewer
        propertyActionElements = new Control[] {propertyActionLabel, propertyAction.getCombo(), propertyActionHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createPropertyScopeEMFComboViewer(Composite parent) {
	    Control propertyScopeLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.propertyScope, EsbMessages.PropertyMediatorPropertiesEditionPart_PropertyScopeLabel);
		propertyScope = new EMFComboViewer(parent);
		propertyScope.setContentProvider(new ArrayContentProvider());
		propertyScope.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyScopeData = new GridData(GridData.FILL_HORIZONTAL);
		propertyScope.getCombo().setLayoutData(propertyScopeData);
                propertyScope.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		propertyScope.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.propertyScope, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyScope()));
				validate();
			}

		});
		propertyScope.setID(EsbViewsRepository.PropertyMediator.Properties.propertyScope);
		Control propertyScopeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.propertyScope, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyScopeEMFComboViewer
        propertyScopeElements = new Control[] {propertyScopeLabel, propertyScope.getCombo(), propertyScopeHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */ 	
	protected Composite createValueTypeEMFComboViewer(Composite parent) {
	    Control valueTypeLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.valueType, EsbMessages.PropertyMediatorPropertiesEditionPart_ValueTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.valueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
				validate();
			}

		});
		valueType.setID(EsbViewsRepository.PropertyMediator.Properties.valueType);
		Control valueTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.valueType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueTypeEMFComboViewer
        valueTypeElements  = new Control[] {valueTypeLabel, valueType.getCombo(), valueTypeHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */ 	
	protected Composite createValueText(Composite parent) {
	    Control valueLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.value, EsbMessages.PropertyMediatorPropertiesEditionPart_ValueLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.value, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, value.getText()));
                propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(
                        PropertyMediatorPropertiesEditionPartImpl.this,
                        EsbViewsRepository.PropertyMediator.Properties.value,
                        PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                        null, value.getText()));
			}
			
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(
                                    PropertyMediatorPropertiesEditionPartImpl.this,
                                    null,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
                                    null, null));
                }
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.value, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, value.getText()));
				}
			}

		});
		EditingUtils.setID(value, EsbViewsRepository.PropertyMediator.Properties.value);
		EditingUtils.setEEFtype(value, "eef::Text"); //$NON-NLS-1$
		Control valueHelpButton = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.value, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueText
        valueElements = new Control[] {valueLabel, value, valueHelpButton};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createExpressionText(Composite parent) {
	    Control expressionLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.expression, EsbMessages.PropertyMediatorPropertiesEditionPart_ExpressionLabel);
		expression = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData expressionData = new GridData(GridData.FILL_HORIZONTAL);
		expression.setLayoutData(expressionData);
		expression.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.expression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, expression.getText()));
                propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(
                        PropertyMediatorPropertiesEditionPartImpl.this,
                        EsbViewsRepository.PropertyMediator.Properties.expression,
                        PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                        null, expression.getText()));				
			}
        }

        /**
         * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
         */
        @Override
        public void focusGained(FocusEvent e) {
            if (propertiesEditionComponent != null) {
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(
                                PropertyMediatorPropertiesEditionPartImpl.this,
                                null,
                                PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
                                null, null));
            }
        }
		});
		expression.addKeyListener(new KeyAdapter() {
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.expression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, expression.getText()));
				}
			}

		});
		EditingUtils.setID(expression, EsbViewsRepository.PropertyMediator.Properties.expression);
		EditingUtils.setEEFtype(expression, "eef::Text"); //$NON-NLS-1$
		Control expressionHelpButton = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.expression, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createExpressionText
        expressionElements = new Control[] {expressionLabel, expression, expressionHelpButton};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createNamespacePrefixText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.namespacePrefix, EsbMessages.PropertyMediatorPropertiesEditionPart_NamespacePrefixLabel);
		namespacePrefix = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData namespacePrefixData = new GridData(GridData.FILL_HORIZONTAL);
		namespacePrefix.setLayoutData(namespacePrefixData);
		namespacePrefix.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.namespacePrefix, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespacePrefix.getText()));
                propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(
                        PropertyMediatorPropertiesEditionPartImpl.this,
                        EsbViewsRepository.PropertyMediator.Properties.namespacePrefix,
                        PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                        null, namespacePrefix.getText()));
			}
        }

        /**
         * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
         */
        @Override
        public void focusGained(FocusEvent e) {
            if (propertiesEditionComponent != null) {
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(
                                PropertyMediatorPropertiesEditionPartImpl.this,
                                null,
                                PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
                                null, null));
            }
        }
		});
		namespacePrefix.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.namespacePrefix, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespacePrefix.getText()));
				}
			}

		});
		EditingUtils.setID(namespacePrefix, EsbViewsRepository.PropertyMediator.Properties.namespacePrefix);
		EditingUtils.setEEFtype(namespacePrefix, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.namespacePrefix, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNamespacePrefixText

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createNamespaceText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.namespace, EsbMessages.PropertyMediatorPropertiesEditionPart_NamespaceLabel);
		namespace = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData namespaceData = new GridData(GridData.FILL_HORIZONTAL);
		namespace.setLayoutData(namespaceData);
		namespace.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.namespace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespace.getText()));
                propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(
                        PropertyMediatorPropertiesEditionPartImpl.this,
                        EsbViewsRepository.PropertyMediator.Properties.namespace,
                        PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                        null, namespace.getText()));
			}
        }

        /**
         * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
         */
        @Override
        public void focusGained(FocusEvent e) {
            if (propertiesEditionComponent != null) {
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(
                                PropertyMediatorPropertiesEditionPartImpl.this,
                                null,
                                PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
                                null, null));
            }
        }
		});
		namespace.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.namespace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespace.getText()));
				}
			}

		});
		EditingUtils.setID(namespace, EsbViewsRepository.PropertyMediator.Properties.namespace);
		EditingUtils.setEEFtype(namespace, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.namespace, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNamespaceText

		// End of user code
		return parent;
	}
	
    /**
     * @generated NOT
     */
	protected Composite createBoolean_Checkbox(Composite parent) {
		boolean_ = new Button(parent, SWT.CHECK);
		boolean_.setText(getDescription(EsbViewsRepository.PropertyMediator.Properties.boolean_, EsbMessages.PropertyMediatorPropertiesEditionPart_Boolean_Label));
		boolean_.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.boolean_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(boolean_.getSelection())));
			}

		});
		GridData boolean_Data = new GridData(GridData.FILL_HORIZONTAL);
		boolean_Data.horizontalSpan = 2;
		boolean_.setLayoutData(boolean_Data);
		EditingUtils.setID(boolean_, EsbViewsRepository.PropertyMediator.Properties.boolean_);
		EditingUtils.setEEFtype(boolean_, "eef::Checkbox"); //$NON-NLS-1$
		Control booleanHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.boolean_, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createBoolean_Checkbox
        booleanElements = new Control[] {boolean_, booleanHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createOMText(Composite parent) {
	    Control omTextLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.oM, EsbMessages.PropertyMediatorPropertiesEditionPart_OMLabel);
		oM = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData oMData = new GridData(GridData.FILL_HORIZONTAL);
		oM.setLayoutData(oMData);
		oM.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.oM, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, oM.getText()));
                propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(
                        PropertyMediatorPropertiesEditionPartImpl.this,
                        EsbViewsRepository.PropertyMediator.Properties.oM,
                        PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                        null, oM.getText()));
			}
        }

        /**
         * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
         */
        @Override
        public void focusGained(FocusEvent e) {
            if (propertiesEditionComponent != null) {
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(
                                PropertyMediatorPropertiesEditionPartImpl.this,
                                null,
                                PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
                                null, null));
            }
        }
		});
		oM.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.oM, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, oM.getText()));
				}
			}

		});
		EditingUtils.setID(oM, EsbViewsRepository.PropertyMediator.Properties.oM);
		EditingUtils.setEEFtype(oM, "eef::Text"); //$NON-NLS-1$
		Control omHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.oM, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOMText
        omTextElements = new Control[] {omTextLabel, oM, omHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createValueStringPatternText(Composite parent) {
	    Control valueStringPatternLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.valueStringPattern, EsbMessages.PropertyMediatorPropertiesEditionPart_ValueStringPatternLabel);
		valueStringPattern = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData valueStringPatternData = new GridData(GridData.FILL_HORIZONTAL);
		valueStringPattern.setLayoutData(valueStringPatternData);
		valueStringPattern.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.valueStringPattern, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueStringPattern.getText()));
                propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(
                        PropertyMediatorPropertiesEditionPartImpl.this,
                        EsbViewsRepository.PropertyMediator.Properties.valueStringPattern,
                        PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                        null, valueStringPattern.getText()));
			}
        }

        /**
         * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
         */
        @Override
        public void focusGained(FocusEvent e) {
            if (propertiesEditionComponent != null) {
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(
                                PropertyMediatorPropertiesEditionPartImpl.this,
                                null,
                                PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
                                null, null));
            }
        }
		});
		valueStringPattern.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.valueStringPattern, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueStringPattern.getText()));
				}
			}

		});
		EditingUtils.setID(valueStringPattern, EsbViewsRepository.PropertyMediator.Properties.valueStringPattern);
		EditingUtils.setEEFtype(valueStringPattern, "eef::Text"); //$NON-NLS-1$
		Control valueStringPatternHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.valueStringPattern, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueStringPatternText
        valueStringPatternElements = new Control[] {valueStringPatternLabel, valueStringPattern, valueStringPatternHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createValueStringCapturingGroupText(Composite parent) {
	    Control valueStringCapturingGroupLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup, EsbMessages.PropertyMediatorPropertiesEditionPart_ValueStringCapturingGroupLabel);
		valueStringCapturingGroup = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData valueStringCapturingGroupData = new GridData(GridData.FILL_HORIZONTAL);
		valueStringCapturingGroup.setLayoutData(valueStringCapturingGroupData);
		valueStringCapturingGroup.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueStringCapturingGroup.getText()));
                propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(
                        PropertyMediatorPropertiesEditionPartImpl.this,
                        EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup,
                        PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                        null, valueStringCapturingGroup.getText()));
			}
        }

        /**
         * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
         */
        @Override
        public void focusGained(FocusEvent e) {
            if (propertiesEditionComponent != null) {
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(
                                PropertyMediatorPropertiesEditionPartImpl.this,
                                null,
                                PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
                                null, null));
            }
        }
		});
		valueStringCapturingGroup.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueStringCapturingGroup.getText()));
				}
			}

		});
		EditingUtils.setID(valueStringCapturingGroup, EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup);
		EditingUtils.setEEFtype(valueStringCapturingGroup, "eef::Text"); //$NON-NLS-1$
		Control valueStringCapturingGroupHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueStringCapturingGroupText
        valueStringCapturingGroupElements = new Control[] {valueStringCapturingGroupLabel, valueStringCapturingGroup, valueStringCapturingGroupHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createNewPropertyNameText(Composite parent) {
	    Control itemLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.newPropertyName, EsbMessages.PropertyMediatorPropertiesEditionPart_NewPropertyNameLabel);
		newPropertyName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData newPropertyNameData = new GridData(GridData.FILL_HORIZONTAL);
		newPropertyName.setLayoutData(newPropertyNameData);
		newPropertyName.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.newPropertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, newPropertyName.getText()));
                propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(
                        PropertyMediatorPropertiesEditionPartImpl.this,
                        EsbViewsRepository.PropertyMediator.Properties.newPropertyName,
                        PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                        null, newPropertyName.getText()));
			}
        }

        /**
         * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
         */
        @Override
        public void focusGained(FocusEvent e) {
            if (propertiesEditionComponent != null) {
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(
                                PropertyMediatorPropertiesEditionPartImpl.this,
                                null,
                                PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
                                null, null));

            }
        }
		});
		newPropertyName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.newPropertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, newPropertyName.getText()));
				}
			}
		});
		EditingUtils.setID(newPropertyName, EsbViewsRepository.PropertyMediator.Properties.newPropertyName);
		EditingUtils.setEEFtype(newPropertyName, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.newPropertyName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNewPropertyNameText
        newPropertyNameElements = new Control[] {itemLabel, newPropertyName, itemHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createDescriptionText(Composite parent) {
	    Control descriptionLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.description, EsbMessages.PropertyMediatorPropertiesEditionPart_DescriptionLabel);
		description = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
		          propertiesEditionComponent
	              .firePropertiesChanged(new PropertiesEditionEvent(
	                  PropertyMediatorPropertiesEditionPartImpl.this,
	                  EsbViewsRepository.PropertyMediator.Properties.description,
	                  PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
	                  null, description.getText()));
			}
	      }

	      /**
	       * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
	       */
	      @Override
	      public void focusGained(FocusEvent e) {
	        if (propertiesEditionComponent != null) {
	          propertiesEditionComponent
	              .firePropertiesChanged(new PropertiesEditionEvent(
	                  PropertyMediatorPropertiesEditionPartImpl.this,
	                  null,
	                  PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
	                  null, null));
	        }
	      }
		});
		description.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PropertyMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.PropertyMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
	    descriptionElements = new Control[] {descriptionLabel, description, descriptionHelp};
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getPropertyName()
	 * 
	 */
	public Enumerator getPropertyName() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyName.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#initPropertyName(Object input, Enumerator current)
	 */
	public void initPropertyName(Object input, Enumerator current) {
		propertyName.setInput(input);
		propertyName.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.propertyName);
		if (eefElementEditorReadOnlyState && propertyName.isEnabled()) {
			propertyName.setEnabled(false);
			propertyName.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyName.isEnabled()) {
			propertyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setPropertyName(Enumerator newValue)
	 * 
	 */
	public void setPropertyName(Enumerator newValue) {
		propertyName.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.propertyName);
		if (eefElementEditorReadOnlyState && propertyName.isEnabled()) {
			propertyName.setEnabled(false);
			propertyName.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyName.isEnabled()) {
			propertyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getPropertyDataType()
	 * 
	 */
	public Enumerator getPropertyDataType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyDataType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#initPropertyDataType(Object input, Enumerator current)
	 */
	public void initPropertyDataType(Object input, Enumerator current) {
		propertyDataType.setInput(input);
		propertyDataType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.propertyDataType);
		if (eefElementEditorReadOnlyState && propertyDataType.isEnabled()) {
			propertyDataType.setEnabled(false);
			propertyDataType.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyDataType.isEnabled()) {
			propertyDataType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setPropertyDataType(Enumerator newValue)
	 * 
	 */
	public void setPropertyDataType(Enumerator newValue) {
		propertyDataType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.propertyDataType);
		if (eefElementEditorReadOnlyState && propertyDataType.isEnabled()) {
			propertyDataType.setEnabled(false);
			propertyDataType.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyDataType.isEnabled()) {
			propertyDataType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getPropertyAction()
	 * 
	 */
	public Enumerator getPropertyAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#initPropertyAction(Object input, Enumerator current)
	 */
	public void initPropertyAction(Object input, Enumerator current) {
		propertyAction.setInput(input);
		propertyAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.propertyAction);
		if (eefElementEditorReadOnlyState && propertyAction.isEnabled()) {
			propertyAction.setEnabled(false);
			propertyAction.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyAction.isEnabled()) {
			propertyAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setPropertyAction(Enumerator newValue)
	 * 
	 */
	public void setPropertyAction(Enumerator newValue) {
		propertyAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.propertyAction);
		if (eefElementEditorReadOnlyState && propertyAction.isEnabled()) {
			propertyAction.setEnabled(false);
			propertyAction.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyAction.isEnabled()) {
			propertyAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getPropertyScope()
	 * 
	 */
	public Enumerator getPropertyScope() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyScope.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#initPropertyScope(Object input, Enumerator current)
	 */
	public void initPropertyScope(Object input, Enumerator current) {
		propertyScope.setInput(input);
		propertyScope.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.propertyScope);
		if (eefElementEditorReadOnlyState && propertyScope.isEnabled()) {
			propertyScope.setEnabled(false);
			propertyScope.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyScope.isEnabled()) {
			propertyScope.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setPropertyScope(Enumerator newValue)
	 * 
	 */
	public void setPropertyScope(Enumerator newValue) {
		propertyScope.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.propertyScope);
		if (eefElementEditorReadOnlyState && propertyScope.isEnabled()) {
			propertyScope.setEnabled(false);
			propertyScope.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyScope.isEnabled()) {
			propertyScope.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getValueType()
	 * 
	 */
	public Enumerator getValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) valueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#initValueType(Object input, Enumerator current)
	 */
	public void initValueType(Object input, Enumerator current) {
		valueType.setInput(input);
		valueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setValueType(Enumerator newValue)
	 * 
	 */
	public void setValueType(Enumerator newValue) {
		valueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getValue()
	 * 
	 */
	public String getValue() {
		return value.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setValue(String newValue)
	 * 
	 */
	public void setValue(String newValue) {
		if (newValue != null) {
			value.setText(newValue);
		} else {
			value.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.value);
		if (eefElementEditorReadOnlyState && value.isEnabled()) {
			value.setEnabled(false);
			value.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !value.isEnabled()) {
			value.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getExpression()
	 * 
	 */
	public String getExpression() {
		return expression.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setExpression(String newValue)
	 * 
	 */
	public void setExpression(String newValue) {
		if (newValue != null) {
			expression.setText(newValue);
		} else {
			expression.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.expression);
		if (eefElementEditorReadOnlyState && expression.isEnabled()) {
			expression.setEnabled(false);
			expression.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !expression.isEnabled()) {
			expression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getNamespacePrefix()
	 * 
	 */
	public String getNamespacePrefix() {
		return namespacePrefix.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setNamespacePrefix(String newValue)
	 * 
	 */
	public void setNamespacePrefix(String newValue) {
		if (newValue != null) {
			namespacePrefix.setText(newValue);
		} else {
			namespacePrefix.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.namespacePrefix);
		if (eefElementEditorReadOnlyState && namespacePrefix.isEnabled()) {
			namespacePrefix.setEnabled(false);
			namespacePrefix.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !namespacePrefix.isEnabled()) {
			namespacePrefix.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getNamespace()
	 * 
	 */
	public String getNamespace() {
		return namespace.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setNamespace(String newValue)
	 * 
	 */
	public void setNamespace(String newValue) {
		if (newValue != null) {
			namespace.setText(newValue);
		} else {
			namespace.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.namespace);
		if (eefElementEditorReadOnlyState && namespace.isEnabled()) {
			namespace.setEnabled(false);
			namespace.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !namespace.isEnabled()) {
			namespace.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getBoolean_()
	 * 
	 */
	public Boolean getBoolean_() {
		return Boolean.valueOf(boolean_.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setBoolean_(Boolean newValue)
	 * 
	 */
	public void setBoolean_(Boolean newValue) {
		if (newValue != null) {
			boolean_.setSelection(newValue.booleanValue());
		} else {
			boolean_.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.boolean_);
		if (eefElementEditorReadOnlyState && boolean_.isEnabled()) {
			boolean_.setEnabled(false);
			boolean_.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !boolean_.isEnabled()) {
			boolean_.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getOM()
	 * 
	 */
	public String getOM() {
		return oM.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setOM(String newValue)
	 * 
	 */
	public void setOM(String newValue) {
		if (newValue != null) {
			oM.setText(newValue);
		} else {
			oM.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.oM);
		if (eefElementEditorReadOnlyState && oM.isEnabled()) {
			oM.setEnabled(false);
			oM.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !oM.isEnabled()) {
			oM.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getValueStringPattern()
	 * 
	 */
	public String getValueStringPattern() {
		return valueStringPattern.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setValueStringPattern(String newValue)
	 * 
	 */
	public void setValueStringPattern(String newValue) {
		if (newValue != null) {
			valueStringPattern.setText(newValue);
		} else {
			valueStringPattern.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.valueStringPattern);
		if (eefElementEditorReadOnlyState && valueStringPattern.isEnabled()) {
			valueStringPattern.setEnabled(false);
			valueStringPattern.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueStringPattern.isEnabled()) {
			valueStringPattern.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getValueStringCapturingGroup()
	 * 
	 */
	public String getValueStringCapturingGroup() {
		return valueStringCapturingGroup.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setValueStringCapturingGroup(String newValue)
	 * 
	 */
	public void setValueStringCapturingGroup(String newValue) {
		if (newValue != null) {
			valueStringCapturingGroup.setText(newValue);
		} else {
			valueStringCapturingGroup.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup);
		if (eefElementEditorReadOnlyState && valueStringCapturingGroup.isEnabled()) {
			valueStringCapturingGroup.setEnabled(false);
			valueStringCapturingGroup.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueStringCapturingGroup.isEnabled()) {
			valueStringCapturingGroup.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getNewPropertyName()
	 * 
	 */
	public String getNewPropertyName() {
		return newPropertyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setNewPropertyName(String newValue)
	 * 
	 */
	public void setNewPropertyName(String newValue) {
		if (newValue != null) {
			newPropertyName.setText(newValue);
		} else {
			newPropertyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.newPropertyName);
		if (eefElementEditorReadOnlyState && newPropertyName.isEnabled()) {
			newPropertyName.setEnabled(false);
			newPropertyName.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !newPropertyName.isEnabled()) {
			newPropertyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.PropertyMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}






	// Start of user code for valueExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getValueExpression() {
        return valueExpression;
    }

    @Override
    public void setValueExpression(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            valueExpressionText.setText(nameSpacedProperty.getPropertyValue());
            valueExpression = nameSpacedProperty;
        }
    }
    
    @Override
    public void refresh() {
        setPropertyScope(propertyNameScopeMap.get(getPropertyName().getName()));
        validate();
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.PropertyMediator_Part_Title;
	}

	
    protected Composite createValueExpressionWidget(final Composite parent) {
        Control valueExpressionLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.valueExpression, EsbMessages.PropertyMediatorPropertiesEditionPart_ValueExpressionLabel);
        if(valueExpression == null) {
            valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = valueExpression.getPropertyValue().isEmpty() ? "" : valueExpression.getPropertyValue();
        valueExpressionText = SWTUtils.createScrollableText(parent, SWT.BORDER);
        valueExpressionText.setText(initValueExpression);
        valueExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        valueExpressionText.setLayoutData(valueData);
        
        valueExpressionText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                openValueExpressionWidgetNamespacedPropertyEditor(parent);
            }
            
        });
        
        valueExpressionText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
                openValueExpressionWidgetNamespacedPropertyEditor(parent);
            }
            
            @Override
            public void keyReleased(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(valueExpressionText, EsbViewsRepository.PropertyMediator.Properties.valueExpression);
        EditingUtils.setEEFtype(valueExpressionText, "eef::Text");
        Control valueExpressionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.valueExpression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        valueExpressionElements = new Control[] {valueExpressionLabel, valueExpressionText, valueExpressionHelp};
        return parent;
    }
    
    private void openValueExpressionWidgetNamespacedPropertyEditor(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                valueExpression);
        nspd.open();
        valueExpressionText.setText(valueExpression.getPropertyValue());
        propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartImpl.this,
                        EsbViewsRepository.PropertyMediator.Properties.valueExpression, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getValueExpression()));
    }
    
    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] {propertiesGroup});
        epv.showEntry(propertyNameElements, false);
        if(getPropertyName().getName().equals(PropertyName.NEW_PROPERTY_NAME.getName())) {
            epv.showEntry(newPropertyNameElements, false);
        }
        epv.showEntry(propertyActionElements, false);
        if(getPropertyAction().getName().equals(PropertyAction.SET.getName())) {
            epv.showEntry(valueTypeElements, false);
            epv.showEntry(propertyDataTypeElements, false);
            if(getValueType().getName().equals(PropertyValueType.LITERAL.getName())) {
                switch (getPropertyDataType().getName()) {
                    case "STRING": {
                        epv.showEntry(valueElements, false);
                        epv.showEntry(valueStringPatternElements, false);
                        epv.showEntry(valueStringCapturingGroupElements, false);
                        break;
                    }
                    default: {
                        epv.showEntry(valueElements, false);
                    }
                }
            } else {
                epv.showEntry(valueExpressionElements, false);
                switch (getPropertyDataType().getName()) {
                case "STRING": {
                    epv.showEntry(valueStringPatternElements, false);
                    epv.showEntry(valueStringCapturingGroupElements, false);
                    break;
                }
                default:
                    break;
                }
            }
        }
        epv.showEntry(propertyScopeElements, false);
        epv.showEntry(descriptionElements, false);
        view.layout(true,true);
        view.pack();
    }

    private void populatePropertyNameScopeMap() {
        propertyNameScopeMap.put("newPropertyName", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("Action", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("COPY_CONTENT_LENGTH_FROM_INCOMING", PropertyScope.AXIS2);
        propertyNameScopeMap.put("CacheLevel", PropertyScope.AXIS2);
        propertyNameScopeMap.put("ClientApiNonBlocking", PropertyScope.AXIS2);
        propertyNameScopeMap.put("ConcurrentConsumers", PropertyScope.AXIS2);
        propertyNameScopeMap.put("ContentType", PropertyScope.AXIS2);
        propertyNameScopeMap.put("disableAddressingForOutMessages", PropertyScope.AXIS2);
        propertyNameScopeMap.put("DISABLE_CHUNKING", PropertyScope.AXIS2);
        propertyNameScopeMap.put("DISABLE_SMOOKS_RESULT_PAYLOAD", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("ERROR_CODE", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("ERROR_DETAIL", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("ERROR_EXCEPTION", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("ERROR_MESSAGE", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("FAULTS_AS_HTTP_200", PropertyScope.AXIS2);
        propertyNameScopeMap.put("FORCE_ERROR_ON_SOAP_FAULT", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("FORCE_HTTP_1.0", PropertyScope.AXIS2_CLIENT);
        propertyNameScopeMap.put("FORCE_HTTP_CONTENT_LENGTH", PropertyScope.AXIS2);
        propertyNameScopeMap.put("FORCE_POST_PUT_NOBODY", PropertyScope.AXIS2);
        propertyNameScopeMap.put("FORCE_SC_ACCEPTED", PropertyScope.AXIS2);
        propertyNameScopeMap.put("FaultTo", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("From", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("HTTP_ETAG", PropertyScope.AXIS2);
        propertyNameScopeMap.put("HTTP_SC", PropertyScope.AXIS2);
        propertyNameScopeMap.put("JMS_COORELATION_ID", PropertyScope.AXIS2);
        propertyNameScopeMap.put("messageType", PropertyScope.AXIS2);
        propertyNameScopeMap.put("MESSAGE_FORMAT", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("MaxConcurrentConsumers", PropertyScope.AXIS2);
        propertyNameScopeMap.put("MercuryLastMessage", PropertyScope.AXIS2);
        propertyNameScopeMap.put("MercurySequenceKey", PropertyScope.AXIS2);
        propertyNameScopeMap.put("MessageID", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("NO_ENTITY_BODY", PropertyScope.AXIS2);
        propertyNameScopeMap.put("NO_KEEPALIVE", PropertyScope.AXIS2);
        propertyNameScopeMap.put("OUT_ONLY", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("OperationName", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("POST_TO_URI", PropertyScope.AXIS2);
        propertyNameScopeMap.put("preserveProcessedHeaders", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("PRESERVE_WS_ADDRESSING", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("REQUEST_HOST_HEADER", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("RESPONSE", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("REST_URL_POSTFIX", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("RelatesTo", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("ReplyTo", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("SERVER_IP", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("SYSTEM_DATE", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("SYSTEM_TIME", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("TRANSPORT_HEADERS", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("TRANSPORT_IN_NAME", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("To", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("transportNonBlocking", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("JMS_CONNECTION_FACTORY", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("JMS_DESTINATION", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("JMS_DESTINATION_TYPE", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("JMS_REPLY_DESTINATION", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("JMS_WRAPPER", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_FILE_URI", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_CONTENT_TYPE", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_FILENAME_PATTERN", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("POLL_INTERVAL", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_ACTION_AFTER_PROCESS", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_MOVE_AFTER_PROCESS", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_ACTION_AFTER_ERRORS", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_MOVE_AFTER_ERRORS", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_ACTION_AFTER_FAILURE", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_MOVE_AFTER_FAILURE", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_REPLY_FILE_URI", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_REPLY_FILENAME", PropertyScope.SYNAPSE);
        propertyNameScopeMap.put("VFS_MOVE_TIMESTAMP_FORMAT", PropertyScope.SYNAPSE);
    }

	// End of user code


}
