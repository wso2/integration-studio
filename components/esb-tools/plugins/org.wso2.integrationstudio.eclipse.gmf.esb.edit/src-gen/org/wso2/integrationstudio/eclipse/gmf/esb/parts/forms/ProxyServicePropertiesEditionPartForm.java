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
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.ProxyWsdlType;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.SequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class ProxyServicePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ProxyServicePropertiesEditionPart {

	protected Text name;
	protected Text pinnedServers;
	protected Text serviceGroup;
	protected Button traceEnabled;
	protected Button statisticsEnabled;
	protected Button startOnLoad;
	protected Text transports;
	
	// Start of user code  for onError widgets declarations
	protected RegistryKeyProperty onError;
	protected Text onErrorText;
	protected Control[] onErrorElements;
	// End of user code

	protected EMFComboViewer endpointType;
	protected Text endpointName;
	
	// Start of user code  for endpointKey widgets declarations
	protected RegistryKeyProperty endpointKey;
	protected Text endpointKeyText;
	protected Control[] endpointKeyElements;
	// End of user code

	protected EMFComboViewer faultSequenceType;
	protected Text faultSequenceName;
	
	// Start of user code  for faultSequenceKey widgets declarations
	protected RegistryKeyProperty faultSequenceKey;
	protected Text faultSequenceKeyText;
	protected Control[] faultSequenceKeyElements;
	// End of user code

	// Start of user code  for faultSequenceOnError widgets declarations
	protected RegistryKeyProperty faultSequenceOnError;
	protected Text faultSequenceOnErrorText;
	protected Control[] faultSequenceOnErrorElements;
	// End of user code

	protected EMFComboViewer inSequenceType;
	protected Text inSequenceName;
	
	// Start of user code  for inSequenceKey widgets declarations
	protected RegistryKeyProperty inSequenceKey;
	protected Text inSequenceKeyText;
	protected Control[] inSequenceKeyElements;
	// End of user code

	// Start of user code  for inSequenceOnError widgets declarations
	protected RegistryKeyProperty inSequenceOnError;
	protected Text inSequenceOnErrorText;
	protected Control[] inSequenceOnErrorElements;
	// End of user code

	protected EMFComboViewer outSequenceType;
	protected Text outSequenceName;
	
	// Start of user code  for outSequenceKey widgets declarations
	protected RegistryKeyProperty outSequenceKey;
	protected Text outSequenceKeyText;
	protected Control[] outSequenceKeyElements;
	// End of user code

	// Start of user code  for outSequenceOnError widgets declarations
	protected RegistryKeyProperty outSequenceOnError;
	protected Text outSequenceOnErrorText;
	protected Control[] outSequenceOnErrorElements;
	// End of user code

	protected ReferencesTable serviceParameters;
	protected List<ViewerFilter> serviceParametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> serviceParametersFilters = new ArrayList<ViewerFilter>();
	protected Button reliableMessagingEnabled;
	protected Button securityEnabled;
	protected ReferencesTable servicePolicies;
	protected List<ViewerFilter> servicePoliciesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> servicePoliciesFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer wsdlType;
	protected Text wsdlXML;
	protected Text wsdlURL;
	protected ReferencesTable wsdlResources;
	protected List<ViewerFilter> wsdlResourcesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> wsdlResourcesFilters = new ArrayList<ViewerFilter>();
	protected Button preservePolicy;
	// Start of user code  for wsdlKey widgets declarations
	protected RegistryKeyProperty wsdlKey;
	protected Text wsdlKeyText;
	protected Control[] wsdlKeyElements;
	// End of user code

	// Start of user code  for wsdlEndpoint widgets declarations
	protected RegistryKeyProperty wsdlEndpoint;
	protected Text wsdlEndpointText;
	protected Control[] wsdlEndpointElements;
	
	protected Section propertiesSection;
	
	protected Composite propertiesGroup;
	protected Composite endpointGroup;
	protected Composite faultSequenceGroup;
	protected Composite inSequenceGroup;
	protected Composite outSequenceGroup;
	protected Composite wsdlGroup;
	
	protected Control[] endpointTypeElements;
	protected Control[] endpointNameElements;
	protected Control[] faultSequenceTypeElements;
	protected Control[] faultSequenceNameElements;
	protected Control[] insequenceTypeElements;
	protected Control[] inSequenceNameElements;
	protected Control[] outSequenceTypeElements;
	protected Control[] outSequenceNameElements;
	protected Control[] wsdlTypeElements;
	protected Control[] wsdlXMLElements;
	protected Control[] wsdlURLElements;
	protected Control[] wsdlResourcesElements;
	protected Control[] preservePolicyElements;
	// End of user code

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected ReferencesTable inSequenceInputConnectors;
	protected List<ViewerFilter> inSequenceInputConnectorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> inSequenceInputConnectorsFilters = new ArrayList<ViewerFilter>();
	protected Button mainSequence;



	/**
	 * For {@link ISection} use only.
	 */
	public ProxyServicePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ProxyServicePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence proxyServiceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep basicStep = proxyServiceStep.addStep(EsbViewsRepository.ProxyService.Basic.class);
		basicStep.addStep(EsbViewsRepository.ProxyService.Basic.name);
		basicStep.addStep(EsbViewsRepository.ProxyService.Basic.pinnedServers);
		basicStep.addStep(EsbViewsRepository.ProxyService.Basic.serviceGroup);
		basicStep.addStep(EsbViewsRepository.ProxyService.Basic.traceEnabled);
		basicStep.addStep(EsbViewsRepository.ProxyService.Basic.statisticsEnabled);
		basicStep.addStep(EsbViewsRepository.ProxyService.Basic.startOnLoad);
		basicStep.addStep(EsbViewsRepository.ProxyService.Basic.transports);
		basicStep.addStep(EsbViewsRepository.ProxyService.Basic.onError);
		
		CompositionStep endpointStep = proxyServiceStep.addStep(EsbViewsRepository.ProxyService.Endpoint.class);
		endpointStep.addStep(EsbViewsRepository.ProxyService.Endpoint.endpointType);
		endpointStep.addStep(EsbViewsRepository.ProxyService.Endpoint.endpointName);
		endpointStep.addStep(EsbViewsRepository.ProxyService.Endpoint.endpointKey);
		
		CompositionStep faultSequenceStep = proxyServiceStep.addStep(EsbViewsRepository.ProxyService.FaultSequence.class);
		faultSequenceStep.addStep(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType);
		faultSequenceStep.addStep(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName);
		faultSequenceStep.addStep(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceKey);
		faultSequenceStep.addStep(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceOnError);
		
		CompositionStep inSequenceStep = proxyServiceStep.addStep(EsbViewsRepository.ProxyService.InSequence.class);
		inSequenceStep.addStep(EsbViewsRepository.ProxyService.InSequence.inSequenceType);
		inSequenceStep.addStep(EsbViewsRepository.ProxyService.InSequence.inSequenceName);
		inSequenceStep.addStep(EsbViewsRepository.ProxyService.InSequence.inSequenceKey);
		inSequenceStep.addStep(EsbViewsRepository.ProxyService.InSequence.inSequenceOnError);
		
		CompositionStep outSequenceStep = proxyServiceStep.addStep(EsbViewsRepository.ProxyService.OutSequence.class);
		outSequenceStep.addStep(EsbViewsRepository.ProxyService.OutSequence.outSequenceType);
		outSequenceStep.addStep(EsbViewsRepository.ProxyService.OutSequence.outSequenceName);
		outSequenceStep.addStep(EsbViewsRepository.ProxyService.OutSequence.outSequenceKey);
		outSequenceStep.addStep(EsbViewsRepository.ProxyService.OutSequence.outSequenceOnError);
		
		proxyServiceStep
			.addStep(EsbViewsRepository.ProxyService.Parameters.class)
			.addStep(EsbViewsRepository.ProxyService.Parameters.serviceParameters);
		
		proxyServiceStep
			.addStep(EsbViewsRepository.ProxyService.ReliableMessaging.class)
			.addStep(EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled);
		
		CompositionStep securityStep = proxyServiceStep.addStep(EsbViewsRepository.ProxyService.Security.class);
		securityStep.addStep(EsbViewsRepository.ProxyService.Security.securityEnabled);
		securityStep.addStep(EsbViewsRepository.ProxyService.Security.servicePolicies);
		
		CompositionStep wsdlStep = proxyServiceStep.addStep(EsbViewsRepository.ProxyService.Wsdl.class);
		wsdlStep.addStep(EsbViewsRepository.ProxyService.Wsdl.wsdlType);
		wsdlStep.addStep(EsbViewsRepository.ProxyService.Wsdl.wsdlXML);
		wsdlStep.addStep(EsbViewsRepository.ProxyService.Wsdl.wsdlURL);
		wsdlStep.addStep(EsbViewsRepository.ProxyService.Wsdl.wsdlKey);
		wsdlStep.addStep(EsbViewsRepository.ProxyService.Wsdl.wsdlResources);
		wsdlStep.addStep(EsbViewsRepository.ProxyService.Wsdl.preservePolicy);
		wsdlStep.addStep(EsbViewsRepository.ProxyService.Wsdl.wsdlEndpoint);
		
		CompositionStep propertiesStep = proxyServiceStep.addStep(EsbViewsRepository.ProxyService.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.mainSequence);
		
		
		composer = new PartComposer(proxyServiceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ProxyService.Basic.class) {
					return createBasicGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.pinnedServers) {
					return createPinnedServersText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.serviceGroup) {
					return createServiceGroupText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.traceEnabled) {
					return createTraceEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.statisticsEnabled) {
					return createStatisticsEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.startOnLoad) {
					return createStartOnLoadCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.transports) {
					return createTransportsText(widgetFactory, parent);
				}
				// Start of user code for onError addToPart creation
				if (key == EsbViewsRepository.ProxyService.Basic.onError ) {
				    return createOnError(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.ProxyService.Endpoint.class) {
					return createEndpointGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Endpoint.endpointType) {
					return createEndpointTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Endpoint.endpointName) {
					return createEndpointNameText(widgetFactory, parent);
				}
				// Start of user code for endpointKey addToPart creation
				if (key == EsbViewsRepository.ProxyService.Endpoint.endpointKey) {
				    return createEndpointKey(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.ProxyService.FaultSequence.class) {
					return createFaultSequenceGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType) {
					return createFaultSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName) {
					return createFaultSequenceNameText(widgetFactory, parent);
				}
				// Start of user code for faultSequenceKey addToPart creation
				if (key == EsbViewsRepository.ProxyService.FaultSequence.faultSequenceKey) {
				    return createFaultSequenceKey(widgetFactory, parent);
				}
				// End of user code
				// Start of user code for faultSequenceOnError addToPart creation
				if (key == EsbViewsRepository.ProxyService.FaultSequence.faultSequenceOnError) {
				    return createFaultSequenceOnError(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.ProxyService.InSequence.class) {
					return createInSequenceGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.InSequence.inSequenceType) {
					return createInSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.InSequence.inSequenceName) {
					return createInSequenceNameText(widgetFactory, parent);
				}
				// Start of user code for inSequenceKey addToPart creation
				if ( key == EsbViewsRepository.ProxyService.InSequence.inSequenceKey) {
				    return createInSequenceKey(widgetFactory, parent);
				}
				// End of user code
				// Start of user code for inSequenceOnError addToPart creation
				if (key == EsbViewsRepository.ProxyService.InSequence.inSequenceOnError) {
				    return createInSequenceOnError(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.ProxyService.OutSequence.class) {
					return createOutSequenceGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.OutSequence.outSequenceType) {
					return createOutSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.OutSequence.outSequenceName) {
					return createOutSequenceNameText(widgetFactory, parent);
				}
				// Start of user code for outSequenceKey addToPart creation
				if (key == EsbViewsRepository.ProxyService.OutSequence.outSequenceKey) {
				    return createOutSequenceKey(widgetFactory, parent);
				}
				// End of user code
				// Start of user code for outSequenceOnError addToPart creation
				if (key == EsbViewsRepository.ProxyService.OutSequence.outSequenceOnError) {
				    return createOutSequenceOnError(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.ProxyService.Parameters.class) {
					return createParametersGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Parameters.serviceParameters) {
					return createServiceParametersTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.ReliableMessaging.class) {
					return createReliableMessagingGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled) {
					return createReliableMessagingEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Security.class) {
					return createSecurityGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Security.securityEnabled) {
					return createSecurityEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Security.servicePolicies) {
					return createServicePoliciesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.class) {
					return createWsdlGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.wsdlType) {
					return createWsdlTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.wsdlXML) {
					return createWsdlXMLText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.wsdlURL) {
					return createWsdlURLText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.wsdlResources) {
					return createWsdlResourcesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.preservePolicy) {
					return createPreservePolicyCheckbox(widgetFactory, parent);
				}
				// Start of user code for wsdlKey addToPart creation
				if (key == EsbViewsRepository.ProxyService.Wsdl.wsdlKey) {
				    return createWsdlKey(widgetFactory, parent);
				}
				// End of user code
				// Start of user code for wsdlEndpoint addToPart creation
				if (key == EsbViewsRepository.ProxyService.Wsdl.wsdlEndpoint) {
				    return createWsdlEndpoint(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.ProxyService.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors) {
					return createInSequenceInputConnectorsTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.mainSequence) {
					return createMainSequenceCheckbox(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createBasicGroup(FormToolkit widgetFactory, final Composite parent) {
		Section basicSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		basicSection.setText(EsbMessages.ProxyServicePropertiesEditionPart_BasicGroupLabel);
		GridData basicSectionData = new GridData(GridData.FILL_HORIZONTAL);
		basicSectionData.horizontalSpan = 3;
		basicSection.setLayoutData(basicSectionData);
		Composite basicGroup = widgetFactory.createComposite(basicSection);
		GridLayout basicGroupLayout = new GridLayout();
		basicGroupLayout.numColumns = 3;
		basicGroup.setLayout(basicGroupLayout);
		basicSection.setClient(basicGroup);
		return basicGroup;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Basic.name, EsbMessages.ProxyServicePropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ProxyServicePropertiesEditionPartForm.this,
							EsbViewsRepository.ProxyService.Basic.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ProxyServicePropertiesEditionPartForm.this,
									EsbViewsRepository.ProxyService.Basic.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
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
									ProxyServicePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Basic.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EsbViewsRepository.ProxyService.Basic.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.name, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createPinnedServersText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Basic.pinnedServers, EsbMessages.ProxyServicePropertiesEditionPart_PinnedServersLabel);
		pinnedServers = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		pinnedServers.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData pinnedServersData = new GridData(GridData.FILL_HORIZONTAL);
		pinnedServers.setLayoutData(pinnedServersData);
		pinnedServers.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ProxyServicePropertiesEditionPartForm.this,
							EsbViewsRepository.ProxyService.Basic.pinnedServers,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pinnedServers.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ProxyServicePropertiesEditionPartForm.this,
									EsbViewsRepository.ProxyService.Basic.pinnedServers,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, pinnedServers.getText()));
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
									ProxyServicePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		pinnedServers.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Basic.pinnedServers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pinnedServers.getText()));
				}
			}
		});
		EditingUtils.setID(pinnedServers, EsbViewsRepository.ProxyService.Basic.pinnedServers);
		EditingUtils.setEEFtype(pinnedServers, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.pinnedServers, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPinnedServersText

		// End of user code
		return parent;
	}

	
	protected Composite createServiceGroupText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Basic.serviceGroup, EsbMessages.ProxyServicePropertiesEditionPart_ServiceGroupLabel);
		serviceGroup = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		serviceGroup.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData serviceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		serviceGroup.setLayoutData(serviceGroupData);
		serviceGroup.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ProxyServicePropertiesEditionPartForm.this,
							EsbViewsRepository.ProxyService.Basic.serviceGroup,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceGroup.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ProxyServicePropertiesEditionPartForm.this,
									EsbViewsRepository.ProxyService.Basic.serviceGroup,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, serviceGroup.getText()));
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
									ProxyServicePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		serviceGroup.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Basic.serviceGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceGroup.getText()));
				}
			}
		});
		EditingUtils.setID(serviceGroup, EsbViewsRepository.ProxyService.Basic.serviceGroup);
		EditingUtils.setEEFtype(serviceGroup, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.serviceGroup, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createServiceGroupText

		// End of user code
		return parent;
	}

	
	protected Composite createTraceEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		traceEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ProxyService.Basic.traceEnabled, EsbMessages.ProxyServicePropertiesEditionPart_TraceEnabledLabel), SWT.CHECK);
		traceEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Basic.traceEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(traceEnabled.getSelection())));
			}

		});
		GridData traceEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		traceEnabledData.horizontalSpan = 2;
		traceEnabled.setLayoutData(traceEnabledData);
		EditingUtils.setID(traceEnabled, EsbViewsRepository.ProxyService.Basic.traceEnabled);
		EditingUtils.setEEFtype(traceEnabled, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.traceEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTraceEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createStatisticsEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		statisticsEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ProxyService.Basic.statisticsEnabled, EsbMessages.ProxyServicePropertiesEditionPart_StatisticsEnabledLabel), SWT.CHECK);
		statisticsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Basic.statisticsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statisticsEnabled.getSelection())));
			}

		});
		GridData statisticsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		statisticsEnabledData.horizontalSpan = 2;
		statisticsEnabled.setLayoutData(statisticsEnabledData);
		EditingUtils.setID(statisticsEnabled, EsbViewsRepository.ProxyService.Basic.statisticsEnabled);
		EditingUtils.setEEFtype(statisticsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.statisticsEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatisticsEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createStartOnLoadCheckbox(FormToolkit widgetFactory, Composite parent) {
		startOnLoad = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ProxyService.Basic.startOnLoad, EsbMessages.ProxyServicePropertiesEditionPart_StartOnLoadLabel), SWT.CHECK);
		startOnLoad.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Basic.startOnLoad, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(startOnLoad.getSelection())));
			}

		});
		GridData startOnLoadData = new GridData(GridData.FILL_HORIZONTAL);
		startOnLoadData.horizontalSpan = 2;
		startOnLoad.setLayoutData(startOnLoadData);
		EditingUtils.setID(startOnLoad, EsbViewsRepository.ProxyService.Basic.startOnLoad);
		EditingUtils.setEEFtype(startOnLoad, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.startOnLoad, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStartOnLoadCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createTransportsText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Basic.transports, EsbMessages.ProxyServicePropertiesEditionPart_TransportsLabel);
		transports = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		transports.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData transportsData = new GridData(GridData.FILL_HORIZONTAL);
		transports.setLayoutData(transportsData);
		transports.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ProxyServicePropertiesEditionPartForm.this,
							EsbViewsRepository.ProxyService.Basic.transports,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, transports.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ProxyServicePropertiesEditionPartForm.this,
									EsbViewsRepository.ProxyService.Basic.transports,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, transports.getText()));
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
									ProxyServicePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		transports.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Basic.transports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, transports.getText()));
				}
			}
		});
		EditingUtils.setID(transports, EsbViewsRepository.ProxyService.Basic.transports);
		EditingUtils.setEEFtype(transports, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.transports, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTransportsText

		// End of user code
		return parent;
	}

	 /**
     * @generated NOT
     */
	protected Composite createEndpointGroup(FormToolkit widgetFactory, final Composite parent) {
		Section endpointSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		endpointSection.setText(EsbMessages.ProxyServicePropertiesEditionPart_EndpointGroupLabel);
		GridData endpointSectionData = new GridData(GridData.FILL_HORIZONTAL);
		endpointSectionData.horizontalSpan = 3;
		endpointSection.setLayoutData(endpointSectionData);
		endpointGroup = widgetFactory.createComposite(endpointSection);
		GridLayout endpointGroupLayout = new GridLayout();
		endpointGroupLayout.numColumns = 3;
		endpointGroup.setLayout(endpointGroupLayout);
		endpointSection.setClient(endpointGroup);
		return endpointGroup;
	}

	 /**
     * @generated NOT
     */
	protected Composite createEndpointTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control endpointTypeLabel = createDescription(parent, EsbViewsRepository.ProxyService.Endpoint.endpointType, EsbMessages.ProxyServicePropertiesEditionPart_EndpointTypeLabel);
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
			    validateEndpoint();
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Endpoint.endpointType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEndpointType()));
			}

		});
		endpointType.setID(EsbViewsRepository.ProxyService.Endpoint.endpointType);
		Control endpointTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Endpoint.endpointType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointTypeEMFComboViewer
		endpointTypeElements = new Control[] {endpointTypeLabel, endpointType.getCombo(), endpointTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createEndpointNameText(FormToolkit widgetFactory, Composite parent) {
		Control endpointNameLabel = createDescription(parent, EsbViewsRepository.ProxyService.Endpoint.endpointName, EsbMessages.ProxyServicePropertiesEditionPart_EndpointNameLabel);
		endpointName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		endpointName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData endpointNameData = new GridData(GridData.FILL_HORIZONTAL);
		endpointName.setLayoutData(endpointNameData);
		endpointName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ProxyServicePropertiesEditionPartForm.this,
							EsbViewsRepository.ProxyService.Endpoint.endpointName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endpointName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ProxyServicePropertiesEditionPartForm.this,
									EsbViewsRepository.ProxyService.Endpoint.endpointName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, endpointName.getText()));
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
									ProxyServicePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		endpointName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Endpoint.endpointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endpointName.getText()));
				}
			}
		});
		EditingUtils.setID(endpointName, EsbViewsRepository.ProxyService.Endpoint.endpointName);
		EditingUtils.setEEFtype(endpointName, "eef::Text"); //$NON-NLS-1$
		Control endpointNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Endpoint.endpointName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointNameText
		endpointNameElements = new Control[] {endpointNameLabel, endpointName, endpointNameHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createFaultSequenceGroup(FormToolkit widgetFactory, final Composite parent) {
		Section faultSequenceSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		faultSequenceSection.setText(EsbMessages.ProxyServicePropertiesEditionPart_FaultSequenceGroupLabel);
		GridData faultSequenceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		faultSequenceSectionData.horizontalSpan = 3;
		faultSequenceSection.setLayoutData(faultSequenceSectionData);
		faultSequenceGroup = widgetFactory.createComposite(faultSequenceSection);
		GridLayout faultSequenceGroupLayout = new GridLayout();
		faultSequenceGroupLayout.numColumns = 3;
		faultSequenceGroup.setLayout(faultSequenceGroupLayout);
		faultSequenceSection.setClient(faultSequenceGroup);
		return faultSequenceGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createFaultSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control faultSequenceTypeLabel = createDescription(parent, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType, EsbMessages.ProxyServicePropertiesEditionPart_FaultSequenceTypeLabel);
		faultSequenceType = new EMFComboViewer(parent);
		faultSequenceType.setContentProvider(new ArrayContentProvider());
		faultSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultSequenceType.getCombo().setLayoutData(faultSequenceTypeData);
                faultSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			    validateFaultSequence();
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultSequenceType()));
			}

		});
		faultSequenceType.setID(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType);
		Control faultSequenceTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultSequenceTypeEMFComboViewer
		faultSequenceTypeElements = new Control[] {faultSequenceTypeLabel, faultSequenceType.getCombo(), faultSequenceTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createFaultSequenceNameText(FormToolkit widgetFactory, Composite parent) {
		Control faultSequenceNameLabel = createDescription(parent, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName, EsbMessages.ProxyServicePropertiesEditionPart_FaultSequenceNameLabel);
		faultSequenceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		faultSequenceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData faultSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		faultSequenceName.setLayoutData(faultSequenceNameData);
		faultSequenceName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ProxyServicePropertiesEditionPartForm.this,
							EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultSequenceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ProxyServicePropertiesEditionPartForm.this,
									EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, faultSequenceName.getText()));
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
									ProxyServicePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		faultSequenceName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultSequenceName.getText()));
				}
			}
		});
		EditingUtils.setID(faultSequenceName, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName);
		EditingUtils.setEEFtype(faultSequenceName, "eef::Text"); //$NON-NLS-1$
		Control faultSequenceNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultSequenceNameText
		faultSequenceNameElements = new Control[] {faultSequenceNameLabel, faultSequenceName, faultSequenceNameHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createInSequenceGroup(FormToolkit widgetFactory, final Composite parent) {
		Section inSequenceSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		inSequenceSection.setText(EsbMessages.ProxyServicePropertiesEditionPart_InSequenceGroupLabel);
		GridData inSequenceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceSectionData.horizontalSpan = 3;
		inSequenceSection.setLayoutData(inSequenceSectionData);
		inSequenceGroup = widgetFactory.createComposite(inSequenceSection);
		GridLayout inSequenceGroupLayout = new GridLayout();
		inSequenceGroupLayout.numColumns = 3;
		inSequenceGroup.setLayout(inSequenceGroupLayout);
		inSequenceSection.setClient(inSequenceGroup);
		return inSequenceGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createInSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control inSeqTypeLabel = createDescription(parent, EsbViewsRepository.ProxyService.InSequence.inSequenceType, EsbMessages.ProxyServicePropertiesEditionPart_InSequenceTypeLabel);
		inSequenceType = new EMFComboViewer(parent);
		inSequenceType.setContentProvider(new ArrayContentProvider());
		inSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData inSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceType.getCombo().setLayoutData(inSequenceTypeData);
                inSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		inSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			    validateInSequence();
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.InSequence.inSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInSequenceType()));
			}

		});
		inSequenceType.setID(EsbViewsRepository.ProxyService.InSequence.inSequenceType);
		Control inSeqTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.InSequence.inSequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInSequenceTypeEMFComboViewer
		insequenceTypeElements = new Control[] {inSeqTypeLabel, inSequenceType.getCombo(), inSeqTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createInSequenceNameText(FormToolkit widgetFactory, Composite parent) {
		Control inSeqNameLabel = createDescription(parent, EsbViewsRepository.ProxyService.InSequence.inSequenceName, EsbMessages.ProxyServicePropertiesEditionPart_InSequenceNameLabel);
		inSequenceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		inSequenceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData inSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceName.setLayoutData(inSequenceNameData);
		inSequenceName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ProxyServicePropertiesEditionPartForm.this,
							EsbViewsRepository.ProxyService.InSequence.inSequenceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inSequenceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ProxyServicePropertiesEditionPartForm.this,
									EsbViewsRepository.ProxyService.InSequence.inSequenceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, inSequenceName.getText()));
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
									ProxyServicePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		inSequenceName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.InSequence.inSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inSequenceName.getText()));
				}
			}
		});
		EditingUtils.setID(inSequenceName, EsbViewsRepository.ProxyService.InSequence.inSequenceName);
		EditingUtils.setEEFtype(inSequenceName, "eef::Text"); //$NON-NLS-1$
		Control inSeqNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.InSequence.inSequenceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInSequenceNameText
		inSequenceNameElements = new Control[] {inSeqNameLabel, inSequenceName, inSeqNameHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOutSequenceGroup(FormToolkit widgetFactory, final Composite parent) {
		Section outSequenceSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		outSequenceSection.setText(EsbMessages.ProxyServicePropertiesEditionPart_OutSequenceGroupLabel);
		GridData outSequenceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		outSequenceSectionData.horizontalSpan = 3;
		outSequenceSection.setLayoutData(outSequenceSectionData);
		outSequenceGroup = widgetFactory.createComposite(outSequenceSection);
		GridLayout outSequenceGroupLayout = new GridLayout();
		outSequenceGroupLayout.numColumns = 3;
		outSequenceGroup.setLayout(outSequenceGroupLayout);
		outSequenceSection.setClient(outSequenceGroup);
		return outSequenceGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createOutSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control outSeqTypeLabel = createDescription(parent, EsbViewsRepository.ProxyService.OutSequence.outSequenceType, EsbMessages.ProxyServicePropertiesEditionPart_OutSequenceTypeLabel);
		outSequenceType = new EMFComboViewer(parent);
		outSequenceType.setContentProvider(new ArrayContentProvider());
		outSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData outSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		outSequenceType.getCombo().setLayoutData(outSequenceTypeData);
                outSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		outSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			    validateOutSequence();
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.OutSequence.outSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutSequenceType()));
			}

		});
		outSequenceType.setID(EsbViewsRepository.ProxyService.OutSequence.outSequenceType);
		Control outSeqTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.OutSequence.outSequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutSequenceTypeEMFComboViewer
		outSequenceTypeElements = new Control[] {outSeqTypeLabel, outSequenceType.getCombo(), outSeqTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOutSequenceNameText(FormToolkit widgetFactory, Composite parent) {
		Control outSeqNameLabel = createDescription(parent, EsbViewsRepository.ProxyService.OutSequence.outSequenceName, EsbMessages.ProxyServicePropertiesEditionPart_OutSequenceNameLabel);
		outSequenceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		outSequenceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData outSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		outSequenceName.setLayoutData(outSequenceNameData);
		outSequenceName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ProxyServicePropertiesEditionPartForm.this,
							EsbViewsRepository.ProxyService.OutSequence.outSequenceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outSequenceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ProxyServicePropertiesEditionPartForm.this,
									EsbViewsRepository.ProxyService.OutSequence.outSequenceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, outSequenceName.getText()));
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
									ProxyServicePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		outSequenceName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.OutSequence.outSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outSequenceName.getText()));
				}
			}
		});
		EditingUtils.setID(outSequenceName, EsbViewsRepository.ProxyService.OutSequence.outSequenceName);
		EditingUtils.setEEFtype(outSequenceName, "eef::Text"); //$NON-NLS-1$
		Control outSeqNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.OutSequence.outSequenceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutSequenceNameText
		outSequenceNameElements = new Control[] {outSeqNameLabel, outSequenceName, outSeqNameHelp};
		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createParametersGroup(FormToolkit widgetFactory, final Composite parent) {
		Section parametersSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		parametersSection.setText(EsbMessages.ProxyServicePropertiesEditionPart_ParametersGroupLabel);
		GridData parametersSectionData = new GridData(GridData.FILL_HORIZONTAL);
		parametersSectionData.horizontalSpan = 3;
		parametersSection.setLayoutData(parametersSectionData);
		Composite parametersGroup = widgetFactory.createComposite(parametersSection);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		parametersSection.setClient(parametersGroup);
		return parametersGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createServiceParametersTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.serviceParameters = new ReferencesTable(getDescription(EsbViewsRepository.ProxyService.Parameters.serviceParameters, EsbMessages.ProxyServicePropertiesEditionPart_ServiceParametersLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Parameters.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				serviceParameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Parameters.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				serviceParameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Parameters.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				serviceParameters.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Parameters.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				serviceParameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.serviceParametersFilters) {
			this.serviceParameters.addFilter(filter);
		}
		this.serviceParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Parameters.serviceParameters, EsbViewsRepository.FORM_KIND));
		this.serviceParameters.createControls(parent, widgetFactory);
		this.serviceParameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Parameters.serviceParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData serviceParametersData = new GridData(GridData.FILL_HORIZONTAL);
		serviceParametersData.horizontalSpan = 3;
		this.serviceParameters.setLayoutData(serviceParametersData);
		this.serviceParameters.setLowerBound(0);
		this.serviceParameters.setUpperBound(-1);
		serviceParameters.setID(EsbViewsRepository.ProxyService.Parameters.serviceParameters);
		serviceParameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createServiceParametersTableComposition

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createReliableMessagingGroup(FormToolkit widgetFactory, final Composite parent) {
		Section reliableMessagingSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		reliableMessagingSection.setText(EsbMessages.ProxyServicePropertiesEditionPart_ReliableMessagingGroupLabel);
		GridData reliableMessagingSectionData = new GridData(GridData.FILL_HORIZONTAL);
		reliableMessagingSectionData.horizontalSpan = 3;
		reliableMessagingSection.setLayoutData(reliableMessagingSectionData);
		Composite reliableMessagingGroup = widgetFactory.createComposite(reliableMessagingSection);
		GridLayout reliableMessagingGroupLayout = new GridLayout();
		reliableMessagingGroupLayout.numColumns = 3;
		reliableMessagingGroup.setLayout(reliableMessagingGroupLayout);
		reliableMessagingSection.setClient(reliableMessagingGroup);
		return reliableMessagingGroup;
	}

	
	protected Composite createReliableMessagingEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		reliableMessagingEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled, EsbMessages.ProxyServicePropertiesEditionPart_ReliableMessagingEnabledLabel), SWT.CHECK);
		reliableMessagingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reliableMessagingEnabled.getSelection())));
			}

		});
		GridData reliableMessagingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		reliableMessagingEnabledData.horizontalSpan = 2;
		reliableMessagingEnabled.setLayoutData(reliableMessagingEnabledData);
		EditingUtils.setID(reliableMessagingEnabled, EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled);
		EditingUtils.setEEFtype(reliableMessagingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReliableMessagingEnabledCheckbox

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createSecurityGroup(FormToolkit widgetFactory, final Composite parent) {
		Section securitySection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		securitySection.setText(EsbMessages.ProxyServicePropertiesEditionPart_SecurityGroupLabel);
		GridData securitySectionData = new GridData(GridData.FILL_HORIZONTAL);
		securitySectionData.horizontalSpan = 3;
		securitySection.setLayoutData(securitySectionData);
		Composite securityGroup = widgetFactory.createComposite(securitySection);
		GridLayout securityGroupLayout = new GridLayout();
		securityGroupLayout.numColumns = 3;
		securityGroup.setLayout(securityGroupLayout);
		securitySection.setClient(securityGroup);
		return securityGroup;
	}

	
	protected Composite createSecurityEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		securityEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ProxyService.Security.securityEnabled, EsbMessages.ProxyServicePropertiesEditionPart_SecurityEnabledLabel), SWT.CHECK);
		securityEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Security.securityEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(securityEnabled.getSelection())));
			}

		});
		GridData securityEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		securityEnabledData.horizontalSpan = 2;
		securityEnabled.setLayoutData(securityEnabledData);
		EditingUtils.setID(securityEnabled, EsbViewsRepository.ProxyService.Security.securityEnabled);
		EditingUtils.setEEFtype(securityEnabled, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Security.securityEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSecurityEnabledCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createServicePoliciesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.servicePolicies = new ReferencesTable(getDescription(EsbViewsRepository.ProxyService.Security.servicePolicies, EsbMessages.ProxyServicePropertiesEditionPart_ServicePoliciesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Security.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				servicePolicies.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Security.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				servicePolicies.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Security.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				servicePolicies.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Security.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				servicePolicies.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.servicePoliciesFilters) {
			this.servicePolicies.addFilter(filter);
		}
		this.servicePolicies.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Security.servicePolicies, EsbViewsRepository.FORM_KIND));
		this.servicePolicies.createControls(parent, widgetFactory);
		this.servicePolicies.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Security.servicePolicies, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData servicePoliciesData = new GridData(GridData.FILL_HORIZONTAL);
		servicePoliciesData.horizontalSpan = 3;
		this.servicePolicies.setLayoutData(servicePoliciesData);
		this.servicePolicies.setLowerBound(0);
		this.servicePolicies.setUpperBound(-1);
		servicePolicies.setID(EsbViewsRepository.ProxyService.Security.servicePolicies);
		servicePolicies.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createServicePoliciesTableComposition

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createWsdlGroup(FormToolkit widgetFactory, final Composite parent) {
		Section wsdlSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		wsdlSection.setText(EsbMessages.ProxyServicePropertiesEditionPart_WsdlGroupLabel);
		GridData wsdlSectionData = new GridData(GridData.FILL_HORIZONTAL);
		wsdlSectionData.horizontalSpan = 3;
		wsdlSection.setLayoutData(wsdlSectionData);
		wsdlGroup = widgetFactory.createComposite(wsdlSection);
		GridLayout wsdlGroupLayout = new GridLayout();
		wsdlGroupLayout.numColumns = 3;
		wsdlGroup.setLayout(wsdlGroupLayout);
		wsdlSection.setClient(wsdlGroup);
		return wsdlGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createWsdlTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control wsdlTypeLabel = createDescription(parent, EsbViewsRepository.ProxyService.Wsdl.wsdlType, EsbMessages.ProxyServicePropertiesEditionPart_WsdlTypeLabel);
		wsdlType = new EMFComboViewer(parent);
		wsdlType.setContentProvider(new ArrayContentProvider());
		wsdlType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData wsdlTypeData = new GridData(GridData.FILL_HORIZONTAL);
		wsdlType.getCombo().setLayoutData(wsdlTypeData);
                wsdlType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		wsdlType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			    validateWSDL();
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Wsdl.wsdlType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getWsdlType()));
			}

		});
		wsdlType.setID(EsbViewsRepository.ProxyService.Wsdl.wsdlType);
		Control wsdlTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Wsdl.wsdlType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createWsdlTypeEMFComboViewer
		wsdlTypeElements = new Control[] {wsdlTypeLabel, wsdlType.getCombo(), wsdlTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createWsdlXMLText(FormToolkit widgetFactory, Composite parent) {
		Control wsdlXMLLabel = createDescription(parent, EsbViewsRepository.ProxyService.Wsdl.wsdlXML, EsbMessages.ProxyServicePropertiesEditionPart_WsdlXMLLabel);
		wsdlXML = new Text(parent, SWT.MULTI | SWT.V_SCROLL | SWT.BORDER);
		wsdlXML.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData wsdlXMLData = new GridData(GridData.FILL_HORIZONTAL);
		wsdlXMLData.heightHint = 80;
		wsdlXML.setLayoutData(wsdlXMLData);
		wsdlXML.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ProxyServicePropertiesEditionPartForm.this,
							EsbViewsRepository.ProxyService.Wsdl.wsdlXML,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlXML.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ProxyServicePropertiesEditionPartForm.this,
									EsbViewsRepository.ProxyService.Wsdl.wsdlXML,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, wsdlXML.getText()));
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
									ProxyServicePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});

		EditingUtils.setID(wsdlXML, EsbViewsRepository.ProxyService.Wsdl.wsdlXML);
		EditingUtils.setEEFtype(wsdlXML, "eef::Text"); //$NON-NLS-1$
		Control wsdlXMLHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Wsdl.wsdlXML, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createWsdlXMLText
		wsdlXMLElements = new Control[] { wsdlXMLLabel, wsdlXML, wsdlXMLHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createWsdlURLText(FormToolkit widgetFactory, Composite parent) {
		Control wsdlURLLabel = createDescription(parent, EsbViewsRepository.ProxyService.Wsdl.wsdlURL, EsbMessages.ProxyServicePropertiesEditionPart_WsdlURLLabel);
		wsdlURL = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		wsdlURL.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData wsdlURLData = new GridData(GridData.FILL_HORIZONTAL);
		wsdlURL.setLayoutData(wsdlURLData);
		wsdlURL.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ProxyServicePropertiesEditionPartForm.this,
							EsbViewsRepository.ProxyService.Wsdl.wsdlURL,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlURL.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ProxyServicePropertiesEditionPartForm.this,
									EsbViewsRepository.ProxyService.Wsdl.wsdlURL,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, wsdlURL.getText()));
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
									ProxyServicePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		wsdlURL.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Wsdl.wsdlURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlURL.getText()));
				}
			}
		});
		EditingUtils.setID(wsdlURL, EsbViewsRepository.ProxyService.Wsdl.wsdlURL);
		EditingUtils.setEEFtype(wsdlURL, "eef::Text"); //$NON-NLS-1$
		Control wsdlURLHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Wsdl.wsdlURL, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createWsdlURLText
		wsdlURLElements = new Control[] {wsdlURLLabel, wsdlURL, wsdlURLHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createWsdlResourcesTableComposition(FormToolkit widgetFactory, Composite parent) {
	    Control[] previousControls = wsdlGroup.getChildren();
		this.wsdlResources = new ReferencesTable(getDescription(EsbViewsRepository.ProxyService.Wsdl.wsdlResources, EsbMessages.ProxyServicePropertiesEditionPart_WsdlResourcesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Wsdl.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				wsdlResources.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Wsdl.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				wsdlResources.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Wsdl.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				wsdlResources.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Wsdl.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				wsdlResources.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.wsdlResourcesFilters) {
			this.wsdlResources.addFilter(filter);
		}
		this.wsdlResources.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Wsdl.wsdlResources, EsbViewsRepository.FORM_KIND));
		this.wsdlResources.createControls(parent, widgetFactory);
		this.wsdlResources.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Wsdl.wsdlResources, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData wsdlResourcesData = new GridData(GridData.FILL_HORIZONTAL);
		wsdlResourcesData.horizontalSpan = 3;
		this.wsdlResources.setLayoutData(wsdlResourcesData);
		this.wsdlResources.setLowerBound(0);
		this.wsdlResources.setUpperBound(-1);
		wsdlResources.setID(EsbViewsRepository.ProxyService.Wsdl.wsdlResources);
		wsdlResources.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createWsdlResourcesTableComposition
		Control[] newControls = wsdlGroup.getChildren();
		wsdlResourcesElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPreservePolicyCheckbox(FormToolkit widgetFactory, Composite parent) {
		preservePolicy = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ProxyService.Wsdl.preservePolicy, EsbMessages.ProxyServicePropertiesEditionPart_PreservePolicyLabel), SWT.CHECK);
		preservePolicy.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Wsdl.preservePolicy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(preservePolicy.getSelection())));
			}

		});
		GridData preservePolicyData = new GridData(GridData.FILL_HORIZONTAL);
		preservePolicyData.horizontalSpan = 2;
		preservePolicy.setLayoutData(preservePolicyData);
		EditingUtils.setID(preservePolicy, EsbViewsRepository.ProxyService.Wsdl.preservePolicy);
		EditingUtils.setEEFtype(preservePolicy, "eef::Checkbox"); //$NON-NLS-1$
		Control preservePolicyHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Wsdl.preservePolicy, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPreservePolicyCheckbox
		preservePolicyElements = new Control[] {preservePolicy, preservePolicyHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.ProxyServicePropertiesEditionPart_PropertiesGroupLabel);
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

	/**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.description, EsbMessages.ProxyServicePropertiesEditionPart_DescriptionLabel);
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
							ProxyServicePropertiesEditionPartForm.this,
							EsbViewsRepository.ProxyService.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ProxyServicePropertiesEditionPartForm.this,
									EsbViewsRepository.ProxyService.Properties.description,
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
									ProxyServicePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.ProxyService.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.ProxyService.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ProxyService.Properties.commentsList, EsbMessages.ProxyServicePropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "ProxyService", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.ProxyService.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createInSequenceInputConnectorsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.inSequenceInputConnectors = new ReferencesTable(getDescription(EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, EsbMessages.ProxyServicePropertiesEditionPart_InSequenceInputConnectorsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				inSequenceInputConnectors.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				inSequenceInputConnectors.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				inSequenceInputConnectors.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				inSequenceInputConnectors.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.inSequenceInputConnectorsFilters) {
			this.inSequenceInputConnectors.addFilter(filter);
		}
		this.inSequenceInputConnectors.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, EsbViewsRepository.FORM_KIND));
		this.inSequenceInputConnectors.createControls(parent, widgetFactory);
		this.inSequenceInputConnectors.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData inSequenceInputConnectorsData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceInputConnectorsData.horizontalSpan = 3;
		this.inSequenceInputConnectors.setLayoutData(inSequenceInputConnectorsData);
		this.inSequenceInputConnectors.setLowerBound(0);
		this.inSequenceInputConnectors.setUpperBound(-1);
		inSequenceInputConnectors.setID(EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors);
		inSequenceInputConnectors.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createInSequenceInputConnectorsTableComposition

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createMainSequenceCheckbox(FormToolkit widgetFactory, Composite parent) {
		mainSequence = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ProxyService.Properties.mainSequence, EsbMessages.ProxyServicePropertiesEditionPart_MainSequenceLabel), SWT.CHECK);
		mainSequence.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this, EsbViewsRepository.ProxyService.Properties.mainSequence, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(mainSequence.getSelection())));
			}

		});
		GridData mainSequenceData = new GridData(GridData.FILL_HORIZONTAL);
		mainSequenceData.horizontalSpan = 2;
		mainSequence.setLayoutData(mainSequenceData);
		EditingUtils.setID(mainSequence, EsbViewsRepository.ProxyService.Properties.mainSequence);
		EditingUtils.setEEFtype(mainSequence, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.mainSequence, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMainSequenceCheckbox

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Basic.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getPinnedServers()
	 * 
	 */
	public String getPinnedServers() {
		return pinnedServers.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setPinnedServers(String newValue)
	 * 
	 */
	public void setPinnedServers(String newValue) {
		if (newValue != null) {
			pinnedServers.setText(newValue);
		} else {
			pinnedServers.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Basic.pinnedServers);
		if (eefElementEditorReadOnlyState && pinnedServers.isEnabled()) {
			pinnedServers.setEnabled(false);
			pinnedServers.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !pinnedServers.isEnabled()) {
			pinnedServers.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getServiceGroup()
	 * 
	 */
	public String getServiceGroup() {
		return serviceGroup.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setServiceGroup(String newValue)
	 * 
	 */
	public void setServiceGroup(String newValue) {
		if (newValue != null) {
			serviceGroup.setText(newValue);
		} else {
			serviceGroup.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Basic.serviceGroup);
		if (eefElementEditorReadOnlyState && serviceGroup.isEnabled()) {
			serviceGroup.setEnabled(false);
			serviceGroup.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !serviceGroup.isEnabled()) {
			serviceGroup.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getTraceEnabled()
	 * 
	 */
	public Boolean getTraceEnabled() {
		return Boolean.valueOf(traceEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setTraceEnabled(Boolean newValue)
	 * 
	 */
	public void setTraceEnabled(Boolean newValue) {
		if (newValue != null) {
			traceEnabled.setSelection(newValue.booleanValue());
		} else {
			traceEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Basic.traceEnabled);
		if (eefElementEditorReadOnlyState && traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(false);
			traceEnabled.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getStatisticsEnabled()
	 * 
	 */
	public Boolean getStatisticsEnabled() {
		return Boolean.valueOf(statisticsEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setStatisticsEnabled(Boolean newValue)
	 * 
	 */
	public void setStatisticsEnabled(Boolean newValue) {
		if (newValue != null) {
			statisticsEnabled.setSelection(newValue.booleanValue());
		} else {
			statisticsEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Basic.statisticsEnabled);
		if (eefElementEditorReadOnlyState && statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(false);
			statisticsEnabled.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getStartOnLoad()
	 * 
	 */
	public Boolean getStartOnLoad() {
		return Boolean.valueOf(startOnLoad.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setStartOnLoad(Boolean newValue)
	 * 
	 */
	public void setStartOnLoad(Boolean newValue) {
		if (newValue != null) {
			startOnLoad.setSelection(newValue.booleanValue());
		} else {
			startOnLoad.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Basic.startOnLoad);
		if (eefElementEditorReadOnlyState && startOnLoad.isEnabled()) {
			startOnLoad.setEnabled(false);
			startOnLoad.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !startOnLoad.isEnabled()) {
			startOnLoad.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getTransports()
	 * 
	 */
	public String getTransports() {
		return transports.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setTransports(String newValue)
	 * 
	 */
	public void setTransports(String newValue) {
		if (newValue != null) {
			transports.setText(newValue);
		} else {
			transports.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Basic.transports);
		if (eefElementEditorReadOnlyState && transports.isEnabled()) {
			transports.setEnabled(false);
			transports.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !transports.isEnabled()) {
			transports.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getEndpointType()
	 * 
	 */
	public Enumerator getEndpointType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) endpointType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initEndpointType(Object input, Enumerator current)
	 */
	public void initEndpointType(Object input, Enumerator current) {
		endpointType.setInput(input);
		endpointType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Endpoint.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setEndpointType(Enumerator newValue)
	 * 
	 */
	public void setEndpointType(Enumerator newValue) {
		endpointType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Endpoint.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getEndpointName()
	 * 
	 */
	public String getEndpointName() {
		return endpointName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setEndpointName(String newValue)
	 * 
	 */
	public void setEndpointName(String newValue) {
		if (newValue != null) {
			endpointName.setText(newValue);
		} else {
			endpointName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Endpoint.endpointName);
		if (eefElementEditorReadOnlyState && endpointName.isEnabled()) {
			endpointName.setEnabled(false);
			endpointName.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointName.isEnabled()) {
			endpointName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getFaultSequenceType()
	 * 
	 */
	public Enumerator getFaultSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initFaultSequenceType(Object input, Enumerator current)
	 */
	public void initFaultSequenceType(Object input, Enumerator current) {
		faultSequenceType.setInput(input);
		faultSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType);
		if (eefElementEditorReadOnlyState && faultSequenceType.isEnabled()) {
			faultSequenceType.setEnabled(false);
			faultSequenceType.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultSequenceType.isEnabled()) {
			faultSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setFaultSequenceType(Enumerator newValue)
	 * 
	 */
	public void setFaultSequenceType(Enumerator newValue) {
		faultSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType);
		if (eefElementEditorReadOnlyState && faultSequenceType.isEnabled()) {
			faultSequenceType.setEnabled(false);
			faultSequenceType.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultSequenceType.isEnabled()) {
			faultSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getFaultSequenceName()
	 * 
	 */
	public String getFaultSequenceName() {
		return faultSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setFaultSequenceName(String newValue)
	 * 
	 */
	public void setFaultSequenceName(String newValue) {
		if (newValue != null) {
			faultSequenceName.setText(newValue);
		} else {
			faultSequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName);
		if (eefElementEditorReadOnlyState && faultSequenceName.isEnabled()) {
			faultSequenceName.setEnabled(false);
			faultSequenceName.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultSequenceName.isEnabled()) {
			faultSequenceName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getInSequenceType()
	 * 
	 */
	public Enumerator getInSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initInSequenceType(Object input, Enumerator current)
	 */
	public void initInSequenceType(Object input, Enumerator current) {
		inSequenceType.setInput(input);
		inSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.InSequence.inSequenceType);
		if (eefElementEditorReadOnlyState && inSequenceType.isEnabled()) {
			inSequenceType.setEnabled(false);
			inSequenceType.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inSequenceType.isEnabled()) {
			inSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setInSequenceType(Enumerator newValue)
	 * 
	 */
	public void setInSequenceType(Enumerator newValue) {
		inSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.InSequence.inSequenceType);
		if (eefElementEditorReadOnlyState && inSequenceType.isEnabled()) {
			inSequenceType.setEnabled(false);
			inSequenceType.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inSequenceType.isEnabled()) {
			inSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getInSequenceName()
	 * 
	 */
	public String getInSequenceName() {
		return inSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setInSequenceName(String newValue)
	 * 
	 */
	public void setInSequenceName(String newValue) {
		if (newValue != null) {
			inSequenceName.setText(newValue);
		} else {
			inSequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.InSequence.inSequenceName);
		if (eefElementEditorReadOnlyState && inSequenceName.isEnabled()) {
			inSequenceName.setEnabled(false);
			inSequenceName.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inSequenceName.isEnabled()) {
			inSequenceName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getOutSequenceType()
	 * 
	 */
	public Enumerator getOutSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initOutSequenceType(Object input, Enumerator current)
	 */
	public void initOutSequenceType(Object input, Enumerator current) {
		outSequenceType.setInput(input);
		outSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.OutSequence.outSequenceType);
		if (eefElementEditorReadOnlyState && outSequenceType.isEnabled()) {
			outSequenceType.setEnabled(false);
			outSequenceType.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outSequenceType.isEnabled()) {
			outSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setOutSequenceType(Enumerator newValue)
	 * 
	 */
	public void setOutSequenceType(Enumerator newValue) {
		outSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.OutSequence.outSequenceType);
		if (eefElementEditorReadOnlyState && outSequenceType.isEnabled()) {
			outSequenceType.setEnabled(false);
			outSequenceType.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outSequenceType.isEnabled()) {
			outSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getOutSequenceName()
	 * 
	 */
	public String getOutSequenceName() {
		return outSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setOutSequenceName(String newValue)
	 * 
	 */
	public void setOutSequenceName(String newValue) {
		if (newValue != null) {
			outSequenceName.setText(newValue);
		} else {
			outSequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.OutSequence.outSequenceName);
		if (eefElementEditorReadOnlyState && outSequenceName.isEnabled()) {
			outSequenceName.setEnabled(false);
			outSequenceName.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outSequenceName.isEnabled()) {
			outSequenceName.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initServiceParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initServiceParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		serviceParameters.setContentProvider(contentProvider);
		serviceParameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Parameters.serviceParameters);
		if (eefElementEditorReadOnlyState && serviceParameters.isEnabled()) {
			serviceParameters.setEnabled(false);
			serviceParameters.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !serviceParameters.isEnabled()) {
			serviceParameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#updateServiceParameters()
	 * 
	 */
	public void updateServiceParameters() {
	serviceParameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addFilterServiceParameters(ViewerFilter filter)
	 * 
	 */
	public void addFilterToServiceParameters(ViewerFilter filter) {
		serviceParametersFilters.add(filter);
		if (this.serviceParameters != null) {
			this.serviceParameters.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addBusinessFilterServiceParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToServiceParameters(ViewerFilter filter) {
		serviceParametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#isContainedInServiceParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInServiceParametersTable(EObject element) {
		return ((ReferencesTableSettings)serviceParameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getReliableMessagingEnabled()
	 * 
	 */
	public Boolean getReliableMessagingEnabled() {
		return Boolean.valueOf(reliableMessagingEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setReliableMessagingEnabled(Boolean newValue)
	 * 
	 */
	public void setReliableMessagingEnabled(Boolean newValue) {
		if (newValue != null) {
			reliableMessagingEnabled.setSelection(newValue.booleanValue());
		} else {
			reliableMessagingEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled);
		if (eefElementEditorReadOnlyState && reliableMessagingEnabled.isEnabled()) {
			reliableMessagingEnabled.setEnabled(false);
			reliableMessagingEnabled.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reliableMessagingEnabled.isEnabled()) {
			reliableMessagingEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getSecurityEnabled()
	 * 
	 */
	public Boolean getSecurityEnabled() {
		return Boolean.valueOf(securityEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setSecurityEnabled(Boolean newValue)
	 * 
	 */
	public void setSecurityEnabled(Boolean newValue) {
		if (newValue != null) {
			securityEnabled.setSelection(newValue.booleanValue());
		} else {
			securityEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Security.securityEnabled);
		if (eefElementEditorReadOnlyState && securityEnabled.isEnabled()) {
			securityEnabled.setEnabled(false);
			securityEnabled.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !securityEnabled.isEnabled()) {
			securityEnabled.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initServicePolicies(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initServicePolicies(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		servicePolicies.setContentProvider(contentProvider);
		servicePolicies.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Security.servicePolicies);
		if (eefElementEditorReadOnlyState && servicePolicies.isEnabled()) {
			servicePolicies.setEnabled(false);
			servicePolicies.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !servicePolicies.isEnabled()) {
			servicePolicies.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#updateServicePolicies()
	 * 
	 */
	public void updateServicePolicies() {
	servicePolicies.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addFilterServicePolicies(ViewerFilter filter)
	 * 
	 */
	public void addFilterToServicePolicies(ViewerFilter filter) {
		servicePoliciesFilters.add(filter);
		if (this.servicePolicies != null) {
			this.servicePolicies.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addBusinessFilterServicePolicies(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToServicePolicies(ViewerFilter filter) {
		servicePoliciesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#isContainedInServicePoliciesTable(EObject element)
	 * 
	 */
	public boolean isContainedInServicePoliciesTable(EObject element) {
		return ((ReferencesTableSettings)servicePolicies.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getWsdlType()
	 * 
	 */
	public Enumerator getWsdlType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) wsdlType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initWsdlType(Object input, Enumerator current)
	 */
	public void initWsdlType(Object input, Enumerator current) {
		wsdlType.setInput(input);
		wsdlType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Wsdl.wsdlType);
		if (eefElementEditorReadOnlyState && wsdlType.isEnabled()) {
			wsdlType.setEnabled(false);
			wsdlType.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !wsdlType.isEnabled()) {
			wsdlType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setWsdlType(Enumerator newValue)
	 * 
	 */
	public void setWsdlType(Enumerator newValue) {
		wsdlType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Wsdl.wsdlType);
		if (eefElementEditorReadOnlyState && wsdlType.isEnabled()) {
			wsdlType.setEnabled(false);
			wsdlType.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !wsdlType.isEnabled()) {
			wsdlType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getWsdlXML()
	 * 
	 */
	public String getWsdlXML() {
		return wsdlXML.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setWsdlXML(String newValue)
	 * 
	 */
	public void setWsdlXML(String newValue) {
		if (newValue != null) {
			wsdlXML.setText(newValue);
		} else {
			wsdlXML.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Wsdl.wsdlXML);
		if (eefElementEditorReadOnlyState && wsdlXML.isEnabled()) {
			wsdlXML.setEnabled(false);
			wsdlXML.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !wsdlXML.isEnabled()) {
			wsdlXML.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getWsdlURL()
	 * 
	 */
	public String getWsdlURL() {
		return wsdlURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setWsdlURL(String newValue)
	 * 
	 */
	public void setWsdlURL(String newValue) {
		if (newValue != null) {
			wsdlURL.setText(newValue);
		} else {
			wsdlURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Wsdl.wsdlURL);
		if (eefElementEditorReadOnlyState && wsdlURL.isEnabled()) {
			wsdlURL.setEnabled(false);
			wsdlURL.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !wsdlURL.isEnabled()) {
			wsdlURL.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initWsdlResources(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initWsdlResources(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		wsdlResources.setContentProvider(contentProvider);
		wsdlResources.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Wsdl.wsdlResources);
		if (eefElementEditorReadOnlyState && wsdlResources.isEnabled()) {
			wsdlResources.setEnabled(false);
			wsdlResources.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !wsdlResources.isEnabled()) {
			wsdlResources.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#updateWsdlResources()
	 * 
	 */
	public void updateWsdlResources() {
	wsdlResources.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addFilterWsdlResources(ViewerFilter filter)
	 * 
	 */
	public void addFilterToWsdlResources(ViewerFilter filter) {
		wsdlResourcesFilters.add(filter);
		if (this.wsdlResources != null) {
			this.wsdlResources.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addBusinessFilterWsdlResources(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToWsdlResources(ViewerFilter filter) {
		wsdlResourcesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#isContainedInWsdlResourcesTable(EObject element)
	 * 
	 */
	public boolean isContainedInWsdlResourcesTable(EObject element) {
		return ((ReferencesTableSettings)wsdlResources.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getPreservePolicy()
	 * 
	 */
	public Boolean getPreservePolicy() {
		return Boolean.valueOf(preservePolicy.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setPreservePolicy(Boolean newValue)
	 * 
	 */
	public void setPreservePolicy(Boolean newValue) {
		if (newValue != null) {
			preservePolicy.setSelection(newValue.booleanValue());
		} else {
			preservePolicy.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Wsdl.preservePolicy);
		if (eefElementEditorReadOnlyState && preservePolicy.isEnabled()) {
			preservePolicy.setEnabled(false);
			preservePolicy.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !preservePolicy.isEnabled()) {
			preservePolicy.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.ProxyService_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initInSequenceInputConnectors(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initInSequenceInputConnectors(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		inSequenceInputConnectors.setContentProvider(contentProvider);
		inSequenceInputConnectors.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors);
		if (eefElementEditorReadOnlyState && inSequenceInputConnectors.isEnabled()) {
			inSequenceInputConnectors.setEnabled(false);
			inSequenceInputConnectors.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inSequenceInputConnectors.isEnabled()) {
			inSequenceInputConnectors.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#updateInSequenceInputConnectors()
	 * 
	 */
	public void updateInSequenceInputConnectors() {
	inSequenceInputConnectors.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addFilterInSequenceInputConnectors(ViewerFilter filter)
	 * 
	 */
	public void addFilterToInSequenceInputConnectors(ViewerFilter filter) {
		inSequenceInputConnectorsFilters.add(filter);
		if (this.inSequenceInputConnectors != null) {
			this.inSequenceInputConnectors.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addBusinessFilterInSequenceInputConnectors(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToInSequenceInputConnectors(ViewerFilter filter) {
		inSequenceInputConnectorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#isContainedInInSequenceInputConnectorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInInSequenceInputConnectorsTable(EObject element) {
		return ((ReferencesTableSettings)inSequenceInputConnectors.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getMainSequence()
	 * 
	 */
	public Boolean getMainSequence() {
		return Boolean.valueOf(mainSequence.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setMainSequence(Boolean newValue)
	 * 
	 */
	public void setMainSequence(Boolean newValue) {
		if (newValue != null) {
			mainSequence.setSelection(newValue.booleanValue());
		} else {
			mainSequence.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.mainSequence);
		if (eefElementEditorReadOnlyState && mainSequence.isEnabled()) {
			mainSequence.setEnabled(false);
			mainSequence.setToolTipText(EsbMessages.ProxyService_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !mainSequence.isEnabled()) {
			mainSequence.setEnabled(true);
		}	
		
	}






	// Start of user code for onError specific getters and setters implementation
	@Override
    public void setOnError(RegistryKeyProperty registryKeyProperty) {
	    if (onError != null) {
            onError = registryKeyProperty;
            onErrorText.setText(registryKeyProperty.getKeyValue());
        }
    }
	
	 @Override
	    public RegistryKeyProperty getOnError() {
	        return onError;
	    }
	// End of user code

	// Start of user code for endpointKey specific getters and setters implementation

	    @Override
	    public void setEndpointKey(RegistryKeyProperty registryKeyProperty) {
	        if (endpointKey != null) {
	            endpointKey = registryKeyProperty;
	            endpointKeyText.setText(registryKeyProperty.getKeyValue());
	        }
	    }

	    @Override
	    public RegistryKeyProperty getEndpointKey() {
	        return endpointKey;
	    }
	
	// End of user code

	// Start of user code for faultSequenceKey specific getters and setters implementation
	    @Override
	    public void setFaultSequenceKey(RegistryKeyProperty registryKeyProperty) {
	        if (faultSequenceKey != null) {
	            faultSequenceKey = registryKeyProperty;
	            faultSequenceKeyText.setText(registryKeyProperty.getKeyValue());
	        }
	    }

	    @Override
	    public RegistryKeyProperty getFaultSequenceKey() {
	        return faultSequenceKey;
	    }
	// End of user code

	// Start of user code for faultSequenceOnError specific getters and setters implementation
	    @Override
	    public void setFaultSequenceOnError(RegistryKeyProperty registryKeyProperty) {
	        if (faultSequenceOnError != null) {
	            faultSequenceOnError = registryKeyProperty;
	            faultSequenceOnErrorText.setText(registryKeyProperty.getKeyValue());
	        }
	    }

	    @Override
	    public RegistryKeyProperty getFaultSequenceOnError() {
	        return faultSequenceOnError;
	    }
	// End of user code

	// Start of user code for inSequenceKey specific getters and setters implementation
	    @Override
	    public void setInSequenceKey(RegistryKeyProperty registryKeyProperty) {
	        if (inSequenceKey != null) {
	            inSequenceKey = registryKeyProperty;
	            inSequenceKeyText.setText(registryKeyProperty.getKeyValue());
	        }
	    }

	    @Override
	    public RegistryKeyProperty getInSequenceKey() {
	        return inSequenceKey;
	    }
	
	// End of user code

	// Start of user code for inSequenceOnError specific getters and setters implementation
	    
	    @Override
	    public void setInSequenceOnError(RegistryKeyProperty registryKeyProperty) {
	        if (inSequenceOnError != null) {
	            inSequenceOnError = registryKeyProperty;
	            inSequenceOnErrorText.setText(registryKeyProperty.getKeyValue());
	        }
	    }

	    @Override
	    public RegistryKeyProperty getInSequenceOnError() {
	        return inSequenceOnError;
	    }
	
	// End of user code

	// Start of user code for outSequenceKey specific getters and setters implementation
	    @Override
	    public void setOutSequenceKey(RegistryKeyProperty registryKeyProperty) {
	        if (outSequenceKey != null) {
	            outSequenceKey = registryKeyProperty;
	            outSequenceKeyText.setText(registryKeyProperty.getKeyValue());
	        }
	    }

	    @Override
	    public RegistryKeyProperty getOutSequenceKey() {
	        return outSequenceKey;
	    }
	// End of user code

	// Start of user code for outSequenceOnError specific getters and setters implementation
	
	    @Override
	    public void setOutSequenceOnError(RegistryKeyProperty registryKeyProperty) {
	        if (outSequenceOnError != null) {
	            outSequenceOnError = registryKeyProperty;
	            outSequenceOnErrorText.setText(registryKeyProperty.getKeyValue());
	        }
	    }

	    @Override
	    public RegistryKeyProperty getOutSequenceOnError() {
	        return outSequenceOnError;
	    }
	// End of user code

	// Start of user code for wsdlKey specific getters and setters implementation
	    @Override
	    public void setWsdlKey(RegistryKeyProperty registryKeyProperty) {
	        if (wsdlKey != null) {
	            wsdlKey = registryKeyProperty;
	            wsdlEndpointText.setText(registryKeyProperty.getKeyValue());
	        }
	    }

	    @Override
	    public RegistryKeyProperty getWsdlKey() {
	        return wsdlKey;
	    }
	// End of user code

	// Start of user code for wsdlEndpoint specific getters and setters implementation

	    @Override
	    public void setWsdlEndpoint(RegistryKeyProperty registryKeyProperty) {
	        if (wsdlEndpoint != null) {
	            wsdlEndpoint = registryKeyProperty;
	            wsdlEndpointText.setText(registryKeyProperty.getKeyValue());
	        }
	    }

	    @Override
	    public RegistryKeyProperty getWsdlEndpoint() {
	        return wsdlEndpoint;
	    }
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ProxyService_Part_Title;
	}

	// Start of user code additional methods
	
	 @Override
	    public void refresh() {
	        super.refresh();
	        validate();
	        validateEndpoint();
	        validateFaultSequence();
	        validateInSequence();
	        validateOutSequence();
	        validateWSDL();
	        name.setFocus();
	        propertiesGroup.setFocus();
	    }

	    public void validate() {
	        propertiesSection.setVisible(false);
	    }
	    
	    private void validateEndpoint() {
	        validate();
	        
	        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
	        eu.clearElements(new Composite[] { endpointGroup });

	        eu.showEntry(endpointTypeElements, false);

	        if (getEndpointType() != null && getEndpointType().getName().equals(SequenceType.NAMED_REFERENCE.getName())) {
	            eu.showEntry(endpointNameElements, false);

	        } else if (getEndpointType() != null && getEndpointType().getName().equals(SequenceType.REGISTRY_REFERENCE.getName())){
	            eu.showEntry(endpointKeyElements, false);

	        }

	        view.layout(true, true);
	    }

	    private void validateFaultSequence() {
	        validate();
	        
            EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
            eu.clearElements(new Composite[] { faultSequenceGroup });

            eu.showEntry(faultSequenceTypeElements, false);

            if (getFaultSequenceType() != null && getFaultSequenceType().getName().equals(SequenceType.NAMED_REFERENCE.getName())) {
                eu.showEntry(faultSequenceNameElements, false);

            } else if (getFaultSequenceType() != null && getFaultSequenceType().getName().equals(SequenceType.REGISTRY_REFERENCE.getName())){
                eu.showEntry(faultSequenceKeyElements, false);

            }

            view.layout(true, true);
        }
	    
	    private void validateInSequence() {
	        validate();
	        
            EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
            eu.clearElements(new Composite[] { inSequenceGroup });

            eu.showEntry(insequenceTypeElements, false);

            if (getInSequenceType() != null && getInSequenceType().getName().equals(SequenceType.NAMED_REFERENCE.getName())) {
                eu.showEntry(inSequenceNameElements, false);

            } else if (getInSequenceType() != null && getInSequenceType().getName().equals(SequenceType.REGISTRY_REFERENCE.getName())){
                eu.showEntry(inSequenceKeyElements, false);

            }

            view.layout(true, true);
        }

	    private void validateOutSequence() {
	        validate();
	        
            EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
            eu.clearElements(new Composite[] { outSequenceGroup });

            eu.showEntry(outSequenceTypeElements, false);

            if (getOutSequenceType() != null && getOutSequenceType() .getName().equals(SequenceType.NAMED_REFERENCE.getName())) {
                eu.showEntry(outSequenceNameElements, false);

            } else if (getOutSequenceType()  != null && getOutSequenceType() .getName().equals(SequenceType.REGISTRY_REFERENCE.getName())){
                eu.showEntry(outSequenceKeyElements, false);

            }

            view.layout(true, true);
        }
	    
	    private void validateWSDL() {
	        validate();
	        
            EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
            eu.clearElements(new Composite[] { wsdlGroup });

            eu.showEntry(wsdlTypeElements, false);

            if (getWsdlType() != null && getWsdlType().getName().equals(ProxyWsdlType.INLINE.getName())) {
                eu.showEntry(wsdlXMLElements, false);
                eu.showEntry(preservePolicyElements, false);
                eu.showEntry(wsdlResourcesElements, false);

            } else if (getWsdlType() != null && getWsdlType().getName().equals(ProxyWsdlType.SOURCE_URL.getName())){
                eu.showEntry(wsdlURLElements, false);
                eu.showEntry(preservePolicyElements, false);
                eu.showEntry(wsdlResourcesElements, false);
            } else if (getWsdlType() != null && getWsdlType().getName().equals(ProxyWsdlType.REGISTRY_KEY.getName())){
                eu.showEntry(wsdlKeyElements, false);
                eu.showEntry(preservePolicyElements, false);
                eu.showEntry(wsdlResourcesElements, false);
            } else if (getWsdlType() != null && getWsdlType().getName().equals(ProxyWsdlType.ENDPOINT.getName())){
                eu.showEntry(wsdlEndpointElements, false);
                eu.showEntry(preservePolicyElements, false);
            }

            view.layout(true, true);
        }
	    
	protected Composite createOnError(FormToolkit widgetFactory, final Composite parent) {
        Control onErrorLabel = createDescription(parent, EsbViewsRepository.ProxyService.Basic.onError,
                EsbMessages.ProxyServicePropertiesEditionPart_OnErrorLabel);
        widgetFactory.paintBordersFor(parent);
        if (onError == null) {
            onError = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initOnError = onError.getKeyValue().isEmpty() ? "" : onError.getKeyValue();
        onErrorText = widgetFactory.createText(parent, initOnError, SWT.READ_ONLY);
        onErrorText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        onErrorText.setLayoutData(valueData);
        onErrorText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, onError, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                onErrorText.setText(onError.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
                                EsbViewsRepository.ProxyService.Basic.onError, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getOnError()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        
        onErrorText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                 if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                     EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                             SWT.NULL, onError, new ArrayList<NamedEntityDescriptor>());
                     dialog.open();
                     onErrorText.setText(onError.getKeyValue());
                     propertiesEditionComponent
                             .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
                                     EsbViewsRepository.ProxyService.Basic.onError, PropertiesEditionEvent.COMMIT,
                                     PropertiesEditionEvent.SET, null, getOnError()));
                 }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(onErrorText, EsbViewsRepository.ProxyService.Basic.onError);
        EditingUtils.setEEFtype(onErrorText, "eef::Text");
        Control onErrorHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.ProxyService.Basic.onError, EsbViewsRepository.FORM_KIND),
                        null);
        onErrorElements = new Control[] { onErrorLabel, onErrorText, onErrorHelp };
        return parent;
    }
	
	 protected Composite createFaultSequenceKey(FormToolkit widgetFactory, final Composite parent) {
	        Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceKey,
	                EsbMessages.ProxyServicePropertiesEditionPart_FaultSequenceKeyLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (faultSequenceKey == null) {
	            faultSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initSequenceKey = faultSequenceKey.getKeyValue().isEmpty() ? "" : faultSequenceKey.getKeyValue();
	        faultSequenceKeyText = widgetFactory.createText(parent, initSequenceKey, SWT.READ_ONLY);
	        faultSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        faultSequenceKeyText.setLayoutData(valueData);
	        faultSequenceKeyText.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseUp(MouseEvent e) {
	                // TODO Auto-generated method stub
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, faultSequenceKey, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                faultSequenceKeyText.setText(faultSequenceKey.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
	                                EsbViewsRepository.ProxyService.FaultSequence.faultSequenceKey, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getFaultSequenceKey()));
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {
	                // TODO Auto-generated method stub

	            }
	        });
	        
	        faultSequenceKeyText.addKeyListener(new KeyListener() {
                
                @Override
                public void keyReleased(KeyEvent e) {
                    if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                        EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                                SWT.NULL, faultSequenceKey, new ArrayList<NamedEntityDescriptor>());
                        dialog.open();
                        faultSequenceKeyText.setText(faultSequenceKey.getKeyValue());
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
                                        EsbViewsRepository.ProxyService.FaultSequence.faultSequenceKey, PropertiesEditionEvent.COMMIT,
                                        PropertiesEditionEvent.SET, null, getFaultSequenceKey()));
                    }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {}
                
            });
	        
	        EditingUtils.setID(faultSequenceKeyText, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceKey);
	        EditingUtils.setEEFtype(faultSequenceKeyText, "eef::Text");
	        Control sequenceKeyHelp = FormUtils
	                .createHelpButton(widgetFactory, parent,
	                        propertiesEditionComponent.getHelpContent(
	                                EsbViewsRepository.ProxyService.FaultSequence.faultSequenceKey, EsbViewsRepository.FORM_KIND),
	                        null);
	        faultSequenceKeyElements = new Control[] { sequenceKeyLabel, faultSequenceKeyText, sequenceKeyHelp };
	        return parent;
	    }
	 
	 protected Composite createFaultSequenceOnError(FormToolkit widgetFactory, final Composite parent) {
	        Control onErrorLabel = createDescription(parent, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceOnError,
	                EsbMessages.ProxyServicePropertiesEditionPart_FaultSequenceOnErrorLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (faultSequenceOnError == null) {
	            faultSequenceOnError = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initOnError = faultSequenceOnError.getKeyValue().isEmpty() ? "" : faultSequenceOnError.getKeyValue();
	        faultSequenceOnErrorText = widgetFactory.createText(parent, initOnError);
	        faultSequenceOnErrorText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        faultSequenceOnErrorText.setLayoutData(valueData);
	        faultSequenceOnErrorText.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseUp(MouseEvent e) {
	                // TODO Auto-generated method stub
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, faultSequenceOnError, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                faultSequenceOnErrorText.setText(faultSequenceOnError.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
	                                EsbViewsRepository.ProxyService.FaultSequence.faultSequenceOnError, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getFaultSequenceOnError()));
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {
	                // TODO Auto-generated method stub

	            }
	        });
	        
	        faultSequenceOnErrorText.addKeyListener(new KeyListener() {
                
                @Override
                public void keyReleased(KeyEvent e) {
                    if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                        EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                                SWT.NULL, faultSequenceOnError, new ArrayList<NamedEntityDescriptor>());
                        dialog.open();
                        faultSequenceOnErrorText.setText(faultSequenceOnError.getKeyValue());
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
                                        EsbViewsRepository.ProxyService.FaultSequence.faultSequenceOnError, PropertiesEditionEvent.COMMIT,
                                        PropertiesEditionEvent.SET, null, getFaultSequenceOnError()));
                    }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {}
                
            });
	        
	        EditingUtils.setID(faultSequenceOnErrorText, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceOnError);
	        EditingUtils.setEEFtype(faultSequenceOnErrorText, "eef::Text");
	        Control onErrorHelp = FormUtils
	                .createHelpButton(widgetFactory, parent,
	                        propertiesEditionComponent.getHelpContent(
	                                EsbViewsRepository.ProxyService.FaultSequence.faultSequenceOnError, EsbViewsRepository.FORM_KIND),
	                        null);
	        faultSequenceOnErrorElements = new Control[] {faultSequenceOnErrorText, faultSequenceOnErrorText, onErrorHelp};
	        return parent;
	    }
	 
	 protected Composite createEndpointKey(FormToolkit widgetFactory, final Composite parent) {
	        Control endpointKeyLabel = createDescription(parent, EsbViewsRepository.ProxyService.Endpoint.endpointKey,
	                EsbMessages.ProxyServicePropertiesEditionPart_EndpointKeyLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (endpointKey == null) {
	            endpointKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initEndpointKey = endpointKey.getKeyValue().isEmpty() ? "" : endpointKey.getKeyValue();
	        endpointKeyText = widgetFactory.createText(parent, initEndpointKey, SWT.READ_ONLY);
	        endpointKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        endpointKeyText.setLayoutData(valueData);
	        endpointKeyText.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseUp(MouseEvent e) {
	                // TODO Auto-generated method stub
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, endpointKey, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                endpointKeyText.setText(endpointKey.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
	                                EsbViewsRepository.ProxyService.Endpoint.endpointKey, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getEndpointKey()));
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {
	                // TODO Auto-generated method stub

	            }
	        });
	        
	        endpointKeyText.addKeyListener(new KeyListener() {
                
                @Override
                public void keyReleased(KeyEvent e) {
                      if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                          EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                                  SWT.NULL, endpointKey, new ArrayList<NamedEntityDescriptor>());
                          dialog.open();
                          endpointKeyText.setText(endpointKey.getKeyValue());
                          propertiesEditionComponent
                                  .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
                                          EsbViewsRepository.ProxyService.Endpoint.endpointKey, PropertiesEditionEvent.COMMIT,
                                          PropertiesEditionEvent.SET, null, getEndpointKey()));
                      }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {}
                
            });
	        
	        EditingUtils.setID(endpointKeyText, EsbViewsRepository.ProxyService.Endpoint.endpointKey);
	        EditingUtils.setEEFtype(endpointKeyText, "eef::Text");
	        Control endpointKeyHelp = FormUtils
	                .createHelpButton(widgetFactory, parent,
	                        propertiesEditionComponent.getHelpContent(
	                                EsbViewsRepository.ProxyService.Endpoint.endpointKey, EsbViewsRepository.FORM_KIND),
	                        null);
	        endpointKeyElements = new Control[] { endpointKeyLabel, endpointKeyText, endpointKeyHelp };
	        return parent;
	    }
	 
	 protected Composite createInSequenceKey(FormToolkit widgetFactory, final Composite parent) {
	        Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.ProxyService.InSequence.inSequenceKey,
	                EsbMessages.ProxyServicePropertiesEditionPart_InSequenceKeyLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (inSequenceKey == null) {
	            inSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initSequenceKey = inSequenceKey.getKeyValue().isEmpty() ? "" : inSequenceKey.getKeyValue();
	        inSequenceKeyText = widgetFactory.createText(parent, initSequenceKey, SWT.READ_ONLY);
	        inSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        inSequenceKeyText.setLayoutData(valueData);
	        inSequenceKeyText.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseUp(MouseEvent e) {
	                // TODO Auto-generated method stub
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, inSequenceKey, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                inSequenceKeyText.setText(inSequenceKey.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
	                                EsbViewsRepository.ProxyService.InSequence.inSequenceKey, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getInSequenceKey()));
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {
	                // TODO Auto-generated method stub

	            }
	        });
	        
	        inSequenceKeyText.addKeyListener(new KeyListener() {
                
                @Override
                public void keyReleased(KeyEvent e) {
                      if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                          EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                                  SWT.NULL, inSequenceKey, new ArrayList<NamedEntityDescriptor>());
                          dialog.open();
                          inSequenceKeyText.setText(inSequenceKey.getKeyValue());
                          propertiesEditionComponent
                                  .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
                                          EsbViewsRepository.ProxyService.InSequence.inSequenceKey, PropertiesEditionEvent.COMMIT,
                                          PropertiesEditionEvent.SET, null, getInSequenceKey()));
                      }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {}
                
            });
	        
	        EditingUtils.setID(inSequenceKeyText, EsbViewsRepository.ProxyService.InSequence.inSequenceKey);
	        EditingUtils.setEEFtype(inSequenceKeyText, "eef::Text");
	        Control sequenceKeyHelp = FormUtils
	                .createHelpButton(widgetFactory, parent,
	                        propertiesEditionComponent.getHelpContent(
	                                EsbViewsRepository.ProxyService.InSequence.inSequenceKey, EsbViewsRepository.FORM_KIND),
	                        null);
	        inSequenceKeyElements = new Control[] { sequenceKeyLabel, inSequenceKeyText, sequenceKeyHelp };
	        return parent;
	    }
	 
	 protected Composite createInSequenceOnError(FormToolkit widgetFactory, final Composite parent) {
	        Control onErrorLabel = createDescription(parent, EsbViewsRepository.ProxyService.InSequence.inSequenceOnError,
	                EsbMessages.ProxyServicePropertiesEditionPart_InSequenceOnErrorLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (inSequenceOnError == null) {
	            inSequenceOnError = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initSequenceOnError = inSequenceOnError.getKeyValue().isEmpty() ? "" : inSequenceOnError.getKeyValue();
	        inSequenceOnErrorText = widgetFactory.createText(parent, initSequenceOnError, SWT.READ_ONLY);
	        inSequenceOnErrorText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        inSequenceOnErrorText.setLayoutData(valueData);
	        inSequenceOnErrorText.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseUp(MouseEvent e) {
	                // TODO Auto-generated method stub
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, inSequenceOnError, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                inSequenceOnErrorText.setText(inSequenceOnError.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
	                                EsbViewsRepository.ProxyService.InSequence.inSequenceOnError, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getInSequenceOnError()));
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {
	                // TODO Auto-generated method stub

	            }
	        });
	        
	        inSequenceOnErrorText.addKeyListener(new KeyListener() {
                
                @Override
                public void keyReleased(KeyEvent e) {
                    if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                        EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                                SWT.NULL, inSequenceOnError, new ArrayList<NamedEntityDescriptor>());
                        dialog.open();
                        inSequenceOnErrorText.setText(inSequenceOnError.getKeyValue());
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
                                        EsbViewsRepository.ProxyService.InSequence.inSequenceOnError, PropertiesEditionEvent.COMMIT,
                                        PropertiesEditionEvent.SET, null, getInSequenceOnError()));
                    }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {}
                
            });
	        
	        EditingUtils.setID(inSequenceOnErrorText, EsbViewsRepository.ProxyService.InSequence.inSequenceOnError);
	        EditingUtils.setEEFtype(inSequenceOnErrorText, "eef::Text");
	        Control sinSequenceOnErrorHelp = FormUtils
	                .createHelpButton(widgetFactory, parent,
	                        propertiesEditionComponent.getHelpContent(
	                                EsbViewsRepository.ProxyService.InSequence.inSequenceOnError, EsbViewsRepository.FORM_KIND),
	                        null);
	        inSequenceOnErrorElements = new Control[] { onErrorLabel, inSequenceOnErrorText, sinSequenceOnErrorHelp };
	        return parent;
	    }

	 protected Composite createOutSequenceKey(FormToolkit widgetFactory, final Composite parent) {
	        Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.ProxyService.OutSequence.outSequenceKey,
	                EsbMessages.ProxyServicePropertiesEditionPart_OutSequenceKeyLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (outSequenceKey == null) {
	            outSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initSequenceKey = outSequenceKey.getKeyValue().isEmpty() ? "" : outSequenceKey.getKeyValue();
	        outSequenceKeyText = widgetFactory.createText(parent, initSequenceKey, SWT.READ_ONLY);
	        outSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        outSequenceKeyText.setLayoutData(valueData);
	        outSequenceKeyText.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseUp(MouseEvent e) {
	                // TODO Auto-generated method stub
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, outSequenceKey, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                outSequenceKeyText.setText(outSequenceKey.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
	                                EsbViewsRepository.ProxyService.OutSequence.outSequenceKey, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getOutSequenceKey()));
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {
	                // TODO Auto-generated method stub

	            }
	        });
	        
	        outSequenceKeyText.addKeyListener(new KeyListener() {
                
                @Override
                public void keyReleased(KeyEvent e) {
                    if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                        EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                                SWT.NULL, outSequenceKey, new ArrayList<NamedEntityDescriptor>());
                        dialog.open();
                        outSequenceKeyText.setText(outSequenceKey.getKeyValue());
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
                                        EsbViewsRepository.ProxyService.OutSequence.outSequenceKey, PropertiesEditionEvent.COMMIT,
                                        PropertiesEditionEvent.SET, null, getOutSequenceKey()));
                    }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {}
                
            });
	        
	        EditingUtils.setID(outSequenceKeyText, EsbViewsRepository.ProxyService.OutSequence.outSequenceKey);
	        EditingUtils.setEEFtype(outSequenceKeyText, "eef::Text");
	        Control sequenceKeyHelp = FormUtils
	                .createHelpButton(widgetFactory, parent,
	                        propertiesEditionComponent.getHelpContent(
	                                EsbViewsRepository.ProxyService.OutSequence.outSequenceKey, EsbViewsRepository.FORM_KIND),
	                        null);
	        outSequenceKeyElements = new Control[] { sequenceKeyLabel, outSequenceKeyText, sequenceKeyHelp };
	        return parent;
	    }
	 
	 protected Composite createOutSequenceOnError(FormToolkit widgetFactory, final Composite parent) {
	        Control onErrorLabel = createDescription(parent, EsbViewsRepository.ProxyService.OutSequence.outSequenceOnError,
	                EsbMessages.ProxyServicePropertiesEditionPart_OutSequenceOnErrorLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (outSequenceOnError == null) {
	            outSequenceOnError = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initSequenceKey = outSequenceOnError.getKeyValue().isEmpty() ? "" : outSequenceOnError.getKeyValue();
	        outSequenceOnErrorText = widgetFactory.createText(parent, initSequenceKey, SWT.READ_ONLY);
	        outSequenceOnErrorText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        outSequenceOnErrorText.setLayoutData(valueData);
	        outSequenceOnErrorText.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseUp(MouseEvent e) {
	                // TODO Auto-generated method stub
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, outSequenceOnError, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                outSequenceOnErrorText.setText(outSequenceOnError.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
	                                EsbViewsRepository.ProxyService.OutSequence.outSequenceOnError, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getOutSequenceOnError()));
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {
	                // TODO Auto-generated method stub

	            }
	        });
	        
	        outSequenceOnErrorText.addKeyListener(new KeyListener() {
                
                @Override
                public void keyReleased(KeyEvent e) {
                    if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                        EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                                SWT.NULL, outSequenceOnError, new ArrayList<NamedEntityDescriptor>());
                        dialog.open();
                        outSequenceOnErrorText.setText(outSequenceOnError.getKeyValue());
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
                                        EsbViewsRepository.ProxyService.OutSequence.outSequenceOnError, PropertiesEditionEvent.COMMIT,
                                        PropertiesEditionEvent.SET, null, getOutSequenceOnError()));
                    }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {}
                
            });
	        
	        EditingUtils.setID(outSequenceOnErrorText, EsbViewsRepository.ProxyService.OutSequence.outSequenceOnError);
	        EditingUtils.setEEFtype(outSequenceOnErrorText, "eef::Text");
	        Control sequenceKeyHelp = FormUtils
	                .createHelpButton(widgetFactory, parent,
	                        propertiesEditionComponent.getHelpContent(
	                                EsbViewsRepository.ProxyService.OutSequence.outSequenceOnError, EsbViewsRepository.FORM_KIND),
	                        null);
	        outSequenceOnErrorElements = new Control[] { onErrorLabel, outSequenceOnErrorText, sequenceKeyHelp };
	        return parent;
	    }
	 
	 protected Composite createWsdlKey(FormToolkit widgetFactory, final Composite parent) {
	        Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.ProxyService.Wsdl.wsdlKey,
	                EsbMessages.ProxyServicePropertiesEditionPart_WsdlKeyLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (wsdlKey == null) {
	            wsdlKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initSequenceKey = wsdlKey.getKeyValue().isEmpty() ? "" : wsdlKey.getKeyValue();
	        wsdlKeyText = widgetFactory.createText(parent, initSequenceKey);
	        wsdlKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        wsdlKeyText.setLayoutData(valueData);
	        wsdlKeyText.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseUp(MouseEvent e) {
	                // TODO Auto-generated method stub
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, wsdlKey, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                wsdlKeyText.setText(wsdlKey.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
	                                EsbViewsRepository.ProxyService.Wsdl.wsdlKey, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getWsdlKey()));
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {
	                // TODO Auto-generated method stub

	            }
	        });
	        
	        wsdlKeyText.addKeyListener(new KeyListener() {
                
                @Override
                public void keyReleased(KeyEvent e) {
                    if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                        EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                                SWT.NULL, wsdlKey, new ArrayList<NamedEntityDescriptor>());
                        dialog.open();
                        wsdlKeyText.setText(wsdlKey.getKeyValue());
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
                                        EsbViewsRepository.ProxyService.Wsdl.wsdlKey, PropertiesEditionEvent.COMMIT,
                                        PropertiesEditionEvent.SET, null, getWsdlKey()));
                    }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {}
                
            });
	        
	        EditingUtils.setID(wsdlKeyText, EsbViewsRepository.ProxyService.Wsdl.wsdlKey);
	        EditingUtils.setEEFtype(wsdlKeyText, "eef::Text");
	        Control sequenceKeyHelp = FormUtils
	                .createHelpButton(widgetFactory, parent,
	                        propertiesEditionComponent.getHelpContent(
	                                EsbViewsRepository.ProxyService.Wsdl.wsdlKey, EsbViewsRepository.FORM_KIND),
	                        null);
	        wsdlKeyElements = new Control[] { sequenceKeyLabel, wsdlKeyText, sequenceKeyHelp };
	        return parent;
	    }
	 
	 protected Composite createWsdlEndpoint(FormToolkit widgetFactory, final Composite parent) {
	        Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.ProxyService.Wsdl.wsdlEndpoint,
	                EsbMessages.ProxyServicePropertiesEditionPart_WsdlEndpointLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (wsdlEndpoint == null) {
	            wsdlEndpoint = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initSequenceKey = wsdlEndpoint.getKeyValue().isEmpty() ? "" : wsdlEndpoint.getKeyValue();
	        wsdlEndpointText = widgetFactory.createText(parent, initSequenceKey, SWT.READ_ONLY);
	        wsdlEndpointText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        wsdlEndpointText.setLayoutData(valueData);
	        wsdlEndpointText.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseUp(MouseEvent e) {
	                // TODO Auto-generated method stub
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, wsdlEndpoint, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                wsdlEndpointText.setText(wsdlEndpoint.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
	                                EsbViewsRepository.ProxyService.Wsdl.wsdlEndpoint, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getWsdlEndpoint()));
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {
	                // TODO Auto-generated method stub

	            }
	        });
	        
	        wsdlEndpointText.addKeyListener(new KeyListener() {
                
                @Override
                public void keyReleased(KeyEvent e) {
                     if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                         EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                                 SWT.NULL, wsdlEndpoint, new ArrayList<NamedEntityDescriptor>());
                         dialog.open();
                         wsdlEndpointText.setText(wsdlEndpoint.getKeyValue());
                         propertiesEditionComponent
                                 .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartForm.this,
                                         EsbViewsRepository.ProxyService.Wsdl.wsdlEndpoint, PropertiesEditionEvent.COMMIT,
                                         PropertiesEditionEvent.SET, null, getWsdlEndpoint()));
                     }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {}
                
            });
	        
	        EditingUtils.setID(wsdlEndpointText, EsbViewsRepository.ProxyService.Wsdl.wsdlEndpoint);
	        EditingUtils.setEEFtype(wsdlEndpointText, "eef::Text");
	        Control sequenceKeyHelp = FormUtils
	                .createHelpButton(widgetFactory, parent,
	                        propertiesEditionComponent.getHelpContent(
	                                EsbViewsRepository.ProxyService.Wsdl.wsdlEndpoint, EsbViewsRepository.FORM_KIND),
	                        null);
	        wsdlEndpointElements = new Control[] { sequenceKeyLabel, wsdlEndpointText, sequenceKeyHelp };
	        return parent;
	    }
	// End of user code


}
