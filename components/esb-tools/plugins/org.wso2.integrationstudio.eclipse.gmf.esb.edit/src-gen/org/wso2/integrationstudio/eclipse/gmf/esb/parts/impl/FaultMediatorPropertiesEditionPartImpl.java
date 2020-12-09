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
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class FaultMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, FaultMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer soapVersion;
	protected Button serializeResponse;
	protected Button markAsResponse;
	protected EMFComboViewer faultCodeSoap11;
	protected EMFComboViewer faultCodeType;
	protected EMFComboViewer faultStringType;
	protected Text faultStringValue;
	protected Text faultActor;
	protected EMFComboViewer faultCodeSoap12;
	protected EMFComboViewer faultReasonType;
	protected Text faultReasonValue;
	protected Text roleName;
	protected Text nodeName;
	protected EMFComboViewer faultDetailType;
	protected Text faultDetailValue;
	// Start of user code  for faultStringExpression widgets declarations
	
	// End of user code

	// Start of user code  for faultCodeExpression widgets declarations
	
	// End of user code

	// Start of user code  for faultDetailExpression widgets declarations
	
	// End of user code

	// Start of user code  for faultReasonExpression widgets declarations
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public FaultMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence faultMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = faultMediatorStep.addStep(EsbViewsRepository.FaultMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.soapVersion);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.serializeResponse);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.markAsResponse);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultCodeType);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultStringType);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultStringValue);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultActor);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultReasonType);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultReasonValue);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.roleName);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.nodeName);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultDetailType);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultDetailValue);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultStringExpression);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultCodeExpression);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultDetailExpression);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultReasonExpression);
		
		
		composer = new PartComposer(faultMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.FaultMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.soapVersion) {
					return createSoapVersionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.serializeResponse) {
					return createSerializeResponseCheckbox(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.markAsResponse) {
					return createMarkAsResponseCheckbox(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11) {
					return createFaultCodeSoap11EMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultCodeType) {
					return createFaultCodeTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultStringType) {
					return createFaultStringTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultStringValue) {
					return createFaultStringValueText(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultActor) {
					return createFaultActorText(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12) {
					return createFaultCodeSoap12EMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultReasonType) {
					return createFaultReasonTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultReasonValue) {
					return createFaultReasonValueText(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.roleName) {
					return createRoleNameText(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.nodeName) {
					return createNodeNameText(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultDetailType) {
					return createFaultDetailTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultDetailValue) {
					return createFaultDetailValueText(parent);
				}
				// Start of user code for faultStringExpression addToPart creation
				
				// End of user code
				// Start of user code for faultCodeExpression addToPart creation
				
				// End of user code
				// Start of user code for faultDetailExpression addToPart creation
				
				// End of user code
				// Start of user code for faultReasonExpression addToPart creation
				
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
		propertiesGroup.setText(EsbMessages.FaultMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.description, EsbMessages.FaultMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.FaultMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.FaultMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.FaultMediator.Properties.commentsList, EsbMessages.FaultMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "FaultMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.FaultMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.FaultMediator.Properties.reverse, EsbMessages.FaultMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.FaultMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createSoapVersionEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.soapVersion, EsbMessages.FaultMediatorPropertiesEditionPart_SoapVersionLabel);
		soapVersion = new EMFComboViewer(parent);
		soapVersion.setContentProvider(new ArrayContentProvider());
		soapVersion.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData soapVersionData = new GridData(GridData.FILL_HORIZONTAL);
		soapVersion.getCombo().setLayoutData(soapVersionData);
                soapVersion.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		soapVersion.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.soapVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSoapVersion()));
			}

		});
		soapVersion.setID(EsbViewsRepository.FaultMediator.Properties.soapVersion);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.soapVersion, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSoapVersionEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createSerializeResponseCheckbox(Composite parent) {
		serializeResponse = new Button(parent, SWT.CHECK);
		serializeResponse.setText(getDescription(EsbViewsRepository.FaultMediator.Properties.serializeResponse, EsbMessages.FaultMediatorPropertiesEditionPart_SerializeResponseLabel));
		serializeResponse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.serializeResponse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(serializeResponse.getSelection())));
			}

		});
		GridData serializeResponseData = new GridData(GridData.FILL_HORIZONTAL);
		serializeResponseData.horizontalSpan = 2;
		serializeResponse.setLayoutData(serializeResponseData);
		EditingUtils.setID(serializeResponse, EsbViewsRepository.FaultMediator.Properties.serializeResponse);
		EditingUtils.setEEFtype(serializeResponse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.serializeResponse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSerializeResponseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createMarkAsResponseCheckbox(Composite parent) {
		markAsResponse = new Button(parent, SWT.CHECK);
		markAsResponse.setText(getDescription(EsbViewsRepository.FaultMediator.Properties.markAsResponse, EsbMessages.FaultMediatorPropertiesEditionPart_MarkAsResponseLabel));
		markAsResponse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.markAsResponse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(markAsResponse.getSelection())));
			}

		});
		GridData markAsResponseData = new GridData(GridData.FILL_HORIZONTAL);
		markAsResponseData.horizontalSpan = 2;
		markAsResponse.setLayoutData(markAsResponseData);
		EditingUtils.setID(markAsResponse, EsbViewsRepository.FaultMediator.Properties.markAsResponse);
		EditingUtils.setEEFtype(markAsResponse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.markAsResponse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMarkAsResponseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createFaultCodeSoap11EMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11, EsbMessages.FaultMediatorPropertiesEditionPart_FaultCodeSoap11Label);
		faultCodeSoap11 = new EMFComboViewer(parent);
		faultCodeSoap11.setContentProvider(new ArrayContentProvider());
		faultCodeSoap11.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultCodeSoap11Data = new GridData(GridData.FILL_HORIZONTAL);
		faultCodeSoap11.getCombo().setLayoutData(faultCodeSoap11Data);
                faultCodeSoap11.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultCodeSoap11.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultCodeSoap11()));
			}

		});
		faultCodeSoap11.setID(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultCodeSoap11EMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createFaultCodeTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultCodeType, EsbMessages.FaultMediatorPropertiesEditionPart_FaultCodeTypeLabel);
		faultCodeType = new EMFComboViewer(parent);
		faultCodeType.setContentProvider(new ArrayContentProvider());
		faultCodeType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultCodeTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultCodeType.getCombo().setLayoutData(faultCodeTypeData);
                faultCodeType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultCodeType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultCodeType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultCodeType()));
			}

		});
		faultCodeType.setID(EsbViewsRepository.FaultMediator.Properties.faultCodeType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultCodeType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultCodeTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createFaultStringTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultStringType, EsbMessages.FaultMediatorPropertiesEditionPart_FaultStringTypeLabel);
		faultStringType = new EMFComboViewer(parent);
		faultStringType.setContentProvider(new ArrayContentProvider());
		faultStringType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultStringTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultStringType.getCombo().setLayoutData(faultStringTypeData);
                faultStringType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultStringType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultStringType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultStringType()));
			}

		});
		faultStringType.setID(EsbViewsRepository.FaultMediator.Properties.faultStringType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultStringType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultStringTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createFaultStringValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultStringValue, EsbMessages.FaultMediatorPropertiesEditionPart_FaultStringValueLabel);
		faultStringValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData faultStringValueData = new GridData(GridData.FILL_HORIZONTAL);
		faultStringValue.setLayoutData(faultStringValueData);
		faultStringValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultStringValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultStringValue.getText()));
			}

		});
		faultStringValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultStringValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultStringValue.getText()));
				}
			}

		});
		EditingUtils.setID(faultStringValue, EsbViewsRepository.FaultMediator.Properties.faultStringValue);
		EditingUtils.setEEFtype(faultStringValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultStringValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultStringValueText

		// End of user code
		return parent;
	}

	
	protected Composite createFaultActorText(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultActor, EsbMessages.FaultMediatorPropertiesEditionPart_FaultActorLabel);
		faultActor = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData faultActorData = new GridData(GridData.FILL_HORIZONTAL);
		faultActor.setLayoutData(faultActorData);
		faultActor.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultActor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultActor.getText()));
			}

		});
		faultActor.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultActor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultActor.getText()));
				}
			}

		});
		EditingUtils.setID(faultActor, EsbViewsRepository.FaultMediator.Properties.faultActor);
		EditingUtils.setEEFtype(faultActor, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultActor, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultActorText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createFaultCodeSoap12EMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12, EsbMessages.FaultMediatorPropertiesEditionPart_FaultCodeSoap12Label);
		faultCodeSoap12 = new EMFComboViewer(parent);
		faultCodeSoap12.setContentProvider(new ArrayContentProvider());
		faultCodeSoap12.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultCodeSoap12Data = new GridData(GridData.FILL_HORIZONTAL);
		faultCodeSoap12.getCombo().setLayoutData(faultCodeSoap12Data);
                faultCodeSoap12.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultCodeSoap12.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultCodeSoap12()));
			}

		});
		faultCodeSoap12.setID(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultCodeSoap12EMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createFaultReasonTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultReasonType, EsbMessages.FaultMediatorPropertiesEditionPart_FaultReasonTypeLabel);
		faultReasonType = new EMFComboViewer(parent);
		faultReasonType.setContentProvider(new ArrayContentProvider());
		faultReasonType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultReasonTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultReasonType.getCombo().setLayoutData(faultReasonTypeData);
                faultReasonType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultReasonType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultReasonType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultReasonType()));
			}

		});
		faultReasonType.setID(EsbViewsRepository.FaultMediator.Properties.faultReasonType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultReasonType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultReasonTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createFaultReasonValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultReasonValue, EsbMessages.FaultMediatorPropertiesEditionPart_FaultReasonValueLabel);
		faultReasonValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData faultReasonValueData = new GridData(GridData.FILL_HORIZONTAL);
		faultReasonValue.setLayoutData(faultReasonValueData);
		faultReasonValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultReasonValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultReasonValue.getText()));
			}

		});
		faultReasonValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultReasonValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultReasonValue.getText()));
				}
			}

		});
		EditingUtils.setID(faultReasonValue, EsbViewsRepository.FaultMediator.Properties.faultReasonValue);
		EditingUtils.setEEFtype(faultReasonValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultReasonValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultReasonValueText

		// End of user code
		return parent;
	}

	
	protected Composite createRoleNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.roleName, EsbMessages.FaultMediatorPropertiesEditionPart_RoleNameLabel);
		roleName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData roleNameData = new GridData(GridData.FILL_HORIZONTAL);
		roleName.setLayoutData(roleNameData);
		roleName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.roleName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, roleName.getText()));
			}

		});
		roleName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.roleName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, roleName.getText()));
				}
			}

		});
		EditingUtils.setID(roleName, EsbViewsRepository.FaultMediator.Properties.roleName);
		EditingUtils.setEEFtype(roleName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.roleName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRoleNameText

		// End of user code
		return parent;
	}

	
	protected Composite createNodeNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.nodeName, EsbMessages.FaultMediatorPropertiesEditionPart_NodeNameLabel);
		nodeName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nodeNameData = new GridData(GridData.FILL_HORIZONTAL);
		nodeName.setLayoutData(nodeNameData);
		nodeName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.nodeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nodeName.getText()));
			}

		});
		nodeName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.nodeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nodeName.getText()));
				}
			}

		});
		EditingUtils.setID(nodeName, EsbViewsRepository.FaultMediator.Properties.nodeName);
		EditingUtils.setEEFtype(nodeName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.nodeName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNodeNameText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createFaultDetailTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultDetailType, EsbMessages.FaultMediatorPropertiesEditionPart_FaultDetailTypeLabel);
		faultDetailType = new EMFComboViewer(parent);
		faultDetailType.setContentProvider(new ArrayContentProvider());
		faultDetailType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultDetailTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultDetailType.getCombo().setLayoutData(faultDetailTypeData);
                faultDetailType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultDetailType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultDetailType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultDetailType()));
			}

		});
		faultDetailType.setID(EsbViewsRepository.FaultMediator.Properties.faultDetailType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultDetailType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultDetailTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createFaultDetailValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultDetailValue, EsbMessages.FaultMediatorPropertiesEditionPart_FaultDetailValueLabel);
		faultDetailValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData faultDetailValueData = new GridData(GridData.FILL_HORIZONTAL);
		faultDetailValue.setLayoutData(faultDetailValueData);
		faultDetailValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultDetailValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultDetailValue.getText()));
			}

		});
		faultDetailValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.FaultMediator.Properties.faultDetailValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultDetailValue.getText()));
				}
			}

		});
		EditingUtils.setID(faultDetailValue, EsbViewsRepository.FaultMediator.Properties.faultDetailValue);
		EditingUtils.setEEFtype(faultDetailValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultDetailValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultDetailValueText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getSoapVersion()
	 * 
	 */
	public Enumerator getSoapVersion() {
		Enumerator selection = (Enumerator) ((StructuredSelection) soapVersion.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initSoapVersion(Object input, Enumerator current)
	 */
	public void initSoapVersion(Object input, Enumerator current) {
		soapVersion.setInput(input);
		soapVersion.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.soapVersion);
		if (eefElementEditorReadOnlyState && soapVersion.isEnabled()) {
			soapVersion.setEnabled(false);
			soapVersion.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !soapVersion.isEnabled()) {
			soapVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setSoapVersion(Enumerator newValue)
	 * 
	 */
	public void setSoapVersion(Enumerator newValue) {
		soapVersion.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.soapVersion);
		if (eefElementEditorReadOnlyState && soapVersion.isEnabled()) {
			soapVersion.setEnabled(false);
			soapVersion.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !soapVersion.isEnabled()) {
			soapVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getSerializeResponse()
	 * 
	 */
	public Boolean getSerializeResponse() {
		return Boolean.valueOf(serializeResponse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setSerializeResponse(Boolean newValue)
	 * 
	 */
	public void setSerializeResponse(Boolean newValue) {
		if (newValue != null) {
			serializeResponse.setSelection(newValue.booleanValue());
		} else {
			serializeResponse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.serializeResponse);
		if (eefElementEditorReadOnlyState && serializeResponse.isEnabled()) {
			serializeResponse.setEnabled(false);
			serializeResponse.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !serializeResponse.isEnabled()) {
			serializeResponse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getMarkAsResponse()
	 * 
	 */
	public Boolean getMarkAsResponse() {
		return Boolean.valueOf(markAsResponse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setMarkAsResponse(Boolean newValue)
	 * 
	 */
	public void setMarkAsResponse(Boolean newValue) {
		if (newValue != null) {
			markAsResponse.setSelection(newValue.booleanValue());
		} else {
			markAsResponse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.markAsResponse);
		if (eefElementEditorReadOnlyState && markAsResponse.isEnabled()) {
			markAsResponse.setEnabled(false);
			markAsResponse.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !markAsResponse.isEnabled()) {
			markAsResponse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultCodeSoap11()
	 * 
	 */
	public Enumerator getFaultCodeSoap11() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultCodeSoap11.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultCodeSoap11(Object input, Enumerator current)
	 */
	public void initFaultCodeSoap11(Object input, Enumerator current) {
		faultCodeSoap11.setInput(input);
		faultCodeSoap11.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11);
		if (eefElementEditorReadOnlyState && faultCodeSoap11.isEnabled()) {
			faultCodeSoap11.setEnabled(false);
			faultCodeSoap11.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeSoap11.isEnabled()) {
			faultCodeSoap11.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultCodeSoap11(Enumerator newValue)
	 * 
	 */
	public void setFaultCodeSoap11(Enumerator newValue) {
		faultCodeSoap11.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11);
		if (eefElementEditorReadOnlyState && faultCodeSoap11.isEnabled()) {
			faultCodeSoap11.setEnabled(false);
			faultCodeSoap11.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeSoap11.isEnabled()) {
			faultCodeSoap11.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultCodeType()
	 * 
	 */
	public Enumerator getFaultCodeType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultCodeType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultCodeType(Object input, Enumerator current)
	 */
	public void initFaultCodeType(Object input, Enumerator current) {
		faultCodeType.setInput(input);
		faultCodeType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeType);
		if (eefElementEditorReadOnlyState && faultCodeType.isEnabled()) {
			faultCodeType.setEnabled(false);
			faultCodeType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeType.isEnabled()) {
			faultCodeType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultCodeType(Enumerator newValue)
	 * 
	 */
	public void setFaultCodeType(Enumerator newValue) {
		faultCodeType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeType);
		if (eefElementEditorReadOnlyState && faultCodeType.isEnabled()) {
			faultCodeType.setEnabled(false);
			faultCodeType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeType.isEnabled()) {
			faultCodeType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultStringType()
	 * 
	 */
	public Enumerator getFaultStringType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultStringType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultStringType(Object input, Enumerator current)
	 */
	public void initFaultStringType(Object input, Enumerator current) {
		faultStringType.setInput(input);
		faultStringType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultStringType);
		if (eefElementEditorReadOnlyState && faultStringType.isEnabled()) {
			faultStringType.setEnabled(false);
			faultStringType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultStringType.isEnabled()) {
			faultStringType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultStringType(Enumerator newValue)
	 * 
	 */
	public void setFaultStringType(Enumerator newValue) {
		faultStringType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultStringType);
		if (eefElementEditorReadOnlyState && faultStringType.isEnabled()) {
			faultStringType.setEnabled(false);
			faultStringType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultStringType.isEnabled()) {
			faultStringType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultStringValue()
	 * 
	 */
	public String getFaultStringValue() {
		return faultStringValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultStringValue(String newValue)
	 * 
	 */
	public void setFaultStringValue(String newValue) {
		if (newValue != null) {
			faultStringValue.setText(newValue);
		} else {
			faultStringValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultStringValue);
		if (eefElementEditorReadOnlyState && faultStringValue.isEnabled()) {
			faultStringValue.setEnabled(false);
			faultStringValue.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultStringValue.isEnabled()) {
			faultStringValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultActor()
	 * 
	 */
	public String getFaultActor() {
		return faultActor.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultActor(String newValue)
	 * 
	 */
	public void setFaultActor(String newValue) {
		if (newValue != null) {
			faultActor.setText(newValue);
		} else {
			faultActor.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultActor);
		if (eefElementEditorReadOnlyState && faultActor.isEnabled()) {
			faultActor.setEnabled(false);
			faultActor.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultActor.isEnabled()) {
			faultActor.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultCodeSoap12()
	 * 
	 */
	public Enumerator getFaultCodeSoap12() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultCodeSoap12.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultCodeSoap12(Object input, Enumerator current)
	 */
	public void initFaultCodeSoap12(Object input, Enumerator current) {
		faultCodeSoap12.setInput(input);
		faultCodeSoap12.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12);
		if (eefElementEditorReadOnlyState && faultCodeSoap12.isEnabled()) {
			faultCodeSoap12.setEnabled(false);
			faultCodeSoap12.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeSoap12.isEnabled()) {
			faultCodeSoap12.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultCodeSoap12(Enumerator newValue)
	 * 
	 */
	public void setFaultCodeSoap12(Enumerator newValue) {
		faultCodeSoap12.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12);
		if (eefElementEditorReadOnlyState && faultCodeSoap12.isEnabled()) {
			faultCodeSoap12.setEnabled(false);
			faultCodeSoap12.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeSoap12.isEnabled()) {
			faultCodeSoap12.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultReasonType()
	 * 
	 */
	public Enumerator getFaultReasonType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultReasonType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultReasonType(Object input, Enumerator current)
	 */
	public void initFaultReasonType(Object input, Enumerator current) {
		faultReasonType.setInput(input);
		faultReasonType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultReasonType);
		if (eefElementEditorReadOnlyState && faultReasonType.isEnabled()) {
			faultReasonType.setEnabled(false);
			faultReasonType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultReasonType.isEnabled()) {
			faultReasonType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultReasonType(Enumerator newValue)
	 * 
	 */
	public void setFaultReasonType(Enumerator newValue) {
		faultReasonType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultReasonType);
		if (eefElementEditorReadOnlyState && faultReasonType.isEnabled()) {
			faultReasonType.setEnabled(false);
			faultReasonType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultReasonType.isEnabled()) {
			faultReasonType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultReasonValue()
	 * 
	 */
	public String getFaultReasonValue() {
		return faultReasonValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultReasonValue(String newValue)
	 * 
	 */
	public void setFaultReasonValue(String newValue) {
		if (newValue != null) {
			faultReasonValue.setText(newValue);
		} else {
			faultReasonValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultReasonValue);
		if (eefElementEditorReadOnlyState && faultReasonValue.isEnabled()) {
			faultReasonValue.setEnabled(false);
			faultReasonValue.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultReasonValue.isEnabled()) {
			faultReasonValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getRoleName()
	 * 
	 */
	public String getRoleName() {
		return roleName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setRoleName(String newValue)
	 * 
	 */
	public void setRoleName(String newValue) {
		if (newValue != null) {
			roleName.setText(newValue);
		} else {
			roleName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.roleName);
		if (eefElementEditorReadOnlyState && roleName.isEnabled()) {
			roleName.setEnabled(false);
			roleName.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !roleName.isEnabled()) {
			roleName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getNodeName()
	 * 
	 */
	public String getNodeName() {
		return nodeName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setNodeName(String newValue)
	 * 
	 */
	public void setNodeName(String newValue) {
		if (newValue != null) {
			nodeName.setText(newValue);
		} else {
			nodeName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.nodeName);
		if (eefElementEditorReadOnlyState && nodeName.isEnabled()) {
			nodeName.setEnabled(false);
			nodeName.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !nodeName.isEnabled()) {
			nodeName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultDetailType()
	 * 
	 */
	public Enumerator getFaultDetailType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultDetailType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultDetailType(Object input, Enumerator current)
	 */
	public void initFaultDetailType(Object input, Enumerator current) {
		faultDetailType.setInput(input);
		faultDetailType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultDetailType);
		if (eefElementEditorReadOnlyState && faultDetailType.isEnabled()) {
			faultDetailType.setEnabled(false);
			faultDetailType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultDetailType.isEnabled()) {
			faultDetailType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultDetailType(Enumerator newValue)
	 * 
	 */
	public void setFaultDetailType(Enumerator newValue) {
		faultDetailType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultDetailType);
		if (eefElementEditorReadOnlyState && faultDetailType.isEnabled()) {
			faultDetailType.setEnabled(false);
			faultDetailType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultDetailType.isEnabled()) {
			faultDetailType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultDetailValue()
	 * 
	 */
	public String getFaultDetailValue() {
		return faultDetailValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultDetailValue(String newValue)
	 * 
	 */
	public void setFaultDetailValue(String newValue) {
		if (newValue != null) {
			faultDetailValue.setText(newValue);
		} else {
			faultDetailValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultDetailValue);
		if (eefElementEditorReadOnlyState && faultDetailValue.isEnabled()) {
			faultDetailValue.setEnabled(false);
			faultDetailValue.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultDetailValue.isEnabled()) {
			faultDetailValue.setEnabled(true);
		}	
		
	}






	// Start of user code for faultStringExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getFaultStringExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFaultStringExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }	
	// End of user code

	// Start of user code for faultCodeExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getFaultCodeExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFaultCodeExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }	
	// End of user code

	// Start of user code for faultDetailExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getFaultDetailExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFaultDetailExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }	
	// End of user code

	// Start of user code for faultReasonExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getFaultReasonExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFaultReasonExpression(NamespacedProperty nameSpacedProperty) {
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
		return EsbMessages.FaultMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
