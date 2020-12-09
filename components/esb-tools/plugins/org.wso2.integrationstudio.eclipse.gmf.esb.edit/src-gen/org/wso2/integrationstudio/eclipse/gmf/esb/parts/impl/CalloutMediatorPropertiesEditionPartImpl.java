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
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CalloutMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CalloutMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Button passHeaders;
	protected EMFComboViewer endpointType;
	protected Text soapAction;
	protected Text pathToAxis2Repository;
	protected Text pathToAxis2xml;
	protected Button initAxis2ClientOptions;
	protected Text serviceURL;
	// Start of user code  for Address Endpoint widgets declarations
	
	// End of user code

	protected EMFComboViewer payloadType;
	protected Text payloadProperty;
	// Start of user code  for Payload Message Xpath widgets declarations
	
	// End of user code

	protected EMFComboViewer resultType;
	protected Text resultContextProperty;
	// Start of user code  for Result Message Xpath widgets declarations
	
	// End of user code

	protected EMFComboViewer policies;
	protected EMFComboViewer securityType;
	// Start of user code  for Policy Key widgets declarations
	
	// End of user code

	// Start of user code  for Outbound Policy Key widgets declarations
	
	// End of user code

	// Start of user code  for Inbound Policy Key widgets declarations
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CalloutMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence calloutMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep miscStep = calloutMediatorStep.addStep(EsbViewsRepository.CalloutMediator.Misc.class);
		miscStep.addStep(EsbViewsRepository.CalloutMediator.Misc.description);
		miscStep.addStep(EsbViewsRepository.CalloutMediator.Misc.commentsList);
		miscStep.addStep(EsbViewsRepository.CalloutMediator.Misc.reverse);
		miscStep.addStep(EsbViewsRepository.CalloutMediator.Misc.passHeaders);
		
		CompositionStep serviceStep = calloutMediatorStep.addStep(EsbViewsRepository.CalloutMediator.Service.class);
		serviceStep.addStep(EsbViewsRepository.CalloutMediator.Service.endpointType);
		serviceStep.addStep(EsbViewsRepository.CalloutMediator.Service.soapAction);
		serviceStep.addStep(EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository);
		serviceStep.addStep(EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml);
		serviceStep.addStep(EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions);
		serviceStep.addStep(EsbViewsRepository.CalloutMediator.Service.serviceURL);
		serviceStep.addStep(EsbViewsRepository.CalloutMediator.Service.addressEndpoint);
		
		CompositionStep sourceStep = calloutMediatorStep.addStep(EsbViewsRepository.CalloutMediator.Source.class);
		sourceStep.addStep(EsbViewsRepository.CalloutMediator.Source.payloadType);
		sourceStep.addStep(EsbViewsRepository.CalloutMediator.Source.payloadProperty);
		sourceStep.addStep(EsbViewsRepository.CalloutMediator.Source.payloadMessageXpath);
		
		CompositionStep targetStep = calloutMediatorStep.addStep(EsbViewsRepository.CalloutMediator.Target.class);
		targetStep.addStep(EsbViewsRepository.CalloutMediator.Target.resultType);
		targetStep.addStep(EsbViewsRepository.CalloutMediator.Target.resultContextProperty);
		targetStep.addStep(EsbViewsRepository.CalloutMediator.Target.resultMessageXpath);
		
		CompositionStep wSStep = calloutMediatorStep.addStep(EsbViewsRepository.CalloutMediator.WS.class);
		wSStep.addStep(EsbViewsRepository.CalloutMediator.WS.policies);
		wSStep.addStep(EsbViewsRepository.CalloutMediator.WS.securityType);
		wSStep.addStep(EsbViewsRepository.CalloutMediator.WS.policyKey);
		wSStep.addStep(EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey);
		wSStep.addStep(EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey);
		
		
		composer = new PartComposer(calloutMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CalloutMediator.Misc.class) {
					return createMiscGroup(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Misc.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Misc.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Misc.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Misc.passHeaders) {
					return createPassHeadersCheckbox(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.class) {
					return createServiceGroup(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.endpointType) {
					return createEndpointTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.soapAction) {
					return createSoapActionText(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository) {
					return createPathToAxis2RepositoryText(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml) {
					return createPathToAxis2xmlText(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions) {
					return createInitAxis2ClientOptionsCheckbox(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.serviceURL) {
					return createServiceURLText(parent);
				}
				// Start of user code for Address Endpoint addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.CalloutMediator.Source.class) {
					return createSourceGroup(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Source.payloadType) {
					return createPayloadTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Source.payloadProperty) {
					return createPayloadPropertyText(parent);
				}
				// Start of user code for Payload Message Xpath addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.CalloutMediator.Target.class) {
					return createTargetGroup(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Target.resultType) {
					return createResultTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Target.resultContextProperty) {
					return createResultContextPropertyText(parent);
				}
				// Start of user code for Result Message Xpath addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.CalloutMediator.WS.class) {
					return createWSGroup(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.WS.policies) {
					return createPoliciesEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.WS.securityType) {
					return createSecurityTypeEMFComboViewer(parent);
				}
				// Start of user code for Policy Key addToPart creation
				
				// End of user code
				// Start of user code for Outbound Policy Key addToPart creation
				
				// End of user code
				// Start of user code for Inbound Policy Key addToPart creation
				
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createMiscGroup(Composite parent) {
		Group miscGroup = new Group(parent, SWT.NONE);
		miscGroup.setText(EsbMessages.CalloutMediatorPropertiesEditionPart_MiscGroupLabel);
		GridData miscGroupData = new GridData(GridData.FILL_HORIZONTAL);
		miscGroupData.horizontalSpan = 3;
		miscGroup.setLayoutData(miscGroupData);
		GridLayout miscGroupLayout = new GridLayout();
		miscGroupLayout.numColumns = 3;
		miscGroup.setLayout(miscGroupLayout);
		return miscGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Misc.description, EsbMessages.CalloutMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.CalloutMediator.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Misc.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.CalloutMediator.Misc.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.CalloutMediator.Misc.commentsList, EsbMessages.CalloutMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "CalloutMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Misc.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.CalloutMediator.Misc.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.CalloutMediator.Misc.reverse, EsbMessages.CalloutMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Misc.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.CalloutMediator.Misc.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Misc.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createPassHeadersCheckbox(Composite parent) {
		passHeaders = new Button(parent, SWT.CHECK);
		passHeaders.setText(getDescription(EsbViewsRepository.CalloutMediator.Misc.passHeaders, EsbMessages.CalloutMediatorPropertiesEditionPart_PassHeadersLabel));
		passHeaders.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Misc.passHeaders, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(passHeaders.getSelection())));
			}

		});
		GridData passHeadersData = new GridData(GridData.FILL_HORIZONTAL);
		passHeadersData.horizontalSpan = 2;
		passHeaders.setLayoutData(passHeadersData);
		EditingUtils.setID(passHeaders, EsbViewsRepository.CalloutMediator.Misc.passHeaders);
		EditingUtils.setEEFtype(passHeaders, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Misc.passHeaders, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPassHeadersCheckbox

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createServiceGroup(Composite parent) {
		Group serviceGroup = new Group(parent, SWT.NONE);
		serviceGroup.setText(EsbMessages.CalloutMediatorPropertiesEditionPart_ServiceGroupLabel);
		GridData serviceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		serviceGroupData.horizontalSpan = 3;
		serviceGroup.setLayoutData(serviceGroupData);
		GridLayout serviceGroupLayout = new GridLayout();
		serviceGroupLayout.numColumns = 3;
		serviceGroup.setLayout(serviceGroupLayout);
		return serviceGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createEndpointTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Service.endpointType, EsbMessages.CalloutMediatorPropertiesEditionPart_EndpointTypeLabel);
		endpointType = new EMFComboViewer(parent);
		endpointType.setContentProvider(new ArrayContentProvider());
		endpointType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData endpointTypeData = new GridData(GridData.FILL_HORIZONTAL);
		endpointType.getCombo().setLayoutData(endpointTypeData);
                endpointType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		endpointType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Service.endpointType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEndpointType()));
			}

		});
		endpointType.setID(EsbViewsRepository.CalloutMediator.Service.endpointType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.endpointType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createSoapActionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Service.soapAction, EsbMessages.CalloutMediatorPropertiesEditionPart_SoapActionLabel);
		soapAction = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData soapActionData = new GridData(GridData.FILL_HORIZONTAL);
		soapAction.setLayoutData(soapActionData);
		soapAction.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Service.soapAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, soapAction.getText()));
			}

		});
		soapAction.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Service.soapAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, soapAction.getText()));
				}
			}

		});
		EditingUtils.setID(soapAction, EsbViewsRepository.CalloutMediator.Service.soapAction);
		EditingUtils.setEEFtype(soapAction, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.soapAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSoapActionText

		// End of user code
		return parent;
	}

	
	protected Composite createPathToAxis2RepositoryText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository, EsbMessages.CalloutMediatorPropertiesEditionPart_PathToAxis2RepositoryLabel);
		pathToAxis2Repository = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData pathToAxis2RepositoryData = new GridData(GridData.FILL_HORIZONTAL);
		pathToAxis2Repository.setLayoutData(pathToAxis2RepositoryData);
		pathToAxis2Repository.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2Repository.getText()));
			}

		});
		pathToAxis2Repository.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2Repository.getText()));
				}
			}

		});
		EditingUtils.setID(pathToAxis2Repository, EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository);
		EditingUtils.setEEFtype(pathToAxis2Repository, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPathToAxis2RepositoryText

		// End of user code
		return parent;
	}

	
	protected Composite createPathToAxis2xmlText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml, EsbMessages.CalloutMediatorPropertiesEditionPart_PathToAxis2xmlLabel);
		pathToAxis2xml = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData pathToAxis2xmlData = new GridData(GridData.FILL_HORIZONTAL);
		pathToAxis2xml.setLayoutData(pathToAxis2xmlData);
		pathToAxis2xml.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2xml.getText()));
			}

		});
		pathToAxis2xml.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2xml.getText()));
				}
			}

		});
		EditingUtils.setID(pathToAxis2xml, EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml);
		EditingUtils.setEEFtype(pathToAxis2xml, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPathToAxis2xmlText

		// End of user code
		return parent;
	}

	
	protected Composite createInitAxis2ClientOptionsCheckbox(Composite parent) {
		initAxis2ClientOptions = new Button(parent, SWT.CHECK);
		initAxis2ClientOptions.setText(getDescription(EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions, EsbMessages.CalloutMediatorPropertiesEditionPart_InitAxis2ClientOptionsLabel));
		initAxis2ClientOptions.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(initAxis2ClientOptions.getSelection())));
			}

		});
		GridData initAxis2ClientOptionsData = new GridData(GridData.FILL_HORIZONTAL);
		initAxis2ClientOptionsData.horizontalSpan = 2;
		initAxis2ClientOptions.setLayoutData(initAxis2ClientOptionsData);
		EditingUtils.setID(initAxis2ClientOptions, EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions);
		EditingUtils.setEEFtype(initAxis2ClientOptions, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInitAxis2ClientOptionsCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createServiceURLText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Service.serviceURL, EsbMessages.CalloutMediatorPropertiesEditionPart_ServiceURLLabel);
		serviceURL = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData serviceURLData = new GridData(GridData.FILL_HORIZONTAL);
		serviceURL.setLayoutData(serviceURLData);
		serviceURL.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Service.serviceURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceURL.getText()));
			}

		});
		serviceURL.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Service.serviceURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceURL.getText()));
				}
			}

		});
		EditingUtils.setID(serviceURL, EsbViewsRepository.CalloutMediator.Service.serviceURL);
		EditingUtils.setEEFtype(serviceURL, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.serviceURL, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createServiceURLText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createSourceGroup(Composite parent) {
		Group sourceGroup = new Group(parent, SWT.NONE);
		sourceGroup.setText(EsbMessages.CalloutMediatorPropertiesEditionPart_SourceGroupLabel);
		GridData sourceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		sourceGroupData.horizontalSpan = 3;
		sourceGroup.setLayoutData(sourceGroupData);
		GridLayout sourceGroupLayout = new GridLayout();
		sourceGroupLayout.numColumns = 3;
		sourceGroup.setLayout(sourceGroupLayout);
		return sourceGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createPayloadTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Source.payloadType, EsbMessages.CalloutMediatorPropertiesEditionPart_PayloadTypeLabel);
		payloadType = new EMFComboViewer(parent);
		payloadType.setContentProvider(new ArrayContentProvider());
		payloadType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData payloadTypeData = new GridData(GridData.FILL_HORIZONTAL);
		payloadType.getCombo().setLayoutData(payloadTypeData);
                payloadType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		payloadType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Source.payloadType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPayloadType()));
			}

		});
		payloadType.setID(EsbViewsRepository.CalloutMediator.Source.payloadType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Source.payloadType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPayloadPropertyText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Source.payloadProperty, EsbMessages.CalloutMediatorPropertiesEditionPart_PayloadPropertyLabel);
		payloadProperty = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData payloadPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		payloadProperty.setLayoutData(payloadPropertyData);
		payloadProperty.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Source.payloadProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, payloadProperty.getText()));
			}

		});
		payloadProperty.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Source.payloadProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, payloadProperty.getText()));
				}
			}

		});
		EditingUtils.setID(payloadProperty, EsbViewsRepository.CalloutMediator.Source.payloadProperty);
		EditingUtils.setEEFtype(payloadProperty, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Source.payloadProperty, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadPropertyText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createTargetGroup(Composite parent) {
		Group targetGroup = new Group(parent, SWT.NONE);
		targetGroup.setText(EsbMessages.CalloutMediatorPropertiesEditionPart_TargetGroupLabel);
		GridData targetGroupData = new GridData(GridData.FILL_HORIZONTAL);
		targetGroupData.horizontalSpan = 3;
		targetGroup.setLayoutData(targetGroupData);
		GridLayout targetGroupLayout = new GridLayout();
		targetGroupLayout.numColumns = 3;
		targetGroup.setLayout(targetGroupLayout);
		return targetGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createResultTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Target.resultType, EsbMessages.CalloutMediatorPropertiesEditionPart_ResultTypeLabel);
		resultType = new EMFComboViewer(parent);
		resultType.setContentProvider(new ArrayContentProvider());
		resultType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData resultTypeData = new GridData(GridData.FILL_HORIZONTAL);
		resultType.getCombo().setLayoutData(resultTypeData);
                resultType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		resultType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Target.resultType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getResultType()));
			}

		});
		resultType.setID(EsbViewsRepository.CalloutMediator.Target.resultType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Target.resultType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createResultTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createResultContextPropertyText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Target.resultContextProperty, EsbMessages.CalloutMediatorPropertiesEditionPart_ResultContextPropertyLabel);
		resultContextProperty = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData resultContextPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		resultContextProperty.setLayoutData(resultContextPropertyData);
		resultContextProperty.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Target.resultContextProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resultContextProperty.getText()));
			}

		});
		resultContextProperty.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.Target.resultContextProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resultContextProperty.getText()));
				}
			}

		});
		EditingUtils.setID(resultContextProperty, EsbViewsRepository.CalloutMediator.Target.resultContextProperty);
		EditingUtils.setEEFtype(resultContextProperty, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Target.resultContextProperty, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createResultContextPropertyText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createWSGroup(Composite parent) {
		Group wSGroup = new Group(parent, SWT.NONE);
		wSGroup.setText(EsbMessages.CalloutMediatorPropertiesEditionPart_WSGroupLabel);
		GridData wSGroupData = new GridData(GridData.FILL_HORIZONTAL);
		wSGroupData.horizontalSpan = 3;
		wSGroup.setLayoutData(wSGroupData);
		GridLayout wSGroupLayout = new GridLayout();
		wSGroupLayout.numColumns = 3;
		wSGroup.setLayout(wSGroupLayout);
		return wSGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createPoliciesEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.WS.policies, EsbMessages.CalloutMediatorPropertiesEditionPart_PoliciesLabel);
		policies = new EMFComboViewer(parent);
		policies.setContentProvider(new ArrayContentProvider());
		policies.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData policiesData = new GridData(GridData.FILL_HORIZONTAL);
		policies.getCombo().setLayoutData(policiesData);
                policies.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		policies.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.WS.policies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPolicies()));
			}

		});
		policies.setID(EsbViewsRepository.CalloutMediator.WS.policies);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.WS.policies, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPoliciesEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createSecurityTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.WS.securityType, EsbMessages.CalloutMediatorPropertiesEditionPart_SecurityTypeLabel);
		securityType = new EMFComboViewer(parent);
		securityType.setContentProvider(new ArrayContentProvider());
		securityType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData securityTypeData = new GridData(GridData.FILL_HORIZONTAL);
		securityType.getCombo().setLayoutData(securityTypeData);
                securityType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		securityType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CalloutMediator.WS.securityType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSecurityType()));
			}

		});
		securityType.setID(EsbViewsRepository.CalloutMediator.WS.securityType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.WS.securityType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSecurityTypeEMFComboViewer

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Misc.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Misc.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Misc.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPassHeaders()
	 * 
	 */
	public Boolean getPassHeaders() {
		return Boolean.valueOf(passHeaders.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPassHeaders(Boolean newValue)
	 * 
	 */
	public void setPassHeaders(Boolean newValue) {
		if (newValue != null) {
			passHeaders.setSelection(newValue.booleanValue());
		} else {
			passHeaders.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Misc.passHeaders);
		if (eefElementEditorReadOnlyState && passHeaders.isEnabled()) {
			passHeaders.setEnabled(false);
			passHeaders.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !passHeaders.isEnabled()) {
			passHeaders.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getEndpointType()
	 * 
	 */
	public Enumerator getEndpointType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) endpointType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#initEndpointType(Object input, Enumerator current)
	 */
	public void initEndpointType(Object input, Enumerator current) {
		endpointType.setInput(input);
		endpointType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Service.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setEndpointType(Enumerator newValue)
	 * 
	 */
	public void setEndpointType(Enumerator newValue) {
		endpointType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Service.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getSoapAction()
	 * 
	 */
	public String getSoapAction() {
		return soapAction.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setSoapAction(String newValue)
	 * 
	 */
	public void setSoapAction(String newValue) {
		if (newValue != null) {
			soapAction.setText(newValue);
		} else {
			soapAction.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Service.soapAction);
		if (eefElementEditorReadOnlyState && soapAction.isEnabled()) {
			soapAction.setEnabled(false);
			soapAction.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !soapAction.isEnabled()) {
			soapAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPathToAxis2Repository()
	 * 
	 */
	public String getPathToAxis2Repository() {
		return pathToAxis2Repository.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPathToAxis2Repository(String newValue)
	 * 
	 */
	public void setPathToAxis2Repository(String newValue) {
		if (newValue != null) {
			pathToAxis2Repository.setText(newValue);
		} else {
			pathToAxis2Repository.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository);
		if (eefElementEditorReadOnlyState && pathToAxis2Repository.isEnabled()) {
			pathToAxis2Repository.setEnabled(false);
			pathToAxis2Repository.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !pathToAxis2Repository.isEnabled()) {
			pathToAxis2Repository.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPathToAxis2xml()
	 * 
	 */
	public String getPathToAxis2xml() {
		return pathToAxis2xml.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPathToAxis2xml(String newValue)
	 * 
	 */
	public void setPathToAxis2xml(String newValue) {
		if (newValue != null) {
			pathToAxis2xml.setText(newValue);
		} else {
			pathToAxis2xml.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml);
		if (eefElementEditorReadOnlyState && pathToAxis2xml.isEnabled()) {
			pathToAxis2xml.setEnabled(false);
			pathToAxis2xml.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !pathToAxis2xml.isEnabled()) {
			pathToAxis2xml.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getInitAxis2ClientOptions()
	 * 
	 */
	public Boolean getInitAxis2ClientOptions() {
		return Boolean.valueOf(initAxis2ClientOptions.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setInitAxis2ClientOptions(Boolean newValue)
	 * 
	 */
	public void setInitAxis2ClientOptions(Boolean newValue) {
		if (newValue != null) {
			initAxis2ClientOptions.setSelection(newValue.booleanValue());
		} else {
			initAxis2ClientOptions.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions);
		if (eefElementEditorReadOnlyState && initAxis2ClientOptions.isEnabled()) {
			initAxis2ClientOptions.setEnabled(false);
			initAxis2ClientOptions.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !initAxis2ClientOptions.isEnabled()) {
			initAxis2ClientOptions.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getServiceURL()
	 * 
	 */
	public String getServiceURL() {
		return serviceURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setServiceURL(String newValue)
	 * 
	 */
	public void setServiceURL(String newValue) {
		if (newValue != null) {
			serviceURL.setText(newValue);
		} else {
			serviceURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Service.serviceURL);
		if (eefElementEditorReadOnlyState && serviceURL.isEnabled()) {
			serviceURL.setEnabled(false);
			serviceURL.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !serviceURL.isEnabled()) {
			serviceURL.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPayloadType()
	 * 
	 */
	public Enumerator getPayloadType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) payloadType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#initPayloadType(Object input, Enumerator current)
	 */
	public void initPayloadType(Object input, Enumerator current) {
		payloadType.setInput(input);
		payloadType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Source.payloadType);
		if (eefElementEditorReadOnlyState && payloadType.isEnabled()) {
			payloadType.setEnabled(false);
			payloadType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payloadType.isEnabled()) {
			payloadType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPayloadType(Enumerator newValue)
	 * 
	 */
	public void setPayloadType(Enumerator newValue) {
		payloadType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Source.payloadType);
		if (eefElementEditorReadOnlyState && payloadType.isEnabled()) {
			payloadType.setEnabled(false);
			payloadType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payloadType.isEnabled()) {
			payloadType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPayloadProperty()
	 * 
	 */
	public String getPayloadProperty() {
		return payloadProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPayloadProperty(String newValue)
	 * 
	 */
	public void setPayloadProperty(String newValue) {
		if (newValue != null) {
			payloadProperty.setText(newValue);
		} else {
			payloadProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Source.payloadProperty);
		if (eefElementEditorReadOnlyState && payloadProperty.isEnabled()) {
			payloadProperty.setEnabled(false);
			payloadProperty.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payloadProperty.isEnabled()) {
			payloadProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getResultType()
	 * 
	 */
	public Enumerator getResultType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) resultType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#initResultType(Object input, Enumerator current)
	 */
	public void initResultType(Object input, Enumerator current) {
		resultType.setInput(input);
		resultType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Target.resultType);
		if (eefElementEditorReadOnlyState && resultType.isEnabled()) {
			resultType.setEnabled(false);
			resultType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resultType.isEnabled()) {
			resultType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setResultType(Enumerator newValue)
	 * 
	 */
	public void setResultType(Enumerator newValue) {
		resultType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Target.resultType);
		if (eefElementEditorReadOnlyState && resultType.isEnabled()) {
			resultType.setEnabled(false);
			resultType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resultType.isEnabled()) {
			resultType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getResultContextProperty()
	 * 
	 */
	public String getResultContextProperty() {
		return resultContextProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setResultContextProperty(String newValue)
	 * 
	 */
	public void setResultContextProperty(String newValue) {
		if (newValue != null) {
			resultContextProperty.setText(newValue);
		} else {
			resultContextProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Target.resultContextProperty);
		if (eefElementEditorReadOnlyState && resultContextProperty.isEnabled()) {
			resultContextProperty.setEnabled(false);
			resultContextProperty.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resultContextProperty.isEnabled()) {
			resultContextProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPolicies()
	 * 
	 */
	public Enumerator getPolicies() {
		Enumerator selection = (Enumerator) ((StructuredSelection) policies.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#initPolicies(Object input, Enumerator current)
	 */
	public void initPolicies(Object input, Enumerator current) {
		policies.setInput(input);
		policies.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.WS.policies);
		if (eefElementEditorReadOnlyState && policies.isEnabled()) {
			policies.setEnabled(false);
			policies.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policies.isEnabled()) {
			policies.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPolicies(Enumerator newValue)
	 * 
	 */
	public void setPolicies(Enumerator newValue) {
		policies.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.WS.policies);
		if (eefElementEditorReadOnlyState && policies.isEnabled()) {
			policies.setEnabled(false);
			policies.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policies.isEnabled()) {
			policies.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getSecurityType()
	 * 
	 */
	public Enumerator getSecurityType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) securityType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#initSecurityType(Object input, Enumerator current)
	 */
	public void initSecurityType(Object input, Enumerator current) {
		securityType.setInput(input);
		securityType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.WS.securityType);
		if (eefElementEditorReadOnlyState && securityType.isEnabled()) {
			securityType.setEnabled(false);
			securityType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !securityType.isEnabled()) {
			securityType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setSecurityType(Enumerator newValue)
	 * 
	 */
	public void setSecurityType(Enumerator newValue) {
		securityType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.WS.securityType);
		if (eefElementEditorReadOnlyState && securityType.isEnabled()) {
			securityType.setEnabled(false);
			securityType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !securityType.isEnabled()) {
			securityType.setEnabled(true);
		}	
		
	}






	// Start of user code for Address Endpoint specific getters and setters implementation
	@Override
	public RegistryKeyProperty getAddressEndpoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAddressEndpoint(RegistryKeyProperty registryKeyProperty) {
		// TODO Auto-generated method stub
		
	}
	// End of user code

	// Start of user code for Payload Message Xpath specific getters and setters implementation
	@Override
	public NamespacedProperty getPayloadMessageXpath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPayloadMessageXpath(NamespacedProperty namespacedProperty) {
		// TODO Auto-generated method stub
		
	}
	// End of user code

	// Start of user code for Result Message Xpath specific getters and setters implementation
	@Override
	public NamespacedProperty getResultMessageXpath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResultMessageXpath(NamespacedProperty namespacedProperty) {
		// TODO Auto-generated method stub
		
	}
	// End of user code

	// Start of user code for Policy Key specific getters and setters implementation
	@Override
	public RegistryKeyProperty getPolicyKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPolicyKey(RegistryKeyProperty registryKeyProperty) {
		// TODO Auto-generated method stub
		
	}
	// End of user code

	// Start of user code for Outbound Policy Key specific getters and setters implementation
	@Override
	public RegistryKeyProperty getOutboundPolicyKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOutboundPolicyKey(RegistryKeyProperty registryKeyProperty) {
		// TODO Auto-generated method stub
		
	}

	// End of user code

	// Start of user code for Inbound Policy Key specific getters and setters implementation
	@Override
	public RegistryKeyProperty getInboundPolicyKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInboundPolicyKey(RegistryKeyProperty registryKeyProperty) {
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
		return EsbMessages.CalloutMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
