/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
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
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputMethod;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class SmooksMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SmooksMediatorPropertiesEditionPart {

	protected EMFComboViewer inputType;
	// Start of user code  for inputExpresssion widgets declarations
	protected NamespacedProperty inputExpression;
	
	protected Text inputExpressionText;
	// End of user code

	protected EMFComboViewer outputType;
	protected Text outputProperty;
	protected EMFComboViewer outputAction;
	protected EMFComboViewer outputMethod;
	// Start of user code  for outputExpression widgets declarations
	protected NamespacedProperty outputExpression;
    
    protected Text outputExpressionText;
	// End of user code

	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	// Start of user code  for configurationKey widgets declarations
	protected RegistryKeyProperty configurationKey;
	
	protected Text configurationKeyText;
	
	protected Section propertiesSection;
	
	protected Composite inputGroup;
	protected Composite outputGroup;
	protected Composite propertiesGroup;
	protected Composite keyGroup;
	protected Composite miscGroup;
	
	protected Control[] inputTypeElements;
	protected Control[] outputTypeElements;
	protected Control[] outputPropertyElements;
	protected Control[] outputActionElements;
	protected Control[] outputMethodElements;
	protected Control[] descriptionElements;
	protected Control[] configurationKeyElements;
	protected Control[] inputExpressionElements;
	protected Control[] outputExpressionElements;
	// End of user code

	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public SmooksMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SmooksMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		Form form = widgetFactory.createForm(parent);
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return form;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence smooksMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep inputStep = smooksMediatorStep.addStep(EsbViewsRepository.SmooksMediator.Input.class);
		inputStep.addStep(EsbViewsRepository.SmooksMediator.Input.inputType);
		inputStep.addStep(EsbViewsRepository.SmooksMediator.Input.inputExpresssion);
		
        smooksMediatorStep.addStep(EsbViewsRepository.SmooksMediator.Key.class)
                .addStep(EsbViewsRepository.SmooksMediator.Key.configurationKey);
		
		CompositionStep outputStep = smooksMediatorStep.addStep(EsbViewsRepository.SmooksMediator.Output.class);
		outputStep.addStep(EsbViewsRepository.SmooksMediator.Output.outputType);
        outputStep.addStep(EsbViewsRepository.SmooksMediator.Output.outputMethod);
		outputStep.addStep(EsbViewsRepository.SmooksMediator.Output.outputProperty);
		outputStep.addStep(EsbViewsRepository.SmooksMediator.Output.outputAction);
		outputStep.addStep(EsbViewsRepository.SmooksMediator.Output.outputExpression);
		
		CompositionStep propertiesStep = smooksMediatorStep.addStep(EsbViewsRepository.SmooksMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.reverse);
		
		smooksMediatorStep
			.addStep(EsbViewsRepository.SmooksMediator.Misc.class)
			.addStep(EsbViewsRepository.SmooksMediator.Misc.description);
		
		
		composer = new PartComposer(smooksMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.SmooksMediator.Input.class) {
					return createInputGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Input.inputType) {
					return createInputTypeEMFComboViewer(widgetFactory, parent);
				}
				// Start of user code for inputExpresssion addToPart creation
				if (key == EsbViewsRepository.SmooksMediator.Input.inputExpresssion) {
                    return createInputExpression(widgetFactory, parent);
                }
				// End of user code
				if (key == EsbViewsRepository.SmooksMediator.Output.class) {
					return createOutputGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Output.outputType) {
					return createOutputTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Output.outputProperty) {
					return createOutputPropertyText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Output.outputAction) {
					return createOutputActionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Output.outputMethod) {
					return createOutputMethodEMFComboViewer(widgetFactory, parent);
				}
				// Start of user code for outputExpression addToPart creation
				if (key == EsbViewsRepository.SmooksMediator.Output.outputExpression) {
                    return createOutputExpression(widgetFactory, parent);
                }
				// End of user code
				if (key == EsbViewsRepository.SmooksMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Key.class) {
					return createKeyGroup(widgetFactory, parent);
				}
				// Start of user code for configurationKey addToPart creation
				if (key == EsbViewsRepository.SmooksMediator.Key.configurationKey) {
                    return createConfigurationKey(widgetFactory, parent);
                }
				// End of user code
				if (key == EsbViewsRepository.SmooksMediator.Misc.class) {
					return createMiscGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Misc.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	
	/**
     * @generated NOT
     */
	protected Composite createInputGroup(FormToolkit widgetFactory, final Composite parent) {
		Section inputSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		inputSection.setText(EsbMessages.SmooksMediatorPropertiesEditionPart_InputGroupLabel);
		GridData inputSectionData = new GridData(GridData.FILL_HORIZONTAL);
		inputSectionData.horizontalSpan = 3;
		inputSection.setLayoutData(inputSectionData);
		inputGroup = widgetFactory.createComposite(inputSection);
		GridLayout inputGroupLayout = new GridLayout();
		inputGroupLayout.numColumns = 3;
		inputGroup.setLayout(inputGroupLayout);
		inputSection.setClient(inputGroup);
		return inputGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createInputTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control inputTypeLabel = createDescription(parent, EsbViewsRepository.SmooksMediator.Input.inputType, EsbMessages.SmooksMediatorPropertiesEditionPart_InputTypeLabel);
		inputType = new EMFComboViewer(parent);
		inputType.setContentProvider(new ArrayContentProvider());
		inputType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData inputTypeData = new GridData(GridData.FILL_HORIZONTAL);
		inputType.getCombo().setLayoutData(inputTypeData);
                inputType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		inputType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Input.inputType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInputType()));
			}

		});
		inputType.setID(EsbViewsRepository.SmooksMediator.Input.inputType);
		Control inputTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Input.inputType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputTypeEMFComboViewer
		inputTypeElements = new Control[] {inputTypeLabel, inputType.getCombo(), inputTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOutputGroup(FormToolkit widgetFactory, final Composite parent) {
		Section outputSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		outputSection.setText(EsbMessages.SmooksMediatorPropertiesEditionPart_OutputGroupLabel);
		GridData outputSectionData = new GridData(GridData.FILL_HORIZONTAL);
		outputSectionData.horizontalSpan = 3;
		outputSection.setLayoutData(outputSectionData);
		outputGroup = widgetFactory.createComposite(outputSection);
		GridLayout outputGroupLayout = new GridLayout();
		outputGroupLayout.numColumns = 3;
		outputGroup.setLayout(outputGroupLayout);
		outputSection.setClient(outputGroup);
		return outputGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createOutputTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control outputTypeLabel = createDescription(parent, EsbViewsRepository.SmooksMediator.Output.outputType, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputTypeLabel);
		outputType = new EMFComboViewer(parent);
		outputType.setContentProvider(new ArrayContentProvider());
		outputType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData outputTypeData = new GridData(GridData.FILL_HORIZONTAL);
		outputType.getCombo().setLayoutData(outputTypeData);
                outputType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		outputType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Output.outputType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputType()));
			}

		});
		outputType.setID(EsbViewsRepository.SmooksMediator.Output.outputType);
		Control outputTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Output.outputType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputTypeEMFComboViewer
		outputTypeElements = new Control[] {outputTypeLabel, outputType.getCombo(), outputTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOutputPropertyText(FormToolkit widgetFactory, Composite parent) {
		Control outputPropertyLabel = createDescription(parent, EsbViewsRepository.SmooksMediator.Output.outputProperty, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputPropertyLabel);
		outputProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		outputProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData outputPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		outputProperty.setLayoutData(outputPropertyData);
		outputProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SmooksMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.SmooksMediator.Output.outputProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmooksMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.SmooksMediator.Output.outputProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, outputProperty.getText()));
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
									SmooksMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		outputProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Output.outputProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputProperty.getText()));
				}
			}
		});
		EditingUtils.setID(outputProperty, EsbViewsRepository.SmooksMediator.Output.outputProperty);
		EditingUtils.setEEFtype(outputProperty, "eef::Text"); //$NON-NLS-1$
		Control outputPropertyHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Output.outputProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputPropertyText
		outputPropertyElements = new Control[] {outputPropertyLabel, outputProperty, outputPropertyHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOutputActionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control outputActionLabel = createDescription(parent, EsbViewsRepository.SmooksMediator.Output.outputAction, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputActionLabel);
		outputAction = new EMFComboViewer(parent);
		outputAction.setContentProvider(new ArrayContentProvider());
		outputAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData outputActionData = new GridData(GridData.FILL_HORIZONTAL);
		outputAction.getCombo().setLayoutData(outputActionData);
                outputAction.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		outputAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Output.outputAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputAction()));
			}

		});
		outputAction.setID(EsbViewsRepository.SmooksMediator.Output.outputAction);
		Control outputActionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Output.outputAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputActionEMFComboViewer
		outputActionElements = new Control[] {outputActionLabel, outputAction.getCombo(), outputActionHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOutputMethodEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control outputMethodLabel = createDescription(parent, EsbViewsRepository.SmooksMediator.Output.outputMethod, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputMethodLabel);
		outputMethod = new EMFComboViewer(parent);
		outputMethod.setContentProvider(new ArrayContentProvider());
		outputMethod.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData outputMethodData = new GridData(GridData.FILL_HORIZONTAL);
		outputMethod.getCombo().setLayoutData(outputMethodData);
                outputMethod.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		outputMethod.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Output.outputMethod, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputMethod()));
				refresh();
			}

		});
		outputMethod.setID(EsbViewsRepository.SmooksMediator.Output.outputMethod);
		Control outputMethodHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Output.outputMethod, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputMethodEMFComboViewer
		outputMethodElements = new Control[] {outputMethodLabel, outputMethod.getCombo(), outputMethodHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.SmooksMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.SmooksMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.SmooksMediator.Properties.commentsList, EsbMessages.SmooksMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
		GridData editCommentsListData = new GridData();
		editCommentsList.setLayoutData(editCommentsListData);
		editCommentsList.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						commentsList.getShell(), "SmooksMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.SmooksMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.SmooksMediator.Properties.reverse, EsbMessages.SmooksMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.SmooksMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createKeyGroup(FormToolkit widgetFactory, final Composite parent) {
		Section keySection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		keySection.setText(EsbMessages.SmooksMediatorPropertiesEditionPart_KeyGroupLabel);
		GridData keySectionData = new GridData(GridData.FILL_HORIZONTAL);
		keySectionData.horizontalSpan = 3;
		keySection.setLayoutData(keySectionData);
		keyGroup = widgetFactory.createComposite(keySection);
		GridLayout keyGroupLayout = new GridLayout();
		keyGroupLayout.numColumns = 3;
		keyGroup.setLayout(keyGroupLayout);
		keySection.setClient(keyGroup);
		return keyGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createMiscGroup(FormToolkit widgetFactory, final Composite parent) {
		Section miscSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		miscSection.setText(EsbMessages.SmooksMediatorPropertiesEditionPart_MiscGroupLabel);
		GridData miscSectionData = new GridData(GridData.FILL_HORIZONTAL);
		miscSectionData.horizontalSpan = 3;
		miscSection.setLayoutData(miscSectionData);
		miscGroup = widgetFactory.createComposite(miscSection);
		GridLayout miscGroupLayout = new GridLayout();
		miscGroupLayout.numColumns = 3;
		miscGroup.setLayout(miscGroupLayout);
		miscSection.setClient(miscGroup);
		return miscGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.SmooksMediator.Misc.description, EsbMessages.SmooksMediatorPropertiesEditionPart_DescriptionLabel);
		description = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		description.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SmooksMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.SmooksMediator.Misc.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmooksMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.SmooksMediator.Misc.description,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, description.getText()));
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
									SmooksMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		description.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.SmooksMediator.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Misc.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] {descriptionLabel, description, descriptionHelp};
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getInputType()
	 * 
	 */
	public Enumerator getInputType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inputType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#initInputType(Object input, Enumerator current)
	 */
	public void initInputType(Object input, Enumerator current) {
		inputType.setInput(input);
		inputType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Input.inputType);
		if (eefElementEditorReadOnlyState && inputType.isEnabled()) {
			inputType.setEnabled(false);
			inputType.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputType.isEnabled()) {
			inputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setInputType(Enumerator newValue)
	 * 
	 */
	public void setInputType(Enumerator newValue) {
		inputType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Input.inputType);
		if (eefElementEditorReadOnlyState && inputType.isEnabled()) {
			inputType.setEnabled(false);
			inputType.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputType.isEnabled()) {
			inputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getOutputType()
	 * 
	 */
	public Enumerator getOutputType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outputType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#initOutputType(Object input, Enumerator current)
	 */
	public void initOutputType(Object input, Enumerator current) {
		outputType.setInput(input);
		outputType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Output.outputType);
		if (eefElementEditorReadOnlyState && outputType.isEnabled()) {
			outputType.setEnabled(false);
			outputType.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputType.isEnabled()) {
			outputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setOutputType(Enumerator newValue)
	 * 
	 */
	public void setOutputType(Enumerator newValue) {
		outputType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Output.outputType);
		if (eefElementEditorReadOnlyState && outputType.isEnabled()) {
			outputType.setEnabled(false);
			outputType.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputType.isEnabled()) {
			outputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getOutputProperty()
	 * 
	 */
	public String getOutputProperty() {
		return outputProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setOutputProperty(String newValue)
	 * 
	 */
	public void setOutputProperty(String newValue) {
		if (newValue != null) {
			outputProperty.setText(newValue);
		} else {
			outputProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Output.outputProperty);
		if (eefElementEditorReadOnlyState && outputProperty.isEnabled()) {
			outputProperty.setEnabled(false);
			outputProperty.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputProperty.isEnabled()) {
			outputProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getOutputAction()
	 * 
	 */
	public Enumerator getOutputAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outputAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#initOutputAction(Object input, Enumerator current)
	 */
	public void initOutputAction(Object input, Enumerator current) {
		outputAction.setInput(input);
		outputAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Output.outputAction);
		if (eefElementEditorReadOnlyState && outputAction.isEnabled()) {
			outputAction.setEnabled(false);
			outputAction.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputAction.isEnabled()) {
			outputAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setOutputAction(Enumerator newValue)
	 * 
	 */
	public void setOutputAction(Enumerator newValue) {
		outputAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Output.outputAction);
		if (eefElementEditorReadOnlyState && outputAction.isEnabled()) {
			outputAction.setEnabled(false);
			outputAction.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputAction.isEnabled()) {
			outputAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getOutputMethod()
	 * 
	 */
	public Enumerator getOutputMethod() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outputMethod.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#initOutputMethod(Object input, Enumerator current)
	 */
	public void initOutputMethod(Object input, Enumerator current) {
		outputMethod.setInput(input);
		outputMethod.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Output.outputMethod);
		if (eefElementEditorReadOnlyState && outputMethod.isEnabled()) {
			outputMethod.setEnabled(false);
			outputMethod.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputMethod.isEnabled()) {
			outputMethod.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setOutputMethod(Enumerator newValue)
	 * 
	 */
	public void setOutputMethod(Enumerator newValue) {
		outputMethod.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Output.outputMethod);
		if (eefElementEditorReadOnlyState && outputMethod.isEnabled()) {
			outputMethod.setEnabled(false);
			outputMethod.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputMethod.isEnabled()) {
			outputMethod.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !commentsList.isEnabled()) {
			commentsList.setEnabled(true);
		}	
		
	}

	public void addToCommentsList(Object newValue) {
		commentsListList.add(newValue);
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToCommentsList(Object newValue) {
		commentsListList.remove(newValue);
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Misc.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}






	// Start of user code for inputExpresssion specific getters and setters implementation
    @Override
    public void setInputExpression(NamespacedProperty namespacedProperty) {
        if (namespacedProperty != null) {
            inputExpression = namespacedProperty;
            inputExpressionText.setText(namespacedProperty.getPropertyValue());
        }
    }

    @Override
    public NamespacedProperty getInputExpression() {
        return inputExpression;
    }
	// End of user code

	// Start of user code for outputExpression specific getters and setters implementation
    @Override
    public void setOutputExpression(NamespacedProperty namespacedProperty) {
        if (namespacedProperty != null) {
            outputExpression = namespacedProperty;
            outputExpressionText.setText(namespacedProperty.getPropertyValue());
        }
    }

    @Override
    public NamespacedProperty getOutputExpression() {
        return outputExpression;
    }
	// End of user code

	// Start of user code for configurationKey specific getters and setters implementation
    @Override
    public void setConfigurationKey(RegistryKeyProperty registryKeyProperty) {
        if (configurationKey != null) {
            configurationKey = registryKeyProperty;
            configurationKeyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getConfigurationKey() {
        return configurationKey;
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.SmooksMediator_Part_Title;
	}







	// Start of user code additional methods
	protected Composite createConfigurationKey(FormToolkit widgetFactory, final Composite parent) {
        Control configurationKeyLabel = createDescription(parent, EsbViewsRepository.SmooksMediator.Key.configurationKey,
                EsbMessages.SmooksMediatorPropertiesEditionPart_ConfigurationKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (configurationKey == null) {
            configurationKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initconfigurationKey = configurationKey.getKeyValue().isEmpty() ? "" : configurationKey.getKeyValue();
        configurationKeyText = widgetFactory.createText(parent, initconfigurationKey, SWT.READ_ONLY);
        configurationKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        configurationKeyText.setLayoutData(valueData);
        configurationKeyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, configurationKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                configurationKeyText.setText(configurationKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.SmooksMediator.Key.configurationKey, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getConfigurationKey()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        
        configurationKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, configurationKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    configurationKeyText.setText(configurationKey.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.SmooksMediator.Key.configurationKey, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getConfigurationKey()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(configurationKeyText, EsbViewsRepository.SmooksMediator.Key.configurationKey);
        EditingUtils.setEEFtype(configurationKeyText, "eef::Text");
        Control sequenceKeyHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.SmooksMediator.Key.configurationKey, EsbViewsRepository.FORM_KIND),
                        null);
        configurationKeyElements = new Control[] { configurationKeyLabel, configurationKeyText, sequenceKeyHelp };
        return parent;
    }

	protected Composite createInputExpression(FormToolkit widgetFactory, final Composite parent) {
        Control inputExpressionLabel = createDescription(parent, EsbViewsRepository.SmooksMediator.Input.inputExpresssion, 
                EsbMessages.SmooksMediatorPropertiesEditionPart_InputExpresssionLabel);
        widgetFactory.paintBordersFor(parent);
        if(inputExpression == null) {
            inputExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initInputExpression = inputExpression.getPropertyValue().isEmpty() ? "" : inputExpression.getPropertyValue();
        inputExpressionText = widgetFactory.createText(parent, initInputExpression, SWT.READ_ONLY);
        inputExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        inputExpressionText.setLayoutData(valueData);

        inputExpressionText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                        inputExpression);
                inputExpression = nspd.open();
                inputExpressionText.setText(inputExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Input.inputExpresssion,
                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInputExpression()));
            }
            
        });
        
        inputExpressionText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                            inputExpression);
                    inputExpression = nspd.open();
                    inputExpressionText.setText(inputExpression.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Input.inputExpresssion,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInputExpression()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(inputExpressionText, EsbViewsRepository.SmooksMediator.Input.inputExpresssion);
        EditingUtils.setEEFtype(inputExpressionText, "eef::Text");
        Control inputExpressionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Input.inputExpresssion, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        inputExpressionElements = new Control[] {inputExpressionLabel, inputExpressionText, inputExpressionHelp};
        return parent;
    }
	
	protected Composite createOutputExpression(FormToolkit widgetFactory, final Composite parent) {
        Control outputExpressionLabel = createDescription(parent, EsbViewsRepository.SmooksMediator.Output.outputExpression,
                EsbMessages.SmooksMediatorPropertiesEditionPart_OutputExpressionLabel);
        widgetFactory.paintBordersFor(parent);
        if(outputExpression == null) {
            outputExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initOutputExpression = outputExpression.getPropertyValue().isEmpty() ? "" : outputExpression.getPropertyValue();
        outputExpressionText = widgetFactory.createText(parent, initOutputExpression, SWT.READ_ONLY);
        outputExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        outputExpressionText.setLayoutData(valueData);

        outputExpressionText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                        outputExpression);
                outputExpression = nspd.open();
                outputExpressionText.setText(outputExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Output.outputExpression,
                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputExpression()));
            }
            
        });
        
        outputExpressionText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                            outputExpression);
                    outputExpression = nspd.open();
                    outputExpressionText.setText(outputExpression.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Output.outputExpression,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputExpression()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });

        EditingUtils.setID(outputExpressionText, EsbViewsRepository.SmooksMediator.Output.outputExpression);
        EditingUtils.setEEFtype(outputExpressionText, "eef::Text");
        Control outputExpressionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Output.outputExpression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        outputExpressionElements = new Control[] {outputExpressionLabel, outputExpressionText, outputExpressionHelp};
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
        eu.clearElements(new Composite[] { outputGroup });
        
        if (propertiesSection != null && propertiesSection.getLayoutData() != null) {
            propertiesSection.setVisible(false);
            ((GridData) propertiesSection.getLayoutData()).exclude = true;
        }
        
        eu.showEntry(outputTypeElements, false);
        eu.showEntry(outputMethodElements, false);

        if (getOutputMethod() != null && getOutputMethod().getName().equals(OutputMethod.PROPERTY.getName())) {
            eu.showEntry(outputPropertyElements, false);
            
        } else if (getOutputMethod() != null && getOutputMethod().getName().equals(OutputMethod.EXPRESSION.getName())) {
            eu.showEntry(outputActionElements, false);
            eu.showEntry(outputExpressionElements, false);
        }
        
        view.layout(true, true);
    }
	// End of user code


}
