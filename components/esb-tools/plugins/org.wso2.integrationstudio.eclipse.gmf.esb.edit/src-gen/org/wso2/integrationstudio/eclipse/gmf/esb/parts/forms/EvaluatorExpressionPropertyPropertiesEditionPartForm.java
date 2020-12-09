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

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class EvaluatorExpressionPropertyPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, EvaluatorExpressionPropertyPropertiesEditionPart {

	protected Text prettyName;
	protected Text evaluatorName;
	protected Text evaluatorValue;



	/**
	 * For {@link ISection} use only.
	 */
	public EvaluatorExpressionPropertyPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EvaluatorExpressionPropertyPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence evaluatorExpressionPropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = evaluatorExpressionPropertyStep.addStep(EsbViewsRepository.EvaluatorExpressionProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName);
		propertiesStep.addStep(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName);
		propertiesStep.addStep(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue);
		
		
		composer = new PartComposer(evaluatorExpressionPropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.EvaluatorExpressionProperty.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName) {
					return createPrettyNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName) {
					return createEvaluatorNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue) {
					return createEvaluatorValueText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.EvaluatorExpressionPropertyPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createPrettyNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName, EsbMessages.EvaluatorExpressionPropertyPropertiesEditionPart_PrettyNameLabel);
		prettyName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		prettyName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData prettyNameData = new GridData(GridData.FILL_HORIZONTAL);
		prettyName.setLayoutData(prettyNameData);
		prettyName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EvaluatorExpressionPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, prettyName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EvaluatorExpressionPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, prettyName.getText()));
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
									EvaluatorExpressionPropertyPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		prettyName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvaluatorExpressionPropertyPropertiesEditionPartForm.this, EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, prettyName.getText()));
				}
			}
		});
		EditingUtils.setID(prettyName, EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName);
		EditingUtils.setEEFtype(prettyName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPrettyNameText

		// End of user code
		return parent;
	}

	
	protected Composite createEvaluatorNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName, EsbMessages.EvaluatorExpressionPropertyPropertiesEditionPart_EvaluatorNameLabel);
		evaluatorName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		evaluatorName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData evaluatorNameData = new GridData(GridData.FILL_HORIZONTAL);
		evaluatorName.setLayoutData(evaluatorNameData);
		evaluatorName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EvaluatorExpressionPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, evaluatorName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EvaluatorExpressionPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, evaluatorName.getText()));
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
									EvaluatorExpressionPropertyPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		evaluatorName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvaluatorExpressionPropertyPropertiesEditionPartForm.this, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, evaluatorName.getText()));
				}
			}
		});
		EditingUtils.setID(evaluatorName, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName);
		EditingUtils.setEEFtype(evaluatorName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEvaluatorNameText

		// End of user code
		return parent;
	}

	
	protected Composite createEvaluatorValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue, EsbMessages.EvaluatorExpressionPropertyPropertiesEditionPart_EvaluatorValueLabel);
		evaluatorValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		evaluatorValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData evaluatorValueData = new GridData(GridData.FILL_HORIZONTAL);
		evaluatorValue.setLayoutData(evaluatorValueData);
		evaluatorValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EvaluatorExpressionPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, evaluatorValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EvaluatorExpressionPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, evaluatorValue.getText()));
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
									EvaluatorExpressionPropertyPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		evaluatorValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvaluatorExpressionPropertyPropertiesEditionPartForm.this, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, evaluatorValue.getText()));
				}
			}
		});
		EditingUtils.setID(evaluatorValue, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue);
		EditingUtils.setEEFtype(evaluatorValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEvaluatorValueText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#getPrettyName()
	 * 
	 */
	public String getPrettyName() {
		return prettyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#setPrettyName(String newValue)
	 * 
	 */
	public void setPrettyName(String newValue) {
		if (newValue != null) {
			prettyName.setText(newValue);
		} else {
			prettyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName);
		if (eefElementEditorReadOnlyState && prettyName.isEnabled()) {
			prettyName.setEnabled(false);
			prettyName.setToolTipText(EsbMessages.EvaluatorExpressionProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !prettyName.isEnabled()) {
			prettyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#getEvaluatorName()
	 * 
	 */
	public String getEvaluatorName() {
		return evaluatorName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#setEvaluatorName(String newValue)
	 * 
	 */
	public void setEvaluatorName(String newValue) {
		if (newValue != null) {
			evaluatorName.setText(newValue);
		} else {
			evaluatorName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName);
		if (eefElementEditorReadOnlyState && evaluatorName.isEnabled()) {
			evaluatorName.setEnabled(false);
			evaluatorName.setToolTipText(EsbMessages.EvaluatorExpressionProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !evaluatorName.isEnabled()) {
			evaluatorName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#getEvaluatorValue()
	 * 
	 */
	public String getEvaluatorValue() {
		return evaluatorValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#setEvaluatorValue(String newValue)
	 * 
	 */
	public void setEvaluatorValue(String newValue) {
		if (newValue != null) {
			evaluatorValue.setText(newValue);
		} else {
			evaluatorValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue);
		if (eefElementEditorReadOnlyState && evaluatorValue.isEnabled()) {
			evaluatorValue.setEnabled(false);
			evaluatorValue.setToolTipText(EsbMessages.EvaluatorExpressionProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !evaluatorValue.isEnabled()) {
			evaluatorValue.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.EvaluatorExpressionProperty_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
