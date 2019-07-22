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
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class EntitlementMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, EntitlementMediatorPropertiesEditionPart {

    protected Text commentsList;
    protected Button editCommentsList;
    protected EList commentsListList;
    protected Button reverse;
    protected Text entitlementServerURL;
    protected Text username;
    protected Text password;
    protected EMFComboViewer callbackHandler;
    protected Text callbackClassName;
    protected Text thriftHost;
    protected Text thriftPort;
    protected EMFComboViewer entitlementClientType;
    protected EMFComboViewer onRejectSequenceType;
    protected EMFComboViewer onAcceptSequenceType;
    protected EMFComboViewer adviceSequenceType;
    protected EMFComboViewer obligationsSequenceType;

    // Start of user code for onRejectSequenceKey widgets declarations
    protected RegistryKeyProperty onRejectSequenceKey;
    protected Text onRejectSequenceKeyText;
    // End of user code

    // Start of user code for onAcceptSequenceKey widgets declarations
    protected RegistryKeyProperty onAcceptSequenceKey;
    protected Text onAcceptSequenceKeyText;
    // End of user code

    // Start of user code for adviceSequenceKey widgets declarations
    protected RegistryKeyProperty adviceSequenceKey;
    protected Text adviceSequenceKeyText;
    // End of user code

    // Start of user code for obligationsSequenceKey widgets declarations
    protected RegistryKeyProperty obligationsSequenceKey;
    protected Text obligationsSequenceKeyText;

    protected Composite propertiesGroup;

    protected Control[] commentListElements;
    protected Control[] reverseElements;

    protected Control[] entitlementServerURLElements;
    protected Control[] usernameElements;
    protected Control[] passwordElements;
    protected Control[] callbackHandlerElements;
    protected Control[] callbackClassNameElements;
    protected Control[] thriftHostElements;
    protected Control[] thriftPortElements;
    protected Control[] entitlementClientTypeElements;
    protected Control[] onRejectSequenceTypeElements;
    protected Control[] onAcceptSequenceTypeElements;
    protected Control[] adviceSequenceTypeElements;
    protected Control[] obligationsSequenceTypeElements;
    protected Control[] onRejectSequenceKeyElements;
    protected Control[] onAcceptSequenceKeyElements;
    protected Control[] adviceSequenceKeyElements;
    protected Control[] obligationsSequenceKeyElements;
    protected Control[] descriptionElements;
    protected Composite filterOnAcceptanceSubPropertiesGroup;
    protected Composite filterOnRejectionSubPropertiesGroup;
    protected Composite filterObligationsSubPropertiesGroup;
    protected Composite filterAdviceSubPropertiesGroup;
    // End of user code

    protected Text description;

    /**
     * For {@link ISection} use only.
     */
    public EntitlementMediatorPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public EntitlementMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
        CompositionSequence entitlementMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
        CompositionStep propertiesStep = entitlementMediatorStep
                .addStep(EsbViewsRepository.EntitlementMediator.Properties.class);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.commentsList);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.reverse);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.username);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.password);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.callbackHandler);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.callbackClassName);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.thriftHost);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.thriftPort);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceKey);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceKey);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceKey);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.description);

        composer = new PartComposer(entitlementMediatorStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.EntitlementMediator.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.commentsList) {
                    return createCommentsListMultiValuedEditor(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.reverse) {
                    return createReverseCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL) {
                    return createEntitlementServerURLText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.username) {
                    return createUsernameText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.password) {
                    return createPasswordText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.callbackHandler) {
                    return createCallbackHandlerEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.callbackClassName) {
                    return createCallbackClassNameText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.thriftHost) {
                    return createThriftHostText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.thriftPort) {
                    return createThriftPortText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType) {
                    return createEntitlementClientTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType) {
                    return createOnRejectSequenceTypeEMFComboViewer(widgetFactory, parent);
                }
                // Start of user code for onRejectSequenceKey addToPart creation
                if (key == EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey) {
                    return createOnRejectSequenceKeyWidget(widgetFactory, filterOnRejectionSubPropertiesGroup);
                }
                // End of user code
                if (key == EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType) {
                    return createOnAcceptSequenceTypeEMFComboViewer(widgetFactory, parent);
                }
                // Start of user code for onAcceptSequenceKey addToPart creation
                if (key == EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceKey) {
                    return createOnAcceptSequenceKeyWidget(widgetFactory, filterOnAcceptanceSubPropertiesGroup);
                }
                // End of user code
                if (key == EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType) {
                    return createAdviceSequenceTypeEMFComboViewer(widgetFactory, parent);
                }
                // Start of user code for adviceSequenceKey addToPart creation
                if (key == EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceKey) {
                    return createAdviceSequenceKeyWidget(widgetFactory, filterAdviceSubPropertiesGroup);
                }
                // End of user code
                if (key == EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType) {
                    return createObligationsSequenceTypeEMFComboViewer(widgetFactory, parent);
                }
                // Start of user code for obligationsSequenceKey addToPart creation
                if (key == EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceKey) {
                    return createObligationsSequenceKeyWidget(widgetFactory, filterObligationsSubPropertiesGroup);
                }
                // End of user code
                if (key == EsbViewsRepository.EntitlementMediator.Properties.description) {
                    return createDescriptionText(widgetFactory, parent);
                }
                return parent;
            }
        };
        composer.compose(view);
    }

    /**
     * 
     */
    protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
        Section propertiesSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        propertiesSection.setText(EsbMessages.EntitlementMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
    protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
        Control[] previousList = propertiesGroup.getChildren();
        commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
        GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
        commentsListData.horizontalSpan = 2;
        commentsList.setLayoutData(commentsListData);
        EditingUtils.setID(commentsList, EsbViewsRepository.EntitlementMediator.Properties.commentsList);
        EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
        editCommentsList = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.EntitlementMediator.Properties.commentsList,
                        EsbMessages.EntitlementMediatorPropertiesEditionPart_CommentsListLabel),
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
                EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(commentsList.getShell(),
                        "EntitlementMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
                        commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null, false,
                        true, null, null);
                if (dialog.open() == Window.OK) {
                    commentsListList = dialog.getResult();
                    if (commentsListList == null) {
                        commentsListList = new BasicEList();
                    }
                    commentsList.setText(commentsListList.toString());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.commentsList,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new BasicEList(commentsListList)));
                    setHasChanged(true);
                }
            }
        });
        EditingUtils.setID(editCommentsList, EsbViewsRepository.EntitlementMediator.Properties.commentsList);
        EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$

        // Start of user code for createCommentsListMultiValuedEditor
        Control[] newList = propertiesGroup.getChildren();
        commentListElements = EEFPropertyViewUtil.getTableElements(previousList, newList);
        // End of user code

        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
        Control[] previousList = propertiesGroup.getChildren();
        reverse = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.EntitlementMediator.Properties.reverse,
                        EsbMessages.EntitlementMediatorPropertiesEditionPart_ReverseLabel),
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
                            EntitlementMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EntitlementMediator.Properties.reverse, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
            }

        });
        GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
        reverseData.horizontalSpan = 2;
        reverse.setLayoutData(reverseData);
        EditingUtils.setID(reverse, EsbViewsRepository.EntitlementMediator.Properties.reverse);
        EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EntitlementMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createReverseCheckbox
        Control[] newList = propertiesGroup.getChildren();
        reverseElements = EEFPropertyViewUtil.getTableElements(previousList, newList);
        // End of user code
        return parent;
    }

    protected Composite createEntitlementServerURLText(FormToolkit widgetFactory, Composite parent) {
        Control entitlementServerURLLabel = createDescription(parent,
                EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_EntitlementServerURLLabel);
        entitlementServerURL = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        entitlementServerURL.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData entitlementServerURLData = new GridData(GridData.FILL_HORIZONTAL);
        entitlementServerURL.setLayoutData(entitlementServerURLData);
        entitlementServerURL.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    entitlementServerURL.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    entitlementServerURL.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        entitlementServerURL.addKeyListener(new KeyAdapter() {
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
                                new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        entitlementServerURL.getText()));
                }
            }
        });
        EditingUtils.setID(entitlementServerURL,
                EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL);
        EditingUtils.setEEFtype(entitlementServerURL, "eef::Text"); //$NON-NLS-1$
        Control entitlementServerURLHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createEntitlementServerURLText
        entitlementServerURLElements = new Control[] { entitlementServerURLLabel, entitlementServerURL,
                entitlementServerURLHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createUsernameText(FormToolkit widgetFactory, Composite parent) {
        Control usernameLabel = createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.username,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_UsernameLabel);
        username = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        username.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData usernameData = new GridData(GridData.FILL_HORIZONTAL);
        username.setLayoutData(usernameData);
        username.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EntitlementMediator.Properties.username, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, username.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.username,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    username.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        username.addKeyListener(new KeyAdapter() {
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
                                EntitlementMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.EntitlementMediator.Properties.username,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, username.getText()));
                }
            }
        });
        EditingUtils.setID(username, EsbViewsRepository.EntitlementMediator.Properties.username);
        EditingUtils.setEEFtype(username, "eef::Text"); //$NON-NLS-1$
        Control usernameHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.username,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createUsernameText
        usernameElements = new Control[] { usernameLabel, username, usernameHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createPasswordText(FormToolkit widgetFactory, Composite parent) {
        Control passwordLabel = createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.password,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_PasswordLabel);
        password = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        password.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData passwordData = new GridData(GridData.FILL_HORIZONTAL);
        password.setLayoutData(passwordData);
        password.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EntitlementMediator.Properties.password, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, password.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.password,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    password.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        password.addKeyListener(new KeyAdapter() {
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
                                EntitlementMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.EntitlementMediator.Properties.password,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, password.getText()));
                }
            }
        });
        EditingUtils.setID(password, EsbViewsRepository.EntitlementMediator.Properties.password);
        EditingUtils.setEEFtype(password, "eef::Text"); //$NON-NLS-1$
        Control passwordHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.password,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createPasswordText
        passwordElements = new Control[] { passwordLabel, password, passwordHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createCallbackHandlerEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control callbackHandlerLabel = createDescription(parent,
                EsbViewsRepository.EntitlementMediator.Properties.callbackHandler,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_CallbackHandlerLabel);
        callbackHandler = new EMFComboViewer(parent);
        callbackHandler.setContentProvider(new ArrayContentProvider());
        callbackHandler
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData callbackHandlerData = new GridData(GridData.FILL_HORIZONTAL);
        callbackHandler.getCombo().setLayoutData(callbackHandlerData);
        callbackHandler.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;

            }
        });
        callbackHandler.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EntitlementMediator.Properties.callbackHandler,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCallbackHandler()));
            }

        });
        callbackHandler.setID(EsbViewsRepository.EntitlementMediator.Properties.callbackHandler);
        Control callbackHandlerHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.callbackHandler,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createCallbackHandlerEMFComboViewer
        callbackHandler.addSelectionChangedListener(new ISelectionChangedListener() {

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

        callbackHandlerElements = new Control[] { callbackHandlerLabel, callbackHandler.getCombo(),
                callbackHandlerHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createCallbackClassNameText(FormToolkit widgetFactory, Composite parent) {
        Control callbackClassNameLabel = createDescription(parent,
                EsbViewsRepository.EntitlementMediator.Properties.callbackClassName,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_CallbackClassNameLabel);
        callbackClassName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        callbackClassName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData callbackClassNameData = new GridData(GridData.FILL_HORIZONTAL);
        callbackClassName.setLayoutData(callbackClassNameData);
        callbackClassName.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.callbackClassName,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    callbackClassName.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.callbackClassName,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    callbackClassName.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        callbackClassName.addKeyListener(new KeyAdapter() {
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
                                new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.EntitlementMediator.Properties.callbackClassName,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        callbackClassName.getText()));
                }
            }
        });
        EditingUtils.setID(callbackClassName, EsbViewsRepository.EntitlementMediator.Properties.callbackClassName);
        EditingUtils.setEEFtype(callbackClassName, "eef::Text"); //$NON-NLS-1$
        Control callbackClassNameHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.callbackClassName,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createCallbackClassNameText
        callbackClassNameElements = new Control[] { callbackClassNameLabel, callbackClassName, callbackClassNameHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createThriftHostText(FormToolkit widgetFactory, Composite parent) {
        Control thriftHostLabel = createDescription(parent,
                EsbViewsRepository.EntitlementMediator.Properties.thriftHost,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_ThriftHostLabel);
        thriftHost = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        thriftHost.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData thriftHostData = new GridData(GridData.FILL_HORIZONTAL);
        thriftHost.setLayoutData(thriftHostData);
        thriftHost.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EntitlementMediator.Properties.thriftHost, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, thriftHost.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.thriftHost,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    thriftHost.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        thriftHost.addKeyListener(new KeyAdapter() {
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
                                EntitlementMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.EntitlementMediator.Properties.thriftHost,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, thriftHost.getText()));
                }
            }
        });
        EditingUtils.setID(thriftHost, EsbViewsRepository.EntitlementMediator.Properties.thriftHost);
        EditingUtils.setEEFtype(thriftHost, "eef::Text"); //$NON-NLS-1$
        Control thriftHostHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.thriftHost,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createThriftHostText
        thriftHostElements = new Control[] { thriftHostLabel, thriftHost, thriftHostHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createThriftPortText(FormToolkit widgetFactory, Composite parent) {
        Control thriftPortLabel = createDescription(parent,
                EsbViewsRepository.EntitlementMediator.Properties.thriftPort,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_ThriftPortLabel);
        thriftPort = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        thriftPort.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData thriftPortData = new GridData(GridData.FILL_HORIZONTAL);
        thriftPort.setLayoutData(thriftPortData);
        thriftPort.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EntitlementMediator.Properties.thriftPort, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, thriftPort.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.thriftPort,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    thriftPort.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        thriftPort.addKeyListener(new KeyAdapter() {
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
                                EntitlementMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.EntitlementMediator.Properties.thriftPort,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, thriftPort.getText()));
                }
            }
        });
        EditingUtils.setID(thriftPort, EsbViewsRepository.EntitlementMediator.Properties.thriftPort);
        EditingUtils.setEEFtype(thriftPort, "eef::Text"); //$NON-NLS-1$
        Control thriftPortHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.thriftPort,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createThriftPortText
        thriftPortElements = new Control[] { thriftPortLabel, thriftPort, thriftPortHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createEntitlementClientTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control entitlementClientTypeLabel = createDescription(parent,
                EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_EntitlementClientTypeLabel);
        entitlementClientType = new EMFComboViewer(parent);
        entitlementClientType.setContentProvider(new ArrayContentProvider());
        entitlementClientType
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData entitlementClientTypeData = new GridData(GridData.FILL_HORIZONTAL);
        entitlementClientType.getCombo().setLayoutData(entitlementClientTypeData);
        entitlementClientType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;

            }
        });
        entitlementClientType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getEntitlementClientType()));
            }

        });
        entitlementClientType.setID(EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType);
        Control entitlementClientTypeHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createEntitlementClientTypeEMFComboViewer
        entitlementClientType.addSelectionChangedListener(new ISelectionChangedListener() {

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

        entitlementClientTypeElements = new Control[] { entitlementClientTypeLabel, entitlementClientType.getControl(),
                entitlementClientTypeHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createOnRejectSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        filterOnRejectionSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "On Rejection",
                true);
        Control onRejectSequenceTypeLabel = createDescription(filterOnRejectionSubPropertiesGroup,
                EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_OnRejectSequenceTypeLabel);
        onRejectSequenceType = new EMFComboViewer(filterOnRejectionSubPropertiesGroup);
        onRejectSequenceType.setContentProvider(new ArrayContentProvider());
        onRejectSequenceType
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData onRejectSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
        onRejectSequenceType.getCombo().setLayoutData(onRejectSequenceTypeData);
        onRejectSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
        onRejectSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getOnRejectSequenceType()));
            }

        });
        onRejectSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType);
        Control onRejectSequenceTypeHelp = FormUtils.createHelpButton(widgetFactory, filterOnRejectionSubPropertiesGroup,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createOnRejectSequenceTypeEMFComboViewer
        onRejectSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

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

        onRejectSequenceTypeElements = new Control[] { onRejectSequenceTypeLabel, onRejectSequenceType.getControl(),
                onRejectSequenceTypeHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createOnAcceptSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        filterOnAcceptanceSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "On Acceptance",
                true);
        Control onAcceptSequenceTypeLabel = createDescription(filterOnAcceptanceSubPropertiesGroup,
                EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_OnAcceptSequenceTypeLabel);
        onAcceptSequenceType = new EMFComboViewer(filterOnAcceptanceSubPropertiesGroup);
        onAcceptSequenceType.setContentProvider(new ArrayContentProvider());
        onAcceptSequenceType
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData onAcceptSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
        onAcceptSequenceType.getCombo().setLayoutData(onAcceptSequenceTypeData);
        onAcceptSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
        onAcceptSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getOnAcceptSequenceType()));
            }

        });
        onAcceptSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType);
        Control onAcceptSequenceTypeHelp = FormUtils.createHelpButton(widgetFactory, filterOnAcceptanceSubPropertiesGroup,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createOnAcceptSequenceTypeEMFComboViewer
        onAcceptSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

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

        onAcceptSequenceTypeElements = new Control[] { onAcceptSequenceTypeLabel, onAcceptSequenceType.getControl(),
                onAcceptSequenceTypeHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createAdviceSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        filterAdviceSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Advice",
                true);
        Control adviceSequenceTypeLabel = createDescription(filterAdviceSubPropertiesGroup,
                EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_AdviceSequenceTypeLabel);
        adviceSequenceType = new EMFComboViewer(filterAdviceSubPropertiesGroup);
        adviceSequenceType.setContentProvider(new ArrayContentProvider());
        adviceSequenceType
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData adviceSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
        adviceSequenceType.getCombo().setLayoutData(adviceSequenceTypeData);
        adviceSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
        adviceSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAdviceSequenceType()));
            }

        });
        adviceSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType);
        Control adviceSequenceTypeHelp = FormUtils.createHelpButton(widgetFactory, filterAdviceSubPropertiesGroup,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createAdviceSequenceTypeEMFComboViewer
        adviceSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

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

        adviceSequenceTypeElements = new Control[] { adviceSequenceTypeLabel, adviceSequenceType.getControl(),
                adviceSequenceTypeHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createObligationsSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        filterObligationsSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Obligation",
                true);
        Control obligationSequenceTypeLabel = createDescription(filterObligationsSubPropertiesGroup,
                EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_ObligationsSequenceTypeLabel);
        obligationsSequenceType = new EMFComboViewer(filterObligationsSubPropertiesGroup);
        obligationsSequenceType.setContentProvider(new ArrayContentProvider());
        obligationsSequenceType
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData obligationsSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
        obligationsSequenceType.getCombo().setLayoutData(obligationsSequenceTypeData);
        obligationsSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
        obligationsSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getObligationsSequenceType()));
            }

        });
        obligationsSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType);
        Control obligationSequenceTypeHelp = FormUtils.createHelpButton(widgetFactory, filterObligationsSubPropertiesGroup,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createObligationsSequenceTypeEMFComboViewer
        obligationsSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

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

        obligationsSequenceTypeElements = new Control[] { obligationSequenceTypeLabel,
                obligationsSequenceType.getControl(), obligationSequenceTypeHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
        Control descriptionLabel = createDescription(parent,
                EsbViewsRepository.EntitlementMediator.Properties.description,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_DescriptionLabel);
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
                            EntitlementMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.EntitlementMediator.Properties.description,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.description,
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
                            EntitlementMediatorPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                                new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.EntitlementMediator.Properties.description,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        description.getText()));
                }
            }
        });
        EditingUtils.setID(description, EsbViewsRepository.EntitlementMediator.Properties.description);
        EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
        Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.description,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createDescriptionText
        descriptionElements = new Control[] { descriptionLabel, description, descriptionHelp };
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
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getCommentsList()
     * 
     */
    public EList getCommentsList() {
        return commentsListList;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setCommentsList(EList
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
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.commentsList);
        if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
            commentsList.setEnabled(false);
            commentsList.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
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
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getReverse()
     * 
     */
    public Boolean getReverse() {
        return Boolean.valueOf(reverse.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setReverse(Boolean
     *      newValue)
     * 
     */
    public void setReverse(Boolean newValue) {
        if (newValue != null) {
            reverse.setSelection(newValue.booleanValue());
        } else {
            reverse.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.reverse);
        if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
            reverse.setEnabled(false);
            reverse.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
            reverse.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getEntitlementServerURL()
     * 
     */
    public String getEntitlementServerURL() {
        return entitlementServerURL.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setEntitlementServerURL(String
     *      newValue)
     * 
     */
    public void setEntitlementServerURL(String newValue) {
        if (newValue != null) {
            entitlementServerURL.setText(newValue);
        } else {
            entitlementServerURL.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL);
        if (eefElementEditorReadOnlyState && entitlementServerURL.isEnabled()) {
            entitlementServerURL.setEnabled(false);
            entitlementServerURL.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !entitlementServerURL.isEnabled()) {
            entitlementServerURL.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getUsername()
     * 
     */
    public String getUsername() {
        return username.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setUsername(String
     *      newValue)
     * 
     */
    public void setUsername(String newValue) {
        if (newValue != null) {
            username.setText(newValue);
        } else {
            username.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.username);
        if (eefElementEditorReadOnlyState && username.isEnabled()) {
            username.setEnabled(false);
            username.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !username.isEnabled()) {
            username.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getPassword()
     * 
     */
    public String getPassword() {
        return password.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setPassword(String
     *      newValue)
     * 
     */
    public void setPassword(String newValue) {
        if (newValue != null) {
            password.setText(newValue);
        } else {
            password.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.password);
        if (eefElementEditorReadOnlyState && password.isEnabled()) {
            password.setEnabled(false);
            password.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !password.isEnabled()) {
            password.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getCallbackHandler()
     * 
     */
    public Enumerator getCallbackHandler() {
        Enumerator selection = (Enumerator) ((StructuredSelection) callbackHandler.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initCallbackHandler(Object
     *      input, Enumerator current)
     */
    public void initCallbackHandler(Object input, Enumerator current) {
        callbackHandler.setInput(input);
        callbackHandler.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.callbackHandler);
        if (eefElementEditorReadOnlyState && callbackHandler.isEnabled()) {
            callbackHandler.setEnabled(false);
            callbackHandler.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !callbackHandler.isEnabled()) {
            callbackHandler.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setCallbackHandler(Enumerator
     *      newValue)
     * 
     */
    public void setCallbackHandler(Enumerator newValue) {
        callbackHandler.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.callbackHandler);
        if (eefElementEditorReadOnlyState && callbackHandler.isEnabled()) {
            callbackHandler.setEnabled(false);
            callbackHandler.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !callbackHandler.isEnabled()) {
            callbackHandler.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getCallbackClassName()
     * 
     */
    public String getCallbackClassName() {
        return callbackClassName.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setCallbackClassName(String
     *      newValue)
     * 
     */
    public void setCallbackClassName(String newValue) {
        if (newValue != null) {
            callbackClassName.setText(newValue);
        } else {
            callbackClassName.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.callbackClassName);
        if (eefElementEditorReadOnlyState && callbackClassName.isEnabled()) {
            callbackClassName.setEnabled(false);
            callbackClassName.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !callbackClassName.isEnabled()) {
            callbackClassName.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getThriftHost()
     * 
     */
    public String getThriftHost() {
        return thriftHost.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setThriftHost(String
     *      newValue)
     * 
     */
    public void setThriftHost(String newValue) {
        if (newValue != null) {
            thriftHost.setText(newValue);
        } else {
            thriftHost.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.thriftHost);
        if (eefElementEditorReadOnlyState && thriftHost.isEnabled()) {
            thriftHost.setEnabled(false);
            thriftHost.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !thriftHost.isEnabled()) {
            thriftHost.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getThriftPort()
     * 
     */
    public String getThriftPort() {
        return thriftPort.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setThriftPort(String
     *      newValue)
     * 
     */
    public void setThriftPort(String newValue) {
        if (newValue != null) {
            thriftPort.setText(newValue);
        } else {
            thriftPort.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.thriftPort);
        if (eefElementEditorReadOnlyState && thriftPort.isEnabled()) {
            thriftPort.setEnabled(false);
            thriftPort.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !thriftPort.isEnabled()) {
            thriftPort.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getEntitlementClientType()
     * 
     */
    public Enumerator getEntitlementClientType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) entitlementClientType.getSelection())
                .getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initEntitlementClientType(Object
     *      input, Enumerator current)
     */
    public void initEntitlementClientType(Object input, Enumerator current) {
        entitlementClientType.setInput(input);
        entitlementClientType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType);
        if (eefElementEditorReadOnlyState && entitlementClientType.isEnabled()) {
            entitlementClientType.setEnabled(false);
            entitlementClientType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !entitlementClientType.isEnabled()) {
            entitlementClientType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setEntitlementClientType(Enumerator
     *      newValue)
     * 
     */
    public void setEntitlementClientType(Enumerator newValue) {
        entitlementClientType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType);
        if (eefElementEditorReadOnlyState && entitlementClientType.isEnabled()) {
            entitlementClientType.setEnabled(false);
            entitlementClientType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !entitlementClientType.isEnabled()) {
            entitlementClientType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getOnRejectSequenceType()
     * 
     */
    public Enumerator getOnRejectSequenceType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) onRejectSequenceType.getSelection())
                .getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initOnRejectSequenceType(Object
     *      input, Enumerator current)
     */
    public void initOnRejectSequenceType(Object input, Enumerator current) {
        onRejectSequenceType.setInput(input);
        onRejectSequenceType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType);
        if (eefElementEditorReadOnlyState && onRejectSequenceType.isEnabled()) {
            onRejectSequenceType.setEnabled(false);
            onRejectSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !onRejectSequenceType.isEnabled()) {
            onRejectSequenceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setOnRejectSequenceType(Enumerator
     *      newValue)
     * 
     */
    public void setOnRejectSequenceType(Enumerator newValue) {
        onRejectSequenceType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType);
        if (eefElementEditorReadOnlyState && onRejectSequenceType.isEnabled()) {
            onRejectSequenceType.setEnabled(false);
            onRejectSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !onRejectSequenceType.isEnabled()) {
            onRejectSequenceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getOnAcceptSequenceType()
     * 
     */
    public Enumerator getOnAcceptSequenceType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) onAcceptSequenceType.getSelection())
                .getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initOnAcceptSequenceType(Object
     *      input, Enumerator current)
     */
    public void initOnAcceptSequenceType(Object input, Enumerator current) {
        onAcceptSequenceType.setInput(input);
        onAcceptSequenceType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType);
        if (eefElementEditorReadOnlyState && onAcceptSequenceType.isEnabled()) {
            onAcceptSequenceType.setEnabled(false);
            onAcceptSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !onAcceptSequenceType.isEnabled()) {
            onAcceptSequenceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setOnAcceptSequenceType(Enumerator
     *      newValue)
     * 
     */
    public void setOnAcceptSequenceType(Enumerator newValue) {
        onAcceptSequenceType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType);
        if (eefElementEditorReadOnlyState && onAcceptSequenceType.isEnabled()) {
            onAcceptSequenceType.setEnabled(false);
            onAcceptSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !onAcceptSequenceType.isEnabled()) {
            onAcceptSequenceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getAdviceSequenceType()
     * 
     */
    public Enumerator getAdviceSequenceType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) adviceSequenceType.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initAdviceSequenceType(Object
     *      input, Enumerator current)
     */
    public void initAdviceSequenceType(Object input, Enumerator current) {
        adviceSequenceType.setInput(input);
        adviceSequenceType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType);
        if (eefElementEditorReadOnlyState && adviceSequenceType.isEnabled()) {
            adviceSequenceType.setEnabled(false);
            adviceSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !adviceSequenceType.isEnabled()) {
            adviceSequenceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setAdviceSequenceType(Enumerator
     *      newValue)
     * 
     */
    public void setAdviceSequenceType(Enumerator newValue) {
        adviceSequenceType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType);
        if (eefElementEditorReadOnlyState && adviceSequenceType.isEnabled()) {
            adviceSequenceType.setEnabled(false);
            adviceSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !adviceSequenceType.isEnabled()) {
            adviceSequenceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getObligationsSequenceType()
     * 
     */
    public Enumerator getObligationsSequenceType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) obligationsSequenceType.getSelection())
                .getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initObligationsSequenceType(Object
     *      input, Enumerator current)
     */
    public void initObligationsSequenceType(Object input, Enumerator current) {
        obligationsSequenceType.setInput(input);
        obligationsSequenceType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType);
        if (eefElementEditorReadOnlyState && obligationsSequenceType.isEnabled()) {
            obligationsSequenceType.setEnabled(false);
            obligationsSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !obligationsSequenceType.isEnabled()) {
            obligationsSequenceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setObligationsSequenceType(Enumerator
     *      newValue)
     * 
     */
    public void setObligationsSequenceType(Enumerator newValue) {
        obligationsSequenceType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType);
        if (eefElementEditorReadOnlyState && obligationsSequenceType.isEnabled()) {
            obligationsSequenceType.setEnabled(false);
            obligationsSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !obligationsSequenceType.isEnabled()) {
            obligationsSequenceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getDescription()
     * 
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setDescription(String
     *      newValue)
     * 
     */
    public void setDescription(String newValue) {
        if (newValue != null) {
            description.setText(newValue);
        } else {
            description.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.EntitlementMediator.Properties.description);
        if (eefElementEditorReadOnlyState && description.isEnabled()) {
            description.setEnabled(false);
            description.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
            description.setEnabled(true);
        }

    }

    // Start of user code for onRejectSequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getOnRejectSequenceKey() {
        return this.onRejectSequenceKey;
    }

    @Override
    public void setOnRejectSequenceKey(RegistryKeyProperty onRejectSequenceKey) {
        if (this.onRejectSequenceKey != null) {
            onRejectSequenceKeyText.setText(onRejectSequenceKey.getKeyValue());
            this.onRejectSequenceKey = onRejectSequenceKey;
        }
    }
    // End of user code

    // Start of user code for onAcceptSequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getOnAcceptSequenceKey() {
        return this.onAcceptSequenceKey;
    }

    @Override
    public void setOnAcceptSequenceKey(RegistryKeyProperty onAcceptSequenceKey) {
        if (this.onAcceptSequenceKey != null) {
            onAcceptSequenceKeyText.setText(onAcceptSequenceKey.getKeyValue());
            this.onAcceptSequenceKey = onAcceptSequenceKey;
        }
    }
    // End of user code

    // Start of user code for adviceSequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getAdviceSequenceKey() {
        return this.adviceSequenceKey;
    }

    @Override
    public void setAdviceSequenceKey(RegistryKeyProperty adviceSequenceKey) {
        if (this.adviceSequenceKey != null) {
            adviceSequenceKeyText.setText(adviceSequenceKey.getKeyValue());
            this.adviceSequenceKey = adviceSequenceKey;
        }
    }
    // End of user code

    // Start of user code for obligationsSequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getObligationsSequenceKey() {
        return this.obligationsSequenceKey;
    }

    @Override
    public void getObligationsSequenceKey(RegistryKeyProperty obligationsSequenceKey) {
        if (this.obligationsSequenceKey != null) {
            obligationsSequenceKeyText.setText(obligationsSequenceKey.getKeyValue());
            this.obligationsSequenceKey = obligationsSequenceKey;
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
        return EsbMessages.EntitlementMediator_Part_Title;
    }

    // Start of user code additional methods
    protected Composite createOnRejectSequenceKeyWidget(FormToolkit widgetFactory, final Composite parent) {
        Control onRejectSequenceKeyLabel = createDescription(parent,
                EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_OnRejectSequenceKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (onRejectSequenceKey == null) {
            onRejectSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }

        String initValueExpression = onRejectSequenceKey.getKeyValue().isEmpty() ? ""
                : onRejectSequenceKey.getKeyValue();
        onRejectSequenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        onRejectSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        onRejectSequenceKeyText.setLayoutData(valueData);
        onRejectSequenceKeyText.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, onRejectSequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                onRejectSequenceKeyText.setText(onRejectSequenceKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        EntitlementMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey,
                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnRejectSequenceKey()));
            }
        });
        EditingUtils.setID(onRejectSequenceKeyText,
                EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey);
        EditingUtils.setEEFtype(onRejectSequenceKeyText, "eef::Text");
        Control onRejectSequenceKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        onRejectSequenceKeyElements = new Control[] { onRejectSequenceKeyLabel, onRejectSequenceKeyText,
                onRejectSequenceKeyHelp };
        return parent;
    }

    protected Composite createOnAcceptSequenceKeyWidget(FormToolkit widgetFactory, final Composite parent) {
        Control onAcceptSequenceKeyLabel = createDescription(parent,
                EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceKey,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_OnAcceptSequenceKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (onAcceptSequenceKey == null) {
            onAcceptSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }

        String initValueExpression = onAcceptSequenceKey.getKeyValue().isEmpty() ? ""
                : onAcceptSequenceKey.getKeyValue();
        onAcceptSequenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        onAcceptSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        onAcceptSequenceKeyText.setLayoutData(valueData);
        onAcceptSequenceKeyText.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, onAcceptSequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                onAcceptSequenceKeyText.setText(onAcceptSequenceKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        EntitlementMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceKey,
                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnRejectSequenceKey()));
            }
        });
        EditingUtils.setID(onAcceptSequenceKeyText,
                EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey);
        EditingUtils.setEEFtype(onAcceptSequenceKeyText, "eef::Text");
        Control onAcceptSequenceKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        onAcceptSequenceKeyElements = new Control[] { onAcceptSequenceKeyLabel, onAcceptSequenceKeyText,
                onAcceptSequenceKeyHelp };
        return parent;
    }

    protected Composite createAdviceSequenceKeyWidget(FormToolkit widgetFactory, final Composite parent) {
        Control adviceSequenceKeyLabel = createDescription(parent,
                EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceKey,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_AdviceSequenceKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (adviceSequenceKey == null) {
            adviceSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }

        String initValueExpression = adviceSequenceKey.getKeyValue().isEmpty() ? "" : adviceSequenceKey.getKeyValue();
        adviceSequenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        adviceSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        adviceSequenceKeyText.setLayoutData(valueData);
        adviceSequenceKeyText.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, adviceSequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                adviceSequenceKeyText.setText(adviceSequenceKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        EntitlementMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceKey,
                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnRejectSequenceKey()));
            }
        });
        EditingUtils.setID(adviceSequenceKeyText,
                EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey);
        EditingUtils.setEEFtype(adviceSequenceKeyText, "eef::Text");
        Control adviceSequenceKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        adviceSequenceKeyElements = new Control[] { adviceSequenceKeyLabel, adviceSequenceKeyText,
                adviceSequenceKeyHelp };
        return parent;
    }

    protected Composite createObligationsSequenceKeyWidget(FormToolkit widgetFactory, final Composite parent) {
        Control obligationsSequenceKeyLabel = createDescription(parent,
                EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceKey,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_ObligationsSequenceKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (obligationsSequenceKey == null) {
            obligationsSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }

        String initValueExpression = obligationsSequenceKey.getKeyValue().isEmpty() ? ""
                : obligationsSequenceKey.getKeyValue();
        obligationsSequenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        obligationsSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        obligationsSequenceKeyText.setLayoutData(valueData);
        obligationsSequenceKeyText.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, obligationsSequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                obligationsSequenceKeyText.setText(obligationsSequenceKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        EntitlementMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceKey,
                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnRejectSequenceKey()));
            }
        });
        EditingUtils.setID(obligationsSequenceKeyText,
                EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey);
        EditingUtils.setEEFtype(obligationsSequenceKeyText, "eef::Text");
        Control obligationsSequenceKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        obligationsSequenceKeyElements = new Control[] { obligationsSequenceKeyLabel, obligationsSequenceKeyText,
                obligationsSequenceKeyHelp };
        return parent;
    }

    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.hideEntry(reverseElements, false);
        epv.hideEntry(commentListElements, false);
        
        epv.showEntry(new Control[] { filterOnAcceptanceSubPropertiesGroup.getParent() }, false);
        epv.clearElements(new Composite[] { filterOnAcceptanceSubPropertiesGroup });
        epv.showEntry(new Control[] { filterOnRejectionSubPropertiesGroup.getParent() }, false);
        epv.clearElements(new Composite[] { filterOnRejectionSubPropertiesGroup });
        epv.showEntry(new Control[] { filterObligationsSubPropertiesGroup.getParent() }, false);
        epv.clearElements(new Composite[] { filterObligationsSubPropertiesGroup });
        epv.showEntry(new Control[] { filterAdviceSubPropertiesGroup.getParent() }, false);
        epv.clearElements(new Composite[] { filterAdviceSubPropertiesGroup });

        epv.showEntry(entitlementServerURLElements, false);
        epv.showEntry(usernameElements, false);
        epv.showEntry(passwordElements, false);
        epv.showEntry(callbackHandlerElements, false);
        epv.showEntry(callbackClassNameElements, false);
        epv.showEntry(entitlementClientTypeElements, false);
        epv.showEntry(onRejectSequenceTypeElements, false);
        epv.showEntry(onAcceptSequenceTypeElements, false);
        epv.showEntry(adviceSequenceTypeElements, false);
        epv.showEntry(obligationsSequenceTypeElements, false);
        epv.showEntry(descriptionElements, false);

        switch (getCallbackHandler().getLiteral()) {
        case "Custom": {
            epv.showEntry(callbackClassNameElements, false);
            break;
        }

        default: {
            epv.hideEntry(callbackClassNameElements, false);
            break;
        }
        }

        switch (getEntitlementClientType().getLiteral()) {
        case "THRIFT": {
            epv.showEntry(thriftHostElements, false);
            epv.showEntry(thriftPortElements, false);
            break;
        }

        default: {
            epv.hideEntry(thriftHostElements, false);
            epv.hideEntry(thriftPortElements, false);
            break;
        }
        }

        switch (getOnRejectSequenceType().getLiteral()) {
        case "REGISTRY_REFERENCE": {
            epv.showEntry(onRejectSequenceKeyElements, false);
            break;
        }

        default: {
            epv.hideEntry(onRejectSequenceKeyElements, false);
            break;
        }
        }

        switch (getOnAcceptSequenceType().getLiteral()) {
        case "REGISTRY_REFERENCE": {
            epv.showEntry(onAcceptSequenceKeyElements, false);
            break;
        }

        default: {
            epv.hideEntry(onAcceptSequenceKeyElements, false);
            break;
        }
        }

        switch (getAdviceSequenceType().getLiteral()) {
        case "REGISTRY_REFERENCE": {
            epv.showEntry(adviceSequenceKeyElements, false);
            break;
        }

        default: {
            epv.hideEntry(adviceSequenceKeyElements, false);
            break;
        }
        }

        switch (getObligationsSequenceType().getLiteral()) {
        case "REGISTRY_REFERENCE": {
            epv.showEntry(obligationsSequenceKeyElements, false);
            break;
        }

        default: {
            epv.hideEntry(obligationsSequenceKeyElements, false);
            break;
        }
        }

        epv.showEntry(descriptionElements, false);

        view.layout(true, true);
    }
    // End of user code

}
