/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class BAMMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, BAMMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text serverProfile;
	protected Text streamName;
	protected Text streamVersion;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public BAMMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence bAMMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = bAMMediatorStep.addStep(EsbViewsRepository.BAMMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.BAMMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.BAMMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.BAMMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.BAMMediator.Properties.serverProfile);
		propertiesStep.addStep(EsbViewsRepository.BAMMediator.Properties.streamName);
		propertiesStep.addStep(EsbViewsRepository.BAMMediator.Properties.streamVersion);
		
		
		composer = new PartComposer(bAMMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.BAMMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.BAMMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.BAMMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.BAMMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.BAMMediator.Properties.serverProfile) {
					return createServerProfileText(parent);
				}
				if (key == EsbViewsRepository.BAMMediator.Properties.streamName) {
					return createStreamNameText(parent);
				}
				if (key == EsbViewsRepository.BAMMediator.Properties.streamVersion) {
					return createStreamVersionText(parent);
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
		propertiesGroup.setText(EsbMessages.BAMMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.BAMMediator.Properties.description, EsbMessages.BAMMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BAMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.BAMMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BAMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.BAMMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.BAMMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BAMMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.BAMMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.BAMMediator.Properties.commentsList, EsbMessages.BAMMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "BAMMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BAMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.BAMMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.BAMMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.BAMMediator.Properties.reverse, EsbMessages.BAMMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BAMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.BAMMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.BAMMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BAMMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createServerProfileText(Composite parent) {
		createDescription(parent, EsbViewsRepository.BAMMediator.Properties.serverProfile, EsbMessages.BAMMediatorPropertiesEditionPart_ServerProfileLabel);
		serverProfile = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData serverProfileData = new GridData(GridData.FILL_HORIZONTAL);
		serverProfile.setLayoutData(serverProfileData);
		serverProfile.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BAMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.BAMMediator.Properties.serverProfile, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serverProfile.getText()));
			}

		});
		serverProfile.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BAMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.BAMMediator.Properties.serverProfile, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serverProfile.getText()));
				}
			}

		});
		EditingUtils.setID(serverProfile, EsbViewsRepository.BAMMediator.Properties.serverProfile);
		EditingUtils.setEEFtype(serverProfile, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BAMMediator.Properties.serverProfile, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createServerProfileText

		// End of user code
		return parent;
	}

	
	protected Composite createStreamNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.BAMMediator.Properties.streamName, EsbMessages.BAMMediatorPropertiesEditionPart_StreamNameLabel);
		streamName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData streamNameData = new GridData(GridData.FILL_HORIZONTAL);
		streamName.setLayoutData(streamNameData);
		streamName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BAMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.BAMMediator.Properties.streamName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, streamName.getText()));
			}

		});
		streamName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BAMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.BAMMediator.Properties.streamName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, streamName.getText()));
				}
			}

		});
		EditingUtils.setID(streamName, EsbViewsRepository.BAMMediator.Properties.streamName);
		EditingUtils.setEEFtype(streamName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BAMMediator.Properties.streamName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStreamNameText

		// End of user code
		return parent;
	}

	
	protected Composite createStreamVersionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.BAMMediator.Properties.streamVersion, EsbMessages.BAMMediatorPropertiesEditionPart_StreamVersionLabel);
		streamVersion = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData streamVersionData = new GridData(GridData.FILL_HORIZONTAL);
		streamVersion.setLayoutData(streamVersionData);
		streamVersion.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BAMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.BAMMediator.Properties.streamVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, streamVersion.getText()));
			}

		});
		streamVersion.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BAMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.BAMMediator.Properties.streamVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, streamVersion.getText()));
				}
			}

		});
		EditingUtils.setID(streamVersion, EsbViewsRepository.BAMMediator.Properties.streamVersion);
		EditingUtils.setEEFtype(streamVersion, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BAMMediator.Properties.streamVersion, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStreamVersionText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BAMMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.BAMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BAMMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.BAMMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BAMMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.BAMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#getServerProfile()
	 * 
	 */
	public String getServerProfile() {
		return serverProfile.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#setServerProfile(String newValue)
	 * 
	 */
	public void setServerProfile(String newValue) {
		if (newValue != null) {
			serverProfile.setText(newValue);
		} else {
			serverProfile.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BAMMediator.Properties.serverProfile);
		if (eefElementEditorReadOnlyState && serverProfile.isEnabled()) {
			serverProfile.setEnabled(false);
			serverProfile.setToolTipText(EsbMessages.BAMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !serverProfile.isEnabled()) {
			serverProfile.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#getStreamName()
	 * 
	 */
	public String getStreamName() {
		return streamName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#setStreamName(String newValue)
	 * 
	 */
	public void setStreamName(String newValue) {
		if (newValue != null) {
			streamName.setText(newValue);
		} else {
			streamName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BAMMediator.Properties.streamName);
		if (eefElementEditorReadOnlyState && streamName.isEnabled()) {
			streamName.setEnabled(false);
			streamName.setToolTipText(EsbMessages.BAMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !streamName.isEnabled()) {
			streamName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#getStreamVersion()
	 * 
	 */
	public String getStreamVersion() {
		return streamVersion.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BAMMediatorPropertiesEditionPart#setStreamVersion(String newValue)
	 * 
	 */
	public void setStreamVersion(String newValue) {
		if (newValue != null) {
			streamVersion.setText(newValue);
		} else {
			streamVersion.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BAMMediator.Properties.streamVersion);
		if (eefElementEditorReadOnlyState && streamVersion.isEnabled()) {
			streamVersion.setEnabled(false);
			streamVersion.setToolTipText(EsbMessages.BAMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !streamVersion.isEnabled()) {
			streamVersion.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.BAMMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
