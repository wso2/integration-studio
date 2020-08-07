/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.io.IOException;
import java.net.URISyntaxException;
// Start of user code for imports
import java.util.ArrayList;
import java.util.HashMap;
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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.ConnectorParameterRenderer;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.ConnectorSchemaHolder;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.ReferenceGroup;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

// End of user code

/**
 * 
 * 
 */
public class CloudConnectorOperationPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, CloudConnectorOperationPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected ReferencesTable connectorParameters;
	protected List<ViewerFilter> connectorParametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> connectorParametersFilters = new ArrayList<ViewerFilter>();
	protected Text configRef;
	protected Text connectorName;
	protected Text operationName;
	protected Text cloudConnectorName;
	protected Text availableConfigs;
	protected EMFComboViewer parameterEditorType;
	protected Browser browser;

    // Start of user code
    protected Composite propertiesGroup;
    protected Control[] reverseElements;
    protected Control[] commentsElements;
    protected Control[] configRefElements;
    protected Control[] availableConfigsElements;
    protected Control[] connectorParamElements;
    protected Composite filterConfigSubPropertiesGroup;
    private boolean hasConnectorSchema;
    protected CLabel infoLabel;
    private static IDeveloperStudioLog log = Logger.getLog(EEFPropertyViewUtil.PLUGIN_ID);
    private ConnectorParameterRenderer propertyRenderer;
    // End of user code

	/**
	 * For {@link ISection} use only.
	 */
	public CloudConnectorOperationPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CloudConnectorOperationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 * @generated NOT
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
	    String schemaName = EEFPropertyViewUtil.generateSchemaName(propertiesEditionComponent);
        if(ConnectorSchemaHolder.getInstance().hasConnectorOperationSchema(schemaName)
                && (!EEFPropertyViewUtil.isLegacyPropertiesViewSet())) {
	        hasConnectorSchema = true;
	    } else {
	        hasConnectorSchema = false;
	    }
	    Form form = widgetFactory.createForm(parent);
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
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
		CompositionSequence cloudConnectorOperationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = cloudConnectorOperationStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.class);
		if(hasConnectorSchema) {
		    propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters);
		} else {
//	        propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.connectorName);
//	      propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.operationName);
//	      propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName);
	      propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType);
	      propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.configRef);
	      propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs);
	      propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters);
	      propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.description);
		}
		//propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.commentsList);
		//propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.reverse);
