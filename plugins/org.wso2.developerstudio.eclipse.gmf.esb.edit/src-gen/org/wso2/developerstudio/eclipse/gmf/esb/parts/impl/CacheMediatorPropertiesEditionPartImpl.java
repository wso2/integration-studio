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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CacheMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CacheMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer cacheProtocolType;
	protected EMFComboViewer cacheType;
	protected Text hashGenerator;
	protected Text cacheTimeout;
	protected Text maxMessageSize;
	protected Text cacheProtocolMethods;
	protected Text maxEntryCount;
	protected EMFComboViewer sequenceType;
	protected Text headersToExcludeInHash;
	protected Text responseCodes;
	protected Button enableCacheControl;
	protected Button includeAgeHeader;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CacheMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence cacheMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = cacheMediatorStep.addStep(EsbViewsRepository.CacheMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.cacheProtocolType);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.cacheType);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.hashGenerator);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.cacheTimeout);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.maxMessageSize);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.maxEntryCount);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.sequenceType);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.responseCodes);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.enableCacheControl);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.includeAgeHeader);
		
		
		composer = new PartComposer(cacheMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CacheMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.cacheProtocolType) {
					return createCacheProtocolTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.cacheType) {
					return createCacheTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.hashGenerator) {
					return createHashGeneratorText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.cacheTimeout) {
					return createCacheTimeoutText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.maxMessageSize) {
					return createMaxMessageSizeText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods) {
					return createCacheProtocolMethodsText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.maxEntryCount) {
					return createMaxEntryCountText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.sequenceType) {
					return createSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash) {
					return createHeadersToExcludeInHashText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.responseCodes) {
					return createResponseCodesText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.enableCacheControl) {
					return createEnableCacheControlCheckbox(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.includeAgeHeader) {
					return createIncludeAgeHeaderCheckbox(parent);
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
		propertiesGroup.setText(EsbMessages.CacheMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.description, EsbMessages.CacheMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.CacheMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.CacheMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.CacheMediator.Properties.commentsList, EsbMessages.CacheMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "CacheMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.CacheMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.CacheMediator.Properties.reverse, EsbMessages.CacheMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.CacheMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createCacheProtocolTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.cacheProtocolType, EsbMessages.CacheMediatorPropertiesEditionPart_CacheProtocolTypeLabel);
		cacheProtocolType = new EMFComboViewer(parent);
		cacheProtocolType.setContentProvider(new ArrayContentProvider());
		cacheProtocolType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData cacheProtocolTypeData = new GridData(GridData.FILL_HORIZONTAL);
		cacheProtocolType.getCombo().setLayoutData(cacheProtocolTypeData);
		cacheProtocolType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.cacheProtocolType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCacheProtocolType()));
			}

		});
		cacheProtocolType.setID(EsbViewsRepository.CacheMediator.Properties.cacheProtocolType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.cacheProtocolType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheProtocolTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createCacheTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.cacheType, EsbMessages.CacheMediatorPropertiesEditionPart_CacheTypeLabel);
		cacheType = new EMFComboViewer(parent);
		cacheType.setContentProvider(new ArrayContentProvider());
		cacheType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData cacheTypeData = new GridData(GridData.FILL_HORIZONTAL);
		cacheType.getCombo().setLayoutData(cacheTypeData);
		cacheType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.cacheType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCacheType()));
			}

		});
		cacheType.setID(EsbViewsRepository.CacheMediator.Properties.cacheType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.cacheType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createHashGeneratorText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.hashGenerator, EsbMessages.CacheMediatorPropertiesEditionPart_HashGeneratorLabel);
		hashGenerator = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData hashGeneratorData = new GridData(GridData.FILL_HORIZONTAL);
		hashGenerator.setLayoutData(hashGeneratorData);
		hashGenerator.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.hashGenerator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hashGenerator.getText()));
			}

		});
		hashGenerator.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.hashGenerator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hashGenerator.getText()));
				}
			}

		});
		EditingUtils.setID(hashGenerator, EsbViewsRepository.CacheMediator.Properties.hashGenerator);
		EditingUtils.setEEFtype(hashGenerator, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.hashGenerator, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createHashGeneratorText

		// End of user code
		return parent;
	}

	
	protected Composite createCacheTimeoutText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.cacheTimeout, EsbMessages.CacheMediatorPropertiesEditionPart_CacheTimeoutLabel);
		cacheTimeout = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData cacheTimeoutData = new GridData(GridData.FILL_HORIZONTAL);
		cacheTimeout.setLayoutData(cacheTimeoutData);
		cacheTimeout.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.cacheTimeout, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheTimeout.getText()));
			}

		});
		cacheTimeout.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.cacheTimeout, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheTimeout.getText()));
				}
			}

		});
		EditingUtils.setID(cacheTimeout, EsbViewsRepository.CacheMediator.Properties.cacheTimeout);
		EditingUtils.setEEFtype(cacheTimeout, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.cacheTimeout, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheTimeoutText

		// End of user code
		return parent;
	}

	
	protected Composite createMaxMessageSizeText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.maxMessageSize, EsbMessages.CacheMediatorPropertiesEditionPart_MaxMessageSizeLabel);
		maxMessageSize = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData maxMessageSizeData = new GridData(GridData.FILL_HORIZONTAL);
		maxMessageSize.setLayoutData(maxMessageSizeData);
		maxMessageSize.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.maxMessageSize, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxMessageSize.getText()));
			}

		});
		maxMessageSize.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.maxMessageSize, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxMessageSize.getText()));
				}
			}

		});
		EditingUtils.setID(maxMessageSize, EsbViewsRepository.CacheMediator.Properties.maxMessageSize);
		EditingUtils.setEEFtype(maxMessageSize, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.maxMessageSize, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxMessageSizeText

		// End of user code
		return parent;
	}

	
	protected Composite createCacheProtocolMethodsText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods, EsbMessages.CacheMediatorPropertiesEditionPart_CacheProtocolMethodsLabel);
		cacheProtocolMethods = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData cacheProtocolMethodsData = new GridData(GridData.FILL_HORIZONTAL);
		cacheProtocolMethods.setLayoutData(cacheProtocolMethodsData);
		cacheProtocolMethods.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheProtocolMethods.getText()));
			}

		});
		cacheProtocolMethods.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheProtocolMethods.getText()));
				}
			}

		});
		EditingUtils.setID(cacheProtocolMethods, EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods);
		EditingUtils.setEEFtype(cacheProtocolMethods, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheProtocolMethodsText

		// End of user code
		return parent;
	}

	
	protected Composite createMaxEntryCountText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.maxEntryCount, EsbMessages.CacheMediatorPropertiesEditionPart_MaxEntryCountLabel);
		maxEntryCount = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData maxEntryCountData = new GridData(GridData.FILL_HORIZONTAL);
		maxEntryCount.setLayoutData(maxEntryCountData);
		maxEntryCount.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.maxEntryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxEntryCount.getText()));
			}

		});
		maxEntryCount.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.maxEntryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxEntryCount.getText()));
				}
			}

		});
		EditingUtils.setID(maxEntryCount, EsbViewsRepository.CacheMediator.Properties.maxEntryCount);
		EditingUtils.setEEFtype(maxEntryCount, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.maxEntryCount, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxEntryCountText

		// End of user code
		return parent;
	}

	
	protected Composite createSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.sequenceType, EsbMessages.CacheMediatorPropertiesEditionPart_SequenceTypeLabel);
		sequenceType = new EMFComboViewer(parent);
		sequenceType.setContentProvider(new ArrayContentProvider());
		sequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		sequenceType.getCombo().setLayoutData(sequenceTypeData);
		sequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.sequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceType()));
			}

		});
		sequenceType.setID(EsbViewsRepository.CacheMediator.Properties.sequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.sequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createHeadersToExcludeInHashText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash, EsbMessages.CacheMediatorPropertiesEditionPart_HeadersToExcludeInHashLabel);
		headersToExcludeInHash = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData headersToExcludeInHashData = new GridData(GridData.FILL_HORIZONTAL);
		headersToExcludeInHash.setLayoutData(headersToExcludeInHashData);
		headersToExcludeInHash.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, headersToExcludeInHash.getText()));
			}

		});
		headersToExcludeInHash.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, headersToExcludeInHash.getText()));
				}
			}

		});
		EditingUtils.setID(headersToExcludeInHash, EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash);
		EditingUtils.setEEFtype(headersToExcludeInHash, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createHeadersToExcludeInHashText

		// End of user code
		return parent;
	}

	
	protected Composite createResponseCodesText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.responseCodes, EsbMessages.CacheMediatorPropertiesEditionPart_ResponseCodesLabel);
		responseCodes = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData responseCodesData = new GridData(GridData.FILL_HORIZONTAL);
		responseCodes.setLayoutData(responseCodesData);
		responseCodes.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.responseCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, responseCodes.getText()));
			}

		});
		responseCodes.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.responseCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, responseCodes.getText()));
				}
			}

		});
		EditingUtils.setID(responseCodes, EsbViewsRepository.CacheMediator.Properties.responseCodes);
		EditingUtils.setEEFtype(responseCodes, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.responseCodes, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createResponseCodesText

		// End of user code
		return parent;
	}

	
	protected Composite createEnableCacheControlCheckbox(Composite parent) {
		enableCacheControl = new Button(parent, SWT.CHECK);
		enableCacheControl.setText(getDescription(EsbViewsRepository.CacheMediator.Properties.enableCacheControl, EsbMessages.CacheMediatorPropertiesEditionPart_EnableCacheControlLabel));
		enableCacheControl.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.enableCacheControl, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(enableCacheControl.getSelection())));
			}

		});
		GridData enableCacheControlData = new GridData(GridData.FILL_HORIZONTAL);
		enableCacheControlData.horizontalSpan = 2;
		enableCacheControl.setLayoutData(enableCacheControlData);
		EditingUtils.setID(enableCacheControl, EsbViewsRepository.CacheMediator.Properties.enableCacheControl);
		EditingUtils.setEEFtype(enableCacheControl, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.enableCacheControl, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEnableCacheControlCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createIncludeAgeHeaderCheckbox(Composite parent) {
		includeAgeHeader = new Button(parent, SWT.CHECK);
		includeAgeHeader.setText(getDescription(EsbViewsRepository.CacheMediator.Properties.includeAgeHeader, EsbMessages.CacheMediatorPropertiesEditionPart_IncludeAgeHeaderLabel));
		includeAgeHeader.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Properties.includeAgeHeader, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(includeAgeHeader.getSelection())));
			}

		});
		GridData includeAgeHeaderData = new GridData(GridData.FILL_HORIZONTAL);
		includeAgeHeaderData.horizontalSpan = 2;
		includeAgeHeader.setLayoutData(includeAgeHeaderData);
		EditingUtils.setID(includeAgeHeader, EsbViewsRepository.CacheMediator.Properties.includeAgeHeader);
		EditingUtils.setEEFtype(includeAgeHeader, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.includeAgeHeader, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIncludeAgeHeaderCheckbox

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getCacheProtocolType()
	 * 
	 */
	public Enumerator getCacheProtocolType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) cacheProtocolType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#initCacheProtocolType(Object input, Enumerator current)
	 */
	public void initCacheProtocolType(Object input, Enumerator current) {
		cacheProtocolType.setInput(input);
		cacheProtocolType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.cacheProtocolType);
		if (eefElementEditorReadOnlyState && cacheProtocolType.isEnabled()) {
			cacheProtocolType.setEnabled(false);
			cacheProtocolType.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cacheProtocolType.isEnabled()) {
			cacheProtocolType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setCacheProtocolType(Enumerator newValue)
	 * 
	 */
	public void setCacheProtocolType(Enumerator newValue) {
		cacheProtocolType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.cacheProtocolType);
		if (eefElementEditorReadOnlyState && cacheProtocolType.isEnabled()) {
			cacheProtocolType.setEnabled(false);
			cacheProtocolType.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cacheProtocolType.isEnabled()) {
			cacheProtocolType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getCacheType()
	 * 
	 */
	public Enumerator getCacheType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) cacheType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#initCacheType(Object input, Enumerator current)
	 */
	public void initCacheType(Object input, Enumerator current) {
		cacheType.setInput(input);
		cacheType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.cacheType);
		if (eefElementEditorReadOnlyState && cacheType.isEnabled()) {
			cacheType.setEnabled(false);
			cacheType.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cacheType.isEnabled()) {
			cacheType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setCacheType(Enumerator newValue)
	 * 
	 */
	public void setCacheType(Enumerator newValue) {
		cacheType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.cacheType);
		if (eefElementEditorReadOnlyState && cacheType.isEnabled()) {
			cacheType.setEnabled(false);
			cacheType.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cacheType.isEnabled()) {
			cacheType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getHashGenerator()
	 * 
	 */
	public String getHashGenerator() {
		return hashGenerator.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setHashGenerator(String newValue)
	 * 
	 */
	public void setHashGenerator(String newValue) {
		if (newValue != null) {
			hashGenerator.setText(newValue);
		} else {
			hashGenerator.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.hashGenerator);
		if (eefElementEditorReadOnlyState && hashGenerator.isEnabled()) {
			hashGenerator.setEnabled(false);
			hashGenerator.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !hashGenerator.isEnabled()) {
			hashGenerator.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getCacheTimeout()
	 * 
	 */
	public String getCacheTimeout() {
		return cacheTimeout.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setCacheTimeout(String newValue)
	 * 
	 */
	public void setCacheTimeout(String newValue) {
		if (newValue != null) {
			cacheTimeout.setText(newValue);
		} else {
			cacheTimeout.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.cacheTimeout);
		if (eefElementEditorReadOnlyState && cacheTimeout.isEnabled()) {
			cacheTimeout.setEnabled(false);
			cacheTimeout.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cacheTimeout.isEnabled()) {
			cacheTimeout.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getMaxMessageSize()
	 * 
	 */
	public String getMaxMessageSize() {
		return maxMessageSize.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setMaxMessageSize(String newValue)
	 * 
	 */
	public void setMaxMessageSize(String newValue) {
		if (newValue != null) {
			maxMessageSize.setText(newValue);
		} else {
			maxMessageSize.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.maxMessageSize);
		if (eefElementEditorReadOnlyState && maxMessageSize.isEnabled()) {
			maxMessageSize.setEnabled(false);
			maxMessageSize.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maxMessageSize.isEnabled()) {
			maxMessageSize.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getCacheProtocolMethods()
	 * 
	 */
	public String getCacheProtocolMethods() {
		return cacheProtocolMethods.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setCacheProtocolMethods(String newValue)
	 * 
	 */
	public void setCacheProtocolMethods(String newValue) {
		if (newValue != null) {
			cacheProtocolMethods.setText(newValue);
		} else {
			cacheProtocolMethods.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods);
		if (eefElementEditorReadOnlyState && cacheProtocolMethods.isEnabled()) {
			cacheProtocolMethods.setEnabled(false);
			cacheProtocolMethods.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cacheProtocolMethods.isEnabled()) {
			cacheProtocolMethods.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getMaxEntryCount()
	 * 
	 */
	public String getMaxEntryCount() {
		return maxEntryCount.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setMaxEntryCount(String newValue)
	 * 
	 */
	public void setMaxEntryCount(String newValue) {
		if (newValue != null) {
			maxEntryCount.setText(newValue);
		} else {
			maxEntryCount.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.maxEntryCount);
		if (eefElementEditorReadOnlyState && maxEntryCount.isEnabled()) {
			maxEntryCount.setEnabled(false);
			maxEntryCount.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maxEntryCount.isEnabled()) {
			maxEntryCount.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getSequenceType()
	 * 
	 */
	public Enumerator getSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#initSequenceType(Object input, Enumerator current)
	 */
	public void initSequenceType(Object input, Enumerator current) {
		sequenceType.setInput(input);
		sequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setSequenceType(Enumerator newValue)
	 * 
	 */
	public void setSequenceType(Enumerator newValue) {
		sequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getHeadersToExcludeInHash()
	 * 
	 */
	public String getHeadersToExcludeInHash() {
		return headersToExcludeInHash.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setHeadersToExcludeInHash(String newValue)
	 * 
	 */
	public void setHeadersToExcludeInHash(String newValue) {
		if (newValue != null) {
			headersToExcludeInHash.setText(newValue);
		} else {
			headersToExcludeInHash.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash);
		if (eefElementEditorReadOnlyState && headersToExcludeInHash.isEnabled()) {
			headersToExcludeInHash.setEnabled(false);
			headersToExcludeInHash.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !headersToExcludeInHash.isEnabled()) {
			headersToExcludeInHash.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getResponseCodes()
	 * 
	 */
	public String getResponseCodes() {
		return responseCodes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setResponseCodes(String newValue)
	 * 
	 */
	public void setResponseCodes(String newValue) {
		if (newValue != null) {
			responseCodes.setText(newValue);
		} else {
			responseCodes.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.responseCodes);
		if (eefElementEditorReadOnlyState && responseCodes.isEnabled()) {
			responseCodes.setEnabled(false);
			responseCodes.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !responseCodes.isEnabled()) {
			responseCodes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getEnableCacheControl()
	 * 
	 */
	public Boolean getEnableCacheControl() {
		return Boolean.valueOf(enableCacheControl.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setEnableCacheControl(Boolean newValue)
	 * 
	 */
	public void setEnableCacheControl(Boolean newValue) {
		if (newValue != null) {
			enableCacheControl.setSelection(newValue.booleanValue());
		} else {
			enableCacheControl.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.enableCacheControl);
		if (eefElementEditorReadOnlyState && enableCacheControl.isEnabled()) {
			enableCacheControl.setEnabled(false);
			enableCacheControl.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !enableCacheControl.isEnabled()) {
			enableCacheControl.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getIncludeAgeHeader()
	 * 
	 */
	public Boolean getIncludeAgeHeader() {
		return Boolean.valueOf(includeAgeHeader.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setIncludeAgeHeader(Boolean newValue)
	 * 
	 */
	public void setIncludeAgeHeader(Boolean newValue) {
		if (newValue != null) {
			includeAgeHeader.setSelection(newValue.booleanValue());
		} else {
			includeAgeHeader.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.includeAgeHeader);
		if (eefElementEditorReadOnlyState && includeAgeHeader.isEnabled()) {
			includeAgeHeader.setEnabled(false);
			includeAgeHeader.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !includeAgeHeader.isEnabled()) {
			includeAgeHeader.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CacheMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
