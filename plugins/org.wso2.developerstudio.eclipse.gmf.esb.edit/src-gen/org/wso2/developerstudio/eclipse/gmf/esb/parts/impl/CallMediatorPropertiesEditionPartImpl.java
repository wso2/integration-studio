/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
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

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

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
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CallMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CallMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected ReferencesTable endpoint;
	protected List<ViewerFilter> endpointBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> endpointFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer endpointType;
	protected Button enableBlockingCalls;
	protected Text sourcePayload;
    protected Text sourceProperty;
    protected Text contentType;
    protected EMFComboViewer sourceType;
    protected Text targetProperty;
    protected EMFComboViewer targetType;
  // Start of user code  for endpointXpath widgets declarations
	
	// End of user code

	// Start of user code  for endpointRegistryKey widgets declarations
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CallMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence callMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = callMediatorStep.addStep(EsbViewsRepository.CallMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.endpoint);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.endpointType);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.enableBlockingCalls);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.endpointXpath);
		propertiesStep.addStep(EsbViewsRepository.CallMediator.Properties.endpointRegistryKey);
		
		
		composer = new PartComposer(callMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CallMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.endpoint) {
					return createEndpointAdvancedReferencesTable(parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.endpointType) {
					return createEndpointTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CallMediator.Properties.enableBlockingCalls) {
					return createEnableBlockingCallsCheckbox(parent);
				}
				// Start of user code for endpointXpath addToPart creation
				
				// End of user code
				// Start of user code for endpointRegistryKey addToPart creation
				
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
		propertiesGroup.setText(EsbMessages.CallMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CallMediator.Properties.description, EsbMessages.CallMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.CallMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.CallMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.CallMediator.Properties.commentsList, EsbMessages.CallMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "CallMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.CallMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.CallMediator.Properties.reverse, EsbMessages.CallMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.CallMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createEndpointAdvancedReferencesTable(Composite parent) {
		String label = getDescription(EsbViewsRepository.CallMediator.Properties.endpoint, EsbMessages.CallMediatorPropertiesEditionPart_EndpointLabel);		 
		this.endpoint = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addEndpoint(); }
			public void handleEdit(EObject element) { editEndpoint(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveEndpoint(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromEndpoint(element); }
			public void navigateTo(EObject element) { }
		});
		this.endpoint.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.endpoint, EsbViewsRepository.SWT_KIND));
		this.endpoint.createControls(parent);
		this.endpoint.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Properties.endpoint, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData endpointData = new GridData(GridData.FILL_HORIZONTAL);
		endpointData.horizontalSpan = 3;
		this.endpoint.setLayoutData(endpointData);
		this.endpoint.disableMove();
		endpoint.setID(EsbViewsRepository.CallMediator.Properties.endpoint);
		endpoint.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addEndpoint() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(endpoint.getInput(), endpointFilters, endpointBusinessFilters,
		"endpoint", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Properties.endpoint,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				endpoint.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveEndpoint(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Properties.endpoint, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		endpoint.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromEndpoint(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Properties.endpoint, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		endpoint.refresh();
	}

	/**
	 * 
	 */
	protected void editEndpoint(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				endpoint.refresh();
			}
		}
	}

	/**
	 * @generated NOT
	 */
	protected Composite createEndpointTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CallMediator.Properties.endpointType, EsbMessages.CallMediatorPropertiesEditionPart_EndpointTypeLabel);
		endpointType = new EMFComboViewer(parent);
		endpointType.setContentProvider(new ArrayContentProvider());
		endpointType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData endpointTypeData = new GridData(GridData.FILL_HORIZONTAL);
		endpointType.getCombo().setLayoutData(endpointTypeData);
                endpointType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		endpointType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Properties.endpointType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEndpointType()));
			}

		});
		endpointType.setID(EsbViewsRepository.CallMediator.Properties.endpointType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.endpointType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createEnableBlockingCallsCheckbox(Composite parent) {
		enableBlockingCalls = new Button(parent, SWT.CHECK);
		enableBlockingCalls.setText(getDescription(EsbViewsRepository.CallMediator.Properties.enableBlockingCalls, EsbMessages.CallMediatorPropertiesEditionPart_EnableBlockingCallsLabel));
		enableBlockingCalls.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Properties.enableBlockingCalls, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(enableBlockingCalls.getSelection())));
			}

		});
		GridData enableBlockingCallsData = new GridData(GridData.FILL_HORIZONTAL);
		enableBlockingCallsData.horizontalSpan = 2;
		enableBlockingCalls.setLayoutData(enableBlockingCallsData);
		EditingUtils.setID(enableBlockingCalls, EsbViewsRepository.CallMediator.Properties.enableBlockingCalls);
		EditingUtils.setEEFtype(enableBlockingCalls, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Properties.enableBlockingCalls, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEnableBlockingCallsCheckbox

		// End of user code
		return parent;
	}


	/**
   * 
   */
  protected Composite createSourceGroup(Composite parent) {
    Group sourceGroup = new Group(parent, SWT.NONE);
    sourceGroup.setText(EsbMessages.CallMediatorPropertiesEditionPart_SourceGroupLabel);
    GridData sourceGroupData = new GridData(GridData.FILL_HORIZONTAL);
    sourceGroupData.horizontalSpan = 3;
    sourceGroup.setLayoutData(sourceGroupData);
    GridLayout sourceGroupLayout = new GridLayout();
    sourceGroupLayout.numColumns = 3;
    sourceGroup.setLayout(sourceGroupLayout);
    return sourceGroup;
  }

  protected Composite createSourcePayloadText(Composite parent) {
    createDescription(parent, EsbViewsRepository.CallMediator.Source.sourcePayload, EsbMessages.CallMediatorPropertiesEditionPart_SourcePayloadLabel);
    sourcePayload = SWTUtils.createScrollableText(parent, SWT.BORDER);
    GridData sourcePayloadData = new GridData(GridData.FILL_HORIZONTAL);
    sourcePayload.setLayoutData(sourcePayloadData);
    sourcePayload.addFocusListener(new FocusAdapter() {

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
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Source.sourcePayload, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourcePayload.getText()));
      }

    });
    sourcePayload.addKeyListener(new KeyAdapter() {

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
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Source.sourcePayload, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourcePayload.getText()));
        }
      }

    });
    EditingUtils.setID(sourcePayload, EsbViewsRepository.CallMediator.Source.sourcePayload);
    EditingUtils.setEEFtype(sourcePayload, "eef::Text"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Source.sourcePayload, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createSourcePayloadText

    // End of user code
    return parent;
  }

  protected Composite createSourcePropertyText(Composite parent) {
    createDescription(parent, EsbViewsRepository.CallMediator.Source.sourceProperty, EsbMessages.CallMediatorPropertiesEditionPart_SourcePropertyLabel);
    sourceProperty = SWTUtils.createScrollableText(parent, SWT.BORDER);
    GridData sourcePropertyData = new GridData(GridData.FILL_HORIZONTAL);
    sourceProperty.setLayoutData(sourcePropertyData);
    sourceProperty.addFocusListener(new FocusAdapter() {

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
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Source.sourceProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceProperty.getText()));
      }

    });
    sourceProperty.addKeyListener(new KeyAdapter() {

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
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Source.sourceProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceProperty.getText()));
        }
      }

    });
    EditingUtils.setID(sourceProperty, EsbViewsRepository.CallMediator.Source.sourceProperty);
    EditingUtils.setEEFtype(sourceProperty, "eef::Text"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Source.sourceProperty, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createSourcePropertyText

    // End of user code
    return parent;
  }

  protected Composite createContentTypeText(Composite parent) {
    createDescription(parent, EsbViewsRepository.CallMediator.Source.contentType, EsbMessages.CallMediatorPropertiesEditionPart_ContentTypeLabel);
    contentType = SWTUtils.createScrollableText(parent, SWT.BORDER);
    GridData contentTypeData = new GridData(GridData.FILL_HORIZONTAL);
    contentType.setLayoutData(contentTypeData);
    contentType.addFocusListener(new FocusAdapter() {

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
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Source.contentType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, contentType.getText()));
      }

    });
    contentType.addKeyListener(new KeyAdapter() {

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
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Source.contentType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, contentType.getText()));
        }
      }

    });
    EditingUtils.setID(contentType, EsbViewsRepository.CallMediator.Source.contentType);
    EditingUtils.setEEFtype(contentType, "eef::Text"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Source.contentType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createContentTypeText

    // End of user code
    return parent;
  }

  protected Composite createSourceTypeEMFComboViewer(Composite parent) {
    createDescription(parent, EsbViewsRepository.CallMediator.Source.sourceType, EsbMessages.CallMediatorPropertiesEditionPart_SourceTypeLabel);
    sourceType = new EMFComboViewer(parent);
    sourceType.setContentProvider(new ArrayContentProvider());
    sourceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData sourceTypeData = new GridData(GridData.FILL_HORIZONTAL);
    sourceType.getCombo().setLayoutData(sourceTypeData);
    sourceType.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Source.sourceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceType()));
      }

    });
    sourceType.setID(EsbViewsRepository.CallMediator.Source.sourceType);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Source.sourceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createSourceTypeEMFComboViewer

    // End of user code
    return parent;
  }

  /**
   * 
   */
  protected Composite createTargetGroup(Composite parent) {
    Group targetGroup = new Group(parent, SWT.NONE);
    targetGroup.setText(EsbMessages.CallMediatorPropertiesEditionPart_TargetGroupLabel);
    GridData targetGroupData = new GridData(GridData.FILL_HORIZONTAL);
    targetGroupData.horizontalSpan = 3;
    targetGroup.setLayoutData(targetGroupData);
    GridLayout targetGroupLayout = new GridLayout();
    targetGroupLayout.numColumns = 3;
    targetGroup.setLayout(targetGroupLayout);
    return targetGroup;
  }

  protected Composite createTargetPropertyText(Composite parent) {
    createDescription(parent, EsbViewsRepository.CallMediator.Target.targetProperty, EsbMessages.CallMediatorPropertiesEditionPart_TargetPropertyLabel);
    targetProperty = SWTUtils.createScrollableText(parent, SWT.BORDER);
    GridData targetPropertyData = new GridData(GridData.FILL_HORIZONTAL);
    targetProperty.setLayoutData(targetPropertyData);
    targetProperty.addFocusListener(new FocusAdapter() {

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
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Target.targetProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetProperty.getText()));
      }

    });
    targetProperty.addKeyListener(new KeyAdapter() {

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
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Target.targetProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetProperty.getText()));
        }
      }

    });
    EditingUtils.setID(targetProperty, EsbViewsRepository.CallMediator.Target.targetProperty);
    EditingUtils.setEEFtype(targetProperty, "eef::Text"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Target.targetProperty, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createTargetPropertyText

    // End of user code
    return parent;
  }

  protected Composite createTargetTypeEMFComboViewer(Composite parent) {
    createDescription(parent, EsbViewsRepository.CallMediator.Target.targetType, EsbMessages.CallMediatorPropertiesEditionPart_TargetTypeLabel);
    targetType = new EMFComboViewer(parent);
    targetType.setContentProvider(new ArrayContentProvider());
    targetType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData targetTypeData = new GridData(GridData.FILL_HORIZONTAL);
    targetType.getCombo().setLayoutData(targetTypeData);
    targetType.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CallMediator.Target.targetType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetType()));
      }

    });
    targetType.setID(EsbViewsRepository.CallMediator.Target.targetType);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallMediator.Target.targetType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createTargetTypeEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.CallMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#initEndpoint(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initEndpoint(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		endpoint.setContentProvider(contentProvider);
		endpoint.setInput(settings);
		endpointBusinessFilters.clear();
		endpointFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.endpoint);
		if (eefElementEditorReadOnlyState && endpoint.getTable().isEnabled()) {
			endpoint.setEnabled(false);
			endpoint.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpoint.getTable().isEnabled()) {
			endpoint.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#updateEndpoint()
	 * 
	 */
	public void updateEndpoint() {
	endpoint.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#addFilterEndpoint(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEndpoint(ViewerFilter filter) {
		endpointFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#addBusinessFilterEndpoint(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEndpoint(ViewerFilter filter) {
		endpointBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#isContainedInEndpointTable(EObject element)
	 * 
	 */
	public boolean isContainedInEndpointTable(EObject element) {
		return ((ReferencesTableSettings)endpoint.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getEndpointType()
	 * 
	 */
	public Enumerator getEndpointType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) endpointType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#initEndpointType(Object input, Enumerator current)
	 */
	public void initEndpointType(Object input, Enumerator current) {
		endpointType.setInput(input);
		endpointType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setEndpointType(Enumerator newValue)
	 * 
	 */
	public void setEndpointType(Enumerator newValue) {
		endpointType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getEnableBlockingCalls()
	 * 
	 */
	public Boolean getEnableBlockingCalls() {
		return Boolean.valueOf(enableBlockingCalls.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setEnableBlockingCalls(Boolean newValue)
	 * 
	 */
	public void setEnableBlockingCalls(Boolean newValue) {
		if (newValue != null) {
			enableBlockingCalls.setSelection(newValue.booleanValue());
		} else {
			enableBlockingCalls.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Properties.enableBlockingCalls);
		if (eefElementEditorReadOnlyState && enableBlockingCalls.isEnabled()) {
			enableBlockingCalls.setEnabled(false);
			enableBlockingCalls.setToolTipText(EsbMessages.CallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !enableBlockingCalls.isEnabled()) {
			enableBlockingCalls.setEnabled(true);
		}	
		
	}






	/**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getSourcePayload()
   * 
   */
  public String getSourcePayload() {
    return sourcePayload.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setSourcePayload(String newValue)
   * 
   */
  public void setSourcePayload(String newValue) {
    if (newValue != null) {
      sourcePayload.setText(newValue);
    } else {
      sourcePayload.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Source.sourcePayload);
    if (eefElementEditorReadOnlyState && sourcePayload.isEnabled()) {
      sourcePayload.setEnabled(false);
      sourcePayload.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !sourcePayload.isEnabled()) {
      sourcePayload.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getSourceProperty()
   * 
   */
  public String getSourceProperty() {
    return sourceProperty.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setSourceProperty(String newValue)
   * 
   */
  public void setSourceProperty(String newValue) {
    if (newValue != null) {
      sourceProperty.setText(newValue);
    } else {
      sourceProperty.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Source.sourceProperty);
    if (eefElementEditorReadOnlyState && sourceProperty.isEnabled()) {
      sourceProperty.setEnabled(false);
      sourceProperty.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !sourceProperty.isEnabled()) {
      sourceProperty.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getContentType()
   * 
   */
  public String getContentType() {
    return contentType.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setContentType(String newValue)
   * 
   */
  public void setContentType(String newValue) {
    if (newValue != null) {
      contentType.setText(newValue);
    } else {
      contentType.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Source.contentType);
    if (eefElementEditorReadOnlyState && contentType.isEnabled()) {
      contentType.setEnabled(false);
      contentType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !contentType.isEnabled()) {
      contentType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getSourceType()
   * 
   */
  public Enumerator getSourceType() {
    Enumerator selection = (Enumerator) ((StructuredSelection) sourceType.getSelection()).getFirstElement();
    return selection;
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#initSourceType(Object input, Enumerator current)
   */
  public void initSourceType(Object input, Enumerator current) {
    sourceType.setInput(input);
    sourceType.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Source.sourceType);
    if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
      sourceType.setEnabled(false);
      sourceType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
      sourceType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setSourceType(Enumerator newValue)
   * 
   */
  public void setSourceType(Enumerator newValue) {
    sourceType.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Source.sourceType);
    if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
      sourceType.setEnabled(false);
      sourceType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
      sourceType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getTargetProperty()
   * 
   */
  public String getTargetProperty() {
    return targetProperty.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setTargetProperty(String newValue)
   * 
   */
  public void setTargetProperty(String newValue) {
    if (newValue != null) {
      targetProperty.setText(newValue);
    } else {
      targetProperty.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Target.targetProperty);
    if (eefElementEditorReadOnlyState && targetProperty.isEnabled()) {
      targetProperty.setEnabled(false);
      targetProperty.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !targetProperty.isEnabled()) {
      targetProperty.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#getTargetType()
   * 
   */
  public Enumerator getTargetType() {
    Enumerator selection = (Enumerator) ((StructuredSelection) targetType.getSelection()).getFirstElement();
    return selection;
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#initTargetType(Object input, Enumerator current)
   */
  public void initTargetType(Object input, Enumerator current) {
    targetType.setInput(input);
    targetType.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Target.targetType);
    if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
      targetType.setEnabled(false);
      targetType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
      targetType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart#setTargetType(Enumerator newValue)
   * 
   */
  public void setTargetType(Enumerator newValue) {
    targetType.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallMediator.Target.targetType);
    if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
      targetType.setEnabled(false);
      targetType.setToolTipText(EsbMessages.CallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
      targetType.setEnabled(true);
    }	
    
  }

  // Start of user code for endpointXpath specific getters and setters implementation
	
	// End of user code

	// Start of user code for endpointRegistryKey specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CallMediator_Part_Title;
	}

	// Start of user code additional methods
    @Override
    public NamespacedProperty getEndpointXPath() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setEndpointXPath(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getEndpointRegistryKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setEndpointRegistryKey(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }
	// End of user code

    @Override
    public void setSourceXPath(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public NamespacedProperty getSourceXPath() {
        // TODO Auto-generated method stub
        return null;
    }


}
