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

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
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
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ValidateMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ValidateMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected ReferencesTable features;
	protected List<ViewerFilter> featuresBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> featuresFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable schemas;
	protected List<ViewerFilter> schemasBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> schemasFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable resources;
	protected List<ViewerFilter> resourcesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> resourcesFilters = new ArrayList<ViewerFilter>();
	protected Button enableCacheSchema;
	// Start of user code  for source widgets declarations
    protected NamespacedProperty source;
    protected Text sourceText;
    protected Control[] reverseElements;
    protected Control[] commentListElements;
    protected Composite propertiesGroup;
    
    protected Composite filterFeaturesSubPropertiesGroup;
    protected Composite filterSchemasSubPropertiesGroup;
    protected Composite filterResourcesSubPropertiesGroup;
    
    protected Control[] featuresTableElements;
    protected Control[] schemasTableElements;
    protected Control[] resourcesTableElements;
    protected Control[] descriptionElements;
    protected Control[] enableCacheSchemaElements;
    protected Control[] sourceElements;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public ValidateMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ValidateMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence validateMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = validateMediatorStep.addStep(EsbViewsRepository.ValidateMediator.Properties.class);
        propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.source);
        propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema);
        propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.schemas);
        propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.features);
        propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.resources);
        propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.description);
		
		composer = new PartComposer(validateMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ValidateMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.features) {
					return createFeaturesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.schemas) {
					return createSchemasTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.resources) {
					return createResourcesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema) {
					return createEnableCacheSchemaCheckbox(widgetFactory, parent);
				}
				// Start of user code for source addToPart creation
                if (key == EsbViewsRepository.ValidateMediator.Properties.source) {
                    return createSourceWidget(widgetFactory, parent);
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
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.ValidateMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.ValidateMediator.Properties.description, EsbMessages.ValidateMediatorPropertiesEditionPart_DescriptionLabel);
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
							ValidateMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ValidateMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ValidateMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ValidateMediator.Properties.description,
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
									ValidateMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.ValidateMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] { descriptionLabel, description, descriptionHelp };
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
		EditingUtils.setID(commentsList, EsbViewsRepository.ValidateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ValidateMediator.Properties.commentsList, EsbMessages.ValidateMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "ValidateMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.ValidateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor
		commentListElements = new Control [] {editCommentsList, commentsList};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ValidateMediator.Properties.reverse, EsbMessages.ValidateMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.ValidateMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox
		reverseElements = new Control [] {reverse};
		// End of user code
		return parent;
	}

	/**
	 * @param container
     * @generated NOT
     *
	 */
	protected Composite createFeaturesTableComposition(FormToolkit widgetFactory, Composite parent) {
        filterFeaturesSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Features", true);
        Control[] previousControls = filterFeaturesSubPropertiesGroup.getChildren();
		this.features = new ReferencesTable(getDescription(EsbViewsRepository.ValidateMediator.Properties.features, EsbMessages.ValidateMediatorPropertiesEditionPart_FeaturesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				features.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				features.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				features.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				features.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.featuresFilters) {
			this.features.addFilter(filter);
		}
		this.features.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.features, EsbViewsRepository.FORM_KIND));
		this.features.createControls(filterFeaturesSubPropertiesGroup, widgetFactory);
		this.features.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.features, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData featuresData = new GridData(GridData.FILL_HORIZONTAL);
		featuresData.horizontalSpan = 3;
		this.features.setLayoutData(featuresData);
		this.features.setLowerBound(0);
		this.features.setUpperBound(-1);
		features.setID(EsbViewsRepository.ValidateMediator.Properties.features);
		features.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createFeaturesTableComposition
        Control[] newControls = filterFeaturesSubPropertiesGroup.getChildren();
        featuresTableElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 *
     * @generated NOT
     */
	protected Composite createSchemasTableComposition(FormToolkit widgetFactory, Composite parent) {
        filterSchemasSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Schemas", true);
        Control[] previousControls = filterSchemasSubPropertiesGroup.getChildren();
		this.schemas = new ReferencesTable(getDescription(EsbViewsRepository.ValidateMediator.Properties.schemas, EsbMessages.ValidateMediatorPropertiesEditionPart_SchemasLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.schemas, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				schemas.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.schemas, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				schemas.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.schemas, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				schemas.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.schemas, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				schemas.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.schemasFilters) {
			this.schemas.addFilter(filter);
		}
		this.schemas.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.schemas, EsbViewsRepository.FORM_KIND));
		this.schemas.createControls(filterSchemasSubPropertiesGroup, widgetFactory);
		this.schemas.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.schemas, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData schemasData = new GridData(GridData.FILL_HORIZONTAL);
		schemasData.horizontalSpan = 3;
		this.schemas.setLayoutData(schemasData);
		this.schemas.setLowerBound(0);
		this.schemas.setUpperBound(-1);
		schemas.setID(EsbViewsRepository.ValidateMediator.Properties.schemas);
		schemas.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createSchemasTableComposition
        Control[] newControls = filterSchemasSubPropertiesGroup.getChildren();
        schemasTableElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 *
     * @generated NOT
     */
	protected Composite createResourcesTableComposition(FormToolkit widgetFactory, Composite parent) {
        filterResourcesSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Resources", true);
        Control[] previousControls = filterResourcesSubPropertiesGroup.getChildren();
		this.resources = new ReferencesTable(getDescription(EsbViewsRepository.ValidateMediator.Properties.resources, EsbMessages.ValidateMediatorPropertiesEditionPart_ResourcesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				resources.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				resources.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				resources.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				resources.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.resourcesFilters) {
			this.resources.addFilter(filter);
		}
		this.resources.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.resources, EsbViewsRepository.FORM_KIND));
		this.resources.createControls(filterResourcesSubPropertiesGroup, widgetFactory);
		this.resources.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.resources, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData resourcesData = new GridData(GridData.FILL_HORIZONTAL);
		resourcesData.horizontalSpan = 3;
		this.resources.setLayoutData(resourcesData);
		this.resources.setLowerBound(0);
		this.resources.setUpperBound(-1);
		resources.setID(EsbViewsRepository.ValidateMediator.Properties.resources);
		resources.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createResourcesTableComposition
        Control[] newControls = filterResourcesSubPropertiesGroup.getChildren();
        resourcesTableElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createEnableCacheSchemaCheckbox(FormToolkit widgetFactory, Composite parent) {
		enableCacheSchema = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema, EsbMessages.ValidateMediatorPropertiesEditionPart_EnableCacheSchemaLabel), SWT.CHECK);
		enableCacheSchema.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(enableCacheSchema.getSelection())));
			}

		});
		GridData enableCacheSchemaData = new GridData(GridData.FILL_HORIZONTAL);
		enableCacheSchemaData.horizontalSpan = 2;
		enableCacheSchema.setLayoutData(enableCacheSchemaData);
		EditingUtils.setID(enableCacheSchema, EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema);
		EditingUtils.setEEFtype(enableCacheSchema, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEnableCacheSchemaCheckbox

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.ValidateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.ValidateMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.ValidateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#initFeatures(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initFeatures(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		features.setContentProvider(contentProvider);
		features.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateMediator.Properties.features);
		if (eefElementEditorReadOnlyState && features.isEnabled()) {
			features.setEnabled(false);
			features.setToolTipText(EsbMessages.ValidateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !features.isEnabled()) {
			features.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#updateFeatures()
	 * 
	 */
	public void updateFeatures() {
	features.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addFilterFeatures(ViewerFilter filter)
	 * 
	 */
	public void addFilterToFeatures(ViewerFilter filter) {
		featuresFilters.add(filter);
		if (this.features != null) {
			this.features.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addBusinessFilterFeatures(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFeatures(ViewerFilter filter) {
		featuresBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#isContainedInFeaturesTable(EObject element)
	 * 
	 */
	public boolean isContainedInFeaturesTable(EObject element) {
		return ((ReferencesTableSettings)features.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#initSchemas(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSchemas(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		schemas.setContentProvider(contentProvider);
		schemas.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateMediator.Properties.schemas);
		if (eefElementEditorReadOnlyState && schemas.isEnabled()) {
			schemas.setEnabled(false);
			schemas.setToolTipText(EsbMessages.ValidateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !schemas.isEnabled()) {
			schemas.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#updateSchemas()
	 * 
	 */
	public void updateSchemas() {
	schemas.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addFilterSchemas(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSchemas(ViewerFilter filter) {
		schemasFilters.add(filter);
		if (this.schemas != null) {
			this.schemas.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addBusinessFilterSchemas(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSchemas(ViewerFilter filter) {
		schemasBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#isContainedInSchemasTable(EObject element)
	 * 
	 */
	public boolean isContainedInSchemasTable(EObject element) {
		return ((ReferencesTableSettings)schemas.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#initResources(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initResources(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		resources.setContentProvider(contentProvider);
		resources.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateMediator.Properties.resources);
		if (eefElementEditorReadOnlyState && resources.isEnabled()) {
			resources.setEnabled(false);
			resources.setToolTipText(EsbMessages.ValidateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resources.isEnabled()) {
			resources.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#updateResources()
	 * 
	 */
	public void updateResources() {
	resources.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addFilterResources(ViewerFilter filter)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addBusinessFilterResources(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToResources(ViewerFilter filter) {
		resourcesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#isContainedInResourcesTable(EObject element)
	 * 
	 */
	public boolean isContainedInResourcesTable(EObject element) {
		return ((ReferencesTableSettings)resources.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#getEnableCacheSchema()
	 * 
	 */
	public Boolean getEnableCacheSchema() {
		return Boolean.valueOf(enableCacheSchema.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#setEnableCacheSchema(Boolean newValue)
	 * 
	 */
	public void setEnableCacheSchema(Boolean newValue) {
		if (newValue != null) {
			enableCacheSchema.setSelection(newValue.booleanValue());
		} else {
			enableCacheSchema.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema);
		if (eefElementEditorReadOnlyState && enableCacheSchema.isEnabled()) {
			enableCacheSchema.setEnabled(false);
			enableCacheSchema.setToolTipText(EsbMessages.ValidateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !enableCacheSchema.isEnabled()) {
			enableCacheSchema.setEnabled(true);
		}	
		
	}






	// Start of user code for source specific getters and setters implementation
    @Override
    public NamespacedProperty getSource() {
        // TODO Auto-generated method stub
        return source;
    }

    @Override
    public void setSource(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            sourceText.setText(nameSpacedProperty.getPropertyValue());
            source = nameSpacedProperty;
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
		return EsbMessages.ValidateMediator_Part_Title;
	}



	// Start of user code additional methods
    protected Composite createSourceWidget(FormToolkit widgetFactory, final Composite parent) {
        Control sourceLabel = createDescription(parent, EsbViewsRepository.ValidateMediator.Properties.source,
                EsbMessages.ValidateMediatorPropertiesEditionPart_SourceLabel);
        widgetFactory.paintBordersFor(parent);
        if (source == null) {
            source = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = source.getPropertyValue().isEmpty() ? "/default/expression"
                : source.getPropertyValue();
        sourceText = widgetFactory.createText(parent, initValueExpression);
        sourceText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        sourceText.setLayoutData(valueData);

        sourceText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                openSourceWidgetNamespacedPropertyEditor(parent);
            }
            
        });
        
        sourceText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
                openSourceWidgetNamespacedPropertyEditor(parent);
            }
            
            @Override
            public void keyReleased(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(sourceText, EsbViewsRepository.EnrichMediator.Source.sourceXPath);
        EditingUtils.setEEFtype(sourceText, "eef::Text");
        Control sourceXPathHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.ValidateMediator.Properties.source, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        return parent;
    }
    
    private void openSourceWidgetNamespacedPropertyEditor(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                SWT.NULL, source);
        source = nspd.open();
        sourceText.setText(source.getPropertyValue());
        propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.ValidateMediator.Properties.source, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getSource()));
    }
    
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);

        view.layout(true, true);
    }
	// End of user code


}
