/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class APIResourcePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, APIResourcePropertiesEditionPart {

	protected ReferencesTable inSequenceInputConnectors;
	protected List<ViewerFilter> inSequenceInputConnectorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> inSequenceInputConnectorsFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer urlStyle;
	protected Text uriTemplate;
	protected Text urlMapping;
	protected Button allowGet;
	protected Button allowPost;
	protected Button allowPut;
	protected Button allowDelete;
	protected Button allowOptions;
	protected Button allowHead;
	protected Button allowPatch;
	protected EMFComboViewer inSequenceType;
	protected Text inSequenceName;
	protected EMFComboViewer outSequenceType;
	protected Text outSequenceName;
	protected EMFComboViewer faultSequenceType;
	protected Text faultSequenceName;
	protected EMFComboViewer protocol;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public APIResourcePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence aPIResourceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = aPIResourceStep.addStep(EsbViewsRepository.APIResource.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.urlStyle);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.uriTemplate);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.urlMapping);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.allowGet);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.allowPost);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.allowPut);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.allowDelete);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.allowOptions);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.allowHead);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.allowPatch);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.inSequenceType);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.inSequenceName);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.outSequenceType);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.outSequenceName);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.faultSequenceType);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.faultSequenceName);
		propertiesStep.addStep(EsbViewsRepository.APIResource.Properties.protocol);
		
		
		composer = new PartComposer(aPIResourceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.APIResource.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors) {
					return createInSequenceInputConnectorsAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.urlStyle) {
					return createUrlStyleEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.uriTemplate) {
					return createUriTemplateText(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.urlMapping) {
					return createUrlMappingText(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.allowGet) {
					return createAllowGetCheckbox(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.allowPost) {
					return createAllowPostCheckbox(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.allowPut) {
					return createAllowPutCheckbox(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.allowDelete) {
					return createAllowDeleteCheckbox(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.allowOptions) {
					return createAllowOptionsCheckbox(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.allowHead) {
					return createAllowHeadCheckbox(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.allowPatch) {
					return createAllowPatchCheckbox(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.inSequenceType) {
					return createInSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.inSequenceName) {
					return createInSequenceNameText(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.outSequenceType) {
					return createOutSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.outSequenceName) {
					return createOutSequenceNameText(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.faultSequenceType) {
					return createFaultSequenceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.faultSequenceName) {
					return createFaultSequenceNameText(parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.protocol) {
					return createProtocolEMFComboViewer(parent);
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
		propertiesGroup.setText(EsbMessages.APIResourcePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createInSequenceInputConnectorsAdvancedTableComposition(Composite parent) {
		this.inSequenceInputConnectors = new ReferencesTable(getDescription(EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, EsbMessages.APIResourcePropertiesEditionPart_InSequenceInputConnectorsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				inSequenceInputConnectors.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				inSequenceInputConnectors.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				inSequenceInputConnectors.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				inSequenceInputConnectors.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.inSequenceInputConnectorsFilters) {
			this.inSequenceInputConnectors.addFilter(filter);
		}
		this.inSequenceInputConnectors.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, EsbViewsRepository.SWT_KIND));
		this.inSequenceInputConnectors.createControls(parent);
		this.inSequenceInputConnectors.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData inSequenceInputConnectorsData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceInputConnectorsData.horizontalSpan = 3;
		this.inSequenceInputConnectors.setLayoutData(inSequenceInputConnectorsData);
		this.inSequenceInputConnectors.setLowerBound(0);
		this.inSequenceInputConnectors.setUpperBound(-1);
		inSequenceInputConnectors.setID(EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors);
		inSequenceInputConnectors.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createInSequenceInputConnectorsAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createUrlStyleEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.APIResource.Properties.urlStyle, EsbMessages.APIResourcePropertiesEditionPart_UrlStyleLabel);
		urlStyle = new EMFComboViewer(parent);
		urlStyle.setContentProvider(new ArrayContentProvider());
		urlStyle.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData urlStyleData = new GridData(GridData.FILL_HORIZONTAL);
		urlStyle.getCombo().setLayoutData(urlStyleData);
		urlStyle.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.urlStyle, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getUrlStyle()));
			}

		});
		urlStyle.setID(EsbViewsRepository.APIResource.Properties.urlStyle);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.urlStyle, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createUrlStyleEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createUriTemplateText(Composite parent) {
		createDescription(parent, EsbViewsRepository.APIResource.Properties.uriTemplate, EsbMessages.APIResourcePropertiesEditionPart_UriTemplateLabel);
		uriTemplate = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData uriTemplateData = new GridData(GridData.FILL_HORIZONTAL);
		uriTemplate.setLayoutData(uriTemplateData);
		uriTemplate.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.uriTemplate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, uriTemplate.getText()));
			}

		});
		uriTemplate.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.uriTemplate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, uriTemplate.getText()));
				}
			}

		});
		EditingUtils.setID(uriTemplate, EsbViewsRepository.APIResource.Properties.uriTemplate);
		EditingUtils.setEEFtype(uriTemplate, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.uriTemplate, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createUriTemplateText

		// End of user code
		return parent;
	}

	
	protected Composite createUrlMappingText(Composite parent) {
		createDescription(parent, EsbViewsRepository.APIResource.Properties.urlMapping, EsbMessages.APIResourcePropertiesEditionPart_UrlMappingLabel);
		urlMapping = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData urlMappingData = new GridData(GridData.FILL_HORIZONTAL);
		urlMapping.setLayoutData(urlMappingData);
		urlMapping.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.urlMapping, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, urlMapping.getText()));
			}

		});
		urlMapping.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.urlMapping, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, urlMapping.getText()));
				}
			}

		});
		EditingUtils.setID(urlMapping, EsbViewsRepository.APIResource.Properties.urlMapping);
		EditingUtils.setEEFtype(urlMapping, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.urlMapping, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createUrlMappingText

		// End of user code
		return parent;
	}

	
	protected Composite createAllowGetCheckbox(Composite parent) {
		allowGet = new Button(parent, SWT.CHECK);
		allowGet.setText(getDescription(EsbViewsRepository.APIResource.Properties.allowGet, EsbMessages.APIResourcePropertiesEditionPart_AllowGetLabel));
		allowGet.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.allowGet, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowGet.getSelection())));
			}

		});
		GridData allowGetData = new GridData(GridData.FILL_HORIZONTAL);
		allowGetData.horizontalSpan = 2;
		allowGet.setLayoutData(allowGetData);
		EditingUtils.setID(allowGet, EsbViewsRepository.APIResource.Properties.allowGet);
		EditingUtils.setEEFtype(allowGet, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.allowGet, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowGetCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowPostCheckbox(Composite parent) {
		allowPost = new Button(parent, SWT.CHECK);
		allowPost.setText(getDescription(EsbViewsRepository.APIResource.Properties.allowPost, EsbMessages.APIResourcePropertiesEditionPart_AllowPostLabel));
		allowPost.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.allowPost, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowPost.getSelection())));
			}

		});
		GridData allowPostData = new GridData(GridData.FILL_HORIZONTAL);
		allowPostData.horizontalSpan = 2;
		allowPost.setLayoutData(allowPostData);
		EditingUtils.setID(allowPost, EsbViewsRepository.APIResource.Properties.allowPost);
		EditingUtils.setEEFtype(allowPost, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.allowPost, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowPostCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowPutCheckbox(Composite parent) {
		allowPut = new Button(parent, SWT.CHECK);
		allowPut.setText(getDescription(EsbViewsRepository.APIResource.Properties.allowPut, EsbMessages.APIResourcePropertiesEditionPart_AllowPutLabel));
		allowPut.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.allowPut, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowPut.getSelection())));
			}

		});
		GridData allowPutData = new GridData(GridData.FILL_HORIZONTAL);
		allowPutData.horizontalSpan = 2;
		allowPut.setLayoutData(allowPutData);
		EditingUtils.setID(allowPut, EsbViewsRepository.APIResource.Properties.allowPut);
		EditingUtils.setEEFtype(allowPut, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.allowPut, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowPutCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowDeleteCheckbox(Composite parent) {
		allowDelete = new Button(parent, SWT.CHECK);
		allowDelete.setText(getDescription(EsbViewsRepository.APIResource.Properties.allowDelete, EsbMessages.APIResourcePropertiesEditionPart_AllowDeleteLabel));
		allowDelete.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.allowDelete, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowDelete.getSelection())));
			}

		});
		GridData allowDeleteData = new GridData(GridData.FILL_HORIZONTAL);
		allowDeleteData.horizontalSpan = 2;
		allowDelete.setLayoutData(allowDeleteData);
		EditingUtils.setID(allowDelete, EsbViewsRepository.APIResource.Properties.allowDelete);
		EditingUtils.setEEFtype(allowDelete, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.allowDelete, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowDeleteCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowOptionsCheckbox(Composite parent) {
		allowOptions = new Button(parent, SWT.CHECK);
		allowOptions.setText(getDescription(EsbViewsRepository.APIResource.Properties.allowOptions, EsbMessages.APIResourcePropertiesEditionPart_AllowOptionsLabel));
		allowOptions.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.allowOptions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowOptions.getSelection())));
			}

		});
		GridData allowOptionsData = new GridData(GridData.FILL_HORIZONTAL);
		allowOptionsData.horizontalSpan = 2;
		allowOptions.setLayoutData(allowOptionsData);
		EditingUtils.setID(allowOptions, EsbViewsRepository.APIResource.Properties.allowOptions);
		EditingUtils.setEEFtype(allowOptions, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.allowOptions, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowOptionsCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowHeadCheckbox(Composite parent) {
		allowHead = new Button(parent, SWT.CHECK);
		allowHead.setText(getDescription(EsbViewsRepository.APIResource.Properties.allowHead, EsbMessages.APIResourcePropertiesEditionPart_AllowHeadLabel));
		allowHead.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.allowHead, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowHead.getSelection())));
			}

		});
		GridData allowHeadData = new GridData(GridData.FILL_HORIZONTAL);
		allowHeadData.horizontalSpan = 2;
		allowHead.setLayoutData(allowHeadData);
		EditingUtils.setID(allowHead, EsbViewsRepository.APIResource.Properties.allowHead);
		EditingUtils.setEEFtype(allowHead, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.allowHead, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowHeadCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowPatchCheckbox(Composite parent) {
		allowPatch = new Button(parent, SWT.CHECK);
		allowPatch.setText(getDescription(EsbViewsRepository.APIResource.Properties.allowPatch, EsbMessages.APIResourcePropertiesEditionPart_AllowPatchLabel));
		allowPatch.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.allowPatch, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowPatch.getSelection())));
			}

		});
		GridData allowPatchData = new GridData(GridData.FILL_HORIZONTAL);
		allowPatchData.horizontalSpan = 2;
		allowPatch.setLayoutData(allowPatchData);
		EditingUtils.setID(allowPatch, EsbViewsRepository.APIResource.Properties.allowPatch);
		EditingUtils.setEEFtype(allowPatch, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.allowPatch, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowPatchCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createInSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.APIResource.Properties.inSequenceType, EsbMessages.APIResourcePropertiesEditionPart_InSequenceTypeLabel);
		inSequenceType = new EMFComboViewer(parent);
		inSequenceType.setContentProvider(new ArrayContentProvider());
		inSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData inSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceType.getCombo().setLayoutData(inSequenceTypeData);
		inSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.inSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInSequenceType()));
			}

		});
		inSequenceType.setID(EsbViewsRepository.APIResource.Properties.inSequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.inSequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createInSequenceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.APIResource.Properties.inSequenceName, EsbMessages.APIResourcePropertiesEditionPart_InSequenceNameLabel);
		inSequenceName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData inSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceName.setLayoutData(inSequenceNameData);
		inSequenceName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.inSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inSequenceName.getText()));
			}

		});
		inSequenceName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.inSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inSequenceName.getText()));
				}
			}

		});
		EditingUtils.setID(inSequenceName, EsbViewsRepository.APIResource.Properties.inSequenceName);
		EditingUtils.setEEFtype(inSequenceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.inSequenceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInSequenceNameText

		// End of user code
		return parent;
	}

	
	protected Composite createOutSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.APIResource.Properties.outSequenceType, EsbMessages.APIResourcePropertiesEditionPart_OutSequenceTypeLabel);
		outSequenceType = new EMFComboViewer(parent);
		outSequenceType.setContentProvider(new ArrayContentProvider());
		outSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData outSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		outSequenceType.getCombo().setLayoutData(outSequenceTypeData);
		outSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.outSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutSequenceType()));
			}

		});
		outSequenceType.setID(EsbViewsRepository.APIResource.Properties.outSequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.outSequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOutSequenceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.APIResource.Properties.outSequenceName, EsbMessages.APIResourcePropertiesEditionPart_OutSequenceNameLabel);
		outSequenceName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData outSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		outSequenceName.setLayoutData(outSequenceNameData);
		outSequenceName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.outSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outSequenceName.getText()));
			}

		});
		outSequenceName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.outSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outSequenceName.getText()));
				}
			}

		});
		EditingUtils.setID(outSequenceName, EsbViewsRepository.APIResource.Properties.outSequenceName);
		EditingUtils.setEEFtype(outSequenceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.outSequenceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutSequenceNameText

		// End of user code
		return parent;
	}

	
	protected Composite createFaultSequenceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.APIResource.Properties.faultSequenceType, EsbMessages.APIResourcePropertiesEditionPart_FaultSequenceTypeLabel);
		faultSequenceType = new EMFComboViewer(parent);
		faultSequenceType.setContentProvider(new ArrayContentProvider());
		faultSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultSequenceType.getCombo().setLayoutData(faultSequenceTypeData);
		faultSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.faultSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultSequenceType()));
			}

		});
		faultSequenceType.setID(EsbViewsRepository.APIResource.Properties.faultSequenceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.faultSequenceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createFaultSequenceNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.APIResource.Properties.faultSequenceName, EsbMessages.APIResourcePropertiesEditionPart_FaultSequenceNameLabel);
		faultSequenceName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData faultSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		faultSequenceName.setLayoutData(faultSequenceNameData);
		faultSequenceName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.faultSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultSequenceName.getText()));
			}

		});
		faultSequenceName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.faultSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultSequenceName.getText()));
				}
			}

		});
		EditingUtils.setID(faultSequenceName, EsbViewsRepository.APIResource.Properties.faultSequenceName);
		EditingUtils.setEEFtype(faultSequenceName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.faultSequenceName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultSequenceNameText

		// End of user code
		return parent;
	}

	
	protected Composite createProtocolEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.APIResource.Properties.protocol, EsbMessages.APIResourcePropertiesEditionPart_ProtocolLabel);
		protocol = new EMFComboViewer(parent);
		protocol.setContentProvider(new ArrayContentProvider());
		protocol.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData protocolData = new GridData(GridData.FILL_HORIZONTAL);
		protocol.getCombo().setLayoutData(protocolData);
		protocol.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartImpl.this, EsbViewsRepository.APIResource.Properties.protocol, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getProtocol()));
			}

		});
		protocol.setID(EsbViewsRepository.APIResource.Properties.protocol);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.protocol, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createProtocolEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initInSequenceInputConnectors(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initInSequenceInputConnectors(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		inSequenceInputConnectors.setContentProvider(contentProvider);
		inSequenceInputConnectors.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors);
		if (eefElementEditorReadOnlyState && inSequenceInputConnectors.isEnabled()) {
			inSequenceInputConnectors.setEnabled(false);
			inSequenceInputConnectors.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inSequenceInputConnectors.isEnabled()) {
			inSequenceInputConnectors.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#updateInSequenceInputConnectors()
	 * 
	 */
	public void updateInSequenceInputConnectors() {
	inSequenceInputConnectors.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#addFilterInSequenceInputConnectors(ViewerFilter filter)
	 * 
	 */
	public void addFilterToInSequenceInputConnectors(ViewerFilter filter) {
		inSequenceInputConnectorsFilters.add(filter);
		if (this.inSequenceInputConnectors != null) {
			this.inSequenceInputConnectors.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#addBusinessFilterInSequenceInputConnectors(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToInSequenceInputConnectors(ViewerFilter filter) {
		inSequenceInputConnectorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#isContainedInInSequenceInputConnectorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInInSequenceInputConnectorsTable(EObject element) {
		return ((ReferencesTableSettings)inSequenceInputConnectors.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getUrlStyle()
	 * 
	 */
	public Enumerator getUrlStyle() {
		Enumerator selection = (Enumerator) ((StructuredSelection) urlStyle.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initUrlStyle(Object input, Enumerator current)
	 */
	public void initUrlStyle(Object input, Enumerator current) {
		urlStyle.setInput(input);
		urlStyle.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.urlStyle);
		if (eefElementEditorReadOnlyState && urlStyle.isEnabled()) {
			urlStyle.setEnabled(false);
			urlStyle.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !urlStyle.isEnabled()) {
			urlStyle.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setUrlStyle(Enumerator newValue)
	 * 
	 */
	public void setUrlStyle(Enumerator newValue) {
		urlStyle.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.urlStyle);
		if (eefElementEditorReadOnlyState && urlStyle.isEnabled()) {
			urlStyle.setEnabled(false);
			urlStyle.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !urlStyle.isEnabled()) {
			urlStyle.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getUriTemplate()
	 * 
	 */
	public String getUriTemplate() {
		return uriTemplate.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setUriTemplate(String newValue)
	 * 
	 */
	public void setUriTemplate(String newValue) {
		if (newValue != null) {
			uriTemplate.setText(newValue);
		} else {
			uriTemplate.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.uriTemplate);
		if (eefElementEditorReadOnlyState && uriTemplate.isEnabled()) {
			uriTemplate.setEnabled(false);
			uriTemplate.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !uriTemplate.isEnabled()) {
			uriTemplate.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getUrlMapping()
	 * 
	 */
	public String getUrlMapping() {
		return urlMapping.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setUrlMapping(String newValue)
	 * 
	 */
	public void setUrlMapping(String newValue) {
		if (newValue != null) {
			urlMapping.setText(newValue);
		} else {
			urlMapping.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.urlMapping);
		if (eefElementEditorReadOnlyState && urlMapping.isEnabled()) {
			urlMapping.setEnabled(false);
			urlMapping.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !urlMapping.isEnabled()) {
			urlMapping.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowGet()
	 * 
	 */
	public Boolean getAllowGet() {
		return Boolean.valueOf(allowGet.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowGet(Boolean newValue)
	 * 
	 */
	public void setAllowGet(Boolean newValue) {
		if (newValue != null) {
			allowGet.setSelection(newValue.booleanValue());
		} else {
			allowGet.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.allowGet);
		if (eefElementEditorReadOnlyState && allowGet.isEnabled()) {
			allowGet.setEnabled(false);
			allowGet.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !allowGet.isEnabled()) {
			allowGet.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowPost()
	 * 
	 */
	public Boolean getAllowPost() {
		return Boolean.valueOf(allowPost.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowPost(Boolean newValue)
	 * 
	 */
	public void setAllowPost(Boolean newValue) {
		if (newValue != null) {
			allowPost.setSelection(newValue.booleanValue());
		} else {
			allowPost.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.allowPost);
		if (eefElementEditorReadOnlyState && allowPost.isEnabled()) {
			allowPost.setEnabled(false);
			allowPost.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !allowPost.isEnabled()) {
			allowPost.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowPut()
	 * 
	 */
	public Boolean getAllowPut() {
		return Boolean.valueOf(allowPut.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowPut(Boolean newValue)
	 * 
	 */
	public void setAllowPut(Boolean newValue) {
		if (newValue != null) {
			allowPut.setSelection(newValue.booleanValue());
		} else {
			allowPut.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.allowPut);
		if (eefElementEditorReadOnlyState && allowPut.isEnabled()) {
			allowPut.setEnabled(false);
			allowPut.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !allowPut.isEnabled()) {
			allowPut.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowDelete()
	 * 
	 */
	public Boolean getAllowDelete() {
		return Boolean.valueOf(allowDelete.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowDelete(Boolean newValue)
	 * 
	 */
	public void setAllowDelete(Boolean newValue) {
		if (newValue != null) {
			allowDelete.setSelection(newValue.booleanValue());
		} else {
			allowDelete.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.allowDelete);
		if (eefElementEditorReadOnlyState && allowDelete.isEnabled()) {
			allowDelete.setEnabled(false);
			allowDelete.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !allowDelete.isEnabled()) {
			allowDelete.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowOptions()
	 * 
	 */
	public Boolean getAllowOptions() {
		return Boolean.valueOf(allowOptions.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowOptions(Boolean newValue)
	 * 
	 */
	public void setAllowOptions(Boolean newValue) {
		if (newValue != null) {
			allowOptions.setSelection(newValue.booleanValue());
		} else {
			allowOptions.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.allowOptions);
		if (eefElementEditorReadOnlyState && allowOptions.isEnabled()) {
			allowOptions.setEnabled(false);
			allowOptions.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !allowOptions.isEnabled()) {
			allowOptions.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowHead()
	 * 
	 */
	public Boolean getAllowHead() {
		return Boolean.valueOf(allowHead.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowHead(Boolean newValue)
	 * 
	 */
	public void setAllowHead(Boolean newValue) {
		if (newValue != null) {
			allowHead.setSelection(newValue.booleanValue());
		} else {
			allowHead.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.allowHead);
		if (eefElementEditorReadOnlyState && allowHead.isEnabled()) {
			allowHead.setEnabled(false);
			allowHead.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !allowHead.isEnabled()) {
			allowHead.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowPatch()
	 * 
	 */
	public Boolean getAllowPatch() {
		return Boolean.valueOf(allowPatch.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowPatch(Boolean newValue)
	 * 
	 */
	public void setAllowPatch(Boolean newValue) {
		if (newValue != null) {
			allowPatch.setSelection(newValue.booleanValue());
		} else {
			allowPatch.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.allowPatch);
		if (eefElementEditorReadOnlyState && allowPatch.isEnabled()) {
			allowPatch.setEnabled(false);
			allowPatch.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !allowPatch.isEnabled()) {
			allowPatch.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getInSequenceType()
	 * 
	 */
	public Enumerator getInSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initInSequenceType(Object input, Enumerator current)
	 */
	public void initInSequenceType(Object input, Enumerator current) {
		inSequenceType.setInput(input);
		inSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.inSequenceType);
		if (eefElementEditorReadOnlyState && inSequenceType.isEnabled()) {
			inSequenceType.setEnabled(false);
			inSequenceType.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inSequenceType.isEnabled()) {
			inSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setInSequenceType(Enumerator newValue)
	 * 
	 */
	public void setInSequenceType(Enumerator newValue) {
		inSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.inSequenceType);
		if (eefElementEditorReadOnlyState && inSequenceType.isEnabled()) {
			inSequenceType.setEnabled(false);
			inSequenceType.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inSequenceType.isEnabled()) {
			inSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getInSequenceName()
	 * 
	 */
	public String getInSequenceName() {
		return inSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setInSequenceName(String newValue)
	 * 
	 */
	public void setInSequenceName(String newValue) {
		if (newValue != null) {
			inSequenceName.setText(newValue);
		} else {
			inSequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.inSequenceName);
		if (eefElementEditorReadOnlyState && inSequenceName.isEnabled()) {
			inSequenceName.setEnabled(false);
			inSequenceName.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inSequenceName.isEnabled()) {
			inSequenceName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getOutSequenceType()
	 * 
	 */
	public Enumerator getOutSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initOutSequenceType(Object input, Enumerator current)
	 */
	public void initOutSequenceType(Object input, Enumerator current) {
		outSequenceType.setInput(input);
		outSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.outSequenceType);
		if (eefElementEditorReadOnlyState && outSequenceType.isEnabled()) {
			outSequenceType.setEnabled(false);
			outSequenceType.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outSequenceType.isEnabled()) {
			outSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setOutSequenceType(Enumerator newValue)
	 * 
	 */
	public void setOutSequenceType(Enumerator newValue) {
		outSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.outSequenceType);
		if (eefElementEditorReadOnlyState && outSequenceType.isEnabled()) {
			outSequenceType.setEnabled(false);
			outSequenceType.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outSequenceType.isEnabled()) {
			outSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getOutSequenceName()
	 * 
	 */
	public String getOutSequenceName() {
		return outSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setOutSequenceName(String newValue)
	 * 
	 */
	public void setOutSequenceName(String newValue) {
		if (newValue != null) {
			outSequenceName.setText(newValue);
		} else {
			outSequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.outSequenceName);
		if (eefElementEditorReadOnlyState && outSequenceName.isEnabled()) {
			outSequenceName.setEnabled(false);
			outSequenceName.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outSequenceName.isEnabled()) {
			outSequenceName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getFaultSequenceType()
	 * 
	 */
	public Enumerator getFaultSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initFaultSequenceType(Object input, Enumerator current)
	 */
	public void initFaultSequenceType(Object input, Enumerator current) {
		faultSequenceType.setInput(input);
		faultSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.faultSequenceType);
		if (eefElementEditorReadOnlyState && faultSequenceType.isEnabled()) {
			faultSequenceType.setEnabled(false);
			faultSequenceType.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultSequenceType.isEnabled()) {
			faultSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setFaultSequenceType(Enumerator newValue)
	 * 
	 */
	public void setFaultSequenceType(Enumerator newValue) {
		faultSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.faultSequenceType);
		if (eefElementEditorReadOnlyState && faultSequenceType.isEnabled()) {
			faultSequenceType.setEnabled(false);
			faultSequenceType.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultSequenceType.isEnabled()) {
			faultSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getFaultSequenceName()
	 * 
	 */
	public String getFaultSequenceName() {
		return faultSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setFaultSequenceName(String newValue)
	 * 
	 */
	public void setFaultSequenceName(String newValue) {
		if (newValue != null) {
			faultSequenceName.setText(newValue);
		} else {
			faultSequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.faultSequenceName);
		if (eefElementEditorReadOnlyState && faultSequenceName.isEnabled()) {
			faultSequenceName.setEnabled(false);
			faultSequenceName.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultSequenceName.isEnabled()) {
			faultSequenceName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getProtocol()
	 * 
	 */
	public Enumerator getProtocol() {
		Enumerator selection = (Enumerator) ((StructuredSelection) protocol.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initProtocol(Object input, Enumerator current)
	 */
	public void initProtocol(Object input, Enumerator current) {
		protocol.setInput(input);
		protocol.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.protocol);
		if (eefElementEditorReadOnlyState && protocol.isEnabled()) {
			protocol.setEnabled(false);
			protocol.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !protocol.isEnabled()) {
			protocol.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setProtocol(Enumerator newValue)
	 * 
	 */
	public void setProtocol(Enumerator newValue) {
		protocol.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Properties.protocol);
		if (eefElementEditorReadOnlyState && protocol.isEnabled()) {
			protocol.setEnabled(false);
			protocol.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !protocol.isEnabled()) {
			protocol.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.APIResource_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
