/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

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
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
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

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
// End of user code

/**
 * 
 * 
 */
public class CalloutMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, CalloutMediatorPropertiesEditionPart {

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
	protected RegistryKeyProperty addressEndpoint;
	protected Text addressEndpointText;
	// End of user code

	protected EMFComboViewer payloadType;
	protected Text payloadProperty;
	// Start of user code  for Payload Message Xpath widgets declarations
	protected NamespacedProperty payloadMessageXpath;
	protected Text payloadMessageXpathText;
	// End of user code

	protected EMFComboViewer resultType;
	protected Text resultContextProperty;
	// Start of user code  for Result Message Xpath widgets declarations
	protected NamespacedProperty resultMessageXpath;
	protected Text resultMessageXpathText;
	// End of user code

	protected EMFComboViewer policies;
	protected EMFComboViewer securityType;
	// Start of user code  for Policy Key widgets declarations
	protected RegistryKeyProperty policyKey;
	protected Text policyKeyText;
	// End of user code

	// Start of user code  for Outbound Policy Key widgets declarations
	protected RegistryKeyProperty outboundPolicyKey;
	protected Text outboundPolicyKeyText;
	// End of user code

	// Start of user code  for Inbound Policy Key widgets declarations
	protected RegistryKeyProperty inboundPolicyKey;
	protected Text inboundPolicyKeyText;
	
	protected Control[] descriptionElements;
	protected Control[] endpointTypeElements;
	protected Control[] soapActionElements;
	protected Control[] pathToAxis2RepositoryElements;
	protected Control[] pathToAxis2xmlElements;
	protected Control[] initAxis2ClientOptionsElements;
	protected Control[] serviceUrlElements;
	protected Control[] addressEndpointElements;
	protected Control[] payloadTypeElements;
	protected Control[] payloadPropertyElements;
	protected Control[] PayloadMessageXpathElements;
	protected Control[] resultTypeElements;
	protected Control[] resultContextPropertyElements;
	protected Control[] resultMessageXpathElements;
	protected Control[] policiesElements;
	protected Control[] securityTypeElements;
	protected Control[] editorPolicyKeyElements;
	protected Control[] outboundPolicyKeyElements;
	protected Control[] inboundPolicyKeyElements;
	protected Control[] policyKeyElements;
	
	
	protected Composite miscGroup;
	protected Composite serviceGroup;
	protected Composite sourceGroup;
	protected Composite targetGroup;
	protected Composite wSGroup;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public CalloutMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CalloutMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence calloutMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		
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
		wSStep.addStep(EsbViewsRepository.CalloutMediator.WS.securityType);
        wSStep.addStep(EsbViewsRepository.CalloutMediator.WS.policies);
		wSStep.addStep(EsbViewsRepository.CalloutMediator.WS.policyKey);
		wSStep.addStep(EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey);
		wSStep.addStep(EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey);
		
        CompositionStep miscStep = calloutMediatorStep.addStep(EsbViewsRepository.CalloutMediator.Misc.class);
        miscStep.addStep(EsbViewsRepository.CalloutMediator.Misc.description);
        miscStep.addStep(EsbViewsRepository.CalloutMediator.Misc.commentsList);
        miscStep.addStep(EsbViewsRepository.CalloutMediator.Misc.reverse);
        miscStep.addStep(EsbViewsRepository.CalloutMediator.Misc.passHeaders);
		
