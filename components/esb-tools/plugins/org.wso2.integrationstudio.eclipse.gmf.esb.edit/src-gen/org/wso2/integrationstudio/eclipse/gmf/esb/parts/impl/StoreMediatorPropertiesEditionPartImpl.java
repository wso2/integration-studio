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
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class StoreMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, StoreMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text messageStore;
	protected Text availableMessageStores;
	protected EMFComboViewer specifyAs;
	// Start of user code  for onStoreSequence widgets declarations
	
	// End of user code

	// Start of user code  for expression widgets declarations
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public StoreMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
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
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence storeMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = storeMediatorStep.addStep(EsbViewsRepository.StoreMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.messageStore);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.availableMessageStores);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.specifyAs);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.onStoreSequence);
		propertiesStep.addStep(EsbViewsRepository.StoreMediator.Properties.expression);
		
		
		composer = new PartComposer(storeMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.StoreMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.messageStore) {
					return createMessageStoreText(parent);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.availableMessageStores) {
					return createAvailableMessageStoresText(parent);
				}
				if (key == EsbViewsRepository.StoreMediator.Properties.specifyAs) {
					return createSpecifyAsEMFComboViewer(parent);
				}
				// Start of user code for onStoreSequence addToPart creation
				
				// End of user code
				// Start of user code for expression addToPart creation
				
				// End of user code
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
		propertiesGroup.setText(EsbMessages.StoreMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.StoreMediator.Properties.description, EsbMessages.StoreMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.StoreMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.StoreMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.StoreMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.StoreMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.StoreMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.StoreMediator.Properties.commentsList, EsbMessages.StoreMediatorPropertiesEditionPart_CommentsListLabel));
		GridData editCommentsListData = new GridData();
		editCommentsList.setLayoutData(editCommentsListData);
		editCommentsList.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.StoreMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
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

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.StoreMediator.Properties.reverse, EsbMessages.StoreMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.StoreMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.StoreMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.StoreMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createMessageStoreText(Composite parent) {
		createDescription(parent, EsbViewsRepository.StoreMediator.Properties.messageStore, EsbMessages.StoreMediatorPropertiesEditionPart_MessageStoreLabel);
		messageStore = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData messageStoreData = new GridData(GridData.FILL_HORIZONTAL);
		messageStore.setLayoutData(messageStoreData);
		messageStore.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.StoreMediator.Properties.messageStore, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, messageStore.getText()));
			}

		});
		messageStore.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.StoreMediator.Properties.messageStore, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, messageStore.getText()));
				}
			}

		});
		EditingUtils.setID(messageStore, EsbViewsRepository.StoreMediator.Properties.messageStore);
		EditingUtils.setEEFtype(messageStore, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.StoreMediator.Properties.messageStore, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMessageStoreText

		// End of user code
		return parent;
	}

	
	protected Composite createAvailableMessageStoresText(Composite parent) {
		createDescription(parent, EsbViewsRepository.StoreMediator.Properties.availableMessageStores, EsbMessages.StoreMediatorPropertiesEditionPart_AvailableMessageStoresLabel);
		availableMessageStores = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData availableMessageStoresData = new GridData(GridData.FILL_HORIZONTAL);
		availableMessageStores.setLayoutData(availableMessageStoresData);
		availableMessageStores.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.StoreMediator.Properties.availableMessageStores, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, availableMessageStores.getText()));
			}

		});
		availableMessageStores.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.StoreMediator.Properties.availableMessageStores, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, availableMessageStores.getText()));
				}
			}

		});
		EditingUtils.setID(availableMessageStores, EsbViewsRepository.StoreMediator.Properties.availableMessageStores);
		EditingUtils.setEEFtype(availableMessageStores, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.StoreMediator.Properties.availableMessageStores, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAvailableMessageStoresText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createSpecifyAsEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.StoreMediator.Properties.specifyAs, EsbMessages.StoreMediatorPropertiesEditionPart_SpecifyAsLabel);
		specifyAs = new EMFComboViewer(parent);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoreMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.StoreMediator.Properties.specifyAs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSpecifyAs()));
			}

		});
		specifyAs.setID(EsbViewsRepository.StoreMediator.Properties.specifyAs);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.StoreMediator.Properties.specifyAs, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSpecifyAsEMFComboViewer

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
		return availableMessageStores.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.StoreMediatorPropertiesEditionPart#setAvailableMessageStores(String newValue)
	 * 
	 */
	public void setAvailableMessageStores(String newValue) {
		if (newValue != null) {
			availableMessageStores.setText(newValue);
		} else {
			availableMessageStores.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.StoreMediator.Properties.availableMessageStores);
		if (eefElementEditorReadOnlyState && availableMessageStores.isEnabled()) {
			availableMessageStores.setEnabled(false);
			availableMessageStores.setToolTipText(EsbMessages.StoreMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !availableMessageStores.isEnabled()) {
			availableMessageStores.setEnabled(true);
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
    public RegistryKeyProperty getOnStoreSequence() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setOnStoreSequence(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }

	// End of user code

	// Start of user code for expression specific getters and setters implementation
    @Override
    public NamespacedProperty getExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
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
	
	// End of user code


}
