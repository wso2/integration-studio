/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

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

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class XSLTMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, XSLTMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer xsltSchemaKeyType;
	protected ReferencesTable properties;
	protected List<ViewerFilter> propertiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> propertiesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable features;
	protected List<ViewerFilter> featuresBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> featuresFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable resources;
	protected List<ViewerFilter> resourcesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> resourcesFilters = new ArrayList<ViewerFilter>();
	// Start of user code  for sourceXpath widgets declarations
	
	// End of user code

	// Start of user code  for XSLTStaticSchemaKey widgets declarations
	
	// End of user code

	// Start of user code  for XSLTDynamicSchemaKey widgets declarations
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public XSLTMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence xSLTMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = xSLTMediatorStep.addStep(EsbViewsRepository.XSLTMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.properties_);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.features);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.resources);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.sourceXpath);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey);
		
		
		composer = new PartComposer(xSLTMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.XSLTMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType) {
					return createXsltSchemaKeyTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.properties_) {
					return createPropertiesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.features) {
					return createFeaturesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.resources) {
					return createResourcesAdvancedTableComposition(parent);
				}
				// Start of user code for sourceXpath addToPart creation
				
				// End of user code
				// Start of user code for XSLTStaticSchemaKey addToPart creation
				
				// End of user code
				// Start of user code for XSLTDynamicSchemaKey addToPart creation
				
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
		propertiesGroup.setText(EsbMessages.XSLTMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.XSLTMediator.Properties.description, EsbMessages.XSLTMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.XSLTMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.XSLTMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.XSLTMediator.Properties.commentsList, EsbMessages.XSLTMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "XSLTMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.XSLTMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.XSLTMediator.Properties.reverse, EsbMessages.XSLTMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.XSLTMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createXsltSchemaKeyTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType, EsbMessages.XSLTMediatorPropertiesEditionPart_XsltSchemaKeyTypeLabel);
		xsltSchemaKeyType = new EMFComboViewer(parent);
		xsltSchemaKeyType.setContentProvider(new ArrayContentProvider());
		xsltSchemaKeyType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData xsltSchemaKeyTypeData = new GridData(GridData.FILL_HORIZONTAL);
		xsltSchemaKeyType.getCombo().setLayoutData(xsltSchemaKeyTypeData);
                xsltSchemaKeyType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		xsltSchemaKeyType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getXsltSchemaKeyType()));
			}

		});
		xsltSchemaKeyType.setID(EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createXsltSchemaKeyTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createPropertiesAdvancedTableComposition(Composite parent) {
		this.properties = new ReferencesTable(getDescription(EsbViewsRepository.XSLTMediator.Properties.properties_, EsbMessages.XSLTMediatorPropertiesEditionPart_PropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				properties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				properties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				properties.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				properties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.propertiesFilters) {
			this.properties.addFilter(filter);
		}
		this.properties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.properties_, EsbViewsRepository.SWT_KIND));
		this.properties.createControls(parent);
		this.properties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.properties_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData propertiesData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesData.horizontalSpan = 3;
		this.properties.setLayoutData(propertiesData);
		this.properties.setLowerBound(0);
		this.properties.setUpperBound(-1);
		properties.setID(EsbViewsRepository.XSLTMediator.Properties.properties_);
		properties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPropertiesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createFeaturesAdvancedTableComposition(Composite parent) {
		this.features = new ReferencesTable(getDescription(EsbViewsRepository.XSLTMediator.Properties.features, EsbMessages.XSLTMediatorPropertiesEditionPart_FeaturesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				features.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				features.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				features.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				features.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.featuresFilters) {
			this.features.addFilter(filter);
		}
		this.features.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.features, EsbViewsRepository.SWT_KIND));
		this.features.createControls(parent);
		this.features.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.features, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData featuresData = new GridData(GridData.FILL_HORIZONTAL);
		featuresData.horizontalSpan = 3;
		this.features.setLayoutData(featuresData);
		this.features.setLowerBound(0);
		this.features.setUpperBound(-1);
		features.setID(EsbViewsRepository.XSLTMediator.Properties.features);
		features.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createFeaturesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createResourcesAdvancedTableComposition(Composite parent) {
		this.resources = new ReferencesTable(getDescription(EsbViewsRepository.XSLTMediator.Properties.resources, EsbMessages.XSLTMediatorPropertiesEditionPart_ResourcesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				resources.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				resources.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				resources.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				resources.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.resourcesFilters) {
			this.resources.addFilter(filter);
		}
		this.resources.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.resources, EsbViewsRepository.SWT_KIND));
		this.resources.createControls(parent);
		this.resources.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.XSLTMediator.Properties.resources, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData resourcesData = new GridData(GridData.FILL_HORIZONTAL);
		resourcesData.horizontalSpan = 3;
		this.resources.setLayoutData(resourcesData);
		this.resources.setLowerBound(0);
		this.resources.setUpperBound(-1);
		resources.setID(EsbViewsRepository.XSLTMediator.Properties.resources);
		resources.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createResourcesAdvancedTableComposition

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.XSLTMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.XSLTMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.XSLTMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#getXsltSchemaKeyType()
	 * 
	 */
	public Enumerator getXsltSchemaKeyType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) xsltSchemaKeyType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#initXsltSchemaKeyType(Object input, Enumerator current)
	 */
	public void initXsltSchemaKeyType(Object input, Enumerator current) {
		xsltSchemaKeyType.setInput(input);
		xsltSchemaKeyType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType);
		if (eefElementEditorReadOnlyState && xsltSchemaKeyType.isEnabled()) {
			xsltSchemaKeyType.setEnabled(false);
			xsltSchemaKeyType.setToolTipText(EsbMessages.XSLTMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !xsltSchemaKeyType.isEnabled()) {
			xsltSchemaKeyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#setXsltSchemaKeyType(Enumerator newValue)
	 * 
	 */
	public void setXsltSchemaKeyType(Enumerator newValue) {
		xsltSchemaKeyType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType);
		if (eefElementEditorReadOnlyState && xsltSchemaKeyType.isEnabled()) {
			xsltSchemaKeyType.setEnabled(false);
			xsltSchemaKeyType.setToolTipText(EsbMessages.XSLTMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !xsltSchemaKeyType.isEnabled()) {
			xsltSchemaKeyType.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#initProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		properties.setContentProvider(contentProvider);
		properties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTMediator.Properties.properties_);
		if (eefElementEditorReadOnlyState && properties.isEnabled()) {
			properties.setEnabled(false);
			properties.setToolTipText(EsbMessages.XSLTMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !properties.isEnabled()) {
			properties.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#updateProperties()
	 * 
	 */
	public void updateProperties() {
	properties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#addFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addFilterToProperties(ViewerFilter filter) {
		propertiesFilters.add(filter);
		if (this.properties != null) {
			this.properties.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#addBusinessFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToProperties(ViewerFilter filter) {
		propertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#isContainedInPropertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPropertiesTable(EObject element) {
		return ((ReferencesTableSettings)properties.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#initFeatures(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initFeatures(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		features.setContentProvider(contentProvider);
		features.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTMediator.Properties.features);
		if (eefElementEditorReadOnlyState && features.isEnabled()) {
			features.setEnabled(false);
			features.setToolTipText(EsbMessages.XSLTMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !features.isEnabled()) {
			features.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#updateFeatures()
	 * 
	 */
	public void updateFeatures() {
	features.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#addFilterFeatures(ViewerFilter filter)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#addBusinessFilterFeatures(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFeatures(ViewerFilter filter) {
		featuresBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#isContainedInFeaturesTable(EObject element)
	 * 
	 */
	public boolean isContainedInFeaturesTable(EObject element) {
		return ((ReferencesTableSettings)features.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#initResources(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initResources(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		resources.setContentProvider(contentProvider);
		resources.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTMediator.Properties.resources);
		if (eefElementEditorReadOnlyState && resources.isEnabled()) {
			resources.setEnabled(false);
			resources.setToolTipText(EsbMessages.XSLTMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resources.isEnabled()) {
			resources.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#updateResources()
	 * 
	 */
	public void updateResources() {
	resources.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#addFilterResources(ViewerFilter filter)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#addBusinessFilterResources(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToResources(ViewerFilter filter) {
		resourcesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart#isContainedInResourcesTable(EObject element)
	 * 
	 */
	public boolean isContainedInResourcesTable(EObject element) {
		return ((ReferencesTableSettings)resources.getInput()).contains(element);
	}






	// Start of user code for sourceXpath specific getters and setters implementation
	@Override
    public NamespacedProperty getSourceXpath() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSourceXpath(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }
	// End of user code

	// Start of user code for XSLTStaticSchemaKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getXSLTStaticSchemaKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setXSLTStaticSchemaKey(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }
	// End of user code

	// Start of user code for XSLTDynamicSchemaKey specific getters and setters implementation
    @Override
    public NamespacedProperty getXSLTDynamicSchemaKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setXSLTDynamicSchemaKey(NamespacedProperty nameSpacedProperty) {
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
		return EsbMessages.XSLTMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
