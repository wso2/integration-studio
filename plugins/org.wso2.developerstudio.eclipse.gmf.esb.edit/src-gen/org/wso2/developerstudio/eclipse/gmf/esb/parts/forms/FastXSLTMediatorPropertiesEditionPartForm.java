/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.FastXSLTMediatorPropertiesEditionPart;
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
public class FastXSLTMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, FastXSLTMediatorPropertiesEditionPart {

    protected Text commentsList;
    protected Button editCommentsList;
    protected EList commentsListList;
    protected Button reverse;

    // Start of user code for fastXsltStaticSchemaKey widgets declarations
    protected RegistryKeyProperty fastXsltStaticSchemaKey;
    protected Text staticSchemaKeyText;
    // End of user code

    // Start of user code for fastXsltDynamicSchemaKey widgets declarations
    protected NamespacedProperty fastXsltDynamicSchemaKey;
    protected Text dynamicSchemaKeyText;

    protected Composite basicGroup;
    protected Composite miscGroup;
    protected Composite propertiesGroup;

    protected Control[] staticSchemaKeyElements;
    protected Control[] dynamicSchemaKeyElements;
    protected Control[] schemaTypeElements;
    protected Control[] descriptionElements;

    protected Section propertiesSection;
    // End of user code

    protected EMFComboViewer fastXsltSchemaKeyType;
    protected Text description;

    /**
     * For {@link ISection} use only.
     */
    public FastXSLTMediatorPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public FastXSLTMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
        CompositionSequence fastXSLTMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
        CompositionStep propertiesStep = fastXSLTMediatorStep
                .addStep(EsbViewsRepository.FastXSLTMediator.Properties.class);
        propertiesStep.addStep(EsbViewsRepository.FastXSLTMediator.Properties.commentsList);
        propertiesStep.addStep(EsbViewsRepository.FastXSLTMediator.Properties.reverse);

        CompositionStep basicStep = fastXSLTMediatorStep.addStep(EsbViewsRepository.FastXSLTMediator.Basic.class);
        basicStep.addStep(EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType);
        basicStep.addStep(EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey);
        basicStep.addStep(EsbViewsRepository.FastXSLTMediator.Basic.fastXsltDynamicSchemaKey);

        CompositionStep miscStep = fastXSLTMediatorStep.addStep(EsbViewsRepository.FastXSLTMediator.Misc.class);
        miscStep.addStep(EsbViewsRepository.FastXSLTMediator.Misc.description);

