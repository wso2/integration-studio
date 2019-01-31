/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class PayloadFactoryMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, PayloadFactoryMediatorPropertiesEditionPart {

	protected EMFComboViewer payloadFormat;
	// Start of user code  for payloadKey widgets declarations
	Control[] payloadFormatElements;
	Control[] payloadElements;
	Control[] mediaTypeElements;
	Control[] descriptionElements;
	Control[] payloadKeyElements;
	
	RegistryKeyProperty payloadKey;
	Text payloadKeyText;
	// End of user code

	protected Text payload;
	protected ReferencesTable args;
	protected List<ViewerFilter> argsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> argsFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer mediaType;
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public PayloadFactoryMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public PayloadFactoryMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence payloadFactoryMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = payloadFactoryMediatorStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.payload);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.args);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.description);
		
		
		composer = new PartComposer(payloadFactoryMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat) {
					return createPayloadFormatEMFComboViewer(widgetFactory, parent);
				}
				// Start of user code for payloadKey addToPart creation
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey) {
					return createPayloadKey(widgetFactory, parent);
				}
				// End of user code
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.payload) {
					return createPayloadText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.args) {
					return createArgsTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType) {
					return createMediaTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_PropertiesGroupLabel);
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

	/**
     * @generated NOT
     */
	protected Composite createPayloadFormatEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control payloadFormatLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_PayloadFormatLabel);
		payloadFormat = new EMFComboViewer(parent);
		payloadFormat.setContentProvider(new ArrayContentProvider());
		payloadFormat.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData payloadFormatData = new GridData(GridData.FILL_HORIZONTAL);
		payloadFormat.getCombo().setLayoutData(payloadFormatData);
		payloadFormat.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPayloadFormat()));
			}

		});
		payloadFormat.setID(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat);
		Control payloadFormatHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadFormatEMFComboViewer
		payloadFormatElements = new Control[] {payloadFormatLabel, payloadFormat.getCombo(), payloadFormatHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPayloadText(FormToolkit widgetFactory, Composite parent) {
		Control payloadLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.payload, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_PayloadLabel);
		payload = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		payload.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData payloadData = new GridData(GridData.FILL_HORIZONTAL);
		payload.setLayoutData(payloadData);
		payload.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PayloadFactoryMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.PayloadFactoryMediator.Properties.payload,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, payload.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PayloadFactoryMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.PayloadFactoryMediator.Properties.payload,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, payload.getText()));
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
									PayloadFactoryMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		payload.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.payload, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, payload.getText()));
				}
			}
		});
		EditingUtils.setID(payload, EsbViewsRepository.PayloadFactoryMediator.Properties.payload);
		EditingUtils.setEEFtype(payload, "eef::Text"); //$NON-NLS-1$
		Control payloadHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.payload, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadText
		payloadElements = new Control[] {payloadLabel, payload, payloadHelp};
		// End of user code
		return parent;
	}

	protected Composite createArgsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.args = new ReferencesTable(getDescription(EsbViewsRepository.PayloadFactoryMediator.Properties.args, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_ArgsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				args.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				args.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				args.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				args.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.argsFilters) {
			this.args.addFilter(filter);
		}
		this.args.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.args, EsbViewsRepository.FORM_KIND));
		this.args.createControls(parent, widgetFactory);
		this.args.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createArgsTableComposition

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createMediaTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control mediaTypeLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_MediaTypeLabel);
		mediaType = new EMFComboViewer(parent);
		mediaType.setContentProvider(new ArrayContentProvider());
		mediaType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData mediaTypeData = new GridData(GridData.FILL_HORIZONTAL);
		mediaType.getCombo().setLayoutData(mediaTypeData);
		mediaType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getMediaType()));
			}

		});
		mediaType.setID(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType);
		Control mediaTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMediaTypeEMFComboViewer
		mediaTypeElements = new Control[] {mediaTypeLabel, mediaType.getCombo(), mediaTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.description, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_DescriptionLabel);
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
							PayloadFactoryMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.PayloadFactoryMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PayloadFactoryMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.PayloadFactoryMediator.Properties.description,
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
									PayloadFactoryMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.PayloadFactoryMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] {descriptionLabel, description, descriptionHelp};
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getPayloadFormat()
	 * 
	 */
	public Enumerator getPayloadFormat() {
		Enumerator selection = (Enumerator) ((StructuredSelection) payloadFormat.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#initPayloadFormat(Object input, Enumerator current)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setPayloadFormat(Enumerator newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getPayload()
	 * 
	 */
	public String getPayload() {
		return payload.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setPayload(String newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#initArgs(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#updateArgs()
	 * 
	 */
	public void updateArgs() {
	args.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#addFilterArgs(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#addBusinessFilterArgs(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToArgs(ViewerFilter filter) {
		argsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#isContainedInArgsTable(EObject element)
	 * 
	 */
	public boolean isContainedInArgsTable(EObject element) {
		return ((ReferencesTableSettings)args.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getMediaType()
	 * 
	 */
	public Enumerator getMediaType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) mediaType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#initMediaType(Object input, Enumerator current)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setMediaType(Enumerator newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setDescription(String newValue)
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
    protected Composite createPayloadKey(FormToolkit widgetFactory, Composite parent) {
        Control payloadKeyLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_PayloadKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if(payloadKey == null) {
            payloadKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        } 
        String initPayloadKey = payloadKey.getKeyValue().isEmpty() ? "" : payloadKey.getKeyValue();
        payloadKeyText = widgetFactory.createText(parent, initPayloadKey);
        payloadKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        payloadKeyText.setLayoutData(valueData);
        payloadKeyText.addFocusListener(new FocusAdapter() {
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
                EEFRegistryKeyPropertyEditorDialog dialog = new  EEFRegistryKeyPropertyEditorDialog(view.getShell(), SWT.NULL,
                        payloadKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                payloadKeyText.setText(payloadKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPayloadKey()));
            }
        });
        EditingUtils.setID(payloadKeyText, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey);
        EditingUtils.setEEFtype(payloadKeyText, "eef::Text");
        Control payloadKeyHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey, EsbViewsRepository.FORM_KIND), null);
        payloadKeyElements = new Control[] {payloadKeyLabel, payloadKeyText, payloadKeyHelp};
        return parent;
    }
	
	// End of user code


}
