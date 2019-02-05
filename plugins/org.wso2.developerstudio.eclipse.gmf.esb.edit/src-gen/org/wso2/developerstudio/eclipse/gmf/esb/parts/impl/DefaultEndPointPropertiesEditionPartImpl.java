/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class DefaultEndPointPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, DefaultEndPointPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Text endPointName;
	protected Button anonymous;
	protected Button inLine;
	protected Button duplicate;
	protected ReferencesTable properties;
	protected List<ViewerFilter> propertiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> propertiesFilters = new ArrayList<ViewerFilter>();
	protected Button reversed;
	protected Button reliableMessagingEnabled;
	protected Button securityEnabled;
	protected Button addressingEnabled;
	protected EMFComboViewer addressingVersion;
	protected Button addressingSeparateListener;
	protected Text timeOutDuration;
	protected EMFComboViewer timeOutAction;
	protected Text retryErrorCodes;
	protected Text retryCount;
	protected Text retryDelay;
	protected Text suspendErrorCodes;
	protected Text suspendInitialDuration;
	protected Text suspendMaximumDuration;
	protected Text suspendProgressionFactor;
	protected EMFComboViewer format;
	protected EMFComboViewer optimize;
	protected ReferencesTable templateParameters;
	protected List<ViewerFilter> templateParametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> templateParametersFilters = new ArrayList<ViewerFilter>();
	protected Button statisticsEnabled;
	protected Button traceEnabled;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DefaultEndPointPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence defaultEndPointStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = defaultEndPointStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.endPointName);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.anonymous);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.inLine);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.duplicate);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.properties_);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.reversed);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.reliableMessagingEnabled);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.securityEnabled);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.addressingEnabled);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.addressingVersion);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.addressingSeparateListener);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.timeOutDuration);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.timeOutAction);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.retryErrorCodes);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.retryCount);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.retryDelay);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.suspendErrorCodes);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.suspendInitialDuration);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.suspendMaximumDuration);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.suspendProgressionFactor);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.format);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.optimize);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.templateParameters);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.statisticsEnabled);
		propertiesStep.addStep(EsbViewsRepository.DefaultEndPoint.Properties.traceEnabled);
		
		
		composer = new PartComposer(defaultEndPointStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.endPointName) {
					return createEndPointNameText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.anonymous) {
					return createAnonymousCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.inLine) {
					return createInLineCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.duplicate) {
					return createDuplicateCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.properties_) {
					return createPropertiesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.reversed) {
					return createReversedCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.reliableMessagingEnabled) {
					return createReliableMessagingEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.securityEnabled) {
					return createSecurityEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.addressingEnabled) {
					return createAddressingEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.addressingVersion) {
					return createAddressingVersionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.addressingSeparateListener) {
					return createAddressingSeparateListenerCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.timeOutDuration) {
					return createTimeOutDurationText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.timeOutAction) {
					return createTimeOutActionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.retryErrorCodes) {
					return createRetryErrorCodesText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.retryCount) {
					return createRetryCountText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.retryDelay) {
					return createRetryDelayText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.suspendErrorCodes) {
					return createSuspendErrorCodesText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.suspendInitialDuration) {
					return createSuspendInitialDurationText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.suspendMaximumDuration) {
					return createSuspendMaximumDurationText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.suspendProgressionFactor) {
					return createSuspendProgressionFactorText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.format) {
					return createFormatEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.optimize) {
					return createOptimizeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.templateParameters) {
					return createTemplateParametersAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.statisticsEnabled) {
					return createStatisticsEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Properties.traceEnabled) {
					return createTraceEnabledCheckbox(parent);
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
		propertiesGroup.setText(EsbMessages.DefaultEndPointPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.description, EsbMessages.DefaultEndPointPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.DefaultEndPoint.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.DefaultEndPoint.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.commentsList, EsbMessages.DefaultEndPointPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "DefaultEndPoint", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.DefaultEndPoint.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createEndPointNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.endPointName, EsbMessages.DefaultEndPointPropertiesEditionPart_EndPointNameLabel);
		endPointName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData endPointNameData = new GridData(GridData.FILL_HORIZONTAL);
		endPointName.setLayoutData(endPointNameData);
		endPointName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.endPointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
			}

		});
		endPointName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.endPointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
				}
			}

		});
		EditingUtils.setID(endPointName, EsbViewsRepository.DefaultEndPoint.Properties.endPointName);
		EditingUtils.setEEFtype(endPointName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.endPointName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndPointNameText

		// End of user code
		return parent;
	}

	
	protected Composite createAnonymousCheckbox(Composite parent) {
		anonymous = new Button(parent, SWT.CHECK);
		anonymous.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.anonymous, EsbMessages.DefaultEndPointPropertiesEditionPart_AnonymousLabel));
		anonymous.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.anonymous, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(anonymous.getSelection())));
			}

		});
		GridData anonymousData = new GridData(GridData.FILL_HORIZONTAL);
		anonymousData.horizontalSpan = 2;
		anonymous.setLayoutData(anonymousData);
		EditingUtils.setID(anonymous, EsbViewsRepository.DefaultEndPoint.Properties.anonymous);
		EditingUtils.setEEFtype(anonymous, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.anonymous, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAnonymousCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createInLineCheckbox(Composite parent) {
		inLine = new Button(parent, SWT.CHECK);
		inLine.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.inLine, EsbMessages.DefaultEndPointPropertiesEditionPart_InLineLabel));
		inLine.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.inLine, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(inLine.getSelection())));
			}

		});
		GridData inLineData = new GridData(GridData.FILL_HORIZONTAL);
		inLineData.horizontalSpan = 2;
		inLine.setLayoutData(inLineData);
		EditingUtils.setID(inLine, EsbViewsRepository.DefaultEndPoint.Properties.inLine);
		EditingUtils.setEEFtype(inLine, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.inLine, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInLineCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createDuplicateCheckbox(Composite parent) {
		duplicate = new Button(parent, SWT.CHECK);
		duplicate.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.duplicate, EsbMessages.DefaultEndPointPropertiesEditionPart_DuplicateLabel));
		duplicate.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.duplicate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(duplicate.getSelection())));
			}

		});
		GridData duplicateData = new GridData(GridData.FILL_HORIZONTAL);
		duplicateData.horizontalSpan = 2;
		duplicate.setLayoutData(duplicateData);
		EditingUtils.setID(duplicate, EsbViewsRepository.DefaultEndPoint.Properties.duplicate);
		EditingUtils.setEEFtype(duplicate, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.duplicate, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDuplicateCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createPropertiesAdvancedTableComposition(Composite parent) {
		this.properties = new ReferencesTable(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.properties_, EsbMessages.DefaultEndPointPropertiesEditionPart_PropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				properties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				properties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				properties.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				properties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.propertiesFilters) {
			this.properties.addFilter(filter);
		}
		this.properties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.properties_, EsbViewsRepository.SWT_KIND));
		this.properties.createControls(parent);
		this.properties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.properties_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData propertiesData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesData.horizontalSpan = 3;
		this.properties.setLayoutData(propertiesData);
		this.properties.setLowerBound(0);
		this.properties.setUpperBound(-1);
		properties.setID(EsbViewsRepository.DefaultEndPoint.Properties.properties_);
		properties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPropertiesAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createReversedCheckbox(Composite parent) {
		reversed = new Button(parent, SWT.CHECK);
		reversed.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.reversed, EsbMessages.DefaultEndPointPropertiesEditionPart_ReversedLabel));
		reversed.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.reversed, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reversed.getSelection())));
			}

		});
		GridData reversedData = new GridData(GridData.FILL_HORIZONTAL);
		reversedData.horizontalSpan = 2;
		reversed.setLayoutData(reversedData);
		EditingUtils.setID(reversed, EsbViewsRepository.DefaultEndPoint.Properties.reversed);
		EditingUtils.setEEFtype(reversed, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.reversed, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReversedCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createReliableMessagingEnabledCheckbox(Composite parent) {
		reliableMessagingEnabled = new Button(parent, SWT.CHECK);
		reliableMessagingEnabled.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.reliableMessagingEnabled, EsbMessages.DefaultEndPointPropertiesEditionPart_ReliableMessagingEnabledLabel));
		reliableMessagingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.reliableMessagingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reliableMessagingEnabled.getSelection())));
			}

		});
		GridData reliableMessagingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		reliableMessagingEnabledData.horizontalSpan = 2;
		reliableMessagingEnabled.setLayoutData(reliableMessagingEnabledData);
		EditingUtils.setID(reliableMessagingEnabled, EsbViewsRepository.DefaultEndPoint.Properties.reliableMessagingEnabled);
		EditingUtils.setEEFtype(reliableMessagingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.reliableMessagingEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReliableMessagingEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createSecurityEnabledCheckbox(Composite parent) {
		securityEnabled = new Button(parent, SWT.CHECK);
		securityEnabled.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.securityEnabled, EsbMessages.DefaultEndPointPropertiesEditionPart_SecurityEnabledLabel));
		securityEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.securityEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(securityEnabled.getSelection())));
			}

		});
		GridData securityEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		securityEnabledData.horizontalSpan = 2;
		securityEnabled.setLayoutData(securityEnabledData);
		EditingUtils.setID(securityEnabled, EsbViewsRepository.DefaultEndPoint.Properties.securityEnabled);
		EditingUtils.setEEFtype(securityEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.securityEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSecurityEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAddressingEnabledCheckbox(Composite parent) {
		addressingEnabled = new Button(parent, SWT.CHECK);
		addressingEnabled.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.addressingEnabled, EsbMessages.DefaultEndPointPropertiesEditionPart_AddressingEnabledLabel));
		addressingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.addressingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(addressingEnabled.getSelection())));
			}

		});
		GridData addressingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		addressingEnabledData.horizontalSpan = 2;
		addressingEnabled.setLayoutData(addressingEnabledData);
		EditingUtils.setID(addressingEnabled, EsbViewsRepository.DefaultEndPoint.Properties.addressingEnabled);
		EditingUtils.setEEFtype(addressingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.addressingEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAddressingVersionEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.addressingVersion, EsbMessages.DefaultEndPointPropertiesEditionPart_AddressingVersionLabel);
		addressingVersion = new EMFComboViewer(parent);
		addressingVersion.setContentProvider(new ArrayContentProvider());
		addressingVersion.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData addressingVersionData = new GridData(GridData.FILL_HORIZONTAL);
		addressingVersion.getCombo().setLayoutData(addressingVersionData);
		addressingVersion.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.addressingVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAddressingVersion()));
			}

		});
		addressingVersion.setID(EsbViewsRepository.DefaultEndPoint.Properties.addressingVersion);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.addressingVersion, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingVersionEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createAddressingSeparateListenerCheckbox(Composite parent) {
		addressingSeparateListener = new Button(parent, SWT.CHECK);
		addressingSeparateListener.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.addressingSeparateListener, EsbMessages.DefaultEndPointPropertiesEditionPart_AddressingSeparateListenerLabel));
		addressingSeparateListener.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.addressingSeparateListener, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(addressingSeparateListener.getSelection())));
			}

		});
		GridData addressingSeparateListenerData = new GridData(GridData.FILL_HORIZONTAL);
		addressingSeparateListenerData.horizontalSpan = 2;
		addressingSeparateListener.setLayoutData(addressingSeparateListenerData);
		EditingUtils.setID(addressingSeparateListener, EsbViewsRepository.DefaultEndPoint.Properties.addressingSeparateListener);
		EditingUtils.setEEFtype(addressingSeparateListener, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.addressingSeparateListener, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingSeparateListenerCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createTimeOutDurationText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.timeOutDuration, EsbMessages.DefaultEndPointPropertiesEditionPart_TimeOutDurationLabel);
		timeOutDuration = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData timeOutDurationData = new GridData(GridData.FILL_HORIZONTAL);
		timeOutDuration.setLayoutData(timeOutDurationData);
		timeOutDuration.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.timeOutDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, timeOutDuration.getText()));
			}

		});
		timeOutDuration.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.timeOutDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, timeOutDuration.getText()));
				}
			}

		});
		EditingUtils.setID(timeOutDuration, EsbViewsRepository.DefaultEndPoint.Properties.timeOutDuration);
		EditingUtils.setEEFtype(timeOutDuration, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.timeOutDuration, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTimeOutDurationText

		// End of user code
		return parent;
	}

	
	protected Composite createTimeOutActionEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.timeOutAction, EsbMessages.DefaultEndPointPropertiesEditionPart_TimeOutActionLabel);
		timeOutAction = new EMFComboViewer(parent);
		timeOutAction.setContentProvider(new ArrayContentProvider());
		timeOutAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData timeOutActionData = new GridData(GridData.FILL_HORIZONTAL);
		timeOutAction.getCombo().setLayoutData(timeOutActionData);
		timeOutAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.timeOutAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTimeOutAction()));
			}

		});
		timeOutAction.setID(EsbViewsRepository.DefaultEndPoint.Properties.timeOutAction);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.timeOutAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTimeOutActionEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createRetryErrorCodesText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.retryErrorCodes, EsbMessages.DefaultEndPointPropertiesEditionPart_RetryErrorCodesLabel);
		retryErrorCodes = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData retryErrorCodesData = new GridData(GridData.FILL_HORIZONTAL);
		retryErrorCodes.setLayoutData(retryErrorCodesData);
		retryErrorCodes.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.retryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryErrorCodes.getText()));
			}

		});
		retryErrorCodes.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.retryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryErrorCodes.getText()));
				}
			}

		});
		EditingUtils.setID(retryErrorCodes, EsbViewsRepository.DefaultEndPoint.Properties.retryErrorCodes);
		EditingUtils.setEEFtype(retryErrorCodes, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.retryErrorCodes, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryErrorCodesText

		// End of user code
		return parent;
	}

	
	protected Composite createRetryCountText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.retryCount, EsbMessages.DefaultEndPointPropertiesEditionPart_RetryCountLabel);
		retryCount = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData retryCountData = new GridData(GridData.FILL_HORIZONTAL);
		retryCount.setLayoutData(retryCountData);
		retryCount.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.retryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryCount.getText()));
			}

		});
		retryCount.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.retryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryCount.getText()));
				}
			}

		});
		EditingUtils.setID(retryCount, EsbViewsRepository.DefaultEndPoint.Properties.retryCount);
		EditingUtils.setEEFtype(retryCount, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.retryCount, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryCountText

		// End of user code
		return parent;
	}

	
	protected Composite createRetryDelayText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.retryDelay, EsbMessages.DefaultEndPointPropertiesEditionPart_RetryDelayLabel);
		retryDelay = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData retryDelayData = new GridData(GridData.FILL_HORIZONTAL);
		retryDelay.setLayoutData(retryDelayData);
		retryDelay.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.retryDelay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryDelay.getText()));
			}

		});
		retryDelay.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.retryDelay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryDelay.getText()));
				}
			}

		});
		EditingUtils.setID(retryDelay, EsbViewsRepository.DefaultEndPoint.Properties.retryDelay);
		EditingUtils.setEEFtype(retryDelay, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.retryDelay, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryDelayText

		// End of user code
		return parent;
	}

	
	protected Composite createSuspendErrorCodesText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.suspendErrorCodes, EsbMessages.DefaultEndPointPropertiesEditionPart_SuspendErrorCodesLabel);
		suspendErrorCodes = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData suspendErrorCodesData = new GridData(GridData.FILL_HORIZONTAL);
		suspendErrorCodes.setLayoutData(suspendErrorCodesData);
		suspendErrorCodes.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.suspendErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendErrorCodes.getText()));
			}

		});
		suspendErrorCodes.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.suspendErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendErrorCodes.getText()));
				}
			}

		});
		EditingUtils.setID(suspendErrorCodes, EsbViewsRepository.DefaultEndPoint.Properties.suspendErrorCodes);
		EditingUtils.setEEFtype(suspendErrorCodes, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.suspendErrorCodes, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendErrorCodesText

		// End of user code
		return parent;
	}

	
	protected Composite createSuspendInitialDurationText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.suspendInitialDuration, EsbMessages.DefaultEndPointPropertiesEditionPart_SuspendInitialDurationLabel);
		suspendInitialDuration = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData suspendInitialDurationData = new GridData(GridData.FILL_HORIZONTAL);
		suspendInitialDuration.setLayoutData(suspendInitialDurationData);
		suspendInitialDuration.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.suspendInitialDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendInitialDuration.getText()));
			}

		});
		suspendInitialDuration.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.suspendInitialDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendInitialDuration.getText()));
				}
			}

		});
		EditingUtils.setID(suspendInitialDuration, EsbViewsRepository.DefaultEndPoint.Properties.suspendInitialDuration);
		EditingUtils.setEEFtype(suspendInitialDuration, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.suspendInitialDuration, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendInitialDurationText

		// End of user code
		return parent;
	}

	
	protected Composite createSuspendMaximumDurationText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.suspendMaximumDuration, EsbMessages.DefaultEndPointPropertiesEditionPart_SuspendMaximumDurationLabel);
		suspendMaximumDuration = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData suspendMaximumDurationData = new GridData(GridData.FILL_HORIZONTAL);
		suspendMaximumDuration.setLayoutData(suspendMaximumDurationData);
		suspendMaximumDuration.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.suspendMaximumDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendMaximumDuration.getText()));
			}

		});
		suspendMaximumDuration.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.suspendMaximumDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendMaximumDuration.getText()));
				}
			}

		});
		EditingUtils.setID(suspendMaximumDuration, EsbViewsRepository.DefaultEndPoint.Properties.suspendMaximumDuration);
		EditingUtils.setEEFtype(suspendMaximumDuration, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.suspendMaximumDuration, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendMaximumDurationText

		// End of user code
		return parent;
	}

	
	protected Composite createSuspendProgressionFactorText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.suspendProgressionFactor, EsbMessages.DefaultEndPointPropertiesEditionPart_SuspendProgressionFactorLabel);
		suspendProgressionFactor = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData suspendProgressionFactorData = new GridData(GridData.FILL_HORIZONTAL);
		suspendProgressionFactor.setLayoutData(suspendProgressionFactorData);
		suspendProgressionFactor.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.suspendProgressionFactor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendProgressionFactor.getText()));
			}

		});
		suspendProgressionFactor.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.suspendProgressionFactor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendProgressionFactor.getText()));
				}
			}

		});
		EditingUtils.setID(suspendProgressionFactor, EsbViewsRepository.DefaultEndPoint.Properties.suspendProgressionFactor);
		EditingUtils.setEEFtype(suspendProgressionFactor, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.suspendProgressionFactor, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendProgressionFactorText

		// End of user code
		return parent;
	}

	
	protected Composite createFormatEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.format, EsbMessages.DefaultEndPointPropertiesEditionPart_FormatLabel);
		format = new EMFComboViewer(parent);
		format.setContentProvider(new ArrayContentProvider());
		format.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData formatData = new GridData(GridData.FILL_HORIZONTAL);
		format.getCombo().setLayoutData(formatData);
		format.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.format, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFormat()));
			}

		});
		format.setID(EsbViewsRepository.DefaultEndPoint.Properties.format);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.format, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFormatEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOptimizeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Properties.optimize, EsbMessages.DefaultEndPointPropertiesEditionPart_OptimizeLabel);
		optimize = new EMFComboViewer(parent);
		optimize.setContentProvider(new ArrayContentProvider());
		optimize.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData optimizeData = new GridData(GridData.FILL_HORIZONTAL);
		optimize.getCombo().setLayoutData(optimizeData);
		optimize.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.optimize, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOptimize()));
			}

		});
		optimize.setID(EsbViewsRepository.DefaultEndPoint.Properties.optimize);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.optimize, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOptimizeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTemplateParametersAdvancedTableComposition(Composite parent) {
		this.templateParameters = new ReferencesTable(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.templateParameters, EsbMessages.DefaultEndPointPropertiesEditionPart_TemplateParametersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				templateParameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				templateParameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				templateParameters.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				templateParameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.templateParametersFilters) {
			this.templateParameters.addFilter(filter);
		}
		this.templateParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.templateParameters, EsbViewsRepository.SWT_KIND));
		this.templateParameters.createControls(parent);
		this.templateParameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.templateParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData templateParametersData = new GridData(GridData.FILL_HORIZONTAL);
		templateParametersData.horizontalSpan = 3;
		this.templateParameters.setLayoutData(templateParametersData);
		this.templateParameters.setLowerBound(0);
		this.templateParameters.setUpperBound(-1);
		templateParameters.setID(EsbViewsRepository.DefaultEndPoint.Properties.templateParameters);
		templateParameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTemplateParametersAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createStatisticsEnabledCheckbox(Composite parent) {
		statisticsEnabled = new Button(parent, SWT.CHECK);
		statisticsEnabled.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.statisticsEnabled, EsbMessages.DefaultEndPointPropertiesEditionPart_StatisticsEnabledLabel));
		statisticsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.statisticsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statisticsEnabled.getSelection())));
			}

		});
		GridData statisticsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		statisticsEnabledData.horizontalSpan = 2;
		statisticsEnabled.setLayoutData(statisticsEnabledData);
		EditingUtils.setID(statisticsEnabled, EsbViewsRepository.DefaultEndPoint.Properties.statisticsEnabled);
		EditingUtils.setEEFtype(statisticsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.statisticsEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatisticsEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createTraceEnabledCheckbox(Composite parent) {
		traceEnabled = new Button(parent, SWT.CHECK);
		traceEnabled.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Properties.traceEnabled, EsbMessages.DefaultEndPointPropertiesEditionPart_TraceEnabledLabel));
		traceEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Properties.traceEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(traceEnabled.getSelection())));
			}

		});
		GridData traceEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		traceEnabledData.horizontalSpan = 2;
		traceEnabled.setLayoutData(traceEnabledData);
		EditingUtils.setID(traceEnabled, EsbViewsRepository.DefaultEndPoint.Properties.traceEnabled);
		EditingUtils.setEEFtype(traceEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Properties.traceEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTraceEnabledCheckbox

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getEndPointName()
	 * 
	 */
	public String getEndPointName() {
		return endPointName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setEndPointName(String newValue)
	 * 
	 */
	public void setEndPointName(String newValue) {
		if (newValue != null) {
			endPointName.setText(newValue);
		} else {
			endPointName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.endPointName);
		if (eefElementEditorReadOnlyState && endPointName.isEnabled()) {
			endPointName.setEnabled(false);
			endPointName.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endPointName.isEnabled()) {
			endPointName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getAnonymous()
	 * 
	 */
	public Boolean getAnonymous() {
		return Boolean.valueOf(anonymous.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setAnonymous(Boolean newValue)
	 * 
	 */
	public void setAnonymous(Boolean newValue) {
		if (newValue != null) {
			anonymous.setSelection(newValue.booleanValue());
		} else {
			anonymous.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.anonymous);
		if (eefElementEditorReadOnlyState && anonymous.isEnabled()) {
			anonymous.setEnabled(false);
			anonymous.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !anonymous.isEnabled()) {
			anonymous.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getInLine()
	 * 
	 */
	public Boolean getInLine() {
		return Boolean.valueOf(inLine.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setInLine(Boolean newValue)
	 * 
	 */
	public void setInLine(Boolean newValue) {
		if (newValue != null) {
			inLine.setSelection(newValue.booleanValue());
		} else {
			inLine.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.inLine);
		if (eefElementEditorReadOnlyState && inLine.isEnabled()) {
			inLine.setEnabled(false);
			inLine.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inLine.isEnabled()) {
			inLine.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getDuplicate()
	 * 
	 */
	public Boolean getDuplicate() {
		return Boolean.valueOf(duplicate.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setDuplicate(Boolean newValue)
	 * 
	 */
	public void setDuplicate(Boolean newValue) {
		if (newValue != null) {
			duplicate.setSelection(newValue.booleanValue());
		} else {
			duplicate.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.duplicate);
		if (eefElementEditorReadOnlyState && duplicate.isEnabled()) {
			duplicate.setEnabled(false);
			duplicate.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !duplicate.isEnabled()) {
			duplicate.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#initProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		properties.setContentProvider(contentProvider);
		properties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.properties_);
		if (eefElementEditorReadOnlyState && properties.isEnabled()) {
			properties.setEnabled(false);
			properties.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !properties.isEnabled()) {
			properties.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#updateProperties()
	 * 
	 */
	public void updateProperties() {
	properties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#addFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addFilterToProperties(ViewerFilter filter) {
		propertiesFilters.add(filter);
		if (this.properties != null) {
			this.properties.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#addBusinessFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToProperties(ViewerFilter filter) {
		propertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#isContainedInPropertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPropertiesTable(EObject element) {
		return ((ReferencesTableSettings)properties.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getReversed()
	 * 
	 */
	public Boolean getReversed() {
		return Boolean.valueOf(reversed.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setReversed(Boolean newValue)
	 * 
	 */
	public void setReversed(Boolean newValue) {
		if (newValue != null) {
			reversed.setSelection(newValue.booleanValue());
		} else {
			reversed.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.reversed);
		if (eefElementEditorReadOnlyState && reversed.isEnabled()) {
			reversed.setEnabled(false);
			reversed.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reversed.isEnabled()) {
			reversed.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getReliableMessagingEnabled()
	 * 
	 */
	public Boolean getReliableMessagingEnabled() {
		return Boolean.valueOf(reliableMessagingEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setReliableMessagingEnabled(Boolean newValue)
	 * 
	 */
	public void setReliableMessagingEnabled(Boolean newValue) {
		if (newValue != null) {
			reliableMessagingEnabled.setSelection(newValue.booleanValue());
		} else {
			reliableMessagingEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.reliableMessagingEnabled);
		if (eefElementEditorReadOnlyState && reliableMessagingEnabled.isEnabled()) {
			reliableMessagingEnabled.setEnabled(false);
			reliableMessagingEnabled.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reliableMessagingEnabled.isEnabled()) {
			reliableMessagingEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getSecurityEnabled()
	 * 
	 */
	public Boolean getSecurityEnabled() {
		return Boolean.valueOf(securityEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setSecurityEnabled(Boolean newValue)
	 * 
	 */
	public void setSecurityEnabled(Boolean newValue) {
		if (newValue != null) {
			securityEnabled.setSelection(newValue.booleanValue());
		} else {
			securityEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.securityEnabled);
		if (eefElementEditorReadOnlyState && securityEnabled.isEnabled()) {
			securityEnabled.setEnabled(false);
			securityEnabled.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !securityEnabled.isEnabled()) {
			securityEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getAddressingEnabled()
	 * 
	 */
	public Boolean getAddressingEnabled() {
		return Boolean.valueOf(addressingEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setAddressingEnabled(Boolean newValue)
	 * 
	 */
	public void setAddressingEnabled(Boolean newValue) {
		if (newValue != null) {
			addressingEnabled.setSelection(newValue.booleanValue());
		} else {
			addressingEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.addressingEnabled);
		if (eefElementEditorReadOnlyState && addressingEnabled.isEnabled()) {
			addressingEnabled.setEnabled(false);
			addressingEnabled.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingEnabled.isEnabled()) {
			addressingEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getAddressingVersion()
	 * 
	 */
	public Enumerator getAddressingVersion() {
		Enumerator selection = (Enumerator) ((StructuredSelection) addressingVersion.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#initAddressingVersion(Object input, Enumerator current)
	 */
	public void initAddressingVersion(Object input, Enumerator current) {
		addressingVersion.setInput(input);
		addressingVersion.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.addressingVersion);
		if (eefElementEditorReadOnlyState && addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(false);
			addressingVersion.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setAddressingVersion(Enumerator newValue)
	 * 
	 */
	public void setAddressingVersion(Enumerator newValue) {
		addressingVersion.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.addressingVersion);
		if (eefElementEditorReadOnlyState && addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(false);
			addressingVersion.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getAddressingSeparateListener()
	 * 
	 */
	public Boolean getAddressingSeparateListener() {
		return Boolean.valueOf(addressingSeparateListener.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setAddressingSeparateListener(Boolean newValue)
	 * 
	 */
	public void setAddressingSeparateListener(Boolean newValue) {
		if (newValue != null) {
			addressingSeparateListener.setSelection(newValue.booleanValue());
		} else {
			addressingSeparateListener.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.addressingSeparateListener);
		if (eefElementEditorReadOnlyState && addressingSeparateListener.isEnabled()) {
			addressingSeparateListener.setEnabled(false);
			addressingSeparateListener.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingSeparateListener.isEnabled()) {
			addressingSeparateListener.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getTimeOutDuration()
	 * 
	 */
	public String getTimeOutDuration() {
		return timeOutDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setTimeOutDuration(String newValue)
	 * 
	 */
	public void setTimeOutDuration(String newValue) {
		if (newValue != null) {
			timeOutDuration.setText(newValue);
		} else {
			timeOutDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.timeOutDuration);
		if (eefElementEditorReadOnlyState && timeOutDuration.isEnabled()) {
			timeOutDuration.setEnabled(false);
			timeOutDuration.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutDuration.isEnabled()) {
			timeOutDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getTimeOutAction()
	 * 
	 */
	public Enumerator getTimeOutAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) timeOutAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#initTimeOutAction(Object input, Enumerator current)
	 */
	public void initTimeOutAction(Object input, Enumerator current) {
		timeOutAction.setInput(input);
		timeOutAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.timeOutAction);
		if (eefElementEditorReadOnlyState && timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(false);
			timeOutAction.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setTimeOutAction(Enumerator newValue)
	 * 
	 */
	public void setTimeOutAction(Enumerator newValue) {
		timeOutAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.timeOutAction);
		if (eefElementEditorReadOnlyState && timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(false);
			timeOutAction.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getRetryErrorCodes()
	 * 
	 */
	public String getRetryErrorCodes() {
		return retryErrorCodes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setRetryErrorCodes(String newValue)
	 * 
	 */
	public void setRetryErrorCodes(String newValue) {
		if (newValue != null) {
			retryErrorCodes.setText(newValue);
		} else {
			retryErrorCodes.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.retryErrorCodes);
		if (eefElementEditorReadOnlyState && retryErrorCodes.isEnabled()) {
			retryErrorCodes.setEnabled(false);
			retryErrorCodes.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryErrorCodes.isEnabled()) {
			retryErrorCodes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getRetryCount()
	 * 
	 */
	public String getRetryCount() {
		return retryCount.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setRetryCount(String newValue)
	 * 
	 */
	public void setRetryCount(String newValue) {
		if (newValue != null) {
			retryCount.setText(newValue);
		} else {
			retryCount.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.retryCount);
		if (eefElementEditorReadOnlyState && retryCount.isEnabled()) {
			retryCount.setEnabled(false);
			retryCount.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryCount.isEnabled()) {
			retryCount.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getRetryDelay()
	 * 
	 */
	public String getRetryDelay() {
		return retryDelay.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setRetryDelay(String newValue)
	 * 
	 */
	public void setRetryDelay(String newValue) {
		if (newValue != null) {
			retryDelay.setText(newValue);
		} else {
			retryDelay.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.retryDelay);
		if (eefElementEditorReadOnlyState && retryDelay.isEnabled()) {
			retryDelay.setEnabled(false);
			retryDelay.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryDelay.isEnabled()) {
			retryDelay.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getSuspendErrorCodes()
	 * 
	 */
	public String getSuspendErrorCodes() {
		return suspendErrorCodes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setSuspendErrorCodes(String newValue)
	 * 
	 */
	public void setSuspendErrorCodes(String newValue) {
		if (newValue != null) {
			suspendErrorCodes.setText(newValue);
		} else {
			suspendErrorCodes.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.suspendErrorCodes);
		if (eefElementEditorReadOnlyState && suspendErrorCodes.isEnabled()) {
			suspendErrorCodes.setEnabled(false);
			suspendErrorCodes.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendErrorCodes.isEnabled()) {
			suspendErrorCodes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getSuspendInitialDuration()
	 * 
	 */
	public String getSuspendInitialDuration() {
		return suspendInitialDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setSuspendInitialDuration(String newValue)
	 * 
	 */
	public void setSuspendInitialDuration(String newValue) {
		if (newValue != null) {
			suspendInitialDuration.setText(newValue);
		} else {
			suspendInitialDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.suspendInitialDuration);
		if (eefElementEditorReadOnlyState && suspendInitialDuration.isEnabled()) {
			suspendInitialDuration.setEnabled(false);
			suspendInitialDuration.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendInitialDuration.isEnabled()) {
			suspendInitialDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getSuspendMaximumDuration()
	 * 
	 */
	public String getSuspendMaximumDuration() {
		return suspendMaximumDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setSuspendMaximumDuration(String newValue)
	 * 
	 */
	public void setSuspendMaximumDuration(String newValue) {
		if (newValue != null) {
			suspendMaximumDuration.setText(newValue);
		} else {
			suspendMaximumDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.suspendMaximumDuration);
		if (eefElementEditorReadOnlyState && suspendMaximumDuration.isEnabled()) {
			suspendMaximumDuration.setEnabled(false);
			suspendMaximumDuration.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendMaximumDuration.isEnabled()) {
			suspendMaximumDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getSuspendProgressionFactor()
	 * 
	 */
	public String getSuspendProgressionFactor() {
		return suspendProgressionFactor.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setSuspendProgressionFactor(String newValue)
	 * 
	 */
	public void setSuspendProgressionFactor(String newValue) {
		if (newValue != null) {
			suspendProgressionFactor.setText(newValue);
		} else {
			suspendProgressionFactor.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.suspendProgressionFactor);
		if (eefElementEditorReadOnlyState && suspendProgressionFactor.isEnabled()) {
			suspendProgressionFactor.setEnabled(false);
			suspendProgressionFactor.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendProgressionFactor.isEnabled()) {
			suspendProgressionFactor.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getFormat()
	 * 
	 */
	public Enumerator getFormat() {
		Enumerator selection = (Enumerator) ((StructuredSelection) format.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#initFormat(Object input, Enumerator current)
	 */
	public void initFormat(Object input, Enumerator current) {
		format.setInput(input);
		format.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.format);
		if (eefElementEditorReadOnlyState && format.isEnabled()) {
			format.setEnabled(false);
			format.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !format.isEnabled()) {
			format.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setFormat(Enumerator newValue)
	 * 
	 */
	public void setFormat(Enumerator newValue) {
		format.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.format);
		if (eefElementEditorReadOnlyState && format.isEnabled()) {
			format.setEnabled(false);
			format.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !format.isEnabled()) {
			format.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getOptimize()
	 * 
	 */
	public Enumerator getOptimize() {
		Enumerator selection = (Enumerator) ((StructuredSelection) optimize.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#initOptimize(Object input, Enumerator current)
	 */
	public void initOptimize(Object input, Enumerator current) {
		optimize.setInput(input);
		optimize.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.optimize);
		if (eefElementEditorReadOnlyState && optimize.isEnabled()) {
			optimize.setEnabled(false);
			optimize.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !optimize.isEnabled()) {
			optimize.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setOptimize(Enumerator newValue)
	 * 
	 */
	public void setOptimize(Enumerator newValue) {
		optimize.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.optimize);
		if (eefElementEditorReadOnlyState && optimize.isEnabled()) {
			optimize.setEnabled(false);
			optimize.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !optimize.isEnabled()) {
			optimize.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#initTemplateParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTemplateParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		templateParameters.setContentProvider(contentProvider);
		templateParameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.templateParameters);
		if (eefElementEditorReadOnlyState && templateParameters.isEnabled()) {
			templateParameters.setEnabled(false);
			templateParameters.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !templateParameters.isEnabled()) {
			templateParameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#updateTemplateParameters()
	 * 
	 */
	public void updateTemplateParameters() {
	templateParameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#addFilterTemplateParameters(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTemplateParameters(ViewerFilter filter) {
		templateParametersFilters.add(filter);
		if (this.templateParameters != null) {
			this.templateParameters.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#addBusinessFilterTemplateParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTemplateParameters(ViewerFilter filter) {
		templateParametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#isContainedInTemplateParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInTemplateParametersTable(EObject element) {
		return ((ReferencesTableSettings)templateParameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getStatisticsEnabled()
	 * 
	 */
	public Boolean getStatisticsEnabled() {
		return Boolean.valueOf(statisticsEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setStatisticsEnabled(Boolean newValue)
	 * 
	 */
	public void setStatisticsEnabled(Boolean newValue) {
		if (newValue != null) {
			statisticsEnabled.setSelection(newValue.booleanValue());
		} else {
			statisticsEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.statisticsEnabled);
		if (eefElementEditorReadOnlyState && statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(false);
			statisticsEnabled.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getTraceEnabled()
	 * 
	 */
	public Boolean getTraceEnabled() {
		return Boolean.valueOf(traceEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setTraceEnabled(Boolean newValue)
	 * 
	 */
	public void setTraceEnabled(Boolean newValue) {
		if (newValue != null) {
			traceEnabled.setSelection(newValue.booleanValue());
		} else {
			traceEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Properties.traceEnabled);
		if (eefElementEditorReadOnlyState && traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(false);
			traceEnabled.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.DefaultEndPoint_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
