/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

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

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class DataMapperMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, DataMapperMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer inputType;
	protected Text configurationLocalPath;
	protected Text inputSchemaLocalPath;
	protected Text outputSchemaLocalPath;
	protected EMFComboViewer outputType;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DataMapperMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence dataMapperMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = dataMapperMediatorStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.inputType);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.outputType);
		
		
		composer = new PartComposer(dataMapperMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.DataMapperMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.inputType) {
					return createInputTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath) {
					return createConfigurationLocalPathText(parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath) {
					return createInputSchemaLocalPathText(parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath) {
					return createOutputSchemaLocalPathText(parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.outputType) {
					return createOutputTypeEMFComboViewer(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.DataMapperMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DataMapperMediator.Properties.description, EsbMessages.DataMapperMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.DataMapperMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.DataMapperMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.DataMapperMediator.Properties.commentsList, EsbMessages.DataMapperMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "DataMapperMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.DataMapperMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.DataMapperMediator.Properties.reverse, EsbMessages.DataMapperMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.DataMapperMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createInputTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.DataMapperMediator.Properties.inputType, EsbMessages.DataMapperMediatorPropertiesEditionPart_InputTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.inputType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInputType()));
			}

		});
		inputType.setID(EsbViewsRepository.DataMapperMediator.Properties.inputType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.inputType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createConfigurationLocalPathText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath, EsbMessages.DataMapperMediatorPropertiesEditionPart_ConfigurationLocalPathLabel);
		configurationLocalPath = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData configurationLocalPathData = new GridData(GridData.FILL_HORIZONTAL);
		configurationLocalPath.setLayoutData(configurationLocalPathData);
		configurationLocalPath.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, configurationLocalPath.getText()));
			}

		});
		configurationLocalPath.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, configurationLocalPath.getText()));
				}
			}

		});
		EditingUtils.setID(configurationLocalPath, EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath);
		EditingUtils.setEEFtype(configurationLocalPath, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createConfigurationLocalPathText

		// End of user code
		return parent;
	}

	
	protected Composite createInputSchemaLocalPathText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath, EsbMessages.DataMapperMediatorPropertiesEditionPart_InputSchemaLocalPathLabel);
		inputSchemaLocalPath = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData inputSchemaLocalPathData = new GridData(GridData.FILL_HORIZONTAL);
		inputSchemaLocalPath.setLayoutData(inputSchemaLocalPathData);
		inputSchemaLocalPath.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputSchemaLocalPath.getText()));
			}

		});
		inputSchemaLocalPath.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputSchemaLocalPath.getText()));
				}
			}

		});
		EditingUtils.setID(inputSchemaLocalPath, EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath);
		EditingUtils.setEEFtype(inputSchemaLocalPath, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputSchemaLocalPathText

		// End of user code
		return parent;
	}

	
	protected Composite createOutputSchemaLocalPathText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath, EsbMessages.DataMapperMediatorPropertiesEditionPart_OutputSchemaLocalPathLabel);
		outputSchemaLocalPath = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData outputSchemaLocalPathData = new GridData(GridData.FILL_HORIZONTAL);
		outputSchemaLocalPath.setLayoutData(outputSchemaLocalPathData);
		outputSchemaLocalPath.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputSchemaLocalPath.getText()));
			}

		});
		outputSchemaLocalPath.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputSchemaLocalPath.getText()));
				}
			}

		});
		EditingUtils.setID(outputSchemaLocalPath, EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath);
		EditingUtils.setEEFtype(outputSchemaLocalPath, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputSchemaLocalPathText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createOutputTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.DataMapperMediator.Properties.outputType, EsbMessages.DataMapperMediatorPropertiesEditionPart_OutputTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DataMapperMediator.Properties.outputType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputType()));
			}

		});
		outputType.setID(EsbViewsRepository.DataMapperMediator.Properties.outputType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.outputType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputTypeEMFComboViewer

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getInputType()
	 * 
	 */
	public Enumerator getInputType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inputType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#initInputType(Object input, Enumerator current)
	 */
	public void initInputType(Object input, Enumerator current) {
		inputType.setInput(input);
		inputType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.inputType);
		if (eefElementEditorReadOnlyState && inputType.isEnabled()) {
			inputType.setEnabled(false);
			inputType.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputType.isEnabled()) {
			inputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setInputType(Enumerator newValue)
	 * 
	 */
	public void setInputType(Enumerator newValue) {
		inputType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.inputType);
		if (eefElementEditorReadOnlyState && inputType.isEnabled()) {
			inputType.setEnabled(false);
			inputType.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputType.isEnabled()) {
			inputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getConfigurationLocalPath()
	 * 
	 */
	public String getConfigurationLocalPath() {
		return configurationLocalPath.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setConfigurationLocalPath(String newValue)
	 * 
	 */
	public void setConfigurationLocalPath(String newValue) {
		if (newValue != null) {
			configurationLocalPath.setText(newValue);
		} else {
			configurationLocalPath.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath);
		if (eefElementEditorReadOnlyState && configurationLocalPath.isEnabled()) {
			configurationLocalPath.setEnabled(false);
			configurationLocalPath.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !configurationLocalPath.isEnabled()) {
			configurationLocalPath.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getInputSchemaLocalPath()
	 * 
	 */
	public String getInputSchemaLocalPath() {
		return inputSchemaLocalPath.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setInputSchemaLocalPath(String newValue)
	 * 
	 */
	public void setInputSchemaLocalPath(String newValue) {
		if (newValue != null) {
			inputSchemaLocalPath.setText(newValue);
		} else {
			inputSchemaLocalPath.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath);
		if (eefElementEditorReadOnlyState && inputSchemaLocalPath.isEnabled()) {
			inputSchemaLocalPath.setEnabled(false);
			inputSchemaLocalPath.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputSchemaLocalPath.isEnabled()) {
			inputSchemaLocalPath.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getOutputSchemaLocalPath()
	 * 
	 */
	public String getOutputSchemaLocalPath() {
		return outputSchemaLocalPath.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setOutputSchemaLocalPath(String newValue)
	 * 
	 */
	public void setOutputSchemaLocalPath(String newValue) {
		if (newValue != null) {
			outputSchemaLocalPath.setText(newValue);
		} else {
			outputSchemaLocalPath.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath);
		if (eefElementEditorReadOnlyState && outputSchemaLocalPath.isEnabled()) {
			outputSchemaLocalPath.setEnabled(false);
			outputSchemaLocalPath.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputSchemaLocalPath.isEnabled()) {
			outputSchemaLocalPath.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getOutputType()
	 * 
	 */
	public Enumerator getOutputType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outputType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#initOutputType(Object input, Enumerator current)
	 */
	public void initOutputType(Object input, Enumerator current) {
		outputType.setInput(input);
		outputType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.outputType);
		if (eefElementEditorReadOnlyState && outputType.isEnabled()) {
			outputType.setEnabled(false);
			outputType.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputType.isEnabled()) {
			outputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setOutputType(Enumerator newValue)
	 * 
	 */
	public void setOutputType(Enumerator newValue) {
		outputType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.outputType);
		if (eefElementEditorReadOnlyState && outputType.isEnabled()) {
			outputType.setEnabled(false);
			outputType.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputType.isEnabled()) {
			outputType.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.DataMapperMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
