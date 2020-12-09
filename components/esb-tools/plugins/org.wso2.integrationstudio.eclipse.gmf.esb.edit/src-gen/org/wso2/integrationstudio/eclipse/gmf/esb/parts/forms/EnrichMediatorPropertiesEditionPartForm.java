/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

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

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

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
import org.wso2.integrationstudio.eclipse.gmf.esb.EnrichSourceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
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
public class EnrichMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, EnrichMediatorPropertiesEditionPart {

    protected Text description;
    protected Text commentsList;
    protected Button editCommentsList;
    protected EList commentsListList;
    protected Button reverse;
    protected Button cloneSource;
    protected EMFComboViewer sourceType;
    protected EMFComboViewer inlineType;
    protected Text sourceXML;
    protected Text sourceProperty;
    // Start of user code for sourceXPath widgets declarations
    protected NamespacedProperty sourceXPath;
    protected Text sourceXPathText;
    // End of user code

    // Start of user code for inlineRegistryKey widgets declarations
    protected RegistryKeyProperty inlineRegistryKey;
    protected Text inlineRegistryKeyText;
    // End of user code

    protected EMFComboViewer targetAction;
    protected EMFComboViewer targetType;
    protected Text targetProperty;
    // Start of user code for targetXPath widgets declarations
    protected NamespacedProperty targetXPath;
    protected Text targetXPathText;
    protected Control[] descriptionElements;
    protected Control[] cloneSourceElements;
    protected Control[] sourceTypeElements;
    protected Control[] inlineTypeElements;
    protected Control[] sourceXMLElements;
    protected Control[] sourcePropertyElements;
    protected Control[] targetActionElements;
    protected Control[] targetTypeElements;
    protected Control[] targetPropertyElements;
    protected Control[] sourceXPathElements;
    protected Control[] inlineRegistryElements;
    protected Control[] targetXPathElements;
    protected Composite miscGroup;
    protected Composite sourceGroup;
    protected Composite targetGroup;
    // End of user code

    /**
     * For {@link ISection} use only.
     */
    public EnrichMediatorPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public EnrichMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
        super(editionComponent);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
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
     *      createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
     * 
     */
    public void createControls(final FormToolkit widgetFactory, Composite view) {
        // Start of user code
        CompositionSequence enrichMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);

