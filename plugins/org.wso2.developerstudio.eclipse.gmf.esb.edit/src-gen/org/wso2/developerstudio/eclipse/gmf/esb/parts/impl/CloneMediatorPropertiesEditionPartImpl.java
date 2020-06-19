/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CloneMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CloneMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text cloneID;
	protected Button sequentialMediation;
	protected Button continueParent;
	protected ReferencesTable targets;
	protected List<ViewerFilter> targetsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> targetsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable targetsOutputConnector;
	protected List<ViewerFilter> targetsOutputConnectorBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> targetsOutputConnectorFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CloneMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence cloneMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = cloneMediatorStep.addStep(EsbViewsRepository.CloneMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.cloneID);
		propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.sequentialMediation);
		propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.continueParent);
		propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.targets);
		propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector);
		
		
		composer = new PartComposer(cloneMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CloneMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.CloneMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.CloneMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.CloneMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.CloneMediator.Properties.cloneID) {
					return createCloneIDText(parent);
				}
				if (key == EsbViewsRepository.CloneMediator.Properties.sequentialMediation) {
					return createSequentialMediationCheckbox(parent);
				}
				if (key == EsbViewsRepository.CloneMediator.Properties.continueParent) {
					return createContinueParentCheckbox(parent);
				}
				if (key == EsbViewsRepository.CloneMediator.Properties.targets) {
					return createTargetsAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector) {
					return createTargetsOutputConnectorAdvancedTableComposition(parent);
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
		propertiesGroup.setText(EsbMessages.CloneMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CloneMediator.Properties.description, EsbMessages.CloneMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.CloneMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.CloneMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.CloneMediator.Properties.commentsList, EsbMessages.CloneMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "CloneMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.CloneMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.CloneMediator.Properties.reverse, EsbMessages.CloneMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.CloneMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createCloneIDText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CloneMediator.Properties.cloneID, EsbMessages.CloneMediatorPropertiesEditionPart_CloneIDLabel);
		cloneID = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData cloneIDData = new GridData(GridData.FILL_HORIZONTAL);
		cloneID.setLayoutData(cloneIDData);
		cloneID.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.cloneID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cloneID.getText()));
			}

		});
		cloneID.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.cloneID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cloneID.getText()));
				}
			}

		});
		EditingUtils.setID(cloneID, EsbViewsRepository.CloneMediator.Properties.cloneID);
		EditingUtils.setEEFtype(cloneID, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneMediator.Properties.cloneID, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCloneIDText

		// End of user code
		return parent;
	}

	
	protected Composite createSequentialMediationCheckbox(Composite parent) {
		sequentialMediation = new Button(parent, SWT.CHECK);
		sequentialMediation.setText(getDescription(EsbViewsRepository.CloneMediator.Properties.sequentialMediation, EsbMessages.CloneMediatorPropertiesEditionPart_SequentialMediationLabel));
		sequentialMediation.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.sequentialMediation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(sequentialMediation.getSelection())));
			}

		});
		GridData sequentialMediationData = new GridData(GridData.FILL_HORIZONTAL);
		sequentialMediationData.horizontalSpan = 2;
		sequentialMediation.setLayoutData(sequentialMediationData);
		EditingUtils.setID(sequentialMediation, EsbViewsRepository.CloneMediator.Properties.sequentialMediation);
		EditingUtils.setEEFtype(sequentialMediation, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneMediator.Properties.sequentialMediation, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequentialMediationCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createContinueParentCheckbox(Composite parent) {
		continueParent = new Button(parent, SWT.CHECK);
		continueParent.setText(getDescription(EsbViewsRepository.CloneMediator.Properties.continueParent, EsbMessages.CloneMediatorPropertiesEditionPart_ContinueParentLabel));
		continueParent.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.continueParent, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(continueParent.getSelection())));
			}

		});
		GridData continueParentData = new GridData(GridData.FILL_HORIZONTAL);
		continueParentData.horizontalSpan = 2;
		continueParent.setLayoutData(continueParentData);
		EditingUtils.setID(continueParent, EsbViewsRepository.CloneMediator.Properties.continueParent);
		EditingUtils.setEEFtype(continueParent, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneMediator.Properties.continueParent, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createContinueParentCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTargetsAdvancedTableComposition(Composite parent) {
		this.targets = new ReferencesTable(getDescription(EsbViewsRepository.CloneMediator.Properties.targets, EsbMessages.CloneMediatorPropertiesEditionPart_TargetsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.targets, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				targets.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.targets, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				targets.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.targets, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				targets.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.targets, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				targets.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.targetsFilters) {
			this.targets.addFilter(filter);
		}
		this.targets.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneMediator.Properties.targets, EsbViewsRepository.SWT_KIND));
		this.targets.createControls(parent);
		this.targets.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.targets, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData targetsData = new GridData(GridData.FILL_HORIZONTAL);
		targetsData.horizontalSpan = 3;
		this.targets.setLayoutData(targetsData);
		this.targets.setLowerBound(0);
		this.targets.setUpperBound(-1);
		targets.setID(EsbViewsRepository.CloneMediator.Properties.targets);
		targets.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTargetsAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTargetsOutputConnectorAdvancedTableComposition(Composite parent) {
		this.targetsOutputConnector = new ReferencesTable(getDescription(EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector, EsbMessages.CloneMediatorPropertiesEditionPart_TargetsOutputConnectorLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				targetsOutputConnector.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				targetsOutputConnector.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				targetsOutputConnector.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				targetsOutputConnector.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.targetsOutputConnectorFilters) {
			this.targetsOutputConnector.addFilter(filter);
		}
		this.targetsOutputConnector.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector, EsbViewsRepository.SWT_KIND));
		this.targetsOutputConnector.createControls(parent);
		this.targetsOutputConnector.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData targetsOutputConnectorData = new GridData(GridData.FILL_HORIZONTAL);
		targetsOutputConnectorData.horizontalSpan = 3;
		this.targetsOutputConnector.setLayoutData(targetsOutputConnectorData);
		this.targetsOutputConnector.setLowerBound(0);
		this.targetsOutputConnector.setUpperBound(-1);
		targetsOutputConnector.setID(EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector);
		targetsOutputConnector.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTargetsOutputConnectorAdvancedTableComposition

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getCloneID()
	 * 
	 */
	public String getCloneID() {
		return cloneID.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setCloneID(String newValue)
	 * 
	 */
	public void setCloneID(String newValue) {
		if (newValue != null) {
			cloneID.setText(newValue);
		} else {
			cloneID.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.cloneID);
		if (eefElementEditorReadOnlyState && cloneID.isEnabled()) {
			cloneID.setEnabled(false);
			cloneID.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cloneID.isEnabled()) {
			cloneID.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getSequentialMediation()
	 * 
	 */
	public Boolean getSequentialMediation() {
		return Boolean.valueOf(sequentialMediation.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setSequentialMediation(Boolean newValue)
	 * 
	 */
	public void setSequentialMediation(Boolean newValue) {
		if (newValue != null) {
			sequentialMediation.setSelection(newValue.booleanValue());
		} else {
			sequentialMediation.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.sequentialMediation);
		if (eefElementEditorReadOnlyState && sequentialMediation.isEnabled()) {
			sequentialMediation.setEnabled(false);
			sequentialMediation.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequentialMediation.isEnabled()) {
			sequentialMediation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getContinueParent()
	 * 
	 */
	public Boolean getContinueParent() {
		return Boolean.valueOf(continueParent.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setContinueParent(Boolean newValue)
	 * 
	 */
	public void setContinueParent(Boolean newValue) {
		if (newValue != null) {
			continueParent.setSelection(newValue.booleanValue());
		} else {
			continueParent.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.continueParent);
		if (eefElementEditorReadOnlyState && continueParent.isEnabled()) {
			continueParent.setEnabled(false);
			continueParent.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !continueParent.isEnabled()) {
			continueParent.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#initTargets(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTargets(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		targets.setContentProvider(contentProvider);
		targets.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.targets);
		if (eefElementEditorReadOnlyState && targets.isEnabled()) {
			targets.setEnabled(false);
			targets.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targets.isEnabled()) {
			targets.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#updateTargets()
	 * 
	 */
	public void updateTargets() {
	targets.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#addFilterTargets(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTargets(ViewerFilter filter) {
		targetsFilters.add(filter);
		if (this.targets != null) {
			this.targets.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#addBusinessFilterTargets(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTargets(ViewerFilter filter) {
		targetsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#isContainedInTargetsTable(EObject element)
	 * 
	 */
	public boolean isContainedInTargetsTable(EObject element) {
		return ((ReferencesTableSettings)targets.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#initTargetsOutputConnector(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTargetsOutputConnector(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		targetsOutputConnector.setContentProvider(contentProvider);
		targetsOutputConnector.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector);
		if (eefElementEditorReadOnlyState && targetsOutputConnector.isEnabled()) {
			targetsOutputConnector.setEnabled(false);
			targetsOutputConnector.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetsOutputConnector.isEnabled()) {
			targetsOutputConnector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#updateTargetsOutputConnector()
	 * 
	 */
	public void updateTargetsOutputConnector() {
	targetsOutputConnector.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#addFilterTargetsOutputConnector(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTargetsOutputConnector(ViewerFilter filter) {
		targetsOutputConnectorFilters.add(filter);
		if (this.targetsOutputConnector != null) {
			this.targetsOutputConnector.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#addBusinessFilterTargetsOutputConnector(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTargetsOutputConnector(ViewerFilter filter) {
		targetsOutputConnectorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#isContainedInTargetsOutputConnectorTable(EObject element)
	 * 
	 */
	public boolean isContainedInTargetsOutputConnectorTable(EObject element) {
		return ((ReferencesTableSettings)targetsOutputConnector.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CloneMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
