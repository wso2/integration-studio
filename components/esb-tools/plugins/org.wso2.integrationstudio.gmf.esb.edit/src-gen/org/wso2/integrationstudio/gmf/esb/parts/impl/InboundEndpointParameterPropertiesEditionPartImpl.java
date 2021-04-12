/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
import org.eclipse.emf.eef.runtime.ui.providers.EMFListContentProvider;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;
import org.wso2.integrationstudio.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart;
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
	protected EMFComboViewer inboundEndpointParameterType;
	protected Text inboundParamKeyText;
  protected Text value;
  	Group propertiesGroup;
  	Control [] nameElements;
  	Control [] paramTypeElements;
  	Control [] valueElements;
  	Control [] paramKeyElements;
  	RegistryKeyProperty inboundEndpointParamKey;


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
		propertiesStep.addStep(EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterType);
		propertiesStep.addStep(EsbViewsRepository.InboundEndpointParameter.Properties.value);
		propertiesStep.addStep(EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterKey);
		
		composer = new PartComposer(inboundEndpointParameterStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.InboundEndpointParameter.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.InboundEndpointParameter.Properties.name) {
					return createNameText(parent);
				}
				if (key == EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterType) {
					return createInboundEndpointParameterTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.InboundEndpointParameter.Properties.value) {
					return createValueText(parent);
				}
				if (key == EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterKey) {
					return createInboundEndpointParamKey(parent);
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
		propertiesGroup = new Group(parent, SWT.NONE);
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
		Control nameTextLabel = createDescription(parent, EsbViewsRepository.InboundEndpointParameter.Properties.name, EsbMessages.InboundEndpointParameterPropertiesEditionPart_NameLabel);
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
		Control nameHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.InboundEndpointParameter.Properties.name, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText
		nameElements = new Control[] { nameTextLabel, name, nameHelp };
		// End of user code
		return parent;
	}

	protected Composite createInboundEndpointParameterTypeEMFComboViewer(Composite parent) {
	Control paramTypeLabel = createDescription(parent, EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterType, EsbMessages.InboundEndpointParameterPropertiesEditionPart_InboundEndpointParameterTypeLabel);
    inboundEndpointParameterType = new EMFComboViewer(parent);
    GridData inboundEndpointParameterTypeData = new GridData(GridData.FILL_HORIZONTAL);
    inboundEndpointParameterType.getCombo().setLayoutData(inboundEndpointParameterTypeData);
    inboundEndpointParameterType.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
    inboundEndpointParameterType.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(InboundEndpointParameterPropertiesEditionPartImpl.this, EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInboundEndpointParameterType()));
        
      }

    });
    inboundEndpointParameterType.setContentProvider(new EMFListContentProvider());
    EditingUtils.setID(inboundEndpointParameterType.getCombo(), EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterType);
    EditingUtils.setEEFtype(inboundEndpointParameterType.getCombo(), "eef::Combo"); //$NON-NLS-1$
    Control paramTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createInboundEndpointParameterTypeEMFComboViewer
    
    inboundEndpointParameterType.addSelectionChangedListener(new ISelectionChangedListener() {
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
		   validate();
		}
	});
    
    
	paramTypeElements = new Control[] { paramTypeLabel, inboundEndpointParameterType.getCombo(), paramTypeHelp };
    // End of user code
    return parent;
  }

  /**
	 * @generated NOT
	 */
	protected Composite createValueText(Composite parent) {
		Control valueTextLabel = createDescription(parent, EsbViewsRepository.InboundEndpointParameter.Properties.value, EsbMessages.InboundEndpointParameterPropertiesEditionPart_ValueLabel);
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
		Control valueHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.InboundEndpointParameter.Properties.value, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueText
		valueElements = new Control[] { valueTextLabel, value, valueHelp };
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
   * @see org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart#getInboundEndpointParameterType()
   * 
   */
  public Enumerator getInboundEndpointParameterType() {
	  Enumerator selection = (Enumerator) ((StructuredSelection) inboundEndpointParameterType.getSelection()).getFirstElement();
		return selection;
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart#initInboundEndpointParameterType(Object input, Object currentValue)
   */
  public void initInboundEndpointParameterType(Object input, Object currentValue) {
    inboundEndpointParameterType.setInput(input);
    if (currentValue != null) {
      inboundEndpointParameterType.setSelection(new StructuredSelection(currentValue));
    }
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart#setInboundEndpointParameterType(Object newValue)
   * 
   */
  public void setInboundEndpointParameterType(Object newValue) {
    if (newValue != null) {
      inboundEndpointParameterType.modelUpdating(new StructuredSelection(newValue));
    } else {
      inboundEndpointParameterType.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterType);
    if (eefElementEditorReadOnlyState && inboundEndpointParameterType.isEnabled()) {
      inboundEndpointParameterType.setEnabled(false);
      inboundEndpointParameterType.setToolTipText(EsbMessages.InboundEndpointParameter_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !inboundEndpointParameterType.isEnabled()) {
      inboundEndpointParameterType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.gmf.esb.parts.InboundEndpointParameterPropertiesEditionPart#addFilterInboundEndpointParameterType(ViewerFilter filter)
   * 
   */
  public void addFilterToInboundEndpointParameterType(ViewerFilter filter) {
    inboundEndpointParameterType.addFilter(filter);
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
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.InboundEndpointParameter_Part_Title;
	}

	@Override
	public RegistryKeyProperty getInboundEndpointParameterKey() {
		return inboundEndpointParamKey;
	}

	@Override
	public void setInboundEndpointParameterKey(RegistryKeyProperty registryKeyProperty) {
		if(registryKeyProperty != null) {
			inboundParamKeyText.setText(registryKeyProperty.getKeyValue());
			inboundEndpointParamKey = registryKeyProperty;
			inboundEndpointParameterType.getCombo().select(1);
			validate();
        }
		
	}


	// Start of user code additional methods
	protected Composite createInboundEndpointParamKey(Composite parent) {
		Control staticKeyLabel = createDescription(parent,
				EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterKey,
				EsbMessages.InboundEndpointParameterPropertiesEditionPart_InboundEndpointParameterKeyLabel);

		if (inboundEndpointParamKey == null) {
			inboundEndpointParamKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = inboundEndpointParamKey.getKeyValue().isEmpty() ? "" : inboundEndpointParamKey.getKeyValue();
		inboundParamKeyText = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		inboundParamKeyText.setLayoutData(nameData);
		inboundParamKeyText.setText(inboundEndpointParamKey.getKeyValue());
		inboundParamKeyText.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
						SWT.NULL, inboundEndpointParamKey, new ArrayList<NamedEntityDescriptor>());
				dialog.open();
				inboundParamKeyText.setText(inboundEndpointParamKey.getKeyValue());
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						InboundEndpointParameterPropertiesEditionPartImpl.this,
						EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterKey, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, null, getInboundEndpointParameterKey()));
			}
			
			
		});
		EditingUtils.setID(inboundParamKeyText, EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterKey);
		EditingUtils.setEEFtype(inboundParamKeyText, "eef::Text");
		Control keyHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
				EsbViewsRepository.InboundEndpointParameter.Properties.inboundEndpointParameterKey, EsbViewsRepository.SWT_KIND), null); // $NON-NLS-1$

		paramKeyElements = new Control[] { staticKeyLabel, inboundParamKeyText, keyHelp };
		return parent;
	}
	
	
	@Override
    public void refresh() {
		super.refresh();
		if (getInboundEndpointParameterType() != null)
			validate();
	}
	
	EEFPropertyViewUtil viewUtil = new EEFPropertyViewUtil(view);

	public void validate() {
		viewUtil.clearElements(new Composite[] { propertiesGroup });

		viewUtil.showEntry(nameElements, false);
		viewUtil.showEntry(paramTypeElements, false);

		if (getInboundEndpointParameterType().getName().equals("STATIC")) {
			viewUtil.showEntry(valueElements, false);
		} else{
			viewUtil.showEntry(paramKeyElements, false);
		}
		view.layout(true, true);
	}
	// End of user code


}
