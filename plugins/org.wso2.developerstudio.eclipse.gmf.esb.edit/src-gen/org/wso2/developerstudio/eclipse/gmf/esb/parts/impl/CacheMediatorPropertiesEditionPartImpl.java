/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
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

import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

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

import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CacheMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CacheMediatorPropertiesEditionPart {

	protected EMFComboViewer cacheType;
	protected Text cacheTimeout;
	protected Text maxMessageSize;
	protected Text maxEntryCount;
	protected EMFComboViewer sequenceType;
	// Start of user code  for sequenceKey widgets declarations
	
	// End of user code

	protected EMFComboViewer cacheProtocolType;
	protected Text cacheProtocolMethods;
	protected Text headersToExcludeInHash;
	protected Text responseCodes;
	protected Button enableCacheControl;
	protected Button includeAgeHeader;
	protected Text hashGenerator;
	protected Text description;



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
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.cacheType);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.cacheTimeout);
		propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.maxMessageSize);
		
		cacheMediatorStep
			.addStep(EsbViewsRepository.CacheMediator.Implementation.class)
			.addStep(EsbViewsRepository.CacheMediator.Implementation.maxEntryCount);
		
		CompositionStep onCacheHitStep = cacheMediatorStep.addStep(EsbViewsRepository.CacheMediator.OnCacheHit.class);
		onCacheHitStep.addStep(EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType);
		onCacheHitStep.addStep(EsbViewsRepository.CacheMediator.OnCacheHit.sequenceKey);
		
		CompositionStep protocolStep = cacheMediatorStep.addStep(EsbViewsRepository.CacheMediator.Protocol.class);
		protocolStep.addStep(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType);
		protocolStep.addStep(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods);
		protocolStep.addStep(EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash);
		protocolStep.addStep(EsbViewsRepository.CacheMediator.Protocol.responseCodes);
		protocolStep.addStep(EsbViewsRepository.CacheMediator.Protocol.enableCacheControl);
		protocolStep.addStep(EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader);
		protocolStep.addStep(EsbViewsRepository.CacheMediator.Protocol.hashGenerator);
		
		cacheMediatorStep
			.addStep(EsbViewsRepository.CacheMediator.Misc.class)
			.addStep(EsbViewsRepository.CacheMediator.Misc.description);
		
		
		composer = new PartComposer(cacheMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CacheMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.cacheType) {
					return createCacheTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.cacheTimeout) {
					return createCacheTimeoutText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.maxMessageSize) {
					return createMaxMessageSizeText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Implementation.class) {
					return createImplementationGroup(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Implementation.maxEntryCount) {
					return createMaxEntryCountText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.OnCacheHit.class) {
					return createOnCacheHitGroup(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType) {
					return createSequenceTypeEMFComboViewer(parent);
				}
				// Start of user code for sequenceKey addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.CacheMediator.Protocol.class) {
					return createProtocolGroup(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType) {
					return createCacheProtocolTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods) {
					return createCacheProtocolMethodsText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash) {
					return createHeadersToExcludeInHashText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Protocol.responseCodes) {
					return createResponseCodesText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Protocol.enableCacheControl) {
					return createEnableCacheControlCheckbox(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader) {
					return createIncludeAgeHeaderCheckbox(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Protocol.hashGenerator) {
					return createHashGeneratorText(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Misc.class) {
					return createMiscGroup(parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Misc.description) {
					return createDescriptionText(parent);
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

	/**
	 * 
	 */
	protected Composite createImplementationGroup(Composite parent) {
		Group implementationGroup = new Group(parent, SWT.NONE);
		implementationGroup.setText(EsbMessages.CacheMediatorPropertiesEditionPart_ImplementationGroupLabel);
		GridData implementationGroupData = new GridData(GridData.FILL_HORIZONTAL);
		implementationGroupData.horizontalSpan = 3;
		implementationGroup.setLayoutData(implementationGroupData);
		GridLayout implementationGroupLayout = new GridLayout();
		implementationGroupLayout.numColumns = 3;
		implementationGroup.setLayout(implementationGroupLayout);
		return implementationGroup;
	}

	
	protected Composite createMaxEntryCountText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Implementation.maxEntryCount, EsbMessages.CacheMediatorPropertiesEditionPart_MaxEntryCountLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Implementation.maxEntryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxEntryCount.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Implementation.maxEntryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxEntryCount.getText()));
				}
			}

		});
		EditingUtils.setID(maxEntryCount, EsbViewsRepository.CacheMediator.Implementation.maxEntryCount);
		EditingUtils.setEEFtype(maxEntryCount, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Implementation.maxEntryCount, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxEntryCountText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createOnCacheHitGroup(Composite parent) {
		Group onCacheHitGroup = new Group(parent, SWT.NONE);
		onCacheHitGroup.setText(EsbMessages.CacheMediatorPropertiesEditionPart_OnCacheHitGroupLabel);
		GridData onCacheHitGroupData = new GridData(GridData.FILL_HORIZONTAL);
		onCacheHitGroupData.horizontalSpan = 3;
		onCacheHitGroup.setLayoutData(onCacheHitGroupData);
		GridLayout onCacheHitGroupLayout = new GridLayout();
		onCacheHitGroupLayout.numColumns = 3;
		onCacheHitGroup.setLayout(onCacheHitGroupLayout);
		return onCacheHitGroup;
	}

	
	protected Composite createSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType, EsbMessages.CacheMediatorPropertiesEditionPart_SequenceTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceType()));
			}

		});
		sequenceType.setID(EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createProtocolGroup(Composite parent) {
		Group protocolGroup = new Group(parent, SWT.NONE);
		protocolGroup.setText(EsbMessages.CacheMediatorPropertiesEditionPart_ProtocolGroupLabel);
		GridData protocolGroupData = new GridData(GridData.FILL_HORIZONTAL);
		protocolGroupData.horizontalSpan = 3;
		protocolGroup.setLayoutData(protocolGroupData);
		GridLayout protocolGroupLayout = new GridLayout();
		protocolGroupLayout.numColumns = 3;
		protocolGroup.setLayout(protocolGroupLayout);
		return protocolGroup;
	}

	
	protected Composite createCacheProtocolTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType, EsbMessages.CacheMediatorPropertiesEditionPart_CacheProtocolTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCacheProtocolType()));
			}

		});
		cacheProtocolType.setID(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheProtocolTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createCacheProtocolMethodsText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods, EsbMessages.CacheMediatorPropertiesEditionPart_CacheProtocolMethodsLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheProtocolMethods.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheProtocolMethods.getText()));
				}
			}

		});
		EditingUtils.setID(cacheProtocolMethods, EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods);
		EditingUtils.setEEFtype(cacheProtocolMethods, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheProtocolMethodsText

		// End of user code
		return parent;
	}

	
	protected Composite createHeadersToExcludeInHashText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash, EsbMessages.CacheMediatorPropertiesEditionPart_HeadersToExcludeInHashLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, headersToExcludeInHash.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, headersToExcludeInHash.getText()));
				}
			}

		});
		EditingUtils.setID(headersToExcludeInHash, EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash);
		EditingUtils.setEEFtype(headersToExcludeInHash, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createHeadersToExcludeInHashText

		// End of user code
		return parent;
	}

	
	protected Composite createResponseCodesText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Protocol.responseCodes, EsbMessages.CacheMediatorPropertiesEditionPart_ResponseCodesLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Protocol.responseCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, responseCodes.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Protocol.responseCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, responseCodes.getText()));
				}
			}

		});
		EditingUtils.setID(responseCodes, EsbViewsRepository.CacheMediator.Protocol.responseCodes);
		EditingUtils.setEEFtype(responseCodes, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Protocol.responseCodes, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createResponseCodesText

		// End of user code
		return parent;
	}

	
	protected Composite createEnableCacheControlCheckbox(Composite parent) {
		enableCacheControl = new Button(parent, SWT.CHECK);
		enableCacheControl.setText(getDescription(EsbViewsRepository.CacheMediator.Protocol.enableCacheControl, EsbMessages.CacheMediatorPropertiesEditionPart_EnableCacheControlLabel));
		enableCacheControl.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Protocol.enableCacheControl, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(enableCacheControl.getSelection())));
			}

		});
		GridData enableCacheControlData = new GridData(GridData.FILL_HORIZONTAL);
		enableCacheControlData.horizontalSpan = 2;
		enableCacheControl.setLayoutData(enableCacheControlData);
		EditingUtils.setID(enableCacheControl, EsbViewsRepository.CacheMediator.Protocol.enableCacheControl);
		EditingUtils.setEEFtype(enableCacheControl, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Protocol.enableCacheControl, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEnableCacheControlCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createIncludeAgeHeaderCheckbox(Composite parent) {
		includeAgeHeader = new Button(parent, SWT.CHECK);
		includeAgeHeader.setText(getDescription(EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader, EsbMessages.CacheMediatorPropertiesEditionPart_IncludeAgeHeaderLabel));
		includeAgeHeader.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(includeAgeHeader.getSelection())));
			}

		});
		GridData includeAgeHeaderData = new GridData(GridData.FILL_HORIZONTAL);
		includeAgeHeaderData.horizontalSpan = 2;
		includeAgeHeader.setLayoutData(includeAgeHeaderData);
		EditingUtils.setID(includeAgeHeader, EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader);
		EditingUtils.setEEFtype(includeAgeHeader, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIncludeAgeHeaderCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createHashGeneratorText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Protocol.hashGenerator, EsbMessages.CacheMediatorPropertiesEditionPart_HashGeneratorLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Protocol.hashGenerator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hashGenerator.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Protocol.hashGenerator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hashGenerator.getText()));
				}
			}

		});
		EditingUtils.setID(hashGenerator, EsbViewsRepository.CacheMediator.Protocol.hashGenerator);
		EditingUtils.setEEFtype(hashGenerator, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Protocol.hashGenerator, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createHashGeneratorText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createMiscGroup(Composite parent) {
		Group miscGroup = new Group(parent, SWT.NONE);
		miscGroup.setText(EsbMessages.CacheMediatorPropertiesEditionPart_MiscGroupLabel);
		GridData miscGroupData = new GridData(GridData.FILL_HORIZONTAL);
		miscGroupData.horizontalSpan = 3;
		miscGroup.setLayoutData(miscGroupData);
		GridLayout miscGroupLayout = new GridLayout();
		miscGroupLayout.numColumns = 3;
		miscGroup.setLayout(miscGroupLayout);
		return miscGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Misc.description, EsbMessages.CacheMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.CacheMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.CacheMediator.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Misc.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Implementation.maxEntryCount);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Protocol.responseCodes);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Protocol.enableCacheControl);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Protocol.hashGenerator);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Misc.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}






	// Start of user code for sequenceKey specific getters and setters implementation
	@Override
	public void setSequenceKey(RegistryKeyProperty registryKeyProperty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RegistryKeyProperty getSequenceKey() {
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
		return EsbMessages.CacheMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
