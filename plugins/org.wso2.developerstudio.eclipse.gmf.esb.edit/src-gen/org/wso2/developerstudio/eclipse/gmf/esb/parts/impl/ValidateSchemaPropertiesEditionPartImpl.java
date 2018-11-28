/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

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

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ValidateSchemaPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ValidateSchemaPropertiesEditionPart {

	protected EMFComboViewer validateSchemaKeyType;
	protected EObjectFlatComboViewer schemaKey;



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
		propertiesGroup.setText(EsbMessages.ValidateSchemaPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createValidateSchemaKeyTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType, EsbMessages.ValidateSchemaPropertiesEditionPart_ValidateSchemaKeyTypeLabel);
		validateSchemaKeyType = new EMFComboViewer(parent);
		validateSchemaKeyType.setContentProvider(new ArrayContentProvider());
		validateSchemaKeyType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData validateSchemaKeyTypeData = new GridData(GridData.FILL_HORIZONTAL);
		validateSchemaKeyType.getCombo().setLayoutData(validateSchemaKeyTypeData);
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
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValidateSchemaKeyTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createSchemaKeyFlatComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ValidateSchema.Properties.schemaKey, EsbMessages.ValidateSchemaPropertiesEditionPart_SchemaKeyLabel);
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
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateSchema.Properties.schemaKey, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	
	// End of user code


}
