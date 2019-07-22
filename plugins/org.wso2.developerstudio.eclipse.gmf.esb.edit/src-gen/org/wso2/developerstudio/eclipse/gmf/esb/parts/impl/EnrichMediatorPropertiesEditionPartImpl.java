/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class EnrichMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EnrichMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Button cloneSource;
	protected EMFComboViewer sourceType;
	protected EMFComboViewer inlineType;
	protected Text sourceXML;
	protected Text sourceProperty;
	// Start of user code  for sourceXPath widgets declarations
	
	// End of user code

	// Start of user code  for inlineRegistryKey widgets declarations
	
	// End of user code

	protected EMFComboViewer targetAction;
	protected EMFComboViewer targetType;
	protected Text targetProperty;
	// Start of user code  for targetXPath widgets declarations
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EnrichMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence enrichMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep miscStep = enrichMediatorStep.addStep(EsbViewsRepository.EnrichMediator.Misc.class);
		miscStep.addStep(EsbViewsRepository.EnrichMediator.Misc.description);
		miscStep.addStep(EsbViewsRepository.EnrichMediator.Misc.commentsList);
		miscStep.addStep(EsbViewsRepository.EnrichMediator.Misc.reverse);
		
		CompositionStep sourceStep = enrichMediatorStep.addStep(EsbViewsRepository.EnrichMediator.Source.class);
		sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.cloneSource);
		sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.sourceType);
		sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.inlineType);
		sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.sourceXML);
		sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.sourceProperty);
		sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.sourceXPath);
		sourceStep.addStep(EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey);
		
		CompositionStep targetStep = enrichMediatorStep.addStep(EsbViewsRepository.EnrichMediator.Target.class);
		targetStep.addStep(EsbViewsRepository.EnrichMediator.Target.targetAction);
		targetStep.addStep(EsbViewsRepository.EnrichMediator.Target.targetType);
		targetStep.addStep(EsbViewsRepository.EnrichMediator.Target.targetProperty);
		targetStep.addStep(EsbViewsRepository.EnrichMediator.Target.targetXPath);
		
		
		composer = new PartComposer(enrichMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.EnrichMediator.Misc.class) {
					return createMiscGroup(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Misc.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Misc.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Misc.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Source.class) {
					return createSourceGroup(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Source.cloneSource) {
					return createCloneSourceCheckbox(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Source.sourceType) {
					return createSourceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Source.inlineType) {
					return createInlineTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Source.sourceXML) {
					return createSourceXMLText(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Source.sourceProperty) {
					return createSourcePropertyText(parent);
				}
				// Start of user code for sourceXPath addToPart creation
				
				// End of user code
				// Start of user code for inlineRegistryKey addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.EnrichMediator.Target.class) {
					return createTargetGroup(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Target.targetAction) {
					return createTargetActionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Target.targetType) {
					return createTargetTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Target.targetProperty) {
					return createTargetPropertyText(parent);
				}
				// Start of user code for targetXPath addToPart creation
				
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createMiscGroup(Composite parent) {
		Group miscGroup = new Group(parent, SWT.NONE);
		miscGroup.setText(EsbMessages.EnrichMediatorPropertiesEditionPart_MiscGroupLabel);
		GridData miscGroupData = new GridData(GridData.FILL_HORIZONTAL);
		miscGroupData.horizontalSpan = 3;
		miscGroup.setLayoutData(miscGroupData);
		GridLayout miscGroupLayout = new GridLayout();
		miscGroupLayout.numColumns = 3;
		miscGroup.setLayout(miscGroupLayout);
		return miscGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Misc.description, EsbMessages.EnrichMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.EnrichMediator.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Misc.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.EnrichMediator.Misc.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.EnrichMediator.Misc.commentsList, EsbMessages.EnrichMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "EnrichMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Misc.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.EnrichMediator.Misc.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.EnrichMediator.Misc.reverse, EsbMessages.EnrichMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Misc.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.EnrichMediator.Misc.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Misc.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createSourceGroup(Composite parent) {
		Group sourceGroup = new Group(parent, SWT.NONE);
		sourceGroup.setText(EsbMessages.EnrichMediatorPropertiesEditionPart_SourceGroupLabel);
		GridData sourceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		sourceGroupData.horizontalSpan = 3;
		sourceGroup.setLayoutData(sourceGroupData);
		GridLayout sourceGroupLayout = new GridLayout();
		sourceGroupLayout.numColumns = 3;
		sourceGroup.setLayout(sourceGroupLayout);
		return sourceGroup;
	}

	
	protected Composite createCloneSourceCheckbox(Composite parent) {
		cloneSource = new Button(parent, SWT.CHECK);
		cloneSource.setText(getDescription(EsbViewsRepository.EnrichMediator.Source.cloneSource, EsbMessages.EnrichMediatorPropertiesEditionPart_CloneSourceLabel));
		cloneSource.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Source.cloneSource, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(cloneSource.getSelection())));
			}

		});
		GridData cloneSourceData = new GridData(GridData.FILL_HORIZONTAL);
		cloneSourceData.horizontalSpan = 2;
		cloneSource.setLayoutData(cloneSourceData);
		EditingUtils.setID(cloneSource, EsbViewsRepository.EnrichMediator.Source.cloneSource);
		EditingUtils.setEEFtype(cloneSource, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Source.cloneSource, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCloneSourceCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createSourceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Source.sourceType, EsbMessages.EnrichMediatorPropertiesEditionPart_SourceTypeLabel);
		sourceType = new EMFComboViewer(parent);
		sourceType.setContentProvider(new ArrayContentProvider());
		sourceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sourceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		sourceType.getCombo().setLayoutData(sourceTypeData);
                sourceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		sourceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Source.sourceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceType()));
			}

		});
		sourceType.setID(EsbViewsRepository.EnrichMediator.Source.sourceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Source.sourceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createInlineTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Source.inlineType, EsbMessages.EnrichMediatorPropertiesEditionPart_InlineTypeLabel);
		inlineType = new EMFComboViewer(parent);
		inlineType.setContentProvider(new ArrayContentProvider());
		inlineType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData inlineTypeData = new GridData(GridData.FILL_HORIZONTAL);
		inlineType.getCombo().setLayoutData(inlineTypeData);
                inlineType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		inlineType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Source.inlineType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInlineType()));
			}

		});
		inlineType.setID(EsbViewsRepository.EnrichMediator.Source.inlineType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Source.inlineType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInlineTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createSourceXMLText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Source.sourceXML, EsbMessages.EnrichMediatorPropertiesEditionPart_SourceXMLLabel);
		sourceXML = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData sourceXMLData = new GridData(GridData.FILL_HORIZONTAL);
		sourceXML.setLayoutData(sourceXMLData);
		sourceXML.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Source.sourceXML, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceXML.getText()));
			}

		});
		sourceXML.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Source.sourceXML, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceXML.getText()));
				}
			}

		});
		EditingUtils.setID(sourceXML, EsbViewsRepository.EnrichMediator.Source.sourceXML);
		EditingUtils.setEEFtype(sourceXML, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Source.sourceXML, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceXMLText

		// End of user code
		return parent;
	}

	
	protected Composite createSourcePropertyText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Source.sourceProperty, EsbMessages.EnrichMediatorPropertiesEditionPart_SourcePropertyLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Source.sourceProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceProperty.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Source.sourceProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceProperty.getText()));
				}
			}

		});
		EditingUtils.setID(sourceProperty, EsbViewsRepository.EnrichMediator.Source.sourceProperty);
		EditingUtils.setEEFtype(sourceProperty, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Source.sourceProperty, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourcePropertyText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createTargetGroup(Composite parent) {
		Group targetGroup = new Group(parent, SWT.NONE);
		targetGroup.setText(EsbMessages.EnrichMediatorPropertiesEditionPart_TargetGroupLabel);
		GridData targetGroupData = new GridData(GridData.FILL_HORIZONTAL);
		targetGroupData.horizontalSpan = 3;
		targetGroup.setLayoutData(targetGroupData);
		GridLayout targetGroupLayout = new GridLayout();
		targetGroupLayout.numColumns = 3;
		targetGroup.setLayout(targetGroupLayout);
		return targetGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createTargetActionEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Target.targetAction, EsbMessages.EnrichMediatorPropertiesEditionPart_TargetActionLabel);
		targetAction = new EMFComboViewer(parent);
		targetAction.setContentProvider(new ArrayContentProvider());
		targetAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData targetActionData = new GridData(GridData.FILL_HORIZONTAL);
		targetAction.getCombo().setLayoutData(targetActionData);
                targetAction.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		targetAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Target.targetAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetAction()));
			}

		});
		targetAction.setID(EsbViewsRepository.EnrichMediator.Target.targetAction);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Target.targetAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetActionEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createTargetTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Target.targetType, EsbMessages.EnrichMediatorPropertiesEditionPart_TargetTypeLabel);
		targetType = new EMFComboViewer(parent);
		targetType.setContentProvider(new ArrayContentProvider());
		targetType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData targetTypeData = new GridData(GridData.FILL_HORIZONTAL);
		targetType.getCombo().setLayoutData(targetTypeData);
                targetType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		targetType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Target.targetType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetType()));
			}

		});
		targetType.setID(EsbViewsRepository.EnrichMediator.Target.targetType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Target.targetType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createTargetPropertyText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Target.targetProperty, EsbMessages.EnrichMediatorPropertiesEditionPart_TargetPropertyLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Target.targetProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetProperty.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EnrichMediator.Target.targetProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetProperty.getText()));
				}
			}

		});
		EditingUtils.setID(targetProperty, EsbViewsRepository.EnrichMediator.Target.targetProperty);
		EditingUtils.setEEFtype(targetProperty, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Target.targetProperty, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetPropertyText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Misc.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Misc.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Misc.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getCloneSource()
	 * 
	 */
	public Boolean getCloneSource() {
		return Boolean.valueOf(cloneSource.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setCloneSource(Boolean newValue)
	 * 
	 */
	public void setCloneSource(Boolean newValue) {
		if (newValue != null) {
			cloneSource.setSelection(newValue.booleanValue());
		} else {
			cloneSource.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.cloneSource);
		if (eefElementEditorReadOnlyState && cloneSource.isEnabled()) {
			cloneSource.setEnabled(false);
			cloneSource.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cloneSource.isEnabled()) {
			cloneSource.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getSourceType()
	 * 
	 */
	public Enumerator getSourceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sourceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initSourceType(Object input, Enumerator current)
	 */
	public void initSourceType(Object input, Enumerator current) {
		sourceType.setInput(input);
		sourceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.sourceType);
		if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
			sourceType.setEnabled(false);
			sourceType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
			sourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setSourceType(Enumerator newValue)
	 * 
	 */
	public void setSourceType(Enumerator newValue) {
		sourceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.sourceType);
		if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
			sourceType.setEnabled(false);
			sourceType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
			sourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getInlineType()
	 * 
	 */
	public Enumerator getInlineType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inlineType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initInlineType(Object input, Enumerator current)
	 */
	public void initInlineType(Object input, Enumerator current) {
		inlineType.setInput(input);
		inlineType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.inlineType);
		if (eefElementEditorReadOnlyState && inlineType.isEnabled()) {
			inlineType.setEnabled(false);
			inlineType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inlineType.isEnabled()) {
			inlineType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setInlineType(Enumerator newValue)
	 * 
	 */
	public void setInlineType(Enumerator newValue) {
		inlineType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.inlineType);
		if (eefElementEditorReadOnlyState && inlineType.isEnabled()) {
			inlineType.setEnabled(false);
			inlineType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inlineType.isEnabled()) {
			inlineType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getSourceXML()
	 * 
	 */
	public String getSourceXML() {
		return sourceXML.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setSourceXML(String newValue)
	 * 
	 */
	public void setSourceXML(String newValue) {
		if (newValue != null) {
			sourceXML.setText(newValue);
		} else {
			sourceXML.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.sourceXML);
		if (eefElementEditorReadOnlyState && sourceXML.isEnabled()) {
			sourceXML.setEnabled(false);
			sourceXML.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceXML.isEnabled()) {
			sourceXML.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getSourceProperty()
	 * 
	 */
	public String getSourceProperty() {
		return sourceProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setSourceProperty(String newValue)
	 * 
	 */
	public void setSourceProperty(String newValue) {
		if (newValue != null) {
			sourceProperty.setText(newValue);
		} else {
			sourceProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Source.sourceProperty);
		if (eefElementEditorReadOnlyState && sourceProperty.isEnabled()) {
			sourceProperty.setEnabled(false);
			sourceProperty.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceProperty.isEnabled()) {
			sourceProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getTargetAction()
	 * 
	 */
	public Enumerator getTargetAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initTargetAction(Object input, Enumerator current)
	 */
	public void initTargetAction(Object input, Enumerator current) {
		targetAction.setInput(input);
		targetAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Target.targetAction);
		if (eefElementEditorReadOnlyState && targetAction.isEnabled()) {
			targetAction.setEnabled(false);
			targetAction.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetAction.isEnabled()) {
			targetAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setTargetAction(Enumerator newValue)
	 * 
	 */
	public void setTargetAction(Enumerator newValue) {
		targetAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Target.targetAction);
		if (eefElementEditorReadOnlyState && targetAction.isEnabled()) {
			targetAction.setEnabled(false);
			targetAction.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetAction.isEnabled()) {
			targetAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getTargetType()
	 * 
	 */
	public Enumerator getTargetType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initTargetType(Object input, Enumerator current)
	 */
	public void initTargetType(Object input, Enumerator current) {
		targetType.setInput(input);
		targetType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Target.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setTargetType(Enumerator newValue)
	 * 
	 */
	public void setTargetType(Enumerator newValue) {
		targetType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Target.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getTargetProperty()
	 * 
	 */
	public String getTargetProperty() {
		return targetProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setTargetProperty(String newValue)
	 * 
	 */
	public void setTargetProperty(String newValue) {
		if (newValue != null) {
			targetProperty.setText(newValue);
		} else {
			targetProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Target.targetProperty);
		if (eefElementEditorReadOnlyState && targetProperty.isEnabled()) {
			targetProperty.setEnabled(false);
			targetProperty.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetProperty.isEnabled()) {
			targetProperty.setEnabled(true);
		}	
		
	}






	// Start of user code for sourceXPath specific getters and setters implementation
	
	// End of user code

	// Start of user code for inlineRegistryKey specific getters and setters implementation
	
	// End of user code

	// Start of user code for targetXPath specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.EnrichMediator_Part_Title;
	}

	// Start of user code additional methods
    @Override
    public NamespacedProperty getSourceXPath() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSourceXPath(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getInlineRegistryKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInlineRegistryKey(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public NamespacedProperty getTargetXPath() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTargetXPath(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }
	// End of user code


}
