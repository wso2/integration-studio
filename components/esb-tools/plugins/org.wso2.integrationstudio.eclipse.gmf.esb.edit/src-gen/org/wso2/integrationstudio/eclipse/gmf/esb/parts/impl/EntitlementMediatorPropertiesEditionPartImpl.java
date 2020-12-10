/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

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
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class EntitlementMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart
        implements ISWTPropertiesEditionPart, EntitlementMediatorPropertiesEditionPart {

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
    // Start of user code for onRejectSequenceKey widgets declarations
    protected RegistryKeyProperty onRejectSequenceKey;
    // End of user code

    protected EMFComboViewer onAcceptSequenceType;
    // Start of user code for onAcceptSequenceKey widgets declarations
    protected RegistryKeyProperty onAcceptSequenceKey;
    // End of user code

    protected EMFComboViewer adviceSequenceType;
    // Start of user code for adviceSequenceKey widgets declarations
    protected RegistryKeyProperty adviceSequenceKey;
    // End of user code

    protected EMFComboViewer obligationsSequenceType;
    // Start of user code for obligationsSequenceKey widgets declarations
    protected RegistryKeyProperty obligationsSequenceKey;
    // End of user code

    protected Text description;

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public EntitlementMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
        super(editionComponent);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
     *      createFigure(org.eclipse.swt.widgets.Composite)
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
     *      createControls(org.eclipse.swt.widgets.Composite)
     * 
     */
    public void createControls(Composite view) {
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
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.thriftHost);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.thriftPort);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceKey);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceKey);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceKey);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceKey);
        propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.description);

        composer = new PartComposer(entitlementMediatorStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.EntitlementMediator.Properties.class) {
                    return createPropertiesGroup(parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.commentsList) {
                    return createCommentsListMultiValuedEditor(parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.reverse) {
                    return createReverseCheckbox(parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL) {
                    return createEntitlementServerURLText(parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.username) {
                    return createUsernameText(parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.password) {
                    return createPasswordText(parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.callbackHandler) {
                    return createCallbackHandlerEMFComboViewer(parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.callbackClassName) {
                    return createCallbackClassNameText(parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.thriftHost) {
                    return createThriftHostText(parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.thriftPort) {
                    return createThriftPortText(parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType) {
                    return createEntitlementClientTypeEMFComboViewer(parent);
                }
                if (key == EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType) {
                    return createOnRejectSequenceTypeEMFComboViewer(parent);
                }
                // Start of user code for onRejectSequenceKey addToPart creation

                // End of user code
                if (key == EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType) {
                    return createOnAcceptSequenceTypeEMFComboViewer(parent);
                }
                // Start of user code for onAcceptSequenceKey addToPart creation

                // End of user code
                if (key == EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType) {
                    return createAdviceSequenceTypeEMFComboViewer(parent);
                }
                // Start of user code for adviceSequenceKey addToPart creation

                // End of user code
                if (key == EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType) {
                    return createObligationsSequenceTypeEMFComboViewer(parent);
                }
                // Start of user code for obligationsSequenceKey addToPart creation

                // End of user code
                if (key == EsbViewsRepository.EntitlementMediator.Properties.description) {
                    return createDescriptionText(parent);
                }
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
        propertiesGroup.setText(EsbMessages.EntitlementMediatorPropertiesEditionPart_PropertiesGroupLabel);
        GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesGroupData.horizontalSpan = 3;
        propertiesGroup.setLayoutData(propertiesGroupData);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 3;
        propertiesGroup.setLayout(propertiesGroupLayout);
        return propertiesGroup;
    }

    protected Composite createCommentsListMultiValuedEditor(Composite parent) {
        commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
        commentsListData.horizontalSpan = 2;
        commentsList.setLayoutData(commentsListData);
        EditingUtils.setID(commentsList, EsbViewsRepository.EntitlementMediator.Properties.commentsList);
        EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
        editCommentsList = new Button(parent, SWT.NONE);
        editCommentsList.setText(getDescription(EsbViewsRepository.EntitlementMediator.Properties.commentsList,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_CommentsListLabel));
        GridData editCommentsListData = new GridData();
        editCommentsList.setLayoutData(editCommentsListData);
        editCommentsList.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
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
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartImpl.this,
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

        // End of user code
        return parent;
    }

    protected Composite createReverseCheckbox(Composite parent) {
        reverse = new Button(parent, SWT.CHECK);
        reverse.setText(getDescription(EsbViewsRepository.EntitlementMediator.Properties.reverse,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_ReverseLabel));
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
                            EntitlementMediatorPropertiesEditionPartImpl.this,
                            EsbViewsRepository.EntitlementMediator.Properties.reverse, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
            }

        });
        GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
        reverseData.horizontalSpan = 2;
        reverse.setLayoutData(reverseData);
        EditingUtils.setID(reverse, EsbViewsRepository.EntitlementMediator.Properties.reverse);
        EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EntitlementMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); // $NON-NLS-1$
        // Start of user code for createReverseCheckbox

        // End of user code
        return parent;
    }

    protected Composite createEntitlementServerURLText(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_EntitlementServerURLLabel);
        entitlementServerURL = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData entitlementServerURLData = new GridData(GridData.FILL_HORIZONTAL);
        entitlementServerURL.setLayoutData(entitlementServerURLData);
        entitlementServerURL.addFocusListener(new FocusAdapter() {

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
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartImpl.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    entitlementServerURL.getText()));
            }

        });
        entitlementServerURL.addKeyListener(new KeyAdapter() {

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
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartImpl.this,
                                        EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        entitlementServerURL.getText()));
                }
            }

        });
        EditingUtils.setID(entitlementServerURL,
                EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL);
        EditingUtils.setEEFtype(entitlementServerURL, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL,
                        EsbViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createEntitlementServerURLText

        // End of user code
        return parent;
    }

    protected Composite createUsernameText(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.username,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_UsernameLabel);
        username = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData usernameData = new GridData(GridData.FILL_HORIZONTAL);
        username.setLayoutData(usernameData);
        username.addFocusListener(new FocusAdapter() {

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
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartImpl.this,
                            EsbViewsRepository.EntitlementMediator.Properties.username, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, username.getText()));
            }

        });
        username.addKeyListener(new KeyAdapter() {

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
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                EntitlementMediatorPropertiesEditionPartImpl.this,
                                EsbViewsRepository.EntitlementMediator.Properties.username,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, username.getText()));
                }
            }

        });
        EditingUtils.setID(username, EsbViewsRepository.EntitlementMediator.Properties.username);
        EditingUtils.setEEFtype(username, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EntitlementMediator.Properties.username, EsbViewsRepository.SWT_KIND), null); // $NON-NLS-1$
        // Start of user code for createUsernameText

        // End of user code
        return parent;
    }

    protected Composite createPasswordText(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.password,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_PasswordLabel);
        password = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData passwordData = new GridData(GridData.FILL_HORIZONTAL);
        password.setLayoutData(passwordData);
        password.addFocusListener(new FocusAdapter() {

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
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartImpl.this,
                            EsbViewsRepository.EntitlementMediator.Properties.password, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, password.getText()));
            }

        });
        password.addKeyListener(new KeyAdapter() {

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
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                EntitlementMediatorPropertiesEditionPartImpl.this,
                                EsbViewsRepository.EntitlementMediator.Properties.password,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, password.getText()));
                }
            }

        });
        EditingUtils.setID(password, EsbViewsRepository.EntitlementMediator.Properties.password);
        EditingUtils.setEEFtype(password, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EntitlementMediator.Properties.password, EsbViewsRepository.SWT_KIND), null); // $NON-NLS-1$
        // Start of user code for createPasswordText

        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createCallbackHandlerEMFComboViewer(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.callbackHandler,
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
                            EntitlementMediatorPropertiesEditionPartImpl.this,
                            EsbViewsRepository.EntitlementMediator.Properties.callbackHandler,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCallbackHandler()));
            }

        });
        callbackHandler.setID(EsbViewsRepository.EntitlementMediator.Properties.callbackHandler);
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.callbackHandler, EsbViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createCallbackHandlerEMFComboViewer

        // End of user code
        return parent;
    }

    protected Composite createCallbackClassNameText(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.callbackClassName,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_CallbackClassNameLabel);
        callbackClassName = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData callbackClassNameData = new GridData(GridData.FILL_HORIZONTAL);
        callbackClassName.setLayoutData(callbackClassNameData);
        callbackClassName.addFocusListener(new FocusAdapter() {

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
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartImpl.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.callbackClassName,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    callbackClassName.getText()));
            }

        });
        callbackClassName.addKeyListener(new KeyAdapter() {

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
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartImpl.this,
                                        EsbViewsRepository.EntitlementMediator.Properties.callbackClassName,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        callbackClassName.getText()));
                }
            }

        });
        EditingUtils.setID(callbackClassName, EsbViewsRepository.EntitlementMediator.Properties.callbackClassName);
        EditingUtils.setEEFtype(callbackClassName, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.callbackClassName,
                        EsbViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createCallbackClassNameText

        // End of user code
        return parent;
    }

    protected Composite createThriftHostText(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.thriftHost,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_ThriftHostLabel);
        thriftHost = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData thriftHostData = new GridData(GridData.FILL_HORIZONTAL);
        thriftHost.setLayoutData(thriftHostData);
        thriftHost.addFocusListener(new FocusAdapter() {

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
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartImpl.this,
                            EsbViewsRepository.EntitlementMediator.Properties.thriftHost, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, thriftHost.getText()));
            }

        });
        thriftHost.addKeyListener(new KeyAdapter() {

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
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                EntitlementMediatorPropertiesEditionPartImpl.this,
                                EsbViewsRepository.EntitlementMediator.Properties.thriftHost,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, thriftHost.getText()));
                }
            }

        });
        EditingUtils.setID(thriftHost, EsbViewsRepository.EntitlementMediator.Properties.thriftHost);
        EditingUtils.setEEFtype(thriftHost, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EntitlementMediator.Properties.thriftHost, EsbViewsRepository.SWT_KIND), null); // $NON-NLS-1$
        // Start of user code for createThriftHostText

        // End of user code
        return parent;
    }

    protected Composite createThriftPortText(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.thriftPort,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_ThriftPortLabel);
        thriftPort = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData thriftPortData = new GridData(GridData.FILL_HORIZONTAL);
        thriftPort.setLayoutData(thriftPortData);
        thriftPort.addFocusListener(new FocusAdapter() {

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
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartImpl.this,
                            EsbViewsRepository.EntitlementMediator.Properties.thriftPort, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, thriftPort.getText()));
            }

        });
        thriftPort.addKeyListener(new KeyAdapter() {

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
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                EntitlementMediatorPropertiesEditionPartImpl.this,
                                EsbViewsRepository.EntitlementMediator.Properties.thriftPort,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, thriftPort.getText()));
                }
            }

        });
        EditingUtils.setID(thriftPort, EsbViewsRepository.EntitlementMediator.Properties.thriftPort);
        EditingUtils.setEEFtype(thriftPort, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EntitlementMediator.Properties.thriftPort, EsbViewsRepository.SWT_KIND), null); // $NON-NLS-1$
        // Start of user code for createThriftPortText

        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createEntitlementClientTypeEMFComboViewer(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType,
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
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartImpl.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getEntitlementClientType()));
            }

        });
        entitlementClientType.setID(EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType);
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType,
                        EsbViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createEntitlementClientTypeEMFComboViewer

        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createOnRejectSequenceTypeEMFComboViewer(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_OnRejectSequenceTypeLabel);
        onRejectSequenceType = new EMFComboViewer(parent);
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
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartImpl.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getOnRejectSequenceType()));
            }

        });
        onRejectSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType);
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType,
                        EsbViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createOnRejectSequenceTypeEMFComboViewer

        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createOnAcceptSequenceTypeEMFComboViewer(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_OnAcceptSequenceTypeLabel);
        onAcceptSequenceType = new EMFComboViewer(parent);
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
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartImpl.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getOnAcceptSequenceType()));
            }

        });
        onAcceptSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType);
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType,
                        EsbViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createOnAcceptSequenceTypeEMFComboViewer

        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createAdviceSequenceTypeEMFComboViewer(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_AdviceSequenceTypeLabel);
        adviceSequenceType = new EMFComboViewer(parent);
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
                            EntitlementMediatorPropertiesEditionPartImpl.this,
                            EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAdviceSequenceType()));
            }

        });
        adviceSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType);
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType,
                        EsbViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createAdviceSequenceTypeEMFComboViewer

        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createObligationsSequenceTypeEMFComboViewer(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_ObligationsSequenceTypeLabel);
        obligationsSequenceType = new EMFComboViewer(parent);
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
                            new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartImpl.this,
                                    EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getObligationsSequenceType()));
            }

        });
        obligationsSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType);
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType,
                        EsbViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createObligationsSequenceTypeEMFComboViewer

        // End of user code
        return parent;
    }

    protected Composite createDescriptionText(Composite parent) {
        createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.description,
                EsbMessages.EntitlementMediatorPropertiesEditionPart_DescriptionLabel);
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
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EntitlementMediatorPropertiesEditionPartImpl.this,
                            EsbViewsRepository.EntitlementMediator.Properties.description,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartImpl.this,
                                        EsbViewsRepository.EntitlementMediator.Properties.description,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        description.getText()));
                }
            }

        });
        EditingUtils.setID(description, EsbViewsRepository.EntitlementMediator.Properties.description);
        EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.EntitlementMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); // $NON-NLS-1$
        // Start of user code for createDescriptionText

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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getCommentsList()
     * 
     */
    public EList getCommentsList() {
        return commentsListList;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setCommentsList(EList
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getReverse()
     * 
     */
    public Boolean getReverse() {
        return Boolean.valueOf(reverse.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setReverse(Boolean
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getEntitlementServerURL()
     * 
     */
    public String getEntitlementServerURL() {
        return entitlementServerURL.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setEntitlementServerURL(String
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getUsername()
     * 
     */
    public String getUsername() {
        return username.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setUsername(String
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getPassword()
     * 
     */
    public String getPassword() {
        return password.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setPassword(String
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getCallbackHandler()
     * 
     */
    public Enumerator getCallbackHandler() {
        Enumerator selection = (Enumerator) ((StructuredSelection) callbackHandler.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initCallbackHandler(Object
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setCallbackHandler(Enumerator
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getCallbackClassName()
     * 
     */
    public String getCallbackClassName() {
        return callbackClassName.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setCallbackClassName(String
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getThriftHost()
     * 
     */
    public String getThriftHost() {
        return thriftHost.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setThriftHost(String
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getThriftPort()
     * 
     */
    public String getThriftPort() {
        return thriftPort.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setThriftPort(String
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getEntitlementClientType()
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initEntitlementClientType(Object
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setEntitlementClientType(Enumerator
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getOnRejectSequenceType()
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initOnRejectSequenceType(Object
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setOnRejectSequenceType(Enumerator
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getOnAcceptSequenceType()
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initOnAcceptSequenceType(Object
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setOnAcceptSequenceType(Enumerator
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getAdviceSequenceType()
     * 
     */
    public Enumerator getAdviceSequenceType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) adviceSequenceType.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initAdviceSequenceType(Object
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setAdviceSequenceType(Enumerator
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getObligationsSequenceType()
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initObligationsSequenceType(Object
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setObligationsSequenceType(Enumerator
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getDescription()
     * 
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setDescription(String
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
        this.onRejectSequenceKey = onRejectSequenceKey;
    }
    // End of user code

    // Start of user code for onAcceptSequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getOnAcceptSequenceKey() {
        return this.onAcceptSequenceKey;
    }

    @Override
    public void setOnAcceptSequenceKey(RegistryKeyProperty onAcceptSequenceKey) {
        this.onAcceptSequenceKey = onAcceptSequenceKey;
    }
    // End of user code

    // Start of user code for adviceSequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getAdviceSequenceKey() {
        return this.adviceSequenceKey;
    }

    @Override
    public void setAdviceSequenceKey(RegistryKeyProperty adviceSequenceKey) {
        this.adviceSequenceKey = adviceSequenceKey;
    }
    // End of user code

    // Start of user code for obligationsSequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getObligationsSequenceKey() {
        return this.obligationsSequenceKey;
    }

    @Override
    public void getObligationsSequenceKey(RegistryKeyProperty obligationsSequenceKey) {
        this.obligationsSequenceKey = obligationsSequenceKey;
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

    // End of user code

}
