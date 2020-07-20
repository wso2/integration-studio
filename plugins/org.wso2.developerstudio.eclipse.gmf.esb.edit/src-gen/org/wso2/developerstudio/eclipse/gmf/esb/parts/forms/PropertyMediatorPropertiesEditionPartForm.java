/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.io.IOException;
import java.net.URISyntaxException;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyAction;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyName;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

// End of user code

/**
 * 
 * 
 */
public class PropertyMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, PropertyMediatorPropertiesEditionPart {

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
	private static IDeveloperStudioLog log = Logger.getLog(EEFPropertyViewUtil.PLUGIN_ID);
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
    
    protected Composite valueComposite;
    protected Composite propertiesGroup;
	protected Text description;

	protected Composite filterValuesSubPropertiesGroup;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 * 
	 */
	public PropertyMediatorPropertiesEditionPartForm() {
	    super();
	}

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	
	public PropertyMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);        
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		Form form = widgetFactory.createForm(parent);
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return form;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence propertyMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = propertyMediatorStep.addStep(EsbViewsRepository.PropertyMediator.Properties.class);
		// Start of user code 
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.propertyName);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.newPropertyName);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.propertyDataType);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.propertyAction);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.propertyScope);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.valueType);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.value);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.expression);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.namespacePrefix);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.namespace);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.boolean_);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.oM);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.valueStringPattern);
		propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup);
        propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.valueExpression);
        propertiesStep.addStep(EsbViewsRepository.PropertyMediator.Properties.description);
        // End of user code
		
		composer = new PartComposer(propertyMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
			    // Start of user code for components addToPart creation
				if (key == EsbViewsRepository.PropertyMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.propertyName) {
					return createPropertyNameEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.propertyDataType) {
					return createPropertyDataTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.propertyAction) {
					return createPropertyActionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.propertyScope) {
					return createPropertyScopeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.valueType) {
					return createValueTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.value) {
					return createValueText(widgetFactory, filterValuesSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.expression) {
					return createExpressionText(widgetFactory, filterValuesSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.namespacePrefix) {
					return createNamespacePrefixText(widgetFactory, filterValuesSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.namespace) {
					return createNamespaceText(widgetFactory, filterValuesSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.boolean_) {
					return createBoolean_Checkbox(widgetFactory, filterValuesSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.oM) {
					return createOMText(widgetFactory, filterValuesSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.valueStringPattern) {
					return createValueStringPatternText(widgetFactory, filterValuesSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup) {
					return createValueStringCapturingGroupText(widgetFactory, filterValuesSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.PropertyMediator.Properties.newPropertyName) {
					return createNewPropertyNameText(widgetFactory, parent);
				}
				if(key == EsbViewsRepository.PropertyMediator.Properties.valueExpression) {
				    return createValueExpressionWidget(widgetFactory, filterValuesSubPropertiesGroup);
				}
				if(key == EsbViewsRepository.PropertyMediator.Properties.description) {
                    return createDescriptionText(widgetFactory, parent);
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
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
	    Section propertiesSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
	    propertiesSection.setText(EsbMessages.PropertyMediatorPropertiesEditionPart_PropertiesGroupLabel);
	    GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
	    propertiesSectionData.horizontalSpan = 3;
	    propertiesSection.setLayoutData(propertiesSectionData);
	    propertiesGroup = widgetFactory.createComposite(propertiesSection);
	    GridLayout propertiesGroupLayout = new GridLayout();
	    propertiesGroupLayout.numColumns = 3;
	    propertiesGroup.setLayout(propertiesGroupLayout);
	    propertiesSection.setClient(propertiesGroup);
	    return propertiesGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createPropertyNameEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyName()));
			}

		});
		propertyName.setID(EsbViewsRepository.PropertyMediator.Properties.propertyName);
		Control propertyNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.propertyName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyNameEMFComboViewer
		propertyNameElements = new Control[] {propertyNameLabel, propertyName.getCombo(), propertyNameHelp};
		propertyName.addSelectionChangedListener(new ISelectionChangedListener() {
			        
            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createPropertyDataTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.propertyDataType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyDataType()));
			}

		});
		propertyDataType.setID(EsbViewsRepository.PropertyMediator.Properties.propertyDataType);
		Control propertyDataTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.propertyDataType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyDataTypeEMFComboViewer
		propertyDataTypeElements = new Control[] {propertyDataTypeLabel, propertyDataType.getCombo(), propertyDataTypeHelp};
		propertyDataType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createPropertyActionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.propertyAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyAction()));
			}

		});
		propertyAction.setID(EsbViewsRepository.PropertyMediator.Properties.propertyAction);
		Control propertyActionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.propertyAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyActionEMFComboViewer
		propertyActionElements = new Control[] {propertyActionLabel, propertyAction.getCombo(), propertyActionHelp};
		propertyAction.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }

        });
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPropertyScopeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.propertyScope, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyScope()));
			}

		});
		propertyScope.setID(EsbViewsRepository.PropertyMediator.Properties.propertyScope);
		Control propertyScopeHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.propertyScope, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyScopeEMFComboViewer
		propertyScopeElements = new Control[] {propertyScopeLabel, propertyScope.getCombo(), propertyScopeHelp};
		propertyScope.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }

        });
		// End of user code
		return parent;
	}
	
    /**
     * @generated NOT
     */	
	protected Composite createValueTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    filterValuesSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Value", true);
		Control valueTypeLabel = createDescription(filterValuesSubPropertiesGroup, EsbViewsRepository.PropertyMediator.Properties.valueType, EsbMessages.PropertyMediatorPropertiesEditionPart_ValueTypeLabel);
		valueType = new EMFComboViewer(filterValuesSubPropertiesGroup);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.valueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
			}

		});
		valueType.setID(EsbViewsRepository.PropertyMediator.Properties.valueType);
		Control valueTypeHelp = FormUtils.createHelpButton(widgetFactory, filterValuesSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.valueType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueTypeEMFComboViewer
		valueTypeElements  = new Control[] {valueTypeLabel, valueType.getCombo(), valueTypeHelp};
        valueType.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
    protected Composite createValueText(FormToolkit widgetFactory, Composite parent) {
        Control valueLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.value,
                EsbMessages.PropertyMediatorPropertiesEditionPart_ValueLabel);
        value = widgetFactory.createText(parent, "");
        value.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);

        // Add new toggle expression widget
        valueComposite = EEFPropertyViewUtil.createComposite(widgetFactory, parent, 1, 1);
        createTextBoxFieldWithButton(widgetFactory, valueComposite,
                EsbViewsRepository.PropertyMediator.Properties.value,
                EsbViewsRepository.PropertyMediator.Properties.valueExpression,
                EsbViewsRepository.PropertyMediator.Properties.valueType); // $NON-NLS-1$

        EditingUtils.setID(value, EsbViewsRepository.PropertyMediator.Properties.value);
        EditingUtils.setEEFtype(value, "eef::Text"); //$NON-NLS-1$
        Control valueHelpButton = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.PropertyMediator.Properties.value, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createValueText
        valueElements = new Control[] { valueLabel, valueComposite, valueHelpButton };
        // End of user code
        return parent;
    }

	/**
     * @generated NOT
     */
	protected Composite createExpressionText(FormToolkit widgetFactory, Composite parent) {
	    Control expressionLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.expression, EsbMessages.PropertyMediatorPropertiesEditionPart_ExpressionLabel);
		expression = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		expression.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData expressionData = new GridData(GridData.FILL_HORIZONTAL);
		expression.setLayoutData(expressionData);
		expression.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PropertyMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.PropertyMediator.Properties.expression,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, expression.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PropertyMediatorPropertiesEditionPartForm.this,
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
									PropertyMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		expression.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.expression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, expression.getText()));
				}
			}
		});
		EditingUtils.setID(expression, EsbViewsRepository.PropertyMediator.Properties.expression);
		EditingUtils.setEEFtype(expression, "eef::Text"); //$NON-NLS-1$
		Control expressionHelpButton = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.expression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createExpressionText
		expressionElements = new Control[] {expressionLabel, expression, expressionHelpButton};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createNamespacePrefixText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.namespacePrefix, EsbMessages.PropertyMediatorPropertiesEditionPart_NamespacePrefixLabel);
		namespacePrefix = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		namespacePrefix.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData namespacePrefixData = new GridData(GridData.FILL_HORIZONTAL);
		namespacePrefix.setLayoutData(namespacePrefixData);
		namespacePrefix.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PropertyMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.PropertyMediator.Properties.namespacePrefix,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespacePrefix.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PropertyMediatorPropertiesEditionPartForm.this,
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
									PropertyMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		namespacePrefix.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.namespacePrefix, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespacePrefix.getText()));
				}
			}
		});
		EditingUtils.setID(namespacePrefix, EsbViewsRepository.PropertyMediator.Properties.namespacePrefix);
		EditingUtils.setEEFtype(namespacePrefix, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.namespacePrefix, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNamespacePrefixText

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createNamespaceText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.namespace, EsbMessages.PropertyMediatorPropertiesEditionPart_NamespaceLabel);
		namespace = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		namespace.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData namespaceData = new GridData(GridData.FILL_HORIZONTAL);
		namespace.setLayoutData(namespaceData);
		namespace.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PropertyMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.PropertyMediator.Properties.namespace,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespace.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PropertyMediatorPropertiesEditionPartForm.this,
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
									PropertyMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		namespace.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.namespace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespace.getText()));
				}
			}
		});
		EditingUtils.setID(namespace, EsbViewsRepository.PropertyMediator.Properties.namespace);
		EditingUtils.setEEFtype(namespace, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.namespace, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNamespaceText

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createBoolean_Checkbox(FormToolkit widgetFactory, Composite parent) {
		boolean_ = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.PropertyMediator.Properties.boolean_, EsbMessages.PropertyMediatorPropertiesEditionPart_Boolean_Label), SWT.CHECK);
		boolean_.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.boolean_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(boolean_.getSelection())));
			}

		});
		GridData boolean_Data = new GridData(GridData.FILL_HORIZONTAL);
		boolean_Data.horizontalSpan = 2;
		boolean_.setLayoutData(boolean_Data);
		EditingUtils.setID(boolean_, EsbViewsRepository.PropertyMediator.Properties.boolean_);
		EditingUtils.setEEFtype(boolean_, "eef::Checkbox"); //$NON-NLS-1$
		Control booleanHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.boolean_, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createBoolean_Checkbox
		booleanElements = new Control[] {boolean_, booleanHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOMText(FormToolkit widgetFactory, Composite parent) {
		Control omTextLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.oM, EsbMessages.PropertyMediatorPropertiesEditionPart_OMLabel);
		oM = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		oM.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData oMData = new GridData(GridData.FILL_HORIZONTAL);
		oM.setLayoutData(oMData);
		oM.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PropertyMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.PropertyMediator.Properties.oM,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, oM.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PropertyMediatorPropertiesEditionPartForm.this,
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
									PropertyMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		oM.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.oM, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, oM.getText()));
				}
			}
		});
		EditingUtils.setID(oM, EsbViewsRepository.PropertyMediator.Properties.oM);
		EditingUtils.setEEFtype(oM, "eef::Text"); //$NON-NLS-1$
		Control omHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.oM, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOMText
		omTextElements = new Control[] {omTextLabel, oM, omHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createValueStringPatternText(FormToolkit widgetFactory, Composite parent) {
		Control valueStringPatternLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.valueStringPattern, EsbMessages.PropertyMediatorPropertiesEditionPart_ValueStringPatternLabel);
		valueStringPattern = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		valueStringPattern.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueStringPatternData = new GridData(GridData.FILL_HORIZONTAL);
		valueStringPattern.setLayoutData(valueStringPatternData);
		valueStringPattern.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PropertyMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.PropertyMediator.Properties.valueStringPattern,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueStringPattern.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PropertyMediatorPropertiesEditionPartForm.this,
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
									PropertyMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		valueStringPattern.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.valueStringPattern, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueStringPattern.getText()));
				}
			}
		});
		EditingUtils.setID(valueStringPattern, EsbViewsRepository.PropertyMediator.Properties.valueStringPattern);
		EditingUtils.setEEFtype(valueStringPattern, "eef::Text"); //$NON-NLS-1$
		Control valueStringPatternHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.valueStringPattern, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueStringPatternText
		valueStringPatternElements = new Control[] {valueStringPatternLabel, valueStringPattern, valueStringPatternHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createValueStringCapturingGroupText(FormToolkit widgetFactory, Composite parent) {
		Control valueStringCapturingGroupLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup, EsbMessages.PropertyMediatorPropertiesEditionPart_ValueStringCapturingGroupLabel);
		valueStringCapturingGroup = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		valueStringCapturingGroup.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueStringCapturingGroupData = new GridData(GridData.FILL_HORIZONTAL);
		valueStringCapturingGroup.setLayoutData(valueStringCapturingGroupData);
		valueStringCapturingGroup.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PropertyMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueStringCapturingGroup.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PropertyMediatorPropertiesEditionPartForm.this,
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
									PropertyMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		valueStringCapturingGroup.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueStringCapturingGroup.getText()));
				}
			}
		});
		EditingUtils.setID(valueStringCapturingGroup, EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup);
		EditingUtils.setEEFtype(valueStringCapturingGroup, "eef::Text"); //$NON-NLS-1$
		Control valueStringCapturingGroupHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueStringCapturingGroupText
		valueStringCapturingGroupElements = new Control[] {valueStringCapturingGroupLabel, valueStringCapturingGroup, valueStringCapturingGroupHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createNewPropertyNameText(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.newPropertyName, EsbMessages.PropertyMediatorPropertiesEditionPart_NewPropertyNameLabel);
		newPropertyName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		newPropertyName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData newPropertyNameData = new GridData(GridData.FILL_HORIZONTAL);
		newPropertyName.setLayoutData(newPropertyNameData);
		newPropertyName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PropertyMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.PropertyMediator.Properties.newPropertyName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, newPropertyName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PropertyMediatorPropertiesEditionPartForm.this,
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
									PropertyMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		newPropertyName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.newPropertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, newPropertyName.getText()));
				}
			}
		});
		EditingUtils.setID(newPropertyName, EsbViewsRepository.PropertyMediator.Properties.newPropertyName);
		EditingUtils.setEEFtype(newPropertyName, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.newPropertyName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNewPropertyNameText
		newPropertyNameElements = new Control[] {itemLabel, newPropertyName, itemHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
    Control descriptionLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.description, EsbMessages.PropertyMediatorPropertiesEditionPart_DescriptionLabel);
    description = widgetFactory.createText(parent, ""); //$NON-NLS-1$
    description.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
    widgetFactory.paintBordersFor(parent);
    GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
    description.setLayoutData(descriptionData);
    description.addFocusListener(new FocusAdapter() {
      /**
       * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
       * 
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void focusLost(FocusEvent e) {
        if (propertiesEditionComponent != null) {
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
              PropertyMediatorPropertiesEditionPartForm.this,
              EsbViewsRepository.PropertyMediator.Properties.description,
              PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
          propertiesEditionComponent
              .firePropertiesChanged(new PropertiesEditionEvent(
                  PropertyMediatorPropertiesEditionPartForm.this,
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
                  PropertyMediatorPropertiesEditionPartForm.this,
                  null,
                  PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
                  null, null));
        }
      }
    });
    description.addKeyListener(new KeyAdapter() {
      /**
       * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
       * 
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void keyPressed(KeyEvent e) {
        if (e.character == SWT.CR) {
          if (propertiesEditionComponent != null)
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PropertyMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
        }
      }
    });
    EditingUtils.setID(description, EsbViewsRepository.PropertyMediator.Properties.description);
    EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
    Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
        //Creating a new name spaced property object since properties change event won't
        //fire if new value is the same object
        return valueExpression;
    }

    @Override
    public void setValueExpression(
            NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
            valueExpressionText.setText(nameSpacedProperty.getPropertyValue());
            valueExpression = nameSpacedProperty;
        }
    }
    
    @Override
    public void refresh() {
        super.refresh();
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

	// Start of user code additional methods
	protected Composite createValueExpressionWidget(FormToolkit widgetFactory, final Composite parent) {
	    Control valueExpressionLabel = createDescription(parent, EsbViewsRepository.PropertyMediator.Properties.valueExpression, EsbMessages.PropertyMediatorPropertiesEditionPart_ValueExpressionLabel);
	    widgetFactory.paintBordersFor(parent);
        if(valueExpression == null) {
            valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
	    String initValueExpression = valueExpression.getPropertyValue().isEmpty() ? "" : valueExpression.getPropertyValue();
	    valueExpressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
	    valueExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	    widgetFactory.paintBordersFor(parent);
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
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openValueExpressionWidgetNamespacedPropertyEditor(parent);
                }
            }
                        
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(valueExpressionText, EsbViewsRepository.PropertyMediator.Properties.valueExpression);
        EditingUtils.setEEFtype(valueExpressionText, "eef::Text");
        Control valueExpressionHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PropertyMediator.Properties.valueExpression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        valueExpressionElements = new Control[] {valueExpressionLabel, valueExpressionText, valueExpressionHelp};
        return parent;
	}
	
    private void openValueExpressionWidgetNamespacedPropertyEditor(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                valueExpression);
        valueExpression = nspd.open();
        valueExpressionText.setText(valueExpression.getPropertyValue());
        propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.PropertyMediator.Properties.valueExpression, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getValueExpression()));
    }
	
	public void validate() {
	    EEFPropertyViewUtil viewUtil = new EEFPropertyViewUtil(view);
	    
	    viewUtil.clearElements(new Composite[] { propertiesGroup });
        
        viewUtil.showEntry(new Control[] { filterValuesSubPropertiesGroup.getParent() }, false);
        viewUtil.clearElements(new Composite[] { filterValuesSubPropertiesGroup });

        viewUtil.showEntry(propertyNameElements, false);
	    if(getPropertyName().getName().equals(PropertyName.NEW_PROPERTY_NAME.getName())) {
	        viewUtil.showEntry(newPropertyNameElements, false);
	    }
	    viewUtil.showEntry(propertyActionElements, false);
	    if(getPropertyAction().getName().equals(PropertyAction.SET.getName())) {
	        //viewUtil.showEntry(valueTypeElements, false);
	        viewUtil.showEntry(propertyDataTypeElements, false);
	        if(getValueType().getName().equals(PropertyValueType.LITERAL.getName())) {
	            switch (getPropertyDataType().getName()) {
                    case "STRING": {
                        viewUtil.showEntry(valueElements, false);
                        viewUtil.showEntry(valueStringPatternElements, false);
                        viewUtil.showEntry(valueStringCapturingGroupElements, false);
                        break;
                    }
                    default: {
                        viewUtil.showEntry(valueElements, false);
                    }
	            }
	        } else {
	            //viewUtil.showEntry(valueExpressionElements, false);
                switch (getPropertyDataType().getName()) {
                case "STRING": {
                    viewUtil.showEntry(valueElements, false);
                    viewUtil.showEntry(valueStringPatternElements, false);
                    viewUtil.showEntry(valueStringCapturingGroupElements, false);
                    break;
                }
                default:
                    viewUtil.showEntry(valueElements, false);
                    break;
                }
	        }
	    }
	    viewUtil.showEntry(propertyScopeElements, false);
	    viewUtil.showEntry(descriptionElements, false);
        view.layout(true,true);
	}

	/**
	 * This method sets the text of value or expression field accordingly(Considering the ecore model)
	 * This should be invoked from component class initPart method after all the fields are init.
	 */
    public void updateValueField() {
        if(getValueType() != null) {
            if (PropertyValueType.EXPRESSION.getLiteral().equals(getValueType().getLiteral())) {
                Control exButton = (Control) valueComposite.getData(EEFPropertyConstants.ASSOCIATED_BUTTON);
                if (exButton != null && exButton instanceof Button) {
                    ((Button) exButton).setSelection(true);
                    ((Button) exButton).notifyListeners(SWT.Selection, new Event());
                }
                StyledText expressionTextBox = (StyledText) valueComposite
                        .getData(EEFPropertyConstants.EXPRESSION_TEXT_BOX);
                expressionTextBox.setText(getValueExpression().getPropertyValue());
            } else {
                Text valueTextBox = (Text) valueComposite.getData(EEFPropertyConstants.VALUE_TEXT_BOX);
                valueTextBox.setText(getValue());
            }
        }
    }

    /**
     * Creates textBox field with button(Expression supported)
     * @param widgetFactory widget Factory
     * @param parent parent composite
     * @param updatedField updated value field
     * @param updatedFieldExpression updated expression field
     * @param updateFieldType updated type field
     * @return composite which contains the expression supported field
     */
    public Composite createTextBoxFieldWithButton(FormToolkit widgetFactory,
            final Composite parent, final String updatedField, String updatedFieldExpression, final String updateFieldType) {
        // Create wrapping composite of 3 elements
        Composite textBoxComposite = EEFPropertyViewUtil.createComposite(widgetFactory, parent, 3, 3);

        // Create expression toggle button
        Button expressionToggleButton = new Button(textBoxComposite, SWT.TOGGLE);
        Image expressionToggleButtonImage = null;
        try {
            expressionToggleButtonImage = new Image(parent.getShell().getDisplay(),
                    EEFPropertyViewUtil.getIconPath(EEFPropertyConstants.EXPRESSION_TOGGLE_BUTTON_IMAGE));
            expressionToggleButton.setImage(expressionToggleButtonImage);
        } catch (URISyntaxException | IOException e1) {
            log.error("Couldn't fetch property field icon", e1);
        }

        // Create Text box widget
        final Text valueTextBox = widgetFactory.createText(textBoxComposite, "", SWT.BORDER);
        valueTextBox.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        valueTextBox.setLayoutData(configRefData);
        valueTextBox.addKeyListener(new KeyAdapter() {

            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this,
                            updatedField, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueTextBox.getText()));
            }
        });

        // Create expression compsite(Which has text box and exp button)
        final Composite expressionComposite = createExpressionComposite(widgetFactory, textBoxComposite,
                updatedFieldExpression);
        expressionComposite.setVisible(false);
        ((GridData) expressionComposite.getLayoutData()).exclude = true; // Hide the expression composite first

        // Bind toggle button events
        expressionToggleButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) { // If pressed
                    // Hide value text box
                    valueTextBox.setVisible(false);
                    ((GridData) valueTextBox.getLayoutData()).exclude = true;
                    // Show expression composite
                    expressionComposite.setVisible(true);
                    ((GridData) expressionComposite.getLayoutData()).exclude = false;
                    parent.layout();
                    valueType.getCombo().select(1); // Assumes 1 is expression
                    // update ecore object to expression
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this,
                            updateFieldType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
                } else {
                    // Show value text box
                    valueTextBox.setVisible(true);
                    ((GridData) valueTextBox.getLayoutData()).exclude = false;
                    // Hide expression composite
                    expressionComposite.setVisible(false);
                    ((GridData) expressionComposite.getLayoutData()).exclude = true;
                    parent.layout();
                    valueType.getCombo().select(0); // Assumes 0 is value
                    // update ecore object to value
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this,
                            updateFieldType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
                }
            }
        });
        //Set control widgets as data of parent composite
        parent.setData(EEFPropertyConstants.ASSOCIATED_BUTTON, expressionToggleButton); // Add associated button
        StyledText expressionTextBox = (StyledText) expressionComposite
                .getData(EEFPropertyConstants.EXPRESSION_TEXT_BOX);
        parent.setData(EEFPropertyConstants.EXPRESSION_TEXT_BOX, expressionTextBox);
        parent.setData(EEFPropertyConstants.VALUE_TEXT_BOX, valueTextBox);
        return parent;
    }

    /**
     * Creates expression sub composite
     * @param widgetFactory widget factory
     * @param parent parent composite
     * @param updatedFieldExpression 
     * @return expression composite
     */
    public Composite createExpressionComposite(FormToolkit widgetFactory, final Composite parent,
            String updatedFieldExpression) {
        // Create wrapping composite of 2 elements and 1 span
        Composite textComposite = EEFPropertyViewUtil.createComposite(widgetFactory, parent, 2, 1);

        // Create expression Text box
        final StyledText expressionTextBox = new StyledText(textComposite, SWT.SINGLE);
        expressionTextBox.setBackground(new Color(null, 255, 255, 255));
        expressionTextBox.addLineStyleListener(new LineStyleListener() {
            public void lineGetStyle(LineStyleEvent e) {
                // Set the line number
                e.bulletIndex = expressionTextBox.getLineAtOffset(e.lineOffset);

                // Set the style, 12 pixles wide for each digit
                StyleRange style = new StyleRange();
                Device device = Display.getCurrent();
                final RGB LINE_NUMBER_FG = new RGB(185, 193, 196);

                style.foreground = new Color(device, LINE_NUMBER_FG);
                GC gc = new GC(expressionTextBox);
                Point textExtent = gc.stringExtent(EEFPropertyConstants.EXPRESSION_TEXTBOX_PREFIX);
                gc.dispose();
                style.metrics = new GlyphMetrics(0, 0, textExtent.x);

                e.bullet = new Bullet(ST.BULLET_TEXT, style);
                e.bullet.text = EEFPropertyConstants.EXPRESSION_TEXTBOX_PREFIX;

            }
        });
        expressionTextBox.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        expressionTextBox.setLayoutData(configRefData);
        expressionTextBox.addKeyListener(new KeyAdapter() {
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {
                EEFPropertyViewUtil.setExpressionValue(expressionTextBox.getText(), getValueExpression());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.PropertyMediator.Properties.valueExpression, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getValueExpression()));
            }
        });

        // Create Expression Dialog Box Button
        Button expressionDialogBoxButton = new Button(textComposite, SWT.PUSH);

        Image expressionDialogBoxButtonImage = null;
        try {
            expressionDialogBoxButtonImage = new Image(parent.getShell().getDisplay(),
                    EEFPropertyViewUtil.getIconPath(EEFPropertyConstants.EXPRESSION_DIALOG_BOX_BUTTON_IMAGE));
        } catch (URISyntaxException | IOException e1) {
            log.error("Couldn't fetch property field icon", e1);
        }
        expressionDialogBoxButton.setImage(expressionDialogBoxButtonImage);
        expressionDialogBoxButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                boolean saved = EEFPropertyViewUtil.openValueExpressionWidgetNamespacedPropertyEditor(parent,
                        expressionTextBox, getValueExpression());
                if (saved) { // update only if the value is saved
                    expressionTextBox.setText(getValueExpression().getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PropertyMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.PropertyMediator.Properties.valueExpression,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            getValueExpression()));
                }
            }
        });
        textComposite.setData(EEFPropertyConstants.EXPRESSION_TEXT_BOX, expressionTextBox); // Add associated button
        return textComposite;
    }

	// End of user code


}
