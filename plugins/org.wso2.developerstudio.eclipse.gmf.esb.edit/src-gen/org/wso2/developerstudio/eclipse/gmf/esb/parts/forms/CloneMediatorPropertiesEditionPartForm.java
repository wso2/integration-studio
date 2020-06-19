/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * @generated NOT
 */
public class CloneMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, CloneMediatorPropertiesEditionPart {

    protected Text description;
    protected Text commentsList;
    protected Button editCommentsList;
    protected EList commentsListList;
    protected Button reverse;
    protected Text cloneID;
    protected Button sequentialMediation;
    protected Button continueParent;
    protected ReferencesTable targets;
    protected List<ViewerFilter> targetsBusinessFilters = new ArrayList<ViewerFilter>();
    protected List<ViewerFilter> targetsFilters = new ArrayList<ViewerFilter>();
    protected ReferencesTable targetsOutputConnector;
    protected List<ViewerFilter> targetsOutputConnectorBusinessFilters = new ArrayList<ViewerFilter>();
    protected List<ViewerFilter> targetsOutputConnectorFilters = new ArrayList<ViewerFilter>();

    
    protected Control[] descriptionElements;
    protected Control[] commentListElements;
    protected Control[] cloneIDElements;
    protected Control[] sequencialMediationElements;
    protected Control[] continueParentElements;
    protected Control[] targetTableElements;
    protected Control[] targetOutputElements;
    protected Composite propertiesGroup;