		composer = new PartComposer(calloutMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CalloutMediator.Misc.class) {
					return createMiscGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Misc.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Misc.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Misc.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Misc.passHeaders) {
					return createPassHeadersCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.class) {
					return createServiceGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.endpointType) {
					return createEndpointTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.soapAction) {
					return createSoapActionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository) {
					return createPathToAxis2RepositoryText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml) {
					return createPathToAxis2xmlText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions) {
					return createInitAxis2ClientOptionsCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Service.serviceURL) {
					return createServiceURLText(widgetFactory, parent);
				}
				// Start of user code for Address Endpoint addToPart creation
				if (key == EsbViewsRepository.CalloutMediator.Service.addressEndpoint) {
					return createAddressEndpoint(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.CalloutMediator.Source.class) {
					return createSourceGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Source.payloadType) {
					return createPayloadTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Source.payloadProperty) {
					return createPayloadPropertyText(widgetFactory, parent);
				}
				// Start of user code for Payload Message Xpath addToPart creation
				if (key == EsbViewsRepository.CalloutMediator.Source.payloadMessageXpath) {
					return createPayloadMessageXpath(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.CalloutMediator.Target.class) {
					return createTargetGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Target.resultType) {
					return createResultTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Target.resultContextProperty) {
					return createResultContextPropertyText(widgetFactory, parent);
				}
				// Start of user code for Result Message Xpath addToPart creation
				if (key == EsbViewsRepository.CalloutMediator.Target.resultMessageXpath) {
					return createResultMessageXpath(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.CalloutMediator.WS.class) {
					return createWSGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.WS.policies) {
					return createPoliciesEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.WS.securityType) {
					return createSecurityTypeEMFComboViewer(widgetFactory, parent);
				}
				// Start of user code for Policy Key addToPart creation
				if (key == EsbViewsRepository.CalloutMediator.WS.policyKey) {
					return createPolicyKey(widgetFactory, parent);
				}
				// End of user code
				// Start of user code for Outbound Policy Key addToPart creation
				if (key == EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey) {
					return createOutboundPolicyKey(widgetFactory, parent);
				}
				// End of user code
				// Start of user code for Inbound Policy Key addToPart creation
				if (key == EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey) {
					return createInboundPolicyKey(widgetFactory, parent);
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
	protected Composite createMiscGroup(FormToolkit widgetFactory, final Composite parent) {
		Section miscSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		miscSection.setText(EsbMessages.CalloutMediatorPropertiesEditionPart_MiscGroupLabel);
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
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.Misc.description, EsbMessages.CalloutMediatorPropertiesEditionPart_DescriptionLabel);
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
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Misc.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Misc.description,
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
									CalloutMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.CalloutMediator.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Misc.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] { descriptionLabel, description, descriptionHelp };
		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.CalloutMediator.Misc.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CalloutMediator.Misc.commentsList, EsbMessages.CalloutMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Misc.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
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

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CalloutMediator.Misc.reverse, EsbMessages.CalloutMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Misc.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.CalloutMediator.Misc.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Misc.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createPassHeadersCheckbox(FormToolkit widgetFactory, Composite parent) {
		passHeaders = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CalloutMediator.Misc.passHeaders, EsbMessages.CalloutMediatorPropertiesEditionPart_PassHeadersLabel), SWT.CHECK);
		passHeaders.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Misc.passHeaders, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(passHeaders.getSelection())));
			}

		});
		GridData passHeadersData = new GridData(GridData.FILL_HORIZONTAL);
		passHeadersData.horizontalSpan = 2;
		passHeaders.setLayoutData(passHeadersData);
		EditingUtils.setID(passHeaders, EsbViewsRepository.CalloutMediator.Misc.passHeaders);
		EditingUtils.setEEFtype(passHeaders, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Misc.passHeaders, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPassHeadersCheckbox

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createServiceGroup(FormToolkit widgetFactory, final Composite parent) {
		Section serviceSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		serviceSection.setText(EsbMessages.CalloutMediatorPropertiesEditionPart_ServiceGroupLabel);
		GridData serviceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		serviceSectionData.horizontalSpan = 3;
		serviceSection.setLayoutData(serviceSectionData);
		serviceGroup = widgetFactory.createComposite(serviceSection);
		GridLayout serviceGroupLayout = new GridLayout();
		serviceGroupLayout.numColumns = 3;
		serviceGroup.setLayout(serviceGroupLayout);
		serviceSection.setClient(serviceGroup);
		return serviceGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createEndpointTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control endpointTypeLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.Service.endpointType, EsbMessages.CalloutMediatorPropertiesEditionPart_EndpointTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Service.endpointType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEndpointType()));
			}

		});
		endpointType.setID(EsbViewsRepository.CalloutMediator.Service.endpointType);
		Control endpointTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.endpointType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointTypeEMFComboViewer
		endpointTypeElements = new Control[] { endpointTypeLabel, endpointType.getCombo(), endpointTypeHelp };
		endpointType.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// TODO Auto-generated method stub
				refresh();
			}
		});
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createSoapActionText(FormToolkit widgetFactory, Composite parent) {
		Control soapActionLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.Service.soapAction, EsbMessages.CalloutMediatorPropertiesEditionPart_SoapActionLabel);
		soapAction = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		soapAction.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData soapActionData = new GridData(GridData.FILL_HORIZONTAL);
		soapAction.setLayoutData(soapActionData);
		soapAction.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Service.soapAction,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, soapAction.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Service.soapAction,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, soapAction.getText()));
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
									CalloutMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		soapAction.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Service.soapAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, soapAction.getText()));
				}
			}
		});
		EditingUtils.setID(soapAction, EsbViewsRepository.CalloutMediator.Service.soapAction);
		EditingUtils.setEEFtype(soapAction, "eef::Text"); //$NON-NLS-1$
		Control soapActionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.soapAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSoapActionText
		soapActionElements = new Control[] { soapActionLabel, soapAction, soapActionHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPathToAxis2RepositoryText(FormToolkit widgetFactory, Composite parent) {
		Control pathToAxis2RepositoryLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository, EsbMessages.CalloutMediatorPropertiesEditionPart_PathToAxis2RepositoryLabel);
		pathToAxis2Repository = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		pathToAxis2Repository.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData pathToAxis2RepositoryData = new GridData(GridData.FILL_HORIZONTAL);
		pathToAxis2Repository.setLayoutData(pathToAxis2RepositoryData);
		pathToAxis2Repository.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2Repository.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, pathToAxis2Repository.getText()));
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
									CalloutMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		pathToAxis2Repository.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2Repository.getText()));
				}
			}
		});
		EditingUtils.setID(pathToAxis2Repository, EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository);
		EditingUtils.setEEFtype(pathToAxis2Repository, "eef::Text"); //$NON-NLS-1$
		Control pathToAxis2RepositoryHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPathToAxis2RepositoryText
		pathToAxis2RepositoryElements = new Control[] { pathToAxis2RepositoryLabel, pathToAxis2Repository,
				pathToAxis2RepositoryHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPathToAxis2xmlText(FormToolkit widgetFactory, Composite parent) {
		Control pathToAxis2xmlLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml, EsbMessages.CalloutMediatorPropertiesEditionPart_PathToAxis2xmlLabel);
		pathToAxis2xml = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		pathToAxis2xml.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData pathToAxis2xmlData = new GridData(GridData.FILL_HORIZONTAL);
		pathToAxis2xml.setLayoutData(pathToAxis2xmlData);
		pathToAxis2xml.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2xml.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, pathToAxis2xml.getText()));
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
									CalloutMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		pathToAxis2xml.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2xml.getText()));
				}
			}
		});
		EditingUtils.setID(pathToAxis2xml, EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml);
		EditingUtils.setEEFtype(pathToAxis2xml, "eef::Text"); //$NON-NLS-1$
		Control pathToAxis2xmlHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPathToAxis2xmlText
		pathToAxis2xmlElements = new Control[] { pathToAxis2xmlLabel, pathToAxis2xml, pathToAxis2xmlHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createInitAxis2ClientOptionsCheckbox(FormToolkit widgetFactory, Composite parent) {
		initAxis2ClientOptions = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions, EsbMessages.CalloutMediatorPropertiesEditionPart_InitAxis2ClientOptionsLabel), SWT.CHECK);
		initAxis2ClientOptions.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(initAxis2ClientOptions.getSelection())));
			}

		});
		GridData initAxis2ClientOptionsData = new GridData(GridData.FILL_HORIZONTAL);
		initAxis2ClientOptionsData.horizontalSpan = 2;
		initAxis2ClientOptions.setLayoutData(initAxis2ClientOptionsData);
		EditingUtils.setID(initAxis2ClientOptions, EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions);
		EditingUtils.setEEFtype(initAxis2ClientOptions, "eef::Checkbox"); //$NON-NLS-1$
		Control initAxis2ClientOptionsHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInitAxis2ClientOptionsCheckbox
		initAxis2ClientOptionsElements = new Control[] { initAxis2ClientOptions, initAxis2ClientOptionsHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createServiceURLText(FormToolkit widgetFactory, Composite parent) {
		Control serviceURLLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.Service.serviceURL, EsbMessages.CalloutMediatorPropertiesEditionPart_ServiceURLLabel);
		serviceURL = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		serviceURL.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData serviceURLData = new GridData(GridData.FILL_HORIZONTAL);
		serviceURL.setLayoutData(serviceURLData);
		serviceURL.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Service.serviceURL,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceURL.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Service.serviceURL,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, serviceURL.getText()));
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
									CalloutMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		serviceURL.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Service.serviceURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceURL.getText()));
				}
			}
		});
		EditingUtils.setID(serviceURL, EsbViewsRepository.CalloutMediator.Service.serviceURL);
		EditingUtils.setEEFtype(serviceURL, "eef::Text"); //$NON-NLS-1$
		Control serviceURLHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.serviceURL, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createServiceURLText
		serviceUrlElements = new Control[] { serviceURLLabel, serviceURL, serviceURLHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createSourceGroup(FormToolkit widgetFactory, final Composite parent) {
		Section sourceSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		sourceSection.setText(EsbMessages.CalloutMediatorPropertiesEditionPart_SourceGroupLabel);
		GridData sourceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		sourceSectionData.horizontalSpan = 3;
		sourceSection.setLayoutData(sourceSectionData);
		sourceGroup = widgetFactory.createComposite(sourceSection);
		GridLayout sourceGroupLayout = new GridLayout();
		sourceGroupLayout.numColumns = 3;
		sourceGroup.setLayout(sourceGroupLayout);
		sourceSection.setClient(sourceGroup);
		return sourceGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createPayloadTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control payloadTypeLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.Source.payloadType, EsbMessages.CalloutMediatorPropertiesEditionPart_PayloadTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Source.payloadType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPayloadType()));
			}

		});
		payloadType.setID(EsbViewsRepository.CalloutMediator.Source.payloadType);
		Control payloadTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Source.payloadType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadTypeEMFComboViewer
		payloadTypeElements = new Control[] { payloadTypeLabel, payloadType.getCombo(), payloadTypeHelp };
		payloadType.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// TODO Auto-generated method stub
				refresh();
			}
		});
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPayloadPropertyText(FormToolkit widgetFactory, Composite parent) {
		Control payloadPropertyLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.Source.payloadProperty, EsbMessages.CalloutMediatorPropertiesEditionPart_PayloadPropertyLabel);
		payloadProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		payloadProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData payloadPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		payloadProperty.setLayoutData(payloadPropertyData);
		payloadProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Source.payloadProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, payloadProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Source.payloadProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, payloadProperty.getText()));
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
									CalloutMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		payloadProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Source.payloadProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, payloadProperty.getText()));
				}
			}
		});
		EditingUtils.setID(payloadProperty, EsbViewsRepository.CalloutMediator.Source.payloadProperty);
		EditingUtils.setEEFtype(payloadProperty, "eef::Text"); //$NON-NLS-1$
		Control payloadPropertyHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Source.payloadProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadPropertyText
		payloadPropertyElements = new Control[] { payloadPropertyLabel, payloadProperty, payloadPropertyHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createTargetGroup(FormToolkit widgetFactory, final Composite parent) {
		Section targetSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		targetSection.setText(EsbMessages.CalloutMediatorPropertiesEditionPart_TargetGroupLabel);
		GridData targetSectionData = new GridData(GridData.FILL_HORIZONTAL);
		targetSectionData.horizontalSpan = 3;
		targetSection.setLayoutData(targetSectionData);
		targetGroup = widgetFactory.createComposite(targetSection);
		GridLayout targetGroupLayout = new GridLayout();
		targetGroupLayout.numColumns = 3;
		targetGroup.setLayout(targetGroupLayout);
		targetSection.setClient(targetGroup);
		return targetGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createResultTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control resultTypeLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.Target.resultType, EsbMessages.CalloutMediatorPropertiesEditionPart_ResultTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Target.resultType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getResultType()));
			}

		});
		resultType.setID(EsbViewsRepository.CalloutMediator.Target.resultType);
		Control resultTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Target.resultType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResultTypeEMFComboViewer
		resultTypeElements = new Control[] { resultTypeLabel, resultType.getCombo(), resultTypeHelp };
		resultType.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// TODO Auto-generated method stub
				refresh();
			}
		});
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createResultContextPropertyText(FormToolkit widgetFactory, Composite parent) {
		Control resultContextPropertyLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.Target.resultContextProperty, EsbMessages.CalloutMediatorPropertiesEditionPart_ResultContextPropertyLabel);
		resultContextProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		resultContextProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData resultContextPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		resultContextProperty.setLayoutData(resultContextPropertyData);
		resultContextProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Target.resultContextProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resultContextProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Target.resultContextProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, resultContextProperty.getText()));
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
									CalloutMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		resultContextProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Target.resultContextProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resultContextProperty.getText()));
				}
			}
		});
		EditingUtils.setID(resultContextProperty, EsbViewsRepository.CalloutMediator.Target.resultContextProperty);
		EditingUtils.setEEFtype(resultContextProperty, "eef::Text"); //$NON-NLS-1$
		Control resultContextPropertyHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Target.resultContextProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResultContextPropertyText
		resultContextPropertyElements = new Control[] { resultContextPropertyLabel, resultContextProperty,
				resultContextPropertyHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createWSGroup(FormToolkit widgetFactory, final Composite parent) {
		Section wSSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		wSSection.setText(EsbMessages.CalloutMediatorPropertiesEditionPart_WSGroupLabel);
		GridData wSSectionData = new GridData(GridData.FILL_HORIZONTAL);
		wSSectionData.horizontalSpan = 3;
		wSSection.setLayoutData(wSSectionData);
		wSGroup = widgetFactory.createComposite(wSSection);
		GridLayout wSGroupLayout = new GridLayout();
		wSGroupLayout.numColumns = 3;
		wSGroup.setLayout(wSGroupLayout);
		wSSection.setClient(wSGroup);
		return wSGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createPoliciesEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control policiesLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.WS.policies, EsbMessages.CalloutMediatorPropertiesEditionPart_PoliciesLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.WS.policies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPolicies()));
			}

		});
		policies.setID(EsbViewsRepository.CalloutMediator.WS.policies);
		Control policiesHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.WS.policies, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPoliciesEMFComboViewer
		policiesElements = new Control[] { policiesLabel, policies.getCombo(), policiesHelp };
		policies.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// TODO Auto-generated method stub
				refresh();
			}
		});
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createSecurityTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control securityTypeLabel = createDescription(parent, EsbViewsRepository.CalloutMediator.WS.securityType, EsbMessages.CalloutMediatorPropertiesEditionPart_SecurityTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.WS.securityType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSecurityType()));
			}

		});
		securityType.setID(EsbViewsRepository.CalloutMediator.WS.securityType);
		Control securityTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.WS.securityType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSecurityTypeEMFComboViewer
		securityTypeElements = new Control[] { securityTypeLabel, securityType.getCombo(), securityTypeHelp };
		securityType.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// TODO Auto-generated method stub
				refresh();
			}
		});
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
		return addressEndpoint;
	}

	@Override
	public void setAddressEndpoint(RegistryKeyProperty registryKeyProperty) {
		if (registryKeyProperty != null) {
			addressEndpointText.setText(registryKeyProperty.getKeyValue());
			addressEndpoint = registryKeyProperty;
		}
	}
	// End of user code

	// Start of user code for Payload Message Xpath specific getters and setters implementation
    @Override
    public NamespacedProperty getPayloadMessageXpath() {
        return payloadMessageXpath;
    }

    @Override
    public void setPayloadMessageXpath(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
        	payloadMessageXpathText.setText(nameSpacedProperty.getPropertyValue());
        	payloadMessageXpath = nameSpacedProperty;
        }
        
    }
	// End of user code

	// Start of user code for Result Message Xpath specific getters and setters implementation
    @Override
    public NamespacedProperty getResultMessageXpath() {
        return resultMessageXpath;
    }

    @Override
    public void setResultMessageXpath(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
        	resultMessageXpathText.setText(nameSpacedProperty.getPropertyValue());
        	resultMessageXpath = nameSpacedProperty;
        }
        
    }
	// End of user code

	// Start of user code for Policy Key specific getters and setters implementation
	@Override
	public RegistryKeyProperty getPolicyKey() {
		return policyKey;
	}

	@Override
	public void setPolicyKey(RegistryKeyProperty registryKeyProperty) {
		if (registryKeyProperty != null) {
			policyKeyText.setText(registryKeyProperty.getKeyValue());
			policyKey = registryKeyProperty;
		}
	}
	// End of user code

	// Start of user code for Outbound Policy Key specific getters and setters implementation
	@Override
	public RegistryKeyProperty getOutboundPolicyKey() {
		return outboundPolicyKey;
	}

	@Override
	public void setOutboundPolicyKey(RegistryKeyProperty registryKeyProperty) {
		if (registryKeyProperty != null) {
			outboundPolicyKeyText.setText(registryKeyProperty.getKeyValue());
			outboundPolicyKey = registryKeyProperty;
		}
	}
	// End of user code

	// Start of user code for Inbound Policy Key specific getters and setters implementation
	@Override
	public RegistryKeyProperty getInboundPolicyKey() {
		return inboundPolicyKey;
	}

	@Override
	public void setInboundPolicyKey(RegistryKeyProperty registryKeyProperty) {
		if (registryKeyProperty != null) {
			inboundPolicyKeyText.setText(registryKeyProperty.getKeyValue());
			inboundPolicyKey = registryKeyProperty;
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
		return EsbMessages.CalloutMediator_Part_Title;
	}

	// Start of user code additional methods
	//registry
	protected Composite createAddressEndpoint(FormToolkit widgetFactory, Composite parent) {
		Control addressEndpointLabel = createDescription(parent,
				EsbViewsRepository.CalloutMediator.Service.addressEndpoint,
				EsbMessages.CalloutMediatorPropertiesEditionPart_AddressEndpointLabel);
		widgetFactory.paintBordersFor(parent);
		if (addressEndpoint == null) {
			addressEndpoint = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = addressEndpoint.getKeyValue().isEmpty() ? "" : addressEndpoint.getKeyValue();
		addressEndpointText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
		addressEndpointText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		addressEndpointText.setLayoutData(valueData);
		
        addressEndpointText.addMouseListener(new MouseListener() {

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, addressEndpoint, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                addressEndpointText.setText(addressEndpoint.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CalloutMediator.Service.addressEndpoint,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAddressEndpoint()));
            }

            @Override
            public void mouseUp(MouseEvent e) {}

            @Override
            public void mouseDoubleClick(MouseEvent e) {}

        });

        addressEndpointText.addKeyListener(new KeyListener() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, addressEndpoint, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    addressEndpointText.setText(addressEndpoint.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CalloutMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CalloutMediator.Service.addressEndpoint, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getAddressEndpoint()));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

        });
		
		EditingUtils.setID(addressEndpointText, EsbViewsRepository.CalloutMediator.Service.addressEndpoint);
		EditingUtils.setEEFtype(addressEndpointText, "eef::Text");
		Control addressEndpointHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Service.addressEndpoint,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		addressEndpointElements = new Control[] { addressEndpointLabel, addressEndpointText, addressEndpointHelp };
		return parent;
	}
	
	protected Composite createPayloadMessageXpath(FormToolkit widgetFactory, final Composite parent) {
		Control payloadMessageXpathLabel = createDescription(parent,
				EsbViewsRepository.CalloutMediator.Source.payloadMessageXpath,
				EsbMessages.CalloutMediatorPropertiesEditionPart_PayloadMessageXpathLabel);
		widgetFactory.paintBordersFor(parent);
		if (payloadMessageXpath == null) {
			payloadMessageXpath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		}
		String initValueExpression = payloadMessageXpath.getPropertyValue().isEmpty() ? "/default/expression"
				: payloadMessageXpath.getPropertyValue();
		payloadMessageXpathText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
		payloadMessageXpathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		payloadMessageXpathText.setLayoutData(valueData);
		
        payloadMessageXpathText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                openPayloadMessageNamespacedPropertyEditor(parent);
            }

        });

        payloadMessageXpathText.addKeyListener(new KeyListener() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openPayloadMessageNamespacedPropertyEditor(parent);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

        });
        
		EditingUtils.setID(payloadMessageXpathText,
				EsbViewsRepository.CalloutMediator.Source.payloadMessageXpath);
		EditingUtils.setEEFtype(payloadMessageXpathText, "eef::Text");
		Control payloadMessageXpathHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(
						EsbViewsRepository.CalloutMediator.Source.payloadMessageXpath,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		PayloadMessageXpathElements = new Control[] { payloadMessageXpathLabel, payloadMessageXpathText, payloadMessageXpathHelp };
		return parent;
	}
	
    private void openResultMessageNamespacedPropertyEditor(final Composite parent) {
        final EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                SWT.NULL, resultMessageXpath);
        resultMessageXpath = nspd.open();
        resultMessageXpathText.setText(resultMessageXpath.getPropertyValue());
        propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.CalloutMediator.Target.resultMessageXpath, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getResultMessageXpath()));
    }

    private void openPayloadMessageNamespacedPropertyEditor(final Composite parent) {
        final EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                SWT.NULL, payloadMessageXpath);
        payloadMessageXpath = nspd.open();
        payloadMessageXpathText.setText(payloadMessageXpath.getPropertyValue());
        propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.CalloutMediator.Source.payloadMessageXpath, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getPayloadMessageXpath()));
    }
	
	protected Composite createResultMessageXpath(FormToolkit widgetFactory, final Composite parent) {
		Control resultMessageXpathLabel = createDescription(parent,
				EsbViewsRepository.CalloutMediator.Target.resultMessageXpath,
				EsbMessages.CalloutMediatorPropertiesEditionPart_ResultMessageXpathLabel);
		widgetFactory.paintBordersFor(parent);
		if (resultMessageXpath == null) {
			resultMessageXpath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		}
		String initValueExpression = resultMessageXpath.getPropertyValue().isEmpty() ? "/default/expression"
				: resultMessageXpath.getPropertyValue();
		resultMessageXpathText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
		resultMessageXpathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		resultMessageXpathText.setLayoutData(valueData);
		
        resultMessageXpathText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                openResultMessageNamespacedPropertyEditor(parent);
            }

        });

        resultMessageXpathText.addKeyListener(new KeyListener() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openResultMessageNamespacedPropertyEditor(parent);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

        });
		
		EditingUtils.setID(payloadMessageXpathText,
				EsbViewsRepository.CalloutMediator.Target.resultMessageXpath);
		EditingUtils.setEEFtype(resultMessageXpathText, "eef::Text");
		Control resultMessageXpathHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(
						EsbViewsRepository.CalloutMediator.Target.resultMessageXpath,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		resultMessageXpathElements = new Control[] { resultMessageXpathLabel, resultMessageXpathText, resultMessageXpathHelp };
		return parent;
	}
	
	protected Composite createPolicyKey(FormToolkit widgetFactory, Composite parent) {
		Control policyKeyLabel = createDescription(parent,
				EsbViewsRepository.CalloutMediator.WS.policyKey,
				EsbMessages.CalloutMediatorPropertiesEditionPart_PolicyKeyLabel);
		widgetFactory.paintBordersFor(parent);
		if (policyKey == null) {
			policyKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = policyKey.getKeyValue().isEmpty() ? "" : policyKey.getKeyValue();
		policyKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
		policyKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		policyKeyText.setLayoutData(valueData);
		
        policyKeyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, policyKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                policyKeyText.setText(policyKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.WS.policyKey,
                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPolicyKey()));
            }

            @Override
            public void mouseUp(MouseEvent e) {}

            @Override
            public void mouseDoubleClick(MouseEvent e) {}

        });

        policyKeyText.addKeyListener(new KeyListener() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, policyKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    policyKeyText.setText(policyKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CalloutMediator.WS.policyKey, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getPolicyKey()));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

        });
		
		EditingUtils.setID(policyKeyText, EsbViewsRepository.CalloutMediator.WS.policyKey);
		EditingUtils.setEEFtype(policyKeyText, "eef::Text");
		Control policyKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.WS.policyKey,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		policyKeyElements = new Control[] { policyKeyLabel, policyKeyText, policyKeyHelp };
		return parent;
	}
	
	protected Composite createInboundPolicyKey(FormToolkit widgetFactory, Composite parent) {
		Control inboundPolicyKeyLabel = createDescription(parent,
				EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey,
				EsbMessages.CalloutMediatorPropertiesEditionPart_InboundPolicyKeyLabel);
		widgetFactory.paintBordersFor(parent);
		if (inboundPolicyKey == null) {
		    inboundPolicyKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = inboundPolicyKey.getKeyValue().isEmpty() ? "" : inboundPolicyKey.getKeyValue();
		inboundPolicyKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
		inboundPolicyKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		inboundPolicyKeyText.setLayoutData(valueData);
		
		inboundPolicyKeyText.addMouseListener(new MouseListener() {
		    
            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, inboundPolicyKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                inboundPolicyKeyText.setText(inboundPolicyKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInboundPolicyKey()));
            }
            
            @Override
            public void mouseUp(MouseEvent e) {}
            
            @Override
            public void mouseDoubleClick(MouseEvent e) {}
            
        });
		
		inboundPolicyKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, inboundPolicyKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    inboundPolicyKeyText.setText(inboundPolicyKey.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInboundPolicyKey()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
		
		EditingUtils.setID(inboundPolicyKeyText, EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey);
		EditingUtils.setEEFtype(inboundPolicyKeyText, "eef::Text");
		Control inboundPolicyKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		inboundPolicyKeyElements = new Control[] { inboundPolicyKeyLabel, inboundPolicyKeyText, inboundPolicyKeyHelp };
		return parent;
	}
	
	protected Composite createOutboundPolicyKey(FormToolkit widgetFactory, Composite parent) {
		Control outboundPolicyKeyLabel = createDescription(parent,
				EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey,
				EsbMessages.CalloutMediatorPropertiesEditionPart_OutboundPolicyKeyLabel);
		widgetFactory.paintBordersFor(parent);
		if (outboundPolicyKey == null) {
		    outboundPolicyKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = outboundPolicyKey.getKeyValue().isEmpty() ? "" : outboundPolicyKey.getKeyValue();
		outboundPolicyKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
		outboundPolicyKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		outboundPolicyKeyText.setLayoutData(valueData);
		
        outboundPolicyKeyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, outboundPolicyKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                outboundPolicyKeyText.setText(outboundPolicyKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getOutboundPolicyKey()));
            }

            @Override
            public void mouseUp(MouseEvent e) {}

            @Override
            public void mouseDoubleClick(MouseEvent e) {}

        });

        outboundPolicyKeyText.addKeyListener(new KeyListener() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, outboundPolicyKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    outboundPolicyKeyText.setText(outboundPolicyKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CalloutMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getOutboundPolicyKey()));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

        });
		
		EditingUtils.setID(outboundPolicyKeyText, EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey);
		EditingUtils.setEEFtype(outboundPolicyKeyText, "eef::Text");
		Control outboundPolicyKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		outboundPolicyKeyElements = new Control[] { outboundPolicyKeyLabel, outboundPolicyKeyText,
				outboundPolicyKeyHelp };
		return parent;
	}
	
	@Override
    public void refresh() {
        super.refresh();
        validate();
    }
	
	EEFPropertyViewUtil viewUtil = new EEFPropertyViewUtil(view);
	
    public void validate() {
    
		viewUtil.clearElements(new Composite[] { miscGroup, serviceGroup, sourceGroup, targetGroup, wSGroup });
    	
		viewUtil.showEntry(descriptionElements, false);
		viewUtil.showEntry(endpointTypeElements, false);
		if (getEndpointType().getLiteral().equals("URL")) {
			viewUtil.showEntry(serviceUrlElements, false);
		} else if (getEndpointType().getLiteral().equals("AddressEndpoint")) {
			viewUtil.showEntry(addressEndpointElements, false);
		}
		
    	viewUtil.showEntry(soapActionElements, false);
    	viewUtil.showEntry(pathToAxis2xmlElements, false);
    	viewUtil.showEntry(pathToAxis2RepositoryElements, false);
    	viewUtil.showEntry(initAxis2ClientOptionsElements, false);
    	viewUtil.showEntry(payloadTypeElements, false);
    	viewUtil.showEntry(resultTypeElements, false);
    	
    	if(getPayloadType().getLiteral().equals("XPATH")) {
    		viewUtil.showEntry(PayloadMessageXpathElements, false);
    	} else if(getPayloadType().getLiteral().equals("PROPERTY")) {
    		viewUtil.showEntry(payloadPropertyElements, false);
    	}
    	
    	viewUtil.showEntry(resultTypeElements, false);
    	if(getResultType().getLiteral().equals("XPATH")) {
    		viewUtil.showEntry(resultMessageXpathElements, false);
    	} else if(getResultType().getLiteral().equals("PROPERTY")) {
    		viewUtil.showEntry(resultContextPropertyElements, false);
    	}
    	
    	viewUtil.showEntry(securityTypeElements, false);
    	if(getSecurityType().getLiteral().equals("TRUE")) {
    		viewUtil.showEntry(policiesElements, false);
    		if(getPolicies().getLiteral().equals("TRUE")) {
    			viewUtil.showEntry(outboundPolicyKeyElements, false);
    			viewUtil.showEntry(inboundPolicyKeyElements, false);
    		} else if(getPolicies().getLiteral().equals("FALSE")) {
    			viewUtil.showEntry(policyKeyElements, false);
    		}
    	} 
       	
        view.layout(true, true);
    }
	// End of user code


}
