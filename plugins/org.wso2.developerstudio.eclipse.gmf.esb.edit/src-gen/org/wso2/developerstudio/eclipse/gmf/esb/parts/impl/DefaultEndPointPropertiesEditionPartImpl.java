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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
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
import org.eclipse.swt.events.KeyListener;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class DefaultEndPointPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, DefaultEndPointPropertiesEditionPart {

    protected Text commentsList;
    protected Button editCommentsList;
    protected EList commentsListList;
    protected Text endPointName;
    protected Button anonymous;
    protected Button inLine;
    protected Button duplicate;
    protected Button reversed;
    protected EMFComboViewer format;
    protected ReferencesTable templateParameters;
    protected List<ViewerFilter> templateParametersBusinessFilters = new ArrayList<ViewerFilter>();
    protected List<ViewerFilter> templateParametersFilters = new ArrayList<ViewerFilter>();
    protected Button statisticsEnabled;
    protected Button traceEnabled;
    protected Text suspendErrorCodes;
    protected Text suspendInitialDuration;
    protected Text suspendMaximumDuration;
    protected Text suspendProgressionFactor;
    protected Text retryErrorCodes;
    protected Text retryCount;
    protected Text retryDelay;
    protected ReferencesTable properties;
    protected List<ViewerFilter> propertiesBusinessFilters = new ArrayList<ViewerFilter>();
    protected List<ViewerFilter> propertiesFilters = new ArrayList<ViewerFilter>();
    protected EMFComboViewer optimize;
    protected Text description;
    protected Button reliableMessagingEnabled;
    protected Button securityEnabled;
    protected Button addressingEnabled;
    protected Button addressingSeparateListener;
    protected EMFComboViewer addressingVersion;
    // Start of user code  for Reliable Messaging Policy widgets declarations
    protected RegistryKeyProperty reliableMessagingPolicy;
    protected Text reliableMessagingPolicyText;
    // End of user code

    // Start of user code  for Security Policy widgets declarations
    protected RegistryKeyProperty securityPolicy;
    protected Text securityPolicyText;
    // End of user code

    // Start of user code  for Inbound Policy widgets declarations
    protected RegistryKeyProperty inboundPolicy;
    protected Text inboundPolicyText;
    // End of user code

    // Start of user code  for Outbound Policy widgets declarations
    protected RegistryKeyProperty outboundPolicy;
    protected Text outboundPolicyText;
    
    protected Control[] inlineTypeElements;
    protected Control[] formatTypeElements;
    protected Control[] traceEnabledTypeElements;
    protected Control[] statEnabledTypeElements;
    protected Control[] suspendErrorCodesTypeElements;
    protected Control[] suspendInitialDurationTypeElements;
    protected Control[] suspendMaxDurationTypeElements;
    protected Control[] suspendProgressionFactorTypeElements;
    protected Control[] retryErrorCodesTypeElements;
    protected Control[] retryCountTypeElements;
    protected Control[] retryDelayTypeElements;
    protected Control[] propertiesTypeElements;
    protected Control[] optimizeTypeElements;
    protected Control[] descriptionTypeElements;
    protected Control[] reliableMegEnabledTypeElements;
    protected Control[] securithEnabledTypeElements;
    protected Control[] addressingEnabledTypeElements;
    protected Control[] timeoutDurationTypeElements;
    protected Control[] timeoutActionTypeElements;
    protected Control[] reliablePolicyTypeElements;
    protected Control[] securityPolicyTypeElements;
    protected Control[] inboundPolicyTypeElements;
    protected Control[] outboundPolicyTypeElements;
    protected Control[] addressingVersionTypeElements;
    protected Control[] addressingSeperateListenerTypeElements;
 
    protected Group basicGroup;
    protected Group endpointSuspendStateGroup;
    protected Group endpointTimeoutStateGroup;
    protected Group miscGroup;
    protected Group qoSGroup;
    protected Group timeoutGroup;
    
    protected GridData propertiesData;
    
    protected Composite filterAdvancedSubPropertiesGroup;
    protected Group failoverErrorCodesGroup;
    
    protected Text failoverNonRetryErrorCodes;
    protected Control[] failoverNonRetryErrorCodesElements;
    
    // End of user code

    protected Text timeOutDuration;
    protected EMFComboViewer timeOutAction;


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
		CompositionStep basicStep = defaultEndPointStep.addStep(EsbViewsRepository.DefaultEndPoint.Basic.class);
		basicStep.addStep(EsbViewsRepository.DefaultEndPoint.Basic.commentsList);
		basicStep.addStep(EsbViewsRepository.DefaultEndPoint.Basic.endPointName);
		basicStep.addStep(EsbViewsRepository.DefaultEndPoint.Basic.anonymous);
		basicStep.addStep(EsbViewsRepository.DefaultEndPoint.Basic.inLine);
		basicStep.addStep(EsbViewsRepository.DefaultEndPoint.Basic.duplicate);
		basicStep.addStep(EsbViewsRepository.DefaultEndPoint.Basic.reversed);
		basicStep.addStep(EsbViewsRepository.DefaultEndPoint.Basic.format);
		basicStep.addStep(EsbViewsRepository.DefaultEndPoint.Basic.templateParameters);
		basicStep.addStep(EsbViewsRepository.DefaultEndPoint.Basic.statisticsEnabled);
		basicStep.addStep(EsbViewsRepository.DefaultEndPoint.Basic.traceEnabled);
		
		CompositionStep endpointSuspendStateStep = defaultEndPointStep.addStep(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.class);
		endpointSuspendStateStep.addStep(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendErrorCodes);
		endpointSuspendStateStep.addStep(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendInitialDuration);
		endpointSuspendStateStep.addStep(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendMaximumDuration);
		endpointSuspendStateStep.addStep(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendProgressionFactor);
		
		CompositionStep endpointTimeoutStateStep = defaultEndPointStep.addStep(EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.class);
		endpointTimeoutStateStep.addStep(EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryErrorCodes);
		endpointTimeoutStateStep.addStep(EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryCount);
		endpointTimeoutStateStep.addStep(EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryDelay);
		
		CompositionStep miscStep = defaultEndPointStep.addStep(EsbViewsRepository.DefaultEndPoint.Misc.class);
		miscStep.addStep(EsbViewsRepository.DefaultEndPoint.Misc.properties);
		miscStep.addStep(EsbViewsRepository.DefaultEndPoint.Misc.optimize);
		miscStep.addStep(EsbViewsRepository.DefaultEndPoint.Misc.description);
		
		CompositionStep qoSStep = defaultEndPointStep.addStep(EsbViewsRepository.DefaultEndPoint.QoS.class);
		qoSStep.addStep(EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingEnabled);
		qoSStep.addStep(EsbViewsRepository.DefaultEndPoint.QoS.securityEnabled);
		qoSStep.addStep(EsbViewsRepository.DefaultEndPoint.QoS.addressingEnabled);
		qoSStep.addStep(EsbViewsRepository.DefaultEndPoint.QoS.addressingSeparateListener);
		qoSStep.addStep(EsbViewsRepository.DefaultEndPoint.QoS.addressingVersion);
		qoSStep.addStep(EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingPolicy);
		qoSStep.addStep(EsbViewsRepository.DefaultEndPoint.QoS.securityPolicy);
		qoSStep.addStep(EsbViewsRepository.DefaultEndPoint.QoS.inboundPolicy);
		qoSStep.addStep(EsbViewsRepository.DefaultEndPoint.QoS.outboundPolicy);
		
		CompositionStep timeoutStep = defaultEndPointStep.addStep(EsbViewsRepository.DefaultEndPoint.Timeout.class);
		timeoutStep.addStep(EsbViewsRepository.DefaultEndPoint.Timeout.timeOutDuration);
		timeoutStep.addStep(EsbViewsRepository.DefaultEndPoint.Timeout.timeOutAction);
		
		defaultEndPointStep
			.addStep(EsbViewsRepository.DefaultEndPoint.FailoverErrorCodes.class)
			.addStep(EsbViewsRepository.DefaultEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes);
		
		
		composer = new PartComposer(defaultEndPointStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.DefaultEndPoint.Basic.class) {
					return createBasicGroup(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Basic.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Basic.endPointName) {
					return createEndPointNameText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Basic.anonymous) {
					return createAnonymousCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Basic.inLine) {
					return createInLineCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Basic.duplicate) {
					return createDuplicateCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Basic.reversed) {
					return createReversedCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Basic.format) {
					return createFormatEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Basic.templateParameters) {
					return createTemplateParametersAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Basic.statisticsEnabled) {
					return createStatisticsEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Basic.traceEnabled) {
					return createTraceEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.class) {
					return createEndpointSuspendStateGroup(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendErrorCodes) {
					return createSuspendErrorCodesText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendInitialDuration) {
					return createSuspendInitialDurationText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendMaximumDuration) {
					return createSuspendMaximumDurationText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendProgressionFactor) {
					return createSuspendProgressionFactorText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.class) {
					return createEndpointTimeoutStateGroup(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryErrorCodes) {
					return createRetryErrorCodesText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryCount) {
					return createRetryCountText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryDelay) {
					return createRetryDelayText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Misc.class) {
					return createMiscGroup(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Misc.properties) {
					return createPropertiesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Misc.optimize) {
					return createOptimizeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Misc.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.QoS.class) {
					return createQoSGroup(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingEnabled) {
					return createReliableMessagingEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.QoS.securityEnabled) {
					return createSecurityEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.QoS.addressingEnabled) {
					return createAddressingEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.QoS.addressingSeparateListener) {
					return createAddressingSeparateListenerCheckbox(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.QoS.addressingVersion) {
					return createAddressingVersionEMFComboViewer(parent);
				}
				// Start of user code for Reliable Messaging Policy addToPart creation
                if (key == EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingPolicy) {
                    return createReliableMessagingPolicy(parent);
                }
				// End of user code
				// Start of user code for Security Policy addToPart creation
                if (key == EsbViewsRepository.DefaultEndPoint.QoS.securityPolicy) {
                    return createSecurityPolicy(parent);
                }
				// End of user code
				// Start of user code for Inbound Policy addToPart creation
                if (key == EsbViewsRepository.DefaultEndPoint.QoS.inboundPolicy) {
                    return createInboundPolicy(parent);
                }
				// End of user code
				// Start of user code for Outbound Policy addToPart creation
                if (key == EsbViewsRepository.DefaultEndPoint.QoS.outboundPolicy) {
                    return createOutboundPolicy(parent);
                }
				// End of user code
				if (key == EsbViewsRepository.DefaultEndPoint.Timeout.class) {
					return createTimeoutGroup(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Timeout.timeOutDuration) {
					return createTimeOutDurationText(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.Timeout.timeOutAction) {
					return createTimeOutActionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.FailoverErrorCodes.class) {
					return createFailoverErrorCodesGroup(parent);
				}
				if (key == EsbViewsRepository.DefaultEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes) {
					return createFailoverNonRetryErrorCodesText(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * @generated NOT
	 */
	protected Composite createBasicGroup(Composite parent) {
		basicGroup = new Group(parent, SWT.NONE);
		basicGroup.setText(EsbMessages.DefaultEndPointPropertiesEditionPart_BasicGroupLabel);
		GridData basicGroupData = new GridData(GridData.FILL_HORIZONTAL);
		basicGroupData.horizontalSpan = 3;
		basicGroup.setLayoutData(basicGroupData);
		GridLayout basicGroupLayout = new GridLayout();
		basicGroupLayout.numColumns = 3;
		basicGroup.setLayout(basicGroupLayout);
		return basicGroup;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.DefaultEndPoint.Basic.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Basic.commentsList, EsbMessages.DefaultEndPointPropertiesEditionPart_CommentsListLabel));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.DefaultEndPoint.Basic.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createEndPointNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DefaultEndPoint.Basic.endPointName, EsbMessages.DefaultEndPointPropertiesEditionPart_EndPointNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.endPointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.endPointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
				}
			}

		});
		EditingUtils.setID(endPointName, EsbViewsRepository.DefaultEndPoint.Basic.endPointName);
		EditingUtils.setEEFtype(endPointName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Basic.endPointName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndPointNameText

		// End of user code
		return parent;
	}

	
	protected Composite createAnonymousCheckbox(Composite parent) {
		anonymous = new Button(parent, SWT.CHECK);
		anonymous.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Basic.anonymous, EsbMessages.DefaultEndPointPropertiesEditionPart_AnonymousLabel));
		anonymous.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.anonymous, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(anonymous.getSelection())));
			}

		});
		GridData anonymousData = new GridData(GridData.FILL_HORIZONTAL);
		anonymousData.horizontalSpan = 2;
		anonymous.setLayoutData(anonymousData);
		EditingUtils.setID(anonymous, EsbViewsRepository.DefaultEndPoint.Basic.anonymous);
		EditingUtils.setEEFtype(anonymous, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Basic.anonymous, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAnonymousCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createInLineCheckbox(Composite parent) {
		inLine = new Button(parent, SWT.CHECK);
		inLine.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Basic.inLine, EsbMessages.DefaultEndPointPropertiesEditionPart_InLineLabel));
		inLine.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.inLine, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(inLine.getSelection())));
			}

		});
		GridData inLineData = new GridData(GridData.FILL_HORIZONTAL);
		inLineData.horizontalSpan = 2;
		inLine.setLayoutData(inLineData);
		EditingUtils.setID(inLine, EsbViewsRepository.DefaultEndPoint.Basic.inLine);
		EditingUtils.setEEFtype(inLine, "eef::Checkbox"); //$NON-NLS-1$
		Control inlineHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Basic.inLine, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInLineCheckbox
		inlineTypeElements = new Control[] { inLine, inlineHelp };
		// End of user code
		return parent;
	}

	
	protected Composite createDuplicateCheckbox(Composite parent) {
		duplicate = new Button(parent, SWT.CHECK);
		duplicate.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Basic.duplicate, EsbMessages.DefaultEndPointPropertiesEditionPart_DuplicateLabel));
		duplicate.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.duplicate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(duplicate.getSelection())));
			}

		});
		GridData duplicateData = new GridData(GridData.FILL_HORIZONTAL);
		duplicateData.horizontalSpan = 2;
		duplicate.setLayoutData(duplicateData);
		EditingUtils.setID(duplicate, EsbViewsRepository.DefaultEndPoint.Basic.duplicate);
		EditingUtils.setEEFtype(duplicate, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Basic.duplicate, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDuplicateCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createReversedCheckbox(Composite parent) {
		reversed = new Button(parent, SWT.CHECK);
		reversed.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Basic.reversed, EsbMessages.DefaultEndPointPropertiesEditionPart_ReversedLabel));
		reversed.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.reversed, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reversed.getSelection())));
			}

		});
		GridData reversedData = new GridData(GridData.FILL_HORIZONTAL);
		reversedData.horizontalSpan = 2;
		reversed.setLayoutData(reversedData);
		EditingUtils.setID(reversed, EsbViewsRepository.DefaultEndPoint.Basic.reversed);
		EditingUtils.setEEFtype(reversed, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Basic.reversed, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReversedCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createFormatEMFComboViewer(Composite parent) {
	    Control formatLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.Basic.format, EsbMessages.DefaultEndPointPropertiesEditionPart_FormatLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.format, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFormat()));
			}

		});
		format.setID(EsbViewsRepository.DefaultEndPoint.Basic.format);
		Control formatHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Basic.format, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFormatEMFComboViewer
		formatTypeElements = new Control[] { formatLabel, format.getCombo(), formatHelp };
        // End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTemplateParametersAdvancedTableComposition(Composite parent) {
		this.templateParameters = new ReferencesTable(getDescription(EsbViewsRepository.DefaultEndPoint.Basic.templateParameters, EsbMessages.DefaultEndPointPropertiesEditionPart_TemplateParametersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				templateParameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				templateParameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				templateParameters.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				templateParameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.templateParametersFilters) {
			this.templateParameters.addFilter(filter);
		}
		this.templateParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Basic.templateParameters, EsbViewsRepository.SWT_KIND));
		this.templateParameters.createControls(parent);
		this.templateParameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.templateParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData templateParametersData = new GridData(GridData.FILL_HORIZONTAL);
		templateParametersData.horizontalSpan = 3;
		this.templateParameters.setLayoutData(templateParametersData);
		this.templateParameters.setLowerBound(0);
		this.templateParameters.setUpperBound(-1);
		templateParameters.setID(EsbViewsRepository.DefaultEndPoint.Basic.templateParameters);
		templateParameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTemplateParametersAdvancedTableComposition

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createStatisticsEnabledCheckbox(Composite parent) {
		statisticsEnabled = new Button(parent, SWT.CHECK);
		statisticsEnabled.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Basic.statisticsEnabled, EsbMessages.DefaultEndPointPropertiesEditionPart_StatisticsEnabledLabel));
		statisticsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.statisticsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statisticsEnabled.getSelection())));
			}

		});
		GridData statisticsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		statisticsEnabledData.horizontalSpan = 2;
		statisticsEnabled.setLayoutData(statisticsEnabledData);
		EditingUtils.setID(statisticsEnabled, EsbViewsRepository.DefaultEndPoint.Basic.statisticsEnabled);
		EditingUtils.setEEFtype(statisticsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control statEnableHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Basic.statisticsEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatisticsEnabledCheckbox
		statEnabledTypeElements = new Control[] { statisticsEnabled, statEnableHelp };
        // End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createTraceEnabledCheckbox(Composite parent) {
		traceEnabled = new Button(parent, SWT.CHECK);
		traceEnabled.setText(getDescription(EsbViewsRepository.DefaultEndPoint.Basic.traceEnabled, EsbMessages.DefaultEndPointPropertiesEditionPart_TraceEnabledLabel));
		traceEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Basic.traceEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(traceEnabled.getSelection())));
			}

		});
		GridData traceEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		traceEnabledData.horizontalSpan = 2;
		traceEnabled.setLayoutData(traceEnabledData);
		EditingUtils.setID(traceEnabled, EsbViewsRepository.DefaultEndPoint.Basic.traceEnabled);
		EditingUtils.setEEFtype(traceEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control tracingEnabledHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Basic.traceEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTraceEnabledCheckbox
		traceEnabledTypeElements = new Control[] { traceEnabled, tracingEnabledHelp };
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createEndpointSuspendStateGroup(Composite parent) {
		endpointSuspendStateGroup = new Group(parent, SWT.NONE);
		endpointSuspendStateGroup.setText(EsbMessages.DefaultEndPointPropertiesEditionPart_EndpointSuspendStateGroupLabel);
		GridData endpointSuspendStateGroupData = new GridData(GridData.FILL_HORIZONTAL);
		endpointSuspendStateGroupData.horizontalSpan = 3;
		endpointSuspendStateGroup.setLayoutData(endpointSuspendStateGroupData);
		GridLayout endpointSuspendStateGroupLayout = new GridLayout();
		endpointSuspendStateGroupLayout.numColumns = 3;
		endpointSuspendStateGroup.setLayout(endpointSuspendStateGroupLayout);
		return endpointSuspendStateGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createSuspendErrorCodesText(Composite parent) {
	    Control suspendErrorCodesLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendErrorCodes, EsbMessages.DefaultEndPointPropertiesEditionPart_SuspendErrorCodesLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendErrorCodes.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendErrorCodes.getText()));
				}
			}

		});
		EditingUtils.setID(suspendErrorCodes, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendErrorCodes);
		EditingUtils.setEEFtype(suspendErrorCodes, "eef::Text"); //$NON-NLS-1$
		Control suspendErrorCodesHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendErrorCodes, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendErrorCodesText
		suspendErrorCodesTypeElements = new Control[] { suspendErrorCodesLabel, suspendErrorCodes, suspendErrorCodesHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createSuspendInitialDurationText(Composite parent) {
	    Control suspendInitialDurationLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendInitialDuration, EsbMessages.DefaultEndPointPropertiesEditionPart_SuspendInitialDurationLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendInitialDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendInitialDuration.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendInitialDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendInitialDuration.getText()));
				}
			}

		});
		EditingUtils.setID(suspendInitialDuration, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendInitialDuration);
		EditingUtils.setEEFtype(suspendInitialDuration, "eef::Text"); //$NON-NLS-1$
		Control suspendInitialDurationHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendInitialDuration, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendInitialDurationText
        suspendInitialDurationTypeElements = new Control[] { suspendInitialDurationLabel, suspendInitialDuration,
                suspendInitialDurationHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createSuspendMaximumDurationText(Composite parent) {
	    Control suspendMaximumDurationLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendMaximumDuration, EsbMessages.DefaultEndPointPropertiesEditionPart_SuspendMaximumDurationLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendMaximumDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendMaximumDuration.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendMaximumDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendMaximumDuration.getText()));
				}
			}

		});
		EditingUtils.setID(suspendMaximumDuration, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendMaximumDuration);
		EditingUtils.setEEFtype(suspendMaximumDuration, "eef::Text"); //$NON-NLS-1$
		Control suspendMaximumDurationHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendMaximumDuration, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendMaximumDurationText
        suspendMaxDurationTypeElements = new Control[] { suspendMaximumDurationLabel, suspendMaximumDuration,
                suspendMaximumDurationHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createSuspendProgressionFactorText(Composite parent) {
	    Control suspendProgressionFactorLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendProgressionFactor, EsbMessages.DefaultEndPointPropertiesEditionPart_SuspendProgressionFactorLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendProgressionFactor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendProgressionFactor.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendProgressionFactor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendProgressionFactor.getText()));
				}
			}

		});
		EditingUtils.setID(suspendProgressionFactor, EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendProgressionFactor);
		EditingUtils.setEEFtype(suspendProgressionFactor, "eef::Text"); //$NON-NLS-1$
		Control suspendProgressionFactorHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendProgressionFactor, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendProgressionFactorText
        suspendProgressionFactorTypeElements = new Control[] { suspendProgressionFactorLabel, suspendProgressionFactor,
                suspendProgressionFactorHelp };
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createEndpointTimeoutStateGroup(Composite parent) {
		endpointTimeoutStateGroup = new Group(parent, SWT.NONE);
		endpointTimeoutStateGroup.setText(EsbMessages.DefaultEndPointPropertiesEditionPart_EndpointTimeoutStateGroupLabel);
		GridData endpointTimeoutStateGroupData = new GridData(GridData.FILL_HORIZONTAL);
		endpointTimeoutStateGroupData.horizontalSpan = 3;
		endpointTimeoutStateGroup.setLayoutData(endpointTimeoutStateGroupData);
		GridLayout endpointTimeoutStateGroupLayout = new GridLayout();
		endpointTimeoutStateGroupLayout.numColumns = 3;
		endpointTimeoutStateGroup.setLayout(endpointTimeoutStateGroupLayout);
		return endpointTimeoutStateGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createRetryErrorCodesText(Composite parent) {
	    Control retryErrorCodesLabel =  createDescription(parent, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryErrorCodes, EsbMessages.DefaultEndPointPropertiesEditionPart_RetryErrorCodesLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryErrorCodes.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryErrorCodes.getText()));
				}
			}

		});
		EditingUtils.setID(retryErrorCodes, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryErrorCodes);
		EditingUtils.setEEFtype(retryErrorCodes, "eef::Text"); //$NON-NLS-1$
		Control retryErrorCodesHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryErrorCodes, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryErrorCodesText
		retryErrorCodesTypeElements = new Control[] { retryErrorCodesLabel, retryErrorCodes, retryErrorCodesHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createRetryCountText(Composite parent) {
	    Control retryCountLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryCount, EsbMessages.DefaultEndPointPropertiesEditionPart_RetryCountLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryCount.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryCount.getText()));
				}
			}

		});
		EditingUtils.setID(retryCount, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryCount);
		EditingUtils.setEEFtype(retryCount, "eef::Text"); //$NON-NLS-1$
		Control retryCountHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryCount, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryCountText
		retryCountTypeElements = new Control[] { retryCountLabel, retryCount, retryCountHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createRetryDelayText(Composite parent) {
	    Control retryDelayLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryDelay, EsbMessages.DefaultEndPointPropertiesEditionPart_RetryDelayLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryDelay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryDelay.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryDelay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryDelay.getText()));
				}
			}

		});
		EditingUtils.setID(retryDelay, EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryDelay);
		EditingUtils.setEEFtype(retryDelay, "eef::Text"); //$NON-NLS-1$
		Control retryDelayHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryDelay, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryDelayText
		retryDelayTypeElements = new Control[] { retryDelayLabel, retryDelay, retryDelayHelp };
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createMiscGroup(Composite parent) {
		miscGroup = new Group(parent, SWT.NONE);
		miscGroup.setText(EsbMessages.DefaultEndPointPropertiesEditionPart_MiscGroupLabel);
		GridData miscGroupData = new GridData(GridData.FILL_HORIZONTAL);
		miscGroupData.horizontalSpan = 3;
		miscGroup.setLayoutData(miscGroupData);
		GridLayout miscGroupLayout = new GridLayout();
		miscGroupLayout.numColumns = 3;
		miscGroup.setLayout(miscGroupLayout);
		return miscGroup;
	}

	/**
	 * @generated NOT
	 * 
	 */
	protected Composite createPropertiesAdvancedTableComposition(Composite parent) {
	    Control[] previousControls = miscGroup.getChildren();
		this.properties = new ReferencesTable(getDescription(EsbViewsRepository.DefaultEndPoint.Misc.properties, EsbMessages.DefaultEndPointPropertiesEditionPart_PropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				properties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				properties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				properties.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				properties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.propertiesFilters) {
			this.properties.addFilter(filter);
		}
		this.properties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Misc.properties, EsbViewsRepository.SWT_KIND));
		this.properties.createControls(parent);
		this.properties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Misc.properties, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData propertiesData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesData.horizontalSpan = 3;
		this.properties.setLayoutData(propertiesData);
		this.properties.setLowerBound(0);
		this.properties.setUpperBound(-1);
		properties.setID(EsbViewsRepository.DefaultEndPoint.Misc.properties);
		properties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPropertiesAdvancedTableComposition
		Control[] newControls = miscGroup.getChildren();
        propertiesTypeElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createOptimizeEMFComboViewer(Composite parent) {
	    Control optimizeLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.Misc.optimize, EsbMessages.DefaultEndPointPropertiesEditionPart_OptimizeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Misc.optimize, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOptimize()));
			}

		});
		optimize.setID(EsbViewsRepository.DefaultEndPoint.Misc.optimize);
		Control optimizeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Misc.optimize, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOptimizeEMFComboViewer
		optimizeTypeElements = new Control[] { optimizeLabel, optimize.getCombo(), optimizeHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createDescriptionText(Composite parent) {
	    Control descriptionLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.Misc.description, EsbMessages.DefaultEndPointPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.DefaultEndPoint.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Misc.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionTypeElements = new Control[] { descriptionLabel, description, descriptionHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createQoSGroup(Composite parent) {
		qoSGroup = new Group(parent, SWT.NONE);
		qoSGroup.setText(EsbMessages.DefaultEndPointPropertiesEditionPart_QoSGroupLabel);
		GridData qoSGroupData = new GridData(GridData.FILL_HORIZONTAL);
		qoSGroupData.horizontalSpan = 3;
		qoSGroup.setLayoutData(qoSGroupData);
		GridLayout qoSGroupLayout = new GridLayout();
		qoSGroupLayout.numColumns = 3;
		qoSGroup.setLayout(qoSGroupLayout);
		return qoSGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createReliableMessagingEnabledCheckbox(Composite parent) {
		reliableMessagingEnabled = new Button(parent, SWT.CHECK);
		reliableMessagingEnabled.setText(getDescription(EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingEnabled, EsbMessages.DefaultEndPointPropertiesEditionPart_ReliableMessagingEnabledLabel));
		reliableMessagingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reliableMessagingEnabled.getSelection())));
			}

		});
		GridData reliableMessagingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		reliableMessagingEnabledData.horizontalSpan = 2;
		reliableMessagingEnabled.setLayoutData(reliableMessagingEnabledData);
		EditingUtils.setID(reliableMessagingEnabled, EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingEnabled);
		EditingUtils.setEEFtype(reliableMessagingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control reliableMessagingEnabledHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReliableMessagingEnabledCheckbox
		reliableMegEnabledTypeElements = new Control[] { reliableMessagingEnabled, reliableMessagingEnabledHelp };
        reliableMessagingEnabled.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                refresh();
            }
        });
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createSecurityEnabledCheckbox(Composite parent) {
		securityEnabled = new Button(parent, SWT.CHECK);
		securityEnabled.setText(getDescription(EsbViewsRepository.DefaultEndPoint.QoS.securityEnabled, EsbMessages.DefaultEndPointPropertiesEditionPart_SecurityEnabledLabel));
		securityEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.QoS.securityEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(securityEnabled.getSelection())));
			}

		});
		GridData securityEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		securityEnabledData.horizontalSpan = 2;
		securityEnabled.setLayoutData(securityEnabledData);
		EditingUtils.setID(securityEnabled, EsbViewsRepository.DefaultEndPoint.QoS.securityEnabled);
		EditingUtils.setEEFtype(securityEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control securityEnabledHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.QoS.securityEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSecurityEnabledCheckbox
        securithEnabledTypeElements = new Control[] { securityEnabled, securityEnabledHelp };
        securityEnabled.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                refresh();
            }
        });
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createAddressingEnabledCheckbox(Composite parent) {
		addressingEnabled = new Button(parent, SWT.CHECK);
		addressingEnabled.setText(getDescription(EsbViewsRepository.DefaultEndPoint.QoS.addressingEnabled, EsbMessages.DefaultEndPointPropertiesEditionPart_AddressingEnabledLabel));
		addressingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.QoS.addressingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(addressingEnabled.getSelection())));
			}

		});
		GridData addressingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		addressingEnabledData.horizontalSpan = 2;
		addressingEnabled.setLayoutData(addressingEnabledData);
		EditingUtils.setID(addressingEnabled, EsbViewsRepository.DefaultEndPoint.QoS.addressingEnabled);
		EditingUtils.setEEFtype(addressingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control addressingEnabledHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.QoS.addressingEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingEnabledCheckbox
        addressingEnabledTypeElements = new Control[] { addressingEnabled, addressingEnabledHelp };
        addressingEnabled.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                refresh();
            }
        });
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createAddressingSeparateListenerCheckbox(Composite parent) {
	    addressingSeparateListener = new Button(parent, SWT.CHECK);
		addressingSeparateListener.setText(getDescription(EsbViewsRepository.DefaultEndPoint.QoS.addressingSeparateListener, EsbMessages.DefaultEndPointPropertiesEditionPart_AddressingSeparateListenerLabel));
		addressingSeparateListener.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.QoS.addressingSeparateListener, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(addressingSeparateListener.getSelection())));
			}

		});
		GridData addressingSeparateListenerData = new GridData(GridData.FILL_HORIZONTAL);
		addressingSeparateListenerData.horizontalSpan = 2;
		addressingSeparateListener.setLayoutData(addressingSeparateListenerData);
		EditingUtils.setID(addressingSeparateListener, EsbViewsRepository.DefaultEndPoint.QoS.addressingSeparateListener);
		EditingUtils.setEEFtype(addressingSeparateListener, "eef::Checkbox"); //$NON-NLS-1$
		Control addressingSeparateListenerHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.QoS.addressingSeparateListener, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingSeparateListenerCheckbox
		addressingSeperateListenerTypeElements = new Control[] { addressingSeparateListener, addressingSeparateListenerHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createAddressingVersionEMFComboViewer(Composite parent) {
	    Control addressingVersionLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.QoS.addressingVersion, EsbMessages.DefaultEndPointPropertiesEditionPart_AddressingVersionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.QoS.addressingVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAddressingVersion()));
			}

		});
		addressingVersion.setID(EsbViewsRepository.DefaultEndPoint.QoS.addressingVersion);
		Control addressingVersionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.QoS.addressingVersion, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingVersionEMFComboViewer
        addressingVersionTypeElements = new Control[] { addressingVersionLabel, addressingVersion.getCombo(),
                addressingVersionHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createTimeoutGroup(Composite parent) {
		timeoutGroup = new Group(parent, SWT.NONE);
		timeoutGroup.setText(EsbMessages.DefaultEndPointPropertiesEditionPart_TimeoutGroupLabel);
		GridData timeoutGroupData = new GridData(GridData.FILL_HORIZONTAL);
		timeoutGroupData.horizontalSpan = 3;
		timeoutGroup.setLayoutData(timeoutGroupData);
		GridLayout timeoutGroupLayout = new GridLayout();
		timeoutGroupLayout.numColumns = 3;
		timeoutGroup.setLayout(timeoutGroupLayout);
		return timeoutGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createTimeOutDurationText(Composite parent) {
	    Control timeOutDurationLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.Timeout.timeOutDuration, EsbMessages.DefaultEndPointPropertiesEditionPart_TimeOutDurationLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Timeout.timeOutDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, timeOutDuration.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Timeout.timeOutDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, timeOutDuration.getText()));
				}
			}

		});
		EditingUtils.setID(timeOutDuration, EsbViewsRepository.DefaultEndPoint.Timeout.timeOutDuration);
		EditingUtils.setEEFtype(timeOutDuration, "eef::Text"); //$NON-NLS-1$
		Control timeOutDurationHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Timeout.timeOutDuration, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTimeOutDurationText
		timeoutDurationTypeElements = new Control[] { timeOutDurationLabel, timeOutDuration, timeOutDurationHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createTimeOutActionEMFComboViewer(Composite parent) {
	    Control timeOutActionLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.Timeout.timeOutAction, EsbMessages.DefaultEndPointPropertiesEditionPart_TimeOutActionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.Timeout.timeOutAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTimeOutAction()));
			}

		});
		timeOutAction.setID(EsbViewsRepository.DefaultEndPoint.Timeout.timeOutAction);
		Control timeOutActionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.Timeout.timeOutAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTimeOutActionEMFComboViewer
		timeoutActionTypeElements = new Control[] { timeOutActionLabel, timeOutAction.getCombo(), timeOutActionHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createFailoverErrorCodesGroup(Composite parent) {
		failoverErrorCodesGroup = new Group(parent, SWT.NONE);
		failoverErrorCodesGroup.setText(EsbMessages.DefaultEndPointPropertiesEditionPart_FailoverErrorCodesGroupLabel);
		GridData failoverErrorCodesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		failoverErrorCodesGroupData.horizontalSpan = 3;
		failoverErrorCodesGroup.setLayoutData(failoverErrorCodesGroupData);
		GridLayout failoverErrorCodesGroupLayout = new GridLayout();
		failoverErrorCodesGroupLayout.numColumns = 3;
		failoverErrorCodesGroup.setLayout(failoverErrorCodesGroupLayout);
		return failoverErrorCodesGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createFailoverNonRetryErrorCodesText(Composite parent) {
	    Control failoverNonRetryErrorCodesLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes, EsbMessages.DefaultEndPointPropertiesEditionPart_FailoverNonRetryErrorCodesLabel);
		failoverNonRetryErrorCodes = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData failoverNonRetryErrorCodesData = new GridData(GridData.FILL_HORIZONTAL);
		failoverNonRetryErrorCodes.setLayoutData(failoverNonRetryErrorCodesData);
		failoverNonRetryErrorCodes.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failoverNonRetryErrorCodes.getText()));
			}

		});
		failoverNonRetryErrorCodes.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this, EsbViewsRepository.DefaultEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failoverNonRetryErrorCodes.getText()));
				}
			}

		});
		EditingUtils.setID(failoverNonRetryErrorCodes, EsbViewsRepository.DefaultEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes);
		EditingUtils.setEEFtype(failoverNonRetryErrorCodes, "eef::Text"); //$NON-NLS-1$
		Control failoverNonRetryErrorCodesHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DefaultEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFailoverNonRetryErrorCodesText
		failoverNonRetryErrorCodesElements = new Control[] { failoverNonRetryErrorCodesLabel, failoverNonRetryErrorCodes, failoverNonRetryErrorCodesHelp };
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Basic.commentsList);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Basic.endPointName);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Basic.anonymous);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Basic.inLine);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Basic.duplicate);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Basic.reversed);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Basic.format);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Basic.format);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#initTemplateParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTemplateParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		templateParameters.setContentProvider(contentProvider);
		templateParameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Basic.templateParameters);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Basic.statisticsEnabled);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Basic.traceEnabled);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendErrorCodes);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendInitialDuration);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendMaximumDuration);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.EndpointSuspendState.suspendProgressionFactor);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryErrorCodes);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryCount);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.EndpointTimeoutState.retryDelay);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#initProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		properties.setContentProvider(contentProvider);
		properties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Misc.properties);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Misc.optimize);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Misc.optimize);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Misc.description);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingEnabled);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.QoS.securityEnabled);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.QoS.addressingEnabled);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.QoS.addressingSeparateListener);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.QoS.addressingVersion);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.QoS.addressingVersion);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Timeout.timeOutDuration);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Timeout.timeOutAction);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.Timeout.timeOutAction);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#getFailoverNonRetryErrorCodes()
	 * 
	 */
	public String getFailoverNonRetryErrorCodes() {
		return failoverNonRetryErrorCodes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DefaultEndPointPropertiesEditionPart#setFailoverNonRetryErrorCodes(String newValue)
	 * 
	 */
	public void setFailoverNonRetryErrorCodes(String newValue) {
		if (newValue != null) {
			failoverNonRetryErrorCodes.setText(newValue);
		} else {
			failoverNonRetryErrorCodes.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DefaultEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes);
		if (eefElementEditorReadOnlyState && failoverNonRetryErrorCodes.isEnabled()) {
			failoverNonRetryErrorCodes.setEnabled(false);
			failoverNonRetryErrorCodes.setToolTipText(EsbMessages.DefaultEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !failoverNonRetryErrorCodes.isEnabled()) {
			failoverNonRetryErrorCodes.setEnabled(true);
		}	
		
	}






	// Start of user code for Reliable Messaging Policy specific getters and setters implementation
	@Override
	public RegistryKeyProperty getReliableMessagingPolicy() {
	    return reliableMessagingPolicy;
	}

	@Override
	public void setReliableMessagingPolicy(RegistryKeyProperty registryKeyProperty) {
	    if (registryKeyProperty != null) {
            reliableMessagingPolicyText.setText(registryKeyProperty.getKeyValue());
            reliableMessagingPolicy = registryKeyProperty;
        }
	}
	// End of user code

	// Start of user code for Security Policy specific getters and setters implementation
	@Override
	public RegistryKeyProperty getSecurityPolicy() {
	    return securityPolicy;
	}

	@Override
	public void setSecurityPolicy(RegistryKeyProperty registryKeyProperty) {
	    if (registryKeyProperty != null) {
            securityPolicyText.setText(registryKeyProperty.getKeyValue());
            securityPolicy = registryKeyProperty;
        }
	}
	// End of user code

	// Start of user code for Inbound Policy specific getters and setters implementation
	@Override
	public RegistryKeyProperty getInboundPolicy() {
	    return inboundPolicy;
	}

	@Override
	public void setInboundPolicy(RegistryKeyProperty registryKeyProperty) {
	    if (registryKeyProperty != null) {
            inboundPolicyText.setText(registryKeyProperty.getKeyValue());
            inboundPolicy = registryKeyProperty;
        }
	}
	// End of user code

	// Start of user code for Outbound Policy specific getters and setters implementation
	@Override
	public RegistryKeyProperty getOutboundPolicy() {
	    return outboundPolicy;
	}

	@Override
	public void setOutboundPolicy(RegistryKeyProperty registryKeyProperty) {
	    if (registryKeyProperty != null) {
            outboundPolicyText.setText(registryKeyProperty.getKeyValue());
            outboundPolicy = registryKeyProperty;
        }
	}
	// End of user code

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
	   protected Composite createReliableMessagingPolicy(Composite parent) {
	        Control reliableMessagingPolicyLabel = createDescription(parent,
	                EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingPolicy,
	                EsbMessages.DefaultEndPointPropertiesEditionPart_ReliableMessagingPolicyLabel);
	        if (reliableMessagingPolicy == null) {
	            reliableMessagingPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initValueExpression = reliableMessagingPolicy.getKeyValue().isEmpty() ? ""
	                : reliableMessagingPolicy.getKeyValue();
	        reliableMessagingPolicyText = SWTUtils.createScrollableText(parent, SWT.READ_ONLY);
	        reliableMessagingPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        reliableMessagingPolicyText.setLayoutData(valueData);
	        
	        reliableMessagingPolicyText.addMouseListener(new MouseListener() {
	            
	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
	                        SWT.NULL, reliableMessagingPolicy, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                reliableMessagingPolicyText.setText(reliableMessagingPolicy.getKeyValue());
	                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
	                        DefaultEndPointPropertiesEditionPartImpl.this,
	                        EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy, PropertiesEditionEvent.COMMIT,
	                        PropertiesEditionEvent.SET, null, getReliableMessagingPolicy()));
	            }
	            
	            @Override
	            public void mouseUp(MouseEvent e) {}
	            
	            @Override
	            public void mouseDoubleClick(MouseEvent e) {}
	            
	        });
	        
	        reliableMessagingPolicyText.addKeyListener(new KeyListener() {
	            
	            @Override
	            public void keyReleased(KeyEvent e) {
	                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
	                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
	                            SWT.NULL, reliableMessagingPolicy, new ArrayList<NamedEntityDescriptor>());
	                    dialog.open();
	                    reliableMessagingPolicyText.setText(reliableMessagingPolicy.getKeyValue());
	                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
	                            DefaultEndPointPropertiesEditionPartImpl.this,
	                            EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy, PropertiesEditionEvent.COMMIT,
	                            PropertiesEditionEvent.SET, null, getReliableMessagingPolicy()));
	                }
	            }
	            
	            @Override
	            public void keyPressed(KeyEvent e) {}
	            
	        });
	        
	        EditingUtils.setID(reliableMessagingPolicyText, EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingPolicy);
	        EditingUtils.setEEFtype(reliableMessagingPolicyText, "eef::Text");
	        Control reliableMessagingPolicyHelp = SWTUtils.createHelpButton(parent,
	                propertiesEditionComponent.getHelpContent(
	                        EsbViewsRepository.DefaultEndPoint.QoS.reliableMessagingPolicy, EsbViewsRepository.FORM_KIND),
	                null); // $NON-NLS-1$
	        reliablePolicyTypeElements = new Control[] { reliableMessagingPolicyLabel, reliableMessagingPolicyText,
	                reliableMessagingPolicyHelp };
	        return parent;
	    }

	    protected Composite createInboundPolicy(Composite parent) {
	        Control inboundPolicyLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.QoS.inboundPolicy,
	                EsbMessages.DefaultEndPointPropertiesEditionPart_InboundPolicyLabel);
	        if (inboundPolicy == null) {
	            inboundPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        inboundPolicyText = SWTUtils.createScrollableText(parent, SWT.READ_ONLY);
	        inboundPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        inboundPolicyText.setLayoutData(valueData);
	        
	        inboundPolicyText.addMouseListener(new MouseListener() {
	            
	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
	                        SWT.NULL, inboundPolicy, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                inboundPolicyText.setText(inboundPolicy.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this,
	                                EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getInboundPolicy()));
	            }
	            
	            @Override
	            public void mouseUp(MouseEvent e) {}
	            
	            @Override
	            public void mouseDoubleClick(MouseEvent e) {}
	            
	        });
	        
	        inboundPolicyText.addKeyListener(new KeyListener() {
	            
	            @Override
	            public void keyReleased(KeyEvent e) {
	                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
	                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
	                            SWT.NULL, inboundPolicy, new ArrayList<NamedEntityDescriptor>());
	                    dialog.open();
	                    inboundPolicyText.setText(inboundPolicy.getKeyValue());
	                    propertiesEditionComponent
	                            .firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this,
	                                    EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy, PropertiesEditionEvent.COMMIT,
	                                    PropertiesEditionEvent.SET, null, getInboundPolicy()));
	                }
	            }
	            
	            @Override
	            public void keyPressed(KeyEvent e) {}
	            
	        });
	        
	        EditingUtils.setID(inboundPolicyText, EsbViewsRepository.DefaultEndPoint.QoS.inboundPolicy);
	        EditingUtils.setEEFtype(inboundPolicyText, "eef::Text");
	        Control inboundPolicyHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent
	                .getHelpContent(EsbViewsRepository.DefaultEndPoint.QoS.inboundPolicy, EsbViewsRepository.FORM_KIND),
	                null); // $NON-NLS-1$
	        inboundPolicyTypeElements = new Control[] { inboundPolicyLabel, inboundPolicyText, inboundPolicyHelp };
	        return parent;
	    }

	    protected Composite createOutboundPolicy(Composite parent) {
	        Control outboundPolicyLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.QoS.outboundPolicy,
	                EsbMessages.DefaultEndPointPropertiesEditionPart_OutboundPolicyLabel);
	        if (outboundPolicy == null) {
	            outboundPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        outboundPolicyText = SWTUtils.createScrollableText(parent, SWT.READ_ONLY);
	        outboundPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        outboundPolicyText.setLayoutData(valueData);
	        
	        outboundPolicyText.addMouseListener(new MouseListener() {
	            
	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
	                        SWT.NULL, outboundPolicy, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                outboundPolicyText.setText(outboundPolicy.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this,
	                                EsbViewsRepository.DefaultEndPoint.QoS.outboundPolicy, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getOutboundPolicy()));
	            }
	            
	            @Override
	            public void mouseUp(MouseEvent e) {}
	            
	            @Override
	            public void mouseDoubleClick(MouseEvent e) {}
	            
	        });
	        
	        outboundPolicyText.addKeyListener(new KeyListener() {
	            
	            @Override
	            public void keyReleased(KeyEvent e) {
	                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
	                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
	                            SWT.NULL, outboundPolicy, new ArrayList<NamedEntityDescriptor>());
	                    dialog.open();
	                    outboundPolicyText.setText(outboundPolicy.getKeyValue());
	                    propertiesEditionComponent
	                            .firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this,
	                                    EsbViewsRepository.DefaultEndPoint.QoS.outboundPolicy, PropertiesEditionEvent.COMMIT,
	                                    PropertiesEditionEvent.SET, null, getOutboundPolicy()));
	                }
	            }
	            
	            @Override
	            public void keyPressed(KeyEvent e) {}
	            
	        });
	        
	        EditingUtils.setID(outboundPolicyText, EsbViewsRepository.DefaultEndPoint.QoS.outboundPolicy);
	        EditingUtils.setEEFtype(outboundPolicyText, "eef::Text");
	        Control outboundPolicyHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent
	                .getHelpContent(EsbViewsRepository.DefaultEndPoint.QoS.outboundPolicy, EsbViewsRepository.FORM_KIND),
	                null); // $NON-NLS-1$
	        outboundPolicyTypeElements = new Control[] { outboundPolicyLabel, outboundPolicyText, outboundPolicyHelp };
	        return parent;
	    }

	    protected Composite createSecurityPolicy(Composite parent) {
	        Control securityPolicyLabel = createDescription(parent, EsbViewsRepository.DefaultEndPoint.QoS.securityPolicy,
	                EsbMessages.DefaultEndPointPropertiesEditionPart_SecurityPolicyLabel);
	        if (securityPolicy == null) {
	            securityPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        securityPolicyText = SWTUtils.createScrollableText(parent, SWT.READ_ONLY);
	        securityPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        securityPolicyText.setLayoutData(valueData);
	        
	        securityPolicyText.addMouseListener(new MouseListener() {
	            
	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
	                        SWT.NULL, securityPolicy, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                securityPolicyText.setText(securityPolicy.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this,
	                                EsbViewsRepository.DefaultEndPoint.QoS.securityPolicy, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getSecurityPolicy()));
	            }
	            
	            @Override
	            public void mouseUp(MouseEvent e) {}
	            
	            @Override
	            public void mouseDoubleClick(MouseEvent e) {}
	            
	        });
	        
	        securityPolicyText.addKeyListener(new KeyListener() {
	            
	            @Override
	            public void keyReleased(KeyEvent e) {
	                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
	                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
	                            SWT.NULL, securityPolicy, new ArrayList<NamedEntityDescriptor>());
	                    dialog.open();
	                    securityPolicyText.setText(securityPolicy.getKeyValue());
	                    propertiesEditionComponent
	                            .firePropertiesChanged(new PropertiesEditionEvent(DefaultEndPointPropertiesEditionPartImpl.this,
	                                    EsbViewsRepository.DefaultEndPoint.QoS.securityPolicy, PropertiesEditionEvent.COMMIT,
	                                    PropertiesEditionEvent.SET, null, getSecurityPolicy()));
	                }
	            }
	            
	            @Override
	            public void keyPressed(KeyEvent e) {}
	            
	        });
	        
	        EditingUtils.setID(securityPolicyText, EsbViewsRepository.DefaultEndPoint.QoS.securityPolicy);
	        EditingUtils.setEEFtype(securityPolicyText, "eef::Text");
	        Control securityPolicyHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent
	                .getHelpContent(EsbViewsRepository.DefaultEndPoint.QoS.securityPolicy, EsbViewsRepository.FORM_KIND),
	                null); // $NON-NLS-1$
	        securityPolicyTypeElements = new Control[] { securityPolicyLabel, securityPolicyText, securityPolicyHelp };
	        return parent;
	    }

	    @Override
	    public void refresh() {
	        super.refresh();
	        validate();
	    }

	    EEFPropertyViewUtil viewUtil = new EEFPropertyViewUtil(view);

	    public void validate() {

	        viewUtil.clearElements(new Composite[] { basicGroup, endpointSuspendStateGroup, endpointTimeoutStateGroup,
	                miscGroup, qoSGroup, timeoutGroup, failoverErrorCodesGroup });

	        viewUtil.showEntry(inlineTypeElements, false);
	        viewUtil.showEntry(formatTypeElements, false);
	        viewUtil.showEntry(traceEnabledTypeElements, false);
	        viewUtil.showEntry(statEnabledTypeElements, false);
	        viewUtil.showEntry(suspendErrorCodesTypeElements, false);
	        viewUtil.showEntry(suspendInitialDurationTypeElements, false);
	        viewUtil.showEntry(suspendMaxDurationTypeElements, false);
	        viewUtil.showEntry(suspendProgressionFactorTypeElements, false);
	        viewUtil.showEntry(retryErrorCodesTypeElements, false);
	        viewUtil.showEntry(retryCountTypeElements, false);
	        viewUtil.showEntry(retryDelayTypeElements, false);
	        viewUtil.showEntry(propertiesTypeElements, false);
	        viewUtil.showEntry(optimizeTypeElements, false);
	        viewUtil.showEntry(descriptionTypeElements, false);
	        viewUtil.showEntry(reliableMegEnabledTypeElements, false);
	        if (reliableMessagingEnabled.getSelection()) {
	            viewUtil.showEntry(reliablePolicyTypeElements, false);
	        }
	        viewUtil.showEntry(securithEnabledTypeElements, false);
	        if (securityEnabled.getSelection()) {
	            viewUtil.showEntry(securityPolicyTypeElements, false);
	            viewUtil.showEntry(inboundPolicyTypeElements, false);
	            viewUtil.showEntry(outboundPolicyTypeElements, false);
	        }
	        viewUtil.showEntry(addressingEnabledTypeElements, false);
	        if (addressingEnabled.getSelection()) {
	            viewUtil.showEntry(addressingVersionTypeElements, false);
	            viewUtil.showEntry(addressingSeperateListenerTypeElements, false);
	        }
	        viewUtil.showEntry(timeoutDurationTypeElements, false);
	        viewUtil.showEntry(timeoutActionTypeElements, false);
	        
	        viewUtil.showEntry(failoverNonRetryErrorCodesElements, false);

	        view.layout(true, true);
	    }
	// End of user code


}
