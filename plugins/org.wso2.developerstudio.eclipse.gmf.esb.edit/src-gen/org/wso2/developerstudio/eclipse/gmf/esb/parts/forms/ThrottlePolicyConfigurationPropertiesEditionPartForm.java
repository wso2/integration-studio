/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ThrottlePolicyConfigurationPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ThrottlePolicyConfigurationPropertiesEditionPart {

	protected EMFComboViewer policyType;
	protected Text maxConcurrentAccessCount;
	protected ReferencesTable policyEntries;
	protected List<ViewerFilter> policyEntriesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> policyEntriesFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public ThrottlePolicyConfigurationPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ThrottlePolicyConfigurationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence throttlePolicyConfigurationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = throttlePolicyConfigurationStep.addStep(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType);
		propertiesStep.addStep(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount);
		propertiesStep.addStep(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries);
		
		
		composer = new PartComposer(throttlePolicyConfigurationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ThrottlePolicyConfiguration.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType) {
					return createPolicyTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount) {
					return createMaxConcurrentAccessCountText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries) {
					return createPolicyEntriesTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.ThrottlePolicyConfigurationPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createPolicyTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType, EsbMessages.ThrottlePolicyConfigurationPropertiesEditionPart_PolicyTypeLabel);
		policyType = new EMFComboViewer(parent);
		policyType.setContentProvider(new ArrayContentProvider());
		policyType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData policyTypeData = new GridData(GridData.FILL_HORIZONTAL);
		policyType.getCombo().setLayoutData(policyTypeData);
                policyType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		policyType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPolicyType()));
			}

		});
		policyType.setID(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPolicyTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createMaxConcurrentAccessCountText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount, EsbMessages.ThrottlePolicyConfigurationPropertiesEditionPart_MaxConcurrentAccessCountLabel);
		maxConcurrentAccessCount = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		maxConcurrentAccessCount.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData maxConcurrentAccessCountData = new GridData(GridData.FILL_HORIZONTAL);
		maxConcurrentAccessCount.setLayoutData(maxConcurrentAccessCountData);
		maxConcurrentAccessCount.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ThrottlePolicyConfigurationPropertiesEditionPartForm.this,
							EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxConcurrentAccessCount.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ThrottlePolicyConfigurationPropertiesEditionPartForm.this,
									EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, maxConcurrentAccessCount.getText()));
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
									ThrottlePolicyConfigurationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		maxConcurrentAccessCount.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxConcurrentAccessCount.getText()));
				}
			}
		});
		EditingUtils.setID(maxConcurrentAccessCount, EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount);
		EditingUtils.setEEFtype(maxConcurrentAccessCount, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxConcurrentAccessCountText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createPolicyEntriesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.policyEntries = new ReferencesTable(getDescription(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries, EsbMessages.ThrottlePolicyConfigurationPropertiesEditionPart_PolicyEntriesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				policyEntries.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				policyEntries.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				policyEntries.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				policyEntries.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.policyEntriesFilters) {
			this.policyEntries.addFilter(filter);
		}
		this.policyEntries.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries, EsbViewsRepository.FORM_KIND));
		this.policyEntries.createControls(parent, widgetFactory);
		this.policyEntries.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData policyEntriesData = new GridData(GridData.FILL_HORIZONTAL);
		policyEntriesData.horizontalSpan = 3;
		this.policyEntries.setLayoutData(policyEntriesData);
		this.policyEntries.setLowerBound(0);
		this.policyEntries.setUpperBound(-1);
		policyEntries.setID(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries);
		policyEntries.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPolicyEntriesTableComposition

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart#getPolicyType()
	 * 
	 */
	public Enumerator getPolicyType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) policyType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart#initPolicyType(Object input, Enumerator current)
	 */
	public void initPolicyType(Object input, Enumerator current) {
		policyType.setInput(input);
		policyType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType);
		if (eefElementEditorReadOnlyState && policyType.isEnabled()) {
			policyType.setEnabled(false);
			policyType.setToolTipText(EsbMessages.ThrottlePolicyConfiguration_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policyType.isEnabled()) {
			policyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart#setPolicyType(Enumerator newValue)
	 * 
	 */
	public void setPolicyType(Enumerator newValue) {
		policyType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType);
		if (eefElementEditorReadOnlyState && policyType.isEnabled()) {
			policyType.setEnabled(false);
			policyType.setToolTipText(EsbMessages.ThrottlePolicyConfiguration_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policyType.isEnabled()) {
			policyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart#getMaxConcurrentAccessCount()
	 * 
	 */
	public String getMaxConcurrentAccessCount() {
		return maxConcurrentAccessCount.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart#setMaxConcurrentAccessCount(String newValue)
	 * 
	 */
	public void setMaxConcurrentAccessCount(String newValue) {
		if (newValue != null) {
			maxConcurrentAccessCount.setText(newValue);
		} else {
			maxConcurrentAccessCount.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount);
		if (eefElementEditorReadOnlyState && maxConcurrentAccessCount.isEnabled()) {
			maxConcurrentAccessCount.setEnabled(false);
			maxConcurrentAccessCount.setToolTipText(EsbMessages.ThrottlePolicyConfiguration_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maxConcurrentAccessCount.isEnabled()) {
			maxConcurrentAccessCount.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart#initPolicyEntries(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPolicyEntries(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		policyEntries.setContentProvider(contentProvider);
		policyEntries.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries);
		if (eefElementEditorReadOnlyState && policyEntries.isEnabled()) {
			policyEntries.setEnabled(false);
			policyEntries.setToolTipText(EsbMessages.ThrottlePolicyConfiguration_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policyEntries.isEnabled()) {
			policyEntries.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart#updatePolicyEntries()
	 * 
	 */
	public void updatePolicyEntries() {
	policyEntries.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart#addFilterPolicyEntries(ViewerFilter filter)
	 * 
	 */
	public void addFilterToPolicyEntries(ViewerFilter filter) {
		policyEntriesFilters.add(filter);
		if (this.policyEntries != null) {
			this.policyEntries.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart#addBusinessFilterPolicyEntries(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPolicyEntries(ViewerFilter filter) {
		policyEntriesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart#isContainedInPolicyEntriesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPolicyEntriesTable(EObject element) {
		return ((ReferencesTableSettings)policyEntries.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ThrottlePolicyConfiguration_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
