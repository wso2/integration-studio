/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

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

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateEndpointParameterPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class TemplateEndpointParameterPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, TemplateEndpointParameterPropertiesEditionPart {

	protected Text parameterName;
	protected Text parameterValue;



	/**
	 * For {@link ISection} use only.
	 */
	public TemplateEndpointParameterPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TemplateEndpointParameterPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence templateEndpointParameterStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = templateEndpointParameterStep.addStep(EsbViewsRepository.TemplateEndpointParameter.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue);
		
		
		composer = new PartComposer(templateEndpointParameterStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.TemplateEndpointParameter.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName) {
					return createParameterNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue) {
					return createParameterValueText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.TemplateEndpointParameterPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createParameterNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName, EsbMessages.TemplateEndpointParameterPropertiesEditionPart_ParameterNameLabel);
		parameterName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		parameterName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData parameterNameData = new GridData(GridData.FILL_HORIZONTAL);
		parameterName.setLayoutData(parameterNameData);
		parameterName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							TemplateEndpointParameterPropertiesEditionPartForm.this,
							EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									TemplateEndpointParameterPropertiesEditionPartForm.this,
									EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, parameterName.getText()));
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
									TemplateEndpointParameterPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		parameterName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointParameterPropertiesEditionPartForm.this, EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterName.getText()));
				}
			}
		});
		EditingUtils.setID(parameterName, EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName);
		EditingUtils.setEEFtype(parameterName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createParameterNameText

		// End of user code
		return parent;
	}

	
	protected Composite createParameterValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue, EsbMessages.TemplateEndpointParameterPropertiesEditionPart_ParameterValueLabel);
		parameterValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		parameterValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData parameterValueData = new GridData(GridData.FILL_HORIZONTAL);
		parameterValue.setLayoutData(parameterValueData);
		parameterValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							TemplateEndpointParameterPropertiesEditionPartForm.this,
							EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									TemplateEndpointParameterPropertiesEditionPartForm.this,
									EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, parameterValue.getText()));
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
									TemplateEndpointParameterPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		parameterValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointParameterPropertiesEditionPartForm.this, EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterValue.getText()));
				}
			}
		});
		EditingUtils.setID(parameterValue, EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue);
		EditingUtils.setEEFtype(parameterValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createParameterValueText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateEndpointParameterPropertiesEditionPart#getParameterName()
	 * 
	 */
	public String getParameterName() {
		return parameterName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateEndpointParameterPropertiesEditionPart#setParameterName(String newValue)
	 * 
	 */
	public void setParameterName(String newValue) {
		if (newValue != null) {
			parameterName.setText(newValue);
		} else {
			parameterName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpointParameter.Properties.parameterName);
		if (eefElementEditorReadOnlyState && parameterName.isEnabled()) {
			parameterName.setEnabled(false);
			parameterName.setToolTipText(EsbMessages.TemplateEndpointParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterName.isEnabled()) {
			parameterName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateEndpointParameterPropertiesEditionPart#getParameterValue()
	 * 
	 */
	public String getParameterValue() {
		return parameterValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateEndpointParameterPropertiesEditionPart#setParameterValue(String newValue)
	 * 
	 */
	public void setParameterValue(String newValue) {
		if (newValue != null) {
			parameterValue.setText(newValue);
		} else {
			parameterValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpointParameter.Properties.parameterValue);
		if (eefElementEditorReadOnlyState && parameterValue.isEnabled()) {
			parameterValue.setEnabled(false);
			parameterValue.setToolTipText(EsbMessages.TemplateEndpointParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterValue.isEnabled()) {
			parameterValue.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.TemplateEndpointParameter_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