    /**
     * For {@link ISection} use only.
     */
    public CloneMediatorPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public CloneMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
        super(editionComponent);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
     *      
     * @generated NOT    
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
        CompositionSequence cloneMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
        CompositionStep propertiesStep = cloneMediatorStep.addStep(EsbViewsRepository.CloneMediator.Properties.class);
        // Start of user code 
        propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.commentsList);
        propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.reverse);
        propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.cloneID);
        propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.sequentialMediation);
        propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.continueParent);
        propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.targets);
        propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector);
        propertiesStep.addStep(EsbViewsRepository.CloneMediator.Properties.description);
        // End of user code
        composer = new PartComposer(cloneMediatorStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.CloneMediator.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneMediator.Properties.description) {
                    return createDescriptionText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneMediator.Properties.commentsList) {
                    return createCommentsListMultiValuedEditor(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneMediator.Properties.reverse) {
                    return createReverseCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneMediator.Properties.cloneID) {
                    return createCloneIDText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneMediator.Properties.sequentialMediation) {
                    return createSequentialMediationCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneMediator.Properties.continueParent) {
                    return createContinueParentCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneMediator.Properties.targets) {
                    return createTargetsTableComposition(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector) {
                    return createTargetsOutputConnectorTableComposition(widgetFactory, parent);
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
        Section propertiesSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        propertiesSection.setText(EsbMessages.CloneMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
        Control itemLabel = createDescription(parent, EsbViewsRepository.CloneMediator.Properties.description,
                EsbMessages.CloneMediatorPropertiesEditionPart_DescriptionLabel);
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
                            CloneMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CloneMediator.Properties.description, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, description.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CloneMediator.Properties.description,
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
                            CloneMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
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
                                CloneMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CloneMediator.Properties.description, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, description.getText()));
                }
            }
        });
        EditingUtils.setID(description, EsbViewsRepository.CloneMediator.Properties.description);
        EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CloneMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createDescriptionText
        descriptionElements = new Control [] {itemLabel, description, itemHelp};
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
        Control [] previousControls = propertiesGroup.getChildren();
        commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
        GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
        commentsListData.horizontalSpan = 2;
        commentsList.setLayoutData(commentsListData);
        EditingUtils.setID(commentsList, EsbViewsRepository.CloneMediator.Properties.commentsList);
        EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
        editCommentsList = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.CloneMediator.Properties.commentsList,
                        EsbMessages.CloneMediatorPropertiesEditionPart_CommentsListLabel),
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
                EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(commentsList.getShell(), "CloneMediator", //$NON-NLS-1$
                        new AdapterFactoryLabelProvider(adapterFactory), commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null, false,
                        true, null, null);
                if (dialog.open() == Window.OK) {
                    commentsListList = dialog.getResult();
                    if (commentsListList == null) {
                        commentsListList = new BasicEList();
                    }
                    commentsList.setText(commentsListList.toString());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CloneMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CloneMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
                    setHasChanged(true);
                }
            }
        });
        EditingUtils.setID(editCommentsList, EsbViewsRepository.CloneMediator.Properties.commentsList);
        EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
        // Start of user code for createCommentsListMultiValuedEditor
        Control [] newControls = propertiesGroup.getChildren();
        commentListElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
        // End of user code
        return parent;
    }
    /**
     * @generated NOT
     */
    protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
        reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CloneMediator.Properties.reverse,
                EsbMessages.CloneMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
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
                            new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CloneMediator.Properties.reverse, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
            }

        });
        GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
        reverseData.horizontalSpan = 2;
        reverse.setLayoutData(reverseData);
        EditingUtils.setID(reverse, EsbViewsRepository.CloneMediator.Properties.reverse);
        EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CloneMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createReverseCheckbox
        
        // End of user code
        return parent;
    }
    /**
     * @generated NOT
     */
    protected Composite createCloneIDText(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.CloneMediator.Properties.cloneID,
                EsbMessages.CloneMediatorPropertiesEditionPart_CloneIDLabel);
        cloneID = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        cloneID.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData cloneIDData = new GridData(GridData.FILL_HORIZONTAL);
        cloneID.setLayoutData(cloneIDData);
        cloneID.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CloneMediator.Properties.cloneID, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, cloneID.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CloneMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CloneMediator.Properties.cloneID, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, cloneID.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CloneMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        cloneID.addKeyListener(new KeyAdapter() {
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
                                CloneMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CloneMediator.Properties.cloneID, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, cloneID.getText()));
                }
            }
        });
        EditingUtils.setID(cloneID, EsbViewsRepository.CloneMediator.Properties.cloneID);
        EditingUtils.setEEFtype(cloneID, "eef::Text"); //$NON-NLS-1$
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CloneMediator.Properties.cloneID, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createCloneIDText
        cloneIDElements = new Control[] {itemLabel, cloneID, itemHelp};
        
        // End of user code
        return parent;
    }
    
    /**
     * @generated NOT
     */
    protected Composite createSequentialMediationCheckbox(FormToolkit widgetFactory, Composite parent) {
        sequentialMediation = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.CloneMediator.Properties.sequentialMediation,
                        EsbMessages.CloneMediatorPropertiesEditionPart_SequentialMediationLabel),
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
                            new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CloneMediator.Properties.sequentialMediation,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new Boolean(sequentialMediation.getSelection())));
            }

        });
        GridData sequentialMediationData = new GridData(GridData.FILL_HORIZONTAL);
        sequentialMediationData.horizontalSpan = 2;
        sequentialMediation.setLayoutData(sequentialMediationData);
        EditingUtils.setID(sequentialMediation, EsbViewsRepository.CloneMediator.Properties.sequentialMediation);
        EditingUtils.setEEFtype(sequentialMediation, "eef::Checkbox"); //$NON-NLS-1$
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.CloneMediator.Properties.sequentialMediation, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createSequentialMediationCheckbox
        sequencialMediationElements = new Control [] {sequentialMediation, itemHelp};
        // End of user code
        return parent;
    }
    /**
     * @generated NOT
     */
    protected Composite createContinueParentCheckbox(FormToolkit widgetFactory, Composite parent) {
        continueParent = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.CloneMediator.Properties.continueParent,
                        EsbMessages.CloneMediatorPropertiesEditionPart_ContinueParentLabel),
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
                            CloneMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CloneMediator.Properties.continueParent, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new Boolean(continueParent.getSelection())));
            }

        });
        GridData continueParentData = new GridData(GridData.FILL_HORIZONTAL);
        continueParentData.horizontalSpan = 2;
        continueParent.setLayoutData(continueParentData);
        EditingUtils.setID(continueParent, EsbViewsRepository.CloneMediator.Properties.continueParent);
        EditingUtils.setEEFtype(continueParent, "eef::Checkbox"); //$NON-NLS-1$
        Control continueHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CloneMediator.Properties.continueParent, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createContinueParentCheckbox
        continueParentElements = new Control [] {continueParent,continueHelp};
        // End of user code
        return parent;
    }

    /**
     * @param container
     *
     * @generated NOT
     */
    protected Composite createTargetsTableComposition(FormToolkit widgetFactory, Composite parent) {
        Control[] previousControls = propertiesGroup.getChildren();
        this.targets = new ReferencesTable(getDescription(EsbViewsRepository.CloneMediator.Properties.targets,
                EsbMessages.CloneMediatorPropertiesEditionPart_TargetsLabel), new ReferencesTableListener() {
                    public void handleAdd() {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CloneMediator.Properties.targets,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
                        targets.refresh();
                    }

                    public void handleEdit(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CloneMediator.Properties.targets,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
                        targets.refresh();
                    }

                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CloneMediator.Properties.targets,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
                        targets.refresh();
                    }

                    public void handleRemove(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CloneMediator.Properties.targets,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
                        targets.refresh();
                    }

                    public void navigateTo(EObject element) {
                    }
                });
        for (ViewerFilter filter : this.targetsFilters) {
            this.targets.addFilter(filter);
        }
        this.targets.setHelpText(propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.CloneMediator.Properties.targets, EsbViewsRepository.FORM_KIND));
        this.targets.createControls(parent, widgetFactory);
        this.targets.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CloneMediator.Properties.targets, PropertiesEditionEvent.CHANGE,
                                    PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
                }
            }

        });
        GridData targetsData = new GridData(GridData.FILL_HORIZONTAL);
        targetsData.horizontalSpan = 3;
        this.targets.setLayoutData(targetsData);
        this.targets.setLowerBound(0);
        this.targets.setUpperBound(-1);
        targets.setID(EsbViewsRepository.CloneMediator.Properties.targets);
        targets.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
        // Start of user code for createTargetsTableComposition
        Control[] newControls = propertiesGroup.getChildren();
        targetTableElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
        // End of user code
        return parent;
    }

    /**
     * @param container
     *
     * @generated NOT
     */
    protected Composite createTargetsOutputConnectorTableComposition(FormToolkit widgetFactory, Composite parent) {
        Control[] previousControls = propertiesGroup.getChildren();
        Label itemLabel = createDescription(parent, EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector,
                EsbMessages.CloneMediatorPropertiesEditionPart_TargetsOutputConnectorLabel);
        this.targetsOutputConnector = new ReferencesTable(
                itemLabel.getText(),
                new ReferencesTableListener() {
                    public void handleAdd() {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
                        targetsOutputConnector.refresh();
                    }

                    public void handleEdit(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
                        targetsOutputConnector.refresh();
                    }

                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
                        targetsOutputConnector.refresh();
                    }

                    public void handleRemove(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
                        targetsOutputConnector.refresh();
                    }

                    public void navigateTo(EObject element) {
                    }
                });
        for (ViewerFilter filter : this.targetsOutputConnectorFilters) {
            this.targetsOutputConnector.addFilter(filter);
        }
        this.targetsOutputConnector.setHelpText(propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector, EsbViewsRepository.FORM_KIND));
        this.targetsOutputConnector.createControls(parent, widgetFactory);
        this.targetsOutputConnector.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CloneMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector,
                                    PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null,
                                    e.item.getData()));
                }
            }

        });
        GridData targetsOutputConnectorData = new GridData(GridData.FILL_HORIZONTAL);
        targetsOutputConnectorData.horizontalSpan = 3;
        this.targetsOutputConnector.setLayoutData(targetsOutputConnectorData);
        this.targetsOutputConnector.setLowerBound(0);
        this.targetsOutputConnector.setUpperBound(-1);
        targetsOutputConnector.setID(EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector);
        targetsOutputConnector.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
        // Start of user code for createTargetsOutputConnectorTableComposition
        Control[] newControls = propertiesGroup.getChildren();
        targetOutputElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
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
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getDescription()
     * 
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setDescription(String
     *      newValue)
     * 
     */
    public void setDescription(String newValue) {
        if (newValue != null) {
            description.setText(newValue);
        } else {
            description.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.description);
        if (eefElementEditorReadOnlyState && description.isEnabled()) {
            description.setEnabled(false);
            description.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
            description.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getCommentsList()
     * 
     */
    public EList getCommentsList() {
        return commentsListList;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setCommentsList(EList
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
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.commentsList);
        if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
            commentsList.setEnabled(false);
            commentsList.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
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
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getReverse()
     * 
     */
    public Boolean getReverse() {
        return Boolean.valueOf(reverse.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setReverse(Boolean
     *      newValue)
     * 
     */
    public void setReverse(Boolean newValue) {
        if (newValue != null) {
            reverse.setSelection(newValue.booleanValue());
        } else {
            reverse.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.reverse);
        if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
            reverse.setEnabled(false);
            reverse.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
            reverse.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getCloneID()
     * 
     */
    public String getCloneID() {
        return cloneID.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setCloneID(String
     *      newValue)
     * 
     */
    public void setCloneID(String newValue) {
        if (newValue != null) {
            cloneID.setText(newValue);
        } else {
            cloneID.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.cloneID);
        if (eefElementEditorReadOnlyState && cloneID.isEnabled()) {
            cloneID.setEnabled(false);
            cloneID.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !cloneID.isEnabled()) {
            cloneID.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getSequentialMediation()
     * 
     */
    public Boolean getSequentialMediation() {
        return Boolean.valueOf(sequentialMediation.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setSequentialMediation(Boolean
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
                EsbViewsRepository.CloneMediator.Properties.sequentialMediation);
        if (eefElementEditorReadOnlyState && sequentialMediation.isEnabled()) {
            sequentialMediation.setEnabled(false);
            sequentialMediation.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sequentialMediation.isEnabled()) {
            sequentialMediation.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#getContinueParent()
     * 
     */
    public Boolean getContinueParent() {
        return Boolean.valueOf(continueParent.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#setContinueParent(Boolean
     *      newValue)
     * 
     */
    public void setContinueParent(Boolean newValue) {
        if (newValue != null) {
            continueParent.setSelection(newValue.booleanValue());
        } else {
            continueParent.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.continueParent);
        if (eefElementEditorReadOnlyState && continueParent.isEnabled()) {
            continueParent.setEnabled(false);
            continueParent.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !continueParent.isEnabled()) {
            continueParent.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#initTargets(EObject
     *      current, EReference containingFeature, EReference feature)
     */
    public void initTargets(ReferencesTableSettings settings) {
        if (current.eResource() != null && current.eResource().getResourceSet() != null)
            this.resourceSet = current.eResource().getResourceSet();
        ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
        targets.setContentProvider(contentProvider);
        targets.setInput(settings);
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediator.Properties.targets);
        if (eefElementEditorReadOnlyState && targets.isEnabled()) {
            targets.setEnabled(false);
            targets.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !targets.isEnabled()) {
            targets.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#updateTargets()
     * 
     */
    public void updateTargets() {
        targets.refresh();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#addFilterTargets(ViewerFilter
     *      filter)
     * 
     */
    public void addFilterToTargets(ViewerFilter filter) {
        targetsFilters.add(filter);
        if (this.targets != null) {
            this.targets.addFilter(filter);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#addBusinessFilterTargets(ViewerFilter
     *      filter)
     * 
     */
    public void addBusinessFilterToTargets(ViewerFilter filter) {
        targetsBusinessFilters.add(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#isContainedInTargetsTable(EObject
     *      element)
     * 
     */
    public boolean isContainedInTargetsTable(EObject element) {
        return ((ReferencesTableSettings) targets.getInput()).contains(element);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#initTargetsOutputConnector(EObject
     *      current, EReference containingFeature, EReference feature)
     */
    public void initTargetsOutputConnector(ReferencesTableSettings settings) {
        if (current.eResource() != null && current.eResource().getResourceSet() != null)
            this.resourceSet = current.eResource().getResourceSet();
        ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
        targetsOutputConnector.setContentProvider(contentProvider);
        targetsOutputConnector.setInput(settings);
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector);
        if (eefElementEditorReadOnlyState && targetsOutputConnector.isEnabled()) {
            targetsOutputConnector.setEnabled(false);
            targetsOutputConnector.setToolTipText(EsbMessages.CloneMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !targetsOutputConnector.isEnabled()) {
            targetsOutputConnector.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#updateTargetsOutputConnector()
     * 
     */
    public void updateTargetsOutputConnector() {
        targetsOutputConnector.refresh();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#addFilterTargetsOutputConnector(ViewerFilter
     *      filter)
     * 
     */
    public void addFilterToTargetsOutputConnector(ViewerFilter filter) {
        targetsOutputConnectorFilters.add(filter);
        if (this.targetsOutputConnector != null) {
            this.targetsOutputConnector.addFilter(filter);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#addBusinessFilterTargetsOutputConnector(ViewerFilter
     *      filter)
     * 
     */
    public void addBusinessFilterToTargetsOutputConnector(ViewerFilter filter) {
        targetsOutputConnectorBusinessFilters.add(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart#isContainedInTargetsOutputConnectorTable(EObject
     *      element)
     * 
     */
    public boolean isContainedInTargetsOutputConnectorTable(EObject element) {
        return ((ReferencesTableSettings) targetsOutputConnector.getInput()).contains(element);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     * 
     */
    public String getTitle() {
        return EsbMessages.CloneMediator_Part_Title;
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
        epv.showEntry(cloneIDElements, false);
        epv.showEntry(sequencialMediationElements, false);
        epv.showEntry(continueParentElements, false);
        epv.showEntry(targetTableElements, false);
        epv.clearTableButtons(targetTableElements);
        view.layout(true, true);
    }
    // End of user code

}
