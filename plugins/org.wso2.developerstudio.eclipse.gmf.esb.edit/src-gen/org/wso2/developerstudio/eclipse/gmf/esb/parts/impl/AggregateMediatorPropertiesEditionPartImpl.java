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
import org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class AggregateMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, AggregateMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text aggregateID;
	protected Text completionTimeout;
	protected EMFComboViewer completionMinMessagesType;
	protected EMFComboViewer completionMaxMessagesType;
	protected Text completionMinMessagesValue;
	protected Text completionMaxMessagesValue;
	protected Text enclosingElementProperty;
	protected EMFComboViewer aggregateElementType;
  // Start of user code  for correlationExpression widgets declarations
	
	// End of user code

	// Start of user code  for completionMinMessages widgets declarations
	
	// End of user code

	// Start of user code  for completionMaxMessages widgets declarations
	
	// End of user code

	// Start of user code  for aggregationExpression widgets declarations
	
	// End of user code

	protected EMFComboViewer sequenceType;
	// Start of user code  for sequenceKey widgets declarations
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AggregateMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence aggregateMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = aggregateMediatorStep.addStep(EsbViewsRepository.AggregateMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.aggregateID);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionTimeout);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.correlationExpression);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMinMessages);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessages);
		
		CompositionStep onCompleteStep = aggregateMediatorStep.addStep(EsbViewsRepository.AggregateMediator.OnComplete.class);
		onCompleteStep.addStep(EsbViewsRepository.AggregateMediator.OnComplete.aggregationExpression);
		onCompleteStep.addStep(EsbViewsRepository.AggregateMediator.OnComplete.sequenceType);
		onCompleteStep.addStep(EsbViewsRepository.AggregateMediator.OnComplete.sequenceKey);
		
		
		composer = new PartComposer(aggregateMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.AggregateMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.aggregateID) {
					return createAggregateIDText(parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.completionTimeout) {
					return createCompletionTimeoutText(parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType) {
					return createCompletionMinMessagesTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType) {
					return createCompletionMaxMessagesTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue) {
					return createCompletionMinMessagesValueText(parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue) {
					return createCompletionMaxMessagesValueText(parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty) {
					return createEnclosingElementPropertyText(parent);
				}
				// Start of user code for correlationExpression addToPart creation
				
				// End of user code
				// Start of user code for completionMinMessages addToPart creation
				
				// End of user code
				// Start of user code for completionMaxMessages addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.AggregateMediator.OnComplete.class) {
					return createOnCompleteGroup(parent);
				}
				// Start of user code for aggregationExpression addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.AggregateMediator.OnComplete.sequenceType) {
					return createSequenceTypeEMFComboViewer(parent);
				}
				// Start of user code for sequenceKey addToPart creation
				
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
		propertiesGroup.setText(EsbMessages.AggregateMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.description, EsbMessages.AggregateMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.AggregateMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.AggregateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.AggregateMediator.Properties.commentsList, EsbMessages.AggregateMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "AggregateMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.AggregateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.AggregateMediator.Properties.reverse, EsbMessages.AggregateMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.AggregateMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAggregateIDText(Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.aggregateID, EsbMessages.AggregateMediatorPropertiesEditionPart_AggregateIDLabel);
		aggregateID = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData aggregateIDData = new GridData(GridData.FILL_HORIZONTAL);
		aggregateID.setLayoutData(aggregateIDData);
		aggregateID.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.aggregateID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, aggregateID.getText()));
			}

		});
		aggregateID.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.aggregateID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, aggregateID.getText()));
				}
			}

		});
		EditingUtils.setID(aggregateID, EsbViewsRepository.AggregateMediator.Properties.aggregateID);
		EditingUtils.setEEFtype(aggregateID, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.aggregateID, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAggregateIDText

		// End of user code
		return parent;
	}

	
	protected Composite createCompletionTimeoutText(Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.completionTimeout, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionTimeoutLabel);
		completionTimeout = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData completionTimeoutData = new GridData(GridData.FILL_HORIZONTAL);
		completionTimeout.setLayoutData(completionTimeoutData);
		completionTimeout.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.completionTimeout, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionTimeout.getText()));
			}

		});
		completionTimeout.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.completionTimeout, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionTimeout.getText()));
				}
			}

		});
		EditingUtils.setID(completionTimeout, EsbViewsRepository.AggregateMediator.Properties.completionTimeout);
		EditingUtils.setEEFtype(completionTimeout, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionTimeout, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionTimeoutText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createCompletionMinMessagesTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionMinMessagesTypeLabel);
		completionMinMessagesType = new EMFComboViewer(parent);
		completionMinMessagesType.setContentProvider(new ArrayContentProvider());
		completionMinMessagesType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData completionMinMessagesTypeData = new GridData(GridData.FILL_HORIZONTAL);
		completionMinMessagesType.getCombo().setLayoutData(completionMinMessagesTypeData);
                completionMinMessagesType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		completionMinMessagesType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCompletionMinMessagesType()));
			}

		});
		completionMinMessagesType.setID(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMinMessagesTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createCompletionMaxMessagesTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionMaxMessagesTypeLabel);
		completionMaxMessagesType = new EMFComboViewer(parent);
		completionMaxMessagesType.setContentProvider(new ArrayContentProvider());
		completionMaxMessagesType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData completionMaxMessagesTypeData = new GridData(GridData.FILL_HORIZONTAL);
		completionMaxMessagesType.getCombo().setLayoutData(completionMaxMessagesTypeData);
                completionMaxMessagesType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		completionMaxMessagesType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCompletionMaxMessagesType()));
			}

		});
		completionMaxMessagesType.setID(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMaxMessagesTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createCompletionMinMessagesValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionMinMessagesValueLabel);
		completionMinMessagesValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData completionMinMessagesValueData = new GridData(GridData.FILL_HORIZONTAL);
		completionMinMessagesValue.setLayoutData(completionMinMessagesValueData);
		completionMinMessagesValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionMinMessagesValue.getText()));
			}

		});
		completionMinMessagesValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionMinMessagesValue.getText()));
				}
			}

		});
		EditingUtils.setID(completionMinMessagesValue, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue);
		EditingUtils.setEEFtype(completionMinMessagesValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMinMessagesValueText

		// End of user code
		return parent;
	}

	
	protected Composite createCompletionMaxMessagesValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionMaxMessagesValueLabel);
		completionMaxMessagesValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData completionMaxMessagesValueData = new GridData(GridData.FILL_HORIZONTAL);
		completionMaxMessagesValue.setLayoutData(completionMaxMessagesValueData);
		completionMaxMessagesValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionMaxMessagesValue.getText()));
			}

		});
		completionMaxMessagesValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionMaxMessagesValue.getText()));
				}
			}

		});
		EditingUtils.setID(completionMaxMessagesValue, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue);
		EditingUtils.setEEFtype(completionMaxMessagesValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMaxMessagesValueText

		// End of user code
		return parent;
	}

	
	protected Composite createEnclosingElementPropertyText(Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty, EsbMessages.AggregateMediatorPropertiesEditionPart_EnclosingElementPropertyLabel);
		enclosingElementProperty = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData enclosingElementPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		enclosingElementProperty.setLayoutData(enclosingElementPropertyData);
		enclosingElementProperty.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, enclosingElementProperty.getText()));
			}

		});
		enclosingElementProperty.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, enclosingElementProperty.getText()));
				}
			}

		});
		EditingUtils.setID(enclosingElementProperty, EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty);
		EditingUtils.setEEFtype(enclosingElementProperty, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEnclosingElementPropertyText

		// End of user code
		return parent;
	}

	protected Composite createAggregateElementTypeEMFComboViewer(Composite parent) {
    createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.aggregateElementType, EsbMessages.AggregateMediatorPropertiesEditionPart_AggregateElementTypeLabel);
    aggregateElementType = new EMFComboViewer(parent);
    aggregateElementType.setContentProvider(new ArrayContentProvider());
    aggregateElementType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData aggregateElementTypeData = new GridData(GridData.FILL_HORIZONTAL);
    aggregateElementType.getCombo().setLayoutData(aggregateElementTypeData);
    aggregateElementType.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.Properties.aggregateElementType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAggregateElementType()));
      }

    });
    aggregateElementType.setID(EsbViewsRepository.AggregateMediator.Properties.aggregateElementType);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.aggregateElementType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createAggregateElementTypeEMFComboViewer

    // End of user code
    return parent;
  }

  /**
	 * 
	 */
	protected Composite createOnCompleteGroup(Composite parent) {
		Group onCompleteGroup = new Group(parent, SWT.NONE);
		onCompleteGroup.setText(EsbMessages.AggregateMediatorPropertiesEditionPart_OnCompleteGroupLabel);
		GridData onCompleteGroupData = new GridData(GridData.FILL_HORIZONTAL);
		onCompleteGroupData.horizontalSpan = 3;
		onCompleteGroup.setLayoutData(onCompleteGroupData);
		GridLayout onCompleteGroupLayout = new GridLayout();
		onCompleteGroupLayout.numColumns = 3;
		onCompleteGroup.setLayout(onCompleteGroupLayout);
		return onCompleteGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.OnComplete.sequenceType, EsbMessages.AggregateMediatorPropertiesEditionPart_SequenceTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.AggregateMediator.OnComplete.sequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceType()));
			}

		});
		sequenceType.setID(EsbViewsRepository.AggregateMediator.OnComplete.sequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.OnComplete.sequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceTypeEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getAggregateID()
	 * 
	 */
	public String getAggregateID() {
		return aggregateID.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setAggregateID(String newValue)
	 * 
	 */
	public void setAggregateID(String newValue) {
		if (newValue != null) {
			aggregateID.setText(newValue);
		} else {
			aggregateID.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.aggregateID);
		if (eefElementEditorReadOnlyState && aggregateID.isEnabled()) {
			aggregateID.setEnabled(false);
			aggregateID.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !aggregateID.isEnabled()) {
			aggregateID.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionTimeout()
	 * 
	 */
	public String getCompletionTimeout() {
		return completionTimeout.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionTimeout(String newValue)
	 * 
	 */
	public void setCompletionTimeout(String newValue) {
		if (newValue != null) {
			completionTimeout.setText(newValue);
		} else {
			completionTimeout.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionTimeout);
		if (eefElementEditorReadOnlyState && completionTimeout.isEnabled()) {
			completionTimeout.setEnabled(false);
			completionTimeout.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionTimeout.isEnabled()) {
			completionTimeout.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMinMessagesType()
	 * 
	 */
	public Enumerator getCompletionMinMessagesType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) completionMinMessagesType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#initCompletionMinMessagesType(Object input, Enumerator current)
	 */
	public void initCompletionMinMessagesType(Object input, Enumerator current) {
		completionMinMessagesType.setInput(input);
		completionMinMessagesType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType);
		if (eefElementEditorReadOnlyState && completionMinMessagesType.isEnabled()) {
			completionMinMessagesType.setEnabled(false);
			completionMinMessagesType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMinMessagesType.isEnabled()) {
			completionMinMessagesType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMinMessagesType(Enumerator newValue)
	 * 
	 */
	public void setCompletionMinMessagesType(Enumerator newValue) {
		completionMinMessagesType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType);
		if (eefElementEditorReadOnlyState && completionMinMessagesType.isEnabled()) {
			completionMinMessagesType.setEnabled(false);
			completionMinMessagesType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMinMessagesType.isEnabled()) {
			completionMinMessagesType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMaxMessagesType()
	 * 
	 */
	public Enumerator getCompletionMaxMessagesType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) completionMaxMessagesType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#initCompletionMaxMessagesType(Object input, Enumerator current)
	 */
	public void initCompletionMaxMessagesType(Object input, Enumerator current) {
		completionMaxMessagesType.setInput(input);
		completionMaxMessagesType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType);
		if (eefElementEditorReadOnlyState && completionMaxMessagesType.isEnabled()) {
			completionMaxMessagesType.setEnabled(false);
			completionMaxMessagesType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMaxMessagesType.isEnabled()) {
			completionMaxMessagesType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMaxMessagesType(Enumerator newValue)
	 * 
	 */
	public void setCompletionMaxMessagesType(Enumerator newValue) {
		completionMaxMessagesType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType);
		if (eefElementEditorReadOnlyState && completionMaxMessagesType.isEnabled()) {
			completionMaxMessagesType.setEnabled(false);
			completionMaxMessagesType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMaxMessagesType.isEnabled()) {
			completionMaxMessagesType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMinMessagesValue()
	 * 
	 */
	public String getCompletionMinMessagesValue() {
		return completionMinMessagesValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMinMessagesValue(String newValue)
	 * 
	 */
	public void setCompletionMinMessagesValue(String newValue) {
		if (newValue != null) {
			completionMinMessagesValue.setText(newValue);
		} else {
			completionMinMessagesValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue);
		if (eefElementEditorReadOnlyState && completionMinMessagesValue.isEnabled()) {
			completionMinMessagesValue.setEnabled(false);
			completionMinMessagesValue.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMinMessagesValue.isEnabled()) {
			completionMinMessagesValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMaxMessagesValue()
	 * 
	 */
	public String getCompletionMaxMessagesValue() {
		return completionMaxMessagesValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMaxMessagesValue(String newValue)
	 * 
	 */
	public void setCompletionMaxMessagesValue(String newValue) {
		if (newValue != null) {
			completionMaxMessagesValue.setText(newValue);
		} else {
			completionMaxMessagesValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue);
		if (eefElementEditorReadOnlyState && completionMaxMessagesValue.isEnabled()) {
			completionMaxMessagesValue.setEnabled(false);
			completionMaxMessagesValue.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMaxMessagesValue.isEnabled()) {
			completionMaxMessagesValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getEnclosingElementProperty()
	 * 
	 */
	public String getEnclosingElementProperty() {
		return enclosingElementProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setEnclosingElementProperty(String newValue)
	 * 
	 */
	public void setEnclosingElementProperty(String newValue) {
		if (newValue != null) {
			enclosingElementProperty.setText(newValue);
		} else {
			enclosingElementProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty);
		if (eefElementEditorReadOnlyState && enclosingElementProperty.isEnabled()) {
			enclosingElementProperty.setEnabled(false);
			enclosingElementProperty.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !enclosingElementProperty.isEnabled()) {
			enclosingElementProperty.setEnabled(true);
		}	
		
	}

	/**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getAggregateElementType()
   * 
   */
  public Enumerator getAggregateElementType() {
    Enumerator selection = (Enumerator) ((StructuredSelection) aggregateElementType.getSelection()).getFirstElement();
    return selection;
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#initAggregateElementType(Object input, Enumerator current)
   */
  public void initAggregateElementType(Object input, Enumerator current) {
    aggregateElementType.setInput(input);
    aggregateElementType.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.aggregateElementType);
    if (eefElementEditorReadOnlyState && aggregateElementType.isEnabled()) {
      aggregateElementType.setEnabled(false);
      aggregateElementType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !aggregateElementType.isEnabled()) {
      aggregateElementType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setAggregateElementType(Enumerator newValue)
   * 
   */
  public void setAggregateElementType(Enumerator newValue) {
    aggregateElementType.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.aggregateElementType);
    if (eefElementEditorReadOnlyState && aggregateElementType.isEnabled()) {
      aggregateElementType.setEnabled(false);
      aggregateElementType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !aggregateElementType.isEnabled()) {
      aggregateElementType.setEnabled(true);
    }	
    
  }

  /**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getSequenceType()
	 * 
	 */
	public Enumerator getSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#initSequenceType(Object input, Enumerator current)
	 */
	public void initSequenceType(Object input, Enumerator current) {
		sequenceType.setInput(input);
		sequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.OnComplete.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setSequenceType(Enumerator newValue)
	 * 
	 */
	public void setSequenceType(Enumerator newValue) {
		sequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.OnComplete.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}






	// Start of user code for correlationExpression specific getters and setters implementation
	
	// End of user code

	// Start of user code for completionMinMessages specific getters and setters implementation
	
	// End of user code

	// Start of user code for completionMaxMessages specific getters and setters implementation
	
	// End of user code

	// Start of user code for aggregationExpression specific getters and setters implementation
	
	// End of user code

	// Start of user code for sequenceKey specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.AggregateMediator_Part_Title;
	}

	// Start of user code additional methods
    @Override
    public NamespacedProperty getCorrelationExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCorrelationExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public NamespacedProperty getCompletionMinMessagesExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCompletionMinMessagesExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public NamespacedProperty getCompletionMaxMessagesExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCompletionMaxMessagesExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public NamespacedProperty getAggregationExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAggregationExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }

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


}
