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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
import org.wso2.developerstudio.eclipse.gmf.esb.APIVersionType;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class SynapseAPIPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SynapseAPIPropertiesEditionPart {

	protected ReferencesTable handlers;
	protected List<ViewerFilter> handlersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> handlersFilters = new ArrayList<ViewerFilter>();
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
	protected EMFComboViewer versionType;
	protected Text version;
	protected Button traceEnabled;
	protected Button statisticsEnabled;
	protected Text description;
	
	// Start of user code for additional parameters
	protected Composite propertiesGroup;
	
	protected Control[] apiNameElements;
	protected Control[] contextElements;
	protected Control[] hostNameElements;
	protected Control[] portElements;
	protected Control[] traceEnabledElements;
	protected Control[] statisticEnabledElements;
	protected Control[] versionTypeElements;
	protected Control[] versionElements;
	protected Control[] descriptionElements;
	protected Control[] publishSwaggerElements;
	
	protected RegistryKeyProperty publishSwagger;
	protected Text publishSwaggerText;
	
	// End of user code


	/**
	 * For {@link ISection} use only.
	 */
	public SynapseAPIPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SynapseAPIPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence synapseAPIStep = new BindingCompositionSequence(propertiesEditionComponent);
		
		CompositionStep propertiesStep = synapseAPIStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.apiName);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.context);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.publishSwagger);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.hostName);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.port);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.resources);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.versionType);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.version);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled);
		propertiesStep.addStep(EsbViewsRepository.SynapseAPI.Handler.Properties.description);
		
		CompositionStep handlerStep = synapseAPIStep.addStep(EsbViewsRepository.SynapseAPI.Handler.class);
		handlerStep.addStep(EsbViewsRepository.SynapseAPI.Handler.handlers);
		
		composer = new PartComposer(synapseAPIStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.SynapseAPI.Handler.class) {
					return createHandlerGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.handlers) {
					return createHandlersTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.apiName) {
					return createApiNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.context) {
					return createContextText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.publishSwagger) {
					return createPublishSwaggerWidget(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.hostName) {
					return createHostNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.port) {
					return createPortText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.resources) {
					return createResourcesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.versionType) {
					return createVersionTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.version) {
					return createVersionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled) {
					return createTraceEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled) {
					return createStatisticsEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SynapseAPI.Handler.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createHandlerGroup(FormToolkit widgetFactory, final Composite parent) {
		Section handlerSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		handlerSection.setText(EsbMessages.SynapseAPIPropertiesEditionPart_HandlerGroupLabel);
		GridData handlerSectionData = new GridData(GridData.FILL_HORIZONTAL);
		handlerSectionData.horizontalSpan = 3;
		handlerSection.setLayoutData(handlerSectionData);
		Composite handlerGroup = widgetFactory.createComposite(handlerSection);
		GridLayout handlerGroupLayout = new GridLayout();
		handlerGroupLayout.numColumns = 3;
		handlerGroup.setLayout(handlerGroupLayout);
		handlerSection.setClient(handlerGroup);
		return handlerGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createHandlersTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.handlers = new ReferencesTable(getDescription(EsbViewsRepository.SynapseAPI.Handler.handlers, EsbMessages.SynapseAPIPropertiesEditionPart_HandlersLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.handlers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				handlers.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.handlers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				handlers.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.handlers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				handlers.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.handlers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				handlers.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.handlersFilters) {
			this.handlers.addFilter(filter);
		}
		this.handlers.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Handler.handlers, EsbViewsRepository.FORM_KIND));
		this.handlers.createControls(parent, widgetFactory);
		this.handlers.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.handlers, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData handlersData = new GridData(GridData.FILL_HORIZONTAL);
		handlersData.horizontalSpan = 3;
		this.handlers.setLayoutData(handlersData);
		this.handlers.setLowerBound(0);
		this.handlers.setUpperBound(-1);
		handlers.setID(EsbViewsRepository.SynapseAPI.Handler.handlers);
		handlers.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createHandlersTableComposition

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.SynapseAPIPropertiesEditionPart_PropertiesGroupLabel);
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
	 * 
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList, EsbMessages.SynapseAPIPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createApiNameText(FormToolkit widgetFactory, Composite parent) {
		Control apiNameLabel = createDescription(parent, EsbViewsRepository.SynapseAPI.Handler.Properties.apiName, EsbMessages.SynapseAPIPropertiesEditionPart_ApiNameLabel);
		apiName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		apiName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData apiNameData = new GridData(GridData.FILL_HORIZONTAL);
		apiName.setLayoutData(apiNameData);
		apiName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SynapseAPIPropertiesEditionPartForm.this,
							EsbViewsRepository.SynapseAPI.Handler.Properties.apiName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, apiName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SynapseAPIPropertiesEditionPartForm.this,
									EsbViewsRepository.SynapseAPI.Handler.Properties.apiName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, apiName.getText()));
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
									SynapseAPIPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		apiName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.apiName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, apiName.getText()));
				}
			}
		});
		EditingUtils.setID(apiName, EsbViewsRepository.SynapseAPI.Handler.Properties.apiName);
		EditingUtils.setEEFtype(apiName, "eef::Text"); //$NON-NLS-1$
		Control apiNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Handler.Properties.apiName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createApiNameText
		apiNameElements = new Control[] {apiNameLabel, apiName, apiNameHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createContextText(FormToolkit widgetFactory, Composite parent) {
		Control contextLabel = createDescription(parent, EsbViewsRepository.SynapseAPI.Handler.Properties.context, EsbMessages.SynapseAPIPropertiesEditionPart_ContextLabel);
		context = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		context.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData contextData = new GridData(GridData.FILL_HORIZONTAL);
		context.setLayoutData(contextData);
		context.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SynapseAPIPropertiesEditionPartForm.this,
							EsbViewsRepository.SynapseAPI.Handler.Properties.context,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, context.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SynapseAPIPropertiesEditionPartForm.this,
									EsbViewsRepository.SynapseAPI.Handler.Properties.context,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, context.getText()));
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
									SynapseAPIPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		context.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.context, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, context.getText()));
				}
			}
		});
		EditingUtils.setID(context, EsbViewsRepository.SynapseAPI.Handler.Properties.context);
		EditingUtils.setEEFtype(context, "eef::Text"); //$NON-NLS-1$
		Control contextHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Handler.Properties.context, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createContextText
		contextElements = new Control[] {contextLabel, context, contextHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createHostNameText(FormToolkit widgetFactory, Composite parent) {
		Control hostLabel = createDescription(parent, EsbViewsRepository.SynapseAPI.Handler.Properties.hostName, EsbMessages.SynapseAPIPropertiesEditionPart_HostNameLabel);
		hostName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		hostName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData hostNameData = new GridData(GridData.FILL_HORIZONTAL);
		hostName.setLayoutData(hostNameData);
		hostName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SynapseAPIPropertiesEditionPartForm.this,
							EsbViewsRepository.SynapseAPI.Handler.Properties.hostName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hostName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SynapseAPIPropertiesEditionPartForm.this,
									EsbViewsRepository.SynapseAPI.Handler.Properties.hostName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, hostName.getText()));
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
									SynapseAPIPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		hostName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.hostName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hostName.getText()));
				}
			}
		});
		EditingUtils.setID(hostName, EsbViewsRepository.SynapseAPI.Handler.Properties.hostName);
		EditingUtils.setEEFtype(hostName, "eef::Text"); //$NON-NLS-1$
		Control hostHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Handler.Properties.hostName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createHostNameText
		hostNameElements = new Control[] {hostLabel, hostName, hostHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPortText(FormToolkit widgetFactory, Composite parent) {
		Control portLabel = createDescription(parent, EsbViewsRepository.SynapseAPI.Handler.Properties.port, EsbMessages.SynapseAPIPropertiesEditionPart_PortLabel);
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
							SynapseAPIPropertiesEditionPartForm.this,
							EsbViewsRepository.SynapseAPI.Handler.Properties.port,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, port.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SynapseAPIPropertiesEditionPartForm.this,
									EsbViewsRepository.SynapseAPI.Handler.Properties.port,
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
									SynapseAPIPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.port, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, port.getText()));
				}
			}
		});
		EditingUtils.setID(port, EsbViewsRepository.SynapseAPI.Handler.Properties.port);
		EditingUtils.setEEFtype(port, "eef::Text"); //$NON-NLS-1$
		Control portHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Handler.Properties.port, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPortText
		portElements = new Control[] {portLabel, port, portHelp};
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createResourcesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.resources = new ReferencesTable(getDescription(EsbViewsRepository.SynapseAPI.Handler.Properties.resources, EsbMessages.SynapseAPIPropertiesEditionPart_ResourcesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				resources.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				resources.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				resources.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				resources.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.resourcesFilters) {
			this.resources.addFilter(filter);
		}
		this.resources.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Handler.Properties.resources, EsbViewsRepository.FORM_KIND));
		this.resources.createControls(parent, widgetFactory);
		this.resources.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.resources, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData resourcesData = new GridData(GridData.FILL_HORIZONTAL);
		resourcesData.horizontalSpan = 3;
		this.resources.setLayoutData(resourcesData);
		this.resources.setLowerBound(0);
		this.resources.setUpperBound(-1);
		resources.setID(EsbViewsRepository.SynapseAPI.Handler.Properties.resources);
		resources.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createResourcesTableComposition

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */	
	protected Composite createVersionTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control versionTypeLabel = createDescription(parent, EsbViewsRepository.SynapseAPI.Handler.Properties.versionType, EsbMessages.SynapseAPIPropertiesEditionPart_VersionTypeLabel);
		versionType = new EMFComboViewer(parent);
		versionType.setContentProvider(new ArrayContentProvider());
		versionType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData versionTypeData = new GridData(GridData.FILL_HORIZONTAL);
		versionType.getCombo().setLayoutData(versionTypeData);
                versionType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		versionType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			    if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.versionType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVersionType()));
			    refresh();
			}

		});
		versionType.setID(EsbViewsRepository.SynapseAPI.Handler.Properties.versionType);
		Control versionTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Handler.Properties.versionType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createVersionTypeEMFComboViewer
		versionTypeElements = new Control[] {versionTypeLabel, versionType.getCombo(), versionTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createVersionText(FormToolkit widgetFactory, Composite parent) {
		Control versionLabel = createDescription(parent, EsbViewsRepository.SynapseAPI.Handler.Properties.version, EsbMessages.SynapseAPIPropertiesEditionPart_VersionLabel);
		version = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		version.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData versionData = new GridData(GridData.FILL_HORIZONTAL);
		version.setLayoutData(versionData);
		version.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SynapseAPIPropertiesEditionPartForm.this,
							EsbViewsRepository.SynapseAPI.Handler.Properties.version,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, version.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SynapseAPIPropertiesEditionPartForm.this,
									EsbViewsRepository.SynapseAPI.Handler.Properties.version,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, version.getText()));
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
									SynapseAPIPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		version.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.version, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, version.getText()));
				}
			}
		});
		EditingUtils.setID(version, EsbViewsRepository.SynapseAPI.Handler.Properties.version);
		EditingUtils.setEEFtype(version, "eef::Text"); //$NON-NLS-1$
		Control versionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Handler.Properties.version, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createVersionText
		versionElements = new Control[] {versionLabel, version, versionHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createTraceEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		traceEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled, EsbMessages.SynapseAPIPropertiesEditionPart_TraceEnabledLabel), SWT.CHECK);
		traceEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(traceEnabled.getSelection())));
			}

		});
		GridData traceEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		traceEnabledData.horizontalSpan = 2;
		traceEnabled.setLayoutData(traceEnabledData);
		EditingUtils.setID(traceEnabled, EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled);
		EditingUtils.setEEFtype(traceEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control traceEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTraceEnabledCheckbox
		traceEnabledElements = new Control[] {traceEnabled, traceEnabledHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createStatisticsEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		statisticsEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled, EsbMessages.SynapseAPIPropertiesEditionPart_StatisticsEnabledLabel), SWT.CHECK);
		statisticsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statisticsEnabled.getSelection())));
			}

		});
		GridData statisticsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		statisticsEnabledData.horizontalSpan = 2;
		statisticsEnabled.setLayoutData(statisticsEnabledData);
		EditingUtils.setID(statisticsEnabled, EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled);
		EditingUtils.setEEFtype(statisticsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control statisticsEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatisticsEnabledCheckbox
		statisticEnabledElements = new Control[] {statisticsEnabled, statisticsEnabledHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.SynapseAPI.Handler.Properties.description, EsbMessages.SynapseAPIPropertiesEditionPart_DescriptionLabel);
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
							SynapseAPIPropertiesEditionPartForm.this,
							EsbViewsRepository.SynapseAPI.Handler.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SynapseAPIPropertiesEditionPartForm.this,
									EsbViewsRepository.SynapseAPI.Handler.Properties.description,
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
									SynapseAPIPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this, EsbViewsRepository.SynapseAPI.Handler.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.SynapseAPI.Handler.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SynapseAPI.Handler.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] {descriptionLabel, description, descriptionHelp};
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart#initHandlers(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initHandlers(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		handlers.setContentProvider(contentProvider);
		handlers.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.handlers);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.apiName);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.context);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.hostName);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.port);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.resources);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.versionType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.versionType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.version);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SynapseAPI.Handler.Properties.description);
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
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.SynapseAPI_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createPublishSwaggerWidget(FormToolkit widgetFactory, Composite parent) {
		Control publishSwaggerLabel = createDescription(parent,
				EsbViewsRepository.SynapseAPI.Handler.Properties.publishSwagger, EsbMessages.SynapseAPIPropertiesEditionPart_PublishSwaggerLabel);
		widgetFactory.paintBordersFor(parent);
		if (publishSwagger == null) {
			publishSwagger = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = publishSwagger.getKeyValue().isEmpty() ? ""
				: publishSwagger.getKeyValue();
		publishSwaggerText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
		publishSwaggerText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		publishSwaggerText.setLayoutData(valueData);
		publishSwaggerText.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDown(MouseEvent event) {
				EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
						SWT.NULL, publishSwagger, new ArrayList<NamedEntityDescriptor>());
				dialog.open();
				publishSwaggerText.setText(publishSwagger.getKeyValue());
				propertiesEditionComponent.firePropertiesChanged(
						new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this,
								EsbViewsRepository.SynapseAPI.Handler.Properties.publishSwagger,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
								getPublishSwagger()));
			}

		});

		publishSwaggerText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
							SWT.NULL, publishSwagger, new ArrayList<NamedEntityDescriptor>());
					dialog.open();
					publishSwaggerText.setText(publishSwagger.getKeyValue());
					propertiesEditionComponent.firePropertiesChanged(
							new PropertiesEditionEvent(SynapseAPIPropertiesEditionPartForm.this,
									EsbViewsRepository.SynapseAPI.Handler.Properties.publishSwagger,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
									getPublishSwagger()));
				}
			}

		});
		EditingUtils.setID(publishSwaggerText,
				EsbViewsRepository.SynapseAPI.Handler.Properties.publishSwagger);
		EditingUtils.setEEFtype(publishSwaggerText, "eef::Text");
		Control publishSwaggerHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(
						EsbViewsRepository.SynapseAPI.Handler.Properties.publishSwagger,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		publishSwaggerElements = new Control[] { publishSwaggerLabel,
				publishSwaggerText, publishSwaggerHelp };
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

        eu.showEntry(apiNameElements, false);
        eu.showEntry(contextElements, false);
        eu.showEntry(publishSwaggerElements, false);
        eu.showEntry(hostNameElements, false);
        eu.showEntry(portElements, false);
        eu.showEntry(versionTypeElements, false);

        if (getVersionType() != null && !getVersionType().getName().equals(APIVersionType.NONE.getName())) {
            eu.showEntry(versionElements, false);
        }
        eu.showEntry(traceEnabledElements, false);
        eu.showEntry(statisticEnabledElements, false);
        eu.showEntry(descriptionElements, false);
        
        view.layout(true, true);
    }

	@Override
	public void setPublishSwagger(RegistryKeyProperty registryKeyProperty) {
		if (registryKeyProperty != null) {
			publishSwaggerText.setText(registryKeyProperty.getKeyValue());
			publishSwagger = registryKeyProperty;
		}
	}

	@Override
	public RegistryKeyProperty getPublishSwagger() {
		return publishSwagger;
	}
	
	// End of user code


}
