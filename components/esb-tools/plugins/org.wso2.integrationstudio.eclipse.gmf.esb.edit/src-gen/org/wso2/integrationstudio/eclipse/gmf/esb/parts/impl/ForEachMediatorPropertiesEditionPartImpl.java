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
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ForEachMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ForEachMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text forEachID;
	// Start of user code  for forEachExpression widgets declarations
	
	// End of user code

	protected EMFComboViewer sequenceType;
	protected Text sequenceName;
	// Start of user code  for sequenceKey widgets declarations
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ForEachMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence forEachMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = forEachMediatorStep.addStep(EsbViewsRepository.ForEachMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ForEachMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.ForEachMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.ForEachMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.ForEachMediator.Properties.forEachID);
		propertiesStep.addStep(EsbViewsRepository.ForEachMediator.Properties.forEachExpression);
		
		CompositionStep sequenceStep = forEachMediatorStep.addStep(EsbViewsRepository.ForEachMediator.Sequence.class);
		sequenceStep.addStep(EsbViewsRepository.ForEachMediator.Sequence.sequenceType);
		sequenceStep.addStep(EsbViewsRepository.ForEachMediator.Sequence.sequenceName);
		sequenceStep.addStep(EsbViewsRepository.ForEachMediator.Sequence.sequenceKey);
		
		
		composer = new PartComposer(forEachMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ForEachMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Properties.forEachID) {
					return createForEachIDText(parent);
				}
				// Start of user code for forEachExpression addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.ForEachMediator.Sequence.class) {
					return createSequenceGroup(parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Sequence.sequenceType) {
					return createSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Sequence.sequenceName) {
					return createSequenceNameText(parent);
				}
				// Start of user code for sequenceKey addToPart creation
				
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
		propertiesGroup.setText(EsbMessages.ForEachMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ForEachMediator.Properties.description, EsbMessages.ForEachMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ForEachMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ForEachMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.ForEachMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.ForEachMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.ForEachMediator.Properties.commentsList, EsbMessages.ForEachMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "ForEachMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ForEachMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.ForEachMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.ForEachMediator.Properties.reverse, EsbMessages.ForEachMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ForEachMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.ForEachMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createForEachIDText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ForEachMediator.Properties.forEachID, EsbMessages.ForEachMediatorPropertiesEditionPart_ForEachIDLabel);
		forEachID = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData forEachIDData = new GridData(GridData.FILL_HORIZONTAL);
		forEachID.setLayoutData(forEachIDData);
		forEachID.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ForEachMediator.Properties.forEachID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, forEachID.getText()));
			}

		});
		forEachID.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ForEachMediator.Properties.forEachID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, forEachID.getText()));
				}
			}

		});
		EditingUtils.setID(forEachID, EsbViewsRepository.ForEachMediator.Properties.forEachID);
		EditingUtils.setEEFtype(forEachID, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Properties.forEachID, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createForEachIDText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createSequenceGroup(Composite parent) {
		Group sequenceGroup = new Group(parent, SWT.NONE);
		sequenceGroup.setText(EsbMessages.ForEachMediatorPropertiesEditionPart_SequenceGroupLabel);
		GridData sequenceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		sequenceGroupData.horizontalSpan = 3;
		sequenceGroup.setLayoutData(sequenceGroupData);
		GridLayout sequenceGroupLayout = new GridLayout();
		sequenceGroupLayout.numColumns = 3;
		sequenceGroup.setLayout(sequenceGroupLayout);
		return sequenceGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ForEachMediator.Sequence.sequenceType, EsbMessages.ForEachMediatorPropertiesEditionPart_SequenceTypeLabel);
		sequenceType = new EMFComboViewer(parent);
		sequenceType.setContentProvider(new ArrayContentProvider());
		sequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ForEachMediator.Sequence.sequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceType()));
			}

		});
		sequenceType.setID(EsbViewsRepository.ForEachMediator.Sequence.sequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Sequence.sequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createSequenceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ForEachMediator.Sequence.sequenceName, EsbMessages.ForEachMediatorPropertiesEditionPart_SequenceNameLabel);
		sequenceName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData sequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		sequenceName.setLayoutData(sequenceNameData);
		sequenceName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ForEachMediator.Sequence.sequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sequenceName.getText()));
			}

		});
		sequenceName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ForEachMediator.Sequence.sequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sequenceName.getText()));
				}
			}

		});
		EditingUtils.setID(sequenceName, EsbViewsRepository.ForEachMediator.Sequence.sequenceName);
		EditingUtils.setEEFtype(sequenceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Sequence.sequenceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceNameText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getForEachID()
	 * 
	 */
	public String getForEachID() {
		return forEachID.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setForEachID(String newValue)
	 * 
	 */
	public void setForEachID(String newValue) {
		if (newValue != null) {
			forEachID.setText(newValue);
		} else {
			forEachID.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Properties.forEachID);
		if (eefElementEditorReadOnlyState && forEachID.isEnabled()) {
			forEachID.setEnabled(false);
			forEachID.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !forEachID.isEnabled()) {
			forEachID.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getSequenceType()
	 * 
	 */
	public Enumerator getSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#initSequenceType(Object input, Enumerator current)
	 */
	public void initSequenceType(Object input, Enumerator current) {
		sequenceType.setInput(input);
		sequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Sequence.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setSequenceType(Enumerator newValue)
	 * 
	 */
	public void setSequenceType(Enumerator newValue) {
		sequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Sequence.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getSequenceName()
	 * 
	 */
	public String getSequenceName() {
		return sequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setSequenceName(String newValue)
	 * 
	 */
	public void setSequenceName(String newValue) {
		if (newValue != null) {
			sequenceName.setText(newValue);
		} else {
			sequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Sequence.sequenceName);
		if (eefElementEditorReadOnlyState && sequenceName.isEnabled()) {
			sequenceName.setEnabled(false);
			sequenceName.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceName.isEnabled()) {
			sequenceName.setEnabled(true);
		}	
		
	}






	// Start of user code for forEachExpression specific getters and setters implementation
	
	// End of user code

	// Start of user code for sequenceKey specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ForEachMediator_Part_Title;
	}

	// Start of user code additional methods
    @Override
    public NamespacedProperty getForEachExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setForEachExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getSequenceKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSequenceKey(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }


	// End of user code


}
