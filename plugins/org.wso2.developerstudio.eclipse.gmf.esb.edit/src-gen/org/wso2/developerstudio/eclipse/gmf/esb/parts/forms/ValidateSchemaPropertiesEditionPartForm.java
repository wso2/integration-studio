/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EcoreAdapterFactory;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ValidateSchemaPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ValidateSchemaPropertiesEditionPart {

	protected EMFComboViewer validateSchemaKeyType;
	protected EObjectFlatComboViewer schemaKey;
	// Start of user code  for staticSchemaKey widgets declarations
	
	// End of user code

	// Start of user code  for dynamicSchemaKey widgets declarations
	
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public ValidateSchemaPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ValidateSchemaPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
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
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType) {
					return createValidateSchemaKeyTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ValidateSchema.Properties.schemaKey) {
					return createSchemaKeyFlatComboViewer(parent, widgetFactory);
				}
				// Start of user code for staticSchemaKey addToPart creation
				
				// End of user code
				// Start of user code for dynamicSchemaKey addToPart creation
				
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.ValidateSchemaPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createValidateSchemaKeyTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType, EsbMessages.ValidateSchemaPropertiesEditionPart_ValidateSchemaKeyTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateSchemaPropertiesEditionPartForm.this, EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValidateSchemaKeyType()));
			}

		});
		validateSchemaKeyType.setID(EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValidateSchemaKeyTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createSchemaKeyFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EsbViewsRepository.ValidateSchema.Properties.schemaKey, EsbMessages.ValidateSchemaPropertiesEditionPart_SchemaKeyLabel);
		schemaKey = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EsbViewsRepository.ValidateSchema.Properties.schemaKey, EsbViewsRepository.FORM_KIND));
		widgetFactory.adapt(schemaKey);
		schemaKey.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData schemaKeyData = new GridData(GridData.FILL_HORIZONTAL);
		schemaKey.setLayoutData(schemaKeyData);
		schemaKey.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateSchemaPropertiesEditionPartForm.this, EsbViewsRepository.ValidateSchema.Properties.schemaKey, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSchemaKey()));
			}

		});
		schemaKey.setID(EsbViewsRepository.ValidateSchema.Properties.schemaKey);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateSchema.Properties.schemaKey, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSchemaKeyFlatComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#getValidateSchemaKeyType()
	 * 
	 */
	public Enumerator getValidateSchemaKeyType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) validateSchemaKeyType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#initValidateSchemaKeyType(Object input, Enumerator current)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#setValidateSchemaKeyType(Enumerator newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#getSchemaKey()
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#initSchemaKey(EObjectFlatComboSettings)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#setSchemaKey(EObject newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#setSchemaKeyButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSchemaKeyButtonMode(ButtonsModeEnum newValue) {
		schemaKey.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#addFilterSchemaKey(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSchemaKey(ViewerFilter filter) {
		schemaKey.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart#addBusinessFilterSchemaKey(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSchemaKey(ViewerFilter filter) {
		schemaKey.addBusinessRuleFilter(filter);
	}






	// Start of user code for staticSchemaKey specific getters and setters implementation
	
	// End of user code

	// Start of user code for dynamicSchemaKey specific getters and setters implementation
	
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

    @Override
    public RegistryKeyProperty getStaticSchemaKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setStaticSchemaKey(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public NamespacedProperty getDynamicSchemaKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDynamicSchemaKey(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }
	// End of user code


}
