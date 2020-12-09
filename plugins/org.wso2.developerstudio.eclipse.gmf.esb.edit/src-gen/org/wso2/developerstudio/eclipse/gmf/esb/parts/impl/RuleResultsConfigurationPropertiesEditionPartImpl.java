/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleResultsConfigurationPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class RuleResultsConfigurationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RuleResultsConfigurationPropertiesEditionPart {

	protected ReferencesTable results;
	protected List<ViewerFilter> resultsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> resultsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RuleResultsConfigurationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence ruleResultsConfigurationStep = new BindingCompositionSequence(propertiesEditionComponent);
		ruleResultsConfigurationStep
			.addStep(EsbViewsRepository.RuleResultsConfiguration.Properties.class)
			.addStep(EsbViewsRepository.RuleResultsConfiguration.Properties.results);
		
		
		composer = new PartComposer(ruleResultsConfigurationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RuleResultsConfiguration.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.RuleResultsConfiguration.Properties.results) {
					return createResultsAdvancedTableComposition(parent);
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
		propertiesGroup.setText(EsbMessages.RuleResultsConfigurationPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createResultsAdvancedTableComposition(Composite parent) {
		this.results = new ReferencesTable(getDescription(EsbViewsRepository.RuleResultsConfiguration.Properties.results, EsbMessages.RuleResultsConfigurationPropertiesEditionPart_ResultsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleResultsConfigurationPropertiesEditionPartImpl.this, EsbViewsRepository.RuleResultsConfiguration.Properties.results, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				results.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleResultsConfigurationPropertiesEditionPartImpl.this, EsbViewsRepository.RuleResultsConfiguration.Properties.results, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				results.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleResultsConfigurationPropertiesEditionPartImpl.this, EsbViewsRepository.RuleResultsConfiguration.Properties.results, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				results.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleResultsConfigurationPropertiesEditionPartImpl.this, EsbViewsRepository.RuleResultsConfiguration.Properties.results, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				results.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.resultsFilters) {
			this.results.addFilter(filter);
		}
		this.results.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleResultsConfiguration.Properties.results, EsbViewsRepository.SWT_KIND));
		this.results.createControls(parent);
		this.results.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleResultsConfigurationPropertiesEditionPartImpl.this, EsbViewsRepository.RuleResultsConfiguration.Properties.results, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData resultsData = new GridData(GridData.FILL_HORIZONTAL);
		resultsData.horizontalSpan = 3;
		this.results.setLayoutData(resultsData);
		this.results.setLowerBound(0);
		this.results.setUpperBound(-1);
		results.setID(EsbViewsRepository.RuleResultsConfiguration.Properties.results);
		results.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createResultsAdvancedTableComposition

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleResultsConfigurationPropertiesEditionPart#initResults(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initResults(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		results.setContentProvider(contentProvider);
		results.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleResultsConfiguration.Properties.results);
		if (eefElementEditorReadOnlyState && results.isEnabled()) {
			results.setEnabled(false);
			results.setToolTipText(EsbMessages.RuleResultsConfiguration_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !results.isEnabled()) {
			results.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleResultsConfigurationPropertiesEditionPart#updateResults()
	 * 
	 */
	public void updateResults() {
	results.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleResultsConfigurationPropertiesEditionPart#addFilterResults(ViewerFilter filter)
	 * 
	 */
	public void addFilterToResults(ViewerFilter filter) {
		resultsFilters.add(filter);
		if (this.results != null) {
			this.results.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleResultsConfigurationPropertiesEditionPart#addBusinessFilterResults(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToResults(ViewerFilter filter) {
		resultsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleResultsConfigurationPropertiesEditionPart#isContainedInResultsTable(EObject element)
	 * 
	 */
	public boolean isContainedInResultsTable(EObject element) {
		return ((ReferencesTableSettings)results.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.RuleResultsConfiguration_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
