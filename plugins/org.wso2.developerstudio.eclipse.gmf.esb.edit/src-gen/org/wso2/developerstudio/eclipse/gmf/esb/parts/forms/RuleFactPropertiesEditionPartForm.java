/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class RuleFactPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, RuleFactPropertiesEditionPart {

	protected EMFComboViewer factType;
	protected Text factCustomType;
	protected Text factName;
	protected EMFComboViewer valueType;
	protected Text valueLiteral;
	// Start of user code  for propertyExpression widgets declarations
	
	// End of user code

	// Start of user code  for valueReferenceKey widgets declarations
	
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public RuleFactPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RuleFactPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 * @generated NOT
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
		CompositionSequence ruleFactStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = ruleFactStep.addStep(EsbViewsRepository.RuleFact.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.factType);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.factCustomType);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.factName);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.valueType);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.valueLiteral);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.propertyExpression);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.valueReferenceKey);
		
		
		composer = new PartComposer(ruleFactStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RuleFact.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleFact.Properties.factType) {
					return createFactTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleFact.Properties.factCustomType) {
					return createFactCustomTypeText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleFact.Properties.factName) {
					return createFactNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleFact.Properties.valueType) {
					return createValueTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleFact.Properties.valueLiteral) {
					return createValueLiteralText(widgetFactory, parent);
				}
				// Start of user code for propertyExpression addToPart creation
				
				// End of user code
				// Start of user code for valueReferenceKey addToPart creation
				
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
		propertiesSection.setText(EsbMessages.RuleFactPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createFactTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleFact.Properties.factType, EsbMessages.RuleFactPropertiesEditionPart_FactTypeLabel);
		factType = new EMFComboViewer(parent);
		factType.setContentProvider(new ArrayContentProvider());
		factType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData factTypeData = new GridData(GridData.FILL_HORIZONTAL);
		factType.getCombo().setLayoutData(factTypeData);
                factType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		factType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartForm.this, EsbViewsRepository.RuleFact.Properties.factType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFactType()));
			}

		});
		factType.setID(EsbViewsRepository.RuleFact.Properties.factType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleFact.Properties.factType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFactTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createFactCustomTypeText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleFact.Properties.factCustomType, EsbMessages.RuleFactPropertiesEditionPart_FactCustomTypeLabel);
		factCustomType = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		factCustomType.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData factCustomTypeData = new GridData(GridData.FILL_HORIZONTAL);
		factCustomType.setLayoutData(factCustomTypeData);
		factCustomType.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RuleFactPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleFact.Properties.factCustomType,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, factCustomType.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleFactPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleFact.Properties.factCustomType,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, factCustomType.getText()));
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
									RuleFactPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		factCustomType.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartForm.this, EsbViewsRepository.RuleFact.Properties.factCustomType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, factCustomType.getText()));
				}
			}
		});
		EditingUtils.setID(factCustomType, EsbViewsRepository.RuleFact.Properties.factCustomType);
		EditingUtils.setEEFtype(factCustomType, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleFact.Properties.factCustomType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFactCustomTypeText

		// End of user code
		return parent;
	}

	
	protected Composite createFactNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleFact.Properties.factName, EsbMessages.RuleFactPropertiesEditionPart_FactNameLabel);
		factName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		factName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData factNameData = new GridData(GridData.FILL_HORIZONTAL);
		factName.setLayoutData(factNameData);
		factName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RuleFactPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleFact.Properties.factName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, factName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleFactPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleFact.Properties.factName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, factName.getText()));
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
									RuleFactPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		factName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartForm.this, EsbViewsRepository.RuleFact.Properties.factName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, factName.getText()));
				}
			}
		});
		EditingUtils.setID(factName, EsbViewsRepository.RuleFact.Properties.factName);
		EditingUtils.setEEFtype(factName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleFact.Properties.factName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFactNameText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createValueTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleFact.Properties.valueType, EsbMessages.RuleFactPropertiesEditionPart_ValueTypeLabel);
		valueType = new EMFComboViewer(parent);
		valueType.setContentProvider(new ArrayContentProvider());
		valueType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData valueTypeData = new GridData(GridData.FILL_HORIZONTAL);
		valueType.getCombo().setLayoutData(valueTypeData);
                valueType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		valueType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartForm.this, EsbViewsRepository.RuleFact.Properties.valueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
			}

		});
		valueType.setID(EsbViewsRepository.RuleFact.Properties.valueType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleFact.Properties.valueType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createValueLiteralText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleFact.Properties.valueLiteral, EsbMessages.RuleFactPropertiesEditionPart_ValueLiteralLabel);
		valueLiteral = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		valueLiteral.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueLiteralData = new GridData(GridData.FILL_HORIZONTAL);
		valueLiteral.setLayoutData(valueLiteralData);
		valueLiteral.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RuleFactPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleFact.Properties.valueLiteral,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleFactPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleFact.Properties.valueLiteral,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, valueLiteral.getText()));
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
									RuleFactPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		valueLiteral.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartForm.this, EsbViewsRepository.RuleFact.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
				}
			}
		});
		EditingUtils.setID(valueLiteral, EsbViewsRepository.RuleFact.Properties.valueLiteral);
		EditingUtils.setEEFtype(valueLiteral, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleFact.Properties.valueLiteral, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueLiteralText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#getFactType()
	 * 
	 */
	public Enumerator getFactType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) factType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#initFactType(Object input, Enumerator current)
	 */
	public void initFactType(Object input, Enumerator current) {
		factType.setInput(input);
		factType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.factType);
		if (eefElementEditorReadOnlyState && factType.isEnabled()) {
			factType.setEnabled(false);
			factType.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !factType.isEnabled()) {
			factType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#setFactType(Enumerator newValue)
	 * 
	 */
	public void setFactType(Enumerator newValue) {
		factType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.factType);
		if (eefElementEditorReadOnlyState && factType.isEnabled()) {
			factType.setEnabled(false);
			factType.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !factType.isEnabled()) {
			factType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#getFactCustomType()
	 * 
	 */
	public String getFactCustomType() {
		return factCustomType.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#setFactCustomType(String newValue)
	 * 
	 */
	public void setFactCustomType(String newValue) {
		if (newValue != null) {
			factCustomType.setText(newValue);
		} else {
			factCustomType.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.factCustomType);
		if (eefElementEditorReadOnlyState && factCustomType.isEnabled()) {
			factCustomType.setEnabled(false);
			factCustomType.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !factCustomType.isEnabled()) {
			factCustomType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#getFactName()
	 * 
	 */
	public String getFactName() {
		return factName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#setFactName(String newValue)
	 * 
	 */
	public void setFactName(String newValue) {
		if (newValue != null) {
			factName.setText(newValue);
		} else {
			factName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.factName);
		if (eefElementEditorReadOnlyState && factName.isEnabled()) {
			factName.setEnabled(false);
			factName.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !factName.isEnabled()) {
			factName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#getValueType()
	 * 
	 */
	public Enumerator getValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) valueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#initValueType(Object input, Enumerator current)
	 */
	public void initValueType(Object input, Enumerator current) {
		valueType.setInput(input);
		valueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#setValueType(Enumerator newValue)
	 * 
	 */
	public void setValueType(Enumerator newValue) {
		valueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#getValueLiteral()
	 * 
	 */
	public String getValueLiteral() {
		return valueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#setValueLiteral(String newValue)
	 * 
	 */
	public void setValueLiteral(String newValue) {
		if (newValue != null) {
			valueLiteral.setText(newValue);
		} else {
			valueLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.valueLiteral);
		if (eefElementEditorReadOnlyState && valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(false);
			valueLiteral.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(true);
		}	
		
	}






	// Start of user code for propertyExpression specific getters and setters implementation
	
	// End of user code

	// Start of user code for valueReferenceKey specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.RuleFact_Part_Title;
	}

        @Override
        public NamespacedProperty getPropertyExpression() {
            // TODO Auto-generated method stub
            return null;
        }
    
        @Override
        public void setPropertyExpression(NamespacedProperty nameSpacedProperty) {
            // TODO Auto-generated method stub
            
        }
    
        @Override
        public RegistryKeyProperty getValueReferenceKey() {
            // TODO Auto-generated method stub
            return null;
        }
    
        @Override
        public void setValueReferenceKey(RegistryKeyProperty registryKeyProperty) {
            // TODO Auto-generated method stub
            
        }

	// Start of user code additional methods
	
	// End of user code


}
