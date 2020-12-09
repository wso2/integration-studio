/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

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

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.URLRewriteRuleActionPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class URLRewriteRuleActionPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, URLRewriteRuleActionPropertiesEditionPart {

	protected EMFComboViewer ruleAction;
	protected EMFComboViewer ruleFragment;
	protected EMFComboViewer ruleOption;
	protected Text actionValue;
	protected Text actionRegex;
	// Start of user code  for actionExpression widgets declarations
    protected Text actionExpressionText;
    protected NamespacedProperty actionExpression;
    protected Control [] ruleActionElements;
    protected Control [] ruleFragmentElements;
    protected Control [] ruleOptionTypeElements;
    protected Control [] actionValueElements;
    protected Control [] actionRegexElements;
    protected Control [] actionExpressionElements;
    protected Group propertiesGroup;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public URLRewriteRuleActionPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction) {
					return createRuleActionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment) {
					return createRuleFragmentEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption) {
					return createRuleOptionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue) {
					return createActionValueText(parent);
				}
				if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex) {
					return createActionRegexText(parent);
				}
				// Start of user code for actionExpression addToPart creation
                if (key == EsbViewsRepository.URLRewriteRuleAction.Properties.actionExpression) {
                    return createActionExpressionText(parent);
                }
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}


    /**
     * @generated NOT
     */
	protected Composite createPropertiesGroup(Composite parent) {
		propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.URLRewriteRuleActionPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createRuleActionEMFComboViewer(Composite parent) {
	    Control ruleActionLabel = createDescription(parent, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction, EsbMessages.URLRewriteRuleActionPropertiesEditionPart_RuleActionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleAction()));
			}

		});
		ruleAction.setID(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction);
		Control ruleActionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleActionEMFComboViewer
		ruleActionElements = new Control[] { ruleActionLabel, ruleActionHelp,
		        ruleAction.getCombo() };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createRuleFragmentEMFComboViewer(Composite parent) {
	    Control ruleFragmentLabel = createDescription(parent, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment, EsbMessages.URLRewriteRuleActionPropertiesEditionPart_RuleFragmentLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleFragment()));
			}

		});
		ruleFragment.setID(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment);
		Control ruleFragmentHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleFragment, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleFragmentEMFComboViewer
		ruleFragmentElements = new Control[] { ruleFragmentLabel, ruleFragmentHelp,
		        ruleFragment.getCombo() };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createRuleOptionEMFComboViewer(Composite parent) {
	    Control ruleOptionLabel = createDescription(parent, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption, EsbMessages.URLRewriteRuleActionPropertiesEditionPart_RuleOptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleOption()));
			}

		});
		ruleOption.setID(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption);
		Control ruleOptionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRuleAction.Properties.ruleOption, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleOptionEMFComboViewer
		ruleOptionTypeElements = new Control[] { ruleOptionLabel, ruleOptionHelp, ruleOption.getCombo() };
		ruleOption.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                validate();
            }

        });
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createActionValueText(Composite parent) {
	    Control actionValueLabel = createDescription(parent, EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue, EsbMessages.URLRewriteRuleActionPropertiesEditionPart_ActionValueLabel);
		actionValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData actionValueData = new GridData(GridData.FILL_HORIZONTAL);
		actionValue.setLayoutData(actionValueData);
		actionValue.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, actionValue.getText()));
			}

		});
		actionValue.addKeyListener(new KeyAdapter() {

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
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, actionValue.getText()));
				}
			}

		});
		EditingUtils.setID(actionValue, EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue);
		EditingUtils.setEEFtype(actionValue, "eef::Text"); //$NON-NLS-1$
		Control actionValueHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRuleAction.Properties.actionValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createActionValueText
		actionValueElements = new Control[] { actionValueLabel, actionValue, actionValueHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createActionRegexText(Composite parent) {
	    Control actionRegexLabel = createDescription(parent, EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex, EsbMessages.URLRewriteRuleActionPropertiesEditionPart_ActionRegexLabel);
		actionRegex = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData actionRegexData = new GridData(GridData.FILL_HORIZONTAL);
		actionRegex.setLayoutData(actionRegexData);
		actionRegex.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, actionRegex.getText()));
			}

		});
		actionRegex.addKeyListener(new KeyAdapter() {

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
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, actionRegex.getText()));
				}
			}

		});
		EditingUtils.setID(actionRegex, EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex);
		EditingUtils.setEEFtype(actionRegex, "eef::Text"); //$NON-NLS-1$
		Control actionRegexHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRuleAction.Properties.actionRegex, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createActionRegexText
		actionRegexElements = new Control[] { actionRegexLabel, actionRegex, actionRegexHelp };
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
    @Override
    public NamespacedProperty getActionExpression() {
        return actionExpression;
    }

    @Override
    public void setActionExpression(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            actionExpressionText.setText(nameSpacedProperty.getPropertyValue());
            actionExpression = nameSpacedProperty;
        }
    }
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

    protected Composite createActionExpressionText(final Composite parent) {
        Control actionExpressionLabel = createDescription(parent,
                EsbViewsRepository.URLRewriteRuleAction.Properties.actionExpression,
                EsbMessages.URLRewriteRuleActionPropertiesEditionPart_ActionExpressionLabel);
        actionExpressionText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY); // $NON-NLS-1$
        actionExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
        actionExpressionText.setLayoutData(propertyValueData);
        if(actionExpression == null) {
            actionExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        actionExpressionText.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            URLRewriteRuleActionPropertiesEditionPartImpl.this,
                            EsbViewsRepository.URLRewriteRuleAction.Properties.actionExpression, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getActionExpression()));
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRuleActionPropertiesEditionPartImpl.this,
                                    EsbViewsRepository.URLRewriteRuleAction.Properties.actionExpression,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    getActionExpression()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            URLRewriteRuleActionPropertiesEditionPartImpl.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });

        EditingUtils.setID(actionExpressionText, EsbViewsRepository.URLRewriteRuleAction.Properties.actionExpression);
        EditingUtils.setEEFtype(actionExpressionText, "eef::Text"); //$NON-NLS-1$
        Control actionExpressionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.URLRewriteRuleAction.Properties.actionExpression, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        actionExpressionElements = new Control[] { actionExpressionLabel, actionExpressionText,
                actionExpressionHelp };
        actionExpressionText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, actionExpression);
                nspd.open();
                actionExpressionText.setText(actionExpression.getPropertyValue());
            }
            
            @Override
            public void mouseDoubleClick(MouseEvent e) {}
            
        });
        
        actionExpressionText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, actionExpression);
                    nspd.open();
                    actionExpressionText.setText(actionExpression.getPropertyValue());
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        return parent;
    }
    
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { propertiesGroup });
        eu.showEntry(ruleActionElements, false);
        eu.showEntry(ruleFragmentElements, false);
        eu.showEntry(ruleOptionTypeElements, false);
        eu.showEntry(actionRegexElements, false);

        if (getRuleOption().getName().equals("EXPRESSION")) {
            eu.showEntry(actionExpressionElements, false);
        } else {
            eu.showEntry(actionValueElements, false);
        }        
        view.layout(true, true);
    }
	// End of user code


}
