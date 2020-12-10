/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleFactsConfigurationPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class RuleFactsConfigurationPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, RuleFactsConfigurationPropertiesEditionPart {

	protected ReferencesTable facts;
	protected List<ViewerFilter> factsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> factsFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public RuleFactsConfigurationPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RuleFactsConfigurationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence ruleFactsConfigurationStep = new BindingCompositionSequence(propertiesEditionComponent);
		ruleFactsConfigurationStep
			.addStep(EsbViewsRepository.RuleFactsConfiguration.Properties.class)
			.addStep(EsbViewsRepository.RuleFactsConfiguration.Properties.facts);
		
		
		composer = new PartComposer(ruleFactsConfigurationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RuleFactsConfiguration.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleFactsConfiguration.Properties.facts) {
					return createFactsTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.RuleFactsConfigurationPropertiesEditionPart_PropertiesGroupLabel);
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
	 * @param container
	 * 
	 */
	protected Composite createFactsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.facts = new ReferencesTable(getDescription(EsbViewsRepository.RuleFactsConfiguration.Properties.facts, EsbMessages.RuleFactsConfigurationPropertiesEditionPart_FactsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactsConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.RuleFactsConfiguration.Properties.facts, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				facts.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactsConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.RuleFactsConfiguration.Properties.facts, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				facts.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactsConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.RuleFactsConfiguration.Properties.facts, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				facts.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactsConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.RuleFactsConfiguration.Properties.facts, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				facts.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.factsFilters) {
			this.facts.addFilter(filter);
		}
		this.facts.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleFactsConfiguration.Properties.facts, EsbViewsRepository.FORM_KIND));
		this.facts.createControls(parent, widgetFactory);
		this.facts.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactsConfigurationPropertiesEditionPartForm.this, EsbViewsRepository.RuleFactsConfiguration.Properties.facts, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData factsData = new GridData(GridData.FILL_HORIZONTAL);
		factsData.horizontalSpan = 3;
		this.facts.setLayoutData(factsData);
		this.facts.setLowerBound(0);
		this.facts.setUpperBound(-1);
		facts.setID(EsbViewsRepository.RuleFactsConfiguration.Properties.facts);
		facts.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createFactsTableComposition

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleFactsConfigurationPropertiesEditionPart#initFacts(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initFacts(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		facts.setContentProvider(contentProvider);
		facts.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFactsConfiguration.Properties.facts);
		if (eefElementEditorReadOnlyState && facts.isEnabled()) {
			facts.setEnabled(false);
			facts.setToolTipText(EsbMessages.RuleFactsConfiguration_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !facts.isEnabled()) {
			facts.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleFactsConfigurationPropertiesEditionPart#updateFacts()
	 * 
	 */
	public void updateFacts() {
	facts.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleFactsConfigurationPropertiesEditionPart#addFilterFacts(ViewerFilter filter)
	 * 
	 */
	public void addFilterToFacts(ViewerFilter filter) {
		factsFilters.add(filter);
		if (this.facts != null) {
			this.facts.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleFactsConfigurationPropertiesEditionPart#addBusinessFilterFacts(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFacts(ViewerFilter filter) {
		factsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleFactsConfigurationPropertiesEditionPart#isContainedInFactsTable(EObject element)
	 * 
	 */
	public boolean isContainedInFactsTable(EObject element) {
		return ((ReferencesTableSettings)facts.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.RuleFactsConfiguration_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
