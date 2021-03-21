/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
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

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

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

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.gmf.esb.EsbPackage;

import org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;

import org.wso2.integrationstudio.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class DSSMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, DSSMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text serviceName;
	protected EMFComboViewer sourceType;
	protected EMFComboViewer operationType;
	protected ReferencesTable operations;
	protected List<ViewerFilter> operationsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> operationsFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer targetType;
	protected Text targetProperty;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DSSMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence dSSMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = dSSMediatorStep.addStep(EsbViewsRepository.DSSMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.serviceName);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.sourceType);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.operationType);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.operations);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.targetType);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.targetProperty);
		
		
		composer = new PartComposer(dSSMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.DSSMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.serviceName) {
					return createServiceNameText(parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.sourceType) {
					return createSourceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.operationType) {
					return createOperationTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.operations) {
					return createOperationsAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.targetType) {
					return createTargetTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.targetProperty) {
					return createTargetPropertyText(parent);
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
		propertiesGroup.setText(EsbMessages.DSSMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DSSMediator.Properties.description, EsbMessages.DSSMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.DSSMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.DSSMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.DSSMediator.Properties.commentsList, EsbMessages.DSSMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "DSSMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.DSSMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.DSSMediator.Properties.reverse, EsbMessages.DSSMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.DSSMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createServiceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DSSMediator.Properties.serviceName, EsbMessages.DSSMediatorPropertiesEditionPart_ServiceNameLabel);
		serviceName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData serviceNameData = new GridData(GridData.FILL_HORIZONTAL);
		serviceName.setLayoutData(serviceNameData);
		serviceName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.serviceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceName.getText()));
			}

		});
		serviceName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.serviceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceName.getText()));
				}
			}

		});
		EditingUtils.setID(serviceName, EsbViewsRepository.DSSMediator.Properties.serviceName);
		EditingUtils.setEEFtype(serviceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.serviceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createServiceNameText

		// End of user code
		return parent;
	}

	
	protected Composite createSourceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.DSSMediator.Properties.sourceType, EsbMessages.DSSMediatorPropertiesEditionPart_SourceTypeLabel);
		sourceType = new EMFComboViewer(parent);
		sourceType.setContentProvider(new ArrayContentProvider());
		sourceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sourceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		sourceType.getCombo().setLayoutData(sourceTypeData);
		sourceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.sourceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceType()));
			}

		});
		sourceType.setID(EsbViewsRepository.DSSMediator.Properties.sourceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.sourceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOperationTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.DSSMediator.Properties.operationType, EsbMessages.DSSMediatorPropertiesEditionPart_OperationTypeLabel);
		operationType = new EMFComboViewer(parent);
		operationType.setContentProvider(new ArrayContentProvider());
		operationType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData operationTypeData = new GridData(GridData.FILL_HORIZONTAL);
		operationType.getCombo().setLayoutData(operationTypeData);
		operationType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.operationType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOperationType()));
			}

		});
		operationType.setID(EsbViewsRepository.DSSMediator.Properties.operationType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.operationType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOperationTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createOperationsAdvancedTableComposition(Composite parent) {
		this.operations = new ReferencesTable(getDescription(EsbViewsRepository.DSSMediator.Properties.operations, EsbMessages.DSSMediatorPropertiesEditionPart_OperationsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				operations.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				operations.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				operations.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				operations.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.operationsFilters) {
			this.operations.addFilter(filter);
		}
		this.operations.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.operations, EsbViewsRepository.SWT_KIND));
		this.operations.createControls(parent);
		this.operations.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.operations, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData operationsData = new GridData(GridData.FILL_HORIZONTAL);
		operationsData.horizontalSpan = 3;
		this.operations.setLayoutData(operationsData);
		this.operations.setLowerBound(0);
		this.operations.setUpperBound(-1);
		operations.setID(EsbViewsRepository.DSSMediator.Properties.operations);
		operations.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createOperationsAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createTargetTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.DSSMediator.Properties.targetType, EsbMessages.DSSMediatorPropertiesEditionPart_TargetTypeLabel);
		targetType = new EMFComboViewer(parent);
		targetType.setContentProvider(new ArrayContentProvider());
		targetType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData targetTypeData = new GridData(GridData.FILL_HORIZONTAL);
		targetType.getCombo().setLayoutData(targetTypeData);
		targetType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.targetType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetType()));
			}

		});
		targetType.setID(EsbViewsRepository.DSSMediator.Properties.targetType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.targetType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createTargetPropertyText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DSSMediator.Properties.targetProperty, EsbMessages.DSSMediatorPropertiesEditionPart_TargetPropertyLabel);
		targetProperty = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData targetPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		targetProperty.setLayoutData(targetPropertyData);
		targetProperty.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.targetProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetProperty.getText()));
			}

		});
		targetProperty.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.DSSMediator.Properties.targetProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetProperty.getText()));
				}
			}

		});
		EditingUtils.setID(targetProperty, EsbViewsRepository.DSSMediator.Properties.targetProperty);
		EditingUtils.setEEFtype(targetProperty, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.targetProperty, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetPropertyText

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
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getServiceName()
	 * 
	 */
	public String getServiceName() {
		return serviceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setServiceName(String newValue)
	 * 
	 */
	public void setServiceName(String newValue) {
		if (newValue != null) {
			serviceName.setText(newValue);
		} else {
			serviceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.serviceName);
		if (eefElementEditorReadOnlyState && serviceName.isEnabled()) {
			serviceName.setEnabled(false);
			serviceName.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !serviceName.isEnabled()) {
			serviceName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getSourceType()
	 * 
	 */
	public Enumerator getSourceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sourceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#initSourceType(Object input, Enumerator current)
	 */
	public void initSourceType(Object input, Enumerator current) {
		sourceType.setInput(input);
		sourceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.sourceType);
		if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
			sourceType.setEnabled(false);
			sourceType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
			sourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setSourceType(Enumerator newValue)
	 * 
	 */
	public void setSourceType(Enumerator newValue) {
		sourceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.sourceType);
		if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
			sourceType.setEnabled(false);
			sourceType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
			sourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getOperationType()
	 * 
	 */
	public Enumerator getOperationType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) operationType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#initOperationType(Object input, Enumerator current)
	 */
	public void initOperationType(Object input, Enumerator current) {
		operationType.setInput(input);
		operationType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.operationType);
		if (eefElementEditorReadOnlyState && operationType.isEnabled()) {
			operationType.setEnabled(false);
			operationType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operationType.isEnabled()) {
			operationType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setOperationType(Enumerator newValue)
	 * 
	 */
	public void setOperationType(Enumerator newValue) {
		operationType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.operationType);
		if (eefElementEditorReadOnlyState && operationType.isEnabled()) {
			operationType.setEnabled(false);
			operationType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operationType.isEnabled()) {
			operationType.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#initOperations(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOperations(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		operations.setContentProvider(contentProvider);
		operations.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.operations);
		if (eefElementEditorReadOnlyState && operations.isEnabled()) {
			operations.setEnabled(false);
			operations.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operations.isEnabled()) {
			operations.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#updateOperations()
	 * 
	 */
	public void updateOperations() {
	operations.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#addFilterOperations(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOperations(ViewerFilter filter) {
		operationsFilters.add(filter);
		if (this.operations != null) {
			this.operations.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#addBusinessFilterOperations(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOperations(ViewerFilter filter) {
		operationsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#isContainedInOperationsTable(EObject element)
	 * 
	 */
	public boolean isContainedInOperationsTable(EObject element) {
		return ((ReferencesTableSettings)operations.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getTargetType()
	 * 
	 */
	public Enumerator getTargetType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#initTargetType(Object input, Enumerator current)
	 */
	public void initTargetType(Object input, Enumerator current) {
		targetType.setInput(input);
		targetType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setTargetType(Enumerator newValue)
	 * 
	 */
	public void setTargetType(Enumerator newValue) {
		targetType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getTargetProperty()
	 * 
	 */
	public String getTargetProperty() {
		return targetProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setTargetProperty(String newValue)
	 * 
	 */
	public void setTargetProperty(String newValue) {
		if (newValue != null) {
			targetProperty.setText(newValue);
		} else {
			targetProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.targetProperty);
		if (eefElementEditorReadOnlyState && targetProperty.isEnabled()) {
			targetProperty.setEnabled(false);
			targetProperty.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetProperty.isEnabled()) {
			targetProperty.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.DSSMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