        composer = new PartComposer(fastXSLTMediatorStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.FastXSLTMediator.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.FastXSLTMediator.Properties.commentsList) {
                    return createCommentsListMultiValuedEditor(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.FastXSLTMediator.Properties.reverse) {
                    return createReverseCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.FastXSLTMediator.Basic.class) {
                    return createBasicGroup(widgetFactory, parent);
                }
                // Start of user code for fastXsltStaticSchemaKey addToPart creation
                if (key == EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey) {
                    return createStaticSchemaWidget(widgetFactory, parent);
                }
                // End of user code
                // Start of user code for fastXsltDynamicSchemaKey addToPart creation
                if (key == EsbViewsRepository.FastXSLTMediator.Basic.fastXsltDynamicSchemaKey) {
                    return createDynamicSchemaWidget(widgetFactory, parent);
                }
                // End of user code
                if (key == EsbViewsRepository.FastXSLTMediator.Misc.class) {
                    return createMiscGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType) {
                    return createFastXsltSchemaKeyTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.FastXSLTMediator.Misc.description) {
                    return createDescriptionText(widgetFactory, parent);
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
        propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        propertiesSection.setText(EsbMessages.FastXSLTMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
     * 
     */
    protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
        commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
        GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
        commentsListData.horizontalSpan = 2;
        commentsList.setLayoutData(commentsListData);
        EditingUtils.setID(commentsList, EsbViewsRepository.FastXSLTMediator.Properties.commentsList);
        EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
        editCommentsList = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.FastXSLTMediator.Properties.commentsList,
                        EsbMessages.FastXSLTMediatorPropertiesEditionPart_CommentsListLabel),
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
                EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(commentsList.getShell(), "FastXSLTMediator", //$NON-NLS-1$
                        new AdapterFactoryLabelProvider(adapterFactory), commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null, false,
                        true, null, null);
                if (dialog.open() == Window.OK) {
                    commentsListList = dialog.getResult();
                    if (commentsListList == null) {
                        commentsListList = new BasicEList();
                    }
                    commentsList.setText(commentsListList.toString());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            FastXSLTMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.FastXSLTMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
                    setHasChanged(true);
                }
            }
        });
        EditingUtils.setID(editCommentsList, EsbViewsRepository.FastXSLTMediator.Properties.commentsList);
        EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
        // Start of user code for createCommentsListMultiValuedEditor

        // End of user code
        return parent;
    }

    protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
        reverse = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.FastXSLTMediator.Properties.reverse,
                        EsbMessages.FastXSLTMediatorPropertiesEditionPart_ReverseLabel),
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
                            FastXSLTMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.FastXSLTMediator.Properties.reverse, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
            }

        });
        GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
        reverseData.horizontalSpan = 2;
        reverse.setLayoutData(reverseData);
        EditingUtils.setID(reverse, EsbViewsRepository.FastXSLTMediator.Properties.reverse);
        EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.FastXSLTMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createReverseCheckbox

        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createBasicGroup(FormToolkit widgetFactory, final Composite parent) {
        Section basicSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        basicSection.setText("Schema Key");
        GridData basicSectionData = new GridData(GridData.FILL_HORIZONTAL);
        basicSectionData.horizontalSpan = 3;
        basicSection.setLayoutData(basicSectionData);
        basicGroup = widgetFactory.createComposite(basicSection);
        GridLayout basicGroupLayout = new GridLayout();
        basicGroupLayout.numColumns = 3;
        basicGroup.setLayout(basicGroupLayout);
        basicSection.setClient(basicGroup);
        return basicGroup;
    }

    /**
     * @generated NOT
     */
    protected Composite createMiscGroup(FormToolkit widgetFactory, final Composite parent) {
        Section miscSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        miscSection.setText(EsbMessages.FastXSLTMediatorPropertiesEditionPart_MiscGroupLabel);
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
     * 
     * @generated NOT
     */
    protected Composite createFastXsltSchemaKeyTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control schemaTypeLabel = createDescription(parent,
                EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType,
                EsbMessages.FastXSLTMediatorPropertiesEditionPart_FastXsltSchemaKeyTypeLabel);
        fastXsltSchemaKeyType = new EMFComboViewer(parent);
        fastXsltSchemaKeyType.setContentProvider(new ArrayContentProvider());
        fastXsltSchemaKeyType
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData fastXsltSchemaKeyTypeData = new GridData(GridData.FILL_HORIZONTAL);
        fastXsltSchemaKeyType.getCombo().setLayoutData(fastXsltSchemaKeyTypeData);
        fastXsltSchemaKeyType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;

            }
        });
        fastXsltSchemaKeyType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(FastXSLTMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getFastXsltSchemaKeyType()));
            }

        });
        fastXsltSchemaKeyType.setID(EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType);
        Control schemaTypeHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createFastXsltSchemaKeyTypeEMFComboViewer
        fastXsltSchemaKeyType.addSelectionChangedListener(new ISelectionChangedListener() {

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

        schemaTypeElements = new Control[] { schemaTypeLabel, fastXsltSchemaKeyType.getCombo(), schemaTypeHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
        Control descriptionText = createDescription(parent, EsbViewsRepository.FastXSLTMediator.Misc.description,
                EsbMessages.FastXSLTMediatorPropertiesEditionPart_DescriptionLabel);
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
                            new PropertiesEditionEvent(FastXSLTMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.FastXSLTMediator.Misc.description, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, description.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            FastXSLTMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.FastXSLTMediator.Misc.description, PropertiesEditionEvent.FOCUS_CHANGED,
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
                            FastXSLTMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
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
                                FastXSLTMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.FastXSLTMediator.Misc.description, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, description.getText()));
                }
            }
        });
        
        EditingUtils.setID(description, EsbViewsRepository.FastXSLTMediator.Misc.description);
        EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
        Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.FastXSLTMediator.Misc.description, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createDescriptionText

        // End of user code
        descriptionElements = new Control[] { descriptionText, description, descriptionHelp };
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
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FastXSLTMediatorPropertiesEditionPart#getCommentsList()
     * 
     */
    public EList getCommentsList() {
        return commentsListList;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FastXSLTMediatorPropertiesEditionPart#setCommentsList(EList
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
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FastXSLTMediator.Properties.commentsList);
        if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
            commentsList.setEnabled(false);
            commentsList.setToolTipText(EsbMessages.FastXSLTMediator_ReadOnly);
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
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FastXSLTMediatorPropertiesEditionPart#getReverse()
     * 
     */
    public Boolean getReverse() {
        return Boolean.valueOf(reverse.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FastXSLTMediatorPropertiesEditionPart#setReverse(Boolean
     *      newValue)
     * 
     */
    public void setReverse(Boolean newValue) {
        if (newValue != null) {
            reverse.setSelection(newValue.booleanValue());
        } else {
            reverse.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FastXSLTMediator.Properties.reverse);
        if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
            reverse.setEnabled(false);
            reverse.setToolTipText(EsbMessages.FastXSLTMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
            reverse.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FastXSLTMediatorPropertiesEditionPart#getFastXsltSchemaKeyType()
     * 
     */
    public Enumerator getFastXsltSchemaKeyType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) fastXsltSchemaKeyType.getSelection())
                .getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FastXSLTMediatorPropertiesEditionPart#initFastXsltSchemaKeyType(Object
     *      input, Enumerator current)
     */
    public void initFastXsltSchemaKeyType(Object input, Enumerator current) {
        fastXsltSchemaKeyType.setInput(input);
        fastXsltSchemaKeyType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType);
        if (eefElementEditorReadOnlyState && fastXsltSchemaKeyType.isEnabled()) {
            fastXsltSchemaKeyType.setEnabled(false);
            fastXsltSchemaKeyType.setToolTipText(EsbMessages.FastXSLTMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !fastXsltSchemaKeyType.isEnabled()) {
            fastXsltSchemaKeyType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FastXSLTMediatorPropertiesEditionPart#setFastXsltSchemaKeyType(Enumerator
     *      newValue)
     * 
     */
    public void setFastXsltSchemaKeyType(Enumerator newValue) {
        fastXsltSchemaKeyType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.FastXSLTMediator.Misc.fastXsltSchemaKeyType);
        if (eefElementEditorReadOnlyState && fastXsltSchemaKeyType.isEnabled()) {
            fastXsltSchemaKeyType.setEnabled(false);
            fastXsltSchemaKeyType.setToolTipText(EsbMessages.FastXSLTMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !fastXsltSchemaKeyType.isEnabled()) {
            fastXsltSchemaKeyType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FastXSLTMediatorPropertiesEditionPart#getDescription()
     * 
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FastXSLTMediatorPropertiesEditionPart#setDescription(String
     *      newValue)
     * 
     */
    public void setDescription(String newValue) {
        if (newValue != null) {
            description.setText(newValue);
        } else {
            description.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FastXSLTMediator.Misc.description);
        if (eefElementEditorReadOnlyState && description.isEnabled()) {
            description.setEnabled(false);
            description.setToolTipText(EsbMessages.FastXSLTMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
            description.setEnabled(true);
        }

    }

    // Start of user code for fastXsltStaticSchemaKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getFastXsltStaticSchemaKey() {
        return this.fastXsltStaticSchemaKey;
    }

    @Override
    public void setFastXsltStaticSchemaKey(RegistryKeyProperty fastXsltStaticSchemaKey) {
        if (this.fastXsltStaticSchemaKey != null) {
            staticSchemaKeyText.setText(fastXsltStaticSchemaKey.getKeyValue());
            this.fastXsltStaticSchemaKey = fastXsltStaticSchemaKey;
        }

    }
    // End of user code

    // Start of user code for fastXsltDynamicSchemaKey specific getters and setters implementation
    @Override
    public NamespacedProperty getFastXsltDynamicSchemaKey() {
        return this.fastXsltDynamicSchemaKey;
    }

    @Override
    public void setFastXsltDynamicSchemaKey(NamespacedProperty fastXsltDynamicSchemaKey) {
        if (this.fastXsltDynamicSchemaKey != null) {
            dynamicSchemaKeyText.setText(fastXsltDynamicSchemaKey.getPropertyValue());
            this.fastXsltDynamicSchemaKey = fastXsltDynamicSchemaKey;
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
        return EsbMessages.FastXSLTMediator_Part_Title;
    }

    // Start of user code additional methods
    protected Composite createStaticSchemaWidget(FormToolkit widgetFactory, final Composite parent) {
        Control staticSchemaKeyLabel = createDescription(parent,
                EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey,
                EsbMessages.FastXSLTMediatorPropertiesEditionPart_FastXsltStaticSchemaKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (fastXsltStaticSchemaKey == null) {
            fastXsltStaticSchemaKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }

        String initValueExpression = fastXsltStaticSchemaKey.getKeyValue().isEmpty() ? ""
                : fastXsltStaticSchemaKey.getKeyValue();
        staticSchemaKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        staticSchemaKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        staticSchemaKeyText.setLayoutData(valueData);
        
        staticSchemaKeyText.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, fastXsltStaticSchemaKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                staticSchemaKeyText.setText(fastXsltStaticSchemaKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        FastXSLTMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey,
                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFastXsltStaticSchemaKey()));
            }
            
            @Override
            public void mouseUp(MouseEvent e) {}
            
            @Override
            public void mouseDoubleClick(MouseEvent e) {}
            
        });
        
        staticSchemaKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, fastXsltStaticSchemaKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    staticSchemaKeyText.setText(fastXsltStaticSchemaKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            FastXSLTMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFastXsltStaticSchemaKey()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(staticSchemaKeyText, EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey);
        EditingUtils.setEEFtype(staticSchemaKeyText, "eef::Text");
        Control staticSchemaKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.FastXSLTMediator.Basic.fastXsltStaticSchemaKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        staticSchemaKeyElements = new Control[] { staticSchemaKeyLabel, staticSchemaKeyText, staticSchemaKeyHelp };
        return parent;
    }

    protected Composite createDynamicSchemaWidget(FormToolkit widgetFactory, final Composite parent) {
        Control dynamicSchemaKeyLabel = createDescription(parent,
                EsbViewsRepository.FastXSLTMediator.Basic.fastXsltDynamicSchemaKey,
                EsbMessages.FastXSLTMediatorPropertiesEditionPart_FastXsltDynamicSchemaKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (fastXsltDynamicSchemaKey == null) {
            fastXsltDynamicSchemaKey = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = fastXsltDynamicSchemaKey.getPropertyValue().isEmpty() ? "/default/expression"
                : fastXsltDynamicSchemaKey.getPropertyValue();
        dynamicSchemaKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        dynamicSchemaKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        dynamicSchemaKeyText.setLayoutData(valueData);

        dynamicSchemaKeyText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, fastXsltDynamicSchemaKey);
                nspd.open();
                dynamicSchemaKeyText.setText(fastXsltDynamicSchemaKey.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(
                        new PropertiesEditionEvent(FastXSLTMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.FastXSLTMediator.Basic.fastXsltDynamicSchemaKey,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                getFastXsltDynamicSchemaKey()));
            }
            
        });
        
        dynamicSchemaKeyText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, fastXsltDynamicSchemaKey);
                    nspd.open();
                    dynamicSchemaKeyText.setText(fastXsltDynamicSchemaKey.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(FastXSLTMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.FastXSLTMediator.Basic.fastXsltDynamicSchemaKey,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getFastXsltDynamicSchemaKey()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(dynamicSchemaKeyText, EsbViewsRepository.FastXSLTMediator.Basic.fastXsltDynamicSchemaKey);
        EditingUtils.setEEFtype(dynamicSchemaKeyText, "eef::Text");
        Control dynamicSchemaKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.FastXSLTMediator.Basic.fastXsltDynamicSchemaKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        dynamicSchemaKeyElements = new Control[] { dynamicSchemaKeyLabel, dynamicSchemaKeyText, dynamicSchemaKeyHelp };
        return parent;
    }
    
    private void openNamespacedPropertyEditor(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                SWT.NULL, fastXsltDynamicSchemaKey);
        // valueExpression.setPropertyValue(valueExpressionText.getText());
        fastXsltDynamicSchemaKey = nspd.open();
        dynamicSchemaKeyText.setText(fastXsltDynamicSchemaKey.getPropertyValue());
        propertiesEditionComponent.firePropertiesChanged(
                new PropertiesEditionEvent(FastXSLTMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.FastXSLTMediator.Basic.fastXsltDynamicSchemaKey,
                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                        getFastXsltDynamicSchemaKey()));
    }


    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] { miscGroup, basicGroup, propertiesGroup });
        epv.showEntry(schemaTypeElements, false);

        switch (getFastXsltSchemaKeyType().getLiteral()) {
        case "Static": {
            epv.showEntry(staticSchemaKeyElements, false);
            break;
        }

        case "Dynamic": {
            epv.showEntry(dynamicSchemaKeyElements, false);
            break;
        }
        }

        if (propertiesSection != null && propertiesSection.getLayoutData() != null) {
            ((GridData) propertiesSection.getLayoutData()).exclude = true;
        }
        propertiesSection.setVisible(false);

        epv.showEntry(descriptionElements, false);
        view.layout(true, true);
    }
    // End of user code

}
