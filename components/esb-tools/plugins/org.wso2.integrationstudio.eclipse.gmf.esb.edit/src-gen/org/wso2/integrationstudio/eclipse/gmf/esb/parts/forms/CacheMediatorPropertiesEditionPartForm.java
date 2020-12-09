/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediatorType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheSequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart;
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
public class CacheMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, CacheMediatorPropertiesEditionPart {

    protected EMFComboViewer cacheMediatorImplementation;
    protected Text id;
    protected EMFComboViewer cacheType;
    protected EMFComboViewer scope;
    protected Text hashGeneratorAttribute;
    protected Text cacheTimeout;
    protected Text maxMessageSize;
    protected Text commentsList;
    protected Button editCommentsList;
    protected EList commentsListList;
    protected Button reverse;
    protected Text maxEntryCount;
    protected EMFComboViewer implementationType;
    protected Text description;
    protected EMFComboViewer sequenceType;
    // Start of user code for sequenceKey widgets declarations
    protected RegistryKeyProperty sequenceKey;

    protected Composite propertiesGroup;
    protected Composite implementationGroup;
    protected Composite miscGroup;
    protected Composite onCacheHitGroup;
    protected Composite protocolGroup;
    protected Composite typeGroup;

    protected Control[] cacheTypeElements;
    protected Control[] cacheTimeoutElements;
    protected Control[] maxMessageSizeElements;
    protected Control[] maxEntryCountElements;
    protected Control[] descriptionElements;
    protected Control[] sequenceTypeElements;
    protected Control[] cacheProtocolTypeElements;
    protected Control[] cacheProtocolMethodsElements;
    protected Control[] headersToExcludeInHashElements;
    protected Control[] responseCodesElements;
    protected Control[] enableCacheControlElements;
    protected Control[] includeAgeHeaderElements;
    protected Control[] hashGeneratorElements;
    protected Control[] sequenceKeyElements;
    protected Control[] cacheMediatorImplementationElements;
    protected Control[] idElements;
    protected Control[] scopeElements;
    protected Control[] hashGeneratorAttributeElements;
    protected Control[] implementationTypeElements;

    protected Text sequenceKeyText;

    protected Section implementationSection;
    protected Section onCacheHitSection;
    protected Section protocolSection;

    // End of user code

    protected EMFComboViewer cacheProtocolType;
    protected Text cacheProtocolMethods;
    protected Text headersToExcludeInHash;
    protected Text responseCodes;
    protected Button enableCacheControl;
    protected Button includeAgeHeader;
    protected Text hashGenerator;

