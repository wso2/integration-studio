/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class SmooksMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SmooksMediatorPropertiesEditionPart {

	protected EMFComboViewer inputType;
	// Start of user code  for inputExpresssion widgets declarations
	
	// End of user code

	protected EMFComboViewer outputType;
	protected Text outputProperty;
	protected EMFComboViewer outputAction;
	protected EMFComboViewer outputMethod;
	// Start of user code  for outputExpression widgets declarations
	
	// End of user code

	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	// Start of user code  for configurationKey widgets declarations
	
	// End of user code

	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SmooksMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence smooksMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep inputStep = smooksMediatorStep.addStep(EsbViewsRepository.SmooksMediator.Input.class);
		inputStep.addStep(EsbViewsRepository.SmooksMediator.Input.inputType);
		inputStep.addStep(EsbViewsRepository.SmooksMediator.Input.inputExpresssion);
		
		CompositionStep outputStep = smooksMediatorStep.addStep(EsbViewsRepository.SmooksMediator.Output.class);
		outputStep.addStep(EsbViewsRepository.SmooksMediator.Output.outputType);
		outputStep.addStep(EsbViewsRepository.SmooksMediator.Output.outputProperty);
		outputStep.addStep(EsbViewsRepository.SmooksMediator.Output.outputAction);
		outputStep.addStep(EsbViewsRepository.SmooksMediator.Output.outputMethod);
		outputStep.addStep(EsbViewsRepository.SmooksMediator.Output.outputExpression);
		
		CompositionStep propertiesStep = smooksMediatorStep.addStep(EsbViewsRepository.SmooksMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.reverse);
		
		smooksMediatorStep
			.addStep(EsbViewsRepository.SmooksMediator.Key.class)
			.addStep(EsbViewsRepository.SmooksMediator.Key.configurationKey);
		
		smooksMediatorStep
			.addStep(EsbViewsRepository.SmooksMediator.Misc.class)
			.addStep(EsbViewsRepository.SmooksMediator.Misc.description);
		
		
		composer = new PartComposer(smooksMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.SmooksMediator.Input.class) {
					return createInputGroup(parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Input.inputType) {
					return createInputTypeEMFComboViewer(parent);
				}
				// Start of user code for inputExpresssion addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.SmooksMediator.Output.class) {
					return createOutputGroup(parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Output.outputType) {
					return createOutputTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Output.outputProperty) {
					return createOutputPropertyText(parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Output.outputAction) {
					return createOutputActionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Output.outputMethod) {
					return createOutputMethodEMFComboViewer(parent);
				}
				// Start of user code for outputExpression addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.SmooksMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Key.class) {
					return createKeyGroup(parent);
				}
				// Start of user code for configurationKey addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.SmooksMediator.Misc.class) {
					return createMiscGroup(parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Misc.description) {
					return createDescriptionText(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createInputGroup(Composite parent) {
		Group inputGroup = new Group(parent, SWT.NONE);
		inputGroup.setText(EsbMessages.SmooksMediatorPropertiesEditionPart_InputGroupLabel);
		GridData inputGroupData = new GridData(GridData.FILL_HORIZONTAL);
		inputGroupData.horizontalSpan = 3;
		inputGroup.setLayoutData(inputGroupData);
		GridLayout inputGroupLayout = new GridLayout();
		inputGroupLayout.numColumns = 3;
		inputGroup.setLayout(inputGroupLayout);
		return inputGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createInputTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Input.inputType, EsbMessages.SmooksMediatorPropertiesEditionPart_InputTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SmooksMediator.Input.inputType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInputType()));
			}

		});
		inputType.setID(EsbViewsRepository.SmooksMediator.Input.inputType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Input.inputType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createOutputGroup(Composite parent) {
		Group outputGroup = new Group(parent, SWT.NONE);
		outputGroup.setText(EsbMessages.SmooksMediatorPropertiesEditionPart_OutputGroupLabel);
		GridData outputGroupData = new GridData(GridData.FILL_HORIZONTAL);
		outputGroupData.horizontalSpan = 3;
		outputGroup.setLayoutData(outputGroupData);
		GridLayout outputGroupLayout = new GridLayout();
		outputGroupLayout.numColumns = 3;
		outputGroup.setLayout(outputGroupLayout);
		return outputGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createOutputTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Output.outputType, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SmooksMediator.Output.outputType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputType()));
			}

		});
		outputType.setID(EsbViewsRepository.SmooksMediator.Output.outputType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Output.outputType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOutputPropertyText(Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Output.outputProperty, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputPropertyLabel);
		outputProperty = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData outputPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		outputProperty.setLayoutData(outputPropertyData);
		outputProperty.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SmooksMediator.Output.outputProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputProperty.getText()));
			}

		});
		outputProperty.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SmooksMediator.Output.outputProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputProperty.getText()));
				}
			}

		});
		EditingUtils.setID(outputProperty, EsbViewsRepository.SmooksMediator.Output.outputProperty);
		EditingUtils.setEEFtype(outputProperty, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Output.outputProperty, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputPropertyText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createOutputActionEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Output.outputAction, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputActionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SmooksMediator.Output.outputAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputAction()));
			}

		});
		outputAction.setID(EsbViewsRepository.SmooksMediator.Output.outputAction);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Output.outputAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputActionEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createOutputMethodEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Output.outputMethod, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputMethodLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SmooksMediator.Output.outputMethod, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputMethod()));
			}

		});
		outputMethod.setID(EsbViewsRepository.SmooksMediator.Output.outputMethod);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Output.outputMethod, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputMethodEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.SmooksMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.SmooksMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.SmooksMediator.Properties.commentsList, EsbMessages.SmooksMediatorPropertiesEditionPart_CommentsListLabel));
		GridData editCommentsListData = new GridData();
		editCommentsList.setLayoutData(editCommentsListData);
		editCommentsList.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SmooksMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
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

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.SmooksMediator.Properties.reverse, EsbMessages.SmooksMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SmooksMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.SmooksMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createKeyGroup(Composite parent) {
		Group keyGroup = new Group(parent, SWT.NONE);
		keyGroup.setText(EsbMessages.SmooksMediatorPropertiesEditionPart_KeyGroupLabel);
		GridData keyGroupData = new GridData(GridData.FILL_HORIZONTAL);
		keyGroupData.horizontalSpan = 3;
		keyGroup.setLayoutData(keyGroupData);
		GridLayout keyGroupLayout = new GridLayout();
		keyGroupLayout.numColumns = 3;
		keyGroup.setLayout(keyGroupLayout);
		return keyGroup;
	}

	/**
	 * 
	 */
	protected Composite createMiscGroup(Composite parent) {
		Group miscGroup = new Group(parent, SWT.NONE);
		miscGroup.setText(EsbMessages.SmooksMediatorPropertiesEditionPart_MiscGroupLabel);
		GridData miscGroupData = new GridData(GridData.FILL_HORIZONTAL);
		miscGroupData.horizontalSpan = 3;
		miscGroup.setLayoutData(miscGroupData);
		GridLayout miscGroupLayout = new GridLayout();
		miscGroupLayout.numColumns = 3;
		miscGroup.setLayout(miscGroupLayout);
		return miscGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Misc.description, EsbMessages.SmooksMediatorPropertiesEditionPart_DescriptionLabel);
		description = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SmooksMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		description.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SmooksMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.SmooksMediator.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Misc.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

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
        // TODO Auto-generated method stub
        
    }

    @Override
    public NamespacedProperty getInputExpression() {
        // TODO Auto-generated method stub
        return null;
    }
	// End of user code

	// Start of user code for outputExpression specific getters and setters implementation
    @Override
    public void setOutputExpression(NamespacedProperty namespacedProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public NamespacedProperty getOutputExpression() {
        // TODO Auto-generated method stub
        return null;
    }
	// End of user code

	// Start of user code for configurationKey specific getters and setters implementation
    @Override
    public void setConfigurationKey(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getConfigurationKey() {
        // TODO Auto-generated method stub
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
		return EsbMessages.SmooksMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
