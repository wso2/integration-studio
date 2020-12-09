/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

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
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class SendMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SendMediatorPropertiesEditionPart {

	protected Button skipSerialization;
	protected ReferencesTable endPoint;
	protected List<ViewerFilter> endPointBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> endPointFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer receivingSequenceType;
	protected Button buildMessageBeforeSending;
	// Start of user code  for StaticReceivingSequence widgets declarations
	
	// End of user code

	// Start of user code  for DynamicReceivingSequence widgets declarations
	
	// End of user code

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SendMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence sendMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = sendMediatorStep.addStep(EsbViewsRepository.SendMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.SendMediator.Properties.skipSerialization);
		propertiesStep.addStep(EsbViewsRepository.SendMediator.Properties.endPoint);
		propertiesStep.addStep(EsbViewsRepository.SendMediator.Properties.receivingSequenceType);
		propertiesStep.addStep(EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending);
		propertiesStep.addStep(EsbViewsRepository.SendMediator.Properties.staticReceivingSequence);
		propertiesStep.addStep(EsbViewsRepository.SendMediator.Properties.dynamicReceivingSequence);
		propertiesStep.addStep(EsbViewsRepository.SendMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.SendMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.SendMediator.Properties.reverse);
		
		
		composer = new PartComposer(sendMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.SendMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.SendMediator.Properties.skipSerialization) {
					return createSkipSerializationCheckbox(parent);
				}
				if (key == EsbViewsRepository.SendMediator.Properties.endPoint) {
					return createEndPointAdvancedReferencesTable(parent);
				}
				if (key == EsbViewsRepository.SendMediator.Properties.receivingSequenceType) {
					return createReceivingSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending) {
					return createBuildMessageBeforeSendingCheckbox(parent);
				}
				// Start of user code for StaticReceivingSequence addToPart creation
				
				// End of user code
				// Start of user code for DynamicReceivingSequence addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.SendMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.SendMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.SendMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
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
		propertiesGroup.setText(EsbMessages.SendMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createSkipSerializationCheckbox(Composite parent) {
		skipSerialization = new Button(parent, SWT.CHECK);
		skipSerialization.setText(getDescription(EsbViewsRepository.SendMediator.Properties.skipSerialization, EsbMessages.SendMediatorPropertiesEditionPart_SkipSerializationLabel));
		skipSerialization.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SendMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SendMediator.Properties.skipSerialization, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(skipSerialization.getSelection())));
			}

		});
		GridData skipSerializationData = new GridData(GridData.FILL_HORIZONTAL);
		skipSerializationData.horizontalSpan = 2;
		skipSerialization.setLayoutData(skipSerializationData);
		EditingUtils.setID(skipSerialization, EsbViewsRepository.SendMediator.Properties.skipSerialization);
		EditingUtils.setEEFtype(skipSerialization, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SendMediator.Properties.skipSerialization, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSkipSerializationCheckbox

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createEndPointAdvancedReferencesTable(Composite parent) {
		String label = getDescription(EsbViewsRepository.SendMediator.Properties.endPoint, EsbMessages.SendMediatorPropertiesEditionPart_EndPointLabel);		 
		this.endPoint = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addEndPoint(); }
			public void handleEdit(EObject element) { editEndPoint(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveEndPoint(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromEndPoint(element); }
			public void navigateTo(EObject element) { }
		});
		this.endPoint.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.SendMediator.Properties.endPoint, EsbViewsRepository.SWT_KIND));
		this.endPoint.createControls(parent);
		this.endPoint.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SendMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SendMediator.Properties.endPoint, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData endPointData = new GridData(GridData.FILL_HORIZONTAL);
		endPointData.horizontalSpan = 3;
		this.endPoint.setLayoutData(endPointData);
		this.endPoint.disableMove();
		endPoint.setID(EsbViewsRepository.SendMediator.Properties.endPoint);
		endPoint.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addEndPoint() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(endPoint.getInput(), endPointFilters, endPointBusinessFilters,
		"EndPoint", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SendMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SendMediator.Properties.endPoint,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				endPoint.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveEndPoint(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SendMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SendMediator.Properties.endPoint, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		endPoint.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromEndPoint(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SendMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SendMediator.Properties.endPoint, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		endPoint.refresh();
	}

	/**
	 * 
	 */
	protected void editEndPoint(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				endPoint.refresh();
			}
		}
	}

	/**
	 * @generated NOT
	 */
	protected Composite createReceivingSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.SendMediator.Properties.receivingSequenceType, EsbMessages.SendMediatorPropertiesEditionPart_ReceivingSequenceTypeLabel);
		receivingSequenceType = new EMFComboViewer(parent);
		receivingSequenceType.setContentProvider(new ArrayContentProvider());
		receivingSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData receivingSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		receivingSequenceType.getCombo().setLayoutData(receivingSequenceTypeData);
                receivingSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		receivingSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SendMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SendMediator.Properties.receivingSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getReceivingSequenceType()));
			}

		});
		receivingSequenceType.setID(EsbViewsRepository.SendMediator.Properties.receivingSequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SendMediator.Properties.receivingSequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReceivingSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createBuildMessageBeforeSendingCheckbox(Composite parent) {
		buildMessageBeforeSending = new Button(parent, SWT.CHECK);
		buildMessageBeforeSending.setText(getDescription(EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending, EsbMessages.SendMediatorPropertiesEditionPart_BuildMessageBeforeSendingLabel));
		buildMessageBeforeSending.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SendMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(buildMessageBeforeSending.getSelection())));
			}

		});
		GridData buildMessageBeforeSendingData = new GridData(GridData.FILL_HORIZONTAL);
		buildMessageBeforeSendingData.horizontalSpan = 2;
		buildMessageBeforeSending.setLayoutData(buildMessageBeforeSendingData);
		EditingUtils.setID(buildMessageBeforeSending, EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending);
		EditingUtils.setEEFtype(buildMessageBeforeSending, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createBuildMessageBeforeSendingCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.SendMediator.Properties.description, EsbMessages.SendMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SendMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SendMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SendMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SendMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.SendMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SendMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.SendMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.SendMediator.Properties.commentsList, EsbMessages.SendMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "SendMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SendMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SendMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.SendMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.SendMediator.Properties.reverse, EsbMessages.SendMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SendMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.SendMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.SendMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SendMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#getSkipSerialization()
	 * 
	 */
	public Boolean getSkipSerialization() {
		return Boolean.valueOf(skipSerialization.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#setSkipSerialization(Boolean newValue)
	 * 
	 */
	public void setSkipSerialization(Boolean newValue) {
		if (newValue != null) {
			skipSerialization.setSelection(newValue.booleanValue());
		} else {
			skipSerialization.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SendMediator.Properties.skipSerialization);
		if (eefElementEditorReadOnlyState && skipSerialization.isEnabled()) {
			skipSerialization.setEnabled(false);
			skipSerialization.setToolTipText(EsbMessages.SendMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !skipSerialization.isEnabled()) {
			skipSerialization.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#initEndPoint(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initEndPoint(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		endPoint.setContentProvider(contentProvider);
		endPoint.setInput(settings);
		endPointBusinessFilters.clear();
		endPointFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SendMediator.Properties.endPoint);
		if (eefElementEditorReadOnlyState && endPoint.getTable().isEnabled()) {
			endPoint.setEnabled(false);
			endPoint.setToolTipText(EsbMessages.SendMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endPoint.getTable().isEnabled()) {
			endPoint.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#updateEndPoint()
	 * 
	 */
	public void updateEndPoint() {
	endPoint.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#addFilterEndPoint(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEndPoint(ViewerFilter filter) {
		endPointFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#addBusinessFilterEndPoint(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEndPoint(ViewerFilter filter) {
		endPointBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#isContainedInEndPointTable(EObject element)
	 * 
	 */
	public boolean isContainedInEndPointTable(EObject element) {
		return ((ReferencesTableSettings)endPoint.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#getReceivingSequenceType()
	 * 
	 */
	public Enumerator getReceivingSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) receivingSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#initReceivingSequenceType(Object input, Enumerator current)
	 */
	public void initReceivingSequenceType(Object input, Enumerator current) {
		receivingSequenceType.setInput(input);
		receivingSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SendMediator.Properties.receivingSequenceType);
		if (eefElementEditorReadOnlyState && receivingSequenceType.isEnabled()) {
			receivingSequenceType.setEnabled(false);
			receivingSequenceType.setToolTipText(EsbMessages.SendMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !receivingSequenceType.isEnabled()) {
			receivingSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#setReceivingSequenceType(Enumerator newValue)
	 * 
	 */
	public void setReceivingSequenceType(Enumerator newValue) {
		receivingSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SendMediator.Properties.receivingSequenceType);
		if (eefElementEditorReadOnlyState && receivingSequenceType.isEnabled()) {
			receivingSequenceType.setEnabled(false);
			receivingSequenceType.setToolTipText(EsbMessages.SendMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !receivingSequenceType.isEnabled()) {
			receivingSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#getBuildMessageBeforeSending()
	 * 
	 */
	public Boolean getBuildMessageBeforeSending() {
		return Boolean.valueOf(buildMessageBeforeSending.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#setBuildMessageBeforeSending(Boolean newValue)
	 * 
	 */
	public void setBuildMessageBeforeSending(Boolean newValue) {
		if (newValue != null) {
			buildMessageBeforeSending.setSelection(newValue.booleanValue());
		} else {
			buildMessageBeforeSending.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SendMediator.Properties.buildMessageBeforeSending);
		if (eefElementEditorReadOnlyState && buildMessageBeforeSending.isEnabled()) {
			buildMessageBeforeSending.setEnabled(false);
			buildMessageBeforeSending.setToolTipText(EsbMessages.SendMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !buildMessageBeforeSending.isEnabled()) {
			buildMessageBeforeSending.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SendMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.SendMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SendMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.SendMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SendMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SendMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.SendMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}






	// Start of user code for StaticReceivingSequence specific getters and setters implementation
	@Override
	public void setStaticReceivingSequence(RegistryKeyProperty registryKeyProperty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RegistryKeyProperty getStaticReceivingSequence() {
		// TODO Auto-generated method stub
		return null;
	}

	// End of user code

	// Start of user code for DynamicReceivingSequence specific getters and setters implementation
	@Override
	public void setDynamicReceivingSequence(NamespacedProperty namespacedProperty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NamespacedProperty getDynamicReceivingSequence() {
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
		return EsbMessages.SendMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
