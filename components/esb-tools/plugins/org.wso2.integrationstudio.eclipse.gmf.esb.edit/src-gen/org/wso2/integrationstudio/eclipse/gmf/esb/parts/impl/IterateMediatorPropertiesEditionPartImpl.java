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
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class IterateMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, IterateMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text iterateID;
	protected Button sequentialMediation;
	protected Button continueParent;
	protected Button preservePayload;
	protected EMFComboViewer sequenceType;
	protected Text sequenceName;
	// Start of user code  for iterateExpression widgets declarations
	protected NamespacedProperty iterateExpression;
	// End of user code

	// Start of user code  for sequenceKey widgets declarations
	protected RegistryKeyProperty sequenceKey;
	// End of user code

	// Start of user code  for attachPath widgets declarations
	protected NamespacedProperty attachPath;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public IterateMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence iterateMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = iterateMediatorStep.addStep(EsbViewsRepository.IterateMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.iterateID);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.sequentialMediation);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.continueParent);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.preservePayload);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.sequenceType);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.sequenceName);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.iterateExpression);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.sequenceKey);
		propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.attachPath);
		
		
		composer = new PartComposer(iterateMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.IterateMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.IterateMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.IterateMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.IterateMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.IterateMediator.Properties.iterateID) {
					return createIterateIDText(parent);
				}
				if (key == EsbViewsRepository.IterateMediator.Properties.sequentialMediation) {
					return createSequentialMediationCheckbox(parent);
				}
				if (key == EsbViewsRepository.IterateMediator.Properties.continueParent) {
					return createContinueParentCheckbox(parent);
				}
				if (key == EsbViewsRepository.IterateMediator.Properties.preservePayload) {
					return createPreservePayloadCheckbox(parent);
				}
				if (key == EsbViewsRepository.IterateMediator.Properties.sequenceType) {
					return createSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.IterateMediator.Properties.sequenceName) {
					return createSequenceNameText(parent);
				}
				// Start of user code for iterateExpression addToPart creation
				
				// End of user code
				// Start of user code for sequenceKey addToPart creation
				
				// End of user code
				// Start of user code for attachPath addToPart creation
				
				// End of user code
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
		propertiesGroup.setText(EsbMessages.IterateMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.IterateMediator.Properties.description, EsbMessages.IterateMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.IterateMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.IterateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.IterateMediator.Properties.commentsList, EsbMessages.IterateMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "IterateMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.IterateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.IterateMediator.Properties.reverse, EsbMessages.IterateMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.IterateMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createIterateIDText(Composite parent) {
		createDescription(parent, EsbViewsRepository.IterateMediator.Properties.iterateID, EsbMessages.IterateMediatorPropertiesEditionPart_IterateIDLabel);
		iterateID = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData iterateIDData = new GridData(GridData.FILL_HORIZONTAL);
		iterateID.setLayoutData(iterateIDData);
		iterateID.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.iterateID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, iterateID.getText()));
			}

		});
		iterateID.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.iterateID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, iterateID.getText()));
				}
			}

		});
		EditingUtils.setID(iterateID, EsbViewsRepository.IterateMediator.Properties.iterateID);
		EditingUtils.setEEFtype(iterateID, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.iterateID, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIterateIDText

		// End of user code
		return parent;
	}

	
	protected Composite createSequentialMediationCheckbox(Composite parent) {
		sequentialMediation = new Button(parent, SWT.CHECK);
		sequentialMediation.setText(getDescription(EsbViewsRepository.IterateMediator.Properties.sequentialMediation, EsbMessages.IterateMediatorPropertiesEditionPart_SequentialMediationLabel));
		sequentialMediation.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.sequentialMediation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(sequentialMediation.getSelection())));
			}

		});
		GridData sequentialMediationData = new GridData(GridData.FILL_HORIZONTAL);
		sequentialMediationData.horizontalSpan = 2;
		sequentialMediation.setLayoutData(sequentialMediationData);
		EditingUtils.setID(sequentialMediation, EsbViewsRepository.IterateMediator.Properties.sequentialMediation);
		EditingUtils.setEEFtype(sequentialMediation, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.sequentialMediation, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequentialMediationCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createContinueParentCheckbox(Composite parent) {
		continueParent = new Button(parent, SWT.CHECK);
		continueParent.setText(getDescription(EsbViewsRepository.IterateMediator.Properties.continueParent, EsbMessages.IterateMediatorPropertiesEditionPart_ContinueParentLabel));
		continueParent.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.continueParent, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(continueParent.getSelection())));
			}

		});
		GridData continueParentData = new GridData(GridData.FILL_HORIZONTAL);
		continueParentData.horizontalSpan = 2;
		continueParent.setLayoutData(continueParentData);
		EditingUtils.setID(continueParent, EsbViewsRepository.IterateMediator.Properties.continueParent);
		EditingUtils.setEEFtype(continueParent, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.continueParent, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createContinueParentCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createPreservePayloadCheckbox(Composite parent) {
		preservePayload = new Button(parent, SWT.CHECK);
		preservePayload.setText(getDescription(EsbViewsRepository.IterateMediator.Properties.preservePayload, EsbMessages.IterateMediatorPropertiesEditionPart_PreservePayloadLabel));
		preservePayload.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.preservePayload, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(preservePayload.getSelection())));
			}

		});
		GridData preservePayloadData = new GridData(GridData.FILL_HORIZONTAL);
		preservePayloadData.horizontalSpan = 2;
		preservePayload.setLayoutData(preservePayloadData);
		EditingUtils.setID(preservePayload, EsbViewsRepository.IterateMediator.Properties.preservePayload);
		EditingUtils.setEEFtype(preservePayload, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.preservePayload, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPreservePayloadCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.IterateMediator.Properties.sequenceType, EsbMessages.IterateMediatorPropertiesEditionPart_SequenceTypeLabel);
		sequenceType = new EMFComboViewer(parent);
		sequenceType.setContentProvider(new ArrayContentProvider());
		sequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		sequenceType.getCombo().setLayoutData(sequenceTypeData);
                sequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		sequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.sequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceType()));
			}

		});
		sequenceType.setID(EsbViewsRepository.IterateMediator.Properties.sequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.sequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createSequenceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.IterateMediator.Properties.sequenceName, EsbMessages.IterateMediatorPropertiesEditionPart_SequenceNameLabel);
		sequenceName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData sequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		sequenceName.setLayoutData(sequenceNameData);
		sequenceName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.sequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sequenceName.getText()));
			}

		});
		sequenceName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.IterateMediator.Properties.sequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sequenceName.getText()));
				}
			}

		});
		EditingUtils.setID(sequenceName, EsbViewsRepository.IterateMediator.Properties.sequenceName);
		EditingUtils.setEEFtype(sequenceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.sequenceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceNameText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getIterateID()
	 * 
	 */
	public String getIterateID() {
		return iterateID.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setIterateID(String newValue)
	 * 
	 */
	public void setIterateID(String newValue) {
		if (newValue != null) {
			iterateID.setText(newValue);
		} else {
			iterateID.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.iterateID);
		if (eefElementEditorReadOnlyState && iterateID.isEnabled()) {
			iterateID.setEnabled(false);
			iterateID.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !iterateID.isEnabled()) {
			iterateID.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getSequentialMediation()
	 * 
	 */
	public Boolean getSequentialMediation() {
		return Boolean.valueOf(sequentialMediation.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setSequentialMediation(Boolean newValue)
	 * 
	 */
	public void setSequentialMediation(Boolean newValue) {
		if (newValue != null) {
			sequentialMediation.setSelection(newValue.booleanValue());
		} else {
			sequentialMediation.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.sequentialMediation);
		if (eefElementEditorReadOnlyState && sequentialMediation.isEnabled()) {
			sequentialMediation.setEnabled(false);
			sequentialMediation.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequentialMediation.isEnabled()) {
			sequentialMediation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getContinueParent()
	 * 
	 */
	public Boolean getContinueParent() {
		return Boolean.valueOf(continueParent.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setContinueParent(Boolean newValue)
	 * 
	 */
	public void setContinueParent(Boolean newValue) {
		if (newValue != null) {
			continueParent.setSelection(newValue.booleanValue());
		} else {
			continueParent.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.continueParent);
		if (eefElementEditorReadOnlyState && continueParent.isEnabled()) {
			continueParent.setEnabled(false);
			continueParent.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !continueParent.isEnabled()) {
			continueParent.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getPreservePayload()
	 * 
	 */
	public Boolean getPreservePayload() {
		return Boolean.valueOf(preservePayload.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setPreservePayload(Boolean newValue)
	 * 
	 */
	public void setPreservePayload(Boolean newValue) {
		if (newValue != null) {
			preservePayload.setSelection(newValue.booleanValue());
		} else {
			preservePayload.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.preservePayload);
		if (eefElementEditorReadOnlyState && preservePayload.isEnabled()) {
			preservePayload.setEnabled(false);
			preservePayload.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !preservePayload.isEnabled()) {
			preservePayload.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getSequenceType()
	 * 
	 */
	public Enumerator getSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#initSequenceType(Object input, Enumerator current)
	 */
	public void initSequenceType(Object input, Enumerator current) {
		sequenceType.setInput(input);
		sequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setSequenceType(Enumerator newValue)
	 * 
	 */
	public void setSequenceType(Enumerator newValue) {
		sequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getSequenceName()
	 * 
	 */
	public String getSequenceName() {
		return sequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setSequenceName(String newValue)
	 * 
	 */
	public void setSequenceName(String newValue) {
		if (newValue != null) {
			sequenceName.setText(newValue);
		} else {
			sequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.sequenceName);
		if (eefElementEditorReadOnlyState && sequenceName.isEnabled()) {
			sequenceName.setEnabled(false);
			sequenceName.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceName.isEnabled()) {
			sequenceName.setEnabled(true);
		}	
		
	}






	// Start of user code for iterateExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getIterateExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setIterateExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub

    }
    // End of user code

	// Start of user code for sequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getSequenceKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSequenceKey(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub

    }
    // End of user code

	// Start of user code for attachPath specific getters and setters implementation
    @Override
    public NamespacedProperty getAttachPath() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAttachPath(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub

    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.IterateMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
