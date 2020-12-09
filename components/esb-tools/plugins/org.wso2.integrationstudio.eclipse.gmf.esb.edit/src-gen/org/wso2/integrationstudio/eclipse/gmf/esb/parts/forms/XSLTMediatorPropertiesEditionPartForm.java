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
import org.eclipse.swt.events.MouseAdapter;
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
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class XSLTMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, XSLTMediatorPropertiesEditionPart {

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
	protected Text sourceXpathText;
    protected Control[] sourceXpathElements;
	// End of user code

	// Start of user code  for XSLTStaticSchemaKey widgets declarations
	protected Text XSLTStaticSchemaKeyText;
    protected Control[] XSLTStaticSchemaKeyElements;
 
	// End of user code

	// Start of user code  for XSLTDynamicSchemaKey widgets declarations
	protected Text dynamicSchemaText;
	protected Control [] XSLTDynamicSchemaKeyElements;
	// End of user code
	
	// Start of user code  
	protected RegistryKeyProperty sequenceKey;
	protected NamespacedProperty sourceXpath;
	protected NamespacedProperty dynamicSchema;
	protected Composite propertiesGroup;
	protected Composite xsltSchemaKeySubsection;
	
	protected Control [] descriptionElements;
	protected Control [] XSLTSchemaTypeElements;
	protected Control [] propertyElements;
	protected Control [] featuresElements;	
	protected Control [] resourcesElements;
	// End of user code
    


	/**
	 * For {@link ISection} use only.
	 */
	public XSLTMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public XSLTMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
	 * @generated NOT
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence xSLTMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = xSLTMediatorStep.addStep(EsbViewsRepository.XSLTMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.sourceXpath);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.properties_);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.resources);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.features);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.XSLTMediator.Properties.reverse);
		
		
		composer = new PartComposer(xSLTMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.XSLTMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType) {
					return createXsltSchemaKeyTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.properties_) {
					return createPropertiesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.features) {
					return createFeaturesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XSLTMediator.Properties.resources) {
					return createResourcesTableComposition(widgetFactory, parent);
				}
				// Start of user code for sourceXpath addToPart creation
				if (key == EsbViewsRepository.XSLTMediator.Properties.sourceXpath) {
                    return createSourceXpathWidget(widgetFactory, parent);
                }
				// End of user code
				
				// Start of user code for XSLTStaticSchemaKey addToPart creation
				if (key == EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey) {
                    return createXSLTStaticSchemaKeyWidget(widgetFactory, xsltSchemaKeySubsection);
                }
				// End of user code
				// Start of user code for XSLTDynamicSchemaKey addToPart creation
                if (key == EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey) {
                    return createXSLTDynamicSchemaKeyWidget(widgetFactory, xsltSchemaKeySubsection);
                }
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 *@generated NOT
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.XSLTMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
     *@generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.XSLTMediator.Properties.description, EsbMessages.XSLTMediatorPropertiesEditionPart_DescriptionLabel);
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
							XSLTMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.XSLTMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									XSLTMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.XSLTMediator.Properties.description,
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
									XSLTMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.XSLTMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control [] {descriptionLabel, description, descriptionHelp};
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
		EditingUtils.setID(commentsList, EsbViewsRepository.XSLTMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.XSLTMediator.Properties.commentsList, EsbMessages.XSLTMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
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

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.XSLTMediator.Properties.reverse, EsbMessages.XSLTMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.XSLTMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createXsltSchemaKeyTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    xsltSchemaKeySubsection = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "XSLT Schema Key", true);
		Control XSLTSchemaTypeLabel = createDescription(xsltSchemaKeySubsection, EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType, EsbMessages.XSLTMediatorPropertiesEditionPart_XsltSchemaKeyTypeLabel);
		xsltSchemaKeyType = new EMFComboViewer(xsltSchemaKeySubsection);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getXsltSchemaKeyType()));
			}

		});
		xsltSchemaKeyType.setID(EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType);
		Control XSLTSchemaTypeHelp = FormUtils.createHelpButton(widgetFactory, xsltSchemaKeySubsection, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createXsltSchemaKeyTypeEMFComboViewer
		XSLTSchemaTypeElements = new Control [] {XSLTSchemaTypeLabel, xsltSchemaKeyType.getCombo(), XSLTSchemaTypeHelp};
		xsltSchemaKeyType.addSelectionChangedListener(new ISelectionChangedListener() {

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
	 * @generated NOT
	 */
	protected Composite createPropertiesTableComposition(FormToolkit widgetFactory, Composite parent) {
	    Control[] previousControls = propertiesGroup.getChildren();
		this.properties = new ReferencesTable(getDescription(EsbViewsRepository.XSLTMediator.Properties.properties_, EsbMessages.XSLTMediatorPropertiesEditionPart_PropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				properties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				properties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				properties.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				properties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.propertiesFilters) {
			this.properties.addFilter(filter);
		}
		this.properties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.properties_, EsbViewsRepository.FORM_KIND));
		this.properties.createControls(parent, widgetFactory);
		this.properties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.properties_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createPropertiesTableComposition
	    Control[] newControls = propertiesGroup.getChildren();
	    propertyElements  = new Control [newControls.length - previousControls.length];
	    for (int i=previousControls.length; i<newControls.length; i++) {
	        propertyElements[previousControls.length -i]= newControls[i];
	    }
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * @generated NOT
	 */
	protected Composite createFeaturesTableComposition(FormToolkit widgetFactory, Composite parent) {
        Control[] previousControls = propertiesGroup.getChildren();
	    this.features = new ReferencesTable(getDescription(EsbViewsRepository.XSLTMediator.Properties.features, EsbMessages.XSLTMediatorPropertiesEditionPart_FeaturesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				features.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				features.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				features.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.features, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				features.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.featuresFilters) {
			this.features.addFilter(filter);
		}
		this.features.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.features, EsbViewsRepository.FORM_KIND));
		this.features.createControls(parent, widgetFactory);
		this.features.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.features, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createFeaturesTableComposition
        Control[] newControls = propertiesGroup.getChildren();
        featuresElements = new Control[newControls.length - previousControls.length];
        for (int i = previousControls.length; i < newControls.length; i++) {
            featuresElements[previousControls.length - i] = newControls[i];
        }
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * @generated NOT
	 */
	protected Composite createResourcesTableComposition(FormToolkit widgetFactory, Composite parent) {
        Control[] previousControls = propertiesGroup.getChildren();
	    this.resources = new ReferencesTable(getDescription(EsbViewsRepository.XSLTMediator.Properties.resources, EsbMessages.XSLTMediatorPropertiesEditionPart_ResourcesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				resources.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				resources.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				resources.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.resources, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				resources.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.resourcesFilters) {
			this.resources.addFilter(filter);
		}
		this.resources.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.resources, EsbViewsRepository.FORM_KIND));
		this.resources.createControls(parent, widgetFactory);
		this.resources.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.resources, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createResourcesTableComposition
        Control[] newControls = propertiesGroup.getChildren();
        resourcesElements = new Control[newControls.length - previousControls.length];
        for (int i = previousControls.length; i < newControls.length; i++) {
            resourcesElements[previousControls.length - i] = newControls[i];
        }
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
        return sourceXpath;
    }

    @Override
    public void setSourceXpath(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            sourceXpathText.setText(nameSpacedProperty.getPropertyValue());
            sourceXpath = nameSpacedProperty;
        }

    }
	// End of user code
    
	// Start of user code for XSLTStaticSchemaKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getXSLTStaticSchemaKey(){
        return sequenceKey;
    }

    @Override
    public void setXSLTStaticSchemaKey(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            XSLTStaticSchemaKeyText.setText(registryKeyProperty.getKeyValue());
            sequenceKey= registryKeyProperty;
        }
    }
	// End of user code

	// Start of user code for XSLTDynamicSchemaKey specific getters and setters implementation
    @Override
    public NamespacedProperty getXSLTDynamicSchemaKey() {
        return dynamicSchema;
    }

    @Override
    public void setXSLTDynamicSchemaKey(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            dynamicSchemaText.setText(nameSpacedProperty.getPropertyValue());
            dynamicSchema = nameSpacedProperty;
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
		return EsbMessages.XSLTMediator_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createXSLTStaticSchemaKeyWidget(FormToolkit widgetFactory, Composite parent) {
        Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey,
                EsbMessages.XSLTMediatorPropertiesEditionPart_XSLTStaticSchemaKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (sequenceKey == null) {
            sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initValueExpression = sequenceKey.getKeyValue().isEmpty() ? "" : sequenceKey.getKeyValue();
        XSLTStaticSchemaKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        XSLTStaticSchemaKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        XSLTStaticSchemaKeyText.setLayoutData(valueData);
        XSLTStaticSchemaKeyText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                XSLTStaticSchemaKeyText.setText(sequenceKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getXSLTStaticSchemaKey()));
            }

        });
        
        XSLTStaticSchemaKeyText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    XSLTStaticSchemaKeyText.setText(sequenceKey.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getXSLTStaticSchemaKey()));
                }
            }

        });
        EditingUtils.setID(XSLTStaticSchemaKeyText, EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey);
        EditingUtils.setEEFtype(XSLTStaticSchemaKeyText, "eef::Text");
        Control sequenceKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        XSLTStaticSchemaKeyElements = new Control[] { sequenceKeyLabel, XSLTStaticSchemaKeyText, sequenceKeyHelp };
        return parent;
    }
	
	protected Composite createSourceXpathWidget(FormToolkit widgetFactory, final Composite parent) {
        Control expressionPathLabel = createDescription(parent, EsbViewsRepository.XSLTMediator.Properties.sourceXpath,
                EsbMessages.XSLTMediatorPropertiesEditionPart_SourceXpathLabel);
        widgetFactory.paintBordersFor(parent);
        if (sourceXpath == null) {
            sourceXpath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = sourceXpath.getPropertyValue().isEmpty() ? "" : sourceXpath.getPropertyValue();
        sourceXpathText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        sourceXpathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        sourceXpathText.setLayoutData(valueData);

        sourceXpathText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, sourceXpath);
                sourceXpath = nspd.open();
                sourceXpathText.setText(sourceXpath.getPropertyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.XSLTMediator.Properties.sourceXpath, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getSourceXpath()));
            }

        });
        
        sourceXpathText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, sourceXpath);
                sourceXpath = nspd.open();
                sourceXpathText.setText(sourceXpath.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.sourceXpath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceXpath()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, sourceXpath);
                    nspd.open();
                    sourceXpathText.setText(sourceXpath.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.XSLTMediator.Properties.sourceXpath,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceXpath()));
                }
            }

        });
        
        EditingUtils.setID(sourceXpathText, EsbViewsRepository.XSLTMediator.Properties.sourceXpath);
        EditingUtils.setEEFtype(sourceXpathText, "eef::Text");
        Control expressionHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.XSLTMediator.Properties.sourceXpath, EsbViewsRepository.FORM_KIND),
                        null); // $NON-NLS-1$
        sourceXpathElements = new Control[] { expressionPathLabel, sourceXpathText, expressionHelp };
        return parent;
    }
	
    protected Composite createXSLTDynamicSchemaKeyWidget(FormToolkit widgetFactory, final Composite parent) {
        Control expressionPathLabel = createDescription(parent, EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey,
                "XSLT Dynamic Schema Key");
        widgetFactory.paintBordersFor(parent);
        if (dynamicSchema == null) {
            dynamicSchema = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = dynamicSchema.getPropertyValue().isEmpty() ? "" : dynamicSchema.getPropertyValue();
        dynamicSchemaText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        dynamicSchemaText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        dynamicSchemaText.setLayoutData(valueData);

        dynamicSchemaText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, dynamicSchema);
                dynamicSchema = nspd.open();
                dynamicSchemaText.setText(dynamicSchema.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        XSLTMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getXSLTDynamicSchemaKey()));
            }

        });

        dynamicSchemaText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, dynamicSchema);
                dynamicSchema = nspd.open();
                dynamicSchemaText.setText(dynamicSchema.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getXSLTDynamicSchemaKey()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, dynamicSchema);
                    nspd.open();
                    dynamicSchemaText.setText(dynamicSchema.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(XSLTMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getXSLTDynamicSchemaKey()));
                }
            }

        });
        
        EditingUtils.setID(dynamicSchemaText, EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey);
        EditingUtils.setEEFtype(dynamicSchemaText, "eef::Text");
        Control expressionHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey, EsbViewsRepository.FORM_KIND),
                        null); // $NON-NLS-1$
        XSLTDynamicSchemaKeyElements = new Control[] { expressionPathLabel, dynamicSchemaText, expressionHelp };
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
        eu.showEntry(new Control[] {xsltSchemaKeySubsection.getParent()}, false);
        eu.clearElements(new Composite[] { xsltSchemaKeySubsection });
        eu.showEntry(sourceXpathElements, false);
        eu.showEntry(XSLTSchemaTypeElements, false);
        if (getXsltSchemaKeyType().getName().equals("DYNAMIC")) {
            eu.showEntry(XSLTDynamicSchemaKeyElements, false);
        } else {
            eu.showEntry(XSLTStaticSchemaKeyElements, false);
        }
        eu.showEntry(propertyElements, false);
        eu.showEntry(featuresElements, false);
        eu.showEntry(resourcesElements, false);
        eu.showEntry(descriptionElements, false);

        view.layout(true, true);
    }
    
	// End of user code


}
