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
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class PayloadFactoryMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PayloadFactoryMediatorPropertiesEditionPart {

	protected EMFComboViewer payloadFormat;
	// Start of user code  for payloadKey widgets declarations
	
	// End of user code

	protected Text payload;
	protected ReferencesTable args;
	protected List<ViewerFilter> argsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> argsFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer mediaType;
	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public PayloadFactoryMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence payloadFactoryMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = payloadFactoryMediatorStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.payload);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.args);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.reverse);
		
		
		composer = new PartComposer(payloadFactoryMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat) {
					return createPayloadFormatEMFComboViewer(parent);
				}
				// Start of user code for payloadKey addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.payload) {
					return createPayloadText(parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.args) {
					return createArgsAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType) {
					return createMediaTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
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
		propertiesGroup.setText(EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createPayloadFormatEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_PayloadFormatLabel);
		payloadFormat = new EMFComboViewer(parent);
		payloadFormat.setContentProvider(new ArrayContentProvider());
		payloadFormat.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData payloadFormatData = new GridData(GridData.FILL_HORIZONTAL);
		payloadFormat.getCombo().setLayoutData(payloadFormatData);
                payloadFormat.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		payloadFormat.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPayloadFormat()));
			}

		});
		payloadFormat.setID(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadFormatEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPayloadText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.payload, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_PayloadLabel);
		payload = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData payloadData = new GridData(GridData.FILL_HORIZONTAL);
		payload.setLayoutData(payloadData);
		payload.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.payload, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, payload.getText()));
			}

		});
		payload.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.payload, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, payload.getText()));
				}
			}

		});
		EditingUtils.setID(payload, EsbViewsRepository.PayloadFactoryMediator.Properties.payload);
		EditingUtils.setEEFtype(payload, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.payload, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createArgsAdvancedTableComposition(Composite parent) {
		this.args = new ReferencesTable(getDescription(EsbViewsRepository.PayloadFactoryMediator.Properties.args, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_ArgsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				args.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				args.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				args.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				args.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.argsFilters) {
			this.args.addFilter(filter);
		}
		this.args.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.args, EsbViewsRepository.SWT_KIND));
		this.args.createControls(parent);
		this.args.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData argsData = new GridData(GridData.FILL_HORIZONTAL);
		argsData.horizontalSpan = 3;
		this.args.setLayoutData(argsData);
		this.args.setLowerBound(0);
		this.args.setUpperBound(-1);
		args.setID(EsbViewsRepository.PayloadFactoryMediator.Properties.args);
		args.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createArgsAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createMediaTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_MediaTypeLabel);
		mediaType = new EMFComboViewer(parent);
		mediaType.setContentProvider(new ArrayContentProvider());
		mediaType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData mediaTypeData = new GridData(GridData.FILL_HORIZONTAL);
		mediaType.getCombo().setLayoutData(mediaTypeData);
                mediaType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		mediaType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getMediaType()));
			}

		});
		mediaType.setID(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMediaTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.description, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.PayloadFactoryMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "PayloadFactoryMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.PayloadFactoryMediator.Properties.reverse, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PayloadFactoryMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.PayloadFactoryMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getPayloadFormat()
	 * 
	 */
	public Enumerator getPayloadFormat() {
		Enumerator selection = (Enumerator) ((StructuredSelection) payloadFormat.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#initPayloadFormat(Object input, Enumerator current)
	 */
	public void initPayloadFormat(Object input, Enumerator current) {
		payloadFormat.setInput(input);
		payloadFormat.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat);
		if (eefElementEditorReadOnlyState && payloadFormat.isEnabled()) {
			payloadFormat.setEnabled(false);
			payloadFormat.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payloadFormat.isEnabled()) {
			payloadFormat.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setPayloadFormat(Enumerator newValue)
	 * 
	 */
	public void setPayloadFormat(Enumerator newValue) {
		payloadFormat.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat);
		if (eefElementEditorReadOnlyState && payloadFormat.isEnabled()) {
			payloadFormat.setEnabled(false);
			payloadFormat.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payloadFormat.isEnabled()) {
			payloadFormat.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getPayload()
	 * 
	 */
	public String getPayload() {
		return payload.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setPayload(String newValue)
	 * 
	 */
	public void setPayload(String newValue) {
		if (newValue != null) {
			payload.setText(newValue);
		} else {
			payload.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.payload);
		if (eefElementEditorReadOnlyState && payload.isEnabled()) {
			payload.setEnabled(false);
			payload.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payload.isEnabled()) {
			payload.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#initArgs(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initArgs(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		args.setContentProvider(contentProvider);
		args.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.args);
		if (eefElementEditorReadOnlyState && args.isEnabled()) {
			args.setEnabled(false);
			args.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !args.isEnabled()) {
			args.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#updateArgs()
	 * 
	 */
	public void updateArgs() {
	args.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#addFilterArgs(ViewerFilter filter)
	 * 
	 */
	public void addFilterToArgs(ViewerFilter filter) {
		argsFilters.add(filter);
		if (this.args != null) {
			this.args.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#addBusinessFilterArgs(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToArgs(ViewerFilter filter) {
		argsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#isContainedInArgsTable(EObject element)
	 * 
	 */
	public boolean isContainedInArgsTable(EObject element) {
		return ((ReferencesTableSettings)args.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getMediaType()
	 * 
	 */
	public Enumerator getMediaType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) mediaType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#initMediaType(Object input, Enumerator current)
	 */
	public void initMediaType(Object input, Enumerator current) {
		mediaType.setInput(input);
		mediaType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType);
		if (eefElementEditorReadOnlyState && mediaType.isEnabled()) {
			mediaType.setEnabled(false);
			mediaType.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !mediaType.isEnabled()) {
			mediaType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setMediaType(Enumerator newValue)
	 * 
	 */
	public void setMediaType(Enumerator newValue) {
		mediaType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType);
		if (eefElementEditorReadOnlyState && mediaType.isEnabled()) {
			mediaType.setEnabled(false);
			mediaType.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !mediaType.isEnabled()) {
			mediaType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}






	// Start of user code for payloadKey specific getters and setters implementation
	@Override
	public void setPayloadKey(RegistryKeyProperty registryKeyProperty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RegistryKeyProperty getPayloadKey() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.PayloadFactoryMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
