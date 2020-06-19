/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class MediatorSequencePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, MediatorSequencePropertiesEditionPart {

	protected Button anonymous;
	protected Text sequenceName;
	protected ReferencesTable mediators;
	protected List<ViewerFilter> mediatorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> mediatorsFilters = new ArrayList<ViewerFilter>();
	protected EObjectFlatComboViewer onError;
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public MediatorSequencePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MediatorSequencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence mediatorSequenceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = mediatorSequenceStep.addStep(EsbViewsRepository.MediatorSequence.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.MediatorSequence.Properties.anonymous);
		propertiesStep.addStep(EsbViewsRepository.MediatorSequence.Properties.sequenceName);
		propertiesStep.addStep(EsbViewsRepository.MediatorSequence.Properties.mediators);
		propertiesStep.addStep(EsbViewsRepository.MediatorSequence.Properties.onError);
		propertiesStep.addStep(EsbViewsRepository.MediatorSequence.Properties.description);
		
		
		composer = new PartComposer(mediatorSequenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.MediatorSequence.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MediatorSequence.Properties.anonymous) {
					return createAnonymousCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MediatorSequence.Properties.sequenceName) {
					return createSequenceNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MediatorSequence.Properties.mediators) {
					return createMediatorsReferencesTable(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MediatorSequence.Properties.onError) {
					return createOnErrorFlatComboViewer(parent, widgetFactory);
				}
				if (key == EsbViewsRepository.MediatorSequence.Properties.description) {
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
		propertiesSection.setText(EsbMessages.MediatorSequencePropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createAnonymousCheckbox(FormToolkit widgetFactory, Composite parent) {
		anonymous = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.MediatorSequence.Properties.anonymous, EsbMessages.MediatorSequencePropertiesEditionPart_AnonymousLabel), SWT.CHECK);
		anonymous.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MediatorSequencePropertiesEditionPartForm.this, EsbViewsRepository.MediatorSequence.Properties.anonymous, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(anonymous.getSelection())));
			}

		});
		GridData anonymousData = new GridData(GridData.FILL_HORIZONTAL);
		anonymousData.horizontalSpan = 2;
		anonymous.setLayoutData(anonymousData);
		EditingUtils.setID(anonymous, EsbViewsRepository.MediatorSequence.Properties.anonymous);
		EditingUtils.setEEFtype(anonymous, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MediatorSequence.Properties.anonymous, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAnonymousCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createSequenceNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MediatorSequence.Properties.sequenceName, EsbMessages.MediatorSequencePropertiesEditionPart_SequenceNameLabel);
		sequenceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		sequenceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData sequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		sequenceName.setLayoutData(sequenceNameData);
		sequenceName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MediatorSequencePropertiesEditionPartForm.this,
							EsbViewsRepository.MediatorSequence.Properties.sequenceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sequenceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MediatorSequencePropertiesEditionPartForm.this,
									EsbViewsRepository.MediatorSequence.Properties.sequenceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, sequenceName.getText()));
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
									MediatorSequencePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		sequenceName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MediatorSequencePropertiesEditionPartForm.this, EsbViewsRepository.MediatorSequence.Properties.sequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sequenceName.getText()));
				}
			}
		});
		EditingUtils.setID(sequenceName, EsbViewsRepository.MediatorSequence.Properties.sequenceName);
		EditingUtils.setEEFtype(sequenceName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MediatorSequence.Properties.sequenceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceNameText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createMediatorsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.mediators = new ReferencesTable(getDescription(EsbViewsRepository.MediatorSequence.Properties.mediators, EsbMessages.MediatorSequencePropertiesEditionPart_MediatorsLabel), new ReferencesTableListener	() {
			public void handleAdd() { addMediators(); }
			public void handleEdit(EObject element) { editMediators(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveMediators(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromMediators(element); }
			public void navigateTo(EObject element) { }
		});
		this.mediators.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.MediatorSequence.Properties.mediators, EsbViewsRepository.FORM_KIND));
		this.mediators.createControls(parent, widgetFactory);
		this.mediators.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MediatorSequencePropertiesEditionPartForm.this, EsbViewsRepository.MediatorSequence.Properties.mediators, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData mediatorsData = new GridData(GridData.FILL_HORIZONTAL);
		mediatorsData.horizontalSpan = 3;
		this.mediators.setLayoutData(mediatorsData);
		this.mediators.disableMove();
		mediators.setID(EsbViewsRepository.MediatorSequence.Properties.mediators);
		mediators.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createMediatorsReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addMediators() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(mediators.getInput(), mediatorsFilters, mediatorsBusinessFilters,
		"mediators", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MediatorSequencePropertiesEditionPartForm.this, EsbViewsRepository.MediatorSequence.Properties.mediators,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				mediators.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveMediators(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MediatorSequencePropertiesEditionPartForm.this, EsbViewsRepository.MediatorSequence.Properties.mediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		mediators.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromMediators(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MediatorSequencePropertiesEditionPartForm.this, EsbViewsRepository.MediatorSequence.Properties.mediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		mediators.refresh();
	}

	/**
	 * 
	 */
	protected void editMediators(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				mediators.refresh();
			}
		}
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createOnErrorFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EsbViewsRepository.MediatorSequence.Properties.onError, EsbMessages.MediatorSequencePropertiesEditionPart_OnErrorLabel);
		onError = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EsbViewsRepository.MediatorSequence.Properties.onError, EsbViewsRepository.FORM_KIND));
		widgetFactory.adapt(onError);
		onError.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData onErrorData = new GridData(GridData.FILL_HORIZONTAL);
		onError.setLayoutData(onErrorData);
		onError.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MediatorSequencePropertiesEditionPartForm.this, EsbViewsRepository.MediatorSequence.Properties.onError, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnError()));
			}

		});
		onError.setID(EsbViewsRepository.MediatorSequence.Properties.onError);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MediatorSequence.Properties.onError, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOnErrorFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MediatorSequence.Properties.description, EsbMessages.MediatorSequencePropertiesEditionPart_DescriptionLabel);
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
							MediatorSequencePropertiesEditionPartForm.this,
							EsbViewsRepository.MediatorSequence.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MediatorSequencePropertiesEditionPartForm.this,
									EsbViewsRepository.MediatorSequence.Properties.description,
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
									MediatorSequencePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MediatorSequencePropertiesEditionPartForm.this, EsbViewsRepository.MediatorSequence.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.MediatorSequence.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MediatorSequence.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#getAnonymous()
	 * 
	 */
	public Boolean getAnonymous() {
		return Boolean.valueOf(anonymous.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#setAnonymous(Boolean newValue)
	 * 
	 */
	public void setAnonymous(Boolean newValue) {
		if (newValue != null) {
			anonymous.setSelection(newValue.booleanValue());
		} else {
			anonymous.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MediatorSequence.Properties.anonymous);
		if (eefElementEditorReadOnlyState && anonymous.isEnabled()) {
			anonymous.setEnabled(false);
			anonymous.setToolTipText(EsbMessages.MediatorSequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !anonymous.isEnabled()) {
			anonymous.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#getSequenceName()
	 * 
	 */
	public String getSequenceName() {
		return sequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#setSequenceName(String newValue)
	 * 
	 */
	public void setSequenceName(String newValue) {
		if (newValue != null) {
			sequenceName.setText(newValue);
		} else {
			sequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MediatorSequence.Properties.sequenceName);
		if (eefElementEditorReadOnlyState && sequenceName.isEnabled()) {
			sequenceName.setEnabled(false);
			sequenceName.setToolTipText(EsbMessages.MediatorSequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceName.isEnabled()) {
			sequenceName.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#initMediators(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initMediators(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		mediators.setContentProvider(contentProvider);
		mediators.setInput(settings);
		mediatorsBusinessFilters.clear();
		mediatorsFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MediatorSequence.Properties.mediators);
		if (eefElementEditorReadOnlyState && mediators.getTable().isEnabled()) {
			mediators.setEnabled(false);
			mediators.setToolTipText(EsbMessages.MediatorSequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !mediators.getTable().isEnabled()) {
			mediators.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#updateMediators()
	 * 
	 */
	public void updateMediators() {
	mediators.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#addFilterMediators(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMediators(ViewerFilter filter) {
		mediatorsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#addBusinessFilterMediators(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMediators(ViewerFilter filter) {
		mediatorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#isContainedInMediatorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInMediatorsTable(EObject element) {
		return ((ReferencesTableSettings)mediators.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#getOnError()
	 * 
	 */
	public EObject getOnError() {
		if (onError.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) onError.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#initOnError(EObjectFlatComboSettings)
	 */
	public void initOnError(EObjectFlatComboSettings settings) {
		onError.setInput(settings);
		if (current != null) {
			onError.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MediatorSequence.Properties.onError);
		if (eefElementEditorReadOnlyState && onError.isEnabled()) {
			onError.setEnabled(false);
			onError.setToolTipText(EsbMessages.MediatorSequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onError.isEnabled()) {
			onError.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#setOnError(EObject newValue)
	 * 
	 */
	public void setOnError(EObject newValue) {
		if (newValue != null) {
			onError.setSelection(new StructuredSelection(newValue));
		} else {
			onError.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MediatorSequence.Properties.onError);
		if (eefElementEditorReadOnlyState && onError.isEnabled()) {
			onError.setEnabled(false);
			onError.setToolTipText(EsbMessages.MediatorSequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onError.isEnabled()) {
			onError.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#setOnErrorButtonMode(ButtonsModeEnum newValue)
	 */
	public void setOnErrorButtonMode(ButtonsModeEnum newValue) {
		onError.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#addFilterOnError(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOnError(ViewerFilter filter) {
		onError.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#addBusinessFilterOnError(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOnError(ViewerFilter filter) {
		onError.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MediatorSequence.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.MediatorSequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.MediatorSequence_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
