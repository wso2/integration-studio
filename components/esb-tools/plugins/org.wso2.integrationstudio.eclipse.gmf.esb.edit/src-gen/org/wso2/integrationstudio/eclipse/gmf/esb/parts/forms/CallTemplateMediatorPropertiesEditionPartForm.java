/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

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
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class CallTemplateMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, CallTemplateMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer availableTemplates;
	protected ReferencesTable templateParameters;
	protected List<ViewerFilter> templateParametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> templateParametersFilters = new ArrayList<ViewerFilter>();
	protected Text targetTemplate;
    protected Control[] availableTemplatesElements;
    protected Control[] targetTemplateElements;
    protected Control[] parametersElements;
    protected Control[] descriptionElements;
    protected Composite propertiesGroup;
    private Control[] templateParametersElements;
    protected Control[] onErrorElements;

    protected RegistryKeyProperty onError;
    protected Text onErrorText;

	/**
	 * For {@link ISection} use only.
	 */
	public CallTemplateMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CallTemplateMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 *  
	 *  @generated NOT
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
		CompositionSequence callTemplateMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = callTemplateMediatorStep.addStep(EsbViewsRepository.CallTemplateMediator.Properties.class);
		// Start of user code
		propertiesStep.addStep(EsbViewsRepository.CallTemplateMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateMediator.Properties.templateParameters);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate);
        propertiesStep.addStep(EsbViewsRepository.CallTemplateMediator.Properties.onError);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateMediator.Properties.description);
		
		composer = new PartComposer(callTemplateMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CallTemplateMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallTemplateMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallTemplateMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates) {
					return createAvailableTemplatesText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallTemplateMediator.Properties.templateParameters) {
					return createTemplateParametersTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallTemplateMediator.Properties.onError) {
                    return createOnErrorWidget(widgetFactory, parent);
                }
				if (key == EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate) {
					return createTargetTemplateText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallTemplateMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				// End of user code
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
		propertiesSection.setText(EsbMessages.CallTemplateMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
	    Control [] previousControls = propertiesGroup.getChildren();
		createDescription(parent, EsbViewsRepository.CallTemplateMediator.Properties.description, EsbMessages.CallTemplateMediatorPropertiesEditionPart_DescriptionLabel);
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
							CallTemplateMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CallTemplateMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CallTemplateMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CallTemplateMediator.Properties.description,
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
									CallTemplateMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.CallTemplateMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallTemplateMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		Control [] newControls = propertiesGroup.getChildren();
		descriptionElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
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
		EditingUtils.setID(commentsList, EsbViewsRepository.CallTemplateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CallTemplateMediator.Properties.commentsList, EsbMessages.CallTemplateMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "CallTemplateMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.CallTemplateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
	    reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CallTemplateMediator.Properties.reverse, EsbMessages.CallTemplateMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.CallTemplateMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		Control reverseHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallTemplateMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createAvailableTemplatesText(FormToolkit widgetFactory, Composite parent) {
		Control availableTemplatesLabel = createDescription(parent, EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates, EsbMessages.CallTemplateMediatorPropertiesEditionPart_AvailableTemplatesLabel);
		availableTemplates = new EMFComboViewer(parent);
		availableTemplates.setContentProvider(new ArrayContentProvider());
		availableTemplates.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData valueTypeData = new GridData(GridData.FILL_HORIZONTAL);
        availableTemplates.getCombo().setLayoutData(valueTypeData);
        Object [] availableTemplateList = EEFPropertyViewUtil.getAvailableTemplateList().toArray();
        String [] availableTemplateNameList = Arrays.copyOf(availableTemplateList, availableTemplateList.length, String[].class);
        availableTemplates.getCombo().setItems(availableTemplateNameList);
        availableTemplates.getCombo().select(0);
        availableTemplates.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
        availableTemplates.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                            null, getAvailableTemplates()));
            }

        });
        availableTemplates.setID(EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates);
		Control availableTemplatesHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
		        EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAvailableTemplatesText
		availableTemplatesElements = new Control[] {availableTemplatesLabel, availableTemplates.getCombo(), availableTemplatesHelp};
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * @generated NOT
	 */
	protected Composite createTemplateParametersTableComposition(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
		this.templateParameters = new ReferencesTable(getDescription(EsbViewsRepository.CallTemplateMediator.Properties.templateParameters, EsbMessages.CallTemplateMediatorPropertiesEditionPart_TemplateParametersLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateMediator.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				templateParameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateMediator.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				templateParameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateMediator.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				templateParameters.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateMediator.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				templateParameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.templateParametersFilters) {
			this.templateParameters.addFilter(filter);
		}
		this.templateParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallTemplateMediator.Properties.templateParameters, EsbViewsRepository.FORM_KIND));
		this.templateParameters.createControls(parent, widgetFactory);
		this.templateParameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateMediator.Properties.templateParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData templateParametersData = new GridData(GridData.FILL_HORIZONTAL);
		templateParametersData.horizontalSpan = 3;
		this.templateParameters.setLayoutData(templateParametersData);
		this.templateParameters.setLowerBound(0);
		this.templateParameters.setUpperBound(-1);
		templateParameters.setID(EsbViewsRepository.CallTemplateMediator.Properties.templateParameters);
		templateParameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTemplateParametersTableComposition
		Control [] newControls = propertiesGroup.getChildren();
		templateParametersElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createTargetTemplateText(FormToolkit widgetFactory, Composite parent) {
		Control targeTemplateLabel = createDescription(parent, EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate, EsbMessages.CallTemplateMediatorPropertiesEditionPart_TargetTemplateLabel);
		targetTemplate = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		targetTemplate.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData targetTemplateData = new GridData(GridData.FILL_HORIZONTAL);
		targetTemplate.setLayoutData(targetTemplateData);
		targetTemplate.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CallTemplateMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetTemplate.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CallTemplateMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, targetTemplate.getText()));
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
									CallTemplateMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		targetTemplate.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetTemplate.getText()));
				}
			}
		});
		EditingUtils.setID(targetTemplate, EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate);
		EditingUtils.setEEFtype(targetTemplate, "eef::Text"); //$NON-NLS-1$
		Control targeTemplateHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetTemplateText
		targetTemplateElements = new Control[] {targeTemplateLabel, targetTemplate, targeTemplateHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createOnErrorWidget(FormToolkit widgetFactory, Composite parent) {
        Control onErrorLabel = createDescription(parent,
                EsbViewsRepository.CallTemplateMediator.Properties.onError, EsbMessages.CallTemplateMediatorPropertiesEditionPart_OnErrorLabel);
        widgetFactory.paintBordersFor(parent);
        if (onError == null) {
            onError = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initValueExpression = onError.getKeyValue().isEmpty() ? ""
                : onError.getKeyValue();
        onErrorText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        onErrorText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        onErrorText.setLayoutData(valueData);
        onErrorText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, onError, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                onErrorText.setText(onError.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(
                        new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CallTemplateMediator.Properties.onError,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                getOnError()));
            }

        });

        onErrorText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, onError, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    onErrorText.setText(onError.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CallTemplateMediator.Properties.onError,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getOnError()));
                }
            }

        });
        EditingUtils.setID(onErrorText,
                EsbViewsRepository.CallTemplateMediator.Properties.onError);
        EditingUtils.setEEFtype(onErrorText, "eef::Text");
        Control onErrorHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.CallTemplateMediator.Properties.onError,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        onErrorElements = new Control[] { onErrorLabel,
                onErrorText, onErrorHelp };
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.CallTemplateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.CallTemplateMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.CallTemplateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#getAvailableTemplates()
	 * 
	 */
	public String getAvailableTemplates() {
		return availableTemplates.getCombo().getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#setAvailableTemplates(String newValue)
	 * 
	 */
	public void setAvailableTemplates(String newValue) {
		if (newValue != null) {
		    selectAvailableTemplateComboBox(newValue);
		} else {
			availableTemplates.getCombo().select(0); //$NON-NLS-1$
		}
		//update target template
		if(availableTemplates.getCombo().getSelectionIndex() != 0) {
		    setTargetTemplate(availableTemplates.getCombo().getText());
		} else {
		    setTargetTemplate("");
		}
		if (propertiesEditionComponent != null) {
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateMediatorPropertiesEditionPartForm.this,
                    EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                    null, targetTemplate.getText()));
        }
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates);
		if (eefElementEditorReadOnlyState && availableTemplates.isEnabled()) {
			availableTemplates.setEnabled(false);
			availableTemplates.setToolTipText(EsbMessages.CallTemplateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !availableTemplates.isEnabled()) {
			availableTemplates.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#initTemplateParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTemplateParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		templateParameters.setContentProvider(contentProvider);
		templateParameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateMediator.Properties.templateParameters);
		if (eefElementEditorReadOnlyState && templateParameters.isEnabled()) {
			templateParameters.setEnabled(false);
			templateParameters.setToolTipText(EsbMessages.CallTemplateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !templateParameters.isEnabled()) {
			templateParameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#updateTemplateParameters()
	 * 
	 */
	public void updateTemplateParameters() {
	templateParameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#addFilterTemplateParameters(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTemplateParameters(ViewerFilter filter) {
		templateParametersFilters.add(filter);
		if (this.templateParameters != null) {
			this.templateParameters.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#addBusinessFilterTemplateParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTemplateParameters(ViewerFilter filter) {
		templateParametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#isContainedInTemplateParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInTemplateParametersTable(EObject element) {
		return ((ReferencesTableSettings)templateParameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#getTargetTemplate()
	 * 
	 */
	public String getTargetTemplate() {
		return targetTemplate.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart#setTargetTemplate(String newValue)
	 * 
	 */
	public void setTargetTemplate(String newValue) {
		if (newValue != null) {
			targetTemplate.setText(newValue);
			selectAvailableTemplateComboBox(newValue);
		} else {
			targetTemplate.setText(""); //$NON-NLS-1$
		}

		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate);
		if (eefElementEditorReadOnlyState && targetTemplate.isEnabled()) {
			targetTemplate.setEnabled(false);
			targetTemplate.setToolTipText(EsbMessages.CallTemplateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetTemplate.isEnabled()) {
			targetTemplate.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CallTemplateMediator_Part_Title;
	}

	// Start of user code additional methods
	@Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] {propertiesGroup});
        epv.showEntry(descriptionElements, false);
        epv.showEntry(availableTemplatesElements, false);
        epv.showEntry(templateParametersElements, false);
        epv.showEntry(targetTemplateElements, false);
        epv.showEntry(onErrorElements, false);
        view.layout(true, true);
    }

    public void selectAvailableTemplateComboBox(String newValue) {
        String [] availableTempaltesList = availableTemplates.getCombo().getItems();
        for(int i=0;i < availableTempaltesList.length;i++) {
            String availableTemplate = availableTempaltesList[i];
            if(availableTemplate.equals(newValue)) {
               availableTemplates.getCombo().select(i);
            }
        }
    }

    @Override
    public void setOnError(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            onErrorText.setText(registryKeyProperty.getKeyValue());
            onError = registryKeyProperty;
        }        
    }

    @Override
    public RegistryKeyProperty getOnError() {
        return onError;
    }

	// End of user code


}
