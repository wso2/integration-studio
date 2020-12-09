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

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class LocalEntryPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, LocalEntryPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Text entryName;
	protected EMFComboViewer localEntryType;
	protected Text valueLiteral;
	protected Text valueXML;
	protected Text valueURL;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public LocalEntryPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence localEntryStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = localEntryStep.addStep(EsbViewsRepository.LocalEntry.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.entryName);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.localEntryType);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.valueLiteral);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.valueXML);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.valueURL);
		
		
		composer = new PartComposer(localEntryStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.LocalEntry.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.entryName) {
					return createEntryNameText(parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.localEntryType) {
					return createLocalEntryTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.valueLiteral) {
					return createValueLiteralText(parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.valueXML) {
					return createValueXMLText(parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.valueURL) {
					return createValueURLText(parent);
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
		propertiesGroup.setText(EsbMessages.LocalEntryPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.description, EsbMessages.LocalEntryPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.LocalEntry.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.LocalEntry.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.LocalEntry.Properties.commentsList, EsbMessages.LocalEntryPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "LocalEntry", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.LocalEntry.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createEntryNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.entryName, EsbMessages.LocalEntryPropertiesEditionPart_EntryNameLabel);
		entryName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData entryNameData = new GridData(GridData.FILL_HORIZONTAL);
		entryName.setLayoutData(entryNameData);
		entryName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.entryName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, entryName.getText()));
			}

		});
		entryName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.entryName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, entryName.getText()));
				}
			}

		});
		EditingUtils.setID(entryName, EsbViewsRepository.LocalEntry.Properties.entryName);
		EditingUtils.setEEFtype(entryName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.entryName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEntryNameText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createLocalEntryTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.localEntryType, EsbMessages.LocalEntryPropertiesEditionPart_LocalEntryTypeLabel);
		localEntryType = new EMFComboViewer(parent);
		localEntryType.setContentProvider(new ArrayContentProvider());
		localEntryType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData localEntryTypeData = new GridData(GridData.FILL_HORIZONTAL);
		localEntryType.getCombo().setLayoutData(localEntryTypeData);
                localEntryType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		localEntryType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.localEntryType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLocalEntryType()));
			}

		});
		localEntryType.setID(EsbViewsRepository.LocalEntry.Properties.localEntryType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.localEntryType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createLocalEntryTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createValueLiteralText(Composite parent) {
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.valueLiteral, EsbMessages.LocalEntryPropertiesEditionPart_ValueLiteralLabel);
		valueLiteral = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData valueLiteralData = new GridData(GridData.FILL_HORIZONTAL);
		valueLiteral.setLayoutData(valueLiteralData);
		valueLiteral.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
			}

		});
		valueLiteral.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
				}
			}

		});
		EditingUtils.setID(valueLiteral, EsbViewsRepository.LocalEntry.Properties.valueLiteral);
		EditingUtils.setEEFtype(valueLiteral, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.valueLiteral, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueLiteralText

		// End of user code
		return parent;
	}

	
	protected Composite createValueXMLText(Composite parent) {
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.valueXML, EsbMessages.LocalEntryPropertiesEditionPart_ValueXMLLabel);
		valueXML = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData valueXMLData = new GridData(GridData.FILL_HORIZONTAL);
		valueXML.setLayoutData(valueXMLData);
		valueXML.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.valueXML, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueXML.getText()));
			}

		});
		valueXML.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.valueXML, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueXML.getText()));
				}
			}

		});
		EditingUtils.setID(valueXML, EsbViewsRepository.LocalEntry.Properties.valueXML);
		EditingUtils.setEEFtype(valueXML, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.valueXML, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueXMLText

		// End of user code
		return parent;
	}

	
	protected Composite createValueURLText(Composite parent) {
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.valueURL, EsbMessages.LocalEntryPropertiesEditionPart_ValueURLLabel);
		valueURL = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData valueURLData = new GridData(GridData.FILL_HORIZONTAL);
		valueURL.setLayoutData(valueURLData);
		valueURL.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.valueURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueURL.getText()));
			}

		});
		valueURL.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartImpl.this, EsbViewsRepository.LocalEntry.Properties.valueURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueURL.getText()));
				}
			}

		});
		EditingUtils.setID(valueURL, EsbViewsRepository.LocalEntry.Properties.valueURL);
		EditingUtils.setEEFtype(valueURL, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.valueURL, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueURLText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getEntryName()
	 * 
	 */
	public String getEntryName() {
		return entryName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setEntryName(String newValue)
	 * 
	 */
	public void setEntryName(String newValue) {
		if (newValue != null) {
			entryName.setText(newValue);
		} else {
			entryName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.entryName);
		if (eefElementEditorReadOnlyState && entryName.isEnabled()) {
			entryName.setEnabled(false);
			entryName.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !entryName.isEnabled()) {
			entryName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getLocalEntryType()
	 * 
	 */
	public Enumerator getLocalEntryType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) localEntryType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#initLocalEntryType(Object input, Enumerator current)
	 */
	public void initLocalEntryType(Object input, Enumerator current) {
		localEntryType.setInput(input);
		localEntryType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.localEntryType);
		if (eefElementEditorReadOnlyState && localEntryType.isEnabled()) {
			localEntryType.setEnabled(false);
			localEntryType.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !localEntryType.isEnabled()) {
			localEntryType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setLocalEntryType(Enumerator newValue)
	 * 
	 */
	public void setLocalEntryType(Enumerator newValue) {
		localEntryType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.localEntryType);
		if (eefElementEditorReadOnlyState && localEntryType.isEnabled()) {
			localEntryType.setEnabled(false);
			localEntryType.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !localEntryType.isEnabled()) {
			localEntryType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getValueLiteral()
	 * 
	 */
	public String getValueLiteral() {
		return valueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setValueLiteral(String newValue)
	 * 
	 */
	public void setValueLiteral(String newValue) {
		if (newValue != null) {
			valueLiteral.setText(newValue);
		} else {
			valueLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.valueLiteral);
		if (eefElementEditorReadOnlyState && valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(false);
			valueLiteral.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getValueXML()
	 * 
	 */
	public String getValueXML() {
		return valueXML.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setValueXML(String newValue)
	 * 
	 */
	public void setValueXML(String newValue) {
		if (newValue != null) {
			valueXML.setText(newValue);
		} else {
			valueXML.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.valueXML);
		if (eefElementEditorReadOnlyState && valueXML.isEnabled()) {
			valueXML.setEnabled(false);
			valueXML.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueXML.isEnabled()) {
			valueXML.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getValueURL()
	 * 
	 */
	public String getValueURL() {
		return valueURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setValueURL(String newValue)
	 * 
	 */
	public void setValueURL(String newValue) {
		if (newValue != null) {
			valueURL.setText(newValue);
		} else {
			valueURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.valueURL);
		if (eefElementEditorReadOnlyState && valueURL.isEnabled()) {
			valueURL.setEnabled(false);
			valueURL.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueURL.isEnabled()) {
			valueURL.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.LocalEntry_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
