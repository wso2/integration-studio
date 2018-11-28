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
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterMediatorContainerPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class RouterMediatorContainerPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RouterMediatorContainerPropertiesEditionPart {

	protected ReferencesTable routerTargetContainer;
	protected List<ViewerFilter> routerTargetContainerBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> routerTargetContainerFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RouterMediatorContainerPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence routerMediatorContainerStep = new BindingCompositionSequence(propertiesEditionComponent);
		routerMediatorContainerStep
			.addStep(EsbViewsRepository.RouterMediatorContainer.Properties.class)
			.addStep(EsbViewsRepository.RouterMediatorContainer.Properties.routerTargetContainer);
		
		
		composer = new PartComposer(routerMediatorContainerStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RouterMediatorContainer.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.RouterMediatorContainer.Properties.routerTargetContainer) {
					return createRouterTargetContainerAdvancedTableComposition(parent);
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
		propertiesGroup.setText(EsbMessages.RouterMediatorContainerPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createRouterTargetContainerAdvancedTableComposition(Composite parent) {
		this.routerTargetContainer = new ReferencesTable(getDescription(EsbViewsRepository.RouterMediatorContainer.Properties.routerTargetContainer, EsbMessages.RouterMediatorContainerPropertiesEditionPart_RouterTargetContainerLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterMediatorContainerPropertiesEditionPartImpl.this, EsbViewsRepository.RouterMediatorContainer.Properties.routerTargetContainer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				routerTargetContainer.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterMediatorContainerPropertiesEditionPartImpl.this, EsbViewsRepository.RouterMediatorContainer.Properties.routerTargetContainer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				routerTargetContainer.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterMediatorContainerPropertiesEditionPartImpl.this, EsbViewsRepository.RouterMediatorContainer.Properties.routerTargetContainer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				routerTargetContainer.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterMediatorContainerPropertiesEditionPartImpl.this, EsbViewsRepository.RouterMediatorContainer.Properties.routerTargetContainer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				routerTargetContainer.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.routerTargetContainerFilters) {
			this.routerTargetContainer.addFilter(filter);
		}
		this.routerTargetContainer.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RouterMediatorContainer.Properties.routerTargetContainer, EsbViewsRepository.SWT_KIND));
		this.routerTargetContainer.createControls(parent);
		this.routerTargetContainer.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterMediatorContainerPropertiesEditionPartImpl.this, EsbViewsRepository.RouterMediatorContainer.Properties.routerTargetContainer, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData routerTargetContainerData = new GridData(GridData.FILL_HORIZONTAL);
		routerTargetContainerData.horizontalSpan = 3;
		this.routerTargetContainer.setLayoutData(routerTargetContainerData);
		this.routerTargetContainer.setLowerBound(0);
		this.routerTargetContainer.setUpperBound(-1);
		routerTargetContainer.setID(EsbViewsRepository.RouterMediatorContainer.Properties.routerTargetContainer);
		routerTargetContainer.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createRouterTargetContainerAdvancedTableComposition

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterMediatorContainerPropertiesEditionPart#initRouterTargetContainer(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRouterTargetContainer(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		routerTargetContainer.setContentProvider(contentProvider);
		routerTargetContainer.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RouterMediatorContainer.Properties.routerTargetContainer);
		if (eefElementEditorReadOnlyState && routerTargetContainer.isEnabled()) {
			routerTargetContainer.setEnabled(false);
			routerTargetContainer.setToolTipText(EsbMessages.RouterMediatorContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !routerTargetContainer.isEnabled()) {
			routerTargetContainer.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterMediatorContainerPropertiesEditionPart#updateRouterTargetContainer()
	 * 
	 */
	public void updateRouterTargetContainer() {
	routerTargetContainer.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterMediatorContainerPropertiesEditionPart#addFilterRouterTargetContainer(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRouterTargetContainer(ViewerFilter filter) {
		routerTargetContainerFilters.add(filter);
		if (this.routerTargetContainer != null) {
			this.routerTargetContainer.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterMediatorContainerPropertiesEditionPart#addBusinessFilterRouterTargetContainer(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRouterTargetContainer(ViewerFilter filter) {
		routerTargetContainerBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterMediatorContainerPropertiesEditionPart#isContainedInRouterTargetContainerTable(EObject element)
	 * 
	 */
	public boolean isContainedInRouterTargetContainerTable(EObject element) {
		return ((ReferencesTableSettings)routerTargetContainer.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.RouterMediatorContainer_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
