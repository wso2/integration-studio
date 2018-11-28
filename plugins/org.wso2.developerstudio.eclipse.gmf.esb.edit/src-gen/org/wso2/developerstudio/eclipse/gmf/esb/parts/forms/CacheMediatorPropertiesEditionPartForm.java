/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.util.EcoreAdapterFactory;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

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
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CacheMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, CacheMediatorPropertiesEditionPart {

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
	 * For {@link ISection} use only.
	 */
	public CacheMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CacheMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
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
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.cacheProtocolType) {
					return createCacheProtocolTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.cacheType) {
					return createCacheTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.hashGenerator) {
					return createHashGeneratorText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.cacheTimeout) {
					return createCacheTimeoutText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.maxMessageSize) {
					return createMaxMessageSizeText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods) {
					return createCacheProtocolMethodsText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.maxEntryCount) {
					return createMaxEntryCountText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.sequenceType) {
					return createSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash) {
					return createHeadersToExcludeInHashText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.responseCodes) {
					return createResponseCodesText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.enableCacheControl) {
					return createEnableCacheControlCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CacheMediator.Properties.includeAgeHeader) {
					return createIncludeAgeHeaderCheckbox(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.CacheMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.description, EsbMessages.CacheMediatorPropertiesEditionPart_DescriptionLabel);
		description = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		description.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CacheMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CacheMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CacheMediator.Properties.description,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, description.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		description.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.CacheMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.CacheMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CacheMediator.Properties.commentsList, EsbMessages.CacheMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
		GridData editCommentsListData = new GridData();
		editCommentsList.setLayoutData(editCommentsListData);
		editCommentsList.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
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

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CacheMediator.Properties.reverse, EsbMessages.CacheMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.CacheMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createCacheProtocolTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.cacheProtocolType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCacheProtocolType()));
			}

		});
		cacheProtocolType.setID(EsbViewsRepository.CacheMediator.Properties.cacheProtocolType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.cacheProtocolType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheProtocolTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createCacheTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.cacheType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCacheType()));
			}

		});
		cacheType.setID(EsbViewsRepository.CacheMediator.Properties.cacheType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.cacheType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createHashGeneratorText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.hashGenerator, EsbMessages.CacheMediatorPropertiesEditionPart_HashGeneratorLabel);
		hashGenerator = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		hashGenerator.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData hashGeneratorData = new GridData(GridData.FILL_HORIZONTAL);
		hashGenerator.setLayoutData(hashGeneratorData);
		hashGenerator.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CacheMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CacheMediator.Properties.hashGenerator,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hashGenerator.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CacheMediator.Properties.hashGenerator,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, hashGenerator.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		hashGenerator.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.hashGenerator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hashGenerator.getText()));
				}
			}
		});
		EditingUtils.setID(hashGenerator, EsbViewsRepository.CacheMediator.Properties.hashGenerator);
		EditingUtils.setEEFtype(hashGenerator, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.hashGenerator, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createHashGeneratorText

		// End of user code
		return parent;
	}

	
	protected Composite createCacheTimeoutText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.cacheTimeout, EsbMessages.CacheMediatorPropertiesEditionPart_CacheTimeoutLabel);
		cacheTimeout = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		cacheTimeout.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData cacheTimeoutData = new GridData(GridData.FILL_HORIZONTAL);
		cacheTimeout.setLayoutData(cacheTimeoutData);
		cacheTimeout.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CacheMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CacheMediator.Properties.cacheTimeout,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheTimeout.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CacheMediator.Properties.cacheTimeout,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, cacheTimeout.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		cacheTimeout.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.cacheTimeout, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheTimeout.getText()));
				}
			}
		});
		EditingUtils.setID(cacheTimeout, EsbViewsRepository.CacheMediator.Properties.cacheTimeout);
		EditingUtils.setEEFtype(cacheTimeout, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.cacheTimeout, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheTimeoutText

		// End of user code
		return parent;
	}

	
	protected Composite createMaxMessageSizeText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.maxMessageSize, EsbMessages.CacheMediatorPropertiesEditionPart_MaxMessageSizeLabel);
		maxMessageSize = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		maxMessageSize.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData maxMessageSizeData = new GridData(GridData.FILL_HORIZONTAL);
		maxMessageSize.setLayoutData(maxMessageSizeData);
		maxMessageSize.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CacheMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CacheMediator.Properties.maxMessageSize,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxMessageSize.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CacheMediator.Properties.maxMessageSize,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, maxMessageSize.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		maxMessageSize.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.maxMessageSize, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxMessageSize.getText()));
				}
			}
		});
		EditingUtils.setID(maxMessageSize, EsbViewsRepository.CacheMediator.Properties.maxMessageSize);
		EditingUtils.setEEFtype(maxMessageSize, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.maxMessageSize, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxMessageSizeText

		// End of user code
		return parent;
	}

	
	protected Composite createCacheProtocolMethodsText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods, EsbMessages.CacheMediatorPropertiesEditionPart_CacheProtocolMethodsLabel);
		cacheProtocolMethods = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		cacheProtocolMethods.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData cacheProtocolMethodsData = new GridData(GridData.FILL_HORIZONTAL);
		cacheProtocolMethods.setLayoutData(cacheProtocolMethodsData);
		cacheProtocolMethods.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CacheMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheProtocolMethods.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, cacheProtocolMethods.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		cacheProtocolMethods.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cacheProtocolMethods.getText()));
				}
			}
		});
		EditingUtils.setID(cacheProtocolMethods, EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods);
		EditingUtils.setEEFtype(cacheProtocolMethods, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.cacheProtocolMethods, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheProtocolMethodsText

		// End of user code
		return parent;
	}

	
	protected Composite createMaxEntryCountText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.maxEntryCount, EsbMessages.CacheMediatorPropertiesEditionPart_MaxEntryCountLabel);
		maxEntryCount = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		maxEntryCount.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData maxEntryCountData = new GridData(GridData.FILL_HORIZONTAL);
		maxEntryCount.setLayoutData(maxEntryCountData);
		maxEntryCount.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CacheMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CacheMediator.Properties.maxEntryCount,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxEntryCount.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CacheMediator.Properties.maxEntryCount,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, maxEntryCount.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		maxEntryCount.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.maxEntryCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxEntryCount.getText()));
				}
			}
		});
		EditingUtils.setID(maxEntryCount, EsbViewsRepository.CacheMediator.Properties.maxEntryCount);
		EditingUtils.setEEFtype(maxEntryCount, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.maxEntryCount, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxEntryCountText

		// End of user code
		return parent;
	}

	
	protected Composite createSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.sequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceType()));
			}

		});
		sequenceType.setID(EsbViewsRepository.CacheMediator.Properties.sequenceType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.sequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createHeadersToExcludeInHashText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash, EsbMessages.CacheMediatorPropertiesEditionPart_HeadersToExcludeInHashLabel);
		headersToExcludeInHash = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		headersToExcludeInHash.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData headersToExcludeInHashData = new GridData(GridData.FILL_HORIZONTAL);
		headersToExcludeInHash.setLayoutData(headersToExcludeInHashData);
		headersToExcludeInHash.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CacheMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, headersToExcludeInHash.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, headersToExcludeInHash.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		headersToExcludeInHash.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, headersToExcludeInHash.getText()));
				}
			}
		});
		EditingUtils.setID(headersToExcludeInHash, EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash);
		EditingUtils.setEEFtype(headersToExcludeInHash, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.headersToExcludeInHash, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createHeadersToExcludeInHashText

		// End of user code
		return parent;
	}

	
	protected Composite createResponseCodesText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CacheMediator.Properties.responseCodes, EsbMessages.CacheMediatorPropertiesEditionPart_ResponseCodesLabel);
		responseCodes = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		responseCodes.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData responseCodesData = new GridData(GridData.FILL_HORIZONTAL);
		responseCodes.setLayoutData(responseCodesData);
		responseCodes.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CacheMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CacheMediator.Properties.responseCodes,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, responseCodes.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CacheMediator.Properties.responseCodes,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, responseCodes.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CacheMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		responseCodes.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.responseCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, responseCodes.getText()));
				}
			}
		});
		EditingUtils.setID(responseCodes, EsbViewsRepository.CacheMediator.Properties.responseCodes);
		EditingUtils.setEEFtype(responseCodes, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.responseCodes, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResponseCodesText

		// End of user code
		return parent;
	}

	
	protected Composite createEnableCacheControlCheckbox(FormToolkit widgetFactory, Composite parent) {
		enableCacheControl = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CacheMediator.Properties.enableCacheControl, EsbMessages.CacheMediatorPropertiesEditionPart_EnableCacheControlLabel), SWT.CHECK);
		enableCacheControl.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.enableCacheControl, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(enableCacheControl.getSelection())));
			}

		});
		GridData enableCacheControlData = new GridData(GridData.FILL_HORIZONTAL);
		enableCacheControlData.horizontalSpan = 2;
		enableCacheControl.setLayoutData(enableCacheControlData);
		EditingUtils.setID(enableCacheControl, EsbViewsRepository.CacheMediator.Properties.enableCacheControl);
		EditingUtils.setEEFtype(enableCacheControl, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.enableCacheControl, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEnableCacheControlCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createIncludeAgeHeaderCheckbox(FormToolkit widgetFactory, Composite parent) {
		includeAgeHeader = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CacheMediator.Properties.includeAgeHeader, EsbMessages.CacheMediatorPropertiesEditionPart_IncludeAgeHeaderLabel), SWT.CHECK);
		includeAgeHeader.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.includeAgeHeader, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(includeAgeHeader.getSelection())));
			}

		});
		GridData includeAgeHeaderData = new GridData(GridData.FILL_HORIZONTAL);
		includeAgeHeaderData.horizontalSpan = 2;
		includeAgeHeader.setLayoutData(includeAgeHeaderData);
		EditingUtils.setID(includeAgeHeader, EsbViewsRepository.CacheMediator.Properties.includeAgeHeader);
		EditingUtils.setEEFtype(includeAgeHeader, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.includeAgeHeader, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
