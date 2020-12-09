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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class URLRewriteRuleActionPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, URLRewriteRuleActionPropertiesEditionPart {

	protected EMFComboViewer ruleAction;
	protected EMFComboViewer ruleFragment;
	protected EMFComboViewer ruleOption;
	protected Text actionValue;
	protected Text actionRegex;
	// Start of user code  for actionExpression widgets declarations
	
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public URLRewriteRuleActionPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public URLRewriteRuleActionPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence uRLRewriteRuleActionStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = uRLRewriteRuleActionStep.addStep(EsbViewsRepository.URLRewriteRuleAction.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteRuleAction.Properties.actionExpression);
		
		
		composer = new PartComposer(uRLRewriteRuleActionStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction) {
					return createRuleActionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment) {
					return createRuleFragmentEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption) {
					return createRuleOptionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue) {
					return createActionValueText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex) {
					return createActionRegexText(widgetFactory, parent);
				}
				// Start of user code for actionExpression addToPart creation
				
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
		propertiesSection.setText(EsbMessages.URLRewriteRuleActionPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createRuleActionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction, EsbMessages.URLRewriteRuleActionPropertiesEditionPart_RuleActionLabel);
		ruleAction = new EMFComboViewer(parent);
		ruleAction.setContentProvider(new ArrayContentProvider());
		ruleAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData ruleActionData = new GridData(GridData.FILL_HORIZONTAL);
		ruleAction.getCombo().setLayoutData(ruleActionData);
                ruleAction.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		ruleAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleAction()));
			}

		});
		ruleAction.setID(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleActionEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createRuleFragmentEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment, EsbMessages.URLRewriteRuleActionPropertiesEditionPart_RuleFragmentLabel);
		ruleFragment = new EMFComboViewer(parent);
		ruleFragment.setContentProvider(new ArrayContentProvider());
		ruleFragment.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData ruleFragmentData = new GridData(GridData.FILL_HORIZONTAL);
		ruleFragment.getCombo().setLayoutData(ruleFragmentData);
                ruleFragment.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		ruleFragment.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleFragment()));
			}

		});
		ruleFragment.setID(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleFragmentEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createRuleOptionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption, EsbMessages.URLRewriteRuleActionPropertiesEditionPart_RuleOptionLabel);
		ruleOption = new EMFComboViewer(parent);
		ruleOption.setContentProvider(new ArrayContentProvider());
		ruleOption.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData ruleOptionData = new GridData(GridData.FILL_HORIZONTAL);
		ruleOption.getCombo().setLayoutData(ruleOptionData);
                ruleOption.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		ruleOption.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleOption()));
			}

		});
		ruleOption.setID(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleOptionEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createActionValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue, EsbMessages.URLRewriteRuleActionPropertiesEditionPart_ActionValueLabel);
		actionValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		actionValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData actionValueData = new GridData(GridData.FILL_HORIZONTAL);
		actionValue.setLayoutData(actionValueData);
		actionValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							URLRewriteRuleActionPropertiesEditionPartForm.this,
							EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, actionValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									URLRewriteRuleActionPropertiesEditionPartForm.this,
									EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, actionValue.getText()));
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
									URLRewriteRuleActionPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		actionValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, actionValue.getText()));
				}
			}
		});
		EditingUtils.setID(actionValue, EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue);
		EditingUtils.setEEFtype(actionValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createActionValueText

		// End of user code
		return parent;
	}

	
	protected Composite createActionRegexText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex, EsbMessages.URLRewriteRuleActionPropertiesEditionPart_ActionRegexLabel);
		actionRegex = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		actionRegex.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData actionRegexData = new GridData(GridData.FILL_HORIZONTAL);
		actionRegex.setLayoutData(actionRegexData);
		actionRegex.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							URLRewriteRuleActionPropertiesEditionPartForm.this,
							EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, actionRegex.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									URLRewriteRuleActionPropertiesEditionPartForm.this,
									EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, actionRegex.getText()));
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
									URLRewriteRuleActionPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		actionRegex.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, actionRegex.getText()));
				}
			}
		});
		EditingUtils.setID(actionRegex, EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex);
		EditingUtils.setEEFtype(actionRegex, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createActionRegexText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#getRuleAction()
	 * 
	 */
	public Enumerator getRuleAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) ruleAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#initRuleAction(Object input, Enumerator current)
	 */
	public void initRuleAction(Object input, Enumerator current) {
		ruleAction.setInput(input);
		ruleAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction);
		if (eefElementEditorReadOnlyState && ruleAction.isEnabled()) {
			ruleAction.setEnabled(false);
			ruleAction.setToolTipText(EsbMessages.URLRewriteRuleAction_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleAction.isEnabled()) {
			ruleAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#setRuleAction(Enumerator newValue)
	 * 
	 */
	public void setRuleAction(Enumerator newValue) {
		ruleAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction);
		if (eefElementEditorReadOnlyState && ruleAction.isEnabled()) {
			ruleAction.setEnabled(false);
			ruleAction.setToolTipText(EsbMessages.URLRewriteRuleAction_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleAction.isEnabled()) {
			ruleAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#getRuleFragment()
	 * 
	 */
	public Enumerator getRuleFragment() {
		Enumerator selection = (Enumerator) ((StructuredSelection) ruleFragment.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#initRuleFragment(Object input, Enumerator current)
	 */
	public void initRuleFragment(Object input, Enumerator current) {
		ruleFragment.setInput(input);
		ruleFragment.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment);
		if (eefElementEditorReadOnlyState && ruleFragment.isEnabled()) {
			ruleFragment.setEnabled(false);
			ruleFragment.setToolTipText(EsbMessages.URLRewriteRuleAction_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleFragment.isEnabled()) {
			ruleFragment.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#setRuleFragment(Enumerator newValue)
	 * 
	 */
	public void setRuleFragment(Enumerator newValue) {
		ruleFragment.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment);
		if (eefElementEditorReadOnlyState && ruleFragment.isEnabled()) {
			ruleFragment.setEnabled(false);
			ruleFragment.setToolTipText(EsbMessages.URLRewriteRuleAction_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleFragment.isEnabled()) {
			ruleFragment.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#getRuleOption()
	 * 
	 */
	public Enumerator getRuleOption() {
		Enumerator selection = (Enumerator) ((StructuredSelection) ruleOption.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#initRuleOption(Object input, Enumerator current)
	 */
	public void initRuleOption(Object input, Enumerator current) {
		ruleOption.setInput(input);
		ruleOption.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption);
		if (eefElementEditorReadOnlyState && ruleOption.isEnabled()) {
			ruleOption.setEnabled(false);
			ruleOption.setToolTipText(EsbMessages.URLRewriteRuleAction_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleOption.isEnabled()) {
			ruleOption.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#setRuleOption(Enumerator newValue)
	 * 
	 */
	public void setRuleOption(Enumerator newValue) {
		ruleOption.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption);
		if (eefElementEditorReadOnlyState && ruleOption.isEnabled()) {
			ruleOption.setEnabled(false);
			ruleOption.setToolTipText(EsbMessages.URLRewriteRuleAction_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleOption.isEnabled()) {
			ruleOption.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#getActionValue()
	 * 
	 */
	public String getActionValue() {
		return actionValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#setActionValue(String newValue)
	 * 
	 */
	public void setActionValue(String newValue) {
		if (newValue != null) {
			actionValue.setText(newValue);
		} else {
			actionValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue);
		if (eefElementEditorReadOnlyState && actionValue.isEnabled()) {
			actionValue.setEnabled(false);
			actionValue.setToolTipText(EsbMessages.URLRewriteRuleAction_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !actionValue.isEnabled()) {
			actionValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#getActionRegex()
	 * 
	 */
	public String getActionRegex() {
		return actionRegex.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart#setActionRegex(String newValue)
	 * 
	 */
	public void setActionRegex(String newValue) {
		if (newValue != null) {
			actionRegex.setText(newValue);
		} else {
			actionRegex.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex);
		if (eefElementEditorReadOnlyState && actionRegex.isEnabled()) {
			actionRegex.setEnabled(false);
			actionRegex.setToolTipText(EsbMessages.URLRewriteRuleAction_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !actionRegex.isEnabled()) {
			actionRegex.setEnabled(true);
		}	
		
	}






	// Start of user code for actionExpression specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.URLRewriteRuleAction_Part_Title;
	}

	// Start of user code additional methods
    @Override
    public NamespacedProperty getActionExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setActionExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }
	// End of user code


}
