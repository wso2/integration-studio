/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class PayloadFactoryArgumentPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, PayloadFactoryArgumentPropertiesEditionPart {

	protected EMFComboViewer argumentType;
	protected Text argumentValue;
	// Start of user code  for argumentExpression widgets declarations
	
	protected Composite propertiesGroup;

	// End of user code

	protected EMFComboViewer evaluator;
	protected Button literal;



	/**
	 * For {@link ISection} use only.
	 */
	public PayloadFactoryArgumentPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public PayloadFactoryArgumentPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence payloadFactoryArgumentStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = payloadFactoryArgumentStep.addStep(EsbViewsRepository.PayloadFactoryArgument.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentExpression);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryArgument.Properties.literal);
		
		
		composer = new PartComposer(payloadFactoryArgumentStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.PayloadFactoryArgument.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType) {
					return createArgumentTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue) {
					return createArgumentValueText(widgetFactory, parent);
				}
				// Start of user code for argumentExpression addToPart creation
				// End of user code
				if (key == EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator) {
					return createEvaluatorEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryArgument.Properties.literal) {
					return createLiteralCheckbox(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.PayloadFactoryArgumentPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createArgumentTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control argumentTypeLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType, EsbMessages.PayloadFactoryArgumentPropertiesEditionPart_ArgumentTypeLabel);
		argumentType = new EMFComboViewer(parent);
		argumentType.setContentProvider(new ArrayContentProvider());
		argumentType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData argumentTypeData = new GridData(GridData.FILL_HORIZONTAL);
		argumentType.getCombo().setLayoutData(argumentTypeData);
                argumentType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		argumentType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			}

		});
		argumentType.setID(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType);
		Control argumentTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createArgumentTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createArgumentValueText(FormToolkit widgetFactory, Composite parent) {
		Control argumentValueLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue, EsbMessages.PayloadFactoryArgumentPropertiesEditionPart_ArgumentValueLabel);
		argumentValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		argumentValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData argumentValueData = new GridData(GridData.FILL_HORIZONTAL);
		argumentValue.setLayoutData(argumentValueData);
		argumentValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PayloadFactoryArgumentPropertiesEditionPartForm.this,
							EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, argumentValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PayloadFactoryArgumentPropertiesEditionPartForm.this,
									EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, argumentValue.getText()));
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
									PayloadFactoryArgumentPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		argumentValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryArgumentPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, argumentValue.getText()));
				}
			}
		});
		EditingUtils.setID(argumentValue, EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue);
		EditingUtils.setEEFtype(argumentValue, "eef::Text"); //$NON-NLS-1$
		Control argumentValueHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createArgumentValueText
		
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createEvaluatorEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control evaluatorLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator, EsbMessages.PayloadFactoryArgumentPropertiesEditionPart_EvaluatorLabel);
		evaluator = new EMFComboViewer(parent);
		evaluator.setContentProvider(new ArrayContentProvider());
		evaluator.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData evaluatorData = new GridData(GridData.FILL_HORIZONTAL);
		evaluator.getCombo().setLayoutData(evaluatorData);
                evaluator.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		evaluator.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryArgumentPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEvaluator()));
			}

		});
		evaluator.setID(EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator);
		Control evaluatorHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEvaluatorEMFComboViewer

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createLiteralCheckbox(FormToolkit widgetFactory, Composite parent) {
		literal = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.PayloadFactoryArgument.Properties.literal, EsbMessages.PayloadFactoryArgumentPropertiesEditionPart_LiteralLabel), SWT.CHECK);
		literal.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryArgumentPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryArgument.Properties.literal, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(literal.getSelection())));
			}

		});
		GridData literalData = new GridData(GridData.FILL_HORIZONTAL);
		literalData.horizontalSpan = 2;
		literal.setLayoutData(literalData);
		EditingUtils.setID(literal, EsbViewsRepository.PayloadFactoryArgument.Properties.literal);
		EditingUtils.setEEFtype(literal, "eef::Checkbox"); //$NON-NLS-1$
		Control literalHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryArgument.Properties.literal, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLiteralCheckbox

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart#getArgumentType()
	 * 
	 */
	public Enumerator getArgumentType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) argumentType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart#initArgumentType(Object input, Enumerator current)
	 */
	public void initArgumentType(Object input, Enumerator current) {
		argumentType.setInput(input);
		argumentType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType);
		if (eefElementEditorReadOnlyState && argumentType.isEnabled()) {
			argumentType.setEnabled(false);
			argumentType.setToolTipText(EsbMessages.PayloadFactoryArgument_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !argumentType.isEnabled()) {
			argumentType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart#setArgumentType(Enumerator newValue)
	 * 
	 */
	public void setArgumentType(Enumerator newValue) {
		argumentType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentType);
		if (eefElementEditorReadOnlyState && argumentType.isEnabled()) {
			argumentType.setEnabled(false);
			argumentType.setToolTipText(EsbMessages.PayloadFactoryArgument_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !argumentType.isEnabled()) {
			argumentType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart#getArgumentValue()
	 * 
	 */
	public String getArgumentValue() {
		return argumentValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart#setArgumentValue(String newValue)
	 * 
	 */
	public void setArgumentValue(String newValue) {
		if (newValue != null) {
			argumentValue.setText(newValue);
		} else {
			argumentValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentValue);
		if (eefElementEditorReadOnlyState && argumentValue.isEnabled()) {
			argumentValue.setEnabled(false);
			argumentValue.setToolTipText(EsbMessages.PayloadFactoryArgument_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !argumentValue.isEnabled()) {
			argumentValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart#getEvaluator()
	 * 
	 */
	public Enumerator getEvaluator() {
		Enumerator selection = (Enumerator) ((StructuredSelection) evaluator.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart#initEvaluator(Object input, Enumerator current)
	 */
	public void initEvaluator(Object input, Enumerator current) {
		evaluator.setInput(input);
		evaluator.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator);
		if (eefElementEditorReadOnlyState && evaluator.isEnabled()) {
			evaluator.setEnabled(false);
			evaluator.setToolTipText(EsbMessages.PayloadFactoryArgument_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !evaluator.isEnabled()) {
			evaluator.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart#setEvaluator(Enumerator newValue)
	 * 
	 */
	public void setEvaluator(Enumerator newValue) {
		evaluator.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryArgument.Properties.evaluator);
		if (eefElementEditorReadOnlyState && evaluator.isEnabled()) {
			evaluator.setEnabled(false);
			evaluator.setToolTipText(EsbMessages.PayloadFactoryArgument_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !evaluator.isEnabled()) {
			evaluator.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart#getLiteral()
	 * 
	 */
	public Boolean getLiteral() {
		return Boolean.valueOf(literal.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryArgumentPropertiesEditionPart#setLiteral(Boolean newValue)
	 * 
	 */
	public void setLiteral(Boolean newValue) {
		if (newValue != null) {
			literal.setSelection(newValue.booleanValue());
		} else {
			literal.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryArgument.Properties.literal);
		if (eefElementEditorReadOnlyState && literal.isEnabled()) {
			literal.setEnabled(false);
			literal.setToolTipText(EsbMessages.PayloadFactoryArgument_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !literal.isEnabled()) {
			literal.setEnabled(true);
		}	
		
	}






	// Start of user code for argumentExpression specific getters and setters implementation
	@Override
	public void setArgumentExpression(NamespacedProperty namespacedProperty) {

	}

	@Override
	public NamespacedProperty getArgumentExpression() {
		return null;
	}
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.PayloadFactoryArgument_Part_Title;
	}


	// Start of user code additional methods

	// End of user code


}
