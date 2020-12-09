/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
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
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class IterateMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, IterateMediatorPropertiesEditionPart {

    protected Text description;
    protected Text commentsList;
    protected Button editCommentsList;
    protected EList commentsListList;
    protected Button reverse;
    protected Text iterateID;
    protected Button sequentialMediation;
    protected Button continueParent;
    protected Button preservePayload;
    protected EMFComboViewer sequenceType;
    protected Text sequenceName;

    // Start of user code
    protected NamespacedProperty iterateExpression;
    protected RegistryKeyProperty sequenceKey;
    protected NamespacedProperty attachPath;
    protected ScrolledForm scrolledForm;

    protected Control[] sequenceNameElements;
    protected Control[] sequenceTypeElements;
    protected Control[] preservePayloadElements;
    protected Control[] continueParentElements;
    protected Control[] sequentialMediationElements;
    protected Control[] iterateIDElements;
    protected Control[] descriptionElements;
    protected Control[] iterateExpressionElements;
    protected Control[] attachPathElements;
    protected Control[] sequenceKeyElements;
    protected Text iterateExpressionText;
    protected Text sequenceKeyText;
    protected Text attachPathText;

    protected Composite propertiesGroup;
    protected Composite sequenceSubsection;
    // End of user code

    /**
     * For {@link ISection} use only.
     */
    public IterateMediatorPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public IterateMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
     * @generated NOT
     */
    public void createControls(final FormToolkit widgetFactory, Composite view) {
        CompositionSequence iterateMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
        CompositionStep propertiesStep = iterateMediatorStep
                .addStep(EsbViewsRepository.IterateMediator.Properties.class);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.commentsList);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.reverse);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.iterateID);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.iterateExpression);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.sequentialMediation);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.continueParent);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.preservePayload);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.attachPath);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.sequenceType);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.sequenceName);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.sequenceKey);
        propertiesStep.addStep(EsbViewsRepository.IterateMediator.Properties.description);

        composer = new PartComposer(iterateMediatorStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.IterateMediator.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.IterateMediator.Properties.description) {
                    return createDescriptionText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.IterateMediator.Properties.commentsList) {
                    return createCommentsListMultiValuedEditor(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.IterateMediator.Properties.reverse) {
                    return createReverseCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.IterateMediator.Properties.iterateID) {
                    return createIterateIDText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.IterateMediator.Properties.sequentialMediation) {
                    return createSequentialMediationCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.IterateMediator.Properties.continueParent) {
                    return createContinueParentCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.IterateMediator.Properties.preservePayload) {
                    return createPreservePayloadCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.IterateMediator.Properties.sequenceType) {
                    return createSequenceTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.IterateMediator.Properties.sequenceName) {
                    return createSequenceNameText(widgetFactory, sequenceSubsection);
                }
                // Start of user code for iterateExpression addToPart creation
                if (key == EsbViewsRepository.IterateMediator.Properties.iterateExpression) {
                    return createIterateExpressionWidget(widgetFactory, parent);
                }
                // End of upropertiesGroupser code
                // Start of user code for sequenceKey addToPart creation
                if (key == EsbViewsRepository.IterateMediator.Properties.sequenceKey) {
                    return createSequenceKeyWidget(widgetFactory, sequenceSubsection);
                }
                // End of user code
                // Start of user code for attachPath createIterateMediatorWidgetaddToPart creation
                if (key == EsbViewsRepository.IterateMediator.Properties.attachPath) {
                    return createAttachPathWidget(widgetFactory, parent);
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
        Section propertiesSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        propertiesSection.setText(EsbMessages.IterateMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
        Control descriptionLabel = createDescription(parent, EsbViewsRepository.IterateMediator.Properties.description,
                EsbMessages.IterateMediatorPropertiesEditionPart_DescriptionLabel);
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
                            IterateMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.IterateMediator.Properties.description, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, description.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.IterateMediator.Properties.description,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    description.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            IterateMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
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
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.IterateMediator.Properties.description,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        description.getText()));
                }
            }
        });
        EditingUtils.setID(description, EsbViewsRepository.IterateMediator.Properties.description);
        EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
        Control descripytionTextHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.description,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createDescriptionText
        descriptionElements = new Control[] { descriptionLabel, description, descripytionTextHelp };
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
        EditingUtils.setID(commentsList, EsbViewsRepository.IterateMediator.Properties.commentsList);
        EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
        editCommentsList = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.IterateMediator.Properties.commentsList,
                        EsbMessages.IterateMediatorPropertiesEditionPart_CommentsListLabel),
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
                EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(commentsList.getShell(), "IterateMediator", //$NON-NLS-1$
                        new AdapterFactoryLabelProvider(adapterFactory), commentsListList,
                        EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null, false, true, null, null);
                if (dialog.open() == Window.OK) {
                    commentsListList = dialog.getResult();
                    if (commentsListList == null) {
                        commentsListList = new BasicEList();
                    }
                    commentsList.setText(commentsListList.toString());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            IterateMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.IterateMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
                    setHasChanged(true);
                }
            }
        });
        EditingUtils.setID(editCommentsList, EsbViewsRepository.IterateMediator.Properties.commentsList);
        EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
        // Start of user code for createCommentsListMultiValuedEditor

        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
        reverse = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.IterateMediator.Properties.reverse,
                        EsbMessages.IterateMediatorPropertiesEditionPart_ReverseLabel),
                SWT.CHECK);
        reverse.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            IterateMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.IterateMediator.Properties.reverse, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
            }

        });
        GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
        reverseData.horizontalSpan = 2;
        reverse.setLayoutData(reverseData);
        EditingUtils.setID(reverse, EsbViewsRepository.IterateMediator.Properties.reverse);
        EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.IterateMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createReverseCheckbox

        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createIterateIDText(FormToolkit widgetFactory, Composite parent) {
        Control iterateIDLabel = createDescription(parent, EsbViewsRepository.IterateMediator.Properties.iterateID,
                EsbMessages.IterateMediatorPropertiesEditionPart_IterateIDLabel);
        iterateID = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        iterateID.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData iterateIDData = new GridData(GridData.FILL_HORIZONTAL);
        iterateID.setLayoutData(iterateIDData);
        iterateID.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            IterateMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.IterateMediator.Properties.iterateID, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, iterateID.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.IterateMediator.Properties.iterateID,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    iterateID.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            IterateMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        iterateID.addKeyListener(new KeyAdapter() {
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
                                IterateMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.IterateMediator.Properties.iterateID, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, iterateID.getText()));
                }
            }
        });
        EditingUtils.setID(iterateID, EsbViewsRepository.IterateMediator.Properties.iterateID);
        EditingUtils.setEEFtype(iterateID, "eef::Text"); //$NON-NLS-1$
        Control iterateIDhelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.IterateMediator.Properties.iterateID, EsbViewsRepository.FORM_KIND),
                        null); // $NON-NLS-1$
        // Start of user code for createIterateIDText
        iterateIDElements = new Control[] { iterateIDLabel, iterateID, iterateIDhelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createSequentialMediationCheckbox(FormToolkit widgetFactory, Composite parent) {
        sequentialMediation = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.IterateMediator.Properties.sequentialMediation,
                        EsbMessages.IterateMediatorPropertiesEditionPart_SequentialMediationLabel),
                SWT.CHECK);
        sequentialMediation.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.IterateMediator.Properties.sequentialMediation,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new Boolean(sequentialMediation.getSelection())));
            }

        });
        GridData sequentialMediationData = new GridData(GridData.FILL_HORIZONTAL);
        sequentialMediationData.horizontalSpan = 2;
        sequentialMediation.setLayoutData(sequentialMediationData);
        EditingUtils.setID(sequentialMediation, EsbViewsRepository.IterateMediator.Properties.sequentialMediation);
        EditingUtils.setEEFtype(sequentialMediation, "eef::Checkbox"); //$NON-NLS-1$
        Control sequentialMediationHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.IterateMediator.Properties.sequentialMediation,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createSequentialMediationCheckbox
        sequentialMediationElements = new Control[] { sequentialMediation, sequentialMediationHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createContinueParentCheckbox(FormToolkit widgetFactory, Composite parent) {
        continueParent = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.IterateMediator.Properties.continueParent,
                        EsbMessages.IterateMediatorPropertiesEditionPart_ContinueParentLabel),
                SWT.CHECK);
        continueParent.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            IterateMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.IterateMediator.Properties.continueParent, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new Boolean(continueParent.getSelection())));
            }

        });
        GridData continueParentData = new GridData(GridData.FILL_HORIZONTAL);
        continueParentData.horizontalSpan = 2;
        continueParent.setLayoutData(continueParentData);
        EditingUtils.setID(continueParent, EsbViewsRepository.IterateMediator.Properties.continueParent);
        EditingUtils.setEEFtype(continueParent, "eef::Checkbox"); //$NON-NLS-1$
        Control continueParentHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.continueParent,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createContinueParentCheckbox
        continueParentElements = new Control[] { continueParent, continueParentHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createPreservePayloadCheckbox(FormToolkit widgetFactory, Composite parent) {
        preservePayload = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.IterateMediator.Properties.preservePayload,
                        EsbMessages.IterateMediatorPropertiesEditionPart_PreservePayloadLabel),
                SWT.CHECK);
        preservePayload.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.IterateMediator.Properties.preservePayload,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new Boolean(preservePayload.getSelection())));
            }

        });

        GridData preservePayloadData = new GridData(GridData.FILL_HORIZONTAL);
        preservePayloadData.horizontalSpan = 2;
        preservePayload.setLayoutData(preservePayloadData);
        EditingUtils.setID(preservePayload, EsbViewsRepository.IterateMediator.Properties.preservePayload);
        EditingUtils.setEEFtype(preservePayload, "eef::Checkbox"); //$NON-NLS-1$
        Control preservePayloadHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.preservePayload,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createPreservePayloadCheckbox
        preservePayloadElements = new Control[] { preservePayload, preservePayloadHelp };
        preservePayload.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                refresh();
            }

        });

        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        sequenceSubsection = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Sequence", true);
        Control sequenceTypeLabel = createDescription(sequenceSubsection,
                EsbViewsRepository.IterateMediator.Properties.sequenceType,
                EsbMessages.IterateMediatorPropertiesEditionPart_SequenceTypeLabel);
        sequenceType = new EMFComboViewer(sequenceSubsection);
        sequenceType.setContentProvider(new ArrayContentProvider());
        sequenceType
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData sequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
        sequenceType.getCombo().setLayoutData(sequenceTypeData);
        sequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
        sequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            IterateMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.IterateMediator.Properties.sequenceType, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getSequenceType()));
            }

        });
        sequenceType.setID(EsbViewsRepository.IterateMediator.Properties.sequenceType);
        Control sequenceTypeHelp = FormUtils.createHelpButton(widgetFactory, sequenceSubsection,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.sequenceType,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createSequenceTypeEMFComboViewer
        sequenceTypeElements = new Control[] { sequenceTypeLabel, sequenceType.getCombo(), sequenceTypeHelp };
        sequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

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
    protected Composite createSequenceNameText(FormToolkit widgetFactory, Composite parent) {
        Control sequenceNameLabel = createDescription(parent,
                EsbViewsRepository.IterateMediator.Properties.sequenceName,
                EsbMessages.IterateMediatorPropertiesEditionPart_SequenceNameLabel);
        sequenceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        sequenceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData sequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
        sequenceName.setLayoutData(sequenceNameData);
        sequenceName.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            IterateMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.IterateMediator.Properties.sequenceName, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, sequenceName.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.IterateMediator.Properties.sequenceName,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    sequenceName.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            IterateMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        sequenceName.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.IterateMediator.Properties.sequenceName,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        sequenceName.getText()));
                }
            }
        });
        EditingUtils.setID(sequenceName, EsbViewsRepository.IterateMediator.Properties.sequenceName);
        EditingUtils.setEEFtype(sequenceName, "eef::Text"); //$NON-NLS-1$
        Control sequenceNameHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.sequenceName,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createSequenceNameText
        sequenceNameElements = new Control[] { sequenceNameLabel, sequenceName, sequenceNameHelp };
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getDescription()
     * 
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setDescription(String
     *      newValue)
     * 
     */
    public void setDescription(String newValue) {
        if (newValue != null) {
            description.setText(newValue);
        } else {
            description.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.description);
        if (eefElementEditorReadOnlyState && description.isEnabled()) {
            description.setEnabled(false);
            description.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
            description.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getCommentsList()
     * 
     */
    public EList getCommentsList() {
        return commentsListList;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setCommentsList(EList
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
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.commentsList);
        if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
            commentsList.setEnabled(false);
            commentsList.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getReverse()
     * 
     */
    public Boolean getReverse() {
        return Boolean.valueOf(reverse.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setReverse(Boolean
     *      newValue)
     * 
     */
    public void setReverse(Boolean newValue) {
        if (newValue != null) {
            reverse.setSelection(newValue.booleanValue());
        } else {
            reverse.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.reverse);
        if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
            reverse.setEnabled(false);
            reverse.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
            reverse.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getIterateID()
     * 
     */
    public String getIterateID() {
        return iterateID.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setIterateID(String
     *      newValue)
     * 
     */
    public void setIterateID(String newValue) {
        if (newValue != null) {
            iterateID.setText(newValue);
        } else {
            iterateID.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.iterateID);
        if (eefElementEditorReadOnlyState && iterateID.isEnabled()) {
            iterateID.setEnabled(false);
            iterateID.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !iterateID.isEnabled()) {
            iterateID.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getSequentialMediation()
     * 
     */
    public Boolean getSequentialMediation() {
        return Boolean.valueOf(sequentialMediation.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setSequentialMediation(Boolean
     *      newValue)
     * 
     */
    public void setSequentialMediation(Boolean newValue) {
        if (newValue != null) {
            sequentialMediation.setSelection(newValue.booleanValue());
        } else {
            sequentialMediation.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.IterateMediator.Properties.sequentialMediation);
        if (eefElementEditorReadOnlyState && sequentialMediation.isEnabled()) {
            sequentialMediation.setEnabled(false);
            sequentialMediation.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sequentialMediation.isEnabled()) {
            sequentialMediation.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getContinueParent()
     * 
     */
    public Boolean getContinueParent() {
        return Boolean.valueOf(continueParent.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setContinueParent(Boolean
     *      newValue)
     * 
     */
    public void setContinueParent(Boolean newValue) {
        if (newValue != null) {
            continueParent.setSelection(newValue.booleanValue());
        } else {
            continueParent.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.IterateMediator.Properties.continueParent);
        if (eefElementEditorReadOnlyState && continueParent.isEnabled()) {
            continueParent.setEnabled(false);
            continueParent.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !continueParent.isEnabled()) {
            continueParent.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getPreservePayload()
     * 
     */
    public Boolean getPreservePayload() {
        return Boolean.valueOf(preservePayload.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setPreservePayload(Boolean
     *      newValue)
     * 
     */
    public void setPreservePayload(Boolean newValue) {
        if (newValue != null) {
            preservePayload.setSelection(newValue.booleanValue());
        } else {
            preservePayload.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.IterateMediator.Properties.preservePayload);
        if (eefElementEditorReadOnlyState && preservePayload.isEnabled()) {
            preservePayload.setEnabled(false);
            preservePayload.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !preservePayload.isEnabled()) {
            preservePayload.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getSequenceType()
     * 
     */
    public Enumerator getSequenceType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) sequenceType.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#initSequenceType(Object
     *      input, Enumerator current)
     */
    public void initSequenceType(Object input, Enumerator current) {
        sequenceType.setInput(input);
        sequenceType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.sequenceType);
        if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
            sequenceType.setEnabled(false);
            sequenceType.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
            sequenceType.setEnabled(true);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setSequenceType(Enumerator
     *      newValue)
     * 
     */
    public void setSequenceType(Enumerator newValue) {
        sequenceType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.sequenceType);
        if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
            sequenceType.setEnabled(false);
            sequenceType.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
            sequenceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#getSequenceName()
     * 
     */
    public String getSequenceName() {
        return sequenceName.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.IterateMediatorPropertiesEditionPart#setSequenceName(String
     *      newValue)
     * 
     */
    public void setSequenceName(String newValue) {
        if (newValue != null) {
            sequenceName.setText(newValue);
        } else {
            sequenceName.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.IterateMediator.Properties.sequenceName);
        if (eefElementEditorReadOnlyState && sequenceName.isEnabled()) {
            sequenceName.setEnabled(false);
            sequenceName.setToolTipText(EsbMessages.IterateMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sequenceName.isEnabled()) {
            sequenceName.setEnabled(true);
        }

    }

    // Start of user code for iterateExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getIterateExpression() {
        return iterateExpression;
    }

    @Override
    public void setIterateExpression(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            iterateExpressionText.setText(nameSpacedProperty.getPropertyValue());
            iterateExpression = nameSpacedProperty;
        }

    }
    // End of user code

    // Start of user code for sequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getSequenceKey() {
        return sequenceKey;
    }

    @Override
    public void setSequenceKey(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            sequenceKeyText.setText(registryKeyProperty.getKeyValue());
            sequenceKey = registryKeyProperty;
        }
    }

    // End of user code

    // Start of user code for attachPath specific getters and setters implementation
    @Override
    public NamespacedProperty getAttachPath() {
        return attachPath;
    }

    @Override
    public void setAttachPath(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            attachPathText.setText(nameSpacedProperty.getPropertyValue());
            attachPath = nameSpacedProperty;
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
        return EsbMessages.IterateMediator_Part_Title;
    }

    // Start of user code additional methods
    protected Composite createIterateExpressionWidget(FormToolkit widgetFactory, final Composite parent) {
        Control iterateExpressionLabel = createDescription(parent,
                EsbViewsRepository.IterateMediator.Properties.iterateExpression,
                EsbMessages.IterateMediatorPropertiesEditionPart_IterateExpressionLabel);
        widgetFactory.paintBordersFor(parent);
        if (iterateExpression == null) {
            iterateExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = iterateExpression.getPropertyValue().isEmpty() ? ""
                : iterateExpression.getPropertyValue();
        iterateExpressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        iterateExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        iterateExpressionText.setLayoutData(valueData);
        iterateExpressionText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, iterateExpression);
                iterateExpression = nspd.open();
                iterateExpressionText.setText(iterateExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        IterateMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.IterateMediator.Properties.iterateExpression, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getIterateExpression()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {

            }
        });
        
        iterateExpressionText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, iterateExpression);
                    iterateExpression = nspd.open();
                    iterateExpressionText.setText(iterateExpression.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            IterateMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.IterateMediator.Properties.iterateExpression, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getIterateExpression()));
                }
            }
            
        });

        EditingUtils.setID(iterateExpressionText, EsbViewsRepository.IterateMediator.Properties.iterateExpression);
        EditingUtils.setEEFtype(iterateExpressionText, "eef::Text");
        Control iterateExpressionHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.IterateMediator.Properties.iterateExpression, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        iterateExpressionElements = new Control[] { iterateExpressionLabel, iterateExpressionText,
                iterateExpressionHelp };
        return parent;
    }

    protected Composite createSequenceKeyWidget(FormToolkit widgetFactory, Composite parent) {
        Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.IterateMediator.Properties.sequenceKey,
                "Sequence Key");
        widgetFactory.paintBordersFor(parent);
        if (sequenceKey == null) {
            sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initValueExpression = sequenceKey.getKeyValue().isEmpty() ? "" : sequenceKey.getKeyValue();
        sequenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        sequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        sequenceKeyText.setLayoutData(valueData);
        sequenceKeyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                sequenceKeyText.setText(sequenceKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.IterateMediator.Properties.sequenceKey,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceKey()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {

            }
        });
        
        sequenceKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    sequenceKeyText.setText(sequenceKey.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.IterateMediator.Properties.sequenceKey,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceKey()));
                }
            }
            
        });

        EditingUtils.setID(sequenceKeyText, EsbViewsRepository.IterateMediator.Properties.sequenceKey);
        EditingUtils.setEEFtype(sequenceKeyText, "eef::Text");
        Control sequenceKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.IterateMediator.Properties.sequenceKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        sequenceKeyElements = new Control[] { sequenceKeyLabel, sequenceKeyText, sequenceKeyHelp };
        return parent;
    }

    protected Composite createAttachPathWidget(FormToolkit widgetFactory, final Composite parent) {
        Control attachPathLabel = createDescription(parent, EsbViewsRepository.IterateMediator.Properties.attachPath,
                "Attach Path");
        widgetFactory.paintBordersFor(parent);
        if (attachPath == null) {
            attachPath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = attachPath.getPropertyValue().isEmpty() ? "" : attachPath.getPropertyValue();
        attachPathText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        attachPathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        attachPathText.setLayoutData(valueData);
        attachPathText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, attachPath);
                attachPath = nspd.open();
                attachPathText.setText(attachPath.getPropertyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.IterateMediator.Properties.attachPath, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getAttachPath()));

            }

            @Override
            public void mouseDown(MouseEvent e) {

            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {

            }
        });
        
        attachPathText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, attachPath);
                    attachPath = nspd.open();
                    attachPathText.setText(attachPath.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(IterateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.IterateMediator.Properties.attachPath,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAttachPath()));
                }
            }

        });

        EditingUtils.setID(attachPathText, EsbViewsRepository.IterateMediator.Properties.attachPath);
        EditingUtils.setEEFtype(attachPathText, "eef::Text");
        Control attachExpressionHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.IterateMediator.Properties.attachPath, EsbViewsRepository.FORM_KIND),
                        null); // $NON-NLS-1$
        attachPathElements = new Control[] { attachPathLabel, attachPathText, attachExpressionHelp };
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
        eu.showEntry(new Control[] {sequenceSubsection.getParent()}, false);
        eu.clearElements(new Composite[] { sequenceSubsection });
        eu.showEntry(iterateIDElements, false);
        eu.showEntry(sequentialMediationElements, false);
        eu.showEntry(continueParentElements, false);
        eu.showEntry(preservePayloadElements, false);
        eu.showEntry(descriptionElements, false);

        if (getPreservePayload()) {
            eu.showEntry(attachPathElements, false);
        }
        eu.showEntry(iterateExpressionElements, false);
        eu.showEntry(sequenceTypeElements, false);

        switch (getSequenceType().getName()) {
        case "RegistryReference": {
            eu.showEntry(sequenceKeyElements, false);
            break;
        }
        case "NamedReference": {
            eu.showEntry(sequenceNameElements, false);
            break;

        }
        default:
            break;

        }

        view.layout(true, true);
    }

    // End of user code

}
