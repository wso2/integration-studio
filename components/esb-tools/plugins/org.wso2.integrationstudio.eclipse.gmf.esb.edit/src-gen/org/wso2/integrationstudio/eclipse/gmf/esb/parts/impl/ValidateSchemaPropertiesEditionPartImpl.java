/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

import java.util.ArrayList;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;
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
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms.EnrichMediatorPropertiesEditionPartForm;
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
public class ValidateSchemaPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ValidateSchemaPropertiesEditionPart {

	protected EMFComboViewer validateSchemaKeyType;
	protected EObjectFlatComboViewer schemaKey;
	// Start of user code  for staticSchemaKey widgets declarations
    protected RegistryKeyProperty staticSchemaKey;
    protected Text staticSchemaKeyText;
	// End of user code

	// Start of user code  for dynamicSchemaKey widgets declarations
    protected NamespacedProperty dynamicSchemaKey;
    protected Text dynamicSchemaKeyText;
    protected Control[] validateSchemaKeyTypeElements;
    protected Control[] schemaKeyFlatElements;
    protected Control[] staticSchemaKeyElements;
    protected Control[] dynamicSchemaKeyElements;
    protected Group propertiesGroup;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ValidateSchemaPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence validateSchemaStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = validateSchemaStep.addStep(EsbViewsRepository.ValidateSchema.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType);
		propertiesStep.addStep(EsbViewsRepository.ValidateSchema.Properties.schemaKey);
		propertiesStep.addStep(EsbViewsRepository.ValidateSchema.Properties.staticSchemaKey);
		propertiesStep.addStep(EsbViewsRepository.ValidateSchema.Properties.dynamicSchemaKey);
		
		
		composer = new PartComposer(validateSchemaStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ValidateSchema.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType) {
					return createValidateSchemaKeyTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ValidateSchema.Properties.schemaKey) {
					return createSchemaKeyFlatComboViewer(parent);
				}
				// Start of user code for staticSchemaKey addToPart creation
                if (key == EsbViewsRepository.ValidateSchema.Properties.staticSchemaKey) {
                    return createStaticSchemaKeyWidget(parent);
                }
				// End of user code
				// Start of user code for dynamicSchemaKey addToPart creation
                if (key == EsbViewsRepository.ValidateSchema.Properties.dynamicSchemaKey) {
                    return createDynamicSchemaKeyWidget(parent);
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
		propertiesGroup.setText(EsbMessages.ValidateSchemaPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createValidateSchemaKeyTypeEMFComboViewer(Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType, EsbMessages.ValidateSchemaPropertiesEditionPart_ValidateSchemaKeyTypeLabel);
		validateSchemaKeyType = new EMFComboViewer(parent);
		validateSchemaKeyType.setContentProvider(new ArrayContentProvider());
		validateSchemaKeyType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData validateSchemaKeyTypeData = new GridData(GridData.FILL_HORIZONTAL);
		validateSchemaKeyType.getCombo().setLayoutData(validateSchemaKeyTypeData);
                validateSchemaKeyType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		validateSchemaKeyType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateSchemaPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValidateSchemaKeyType()));
			}

		});
		validateSchemaKeyType.setID(EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType);
		Control itemHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValidateSchemaKeyTypeEMFComboViewer
		validateSchemaKeyTypeElements = new Control [] {itemLabel, itemHelp, validateSchemaKeyType.getCombo()};
		validateSchemaKeyType.addSelectionChangedListener(new ISelectionChangedListener() {

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
	protected Composite createSchemaKeyFlatComboViewer(Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.ValidateSchema.Properties.schemaKey, EsbMessages.ValidateSchemaPropertiesEditionPart_SchemaKeyLabel);
		schemaKey = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EsbViewsRepository.ValidateSchema.Properties.schemaKey, EsbViewsRepository.SWT_KIND));
		schemaKey.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		schemaKey.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateSchemaPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateSchema.Properties.schemaKey, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getSchemaKey()));
			}

		});
		GridData schemaKeyData = new GridData(GridData.FILL_HORIZONTAL);
		schemaKey.setLayoutData(schemaKeyData);
		schemaKey.setID(EsbViewsRepository.ValidateSchema.Properties.schemaKey);
		Control itemHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateSchema.Properties.schemaKey, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSchemaKeyFlatComboViewer
		schemaKeyFlatElements = new Control [] {itemLabel, itemHelp, schemaKey};
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#getValidateSchemaKeyType()
	 * 
	 */
	public Enumerator getValidateSchemaKeyType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) validateSchemaKeyType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#initValidateSchemaKeyType(Object input, Enumerator current)
	 */
	public void initValidateSchemaKeyType(Object input, Enumerator current) {
		validateSchemaKeyType.setInput(input);
		validateSchemaKeyType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType);
		if (eefElementEditorReadOnlyState && validateSchemaKeyType.isEnabled()) {
			validateSchemaKeyType.setEnabled(false);
			validateSchemaKeyType.setToolTipText(EsbMessages.ValidateSchema_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !validateSchemaKeyType.isEnabled()) {
			validateSchemaKeyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#setValidateSchemaKeyType(Enumerator newValue)
	 * 
	 */
	public void setValidateSchemaKeyType(Enumerator newValue) {
		validateSchemaKeyType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType);
		if (eefElementEditorReadOnlyState && validateSchemaKeyType.isEnabled()) {
			validateSchemaKeyType.setEnabled(false);
			validateSchemaKeyType.setToolTipText(EsbMessages.ValidateSchema_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !validateSchemaKeyType.isEnabled()) {
			validateSchemaKeyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#getSchemaKey()
	 * 
	 */
	public EObject getSchemaKey() {
		if (schemaKey.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) schemaKey.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#initSchemaKey(EObjectFlatComboSettings)
	 */
	public void initSchemaKey(EObjectFlatComboSettings settings) {
		schemaKey.setInput(settings);
		if (current != null) {
			schemaKey.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateSchema.Properties.schemaKey);
		if (eefElementEditorReadOnlyState && schemaKey.isEnabled()) {
			schemaKey.setEnabled(false);
			schemaKey.setToolTipText(EsbMessages.ValidateSchema_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !schemaKey.isEnabled()) {
			schemaKey.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#setSchemaKey(EObject newValue)
	 * 
	 */
	public void setSchemaKey(EObject newValue) {
		if (newValue != null) {
			schemaKey.setSelection(new StructuredSelection(newValue));
		} else {
			schemaKey.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateSchema.Properties.schemaKey);
		if (eefElementEditorReadOnlyState && schemaKey.isEnabled()) {
			schemaKey.setEnabled(false);
			schemaKey.setToolTipText(EsbMessages.ValidateSchema_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !schemaKey.isEnabled()) {
			schemaKey.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#setSchemaKeyButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSchemaKeyButtonMode(ButtonsModeEnum newValue) {
		schemaKey.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#addFilterSchemaKey(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSchemaKey(ViewerFilter filter) {
		schemaKey.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#addBusinessFilterSchemaKey(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSchemaKey(ViewerFilter filter) {
		schemaKey.addBusinessRuleFilter(filter);
	}






	// Start of user code for staticSchemaKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getStaticSchemaKey() {
        // TODO Auto-generated method stub
        return staticSchemaKey;
    }

    @Override
    public void setStaticSchemaKey(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            staticSchemaKeyText.setText(registryKeyProperty.getKeyValue());
            staticSchemaKey = registryKeyProperty;
        }
        
    }
	// End of user code

	// Start of user code for dynamicSchemaKey specific getters and setters implementation
    @Override
    public NamespacedProperty getDynamicSchemaKey() {
        // TODO Auto-generated method stub
        return dynamicSchemaKey;
    }

    @Override
    public void setDynamicSchemaKey(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            dynamicSchemaKeyText.setText(nameSpacedProperty.getPropertyValue());
            dynamicSchemaKey = nameSpacedProperty;
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
		return EsbMessages.ValidateSchema_Part_Title;
	}





	// Start of user code additional methods
    protected Composite createDynamicSchemaKeyWidget(final Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.ValidateSchema.Properties.dynamicSchemaKey, EsbMessages.ValidateSchemaPropertiesEditionPart_DynamicSchemaKeyLabel);
        dynamicSchemaKeyText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        GridData parameterExpressionData = new GridData(GridData.FILL_HORIZONTAL);
        dynamicSchemaKeyText.setLayoutData(parameterExpressionData);
        if(dynamicSchemaKey == null) {
            dynamicSchemaKey = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = dynamicSchemaKey.getPropertyValue().isEmpty() ? "/default/expression" : dynamicSchemaKey.getPropertyValue();
        dynamicSchemaKeyText.setText(initValueExpression);
        dynamicSchemaKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        dynamicSchemaKeyText.addMouseListener(new MouseListener(){

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, dynamicSchemaKey);
                nspd.open();
                dynamicSchemaKeyText.setText(dynamicSchemaKey.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateSchemaPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateSchema.Properties.dynamicSchemaKey, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDynamicSchemaKey()));

                
            }

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });
        
        dynamicSchemaKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
               if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                   EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, dynamicSchemaKey);
                   nspd.open();
                   dynamicSchemaKeyText.setText(dynamicSchemaKey.getPropertyValue());
                   propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateSchemaPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateSchema.Properties.dynamicSchemaKey, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDynamicSchemaKey()));
               }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(dynamicSchemaKeyText, EsbViewsRepository.ValidateSchema.Properties.dynamicSchemaKey);
        EditingUtils.setEEFtype(dynamicSchemaKeyText, "eef::Text");
        Control itemHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateSchema.Properties.dynamicSchemaKey, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
        dynamicSchemaKeyElements = new Control[] {itemLabel, dynamicSchemaKeyText, itemHelp};
        return parent;
    }

    protected Composite createStaticSchemaKeyWidget(Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.ValidateSchema.Properties.staticSchemaKey, EsbMessages.ValidateSchemaPropertiesEditionPart_StaticSchemaKeyLabel);
        staticSchemaKeyText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        GridData parameterExpressionData = new GridData(GridData.FILL_HORIZONTAL);
        staticSchemaKeyText.setLayoutData(parameterExpressionData);
        if(staticSchemaKey == null) {
            staticSchemaKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        } 
        String initValueExpression = staticSchemaKey.getKeyValue().isEmpty() ? "" : staticSchemaKey.getKeyValue();
        staticSchemaKeyText.setText(initValueExpression);
        staticSchemaKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        staticSchemaKeyText.addMouseListener(new MouseListener(){

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, staticSchemaKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                staticSchemaKeyText.setText(staticSchemaKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        ValidateSchemaPropertiesEditionPartImpl.this,
                        EsbViewsRepository.ValidateSchema.Properties.staticSchemaKey, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getStaticSchemaKey()));

                
            }

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });
        
        staticSchemaKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, staticSchemaKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    staticSchemaKeyText.setText(staticSchemaKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ValidateSchemaPropertiesEditionPartImpl.this,
                            EsbViewsRepository.ValidateSchema.Properties.staticSchemaKey, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getStaticSchemaKey()));
                }
                
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(staticSchemaKeyText, EsbViewsRepository.ValidateSchema.Properties.staticSchemaKey);
        EditingUtils.setEEFtype(staticSchemaKeyText, "eef::Text");
        Control itemHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateSchema.Properties.staticSchemaKey, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
        staticSchemaKeyElements = new Control[] {itemLabel, staticSchemaKeyText, itemHelp};
        return parent;
    }
    
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] { propertiesGroup });
        epv.showEntry(validateSchemaKeyTypeElements, false);
        switch (getValidateSchemaKeyType().getLiteral()) {
        case "Static": {
            epv.showEntry(staticSchemaKeyElements, false);
            break;
        }

        case "Dynamic": {
            epv.showEntry(dynamicSchemaKeyElements, false);
            break;
        }
        }
        view.layout(true, true);
    }
    
    public void validate(EObjectFlatComboSettings schemaSettings) {
        if(getValidateSchemaKeyType() == null) {
            validateSchemaKeyType.setEnabled(true);
            //initValidateSchemaKeyType(schemaSettings, current);
        }
        validate();
    }
	// End of user code


}
