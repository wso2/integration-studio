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
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class SynapseAPIPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SynapseAPIPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Text apiName;
	protected Text context;
	protected Text hostName;
	protected Text port;
	protected ReferencesTable resources;
	protected List<ViewerFilter> resourcesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> resourcesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable handlers;
	protected List<ViewerFilter> handlersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> handlersFilters = new ArrayList<ViewerFilter>();
	protected Button traceEnabled;
	protected Button statisticsEnabled;
	protected Text version;
	protected EMFComboViewer versionType;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SynapseAPIPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence synapseAPIStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = synapseAPIStep.addStep(EsbViewsRepository.SynapseAPI.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.apiName);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.context);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.hostName);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.port);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.resources);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.handlers);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.traceEnabled);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.statisticsEnabled);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.version);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Properties.versionType);
		
		
		composer = new PartComposer(synapseAPIStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.SynapseAPI.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.apiName) {
					return createApiNameText(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.context) {
					return createContextText(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.hostName) {
					return createHostNameText(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.port) {
					return createPortText(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.resources) {
					return createResourcesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.handlers) {
					return createHandlersAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.traceEnabled) {
					return createTraceEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.statisticsEnabled) {
					return createStatisticsEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.version) {
					return createVersionText(parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Properties.versionType) {
					return createVersionTypeEMFComboViewer(parent);
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
		propertiesGroup.setText(EsbMessages.SynapseAPIPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.SynapseAPI.Properties.description, EsbMessages.SynapseAPIPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.SynapseAPI.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.SynapseAPI.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.SynapseAPI.Properties.commentsList, EsbMessages.SynapseAPIPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "SynapseAPI", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.SynapseAPI.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createApiNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.SynapseAPI.Properties.apiName, EsbMessages.SynapseAPIPropertiesEditionPart_ApiNameLabel);
		apiName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData apiNameData = new GridData(GridData.FILL_HORIZONTAL);
		apiName.setLayoutData(apiNameData);
		apiName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.apiName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, apiName.getText()));
			}

		});
		apiName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.apiName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, apiName.getText()));
				}
			}

		});
		EditingUtils.setID(apiName, EsbViewsRepository.SynapseAPI.Properties.apiName);
		EditingUtils.setEEFtype(apiName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Properties.apiName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createApiNameText

		// End of user code
		return parent;
	}

	
	protected Composite createContextText(Composite parent) {
		createDescription(parent, EsbViewsRepository.SynapseAPI.Properties.context, EsbMessages.SynapseAPIPropertiesEditionPart_ContextLabel);
		context = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData contextData = new GridData(GridData.FILL_HORIZONTAL);
		context.setLayoutData(contextData);
		context.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.context, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, context.getText()));
			}

		});
		context.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.context, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, context.getText()));
				}
			}

		});
		EditingUtils.setID(context, EsbViewsRepository.SynapseAPI.Properties.context);
		EditingUtils.setEEFtype(context, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Properties.context, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createContextText

		// End of user code
		return parent;
	}

	
	protected Composite createHostNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.SynapseAPI.Properties.hostName, EsbMessages.SynapseAPIPropertiesEditionPart_HostNameLabel);
		hostName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData hostNameData = new GridData(GridData.FILL_HORIZONTAL);
		hostName.setLayoutData(hostNameData);
		hostName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.hostName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hostName.getText()));
			}

		});
		hostName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.hostName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hostName.getText()));
				}
			}

		});
		EditingUtils.setID(hostName, EsbViewsRepository.SynapseAPI.Properties.hostName);
		EditingUtils.setEEFtype(hostName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Properties.hostName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createHostNameText

		// End of user code
		return parent;
	}

	
	protected Composite createPortText(Composite parent) {
		createDescription(parent, EsbViewsRepository.SynapseAPI.Properties.port, EsbMessages.SynapseAPIPropertiesEditionPart_PortLabel);
		port = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData portData = new GridData(GridData.FILL_HORIZONTAL);
		port.setLayoutData(portData);
		port.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.port, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, port.getText()));
			}

		});
		port.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.port, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, port.getText()));
				}
			}

		});
		EditingUtils.setID(port, EsbViewsRepository.SynapseAPI.Properties.port);
		EditingUtils.setEEFtype(port, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Properties.port, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPortText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createResourcesAdvancedTableComposition(Composite parent) {
		this.resources = new ReferencesTable(getDescription(EsbViewsRepository.SynapseAPI.Properties.resources, EsbMessages.SynapseAPIPropertiesEditionPart_ResourcesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				resources.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				resources.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				resources.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				resources.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.resourcesFilters) {
			this.resources.addFilter(filter);
		}
		this.resources.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Properties.resources, EsbViewsRepository.SWT_KIND));
		this.resources.createControls(parent);
		this.resources.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.resources, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData resourcesData = new GridData(GridData.FILL_HORIZONTAL);
		resourcesData.horizontalSpan = 3;
		this.resources.setLayoutData(resourcesData);
		this.resources.setLowerBound(0);
		this.resources.setUpperBound(-1);
		resources.setID(EsbViewsRepository.SynapseAPI.Properties.resources);
		resources.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createResourcesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createHandlersAdvancedTableComposition(Composite parent) {
		this.handlers = new ReferencesTable(getDescription(EsbViewsRepository.SynapseAPI.Properties.handlers, EsbMessages.SynapseAPIPropertiesEditionPart_HandlersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.handlers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				handlers.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.handlers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				handlers.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.handlers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				handlers.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.handlers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				handlers.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.handlersFilters) {
			this.handlers.addFilter(filter);
		}
		this.handlers.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Properties.handlers, EsbViewsRepository.SWT_KIND));
		this.handlers.createControls(parent);
		this.handlers.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.handlers, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData handlersData = new GridData(GridData.FILL_HORIZONTAL);
		handlersData.horizontalSpan = 3;
		this.handlers.setLayoutData(handlersData);
		this.handlers.setLowerBound(0);
		this.handlers.setUpperBound(-1);
		handlers.setID(EsbViewsRepository.SynapseAPI.Properties.handlers);
		handlers.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createHandlersAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createTraceEnabledCheckbox(Composite parent) {
		traceEnabled = new Button(parent, SWT.CHECK);
		traceEnabled.setText(getDescription(EsbViewsRepository.SynapseAPI.Properties.traceEnabled, EsbMessages.SynapseAPIPropertiesEditionPart_TraceEnabledLabel));
		traceEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.traceEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(traceEnabled.getSelection())));
			}

		});
		GridData traceEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		traceEnabledData.horizontalSpan = 2;
		traceEnabled.setLayoutData(traceEnabledData);
		EditingUtils.setID(traceEnabled, EsbViewsRepository.SynapseAPI.Properties.traceEnabled);
		EditingUtils.setEEFtype(traceEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Properties.traceEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTraceEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createStatisticsEnabledCheckbox(Composite parent) {
		statisticsEnabled = new Button(parent, SWT.CHECK);
		statisticsEnabled.setText(getDescription(EsbViewsRepository.SynapseAPI.Properties.statisticsEnabled, EsbMessages.SynapseAPIPropertiesEditionPart_StatisticsEnabledLabel));
		statisticsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.statisticsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statisticsEnabled.getSelection())));
			}

		});
		GridData statisticsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		statisticsEnabledData.horizontalSpan = 2;
		statisticsEnabled.setLayoutData(statisticsEnabledData);
		EditingUtils.setID(statisticsEnabled, EsbViewsRepository.SynapseAPI.Properties.statisticsEnabled);
		EditingUtils.setEEFtype(statisticsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Properties.statisticsEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatisticsEnabledCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createVersionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.SynapseAPI.Properties.version, EsbMessages.SynapseAPIPropertiesEditionPart_VersionLabel);
		version = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData versionData = new GridData(GridData.FILL_HORIZONTAL);
		version.setLayoutData(versionData);
		version.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.version, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, version.getText()));
			}

		});
		version.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.version, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, version.getText()));
				}
			}

		});
		EditingUtils.setID(version, EsbViewsRepository.SynapseAPI.Properties.version);
		EditingUtils.setEEFtype(version, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Properties.version, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createVersionText

		// End of user code
		return parent;
	}

	
	protected Composite createVersionTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.SynapseAPI.Properties.versionType, EsbMessages.SynapseAPIPropertiesEditionPart_VersionTypeLabel);
		versionType = new EMFComboViewer(parent);
		versionType.setContentProvider(new ArrayContentProvider());
		versionType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData versionTypeData = new GridData(GridData.FILL_HORIZONTAL);
		versionType.getCombo().setLayoutData(versionTypeData);
		versionType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartImpl.this, EsbViewsRepository.SynapseAPI.Properties.versionType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVersionType()));
			}

		});
		versionType.setID(EsbViewsRepository.SynapseAPI.Properties.versionType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Properties.versionType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createVersionTypeEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#getApiName()
	 * 
	 */
	public String getApiName() {
		return apiName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#setApiName(String newValue)
	 * 
	 */
	public void setApiName(String newValue) {
		if (newValue != null) {
			apiName.setText(newValue);
		} else {
			apiName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.apiName);
		if (eefElementEditorReadOnlyState && apiName.isEnabled()) {
			apiName.setEnabled(false);
			apiName.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !apiName.isEnabled()) {
			apiName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#getContext()
	 * 
	 */
	public String getContext() {
		return context.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#setContext(String newValue)
	 * 
	 */
	public void setContext(String newValue) {
		if (newValue != null) {
			context.setText(newValue);
		} else {
			context.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.context);
		if (eefElementEditorReadOnlyState && context.isEnabled()) {
			context.setEnabled(false);
			context.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !context.isEnabled()) {
			context.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#getHostName()
	 * 
	 */
	public String getHostName() {
		return hostName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#setHostName(String newValue)
	 * 
	 */
	public void setHostName(String newValue) {
		if (newValue != null) {
			hostName.setText(newValue);
		} else {
			hostName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.hostName);
		if (eefElementEditorReadOnlyState && hostName.isEnabled()) {
			hostName.setEnabled(false);
			hostName.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !hostName.isEnabled()) {
			hostName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#getPort()
	 * 
	 */
	public String getPort() {
		return port.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#setPort(String newValue)
	 * 
	 */
	public void setPort(String newValue) {
		if (newValue != null) {
			port.setText(newValue);
		} else {
			port.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.port);
		if (eefElementEditorReadOnlyState && port.isEnabled()) {
			port.setEnabled(false);
			port.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !port.isEnabled()) {
			port.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#initResources(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initResources(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		resources.setContentProvider(contentProvider);
		resources.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.resources);
		if (eefElementEditorReadOnlyState && resources.isEnabled()) {
			resources.setEnabled(false);
			resources.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resources.isEnabled()) {
			resources.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#updateResources()
	 * 
	 */
	public void updateResources() {
	resources.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#addFilterResources(ViewerFilter filter)
	 * 
	 */
	public void addFilterToResources(ViewerFilter filter) {
		resourcesFilters.add(filter);
		if (this.resources != null) {
			this.resources.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#addBusinessFilterResources(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToResources(ViewerFilter filter) {
		resourcesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#isContainedInResourcesTable(EObject element)
	 * 
	 */
	public boolean isContainedInResourcesTable(EObject element) {
		return ((ReferencesTableSettings)resources.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#initHandlers(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initHandlers(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		handlers.setContentProvider(contentProvider);
		handlers.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.handlers);
		if (eefElementEditorReadOnlyState && handlers.isEnabled()) {
			handlers.setEnabled(false);
			handlers.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !handlers.isEnabled()) {
			handlers.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#updateHandlers()
	 * 
	 */
	public void updateHandlers() {
	handlers.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#addFilterHandlers(ViewerFilter filter)
	 * 
	 */
	public void addFilterToHandlers(ViewerFilter filter) {
		handlersFilters.add(filter);
		if (this.handlers != null) {
			this.handlers.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#addBusinessFilterHandlers(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToHandlers(ViewerFilter filter) {
		handlersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#isContainedInHandlersTable(EObject element)
	 * 
	 */
	public boolean isContainedInHandlersTable(EObject element) {
		return ((ReferencesTableSettings)handlers.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#getTraceEnabled()
	 * 
	 */
	public Boolean getTraceEnabled() {
		return Boolean.valueOf(traceEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#setTraceEnabled(Boolean newValue)
	 * 
	 */
	public void setTraceEnabled(Boolean newValue) {
		if (newValue != null) {
			traceEnabled.setSelection(newValue.booleanValue());
		} else {
			traceEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.traceEnabled);
		if (eefElementEditorReadOnlyState && traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(false);
			traceEnabled.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#getStatisticsEnabled()
	 * 
	 */
	public Boolean getStatisticsEnabled() {
		return Boolean.valueOf(statisticsEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#setStatisticsEnabled(Boolean newValue)
	 * 
	 */
	public void setStatisticsEnabled(Boolean newValue) {
		if (newValue != null) {
			statisticsEnabled.setSelection(newValue.booleanValue());
		} else {
			statisticsEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.statisticsEnabled);
		if (eefElementEditorReadOnlyState && statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(false);
			statisticsEnabled.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#getVersion()
	 * 
	 */
	public String getVersion() {
		return version.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#setVersion(String newValue)
	 * 
	 */
	public void setVersion(String newValue) {
		if (newValue != null) {
			version.setText(newValue);
		} else {
			version.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.version);
		if (eefElementEditorReadOnlyState && version.isEnabled()) {
			version.setEnabled(false);
			version.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !version.isEnabled()) {
			version.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#getVersionType()
	 * 
	 */
	public Enumerator getVersionType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) versionType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#initVersionType(Object input, Enumerator current)
	 */
	public void initVersionType(Object input, Enumerator current) {
		versionType.setInput(input);
		versionType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.versionType);
		if (eefElementEditorReadOnlyState && versionType.isEnabled()) {
			versionType.setEnabled(false);
			versionType.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !versionType.isEnabled()) {
			versionType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#setVersionType(Enumerator newValue)
	 * 
	 */
	public void setVersionType(Enumerator newValue) {
		versionType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Properties.versionType);
		if (eefElementEditorReadOnlyState && versionType.isEnabled()) {
			versionType.setEnabled(false);
			versionType.setToolTipText(EsbMessages.SynapseAPI_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !versionType.isEnabled()) {
			versionType.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.SynapseAPI_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
