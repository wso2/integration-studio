/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class TemplateEndpointPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TemplateEndpointPropertiesEditionPart {

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
	protected Text address;
	protected Text targetTemplate;
	protected ReferencesTable parameters;
	protected List<ViewerFilter> parametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> parametersFilters = new ArrayList<ViewerFilter>();
	protected Text availableTemplates;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TemplateEndpointPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence templateEndpointStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = templateEndpointStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.endPointName);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.anonymous);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.inLine);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.duplicate);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.properties_);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.reversed);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.retryCount);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.retryDelay);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.format);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.optimize);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.templateParameters);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.address);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.parameters);
		propertiesStep.addStep(EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates);
		
		
		composer = new PartComposer(templateEndpointStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.endPointName) {
					return createEndPointNameText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.anonymous) {
					return createAnonymousCheckbox(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.inLine) {
					return createInLineCheckbox(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.duplicate) {
					return createDuplicateCheckbox(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.properties_) {
					return createPropertiesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.reversed) {
					return createReversedCheckbox(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled) {
					return createReliableMessagingEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled) {
					return createSecurityEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled) {
					return createAddressingEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion) {
					return createAddressingVersionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener) {
					return createAddressingSeparateListenerCheckbox(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration) {
					return createTimeOutDurationText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction) {
					return createTimeOutActionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes) {
					return createRetryErrorCodesText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.retryCount) {
					return createRetryCountText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.retryDelay) {
					return createRetryDelayText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes) {
					return createSuspendErrorCodesText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration) {
					return createSuspendInitialDurationText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration) {
					return createSuspendMaximumDurationText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor) {
					return createSuspendProgressionFactorText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.format) {
					return createFormatEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.optimize) {
					return createOptimizeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.templateParameters) {
					return createTemplateParametersAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled) {
					return createStatisticsEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled) {
					return createTraceEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.address) {
					return createAddressText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate) {
					return createTargetTemplateText(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.parameters) {
					return createParametersAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates) {
					return createAvailableTemplatesText(parent);
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
		propertiesGroup.setText(EsbMessages.TemplateEndpointPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.description, EsbMessages.TemplateEndpointPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.TemplateEndpoint.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.TemplateEndpoint.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.commentsList, EsbMessages.TemplateEndpointPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "TemplateEndpoint", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.TemplateEndpoint.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createEndPointNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.endPointName, EsbMessages.TemplateEndpointPropertiesEditionPart_EndPointNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.endPointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.endPointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
				}
			}

		});
		EditingUtils.setID(endPointName, EsbViewsRepository.TemplateEndpoint.Properties.endPointName);
		EditingUtils.setEEFtype(endPointName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.endPointName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndPointNameText

		// End of user code
		return parent;
	}

	
	protected Composite createAnonymousCheckbox(Composite parent) {
		anonymous = new Button(parent, SWT.CHECK);
		anonymous.setText(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.anonymous, EsbMessages.TemplateEndpointPropertiesEditionPart_AnonymousLabel));
		anonymous.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.anonymous, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(anonymous.getSelection())));
			}

		});
		GridData anonymousData = new GridData(GridData.FILL_HORIZONTAL);
		anonymousData.horizontalSpan = 2;
		anonymous.setLayoutData(anonymousData);
		EditingUtils.setID(anonymous, EsbViewsRepository.TemplateEndpoint.Properties.anonymous);
		EditingUtils.setEEFtype(anonymous, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.anonymous, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAnonymousCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createInLineCheckbox(Composite parent) {
		inLine = new Button(parent, SWT.CHECK);
		inLine.setText(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.inLine, EsbMessages.TemplateEndpointPropertiesEditionPart_InLineLabel));
		inLine.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.inLine, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(inLine.getSelection())));
			}

		});
		GridData inLineData = new GridData(GridData.FILL_HORIZONTAL);
		inLineData.horizontalSpan = 2;
		inLine.setLayoutData(inLineData);
		EditingUtils.setID(inLine, EsbViewsRepository.TemplateEndpoint.Properties.inLine);
		EditingUtils.setEEFtype(inLine, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.inLine, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInLineCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createDuplicateCheckbox(Composite parent) {
		duplicate = new Button(parent, SWT.CHECK);
		duplicate.setText(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.duplicate, EsbMessages.TemplateEndpointPropertiesEditionPart_DuplicateLabel));
		duplicate.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.duplicate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(duplicate.getSelection())));
			}

		});
		GridData duplicateData = new GridData(GridData.FILL_HORIZONTAL);
		duplicateData.horizontalSpan = 2;
		duplicate.setLayoutData(duplicateData);
		EditingUtils.setID(duplicate, EsbViewsRepository.TemplateEndpoint.Properties.duplicate);
		EditingUtils.setEEFtype(duplicate, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.duplicate, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDuplicateCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createPropertiesAdvancedTableComposition(Composite parent) {
		this.properties = new ReferencesTable(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.properties_, EsbMessages.TemplateEndpointPropertiesEditionPart_PropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				properties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				properties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				properties.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				properties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.propertiesFilters) {
			this.properties.addFilter(filter);
		}
		this.properties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.properties_, EsbViewsRepository.SWT_KIND));
		this.properties.createControls(parent);
		this.properties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.properties_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData propertiesData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesData.horizontalSpan = 3;
		this.properties.setLayoutData(propertiesData);
		this.properties.setLowerBound(0);
		this.properties.setUpperBound(-1);
		properties.setID(EsbViewsRepository.TemplateEndpoint.Properties.properties_);
		properties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPropertiesAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createReversedCheckbox(Composite parent) {
		reversed = new Button(parent, SWT.CHECK);
		reversed.setText(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.reversed, EsbMessages.TemplateEndpointPropertiesEditionPart_ReversedLabel));
		reversed.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.reversed, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reversed.getSelection())));
			}

		});
		GridData reversedData = new GridData(GridData.FILL_HORIZONTAL);
		reversedData.horizontalSpan = 2;
		reversed.setLayoutData(reversedData);
		EditingUtils.setID(reversed, EsbViewsRepository.TemplateEndpoint.Properties.reversed);
		EditingUtils.setEEFtype(reversed, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.reversed, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReversedCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createReliableMessagingEnabledCheckbox(Composite parent) {
		reliableMessagingEnabled = new Button(parent, SWT.CHECK);
		reliableMessagingEnabled.setText(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled, EsbMessages.TemplateEndpointPropertiesEditionPart_ReliableMessagingEnabledLabel));
		reliableMessagingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reliableMessagingEnabled.getSelection())));
			}

		});
		GridData reliableMessagingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		reliableMessagingEnabledData.horizontalSpan = 2;
		reliableMessagingEnabled.setLayoutData(reliableMessagingEnabledData);
		EditingUtils.setID(reliableMessagingEnabled, EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled);
		EditingUtils.setEEFtype(reliableMessagingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReliableMessagingEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createSecurityEnabledCheckbox(Composite parent) {
		securityEnabled = new Button(parent, SWT.CHECK);
		securityEnabled.setText(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled, EsbMessages.TemplateEndpointPropertiesEditionPart_SecurityEnabledLabel));
		securityEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(securityEnabled.getSelection())));
			}

		});
		GridData securityEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		securityEnabledData.horizontalSpan = 2;
		securityEnabled.setLayoutData(securityEnabledData);
		EditingUtils.setID(securityEnabled, EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled);
		EditingUtils.setEEFtype(securityEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSecurityEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAddressingEnabledCheckbox(Composite parent) {
		addressingEnabled = new Button(parent, SWT.CHECK);
		addressingEnabled.setText(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled, EsbMessages.TemplateEndpointPropertiesEditionPart_AddressingEnabledLabel));
		addressingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(addressingEnabled.getSelection())));
			}

		});
		GridData addressingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		addressingEnabledData.horizontalSpan = 2;
		addressingEnabled.setLayoutData(addressingEnabledData);
		EditingUtils.setID(addressingEnabled, EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled);
		EditingUtils.setEEFtype(addressingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingEnabledCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createAddressingVersionEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion, EsbMessages.TemplateEndpointPropertiesEditionPart_AddressingVersionLabel);
		addressingVersion = new EMFComboViewer(parent);
		addressingVersion.setContentProvider(new ArrayContentProvider());
		addressingVersion.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData addressingVersionData = new GridData(GridData.FILL_HORIZONTAL);
		addressingVersion.getCombo().setLayoutData(addressingVersionData);
                addressingVersion.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		addressingVersion.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAddressingVersion()));
			}

		});
		addressingVersion.setID(EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingVersionEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createAddressingSeparateListenerCheckbox(Composite parent) {
		addressingSeparateListener = new Button(parent, SWT.CHECK);
		addressingSeparateListener.setText(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener, EsbMessages.TemplateEndpointPropertiesEditionPart_AddressingSeparateListenerLabel));
		addressingSeparateListener.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(addressingSeparateListener.getSelection())));
			}

		});
		GridData addressingSeparateListenerData = new GridData(GridData.FILL_HORIZONTAL);
		addressingSeparateListenerData.horizontalSpan = 2;
		addressingSeparateListener.setLayoutData(addressingSeparateListenerData);
		EditingUtils.setID(addressingSeparateListener, EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener);
		EditingUtils.setEEFtype(addressingSeparateListener, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingSeparateListenerCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createTimeOutDurationText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration, EsbMessages.TemplateEndpointPropertiesEditionPart_TimeOutDurationLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, timeOutDuration.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, timeOutDuration.getText()));
				}
			}

		});
		EditingUtils.setID(timeOutDuration, EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration);
		EditingUtils.setEEFtype(timeOutDuration, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTimeOutDurationText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createTimeOutActionEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction, EsbMessages.TemplateEndpointPropertiesEditionPart_TimeOutActionLabel);
		timeOutAction = new EMFComboViewer(parent);
		timeOutAction.setContentProvider(new ArrayContentProvider());
		timeOutAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData timeOutActionData = new GridData(GridData.FILL_HORIZONTAL);
		timeOutAction.getCombo().setLayoutData(timeOutActionData);
                timeOutAction.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		timeOutAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTimeOutAction()));
			}

		});
		timeOutAction.setID(EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTimeOutActionEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createRetryErrorCodesText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes, EsbMessages.TemplateEndpointPropertiesEditionPart_RetryErrorCodesLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryErrorCodes.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryErrorCodes.getText()));
				}
			}

		});
		EditingUtils.setID(retryErrorCodes, EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes);
		EditingUtils.setEEFtype(retryErrorCodes, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryErrorCodesText

		// End of user code
		return parent;
	}

	
	protected Composite createRetryCountText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.retryCount, EsbMessages.TemplateEndpointPropertiesEditionPart_RetryCountLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.retryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryCount.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.retryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryCount.getText()));
				}
			}

		});
		EditingUtils.setID(retryCount, EsbViewsRepository.TemplateEndpoint.Properties.retryCount);
		EditingUtils.setEEFtype(retryCount, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.retryCount, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryCountText

		// End of user code
		return parent;
	}

	
	protected Composite createRetryDelayText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.retryDelay, EsbMessages.TemplateEndpointPropertiesEditionPart_RetryDelayLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.retryDelay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryDelay.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.retryDelay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryDelay.getText()));
				}
			}

		});
		EditingUtils.setID(retryDelay, EsbViewsRepository.TemplateEndpoint.Properties.retryDelay);
		EditingUtils.setEEFtype(retryDelay, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.retryDelay, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryDelayText

		// End of user code
		return parent;
	}

	
	protected Composite createSuspendErrorCodesText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes, EsbMessages.TemplateEndpointPropertiesEditionPart_SuspendErrorCodesLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendErrorCodes.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendErrorCodes.getText()));
				}
			}

		});
		EditingUtils.setID(suspendErrorCodes, EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes);
		EditingUtils.setEEFtype(suspendErrorCodes, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendErrorCodesText

		// End of user code
		return parent;
	}

	
	protected Composite createSuspendInitialDurationText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration, EsbMessages.TemplateEndpointPropertiesEditionPart_SuspendInitialDurationLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendInitialDuration.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendInitialDuration.getText()));
				}
			}

		});
		EditingUtils.setID(suspendInitialDuration, EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration);
		EditingUtils.setEEFtype(suspendInitialDuration, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendInitialDurationText

		// End of user code
		return parent;
	}

	
	protected Composite createSuspendMaximumDurationText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration, EsbMessages.TemplateEndpointPropertiesEditionPart_SuspendMaximumDurationLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendMaximumDuration.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendMaximumDuration.getText()));
				}
			}

		});
		EditingUtils.setID(suspendMaximumDuration, EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration);
		EditingUtils.setEEFtype(suspendMaximumDuration, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendMaximumDurationText

		// End of user code
		return parent;
	}

	
	protected Composite createSuspendProgressionFactorText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor, EsbMessages.TemplateEndpointPropertiesEditionPart_SuspendProgressionFactorLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendProgressionFactor.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendProgressionFactor.getText()));
				}
			}

		});
		EditingUtils.setID(suspendProgressionFactor, EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor);
		EditingUtils.setEEFtype(suspendProgressionFactor, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendProgressionFactorText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createFormatEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.format, EsbMessages.TemplateEndpointPropertiesEditionPart_FormatLabel);
		format = new EMFComboViewer(parent);
		format.setContentProvider(new ArrayContentProvider());
		format.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData formatData = new GridData(GridData.FILL_HORIZONTAL);
		format.getCombo().setLayoutData(formatData);
                format.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		format.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.format, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFormat()));
			}

		});
		format.setID(EsbViewsRepository.TemplateEndpoint.Properties.format);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.format, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFormatEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createOptimizeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.optimize, EsbMessages.TemplateEndpointPropertiesEditionPart_OptimizeLabel);
		optimize = new EMFComboViewer(parent);
		optimize.setContentProvider(new ArrayContentProvider());
		optimize.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData optimizeData = new GridData(GridData.FILL_HORIZONTAL);
		optimize.getCombo().setLayoutData(optimizeData);
                optimize.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		optimize.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.optimize, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOptimize()));
			}

		});
		optimize.setID(EsbViewsRepository.TemplateEndpoint.Properties.optimize);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.optimize, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOptimizeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTemplateParametersAdvancedTableComposition(Composite parent) {
		this.templateParameters = new ReferencesTable(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.templateParameters, EsbMessages.TemplateEndpointPropertiesEditionPart_TemplateParametersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				templateParameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				templateParameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				templateParameters.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				templateParameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.templateParametersFilters) {
			this.templateParameters.addFilter(filter);
		}
		this.templateParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.templateParameters, EsbViewsRepository.SWT_KIND));
		this.templateParameters.createControls(parent);
		this.templateParameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.templateParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData templateParametersData = new GridData(GridData.FILL_HORIZONTAL);
		templateParametersData.horizontalSpan = 3;
		this.templateParameters.setLayoutData(templateParametersData);
		this.templateParameters.setLowerBound(0);
		this.templateParameters.setUpperBound(-1);
		templateParameters.setID(EsbViewsRepository.TemplateEndpoint.Properties.templateParameters);
		templateParameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTemplateParametersAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createStatisticsEnabledCheckbox(Composite parent) {
		statisticsEnabled = new Button(parent, SWT.CHECK);
		statisticsEnabled.setText(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled, EsbMessages.TemplateEndpointPropertiesEditionPart_StatisticsEnabledLabel));
		statisticsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statisticsEnabled.getSelection())));
			}

		});
		GridData statisticsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		statisticsEnabledData.horizontalSpan = 2;
		statisticsEnabled.setLayoutData(statisticsEnabledData);
		EditingUtils.setID(statisticsEnabled, EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled);
		EditingUtils.setEEFtype(statisticsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatisticsEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createTraceEnabledCheckbox(Composite parent) {
		traceEnabled = new Button(parent, SWT.CHECK);
		traceEnabled.setText(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled, EsbMessages.TemplateEndpointPropertiesEditionPart_TraceEnabledLabel));
		traceEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(traceEnabled.getSelection())));
			}

		});
		GridData traceEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		traceEnabledData.horizontalSpan = 2;
		traceEnabled.setLayoutData(traceEnabledData);
		EditingUtils.setID(traceEnabled, EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled);
		EditingUtils.setEEFtype(traceEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTraceEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAddressText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.address, EsbMessages.TemplateEndpointPropertiesEditionPart_AddressLabel);
		address = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData addressData = new GridData(GridData.FILL_HORIZONTAL);
		address.setLayoutData(addressData);
		address.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.address, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, address.getText()));
			}

		});
		address.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.address, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, address.getText()));
				}
			}

		});
		EditingUtils.setID(address, EsbViewsRepository.TemplateEndpoint.Properties.address);
		EditingUtils.setEEFtype(address, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.address, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressText

		// End of user code
		return parent;
	}

	
	protected Composite createTargetTemplateText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate, EsbMessages.TemplateEndpointPropertiesEditionPart_TargetTemplateLabel);
		targetTemplate = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData targetTemplateData = new GridData(GridData.FILL_HORIZONTAL);
		targetTemplate.setLayoutData(targetTemplateData);
		targetTemplate.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetTemplate.getText()));
			}

		});
		targetTemplate.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetTemplate.getText()));
				}
			}

		});
		EditingUtils.setID(targetTemplate, EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate);
		EditingUtils.setEEFtype(targetTemplate, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetTemplateText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createParametersAdvancedTableComposition(Composite parent) {
		this.parameters = new ReferencesTable(getDescription(EsbViewsRepository.TemplateEndpoint.Properties.parameters, EsbMessages.TemplateEndpointPropertiesEditionPart_ParametersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				parameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				parameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				parameters.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				parameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.parametersFilters) {
			this.parameters.addFilter(filter);
		}
		this.parameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.parameters, EsbViewsRepository.SWT_KIND));
		this.parameters.createControls(parent);
		this.parameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.parameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData parametersData = new GridData(GridData.FILL_HORIZONTAL);
		parametersData.horizontalSpan = 3;
		this.parameters.setLayoutData(parametersData);
		this.parameters.setLowerBound(0);
		this.parameters.setUpperBound(-1);
		parameters.setID(EsbViewsRepository.TemplateEndpoint.Properties.parameters);
		parameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createParametersAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createAvailableTemplatesText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates, EsbMessages.TemplateEndpointPropertiesEditionPart_AvailableTemplatesLabel);
		availableTemplates = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData availableTemplatesData = new GridData(GridData.FILL_HORIZONTAL);
		availableTemplates.setLayoutData(availableTemplatesData);
		availableTemplates.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, availableTemplates.getText()));
			}

		});
		availableTemplates.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateEndpointPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, availableTemplates.getText()));
				}
			}

		});
		EditingUtils.setID(availableTemplates, EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates);
		EditingUtils.setEEFtype(availableTemplates, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAvailableTemplatesText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getEndPointName()
	 * 
	 */
	public String getEndPointName() {
		return endPointName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setEndPointName(String newValue)
	 * 
	 */
	public void setEndPointName(String newValue) {
		if (newValue != null) {
			endPointName.setText(newValue);
		} else {
			endPointName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.endPointName);
		if (eefElementEditorReadOnlyState && endPointName.isEnabled()) {
			endPointName.setEnabled(false);
			endPointName.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endPointName.isEnabled()) {
			endPointName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getAnonymous()
	 * 
	 */
	public Boolean getAnonymous() {
		return Boolean.valueOf(anonymous.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setAnonymous(Boolean newValue)
	 * 
	 */
	public void setAnonymous(Boolean newValue) {
		if (newValue != null) {
			anonymous.setSelection(newValue.booleanValue());
		} else {
			anonymous.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.anonymous);
		if (eefElementEditorReadOnlyState && anonymous.isEnabled()) {
			anonymous.setEnabled(false);
			anonymous.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !anonymous.isEnabled()) {
			anonymous.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getInLine()
	 * 
	 */
	public Boolean getInLine() {
		return Boolean.valueOf(inLine.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setInLine(Boolean newValue)
	 * 
	 */
	public void setInLine(Boolean newValue) {
		if (newValue != null) {
			inLine.setSelection(newValue.booleanValue());
		} else {
			inLine.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.inLine);
		if (eefElementEditorReadOnlyState && inLine.isEnabled()) {
			inLine.setEnabled(false);
			inLine.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inLine.isEnabled()) {
			inLine.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getDuplicate()
	 * 
	 */
	public Boolean getDuplicate() {
		return Boolean.valueOf(duplicate.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setDuplicate(Boolean newValue)
	 * 
	 */
	public void setDuplicate(Boolean newValue) {
		if (newValue != null) {
			duplicate.setSelection(newValue.booleanValue());
		} else {
			duplicate.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.duplicate);
		if (eefElementEditorReadOnlyState && duplicate.isEnabled()) {
			duplicate.setEnabled(false);
			duplicate.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !duplicate.isEnabled()) {
			duplicate.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#initProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		properties.setContentProvider(contentProvider);
		properties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.properties_);
		if (eefElementEditorReadOnlyState && properties.isEnabled()) {
			properties.setEnabled(false);
			properties.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !properties.isEnabled()) {
			properties.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#updateProperties()
	 * 
	 */
	public void updateProperties() {
	properties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#addFilterProperties(ViewerFilter filter)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#addBusinessFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToProperties(ViewerFilter filter) {
		propertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#isContainedInPropertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPropertiesTable(EObject element) {
		return ((ReferencesTableSettings)properties.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getReversed()
	 * 
	 */
	public Boolean getReversed() {
		return Boolean.valueOf(reversed.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setReversed(Boolean newValue)
	 * 
	 */
	public void setReversed(Boolean newValue) {
		if (newValue != null) {
			reversed.setSelection(newValue.booleanValue());
		} else {
			reversed.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.reversed);
		if (eefElementEditorReadOnlyState && reversed.isEnabled()) {
			reversed.setEnabled(false);
			reversed.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reversed.isEnabled()) {
			reversed.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getReliableMessagingEnabled()
	 * 
	 */
	public Boolean getReliableMessagingEnabled() {
		return Boolean.valueOf(reliableMessagingEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setReliableMessagingEnabled(Boolean newValue)
	 * 
	 */
	public void setReliableMessagingEnabled(Boolean newValue) {
		if (newValue != null) {
			reliableMessagingEnabled.setSelection(newValue.booleanValue());
		} else {
			reliableMessagingEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled);
		if (eefElementEditorReadOnlyState && reliableMessagingEnabled.isEnabled()) {
			reliableMessagingEnabled.setEnabled(false);
			reliableMessagingEnabled.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reliableMessagingEnabled.isEnabled()) {
			reliableMessagingEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getSecurityEnabled()
	 * 
	 */
	public Boolean getSecurityEnabled() {
		return Boolean.valueOf(securityEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setSecurityEnabled(Boolean newValue)
	 * 
	 */
	public void setSecurityEnabled(Boolean newValue) {
		if (newValue != null) {
			securityEnabled.setSelection(newValue.booleanValue());
		} else {
			securityEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled);
		if (eefElementEditorReadOnlyState && securityEnabled.isEnabled()) {
			securityEnabled.setEnabled(false);
			securityEnabled.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !securityEnabled.isEnabled()) {
			securityEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getAddressingEnabled()
	 * 
	 */
	public Boolean getAddressingEnabled() {
		return Boolean.valueOf(addressingEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setAddressingEnabled(Boolean newValue)
	 * 
	 */
	public void setAddressingEnabled(Boolean newValue) {
		if (newValue != null) {
			addressingEnabled.setSelection(newValue.booleanValue());
		} else {
			addressingEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled);
		if (eefElementEditorReadOnlyState && addressingEnabled.isEnabled()) {
			addressingEnabled.setEnabled(false);
			addressingEnabled.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingEnabled.isEnabled()) {
			addressingEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getAddressingVersion()
	 * 
	 */
	public Enumerator getAddressingVersion() {
		Enumerator selection = (Enumerator) ((StructuredSelection) addressingVersion.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#initAddressingVersion(Object input, Enumerator current)
	 */
	public void initAddressingVersion(Object input, Enumerator current) {
		addressingVersion.setInput(input);
		addressingVersion.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion);
		if (eefElementEditorReadOnlyState && addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(false);
			addressingVersion.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setAddressingVersion(Enumerator newValue)
	 * 
	 */
	public void setAddressingVersion(Enumerator newValue) {
		addressingVersion.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion);
		if (eefElementEditorReadOnlyState && addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(false);
			addressingVersion.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getAddressingSeparateListener()
	 * 
	 */
	public Boolean getAddressingSeparateListener() {
		return Boolean.valueOf(addressingSeparateListener.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setAddressingSeparateListener(Boolean newValue)
	 * 
	 */
	public void setAddressingSeparateListener(Boolean newValue) {
		if (newValue != null) {
			addressingSeparateListener.setSelection(newValue.booleanValue());
		} else {
			addressingSeparateListener.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener);
		if (eefElementEditorReadOnlyState && addressingSeparateListener.isEnabled()) {
			addressingSeparateListener.setEnabled(false);
			addressingSeparateListener.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingSeparateListener.isEnabled()) {
			addressingSeparateListener.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getTimeOutDuration()
	 * 
	 */
	public String getTimeOutDuration() {
		return timeOutDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setTimeOutDuration(String newValue)
	 * 
	 */
	public void setTimeOutDuration(String newValue) {
		if (newValue != null) {
			timeOutDuration.setText(newValue);
		} else {
			timeOutDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration);
		if (eefElementEditorReadOnlyState && timeOutDuration.isEnabled()) {
			timeOutDuration.setEnabled(false);
			timeOutDuration.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutDuration.isEnabled()) {
			timeOutDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getTimeOutAction()
	 * 
	 */
	public Enumerator getTimeOutAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) timeOutAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#initTimeOutAction(Object input, Enumerator current)
	 */
	public void initTimeOutAction(Object input, Enumerator current) {
		timeOutAction.setInput(input);
		timeOutAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction);
		if (eefElementEditorReadOnlyState && timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(false);
			timeOutAction.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setTimeOutAction(Enumerator newValue)
	 * 
	 */
	public void setTimeOutAction(Enumerator newValue) {
		timeOutAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction);
		if (eefElementEditorReadOnlyState && timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(false);
			timeOutAction.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getRetryErrorCodes()
	 * 
	 */
	public String getRetryErrorCodes() {
		return retryErrorCodes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setRetryErrorCodes(String newValue)
	 * 
	 */
	public void setRetryErrorCodes(String newValue) {
		if (newValue != null) {
			retryErrorCodes.setText(newValue);
		} else {
			retryErrorCodes.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes);
		if (eefElementEditorReadOnlyState && retryErrorCodes.isEnabled()) {
			retryErrorCodes.setEnabled(false);
			retryErrorCodes.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryErrorCodes.isEnabled()) {
			retryErrorCodes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getRetryCount()
	 * 
	 */
	public String getRetryCount() {
		return retryCount.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setRetryCount(String newValue)
	 * 
	 */
	public void setRetryCount(String newValue) {
		if (newValue != null) {
			retryCount.setText(newValue);
		} else {
			retryCount.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.retryCount);
		if (eefElementEditorReadOnlyState && retryCount.isEnabled()) {
			retryCount.setEnabled(false);
			retryCount.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryCount.isEnabled()) {
			retryCount.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getRetryDelay()
	 * 
	 */
	public String getRetryDelay() {
		return retryDelay.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setRetryDelay(String newValue)
	 * 
	 */
	public void setRetryDelay(String newValue) {
		if (newValue != null) {
			retryDelay.setText(newValue);
		} else {
			retryDelay.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.retryDelay);
		if (eefElementEditorReadOnlyState && retryDelay.isEnabled()) {
			retryDelay.setEnabled(false);
			retryDelay.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryDelay.isEnabled()) {
			retryDelay.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getSuspendErrorCodes()
	 * 
	 */
	public String getSuspendErrorCodes() {
		return suspendErrorCodes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setSuspendErrorCodes(String newValue)
	 * 
	 */
	public void setSuspendErrorCodes(String newValue) {
		if (newValue != null) {
			suspendErrorCodes.setText(newValue);
		} else {
			suspendErrorCodes.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes);
		if (eefElementEditorReadOnlyState && suspendErrorCodes.isEnabled()) {
			suspendErrorCodes.setEnabled(false);
			suspendErrorCodes.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendErrorCodes.isEnabled()) {
			suspendErrorCodes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getSuspendInitialDuration()
	 * 
	 */
	public String getSuspendInitialDuration() {
		return suspendInitialDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setSuspendInitialDuration(String newValue)
	 * 
	 */
	public void setSuspendInitialDuration(String newValue) {
		if (newValue != null) {
			suspendInitialDuration.setText(newValue);
		} else {
			suspendInitialDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration);
		if (eefElementEditorReadOnlyState && suspendInitialDuration.isEnabled()) {
			suspendInitialDuration.setEnabled(false);
			suspendInitialDuration.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendInitialDuration.isEnabled()) {
			suspendInitialDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getSuspendMaximumDuration()
	 * 
	 */
	public String getSuspendMaximumDuration() {
		return suspendMaximumDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setSuspendMaximumDuration(String newValue)
	 * 
	 */
	public void setSuspendMaximumDuration(String newValue) {
		if (newValue != null) {
			suspendMaximumDuration.setText(newValue);
		} else {
			suspendMaximumDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration);
		if (eefElementEditorReadOnlyState && suspendMaximumDuration.isEnabled()) {
			suspendMaximumDuration.setEnabled(false);
			suspendMaximumDuration.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendMaximumDuration.isEnabled()) {
			suspendMaximumDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getSuspendProgressionFactor()
	 * 
	 */
	public String getSuspendProgressionFactor() {
		return suspendProgressionFactor.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setSuspendProgressionFactor(String newValue)
	 * 
	 */
	public void setSuspendProgressionFactor(String newValue) {
		if (newValue != null) {
			suspendProgressionFactor.setText(newValue);
		} else {
			suspendProgressionFactor.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor);
		if (eefElementEditorReadOnlyState && suspendProgressionFactor.isEnabled()) {
			suspendProgressionFactor.setEnabled(false);
			suspendProgressionFactor.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendProgressionFactor.isEnabled()) {
			suspendProgressionFactor.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getFormat()
	 * 
	 */
	public Enumerator getFormat() {
		Enumerator selection = (Enumerator) ((StructuredSelection) format.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#initFormat(Object input, Enumerator current)
	 */
	public void initFormat(Object input, Enumerator current) {
		format.setInput(input);
		format.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.format);
		if (eefElementEditorReadOnlyState && format.isEnabled()) {
			format.setEnabled(false);
			format.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !format.isEnabled()) {
			format.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setFormat(Enumerator newValue)
	 * 
	 */
	public void setFormat(Enumerator newValue) {
		format.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.format);
		if (eefElementEditorReadOnlyState && format.isEnabled()) {
			format.setEnabled(false);
			format.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !format.isEnabled()) {
			format.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getOptimize()
	 * 
	 */
	public Enumerator getOptimize() {
		Enumerator selection = (Enumerator) ((StructuredSelection) optimize.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#initOptimize(Object input, Enumerator current)
	 */
	public void initOptimize(Object input, Enumerator current) {
		optimize.setInput(input);
		optimize.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.optimize);
		if (eefElementEditorReadOnlyState && optimize.isEnabled()) {
			optimize.setEnabled(false);
			optimize.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !optimize.isEnabled()) {
			optimize.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setOptimize(Enumerator newValue)
	 * 
	 */
	public void setOptimize(Enumerator newValue) {
		optimize.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.optimize);
		if (eefElementEditorReadOnlyState && optimize.isEnabled()) {
			optimize.setEnabled(false);
			optimize.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !optimize.isEnabled()) {
			optimize.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#initTemplateParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTemplateParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		templateParameters.setContentProvider(contentProvider);
		templateParameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.templateParameters);
		if (eefElementEditorReadOnlyState && templateParameters.isEnabled()) {
			templateParameters.setEnabled(false);
			templateParameters.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !templateParameters.isEnabled()) {
			templateParameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#updateTemplateParameters()
	 * 
	 */
	public void updateTemplateParameters() {
	templateParameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#addFilterTemplateParameters(ViewerFilter filter)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#addBusinessFilterTemplateParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTemplateParameters(ViewerFilter filter) {
		templateParametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#isContainedInTemplateParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInTemplateParametersTable(EObject element) {
		return ((ReferencesTableSettings)templateParameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getStatisticsEnabled()
	 * 
	 */
	public Boolean getStatisticsEnabled() {
		return Boolean.valueOf(statisticsEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setStatisticsEnabled(Boolean newValue)
	 * 
	 */
	public void setStatisticsEnabled(Boolean newValue) {
		if (newValue != null) {
			statisticsEnabled.setSelection(newValue.booleanValue());
		} else {
			statisticsEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled);
		if (eefElementEditorReadOnlyState && statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(false);
			statisticsEnabled.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getTraceEnabled()
	 * 
	 */
	public Boolean getTraceEnabled() {
		return Boolean.valueOf(traceEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setTraceEnabled(Boolean newValue)
	 * 
	 */
	public void setTraceEnabled(Boolean newValue) {
		if (newValue != null) {
			traceEnabled.setSelection(newValue.booleanValue());
		} else {
			traceEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled);
		if (eefElementEditorReadOnlyState && traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(false);
			traceEnabled.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getAddress()
	 * 
	 */
	public String getAddress() {
		return address.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setAddress(String newValue)
	 * 
	 */
	public void setAddress(String newValue) {
		if (newValue != null) {
			address.setText(newValue);
		} else {
			address.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.address);
		if (eefElementEditorReadOnlyState && address.isEnabled()) {
			address.setEnabled(false);
			address.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !address.isEnabled()) {
			address.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getTargetTemplate()
	 * 
	 */
	public String getTargetTemplate() {
		return targetTemplate.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setTargetTemplate(String newValue)
	 * 
	 */
	public void setTargetTemplate(String newValue) {
		if (newValue != null) {
			targetTemplate.setText(newValue);
		} else {
			targetTemplate.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate);
		if (eefElementEditorReadOnlyState && targetTemplate.isEnabled()) {
			targetTemplate.setEnabled(false);
			targetTemplate.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetTemplate.isEnabled()) {
			targetTemplate.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#initParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		parameters.setContentProvider(contentProvider);
		parameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.parameters);
		if (eefElementEditorReadOnlyState && parameters.isEnabled()) {
			parameters.setEnabled(false);
			parameters.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameters.isEnabled()) {
			parameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#updateParameters()
	 * 
	 */
	public void updateParameters() {
	parameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#addFilterParameters(ViewerFilter filter)
	 * 
	 */
	public void addFilterToParameters(ViewerFilter filter) {
		parametersFilters.add(filter);
		if (this.parameters != null) {
			this.parameters.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#addBusinessFilterParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToParameters(ViewerFilter filter) {
		parametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#isContainedInParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInParametersTable(EObject element) {
		return ((ReferencesTableSettings)parameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#getAvailableTemplates()
	 * 
	 */
	public String getAvailableTemplates() {
		return availableTemplates.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart#setAvailableTemplates(String newValue)
	 * 
	 */
	public void setAvailableTemplates(String newValue) {
		if (newValue != null) {
			availableTemplates.setText(newValue);
		} else {
			availableTemplates.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates);
		if (eefElementEditorReadOnlyState && availableTemplates.isEnabled()) {
			availableTemplates.setEnabled(false);
			availableTemplates.setToolTipText(EsbMessages.TemplateEndpoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !availableTemplates.isEnabled()) {
			availableTemplates.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.TemplateEndpoint_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
