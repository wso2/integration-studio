/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ThrottleMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ThrottleMediatorPropertiesEditionPart {

	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text groupId;
	protected Text description;
	protected EMFComboViewer onAcceptBranchsequenceType;
	// Start of user code  for OnAcceptBranchSequenceKey widgets declarations
	
	// End of user code

	protected EMFComboViewer onRejectBranchsequenceType;
	// Start of user code  for OnRejectBranchSequenceKey widgets declarations
	
	// End of user code

	protected EMFComboViewer policyType;
	protected Text maxConcurrentAccessCount;
	protected ReferencesTable policyEntries;
	protected List<ViewerFilter> policyEntriesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> policyEntriesFilters = new ArrayList<ViewerFilter>();
	// Start of user code  for policyKey widgets declarations
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ThrottleMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence throttleMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep generalStep = throttleMediatorStep.addStep(EsbViewsRepository.ThrottleMediator.General.class);
		generalStep.addStep(EsbViewsRepository.ThrottleMediator.General.commentsList);
		generalStep.addStep(EsbViewsRepository.ThrottleMediator.General.reverse);
		generalStep.addStep(EsbViewsRepository.ThrottleMediator.General.groupId);
		
		throttleMediatorStep
			.addStep(EsbViewsRepository.ThrottleMediator.Misc.class)
			.addStep(EsbViewsRepository.ThrottleMediator.Misc.description);
		
		CompositionStep onAcceptStep = throttleMediatorStep.addStep(EsbViewsRepository.ThrottleMediator.OnAccept.class);
		onAcceptStep.addStep(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType);
		onAcceptStep.addStep(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey);
		
		CompositionStep onRejectStep = throttleMediatorStep.addStep(EsbViewsRepository.ThrottleMediator.OnReject.class);
		onRejectStep.addStep(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType);
		onRejectStep.addStep(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey);
		
		CompositionStep throttlePolicyStep = throttleMediatorStep.addStep(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.class);
		throttlePolicyStep.addStep(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType);
		throttlePolicyStep.addStep(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount);
		throttlePolicyStep.addStep(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries);
		throttlePolicyStep.addStep(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey);
		
		
		composer = new PartComposer(throttleMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ThrottleMediator.General.class) {
					return createGeneralGroup(parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.General.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.General.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.General.groupId) {
					return createGroupIdText(parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Misc.class) {
					return createMiscGroup(parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Misc.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.OnAccept.class) {
					return createOnAcceptGroup(parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType) {
					return createOnAcceptBranchsequenceTypeEMFComboViewer(parent);
				}
				// Start of user code for OnAcceptBranchSequenceKey addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.ThrottleMediator.OnReject.class) {
					//FIXME INVALID CASE INTO template public implementation(editor : ViewElement) in SWT Impl for ViewElement onReject
				}
				if (key == EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType) {
					return createOnRejectBranchsequenceTypeEMFComboViewer(parent);
				}
				// Start of user code for OnRejectBranchSequenceKey addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.class) {
					return createThrottlePolicyGroup(parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType) {
					return createPolicyTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount) {
					return createMaxConcurrentAccessCountText(parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries) {
					return createPolicyEntriesAdvancedTableComposition(parent);
				}
				// Start of user code for policyKey addToPart creation
				
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createGeneralGroup(Composite parent) {
		Group generalGroup = new Group(parent, SWT.NONE);
		generalGroup.setText(EsbMessages.ThrottleMediatorPropertiesEditionPart_GeneralGroupLabel);
		GridData generalGroupData = new GridData(GridData.FILL_HORIZONTAL);
		generalGroupData.horizontalSpan = 3;
		generalGroup.setLayoutData(generalGroupData);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		return generalGroup;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.ThrottleMediator.General.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.ThrottleMediator.General.commentsList, EsbMessages.ThrottleMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "ThrottleMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.General.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.ThrottleMediator.General.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.ThrottleMediator.General.reverse, EsbMessages.ThrottleMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.General.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.ThrottleMediator.General.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.General.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createGroupIdText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottleMediator.General.groupId, EsbMessages.ThrottleMediatorPropertiesEditionPart_GroupIdLabel);
		groupId = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData groupIdData = new GridData(GridData.FILL_HORIZONTAL);
		groupId.setLayoutData(groupIdData);
		groupId.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.General.groupId, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, groupId.getText()));
			}

		});
		groupId.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.General.groupId, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, groupId.getText()));
				}
			}

		});
		EditingUtils.setID(groupId, EsbViewsRepository.ThrottleMediator.General.groupId);
		EditingUtils.setEEFtype(groupId, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.General.groupId, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createGroupIdText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createMiscGroup(Composite parent) {
		Group miscGroup = new Group(parent, SWT.NONE);
		miscGroup.setText(EsbMessages.ThrottleMediatorPropertiesEditionPart_MiscGroupLabel);
		GridData miscGroupData = new GridData(GridData.FILL_HORIZONTAL);
		miscGroupData.horizontalSpan = 3;
		miscGroup.setLayoutData(miscGroupData);
		GridLayout miscGroupLayout = new GridLayout();
		miscGroupLayout.numColumns = 3;
		miscGroup.setLayout(miscGroupLayout);
		return miscGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottleMediator.Misc.description, EsbMessages.ThrottleMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.ThrottleMediator.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.Misc.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createOnAcceptGroup(Composite parent) {
		Group onAcceptGroup = new Group(parent, SWT.NONE);
		onAcceptGroup.setText(EsbMessages.ThrottleMediatorPropertiesEditionPart_OnAcceptGroupLabel);
		GridData onAcceptGroupData = new GridData(GridData.FILL_HORIZONTAL);
		onAcceptGroupData.horizontalSpan = 3;
		onAcceptGroup.setLayoutData(onAcceptGroupData);
		GridLayout onAcceptGroupLayout = new GridLayout();
		onAcceptGroupLayout.numColumns = 3;
		onAcceptGroup.setLayout(onAcceptGroupLayout);
		return onAcceptGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createOnAcceptBranchsequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType, EsbMessages.ThrottleMediatorPropertiesEditionPart_OnAcceptBranchsequenceTypeLabel);
		onAcceptBranchsequenceType = new EMFComboViewer(parent);
		onAcceptBranchsequenceType.setContentProvider(new ArrayContentProvider());
		onAcceptBranchsequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData onAcceptBranchsequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		onAcceptBranchsequenceType.getCombo().setLayoutData(onAcceptBranchsequenceTypeData);
                onAcceptBranchsequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		onAcceptBranchsequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnAcceptBranchsequenceType()));
			}

		});
		onAcceptBranchsequenceType.setID(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOnAcceptBranchsequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

//FIXME INVALID CASE INTO template public additionalImplementation(editor : ViewElement, pec : PropertiesEditionComponent, inputPEC : PropertiesEditionComponent) in SWT Impl for ViewElement onReject

	/**
	 * @generated NOT
	 */
	protected Composite createOnRejectBranchsequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType, EsbMessages.ThrottleMediatorPropertiesEditionPart_OnRejectBranchsequenceTypeLabel);
		onRejectBranchsequenceType = new EMFComboViewer(parent);
		onRejectBranchsequenceType.setContentProvider(new ArrayContentProvider());
		onRejectBranchsequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData onRejectBranchsequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		onRejectBranchsequenceType.getCombo().setLayoutData(onRejectBranchsequenceTypeData);
                onRejectBranchsequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		onRejectBranchsequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnRejectBranchsequenceType()));
			}

		});
		onRejectBranchsequenceType.setID(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOnRejectBranchsequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createThrottlePolicyGroup(Composite parent) {
		Group throttlePolicyGroup = new Group(parent, SWT.NONE);
		throttlePolicyGroup.setText(EsbMessages.ThrottleMediatorPropertiesEditionPart_ThrottlePolicyGroupLabel);
		GridData throttlePolicyGroupData = new GridData(GridData.FILL_HORIZONTAL);
		throttlePolicyGroupData.horizontalSpan = 3;
		throttlePolicyGroup.setLayoutData(throttlePolicyGroupData);
		GridLayout throttlePolicyGroupLayout = new GridLayout();
		throttlePolicyGroupLayout.numColumns = 3;
		throttlePolicyGroup.setLayout(throttlePolicyGroupLayout);
		return throttlePolicyGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createPolicyTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType, EsbMessages.ThrottleMediatorPropertiesEditionPart_PolicyTypeLabel);
		policyType = new EMFComboViewer(parent);
		policyType.setContentProvider(new ArrayContentProvider());
		policyType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData policyTypeData = new GridData(GridData.FILL_HORIZONTAL);
		policyType.getCombo().setLayoutData(policyTypeData);
                policyType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		policyType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPolicyType()));
			}

		});
		policyType.setID(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPolicyTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createMaxConcurrentAccessCountText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount, EsbMessages.ThrottleMediatorPropertiesEditionPart_MaxConcurrentAccessCountLabel);
		maxConcurrentAccessCount = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData maxConcurrentAccessCountData = new GridData(GridData.FILL_HORIZONTAL);
		maxConcurrentAccessCount.setLayoutData(maxConcurrentAccessCountData);
		maxConcurrentAccessCount.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxConcurrentAccessCount.getText()));
			}

		});
		maxConcurrentAccessCount.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxConcurrentAccessCount.getText()));
				}
			}

		});
		EditingUtils.setID(maxConcurrentAccessCount, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount);
		EditingUtils.setEEFtype(maxConcurrentAccessCount, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxConcurrentAccessCountText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createPolicyEntriesAdvancedTableComposition(Composite parent) {
		this.policyEntries = new ReferencesTable(getDescription(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, EsbMessages.ThrottleMediatorPropertiesEditionPart_PolicyEntriesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				policyEntries.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				policyEntries.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				policyEntries.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				policyEntries.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.policyEntriesFilters) {
			this.policyEntries.addFilter(filter);
		}
		this.policyEntries.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, EsbViewsRepository.SWT_KIND));
		this.policyEntries.createControls(parent);
		this.policyEntries.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData policyEntriesData = new GridData(GridData.FILL_HORIZONTAL);
		policyEntriesData.horizontalSpan = 3;
		this.policyEntries.setLayoutData(policyEntriesData);
		this.policyEntries.setLowerBound(0);
		this.policyEntries.setUpperBound(-1);
		policyEntries.setID(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries);
		policyEntries.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPolicyEntriesAdvancedTableComposition

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.General.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.General.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getGroupId()
	 * 
	 */
	public String getGroupId() {
		return groupId.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setGroupId(String newValue)
	 * 
	 */
	public void setGroupId(String newValue) {
		if (newValue != null) {
			groupId.setText(newValue);
		} else {
			groupId.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.General.groupId);
		if (eefElementEditorReadOnlyState && groupId.isEnabled()) {
			groupId.setEnabled(false);
			groupId.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !groupId.isEnabled()) {
			groupId.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Misc.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getOnAcceptBranchsequenceType()
	 * 
	 */
	public Enumerator getOnAcceptBranchsequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) onAcceptBranchsequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initOnAcceptBranchsequenceType(Object input, Enumerator current)
	 */
	public void initOnAcceptBranchsequenceType(Object input, Enumerator current) {
		onAcceptBranchsequenceType.setInput(input);
		onAcceptBranchsequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType);
		if (eefElementEditorReadOnlyState && onAcceptBranchsequenceType.isEnabled()) {
			onAcceptBranchsequenceType.setEnabled(false);
			onAcceptBranchsequenceType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onAcceptBranchsequenceType.isEnabled()) {
			onAcceptBranchsequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setOnAcceptBranchsequenceType(Enumerator newValue)
	 * 
	 */
	public void setOnAcceptBranchsequenceType(Enumerator newValue) {
		onAcceptBranchsequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType);
		if (eefElementEditorReadOnlyState && onAcceptBranchsequenceType.isEnabled()) {
			onAcceptBranchsequenceType.setEnabled(false);
			onAcceptBranchsequenceType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onAcceptBranchsequenceType.isEnabled()) {
			onAcceptBranchsequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getOnRejectBranchsequenceType()
	 * 
	 */
	public Enumerator getOnRejectBranchsequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) onRejectBranchsequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initOnRejectBranchsequenceType(Object input, Enumerator current)
	 */
	public void initOnRejectBranchsequenceType(Object input, Enumerator current) {
		onRejectBranchsequenceType.setInput(input);
		onRejectBranchsequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType);
		if (eefElementEditorReadOnlyState && onRejectBranchsequenceType.isEnabled()) {
			onRejectBranchsequenceType.setEnabled(false);
			onRejectBranchsequenceType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onRejectBranchsequenceType.isEnabled()) {
			onRejectBranchsequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setOnRejectBranchsequenceType(Enumerator newValue)
	 * 
	 */
	public void setOnRejectBranchsequenceType(Enumerator newValue) {
		onRejectBranchsequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType);
		if (eefElementEditorReadOnlyState && onRejectBranchsequenceType.isEnabled()) {
			onRejectBranchsequenceType.setEnabled(false);
			onRejectBranchsequenceType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onRejectBranchsequenceType.isEnabled()) {
			onRejectBranchsequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getPolicyType()
	 * 
	 */
	public Enumerator getPolicyType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) policyType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initPolicyType(Object input, Enumerator current)
	 */
	public void initPolicyType(Object input, Enumerator current) {
		policyType.setInput(input);
		policyType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType);
		if (eefElementEditorReadOnlyState && policyType.isEnabled()) {
			policyType.setEnabled(false);
			policyType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policyType.isEnabled()) {
			policyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setPolicyType(Enumerator newValue)
	 * 
	 */
	public void setPolicyType(Enumerator newValue) {
		policyType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType);
		if (eefElementEditorReadOnlyState && policyType.isEnabled()) {
			policyType.setEnabled(false);
			policyType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policyType.isEnabled()) {
			policyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getMaxConcurrentAccessCount()
	 * 
	 */
	public String getMaxConcurrentAccessCount() {
		return maxConcurrentAccessCount.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setMaxConcurrentAccessCount(String newValue)
	 * 
	 */
	public void setMaxConcurrentAccessCount(String newValue) {
		if (newValue != null) {
			maxConcurrentAccessCount.setText(newValue);
		} else {
			maxConcurrentAccessCount.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount);
		if (eefElementEditorReadOnlyState && maxConcurrentAccessCount.isEnabled()) {
			maxConcurrentAccessCount.setEnabled(false);
			maxConcurrentAccessCount.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maxConcurrentAccessCount.isEnabled()) {
			maxConcurrentAccessCount.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initPolicyEntries(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPolicyEntries(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		policyEntries.setContentProvider(contentProvider);
		policyEntries.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries);
		if (eefElementEditorReadOnlyState && policyEntries.isEnabled()) {
			policyEntries.setEnabled(false);
			policyEntries.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policyEntries.isEnabled()) {
			policyEntries.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#updatePolicyEntries()
	 * 
	 */
	public void updatePolicyEntries() {
	policyEntries.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#addFilterPolicyEntries(ViewerFilter filter)
	 * 
	 */
	public void addFilterToPolicyEntries(ViewerFilter filter) {
		policyEntriesFilters.add(filter);
		if (this.policyEntries != null) {
			this.policyEntries.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#addBusinessFilterPolicyEntries(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPolicyEntries(ViewerFilter filter) {
		policyEntriesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#isContainedInPolicyEntriesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPolicyEntriesTable(EObject element) {
		return ((ReferencesTableSettings)policyEntries.getInput()).contains(element);
	}






	// Start of user code for OnAcceptBranchSequenceKey specific getters and setters implementation
	
	// End of user code

	// Start of user code for OnRejectBranchSequenceKey specific getters and setters implementation
	
	// End of user code

	// Start of user code for policyKey specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ThrottleMediator_Part_Title;
	}

	// Start of user code additional methods
    @Override
    public RegistryKeyProperty getOnAcceptBranchSequenceKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setOnAcceptBranchSequenceKey(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getOnRejectBranchSequenceKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setOnRejectBranchSequenceKey(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getPolicyKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPolicyKey(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }
	// End of user code


}
