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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ProxyServicePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ProxyServicePropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected ReferencesTable inSequenceInputConnectors;
	protected List<ViewerFilter> inSequenceInputConnectorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> inSequenceInputConnectorsFilters = new ArrayList<ViewerFilter>();
	protected Text name;
	protected Text pinnedServers;
	protected Text serviceGroup;
	protected Button traceEnabled;
	protected Button statisticsEnabled;
	protected Button startOnLoad;
	protected Text transports;
	protected Button reliableMessagingEnabled;
	protected Button securityEnabled;
	protected ReferencesTable serviceParameters;
	protected List<ViewerFilter> serviceParametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> serviceParametersFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable servicePolicies;
	protected List<ViewerFilter> servicePoliciesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> servicePoliciesFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer inSequenceType;
	protected Text inSequenceName;
	protected EMFComboViewer outSequenceType;
	protected Text outSequenceName;
	protected EMFComboViewer faultSequenceType;
	protected Text faultSequenceName;
	protected EMFComboViewer endpointType;
	protected Text endpointName;
	protected Button mainSequence;
	protected EMFComboViewer wsdlType;
	protected Button preservePolicy;
	protected Text wsdlXML;
	protected Text wsdlURL;
	protected ReferencesTable wsdlResources;
	protected List<ViewerFilter> wsdlResourcesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> wsdlResourcesFilters = new ArrayList<ViewerFilter>();



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
		CompositionStep propertiesStep = proxyServiceStep.addStep(EsbViewsRepository.ProxyService.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.name);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.pinnedServers);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.serviceGroup);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.traceEnabled);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.statisticsEnabled);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.startOnLoad);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.transports);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.securityEnabled);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.serviceParameters);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.servicePolicies);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.inSequenceType);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.inSequenceName);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.outSequenceType);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.outSequenceName);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.faultSequenceType);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.faultSequenceName);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.endpointType);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.endpointName);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.mainSequence);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.wsdlType);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.preservePolicy);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.wsdlXML);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.wsdlURL);
		propertiesStep.addStep(EsbViewsRepository.ProxyService.Properties.wsdlResources);
		
		
		composer = new PartComposer(proxyServiceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
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
				if (key == EsbViewsRepository.ProxyService.Properties.name) {
					return createNameText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.pinnedServers) {
					return createPinnedServersText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.serviceGroup) {
					return createServiceGroupText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.traceEnabled) {
					return createTraceEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.statisticsEnabled) {
					return createStatisticsEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.startOnLoad) {
					return createStartOnLoadCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.transports) {
					return createTransportsText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled) {
					return createReliableMessagingEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.securityEnabled) {
					return createSecurityEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.serviceParameters) {
					return createServiceParametersAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.servicePolicies) {
					return createServicePoliciesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.inSequenceType) {
					return createInSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.inSequenceName) {
					return createInSequenceNameText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.outSequenceType) {
					return createOutSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.outSequenceName) {
					return createOutSequenceNameText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.faultSequenceType) {
					return createFaultSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.faultSequenceName) {
					return createFaultSequenceNameText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.endpointType) {
					return createEndpointTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.endpointName) {
					return createEndpointNameText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.mainSequence) {
					return createMainSequenceCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.wsdlType) {
					return createWsdlTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.preservePolicy) {
					return createPreservePolicyCheckbox(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.wsdlXML) {
					return createWsdlXMLText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.wsdlURL) {
					return createWsdlURLText(parent);
				}
				if (key == EsbViewsRepository.ProxyService.Properties.wsdlResources) {
					return createWsdlResourcesAdvancedTableComposition(parent);
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

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.name, EsbMessages.ProxyServicePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EsbViewsRepository.ProxyService.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.name, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createPinnedServersText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.pinnedServers, EsbMessages.ProxyServicePropertiesEditionPart_PinnedServersLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.pinnedServers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pinnedServers.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.pinnedServers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pinnedServers.getText()));
				}
			}

		});
		EditingUtils.setID(pinnedServers, EsbViewsRepository.ProxyService.Properties.pinnedServers);
		EditingUtils.setEEFtype(pinnedServers, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.pinnedServers, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPinnedServersText

		// End of user code
		return parent;
	}

	
	protected Composite createServiceGroupText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.serviceGroup, EsbMessages.ProxyServicePropertiesEditionPart_ServiceGroupLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.serviceGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceGroup.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.serviceGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceGroup.getText()));
				}
			}

		});
		EditingUtils.setID(serviceGroup, EsbViewsRepository.ProxyService.Properties.serviceGroup);
		EditingUtils.setEEFtype(serviceGroup, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.serviceGroup, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createServiceGroupText

		// End of user code
		return parent;
	}

	
	protected Composite createTraceEnabledCheckbox(Composite parent) {
		traceEnabled = new Button(parent, SWT.CHECK);
		traceEnabled.setText(getDescription(EsbViewsRepository.ProxyService.Properties.traceEnabled, EsbMessages.ProxyServicePropertiesEditionPart_TraceEnabledLabel));
		traceEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.traceEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(traceEnabled.getSelection())));
			}

		});
		GridData traceEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		traceEnabledData.horizontalSpan = 2;
		traceEnabled.setLayoutData(traceEnabledData);
		EditingUtils.setID(traceEnabled, EsbViewsRepository.ProxyService.Properties.traceEnabled);
		EditingUtils.setEEFtype(traceEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.traceEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTraceEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createStatisticsEnabledCheckbox(Composite parent) {
		statisticsEnabled = new Button(parent, SWT.CHECK);
		statisticsEnabled.setText(getDescription(EsbViewsRepository.ProxyService.Properties.statisticsEnabled, EsbMessages.ProxyServicePropertiesEditionPart_StatisticsEnabledLabel));
		statisticsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.statisticsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statisticsEnabled.getSelection())));
			}

		});
		GridData statisticsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		statisticsEnabledData.horizontalSpan = 2;
		statisticsEnabled.setLayoutData(statisticsEnabledData);
		EditingUtils.setID(statisticsEnabled, EsbViewsRepository.ProxyService.Properties.statisticsEnabled);
		EditingUtils.setEEFtype(statisticsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.statisticsEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatisticsEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createStartOnLoadCheckbox(Composite parent) {
		startOnLoad = new Button(parent, SWT.CHECK);
		startOnLoad.setText(getDescription(EsbViewsRepository.ProxyService.Properties.startOnLoad, EsbMessages.ProxyServicePropertiesEditionPart_StartOnLoadLabel));
		startOnLoad.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.startOnLoad, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(startOnLoad.getSelection())));
			}

		});
		GridData startOnLoadData = new GridData(GridData.FILL_HORIZONTAL);
		startOnLoadData.horizontalSpan = 2;
		startOnLoad.setLayoutData(startOnLoadData);
		EditingUtils.setID(startOnLoad, EsbViewsRepository.ProxyService.Properties.startOnLoad);
		EditingUtils.setEEFtype(startOnLoad, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.startOnLoad, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStartOnLoadCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createTransportsText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.transports, EsbMessages.ProxyServicePropertiesEditionPart_TransportsLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.transports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, transports.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.transports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, transports.getText()));
				}
			}

		});
		EditingUtils.setID(transports, EsbViewsRepository.ProxyService.Properties.transports);
		EditingUtils.setEEFtype(transports, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.transports, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTransportsText

		// End of user code
		return parent;
	}

	
	protected Composite createReliableMessagingEnabledCheckbox(Composite parent) {
		reliableMessagingEnabled = new Button(parent, SWT.CHECK);
		reliableMessagingEnabled.setText(getDescription(EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled, EsbMessages.ProxyServicePropertiesEditionPart_ReliableMessagingEnabledLabel));
		reliableMessagingEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reliableMessagingEnabled.getSelection())));
			}

		});
		GridData reliableMessagingEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		reliableMessagingEnabledData.horizontalSpan = 2;
		reliableMessagingEnabled.setLayoutData(reliableMessagingEnabledData);
		EditingUtils.setID(reliableMessagingEnabled, EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled);
		EditingUtils.setEEFtype(reliableMessagingEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReliableMessagingEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createSecurityEnabledCheckbox(Composite parent) {
		securityEnabled = new Button(parent, SWT.CHECK);
		securityEnabled.setText(getDescription(EsbViewsRepository.ProxyService.Properties.securityEnabled, EsbMessages.ProxyServicePropertiesEditionPart_SecurityEnabledLabel));
		securityEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.securityEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(securityEnabled.getSelection())));
			}

		});
		GridData securityEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		securityEnabledData.horizontalSpan = 2;
		securityEnabled.setLayoutData(securityEnabledData);
		EditingUtils.setID(securityEnabled, EsbViewsRepository.ProxyService.Properties.securityEnabled);
		EditingUtils.setEEFtype(securityEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.securityEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSecurityEnabledCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createServiceParametersAdvancedTableComposition(Composite parent) {
		this.serviceParameters = new ReferencesTable(getDescription(EsbViewsRepository.ProxyService.Properties.serviceParameters, EsbMessages.ProxyServicePropertiesEditionPart_ServiceParametersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				serviceParameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				serviceParameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				serviceParameters.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.serviceParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				serviceParameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.serviceParametersFilters) {
			this.serviceParameters.addFilter(filter);
		}
		this.serviceParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.serviceParameters, EsbViewsRepository.SWT_KIND));
		this.serviceParameters.createControls(parent);
		this.serviceParameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.serviceParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData serviceParametersData = new GridData(GridData.FILL_HORIZONTAL);
		serviceParametersData.horizontalSpan = 3;
		this.serviceParameters.setLayoutData(serviceParametersData);
		this.serviceParameters.setLowerBound(0);
		this.serviceParameters.setUpperBound(-1);
		serviceParameters.setID(EsbViewsRepository.ProxyService.Properties.serviceParameters);
		serviceParameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createServiceParametersAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createServicePoliciesAdvancedTableComposition(Composite parent) {
		this.servicePolicies = new ReferencesTable(getDescription(EsbViewsRepository.ProxyService.Properties.servicePolicies, EsbMessages.ProxyServicePropertiesEditionPart_ServicePoliciesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				servicePolicies.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				servicePolicies.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				servicePolicies.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.servicePolicies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				servicePolicies.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.servicePoliciesFilters) {
			this.servicePolicies.addFilter(filter);
		}
		this.servicePolicies.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.servicePolicies, EsbViewsRepository.SWT_KIND));
		this.servicePolicies.createControls(parent);
		this.servicePolicies.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.servicePolicies, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData servicePoliciesData = new GridData(GridData.FILL_HORIZONTAL);
		servicePoliciesData.horizontalSpan = 3;
		this.servicePolicies.setLayoutData(servicePoliciesData);
		this.servicePolicies.setLowerBound(0);
		this.servicePolicies.setUpperBound(-1);
		servicePolicies.setID(EsbViewsRepository.ProxyService.Properties.servicePolicies);
		servicePolicies.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createServicePoliciesAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createInSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.inSequenceType, EsbMessages.ProxyServicePropertiesEditionPart_InSequenceTypeLabel);
		inSequenceType = new EMFComboViewer(parent);
		inSequenceType.setContentProvider(new ArrayContentProvider());
		inSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData inSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceType.getCombo().setLayoutData(inSequenceTypeData);
		inSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.inSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInSequenceType()));
			}

		});
		inSequenceType.setID(EsbViewsRepository.ProxyService.Properties.inSequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.inSequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createInSequenceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.inSequenceName, EsbMessages.ProxyServicePropertiesEditionPart_InSequenceNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.inSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inSequenceName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.inSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inSequenceName.getText()));
				}
			}

		});
		EditingUtils.setID(inSequenceName, EsbViewsRepository.ProxyService.Properties.inSequenceName);
		EditingUtils.setEEFtype(inSequenceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.inSequenceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInSequenceNameText

		// End of user code
		return parent;
	}

	
	protected Composite createOutSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.outSequenceType, EsbMessages.ProxyServicePropertiesEditionPart_OutSequenceTypeLabel);
		outSequenceType = new EMFComboViewer(parent);
		outSequenceType.setContentProvider(new ArrayContentProvider());
		outSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData outSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		outSequenceType.getCombo().setLayoutData(outSequenceTypeData);
		outSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.outSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutSequenceType()));
			}

		});
		outSequenceType.setID(EsbViewsRepository.ProxyService.Properties.outSequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.outSequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOutSequenceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.outSequenceName, EsbMessages.ProxyServicePropertiesEditionPart_OutSequenceNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.outSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outSequenceName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.outSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outSequenceName.getText()));
				}
			}

		});
		EditingUtils.setID(outSequenceName, EsbViewsRepository.ProxyService.Properties.outSequenceName);
		EditingUtils.setEEFtype(outSequenceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.outSequenceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutSequenceNameText

		// End of user code
		return parent;
	}

	
	protected Composite createFaultSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.faultSequenceType, EsbMessages.ProxyServicePropertiesEditionPart_FaultSequenceTypeLabel);
		faultSequenceType = new EMFComboViewer(parent);
		faultSequenceType.setContentProvider(new ArrayContentProvider());
		faultSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultSequenceType.getCombo().setLayoutData(faultSequenceTypeData);
		faultSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.faultSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultSequenceType()));
			}

		});
		faultSequenceType.setID(EsbViewsRepository.ProxyService.Properties.faultSequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.faultSequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createFaultSequenceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.faultSequenceName, EsbMessages.ProxyServicePropertiesEditionPart_FaultSequenceNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.faultSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultSequenceName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.faultSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultSequenceName.getText()));
				}
			}

		});
		EditingUtils.setID(faultSequenceName, EsbViewsRepository.ProxyService.Properties.faultSequenceName);
		EditingUtils.setEEFtype(faultSequenceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.faultSequenceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultSequenceNameText

		// End of user code
		return parent;
	}

	
	protected Composite createEndpointTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.endpointType, EsbMessages.ProxyServicePropertiesEditionPart_EndpointTypeLabel);
		endpointType = new EMFComboViewer(parent);
		endpointType.setContentProvider(new ArrayContentProvider());
		endpointType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData endpointTypeData = new GridData(GridData.FILL_HORIZONTAL);
		endpointType.getCombo().setLayoutData(endpointTypeData);
		endpointType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.endpointType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEndpointType()));
			}

		});
		endpointType.setID(EsbViewsRepository.ProxyService.Properties.endpointType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.endpointType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createEndpointNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.endpointName, EsbMessages.ProxyServicePropertiesEditionPart_EndpointNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.endpointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endpointName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.endpointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endpointName.getText()));
				}
			}

		});
		EditingUtils.setID(endpointName, EsbViewsRepository.ProxyService.Properties.endpointName);
		EditingUtils.setEEFtype(endpointName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.endpointName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointNameText

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

	
	protected Composite createWsdlTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.wsdlType, EsbMessages.ProxyServicePropertiesEditionPart_WsdlTypeLabel);
		wsdlType = new EMFComboViewer(parent);
		wsdlType.setContentProvider(new ArrayContentProvider());
		wsdlType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData wsdlTypeData = new GridData(GridData.FILL_HORIZONTAL);
		wsdlType.getCombo().setLayoutData(wsdlTypeData);
		wsdlType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.wsdlType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getWsdlType()));
			}

		});
		wsdlType.setID(EsbViewsRepository.ProxyService.Properties.wsdlType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.wsdlType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createWsdlTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPreservePolicyCheckbox(Composite parent) {
		preservePolicy = new Button(parent, SWT.CHECK);
		preservePolicy.setText(getDescription(EsbViewsRepository.ProxyService.Properties.preservePolicy, EsbMessages.ProxyServicePropertiesEditionPart_PreservePolicyLabel));
		preservePolicy.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.preservePolicy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(preservePolicy.getSelection())));
			}

		});
		GridData preservePolicyData = new GridData(GridData.FILL_HORIZONTAL);
		preservePolicyData.horizontalSpan = 2;
		preservePolicy.setLayoutData(preservePolicyData);
		EditingUtils.setID(preservePolicy, EsbViewsRepository.ProxyService.Properties.preservePolicy);
		EditingUtils.setEEFtype(preservePolicy, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.preservePolicy, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPreservePolicyCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createWsdlXMLText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.wsdlXML, EsbMessages.ProxyServicePropertiesEditionPart_WsdlXMLLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.wsdlXML, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlXML.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.wsdlXML, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlXML.getText()));
				}
			}

		});
		EditingUtils.setID(wsdlXML, EsbViewsRepository.ProxyService.Properties.wsdlXML);
		EditingUtils.setEEFtype(wsdlXML, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.wsdlXML, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createWsdlXMLText

		// End of user code
		return parent;
	}

	
	protected Composite createWsdlURLText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyService.Properties.wsdlURL, EsbMessages.ProxyServicePropertiesEditionPart_WsdlURLLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.wsdlURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlURL.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.wsdlURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, wsdlURL.getText()));
				}
			}

		});
		EditingUtils.setID(wsdlURL, EsbViewsRepository.ProxyService.Properties.wsdlURL);
		EditingUtils.setEEFtype(wsdlURL, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.wsdlURL, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createWsdlURLText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createWsdlResourcesAdvancedTableComposition(Composite parent) {
		this.wsdlResources = new ReferencesTable(getDescription(EsbViewsRepository.ProxyService.Properties.wsdlResources, EsbMessages.ProxyServicePropertiesEditionPart_WsdlResourcesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				wsdlResources.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				wsdlResources.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				wsdlResources.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.wsdlResources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				wsdlResources.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.wsdlResourcesFilters) {
			this.wsdlResources.addFilter(filter);
		}
		this.wsdlResources.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyService.Properties.wsdlResources, EsbViewsRepository.SWT_KIND));
		this.wsdlResources.createControls(parent);
		this.wsdlResources.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyService.Properties.wsdlResources, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData wsdlResourcesData = new GridData(GridData.FILL_HORIZONTAL);
		wsdlResourcesData.horizontalSpan = 3;
		this.wsdlResources.setLayoutData(wsdlResourcesData);
		this.wsdlResources.setLowerBound(0);
		this.wsdlResources.setUpperBound(-1);
		wsdlResources.setID(EsbViewsRepository.ProxyService.Properties.wsdlResources);
		wsdlResources.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createWsdlResourcesAdvancedTableComposition

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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.name);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.pinnedServers);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.serviceGroup);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.traceEnabled);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.statisticsEnabled);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.startOnLoad);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.transports);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.securityEnabled);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initServiceParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initServiceParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		serviceParameters.setContentProvider(contentProvider);
		serviceParameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.serviceParameters);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart#initServicePolicies(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initServicePolicies(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		servicePolicies.setContentProvider(contentProvider);
		servicePolicies.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.servicePolicies);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.inSequenceType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.inSequenceType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.inSequenceName);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.outSequenceType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.outSequenceType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.outSequenceName);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.faultSequenceType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.faultSequenceType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.faultSequenceName);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.endpointType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.endpointType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.endpointName);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.wsdlType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.wsdlType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.preservePolicy);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.wsdlXML);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.wsdlURL);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyService.Properties.wsdlResources);
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
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ProxyService_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