//		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.connectorName);
//		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.operationName);
//		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName);
//		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType);
//		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.configRef);
//		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs);
//		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters);
//		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.description);

		composer = new PartComposer(cloudConnectorOperationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters) {
					return createConnectorParametersTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.configRef) {
					return createConfigRefText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.connectorName) {
					return createConnectorNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.operationName) {
					return createOperationNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName) {
					return createCloudConnectorNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs) {
					return createAvailableConfigsText(widgetFactory, filterConfigSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType) {
					return createParameterEditorTypeEMFComboViewer(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * @generated NOT
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
	    if(hasConnectorSchema) {
	        propertiesGroup = new Composite(parent, SWT.TRANSPARENT);
            propertiesGroup.setLocation(0, 0);
            GridLayout propertiesGroupLayout = new GridLayout();
            propertiesGroupLayout.numColumns = 1;
            propertiesGroupLayout.horizontalSpacing = 0;
    		propertiesGroup.setLayout(propertiesGroupLayout);
    		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
    		propertiesSectionData.horizontalSpan = 3;
    		propertiesGroup.setLayoutData(propertiesSectionData);
	    } else {
	        Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
	        propertiesSection.setText(EsbMessages.CloudConnectorOperationPropertiesEditionPart_PropertiesGroupLabel);
	        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
	        propertiesSectionData.horizontalSpan = 3;
	        propertiesSection.setLayoutData(propertiesSectionData);
	        propertiesGroup = widgetFactory.createComposite(propertiesSection);
	        GridLayout propertiesGroupLayout = new GridLayout();
	        propertiesGroupLayout.numColumns = 3;
	        propertiesGroup.setLayout(propertiesGroupLayout);
	        propertiesSection.setClient(propertiesGroup);
	    }
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.description, EsbMessages.CloudConnectorOperationPropertiesEditionPart_DescriptionLabel);
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
							CloudConnectorOperationPropertiesEditionPartForm.this,
							EsbViewsRepository.CloudConnectorOperation.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CloudConnectorOperationPropertiesEditionPartForm.this,
									EsbViewsRepository.CloudConnectorOperation.Properties.description,
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
									CloudConnectorOperationPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.CloudConnectorOperation.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.CloudConnectorOperation.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CloudConnectorOperation.Properties.commentsList, EsbMessages.CloudConnectorOperationPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "CloudConnectorOperation", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.CloudConnectorOperation.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor
		Control[] newControls = propertiesGroup.getChildren();
		commentsElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CloudConnectorOperation.Properties.reverse, EsbMessages.CloudConnectorOperationPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.CloudConnectorOperation.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox
		Control[] newControls = propertiesGroup.getChildren();
		reverseElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createConnectorParametersTableComposition(FormToolkit widgetFactory, Composite parent) {
	     // Start of user code for createConnectorParametersTableComposition
        Control[] previousControls = propertiesGroup.getChildren();
	    if(hasConnectorSchema) {
            CloudConnectorOperationImpl connectorObject = (CloudConnectorOperationImpl)propertiesEditionComponent.getEditingContext().getEObject();
            String schemaName = connectorObject.getConnectorName().split("connector")[0] + "-" + connectorObject.getOperationName();
            propertyRenderer = new ConnectorParameterRenderer(propertiesEditionComponent, this);
            this.connectorParameters = new ReferenceGroup(getDescription(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, null),
                    propertyRenderer, schemaName);
            this.connectorParameters.createControls(parent, widgetFactory);
            connectorParameters.setID(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters);
            connectorParameters.setEEFType("eef::AdvancedTableComposition");
            infoLabel = new CLabel(propertiesGroup, SWT.NONE);
            Image image;
            try {
                image = new Image(parent.getShell().getDisplay(), EEFPropertyViewUtil.getIconPath("icons/full/obj16/check-icon-16x16.png"));
                infoLabel.setImage(image);
                infoLabel.setText("There are no errors");
            } catch (URISyntaxException | IOException e) {
                log.error("Error initializing properties view message banner", e);
            }

	    } else {
	        this.connectorParameters = new ReferencesTable(getDescription(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, EsbMessages.CloudConnectorOperationPropertiesEditionPart_ConnectorParametersLabel), new ReferencesTableListener() {
	            public void handleAdd() {
	                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
	                connectorParameters.refresh();
	            }
	            public void handleEdit(EObject element) {
	                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
	                connectorParameters.refresh();
	            }
	            public void handleMove(EObject element, int oldIndex, int newIndex) {
	                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
	                connectorParameters.refresh();
	            }
	            public void handleRemove(EObject element) {
	                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
	                connectorParameters.refresh();
	            }
	            public void navigateTo(EObject element) { }
	        });
	        for (ViewerFilter filter : this.connectorParametersFilters) {
	            this.connectorParameters.addFilter(filter);
	        }
	        this.connectorParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, EsbViewsRepository.FORM_KIND));
	        this.connectorParameters.createControls(parent, widgetFactory);
	        this.connectorParameters.addSelectionListener(new SelectionAdapter() {
	            
	            public void widgetSelected(SelectionEvent e) {
	                if (e.item != null && e.item.getData() instanceof EObject) {
	                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
	                }
	            }
	            
	        });
	        GridData connectorParametersData = new GridData(GridData.FILL_HORIZONTAL);
	        connectorParametersData.horizontalSpan = 3;
	        this.connectorParameters.setLayoutData(connectorParametersData);
	        this.connectorParameters.setLowerBound(0);
	        this.connectorParameters.setUpperBound(-1);
	        connectorParameters.setID(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters);
	        connectorParameters.setEEFType("eef::AdvancedTableComposition");
	    }
        Control[] newControls = propertiesGroup.getChildren();
        connectorParamElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createConfigRefText(FormToolkit widgetFactory, Composite parent) {
	        filterConfigSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Session",
                    true);
	        Control [] previousControls = filterConfigSubPropertiesGroup.getChildren();
		createDescription(filterConfigSubPropertiesGroup, EsbViewsRepository.CloudConnectorOperation.Properties.configRef, EsbMessages.CloudConnectorOperationPropertiesEditionPart_ConfigRefLabel);
		configRef = widgetFactory.createText(filterConfigSubPropertiesGroup, ""); //$NON-NLS-1$
		configRef.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		
		widgetFactory.paintBordersFor(filterConfigSubPropertiesGroup);
		GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
		configRef.setLayoutData(configRefData);
		configRef.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CloudConnectorOperationPropertiesEditionPartForm.this,
							EsbViewsRepository.CloudConnectorOperation.Properties.configRef,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, configRef.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CloudConnectorOperationPropertiesEditionPartForm.this,
									EsbViewsRepository.CloudConnectorOperation.Properties.configRef,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, configRef.getText()));
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
									CloudConnectorOperationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		configRef.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.configRef, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, configRef.getText()));
				}
			}
		});
		EditingUtils.setID(configRef, EsbViewsRepository.CloudConnectorOperation.Properties.configRef);
		EditingUtils.setEEFtype(configRef, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, filterConfigSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.configRef, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConfigRefText
	        Control [] newControls = filterConfigSubPropertiesGroup.getChildren();
	        configRefElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return filterConfigSubPropertiesGroup;
	}

	
	protected Composite createConnectorNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.connectorName, EsbMessages.CloudConnectorOperationPropertiesEditionPart_ConnectorNameLabel);
		connectorName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		connectorName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData connectorNameData = new GridData(GridData.FILL_HORIZONTAL);
		connectorName.setLayoutData(connectorNameData);
		connectorName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CloudConnectorOperationPropertiesEditionPartForm.this,
							EsbViewsRepository.CloudConnectorOperation.Properties.connectorName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectorName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CloudConnectorOperationPropertiesEditionPartForm.this,
									EsbViewsRepository.CloudConnectorOperation.Properties.connectorName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, connectorName.getText()));
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
									CloudConnectorOperationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		connectorName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectorName.getText()));
				}
			}
		});
		EditingUtils.setID(connectorName, EsbViewsRepository.CloudConnectorOperation.Properties.connectorName);
		EditingUtils.setEEFtype(connectorName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.connectorName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectorNameText

		// End of user code
		return parent;
	}

	
	protected Composite createOperationNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.operationName, EsbMessages.CloudConnectorOperationPropertiesEditionPart_OperationNameLabel);
		operationName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		operationName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData operationNameData = new GridData(GridData.FILL_HORIZONTAL);
		operationName.setLayoutData(operationNameData);
		operationName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CloudConnectorOperationPropertiesEditionPartForm.this,
							EsbViewsRepository.CloudConnectorOperation.Properties.operationName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, operationName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CloudConnectorOperationPropertiesEditionPartForm.this,
									EsbViewsRepository.CloudConnectorOperation.Properties.operationName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, operationName.getText()));
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
									CloudConnectorOperationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		operationName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.operationName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, operationName.getText()));
				}
			}
		});
		EditingUtils.setID(operationName, EsbViewsRepository.CloudConnectorOperation.Properties.operationName);
		EditingUtils.setEEFtype(operationName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.operationName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOperationNameText

		// End of user code
		return parent;
	}

	
	protected Composite createCloudConnectorNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName, EsbMessages.CloudConnectorOperationPropertiesEditionPart_CloudConnectorNameLabel);
		cloudConnectorName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		cloudConnectorName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData cloudConnectorNameData = new GridData(GridData.FILL_HORIZONTAL);
		cloudConnectorName.setLayoutData(cloudConnectorNameData);
		cloudConnectorName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CloudConnectorOperationPropertiesEditionPartForm.this,
							EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cloudConnectorName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CloudConnectorOperationPropertiesEditionPartForm.this,
									EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, cloudConnectorName.getText()));
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
									CloudConnectorOperationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		cloudConnectorName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cloudConnectorName.getText()));
				}
			}
		});
		EditingUtils.setID(cloudConnectorName, EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName);
		EditingUtils.setEEFtype(cloudConnectorName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCloudConnectorNameText

		// End of user code
		return parent;
	}

	
	protected Composite createAvailableConfigsText(FormToolkit widgetFactory, Composite parent) {
	        Control [] previousControls = filterConfigSubPropertiesGroup.getChildren();
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs, EsbMessages.CloudConnectorOperationPropertiesEditionPart_AvailableConfigsLabel);
		availableConfigs = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		availableConfigs.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData availableConfigsData = new GridData(GridData.FILL_HORIZONTAL);
		availableConfigs.setLayoutData(availableConfigsData);
		availableConfigs.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CloudConnectorOperationPropertiesEditionPartForm.this,
							EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, availableConfigs.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CloudConnectorOperationPropertiesEditionPartForm.this,
									EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, availableConfigs.getText()));
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
									CloudConnectorOperationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		availableConfigs.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, availableConfigs.getText()));
				}
			}
		});
		EditingUtils.setID(availableConfigs, EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs);
		EditingUtils.setEEFtype(availableConfigs, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAvailableConfigsText
	        Control [] newControls = filterConfigSubPropertiesGroup.getChildren();
	        availableConfigsElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createParameterEditorTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType, EsbMessages.CloudConnectorOperationPropertiesEditionPart_ParameterEditorTypeLabel);
		parameterEditorType = new EMFComboViewer(parent);
		parameterEditorType.setContentProvider(new ArrayContentProvider());
		parameterEditorType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData parameterEditorTypeData = new GridData(GridData.FILL_HORIZONTAL);
		parameterEditorType.getCombo().setLayoutData(parameterEditorTypeData);
                parameterEditorType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		parameterEditorType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartForm.this, EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getParameterEditorType()));
			}

		});
		parameterEditorType.setID(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createParameterEditorTypeEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#initConnectorParameters(EObject current, EReference containingFeature, EReference feature)
	 */
    public void initConnectorParameters(ReferencesTableSettings settings) {
        if (current.eResource() != null && current.eResource().getResourceSet() != null)
            this.resourceSet = current.eResource().getResourceSet();
        if (hasConnectorSchema) {
            EObject dataObject = ((ReferencesTableSettings) settings).getSource();
            if (connectorParameters instanceof ReferenceGroup) {
                ((ReferenceGroup) connectorParameters).setInput(settings, dataObject);
            }
        } else {
            ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
            connectorParameters.setContentProvider(contentProvider);
            connectorParameters.setInput(settings);
            boolean eefElementEditorReadOnlyState = isReadOnly(
                    EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters);
            if (eefElementEditorReadOnlyState && connectorParameters.isEnabled()) {
                connectorParameters.setEnabled(false);
                connectorParameters.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
            } else if (!eefElementEditorReadOnlyState && !connectorParameters.isEnabled()) {
                connectorParameters.setEnabled(true);
            }

            //Adjust table size according to no of params
            EObject dataObject = ((ReferencesTableSettings) settings).getSource();
            EList<CallTemplateParameter> parameterList = ((CloudConnectorOperation) dataObject).getConnectorParameters();
            int n0OfParams = parameterList.size();
            int tableLength = 100 + (n0OfParams / 5) * 100;
            Table connectorParamTable = this.connectorParameters.getTable();
            FormData connectorParamFormData = new FormData();
            connectorParamFormData.height = (tableLength >= 300) ? 300 : tableLength;
            connectorParamFormData.top = new FormAttachment(6, ITabbedPropertyConstants.VSPACE + 4);
            connectorParamFormData.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
            connectorParamFormData.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
            connectorParamTable.setLayoutData(connectorParamFormData);
            validate();
        }
    }


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#updateConnectorParameters()
	 * 
	 */
	public void updateConnectorParameters() {
	    if (!hasConnectorSchema) {
	        connectorParameters.refresh();
	    }
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#addFilterConnectorParameters(ViewerFilter filter)
	 * 
	 */
	public void addFilterToConnectorParameters(ViewerFilter filter) {
		connectorParametersFilters.add(filter);
		if (this.connectorParameters != null) {
			this.connectorParameters.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#addBusinessFilterConnectorParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToConnectorParameters(ViewerFilter filter) {
		connectorParametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#isContainedInConnectorParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInConnectorParametersTable(EObject element) {
		return ((ReferencesTableSettings)connectorParameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getConfigRef()
	 * 
	 */
	public String getConfigRef() {
		return configRef.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setConfigRef(String newValue)
	 * 
	 */
	public void setConfigRef(String newValue) {
		if (newValue != null) {
			configRef.setText(newValue);
		} else {
			configRef.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.configRef);
		if (eefElementEditorReadOnlyState && configRef.isEnabled()) {
			configRef.setEnabled(false);
			configRef.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !configRef.isEnabled()) {
			configRef.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getConnectorName()
	 * 
	 */
	public String getConnectorName() {
		return connectorName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setConnectorName(String newValue)
	 * 
	 */
	public void setConnectorName(String newValue) {
		if (newValue != null) {
			connectorName.setText(newValue);
		} else {
			connectorName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.connectorName);
		if (eefElementEditorReadOnlyState && connectorName.isEnabled()) {
			connectorName.setEnabled(false);
			connectorName.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectorName.isEnabled()) {
			connectorName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getOperationName()
	 * 
	 */
	public String getOperationName() {
		return operationName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setOperationName(String newValue)
	 * 
	 */
	public void setOperationName(String newValue) {
		if (newValue != null) {
			operationName.setText(newValue);
		} else {
			operationName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.operationName);
		if (eefElementEditorReadOnlyState && operationName.isEnabled()) {
			operationName.setEnabled(false);
			operationName.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operationName.isEnabled()) {
			operationName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getCloudConnectorName()
	 * 
	 */
	public String getCloudConnectorName() {
		return cloudConnectorName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setCloudConnectorName(String newValue)
	 * 
	 */
	public void setCloudConnectorName(String newValue) {
		if (newValue != null) {
			cloudConnectorName.setText(newValue);
		} else {
			cloudConnectorName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName);
		if (eefElementEditorReadOnlyState && cloudConnectorName.isEnabled()) {
			cloudConnectorName.setEnabled(false);
			cloudConnectorName.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cloudConnectorName.isEnabled()) {
			cloudConnectorName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getAvailableConfigs()
	 * 
	 */
	public String getAvailableConfigs() {
		return availableConfigs.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setAvailableConfigs(String newValue)
	 * 
	 */
	public void setAvailableConfigs(String newValue) {
		if (newValue != null) {
			availableConfigs.setText(newValue);
		} else {
			availableConfigs.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs);
		if (eefElementEditorReadOnlyState && availableConfigs.isEnabled()) {
			availableConfigs.setEnabled(false);
			availableConfigs.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !availableConfigs.isEnabled()) {
			availableConfigs.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getParameterEditorType()
	 * 
	 */
	public Enumerator getParameterEditorType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) parameterEditorType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#initParameterEditorType(Object input, Enumerator current)
	 */
	public void initParameterEditorType(Object input, Enumerator current) {
		parameterEditorType.setInput(input);
		parameterEditorType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType);
		if (eefElementEditorReadOnlyState && parameterEditorType.isEnabled()) {
			parameterEditorType.setEnabled(false);
			parameterEditorType.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterEditorType.isEnabled()) {
			parameterEditorType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setParameterEditorType(Enumerator newValue)
	 * 
	 */
	public void setParameterEditorType(Enumerator newValue) {
		parameterEditorType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType);
		if (eefElementEditorReadOnlyState && parameterEditorType.isEnabled()) {
			parameterEditorType.setEnabled(false);
			parameterEditorType.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterEditorType.isEnabled()) {
			parameterEditorType.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CloudConnectorOperation_Part_Title;
	}

//	 Start of user code additional methods
    @Override
    public void refresh() {
        super.refresh();
        if(!hasConnectorSchema) {
            validate();
        }
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);

        epv.showEntry(new Control[] { filterConfigSubPropertiesGroup.getParent() }, false);
        epv.clearElements(new Composite[] { filterConfigSubPropertiesGroup });

        epv.showEntry(configRefElements, false);
        epv.showEntry(availableConfigsElements, false);
        epv.clearTableButtons(connectorParamElements);
        view.layout(true, true);
    }
    
    public void updateMessage(String kind, String message, String field, String regex) throws URISyntaxException, IOException {
        String bannerMessage;
        Image image;
        if(infoLabel != null && !infoLabel.isDisposed()) {
            infoLabel.dispose();
        }
        infoLabel = new CLabel(propertiesGroup, SWT.NONE);
        if(kind.equals("requirederror")) {
            image = new Image(propertiesGroup.getShell().getDisplay(), EEFPropertyViewUtil.getIconPath("icons/full/obj16/error-icon-16x16.png"));
            bannerMessage = "Value of the '" + field + "' field is required"; 
        } else if (kind.equals("regexerror")) {
            image = new Image(propertiesGroup.getShell().getDisplay(), EEFPropertyViewUtil.getIconPath("icons/full/obj16/error-icon-16x16.png"));
            bannerMessage = "Value of the '" + field + "' field should match " + regex;
        } else if (kind.equals("custom")){
            image = new Image(propertiesGroup.getShell().getDisplay(), EEFPropertyViewUtil.getIconPath("icons/full/obj16/check-icon-16x16.png"));
            bannerMessage = message;
        } else {
            image = new Image(propertiesGroup.getShell().getDisplay(), EEFPropertyViewUtil.getIconPath("icons/full/obj16/check-icon-16x16.png"));
            bannerMessage = "There are no errors";
        }
        infoLabel.setImage(image);
        infoLabel.setText(bannerMessage);
        infoLabel.getParent().layout();
    }

	public void afterInitialization(){
		if (propertyRenderer != null) {
			propertyRenderer.addDefaultValues();
			propertyRenderer = null;
		}
	}
	// End of user code


}
