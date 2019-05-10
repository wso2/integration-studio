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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ProxyServicePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ProxyServicePropertiesEditionPart {

	protected Text name;
	protected Text pinnedServers;
	protected Text serviceGroup;
	protected Button traceEnabled;
	protected Button statisticsEnabled;
	protected Button startOnLoad;
	protected Text transports;
	// Start of user code  for onError widgets declarations
	
	// End of user code

	protected EMFComboViewer endpointType;
	protected Text endpointName;
	// Start of user code  for endpointKey widgets declarations
	
	// End of user code

	protected EMFComboViewer faultSequenceType;
	protected Text faultSequenceName;
	// Start of user code  for faultSequenceKey widgets declarations
	
	// End of user code

	// Start of user code  for faultSequenceOnError widgets declarations
	
	// End of user code

	protected EMFComboViewer inSequenceType;
	protected Text inSequenceName;
	// Start of user code  for inSequenceKey widgets declarations
	
	// End of user code

	// Start of user code  for inSequenceOnError widgets declarations
	
	// End of user code

	protected EMFComboViewer outSequenceType;
	protected Text outSequenceName;
	// Start of user code  for outSequenceKey widgets declarations
	
	// End of user code

	// Start of user code  for outSequenceOnError widgets declarations
	
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
	
	// End of user code

	// Start of user code  for wsdlEndpoint widgets declarations
	
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
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ProxyServicePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		wsdlStep.addStep(EsbViewsRepository.ProxyService.Wsdl.wsdlResources);
		wsdlStep.addStep(EsbViewsRepository.ProxyService.Wsdl.preservePolicy);
		wsdlStep.addStep(EsbViewsRepository.ProxyService.Wsdl.wsdlKey);
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
					return createBasicGroup(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.name) {
					return createNameText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.pinnedServers) {
					return createPinnedServersText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.serviceGroup) {
					return createServiceGroupText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.traceEnabled) {
					return createTraceEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.statisticsEnabled) {
					return createStatisticsEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.startOnLoad) {
					return createStartOnLoadCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Basic.transports) {
					return createTransportsText(parent);
				}
				// Start of user code for onError addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.ProxyService.Endpoint.class) {
					return createEndpointGroup(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Endpoint.endpointType) {
					return createEndpointTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Endpoint.endpointName) {
					return createEndpointNameText(parent);
				}
				// Start of user code for endpointKey addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.ProxyService.FaultSequence.class) {
					return createFaultSequenceGroup(parent);
				}
				if (key == EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType) {
					return createFaultSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName) {
					return createFaultSequenceNameText(parent);
				}
				// Start of user code for faultSequenceKey addToPart creation
				
				// End of user code
				// Start of user code for faultSequenceOnError addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.ProxyService.InSequence.class) {
					return createInSequenceGroup(parent);
				}
				if (key == EsbViewsRepository.ProxyService.InSequence.inSequenceType) {
					return createInSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ProxyService.InSequence.inSequenceName) {
					return createInSequenceNameText(parent);
				}
				// Start of user code for inSequenceKey addToPart creation
				
				// End of user code
				// Start of user code for inSequenceOnError addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.ProxyService.OutSequence.class) {
					return createOutSequenceGroup(parent);
				}
				if (key == EsbViewsRepository.ProxyService.OutSequence.outSequenceType) {
					return createOutSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ProxyService.OutSequence.outSequenceName) {
					return createOutSequenceNameText(parent);
				}
				// Start of user code for outSequenceKey addToPart creation
				
				// End of user code
				// Start of user code for outSequenceOnError addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.ProxyService.Parameters.class) {
					return createParametersGroup(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Parameters.serviceParameters) {
					return createServiceParametersAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.ProxyService.ReliableMessaging.class) {
					return createReliableMessagingGroup(parent);
				}
				if (key == EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled) {
					return createReliableMessagingEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Security.class) {
					return createSecurityGroup(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Security.securityEnabled) {
					return createSecurityEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Security.servicePolicies) {
					return createServicePoliciesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.class) {
					return createWsdlGroup(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.wsdlType) {
					return createWsdlTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.wsdlXML) {
					return createWsdlXMLText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.wsdlURL) {
					return createWsdlURLText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.wsdlResources) {
					return createWsdlResourcesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Wsdl.preservePolicy) {
					return createPreservePolicyCheckbox(parent);
				}
				// Start of user code for wsdlKey addToPart creation
				
				// End of user code
				// Start of user code for wsdlEndpoint addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.ProxyService.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors) {
					return createInSequenceInputConnectorsAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.mainSequence) {
					return createMainSequenceCheckbox(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createBasicGroup(Composite parent) {
		Group basicGroup = new Group(parent, SWT.NONE);
		basicGroup.setText(EsbMessages.ProxyServicePropertiesEditionPart_BasicGroupLabel);
		GridData basicGroupData = new GridData(GridData.FILL_HORIZONTAL);
		basicGroupData.horizontalSpan = 3;
		basicGroup.setLayoutData(basicGroupData);
		GridLayout basicGroupLayout = new GridLayout();
		basicGroupLayout.numColumns = 3;
		basicGroup.setLayout(basicGroupLayout);
		return basicGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Basic.name, EsbMessages.ProxyServicePropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Basic.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Basic.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EsbViewsRepository.ProxyService.Basic.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.name, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createPinnedServersText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Basic.pinnedServers, EsbMessages.ProxyServicePropertiesEditionPart_PinnedServersLabel);
		pinnedServers = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData pinnedServersData = new GridData(GridData.FILL_HORIZONTAL);
		pinnedServers.setLayoutData(pinnedServersData);
		pinnedServers.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Basic.pinnedServers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pinnedServers.getText()));
			}

		});
		pinnedServers.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Basic.pinnedServers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pinnedServers.getText()));
				}
			}

		});
		EditingUtils.setID(pinnedServers, EsbViewsRepository.ProxyService.Basic.pinnedServers);
		EditingUtils.setEEFtype(pinnedServers, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.pinnedServers, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPinnedServersText

		// End of user code
		return parent;
	}

	
	protected Composite createServiceGroupText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Basic.serviceGroup, EsbMessages.ProxyServicePropertiesEditionPart_ServiceGroupLabel);
		serviceGroup = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData serviceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		serviceGroup.setLayoutData(serviceGroupData);
		serviceGroup.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Basic.serviceGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceGroup.getText()));
			}

		});
		serviceGroup.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Basic.serviceGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceGroup.getText()));
				}
			}

		});
		EditingUtils.setID(serviceGroup, EsbViewsRepository.ProxyService.Basic.serviceGroup);
		EditingUtils.setEEFtype(serviceGroup, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.serviceGroup, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createServiceGroupText

		// End of user code
		return parent;
	}

	
	protected Composite createTraceEnabledCheckbox(Composite parent) {
		traceEnabled = new Button(parent, SWT.CHECK);
		traceEnabled.setText(getDescription(EsbViewsRepository.ProxyService.Basic.traceEnabled, EsbMessages.ProxyServicePropertiesEditionPart_TraceEnabledLabel));
		traceEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Basic.traceEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(traceEnabled.getSelection())));
			}

		});
		GridData traceEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		traceEnabledData.horizontalSpan = 2;
		traceEnabled.setLayoutData(traceEnabledData);
		EditingUtils.setID(traceEnabled, EsbViewsRepository.ProxyService.Basic.traceEnabled);
		EditingUtils.setEEFtype(traceEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.traceEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTraceEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createStatisticsEnabledCheckbox(Composite parent) {
		statisticsEnabled = new Button(parent, SWT.CHECK);
		statisticsEnabled.setText(getDescription(EsbViewsRepository.ProxyService.Basic.statisticsEnabled, EsbMessages.ProxyServicePropertiesEditionPart_StatisticsEnabledLabel));
		statisticsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Basic.statisticsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statisticsEnabled.getSelection())));
			}

		});
		GridData statisticsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		statisticsEnabledData.horizontalSpan = 2;
		statisticsEnabled.setLayoutData(statisticsEnabledData);
		EditingUtils.setID(statisticsEnabled, EsbViewsRepository.ProxyService.Basic.statisticsEnabled);
		EditingUtils.setEEFtype(statisticsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.statisticsEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatisticsEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createStartOnLoadCheckbox(Composite parent) {
		startOnLoad = new Button(parent, SWT.CHECK);
		startOnLoad.setText(getDescription(EsbViewsRepository.ProxyService.Basic.startOnLoad, EsbMessages.ProxyServicePropertiesEditionPart_StartOnLoadLabel));
		startOnLoad.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Basic.startOnLoad, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(startOnLoad.getSelection())));
			}

		});
		GridData startOnLoadData = new GridData(GridData.FILL_HORIZONTAL);
		startOnLoadData.horizontalSpan = 2;
		startOnLoad.setLayoutData(startOnLoadData);
		EditingUtils.setID(startOnLoad, EsbViewsRepository.ProxyService.Basic.startOnLoad);
		EditingUtils.setEEFtype(startOnLoad, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.startOnLoad, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStartOnLoadCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createTransportsText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Basic.transports, EsbMessages.ProxyServicePropertiesEditionPart_TransportsLabel);
		transports = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData transportsData = new GridData(GridData.FILL_HORIZONTAL);
		transports.setLayoutData(transportsData);
		transports.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Basic.transports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, transports.getText()));
			}

		});
		transports.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Basic.transports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, transports.getText()));
				}
			}

		});
		EditingUtils.setID(transports, EsbViewsRepository.ProxyService.Basic.transports);
		EditingUtils.setEEFtype(transports, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Basic.transports, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTransportsText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createEndpointGroup(Composite parent) {
		Group endpointGroup = new Group(parent, SWT.NONE);
		endpointGroup.setText(EsbMessages.ProxyServicePropertiesEditionPart_EndpointGroupLabel);
		GridData endpointGroupData = new GridData(GridData.FILL_HORIZONTAL);
		endpointGroupData.horizontalSpan = 3;
		endpointGroup.setLayoutData(endpointGroupData);
		GridLayout endpointGroupLayout = new GridLayout();
		endpointGroupLayout.numColumns = 3;
		endpointGroup.setLayout(endpointGroupLayout);
		return endpointGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createEndpointTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Endpoint.endpointType, EsbMessages.ProxyServicePropertiesEditionPart_EndpointTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Endpoint.endpointType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEndpointType()));
			}

		});
		endpointType.setID(EsbViewsRepository.ProxyService.Endpoint.endpointType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Endpoint.endpointType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createEndpointNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Endpoint.endpointName, EsbMessages.ProxyServicePropertiesEditionPart_EndpointNameLabel);
		endpointName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData endpointNameData = new GridData(GridData.FILL_HORIZONTAL);
		endpointName.setLayoutData(endpointNameData);
		endpointName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Endpoint.endpointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endpointName.getText()));
			}

		});
		endpointName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Endpoint.endpointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endpointName.getText()));
				}
			}

		});
		EditingUtils.setID(endpointName, EsbViewsRepository.ProxyService.Endpoint.endpointName);
		EditingUtils.setEEFtype(endpointName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Endpoint.endpointName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointNameText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createFaultSequenceGroup(Composite parent) {
		Group faultSequenceGroup = new Group(parent, SWT.NONE);
		faultSequenceGroup.setText(EsbMessages.ProxyServicePropertiesEditionPart_FaultSequenceGroupLabel);
		GridData faultSequenceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		faultSequenceGroupData.horizontalSpan = 3;
		faultSequenceGroup.setLayoutData(faultSequenceGroupData);
		GridLayout faultSequenceGroupLayout = new GridLayout();
		faultSequenceGroupLayout.numColumns = 3;
		faultSequenceGroup.setLayout(faultSequenceGroupLayout);
		return faultSequenceGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createFaultSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType, EsbMessages.ProxyServicePropertiesEditionPart_FaultSequenceTypeLabel);
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
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultSequenceType()));
			}

		});
		faultSequenceType.setID(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createFaultSequenceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName, EsbMessages.ProxyServicePropertiesEditionPart_FaultSequenceNameLabel);
		faultSequenceName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData faultSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		faultSequenceName.setLayoutData(faultSequenceNameData);
		faultSequenceName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultSequenceName.getText()));
			}

		});
		faultSequenceName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultSequenceName.getText()));
				}
			}

		});
		EditingUtils.setID(faultSequenceName, EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName);
		EditingUtils.setEEFtype(faultSequenceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.FaultSequence.faultSequenceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultSequenceNameText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createInSequenceGroup(Composite parent) {
		Group inSequenceGroup = new Group(parent, SWT.NONE);
		inSequenceGroup.setText(EsbMessages.ProxyServicePropertiesEditionPart_InSequenceGroupLabel);
		GridData inSequenceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceGroupData.horizontalSpan = 3;
		inSequenceGroup.setLayoutData(inSequenceGroupData);
		GridLayout inSequenceGroupLayout = new GridLayout();
		inSequenceGroupLayout.numColumns = 3;
		inSequenceGroup.setLayout(inSequenceGroupLayout);
		return inSequenceGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createInSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.InSequence.inSequenceType, EsbMessages.ProxyServicePropertiesEditionPart_InSequenceTypeLabel);
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
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.InSequence.inSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInSequenceType()));
			}

		});
		inSequenceType.setID(EsbViewsRepository.ProxyService.InSequence.inSequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.InSequence.inSequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createInSequenceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.InSequence.inSequenceName, EsbMessages.ProxyServicePropertiesEditionPart_InSequenceNameLabel);
		inSequenceName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData inSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceName.setLayoutData(inSequenceNameData);
		inSequenceName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.InSequence.inSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inSequenceName.getText()));
			}

		});
		inSequenceName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.InSequence.inSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inSequenceName.getText()));
				}
			}

		});
		EditingUtils.setID(inSequenceName, EsbViewsRepository.ProxyService.InSequence.inSequenceName);
		EditingUtils.setEEFtype(inSequenceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.InSequence.inSequenceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInSequenceNameText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createOutSequenceGroup(Composite parent) {
		Group outSequenceGroup = new Group(parent, SWT.NONE);
		outSequenceGroup.setText(EsbMessages.ProxyServicePropertiesEditionPart_OutSequenceGroupLabel);
		GridData outSequenceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		outSequenceGroupData.horizontalSpan = 3;
		outSequenceGroup.setLayoutData(outSequenceGroupData);
		GridLayout outSequenceGroupLayout = new GridLayout();
		outSequenceGroupLayout.numColumns = 3;
		outSequenceGroup.setLayout(outSequenceGroupLayout);
		return outSequenceGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createOutSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.OutSequence.outSequenceType, EsbMessages.ProxyServicePropertiesEditionPart_OutSequenceTypeLabel);
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
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.OutSequence.outSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutSequenceType()));
			}

		});
		outSequenceType.setID(EsbViewsRepository.ProxyService.OutSequence.outSequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.OutSequence.outSequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOutSequenceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.OutSequence.outSequenceName, EsbMessages.ProxyServicePropertiesEditionPart_OutSequenceNameLabel);
		outSequenceName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData outSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		outSequenceName.setLayoutData(outSequenceNameData);
		outSequenceName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.OutSequence.outSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outSequenceName.getText()));
			}

		});
		outSequenceName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.OutSequence.outSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outSequenceName.getText()));
				}
			}

		});
		EditingUtils.setID(outSequenceName, EsbViewsRepository.ProxyService.OutSequence.outSequenceName);
		EditingUtils.setEEFtype(outSequenceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.OutSequence.outSequenceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutSequenceNameText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createParametersGroup(Composite parent) {
		Group parametersGroup = new Group(parent, SWT.NONE);
		parametersGroup.setText(EsbMessages.ProxyServicePropertiesEditionPart_ParametersGroupLabel);
		GridData parametersGroupData = new GridData(GridData.FILL_HORIZONTAL);
		parametersGroupData.horizontalSpan = 3;
		parametersGroup.setLayoutData(parametersGroupData);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		return parametersGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createServiceParametersAdvancedTableComposition(Composite parent) {
		this.serviceParameters = new ReferencesTable(getDescription(EsbViewsRepository.ProxyService.Parameters.serviceParameters, EsbMessages.ProxyServicePropertiesEditionPart_ServiceParametersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Parameters.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				serviceParameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Parameters.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				serviceParameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Parameters.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				serviceParameters.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Parameters.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				serviceParameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.serviceParametersFilters) {
			this.serviceParameters.addFilter(filter);
		}
		this.serviceParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Parameters.serviceParameters, EsbViewsRepository.SWT_KIND));
		this.serviceParameters.createControls(parent);
		this.serviceParameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Parameters.serviceParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createServiceParametersAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createReliableMessagingGroup(Composite parent) {
		Group reliableMessagingGroup = new Group(parent, SWT.NONE);
		reliableMessagingGroup.setText(EsbMessages.ProxyServicePropertiesEditionPart_ReliableMessagingGroupLabel);
		GridData reliableMessagingGroupData = new GridData(GridData.FILL_HORIZONTAL);
		reliableMessagingGroupData.horizontalSpan = 3;
		reliableMessagingGroup.setLayoutData(reliableMessagingGroupData);
		GridLayout reliableMessagingGroupLayout = new GridLayout();
		reliableMessagingGroupLayout.numColumns = 3;
		reliableMessagingGroup.setLayout(reliableMessagingGroupLayout);
		return reliableMessagingGroup;
	}

	
	protected Composite createReliableMessagingEnabledCheckbox(Composite parent) {
		reliableMessagingEnabled = new Button(parent, SWT.CHECK);
		reliableMessagingEnabled.setText(getDescription(EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled, EsbMessages.ProxyServicePropertiesEditionPart_ReliableMessagingEnabledLabel));
		reliableMessagingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reliableMessagingEnabled.getSelection())));
			}

		});
		GridData reliableMessagingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		reliableMessagingEnabledData.horizontalSpan = 2;
		reliableMessagingEnabled.setLayoutData(reliableMessagingEnabledData);
		EditingUtils.setID(reliableMessagingEnabled, EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled);
		EditingUtils.setEEFtype(reliableMessagingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.ReliableMessaging.reliableMessagingEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReliableMessagingEnabledCheckbox

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createSecurityGroup(Composite parent) {
		Group securityGroup = new Group(parent, SWT.NONE);
		securityGroup.setText(EsbMessages.ProxyServicePropertiesEditionPart_SecurityGroupLabel);
		GridData securityGroupData = new GridData(GridData.FILL_HORIZONTAL);
		securityGroupData.horizontalSpan = 3;
		securityGroup.setLayoutData(securityGroupData);
		GridLayout securityGroupLayout = new GridLayout();
		securityGroupLayout.numColumns = 3;
		securityGroup.setLayout(securityGroupLayout);
		return securityGroup;
	}

	
	protected Composite createSecurityEnabledCheckbox(Composite parent) {
		securityEnabled = new Button(parent, SWT.CHECK);
		securityEnabled.setText(getDescription(EsbViewsRepository.ProxyService.Security.securityEnabled, EsbMessages.ProxyServicePropertiesEditionPart_SecurityEnabledLabel));
		securityEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Security.securityEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(securityEnabled.getSelection())));
			}

		});
		GridData securityEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		securityEnabledData.horizontalSpan = 2;
		securityEnabled.setLayoutData(securityEnabledData);
		EditingUtils.setID(securityEnabled, EsbViewsRepository.ProxyService.Security.securityEnabled);
		EditingUtils.setEEFtype(securityEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Security.securityEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSecurityEnabledCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createServicePoliciesAdvancedTableComposition(Composite parent) {
		this.servicePolicies = new ReferencesTable(getDescription(EsbViewsRepository.ProxyService.Security.servicePolicies, EsbMessages.ProxyServicePropertiesEditionPart_ServicePoliciesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Security.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				servicePolicies.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Security.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				servicePolicies.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Security.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				servicePolicies.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Security.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				servicePolicies.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.servicePoliciesFilters) {
			this.servicePolicies.addFilter(filter);
		}
		this.servicePolicies.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Security.servicePolicies, EsbViewsRepository.SWT_KIND));
		this.servicePolicies.createControls(parent);
		this.servicePolicies.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Security.servicePolicies, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createServicePoliciesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createWsdlGroup(Composite parent) {
		Group wsdlGroup = new Group(parent, SWT.NONE);
		wsdlGroup.setText(EsbMessages.ProxyServicePropertiesEditionPart_WsdlGroupLabel);
		GridData wsdlGroupData = new GridData(GridData.FILL_HORIZONTAL);
		wsdlGroupData.horizontalSpan = 3;
		wsdlGroup.setLayoutData(wsdlGroupData);
		GridLayout wsdlGroupLayout = new GridLayout();
		wsdlGroupLayout.numColumns = 3;
		wsdlGroup.setLayout(wsdlGroupLayout);
		return wsdlGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createWsdlTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Wsdl.wsdlType, EsbMessages.ProxyServicePropertiesEditionPart_WsdlTypeLabel);
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
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Wsdl.wsdlType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getWsdlType()));
			}

		});
		wsdlType.setID(EsbViewsRepository.ProxyService.Wsdl.wsdlType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Wsdl.wsdlType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createWsdlTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createWsdlXMLText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Wsdl.wsdlXML, EsbMessages.ProxyServicePropertiesEditionPart_WsdlXMLLabel);
		wsdlXML = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData wsdlXMLData = new GridData(GridData.FILL_HORIZONTAL);
		wsdlXML.setLayoutData(wsdlXMLData);
		wsdlXML.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Wsdl.wsdlXML, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlXML.getText()));
			}

		});
		wsdlXML.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Wsdl.wsdlXML, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlXML.getText()));
				}
			}

		});
		EditingUtils.setID(wsdlXML, EsbViewsRepository.ProxyService.Wsdl.wsdlXML);
		EditingUtils.setEEFtype(wsdlXML, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Wsdl.wsdlXML, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createWsdlXMLText

		// End of user code
		return parent;
	}

	
	protected Composite createWsdlURLText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Wsdl.wsdlURL, EsbMessages.ProxyServicePropertiesEditionPart_WsdlURLLabel);
		wsdlURL = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData wsdlURLData = new GridData(GridData.FILL_HORIZONTAL);
		wsdlURL.setLayoutData(wsdlURLData);
		wsdlURL.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Wsdl.wsdlURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlURL.getText()));
			}

		});
		wsdlURL.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Wsdl.wsdlURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlURL.getText()));
				}
			}

		});
		EditingUtils.setID(wsdlURL, EsbViewsRepository.ProxyService.Wsdl.wsdlURL);
		EditingUtils.setEEFtype(wsdlURL, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Wsdl.wsdlURL, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createWsdlURLText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createWsdlResourcesAdvancedTableComposition(Composite parent) {
		this.wsdlResources = new ReferencesTable(getDescription(EsbViewsRepository.ProxyService.Wsdl.wsdlResources, EsbMessages.ProxyServicePropertiesEditionPart_WsdlResourcesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Wsdl.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				wsdlResources.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Wsdl.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				wsdlResources.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Wsdl.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				wsdlResources.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Wsdl.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				wsdlResources.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.wsdlResourcesFilters) {
			this.wsdlResources.addFilter(filter);
		}
		this.wsdlResources.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Wsdl.wsdlResources, EsbViewsRepository.SWT_KIND));
		this.wsdlResources.createControls(parent);
		this.wsdlResources.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Wsdl.wsdlResources, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createWsdlResourcesAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createPreservePolicyCheckbox(Composite parent) {
		preservePolicy = new Button(parent, SWT.CHECK);
		preservePolicy.setText(getDescription(EsbViewsRepository.ProxyService.Wsdl.preservePolicy, EsbMessages.ProxyServicePropertiesEditionPart_PreservePolicyLabel));
		preservePolicy.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Wsdl.preservePolicy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(preservePolicy.getSelection())));
			}

		});
		GridData preservePolicyData = new GridData(GridData.FILL_HORIZONTAL);
		preservePolicyData.horizontalSpan = 2;
		preservePolicy.setLayoutData(preservePolicyData);
		EditingUtils.setID(preservePolicy, EsbViewsRepository.ProxyService.Wsdl.preservePolicy);
		EditingUtils.setEEFtype(preservePolicy, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Wsdl.preservePolicy, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPreservePolicyCheckbox

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.ProxyServicePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.description, EsbMessages.ProxyServicePropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.ProxyService.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.ProxyService.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.ProxyService.Properties.commentsList, EsbMessages.ProxyServicePropertiesEditionPart_CommentsListLabel));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
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
	 * @param container
	 * 
	 */
	protected Composite createInSequenceInputConnectorsAdvancedTableComposition(Composite parent) {
		this.inSequenceInputConnectors = new ReferencesTable(getDescription(EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, EsbMessages.ProxyServicePropertiesEditionPart_InSequenceInputConnectorsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				inSequenceInputConnectors.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				inSequenceInputConnectors.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				inSequenceInputConnectors.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				inSequenceInputConnectors.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.inSequenceInputConnectorsFilters) {
			this.inSequenceInputConnectors.addFilter(filter);
		}
		this.inSequenceInputConnectors.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, EsbViewsRepository.SWT_KIND));
		this.inSequenceInputConnectors.createControls(parent);
		this.inSequenceInputConnectors.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createInSequenceInputConnectorsAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createMainSequenceCheckbox(Composite parent) {
		mainSequence = new Button(parent, SWT.CHECK);
		mainSequence.setText(getDescription(EsbViewsRepository.ProxyService.Properties.mainSequence, EsbMessages.ProxyServicePropertiesEditionPart_MainSequenceLabel));
		mainSequence.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.mainSequence, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(mainSequence.getSelection())));
			}

		});
		GridData mainSequenceData = new GridData(GridData.FILL_HORIZONTAL);
		mainSequenceData.horizontalSpan = 2;
		mainSequence.setLayoutData(mainSequenceData);
		EditingUtils.setID(mainSequence, EsbViewsRepository.ProxyService.Properties.mainSequence);
		EditingUtils.setEEFtype(mainSequence, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.mainSequence, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setName(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getPinnedServers()
	 * 
	 */
	public String getPinnedServers() {
		return pinnedServers.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setPinnedServers(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getServiceGroup()
	 * 
	 */
	public String getServiceGroup() {
		return serviceGroup.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setServiceGroup(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getTraceEnabled()
	 * 
	 */
	public Boolean getTraceEnabled() {
		return Boolean.valueOf(traceEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setTraceEnabled(Boolean newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getStatisticsEnabled()
	 * 
	 */
	public Boolean getStatisticsEnabled() {
		return Boolean.valueOf(statisticsEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setStatisticsEnabled(Boolean newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getStartOnLoad()
	 * 
	 */
	public Boolean getStartOnLoad() {
		return Boolean.valueOf(startOnLoad.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setStartOnLoad(Boolean newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getTransports()
	 * 
	 */
	public String getTransports() {
		return transports.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setTransports(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getEndpointType()
	 * 
	 */
	public Enumerator getEndpointType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) endpointType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initEndpointType(Object input, Enumerator current)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setEndpointType(Enumerator newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getEndpointName()
	 * 
	 */
	public String getEndpointName() {
		return endpointName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setEndpointName(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getFaultSequenceType()
	 * 
	 */
	public Enumerator getFaultSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initFaultSequenceType(Object input, Enumerator current)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setFaultSequenceType(Enumerator newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getFaultSequenceName()
	 * 
	 */
	public String getFaultSequenceName() {
		return faultSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setFaultSequenceName(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getInSequenceType()
	 * 
	 */
	public Enumerator getInSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initInSequenceType(Object input, Enumerator current)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setInSequenceType(Enumerator newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getInSequenceName()
	 * 
	 */
	public String getInSequenceName() {
		return inSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setInSequenceName(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getOutSequenceType()
	 * 
	 */
	public Enumerator getOutSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initOutSequenceType(Object input, Enumerator current)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setOutSequenceType(Enumerator newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getOutSequenceName()
	 * 
	 */
	public String getOutSequenceName() {
		return outSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setOutSequenceName(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initServiceParameters(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#updateServiceParameters()
	 * 
	 */
	public void updateServiceParameters() {
	serviceParameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addFilterServiceParameters(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addBusinessFilterServiceParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToServiceParameters(ViewerFilter filter) {
		serviceParametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#isContainedInServiceParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInServiceParametersTable(EObject element) {
		return ((ReferencesTableSettings)serviceParameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getReliableMessagingEnabled()
	 * 
	 */
	public Boolean getReliableMessagingEnabled() {
		return Boolean.valueOf(reliableMessagingEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setReliableMessagingEnabled(Boolean newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getSecurityEnabled()
	 * 
	 */
	public Boolean getSecurityEnabled() {
		return Boolean.valueOf(securityEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setSecurityEnabled(Boolean newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initServicePolicies(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#updateServicePolicies()
	 * 
	 */
	public void updateServicePolicies() {
	servicePolicies.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addFilterServicePolicies(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addBusinessFilterServicePolicies(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToServicePolicies(ViewerFilter filter) {
		servicePoliciesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#isContainedInServicePoliciesTable(EObject element)
	 * 
	 */
	public boolean isContainedInServicePoliciesTable(EObject element) {
		return ((ReferencesTableSettings)servicePolicies.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getWsdlType()
	 * 
	 */
	public Enumerator getWsdlType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) wsdlType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initWsdlType(Object input, Enumerator current)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setWsdlType(Enumerator newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getWsdlXML()
	 * 
	 */
	public String getWsdlXML() {
		return wsdlXML.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setWsdlXML(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getWsdlURL()
	 * 
	 */
	public String getWsdlURL() {
		return wsdlURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setWsdlURL(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initWsdlResources(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#updateWsdlResources()
	 * 
	 */
	public void updateWsdlResources() {
	wsdlResources.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addFilterWsdlResources(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addBusinessFilterWsdlResources(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToWsdlResources(ViewerFilter filter) {
		wsdlResourcesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#isContainedInWsdlResourcesTable(EObject element)
	 * 
	 */
	public boolean isContainedInWsdlResourcesTable(EObject element) {
		return ((ReferencesTableSettings)wsdlResources.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getPreservePolicy()
	 * 
	 */
	public Boolean getPreservePolicy() {
		return Boolean.valueOf(preservePolicy.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setPreservePolicy(Boolean newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setDescription(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setCommentsList(EList newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initInSequenceInputConnectors(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#updateInSequenceInputConnectors()
	 * 
	 */
	public void updateInSequenceInputConnectors() {
	inSequenceInputConnectors.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addFilterInSequenceInputConnectors(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#addBusinessFilterInSequenceInputConnectors(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToInSequenceInputConnectors(ViewerFilter filter) {
		inSequenceInputConnectorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#isContainedInInSequenceInputConnectorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInInSequenceInputConnectorsTable(EObject element) {
		return ((ReferencesTableSettings)inSequenceInputConnectors.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#getMainSequence()
	 * 
	 */
	public Boolean getMainSequence() {
		return Boolean.valueOf(mainSequence.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#setMainSequence(Boolean newValue)
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
	
	// End of user code

	// Start of user code for endpointKey specific getters and setters implementation
	
	// End of user code

	// Start of user code for faultSequenceKey specific getters and setters implementation
	
	// End of user code

	// Start of user code for faultSequenceOnError specific getters and setters implementation
	
	// End of user code

	// Start of user code for inSequenceKey specific getters and setters implementation
	
	// End of user code

	// Start of user code for inSequenceOnError specific getters and setters implementation
	
	// End of user code

	// Start of user code for outSequenceKey specific getters and setters implementation
	
	// End of user code

	// Start of user code for outSequenceOnError specific getters and setters implementation
	
	// End of user code

	// Start of user code for wsdlKey specific getters and setters implementation
	
	// End of user code

	// Start of user code for wsdlEndpoint specific getters and setters implementation
	
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
    public void setOnError(RegistryKeyProperty rkp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getOnError() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setEndpointKey(RegistryKeyProperty rkp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getEndpointKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFaultSequenceKey(RegistryKeyProperty rkp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getFaultSequenceKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFaultSequenceOnError(RegistryKeyProperty rkp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getFaultSequenceOnError() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInSequenceKey(RegistryKeyProperty rkp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getInSequenceKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInSequenceOnError(RegistryKeyProperty rkp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getInSequenceOnError() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setOutSequenceKey(RegistryKeyProperty rkp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getOutSequenceKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setOutSequenceOnError(RegistryKeyProperty rkp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getOutSequenceOnError() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setWsdlKey(RegistryKeyProperty rkp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getWsdlKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setWsdlEndpoint(RegistryKeyProperty rkp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getWsdlEndpoint() {
        // TODO Auto-generated method stub
        return null;
    }
	
	// End of user code


}
