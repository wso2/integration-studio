/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
// Start of user code for imports
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
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;
import org.wso2.integrationstudio.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart;
import org.wso2.integrationstudio.gmf.esb.parts.forms.JsonTransformMediatorPropertiesEditionPartForm;
import org.wso2.integrationstudio.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class InboundEndpointParameterPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, InboundEndpointParameterPropertiesEditionPart {

	protected Text name;
	protected Text value;
	protected RegistryKeyProperty key;
	protected Text keyText;


	protected EMFComboViewer type;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public InboundEndpointParameterPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence inboundEndpointParameterStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = inboundEndpointParameterStep.addStep(EsbViewsRepository.InboundEndpointParameter.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.InboundEndpointParameter.Properties.name);
		propertiesStep.addStep(EsbViewsRepository.InboundEndpointParameter.Properties.value);
		propertiesStep.addStep(EsbViewsRepository.InboundEndpointParameter.Properties.type);
		propertiesStep.addStep(EsbViewsRepository.InboundEndpointParameter.Properties.key);
		
		composer = new PartComposer(inboundEndpointParameterStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.InboundEndpointParameter.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.InboundEndpointParameter.Properties.name) {
					return createNameText(parent);
				}
				if (key == EsbViewsRepository.InboundEndpointParameter.Properties.value) {
					return createValueText(parent);
				}
				if (key == EsbViewsRepository.InboundEndpointParameter.Properties.type) {
					return createTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.InboundEndpointParameter.Properties.key) {
//					return createStaticReferenceKey(widgetFactory, referingSequenceSubsection);
					return createSchemaRegistryKeyWidget(parent);
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
		propertiesGroup.setText(EsbMessages.InboundEndpointParameterPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.InboundEndpointParameter.Properties.name, EsbMessages.InboundEndpointParameterPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InboundEndpointParameterPropertiesEditionPartImpl.this, EsbViewsRepository.InboundEndpointParameter.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyReleased(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InboundEndpointParameterPropertiesEditionPartImpl.this, EsbViewsRepository.InboundEndpointParameter.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EsbViewsRepository.InboundEndpointParameter.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.InboundEndpointParameter.Properties.name, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.InboundEndpointParameter.Properties.value, EsbMessages.InboundEndpointParameterPropertiesEditionPart_ValueLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InboundEndpointParameterPropertiesEditionPartImpl.this, EsbViewsRepository.InboundEndpointParameter.Properties.value, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, value.getText()));
			}

		});
		value.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyReleased(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InboundEndpointParameterPropertiesEditionPartImpl.this, EsbViewsRepository.InboundEndpointParameter.Properties.value, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, value.getText()));
				}
			}

		});
		EditingUtils.setID(value, EsbViewsRepository.InboundEndpointParameter.Properties.value);
		EditingUtils.setEEFtype(value, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.InboundEndpointParameter.Properties.value, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueText

		// End of user code
		return parent;
	}


	protected Composite createTypeEMFComboViewer(Composite parent) {
    createDescription(parent, EsbViewsRepository.InboundEndpointParameter.Properties.type, EsbMessages.SequencePropertiesEditionPart_ReferringSequenceTypeLabel);
    type = new EMFComboViewer(parent);
    type.setContentProvider(new ArrayContentProvider());
    type.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
    type.getCombo().setLayoutData(typeData);
    type.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent
				  (InboundEndpointParameterPropertiesEditionPartImpl.this, EsbViewsRepository.InboundEndpointParameter
						  .Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getType()));
      }

    });
    type.setID(EsbViewsRepository.InboundEndpointParameter.Properties.type);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository
			.InboundEndpointParameter.Properties.type, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createTypeEMFComboViewer

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

	// Start of user code for staticReferenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getKey() {
        return key;
    }

    @Override
    public void setKey(RegistryKeyProperty registryKeyProperty) {
        if(registryKeyProperty != null) {
            keyText.setText(registryKeyProperty.getKeyValue());
            key = registryKeyProperty;
        }
    }

    
    protected Composite createSchemaRegistryKeyWidget(final Composite parent) {
        if (key == null) {
            key = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        } 
        String initValueExpression = key.getKeyValue().isEmpty() ? "" : key.getKeyValue();
		keyText = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData keyTextData = new GridData(GridData.FILL_HORIZONTAL);
		keyText.setLayoutData(keyTextData);

        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        keyText.setLayoutData(valueData);
		keyText.setText(initValueExpression);
        
        keyText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                openCreateSchemaRegistryKeyNPE(parent);
            }

        });

        keyText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openCreateSchemaRegistryKeyNPE(parent);
                }
            }

        });
        
        EditingUtils.setID(keyText, EsbViewsRepository.InboundEndpointParameter.Properties.key);
        EditingUtils.setEEFtype(keyText, "eef::Text");
//        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.JsonTransformMediator.Properties.schema, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        return parent;
    }
    
    private void openCreateSchemaRegistryKeyNPE(final Composite parent) {
        EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(), SWT.NULL,
                key, new ArrayList<NamedEntityDescriptor>());
        dialog.open();
        keyText.setText(key.getKeyValue());
        propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(InboundEndpointParameterPropertiesEditionPartImpl.this,
                		EsbViewsRepository.InboundEndpointParameter.Properties.key, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getKey()));
    }
    
    // End of user code
    

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.InboundEndpointParameter.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EsbMessages.InboundEndpointParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart#getValue()
	 * 
	 */
	public String getValue() {
		return value.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart#setValue(String newValue)
	 * 
	 */
	public void setValue(String newValue) {
		if (newValue != null) {
			value.setText(newValue);
		} else {
			value.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.InboundEndpointParameter.Properties.value);
		if (eefElementEditorReadOnlyState && value.isEnabled()) {
			value.setEnabled(false);
			value.setToolTipText(EsbMessages.InboundEndpointParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !value.isEnabled()) {
			value.setEnabled(true);
		}	
		
	}






	/**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart#getType()
   * 
   */
  public Enumerator getType() {
    Enumerator selection = (Enumerator) ((StructuredSelection) type.getSelection()).getFirstElement();
    return selection;
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart#initType(Object input, Enumerator current)
   */
  public void initType(Object input, Enumerator current) {
    type.setInput(input);
    type.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.InboundEndpointParameter.Properties.type);
    if (eefElementEditorReadOnlyState && type.isEnabled()) {
      type.setEnabled(false);
      type.setToolTipText(EsbMessages.InboundEndpointParameter_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !type.isEnabled()) {
      type.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart#setType(Enumerator newValue)
   * 
   */
  public void setType(Enumerator newValue) {
    type.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.InboundEndpointParameter.Properties.type);
    if (eefElementEditorReadOnlyState && type.isEnabled()) {
      type.setEnabled(false);
      type.setToolTipText(EsbMessages.InboundEndpointParameter_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !type.isEnabled()) {
      type.setEnabled(true);
    }	
    
  }

  /**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.InboundEndpointParameter_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
