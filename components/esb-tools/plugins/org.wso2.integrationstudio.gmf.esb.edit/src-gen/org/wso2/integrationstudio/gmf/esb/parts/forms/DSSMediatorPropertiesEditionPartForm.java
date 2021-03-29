/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts.forms;

import java.io.File;
// Start of user code for imports
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.components.DSSMediatorPropertiesEditionComponent;
import org.wso2.integrationstudio.artifact.dataserviceProject.artifact.DSSArtifact;
import org.wso2.integrationstudio.artifact.dataserviceProject.artifact.DSSProjectArtifact;
import org.wso2.integrationstudio.gmf.esb.AbstractDSSOperation;
import org.wso2.integrationstudio.gmf.esb.DSSOperationType;
import org.wso2.integrationstudio.gmf.esb.DSSSourceType;
import org.wso2.integrationstudio.gmf.esb.DSSTargetType;
import org.wso2.integrationstudio.gmf.esb.DSSoperationProperty;
import org.wso2.integrationstudio.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.gmf.esb.impl.AbstractDSSOperationImpl;
import org.wso2.integrationstudio.gmf.esb.impl.DSSMediatorImpl;

// End of user code

/**
 * 
 * 
 */
public class DSSMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, DSSMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text serviceName;
	protected EMFComboViewer sourceType;
	protected ReferencesTable operations;
	protected List<ViewerFilter> operationsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> operationsFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer targetType;
	protected Text targetProperty;
	protected EMFComboViewer operationType;
	private EMFComboViewer availableDataServices;
	
	// Start of user code  for payloadKey widgets declarations
	Composite propertiesGroup;
	protected Control[] serviceNameElements;
	protected Control[] descriptionElements;
	protected Control[] sourceTypeElements;
	protected Control[] operationTypeElements;
	protected Control[] operationsTableElements;
	protected Control[] targetPropertyElements;
	protected Control[] targetTypeElements;
	protected Control[] availableDataServicesElements;
	public static final String AVAILABLE_DSS_DEFAULT_VALUE = "Select from available Data Services";
	Map<String, File> dbsFileMap = new HashMap<String, File>();
	List<AbstractDSSOperation> operationList;
    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	// End of user code

	/**
	 * For {@link ISection} use only.
	 */
	public DSSMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DSSMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence dSSMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = dSSMediatorStep.addStep(EsbViewsRepository.DSSMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.availableDataServices);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.serviceName);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.sourceType);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.operationType);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.operations);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.targetType);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.targetProperty);
		propertiesStep.addStep(EsbViewsRepository.DSSMediator.Properties.description);

		
		composer = new PartComposer(dSSMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.DSSMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.serviceName) {
					return createServiceNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.availableDataServices) {
					return createAvailableDataServicesComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.sourceType) {
					return createSourceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.operationType) {
					return createOperationTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.operations) {
					return createOperationsTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.targetType) {
					return createTargetTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DSSMediator.Properties.targetProperty) {
					return createTargetPropertyText(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.DSSMediatorPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.DSSMediator.Properties.description, EsbMessages.DSSMediatorPropertiesEditionPart_DescriptionLabel);
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
							DSSMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DSSMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DSSMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DSSMediator.Properties.description,
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
									DSSMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.DSSMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] {descriptionLabel, description, descriptionHelp};
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
		EditingUtils.setID(commentsList, EsbViewsRepository.DSSMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.DSSMediator.Properties.commentsList, EsbMessages.DSSMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "DSSMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.DSSMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.DSSMediator.Properties.reverse, EsbMessages.DSSMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.DSSMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createServiceNameText(FormToolkit widgetFactory, Composite parent) {
		Control serviceNameLabel = createDescription(parent, EsbViewsRepository.DSSMediator.Properties.serviceName, EsbMessages.DSSMediatorPropertiesEditionPart_ServiceNameLabel);
		serviceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		serviceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData serviceNameData = new GridData(GridData.FILL_HORIZONTAL);
		serviceName.setLayoutData(serviceNameData);
		serviceName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DSSMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DSSMediator.Properties.serviceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DSSMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DSSMediator.Properties.serviceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, serviceName.getText()));
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
									DSSMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		serviceName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.serviceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceName.getText()));
				}
			}
		});
		EditingUtils.setID(serviceName, EsbViewsRepository.DSSMediator.Properties.serviceName);
		EditingUtils.setEEFtype(serviceName, "eef::Text"); //$NON-NLS-1$
		Control serviceNameHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.serviceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createServiceNameText
		serviceNameElements = new Control[] {serviceNameLabel,serviceName, serviceNameHelp};
		// End of user code
		return parent;
	}

	
	protected Composite createSourceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control sourceTypeLabel = createDescription(parent, EsbViewsRepository.DSSMediator.Properties.sourceType, EsbMessages.DSSMediatorPropertiesEditionPart_SourceTypeLabel);
		sourceType = new EMFComboViewer(parent);
		sourceType.setContentProvider(new ArrayContentProvider());
		sourceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sourceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		sourceType.getCombo().setLayoutData(sourceTypeData);
		sourceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.sourceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceType()));
			}

		});
		sourceType.setID(EsbViewsRepository.DSSMediator.Properties.sourceType);
		Control sourceTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.sourceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceTypeEMFComboViewer
		sourceTypeElements = new Control[] {sourceTypeLabel, sourceType.getCombo(), sourceTypeHelp};
		sourceType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });
		// End of user code
		return parent;
	}

	protected Composite createAvailableDataServicesComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control availableDataServicesLabel = createDescription(parent, EsbViewsRepository.DSSMediator.Properties.availableDataServices, EsbMessages.DSSMediatorPropertiesEditionPart_AvailableDataServicesLabel);
		availableDataServices = new EMFComboViewer(parent);
		availableDataServices.setContentProvider(new ArrayContentProvider());
		availableDataServices.setInput(getAvailableArtifactListFromProject(parent));

		availableDataServices.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData availableDataServicesdata = new GridData(GridData.FILL_HORIZONTAL);
		availableDataServices.getCombo().setLayoutData(availableDataServicesdata);
		availableDataServices.setID(EsbViewsRepository.DSSMediator.Properties.availableDataServices);
		Control availableDataServicesHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.availableDataServices, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceTypeEMFComboViewer
		availableDataServicesElements = new Control[] {availableDataServicesLabel, availableDataServices.getCombo(), availableDataServicesHelp};
		availableDataServices.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 
			 */
			public void selectionChanged(SelectionChangedEvent event) {

				if (propertiesEditionComponent != null)
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DSSMediator.Properties.availableDataServices,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
									getAvailableDataServices()));

				if (!(availableDataServices.getCombo().getText().isEmpty())
						&& !(availableDataServices.getCombo().getText().equals(AVAILABLE_DSS_DEFAULT_VALUE))) {

					String selectedDataService = availableDataServices.getCombo().getText();
					File dbsFile = dbsFileMap.get(selectedDataService);

					try {
						Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(dbsFile);
						doc.getDocumentElement().normalize();

						Element dataElement = (Element) doc.getElementsByTagName("data").item(0);
						NodeList operationNodeList = dataElement.getElementsByTagName("operation");

						operationList = new ArrayList<AbstractDSSOperation>();
						for (int i = 0; i < operationNodeList.getLength(); i++) {

							Node operationNode = operationNodeList.item(i);
							Element operationElement = (Element) operationNode;
							Element callQueryElement = (Element) operationElement.getElementsByTagName("call-query")
									.item(0);
							NodeList withParamList = callQueryElement.getElementsByTagName("with-param");

							AbstractDSSOperation visualOperation = EsbFactory.eINSTANCE.createAbstractDSSOperation();
							visualOperation.setOperationName(operationElement.getAttribute("name"));
							List<DSSoperationProperty> visualParamList = new ArrayList<DSSoperationProperty>();

							for (int j = 0; j < withParamList.getLength(); j++) {
								Element paramElement = (Element) withParamList.item(j);
								String paramName = paramElement.getAttribute("name");
								DSSoperationProperty visualProperty = EsbFactory.eINSTANCE.createDSSoperationProperty();
								visualProperty.setPropertyName(paramName);
								visualParamList.add(visualProperty);
							}
							AbstractDSSOperationImpl visualAbstractDSSOperation = (AbstractDSSOperationImpl) visualOperation;
							visualAbstractDSSOperation.eSet(EsbPackage.ABSTRACT_DSS_OPERATION__DSS_PRPERTIES,
									visualParamList);
							operationList.add(visualAbstractDSSOperation);
						}
					} catch (Exception e) {
						log.error(e);
					}
					DSSMediatorPropertiesEditionComponent dssEditionComponent = (DSSMediatorPropertiesEditionComponent) propertiesEditionComponent;
					DSSMediatorImpl dssMediatorModel = dssEditionComponent.getSymanticDssModel();
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(dssMediatorModel);
					domain.getCommandStack().execute(new RecordingCommand(domain) {

						@Override
						protected void doExecute() {
							// Implement your write operations here,
							// for example: set a new name
							if (operationList.size() > 1) {
								dssMediatorModel.setOperationType(DSSOperationType.REQUESTBOX);
							}
							dssMediatorModel.eSet(EsbPackage.DSS_MEDIATOR__OPERATIONS, operationList);
//				            element.eSet(element.eClass().getEStructuralFeature("name"), "aNewName");
						}
					});

					serviceName.setText(availableDataServices.getCombo().getText());
				}
			}
        });
		// End of user code
		return parent;
	}
	
	protected Composite createOperationTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control operationTypeLabel = createDescription(parent, EsbViewsRepository.DSSMediator.Properties.operationType, EsbMessages.DSSMediatorPropertiesEditionPart_OperationTypeLabel);
		operationType = new EMFComboViewer(parent);
		operationType.setContentProvider(new ArrayContentProvider());
		operationType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData operationTypeData = new GridData(GridData.FILL_HORIZONTAL);
		operationType.getCombo().setLayoutData(operationTypeData);
		operationType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.operationType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOperationType()));
			}

		});
		operationType.setID(EsbViewsRepository.DSSMediator.Properties.operationType);
		Control operationTypeHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.operationType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOperationTypeEMFComboViewer
		operationTypeElements = new Control[] {operationTypeLabel, operationType.getCombo(), operationTypeHelp};
		operationType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createOperationsTableComposition(FormToolkit widgetFactory, Composite parent) {
		Control[] previousControls = propertiesGroup.getChildren();
		this.operations = new ReferencesTable(getDescription(EsbViewsRepository.DSSMediator.Properties.operations, EsbMessages.DSSMediatorPropertiesEditionPart_OperationsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				operations.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				operations.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				operations.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				operations.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.operationsFilters) {
			this.operations.addFilter(filter);
		}
		this.operations.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.operations, EsbViewsRepository.FORM_KIND));
		this.operations.createControls(parent, widgetFactory);
		this.operations.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.operations, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData operationsData = new GridData(GridData.FILL_HORIZONTAL);
		operationsData.horizontalSpan = 3;
		this.operations.setLayoutData(operationsData);
		this.operations.setLowerBound(0);
		this.operations.setUpperBound(-1);
		operations.setID(EsbViewsRepository.DSSMediator.Properties.operations);
		operations.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createOperationsTableComposition
		Control[] newControls = propertiesGroup.getChildren();
		operationsTableElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	
	protected Composite createTargetTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control targetTypeCombo = createDescription(parent, EsbViewsRepository.DSSMediator.Properties.targetType, EsbMessages.DSSMediatorPropertiesEditionPart_TargetTypeLabel);
		targetType = new EMFComboViewer(parent);
		targetType.setContentProvider(new ArrayContentProvider());
		targetType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData targetTypeData = new GridData(GridData.FILL_HORIZONTAL);
		targetType.getCombo().setLayoutData(targetTypeData);
		targetType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.targetType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetType()));
			}

		});
		targetType.setID(EsbViewsRepository.DSSMediator.Properties.targetType);
		Control targetTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.targetType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetTypeEMFComboViewer
		targetTypeElements = new Control[] {targetTypeCombo, targetType.getCombo(), targetTypeHelp};
		// End of user code
		return parent;
	}

	
	protected Composite createTargetPropertyText(FormToolkit widgetFactory, Composite parent) {
		Control targetPropertyLabel = createDescription(parent, EsbViewsRepository.DSSMediator.Properties.targetProperty, EsbMessages.DSSMediatorPropertiesEditionPart_TargetPropertyLabel);
		targetProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		targetProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData targetPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		targetProperty.setLayoutData(targetPropertyData);
		targetProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DSSMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DSSMediator.Properties.targetProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DSSMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DSSMediator.Properties.targetProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, targetProperty.getText()));
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
									DSSMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		targetProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DSSMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DSSMediator.Properties.targetProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetProperty.getText()));
				}
			}
		});
		EditingUtils.setID(targetProperty, EsbViewsRepository.DSSMediator.Properties.targetProperty);
		EditingUtils.setEEFtype(targetProperty, "eef::Text"); //$NON-NLS-1$
		Control targetPropertyHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DSSMediator.Properties.targetProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetPropertyText
		targetPropertyElements = new Control[] {targetPropertyLabel, targetProperty, targetPropertyHelp};
		targetType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
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
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getServiceName()
	 * 
	 */
	public String getServiceName() {
		return serviceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setServiceName(String newValue)
	 * 
	 */
	public void setServiceName(String newValue) {
		if (newValue != null) {
			serviceName.setText(newValue);
		} else {
			serviceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.serviceName);
		if (eefElementEditorReadOnlyState && serviceName.isEnabled()) {
			serviceName.setEnabled(false);
			serviceName.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !serviceName.isEnabled()) {
			serviceName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getAvailableDataServices()
	 * 
	 */
	public String getAvailableDataServices() {
		return availableDataServices.getCombo().getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setAvailableDataServices(String newValue)
	 * 
	 */
	public void setAvailableDataServices(String newValue) {
		if (newValue != null) {
			availableDataServices.getCombo().setText(newValue);
		} else {
			availableDataServices.getCombo().setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.availableDataServices);
		if (eefElementEditorReadOnlyState && availableDataServices.isEnabled()) {
			availableDataServices.setEnabled(false);
			availableDataServices.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !availableDataServices.isEnabled()) {
			availableDataServices.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getSourceType()
	 * 
	 */
	public Enumerator getSourceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sourceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#initSourceType(Object input, Enumerator current)
	 */
	public void initSourceType(Object input, Enumerator current) {
		sourceType.setInput(input);
		sourceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.sourceType);
		if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
			sourceType.setEnabled(false);
			sourceType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
			sourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setSourceType(Enumerator newValue)
	 * 
	 */
	public void setSourceType(Enumerator newValue) {
		sourceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.sourceType);
		if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
			sourceType.setEnabled(false);
			sourceType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
			sourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getOperationType()
	 * 
	 */
	public Enumerator getOperationType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) operationType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#initOperationType(Object input, Enumerator current)
	 */
	public void initOperationType(Object input, Enumerator current) {
		operationType.setInput(input);
		operationType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.operationType);
		if (eefElementEditorReadOnlyState && operationType.isEnabled()) {
			operationType.setEnabled(false);
			operationType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operationType.isEnabled()) {
			operationType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setOperationType(Enumerator newValue)
	 * 
	 */
	public void setOperationType(Enumerator newValue) {
		operationType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.operationType);
		if (eefElementEditorReadOnlyState && operationType.isEnabled()) {
			operationType.setEnabled(false);
			operationType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operationType.isEnabled()) {
			operationType.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#initOperations(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOperations(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		operations.setContentProvider(contentProvider);
		operations.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.operations);
		if (eefElementEditorReadOnlyState && operations.isEnabled()) {
			operations.setEnabled(false);
			operations.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operations.isEnabled()) {
			operations.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#updateOperations()
	 * 
	 */
	public void updateOperations() {
	operations.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#addFilterOperations(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOperations(ViewerFilter filter) {
		operationsFilters.add(filter);
		if (this.operations != null) {
			this.operations.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#addBusinessFilterOperations(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOperations(ViewerFilter filter) {
		operationsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#isContainedInOperationsTable(EObject element)
	 * 
	 */
	public boolean isContainedInOperationsTable(EObject element) {
		return ((ReferencesTableSettings)operations.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getTargetType()
	 * 
	 */
	public Enumerator getTargetType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#initTargetType(Object input, Enumerator current)
	 */
	public void initTargetType(Object input, Enumerator current) {
		targetType.setInput(input);
		targetType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setTargetType(Enumerator newValue)
	 * 
	 */
	public void setTargetType(Enumerator newValue) {
		targetType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#getTargetProperty()
	 * 
	 */
	public String getTargetProperty() {
		return targetProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart#setTargetProperty(String newValue)
	 * 
	 */
	public void setTargetProperty(String newValue) {
		if (newValue != null) {
			targetProperty.setText(newValue);
		} else {
			targetProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DSSMediator.Properties.targetProperty);
		if (eefElementEditorReadOnlyState && targetProperty.isEnabled()) {
			targetProperty.setEnabled(false);
			targetProperty.setToolTipText(EsbMessages.DSSMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetProperty.isEnabled()) {
			targetProperty.setEnabled(true);
		}	
		
	}

	protected ArrayList<String> getAvailableArtifactListFromProject(Composite parent) {

        String synapseArtifcatCategory = "service/dataservice";
        String comboBoxDefaultValue = AVAILABLE_DSS_DEFAULT_VALUE;
        ArrayList<String> availableList = new ArrayList<String>();
        availableList.add(comboBoxDefaultValue);
        File projectPath = null;
        final Shell shell = (Shell) parent.getShell();
        final IEditorPart editor = (IEditorPart) ((WorkbenchWindow) shell.getDisplay().getActiveShell().getData())
                .getActivePage().getActiveEditor();
        if (editor != null) {
            // IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
            // IFile file = input.getFile();
            // IProject workspaceProject = file.getProject();

            // Fixing TOOLS-2322
            IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
            for (IProject workspaceProject : projects) {
                try {
                    if (workspaceProject.hasNature("org.wso2.developerstudio.eclipse.ds.project.nature")) {
                    	DSSProjectArtifact dssProjectArtifact = new DSSProjectArtifact();
                        projectPath = workspaceProject.getLocation().toFile();
                        try {
                            dssProjectArtifact
                                    .fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
                            List<DSSArtifact> allDSSArtifacts = dssProjectArtifact.getAllDSSArtifacts();
                            for (DSSArtifact dssArtifact : allDSSArtifacts) {
                                if (synapseArtifcatCategory.equals(dssArtifact.getType())) {
                                    File artifact = new File(projectPath, dssArtifact.getFile());
                                    String dbsName = artifact.getName().replaceAll("[.]dbs$", "");
                                    availableList.add(dbsName);
                                    dbsFileMap.put(dbsName, artifact);
                                }
                            }
                        } catch (Exception e) {
                            ErrorDialog.openError(shell, "Error occured while scanning the project for "
                                    + synapseArtifcatCategory + " artifacts", e.getMessage(), 
                                    new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
                        }
                    }
                } catch (CoreException e) {
                    ErrorDialog.openError(shell, "Error occured while scanning the project", e.getMessage(), 
                    		new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
                }
            }
        }
        return availableList;
    }





	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.DSSMediator_Part_Title;
	}

	// Start of user code additional methods
	@Override
    public void refresh() {
        super.refresh();
        validate();
    }
    
    public void validate() {
        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { propertiesGroup });
        
        eu.showEntry(serviceNameElements, false);
        eu.showEntry(descriptionElements, false);
        eu.showEntry(sourceTypeElements, false);
        eu.showEntry(operationTypeElements, false);
        eu.showEntry(availableDataServicesElements, false);

		if (getSourceType().getName().equals(DSSSourceType.INLINE.getName())) {
			eu.showEntry(operationsTableElements, false);
			
		}
        eu.showEntry(targetTypeElements, false);
		if (getTargetType().getName().equals(DSSTargetType.PROPERTY.getName())) {
			eu.showEntry(targetPropertyElements, false);
		}
        // Sets a default XML value. If not, parsing to XML fails and is unable to load the source view
        
        view.layout(true, true);
    }
	
    
	// End of user code
	// End of user code


}
