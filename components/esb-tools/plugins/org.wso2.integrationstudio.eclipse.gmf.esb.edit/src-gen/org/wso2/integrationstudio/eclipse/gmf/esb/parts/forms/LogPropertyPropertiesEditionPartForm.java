/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

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

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.eclipse.gmf.esb.AggregateSequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CompletionMessagesType;
import org.wso2.integrationstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.LogPropertyPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class LogPropertyPropertiesEditionPartForm extends SectionPropertiesEditingPart
		implements IFormPropertiesEditionPart, LogPropertyPropertiesEditionPart {

	protected Text propertyName;
	protected EMFComboViewer propertyValueType;
	protected Text propertyValue;
	// Start of user code for propertyExpression widgets declarations
	protected NamespacedProperty propertyExpression;
	protected Text propertyExpressionText;
	protected Control[] propertyNameElements;
	protected Control[] propertyValueTypeElements;
	protected Control[] propertyExpressionTypeElements;
	protected Control[] propertyValueElements;
	Composite propertiesGroup;
	// End of user code

	/**
	 * For {@link ISection} use only.
	 */
	public LogPropertyPropertiesEditionPartForm() {
		super();
	}

	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *            the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public LogPropertyPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *      createFigure(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.forms.widgets.FormToolkit)
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
	 *      createControls(org.eclipse.ui.forms.widgets.FormToolkit,
	 *      org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence logPropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = logPropertyStep.addStep(EsbViewsRepository.LogProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.LogProperty.Properties.propertyName);
		propertiesStep.addStep(EsbViewsRepository.LogProperty.Properties.propertyValueType);
		propertiesStep.addStep(EsbViewsRepository.LogProperty.Properties.propertyValue);
		propertiesStep.addStep(EsbViewsRepository.LogProperty.Properties.propertyExpression);

		composer = new PartComposer(logPropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.LogProperty.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LogProperty.Properties.propertyName) {
					return createPropertyNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LogProperty.Properties.propertyValueType) {
					return createPropertyValueTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LogProperty.Properties.propertyValue) {
					return createPropertyValueText(widgetFactory, parent);
				}
				// Start of user code for propertyExpression addToPart creation
				if (key == EsbViewsRepository.LogProperty.Properties.propertyExpression) {
					return createPropertyExpressionText(widgetFactory, parent);
				}
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
		Section propertiesSection = widgetFactory.createSection(parent,
				Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.LogPropertyPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createPropertyNameText(FormToolkit widgetFactory, Composite parent) {
		Control propertyNameText = createDescription(parent, EsbViewsRepository.LogProperty.Properties.propertyName,
				EsbMessages.LogPropertyPropertiesEditionPart_PropertyNameLabel);
		propertyName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyNameData = new GridData(GridData.FILL_HORIZONTAL);
		propertyName.setLayoutData(propertyNameData);
		propertyName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LogPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.LogProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT,
							PropertiesEditionEvent.SET, null, propertyName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(LogPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.LogProperty.Properties.propertyName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
									propertyName.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LogPropertyPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
							PropertiesEditionEvent.FOCUS_GAINED, null, null));
				}
			}
		});
		propertyName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
								LogPropertyPropertiesEditionPartForm.this,
								EsbViewsRepository.LogProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT,
								PropertiesEditionEvent.SET, null, propertyName.getText()));
				}
			}
		});
		EditingUtils.setID(propertyName, EsbViewsRepository.LogProperty.Properties.propertyName);
		EditingUtils.setEEFtype(propertyName, "eef::Text"); //$NON-NLS-1$
		Control propertyNameHelp = FormUtils
				.createHelpButton(widgetFactory, parent,
						propertiesEditionComponent.getHelpContent(
								EsbViewsRepository.LogProperty.Properties.propertyName, EsbViewsRepository.FORM_KIND),
						null); // $NON-NLS-1$
		// Start of user code for createPropertyNameText
		propertyNameElements = new Control[] { propertyNameText, propertyName, propertyNameHelp };

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createPropertyValueTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control propertyValueTypeLabel = createDescription(parent,
				EsbViewsRepository.LogProperty.Properties.propertyValueType,
				EsbMessages.LogPropertyPropertiesEditionPart_PropertyValueTypeLabel);
		propertyValueType = new EMFComboViewer(parent);
		propertyValueType.setContentProvider(new ArrayContentProvider());
		propertyValueType
				.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyValueTypeData = new GridData(GridData.FILL_HORIZONTAL);
		propertyValueType.getCombo().setLayoutData(propertyValueTypeData);
                propertyValueType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		propertyValueType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LogPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.LogProperty.Properties.propertyValueType, PropertiesEditionEvent.COMMIT,
							PropertiesEditionEvent.SET, null, getPropertyValueType()));

			}

		});
		propertyValueType.setID(EsbViewsRepository.LogProperty.Properties.propertyValueType);
		Control propertyValueTypeHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogProperty.Properties.propertyValueType,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		// Start of user code for createPropertyValueTypeEMFComboViewer
		propertyValueTypeElements = new Control[] { propertyValueTypeLabel, propertyValueType.getCombo(),
				propertyValueTypeHelp };
		propertyValueType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			    refresh();
			}

		});
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createPropertyValueText(FormToolkit widgetFactory, Composite parent) {
		Control propertyValueTextLabel = createDescription(parent,
				EsbViewsRepository.LogProperty.Properties.propertyValue,
				EsbMessages.LogPropertyPropertiesEditionPart_PropertyValueLabel);
		propertyValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
		propertyValue.setLayoutData(propertyValueData);
		propertyValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LogPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.LogProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT,
							PropertiesEditionEvent.SET, null, propertyValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(LogPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.LogProperty.Properties.propertyValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
									propertyValue.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LogPropertyPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
							PropertiesEditionEvent.FOCUS_GAINED, null, null));
				}
			}
		});
		propertyValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
								LogPropertyPropertiesEditionPartForm.this,
								EsbViewsRepository.LogProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT,
								PropertiesEditionEvent.SET, null, propertyValue.getText()));
				}
			}
		});
		EditingUtils.setID(propertyValue, EsbViewsRepository.LogProperty.Properties.propertyValue);
		EditingUtils.setEEFtype(propertyValue, "eef::Text"); //$NON-NLS-1$
		Control propertyValueHelp = FormUtils
				.createHelpButton(widgetFactory, parent,propertiesEditionComponent.getHelpContent(
								EsbViewsRepository.LogProperty.Properties.propertyValue, EsbViewsRepository.FORM_KIND),null); // $NON-NLS-1$
		// Start of user code for createPropertyValueText
		propertyValueElements = new Control[] { propertyValueTextLabel, propertyValue, propertyValueHelp };
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LogPropertyPropertiesEditionPart#getPropertyName()
	 * 
	 */
	public String getPropertyName() {
		return propertyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LogPropertyPropertiesEditionPart#setPropertyName(String
	 *      newValue)
	 * 
	 */
	public void setPropertyName(String newValue) {
		if (newValue != null) {
			propertyName.setText(newValue);
		} else {
			propertyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LogProperty.Properties.propertyName);
		if (eefElementEditorReadOnlyState && propertyName.isEnabled()) {
			propertyName.setEnabled(false);
			propertyName.setToolTipText(EsbMessages.LogProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyName.isEnabled()) {
			propertyName.setEnabled(true);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LogPropertyPropertiesEditionPart#getPropertyValueType()
	 * 
	 */
	public Enumerator getPropertyValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyValueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LogPropertyPropertiesEditionPart#initPropertyValueType(Object
	 *      input, Enumerator current)
	 */
	public void initPropertyValueType(Object input, Enumerator current) {
		propertyValueType.setInput(input);
		propertyValueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LogProperty.Properties.propertyValueType);
		if (eefElementEditorReadOnlyState && propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(false);
			propertyValueType.setToolTipText(EsbMessages.LogProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(true);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LogPropertyPropertiesEditionPart#setPropertyValueType(Enumerator
	 *      newValue)
	 * 
	 */
	public void setPropertyValueType(Enumerator newValue) {
		propertyValueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LogProperty.Properties.propertyValueType);
		if (eefElementEditorReadOnlyState && propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(false);
			propertyValueType.setToolTipText(EsbMessages.LogProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(true);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LogPropertyPropertiesEditionPart#getPropertyValue()
	 * 
	 */
	public String getPropertyValue() {
		return propertyValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LogPropertyPropertiesEditionPart#setPropertyValue(String
	 *      newValue)
	 * 
	 */
	public void setPropertyValue(String newValue) {
		if (newValue != null) {
			propertyValue.setText(newValue);
		} else {
			propertyValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LogProperty.Properties.propertyValue);
		if (eefElementEditorReadOnlyState && propertyValue.isEnabled()) {
			propertyValue.setEnabled(false);
			propertyValue.setToolTipText(EsbMessages.LogProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValue.isEnabled()) {
			propertyValue.setEnabled(true);
		}

	}

	// Start of user code for propertyExpression specific getters and setters
	// implementation
	@Override
	public NamespacedProperty getExpressionValue() {
		return propertyExpression;
	}

	@Override
	public void setExpressionValue(NamespacedProperty nameSpacedProperty) {
		if (nameSpacedProperty != null) {
			propertyExpressionText.setText(nameSpacedProperty.getPropertyValue());
			propertyExpression = nameSpacedProperty;
		}
	}

	/**
	 * @generated NOT
	 */
	protected Composite createPropertyExpressionText(FormToolkit widgetFactory, Composite parent) {
		Control propertyExpressionTextLabel = createDescription(parent,
				EsbViewsRepository.LogProperty.Properties.propertyExpression,
				EsbMessages.LogPropertyPropertiesEditionPart_PropertyExpressionLabel);
		propertyExpressionText = widgetFactory.createText(parent, "", 8);
		propertyExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
		propertyExpressionText.setLayoutData(propertyValueData);
		propertyExpressionText.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LogPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.LogProperty.Properties.propertyExpression, PropertiesEditionEvent.COMMIT,
							PropertiesEditionEvent.SET, null, propertyExpressionText.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(LogPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.LogProperty.Properties.propertyExpression,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
									propertyExpressionText.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LogPropertyPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
							PropertiesEditionEvent.FOCUS_GAINED, null, null));
				}
			}
		});
		propertyExpressionText.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(
								new PropertiesEditionEvent(LogPropertyPropertiesEditionPartForm.this,
										EsbViewsRepository.LogProperty.Properties.propertyExpression,
										PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
										propertyExpressionText.getText()));
				}
			}
		});
		EditingUtils.setID(propertyExpressionText, EsbViewsRepository.LogProperty.Properties.propertyExpression);
		EditingUtils.setEEFtype(propertyExpressionText, "eef::Text"); //$NON-NLS-1$
		Control propertyExpressionHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogProperty.Properties.propertyExpression,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		// Start of user code for createPropertyValueText
		propertyExpressionTypeElements = new Control[] { propertyExpressionTextLabel, propertyExpressionText,
				propertyExpressionHelp };
		// End of user code
		return parent;
	}

	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.LogProperty_Part_Title;
	}

	// Start of user code additional methods
	@Override
	public void refresh() {
		super.refresh();
		validate();
	}

	public void validate() {
		clearElements();
		showEntry(propertyNameElements, false);
		showEntry(propertyValueElements, false);

		if (getPropertyValueType().getName().equals(PropertyValueType.EXPRESSION.getName())) {
			showEntry(propertyExpressionTypeElements, false);
		} else if (getPropertyValueType().getName().equals(PropertyValueType.LITERAL.getName())) {
			showEntry(propertyValueTypeElements, false);
		}

		view.layout(true, true);
	}

	public void clearElements() {
		hideEntry(propertiesGroup.getChildren(), false);
	}

	public void hideEntry(Control controls[], boolean layout) {
		// view.getChildren();
		for (Control control : controls) {
			// null check and type check
			if (control.getLayoutData() != null && control.getLayoutData() instanceof GridData) {
				((GridData) control.getLayoutData()).exclude = true;
				control.setVisible(false);
			}
		}
		if (layout) {
			view.layout(true, true);
		}
	}

	public void showEntry(Control controls[], boolean layout) {
		for (Control control : controls) {
			// null check and type check
			((GridData) control.getLayoutData()).exclude = false;
			control.setVisible(true);
		}
		if (layout) {
			view.layout(true, true);
		}
	}
	// End of user code

}
