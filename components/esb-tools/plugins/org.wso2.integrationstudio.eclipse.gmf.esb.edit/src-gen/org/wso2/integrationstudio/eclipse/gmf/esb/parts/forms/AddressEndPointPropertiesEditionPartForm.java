/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EcoreAdapterFactory;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

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
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointFailoverRetryType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class AddressEndPointPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, AddressEndPointPropertiesEditionPart {

	private static final String DEFAULT_FAILOVER_ERROR_CODES = "101507,101504";
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
	protected Text uRI;
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
	protected EMFComboViewer addressingVersion;
	protected Button addressingSeparateListener;
	// Start of user code  for Reliable Messaging Policy widgets declarations
	protected RegistryKeyProperty reliableMessagingPolicy;
    protected Text reliableMessagingPolicyText;
	// End of user code

	// Start of user code  for Inbound Policy widgets declarations
    protected RegistryKeyProperty inboundPolicy;
    protected Text inboundPolicyText;
	// End of user code

	// Start of user code  for Outbound Policy widgets declarations
    protected RegistryKeyProperty outboundPolicy;
    protected Text outboundPolicyText;
	// End of user code

	// Start of user code  for Security Policy widgets declarations
    protected RegistryKeyProperty securityPolicy;
    protected Text securityPolicyText;
    
	protected Control[] inlineTypeElements;
    protected Control[] formatTypeElements;
    protected Control[] traceEnabledTypeElements;
    protected Control[] statEnabledTypeElements;
    protected Control[] uriTypeElements;
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
 
    protected Composite basicGroup;
    protected Composite endpointSuspendStateGroup;
    protected Composite endpointTimeoutStateGroup;
    protected Composite miscGroup;
    protected Composite qoSGroup;
    protected Composite timeoutGroup;
    protected Composite failoverErrorCodesGroup;
    
    protected GridData propertiesData;
    
    protected Composite filterAdvancedSubPropertiesGroup;
    
    protected EMFComboViewer failoverType;
    protected Text failoverRetryErrorCodes;
    protected Text failoverNonRetryErrorCodes;
    
    protected Control[] failoverTypeElements;
    protected Control[] failoverRetryErrorCodesElements;
    protected Control[] failoverNonRetryErrorCodesElements;
    
	// End of user code

	protected Text timeOutDuration;
	protected EMFComboViewer timeOutAction;

  /**
	 * For {@link ISection} use only.
	 */
	public AddressEndPointPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AddressEndPointPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		Form form = widgetFactory.createForm(parent);
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return form;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence addressEndPointStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep basicStep = addressEndPointStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.class);
		basicStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.commentsList);
		basicStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.endPointName);
		basicStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.anonymous);
		basicStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.inLine);
		basicStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.duplicate);
		basicStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.reversed);
		basicStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.format);
		basicStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.templateParameters);
		basicStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled);
		basicStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.traceEnabled);
		basicStep.addStep(EsbViewsRepository.AddressEndPoint.Basic.uRI);
		
		CompositionStep endpointSuspendStateStep = addressEndPointStep.addStep(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.class);
		endpointSuspendStateStep.addStep(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes);
		endpointSuspendStateStep.addStep(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration);
		endpointSuspendStateStep.addStep(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration);
		endpointSuspendStateStep.addStep(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor);
		
		CompositionStep endpointTimeoutStateStep = addressEndPointStep.addStep(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.class);
		endpointTimeoutStateStep.addStep(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes);
		endpointTimeoutStateStep.addStep(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount);
		endpointTimeoutStateStep.addStep(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay);
		
		CompositionStep qoSStep = addressEndPointStep.addStep(EsbViewsRepository.AddressEndPoint.QoS.class);
		qoSStep.addStep(EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled);
		qoSStep.addStep(EsbViewsRepository.AddressEndPoint.QoS.securityEnabled);
		qoSStep.addStep(EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled);
		qoSStep.addStep(EsbViewsRepository.AddressEndPoint.QoS.addressingVersion);
		qoSStep.addStep(EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener);
		qoSStep.addStep(EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy);
		qoSStep.addStep(EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy);
		qoSStep.addStep(EsbViewsRepository.AddressEndPoint.QoS.outboundPolicy);
		qoSStep.addStep(EsbViewsRepository.AddressEndPoint.QoS.securityPolicy);
		
		CompositionStep timeoutStep = addressEndPointStep.addStep(EsbViewsRepository.AddressEndPoint.Timeout.class);
		timeoutStep.addStep(EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration);
		timeoutStep.addStep(EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction);
		
        CompositionStep miscStep = addressEndPointStep.addStep(EsbViewsRepository.AddressEndPoint.Misc.class);
        miscStep.addStep(EsbViewsRepository.AddressEndPoint.Misc.properties);
        miscStep.addStep(EsbViewsRepository.AddressEndPoint.Misc.optimize);
        miscStep.addStep(EsbViewsRepository.AddressEndPoint.Misc.description);
		
        CompositionStep failoverStep = addressEndPointStep.addStep(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.class);
        failoverStep.addStep(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType);
        failoverStep.addStep(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes);
        failoverStep.addStep(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes);
        
		composer = new PartComposer(addressEndPointStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
			    // Start of user code
				if (key == EsbViewsRepository.AddressEndPoint.Basic.class) {
					return createBasicGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Basic.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Basic.endPointName) {
					return createEndPointNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Basic.anonymous) {
					return createAnonymousCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Basic.inLine) {
					return createInLineCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Basic.duplicate) {
					return createDuplicateCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Basic.reversed) {
					return createReversedCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Basic.format) {
					return createFormatEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Basic.templateParameters) {
					return createTemplateParametersTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled) {
					return createStatisticsEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Basic.traceEnabled) {
					return createTraceEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Basic.uRI) {
					return createURIText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.EndpointSuspendState.class) {
					return createEndpointSuspendStateGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes) {
					return createSuspendErrorCodesText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration) {
					return createSuspendInitialDurationText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration) {
					return createSuspendMaximumDurationText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor) {
					return createSuspendProgressionFactorText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.class) {
					return createEndpointTimeoutStateGroup(widgetFactory, filterAdvancedSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes) {
					return createRetryErrorCodesText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount) {
					return createRetryCountText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay) {
					return createRetryDelayText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Misc.class) {
					return createMiscGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Misc.properties) {
					return createPropertiesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Misc.optimize) {
					return createOptimizeEMFComboViewer(widgetFactory, filterAdvancedSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Misc.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.QoS.class) {
					return createQoSGroup(widgetFactory, filterAdvancedSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled) {
					return createReliableMessagingEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.QoS.securityEnabled) {
					return createSecurityEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled) {
					return createAddressingEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.QoS.addressingVersion) {
					return createAddressingVersionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener) {
					return createAddressingSeparateListenerCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy) {
					return createReliableMessagingPolicy(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy) {
					return createInboundPolicy(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.QoS.outboundPolicy) {
					return createOutboundPolicy(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.QoS.securityPolicy) {
					return createSecurityPolicy(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Timeout.class) {
					return createTimeoutGroup(widgetFactory, filterAdvancedSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration) {
					return createTimeOutDurationText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction) {
					return createTimeOutActionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.class) {
                    return createFailoverErrorCodesGroup(widgetFactory, filterAdvancedSubPropertiesGroup);
                }
				if (key == EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType) {
                    return createFailoverTypeEMFComboViewer(widgetFactory, parent);
                }
				if (key == EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes) {
                    return createFailoverRetryErrorCodesText(widgetFactory, parent);
                }
				if (key == EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes) {
                    return createFailoverNonRetryErrorCodesText(widgetFactory, parent);
                }
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}
	
	/**
     * @generated NOT
     */
	protected Composite createBasicGroup(FormToolkit widgetFactory, final Composite parent) {
		Section basicSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		basicSection.setText(EsbMessages.AddressEndPointPropertiesEditionPart_BasicGroupLabel);
		GridData basicSectionData = new GridData(GridData.FILL_HORIZONTAL);
		basicSectionData.horizontalSpan = 3;
		basicSection.setLayoutData(basicSectionData);
		basicGroup = widgetFactory.createComposite(basicSection);
		GridLayout basicGroupLayout = new GridLayout();
		basicGroupLayout.numColumns = 3;
		basicGroup.setLayout(basicGroupLayout);
		basicSection.setClient(basicGroup);
		return basicGroup;
	}

	/**
	 * 
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.AddressEndPoint.Basic.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AddressEndPoint.Basic.commentsList, EsbMessages.AddressEndPointPropertiesEditionPart_CommentsListLabel), SWT.NONE);
		GridData editCommentsListData = new GridData();
		editCommentsList.setLayoutData(editCommentsListData);
		editCommentsList.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						commentsList.getShell(), "AddressEndPoint", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.AddressEndPoint.Basic.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createEndPointNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.AddressEndPoint.Basic.endPointName, EsbMessages.AddressEndPointPropertiesEditionPart_EndPointNameLabel);
		endPointName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		endPointName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData endPointNameData = new GridData(GridData.FILL_HORIZONTAL);
		endPointName.setLayoutData(endPointNameData);
		endPointName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AddressEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.AddressEndPoint.Basic.endPointName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.AddressEndPoint.Basic.endPointName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, endPointName.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		endPointName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.endPointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
				}
			}
		});
		EditingUtils.setID(endPointName, EsbViewsRepository.AddressEndPoint.Basic.endPointName);
		EditingUtils.setEEFtype(endPointName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Basic.endPointName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndPointNameText

		// End of user code
		return parent;
	}

	
	protected Composite createAnonymousCheckbox(FormToolkit widgetFactory, Composite parent) {
		anonymous = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AddressEndPoint.Basic.anonymous, EsbMessages.AddressEndPointPropertiesEditionPart_AnonymousLabel), SWT.CHECK);
		anonymous.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.anonymous, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(anonymous.getSelection())));
			}

		});
		GridData anonymousData = new GridData(GridData.FILL_HORIZONTAL);
		anonymousData.horizontalSpan = 2;
		anonymous.setLayoutData(anonymousData);
		EditingUtils.setID(anonymous, EsbViewsRepository.AddressEndPoint.Basic.anonymous);
		EditingUtils.setEEFtype(anonymous, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Basic.anonymous, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAnonymousCheckbox

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createInLineCheckbox(FormToolkit widgetFactory, Composite parent) {
		inLine = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AddressEndPoint.Basic.inLine, EsbMessages.AddressEndPointPropertiesEditionPart_InLineLabel), SWT.CHECK);
		inLine.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.inLine, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(inLine.getSelection())));
			}

		});
		GridData inLineData = new GridData(GridData.FILL_HORIZONTAL);
		inLineData.horizontalSpan = 2;
		inLine.setLayoutData(inLineData);
		EditingUtils.setID(inLine, EsbViewsRepository.AddressEndPoint.Basic.inLine);
		EditingUtils.setEEFtype(inLine, "eef::Checkbox"); //$NON-NLS-1$
		Control inlineHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Basic.inLine, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInLineCheckbox
		inlineTypeElements = new Control[] { inLine, inlineHelp };
		// End of user code
		return parent;
	}

	
	protected Composite createDuplicateCheckbox(FormToolkit widgetFactory, Composite parent) {
		duplicate = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AddressEndPoint.Basic.duplicate, EsbMessages.AddressEndPointPropertiesEditionPart_DuplicateLabel), SWT.CHECK);
		duplicate.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.duplicate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(duplicate.getSelection())));
			}

		});
		GridData duplicateData = new GridData(GridData.FILL_HORIZONTAL);
		duplicateData.horizontalSpan = 2;
		duplicate.setLayoutData(duplicateData);
		EditingUtils.setID(duplicate, EsbViewsRepository.AddressEndPoint.Basic.duplicate);
		EditingUtils.setEEFtype(duplicate, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Basic.duplicate, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDuplicateCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createReversedCheckbox(FormToolkit widgetFactory, Composite parent) {
		reversed = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AddressEndPoint.Basic.reversed, EsbMessages.AddressEndPointPropertiesEditionPart_ReversedLabel), SWT.CHECK);
		reversed.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.reversed, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reversed.getSelection())));
			}

		});
		GridData reversedData = new GridData(GridData.FILL_HORIZONTAL);
		reversedData.horizontalSpan = 2;
		reversed.setLayoutData(reversedData);
		EditingUtils.setID(reversed, EsbViewsRepository.AddressEndPoint.Basic.reversed);
		EditingUtils.setEEFtype(reversed, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Basic.reversed, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReversedCheckbox

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createFormatEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control formatLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.Basic.format, EsbMessages.AddressEndPointPropertiesEditionPart_FormatLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.format, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFormat()));
			}

		});
		format.setID(EsbViewsRepository.AddressEndPoint.Basic.format);
		Control formatHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Basic.format, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFormatEMFComboViewer
		formatTypeElements = new Control[] { formatLabel, format.getCombo(), formatHelp };
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTemplateParametersTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.templateParameters = new ReferencesTable(getDescription(EsbViewsRepository.AddressEndPoint.Basic.templateParameters, EsbMessages.AddressEndPointPropertiesEditionPart_TemplateParametersLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				templateParameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				templateParameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				templateParameters.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				templateParameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.templateParametersFilters) {
			this.templateParameters.addFilter(filter);
		}
		this.templateParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Basic.templateParameters, EsbViewsRepository.FORM_KIND));
		this.templateParameters.createControls(parent, widgetFactory);
		this.templateParameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.templateParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData templateParametersData = new GridData(GridData.FILL_HORIZONTAL);
		templateParametersData.horizontalSpan = 3;
		this.templateParameters.setLayoutData(templateParametersData);
		this.templateParameters.setLowerBound(0);
		this.templateParameters.setUpperBound(-1);
		templateParameters.setID(EsbViewsRepository.AddressEndPoint.Basic.templateParameters);
		templateParameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTemplateParametersTableComposition

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createStatisticsEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		statisticsEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled, EsbMessages.AddressEndPointPropertiesEditionPart_StatisticsEnabledLabel), SWT.CHECK);
		statisticsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statisticsEnabled.getSelection())));
			}

		});
		GridData statisticsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		statisticsEnabledData.horizontalSpan = 2;
		statisticsEnabled.setLayoutData(statisticsEnabledData);
		EditingUtils.setID(statisticsEnabled, EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled);
		EditingUtils.setEEFtype(statisticsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control statEnableHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatisticsEnabledCheckbox
		statEnabledTypeElements = new Control[] { statisticsEnabled, statEnableHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createTraceEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		traceEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AddressEndPoint.Basic.traceEnabled, EsbMessages.AddressEndPointPropertiesEditionPart_TraceEnabledLabel), SWT.CHECK);
		traceEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.traceEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(traceEnabled.getSelection())));
			}

		});
		GridData traceEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		traceEnabledData.horizontalSpan = 2;
		traceEnabled.setLayoutData(traceEnabledData);
		EditingUtils.setID(traceEnabled, EsbViewsRepository.AddressEndPoint.Basic.traceEnabled);
		EditingUtils.setEEFtype(traceEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control tracingEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Basic.traceEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTraceEnabledCheckbox
		traceEnabledTypeElements = new Control[] { traceEnabled, tracingEnabledHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createURIText(FormToolkit widgetFactory, Composite parent) {
		Control URILabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.Basic.uRI, EsbMessages.AddressEndPointPropertiesEditionPart_URILabel);
		uRI = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		uRI.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData uRIData = new GridData(GridData.FILL_HORIZONTAL);
		uRI.setLayoutData(uRIData);
		uRI.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AddressEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.AddressEndPoint.Basic.uRI,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, uRI.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.AddressEndPoint.Basic.uRI,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, uRI.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		uRI.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Basic.uRI, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, uRI.getText()));
				}
			}
		});
		EditingUtils.setID(uRI, EsbViewsRepository.AddressEndPoint.Basic.uRI);
		EditingUtils.setEEFtype(uRI, "eef::Text"); //$NON-NLS-1$
		Control URIHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Basic.uRI, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createURIText
		uriTypeElements = new Control[] { URILabel, uRI, URIHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createEndpointSuspendStateGroup(FormToolkit widgetFactory, final Composite parent) {
	    filterAdvancedSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Advanced", false);
	    
		Section endpointSuspendStateSection = widgetFactory.createSection(filterAdvancedSubPropertiesGroup, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		endpointSuspendStateSection.setText(EsbMessages.AddressEndPointPropertiesEditionPart_EndpointSuspendStateGroupLabel);
		GridData endpointSuspendStateSectionData = new GridData(GridData.FILL_HORIZONTAL);
		endpointSuspendStateSectionData.horizontalSpan = 3;
		endpointSuspendStateSection.setLayoutData(endpointSuspendStateSectionData);
		endpointSuspendStateGroup = widgetFactory.createComposite(endpointSuspendStateSection);
		GridLayout endpointSuspendStateGroupLayout = new GridLayout();
		endpointSuspendStateGroupLayout.numColumns = 3;
		endpointSuspendStateGroup.setLayout(endpointSuspendStateGroupLayout);
		endpointSuspendStateSection.setClient(endpointSuspendStateGroup);
		return endpointSuspendStateGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createSuspendErrorCodesText(FormToolkit widgetFactory, Composite parent) {
		Control suspendErrorCodesLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes, EsbMessages.AddressEndPointPropertiesEditionPart_SuspendErrorCodesLabel);
		suspendErrorCodes = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		suspendErrorCodes.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData suspendErrorCodesData = new GridData(GridData.FILL_HORIZONTAL);
		suspendErrorCodes.setLayoutData(suspendErrorCodesData);
		suspendErrorCodes.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AddressEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendErrorCodes.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, suspendErrorCodes.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		suspendErrorCodes.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendErrorCodes.getText()));
				}
			}
		});
		EditingUtils.setID(suspendErrorCodes, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes);
		EditingUtils.setEEFtype(suspendErrorCodes, "eef::Text"); //$NON-NLS-1$
		Control suspendErrorCodesHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendErrorCodesText
		suspendErrorCodesTypeElements = new Control[] { suspendErrorCodesLabel, suspendErrorCodes, suspendErrorCodesHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createSuspendInitialDurationText(FormToolkit widgetFactory, Composite parent) {
		Control suspendInitialDurationLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration, EsbMessages.AddressEndPointPropertiesEditionPart_SuspendInitialDurationLabel);
		suspendInitialDuration = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		suspendInitialDuration.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData suspendInitialDurationData = new GridData(GridData.FILL_HORIZONTAL);
		suspendInitialDuration.setLayoutData(suspendInitialDurationData);
		suspendInitialDuration.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AddressEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendInitialDuration.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, suspendInitialDuration.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		suspendInitialDuration.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendInitialDuration.getText()));
				}
			}
		});
		EditingUtils.setID(suspendInitialDuration, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration);
		EditingUtils.setEEFtype(suspendInitialDuration, "eef::Text"); //$NON-NLS-1$
		Control suspendInitialDurationHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendInitialDurationText
		suspendInitialDurationTypeElements = new Control[] { suspendInitialDurationLabel, suspendInitialDuration,
				suspendInitialDurationHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createSuspendMaximumDurationText(FormToolkit widgetFactory, Composite parent) {
		Control suspendMaximumDurationLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration, EsbMessages.AddressEndPointPropertiesEditionPart_SuspendMaximumDurationLabel);
		suspendMaximumDuration = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		suspendMaximumDuration.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData suspendMaximumDurationData = new GridData(GridData.FILL_HORIZONTAL);
		suspendMaximumDuration.setLayoutData(suspendMaximumDurationData);
		suspendMaximumDuration.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AddressEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendMaximumDuration.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, suspendMaximumDuration.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		suspendMaximumDuration.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendMaximumDuration.getText()));
				}
			}
		});
		EditingUtils.setID(suspendMaximumDuration, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration);
		EditingUtils.setEEFtype(suspendMaximumDuration, "eef::Text"); //$NON-NLS-1$
		Control suspendMaximumDurationHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendMaximumDurationText
		suspendMaxDurationTypeElements = new Control[] { suspendMaximumDurationLabel, suspendMaximumDuration,
				suspendMaximumDurationHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createSuspendProgressionFactorText(FormToolkit widgetFactory, Composite parent) {
		Control suspendProgressionFactorLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor, EsbMessages.AddressEndPointPropertiesEditionPart_SuspendProgressionFactorLabel);
		suspendProgressionFactor = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		suspendProgressionFactor.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData suspendProgressionFactorData = new GridData(GridData.FILL_HORIZONTAL);
		suspendProgressionFactor.setLayoutData(suspendProgressionFactorData);
		suspendProgressionFactor.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AddressEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendProgressionFactor.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, suspendProgressionFactor.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		suspendProgressionFactor.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendProgressionFactor.getText()));
				}
			}
		});
		EditingUtils.setID(suspendProgressionFactor, EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor);
		EditingUtils.setEEFtype(suspendProgressionFactor, "eef::Text"); //$NON-NLS-1$
		Control suspendProgressionFactorHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendProgressionFactorText
		suspendProgressionFactorTypeElements = new Control[] { suspendProgressionFactorLabel, suspendProgressionFactor,
				suspendProgressionFactorHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createEndpointTimeoutStateGroup(FormToolkit widgetFactory, final Composite parent) {
		Section endpointTimeoutStateSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		endpointTimeoutStateSection.setText(EsbMessages.AddressEndPointPropertiesEditionPart_EndpointTimeoutStateGroupLabel);
		GridData endpointTimeoutStateSectionData = new GridData(GridData.FILL_HORIZONTAL);
		endpointTimeoutStateSectionData.horizontalSpan = 3;
		endpointTimeoutStateSection.setLayoutData(endpointTimeoutStateSectionData);
		endpointTimeoutStateGroup = widgetFactory.createComposite(endpointTimeoutStateSection);
		GridLayout endpointTimeoutStateGroupLayout = new GridLayout();
		endpointTimeoutStateGroupLayout.numColumns = 3;
		endpointTimeoutStateGroup.setLayout(endpointTimeoutStateGroupLayout);
		endpointTimeoutStateSection.setClient(endpointTimeoutStateGroup);
		return endpointTimeoutStateGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createRetryErrorCodesText(FormToolkit widgetFactory, Composite parent) {
		Control retryErrorCodesLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes, EsbMessages.AddressEndPointPropertiesEditionPart_RetryErrorCodesLabel);
		retryErrorCodes = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		retryErrorCodes.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData retryErrorCodesData = new GridData(GridData.FILL_HORIZONTAL);
		retryErrorCodes.setLayoutData(retryErrorCodesData);
		retryErrorCodes.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AddressEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryErrorCodes.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, retryErrorCodes.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		retryErrorCodes.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryErrorCodes.getText()));
				}
			}
		});
		EditingUtils.setID(retryErrorCodes, EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes);
		EditingUtils.setEEFtype(retryErrorCodes, "eef::Text"); //$NON-NLS-1$
		Control retryErrorCodesHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryErrorCodesText
		retryErrorCodesTypeElements = new Control[] { retryErrorCodesLabel, retryErrorCodes, retryErrorCodesHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createRetryCountText(FormToolkit widgetFactory, Composite parent) {
		Control retryCountLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount, EsbMessages.AddressEndPointPropertiesEditionPart_RetryCountLabel);
		retryCount = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		retryCount.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData retryCountData = new GridData(GridData.FILL_HORIZONTAL);
		retryCount.setLayoutData(retryCountData);
		retryCount.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AddressEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryCount.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, retryCount.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		retryCount.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryCount.getText()));
				}
			}
		});
		EditingUtils.setID(retryCount, EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount);
		EditingUtils.setEEFtype(retryCount, "eef::Text"); //$NON-NLS-1$
		Control retryCountHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryCountText
		retryCountTypeElements = new Control[] { retryCountLabel, retryCount, retryCountHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createRetryDelayText(FormToolkit widgetFactory, Composite parent) {
		Control retryDelayLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay, EsbMessages.AddressEndPointPropertiesEditionPart_RetryDelayLabel);
		retryDelay = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		retryDelay.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData retryDelayData = new GridData(GridData.FILL_HORIZONTAL);
		retryDelay.setLayoutData(retryDelayData);
		retryDelay.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AddressEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryDelay.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, retryDelay.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		retryDelay.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryDelay.getText()));
				}
			}
		});
		EditingUtils.setID(retryDelay, EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay);
		EditingUtils.setEEFtype(retryDelay, "eef::Text"); //$NON-NLS-1$
		Control retryDelayHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryDelayText
		retryDelayTypeElements = new Control[] { retryDelayLabel, retryDelay, retryDelayHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createMiscGroup(FormToolkit widgetFactory, final Composite parent) {
		Section miscSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		miscSection.setText(EsbMessages.AddressEndPointPropertiesEditionPart_MiscGroupLabel);
		GridData miscSectionData = new GridData(GridData.FILL_HORIZONTAL);
		miscSectionData.horizontalSpan = 3;
		miscSection.setLayoutData(miscSectionData);
		miscGroup = widgetFactory.createComposite(miscSection);
		GridLayout miscGroupLayout = new GridLayout();
		miscGroupLayout.numColumns = 3;
		miscGroup.setLayout(miscGroupLayout);
		miscSection.setClient(miscGroup);
		return miscGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createPropertiesTableComposition(FormToolkit widgetFactory, Composite parent) {
		Control[] previousControls = miscGroup.getChildren();
		this.properties = new ReferencesTable(getDescription(EsbViewsRepository.AddressEndPoint.Misc.properties, EsbMessages.AddressEndPointPropertiesEditionPart_PropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				properties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				properties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				properties.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				properties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.propertiesFilters) {
			this.properties.addFilter(filter);
		}
		this.properties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Misc.properties, EsbViewsRepository.FORM_KIND));
		this.properties.createControls(parent, widgetFactory);
		this.properties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Misc.properties, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		propertiesData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesData.horizontalSpan = 3;
		this.properties.setLayoutData(propertiesData);
		this.properties.setLowerBound(0);
		this.properties.setUpperBound(-1);
		properties.setID(EsbViewsRepository.AddressEndPoint.Misc.properties);
		properties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPropertiesTableComposition
		Control[] newControls = miscGroup.getChildren();
		propertiesTypeElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOptimizeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control optimizeLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.Misc.optimize, EsbMessages.AddressEndPointPropertiesEditionPart_OptimizeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Misc.optimize, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOptimize()));
			}

		});
		optimize.setID(EsbViewsRepository.AddressEndPoint.Misc.optimize);
		Control optimizeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Misc.optimize, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOptimizeEMFComboViewer
		optimizeTypeElements = new Control[] { optimizeLabel, optimize.getCombo(), optimizeHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.Misc.description, EsbMessages.AddressEndPointPropertiesEditionPart_DescriptionLabel);
		description = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		description.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AddressEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.AddressEndPoint.Misc.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.AddressEndPoint.Misc.description,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, description.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		description.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.AddressEndPoint.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Misc.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionTypeElements = new Control[] { descriptionLabel, description, descriptionHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createQoSGroup(FormToolkit widgetFactory, final Composite parent) {
		Section qoSSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		qoSSection.setText(EsbMessages.AddressEndPointPropertiesEditionPart_QoSGroupLabel);
		GridData qoSSectionData = new GridData(GridData.FILL_HORIZONTAL);
		qoSSectionData.horizontalSpan = 3;
		qoSSection.setLayoutData(qoSSectionData);
		qoSGroup = widgetFactory.createComposite(qoSSection);
		GridLayout qoSGroupLayout = new GridLayout();
		qoSGroupLayout.numColumns = 3;
		qoSGroup.setLayout(qoSGroupLayout);
		qoSSection.setClient(qoSGroup);
		return qoSGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createReliableMessagingEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		reliableMessagingEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled, EsbMessages.AddressEndPointPropertiesEditionPart_ReliableMessagingEnabledLabel), SWT.CHECK);
		reliableMessagingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reliableMessagingEnabled.getSelection())));
			}

		});
		GridData reliableMessagingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		reliableMessagingEnabledData.horizontalSpan = 2;
		reliableMessagingEnabled.setLayoutData(reliableMessagingEnabledData);
		EditingUtils.setID(reliableMessagingEnabled, EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled);
		EditingUtils.setEEFtype(reliableMessagingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control reliableMessagingEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	protected Composite createSecurityEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		securityEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AddressEndPoint.QoS.securityEnabled, EsbMessages.AddressEndPointPropertiesEditionPart_SecurityEnabledLabel), SWT.CHECK);
		securityEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.QoS.securityEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(securityEnabled.getSelection())));
			}

		});
		GridData securityEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		securityEnabledData.horizontalSpan = 2;
		securityEnabled.setLayoutData(securityEnabledData);
		EditingUtils.setID(securityEnabled, EsbViewsRepository.AddressEndPoint.QoS.securityEnabled);
		EditingUtils.setEEFtype(securityEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control securityEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.QoS.securityEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	protected Composite createAddressingEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		addressingEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled, EsbMessages.AddressEndPointPropertiesEditionPart_AddressingEnabledLabel), SWT.CHECK);
		addressingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(addressingEnabled.getSelection())));
			}

		});
		GridData addressingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		addressingEnabledData.horizontalSpan = 2;
		addressingEnabled.setLayoutData(addressingEnabledData);
		EditingUtils.setID(addressingEnabled, EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled);
		EditingUtils.setEEFtype(addressingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control addressingEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	protected Composite createAddressingVersionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control addressingVersionLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.QoS.addressingVersion, EsbMessages.AddressEndPointPropertiesEditionPart_AddressingVersionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.QoS.addressingVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAddressingVersion()));
			}

		});
		addressingVersion.setID(EsbViewsRepository.AddressEndPoint.QoS.addressingVersion);
		Control addressingVersionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.QoS.addressingVersion, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingVersionEMFComboViewer
		addressingVersionTypeElements = new Control[] { addressingVersionLabel, addressingVersion.getCombo(),
				addressingVersionHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createAddressingSeparateListenerCheckbox(FormToolkit widgetFactory, Composite parent) {
		addressingSeparateListener = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener, EsbMessages.AddressEndPointPropertiesEditionPart_AddressingSeparateListenerLabel), SWT.CHECK);
		addressingSeparateListener.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(addressingSeparateListener.getSelection())));
			}

		});
		GridData addressingSeparateListenerData = new GridData(GridData.FILL_HORIZONTAL);
		addressingSeparateListenerData.horizontalSpan = 2;
		addressingSeparateListener.setLayoutData(addressingSeparateListenerData);
		EditingUtils.setID(addressingSeparateListener, EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener);
		EditingUtils.setEEFtype(addressingSeparateListener, "eef::Checkbox"); //$NON-NLS-1$
		Control addressingSeparateListenerHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingSeparateListenerCheckbox
		addressingSeperateListenerTypeElements = new Control[] { addressingSeparateListener,
				addressingSeparateListenerHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createTimeoutGroup(FormToolkit widgetFactory, final Composite parent) {
		Section timeoutSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		timeoutSection.setText(EsbMessages.AddressEndPointPropertiesEditionPart_TimeoutGroupLabel);
		GridData timeoutSectionData = new GridData(GridData.FILL_HORIZONTAL);
		timeoutSectionData.horizontalSpan = 3;
		timeoutSection.setLayoutData(timeoutSectionData);
		timeoutGroup = widgetFactory.createComposite(timeoutSection);
		GridLayout timeoutGroupLayout = new GridLayout();
		timeoutGroupLayout.numColumns = 3;
		timeoutGroup.setLayout(timeoutGroupLayout);
		timeoutSection.setClient(timeoutGroup);
		return timeoutGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createTimeOutDurationText(FormToolkit widgetFactory, Composite parent) {
		Control timeOutDurationLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration, EsbMessages.AddressEndPointPropertiesEditionPart_TimeOutDurationLabel);
		timeOutDuration = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		timeOutDuration.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData timeOutDurationData = new GridData(GridData.FILL_HORIZONTAL);
		timeOutDuration.setLayoutData(timeOutDurationData);
		timeOutDuration.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AddressEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, timeOutDuration.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, timeOutDuration.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AddressEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		timeOutDuration.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, timeOutDuration.getText()));
				}
			}
		});
		EditingUtils.setID(timeOutDuration, EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration);
		EditingUtils.setEEFtype(timeOutDuration, "eef::Text"); //$NON-NLS-1$
		Control timeOutDurationHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTimeOutDurationText
		timeoutDurationTypeElements = new Control[] { timeOutDurationLabel, timeOutDuration, timeOutDurationHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createTimeOutActionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control timeOutActionLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction, EsbMessages.AddressEndPointPropertiesEditionPart_TimeOutActionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTimeOutAction()));
			}

		});
		timeOutAction.setID(EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction);
		Control timeOutActionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTimeOutActionEMFComboViewer
		timeoutActionTypeElements = new Control[] { timeOutActionLabel, timeOutAction.getCombo(), timeOutActionHelp };
		// End of user code
		return parent;
	}


	/**
   * 
   */
  protected Composite createFailoverErrorCodesGroup(FormToolkit widgetFactory, final Composite parent) {
    Section failoverErrorCodesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
    failoverErrorCodesSection.setText(EsbMessages.AddressEndPointPropertiesEditionPart_FailoverErrorCodesGroupLabel);
    GridData failoverErrorCodesSectionData = new GridData(GridData.FILL_HORIZONTAL);
    failoverErrorCodesSectionData.horizontalSpan = 3;
    failoverErrorCodesSection.setLayoutData(failoverErrorCodesSectionData);
    failoverErrorCodesGroup = widgetFactory.createComposite(failoverErrorCodesSection);
    GridLayout failoverErrorCodesGroupLayout = new GridLayout();
    failoverErrorCodesGroupLayout.numColumns = 3;
    failoverErrorCodesGroup.setLayout(failoverErrorCodesGroupLayout);
    failoverErrorCodesSection.setClient(failoverErrorCodesGroup);
    return failoverErrorCodesGroup;
  }

  /**
   * @generated NOT
   */
  protected Composite createFailoverTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
    Control failoverTypeLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType, EsbMessages.AddressEndPointPropertiesEditionPart_FailoverTypeLabel);
    failoverType = new EMFComboViewer(parent);
    failoverType.setContentProvider(new ArrayContentProvider());
    failoverType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData failoverTypeData = new GridData(GridData.FILL_HORIZONTAL);
    failoverType.getCombo().setLayoutData(failoverTypeData);
    failoverType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

        @Override
        public void handleEvent(Event arg0) {
            arg0.doit = false;

        }
    });
    failoverType.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null) {
        	propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFailoverType()));
        	
        	if (getFailoverType().getName().equals(EndPointFailoverRetryType.RETRY_ERROR_CODES.getName())) {
        		setFailoverRetryErrorCodes(DEFAULT_FAILOVER_ERROR_CODES);
        		setFailoverNonRetryErrorCodes("");
        		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				        AddressEndPointPropertiesEditionPartForm.this,
				        EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes,
				        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, DEFAULT_FAILOVER_ERROR_CODES));
        		propertiesEditionComponent.firePropertiesChanged(
				        new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this,
				                EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes,
				                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ""));
        		
        	} else if (getFailoverType().getName().equals(EndPointFailoverRetryType.NON_RETRY_ERROR_CODES.getName())) {
        		setFailoverRetryErrorCodes("");
        		setFailoverNonRetryErrorCodes(DEFAULT_FAILOVER_ERROR_CODES);
        		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				        AddressEndPointPropertiesEditionPartForm.this,
				        EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes,
				        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, DEFAULT_FAILOVER_ERROR_CODES));
        		propertiesEditionComponent.firePropertiesChanged(
				        new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this,
				                EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes,
				                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ""));
        	}
        	refresh();
        }  
      }

    });
    failoverType.setID(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType);
    Control failoverTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
    // Start of user code for createFailoverTypeEMFComboViewer
    failoverTypeElements = new Control[] { failoverTypeLabel, failoverType.getCombo(), failoverTypeHelp };
    // End of user code
    return parent;
  }

  protected Composite createFailoverRetryErrorCodesText(FormToolkit widgetFactory, Composite parent) {
    Control failoverRetryErrorCodesLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes, EsbMessages.AddressEndPointPropertiesEditionPart_FailoverRetryErrorCodesLabel);
    failoverRetryErrorCodes = widgetFactory.createText(parent, ""); //$NON-NLS-1$
    failoverRetryErrorCodes.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
    widgetFactory.paintBordersFor(parent);
    GridData failoverRetryErrorCodesData = new GridData(GridData.FILL_HORIZONTAL);
    failoverRetryErrorCodes.setLayoutData(failoverRetryErrorCodesData);
    failoverRetryErrorCodes.addFocusListener(new FocusAdapter() {
      /**
       * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
       * 
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void focusLost(FocusEvent e) {
        if (propertiesEditionComponent != null) {
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
              AddressEndPointPropertiesEditionPartForm.this,
              EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes,
              PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failoverRetryErrorCodes.getText()));
          propertiesEditionComponent
              .firePropertiesChanged(new PropertiesEditionEvent(
                  AddressEndPointPropertiesEditionPartForm.this,
                  EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes,
                  PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                  null, failoverRetryErrorCodes.getText()));
        }
      }

      /**
       * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
       */
      @Override
      public void focusGained(FocusEvent e) {
        if (propertiesEditionComponent != null) {
          propertiesEditionComponent
              .firePropertiesChanged(new PropertiesEditionEvent(
                  AddressEndPointPropertiesEditionPartForm.this,
                  null,
                  PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
                  null, null));
        }
      }
    });
    failoverRetryErrorCodes.addKeyListener(new KeyAdapter() {
      /**
       * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
       * 
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void keyPressed(KeyEvent e) {
        if (e.character == SWT.CR) {
          if (propertiesEditionComponent != null)
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failoverRetryErrorCodes.getText()));
        }
      }
    });
    EditingUtils.setID(failoverRetryErrorCodes, EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes);
    EditingUtils.setEEFtype(failoverRetryErrorCodes, "eef::Text"); //$NON-NLS-1$
    Control failoverRetryErrorCodesHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
    // Start of user code for createFailoverRetryErrorCodesText
    failoverRetryErrorCodesElements = new Control[] { failoverRetryErrorCodesLabel, failoverRetryErrorCodes, failoverRetryErrorCodesHelp };
    // End of user code
    return parent;
  }

  protected Composite createFailoverNonRetryErrorCodesText(FormToolkit widgetFactory, Composite parent) {
	Control failoverNonRetryErrorCodesLabel = createDescription(parent, EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes, EsbMessages.AddressEndPointPropertiesEditionPart_FailoverNonRetryErrorCodesLabel);
    failoverNonRetryErrorCodes = widgetFactory.createText(parent, ""); //$NON-NLS-1$
    failoverNonRetryErrorCodes.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
    widgetFactory.paintBordersFor(parent);
    GridData failoverNonRetryErrorCodesData = new GridData(GridData.FILL_HORIZONTAL);
    failoverNonRetryErrorCodes.setLayoutData(failoverNonRetryErrorCodesData);
    failoverNonRetryErrorCodes.addFocusListener(new FocusAdapter() {
      /**
       * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
       * 
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void focusLost(FocusEvent e) {
        if (propertiesEditionComponent != null) {
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
              AddressEndPointPropertiesEditionPartForm.this,
              EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes,
              PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failoverNonRetryErrorCodes.getText()));
          propertiesEditionComponent
              .firePropertiesChanged(new PropertiesEditionEvent(
                  AddressEndPointPropertiesEditionPartForm.this,
                  EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes,
                  PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                  null, failoverNonRetryErrorCodes.getText()));
        }
      }

      /**
       * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
       */
      @Override
      public void focusGained(FocusEvent e) {
        if (propertiesEditionComponent != null) {
          propertiesEditionComponent
              .firePropertiesChanged(new PropertiesEditionEvent(
                  AddressEndPointPropertiesEditionPartForm.this,
                  null,
                  PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
                  null, null));
        }
      }
    });
    failoverNonRetryErrorCodes.addKeyListener(new KeyAdapter() {
      /**
       * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
       * 
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void keyPressed(KeyEvent e) {
        if (e.character == SWT.CR) {
          if (propertiesEditionComponent != null)
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AddressEndPointPropertiesEditionPartForm.this, EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failoverNonRetryErrorCodes.getText()));
        }
      }
    });
    EditingUtils.setID(failoverNonRetryErrorCodes, EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes);
    EditingUtils.setEEFtype(failoverNonRetryErrorCodes, "eef::Text"); //$NON-NLS-1$
    Control failoverNonRetryErrorCodesHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getEndPointName()
	 * 
	 */
	public String getEndPointName() {
		return endPointName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setEndPointName(String newValue)
	 * 
	 */
	public void setEndPointName(String newValue) {
		if (newValue != null) {
			endPointName.setText(newValue);
		} else {
			endPointName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.endPointName);
		if (eefElementEditorReadOnlyState && endPointName.isEnabled()) {
			endPointName.setEnabled(false);
			endPointName.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endPointName.isEnabled()) {
			endPointName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getAnonymous()
	 * 
	 */
	public Boolean getAnonymous() {
		return Boolean.valueOf(anonymous.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setAnonymous(Boolean newValue)
	 * 
	 */
	public void setAnonymous(Boolean newValue) {
		if (newValue != null) {
			anonymous.setSelection(newValue.booleanValue());
		} else {
			anonymous.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.anonymous);
		if (eefElementEditorReadOnlyState && anonymous.isEnabled()) {
			anonymous.setEnabled(false);
			anonymous.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !anonymous.isEnabled()) {
			anonymous.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getInLine()
	 * 
	 */
	public Boolean getInLine() {
		return Boolean.valueOf(inLine.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setInLine(Boolean newValue)
	 * 
	 */
	public void setInLine(Boolean newValue) {
		if (newValue != null) {
			inLine.setSelection(newValue.booleanValue());
		} else {
			inLine.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.inLine);
		if (eefElementEditorReadOnlyState && inLine.isEnabled()) {
			inLine.setEnabled(false);
			inLine.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inLine.isEnabled()) {
			inLine.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getDuplicate()
	 * 
	 */
	public Boolean getDuplicate() {
		return Boolean.valueOf(duplicate.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setDuplicate(Boolean newValue)
	 * 
	 */
	public void setDuplicate(Boolean newValue) {
		if (newValue != null) {
			duplicate.setSelection(newValue.booleanValue());
		} else {
			duplicate.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.duplicate);
		if (eefElementEditorReadOnlyState && duplicate.isEnabled()) {
			duplicate.setEnabled(false);
			duplicate.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !duplicate.isEnabled()) {
			duplicate.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getReversed()
	 * 
	 */
	public Boolean getReversed() {
		return Boolean.valueOf(reversed.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setReversed(Boolean newValue)
	 * 
	 */
	public void setReversed(Boolean newValue) {
		if (newValue != null) {
			reversed.setSelection(newValue.booleanValue());
		} else {
			reversed.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.reversed);
		if (eefElementEditorReadOnlyState && reversed.isEnabled()) {
			reversed.setEnabled(false);
			reversed.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reversed.isEnabled()) {
			reversed.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getFormat()
	 * 
	 */
	public Enumerator getFormat() {
		Enumerator selection = (Enumerator) ((StructuredSelection) format.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#initFormat(Object input, Enumerator current)
	 */
	public void initFormat(Object input, Enumerator current) {
		format.setInput(input);
		format.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.format);
		if (eefElementEditorReadOnlyState && format.isEnabled()) {
			format.setEnabled(false);
			format.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !format.isEnabled()) {
			format.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setFormat(Enumerator newValue)
	 * 
	 */
	public void setFormat(Enumerator newValue) {
		format.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.format);
		if (eefElementEditorReadOnlyState && format.isEnabled()) {
			format.setEnabled(false);
			format.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !format.isEnabled()) {
			format.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#initTemplateParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTemplateParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		templateParameters.setContentProvider(contentProvider);
		templateParameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.templateParameters);
		if (eefElementEditorReadOnlyState && templateParameters.isEnabled()) {
			templateParameters.setEnabled(false);
			templateParameters.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !templateParameters.isEnabled()) {
			templateParameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#updateTemplateParameters()
	 * 
	 */
	public void updateTemplateParameters() {
	templateParameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#addFilterTemplateParameters(ViewerFilter filter)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#addBusinessFilterTemplateParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTemplateParameters(ViewerFilter filter) {
		templateParametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#isContainedInTemplateParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInTemplateParametersTable(EObject element) {
		return ((ReferencesTableSettings)templateParameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getStatisticsEnabled()
	 * 
	 */
	public Boolean getStatisticsEnabled() {
		return Boolean.valueOf(statisticsEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setStatisticsEnabled(Boolean newValue)
	 * 
	 */
	public void setStatisticsEnabled(Boolean newValue) {
		if (newValue != null) {
			statisticsEnabled.setSelection(newValue.booleanValue());
		} else {
			statisticsEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled);
		if (eefElementEditorReadOnlyState && statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(false);
			statisticsEnabled.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getTraceEnabled()
	 * 
	 */
	public Boolean getTraceEnabled() {
		return Boolean.valueOf(traceEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setTraceEnabled(Boolean newValue)
	 * 
	 */
	public void setTraceEnabled(Boolean newValue) {
		if (newValue != null) {
			traceEnabled.setSelection(newValue.booleanValue());
		} else {
			traceEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.traceEnabled);
		if (eefElementEditorReadOnlyState && traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(false);
			traceEnabled.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getURI()
	 * 
	 */
	public String getURI() {
		return uRI.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setURI(String newValue)
	 * 
	 */
	public void setURI(String newValue) {
		if (newValue != null) {
			uRI.setText(newValue);
		} else {
			uRI.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Basic.uRI);
		if (eefElementEditorReadOnlyState && uRI.isEnabled()) {
			uRI.setEnabled(false);
			uRI.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !uRI.isEnabled()) {
			uRI.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getSuspendErrorCodes()
	 * 
	 */
	public String getSuspendErrorCodes() {
		return suspendErrorCodes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setSuspendErrorCodes(String newValue)
	 * 
	 */
	public void setSuspendErrorCodes(String newValue) {
		if (newValue != null) {
			suspendErrorCodes.setText(newValue);
		} else {
			suspendErrorCodes.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes);
		if (eefElementEditorReadOnlyState && suspendErrorCodes.isEnabled()) {
			suspendErrorCodes.setEnabled(false);
			suspendErrorCodes.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendErrorCodes.isEnabled()) {
			suspendErrorCodes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getSuspendInitialDuration()
	 * 
	 */
	public String getSuspendInitialDuration() {
		return suspendInitialDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setSuspendInitialDuration(String newValue)
	 * 
	 */
	public void setSuspendInitialDuration(String newValue) {
		if (newValue != null) {
			suspendInitialDuration.setText(newValue);
		} else {
			suspendInitialDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration);
		if (eefElementEditorReadOnlyState && suspendInitialDuration.isEnabled()) {
			suspendInitialDuration.setEnabled(false);
			suspendInitialDuration.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendInitialDuration.isEnabled()) {
			suspendInitialDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getSuspendMaximumDuration()
	 * 
	 */
	public String getSuspendMaximumDuration() {
		return suspendMaximumDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setSuspendMaximumDuration(String newValue)
	 * 
	 */
	public void setSuspendMaximumDuration(String newValue) {
		if (newValue != null) {
			suspendMaximumDuration.setText(newValue);
		} else {
			suspendMaximumDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration);
		if (eefElementEditorReadOnlyState && suspendMaximumDuration.isEnabled()) {
			suspendMaximumDuration.setEnabled(false);
			suspendMaximumDuration.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendMaximumDuration.isEnabled()) {
			suspendMaximumDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getSuspendProgressionFactor()
	 * 
	 */
	public String getSuspendProgressionFactor() {
		return suspendProgressionFactor.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setSuspendProgressionFactor(String newValue)
	 * 
	 */
	public void setSuspendProgressionFactor(String newValue) {
		if (newValue != null) {
			suspendProgressionFactor.setText(newValue);
		} else {
			suspendProgressionFactor.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor);
		if (eefElementEditorReadOnlyState && suspendProgressionFactor.isEnabled()) {
			suspendProgressionFactor.setEnabled(false);
			suspendProgressionFactor.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendProgressionFactor.isEnabled()) {
			suspendProgressionFactor.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getRetryErrorCodes()
	 * 
	 */
	public String getRetryErrorCodes() {
		return retryErrorCodes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setRetryErrorCodes(String newValue)
	 * 
	 */
	public void setRetryErrorCodes(String newValue) {
		if (newValue != null) {
			retryErrorCodes.setText(newValue);
		} else {
			retryErrorCodes.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes);
		if (eefElementEditorReadOnlyState && retryErrorCodes.isEnabled()) {
			retryErrorCodes.setEnabled(false);
			retryErrorCodes.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryErrorCodes.isEnabled()) {
			retryErrorCodes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getRetryCount()
	 * 
	 */
	public String getRetryCount() {
		return retryCount.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setRetryCount(String newValue)
	 * 
	 */
	public void setRetryCount(String newValue) {
		if (newValue != null) {
			retryCount.setText(newValue);
		} else {
			retryCount.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount);
		if (eefElementEditorReadOnlyState && retryCount.isEnabled()) {
			retryCount.setEnabled(false);
			retryCount.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryCount.isEnabled()) {
			retryCount.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getRetryDelay()
	 * 
	 */
	public String getRetryDelay() {
		return retryDelay.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setRetryDelay(String newValue)
	 * 
	 */
	public void setRetryDelay(String newValue) {
		if (newValue != null) {
			retryDelay.setText(newValue);
		} else {
			retryDelay.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay);
		if (eefElementEditorReadOnlyState && retryDelay.isEnabled()) {
			retryDelay.setEnabled(false);
			retryDelay.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryDelay.isEnabled()) {
			retryDelay.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#initProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		properties.setContentProvider(contentProvider);
		properties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Misc.properties);
		if (eefElementEditorReadOnlyState && properties.isEnabled()) {
			properties.setEnabled(false);
			properties.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !properties.isEnabled()) {
			properties.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#updateProperties()
	 * 
	 */
	public void updateProperties() {
	properties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#addFilterProperties(ViewerFilter filter)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#addBusinessFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToProperties(ViewerFilter filter) {
		propertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#isContainedInPropertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPropertiesTable(EObject element) {
		return ((ReferencesTableSettings)properties.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getOptimize()
	 * 
	 */
	public Enumerator getOptimize() {
		Enumerator selection = (Enumerator) ((StructuredSelection) optimize.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#initOptimize(Object input, Enumerator current)
	 */
	public void initOptimize(Object input, Enumerator current) {
		optimize.setInput(input);
		optimize.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Misc.optimize);
		if (eefElementEditorReadOnlyState && optimize.isEnabled()) {
			optimize.setEnabled(false);
			optimize.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !optimize.isEnabled()) {
			optimize.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setOptimize(Enumerator newValue)
	 * 
	 */
	public void setOptimize(Enumerator newValue) {
		optimize.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Misc.optimize);
		if (eefElementEditorReadOnlyState && optimize.isEnabled()) {
			optimize.setEnabled(false);
			optimize.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !optimize.isEnabled()) {
			optimize.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Misc.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getReliableMessagingEnabled()
	 * 
	 */
	public Boolean getReliableMessagingEnabled() {
		return Boolean.valueOf(reliableMessagingEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setReliableMessagingEnabled(Boolean newValue)
	 * 
	 */
	public void setReliableMessagingEnabled(Boolean newValue) {
		if (newValue != null) {
			reliableMessagingEnabled.setSelection(newValue.booleanValue());
		} else {
			reliableMessagingEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled);
		if (eefElementEditorReadOnlyState && reliableMessagingEnabled.isEnabled()) {
			reliableMessagingEnabled.setEnabled(false);
			reliableMessagingEnabled.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reliableMessagingEnabled.isEnabled()) {
			reliableMessagingEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getSecurityEnabled()
	 * 
	 */
	public Boolean getSecurityEnabled() {
		return Boolean.valueOf(securityEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setSecurityEnabled(Boolean newValue)
	 * 
	 */
	public void setSecurityEnabled(Boolean newValue) {
		if (newValue != null) {
			securityEnabled.setSelection(newValue.booleanValue());
		} else {
			securityEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.QoS.securityEnabled);
		if (eefElementEditorReadOnlyState && securityEnabled.isEnabled()) {
			securityEnabled.setEnabled(false);
			securityEnabled.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !securityEnabled.isEnabled()) {
			securityEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getAddressingEnabled()
	 * 
	 */
	public Boolean getAddressingEnabled() {
		return Boolean.valueOf(addressingEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setAddressingEnabled(Boolean newValue)
	 * 
	 */
	public void setAddressingEnabled(Boolean newValue) {
		if (newValue != null) {
			addressingEnabled.setSelection(newValue.booleanValue());
		} else {
			addressingEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled);
		if (eefElementEditorReadOnlyState && addressingEnabled.isEnabled()) {
			addressingEnabled.setEnabled(false);
			addressingEnabled.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingEnabled.isEnabled()) {
			addressingEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getAddressingVersion()
	 * 
	 */
	public Enumerator getAddressingVersion() {
		Enumerator selection = (Enumerator) ((StructuredSelection) addressingVersion.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#initAddressingVersion(Object input, Enumerator current)
	 */
	public void initAddressingVersion(Object input, Enumerator current) {
		addressingVersion.setInput(input);
		addressingVersion.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.QoS.addressingVersion);
		if (eefElementEditorReadOnlyState && addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(false);
			addressingVersion.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setAddressingVersion(Enumerator newValue)
	 * 
	 */
	public void setAddressingVersion(Enumerator newValue) {
		addressingVersion.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.QoS.addressingVersion);
		if (eefElementEditorReadOnlyState && addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(false);
			addressingVersion.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getAddressingSeparateListener()
	 * 
	 */
	public Boolean getAddressingSeparateListener() {
		return Boolean.valueOf(addressingSeparateListener.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setAddressingSeparateListener(Boolean newValue)
	 * 
	 */
	public void setAddressingSeparateListener(Boolean newValue) {
		if (newValue != null) {
			addressingSeparateListener.setSelection(newValue.booleanValue());
		} else {
			addressingSeparateListener.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener);
		if (eefElementEditorReadOnlyState && addressingSeparateListener.isEnabled()) {
			addressingSeparateListener.setEnabled(false);
			addressingSeparateListener.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingSeparateListener.isEnabled()) {
			addressingSeparateListener.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getTimeOutDuration()
	 * 
	 */
	public String getTimeOutDuration() {
		return timeOutDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setTimeOutDuration(String newValue)
	 * 
	 */
	public void setTimeOutDuration(String newValue) {
		if (newValue != null) {
			timeOutDuration.setText(newValue);
		} else {
			timeOutDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration);
		if (eefElementEditorReadOnlyState && timeOutDuration.isEnabled()) {
			timeOutDuration.setEnabled(false);
			timeOutDuration.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutDuration.isEnabled()) {
			timeOutDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getTimeOutAction()
	 * 
	 */
	public Enumerator getTimeOutAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) timeOutAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#initTimeOutAction(Object input, Enumerator current)
	 */
	public void initTimeOutAction(Object input, Enumerator current) {
		timeOutAction.setInput(input);
		timeOutAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction);
		if (eefElementEditorReadOnlyState && timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(false);
			timeOutAction.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setTimeOutAction(Enumerator newValue)
	 * 
	 */
	public void setTimeOutAction(Enumerator newValue) {
		timeOutAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction);
		if (eefElementEditorReadOnlyState && timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(false);
			timeOutAction.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(true);
		}	
		
	}






	/**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getFailoverType()
   * 
   */
  public Enumerator getFailoverType() {
    Enumerator selection = (Enumerator) ((StructuredSelection) failoverType.getSelection()).getFirstElement();
    return selection;
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#initFailoverType(Object input, Enumerator current)
   */
  public void initFailoverType(Object input, Enumerator current) {
    failoverType.setInput(input);
    failoverType.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType);
    if (eefElementEditorReadOnlyState && failoverType.isEnabled()) {
      failoverType.setEnabled(false);
      failoverType.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !failoverType.isEnabled()) {
      failoverType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setFailoverType(Enumerator newValue)
   * 
   */
  public void setFailoverType(Enumerator newValue) {
    failoverType.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType);
    if (eefElementEditorReadOnlyState && failoverType.isEnabled()) {
      failoverType.setEnabled(false);
      failoverType.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !failoverType.isEnabled()) {
      failoverType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getFailoverRetryErrorCodes()
   * 
   */
  public String getFailoverRetryErrorCodes() {
    return failoverRetryErrorCodes.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setFailoverRetryErrorCodes(String newValue)
   * 
   */
  public void setFailoverRetryErrorCodes(String newValue) {
    if (newValue != null) {
      failoverRetryErrorCodes.setText(newValue);
    } else {
      failoverRetryErrorCodes.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes);
    if (eefElementEditorReadOnlyState && failoverRetryErrorCodes.isEnabled()) {
      failoverRetryErrorCodes.setEnabled(false);
      failoverRetryErrorCodes.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !failoverRetryErrorCodes.isEnabled()) {
      failoverRetryErrorCodes.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#getFailoverNonRetryErrorCodes()
   * 
   */
  public String getFailoverNonRetryErrorCodes() {
    return failoverNonRetryErrorCodes.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart#setFailoverNonRetryErrorCodes(String newValue)
   * 
   */
  public void setFailoverNonRetryErrorCodes(String newValue) {
    if (newValue != null) {
      failoverNonRetryErrorCodes.setText(newValue);
    } else {
      failoverNonRetryErrorCodes.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes);
    if (eefElementEditorReadOnlyState && failoverNonRetryErrorCodes.isEnabled()) {
      failoverNonRetryErrorCodes.setEnabled(false);
      failoverNonRetryErrorCodes.setToolTipText(EsbMessages.AddressEndPoint_ReadOnly);
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

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.AddressEndPoint_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createReliableMessagingPolicy(FormToolkit widgetFactory, Composite parent) {
		Control reliableMessagingPolicyLabel = createDescription(parent,
				EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy,
				EsbMessages.AddressEndPointPropertiesEditionPart_ReliableMessagingPolicyLabel);
		widgetFactory.paintBordersFor(parent);
		if (reliableMessagingPolicy == null) {
			reliableMessagingPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = reliableMessagingPolicy.getKeyValue().isEmpty() ? "" : reliableMessagingPolicy.getKeyValue();
		reliableMessagingPolicyText = widgetFactory.createText(parent, initValueExpression);
		reliableMessagingPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		reliableMessagingPolicyText.setLayoutData(valueData);
		reliableMessagingPolicyText.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
						SWT.NULL, reliableMessagingPolicy, new ArrayList<NamedEntityDescriptor>());
				dialog.open();
				reliableMessagingPolicyText.setText(reliableMessagingPolicy.getKeyValue());
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AddressEndPointPropertiesEditionPartForm.this,
						EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, null, getReliableMessagingPolicy()));
			}
		});
		EditingUtils.setID(reliableMessagingPolicyText, EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy);
		EditingUtils.setEEFtype(reliableMessagingPolicyText, "eef::Text");
		Control reliableMessagingPolicyHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		reliablePolicyTypeElements = new Control[] { reliableMessagingPolicyLabel, reliableMessagingPolicyText,
				reliableMessagingPolicyHelp };
		return parent;
	}
	
	protected Composite createInboundPolicy(FormToolkit widgetFactory, Composite parent) {
		Control inboundPolicyLabel = createDescription(parent,
				EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy,
				EsbMessages.AddressEndPointPropertiesEditionPart_InboundPolicyLabel);
		widgetFactory.paintBordersFor(parent);
		if (inboundPolicy == null) {
			inboundPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = inboundPolicy.getKeyValue().isEmpty() ? "" : inboundPolicy.getKeyValue();
		inboundPolicyText = widgetFactory.createText(parent, initValueExpression);
		inboundPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		inboundPolicyText.setLayoutData(valueData);
		inboundPolicyText.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
						SWT.NULL, inboundPolicy, new ArrayList<NamedEntityDescriptor>());
				dialog.open();
				inboundPolicyText.setText(inboundPolicy.getKeyValue());
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AddressEndPointPropertiesEditionPartForm.this,
						EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, null, getInboundPolicy()));
			}
		});
		EditingUtils.setID(inboundPolicyText, EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy);
		EditingUtils.setEEFtype(inboundPolicyText, "eef::Text");
		Control inboundPolicyHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		inboundPolicyTypeElements = new Control[] { inboundPolicyLabel, inboundPolicyText, inboundPolicyHelp };
		return parent;
	}
	
	protected Composite createOutboundPolicy(FormToolkit widgetFactory, Composite parent) {
		Control outboundPolicyLabel = createDescription(parent,
				EsbViewsRepository.AddressEndPoint.QoS.outboundPolicy,
				EsbMessages.AddressEndPointPropertiesEditionPart_OutboundPolicyLabel);
		widgetFactory.paintBordersFor(parent);
		if (outboundPolicy == null) {
			outboundPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = outboundPolicy.getKeyValue().isEmpty() ? "" : outboundPolicy.getKeyValue();
		outboundPolicyText = widgetFactory.createText(parent, initValueExpression);
		outboundPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		outboundPolicyText.setLayoutData(valueData);
		outboundPolicyText.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
						SWT.NULL, outboundPolicy, new ArrayList<NamedEntityDescriptor>());
				dialog.open();
				outboundPolicyText.setText(outboundPolicy.getKeyValue());
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AddressEndPointPropertiesEditionPartForm.this,
						EsbViewsRepository.AddressEndPoint.QoS.outboundPolicy, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, null, getOutboundPolicy()));
			}
		});
		EditingUtils.setID(outboundPolicyText, EsbViewsRepository.AddressEndPoint.QoS.outboundPolicy);
		EditingUtils.setEEFtype(outboundPolicyText, "eef::Text");
		Control outboundPolicyHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.QoS.outboundPolicy,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		outboundPolicyTypeElements = new Control[] { outboundPolicyLabel, outboundPolicyText, outboundPolicyHelp };
		return parent;
	}
	
	protected Composite createSecurityPolicy(FormToolkit widgetFactory, Composite parent) {
		Control securityPolicyLabel = createDescription(parent,
				EsbViewsRepository.AddressEndPoint.QoS.securityPolicy,
				EsbMessages.AddressEndPointPropertiesEditionPart_SecurityPolicyLabel);
		widgetFactory.paintBordersFor(parent);
		if (securityPolicy == null) {
			securityPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = securityPolicy.getKeyValue().isEmpty() ? "" : securityPolicy.getKeyValue();
		securityPolicyText = widgetFactory.createText(parent, initValueExpression);
		securityPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		securityPolicyText.setLayoutData(valueData);
		securityPolicyText.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
						SWT.NULL, securityPolicy, new ArrayList<NamedEntityDescriptor>());
				dialog.open();
				securityPolicyText.setText(securityPolicy.getKeyValue());
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						AddressEndPointPropertiesEditionPartForm.this,
						EsbViewsRepository.AddressEndPoint.QoS.securityPolicy, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, null, getSecurityPolicy()));
			}
		});
		EditingUtils.setID(securityPolicyText, EsbViewsRepository.AddressEndPoint.QoS.securityPolicy);
		EditingUtils.setEEFtype(securityPolicyText, "eef::Text");
		Control securityPolicyHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.AddressEndPoint.QoS.securityPolicy,
						EsbViewsRepository.FORM_KIND),
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
    	viewUtil.showEntry(uriTypeElements, false);
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
       	if(reliableMessagingEnabled.getSelection()) {
       		viewUtil.showEntry(reliablePolicyTypeElements, false);
       	}	
       	viewUtil.showEntry(securithEnabledTypeElements, false);
       	if(securityEnabled.getSelection()) {
       		viewUtil.showEntry(securityPolicyTypeElements, false);
       		viewUtil.showEntry(inboundPolicyTypeElements, false);
       		viewUtil.showEntry(outboundPolicyTypeElements, false);
       	}
       	viewUtil.showEntry(addressingEnabledTypeElements, false);
       	if(addressingEnabled.getSelection()) {
       		viewUtil.showEntry(addressingVersionTypeElements, false);
       		viewUtil.showEntry(addressingSeperateListenerTypeElements, false);
       	}
       	viewUtil.showEntry(timeoutDurationTypeElements, false);
       	viewUtil.showEntry(timeoutActionTypeElements, false);
       	
       	viewUtil.showEntry(failoverTypeElements, false);
       	
       	if (null != getFailoverRetryErrorCodes() && !"".equals(getFailoverRetryErrorCodes())) {
       		failoverType.getCombo().select(0);
       	} else if (null != getFailoverNonRetryErrorCodes() && !"".equals(getFailoverNonRetryErrorCodes())) {
       		failoverType.getCombo().select(1);
       	}
       	
       	if (getFailoverType().getName().equals(EndPointFailoverRetryType.RETRY_ERROR_CODES.getName())) {
       		viewUtil.showEntry(failoverRetryErrorCodesElements, false);
       	} else {
       		viewUtil.showEntry(failoverNonRetryErrorCodesElements, false);
       	}
       	
        view.layout(true, true);
    }
	// End of user code


}
