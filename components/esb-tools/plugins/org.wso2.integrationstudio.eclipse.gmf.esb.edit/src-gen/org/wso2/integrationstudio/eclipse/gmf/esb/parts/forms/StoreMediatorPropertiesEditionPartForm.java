/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.jface.dialogs.ErrorDialog;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.wso2.integrationstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.integrationstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart;
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
public class StoreMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, StoreMediatorPropertiesEditionPart {

    // Start of user code
	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text messageStore;
	protected EMFComboViewer availableMessageStores;
	protected EMFComboViewer specifyAs;
	
	protected static String MESSAGE_STORE_DEFAULT_VALUE = "Select From Message Stores";
    protected NamespacedProperty expression;
    protected RegistryKeyProperty sequenceKey;
    protected Composite propertiesGroup;
    protected Control[] specifyAsElements;
    protected Control[] availableMessageStoreElements;
    protected Control[] messageStoreElements;
    protected Control[] descriptionElements;
    protected Composite messageStoreSubsection;

	// End of user code 

	// Start of user code  for onStoreSequence widgets declarations
    protected Text onSequenceKeyText;
    protected Control[] onSequenceKeyElements;
	// End of user code

	// Start of user code  for expression widgets declarations
	protected Text expressionText;
	protected Control[] exoressionElements;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public StoreMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public StoreMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
	 * @generated NOT
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence storeMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = storeMediatorStep.addStep(EsbViewsRepository.StoreMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.specifyAs);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.expression);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.availableMessageStores);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.messageStore);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.onStoreSequence);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.reverse);
		
		
		composer = new PartComposer(storeMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.StoreMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.messageStore) {
					return createMessageStoreText(widgetFactory, messageStoreSubsection);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.availableMessageStores) {
					return createAvailableMessageStoresText(widgetFactory, messageStoreSubsection);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.specifyAs) {
					return createSpecifyAsEMFComboViewer(widgetFactory, parent);
				}
				// Start of user code for onStoreSequence addToPart creation
                if (key == EsbViewsRepository.StoreMediator.Properties.onStoreSequence) {
                    return createOnStoreSequenceWidget(widgetFactory, parent);
                }
				// End of user code
				// Start of user code for expression addToPart creation
                if (key == EsbViewsRepository.StoreMediator.Properties.expression) {
                    return createExpressionWidget(widgetFactory, messageStoreSubsection);
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
		propertiesSection.setText(EsbMessages.StoreMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.StoreMediator.Properties.description, EsbMessages.StoreMediatorPropertiesEditionPart_DescriptionLabel);
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
							StoreMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.StoreMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									StoreMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.StoreMediator.Properties.description,
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
									StoreMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartForm.this, EsbViewsRepository.StoreMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.StoreMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.StoreMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		EditingUtils.setID(commentsList, EsbViewsRepository.StoreMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.StoreMediator.Properties.commentsList, EsbMessages.StoreMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "StoreMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartForm.this, EsbViewsRepository.StoreMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.StoreMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.StoreMediator.Properties.reverse, EsbMessages.StoreMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartForm.this, EsbViewsRepository.StoreMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.StoreMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.StoreMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	 /**
     * @generated NOT
     */
	protected Composite createMessageStoreText(FormToolkit widgetFactory, Composite parent) {
		Control messageStoreLabel = createDescription(parent, EsbViewsRepository.StoreMediator.Properties.messageStore, EsbMessages.StoreMediatorPropertiesEditionPart_MessageStoreLabel);
		messageStore = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		messageStore.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData messageStoreData = new GridData(GridData.FILL_HORIZONTAL);
		messageStore.setLayoutData(messageStoreData);
		messageStore.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							StoreMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.StoreMediator.Properties.messageStore,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, messageStore.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									StoreMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.StoreMediator.Properties.messageStore,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, messageStore.getText()));
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
									StoreMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		messageStore.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartForm.this, EsbViewsRepository.StoreMediator.Properties.messageStore, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, messageStore.getText()));
				}
			}
		});
		EditingUtils.setID(messageStore, EsbViewsRepository.StoreMediator.Properties.messageStore);
		EditingUtils.setEEFtype(messageStore, "eef::Text"); //$NON-NLS-1$
		Control messageStoreHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.StoreMediator.Properties.messageStore, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMessageStoreText
		messageStoreElements = new Control [] {messageStoreLabel, messageStore, messageStoreHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
    protected Composite createAvailableMessageStoresText(FormToolkit widgetFactory, Composite parent) {
        Control availableMessageStoresLabel = createDescription(parent, EsbViewsRepository.StoreMediator.Properties.availableMessageStores, EsbMessages.StoreMediatorPropertiesEditionPart_AvailableMessageStoresLabel);
        
        availableMessageStores = new EMFComboViewer(parent);
        availableMessageStores.setContentProvider(new ArrayContentProvider());
        availableMessageStores.setInput(getAvailableArtifactListFromProject(parent));
        availableMessageStores.getCombo().select(0);
        availableMessageStores.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData availableMessageStoresData = new GridData(GridData.FILL_HORIZONTAL);
        availableMessageStores.getCombo().setLayoutData(availableMessageStoresData);
        availableMessageStores.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
        EditingUtils.setID(availableMessageStores.getCombo(), EsbViewsRepository.StoreMediator.Properties.availableMessageStores);
        EditingUtils.setEEFtype(availableMessageStores.getCombo(), "eef::Text"); //$NON-NLS-1$
        Control availableMessageStoreHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.StoreMediator.Properties.availableMessageStores, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        // Start of user code for createAvailableMessageStoresText
        availableMessageStoreElements = new Control [] {availableMessageStoresLabel, availableMessageStores.getCombo(), availableMessageStoreHelp};
        availableMessageStores.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if(MESSAGE_STORE_DEFAULT_VALUE.equals(availableMessageStores.getCombo().getText())) {
                messageStore.setText("");
                messageStore.forceFocus();
                }else {
                    messageStore.setText(availableMessageStores.getCombo().getText());
                    messageStore.forceFocus();
                }
            }

        });
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
	protected Composite createSpecifyAsEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    messageStoreSubsection = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Message Store", true);
		Control specifyAsLabel = createDescription(messageStoreSubsection, EsbViewsRepository.StoreMediator.Properties.specifyAs, EsbMessages.StoreMediatorPropertiesEditionPart_SpecifyAsLabel);
		specifyAs = new EMFComboViewer(messageStoreSubsection);
		specifyAs.setContentProvider(new ArrayContentProvider());
		specifyAs.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData specifyAsData = new GridData(GridData.FILL_HORIZONTAL);
		specifyAs.getCombo().setLayoutData(specifyAsData);
                specifyAs.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		specifyAs.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartForm.this, EsbViewsRepository.StoreMediator.Properties.specifyAs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSpecifyAs()));
			}

		});
		specifyAs.setID(EsbViewsRepository.StoreMediator.Properties.specifyAs);
		Control specifyAsHelp = FormUtils.createHelpButton(widgetFactory, messageStoreSubsection, propertiesEditionComponent.getHelpContent(EsbViewsRepository.StoreMediator.Properties.specifyAs, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSpecifyAsEMFComboViewer
		specifyAs.addSelectionChangedListener(new ISelectionChangedListener() {

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

		specifyAsElements = new Control [] {specifyAsLabel, specifyAs.getCombo(), specifyAsHelp};
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.StoreMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.StoreMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.StoreMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.StoreMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.StoreMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.StoreMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#getMessageStore()
	 * 
	 */
	public String getMessageStore() {
		return messageStore.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#setMessageStore(String newValue)
	 * 
	 */
	public void setMessageStore(String newValue) {
		if (newValue != null) {
			messageStore.setText(newValue);
		} else {
			messageStore.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.StoreMediator.Properties.messageStore);
		if (eefElementEditorReadOnlyState && messageStore.isEnabled()) {
			messageStore.setEnabled(false);
			messageStore.setToolTipText(EsbMessages.StoreMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !messageStore.isEnabled()) {
			messageStore.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#getAvailableMessageStores()
	 * 
	 */
	public String getAvailableMessageStores() {
		return availableMessageStores.getCombo().getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#setAvailableMessageStores(String newValue)
	 * 
	 */
	public void setAvailableMessageStores(String newValue) {
		if (newValue != null) {
			availableMessageStores.getCombo().setText(newValue);
		} else {
			availableMessageStores.getCombo().setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#getSpecifyAs()
	 * 
	 */
	public Enumerator getSpecifyAs() {
		Enumerator selection = (Enumerator) ((StructuredSelection) specifyAs.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#initSpecifyAs(Object input, Enumerator current)
	 */
	public void initSpecifyAs(Object input, Enumerator current) {
		specifyAs.setInput(input);
		specifyAs.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.StoreMediator.Properties.specifyAs);
		if (eefElementEditorReadOnlyState && specifyAs.isEnabled()) {
			specifyAs.setEnabled(false);
			specifyAs.setToolTipText(EsbMessages.StoreMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !specifyAs.isEnabled()) {
			specifyAs.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#setSpecifyAs(Enumerator newValue)
	 * 
	 */
	public void setSpecifyAs(Enumerator newValue) {
		specifyAs.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.StoreMediator.Properties.specifyAs);
		if (eefElementEditorReadOnlyState && specifyAs.isEnabled()) {
			specifyAs.setEnabled(false);
			specifyAs.setToolTipText(EsbMessages.StoreMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !specifyAs.isEnabled()) {
			specifyAs.setEnabled(true);
		}	
		
	}






	// Start of user code for onStoreSequence specific getters and setters implementation
    @Override
    public RegistryKeyProperty getOnStoreSequence(){
        return sequenceKey;
    }

    @Override
    public void setOnStoreSequence(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            onSequenceKeyText.setText(registryKeyProperty.getKeyValue());
            sequenceKey= registryKeyProperty;
        }
    }
	// End of user code

	// Start of user code for expression specific getters and setters implementation
    @Override
    public NamespacedProperty getExpression() {
        return expression;
    }

    @Override
    public void setExpression(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            expressionText.setText(nameSpacedProperty.getPropertyValue());
            expression = nameSpacedProperty;
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
		return EsbMessages.StoreMediator_Part_Title;
	}

	// Start of user code additional methods
    protected Composite createOnStoreSequenceWidget(FormToolkit widgetFactory, Composite parent) {
        Control onSequenceKeyLabel = createDescription(parent, EsbViewsRepository.StoreMediator.Properties.onStoreSequence,
                EsbMessages.StoreMediatorPropertiesEditionPart_OnStoreSequenceLabel);
        widgetFactory.paintBordersFor(parent);
        if (sequenceKey == null) {
            sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initValueExpression = sequenceKey.getKeyValue().isEmpty() ? "" : sequenceKey.getKeyValue();
        onSequenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        onSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        onSequenceKeyText.setLayoutData(valueData);
        onSequenceKeyText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                onSequenceKeyText.setText(sequenceKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.StoreMediator.Properties.onStoreSequence,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnStoreSequence()));
            }

        });
        
        onSequenceKeyText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    onSequenceKeyText.setText(sequenceKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            StoreMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.StoreMediator.Properties.onStoreSequence, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getOnStoreSequence()));
                }
            }

        });

        EditingUtils.setID(onSequenceKeyText, EsbViewsRepository.StoreMediator.Properties.onStoreSequence);
        EditingUtils.setEEFtype(onSequenceKeyText, "eef::Text");
        Control sequenceKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.StoreMediator.Properties.onStoreSequence,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        onSequenceKeyElements = new Control[] { onSequenceKeyLabel, onSequenceKeyText, sequenceKeyHelp };
        return parent;
    }
    
    protected Composite createExpressionWidget(FormToolkit widgetFactory, final Composite parent) {
        Control expressionPathLabel = createDescription(parent, EsbViewsRepository.StoreMediator.Properties.expression,
                EsbMessages.StoreMediatorPropertiesEditionPart_ExpressionLabel);
        widgetFactory.paintBordersFor(parent);
        if (expression == null) {
            expression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = expression.getPropertyValue().isEmpty() ? "" : expression.getPropertyValue();
        expressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        expressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        expressionText.setLayoutData(valueData);

        expressionText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                openExpressionWidgetNamespacedPropertyEditor(parent);
            }
            
        });
        
        expressionText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if(!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openExpressionWidgetNamespacedPropertyEditor(parent);
                }
            }
            
        });
        
        EditingUtils.setID(expressionText, EsbViewsRepository.StoreMediator.Properties.expression);
        EditingUtils.setEEFtype(expressionText, "eef::Text");
        Control expressionHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.StoreMediator.Properties.expression, EsbViewsRepository.FORM_KIND),
                        null); // $NON-NLS-1$
        exoressionElements = new Control[] { expressionPathLabel, expressionText, expressionHelp };
        return parent;
    }
    
    private void openExpressionWidgetNamespacedPropertyEditor(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                expression);
        expression = nspd.open();
        expressionText.setText(expression.getPropertyValue());
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                StoreMediatorPropertiesEditionPartForm.this, EsbViewsRepository.StoreMediator.Properties.expression,
                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getExpression()));
    }
    
    protected ArrayList<String> getAvailableArtifactListFromProject(Composite parent) {

        String synapseArtifcatCategory = "synapse/message-store";
        String comboBoxDefaultValue = MESSAGE_STORE_DEFAULT_VALUE;
        ArrayList<String> availableList = new ArrayList<String>();
        availableList.add(comboBoxDefaultValue);
        File projectPath = null;
        final Shell shell = (Shell) parent.getShell();
        final IEditorPart editor = (IEditorPart) ((WorkbenchWindow) shell.getDisplay().getActiveShell().getData())
                .getActivePage().getActiveEditor();
        if (editor != null) {
            // IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
            // IFile file = input.getFile();
            // IProject workspaceProject = file.getProject();

            // Fixing TOOLS-2322
            IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
            for (IProject workspaceProject : projects) {
                try {
                    if (workspaceProject.hasNature("org.wso2.integrationstudio.eclipse.esb.project.nature")) {
                        ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
                        projectPath = workspaceProject.getLocation().toFile();
                        try {
                            esbProjectArtifact
                                    .fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
                            List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
                            for (ESBArtifact esbArtifact : allESBArtifacts) {
                                if (synapseArtifcatCategory.equals(esbArtifact.getType())) {
                                    File artifact = new File(projectPath, esbArtifact.getFile());
                                    availableList.add(artifact.getName().replaceAll("[.]xml$", ""));
                                }
                            }
                        } catch (Exception e) {
                            ErrorDialog.openError(shell, "Error occured while scanning the project for "
                                    + synapseArtifcatCategory + " artifacts", e.getMessage(), 
                                    new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
                        }
                    }
                } catch (CoreException e) {
                    ErrorDialog.openError(shell, "Error occured while scanning the project", e.getMessage(), 
                    		new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
                }
            }
        }
        return availableList;
    }

    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] {propertiesGroup});
        eu.showEntry(new Control[] {messageStoreSubsection.getParent()}, false);
        eu.clearElements(new Composite[] { messageStoreSubsection });
        eu.showEntry(specifyAsElements, false);
        switch (getSpecifyAs().getName()) {
        case "Value": {
            eu.showEntry(availableMessageStoreElements, false);
            eu.showEntry(messageStoreElements, false);
            break;
        }
        case "Expression": {
            eu.showEntry(exoressionElements, false);
            break;

        }
        default:
            break;

        }
        eu.showEntry(onSequenceKeyElements, false);
        eu.showEntry(descriptionElements, false);
        
        view.layout(true, true);
    }

    
	// End of user code


}
