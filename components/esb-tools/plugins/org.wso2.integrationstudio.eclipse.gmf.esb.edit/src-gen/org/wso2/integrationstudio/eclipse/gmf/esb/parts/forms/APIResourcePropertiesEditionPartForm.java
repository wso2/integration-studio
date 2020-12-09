/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

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

import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

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
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.eclipse.gmf.esb.ApiResourceUrlStyle;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.SequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class APIResourcePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, APIResourcePropertiesEditionPart {

	protected ReferencesTable inSequenceInputConnectors;
	protected List<ViewerFilter> inSequenceInputConnectorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> inSequenceInputConnectorsFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer urlStyle;
	protected Text uriTemplate;
	protected Text urlMapping;
	protected EMFComboViewer protocol;
	protected Button allowGet;
	protected Button allowPost;
	protected Button allowPut;
	protected Button allowDelete;
	protected Button allowOptions;
	protected Button allowHead;
	protected Button allowPatch;
	protected EMFComboViewer inSequenceType;
	protected Text inSequenceName;
	// Start of user code  for inSequenceKey widgets declarations
	protected RegistryKeyProperty inSequenceKey;
	protected Text inSequenceKeyText;
	
	// End of user code

	protected EMFComboViewer outSequenceType;
	protected Text outSequenceName;
	// Start of user code  for outSequenceKey widgets declarations
	protected RegistryKeyProperty outSequenceKey;
	protected Text outSequenceKeyText;
	
	// End of user code

	protected EMFComboViewer faultSequenceType;
	protected Text faultSequenceName;
	// Start of user code  for faultSequenceKey widgets declarations
	protected RegistryKeyProperty faultSequenceKey;
	protected Text faultSequenceKeyText;
	
	protected Section propertiesSection;
	
	protected Composite basicGroup;
	protected Composite propertiesGroup;
	protected Composite inSequenceGroup;
	protected Composite outSequenceGroup;
	protected Composite faultSequenceGroup;
	
	protected Control[] inSequenceKeyElements;
	protected Control[] urlStyleElements;
	protected Control[] uriTemplateElements;
	protected Control[] outSequenceKeyElements;
	protected Control[] faultSequenceKeyElements;
	protected Control[] urlMappingElements;
	protected Control[] protocolElements;
	protected Control[] inSequenceTypeElements;
	protected Control[] inSequenceNameElements;
	protected Control[] outSequenceTypeElements;
	protected Control[] outSequenceNameElements;
	protected Control[] faultSequenceTypeElements;
	protected Control[] faultSquenceNameElements;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public APIResourcePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public APIResourcePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		Form form = widgetFactory.createForm(parent);
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return form;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence aPIResourceStep = new BindingCompositionSequence(propertiesEditionComponent);
		aPIResourceStep
			.addStep(EsbViewsRepository.APIResource.Properties.class)
			.addStep(EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors);
		
		CompositionStep basicStep = aPIResourceStep.addStep(EsbViewsRepository.APIResource.Basic.class);
		basicStep.addStep(EsbViewsRepository.APIResource.Basic.urlStyle);
		basicStep.addStep(EsbViewsRepository.APIResource.Basic.uriTemplate);
		basicStep.addStep(EsbViewsRepository.APIResource.Basic.urlMapping);
		basicStep.addStep(EsbViewsRepository.APIResource.Basic.protocol);
		
		CompositionStep methodsStep = aPIResourceStep.addStep(EsbViewsRepository.APIResource.Methods.class);
		methodsStep.addStep(EsbViewsRepository.APIResource.Methods.allowGet);
		methodsStep.addStep(EsbViewsRepository.APIResource.Methods.allowPost);
		methodsStep.addStep(EsbViewsRepository.APIResource.Methods.allowPut);
		methodsStep.addStep(EsbViewsRepository.APIResource.Methods.allowDelete);
		methodsStep.addStep(EsbViewsRepository.APIResource.Methods.allowOptions);
		methodsStep.addStep(EsbViewsRepository.APIResource.Methods.allowHead);
		methodsStep.addStep(EsbViewsRepository.APIResource.Methods.allowPatch);
		
		CompositionStep inSequenceStep = aPIResourceStep.addStep(EsbViewsRepository.APIResource.InSequence.class);
		inSequenceStep.addStep(EsbViewsRepository.APIResource.InSequence.inSequenceType);
		inSequenceStep.addStep(EsbViewsRepository.APIResource.InSequence.inSequenceName);
		inSequenceStep.addStep(EsbViewsRepository.APIResource.InSequence.inSequenceKey);
		
		CompositionStep outSequenceStep = aPIResourceStep.addStep(EsbViewsRepository.APIResource.OutSequence.class);
		outSequenceStep.addStep(EsbViewsRepository.APIResource.OutSequence.outSequenceType);
		outSequenceStep.addStep(EsbViewsRepository.APIResource.OutSequence.outSequenceName);
		outSequenceStep.addStep(EsbViewsRepository.APIResource.OutSequence.outSequenceKey);
		
		CompositionStep faultSequenceStep = aPIResourceStep.addStep(EsbViewsRepository.APIResource.FaultSequence.class);
		faultSequenceStep.addStep(EsbViewsRepository.APIResource.FaultSequence.faultSequenceType);
		faultSequenceStep.addStep(EsbViewsRepository.APIResource.FaultSequence.faultSequenceName);
		faultSequenceStep.addStep(EsbViewsRepository.APIResource.FaultSequence.faultSequenceKey);
		
		
		composer = new PartComposer(aPIResourceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.APIResource.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors) {
					return createInSequenceInputConnectorsTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Basic.class) {
					return createBasicGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Basic.urlStyle) {
					return createUrlStyleEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Basic.uriTemplate) {
					return createUriTemplateText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Basic.urlMapping) {
					return createUrlMappingText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Basic.protocol) {
					return createProtocolEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Methods.class) {
					return createMethodsGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Methods.allowGet) {
					return createAllowGetCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Methods.allowPost) {
					return createAllowPostCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Methods.allowPut) {
					return createAllowPutCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Methods.allowDelete) {
					return createAllowDeleteCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Methods.allowOptions) {
					return createAllowOptionsCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Methods.allowHead) {
					return createAllowHeadCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.Methods.allowPatch) {
					return createAllowPatchCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.InSequence.class) {
					return createInSequenceGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.InSequence.inSequenceType) {
					return createInSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.InSequence.inSequenceName) {
					return createInSequenceNameText(widgetFactory, parent);
				}
				// Start of user code for inSequenceKey addToPart creation
				if (key == EsbViewsRepository.APIResource.InSequence.inSequenceKey) {
				    return createInSequenceKey(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.APIResource.OutSequence.class) {
					return createOutSequenceGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.OutSequence.outSequenceType) {
					return createOutSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.OutSequence.outSequenceName) {
					return createOutSequenceNameText(widgetFactory, parent);
				}
				// Start of user code for outSequenceKey addToPart creation
				if (key == EsbViewsRepository.APIResource.OutSequence.outSequenceKey) {
				    return createOutSequenceKey(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.APIResource.FaultSequence.class) {
					return createFaultSequenceGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.FaultSequence.faultSequenceType) {
					return createFaultSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.APIResource.FaultSequence.faultSequenceName) {
					return createFaultSequenceNameText(widgetFactory, parent);
				}
				// Start of user code for faultSequenceKey addToPart creation
				if (key == EsbViewsRepository.APIResource.FaultSequence.faultSequenceKey) {
				    return createFaultSequenceKey(widgetFactory, parent);
				}
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}
	
	/**
     * @generated NOT
     */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.APIResourcePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createInSequenceInputConnectorsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.inSequenceInputConnectors = new ReferencesTable(getDescription(EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, EsbMessages.APIResourcePropertiesEditionPart_InSequenceInputConnectorsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				inSequenceInputConnectors.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				inSequenceInputConnectors.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				inSequenceInputConnectors.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				inSequenceInputConnectors.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.inSequenceInputConnectorsFilters) {
			this.inSequenceInputConnectors.addFilter(filter);
		}
		this.inSequenceInputConnectors.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, EsbViewsRepository.FORM_KIND));
		this.inSequenceInputConnectors.createControls(parent, widgetFactory);
		this.inSequenceInputConnectors.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createInSequenceInputConnectorsTableComposition

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createBasicGroup(FormToolkit widgetFactory, final Composite parent) {
		Section basicSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		basicSection.setText(EsbMessages.APIResourcePropertiesEditionPart_BasicGroupLabel);
		GridData basicSectionData = new GridData(GridData.FILL_HORIZONTAL);
		basicSectionData.horizontalSpan = 3;
		basicSection.setLayoutData(basicSectionData);
		basicGroup = widgetFactory.createComposite(basicSection);
		GridLayout basicGroupLayout = new GridLayout();
		basicGroupLayout.numColumns = 3;
		basicGroup.setLayout(basicGroupLayout);
		basicSection.setClient(basicGroup);
		return basicGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createUrlStyleEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control urlStyleLabel = createDescription(parent, EsbViewsRepository.APIResource.Basic.urlStyle, EsbMessages.APIResourcePropertiesEditionPart_UrlStyleLabel);
		urlStyle = new EMFComboViewer(parent);
		urlStyle.setContentProvider(new ArrayContentProvider());
		urlStyle.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData urlStyleData = new GridData(GridData.FILL_HORIZONTAL);
		urlStyle.getCombo().setLayoutData(urlStyleData);
                urlStyle.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		urlStyle.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			    if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Basic.urlStyle, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getUrlStyle()));
			    refresh();
			}

		});
		urlStyle.setID(EsbViewsRepository.APIResource.Basic.urlStyle);
		Control urlStyleHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Basic.urlStyle, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createUrlStyleEMFComboViewer
		urlStyleElements = new Control[] {urlStyleLabel, urlStyle.getCombo(), urlStyleHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createUriTemplateText(FormToolkit widgetFactory, Composite parent) {
		Control uriTemplateLabel = createDescription(parent, EsbViewsRepository.APIResource.Basic.uriTemplate, EsbMessages.APIResourcePropertiesEditionPart_UriTemplateLabel);
		uriTemplate = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		uriTemplate.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData uriTemplateData = new GridData(GridData.FILL_HORIZONTAL);
		uriTemplate.setLayoutData(uriTemplateData);
		uriTemplate.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							APIResourcePropertiesEditionPartForm.this,
							EsbViewsRepository.APIResource.Basic.uriTemplate,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, uriTemplate.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									APIResourcePropertiesEditionPartForm.this,
									EsbViewsRepository.APIResource.Basic.uriTemplate,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, uriTemplate.getText()));
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
									APIResourcePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		uriTemplate.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Basic.uriTemplate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, uriTemplate.getText()));
				}
			}
		});
		EditingUtils.setID(uriTemplate, EsbViewsRepository.APIResource.Basic.uriTemplate);
		EditingUtils.setEEFtype(uriTemplate, "eef::Text"); //$NON-NLS-1$
		Control uriTemplateHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Basic.uriTemplate, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createUriTemplateText
		uriTemplateElements = new Control[] {uriTemplateLabel, uriTemplate, uriTemplateHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createUrlMappingText(FormToolkit widgetFactory, Composite parent) {
		Control urlMappingLabel = createDescription(parent, EsbViewsRepository.APIResource.Basic.urlMapping, EsbMessages.APIResourcePropertiesEditionPart_UrlMappingLabel);
		urlMapping = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		urlMapping.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData urlMappingData = new GridData(GridData.FILL_HORIZONTAL);
		urlMapping.setLayoutData(urlMappingData);
		urlMapping.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							APIResourcePropertiesEditionPartForm.this,
							EsbViewsRepository.APIResource.Basic.urlMapping,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, urlMapping.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									APIResourcePropertiesEditionPartForm.this,
									EsbViewsRepository.APIResource.Basic.urlMapping,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, urlMapping.getText()));
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
									APIResourcePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		urlMapping.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Basic.urlMapping, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, urlMapping.getText()));
				}
			}
		});
		EditingUtils.setID(urlMapping, EsbViewsRepository.APIResource.Basic.urlMapping);
		EditingUtils.setEEFtype(urlMapping, "eef::Text"); //$NON-NLS-1$
		Control urlMappingHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Basic.urlMapping, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createUrlMappingText
		urlMappingElements = new Control[] {urlMappingLabel, urlMapping, urlMappingHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createProtocolEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control protocolLabel = createDescription(parent, EsbViewsRepository.APIResource.Basic.protocol, EsbMessages.APIResourcePropertiesEditionPart_ProtocolLabel);
		protocol = new EMFComboViewer(parent);
		protocol.setContentProvider(new ArrayContentProvider());
		protocol.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData protocolData = new GridData(GridData.FILL_HORIZONTAL);
		protocol.getCombo().setLayoutData(protocolData);
                protocol.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
        
                    }
                });
		protocol.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Basic.protocol, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getProtocol()));
			}

		});
		protocol.setID(EsbViewsRepository.APIResource.Basic.protocol);
		Control protocolHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Basic.protocol, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createProtocolEMFComboViewer
		protocolElements = new Control[] {protocolLabel, protocol.getCombo(), protocolHelp};
		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createMethodsGroup(FormToolkit widgetFactory, final Composite parent) {
		Section methodsSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		methodsSection.setText(EsbMessages.APIResourcePropertiesEditionPart_MethodsGroupLabel);
		GridData methodsSectionData = new GridData(GridData.FILL_HORIZONTAL);
		methodsSectionData.horizontalSpan = 3;
		methodsSection.setLayoutData(methodsSectionData);
		Composite methodsGroup = widgetFactory.createComposite(methodsSection);
		GridLayout methodsGroupLayout = new GridLayout();
		methodsGroupLayout.numColumns = 3;
		methodsGroup.setLayout(methodsGroupLayout);
		methodsSection.setClient(methodsGroup);
		return methodsGroup;
	}

	
	protected Composite createAllowGetCheckbox(FormToolkit widgetFactory, Composite parent) {
		allowGet = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.APIResource.Methods.allowGet, EsbMessages.APIResourcePropertiesEditionPart_AllowGetLabel), SWT.CHECK);
		allowGet.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Methods.allowGet, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowGet.getSelection())));
			}

		});
		GridData allowGetData = new GridData(GridData.FILL_HORIZONTAL);
		allowGetData.horizontalSpan = 2;
		allowGet.setLayoutData(allowGetData);
		EditingUtils.setID(allowGet, EsbViewsRepository.APIResource.Methods.allowGet);
		EditingUtils.setEEFtype(allowGet, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Methods.allowGet, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowGetCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowPostCheckbox(FormToolkit widgetFactory, Composite parent) {
		allowPost = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.APIResource.Methods.allowPost, EsbMessages.APIResourcePropertiesEditionPart_AllowPostLabel), SWT.CHECK);
		allowPost.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Methods.allowPost, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowPost.getSelection())));
			}

		});
		GridData allowPostData = new GridData(GridData.FILL_HORIZONTAL);
		allowPostData.horizontalSpan = 2;
		allowPost.setLayoutData(allowPostData);
		EditingUtils.setID(allowPost, EsbViewsRepository.APIResource.Methods.allowPost);
		EditingUtils.setEEFtype(allowPost, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Methods.allowPost, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowPostCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowPutCheckbox(FormToolkit widgetFactory, Composite parent) {
		allowPut = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.APIResource.Methods.allowPut, EsbMessages.APIResourcePropertiesEditionPart_AllowPutLabel), SWT.CHECK);
		allowPut.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Methods.allowPut, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowPut.getSelection())));
			}

		});
		GridData allowPutData = new GridData(GridData.FILL_HORIZONTAL);
		allowPutData.horizontalSpan = 2;
		allowPut.setLayoutData(allowPutData);
		EditingUtils.setID(allowPut, EsbViewsRepository.APIResource.Methods.allowPut);
		EditingUtils.setEEFtype(allowPut, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Methods.allowPut, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowPutCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowDeleteCheckbox(FormToolkit widgetFactory, Composite parent) {
		allowDelete = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.APIResource.Methods.allowDelete, EsbMessages.APIResourcePropertiesEditionPart_AllowDeleteLabel), SWT.CHECK);
		allowDelete.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Methods.allowDelete, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowDelete.getSelection())));
			}

		});
		GridData allowDeleteData = new GridData(GridData.FILL_HORIZONTAL);
		allowDeleteData.horizontalSpan = 2;
		allowDelete.setLayoutData(allowDeleteData);
		EditingUtils.setID(allowDelete, EsbViewsRepository.APIResource.Methods.allowDelete);
		EditingUtils.setEEFtype(allowDelete, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Methods.allowDelete, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowDeleteCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowOptionsCheckbox(FormToolkit widgetFactory, Composite parent) {
		allowOptions = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.APIResource.Methods.allowOptions, EsbMessages.APIResourcePropertiesEditionPart_AllowOptionsLabel), SWT.CHECK);
		allowOptions.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Methods.allowOptions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowOptions.getSelection())));
			}

		});
		GridData allowOptionsData = new GridData(GridData.FILL_HORIZONTAL);
		allowOptionsData.horizontalSpan = 2;
		allowOptions.setLayoutData(allowOptionsData);
		EditingUtils.setID(allowOptions, EsbViewsRepository.APIResource.Methods.allowOptions);
		EditingUtils.setEEFtype(allowOptions, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Methods.allowOptions, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowOptionsCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowHeadCheckbox(FormToolkit widgetFactory, Composite parent) {
		allowHead = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.APIResource.Methods.allowHead, EsbMessages.APIResourcePropertiesEditionPart_AllowHeadLabel), SWT.CHECK);
		allowHead.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Methods.allowHead, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowHead.getSelection())));
			}

		});
		GridData allowHeadData = new GridData(GridData.FILL_HORIZONTAL);
		allowHeadData.horizontalSpan = 2;
		allowHead.setLayoutData(allowHeadData);
		EditingUtils.setID(allowHead, EsbViewsRepository.APIResource.Methods.allowHead);
		EditingUtils.setEEFtype(allowHead, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Methods.allowHead, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowHeadCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAllowPatchCheckbox(FormToolkit widgetFactory, Composite parent) {
		allowPatch = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.APIResource.Methods.allowPatch, EsbMessages.APIResourcePropertiesEditionPart_AllowPatchLabel), SWT.CHECK);
		allowPatch.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.Methods.allowPatch, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(allowPatch.getSelection())));
			}

		});
		GridData allowPatchData = new GridData(GridData.FILL_HORIZONTAL);
		allowPatchData.horizontalSpan = 2;
		allowPatch.setLayoutData(allowPatchData);
		EditingUtils.setID(allowPatch, EsbViewsRepository.APIResource.Methods.allowPatch);
		EditingUtils.setEEFtype(allowPatch, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.Methods.allowPatch, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAllowPatchCheckbox

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createInSequenceGroup(FormToolkit widgetFactory, final Composite parent) {
		Section inSequenceSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		inSequenceSection.setText(EsbMessages.APIResourcePropertiesEditionPart_InSequenceGroupLabel);
		GridData inSequenceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceSectionData.horizontalSpan = 3;
		inSequenceSection.setLayoutData(inSequenceSectionData);
		inSequenceGroup = widgetFactory.createComposite(inSequenceSection);
		GridLayout inSequenceGroupLayout = new GridLayout();
		inSequenceGroupLayout.numColumns = 3;
		inSequenceGroup.setLayout(inSequenceGroupLayout);
		inSequenceSection.setClient(inSequenceGroup);
		return inSequenceGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createInSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control inSequenceTypeLabel = createDescription(parent, EsbViewsRepository.APIResource.InSequence.inSequenceType, EsbMessages.APIResourcePropertiesEditionPart_InSequenceTypeLabel);
		inSequenceType = new EMFComboViewer(parent);
		inSequenceType.setContentProvider(new ArrayContentProvider());
		inSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData inSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceType.getCombo().setLayoutData(inSequenceTypeData);
                inSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		inSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			    if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.InSequence.inSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInSequenceType()));
			    refresh();
                
			}

		});
		inSequenceType.setID(EsbViewsRepository.APIResource.InSequence.inSequenceType);
		Control inSequenceHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.InSequence.inSequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInSequenceTypeEMFComboViewer
		inSequenceTypeElements = new Control[] {inSequenceTypeLabel, inSequenceType.getCombo(), inSequenceHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createInSequenceNameText(FormToolkit widgetFactory, Composite parent) {
		Control inSequenceNameLabel = createDescription(parent, EsbViewsRepository.APIResource.InSequence.inSequenceName, EsbMessages.APIResourcePropertiesEditionPart_InSequenceNameLabel);
		inSequenceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		inSequenceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData inSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		inSequenceName.setLayoutData(inSequenceNameData);
		inSequenceName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							APIResourcePropertiesEditionPartForm.this,
							EsbViewsRepository.APIResource.InSequence.inSequenceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inSequenceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									APIResourcePropertiesEditionPartForm.this,
									EsbViewsRepository.APIResource.InSequence.inSequenceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, inSequenceName.getText()));
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
									APIResourcePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		inSequenceName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.InSequence.inSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inSequenceName.getText()));
				}
			}
		});
		EditingUtils.setID(inSequenceName, EsbViewsRepository.APIResource.InSequence.inSequenceName);
		EditingUtils.setEEFtype(inSequenceName, "eef::Text"); //$NON-NLS-1$
		Control inSequenceNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.InSequence.inSequenceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInSequenceNameText
		inSequenceNameElements = new Control[] {inSequenceNameLabel, inSequenceName, inSequenceNameHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOutSequenceGroup(FormToolkit widgetFactory, final Composite parent) {
		Section outSequenceSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		outSequenceSection.setText(EsbMessages.APIResourcePropertiesEditionPart_OutSequenceGroupLabel);
		GridData outSequenceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		outSequenceSectionData.horizontalSpan = 3;
		outSequenceSection.setLayoutData(outSequenceSectionData);
		outSequenceGroup = widgetFactory.createComposite(outSequenceSection);
		GridLayout outSequenceGroupLayout = new GridLayout();
		outSequenceGroupLayout.numColumns = 3;
		outSequenceGroup.setLayout(outSequenceGroupLayout);
		outSequenceSection.setClient(outSequenceGroup);
		return outSequenceGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createOutSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control outSequenceTypeLabel = createDescription(parent, EsbViewsRepository.APIResource.OutSequence.outSequenceType, EsbMessages.APIResourcePropertiesEditionPart_OutSequenceTypeLabel);
		outSequenceType = new EMFComboViewer(parent);
		outSequenceType.setContentProvider(new ArrayContentProvider());
		outSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData outSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		outSequenceType.getCombo().setLayoutData(outSequenceTypeData);
                outSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
        
                    }
                });
		outSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			    if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.OutSequence.outSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutSequenceType()));
			    refresh();
			}

		});
		outSequenceType.setID(EsbViewsRepository.APIResource.OutSequence.outSequenceType);
		Control outSequenceTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.OutSequence.outSequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutSequenceTypeEMFComboViewer
		outSequenceTypeElements = new Control[] {outSequenceTypeLabel, outSequenceType.getCombo(), outSequenceTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOutSequenceNameText(FormToolkit widgetFactory, Composite parent) {
		Control outSequenceNameLabel = createDescription(parent, EsbViewsRepository.APIResource.OutSequence.outSequenceName, EsbMessages.APIResourcePropertiesEditionPart_OutSequenceNameLabel);
		outSequenceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		outSequenceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData outSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		outSequenceName.setLayoutData(outSequenceNameData);
		outSequenceName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							APIResourcePropertiesEditionPartForm.this,
							EsbViewsRepository.APIResource.OutSequence.outSequenceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outSequenceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									APIResourcePropertiesEditionPartForm.this,
									EsbViewsRepository.APIResource.OutSequence.outSequenceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, outSequenceName.getText()));
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
									APIResourcePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		outSequenceName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.OutSequence.outSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outSequenceName.getText()));
				}
			}
		});
		EditingUtils.setID(outSequenceName, EsbViewsRepository.APIResource.OutSequence.outSequenceName);
		EditingUtils.setEEFtype(outSequenceName, "eef::Text"); //$NON-NLS-1$
		Control outSequenceNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.OutSequence.outSequenceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutSequenceNameText
		outSequenceNameElements = new Control[] {outSequenceNameLabel, outSequenceName, outSequenceNameHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createFaultSequenceGroup(FormToolkit widgetFactory, final Composite parent) {
		Section faultSequenceSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		faultSequenceSection.setText(EsbMessages.APIResourcePropertiesEditionPart_FaultSequenceGroupLabel);
		GridData faultSequenceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		faultSequenceSectionData.horizontalSpan = 3;
		faultSequenceSection.setLayoutData(faultSequenceSectionData);
		faultSequenceGroup = widgetFactory.createComposite(faultSequenceSection);
		GridLayout faultSequenceGroupLayout = new GridLayout();
		faultSequenceGroupLayout.numColumns = 3;
		faultSequenceGroup.setLayout(faultSequenceGroupLayout);
		faultSequenceSection.setClient(faultSequenceGroup);
		return faultSequenceGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createFaultSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control faultSequenceTypeLabel = createDescription(parent, EsbViewsRepository.APIResource.FaultSequence.faultSequenceType, EsbMessages.APIResourcePropertiesEditionPart_FaultSequenceTypeLabel);
		faultSequenceType = new EMFComboViewer(parent);
		faultSequenceType.setContentProvider(new ArrayContentProvider());
		faultSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultSequenceType.getCombo().setLayoutData(faultSequenceTypeData);
                faultSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
			    if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.FaultSequence.faultSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultSequenceType()));
			    refresh();
			}

		});
		faultSequenceType.setID(EsbViewsRepository.APIResource.FaultSequence.faultSequenceType);
		Control faultSequenceTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.FaultSequence.faultSequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultSequenceTypeEMFComboViewer
		faultSequenceTypeElements = new Control[] {faultSequenceTypeLabel, faultSequenceType.getCombo(), faultSequenceTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createFaultSequenceNameText(FormToolkit widgetFactory, Composite parent) {
		Control faultSquenceNameLabel = createDescription(parent, EsbViewsRepository.APIResource.FaultSequence.faultSequenceName, EsbMessages.APIResourcePropertiesEditionPart_FaultSequenceNameLabel);
		faultSequenceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		faultSequenceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData faultSequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		faultSequenceName.setLayoutData(faultSequenceNameData);
		faultSequenceName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							APIResourcePropertiesEditionPartForm.this,
							EsbViewsRepository.APIResource.FaultSequence.faultSequenceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultSequenceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									APIResourcePropertiesEditionPartForm.this,
									EsbViewsRepository.APIResource.FaultSequence.faultSequenceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, faultSequenceName.getText()));
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
									APIResourcePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		faultSequenceName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this, EsbViewsRepository.APIResource.FaultSequence.faultSequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultSequenceName.getText()));
				}
			}
		});
		EditingUtils.setID(faultSequenceName, EsbViewsRepository.APIResource.FaultSequence.faultSequenceName);
		EditingUtils.setEEFtype(faultSequenceName, "eef::Text"); //$NON-NLS-1$
		Control faultSquenceNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.APIResource.FaultSequence.faultSequenceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultSequenceNameText
		faultSquenceNameElements = new Control[] {faultSquenceNameLabel, faultSequenceName, faultSquenceNameHelp};
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initInSequenceInputConnectors(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#updateInSequenceInputConnectors()
	 * 
	 */
	public void updateInSequenceInputConnectors() {
	inSequenceInputConnectors.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#addFilterInSequenceInputConnectors(ViewerFilter filter)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#addBusinessFilterInSequenceInputConnectors(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToInSequenceInputConnectors(ViewerFilter filter) {
		inSequenceInputConnectorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#isContainedInInSequenceInputConnectorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInInSequenceInputConnectorsTable(EObject element) {
		return ((ReferencesTableSettings)inSequenceInputConnectors.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getUrlStyle()
	 * 
	 */
	public Enumerator getUrlStyle() {
		Enumerator selection = (Enumerator) ((StructuredSelection) urlStyle.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initUrlStyle(Object input, Enumerator current)
	 */
	public void initUrlStyle(Object input, Enumerator current) {
		urlStyle.setInput(input);
		urlStyle.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Basic.urlStyle);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setUrlStyle(Enumerator newValue)
	 * 
	 */
	public void setUrlStyle(Enumerator newValue) {
		urlStyle.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Basic.urlStyle);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getUriTemplate()
	 * 
	 */
	public String getUriTemplate() {
		return uriTemplate.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setUriTemplate(String newValue)
	 * 
	 */
	public void setUriTemplate(String newValue) {
		if (newValue != null) {
			uriTemplate.setText(newValue);
		} else {
			uriTemplate.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Basic.uriTemplate);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getUrlMapping()
	 * 
	 */
	public String getUrlMapping() {
		return urlMapping.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setUrlMapping(String newValue)
	 * 
	 */
	public void setUrlMapping(String newValue) {
		if (newValue != null) {
			urlMapping.setText(newValue);
		} else {
			urlMapping.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Basic.urlMapping);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getProtocol()
	 * 
	 */
	public Enumerator getProtocol() {
		Enumerator selection = (Enumerator) ((StructuredSelection) protocol.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initProtocol(Object input, Enumerator current)
	 */
	public void initProtocol(Object input, Enumerator current) {
		protocol.setInput(input);
		protocol.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Basic.protocol);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setProtocol(Enumerator newValue)
	 * 
	 */
	public void setProtocol(Enumerator newValue) {
		protocol.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Basic.protocol);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowGet()
	 * 
	 */
	public Boolean getAllowGet() {
		return Boolean.valueOf(allowGet.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowGet(Boolean newValue)
	 * 
	 */
	public void setAllowGet(Boolean newValue) {
		if (newValue != null) {
			allowGet.setSelection(newValue.booleanValue());
		} else {
			allowGet.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Methods.allowGet);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowPost()
	 * 
	 */
	public Boolean getAllowPost() {
		return Boolean.valueOf(allowPost.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowPost(Boolean newValue)
	 * 
	 */
	public void setAllowPost(Boolean newValue) {
		if (newValue != null) {
			allowPost.setSelection(newValue.booleanValue());
		} else {
			allowPost.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Methods.allowPost);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowPut()
	 * 
	 */
	public Boolean getAllowPut() {
		return Boolean.valueOf(allowPut.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowPut(Boolean newValue)
	 * 
	 */
	public void setAllowPut(Boolean newValue) {
		if (newValue != null) {
			allowPut.setSelection(newValue.booleanValue());
		} else {
			allowPut.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Methods.allowPut);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowDelete()
	 * 
	 */
	public Boolean getAllowDelete() {
		return Boolean.valueOf(allowDelete.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowDelete(Boolean newValue)
	 * 
	 */
	public void setAllowDelete(Boolean newValue) {
		if (newValue != null) {
			allowDelete.setSelection(newValue.booleanValue());
		} else {
			allowDelete.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Methods.allowDelete);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowOptions()
	 * 
	 */
	public Boolean getAllowOptions() {
		return Boolean.valueOf(allowOptions.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowOptions(Boolean newValue)
	 * 
	 */
	public void setAllowOptions(Boolean newValue) {
		if (newValue != null) {
			allowOptions.setSelection(newValue.booleanValue());
		} else {
			allowOptions.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Methods.allowOptions);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowHead()
	 * 
	 */
	public Boolean getAllowHead() {
		return Boolean.valueOf(allowHead.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowHead(Boolean newValue)
	 * 
	 */
	public void setAllowHead(Boolean newValue) {
		if (newValue != null) {
			allowHead.setSelection(newValue.booleanValue());
		} else {
			allowHead.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Methods.allowHead);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getAllowPatch()
	 * 
	 */
	public Boolean getAllowPatch() {
		return Boolean.valueOf(allowPatch.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setAllowPatch(Boolean newValue)
	 * 
	 */
	public void setAllowPatch(Boolean newValue) {
		if (newValue != null) {
			allowPatch.setSelection(newValue.booleanValue());
		} else {
			allowPatch.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.Methods.allowPatch);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getInSequenceType()
	 * 
	 */
	public Enumerator getInSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initInSequenceType(Object input, Enumerator current)
	 */
	public void initInSequenceType(Object input, Enumerator current) {
		inSequenceType.setInput(input);
		inSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.InSequence.inSequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setInSequenceType(Enumerator newValue)
	 * 
	 */
	public void setInSequenceType(Enumerator newValue) {
		inSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.InSequence.inSequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getInSequenceName()
	 * 
	 */
	public String getInSequenceName() {
		return inSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setInSequenceName(String newValue)
	 * 
	 */
	public void setInSequenceName(String newValue) {
		if (newValue != null) {
			inSequenceName.setText(newValue);
		} else {
			inSequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.InSequence.inSequenceName);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getOutSequenceType()
	 * 
	 */
	public Enumerator getOutSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initOutSequenceType(Object input, Enumerator current)
	 */
	public void initOutSequenceType(Object input, Enumerator current) {
		outSequenceType.setInput(input);
		outSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.OutSequence.outSequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setOutSequenceType(Enumerator newValue)
	 * 
	 */
	public void setOutSequenceType(Enumerator newValue) {
		outSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.OutSequence.outSequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getOutSequenceName()
	 * 
	 */
	public String getOutSequenceName() {
		return outSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setOutSequenceName(String newValue)
	 * 
	 */
	public void setOutSequenceName(String newValue) {
		if (newValue != null) {
			outSequenceName.setText(newValue);
		} else {
			outSequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.OutSequence.outSequenceName);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getFaultSequenceType()
	 * 
	 */
	public Enumerator getFaultSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#initFaultSequenceType(Object input, Enumerator current)
	 */
	public void initFaultSequenceType(Object input, Enumerator current) {
		faultSequenceType.setInput(input);
		faultSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.FaultSequence.faultSequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setFaultSequenceType(Enumerator newValue)
	 * 
	 */
	public void setFaultSequenceType(Enumerator newValue) {
		faultSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.FaultSequence.faultSequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#getFaultSequenceName()
	 * 
	 */
	public String getFaultSequenceName() {
		return faultSequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart#setFaultSequenceName(String newValue)
	 * 
	 */
	public void setFaultSequenceName(String newValue) {
		if (newValue != null) {
			faultSequenceName.setText(newValue);
		} else {
			faultSequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.APIResource.FaultSequence.faultSequenceName);
		if (eefElementEditorReadOnlyState && faultSequenceName.isEnabled()) {
			faultSequenceName.setEnabled(false);
			faultSequenceName.setToolTipText(EsbMessages.APIResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultSequenceName.isEnabled()) {
			faultSequenceName.setEnabled(true);
		}	
		
	}






	// Start of user code for inSequenceKey specific getters and setters implementation
    @Override
    public void setInSequenceKey(RegistryKeyProperty registryKeyProperty) {
        if (inSequenceKey != null) {
            inSequenceKey = registryKeyProperty;
            inSequenceKeyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getInSequenceKey() {
        return inSequenceKey;
    }
	
	// End of user code

	// Start of user code for outSequenceKey specific getters and setters implementation
    @Override
    public void setOutSequenceKey(RegistryKeyProperty registryKeyProperty) {
        if (outSequenceKey != null) {
            outSequenceKey = registryKeyProperty;
            outSequenceKeyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getOutSequenceKey() {
        return outSequenceKey;
    }
	
	// End of user code

	// Start of user code for faultSequenceKey specific getters and setters implementation
    @Override
    public void setFaultSequenceKey(RegistryKeyProperty registryKeyProperty) {
        if (faultSequenceKey != null) {
            faultSequenceKey = registryKeyProperty;
            faultSequenceKeyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getFaultSequenceKey() {
        return faultSequenceKey;
    }
	// End of user code

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
	@Override
    public void refresh() {
        super.refresh();
        validate();
        urlStyle.getCombo().setFocus();
        propertiesGroup.setFocus();
    }
	
	 protected Composite createInSequenceKey(FormToolkit widgetFactory, final Composite parent) {
	        Control inSequenceKeyLabel = createDescription(parent, EsbViewsRepository.APIResource.InSequence.inSequenceKey,
	                EsbMessages.APIResourcePropertiesEditionPart_InSequenceKeyLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (inSequenceKey == null) {
	            inSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initSequenceKey = inSequenceKey.getKeyValue().isEmpty() ? "" : inSequenceKey.getKeyValue();
	        inSequenceKeyText = widgetFactory.createText(parent, initSequenceKey, SWT.READ_ONLY);
	        inSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        inSequenceKeyText.setLayoutData(valueData);
	        inSequenceKeyText.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseUp(MouseEvent e) {
	                // TODO Auto-generated method stub
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, inSequenceKey, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                inSequenceKeyText.setText(inSequenceKey.getKeyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this,
	                                EsbViewsRepository.APIResource.InSequence.inSequenceKey, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getInSequenceKey()));
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {
	                // TODO Auto-generated method stub

	            }
	        });
	        
	        inSequenceKeyText.addKeyListener(new KeyListener() {
                
                @Override
                public void keyReleased(KeyEvent e) {
                       if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                           EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                                   SWT.NULL, inSequenceKey, new ArrayList<NamedEntityDescriptor>());
                           dialog.open();
                           inSequenceKeyText.setText(inSequenceKey.getKeyValue());
                           propertiesEditionComponent
                                   .firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this,
                                           EsbViewsRepository.APIResource.InSequence.inSequenceKey, PropertiesEditionEvent.COMMIT,
                                           PropertiesEditionEvent.SET, null, getInSequenceKey()));
                       }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {}
                
            });
	        
	        EditingUtils.setID(inSequenceKeyText, EsbViewsRepository.APIResource.InSequence.inSequenceKey);
	        EditingUtils.setEEFtype(inSequenceKeyText, "eef::Text");
	        Control sequenceKeyHelp = FormUtils
	                .createHelpButton(widgetFactory, parent,
	                        propertiesEditionComponent.getHelpContent(
	                                EsbViewsRepository.APIResource.InSequence.inSequenceKey, EsbViewsRepository.FORM_KIND),
	                        null);
	        inSequenceKeyElements = new Control[] { inSequenceKeyLabel, inSequenceKeyText, sequenceKeyHelp };
	        return parent;
	    }
	 
	 protected Composite createOutSequenceKey(FormToolkit widgetFactory, final Composite parent) {
         Control outSequenceKeyLabel = createDescription(parent, EsbViewsRepository.APIResource.OutSequence.outSequenceKey,
                 EsbMessages.APIResourcePropertiesEditionPart_OutSequenceKeyLabel);
         widgetFactory.paintBordersFor(parent);
         if (outSequenceKey == null) {
             outSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
         }
         String initSequenceKey = outSequenceKey.getKeyValue().isEmpty() ? "" : outSequenceKey.getKeyValue();
         outSequenceKeyText = widgetFactory.createText(parent, initSequenceKey, SWT.READ_ONLY);
         outSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
         widgetFactory.paintBordersFor(parent);
         GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
         outSequenceKeyText.setLayoutData(valueData);
         outSequenceKeyText.addMouseListener(new MouseListener() {

             @Override
             public void mouseUp(MouseEvent e) {
                 // TODO Auto-generated method stub
             }

             @Override
             public void mouseDown(MouseEvent e) {
                 EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                         SWT.NULL, outSequenceKey, new ArrayList<NamedEntityDescriptor>());
                 dialog.open();
                 outSequenceKeyText.setText(outSequenceKey.getKeyValue());
                 propertiesEditionComponent
                         .firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this,
                                 EsbViewsRepository.APIResource.OutSequence.outSequenceKey, PropertiesEditionEvent.COMMIT,
                                 PropertiesEditionEvent.SET, null, getOutSequenceKey()));
             }

             @Override
             public void mouseDoubleClick(MouseEvent e) {
                 // TODO Auto-generated method stub

             }
         });
         
         outSequenceKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                   if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                       EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                               SWT.NULL, outSequenceKey, new ArrayList<NamedEntityDescriptor>());
                       dialog.open();
                       outSequenceKeyText.setText(outSequenceKey.getKeyValue());
                       propertiesEditionComponent
                               .firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this,
                                       EsbViewsRepository.APIResource.OutSequence.outSequenceKey, PropertiesEditionEvent.COMMIT,
                                       PropertiesEditionEvent.SET, null, getOutSequenceKey()));
                   }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
         
         EditingUtils.setID(outSequenceKeyText, EsbViewsRepository.APIResource.OutSequence.outSequenceKey);
         EditingUtils.setEEFtype(outSequenceKeyText, "eef::Text");
         Control sequenceKeyHelp = FormUtils
                 .createHelpButton(widgetFactory, parent,
                         propertiesEditionComponent.getHelpContent(
                                 EsbViewsRepository.APIResource.OutSequence.outSequenceKey, EsbViewsRepository.FORM_KIND),
                         null);
         outSequenceKeyElements = new Control[] { outSequenceKeyLabel, outSequenceKeyText, sequenceKeyHelp };
         return parent;
     }
	 
	 protected Composite createFaultSequenceKey(FormToolkit widgetFactory, final Composite parent) {
         Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.APIResource.FaultSequence.faultSequenceKey,
                 EsbMessages.APIResourcePropertiesEditionPart_FaultSequenceKeyLabel);
         widgetFactory.paintBordersFor(parent);
         if (faultSequenceKey == null) {
             faultSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
         }
         String initSequenceKey = faultSequenceKey.getKeyValue().isEmpty() ? "" : faultSequenceKey.getKeyValue();
         faultSequenceKeyText = widgetFactory.createText(parent, initSequenceKey, SWT.READ_ONLY);
         faultSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
         widgetFactory.paintBordersFor(parent);
         GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
         faultSequenceKeyText.setLayoutData(valueData);
         faultSequenceKeyText.addMouseListener(new MouseListener() {

             @Override
             public void mouseUp(MouseEvent e) {
                 // TODO Auto-generated method stub
             }

             @Override
             public void mouseDown(MouseEvent e) {
                 EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                         SWT.NULL, faultSequenceKey, new ArrayList<NamedEntityDescriptor>());
                 dialog.open();
                 faultSequenceKeyText.setText(faultSequenceKey.getKeyValue());
                 propertiesEditionComponent
                         .firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this,
                                 EsbViewsRepository.APIResource.FaultSequence.faultSequenceKey, PropertiesEditionEvent.COMMIT,
                                 PropertiesEditionEvent.SET, null, getFaultSequenceKey()));
             }

             @Override
             public void mouseDoubleClick(MouseEvent e) {
                 // TODO Auto-generated method stub

             }
         });
         
         faultSequenceKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, faultSequenceKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    faultSequenceKeyText.setText(faultSequenceKey.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(APIResourcePropertiesEditionPartForm.this,
                                    EsbViewsRepository.APIResource.FaultSequence.faultSequenceKey, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getFaultSequenceKey()));
                } 
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
         
         EditingUtils.setID(faultSequenceKeyText, EsbViewsRepository.APIResource.FaultSequence.faultSequenceKey);
         EditingUtils.setEEFtype(faultSequenceKeyText, "eef::Text");
         Control sequenceKeyHelp = FormUtils
                 .createHelpButton(widgetFactory, parent,
                         propertiesEditionComponent.getHelpContent(
                                 EsbViewsRepository.APIResource.FaultSequence.faultSequenceKey, EsbViewsRepository.FORM_KIND),
                         null);
         faultSequenceKeyElements = new Control[] { sequenceKeyLabel, faultSequenceKeyText, sequenceKeyHelp };
         return parent;
     }
	
	public void validate() {
        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        
        eu.clearElements(new Composite[] { propertiesGroup });
        propertiesSection.setVisible(false);
        ((GridData) propertiesSection.getLayoutData()).exclude = true;
        
        eu.clearElements(new Composite[] { basicGroup });
        eu.showEntry(urlStyleElements, false);
        if (getUrlStyle() != null && getUrlStyle().getName().equals(ApiResourceUrlStyle.URI_TEMPLATE.getName())) {
            eu.showEntry(uriTemplateElements, false);
        } else if (getUrlStyle() != null && getUrlStyle().getName().equals(ApiResourceUrlStyle.URL_MAPPING.getName())) {
            eu.showEntry(urlMappingElements, false);
        }
        eu.showEntry(protocolElements, false);
        
        eu.clearElements(new Composite[] { inSequenceGroup });
        eu.showEntry(inSequenceTypeElements, false);
        if (getInSequenceType() != null && getInSequenceType().getName().equals(SequenceType.NAMED_REFERENCE.getName())) {
            eu.showEntry(inSequenceNameElements, false);
        } else if (getInSequenceType() != null && getInSequenceType().getName().equals(SequenceType.REGISTRY_REFERENCE.getName())) {
            eu.showEntry(inSequenceKeyElements, false);
        }
        
        eu.clearElements(new Composite[] { outSequenceGroup });
        eu.showEntry(outSequenceTypeElements, false);
        if (getOutSequenceType() != null && getOutSequenceType().getName().equals(SequenceType.NAMED_REFERENCE.getName())) {
            eu.showEntry(outSequenceNameElements, false);
        } else if (getOutSequenceType() != null && getOutSequenceType().getName().equals(SequenceType.REGISTRY_REFERENCE.getName())) {
            eu.showEntry(outSequenceKeyElements, false);
        }
        
        eu.clearElements(new Composite[] { faultSequenceGroup });
        eu.showEntry(faultSequenceTypeElements, false);
        if (getFaultSequenceType() != null && getFaultSequenceType().getName().equals(SequenceType.NAMED_REFERENCE.getName())) {
            eu.showEntry(faultSquenceNameElements, false);
        } else if (getFaultSequenceType() != null && getFaultSequenceType().getName().equals(SequenceType.REGISTRY_REFERENCE.getName())) {
            eu.showEntry(faultSequenceKeyElements, false);
        }
        
        view.layout(true, true);
    }
	
	// End of user code


}
