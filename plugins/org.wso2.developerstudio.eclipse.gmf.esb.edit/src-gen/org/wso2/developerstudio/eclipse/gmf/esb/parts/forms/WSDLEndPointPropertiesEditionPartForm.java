/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

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
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class WSDLEndPointPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, WSDLEndPointPropertiesEditionPart {

	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Text endPointName;
	protected Button anonymous;
	protected Button duplicate;
	protected Button reversed;
	protected ReferencesTable templateParameters;
	protected List<ViewerFilter> templateParametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> templateParametersFilters = new ArrayList<ViewerFilter>();
	protected Button inLine;
	protected EMFComboViewer format;
	protected Button traceEnabled;
	protected Button statisticsEnabled;
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
	protected Text wsdlUri;
	protected Text service;
	protected Text port;
	protected Button reliableMessagingEnabled;
	protected Button securityEnabled;
	protected Button addressingEnabled;
	// Start of user code  for reliableMessagingPolicy widgets declarations
	protected RegistryKeyProperty reliableMessagingPolicy;
	protected Text reliableMessagingPolicyText;
	// End of user code

	// Start of user code  for securityPolicy widgets declarations
	protected RegistryKeyProperty securityPolicy;
	protected Text securityPolicyText;
	// End of user code

	// Start of user code  for inboundPolicy widgets declarations
	protected RegistryKeyProperty inboundPolicy;
	protected Text inboundPolicyText;
	// End of user code

	// Start of user code  for outboundPolicy widgets declarations
	protected RegistryKeyProperty outboundPolicy;
	protected Text outboundPolicyText;
	
	protected Section propertiesSection;
	
	protected Composite propertiesGroup;
	protected Composite basicGroup;
	protected Composite qosGroup;
	
	protected Control[] inlineElements;
	protected Control[] formatElements;
	protected Control[] traceEnabledElements;
	protected Control[] statisticsEnabledElements;
	protected Control[] optimizeElements;
	protected Control[] descriptionElements;
	protected Control[] wsdlUriElements;
	protected Control[] serviceElements;
	protected Control[] portElements;
	protected Control[] reliableMessagingEnabledElements;
	protected Control[] securityEnabledElements;
	protected Control[] addressingEnabledElements;
	protected Control[] addressingVersionElements;
	protected Control[] addressingSeparateListenerElements;
	protected Control[] reliableMessagingPolicyElements;
	protected Control[] securityPolicyElements;
	protected Control[] inboundPolicyElements;
	protected Control[] outboundPolicyElements;
	
	protected Composite filterAdvancedSubPropertiesGroup;
	
    protected Composite failoverErrorCodesGroup;
    
    protected Text failoverNonRetryErrorCodes;
    protected Control[] failoverNonRetryErrorCodesElements;
	// End of user code

	protected EMFComboViewer addressingVersion;
	protected Button addressingSeparateListener;
	protected Text timeOutDuration;
	protected EMFComboViewer timeOutAction;



  /**
	 * For {@link ISection} use only.
	 */
	public WSDLEndPointPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public WSDLEndPointPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence wSDLEndPointStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = wSDLEndPointStep.addStep(EsbViewsRepository.WSDLEndPoint.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.WSDLEndPoint.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.WSDLEndPoint.Properties.endPointName);
		propertiesStep.addStep(EsbViewsRepository.WSDLEndPoint.Properties.anonymous);
		propertiesStep.addStep(EsbViewsRepository.WSDLEndPoint.Properties.duplicate);
		propertiesStep.addStep(EsbViewsRepository.WSDLEndPoint.Properties.reversed);
		propertiesStep.addStep(EsbViewsRepository.WSDLEndPoint.Properties.templateParameters);
		
		CompositionStep basicStep = wSDLEndPointStep.addStep(EsbViewsRepository.WSDLEndPoint.Basic.class);
		basicStep.addStep(EsbViewsRepository.WSDLEndPoint.Basic.inLine);
		basicStep.addStep(EsbViewsRepository.WSDLEndPoint.Basic.format);
		basicStep.addStep(EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled);
		basicStep.addStep(EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled);
		
		CompositionStep endpointSuspendStateStep = wSDLEndPointStep.addStep(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.class);
		endpointSuspendStateStep.addStep(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes);
		endpointSuspendStateStep.addStep(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration);
		endpointSuspendStateStep.addStep(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration);
		endpointSuspendStateStep.addStep(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor);
				
		CompositionStep endpointTimeoutStateStep = wSDLEndPointStep.addStep(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.class);
		endpointTimeoutStateStep.addStep(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes);
		endpointTimeoutStateStep.addStep(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount);
		endpointTimeoutStateStep.addStep(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay);	
		
		CompositionStep qosStep = wSDLEndPointStep.addStep(EsbViewsRepository.WSDLEndPoint.Qos.class);
		qosStep.addStep(EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled);
		qosStep.addStep(EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled);
		qosStep.addStep(EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled);
		qosStep.addStep(EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingPolicy);
		qosStep.addStep(EsbViewsRepository.WSDLEndPoint.Qos.securityPolicy);
		qosStep.addStep(EsbViewsRepository.WSDLEndPoint.Qos.inboundPolicy);
		qosStep.addStep(EsbViewsRepository.WSDLEndPoint.Qos.outboundPolicy);
		qosStep.addStep(EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion);
		qosStep.addStep(EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener);
		
		CompositionStep timeoutStep = wSDLEndPointStep.addStep(EsbViewsRepository.WSDLEndPoint.Timeout.class);
		timeoutStep.addStep(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration);
		timeoutStep.addStep(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction);

        CompositionStep miscStep = wSDLEndPointStep.addStep(EsbViewsRepository.WSDLEndPoint.Misc.class);
        miscStep.addStep(EsbViewsRepository.WSDLEndPoint.Misc.properties);
        miscStep.addStep(EsbViewsRepository.WSDLEndPoint.Misc.description); 
        miscStep.addStep(EsbViewsRepository.WSDLEndPoint.Misc.optimize);
        miscStep.addStep(EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri);
        miscStep.addStep(EsbViewsRepository.WSDLEndPoint.Misc.service);
        miscStep.addStep(EsbViewsRepository.WSDLEndPoint.Misc.port);	
        
        CompositionStep failoverStep = wSDLEndPointStep.addStep(EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.class);
        failoverStep.addStep(EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes);
		
		composer = new PartComposer(wSDLEndPointStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
			    // Start of user code
				if (key == EsbViewsRepository.WSDLEndPoint.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Properties.endPointName) {
					return createEndPointNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Properties.anonymous) {
					return createAnonymousCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Properties.duplicate) {
					return createDuplicateCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Properties.reversed) {
					return createReversedCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Properties.templateParameters) {
					return createTemplateParametersTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Basic.class) {
					return createBasicGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Basic.inLine) {
					return createInLineCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Basic.format) {
					return createFormatEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled) {
					return createTraceEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled) {
					return createStatisticsEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.class) {
					return createEndpointSuspendStateGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes) {
					return createSuspendErrorCodesText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration) {
					return createSuspendInitialDurationText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration) {
					return createSuspendMaximumDurationText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor) {
					return createSuspendProgressionFactorText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.class) {
					return createEndpointTimeoutStateGroup(widgetFactory, filterAdvancedSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes) {
					return createRetryErrorCodesText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount) {
					return createRetryCountText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay) {
					return createRetryDelayText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Misc.class) {
					return createMiscGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Misc.properties) {
					return createPropertiesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Misc.optimize) {
					return createOptimizeEMFComboViewer(widgetFactory, filterAdvancedSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Misc.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri) {
					return createWsdlUriText(widgetFactory, filterAdvancedSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Misc.service) {
					return createServiceText(widgetFactory, filterAdvancedSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Misc.port) {
					return createPortText(widgetFactory, filterAdvancedSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Qos.class) {
					return createQosGroup(widgetFactory, filterAdvancedSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled) {
					return createReliableMessagingEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled) {
					return createSecurityEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled) {
					return createAddressingEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingPolicy) {
                    return createReliableMessagingPolicy(widgetFactory, parent);
                }
				if (key == EsbViewsRepository.WSDLEndPoint.Qos.securityPolicy) {
                    return createSecurityPolicy(widgetFactory, parent);
                }
				if (key == EsbViewsRepository.WSDLEndPoint.Qos.inboundPolicy) {
                    return createInboundPolicy(widgetFactory, parent);
                }
				if (key == EsbViewsRepository.WSDLEndPoint.Qos.outboundPolicy) {
                    return createOutboundPolicy(widgetFactory, parent);
                }
				if (key == EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion) {
					return createAddressingVersionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener) {
					return createAddressingSeparateListenerCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Timeout.class) {
					return createTimeoutGroup(widgetFactory, filterAdvancedSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration) {
					return createTimeOutDurationText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction) {
					return createTimeOutActionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.class) {
                    return createFailoverErrorCodesGroup(widgetFactory, filterAdvancedSubPropertiesGroup);
                }
				if (key == EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes) {
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
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.WSDLEndPointPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.WSDLEndPoint.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.WSDLEndPoint.Properties.commentsList, EsbMessages.WSDLEndPointPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "WSDLEndPoint", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.WSDLEndPoint.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	protected Composite createEndPointNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.WSDLEndPoint.Properties.endPointName, EsbMessages.WSDLEndPointPropertiesEditionPart_EndPointNameLabel);
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
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.Properties.endPointName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.Properties.endPointName,
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
									WSDLEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Properties.endPointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
				}
			}
		});
		EditingUtils.setID(endPointName, EsbViewsRepository.WSDLEndPoint.Properties.endPointName);
		EditingUtils.setEEFtype(endPointName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Properties.endPointName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndPointNameText

		// End of user code
		return parent;
	}

	protected Composite createAnonymousCheckbox(FormToolkit widgetFactory, Composite parent) {
		anonymous = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.WSDLEndPoint.Properties.anonymous, EsbMessages.WSDLEndPointPropertiesEditionPart_AnonymousLabel), SWT.CHECK);
		anonymous.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Properties.anonymous, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(anonymous.getSelection())));
			}

		});
		GridData anonymousData = new GridData(GridData.FILL_HORIZONTAL);
		anonymousData.horizontalSpan = 2;
		anonymous.setLayoutData(anonymousData);
		EditingUtils.setID(anonymous, EsbViewsRepository.WSDLEndPoint.Properties.anonymous);
		EditingUtils.setEEFtype(anonymous, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Properties.anonymous, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAnonymousCheckbox

		// End of user code
		return parent;
	}

	protected Composite createDuplicateCheckbox(FormToolkit widgetFactory, Composite parent) {
		duplicate = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.WSDLEndPoint.Properties.duplicate, EsbMessages.WSDLEndPointPropertiesEditionPart_DuplicateLabel), SWT.CHECK);
		duplicate.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Properties.duplicate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(duplicate.getSelection())));
			}

		});
		GridData duplicateData = new GridData(GridData.FILL_HORIZONTAL);
		duplicateData.horizontalSpan = 2;
		duplicate.setLayoutData(duplicateData);
		EditingUtils.setID(duplicate, EsbViewsRepository.WSDLEndPoint.Properties.duplicate);
		EditingUtils.setEEFtype(duplicate, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Properties.duplicate, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDuplicateCheckbox

		// End of user code
		return parent;
	}

	protected Composite createReversedCheckbox(FormToolkit widgetFactory, Composite parent) {
		reversed = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.WSDLEndPoint.Properties.reversed, EsbMessages.WSDLEndPointPropertiesEditionPart_ReversedLabel), SWT.CHECK);
		reversed.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Properties.reversed, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reversed.getSelection())));
			}

		});
		GridData reversedData = new GridData(GridData.FILL_HORIZONTAL);
		reversedData.horizontalSpan = 2;
		reversed.setLayoutData(reversedData);
		EditingUtils.setID(reversed, EsbViewsRepository.WSDLEndPoint.Properties.reversed);
		EditingUtils.setEEFtype(reversed, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Properties.reversed, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReversedCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTemplateParametersTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.templateParameters = new ReferencesTable(getDescription(EsbViewsRepository.WSDLEndPoint.Properties.templateParameters, EsbMessages.WSDLEndPointPropertiesEditionPart_TemplateParametersLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				templateParameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				templateParameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				templateParameters.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				templateParameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.templateParametersFilters) {
			this.templateParameters.addFilter(filter);
		}
		this.templateParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Properties.templateParameters, EsbViewsRepository.FORM_KIND));
		this.templateParameters.createControls(parent, widgetFactory);
		this.templateParameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Properties.templateParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData templateParametersData = new GridData(GridData.FILL_HORIZONTAL);
		templateParametersData.horizontalSpan = 3;
		this.templateParameters.setLayoutData(templateParametersData);
		this.templateParameters.setLowerBound(0);
		this.templateParameters.setUpperBound(-1);
		templateParameters.setID(EsbViewsRepository.WSDLEndPoint.Properties.templateParameters);
		templateParameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTemplateParametersTableComposition

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createBasicGroup(FormToolkit widgetFactory, final Composite parent) {
		Section basicSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		basicSection.setText(EsbMessages.WSDLEndPointPropertiesEditionPart_BasicGroupLabel);
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
     * @generated NOT
     */
	protected Composite createInLineCheckbox(FormToolkit widgetFactory, Composite parent) {
		inLine = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.WSDLEndPoint.Basic.inLine, EsbMessages.WSDLEndPointPropertiesEditionPart_InLineLabel), SWT.CHECK);
		inLine.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Basic.inLine, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(inLine.getSelection())));
			}

		});
		GridData inLineData = new GridData(GridData.FILL_HORIZONTAL);
		inLineData.horizontalSpan = 2;
		inLine.setLayoutData(inLineData);
		EditingUtils.setID(inLine, EsbViewsRepository.WSDLEndPoint.Basic.inLine);
		EditingUtils.setEEFtype(inLine, "eef::Checkbox"); //$NON-NLS-1$
		Control inlineHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Basic.inLine, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInLineCheckbox
		inlineElements = new Control[] {inLine, inlineHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createFormatEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control formatLabel = createDescription(parent, EsbViewsRepository.WSDLEndPoint.Basic.format, EsbMessages.WSDLEndPointPropertiesEditionPart_FormatLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Basic.format, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFormat()));
			}

		});
		format.setID(EsbViewsRepository.WSDLEndPoint.Basic.format);
		Control formatHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Basic.format, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFormatEMFComboViewer
		formatElements = new Control[] {formatLabel, format.getCombo(), formatHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createTraceEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		traceEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled, EsbMessages.WSDLEndPointPropertiesEditionPart_TraceEnabledLabel), SWT.CHECK);
		traceEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(traceEnabled.getSelection())));
			}

		});
		GridData traceEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		traceEnabledData.horizontalSpan = 2;
		traceEnabled.setLayoutData(traceEnabledData);
		EditingUtils.setID(traceEnabled, EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled);
		EditingUtils.setEEFtype(traceEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control traceEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTraceEnabledCheckbox
		traceEnabledElements = new Control[] {traceEnabled, traceEnabledHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createStatisticsEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		statisticsEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled, EsbMessages.WSDLEndPointPropertiesEditionPart_StatisticsEnabledLabel), SWT.CHECK);
		statisticsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statisticsEnabled.getSelection())));
			}

		});
		GridData statisticsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		statisticsEnabledData.horizontalSpan = 2;
		statisticsEnabled.setLayoutData(statisticsEnabledData);
		EditingUtils.setID(statisticsEnabled, EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled);
		EditingUtils.setEEFtype(statisticsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control statisticsEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatisticsEnabledCheckbox
		statisticsEnabledElements = new Control[] {statisticsEnabled, statisticsEnabledHelp};
		// End of user code
		return parent;
	}

	protected Composite createEndpointSuspendStateGroup(FormToolkit widgetFactory, final Composite parent) {
	    filterAdvancedSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Advanced", false);
	    
		Section endpointSuspendStateSection = widgetFactory.createSection(filterAdvancedSubPropertiesGroup, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		endpointSuspendStateSection.setText(EsbMessages.WSDLEndPointPropertiesEditionPart_EndpointSuspendStateGroupLabel);
		GridData endpointSuspendStateSectionData = new GridData(GridData.FILL_HORIZONTAL);
		endpointSuspendStateSectionData.horizontalSpan = 3;
		endpointSuspendStateSection.setLayoutData(endpointSuspendStateSectionData);
		Composite endpointSuspendStateGroup = widgetFactory.createComposite(endpointSuspendStateSection);
		GridLayout endpointSuspendStateGroupLayout = new GridLayout();
		endpointSuspendStateGroupLayout.numColumns = 3;
		endpointSuspendStateGroup.setLayout(endpointSuspendStateGroupLayout);
		endpointSuspendStateSection.setClient(endpointSuspendStateGroup);
		return endpointSuspendStateGroup;
	}

	protected Composite createSuspendErrorCodesText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes, EsbMessages.WSDLEndPointPropertiesEditionPart_SuspendErrorCodesLabel);
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
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendErrorCodes.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes,
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
									WSDLEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendErrorCodes.getText()));
				}
			}
		});
		EditingUtils.setID(suspendErrorCodes, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes);
		EditingUtils.setEEFtype(suspendErrorCodes, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendErrorCodesText

		// End of user code
		return parent;
	}

	protected Composite createSuspendInitialDurationText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration, EsbMessages.WSDLEndPointPropertiesEditionPart_SuspendInitialDurationLabel);
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
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendInitialDuration.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration,
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
									WSDLEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendInitialDuration.getText()));
				}
			}
		});
		EditingUtils.setID(suspendInitialDuration, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration);
		EditingUtils.setEEFtype(suspendInitialDuration, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendInitialDurationText

		// End of user code
		return parent;
	}

	protected Composite createSuspendMaximumDurationText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration, EsbMessages.WSDLEndPointPropertiesEditionPart_SuspendMaximumDurationLabel);
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
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendMaximumDuration.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration,
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
									WSDLEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendMaximumDuration.getText()));
				}
			}
		});
		EditingUtils.setID(suspendMaximumDuration, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration);
		EditingUtils.setEEFtype(suspendMaximumDuration, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendMaximumDurationText

		// End of user code
		return parent;
	}

	protected Composite createSuspendProgressionFactorText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor, EsbMessages.WSDLEndPointPropertiesEditionPart_SuspendProgressionFactorLabel);
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
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendProgressionFactor.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor,
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
									WSDLEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, suspendProgressionFactor.getText()));
				}
			}
		});
		EditingUtils.setID(suspendProgressionFactor, EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor);
		EditingUtils.setEEFtype(suspendProgressionFactor, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSuspendProgressionFactorText

		// End of user code
		return parent;
	}

	protected Composite createEndpointTimeoutStateGroup(FormToolkit widgetFactory, final Composite parent) {
		Section endpointTimeoutStateSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		endpointTimeoutStateSection.setText(EsbMessages.WSDLEndPointPropertiesEditionPart_EndpointTimeoutStateGroupLabel);
		GridData endpointTimeoutStateSectionData = new GridData(GridData.FILL_HORIZONTAL);
		endpointTimeoutStateSectionData.horizontalSpan = 3;
		endpointTimeoutStateSection.setLayoutData(endpointTimeoutStateSectionData);
		Composite endpointTimeoutStateGroup = widgetFactory.createComposite(endpointTimeoutStateSection);
		GridLayout endpointTimeoutStateGroupLayout = new GridLayout();
		endpointTimeoutStateGroupLayout.numColumns = 3;
		endpointTimeoutStateGroup.setLayout(endpointTimeoutStateGroupLayout);
		endpointTimeoutStateSection.setClient(endpointTimeoutStateGroup);
		return endpointTimeoutStateGroup;
	}

	protected Composite createRetryErrorCodesText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes, EsbMessages.WSDLEndPointPropertiesEditionPart_RetryErrorCodesLabel);
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
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryErrorCodes.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes,
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
									WSDLEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryErrorCodes.getText()));
				}
			}
		});
		EditingUtils.setID(retryErrorCodes, EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes);
		EditingUtils.setEEFtype(retryErrorCodes, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryErrorCodesText

		// End of user code
		return parent;
	}

	protected Composite createRetryCountText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount, EsbMessages.WSDLEndPointPropertiesEditionPart_RetryCountLabel);
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
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryCount.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount,
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
									WSDLEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryCount.getText()));
				}
			}
		});
		EditingUtils.setID(retryCount, EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount);
		EditingUtils.setEEFtype(retryCount, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryCountText

		// End of user code
		return parent;
	}

	protected Composite createRetryDelayText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay, EsbMessages.WSDLEndPointPropertiesEditionPart_RetryDelayLabel);
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
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryDelay.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay,
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
									WSDLEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryDelay.getText()));
				}
			}
		});
		EditingUtils.setID(retryDelay, EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay);
		EditingUtils.setEEFtype(retryDelay, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryDelayText

		// End of user code
		return parent;
	}

	protected Composite createMiscGroup(FormToolkit widgetFactory, final Composite parent) {
		Section miscSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		miscSection.setText(EsbMessages.WSDLEndPointPropertiesEditionPart_MiscGroupLabel);
		GridData miscSectionData = new GridData(GridData.FILL_HORIZONTAL);
		miscSectionData.horizontalSpan = 3;
		miscSection.setLayoutData(miscSectionData);
		Composite miscGroup = widgetFactory.createComposite(miscSection);
		GridLayout miscGroupLayout = new GridLayout();
		miscGroupLayout.numColumns = 3;
		miscGroup.setLayout(miscGroupLayout);
		miscSection.setClient(miscGroup);
		return miscGroup;
	}

	protected Composite createPropertiesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.properties = new ReferencesTable(getDescription(EsbViewsRepository.WSDLEndPoint.Misc.properties, EsbMessages.WSDLEndPointPropertiesEditionPart_PropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				properties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				properties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				properties.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Misc.properties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				properties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.propertiesFilters) {
			this.properties.addFilter(filter);
		}
		this.properties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Misc.properties, EsbViewsRepository.FORM_KIND));
		this.properties.createControls(parent, widgetFactory);
		this.properties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Misc.properties, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData propertiesData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesData.horizontalSpan = 3;
		this.properties.setLayoutData(propertiesData);
		this.properties.setLowerBound(0);
		this.properties.setUpperBound(-1);
		properties.setID(EsbViewsRepository.WSDLEndPoint.Misc.properties);
		properties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPropertiesTableComposition

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOptimizeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control optimizeLable = createDescription(parent, EsbViewsRepository.WSDLEndPoint.Misc.optimize, EsbMessages.WSDLEndPointPropertiesEditionPart_OptimizeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Misc.optimize, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOptimize()));
			}

		});
		optimize.setID(EsbViewsRepository.WSDLEndPoint.Misc.optimize);
		Control optimizeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Misc.optimize, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOptimizeEMFComboViewer
		optimizeElements = new Control[] {optimizeLable, optimize.getCombo(), optimizeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.WSDLEndPoint.Misc.description, EsbMessages.WSDLEndPointPropertiesEditionPart_DescriptionLabel);
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
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.Misc.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.Misc.description,
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
									WSDLEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.WSDLEndPoint.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Misc.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] {descriptionLabel, description, descriptionHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createWsdlUriText(FormToolkit widgetFactory, Composite parent) {
		Control wsdlUriLabel = createDescription(parent, EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri, EsbMessages.WSDLEndPointPropertiesEditionPart_WsdlUriLabel);
		wsdlUri = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		wsdlUri.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData wsdlUriData = new GridData(GridData.FILL_HORIZONTAL);
		wsdlUri.setLayoutData(wsdlUriData);
		wsdlUri.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlUri.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, wsdlUri.getText()));
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
									WSDLEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		wsdlUri.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlUri.getText()));
				}
			}
		});
		EditingUtils.setID(wsdlUri, EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri);
		EditingUtils.setEEFtype(wsdlUri, "eef::Text"); //$NON-NLS-1$
		Control wsdlUriHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createWsdlUriText
		wsdlUriElements = new Control[] {wsdlUriLabel, wsdlUri, wsdlUriHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createServiceText(FormToolkit widgetFactory, Composite parent) {
		Control serviceLabel = createDescription(parent, EsbViewsRepository.WSDLEndPoint.Misc.service, EsbMessages.WSDLEndPointPropertiesEditionPart_ServiceLabel);
		service = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		service.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData serviceData = new GridData(GridData.FILL_HORIZONTAL);
		service.setLayoutData(serviceData);
		service.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.Misc.service,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, service.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.Misc.service,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, service.getText()));
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
									WSDLEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		service.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Misc.service, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, service.getText()));
				}
			}
		});
		EditingUtils.setID(service, EsbViewsRepository.WSDLEndPoint.Misc.service);
		EditingUtils.setEEFtype(service, "eef::Text"); //$NON-NLS-1$
		Control serviceHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Misc.service, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createServiceText
		serviceElements = new Control[] {serviceLabel, service, serviceHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPortText(FormToolkit widgetFactory, Composite parent) {
		Control portLabel = createDescription(parent, EsbViewsRepository.WSDLEndPoint.Misc.port, EsbMessages.WSDLEndPointPropertiesEditionPart_PortLabel);
		port = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		port.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData portData = new GridData(GridData.FILL_HORIZONTAL);
		port.setLayoutData(portData);
		port.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.Misc.port,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, port.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.Misc.port,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, port.getText()));
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
									WSDLEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		port.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Misc.port, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, port.getText()));
				}
			}
		});
		EditingUtils.setID(port, EsbViewsRepository.WSDLEndPoint.Misc.port);
		EditingUtils.setEEFtype(port, "eef::Text"); //$NON-NLS-1$
		Control portHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Misc.port, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPortText
		portElements = new Control[] { portLabel, port, portHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createQosGroup(FormToolkit widgetFactory, final Composite parent) {
		Section qosSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		qosSection.setText(EsbMessages.WSDLEndPointPropertiesEditionPart_QosGroupLabel);
		GridData qosSectionData = new GridData(GridData.FILL_HORIZONTAL);
		qosSectionData.horizontalSpan = 3;
		qosSection.setLayoutData(qosSectionData);
		qosGroup = widgetFactory.createComposite(qosSection);
		GridLayout qosGroupLayout = new GridLayout();
		qosGroupLayout.numColumns = 3;
		qosGroup.setLayout(qosGroupLayout);
		qosSection.setClient(qosGroup);
		return qosGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createReliableMessagingEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		reliableMessagingEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled, EsbMessages.WSDLEndPointPropertiesEditionPart_ReliableMessagingEnabledLabel), SWT.CHECK);
		reliableMessagingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reliableMessagingEnabled.getSelection())));
				validate();
			}

		});
		GridData reliableMessagingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		reliableMessagingEnabledData.horizontalSpan = 2;
		reliableMessagingEnabled.setLayoutData(reliableMessagingEnabledData);
		EditingUtils.setID(reliableMessagingEnabled, EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled);
		EditingUtils.setEEFtype(reliableMessagingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control reliableMessagingEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReliableMessagingEnabledCheckbox
		reliableMessagingEnabledElements = new Control[] {reliableMessagingEnabled, reliableMessagingEnabledHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createSecurityEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		securityEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled, EsbMessages.WSDLEndPointPropertiesEditionPart_SecurityEnabledLabel), SWT.CHECK);
		securityEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(securityEnabled.getSelection())));
				validate();
			}

		});
		GridData securityEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		securityEnabledData.horizontalSpan = 2;
		securityEnabled.setLayoutData(securityEnabledData);
		EditingUtils.setID(securityEnabled, EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled);
		EditingUtils.setEEFtype(securityEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control securityEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSecurityEnabledCheckbox
		securityEnabledElements = new Control[] {securityEnabled, securityEnabledHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createAddressingEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		addressingEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled, EsbMessages.WSDLEndPointPropertiesEditionPart_AddressingEnabledLabel), SWT.CHECK);
		addressingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(addressingEnabled.getSelection())));
				refresh();
			}

		});
		GridData addressingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		addressingEnabledData.horizontalSpan = 2;
		addressingEnabled.setLayoutData(addressingEnabledData);
		EditingUtils.setID(addressingEnabled, EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled);
		EditingUtils.setEEFtype(addressingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control addressingEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingEnabledCheckbox
		addressingEnabledElements = new Control[] {addressingEnabled, addressingEnabledHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createAddressingVersionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control addressingVersionLabel = createDescription(parent, EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion, EsbMessages.WSDLEndPointPropertiesEditionPart_AddressingVersionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAddressingVersion()));
			}

		});
		addressingVersion.setID(EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion);
		Control addressingVersionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingVersionEMFComboViewer
		addressingVersionElements = new Control[] {addressingVersionLabel, addressingVersion.getCombo(), addressingVersionHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createAddressingSeparateListenerCheckbox(FormToolkit widgetFactory, Composite parent) {
		addressingSeparateListener = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener, EsbMessages.WSDLEndPointPropertiesEditionPart_AddressingSeparateListenerLabel), SWT.CHECK);
		addressingSeparateListener.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(addressingSeparateListener.getSelection())));
			}

		});
		GridData addressingSeparateListenerData = new GridData(GridData.FILL_HORIZONTAL);
		addressingSeparateListenerData.horizontalSpan = 2;
		addressingSeparateListener.setLayoutData(addressingSeparateListenerData);
		EditingUtils.setID(addressingSeparateListener, EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener);
		EditingUtils.setEEFtype(addressingSeparateListener, "eef::Checkbox"); //$NON-NLS-1$
		Control addressingSeparateListenerHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAddressingSeparateListenerCheckbox
		addressingSeparateListenerElements = new Control[] {addressingSeparateListener, addressingSeparateListenerHelp};
		// End of user code
		return parent;
	}

	protected Composite createTimeoutGroup(FormToolkit widgetFactory, final Composite parent) {
		Section timeoutSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		timeoutSection.setText(EsbMessages.WSDLEndPointPropertiesEditionPart_TimeoutGroupLabel);
		GridData timeoutSectionData = new GridData(GridData.FILL_HORIZONTAL);
		timeoutSectionData.horizontalSpan = 3;
		timeoutSection.setLayoutData(timeoutSectionData);
		Composite timeoutGroup = widgetFactory.createComposite(timeoutSection);
		GridLayout timeoutGroupLayout = new GridLayout();
		timeoutGroupLayout.numColumns = 3;
		timeoutGroup.setLayout(timeoutGroupLayout);
		timeoutSection.setClient(timeoutGroup);
		return timeoutGroup;
	}

	protected Composite createTimeOutDurationText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration, EsbMessages.WSDLEndPointPropertiesEditionPart_TimeOutDurationLabel);
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
							WSDLEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, timeOutDuration.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WSDLEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration,
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
									WSDLEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, timeOutDuration.getText()));
				}
			}
		});
		EditingUtils.setID(timeOutDuration, EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration);
		EditingUtils.setEEFtype(timeOutDuration, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTimeOutDurationText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createTimeOutActionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction, EsbMessages.WSDLEndPointPropertiesEditionPart_TimeOutActionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTimeOutAction()));
			}

		});
		timeOutAction.setID(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTimeOutActionEMFComboViewer

		// End of user code
		return parent;
	}


	/**
   * 
   */
  protected Composite createFailoverErrorCodesGroup(FormToolkit widgetFactory, final Composite parent) {
    Section failoverErrorCodesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
    failoverErrorCodesSection.setText(EsbMessages.WSDLEndPointPropertiesEditionPart_FailoverErrorCodesGroupLabel);
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

  protected Composite createFailoverNonRetryErrorCodesText(FormToolkit widgetFactory, Composite parent) {
	Control failoverNonRetryErrorCodesLabel = createDescription(parent, EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes, EsbMessages.WSDLEndPointPropertiesEditionPart_FailoverNonRetryErrorCodesLabel);
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
              WSDLEndPointPropertiesEditionPartForm.this,
              EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes,
              PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failoverNonRetryErrorCodes.getText()));
          propertiesEditionComponent
              .firePropertiesChanged(new PropertiesEditionEvent(
                  WSDLEndPointPropertiesEditionPartForm.this,
                  EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes,
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
                  WSDLEndPointPropertiesEditionPartForm.this,
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
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this, EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failoverNonRetryErrorCodes.getText()));
        }
      }
    });
    EditingUtils.setID(failoverNonRetryErrorCodes, EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes);
    EditingUtils.setEEFtype(failoverNonRetryErrorCodes, "eef::Text"); //$NON-NLS-1$
    Control failoverNonRetryErrorCodesHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getEndPointName()
	 * 
	 */
	public String getEndPointName() {
		return endPointName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setEndPointName(String newValue)
	 * 
	 */
	public void setEndPointName(String newValue) {
		if (newValue != null) {
			endPointName.setText(newValue);
		} else {
			endPointName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Properties.endPointName);
		if (eefElementEditorReadOnlyState && endPointName.isEnabled()) {
			endPointName.setEnabled(false);
			endPointName.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endPointName.isEnabled()) {
			endPointName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getAnonymous()
	 * 
	 */
	public Boolean getAnonymous() {
		return Boolean.valueOf(anonymous.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setAnonymous(Boolean newValue)
	 * 
	 */
	public void setAnonymous(Boolean newValue) {
		if (newValue != null) {
			anonymous.setSelection(newValue.booleanValue());
		} else {
			anonymous.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Properties.anonymous);
		if (eefElementEditorReadOnlyState && anonymous.isEnabled()) {
			anonymous.setEnabled(false);
			anonymous.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !anonymous.isEnabled()) {
			anonymous.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getDuplicate()
	 * 
	 */
	public Boolean getDuplicate() {
		return Boolean.valueOf(duplicate.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setDuplicate(Boolean newValue)
	 * 
	 */
	public void setDuplicate(Boolean newValue) {
		if (newValue != null) {
			duplicate.setSelection(newValue.booleanValue());
		} else {
			duplicate.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Properties.duplicate);
		if (eefElementEditorReadOnlyState && duplicate.isEnabled()) {
			duplicate.setEnabled(false);
			duplicate.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !duplicate.isEnabled()) {
			duplicate.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getReversed()
	 * 
	 */
	public Boolean getReversed() {
		return Boolean.valueOf(reversed.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setReversed(Boolean newValue)
	 * 
	 */
	public void setReversed(Boolean newValue) {
		if (newValue != null) {
			reversed.setSelection(newValue.booleanValue());
		} else {
			reversed.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Properties.reversed);
		if (eefElementEditorReadOnlyState && reversed.isEnabled()) {
			reversed.setEnabled(false);
			reversed.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reversed.isEnabled()) {
			reversed.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#initTemplateParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTemplateParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		templateParameters.setContentProvider(contentProvider);
		templateParameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Properties.templateParameters);
		if (eefElementEditorReadOnlyState && templateParameters.isEnabled()) {
			templateParameters.setEnabled(false);
			templateParameters.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !templateParameters.isEnabled()) {
			templateParameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#updateTemplateParameters()
	 * 
	 */
	public void updateTemplateParameters() {
	templateParameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#addFilterTemplateParameters(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#addBusinessFilterTemplateParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTemplateParameters(ViewerFilter filter) {
		templateParametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#isContainedInTemplateParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInTemplateParametersTable(EObject element) {
		return ((ReferencesTableSettings)templateParameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getInLine()
	 * 
	 */
	public Boolean getInLine() {
		return Boolean.valueOf(inLine.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setInLine(Boolean newValue)
	 * 
	 */
	public void setInLine(Boolean newValue) {
		if (newValue != null) {
			inLine.setSelection(newValue.booleanValue());
		} else {
			inLine.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Basic.inLine);
		if (eefElementEditorReadOnlyState && inLine.isEnabled()) {
			inLine.setEnabled(false);
			inLine.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inLine.isEnabled()) {
			inLine.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getFormat()
	 * 
	 */
	public Enumerator getFormat() {
		Enumerator selection = (Enumerator) ((StructuredSelection) format.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#initFormat(Object input, Enumerator current)
	 */
	public void initFormat(Object input, Enumerator current) {
		format.setInput(input);
		format.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Basic.format);
		if (eefElementEditorReadOnlyState && format.isEnabled()) {
			format.setEnabled(false);
			format.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !format.isEnabled()) {
			format.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setFormat(Enumerator newValue)
	 * 
	 */
	public void setFormat(Enumerator newValue) {
		format.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Basic.format);
		if (eefElementEditorReadOnlyState && format.isEnabled()) {
			format.setEnabled(false);
			format.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !format.isEnabled()) {
			format.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getTraceEnabled()
	 * 
	 */
	public Boolean getTraceEnabled() {
		return Boolean.valueOf(traceEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setTraceEnabled(Boolean newValue)
	 * 
	 */
	public void setTraceEnabled(Boolean newValue) {
		if (newValue != null) {
			traceEnabled.setSelection(newValue.booleanValue());
		} else {
			traceEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled);
		if (eefElementEditorReadOnlyState && traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(false);
			traceEnabled.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getStatisticsEnabled()
	 * 
	 */
	public Boolean getStatisticsEnabled() {
		return Boolean.valueOf(statisticsEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setStatisticsEnabled(Boolean newValue)
	 * 
	 */
	public void setStatisticsEnabled(Boolean newValue) {
		if (newValue != null) {
			statisticsEnabled.setSelection(newValue.booleanValue());
		} else {
			statisticsEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled);
		if (eefElementEditorReadOnlyState && statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(false);
			statisticsEnabled.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getSuspendErrorCodes()
	 * 
	 */
	public String getSuspendErrorCodes() {
		return suspendErrorCodes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setSuspendErrorCodes(String newValue)
	 * 
	 */
	public void setSuspendErrorCodes(String newValue) {
		if (newValue != null) {
			suspendErrorCodes.setText(newValue);
		} else {
			suspendErrorCodes.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes);
		if (eefElementEditorReadOnlyState && suspendErrorCodes.isEnabled()) {
			suspendErrorCodes.setEnabled(false);
			suspendErrorCodes.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendErrorCodes.isEnabled()) {
			suspendErrorCodes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getSuspendInitialDuration()
	 * 
	 */
	public String getSuspendInitialDuration() {
		return suspendInitialDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setSuspendInitialDuration(String newValue)
	 * 
	 */
	public void setSuspendInitialDuration(String newValue) {
		if (newValue != null) {
			suspendInitialDuration.setText(newValue);
		} else {
			suspendInitialDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration);
		if (eefElementEditorReadOnlyState && suspendInitialDuration.isEnabled()) {
			suspendInitialDuration.setEnabled(false);
			suspendInitialDuration.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendInitialDuration.isEnabled()) {
			suspendInitialDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getSuspendMaximumDuration()
	 * 
	 */
	public String getSuspendMaximumDuration() {
		return suspendMaximumDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setSuspendMaximumDuration(String newValue)
	 * 
	 */
	public void setSuspendMaximumDuration(String newValue) {
		if (newValue != null) {
			suspendMaximumDuration.setText(newValue);
		} else {
			suspendMaximumDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration);
		if (eefElementEditorReadOnlyState && suspendMaximumDuration.isEnabled()) {
			suspendMaximumDuration.setEnabled(false);
			suspendMaximumDuration.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendMaximumDuration.isEnabled()) {
			suspendMaximumDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getSuspendProgressionFactor()
	 * 
	 */
	public String getSuspendProgressionFactor() {
		return suspendProgressionFactor.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setSuspendProgressionFactor(String newValue)
	 * 
	 */
	public void setSuspendProgressionFactor(String newValue) {
		if (newValue != null) {
			suspendProgressionFactor.setText(newValue);
		} else {
			suspendProgressionFactor.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor);
		if (eefElementEditorReadOnlyState && suspendProgressionFactor.isEnabled()) {
			suspendProgressionFactor.setEnabled(false);
			suspendProgressionFactor.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !suspendProgressionFactor.isEnabled()) {
			suspendProgressionFactor.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getRetryErrorCodes()
	 * 
	 */
	public String getRetryErrorCodes() {
		return retryErrorCodes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setRetryErrorCodes(String newValue)
	 * 
	 */
	public void setRetryErrorCodes(String newValue) {
		if (newValue != null) {
			retryErrorCodes.setText(newValue);
		} else {
			retryErrorCodes.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes);
		if (eefElementEditorReadOnlyState && retryErrorCodes.isEnabled()) {
			retryErrorCodes.setEnabled(false);
			retryErrorCodes.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryErrorCodes.isEnabled()) {
			retryErrorCodes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getRetryCount()
	 * 
	 */
	public String getRetryCount() {
		return retryCount.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setRetryCount(String newValue)
	 * 
	 */
	public void setRetryCount(String newValue) {
		if (newValue != null) {
			retryCount.setText(newValue);
		} else {
			retryCount.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount);
		if (eefElementEditorReadOnlyState && retryCount.isEnabled()) {
			retryCount.setEnabled(false);
			retryCount.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryCount.isEnabled()) {
			retryCount.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getRetryDelay()
	 * 
	 */
	public String getRetryDelay() {
		return retryDelay.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setRetryDelay(String newValue)
	 * 
	 */
	public void setRetryDelay(String newValue) {
		if (newValue != null) {
			retryDelay.setText(newValue);
		} else {
			retryDelay.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay);
		if (eefElementEditorReadOnlyState && retryDelay.isEnabled()) {
			retryDelay.setEnabled(false);
			retryDelay.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryDelay.isEnabled()) {
			retryDelay.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#initProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		properties.setContentProvider(contentProvider);
		properties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Misc.properties);
		if (eefElementEditorReadOnlyState && properties.isEnabled()) {
			properties.setEnabled(false);
			properties.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !properties.isEnabled()) {
			properties.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#updateProperties()
	 * 
	 */
	public void updateProperties() {
	properties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#addFilterProperties(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#addBusinessFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToProperties(ViewerFilter filter) {
		propertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#isContainedInPropertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPropertiesTable(EObject element) {
		return ((ReferencesTableSettings)properties.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getOptimize()
	 * 
	 */
	public Enumerator getOptimize() {
		Enumerator selection = (Enumerator) ((StructuredSelection) optimize.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#initOptimize(Object input, Enumerator current)
	 */
	public void initOptimize(Object input, Enumerator current) {
		optimize.setInput(input);
		optimize.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Misc.optimize);
		if (eefElementEditorReadOnlyState && optimize.isEnabled()) {
			optimize.setEnabled(false);
			optimize.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !optimize.isEnabled()) {
			optimize.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setOptimize(Enumerator newValue)
	 * 
	 */
	public void setOptimize(Enumerator newValue) {
		optimize.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Misc.optimize);
		if (eefElementEditorReadOnlyState && optimize.isEnabled()) {
			optimize.setEnabled(false);
			optimize.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !optimize.isEnabled()) {
			optimize.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Misc.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getWsdlUri()
	 * 
	 */
	public String getWsdlUri() {
		return wsdlUri.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setWsdlUri(String newValue)
	 * 
	 */
	public void setWsdlUri(String newValue) {
		if (newValue != null) {
			wsdlUri.setText(newValue);
		} else {
			wsdlUri.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri);
		if (eefElementEditorReadOnlyState && wsdlUri.isEnabled()) {
			wsdlUri.setEnabled(false);
			wsdlUri.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !wsdlUri.isEnabled()) {
			wsdlUri.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getService()
	 * 
	 */
	public String getService() {
		return service.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setService(String newValue)
	 * 
	 */
	public void setService(String newValue) {
		if (newValue != null) {
			service.setText(newValue);
		} else {
			service.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Misc.service);
		if (eefElementEditorReadOnlyState && service.isEnabled()) {
			service.setEnabled(false);
			service.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !service.isEnabled()) {
			service.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getPort()
	 * 
	 */
	public String getPort() {
		return port.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setPort(String newValue)
	 * 
	 */
	public void setPort(String newValue) {
		if (newValue != null) {
			port.setText(newValue);
		} else {
			port.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Misc.port);
		if (eefElementEditorReadOnlyState && port.isEnabled()) {
			port.setEnabled(false);
			port.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !port.isEnabled()) {
			port.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getReliableMessagingEnabled()
	 * 
	 */
	public Boolean getReliableMessagingEnabled() {
		return Boolean.valueOf(reliableMessagingEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setReliableMessagingEnabled(Boolean newValue)
	 * 
	 */
	public void setReliableMessagingEnabled(Boolean newValue) {
		if (newValue != null) {
			reliableMessagingEnabled.setSelection(newValue.booleanValue());
		} else {
			reliableMessagingEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled);
		if (eefElementEditorReadOnlyState && reliableMessagingEnabled.isEnabled()) {
			reliableMessagingEnabled.setEnabled(false);
			reliableMessagingEnabled.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reliableMessagingEnabled.isEnabled()) {
			reliableMessagingEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getSecurityEnabled()
	 * 
	 */
	public Boolean getSecurityEnabled() {
		return Boolean.valueOf(securityEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setSecurityEnabled(Boolean newValue)
	 * 
	 */
	public void setSecurityEnabled(Boolean newValue) {
		if (newValue != null) {
			securityEnabled.setSelection(newValue.booleanValue());
		} else {
			securityEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled);
		if (eefElementEditorReadOnlyState && securityEnabled.isEnabled()) {
			securityEnabled.setEnabled(false);
			securityEnabled.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !securityEnabled.isEnabled()) {
			securityEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getAddressingEnabled()
	 * 
	 */
	public Boolean getAddressingEnabled() {
		return Boolean.valueOf(addressingEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setAddressingEnabled(Boolean newValue)
	 * 
	 */
	public void setAddressingEnabled(Boolean newValue) {
		if (newValue != null) {
			addressingEnabled.setSelection(newValue.booleanValue());
		} else {
			addressingEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled);
		if (eefElementEditorReadOnlyState && addressingEnabled.isEnabled()) {
			addressingEnabled.setEnabled(false);
			addressingEnabled.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingEnabled.isEnabled()) {
			addressingEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getAddressingVersion()
	 * 
	 */
	public Enumerator getAddressingVersion() {
		Enumerator selection = (Enumerator) ((StructuredSelection) addressingVersion.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#initAddressingVersion(Object input, Enumerator current)
	 */
	public void initAddressingVersion(Object input, Enumerator current) {
		addressingVersion.setInput(input);
		addressingVersion.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion);
		if (eefElementEditorReadOnlyState && addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(false);
			addressingVersion.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setAddressingVersion(Enumerator newValue)
	 * 
	 */
	public void setAddressingVersion(Enumerator newValue) {
		addressingVersion.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion);
		if (eefElementEditorReadOnlyState && addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(false);
			addressingVersion.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingVersion.isEnabled()) {
			addressingVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getAddressingSeparateListener()
	 * 
	 */
	public Boolean getAddressingSeparateListener() {
		return Boolean.valueOf(addressingSeparateListener.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setAddressingSeparateListener(Boolean newValue)
	 * 
	 */
	public void setAddressingSeparateListener(Boolean newValue) {
		if (newValue != null) {
			addressingSeparateListener.setSelection(newValue.booleanValue());
		} else {
			addressingSeparateListener.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener);
		if (eefElementEditorReadOnlyState && addressingSeparateListener.isEnabled()) {
			addressingSeparateListener.setEnabled(false);
			addressingSeparateListener.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !addressingSeparateListener.isEnabled()) {
			addressingSeparateListener.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getTimeOutDuration()
	 * 
	 */
	public String getTimeOutDuration() {
		return timeOutDuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setTimeOutDuration(String newValue)
	 * 
	 */
	public void setTimeOutDuration(String newValue) {
		if (newValue != null) {
			timeOutDuration.setText(newValue);
		} else {
			timeOutDuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration);
		if (eefElementEditorReadOnlyState && timeOutDuration.isEnabled()) {
			timeOutDuration.setEnabled(false);
			timeOutDuration.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutDuration.isEnabled()) {
			timeOutDuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getTimeOutAction()
	 * 
	 */
	public Enumerator getTimeOutAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) timeOutAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#initTimeOutAction(Object input, Enumerator current)
	 */
	public void initTimeOutAction(Object input, Enumerator current) {
		timeOutAction.setInput(input);
		timeOutAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction);
		if (eefElementEditorReadOnlyState && timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(false);
			timeOutAction.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setTimeOutAction(Enumerator newValue)
	 * 
	 */
	public void setTimeOutAction(Enumerator newValue) {
		timeOutAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction);
		if (eefElementEditorReadOnlyState && timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(false);
			timeOutAction.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timeOutAction.isEnabled()) {
			timeOutAction.setEnabled(true);
		}	
		
	}






	/**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#getFailoverNonRetryErrorCodes()
   * 
   */
  public String getFailoverNonRetryErrorCodes() {
    return failoverNonRetryErrorCodes.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart#setFailoverNonRetryErrorCodes(String newValue)
   * 
   */
  public void setFailoverNonRetryErrorCodes(String newValue) {
    if (newValue != null) {
      failoverNonRetryErrorCodes.setText(newValue);
    } else {
      failoverNonRetryErrorCodes.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes);
    if (eefElementEditorReadOnlyState && failoverNonRetryErrorCodes.isEnabled()) {
      failoverNonRetryErrorCodes.setEnabled(false);
      failoverNonRetryErrorCodes.setToolTipText(EsbMessages.WSDLEndPoint_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !failoverNonRetryErrorCodes.isEnabled()) {
      failoverNonRetryErrorCodes.setEnabled(true);
    }	
    
  }

    // Start of user code for reliableMessagingPolicy specific getters and setters implementation
    @Override
    public void setReliableMessagingPolicy(RegistryKeyProperty registryKeyProperty) {
        if (reliableMessagingPolicy != null) {
            reliableMessagingPolicy = registryKeyProperty;
            reliableMessagingPolicyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getReliableMessagingPolicy() {
        return reliableMessagingPolicy;
    }
	// End of user code

	// Start of user code for securityPolicy specific getters and setters implementation
    @Override
    public void setSecurityPolicy(RegistryKeyProperty registryKeyProperty) {
        if (securityPolicy != null) {
            securityPolicy = registryKeyProperty;
            securityPolicyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getSecurityPolicy() {
        return securityPolicy;
    }
	// End of user code

	// Start of user code for inboundPolicy specific getters and setters implementation
    @Override
    public void setInboundPolicy(RegistryKeyProperty registryKeyProperty) {
        if (inboundPolicy != null) {
            inboundPolicy = registryKeyProperty;
            inboundPolicyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getInboundPolicy() {
        return inboundPolicy;
    }
	// End of user code

	// Start of user code for outboundPolicy specific getters and setters implementation
    @Override
    public void setOutboundPolicy(RegistryKeyProperty registryKeyProperty) {
        if (outboundPolicy != null) {
            outboundPolicy = registryKeyProperty;
            outboundPolicyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getOutboundPolicy() {
        return outboundPolicy;
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.WSDLEndPoint_Part_Title;
	}









	// Start of user code additional methods
	protected Composite createReliableMessagingPolicy(FormToolkit widgetFactory, final Composite parent) {
        Control reliableMessagingPolicyLabel = createDescription(parent, EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingPolicy,
                EsbMessages.WSDLEndPointPropertiesEditionPart_ReliableMessagingPolicyLabel);
        widgetFactory.paintBordersFor(parent);
        if (reliableMessagingPolicy == null) {
            reliableMessagingPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initReliableMessagingPolicy = reliableMessagingPolicy.getKeyValue().isEmpty() ? "" : reliableMessagingPolicy.getKeyValue();
        reliableMessagingPolicyText = widgetFactory.createText(parent, initReliableMessagingPolicy, SWT.READ_ONLY);
        reliableMessagingPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        reliableMessagingPolicyText.setLayoutData(valueData);
        reliableMessagingPolicyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, reliableMessagingPolicy, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                reliableMessagingPolicyText.setText(reliableMessagingPolicy.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this,
                                EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingPolicy, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getReliableMessagingPolicy()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        
        reliableMessagingPolicyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, reliableMessagingPolicy, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    reliableMessagingPolicyText.setText(reliableMessagingPolicy.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this,
                                    EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingPolicy, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getReliableMessagingPolicy()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(reliableMessagingPolicyText, EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingPolicy);
        EditingUtils.setEEFtype(reliableMessagingPolicyText, "eef::Text");
        Control reliableMessagingPolicyHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingPolicy, EsbViewsRepository.FORM_KIND),
                        null);
        reliableMessagingPolicyElements = new Control[] { reliableMessagingPolicyLabel, reliableMessagingPolicyText, reliableMessagingPolicyHelp };
        return parent;
    }
	
	protected Composite createSecurityPolicy(FormToolkit widgetFactory, final Composite parent) {
        Control securityPolicyLabel = createDescription(parent, EsbViewsRepository.WSDLEndPoint.Qos.securityPolicy,
                EsbMessages.WSDLEndPointPropertiesEditionPart_SecurityPolicyLabel);
        widgetFactory.paintBordersFor(parent);
        if (securityPolicy == null) {
            securityPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initSecurityPolicy = securityPolicy.getKeyValue().isEmpty() ? "" : securityPolicy.getKeyValue();
        securityPolicyText = widgetFactory.createText(parent, initSecurityPolicy, SWT.READ_ONLY);
        securityPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        securityPolicyText.setLayoutData(valueData);
        securityPolicyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, securityPolicy, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                securityPolicyText.setText(securityPolicy.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this,
                                EsbViewsRepository.WSDLEndPoint.Qos.securityPolicy, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getSecurityPolicy()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        
        securityPolicyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, securityPolicy, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    securityPolicyText.setText(securityPolicy.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this,
                                    EsbViewsRepository.WSDLEndPoint.Qos.securityPolicy, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getSecurityPolicy()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(securityPolicyText, EsbViewsRepository.WSDLEndPoint.Qos.securityPolicy);
        EditingUtils.setEEFtype(securityPolicyText, "eef::Text");
        Control securityPolicyHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.WSDLEndPoint.Qos.securityPolicy, EsbViewsRepository.FORM_KIND),
                        null);
        securityPolicyElements = new Control[] { securityPolicyLabel, securityPolicyText, securityPolicyHelp };
        return parent;
    }
	
	protected Composite createInboundPolicy(FormToolkit widgetFactory, final Composite parent) {
        Control inboundPolicyLabel = createDescription(parent, EsbViewsRepository.WSDLEndPoint.Qos.inboundPolicy,
                EsbMessages.WSDLEndPointPropertiesEditionPart_InboundPolicyLabel);
        widgetFactory.paintBordersFor(parent);
        if (inboundPolicy == null) {
            inboundPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initInboundPolicy = inboundPolicy.getKeyValue().isEmpty() ? "" : inboundPolicy.getKeyValue();
        inboundPolicyText = widgetFactory.createText(parent, initInboundPolicy, SWT.READ_ONLY);
        inboundPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        inboundPolicyText.setLayoutData(valueData);
        inboundPolicyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, inboundPolicy, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                inboundPolicyText.setText(inboundPolicy.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this,
                                EsbViewsRepository.WSDLEndPoint.Qos.inboundPolicy, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getInboundPolicy()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        
        inboundPolicyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, inboundPolicy, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    inboundPolicyText.setText(inboundPolicy.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this,
                                    EsbViewsRepository.WSDLEndPoint.Qos.inboundPolicy, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getInboundPolicy()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(inboundPolicyText, EsbViewsRepository.WSDLEndPoint.Qos.inboundPolicy);
        EditingUtils.setEEFtype(inboundPolicyText, "eef::Text");
        Control inboundPolicyHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.WSDLEndPoint.Qos.inboundPolicy, EsbViewsRepository.FORM_KIND),
                        null);
        inboundPolicyElements = new Control[] { inboundPolicyLabel, inboundPolicyText, inboundPolicyHelp };
        return parent;
    }

	protected Composite createOutboundPolicy(FormToolkit widgetFactory, final Composite parent) {
        Control outboundPolicyLabel = createDescription(parent, EsbViewsRepository.WSDLEndPoint.Qos.outboundPolicy,
                EsbMessages.WSDLEndPointPropertiesEditionPart_OutboundPolicyLabel);
        widgetFactory.paintBordersFor(parent);
        if (outboundPolicy == null) {
            outboundPolicy = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initOutboundPolicy = outboundPolicy.getKeyValue().isEmpty() ? "" : outboundPolicy.getKeyValue();
        outboundPolicyText = widgetFactory.createText(parent, initOutboundPolicy, SWT.READ_ONLY);
        outboundPolicyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        outboundPolicyText.setLayoutData(valueData);
        outboundPolicyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, outboundPolicy, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                outboundPolicyText.setText(outboundPolicy.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this,
                                EsbViewsRepository.WSDLEndPoint.Qos.outboundPolicy, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getOutboundPolicy()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        
        outboundPolicyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, outboundPolicy, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    outboundPolicyText.setText(outboundPolicy.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(WSDLEndPointPropertiesEditionPartForm.this,
                                    EsbViewsRepository.WSDLEndPoint.Qos.outboundPolicy, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getOutboundPolicy()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(outboundPolicyText, EsbViewsRepository.WSDLEndPoint.Qos.outboundPolicy);
        EditingUtils.setEEFtype(outboundPolicyText, "eef::Text");
        Control outboundPolicyHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.WSDLEndPoint.Qos.outboundPolicy, EsbViewsRepository.FORM_KIND),
                        null);
        outboundPolicyElements = new Control[] { outboundPolicyLabel, outboundPolicyText, outboundPolicyHelp };
        return parent;
    }
	
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }
    
    public void validate() {
        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { propertiesGroup });
        eu.clearElements(new Composite[] { qosGroup });
        
        ((GridData) propertiesSection.getLayoutData()).exclude = true;
        propertiesSection.setVisible(false);
        
        eu.showEntry(reliableMessagingEnabledElements, false);
        eu.showEntry(securityEnabledElements, false);
        eu.showEntry(addressingEnabledElements, false);
        
        eu.showEntry(failoverNonRetryErrorCodesElements, false);
        
        if (getReliableMessagingEnabled()) {
            eu.showEntry(reliableMessagingPolicyElements, false);
        }
        
        if (getSecurityEnabled()) {
            eu.showEntry(securityPolicyElements, false);
            eu.showEntry(inboundPolicyElements, false);
            eu.showEntry(outboundPolicyElements, false);
        }
        
        if (getAddressingEnabled()) {
            eu.showEntry(addressingVersionElements, false);
            eu.showEntry(addressingSeparateListenerElements, false);
        }
        
        view.layout(true, true);
    }
	// End of user code


}
