/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

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

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.eclipse.gmf.esb.AggregateSequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CompletionMessagesType;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart;
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
public class CloneTargetPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, CloneTargetPropertiesEditionPart {

    protected EMFComboViewer sequenceType;
    protected EObjectFlatComboViewer sequence;
    protected EMFComboViewer endpointType;
    protected Text soapAction;
    protected Text toAddress;
    // Start of user code for endpointRegistryKey widgets declarations
    protected RegistryKeyProperty endpointKey;
    protected Text endpointKeyText;
    // End of user code

    // Start of user code for sequenceRegistryKey widgets declarations
    protected RegistryKeyProperty sequenceKey;
    protected Text sequenceKeyText;
    protected Control[] sequenceTypeElements;
    protected Control[] sequenceElements;
    protected Control[] sequenceKeyElements;
    protected Control[] endpointTypeElements;
    protected Control[] endpointKeyElements;
    protected Control[] soapActionElements;
    protected Control[] toAddressElements;
    protected Composite propertiesGroup;
    // End of user code

    /**
     * For {@link ISection} use only.
     */
    public CloneTargetPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public CloneTargetPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
     *      createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
     * 
     */
    public void createControls(final FormToolkit widgetFactory, Composite view) {
        CompositionSequence cloneTargetStep = new BindingCompositionSequence(propertiesEditionComponent);
        CompositionStep propertiesStep = cloneTargetStep.addStep(EsbViewsRepository.CloneTarget.Properties.class);
        propertiesStep.addStep(EsbViewsRepository.CloneTarget.Properties.sequenceType);
        propertiesStep.addStep(EsbViewsRepository.CloneTarget.Properties.sequence);
        propertiesStep.addStep(EsbViewsRepository.CloneTarget.Properties.endpointType);
        propertiesStep.addStep(EsbViewsRepository.CloneTarget.Properties.soapAction);
        propertiesStep.addStep(EsbViewsRepository.CloneTarget.Properties.toAddress);
        propertiesStep.addStep(EsbViewsRepository.CloneTarget.Properties.endpointRegistryKey);
        propertiesStep.addStep(EsbViewsRepository.CloneTarget.Properties.sequenceRegistryKey);

        composer = new PartComposer(cloneTargetStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.CloneTarget.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneTarget.Properties.sequenceType) {
                    return createSequenceTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneTarget.Properties.sequence) {
                    return createSequenceFlatComboViewer(parent, widgetFactory);
                }
                if (key == EsbViewsRepository.CloneTarget.Properties.endpointType) {
                    return createEndpointTypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneTarget.Properties.soapAction) {
                    return createSoapActionText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.CloneTarget.Properties.toAddress) {
                    return createToAddressText(widgetFactory, parent);
                }
                // Start of user code for endpointRegistryKey addToPart creation
                if (key == EsbViewsRepository.CloneTarget.Properties.sequenceRegistryKey) {
                    return createSequenceKeyWidget(widgetFactory, parent);
                }
                // End of user code
                // Start of user code for sequenceRegistryKey addToPart creation
                if (key == EsbViewsRepository.CloneTarget.Properties.endpointRegistryKey) {
                    return createEndpointKeyWidget(widgetFactory, parent);
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
        Section propertiesSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        propertiesSection.setText(EsbMessages.CloneTargetPropertiesEditionPart_PropertiesGroupLabel);
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
     * @generated NOT
     */
    protected Composite createSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control sequenceTypeLabel = createDescription(parent, EsbViewsRepository.CloneTarget.Properties.sequenceType,
                EsbMessages.CloneTargetPropertiesEditionPart_SequenceTypeLabel);
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
                            CloneTargetPropertiesEditionPartForm.this,
                            EsbViewsRepository.CloneTarget.Properties.sequenceType, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getSequenceType()));
            }

        });
        sequenceType.setID(EsbViewsRepository.CloneTarget.Properties.sequenceType);
        Control sequenceTypeHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.CloneTarget.Properties.sequenceType, EsbViewsRepository.FORM_KIND),
                        null); // $NON-NLS-1$
        // Start of user code for createSequenceTypeEMFComboViewer
        sequenceTypeElements = new Control[] { sequenceTypeLabel, sequenceType.getCombo(), sequenceTypeHelp };
        sequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });
        // End of user code
        return parent;
    }

    /**
     * @param parent the parent composite
     * @param widgetFactory factory to use to instanciante widget of the form
     * @generated NOT
     */
    protected Composite createSequenceFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
        Control sequenceLabel = createDescription(parent, EsbViewsRepository.CloneTarget.Properties.sequence,
                EsbMessages.CloneTargetPropertiesEditionPart_SequenceLabel);
        sequence = new EObjectFlatComboViewer(parent, !propertiesEditionComponent
                .isRequired(EsbViewsRepository.CloneTarget.Properties.sequence, EsbViewsRepository.FORM_KIND));
        widgetFactory.adapt(sequence);
        sequence.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
        GridData sequenceData = new GridData(GridData.FILL_HORIZONTAL);
        sequence.setLayoutData(sequenceData);
        sequence.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(CloneTargetPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CloneTarget.Properties.sequence, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getSequence()));
            }

        });
        sequence.setID(EsbViewsRepository.CloneTarget.Properties.sequence);
        Control sequenceHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CloneTarget.Properties.sequence, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createSequenceFlatComboViewer
        sequenceElements = new Control[] {sequenceLabel, sequence, sequenceHelp};
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createEndpointTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        Control endpointTypeLabel = createDescription(parent, EsbViewsRepository.CloneTarget.Properties.endpointType,
                EsbMessages.CloneTargetPropertiesEditionPart_EndpointTypeLabel);
        endpointType = new EMFComboViewer(parent);
        endpointType.setContentProvider(new ArrayContentProvider());
        endpointType
                .setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
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
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CloneTargetPropertiesEditionPartForm.this,
                            EsbViewsRepository.CloneTarget.Properties.endpointType, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getEndpointType()));
            }

        });
        endpointType.setID(EsbViewsRepository.CloneTarget.Properties.endpointType);
        Control endpointTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CloneTarget.Properties.endpointType, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createEndpointTypeEMFComboViewer
        endpointTypeElements = new Control[] {endpointTypeLabel, endpointType.getCombo(), endpointTypeHelp};
        endpointType.addSelectionChangedListener(new ISelectionChangedListener() {
            
            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createSoapActionText(FormToolkit widgetFactory, Composite parent) {
        Control soapActionLabel = createDescription(parent, EsbViewsRepository.CloneTarget.Properties.soapAction,
                EsbMessages.CloneTargetPropertiesEditionPart_SoapActionLabel);
        soapAction = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        soapAction.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData soapActionData = new GridData(GridData.FILL_HORIZONTAL);
        soapAction.setLayoutData(soapActionData);
        soapAction.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(CloneTargetPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CloneTarget.Properties.soapAction, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, soapAction.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CloneTargetPropertiesEditionPartForm.this,
                            EsbViewsRepository.CloneTarget.Properties.soapAction, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, soapAction.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CloneTargetPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        soapAction.addKeyListener(new KeyAdapter() {
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
                                CloneTargetPropertiesEditionPartForm.this,
                                EsbViewsRepository.CloneTarget.Properties.soapAction, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, soapAction.getText()));
                }
            }
        });
        EditingUtils.setID(soapAction, EsbViewsRepository.CloneTarget.Properties.soapAction);
        EditingUtils.setEEFtype(soapAction, "eef::Text"); //$NON-NLS-1$
        Control soapActionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CloneTarget.Properties.soapAction, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createSoapActionText
        soapActionElements = new Control[] {soapActionLabel, soapAction, soapActionHelp};
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createToAddressText(FormToolkit widgetFactory, Composite parent) {
        Control toAddressLabel = createDescription(parent, EsbViewsRepository.CloneTarget.Properties.toAddress,
                EsbMessages.CloneTargetPropertiesEditionPart_ToAddressLabel);
        toAddress = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        toAddress.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData toAddressData = new GridData(GridData.FILL_HORIZONTAL);
        toAddress.setLayoutData(toAddressData);
        toAddress.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(CloneTargetPropertiesEditionPartForm.this,
                                    EsbViewsRepository.CloneTarget.Properties.toAddress, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, toAddress.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CloneTargetPropertiesEditionPartForm.this,
                            EsbViewsRepository.CloneTarget.Properties.toAddress, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, toAddress.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CloneTargetPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        toAddress.addKeyListener(new KeyAdapter() {
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
                                CloneTargetPropertiesEditionPartForm.this,
                                EsbViewsRepository.CloneTarget.Properties.toAddress, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, toAddress.getText()));
                }
            }
        });
        EditingUtils.setID(toAddress, EsbViewsRepository.CloneTarget.Properties.toAddress);
        EditingUtils.setEEFtype(toAddress, "eef::Text"); //$NON-NLS-1$
        Control toAddressHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.CloneTarget.Properties.toAddress, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createToAddressText
        toAddressElements = new Control[] {toAddressLabel, sequenceType.getCombo(), toAddressHelp};
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#getSequenceType()
     * 
     */
    public Enumerator getSequenceType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) sequenceType.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#initSequenceType(Object
     *      input, Enumerator current)
     */
    public void initSequenceType(Object input, Enumerator current) {
        sequenceType.setInput(input);
        sequenceType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneTarget.Properties.sequenceType);
        if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
            sequenceType.setEnabled(false);
            sequenceType.setToolTipText(EsbMessages.CloneTarget_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
            sequenceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#setSequenceType(Enumerator
     *      newValue)
     * 
     */
    public void setSequenceType(Enumerator newValue) {
        sequenceType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneTarget.Properties.sequenceType);
        if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
            sequenceType.setEnabled(false);
            sequenceType.setToolTipText(EsbMessages.CloneTarget_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
            sequenceType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#getSequence()
     * 
     */
    public EObject getSequence() {
        if (sequence.getSelection() instanceof StructuredSelection) {
            Object firstElement = ((StructuredSelection) sequence.getSelection()).getFirstElement();
            if (firstElement instanceof EObject)
                return (EObject) firstElement;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#initSequence(EObjectFlatComboSettings)
     */
    public void initSequence(EObjectFlatComboSettings settings) {
        sequence.setInput(settings);
        if (current != null) {
            sequence.setSelection(new StructuredSelection(settings.getValue()));
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneTarget.Properties.sequence);
        if (eefElementEditorReadOnlyState && sequence.isEnabled()) {
            sequence.setEnabled(false);
            sequence.setToolTipText(EsbMessages.CloneTarget_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sequence.isEnabled()) {
            sequence.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#setSequence(EObject
     *      newValue)
     * 
     */
    public void setSequence(EObject newValue) {
        if (newValue != null) {
            sequence.setSelection(new StructuredSelection(newValue));
        } else {
            sequence.setSelection(new StructuredSelection()); // $NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneTarget.Properties.sequence);
        if (eefElementEditorReadOnlyState && sequence.isEnabled()) {
            sequence.setEnabled(false);
            sequence.setToolTipText(EsbMessages.CloneTarget_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !sequence.isEnabled()) {
            sequence.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#setSequenceButtonMode(ButtonsModeEnum
     *      newValue)
     */
    public void setSequenceButtonMode(ButtonsModeEnum newValue) {
        sequence.setButtonMode(newValue);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#addFilterSequence(ViewerFilter
     *      filter)
     * 
     */
    public void addFilterToSequence(ViewerFilter filter) {
        sequence.addFilter(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#addBusinessFilterSequence(ViewerFilter
     *      filter)
     * 
     */
    public void addBusinessFilterToSequence(ViewerFilter filter) {
        sequence.addBusinessRuleFilter(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#getEndpointType()
     * 
     */
    public Enumerator getEndpointType() {
        Enumerator selection = (Enumerator) ((StructuredSelection) endpointType.getSelection()).getFirstElement();
        return selection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#initEndpointType(Object
     *      input, Enumerator current)
     */
    public void initEndpointType(Object input, Enumerator current) {
        endpointType.setInput(input);
        endpointType.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneTarget.Properties.endpointType);
        if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
            endpointType.setEnabled(false);
            endpointType.setToolTipText(EsbMessages.CloneTarget_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
            endpointType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#setEndpointType(Enumerator
     *      newValue)
     * 
     */
    public void setEndpointType(Enumerator newValue) {
        endpointType.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneTarget.Properties.endpointType);
        if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
            endpointType.setEnabled(false);
            endpointType.setToolTipText(EsbMessages.CloneTarget_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
            endpointType.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#getSoapAction()
     * 
     */
    public String getSoapAction() {
        return soapAction.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#setSoapAction(String
     *      newValue)
     * 
     */
    public void setSoapAction(String newValue) {
        if (newValue != null) {
            soapAction.setText(newValue);
        } else {
            soapAction.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneTarget.Properties.soapAction);
        if (eefElementEditorReadOnlyState && soapAction.isEnabled()) {
            soapAction.setEnabled(false);
            soapAction.setToolTipText(EsbMessages.CloneTarget_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !soapAction.isEnabled()) {
            soapAction.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#getToAddress()
     * 
     */
    public String getToAddress() {
        return toAddress.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart#setToAddress(String
     *      newValue)
     * 
     */
    public void setToAddress(String newValue) {
        if (newValue != null) {
            toAddress.setText(newValue);
        } else {
            toAddress.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneTarget.Properties.toAddress);
        if (eefElementEditorReadOnlyState && toAddress.isEnabled()) {
            toAddress.setEnabled(false);
            toAddress.setToolTipText(EsbMessages.CloneTarget_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !toAddress.isEnabled()) {
            toAddress.setEnabled(true);
        }

    }

    // Start of user code for endpointRegistryKey specific getters and setters implementation

    @Override
    public RegistryKeyProperty getEndpointKey() {
        return endpointKey;
    }

    @Override
    public void setEndpointKey(RegistryKeyProperty registryKeyProperty) {
        if (endpointKey != null) {
            endpointKeyText.setText(registryKeyProperty.getKeyValue());
            endpointKey = registryKeyProperty;
        }

    }

    // End of user code

    // Start of user code for sequenceRegistryKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getSequenceKey() {
        return sequenceKey;
    }

    @Override
    public void setSequenceKey(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            sequenceKeyText.setText(registryKeyProperty.getKeyValue());
            sequenceKey = registryKeyProperty;
        }
    }

    // End of user code

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     * 
     */

    // Start of user code additional methods
    protected Composite createEndpointKeyWidget(FormToolkit widgetFactory, Composite parent) {
        Control endpointKeyLabel = createDescription(parent,
                EsbViewsRepository.CloneTarget.Properties.endpointRegistryKey,
                EsbMessages.CloneTargetPropertiesEditionPart_EndpointRegistryKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (endpointKey == null) {
            endpointKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initValueExpression = endpointKey.getKeyValue().isEmpty() ? "" : endpointKey.getKeyValue();
        endpointKeyText = widgetFactory.createText(parent, initValueExpression);
        endpointKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        endpointKeyText.setLayoutData(valueData);
        endpointKeyText.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, endpointKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                endpointKeyText.setText(endpointKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(CloneTargetPropertiesEditionPartForm.this,
                                EsbViewsRepository.CloneTarget.Properties.sequenceRegistryKey,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceKey()));
            }
        });
        EditingUtils.setID(endpointKeyText, EsbViewsRepository.AggregateMediator.OnComplete.sequenceKey);
        EditingUtils.setEEFtype(endpointKeyText, "eef::Text");
        Control endpointKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneTarget.Properties.endpointRegistryKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        endpointKeyElements = new Control[] { endpointKeyLabel, endpointKeyText, endpointKeyHelp };
        return parent;
    }

    protected Composite createSequenceKeyWidget(FormToolkit widgetFactory, Composite parent) {
        Control sequenceKeyLabel = createDescription(parent,
                EsbViewsRepository.CloneTarget.Properties.sequenceRegistryKey,
                EsbMessages.CloneTargetPropertiesEditionPart_SequenceRegistryKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (sequenceKey == null) {
            sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initValueExpression = sequenceKey.getKeyValue().isEmpty() ? "" : sequenceKey.getKeyValue();
        sequenceKeyText = widgetFactory.createText(parent, initValueExpression);
        sequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        sequenceKeyText.setLayoutData(valueData);
        sequenceKeyText.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                sequenceKeyText.setText(sequenceKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(CloneTargetPropertiesEditionPartForm.this,
                                EsbViewsRepository.CloneTarget.Properties.sequenceRegistryKey,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceKey()));
            }
        });
        EditingUtils.setID(sequenceKeyText, EsbViewsRepository.AggregateMediator.OnComplete.sequenceKey);
        EditingUtils.setEEFtype(sequenceKeyText, "eef::Text");
        Control sequenceKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneTarget.Properties.sequenceRegistryKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
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
        eu.clearElements(new Composite[] {propertiesGroup});
        eu.showEntry(sequenceTypeElements, false);
        eu.showEntry(sequenceKeyElements, false);
        eu.showEntry(endpointTypeElements, false);
        eu.showEntry(sequenceKeyElements, false);
        eu.showEntry(soapActionElements, false);
        eu.showEntry(toAddressElements, false);
    }


    // End of user code

    public String getTitle() {
        return EsbMessages.CloneTarget_Part_Title;
    }
}
