/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
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

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

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

import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
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
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class CallMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, CallMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected ReferencesTable endpoint;
	protected List<ViewerFilter> endpointBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> endpointFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer endpointType;
	protected Button enableBlockingCalls;
	// Start of user code  for endpointXpath widgets declarations
    protected NamespacedProperty endpointXPath;
    protected Text endpointXPathText;
	// End of user code

	// Start of user code  for endpointRegistryKey widgets declarations
    protected RegistryKeyProperty endpointRegistryKey;
    protected Text endpointRegistryKeyText;
    protected Control[] endpointTypeElements;
    protected Control[] enableBlockingCallsElements;
    protected Control[] endpointRegistryKeyElements;
    protected Control[] endpointXpathElements;
    protected Control[] descriptionElements;
    protected Control[] sourceTypeElements;
    protected Control[] sourceXpathElements;
    protected Control[] targetTypeElements;
    protected Control[] sourcePayloadElements;
    protected Control[] sourcePropertyElements;
    protected Control[] targetPropertyElements;
    protected Composite propertiesGroup;
    protected Composite sourceGroup;
    protected Composite targetGroup;
    
    protected final EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
    
    protected Composite filterEndpointTypeSubPropertiesGroup;
	protected Text sourcePayload;
    protected Text sourceProperty;
    protected Text contentType;
    protected EMFComboViewer sourceType;
    protected Text targetProperty;
    protected EMFComboViewer targetType;
    
    protected NamespacedProperty sourceXPath;
    protected Text sourceXPathText;
  // End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public CallMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CallMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence callMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = callMediatorStep.addStep(EsbViewsRepository.CallMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.endpoint);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.enableBlockingCalls);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.endpointType);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.endpointXpath);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.endpointRegistryKey);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.description);
		
        CompositionStep sourceStep = callMediatorStep.addStep(EsbViewsRepository.CallMediator.Source.class);
        sourceStep.addStep(EsbViewsRepository.CallMediator.Source.contentType);
        sourceStep.addStep(EsbViewsRepository.CallMediator.Source.sourceType);
        sourceStep.addStep(EsbViewsRepository.CallMediator.Source.sourcePayload);
        sourceStep.addStep(EsbViewsRepository.CallMediator.Source.sourceProperty);
        sourceStep.addStep(EsbViewsRepository.CallMediator.Source.sourceXPath);

        CompositionStep targetStep = callMediatorStep.addStep(EsbViewsRepository.CallMediator.Target.class);
        targetStep.addStep(EsbViewsRepository.CallMediator.Target.targetType);
        targetStep.addStep(EsbViewsRepository.CallMediator.Target.targetProperty);
		
		composer = new PartComposer(callMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
			    // Start of user code for components addToPart creation
				if (key == EsbViewsRepository.CallMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.endpoint) {
					return createEndpointReferencesTable(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.endpointType) {
					return createEndpointTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.enableBlockingCalls) {
					return createEnableBlockingCallsCheckbox(widgetFactory, parent);
				}
                if (key == EsbViewsRepository.CallMediator.Properties.endpointXpath) {
                    return createEndpointXPathWidget(widgetFactory, filterEndpointTypeSubPropertiesGroup);
                }
                if (key == EsbViewsRepository.CallMediator.Properties.endpointRegistryKey) {
                    return createEndpointRegistryKeyWidget(widgetFactory, filterEndpointTypeSubPropertiesGroup);
                }
                if (key == EsbViewsRepository.CallMediator.Source.class) {
                    return createSourceGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CallMediator.Source.sourcePayload) {
                    return createSourcePayloadText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CallMediator.Source.sourceProperty) {
                    return createSourcePropertyText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CallMediator.Source.sourceType) {
                    return createSourceTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CallMediator.Source.contentType) {
                    return createContentTypeText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CallMediator.Target.class) {
                    return createTargetGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CallMediator.Target.targetType) {
                    return createTargetTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CallMediator.Target.targetProperty) {
                    return createTargetPropertyText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CallMediator.Source.sourceXPath) {
                    return createSourceXpathWidget(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.CallMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		Control descriptionText = createDescription(parent, EsbViewsRepository.CallMediator.Properties.description, EsbMessages.CallMediatorPropertiesEditionPart_DescriptionLabel);
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
							CallMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CallMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CallMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CallMediator.Properties.description,
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
									CallMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.CallMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		descriptionElements = new Control[] { descriptionText, description, descriptionHelp };
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
		EditingUtils.setID(commentsList, EsbViewsRepository.CallMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CallMediator.Properties.commentsList, EsbMessages.CallMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "CallMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.CallMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CallMediator.Properties.reverse, EsbMessages.CallMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.CallMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createEndpointReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.endpoint = new ReferencesTable(getDescription(EsbViewsRepository.CallMediator.Properties.endpoint, EsbMessages.CallMediatorPropertiesEditionPart_EndpointLabel), new ReferencesTableListener	() {
			public void handleAdd() { addEndpoint(); }
			public void handleEdit(EObject element) { editEndpoint(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveEndpoint(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromEndpoint(element); }
			public void navigateTo(EObject element) { }
		});
		this.endpoint.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.endpoint, EsbViewsRepository.FORM_KIND));
		this.endpoint.createControls(parent, widgetFactory);
		this.endpoint.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallMediator.Properties.endpoint, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData endpointData = new GridData(GridData.FILL_HORIZONTAL);
		endpointData.horizontalSpan = 3;
		this.endpoint.setLayoutData(endpointData);
		this.endpoint.disableMove();
		endpoint.setID(EsbViewsRepository.CallMediator.Properties.endpoint);
		endpoint.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createEndpointReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addEndpoint() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(endpoint.getInput(), endpointFilters, endpointBusinessFilters,
		"endpoint", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallMediator.Properties.endpoint,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				endpoint.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveEndpoint(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallMediator.Properties.endpoint, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		endpoint.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromEndpoint(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallMediator.Properties.endpoint, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		endpoint.refresh();
	}

	/**
	 * 
	 */
	protected void editEndpoint(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				endpoint.refresh();
			}
		}
	}

    /**
     * @generated NOT
     */
	protected Composite createEndpointTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        filterEndpointTypeSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent,
                "Endpoint Type", true);
		Control endpointTypeLabel = createDescription(filterEndpointTypeSubPropertiesGroup, EsbViewsRepository.CallMediator.Properties.endpointType, EsbMessages.CallMediatorPropertiesEditionPart_EndpointTypeLabel);
		endpointType = new EMFComboViewer(filterEndpointTypeSubPropertiesGroup);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallMediator.Properties.endpointType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEndpointType()));
			}

		});
		endpointType.setID(EsbViewsRepository.CallMediator.Properties.endpointType);
		Control endpointTypeHelp = FormUtils.createHelpButton(widgetFactory, filterEndpointTypeSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.endpointType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointTypeEMFComboViewer
		endpointTypeElements = new Control[] {endpointTypeLabel, endpointType.getCombo(), endpointTypeHelp};		
		endpointType.addSelectionChangedListener(new ISelectionChangedListener() {
            
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
     * @generated NOT
     */
	protected Composite createEnableBlockingCallsCheckbox(FormToolkit widgetFactory, Composite parent) {
		enableBlockingCalls = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CallMediator.Properties.enableBlockingCalls, EsbMessages.CallMediatorPropertiesEditionPart_EnableBlockingCallsLabel), SWT.CHECK);
		enableBlockingCalls.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallMediator.Properties.enableBlockingCalls, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(enableBlockingCalls.getSelection())));
			}

		});
		GridData enableBlockingCallsData = new GridData(GridData.FILL_HORIZONTAL);
		enableBlockingCallsData.horizontalSpan = 2;
		enableBlockingCalls.setLayoutData(enableBlockingCallsData);
		EditingUtils.setID(enableBlockingCalls, EsbViewsRepository.CallMediator.Properties.enableBlockingCalls);
		EditingUtils.setEEFtype(enableBlockingCalls, "eef::Checkbox"); //$NON-NLS-1$
		Control enableBlockingCallsHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.enableBlockingCalls, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEnableBlockingCallsCheckbox
		enableBlockingCallsElements = new Control[] {enableBlockingCalls, enableBlockingCallsHelp};
        
		// End of user code
		return parent;
	}


	/**
   * 
   */
    protected Composite createSourceGroup(FormToolkit widgetFactory, final Composite parent) {
        Section sourceSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        sourceSection.setText(EsbMessages.CallMediatorPropertiesEditionPart_SourceGroupLabel);
        GridData sourceSectionData = new GridData(GridData.FILL_HORIZONTAL);
        sourceSectionData.horizontalSpan = 3;
        sourceSection.setLayoutData(sourceSectionData);
        sourceGroup = widgetFactory.createComposite(sourceSection);
        GridLayout sourceGroupLayout = new GridLayout();
        sourceGroupLayout.numColumns = 3;
        sourceGroup.setLayout(sourceGroupLayout);
        sourceSection.setClient(sourceGroup);
        return sourceGroup;
    }

    protected Composite createSourcePayloadText(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.CallMediator.Source.sourcePayload,
                EsbMessages.CallMediatorPropertiesEditionPart_SourcePayloadLabel);
        sourcePayload = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        sourcePayload.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData sourcePayloadData = new GridData(GridData.FILL_HORIZONTAL);
        sourcePayload.setLayoutData(sourcePayloadData);
        sourcePayload.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CallMediator.Source.sourcePayload, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, sourcePayload.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CallMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CallMediator.Source.sourcePayload, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, sourcePayload.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CallMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        sourcePayload.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CallMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CallMediator.Source.sourcePayload, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, sourcePayload.getText()));
                }
            }
        });
        EditingUtils.setID(sourcePayload, EsbViewsRepository.CallMediator.Source.sourcePayload);
        EditingUtils.setEEFtype(sourcePayload, "eef::Text"); //$NON-NLS-1$
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CallMediator.Source.sourcePayload, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createSourcePayloadText
        sourcePayloadElements = new Control[] { itemLabel, sourcePayload, itemHelp };
        // End of user code
        return parent;
    }

    protected Composite createSourcePropertyText(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.CallMediator.Source.sourceProperty,
                EsbMessages.CallMediatorPropertiesEditionPart_SourcePropertyLabel);
        sourceProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        sourceProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData sourcePropertyData = new GridData(GridData.FILL_HORIZONTAL);
        sourceProperty.setLayoutData(sourcePropertyData);
        sourceProperty.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CallMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CallMediator.Source.sourceProperty, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, sourceProperty.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CallMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CallMediator.Source.sourceProperty, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, sourceProperty.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CallMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        sourceProperty.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CallMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CallMediator.Source.sourceProperty, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, sourceProperty.getText()));
                }
            }
        });
        EditingUtils.setID(sourceProperty, EsbViewsRepository.CallMediator.Source.sourceProperty);
        EditingUtils.setEEFtype(sourceProperty, "eef::Text"); //$NON-NLS-1$
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CallMediator.Source.sourceProperty, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createSourcePropertyText
        sourcePropertyElements = new Control[] { itemLabel, sourceProperty, itemHelp };
        // End of user code
        return parent;
    }

    protected Composite createContentTypeText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, EsbViewsRepository.CallMediator.Source.contentType,
                EsbMessages.CallMediatorPropertiesEditionPart_ContentTypeLabel);
        contentType = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        contentType.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData contentTypeData = new GridData(GridData.FILL_HORIZONTAL);
        contentType.setLayoutData(contentTypeData);
        contentType.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CallMediator.Source.contentType, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, contentType.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CallMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CallMediator.Source.contentType, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, contentType.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CallMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        contentType.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CallMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CallMediator.Source.contentType, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, contentType.getText()));
                }
            }
        });
        EditingUtils.setID(contentType, EsbViewsRepository.CallMediator.Source.contentType);
        EditingUtils.setEEFtype(contentType, "eef::Text"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CallMediator.Source.contentType, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createContentTypeText

        // End of user code
        return parent;
    }

    protected Composite createSourceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.CallMediator.Source.sourceType,
                EsbMessages.CallMediatorPropertiesEditionPart_SourceTypeLabel);
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
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CallMediator.Source.sourceType, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getSourceType()));
            }

        });
        sourceType.setID(EsbViewsRepository.CallMediator.Source.sourceType);
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.CallMediator.Source.sourceType, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createSourceTypeEMFComboViewer
        sourceTypeElements = new Control[] { itemLabel, sourceType.getCombo(), itemHelp };
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

    /**
   * 
   */
    protected Composite createTargetGroup(FormToolkit widgetFactory, final Composite parent) {
        Section targetSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        targetSection.setText(EsbMessages.CallMediatorPropertiesEditionPart_TargetGroupLabel);
        GridData targetSectionData = new GridData(GridData.FILL_HORIZONTAL);
        targetSectionData.horizontalSpan = 3;
        targetSection.setLayoutData(targetSectionData);
        targetGroup = widgetFactory.createComposite(targetSection);
        GridLayout targetGroupLayout = new GridLayout();
        targetGroupLayout.numColumns = 3;
        targetGroup.setLayout(targetGroupLayout);
        targetSection.setClient(targetGroup);
        return targetGroup;
    }

    protected Composite createTargetPropertyText(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.CallMediator.Target.targetProperty,
                EsbMessages.CallMediatorPropertiesEditionPart_TargetPropertyLabel);
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
                            CallMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CallMediator.Target.targetProperty, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, targetProperty.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CallMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CallMediator.Target.targetProperty, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, targetProperty.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CallMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CallMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CallMediator.Target.targetProperty, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, targetProperty.getText()));
                }
            }
        });
        EditingUtils.setID(targetProperty, EsbViewsRepository.CallMediator.Target.targetProperty);
        EditingUtils.setEEFtype(targetProperty, "eef::Text"); //$NON-NLS-1$
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CallMediator.Target.targetProperty, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createTargetPropertyText
        targetPropertyElements = new Control[] { itemLabel, targetProperty, itemHelp };
        // End of user code
        return parent;
    }

    protected Composite createTargetTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.CallMediator.Target.targetType,
                EsbMessages.CallMediatorPropertiesEditionPart_TargetTypeLabel);
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
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CallMediator.Target.targetType, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getTargetType()));
            }

        });
        targetType.setID(EsbViewsRepository.CallMediator.Target.targetType);
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.CallMediator.Target.targetType, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createTargetTypeEMFComboViewer
        targetTypeElements = new Control[] { itemLabel, targetType.getCombo(), itemHelp };
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.CallMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#initEndpoint(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initEndpoint(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		endpoint.setContentProvider(contentProvider);
		endpoint.setInput(settings);
		endpointBusinessFilters.clear();
		endpointFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.endpoint);
		if (eefElementEditorReadOnlyState && endpoint.getTable().isEnabled()) {
			endpoint.setEnabled(false);
			endpoint.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpoint.getTable().isEnabled()) {
			endpoint.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#updateEndpoint()
	 * 
	 */
	public void updateEndpoint() {
	endpoint.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#addFilterEndpoint(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEndpoint(ViewerFilter filter) {
		endpointFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#addBusinessFilterEndpoint(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEndpoint(ViewerFilter filter) {
		endpointBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#isContainedInEndpointTable(EObject element)
	 * 
	 */
	public boolean isContainedInEndpointTable(EObject element) {
		return ((ReferencesTableSettings)endpoint.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getEndpointType()
	 * 
	 */
	public Enumerator getEndpointType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) endpointType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#initEndpointType(Object input, Enumerator current)
	 */
	public void initEndpointType(Object input, Enumerator current) {
		endpointType.setInput(input);
		endpointType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setEndpointType(Enumerator newValue)
	 * 
	 */
	public void setEndpointType(Enumerator newValue) {
		endpointType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getEnableBlockingCalls()
	 * 
	 */
	public Boolean getEnableBlockingCalls() {
		return Boolean.valueOf(enableBlockingCalls.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setEnableBlockingCalls(Boolean newValue)
	 * 
	 */
	public void setEnableBlockingCalls(Boolean newValue) {
		if (newValue != null) {
			enableBlockingCalls.setSelection(newValue.booleanValue());
		} else {
			enableBlockingCalls.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.enableBlockingCalls);
		if (eefElementEditorReadOnlyState && enableBlockingCalls.isEnabled()) {
			enableBlockingCalls.setEnabled(false);
			enableBlockingCalls.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !enableBlockingCalls.isEnabled()) {
			enableBlockingCalls.setEnabled(true);
		}	
		
	}






	/**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getSourcePayload()
   * 
   */
  public String getSourcePayload() {
    return sourcePayload.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setSourcePayload(String newValue)
   * 
   */
  public void setSourcePayload(String newValue) {
    if (newValue != null) {
      sourcePayload.setText(newValue);
    } else {
      sourcePayload.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Source.sourcePayload);
    if (eefElementEditorReadOnlyState && sourcePayload.isEnabled()) {
      sourcePayload.setEnabled(false);
      sourcePayload.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !sourcePayload.isEnabled()) {
      sourcePayload.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getSourceProperty()
   * 
   */
  public String getSourceProperty() {
    return sourceProperty.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setSourceProperty(String newValue)
   * 
   */
  public void setSourceProperty(String newValue) {
    if (newValue != null) {
      sourceProperty.setText(newValue);
    } else {
      sourceProperty.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Source.sourceProperty);
    if (eefElementEditorReadOnlyState && sourceProperty.isEnabled()) {
      sourceProperty.setEnabled(false);
      sourceProperty.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !sourceProperty.isEnabled()) {
      sourceProperty.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getContentType()
   * 
   */
  public String getContentType() {
    return contentType.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setContentType(String newValue)
   * 
   */
  public void setContentType(String newValue) {
    if (newValue != null) {
      contentType.setText(newValue);
    } else {
      contentType.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Source.contentType);
    if (eefElementEditorReadOnlyState && contentType.isEnabled()) {
      contentType.setEnabled(false);
      contentType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !contentType.isEnabled()) {
      contentType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getSourceType()
   * 
   */
  public Enumerator getSourceType() {
    Enumerator selection = (Enumerator) ((StructuredSelection) sourceType.getSelection()).getFirstElement();
    return selection;
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#initSourceType(Object input, Enumerator current)
   */
  public void initSourceType(Object input, Enumerator current) {
    sourceType.setInput(input);
    sourceType.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Source.sourceType);
    if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
      sourceType.setEnabled(false);
      sourceType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
      sourceType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setSourceType(Enumerator newValue)
   * 
   */
  public void setSourceType(Enumerator newValue) {
    sourceType.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Source.sourceType);
    if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
      sourceType.setEnabled(false);
      sourceType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
      sourceType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getTargetProperty()
   * 
   */
  public String getTargetProperty() {
    return targetProperty.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setTargetProperty(String newValue)
   * 
   */
  public void setTargetProperty(String newValue) {
    if (newValue != null) {
      targetProperty.setText(newValue);
    } else {
      targetProperty.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Target.targetProperty);
    if (eefElementEditorReadOnlyState && targetProperty.isEnabled()) {
      targetProperty.setEnabled(false);
      targetProperty.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !targetProperty.isEnabled()) {
      targetProperty.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getTargetType()
   * 
   */
  public Enumerator getTargetType() {
    Enumerator selection = (Enumerator) ((StructuredSelection) targetType.getSelection()).getFirstElement();
    return selection;
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#initTargetType(Object input, Enumerator current)
   */
  public void initTargetType(Object input, Enumerator current) {
    targetType.setInput(input);
    targetType.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Target.targetType);
    if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
      targetType.setEnabled(false);
      targetType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
      targetType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setTargetType(Enumerator newValue)
   * 
   */
  public void setTargetType(Enumerator newValue) {
    targetType.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Target.targetType);
    if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
      targetType.setEnabled(false);
      targetType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
      targetType.setEnabled(true);
    }	
    
  }

    // Start of user code for endpointXpath specific getters and setters implementation
    @Override
    public NamespacedProperty getEndpointXPath() {
        return endpointXPath;
    }

    @Override
    public void setEndpointXPath(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
            endpointXPathText.setText(nameSpacedProperty.getPropertyValue());
            endpointXPath = nameSpacedProperty;
        }        
    }
	// End of user code

	// Start of user code for endpointRegistryKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getEndpointRegistryKey() {
        return endpointRegistryKey;
    }

    @Override
    public void setEndpointRegistryKey(RegistryKeyProperty registryKeyProperty) {
        if(registryKeyProperty != null) {
            endpointRegistryKeyText.setText(registryKeyProperty.getKeyValue());
            endpointRegistryKey = registryKeyProperty;
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
		return EsbMessages.CallMediator_Part_Title;
	}


	// Start of user code additional methods
    protected Composite createEndpointRegistryKeyWidget(FormToolkit widgetFactory, final Composite parent) {
        Control endpointRegistryKeyLabel = createDescription(parent, EsbViewsRepository.CallMediator.Properties.endpointRegistryKey, EsbMessages.CallMediatorPropertiesEditionPart_EndpointRegistryKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if(endpointRegistryKey == null) {
            endpointRegistryKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        } 
        String initValueExpression = endpointRegistryKey.getKeyValue().isEmpty() ? "" : endpointRegistryKey.getKeyValue();
        endpointRegistryKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        endpointRegistryKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        endpointRegistryKeyText.setLayoutData(valueData);
        
        endpointRegistryKeyText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                openCreateEndpointRegistryKeyNPE(parent);
            }

        });

        endpointRegistryKeyText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (!epv.isReservedKeyCombination(e)) {
                    openCreateEndpointRegistryKeyNPE(parent);
                }
            }

        });
        
        EditingUtils.setID(endpointRegistryKeyText, EsbViewsRepository.CallMediator.Properties.endpointRegistryKey);
        EditingUtils.setEEFtype(endpointRegistryKeyText, "eef::Text");
        Control endpointRegistryKeyHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.endpointRegistryKey, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        endpointRegistryKeyElements = new Control[] {endpointRegistryKeyLabel, endpointRegistryKeyText, endpointRegistryKeyHelp};
        return parent;
    }

    protected Composite createEndpointXPathWidget(FormToolkit widgetFactory, final Composite parent) {
        Control endpointXPathLabel = createDescription(parent, EsbViewsRepository.CallMediator.Properties.endpointXpath, EsbMessages.CallMediatorPropertiesEditionPart_EndpointXpathLabel);
        widgetFactory.paintBordersFor(parent);
        if(endpointXPath == null) {
            endpointXPath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = endpointXPath.getPropertyValue().isEmpty() ? "/default/expression" : endpointXPath.getPropertyValue();
        endpointXPathText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        endpointXPathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        endpointXPathText.setLayoutData(valueData);

        endpointXPathText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                openCreateEndpointNPE(parent);
            }
            
        });
        
        endpointXPathText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {}
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!epv.isReservedKeyCombination(e)) {
                    openCreateEndpointNPE(parent);
                }
            }
            
        });
        
        EditingUtils.setID(endpointXPathText, EsbViewsRepository.AggregateMediator.OnComplete.aggregationExpression);
        EditingUtils.setEEFtype(endpointXPathText, "eef::Text");
        Control endpointXPathHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.endpointXpath, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        endpointXpathElements = new Control[] {endpointXPathLabel, endpointXPathText, endpointXPathHelp};
        return parent;
    }
	
    private void openCreateEndpointNPE(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                endpointXPath);
        endpointXPath = nspd.open();
        endpointXPathText.setText(endpointXPath.getPropertyValue());
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                CallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallMediator.Properties.endpointXpath,
                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEndpointXPath()));
    }

    private void openCreateEndpointRegistryKeyNPE(final Composite parent) {
        EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(), SWT.NULL,
                endpointRegistryKey, new ArrayList<NamedEntityDescriptor>());
        dialog.open();
        endpointRegistryKeyText.setText(endpointRegistryKey.getKeyValue());
        propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.CallMediator.Properties.endpointRegistryKey, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getEndpointRegistryKey()));
    }
    
	@Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        epv.clearElements(new Composite[] { propertiesGroup, sourceGroup, targetGroup });
        epv.showEntry(new Control[] {filterEndpointTypeSubPropertiesGroup.getParent()}, false);
        epv.clearElements(new Composite[] { filterEndpointTypeSubPropertiesGroup });
        
        epv.showEntry(endpointTypeElements, false);
        epv.showEntry(enableBlockingCallsElements, false);
        epv.showEntry(sourceTypeElements, false);
        epv.showEntry(targetTypeElements, false);
        
        switch (getEndpointType().getName()) {
        case "NONE":
        case "INLINE":
            break;
        case "REGISRTYKEY":
            epv.showEntry(endpointRegistryKeyElements, false);
            break;
        case "XPATH":
            epv.showEntry(endpointXpathElements, false);
            break;
        }
        
        epv.showEntry(enableBlockingCallsElements, false);
        epv.showEntry(descriptionElements, false);
        
        switch (getSourceType().getName()) {
        case "NONE":
        case "BODY":
            break;
        case "INLINE": {
            epv.showEntry(sourcePayloadElements, false);
            break;
        }
        case "CUSTOM":{
            epv.showEntry(sourceXpathElements, false);
            break;
        }
        case "PROPERTY":{
            epv.showEntry(sourcePropertyElements, false);
            break;
        }
        }
        
        switch (getTargetType().getName()) {
        case "NONE":
        case "BODY":
            break;
        case "PROPERTY":{
            epv.showEntry(targetPropertyElements, false);
            break;
        }
        }
        view.layout(true, true);
    }
	// End of user code

    @Override
    public NamespacedProperty getSourceXPath() {
        // TODO Auto-generated method stub
        return sourceXPath;
    }

    @Override
    public void setSourceXPath(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        if (nameSpacedProperty != null) {
            sourceXPathText.setText(nameSpacedProperty.getPropertyValue());
            sourceXPath = nameSpacedProperty;
        }
    }
    
    protected Composite createSourceXpathWidget(FormToolkit widgetFactory, final Composite parent) {
        Control sourceXpathLabel = createDescription(parent, EsbViewsRepository.CallMediator.Source.sourceXPath,
                EsbMessages.CallMediatorPropertiesEditionPart_SourceXPathLabel);
        widgetFactory.paintBordersFor(parent);
        if (sourceXPath == null) {
            sourceXPath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = sourceXPath.getPropertyValue().isEmpty() ? ""
                : sourceXPath.getPropertyValue();
        sourceXPathText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        sourceXPathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        sourceXPathText.setLayoutData(valueData);

        sourceXPathText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, sourceXPath);
                sourceXPath = nspd.open();
                sourceXPathText.setText(sourceXPath.getPropertyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CallMediator.Source.sourceXPath, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getSourceXPath()));
            }
            
        });
        
        sourceXPathText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, sourceXPath);
                    sourceXPath = nspd.open();
                    sourceXPathText.setText(sourceXPath.getPropertyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CallMediator.Source.sourceXPath, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getSourceXPath()));
                }
            }
            
        });
        
        EditingUtils.setID(sourceXPathText, EsbViewsRepository.CallMediator.Source.sourceXPath);
        EditingUtils.setEEFtype(sourceXPathText, "eef::Text");
        Control sourceXPathHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.CallMediator.Source.sourceXPath, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        sourceXpathElements = new Control[] { sourceXpathLabel, sourceXPathText, sourceXPathHelp };
        return parent;
    }

}