    /**
     * For {@link ISection} use only.
     */
    public CacheMediatorPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
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
     *      createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
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
     *      createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
     * 
     */
    public void createControls(final FormToolkit widgetFactory, Composite view) {
        CompositionSequence cacheMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
        
        CompositionStep cacheTypeStep = cacheMediatorStep.addStep(EsbViewsRepository.CacheMediator.Type.class);
        cacheTypeStep.addStep(EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation);
        
        CompositionStep propertiesStep = cacheMediatorStep.addStep(EsbViewsRepository.CacheMediator.Properties.class);
        propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.cacheType);
        propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.id);
        propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.cacheTimeout);
        propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.maxMessageSize);
        propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.scope);
        propertiesStep.addStep(EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute);

        CompositionStep implementationStep = cacheMediatorStep.addStep(EsbViewsRepository.CacheMediator.Implementation.class);
        implementationStep.addStep(EsbViewsRepository.CacheMediator.Implementation.maxEntryCount);
        implementationStep.addStep(EsbViewsRepository.CacheMediator.Implementation.implementationType);

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

        cacheMediatorStep.addStep(EsbViewsRepository.CacheMediator.Misc.class)
                .addStep(EsbViewsRepository.CacheMediator.Misc.description);

        composer = new PartComposer(cacheMediatorStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.CacheMediator.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Properties.cacheType) {
                    return createCacheTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Properties.cacheTimeout) {
                    return createCacheTimeoutText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Properties.maxMessageSize) {
                    return createMaxMessageSizeText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Implementation.class) {
                    return createImplementationGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Implementation.maxEntryCount) {
                    return createMaxEntryCountText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Misc.class) {
                    return createMiscGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Misc.description) {
                    return createDescriptionText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.OnCacheHit.class) {
                    return createOnCacheHitGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType) {
                    return createSequenceTypeEMFComboViewer(widgetFactory, parent);
                }
                // Start of user code for sequenceKey addToPart creation
                if (key == EsbViewsRepository.CacheMediator.OnCacheHit.sequenceKey) {
                    return createSequenceKey(widgetFactory, parent);
                }
                // End of user code
                if (key == EsbViewsRepository.CacheMediator.Protocol.class) {
                    return createProtocolGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType) {
                    return createCacheProtocolTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods) {
                    return createCacheProtocolMethodsText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash) {
                    return createHeadersToExcludeInHashText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Protocol.responseCodes) {
                    return createResponseCodesText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Protocol.enableCacheControl) {
                    return createEnableCacheControlCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader) {
                    return createIncludeAgeHeaderCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Protocol.hashGenerator) {
                    return createHashGeneratorText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Type.class) {
                    return createTypeGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation) {
                    return createCacheMediatorImplementationEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Properties.id) {
                    return createIdText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Properties.scope) {
                    return createScopeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute) {
                    return createHashGeneratorAttributeText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CacheMediator.Implementation.implementationType) {
                    return createImplementationTypeEMFComboViewer(widgetFactory, parent);
                }
                return parent;
            }
        };
        composer.compose(view);
    }

    /**
     * @generated NOT
     */
  protected Composite createTypeGroup(FormToolkit widgetFactory, final Composite parent) {
    Section typeSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
    typeSection.setText(EsbMessages.CacheMediatorPropertiesEditionPart_TypeGroupLabel);
    GridData typeSectionData = new GridData(GridData.FILL_HORIZONTAL);
    typeSectionData.horizontalSpan = 3;
    typeSection.setLayoutData(typeSectionData);
    typeGroup = widgetFactory.createComposite(typeSection);
    GridLayout typeGroupLayout = new GridLayout();
    typeGroupLayout.numColumns = 3;
    typeGroup.setLayout(typeGroupLayout);
    typeSection.setClient(typeGroup);
    return typeGroup;
  }

    /**
     * @generated NOT
     */
    protected Composite createCacheMediatorImplementationEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
    Control cacheTypeDescription = createDescription(parent, EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation, EsbMessages.CacheMediatorPropertiesEditionPart_CacheMediatorImplementationLabel);
    cacheMediatorImplementation = new EMFComboViewer(parent);
    cacheMediatorImplementation.setContentProvider(new ArrayContentProvider());
    cacheMediatorImplementation.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData cacheMediatorImplementationData = new GridData(GridData.FILL_HORIZONTAL);
    cacheMediatorImplementation.getCombo().setLayoutData(cacheMediatorImplementationData);
    cacheMediatorImplementation.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

        @Override
        public void handleEvent(Event arg0) {
            arg0.doit = false;

        }
    });
    cacheMediatorImplementation.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCacheMediatorImplementation()));
        refresh();
      }

    });
    cacheMediatorImplementation.setID(EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation);
    Control cacheTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
    // Start of user code for createCacheMediatorImplementationEMFComboViewer
    cacheMediatorImplementationElements = new Control[] {cacheTypeDescription, cacheMediatorImplementation.getCombo(), cacheTypeHelp};
    // End of user code
    return parent;
  }

    /**
     * @generated NOT
     */
    protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
        Section propertiesSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        propertiesSection.setText(EsbMessages.CacheMediatorPropertiesEditionPart_PropertiesGroupLabel);
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

    protected Composite createIdText(FormToolkit widgetFactory, Composite parent) {
    Control idDescription = createDescription(parent, EsbViewsRepository.CacheMediator.Properties.id, EsbMessages.CacheMediatorPropertiesEditionPart_IdLabel);
    id = widgetFactory.createText(parent, ""); //$NON-NLS-1$
    id.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
    widgetFactory.paintBordersFor(parent);
    GridData idData = new GridData(GridData.FILL_HORIZONTAL);
    id.setLayoutData(idData);
    id.addFocusListener(new FocusAdapter() {
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
              EsbViewsRepository.CacheMediator.Properties.id,
              PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
          propertiesEditionComponent
              .firePropertiesChanged(new PropertiesEditionEvent(
                  CacheMediatorPropertiesEditionPartForm.this,
                  EsbViewsRepository.CacheMediator.Properties.id,
                  PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                  null, id.getText()));
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
    id.addKeyListener(new KeyAdapter() {
      /**
       * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
       * 
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void keyPressed(KeyEvent e) {
        if (e.character == SWT.CR) {
          if (propertiesEditionComponent != null)
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
        }
      }
    });
    EditingUtils.setID(id, EsbViewsRepository.CacheMediator.Properties.id);
    EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
    Control idHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.id, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
    // Start of user code for createIdText
    idElements = new Control[] {idDescription, id, idHelp};
    // End of user code
    return parent;
  }

    /**
     * @generated NOT
     */
    protected Composite createCacheTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control cacheTypeLabel = createDescription(parent, EsbViewsRepository.CacheMediator.Properties.cacheType,
                EsbMessages.CacheMediatorPropertiesEditionPart_CacheTypeLabel);
        cacheType = new EMFComboViewer(parent);
        cacheType.setContentProvider(new ArrayContentProvider());
        cacheType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData cacheTypeData = new GridData(GridData.FILL_HORIZONTAL);
        cacheType.getCombo().setLayoutData(cacheTypeData);
        cacheType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;

            }
        });
        cacheType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.Properties.cacheType,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCacheType()));
                refresh();
            }

        });
        cacheType.setID(EsbViewsRepository.CacheMediator.Properties.cacheType);
        Control cacheTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.CacheMediator.Properties.cacheType, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createCacheTypeEMFComboViewer
        cacheTypeElements = new Control[] { cacheTypeLabel, cacheType.getCombo(), cacheTypeHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createScopeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
    Control scopeDescription = createDescription(parent, EsbViewsRepository.CacheMediator.Properties.scope, EsbMessages.CacheMediatorPropertiesEditionPart_ScopeLabel);
    scope = new EMFComboViewer(parent);
    scope.setContentProvider(new ArrayContentProvider());
    scope.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData scopeData = new GridData(GridData.FILL_HORIZONTAL);
    scope.getCombo().setLayoutData(scopeData);
    scope.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

        @Override
        public void handleEvent(Event arg0) {
            arg0.doit = false;

        }
    });
    scope.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.scope, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getScope()));
        refresh();
      }

    });
    scope.setID(EsbViewsRepository.CacheMediator.Properties.scope);
    Control scopeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.scope, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
    // Start of user code for createScopeEMFComboViewer
    scopeElements = new Control[] {scopeDescription, scope.getCombo(), scopeHelp};
    // End of user code
    return parent;
  }

    protected Composite createHashGeneratorAttributeText(FormToolkit widgetFactory, Composite parent) {
    Control hashGeneratorDescription = createDescription(parent, EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute, EsbMessages.CacheMediatorPropertiesEditionPart_HashGeneratorAttributeLabel);
    hashGeneratorAttribute = widgetFactory.createText(parent, ""); //$NON-NLS-1$
    hashGeneratorAttribute.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
    widgetFactory.paintBordersFor(parent);
    GridData hashGeneratorAttributeData = new GridData(GridData.FILL_HORIZONTAL);
    hashGeneratorAttribute.setLayoutData(hashGeneratorAttributeData);
    hashGeneratorAttribute.addFocusListener(new FocusAdapter() {
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
              EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute,
              PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hashGeneratorAttribute.getText()));
          propertiesEditionComponent
              .firePropertiesChanged(new PropertiesEditionEvent(
                  CacheMediatorPropertiesEditionPartForm.this,
                  EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute,
                  PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                  null, hashGeneratorAttribute.getText()));
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
    hashGeneratorAttribute.addKeyListener(new KeyAdapter() {
      /**
       * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
       * 
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void keyPressed(KeyEvent e) {
        if (e.character == SWT.CR) {
          if (propertiesEditionComponent != null)
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hashGeneratorAttribute.getText()));
        }
      }
    });
    EditingUtils.setID(hashGeneratorAttribute, EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute);
    EditingUtils.setEEFtype(hashGeneratorAttribute, "eef::Text"); //$NON-NLS-1$
    Control hashGeneratorHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
    // Start of user code for createHashGeneratorAttributeText
    hashGeneratorAttributeElements = new Control[] {hashGeneratorDescription, hashGeneratorAttribute, hashGeneratorHelp};
    // End of user code
    return parent;
  }

    /**
     * @generated NOT
     */
    protected Composite createCacheTimeoutText(FormToolkit widgetFactory, Composite parent) {
        Control cacheTimeoutLabel = createDescription(parent, EsbViewsRepository.CacheMediator.Properties.cacheTimeout,
                EsbMessages.CacheMediatorPropertiesEditionPart_CacheTimeoutLabel);
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
                            EsbViewsRepository.CacheMediator.Properties.cacheTimeout, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, cacheTimeout.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.Properties.cacheTimeout,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    cacheTimeout.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CacheMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CacheMediator.Properties.cacheTimeout, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, cacheTimeout.getText()));
                }
            }
        });
        EditingUtils.setID(cacheTimeout, EsbViewsRepository.CacheMediator.Properties.cacheTimeout);
        EditingUtils.setEEFtype(cacheTimeout, "eef::Text"); //$NON-NLS-1$
        Control cacheTimeoutHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.CacheMediator.Properties.cacheTimeout, EsbViewsRepository.FORM_KIND),
                        null); // $NON-NLS-1$
        // Start of user code for createCacheTimeoutText
        cacheTimeoutElements = new Control[] { cacheTimeoutLabel, cacheTimeout, cacheTimeoutHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createMaxMessageSizeText(FormToolkit widgetFactory, Composite parent) {
        Control maxMesageSizeLable = createDescription(parent,
                EsbViewsRepository.CacheMediator.Properties.maxMessageSize,
                EsbMessages.CacheMediatorPropertiesEditionPart_MaxMessageSizeLabel);
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
                            EsbViewsRepository.CacheMediator.Properties.maxMessageSize, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, maxMessageSize.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.Properties.maxMessageSize,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    maxMessageSize.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CacheMediator.Properties.maxMessageSize,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        maxMessageSize.getText()));
                }
            }
        });
        EditingUtils.setID(maxMessageSize, EsbViewsRepository.CacheMediator.Properties.maxMessageSize);
        EditingUtils.setEEFtype(maxMessageSize, "eef::Text"); //$NON-NLS-1$
        Control maxMessageSizeHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Properties.maxMessageSize,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createMaxMessageSizeText
        maxMessageSizeElements = new Control[] { maxMesageSizeLable, maxMessageSize, maxMessageSizeHelp };
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

    /**
     * @generated NOT
     */
    protected Composite createImplementationGroup(FormToolkit widgetFactory, final Composite parent) {
        implementationSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        implementationSection.setText(EsbMessages.CacheMediatorPropertiesEditionPart_ImplementationGroupLabel);
        GridData implementationSectionData = new GridData(GridData.FILL_HORIZONTAL);
        implementationSectionData.horizontalSpan = 3;
        implementationSection.setLayoutData(implementationSectionData);
        implementationGroup = widgetFactory.createComposite(implementationSection);
        GridLayout implementationGroupLayout = new GridLayout();
        implementationGroupLayout.numColumns = 3;
        implementationGroup.setLayout(implementationGroupLayout);
        implementationSection.setClient(implementationGroup);
        return implementationGroup;
    }

    /**
     * @generated NOT
     */
    protected Composite createMaxEntryCountText(FormToolkit widgetFactory, Composite parent) {
        Control maxEntryCountLabel = createDescription(parent,
                EsbViewsRepository.CacheMediator.Implementation.maxEntryCount,
                EsbMessages.CacheMediatorPropertiesEditionPart_MaxEntryCountLabel);
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
                            EsbViewsRepository.CacheMediator.Implementation.maxEntryCount,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxEntryCount.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.Implementation.maxEntryCount,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    maxEntryCount.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CacheMediator.Implementation.maxEntryCount,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        maxEntryCount.getText()));
                }
            }
        });
        EditingUtils.setID(maxEntryCount, EsbViewsRepository.CacheMediator.Implementation.maxEntryCount);
        EditingUtils.setEEFtype(maxEntryCount, "eef::Text"); //$NON-NLS-1$
        Control maxEntryCountHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Implementation.maxEntryCount,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createMaxEntryCountText
        maxEntryCountElements = new Control[] { maxEntryCountLabel, maxEntryCount, maxEntryCountHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createImplementationTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
    Control implementationTypeDescription = createDescription(parent, EsbViewsRepository.CacheMediator.Implementation.implementationType, EsbMessages.CacheMediatorPropertiesEditionPart_ImplementationTypeLabel);
    implementationType = new EMFComboViewer(parent);
    implementationType.setContentProvider(new ArrayContentProvider());
    implementationType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData implementationTypeData = new GridData(GridData.FILL_HORIZONTAL);
    implementationType.getCombo().setLayoutData(implementationTypeData);
    implementationType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

        @Override
        public void handleEvent(Event arg0) {
            arg0.doit = false;

        }
    });
    implementationType.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CacheMediator.Implementation.implementationType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getImplementationType()));
        refresh();
      }

    });
    implementationType.setID(EsbViewsRepository.CacheMediator.Implementation.implementationType);
    Control implementationTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Implementation.implementationType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
    // Start of user code for createImplementationTypeEMFComboViewer
    implementationTypeElements = new Control[] {implementationTypeDescription, implementationType.getCombo(), implementationTypeHelp};
    // End of user code
    return parent;
  }

    /**
     * @generated NOT
     */
    protected Composite createMiscGroup(FormToolkit widgetFactory, final Composite parent) {
        Section miscSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        miscSection.setText(EsbMessages.CacheMediatorPropertiesEditionPart_MiscGroupLabel);
        GridData miscSectionData = new GridData(GridData.FILL_HORIZONTAL);
        miscSectionData.horizontalSpan = 3;
        miscSection.setLayoutData(miscSectionData);
        miscGroup = widgetFactory.createComposite(miscSection);
        GridLayout miscGroupLayout = new GridLayout();
        miscGroupLayout.numColumns = 3;
        miscGroup.setLayout(miscGroupLayout);
        miscSection.setClient(miscGroup);
        return miscGroup;
    }

    /**
     * @generated NOT
     */
    protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
        Control descriptionLabel = createDescription(parent, EsbViewsRepository.CacheMediator.Misc.description,
                EsbMessages.CacheMediatorPropertiesEditionPart_DescriptionLabel);
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
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.Misc.description, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, description.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CacheMediator.Misc.description, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, description.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CacheMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CacheMediator.Misc.description, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, description.getText()));
                }
            }
        });
        EditingUtils.setID(description, EsbViewsRepository.CacheMediator.Misc.description);
        EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
        Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.CacheMediator.Misc.description, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createDescriptionText
        descriptionElements = new Control[] { descriptionLabel, description, descriptionHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createOnCacheHitGroup(FormToolkit widgetFactory, final Composite parent) {
        onCacheHitSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        onCacheHitSection.setText(EsbMessages.CacheMediatorPropertiesEditionPart_OnCacheHitGroupLabel);
        GridData onCacheHitSectionData = new GridData(GridData.FILL_HORIZONTAL);
        onCacheHitSectionData.horizontalSpan = 3;
        onCacheHitSection.setLayoutData(onCacheHitSectionData);
        onCacheHitGroup = widgetFactory.createComposite(onCacheHitSection);
        GridLayout onCacheHitGroupLayout = new GridLayout();
        onCacheHitGroupLayout.numColumns = 3;
        onCacheHitGroup.setLayout(onCacheHitGroupLayout);
        onCacheHitSection.setClient(onCacheHitGroup);
        return onCacheHitGroup;
    }

    /**
     * @generated NOT
     */
    protected Composite createSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control sequenceTypeLabel = createDescription(parent, EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType,
                EsbMessages.CacheMediatorPropertiesEditionPart_SequenceTypeLabel);
        sequenceType = new EMFComboViewer(parent);
        sequenceType.setContentProvider(new ArrayContentProvider());
        sequenceType
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData sequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
        sequenceType.getCombo().setLayoutData(sequenceTypeData);
        sequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;

            }
        });
        sequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getSequenceType()));
                refresh();
            }

        });
        sequenceType.setID(EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType);
        Control sequenceTypeHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.CacheMediator.OnCacheHit.sequenceType, EsbViewsRepository.FORM_KIND),
                        null); // $NON-NLS-1$
        // Start of user code for createSequenceTypeEMFComboViewer
        sequenceTypeElements = new Control[] { sequenceTypeLabel, sequenceType.getCombo(), sequenceTypeHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createProtocolGroup(FormToolkit widgetFactory, final Composite parent) {
        protocolSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        protocolSection.setText(EsbMessages.CacheMediatorPropertiesEditionPart_ProtocolGroupLabel);
        GridData protocolSectionData = new GridData(GridData.FILL_HORIZONTAL);
        protocolSectionData.horizontalSpan = 3;
        protocolSection.setLayoutData(protocolSectionData);
        protocolGroup = widgetFactory.createComposite(protocolSection);
        GridLayout protocolGroupLayout = new GridLayout();
        protocolGroupLayout.numColumns = 3;
        protocolGroup.setLayout(protocolGroupLayout);
        protocolSection.setClient(protocolGroup);
        return protocolGroup;
    }

    /**
     * @generated NOT
     */
    protected Composite createCacheProtocolTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control cacheProtocolTypeLabel = createDescription(parent,
                EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType,
                EsbMessages.CacheMediatorPropertiesEditionPart_CacheProtocolTypeLabel);
        cacheProtocolType = new EMFComboViewer(parent);
        cacheProtocolType.setContentProvider(new ArrayContentProvider());
        cacheProtocolType
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData cacheProtocolTypeData = new GridData(GridData.FILL_HORIZONTAL);
        cacheProtocolType.getCombo().setLayoutData(cacheProtocolTypeData);
        cacheProtocolType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;

            }
        });
        cacheProtocolType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getCacheProtocolType()));
            }

        });
        cacheProtocolType.setID(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType);
        Control cacheProtocolTypeHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Protocol.cacheProtocolType,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createCacheProtocolTypeEMFComboViewer
        cacheProtocolTypeElements = new Control[] { cacheProtocolTypeLabel, cacheProtocolType.getCombo(),
                cacheProtocolTypeHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createCacheProtocolMethodsText(FormToolkit widgetFactory, Composite parent) {
        Control cacheProtocolMethodsLabel = createDescription(parent,
                EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods,
                EsbMessages.CacheMediatorPropertiesEditionPart_CacheProtocolMethodsLabel);
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
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    cacheProtocolMethods.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    cacheProtocolMethods.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        cacheProtocolMethods.getText()));
                }
            }
        });
        EditingUtils.setID(cacheProtocolMethods, EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods);
        EditingUtils.setEEFtype(cacheProtocolMethods, "eef::Text"); //$NON-NLS-1$
        Control cacheProtocolMethodsHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createCacheProtocolMethodsText
        cacheProtocolMethodsElements = new Control[] { cacheProtocolMethodsLabel, cacheProtocolMethods,
                cacheProtocolMethodsHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createHeadersToExcludeInHashText(FormToolkit widgetFactory, Composite parent) {
        Control headersToExcludeInHashLabel = createDescription(parent,
                EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash,
                EsbMessages.CacheMediatorPropertiesEditionPart_HeadersToExcludeInHashLabel);
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
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    headersToExcludeInHash.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    headersToExcludeInHash.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        headersToExcludeInHash.getText()));
                }
            }
        });
        EditingUtils.setID(headersToExcludeInHash, EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash);
        EditingUtils.setEEFtype(headersToExcludeInHash, "eef::Text"); //$NON-NLS-1$
        Control headersToExcludeInHashHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createHeadersToExcludeInHashText
        headersToExcludeInHashElements = new Control[] { headersToExcludeInHashLabel, headersToExcludeInHash,
                headersToExcludeInHashHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createResponseCodesText(FormToolkit widgetFactory, Composite parent) {
        Control responseCodesLabel = createDescription(parent, EsbViewsRepository.CacheMediator.Protocol.responseCodes,
                EsbMessages.CacheMediatorPropertiesEditionPart_ResponseCodesLabel);
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
                            EsbViewsRepository.CacheMediator.Protocol.responseCodes, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, responseCodes.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.Protocol.responseCodes,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    responseCodes.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CacheMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CacheMediator.Protocol.responseCodes, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, responseCodes.getText()));
                }
            }
        });
        EditingUtils.setID(responseCodes, EsbViewsRepository.CacheMediator.Protocol.responseCodes);
        EditingUtils.setEEFtype(responseCodes, "eef::Text"); //$NON-NLS-1$
        Control responseCodesHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.CacheMediator.Protocol.responseCodes, EsbViewsRepository.FORM_KIND),
                        null); // $NON-NLS-1$
        // Start of user code for createResponseCodesText
        responseCodesElements = new Control[] { responseCodesLabel, responseCodes, responseCodesHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createEnableCacheControlCheckbox(FormToolkit widgetFactory, Composite parent) {
        enableCacheControl = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.CacheMediator.Protocol.enableCacheControl,
                        EsbMessages.CacheMediatorPropertiesEditionPart_EnableCacheControlLabel),
                SWT.CHECK);
        enableCacheControl.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CacheMediator.Protocol.enableCacheControl, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new Boolean(enableCacheControl.getSelection())));
            }

        });
        GridData enableCacheControlData = new GridData(GridData.FILL_HORIZONTAL);
        enableCacheControlData.horizontalSpan = 2;
        enableCacheControl.setLayoutData(enableCacheControlData);
        EditingUtils.setID(enableCacheControl, EsbViewsRepository.CacheMediator.Protocol.enableCacheControl);
        EditingUtils.setEEFtype(enableCacheControl, "eef::Checkbox"); //$NON-NLS-1$
        Control enableCacheControlHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Protocol.enableCacheControl,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createEnableCacheControlCheckbox
        enableCacheControlElements = new Control[] { enableCacheControl,
                enableCacheControlHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createIncludeAgeHeaderCheckbox(FormToolkit widgetFactory, Composite parent) {
        Control includeAgeHeaderLabel = includeAgeHeader = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader,
                        EsbMessages.CacheMediatorPropertiesEditionPart_IncludeAgeHeaderLabel),
                SWT.CHECK);
        includeAgeHeader.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new Boolean(includeAgeHeader.getSelection())));
            }

        });
        GridData includeAgeHeaderData = new GridData(GridData.FILL_HORIZONTAL);
        includeAgeHeaderData.horizontalSpan = 2;
        includeAgeHeader.setLayoutData(includeAgeHeaderData);
        EditingUtils.setID(includeAgeHeader, EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader);
        EditingUtils.setEEFtype(includeAgeHeader, "eef::Checkbox"); //$NON-NLS-1$
        Control includeAgeHeaderHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.CacheMediator.Protocol.includeAgeHeader,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createIncludeAgeHeaderCheckbox
        includeAgeHeaderElements = new Control[] { includeAgeHeaderLabel, includeAgeHeader, includeAgeHeaderHelp };
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createHashGeneratorText(FormToolkit widgetFactory, Composite parent) {
        Control hashGeneratorLabel = createDescription(parent, EsbViewsRepository.CacheMediator.Protocol.hashGenerator,
                EsbMessages.CacheMediatorPropertiesEditionPart_HashGeneratorLabel);
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
                            EsbViewsRepository.CacheMediator.Protocol.hashGenerator, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, hashGenerator.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.Protocol.hashGenerator,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    hashGenerator.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CacheMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CacheMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CacheMediator.Protocol.hashGenerator, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, hashGenerator.getText()));
                }
            }
        });
        EditingUtils.setID(hashGenerator, EsbViewsRepository.CacheMediator.Protocol.hashGenerator);
        EditingUtils.setEEFtype(hashGenerator, "eef::Text"); //$NON-NLS-1$
        Control hashGeneratorHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.CacheMediator.Protocol.hashGenerator, EsbViewsRepository.FORM_KIND),
                        null); // $NON-NLS-1$
        // Start of user code for createHashGeneratorText
        hashGeneratorElements = new Control[] { hashGeneratorLabel, hashGenerator, hashGeneratorHelp };
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
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getCacheMediatorImplementation()
   * 
   */
  public Enumerator getCacheMediatorImplementation() {
    Enumerator selection = (Enumerator) ((StructuredSelection) cacheMediatorImplementation.getSelection()).getFirstElement();
    return selection;
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#initCacheMediatorImplementation(Object input, Enumerator current)
   */
  public void initCacheMediatorImplementation(Object input, Enumerator current) {
    cacheMediatorImplementation.setInput(input);
    cacheMediatorImplementation.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation);
    if (eefElementEditorReadOnlyState && cacheMediatorImplementation.isEnabled()) {
      cacheMediatorImplementation.setEnabled(false);
      cacheMediatorImplementation.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !cacheMediatorImplementation.isEnabled()) {
      cacheMediatorImplementation.setEnabled(true);
    }	
    
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setCacheMediatorImplementation(Enumerator newValue)
   * 
   */
  public void setCacheMediatorImplementation(Enumerator newValue) {
    cacheMediatorImplementation.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Type.cacheMediatorImplementation);
    if (eefElementEditorReadOnlyState && cacheMediatorImplementation.isEnabled()) {
      cacheMediatorImplementation.setEnabled(false);
      cacheMediatorImplementation.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !cacheMediatorImplementation.isEnabled()) {
      cacheMediatorImplementation.setEnabled(true);
    }	
    
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getId()
   * 
   */
  public String getId() {
    return id.getText();
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setId(String newValue)
   * 
   */
  public void setId(String newValue) {
    if (newValue != null) {
      id.setText(newValue);
    } else {
      id.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.id);
    if (eefElementEditorReadOnlyState && id.isEnabled()) {
      id.setEnabled(false);
      id.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !id.isEnabled()) {
      id.setEnabled(true);
    }	
    
  }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getCacheType()
     * 
     */
    public Enumerator getCacheType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) cacheType.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#initCacheType(Object
     *      input, Enumerator current)
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setCacheType(Enumerator
     *      newValue)
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
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getScope()
   * 
   */
  public Enumerator getScope() {
    Enumerator selection = (Enumerator) ((StructuredSelection) scope.getSelection()).getFirstElement();
    return selection;
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#initScope(Object input, Enumerator current)
   */
  public void initScope(Object input, Enumerator current) {
    scope.setInput(input);
    scope.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.scope);
    if (eefElementEditorReadOnlyState && scope.isEnabled()) {
      scope.setEnabled(false);
      scope.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !scope.isEnabled()) {
      scope.setEnabled(true);
    }	
    
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setScope(Enumerator newValue)
   * 
   */
  public void setScope(Enumerator newValue) {
    scope.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.scope);
    if (eefElementEditorReadOnlyState && scope.isEnabled()) {
      scope.setEnabled(false);
      scope.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !scope.isEnabled()) {
      scope.setEnabled(true);
    }	
    
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getHashGeneratorAttribute()
   * 
   */
  public String getHashGeneratorAttribute() {
    return hashGeneratorAttribute.getText();
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setHashGeneratorAttribute(String newValue)
   * 
   */
  public void setHashGeneratorAttribute(String newValue) {
    if (newValue != null) {
      hashGeneratorAttribute.setText(newValue);
    } else {
      hashGeneratorAttribute.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Properties.hashGeneratorAttribute);
    if (eefElementEditorReadOnlyState && hashGeneratorAttribute.isEnabled()) {
      hashGeneratorAttribute.setEnabled(false);
      hashGeneratorAttribute.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !hashGeneratorAttribute.isEnabled()) {
      hashGeneratorAttribute.setEnabled(true);
    }	
    
  }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getCacheTimeout()
     * 
     */
    public String getCacheTimeout() {
        return cacheTimeout.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setCacheTimeout(String
     *      newValue)
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getMaxMessageSize()
     * 
     */
    public String getMaxMessageSize() {
        return maxMessageSize.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setMaxMessageSize(String
     *      newValue)
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
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getCommentsList()
   * 
   */
  public EList getCommentsList() {
    return commentsListList;
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setCommentsList(EList newValue)
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
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getReverse()
   * 
   */
  public Boolean getReverse() {
    return Boolean.valueOf(reverse.getSelection());
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setReverse(Boolean newValue)
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getMaxEntryCount()
     * 
     */
    public String getMaxEntryCount() {
        return maxEntryCount.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setMaxEntryCount(String
     *      newValue)
     * 
     */
    public void setMaxEntryCount(String newValue) {
        if (newValue != null) {
            maxEntryCount.setText(newValue);
        } else {
            maxEntryCount.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.CacheMediator.Implementation.maxEntryCount);
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
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getImplementationType()
   * 
   */
  public Enumerator getImplementationType() {
    Enumerator selection = (Enumerator) ((StructuredSelection) implementationType.getSelection()).getFirstElement();
    return selection;
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#initImplementationType(Object input, Enumerator current)
   */
  public void initImplementationType(Object input, Enumerator current) {
    implementationType.setInput(input);
    implementationType.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Implementation.implementationType);
    if (eefElementEditorReadOnlyState && implementationType.isEnabled()) {
      implementationType.setEnabled(false);
      implementationType.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !implementationType.isEnabled()) {
      implementationType.setEnabled(true);
    }	
    
  }

    /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setImplementationType(Enumerator newValue)
   * 
   */
  public void setImplementationType(Enumerator newValue) {
    implementationType.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CacheMediator.Implementation.implementationType);
    if (eefElementEditorReadOnlyState && implementationType.isEnabled()) {
      implementationType.setEnabled(false);
      implementationType.setToolTipText(EsbMessages.CacheMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !implementationType.isEnabled()) {
      implementationType.setEnabled(true);
    }	
    
  }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getDescription()
     * 
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setDescription(String
     *      newValue)
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

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getSequenceType()
     * 
     */
    public Enumerator getSequenceType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) sequenceType.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#initSequenceType(Object
     *      input, Enumerator current)
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setSequenceType(Enumerator
     *      newValue)
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getCacheProtocolType()
     * 
     */
    public Enumerator getCacheProtocolType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) cacheProtocolType.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#initCacheProtocolType(Object
     *      input, Enumerator current)
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setCacheProtocolType(Enumerator
     *      newValue)
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getCacheProtocolMethods()
     * 
     */
    public String getCacheProtocolMethods() {
        return cacheProtocolMethods.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setCacheProtocolMethods(String
     *      newValue)
     * 
     */
    public void setCacheProtocolMethods(String newValue) {
        if (newValue != null) {
            cacheProtocolMethods.setText(newValue);
        } else {
            cacheProtocolMethods.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.CacheMediator.Protocol.cacheProtocolMethods);
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getHeadersToExcludeInHash()
     * 
     */
    public String getHeadersToExcludeInHash() {
        return headersToExcludeInHash.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setHeadersToExcludeInHash(String
     *      newValue)
     * 
     */
    public void setHeadersToExcludeInHash(String newValue) {
        if (newValue != null) {
            headersToExcludeInHash.setText(newValue);
        } else {
            headersToExcludeInHash.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.CacheMediator.Protocol.headersToExcludeInHash);
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getResponseCodes()
     * 
     */
    public String getResponseCodes() {
        return responseCodes.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setResponseCodes(String
     *      newValue)
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getEnableCacheControl()
     * 
     */
    public Boolean getEnableCacheControl() {
        return Boolean.valueOf(enableCacheControl.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setEnableCacheControl(Boolean
     *      newValue)
     * 
     */
    public void setEnableCacheControl(Boolean newValue) {
        if (newValue != null) {
            enableCacheControl.setSelection(newValue.booleanValue());
        } else {
            enableCacheControl.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.CacheMediator.Protocol.enableCacheControl);
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getIncludeAgeHeader()
     * 
     */
    public Boolean getIncludeAgeHeader() {
        return Boolean.valueOf(includeAgeHeader.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setIncludeAgeHeader(Boolean
     *      newValue)
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#getHashGenerator()
     * 
     */
    public String getHashGenerator() {
        return hashGenerator.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CacheMediatorPropertiesEditionPart#setHashGenerator(String
     *      newValue)
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

    // Start of user code for sequenceKey specific getters and setters implementation
    @Override
    public void setSequenceKey(RegistryKeyProperty registryKeyProperty) {
        if (sequenceKey != null) {
            sequenceKey = registryKeyProperty;
            sequenceKeyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getSequenceKey() {
        return sequenceKey;
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
    protected Composite createSequenceKey(FormToolkit widgetFactory, final Composite parent) {
        Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.CacheMediator.OnCacheHit.sequenceKey,
                EsbMessages.CacheMediatorPropertiesEditionPart_SequenceKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (sequenceKey == null) {
            sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initSequenceKey = sequenceKey.getKeyValue().isEmpty() ? "" : sequenceKey.getKeyValue();
        sequenceKeyText = widgetFactory.createText(parent, initSequenceKey, SWT.READ_ONLY);
        sequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        sequenceKeyText.setLayoutData(valueData);
        sequenceKeyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                sequenceKeyText.setText(sequenceKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.CacheMediator.OnCacheHit.sequenceKey, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getSequenceKey()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        
        sequenceKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    sequenceKeyText.setText(sequenceKey.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(CacheMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CacheMediator.OnCacheHit.sequenceKey, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getSequenceKey()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(sequenceKeyText, EsbViewsRepository.CacheMediator.OnCacheHit.sequenceKey);
        EditingUtils.setEEFtype(sequenceKeyText, "eef::Text");
        Control sequenceKeyHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.CacheMediator.OnCacheHit.sequenceKey, EsbViewsRepository.FORM_KIND),
                        null);
        sequenceKeyElements = new Control[] { sequenceKeyLabel, sequenceKeyText, sequenceKeyHelp };
        return parent;
    }

    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { typeGroup });
        eu.clearElements(new Composite[] { propertiesGroup });
        eu.clearElements(new Composite[] { implementationGroup });
        eu.clearElements(new Composite[] { miscGroup });
        eu.clearElements(new Composite[] { onCacheHitGroup });
        eu.clearElements(new Composite[] { protocolGroup });

        eu.showEntry(cacheMediatorImplementationElements, false);
        
        
        boolean previousCacheImplementation = false;
        if (getCacheMediatorImplementation() != null) {
            previousCacheImplementation = getCacheMediatorImplementation().getName().equals(CacheMediatorType.COMPATIBILITY_611.getName());
        }
        
        eu.showEntry(cacheTypeElements, false);

        if (getCacheType() != null && getCacheType().getName().equals(CacheType.FINDER.getName())) {
            
            if (!implementationSection.isVisible()) {
                implementationSection.setVisible(true);
            }
            if (!onCacheHitSection.isVisible()) {
                onCacheHitSection.setVisible(true);
            }
            
            if (!previousCacheImplementation) {
                if (!protocolSection.isVisible()) {
                    protocolSection.setVisible(true);
                }
                
                eu.showEntry(cacheProtocolTypeElements, false);
                eu.showEntry(cacheProtocolMethodsElements, false);
                eu.showEntry(headersToExcludeInHashElements, false);
                eu.showEntry(responseCodesElements, false);
                eu.showEntry(enableCacheControlElements, false);
                eu.showEntry(includeAgeHeaderElements, false);
                eu.showEntry(hashGeneratorElements, false);
                
                ((GridData) protocolSection.getLayoutData()).exclude = false;
            } else {
                eu.showEntry(idElements, false);
                eu.showEntry(scopeElements, false);
                eu.showEntry(hashGeneratorAttributeElements, false);
                eu.showEntry(implementationTypeElements, false);
            }

            eu.showEntry(cacheTimeoutElements, false);
            eu.showEntry(maxMessageSizeElements, false);
            eu.showEntry(maxEntryCountElements, false);
            eu.showEntry(sequenceTypeElements, false);

            if (getSequenceType() != null
                    && getSequenceType().getName().equals(CacheSequenceType.REGISTRY_REFERENCE.getName())) {
                eu.showEntry(sequenceKeyElements, false);
            }

            ((GridData) implementationSection.getLayoutData()).exclude = false;
            ((GridData) onCacheHitSection.getLayoutData()).exclude = false;

        } else {
            if (previousCacheImplementation) {
                eu.showEntry(scopeElements, false);
            }
            implementationSection.setVisible(false);
            ((GridData) implementationSection.getLayoutData()).exclude = true;
            onCacheHitSection.setVisible(false);
            ((GridData) onCacheHitSection.getLayoutData()).exclude = true;
            protocolSection.setVisible(false);
            ((GridData) protocolSection.getLayoutData()).exclude = true;
        }

        if (previousCacheImplementation) {
            protocolSection.setVisible(false);
            ((GridData) protocolSection.getLayoutData()).exclude = true;
        }
        eu.showEntry(descriptionElements, false);
        view.layout(true, true);
    }

    // End of user code

}
