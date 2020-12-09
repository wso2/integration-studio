/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

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

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateFeaturePropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ValidateFeaturePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ValidateFeaturePropertiesEditionPart {

	protected Text featureName;
	protected Button featureEnabled;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ValidateFeaturePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence validateFeatureStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = validateFeatureStep.addStep(EsbViewsRepository.ValidateFeature.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ValidateFeature.Properties.featureName);
		propertiesStep.addStep(EsbViewsRepository.ValidateFeature.Properties.featureEnabled);
		
		
		composer = new PartComposer(validateFeatureStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ValidateFeature.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.ValidateFeature.Properties.featureName) {
					return createFeatureNameText(parent);
				}
				if (key == EsbViewsRepository.ValidateFeature.Properties.featureEnabled) {
					return createFeatureEnabledCheckbox(parent);
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
		propertiesGroup.setText(EsbMessages.ValidateFeaturePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createFeatureNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ValidateFeature.Properties.featureName, EsbMessages.ValidateFeaturePropertiesEditionPart_FeatureNameLabel);
		featureName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData featureNameData = new GridData(GridData.FILL_HORIZONTAL);
		featureName.setLayoutData(featureNameData);

		featureName.addKeyListener(new KeyAdapter() {

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
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(ValidateFeaturePropertiesEditionPartImpl.this,
                                        EsbViewsRepository.ValidateFeature.Properties.featureName,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        featureName.getText()));
                    }
                }
			}

		});
		EditingUtils.setID(featureName, EsbViewsRepository.ValidateFeature.Properties.featureName);
		EditingUtils.setEEFtype(featureName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateFeature.Properties.featureName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFeatureNameText

		// End of user code
		return parent;
	}

	
	protected Composite createFeatureEnabledCheckbox(Composite parent) {
		featureEnabled = new Button(parent, SWT.CHECK);
		featureEnabled.setText(getDescription(EsbViewsRepository.ValidateFeature.Properties.featureEnabled, EsbMessages.ValidateFeaturePropertiesEditionPart_FeatureEnabledLabel));
		featureEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateFeaturePropertiesEditionPartImpl.this, EsbViewsRepository.ValidateFeature.Properties.featureEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(featureEnabled.getSelection())));
			}

		});
		GridData featureEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		featureEnabledData.horizontalSpan = 2;
		featureEnabled.setLayoutData(featureEnabledData);
		EditingUtils.setID(featureEnabled, EsbViewsRepository.ValidateFeature.Properties.featureEnabled);
		EditingUtils.setEEFtype(featureEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateFeature.Properties.featureEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
