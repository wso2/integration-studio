/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

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

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneMediatorContainerPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CloneMediatorContainerPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CloneMediatorContainerPropertiesEditionPart {

	protected ReferencesTable cloneTargetContainer;
	protected List<ViewerFilter> cloneTargetContainerBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> cloneTargetContainerFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CloneMediatorContainerPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence cloneMediatorContainerStep = new BindingCompositionSequence(propertiesEditionComponent);
		cloneMediatorContainerStep
			.addStep(EsbViewsRepository.CloneMediatorContainer.Properties.class)
			.addStep(EsbViewsRepository.CloneMediatorContainer.Properties.cloneTargetContainer);
		
		
		composer = new PartComposer(cloneMediatorContainerStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CloneMediatorContainer.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.CloneMediatorContainer.Properties.cloneTargetContainer) {
					return createCloneTargetContainerAdvancedTableComposition(parent);
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
		propertiesGroup.setText(EsbMessages.CloneMediatorContainerPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createCloneTargetContainerAdvancedTableComposition(Composite parent) {
		this.cloneTargetContainer = new ReferencesTable(getDescription(EsbViewsRepository.CloneMediatorContainer.Properties.cloneTargetContainer, EsbMessages.CloneMediatorContainerPropertiesEditionPart_CloneTargetContainerLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorContainerPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediatorContainer.Properties.cloneTargetContainer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				cloneTargetContainer.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorContainerPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediatorContainer.Properties.cloneTargetContainer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				cloneTargetContainer.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorContainerPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediatorContainer.Properties.cloneTargetContainer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				cloneTargetContainer.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorContainerPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediatorContainer.Properties.cloneTargetContainer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				cloneTargetContainer.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.cloneTargetContainerFilters) {
			this.cloneTargetContainer.addFilter(filter);
		}
		this.cloneTargetContainer.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneMediatorContainer.Properties.cloneTargetContainer, EsbViewsRepository.SWT_KIND));
		this.cloneTargetContainer.createControls(parent);
		this.cloneTargetContainer.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorContainerPropertiesEditionPartImpl.this, EsbViewsRepository.CloneMediatorContainer.Properties.cloneTargetContainer, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData cloneTargetContainerData = new GridData(GridData.FILL_HORIZONTAL);
		cloneTargetContainerData.horizontalSpan = 3;
		this.cloneTargetContainer.setLayoutData(cloneTargetContainerData);
		this.cloneTargetContainer.setLowerBound(0);
		this.cloneTargetContainer.setUpperBound(-1);
		cloneTargetContainer.setID(EsbViewsRepository.CloneMediatorContainer.Properties.cloneTargetContainer);
		cloneTargetContainer.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createCloneTargetContainerAdvancedTableComposition

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneMediatorContainerPropertiesEditionPart#initCloneTargetContainer(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initCloneTargetContainer(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		cloneTargetContainer.setContentProvider(contentProvider);
		cloneTargetContainer.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediatorContainer.Properties.cloneTargetContainer);
		if (eefElementEditorReadOnlyState && cloneTargetContainer.isEnabled()) {
			cloneTargetContainer.setEnabled(false);
			cloneTargetContainer.setToolTipText(EsbMessages.CloneMediatorContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cloneTargetContainer.isEnabled()) {
			cloneTargetContainer.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneMediatorContainerPropertiesEditionPart#updateCloneTargetContainer()
	 * 
	 */
	public void updateCloneTargetContainer() {
	cloneTargetContainer.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneMediatorContainerPropertiesEditionPart#addFilterCloneTargetContainer(ViewerFilter filter)
	 * 
	 */
	public void addFilterToCloneTargetContainer(ViewerFilter filter) {
		cloneTargetContainerFilters.add(filter);
		if (this.cloneTargetContainer != null) {
			this.cloneTargetContainer.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneMediatorContainerPropertiesEditionPart#addBusinessFilterCloneTargetContainer(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCloneTargetContainer(ViewerFilter filter) {
		cloneTargetContainerBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneMediatorContainerPropertiesEditionPart#isContainedInCloneTargetContainerTable(EObject element)
	 * 
	 */
	public boolean isContainedInCloneTargetContainerTable(EObject element) {
		return ((ReferencesTableSettings)cloneTargetContainer.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CloneMediatorContainer_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
