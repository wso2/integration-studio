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
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RegistryKeyPropertyPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class RegistryKeyPropertyPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, RegistryKeyPropertyPropertiesEditionPart {

	protected Text prettyName;
	protected Text keyName;
	protected Text keyValue;
	protected Text filters;



	/**
	 * For {@link ISection} use only.
	 */
	public RegistryKeyPropertyPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RegistryKeyPropertyPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence registryKeyPropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = registryKeyPropertyStep.addStep(EsbViewsRepository.RegistryKeyProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.RegistryKeyProperty.Properties.prettyName);
		propertiesStep.addStep(EsbViewsRepository.RegistryKeyProperty.Properties.keyName);
		propertiesStep.addStep(EsbViewsRepository.RegistryKeyProperty.Properties.keyValue);
		propertiesStep.addStep(EsbViewsRepository.RegistryKeyProperty.Properties.filters);
		
		
		composer = new PartComposer(registryKeyPropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RegistryKeyProperty.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RegistryKeyProperty.Properties.prettyName) {
					return createPrettyNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RegistryKeyProperty.Properties.keyName) {
					return createKeyNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RegistryKeyProperty.Properties.keyValue) {
					return createKeyValueText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RegistryKeyProperty.Properties.filters) {
					return createFiltersText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.RegistryKeyPropertyPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.RegistryKeyProperty.Properties.prettyName, EsbMessages.RegistryKeyPropertyPropertiesEditionPart_PrettyNameLabel);
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
							RegistryKeyPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.RegistryKeyProperty.Properties.prettyName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, prettyName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RegistryKeyPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.RegistryKeyProperty.Properties.prettyName,
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
									RegistryKeyPropertyPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RegistryKeyPropertyPropertiesEditionPartForm.this, EsbViewsRepository.RegistryKeyProperty.Properties.prettyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, prettyName.getText()));
				}
			}
		});
		EditingUtils.setID(prettyName, EsbViewsRepository.RegistryKeyProperty.Properties.prettyName);
		EditingUtils.setEEFtype(prettyName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RegistryKeyProperty.Properties.prettyName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPrettyNameText

		// End of user code
		return parent;
	}

	
	protected Composite createKeyNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RegistryKeyProperty.Properties.keyName, EsbMessages.RegistryKeyPropertyPropertiesEditionPart_KeyNameLabel);
		keyName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		keyName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData keyNameData = new GridData(GridData.FILL_HORIZONTAL);
		keyName.setLayoutData(keyNameData);
		keyName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RegistryKeyPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.RegistryKeyProperty.Properties.keyName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, keyName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RegistryKeyPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.RegistryKeyProperty.Properties.keyName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, keyName.getText()));
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
									RegistryKeyPropertyPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		keyName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RegistryKeyPropertyPropertiesEditionPartForm.this, EsbViewsRepository.RegistryKeyProperty.Properties.keyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, keyName.getText()));
				}
			}
		});
		EditingUtils.setID(keyName, EsbViewsRepository.RegistryKeyProperty.Properties.keyName);
		EditingUtils.setEEFtype(keyName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RegistryKeyProperty.Properties.keyName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createKeyNameText

		// End of user code
		return parent;
	}

	
	protected Composite createKeyValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RegistryKeyProperty.Properties.keyValue, EsbMessages.RegistryKeyPropertyPropertiesEditionPart_KeyValueLabel);
		keyValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		keyValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData keyValueData = new GridData(GridData.FILL_HORIZONTAL);
		keyValue.setLayoutData(keyValueData);
		keyValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RegistryKeyPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.RegistryKeyProperty.Properties.keyValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, keyValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RegistryKeyPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.RegistryKeyProperty.Properties.keyValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, keyValue.getText()));
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
									RegistryKeyPropertyPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		keyValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RegistryKeyPropertyPropertiesEditionPartForm.this, EsbViewsRepository.RegistryKeyProperty.Properties.keyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, keyValue.getText()));
				}
			}
		});
		EditingUtils.setID(keyValue, EsbViewsRepository.RegistryKeyProperty.Properties.keyValue);
		EditingUtils.setEEFtype(keyValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RegistryKeyProperty.Properties.keyValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createKeyValueText

		// End of user code
		return parent;
	}

	
	protected Composite createFiltersText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RegistryKeyProperty.Properties.filters, EsbMessages.RegistryKeyPropertyPropertiesEditionPart_FiltersLabel);
		filters = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		filters.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData filtersData = new GridData(GridData.FILL_HORIZONTAL);
		filters.setLayoutData(filtersData);
		filters.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RegistryKeyPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.RegistryKeyProperty.Properties.filters,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, filters.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RegistryKeyPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.RegistryKeyProperty.Properties.filters,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, filters.getText()));
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
									RegistryKeyPropertyPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		filters.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RegistryKeyPropertyPropertiesEditionPartForm.this, EsbViewsRepository.RegistryKeyProperty.Properties.filters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, filters.getText()));
				}
			}
		});
		EditingUtils.setID(filters, EsbViewsRepository.RegistryKeyProperty.Properties.filters);
		EditingUtils.setEEFtype(filters, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RegistryKeyProperty.Properties.filters, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFiltersText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RegistryKeyPropertyPropertiesEditionPart#getPrettyName()
	 * 
	 */
	public String getPrettyName() {
		return prettyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RegistryKeyPropertyPropertiesEditionPart#setPrettyName(String newValue)
	 * 
	 */
	public void setPrettyName(String newValue) {
		if (newValue != null) {
			prettyName.setText(newValue);
		} else {
			prettyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RegistryKeyProperty.Properties.prettyName);
		if (eefElementEditorReadOnlyState && prettyName.isEnabled()) {
			prettyName.setEnabled(false);
			prettyName.setToolTipText(EsbMessages.RegistryKeyProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !prettyName.isEnabled()) {
			prettyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RegistryKeyPropertyPropertiesEditionPart#getKeyName()
	 * 
	 */
	public String getKeyName() {
		return keyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RegistryKeyPropertyPropertiesEditionPart#setKeyName(String newValue)
	 * 
	 */
	public void setKeyName(String newValue) {
		if (newValue != null) {
			keyName.setText(newValue);
		} else {
			keyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RegistryKeyProperty.Properties.keyName);
		if (eefElementEditorReadOnlyState && keyName.isEnabled()) {
			keyName.setEnabled(false);
			keyName.setToolTipText(EsbMessages.RegistryKeyProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !keyName.isEnabled()) {
			keyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RegistryKeyPropertyPropertiesEditionPart#getKeyValue()
	 * 
	 */
	public String getKeyValue() {
		return keyValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RegistryKeyPropertyPropertiesEditionPart#setKeyValue(String newValue)
	 * 
	 */
	public void setKeyValue(String newValue) {
		if (newValue != null) {
			keyValue.setText(newValue);
		} else {
			keyValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RegistryKeyProperty.Properties.keyValue);
		if (eefElementEditorReadOnlyState && keyValue.isEnabled()) {
			keyValue.setEnabled(false);
			keyValue.setToolTipText(EsbMessages.RegistryKeyProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !keyValue.isEnabled()) {
			keyValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RegistryKeyPropertyPropertiesEditionPart#getFilters()
	 * 
	 */
	public String getFilters() {
		return filters.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RegistryKeyPropertyPropertiesEditionPart#setFilters(String newValue)
	 * 
	 */
	public void setFilters(String newValue) {
		if (newValue != null) {
			filters.setText(newValue);
		} else {
			filters.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RegistryKeyProperty.Properties.filters);
		if (eefElementEditorReadOnlyState && filters.isEnabled()) {
			filters.setEnabled(false);
			filters.setToolTipText(EsbMessages.RegistryKeyProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !filters.isEnabled()) {
			filters.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.RegistryKeyProperty_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
