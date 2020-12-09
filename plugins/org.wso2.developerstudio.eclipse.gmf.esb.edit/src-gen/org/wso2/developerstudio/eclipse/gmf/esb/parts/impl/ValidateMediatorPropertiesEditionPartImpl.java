/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

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
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ValidateMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ValidateMediatorPropertiesEditionPart {

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
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ValidateMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence validateMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = validateMediatorStep.addStep(EsbViewsRepository.ValidateMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.features);
		propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.schemas);
		propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.resources);
		propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema);
		propertiesStep.addStep(EsbViewsRepository.ValidateMediator.Properties.source);
		
		
		composer = new PartComposer(validateMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ValidateMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.features) {
					return createFeaturesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.schemas) {
					return createSchemasAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.resources) {
					return createResourcesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema) {
					return createEnableCacheSchemaCheckbox(parent);
				}
				// Start of user code for source addToPart creation
				
				// End of user code
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
		propertiesGroup.setText(EsbMessages.ValidateMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ValidateMediator.Properties.description, EsbMessages.ValidateMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.ValidateMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.ValidateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.ValidateMediator.Properties.commentsList, EsbMessages.ValidateMediatorPropertiesEditionPart_CommentsListLabel));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.ValidateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.ValidateMediator.Properties.reverse, EsbMessages.ValidateMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.ValidateMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createFeaturesAdvancedTableComposition(Composite parent) {
		this.features = new ReferencesTable(getDescription(EsbViewsRepository.ValidateMediator.Properties.features, EsbMessages.ValidateMediatorPropertiesEditionPart_FeaturesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				features.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				features.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				features.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				features.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.featuresFilters) {
			this.features.addFilter(filter);
		}
		this.features.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.features, EsbViewsRepository.SWT_KIND));
		this.features.createControls(parent);
		this.features.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.features, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createFeaturesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createSchemasAdvancedTableComposition(Composite parent) {
		this.schemas = new ReferencesTable(getDescription(EsbViewsRepository.ValidateMediator.Properties.schemas, EsbMessages.ValidateMediatorPropertiesEditionPart_SchemasLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.schemas, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				schemas.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.schemas, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				schemas.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.schemas, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				schemas.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.schemas, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				schemas.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.schemasFilters) {
			this.schemas.addFilter(filter);
		}
		this.schemas.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.schemas, EsbViewsRepository.SWT_KIND));
		this.schemas.createControls(parent);
		this.schemas.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.schemas, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createSchemasAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createResourcesAdvancedTableComposition(Composite parent) {
		this.resources = new ReferencesTable(getDescription(EsbViewsRepository.ValidateMediator.Properties.resources, EsbMessages.ValidateMediatorPropertiesEditionPart_ResourcesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				resources.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				resources.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				resources.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				resources.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.resourcesFilters) {
			this.resources.addFilter(filter);
		}
		this.resources.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.resources, EsbViewsRepository.SWT_KIND));
		this.resources.createControls(parent);
		this.resources.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.resources, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createResourcesAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createEnableCacheSchemaCheckbox(Composite parent) {
		enableCacheSchema = new Button(parent, SWT.CHECK);
		enableCacheSchema.setText(getDescription(EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema, EsbMessages.ValidateMediatorPropertiesEditionPart_EnableCacheSchemaLabel));
		enableCacheSchema.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ValidateMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(enableCacheSchema.getSelection())));
			}

		});
		GridData enableCacheSchemaData = new GridData(GridData.FILL_HORIZONTAL);
		enableCacheSchemaData.horizontalSpan = 2;
		enableCacheSchema.setLayoutData(enableCacheSchemaData);
		EditingUtils.setID(enableCacheSchema, EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema);
		EditingUtils.setEEFtype(enableCacheSchema, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateMediator.Properties.enableCacheSchema, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#setDescription(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#setCommentsList(EList newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#setReverse(Boolean newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#initFeatures(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#updateFeatures()
	 * 
	 */
	public void updateFeatures() {
	features.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addFilterFeatures(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addBusinessFilterFeatures(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFeatures(ViewerFilter filter) {
		featuresBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#isContainedInFeaturesTable(EObject element)
	 * 
	 */
	public boolean isContainedInFeaturesTable(EObject element) {
		return ((ReferencesTableSettings)features.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#initSchemas(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#updateSchemas()
	 * 
	 */
	public void updateSchemas() {
	schemas.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addFilterSchemas(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addBusinessFilterSchemas(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSchemas(ViewerFilter filter) {
		schemasBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#isContainedInSchemasTable(EObject element)
	 * 
	 */
	public boolean isContainedInSchemasTable(EObject element) {
		return ((ReferencesTableSettings)schemas.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#initResources(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#updateResources()
	 * 
	 */
	public void updateResources() {
	resources.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addFilterResources(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#addBusinessFilterResources(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToResources(ViewerFilter filter) {
		resourcesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#isContainedInResourcesTable(EObject element)
	 * 
	 */
	public boolean isContainedInResourcesTable(EObject element) {
		return ((ReferencesTableSettings)resources.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#getEnableCacheSchema()
	 * 
	 */
	public Boolean getEnableCacheSchema() {
		return Boolean.valueOf(enableCacheSchema.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateMediatorPropertiesEditionPart#setEnableCacheSchema(Boolean newValue)
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
        return null;
    }

    @Override
    public void setSource(NamespacedProperty nameSpacedProperty) {
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
		return EsbMessages.ValidateMediator_Part_Title;
	}


	// Start of user code additional methods
	
	// End of user code


}
