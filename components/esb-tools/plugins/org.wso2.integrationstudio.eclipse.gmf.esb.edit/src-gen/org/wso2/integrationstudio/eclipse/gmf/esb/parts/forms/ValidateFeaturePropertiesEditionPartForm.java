/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
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

import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateFeaturePropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ValidateFeaturePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ValidateFeaturePropertiesEditionPart {

	protected Text featureName;
	protected Button featureEnabled;



	/**
	 * For {@link ISection} use only.
	 */
	public ValidateFeaturePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ValidateFeaturePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence validateFeatureStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = validateFeatureStep.addStep(EsbViewsRepository.ValidateFeature.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ValidateFeature.Properties.featureName);
		propertiesStep.addStep(EsbViewsRepository.ValidateFeature.Properties.featureEnabled);
		
		
		composer = new PartComposer(validateFeatureStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ValidateFeature.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ValidateFeature.Properties.featureName) {
					return createFeatureNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ValidateFeature.Properties.featureEnabled) {
					return createFeatureEnabledCheckbox(widgetFactory, parent);
				}
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
		propertiesSection.setText(EsbMessages.ValidateFeaturePropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createFeatureNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ValidateFeature.Properties.featureName, EsbMessages.ValidateFeaturePropertiesEditionPart_FeatureNameLabel);
		featureName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		featureName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData featureNameData = new GridData(GridData.FILL_HORIZONTAL);
		featureName.setLayoutData(featureNameData);
		featureName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ValidateFeaturePropertiesEditionPartForm.this,
							EsbViewsRepository.ValidateFeature.Properties.featureName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, featureName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ValidateFeaturePropertiesEditionPartForm.this,
									EsbViewsRepository.ValidateFeature.Properties.featureName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, featureName.getText()));
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
									ValidateFeaturePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		featureName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateFeaturePropertiesEditionPartForm.this, EsbViewsRepository.ValidateFeature.Properties.featureName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, featureName.getText()));
				}
			}
		});
		EditingUtils.setID(featureName, EsbViewsRepository.ValidateFeature.Properties.featureName);
		EditingUtils.setEEFtype(featureName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateFeature.Properties.featureName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFeatureNameText

		// End of user code
		return parent;
	}

	
	protected Composite createFeatureEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		featureEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ValidateFeature.Properties.featureEnabled, EsbMessages.ValidateFeaturePropertiesEditionPart_FeatureEnabledLabel), SWT.CHECK);
		featureEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateFeaturePropertiesEditionPartForm.this, EsbViewsRepository.ValidateFeature.Properties.featureEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(featureEnabled.getSelection())));
			}

		});
		GridData featureEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		featureEnabledData.horizontalSpan = 2;
		featureEnabled.setLayoutData(featureEnabledData);
		EditingUtils.setID(featureEnabled, EsbViewsRepository.ValidateFeature.Properties.featureEnabled);
		EditingUtils.setEEFtype(featureEnabled, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateFeature.Properties.featureEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFeatureEnabledCheckbox

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateFeaturePropertiesEditionPart#getFeatureName()
	 * 
	 */
	public String getFeatureName() {
		return featureName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateFeaturePropertiesEditionPart#setFeatureName(String newValue)
	 * 
	 */
	public void setFeatureName(String newValue) {
		if (newValue != null) {
			featureName.setText(newValue);
		} else {
			featureName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateFeature.Properties.featureName);
		if (eefElementEditorReadOnlyState && featureName.isEnabled()) {
			featureName.setEnabled(false);
			featureName.setToolTipText(EsbMessages.ValidateFeature_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !featureName.isEnabled()) {
			featureName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateFeaturePropertiesEditionPart#getFeatureEnabled()
	 * 
	 */
	public Boolean getFeatureEnabled() {
		return Boolean.valueOf(featureEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateFeaturePropertiesEditionPart#setFeatureEnabled(Boolean newValue)
	 * 
	 */
	public void setFeatureEnabled(Boolean newValue) {
		if (newValue != null) {
			featureEnabled.setSelection(newValue.booleanValue());
		} else {
			featureEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateFeature.Properties.featureEnabled);
		if (eefElementEditorReadOnlyState && featureEnabled.isEnabled()) {
			featureEnabled.setEnabled(false);
			featureEnabled.setToolTipText(EsbMessages.ValidateFeature_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !featureEnabled.isEnabled()) {
			featureEnabled.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ValidateFeature_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