        CompositionStep sourceStep = enrichMediatorStep.addStep(EsbViewsRepository.EnrichMediator.Source.class);
        sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.cloneSource);
        sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.sourceType);
        sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.inlineType);
        sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.sourceXML);
        sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.sourceProperty);
        sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.sourceXPath);
        sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey);

        CompositionStep targetStep = enrichMediatorStep.addStep(EsbViewsRepository.EnrichMediator.Target.class);
        targetStep.addStep(EsbViewsRepository.EnrichMediator.Target.targetAction);
        targetStep.addStep(EsbViewsRepository.EnrichMediator.Target.targetType);
        targetStep.addStep(EsbViewsRepository.EnrichMediator.Target.targetProperty);
        targetStep.addStep(EsbViewsRepository.EnrichMediator.Target.targetXPath);
        
        CompositionStep miscStep = enrichMediatorStep.addStep(EsbViewsRepository.EnrichMediator.Misc.class);
        miscStep.addStep(EsbViewsRepository.EnrichMediator.Misc.description);
        miscStep.addStep(EsbViewsRepository.EnrichMediator.Misc.commentsList);
        miscStep.addStep(EsbViewsRepository.EnrichMediator.Misc.reverse);
        // End of user code
        composer = new PartComposer(enrichMediatorStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.EnrichMediator.Misc.class) {
                    return createMiscGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Misc.description) {
                    return createDescriptionText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Misc.commentsList) {
                    return createCommentsListMultiValuedEditor(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Misc.reverse) {
                    return createReverseCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Source.class) {
                    return createSourceGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Source.cloneSource) {
                    return createCloneSourceCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Source.sourceType) {
                    return createSourceTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Source.inlineType) {
                    return createInlineTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Source.sourceXML) {
                    return createSourceXMLText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Source.sourceProperty) {
                    return createSourcePropertyText(widgetFactory, parent);
                }
                // Start of user code for sourceXPath addToPart creation
                if (key == EsbViewsRepository.EnrichMediator.Source.sourceXPath) {
                    return createsourceXPathWidget(widgetFactory, parent);
                }
                // End of user code
                // Start of user code for inlineRegistryKey addToPart creation
                if (key == EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey) {
                    return createInlineRegistryKeyWidget(widgetFactory, parent);
                }

                // End of user code
                if (key == EsbViewsRepository.EnrichMediator.Target.class) {
                    return createTargetGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Target.targetAction) {
                    return createTargetActionEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Target.targetType) {
                    return createTargetTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EnrichMediator.Target.targetProperty) {
                    return createTargetPropertyText(widgetFactory, parent);
                }
                // Start of user code for targetXPath addToPart creation
                if (key == EsbViewsRepository.EnrichMediator.Target.targetXPath) {
                    return createtargetXPathWidget(widgetFactory, parent);
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
    protected Composite createMiscGroup(FormToolkit widgetFactory, final Composite parent) {
        Section miscSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        miscSection.setText(EsbMessages.EnrichMediatorPropertiesEditionPart_MiscGroupLabel);
        GridData miscSectionData = new GridData(GridData.FILL_HORIZONTAL);
        miscSectionData.horizontalSpan = 3;
        miscSection.setLayoutData(miscSectionData);
        miscGroup = widgetFactory.createComposite(miscSection);
        GridLayout miscGroupLayout = new GridLayout();
        miscGroupLayout.numColumns = 3;
        miscGroup.setLayout(miscGroupLayout);
        miscSection.setClient(miscGroup);
        return miscGroup;
    }
    
    /**
     * @generated NOT
     */
    protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.EnrichMediator.Misc.description,
                EsbMessages.EnrichMediatorPropertiesEditionPart_DescriptionLabel);
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
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Misc.description, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, description.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EnrichMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EnrichMediator.Misc.description, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, description.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EnrichMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                EnrichMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.EnrichMediator.Misc.description, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, description.getText()));
                }
            }
        });
        EditingUtils.setID(description, EsbViewsRepository.EnrichMediator.Misc.description);
        EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EnrichMediator.Misc.description, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createDescriptionText
        descriptionElements = new Control[] { itemLabel, description, itemHelp };

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
        EditingUtils.setID(commentsList, EsbViewsRepository.EnrichMediator.Misc.commentsList);
        EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
        editCommentsList = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.EnrichMediator.Misc.commentsList,
                        EsbMessages.EnrichMediatorPropertiesEditionPart_CommentsListLabel),
                SWT.NONE);
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
                EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(commentsList.getShell(), "EnrichMediator", //$NON-NLS-1$
                        new AdapterFactoryLabelProvider(adapterFactory), commentsListList,
                        EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null, false, true, null, null);
                if (dialog.open() == Window.OK) {
                    commentsListList = dialog.getResult();
                    if (commentsListList == null) {
                        commentsListList = new BasicEList();
                    }
                    commentsList.setText(commentsListList.toString());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Misc.commentsList, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
                    setHasChanged(true);
                }
            }
        });
        EditingUtils.setID(editCommentsList, EsbViewsRepository.EnrichMediator.Misc.commentsList);
        EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
        // Start of user code for createCommentsListMultiValuedEditor

        // End of user code
        return parent;
    }

    protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
        reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.EnrichMediator.Misc.reverse,
                EsbMessages.EnrichMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
        reverse.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Misc.reverse, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
            }

        });
        GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
        reverseData.horizontalSpan = 2;
        reverse.setLayoutData(reverseData);
        EditingUtils.setID(reverse, EsbViewsRepository.EnrichMediator.Misc.reverse);
        EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.EnrichMediator.Misc.reverse, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createReverseCheckbox

        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createSourceGroup(FormToolkit widgetFactory, final Composite parent) {
        Section sourceSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        sourceSection.setText(EsbMessages.EnrichMediatorPropertiesEditionPart_SourceGroupLabel);
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

    /**
     * @generated NOT
     */
    protected Composite createCloneSourceCheckbox(FormToolkit widgetFactory, Composite parent) {
        cloneSource = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.EnrichMediator.Source.cloneSource,
                        EsbMessages.EnrichMediatorPropertiesEditionPart_CloneSourceLabel),
                SWT.CHECK);
        cloneSource.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Source.cloneSource, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, new Boolean(cloneSource.getSelection())));
            }

        });
        GridData cloneSourceData = new GridData(GridData.FILL_HORIZONTAL);
        cloneSourceData.horizontalSpan = 2;
        cloneSource.setLayoutData(cloneSourceData);
        EditingUtils.setID(cloneSource, EsbViewsRepository.EnrichMediator.Source.cloneSource);
        EditingUtils.setEEFtype(cloneSource, "eef::Checkbox"); //$NON-NLS-1$
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EnrichMediator.Source.cloneSource, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createCloneSourceCheckbox
        cloneSourceElements = new Control[] { cloneSource, itemHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createSourceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.EnrichMediator.Source.sourceType,
                EsbMessages.EnrichMediatorPropertiesEditionPart_SourceTypeLabel);
        sourceType = new EMFComboViewer(parent);
        sourceType.setContentProvider(new ArrayContentProvider());
        sourceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData sourceTypeData = new GridData(GridData.FILL_HORIZONTAL);
        sourceType.getCombo().setLayoutData(sourceTypeData);
        sourceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
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
                            new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Source.sourceType, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getSourceType()));
            }

        });
        sourceType.setID(EsbViewsRepository.EnrichMediator.Source.sourceType);
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EnrichMediator.Source.sourceType, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
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
     * @generated NOT
     */
    protected Composite createInlineTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.EnrichMediator.Source.inlineType,
                EsbMessages.EnrichMediatorPropertiesEditionPart_InlineTypeLabel);
        inlineType = new EMFComboViewer(parent);
        inlineType.setContentProvider(new ArrayContentProvider());
        inlineType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData inlineTypeData = new GridData(GridData.FILL_HORIZONTAL);
        inlineType.getCombo().setLayoutData(inlineTypeData);
        inlineType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
        inlineType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Source.inlineType, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getInlineType()));
            }

        });
        inlineType.setID(EsbViewsRepository.EnrichMediator.Source.inlineType);
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EnrichMediator.Source.inlineType, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createInlineTypeEMFComboViewer
        inlineTypeElements = new Control[] { itemLabel, inlineType.getCombo(), itemHelp };
        inlineType.addSelectionChangedListener(new ISelectionChangedListener() {

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
    protected Composite createSourceXMLText(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.EnrichMediator.Source.sourceXML,
                EsbMessages.EnrichMediatorPropertiesEditionPart_SourceXMLLabel);
        sourceXML = widgetFactory.createText(parent, "", SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
        sourceXML.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData sourceXMLData = new GridData(GridData.FILL_HORIZONTAL);
        sourceXMLData.heightHint = sourceXML.getLineHeight()*4;
        sourceXML.setLayoutData(sourceXMLData);
        sourceXML.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Source.sourceXML, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, sourceXML.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EnrichMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EnrichMediator.Source.sourceXML, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, sourceXML.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EnrichMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        EditingUtils.setID(sourceXML, EsbViewsRepository.EnrichMediator.Source.sourceXML);
        EditingUtils.setEEFtype(sourceXML, "eef::Text"); //$NON-NLS-1$
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EnrichMediator.Source.sourceXML, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createSourceXMLText
        sourceXMLElements = new Control[] { itemLabel, sourceXML, itemHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createSourcePropertyText(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.EnrichMediator.Source.sourceProperty,
                EsbMessages.EnrichMediatorPropertiesEditionPart_SourcePropertyLabel);
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
                            EnrichMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EnrichMediator.Source.sourceProperty, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, sourceProperty.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Source.sourceProperty,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    sourceProperty.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EnrichMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
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
                                EnrichMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.EnrichMediator.Source.sourceProperty, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, sourceProperty.getText()));
                }
            }
        });
        EditingUtils.setID(sourceProperty, EsbViewsRepository.EnrichMediator.Source.sourceProperty);
        EditingUtils.setEEFtype(sourceProperty, "eef::Text"); //$NON-NLS-1$
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EnrichMediator.Source.sourceProperty, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createSourcePropertyText
        sourcePropertyElements = new Control[] { itemLabel, sourceProperty, itemHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createTargetGroup(FormToolkit widgetFactory, final Composite parent) {
        Section targetSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        targetSection.setText(EsbMessages.EnrichMediatorPropertiesEditionPart_TargetGroupLabel);
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

    /**
     * @generated NOT
     */
    protected Composite createTargetActionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.EnrichMediator.Target.targetAction,
                EsbMessages.EnrichMediatorPropertiesEditionPart_TargetActionLabel);
        targetAction = new EMFComboViewer(parent);
        targetAction.setContentProvider(new ArrayContentProvider());
        targetAction
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData targetActionData = new GridData(GridData.FILL_HORIZONTAL);
        targetAction.getCombo().setLayoutData(targetActionData);
        targetAction.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
        targetAction.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EnrichMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EnrichMediator.Target.targetAction, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getTargetAction()));
            }

        });
        targetAction.setID(EsbViewsRepository.EnrichMediator.Target.targetAction);
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EnrichMediator.Target.targetAction, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createTargetActionEMFComboViewer
        targetActionElements = new Control[] { itemLabel, targetAction.getCombo(), itemHelp };
        targetAction.addSelectionChangedListener(new ISelectionChangedListener() {

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
    protected Composite createTargetTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.EnrichMediator.Target.targetType,
                EsbMessages.EnrichMediatorPropertiesEditionPart_TargetTypeLabel);
        targetType = new EMFComboViewer(parent);
        targetType.setContentProvider(new ArrayContentProvider());
        targetType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData targetTypeData = new GridData(GridData.FILL_HORIZONTAL);
        targetType.getCombo().setLayoutData(targetTypeData);
        targetType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
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
                            new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Target.targetType, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getTargetType()));
            }

        });
        targetType.setID(EsbViewsRepository.EnrichMediator.Target.targetType);
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EnrichMediator.Target.targetType, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
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
     * @generated NOT
     */
    protected Composite createTargetPropertyText(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.EnrichMediator.Target.targetProperty,
                EsbMessages.EnrichMediatorPropertiesEditionPart_TargetPropertyLabel);
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
                            EnrichMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EnrichMediator.Target.targetProperty, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, targetProperty.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Target.targetProperty,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    targetProperty.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EnrichMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
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
                                EnrichMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.EnrichMediator.Target.targetProperty, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, targetProperty.getText()));
                }
            }
        });
        EditingUtils.setID(targetProperty, EsbViewsRepository.EnrichMediator.Target.targetProperty);
        EditingUtils.setEEFtype(targetProperty, "eef::Text"); //$NON-NLS-1$
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EnrichMediator.Target.targetProperty, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createTargetPropertyText
        targetPropertyElements = new Control[] { itemLabel, targetProperty, itemHelp };
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getDescription()
     * 
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setDescription(String
     *      newValue)
     * 
     */
    public void setDescription(String newValue) {
        if (newValue != null) {
            description.setText(newValue);
        } else {
            description.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Misc.description);
        if (eefElementEditorReadOnlyState && description.isEnabled()) {
            description.setEnabled(false);
            description.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
            description.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getCommentsList()
     * 
     */
    public EList getCommentsList() {
        return commentsListList;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setCommentsList(EList
     *      newValue)
     * 
     */
    public void setCommentsList(EList newValue) {
        commentsListList = newValue;
        if (newValue != null) {
            commentsList.setText(commentsListList.toString());
        } else {
            commentsList.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Misc.commentsList);
        if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
            commentsList.setEnabled(false);
            commentsList.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getReverse()
     * 
     */
    public Boolean getReverse() {
        return Boolean.valueOf(reverse.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setReverse(Boolean
     *      newValue)
     * 
     */
    public void setReverse(Boolean newValue) {
        if (newValue != null) {
            reverse.setSelection(newValue.booleanValue());
        } else {
            reverse.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Misc.reverse);
        if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
            reverse.setEnabled(false);
            reverse.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
            reverse.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getCloneSource()
     * 
     */
    public Boolean getCloneSource() {
        return Boolean.valueOf(cloneSource.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setCloneSource(Boolean
     *      newValue)
     * 
     */
    public void setCloneSource(Boolean newValue) {
        if (newValue != null) {
            cloneSource.setSelection(newValue.booleanValue());
        } else {
            cloneSource.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.cloneSource);
        if (eefElementEditorReadOnlyState && cloneSource.isEnabled()) {
            cloneSource.setEnabled(false);
            cloneSource.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !cloneSource.isEnabled()) {
            cloneSource.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getSourceType()
     * 
     */
    public Enumerator getSourceType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) sourceType.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initSourceType(Object
     *      input, Enumerator current)
     */
    public void initSourceType(Object input, Enumerator current) {
        sourceType.setInput(input);
        sourceType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.sourceType);
        if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
            sourceType.setEnabled(false);
            sourceType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
            sourceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setSourceType(Enumerator
     *      newValue)
     * 
     */
    public void setSourceType(Enumerator newValue) {
        sourceType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.sourceType);
        if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
            sourceType.setEnabled(false);
            sourceType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
            sourceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getInlineType()
     * 
     */
    public Enumerator getInlineType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) inlineType.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initInlineType(Object
     *      input, Enumerator current)
     */
    public void initInlineType(Object input, Enumerator current) {
        inlineType.setInput(input);
        inlineType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.inlineType);
        if (eefElementEditorReadOnlyState && inlineType.isEnabled()) {
            inlineType.setEnabled(false);
            inlineType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !inlineType.isEnabled()) {
            inlineType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setInlineType(Enumerator
     *      newValue)
     * 
     */
    public void setInlineType(Enumerator newValue) {
        inlineType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.inlineType);
        if (eefElementEditorReadOnlyState && inlineType.isEnabled()) {
            inlineType.setEnabled(false);
            inlineType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !inlineType.isEnabled()) {
            inlineType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getSourceXML()
     * 
     */
    public String getSourceXML() {
        return sourceXML.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setSourceXML(String
     *      newValue)
     * 
     */
    public void setSourceXML(String newValue) {
        if (newValue != null) {
            sourceXML.setText(newValue);
        } else {
            sourceXML.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.sourceXML);
        if (eefElementEditorReadOnlyState && sourceXML.isEnabled()) {
            sourceXML.setEnabled(false);
            sourceXML.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sourceXML.isEnabled()) {
            sourceXML.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getSourceProperty()
     * 
     */
    public String getSourceProperty() {
        return sourceProperty.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setSourceProperty(String
     *      newValue)
     * 
     */
    public void setSourceProperty(String newValue) {
        if (newValue != null) {
            sourceProperty.setText(newValue);
        } else {
            sourceProperty.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.sourceProperty);
        if (eefElementEditorReadOnlyState && sourceProperty.isEnabled()) {
            sourceProperty.setEnabled(false);
            sourceProperty.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sourceProperty.isEnabled()) {
            sourceProperty.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getTargetAction()
     * 
     */
    public Enumerator getTargetAction() {
        Enumerator selection = (Enumerator) ((StructuredSelection) targetAction.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initTargetAction(Object
     *      input, Enumerator current)
     */
    public void initTargetAction(Object input, Enumerator current) {
        targetAction.setInput(input);
        targetAction.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Target.targetAction);
        if (eefElementEditorReadOnlyState && targetAction.isEnabled()) {
            targetAction.setEnabled(false);
            targetAction.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !targetAction.isEnabled()) {
            targetAction.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setTargetAction(Enumerator
     *      newValue)
     * 
     */
    public void setTargetAction(Enumerator newValue) {
        targetAction.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Target.targetAction);
        if (eefElementEditorReadOnlyState && targetAction.isEnabled()) {
            targetAction.setEnabled(false);
            targetAction.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !targetAction.isEnabled()) {
            targetAction.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getTargetType()
     * 
     */
    public Enumerator getTargetType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) targetType.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initTargetType(Object
     *      input, Enumerator current)
     */
    public void initTargetType(Object input, Enumerator current) {
        targetType.setInput(input);
        targetType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Target.targetType);
        if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
            targetType.setEnabled(false);
            targetType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
            targetType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setTargetType(Enumerator
     *      newValue)
     * 
     */
    public void setTargetType(Enumerator newValue) {
        targetType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Target.targetType);
        if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
            targetType.setEnabled(false);
            targetType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
            targetType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getTargetProperty()
     * 
     */
    public String getTargetProperty() {
        return targetProperty.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setTargetProperty(String
     *      newValue)
     * 
     */
    public void setTargetProperty(String newValue) {
        if (newValue != null) {
            targetProperty.setText(newValue);
        } else {
            targetProperty.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Target.targetProperty);
        if (eefElementEditorReadOnlyState && targetProperty.isEnabled()) {
            targetProperty.setEnabled(false);
            targetProperty.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !targetProperty.isEnabled()) {
            targetProperty.setEnabled(true);
        }

    }

    // Start of user code for sourceXPath specific getters and setters implementation
    @Override
    public NamespacedProperty getSourceXPath() {
        // TODO Auto-generated method stub
        return sourceXPath;
    }

    @Override
    public void setSourceXPath(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            sourceXPathText.setText(nameSpacedProperty.getPropertyValue());
            sourceXPath = nameSpacedProperty;
        }

    }
    // End of user code

    // Start of user code for inlineRegistryKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getInlineRegistryKey() {
        // TODO Auto-generated method stub
        return inlineRegistryKey;
    }

    @Override
    public void setInlineRegistryKey(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            inlineRegistryKeyText.setText(registryKeyProperty.getKeyValue());
            inlineRegistryKey = registryKeyProperty;
        }

    }
    // End of user code

    // Start of user code for targetXPath specific getters and setters implementation
    @Override
    public NamespacedProperty getTargetXPath() {
        // TODO Auto-generated method stub
        return targetXPath;
    }

    @Override
    public void setTargetXPath(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            targetXPathText.setText(nameSpacedProperty.getPropertyValue());
            targetXPath = nameSpacedProperty;
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
        return EsbMessages.EnrichMediator_Part_Title;
    }

    // Start of user code additional methods
    protected Composite createsourceXPathWidget(FormToolkit widgetFactory, final Composite parent) {
        Control sourceXPathLabel = createDescription(parent, EsbViewsRepository.EnrichMediator.Source.sourceXPath,
                EsbMessages.EnrichMediatorPropertiesEditionPart_SourceXPathLabel);
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
                        .firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.EnrichMediator.Source.sourceXPath, PropertiesEditionEvent.COMMIT,
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
                            .firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Source.sourceXPath, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getSourceXPath()));
                }
            }
            
        });
        
        EditingUtils.setID(sourceXPathText, EsbViewsRepository.EnrichMediator.Source.sourceXPath);
        EditingUtils.setEEFtype(sourceXPathText, "eef::Text");
        Control sourceXPathHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.EnrichMediator.Target.targetXPath, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        sourceXPathElements = new Control[] { sourceXPathLabel, sourceXPathText, sourceXPathHelp };
        return parent;
    }

    protected Composite createInlineRegistryKeyWidget(FormToolkit widgetFactory, Composite parent) {
        Control inlineRegistryKeyLabel = createDescription(parent,
                EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey,
                EsbMessages.EnrichMediatorPropertiesEditionPart_InlineRegistryKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (inlineRegistryKey == null) {
            inlineRegistryKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initValueExpression = inlineRegistryKey.getKeyValue().isEmpty() ? "" : inlineRegistryKey.getKeyValue();
        inlineRegistryKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        inlineRegistryKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        inlineRegistryKeyText.setLayoutData(valueData);
        
        inlineRegistryKeyText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, inlineRegistryKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                inlineRegistryKeyText.setText(inlineRegistryKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        EnrichMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getInlineRegistryKey()));
            }

        });

        inlineRegistryKeyText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, inlineRegistryKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    inlineRegistryKeyText.setText(inlineRegistryKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EnrichMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getInlineRegistryKey()));
                }
            }

        });

        EditingUtils.setID(inlineRegistryKeyText, EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey);
        EditingUtils.setEEFtype(inlineRegistryKeyText, "eef::Text");
        Control inlineRegistryKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        inlineRegistryElements = new Control[] { inlineRegistryKeyLabel, inlineRegistryKeyText, inlineRegistryKeyHelp };
        return parent;
    }

    protected Composite createtargetXPathWidget(FormToolkit widgetFactory, final Composite parent) {
        Control targetXPathLabel = createDescription(parent, EsbViewsRepository.EnrichMediator.Target.targetXPath,
                EsbMessages.EnrichMediatorPropertiesEditionPart_TargetXPathLabel);
        widgetFactory.paintBordersFor(parent);
        if (targetXPath == null) {
            targetXPath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = targetXPath.getPropertyValue().isEmpty() ? "/default/expression"
                : targetXPath.getPropertyValue();
        targetXPathText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        targetXPathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        targetXPathText.setLayoutData(valueData);
        
        targetXPathText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, targetXPath);
                // valueExpression.setPropertyValue(valueExpressionText.getText());
                targetXPath = nspd.open();
                targetXPathText.setText(targetXPath.getPropertyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.EnrichMediator.Target.targetXPath, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getTargetXPath()));
            }
            
        });
        
        targetXPathText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, targetXPath);
                    // valueExpression.setPropertyValue(valueExpressionText.getText());
                    targetXPath = nspd.open();
                    targetXPathText.setText(targetXPath.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EnrichMediator.Target.targetXPath, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getTargetXPath()));
                }
            }
            
        });
        
        EditingUtils.setID(targetXPathText, EsbViewsRepository.EnrichMediator.Target.targetXPath);
        EditingUtils.setEEFtype(targetXPathText, "eef::Text");
        Control targetXPathHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.EnrichMediator.Target.targetXPath, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        targetXPathElements = new Control[] { targetXPathLabel, targetXPathText, targetXPathHelp };
        return parent;
    }
    
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] { miscGroup, sourceGroup, targetGroup });
        epv.showEntry(cloneSourceElements, false);
        epv.showEntry(sourceTypeElements, false);
        switch (getSourceType().getLiteral()) {
        case "custom": {
            epv.showEntry(sourceXPathElements, false);
            break;
        }

        case "property": {
            epv.showEntry(sourcePropertyElements, false);
            break;
        }

        case "inline": {
            epv.showEntry(inlineTypeElements, false);
            if(!((StructuredSelection) inlineType.getSelection()).isEmpty()) {
                switch (getInlineType().getLiteral()) {
                case "Inline XML/JSON": {
                    epv.showEntry(sourceXMLElements, false);
                    break;
                }
                case "RegistryKey": {
                    epv.showEntry(inlineRegistryElements, false);
                    break;
                }
                }
            } else {
                inlineType.setEnabled(true);
                setInlineType(new Enumerator() {
                    
                    @Override
                    public int getValue() {
                        // TODO Auto-generated method stub
                        return 0;
                    }
                    
                    @Override
                    public String getName() {
                        // TODO Auto-generated method stub
                        return null;
                    }
                    
                    @Override
                    public String getLiteral() {
                        // TODO Auto-generated method stub
                        return null;
                    }
                });
                epv.showEntry(sourceXMLElements, false);
            }

            break;
        }
        }

        epv.showEntry(targetActionElements, false);
        epv.showEntry(targetTypeElements, false);
        switch (getTargetType().getLiteral()) {
        case "custom": {
            epv.showEntry(targetXPathElements, false);
            break;
        }

        case "property": {
            epv.showEntry(targetPropertyElements, false);
            break;
        }
        }
        epv.showEntry(descriptionElements, false);
        view.layout(true, true);
    }
    // End of user code

}
