/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorInputConnectorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CloudConnectorInputConnectorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CloudConnectorInputConnectorPropertiesEditionPart {

	protected ReferencesTable incomingLinks;
	protected List<ViewerFilter> incomingLinksBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> incomingLinksFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CloudConnectorInputConnectorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence cloudConnectorInputConnectorStep = new BindingCompositionSequence(propertiesEditionComponent);
		cloudConnectorInputConnectorStep
			.addStep(EsbViewsRepository.CloudConnectorInputConnector.Properties.class)
			.addStep(EsbViewsRepository.CloudConnectorInputConnector.Properties.incomingLinks);
		
		
		composer = new PartComposer(cloudConnectorInputConnectorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CloudConnectorInputConnector.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.CloudConnectorInputConnector.Properties.incomingLinks) {
					return createIncomingLinksAdvancedReferencesTable(parent);
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
		propertiesGroup.setText(EsbMessages.CloudConnectorInputConnectorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * 
	 */
	protected Composite createIncomingLinksAdvancedReferencesTable(Composite parent) {
		String label = getDescription(EsbViewsRepository.CloudConnectorInputConnector.Properties.incomingLinks, EsbMessages.CloudConnectorInputConnectorPropertiesEditionPart_IncomingLinksLabel);		 
		this.incomingLinks = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addIncomingLinks(); }
			public void handleEdit(EObject element) { editIncomingLinks(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveIncomingLinks(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromIncomingLinks(element); }
			public void navigateTo(EObject element) { }
		});
		this.incomingLinks.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorInputConnector.Properties.incomingLinks, EsbViewsRepository.SWT_KIND));
		this.incomingLinks.createControls(parent);
		this.incomingLinks.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorInputConnectorPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorInputConnector.Properties.incomingLinks, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData incomingLinksData = new GridData(GridData.FILL_HORIZONTAL);
		incomingLinksData.horizontalSpan = 3;
		this.incomingLinks.setLayoutData(incomingLinksData);
		this.incomingLinks.disableMove();
		incomingLinks.setID(EsbViewsRepository.CloudConnectorInputConnector.Properties.incomingLinks);
		incomingLinks.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addIncomingLinks() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(incomingLinks.getInput(), incomingLinksFilters, incomingLinksBusinessFilters,
		"incomingLinks", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorInputConnectorPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorInputConnector.Properties.incomingLinks,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				incomingLinks.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveIncomingLinks(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorInputConnectorPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorInputConnector.Properties.incomingLinks, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		incomingLinks.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromIncomingLinks(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorInputConnectorPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorInputConnector.Properties.incomingLinks, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		incomingLinks.refresh();
	}

	/**
	 * 
	 */
	protected void editIncomingLinks(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				incomingLinks.refresh();
			}
		}
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorInputConnectorPropertiesEditionPart#initIncomingLinks(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initIncomingLinks(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		incomingLinks.setContentProvider(contentProvider);
		incomingLinks.setInput(settings);
		incomingLinksBusinessFilters.clear();
		incomingLinksFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorInputConnector.Properties.incomingLinks);
		if (eefElementEditorReadOnlyState && incomingLinks.getTable().isEnabled()) {
			incomingLinks.setEnabled(false);
			incomingLinks.setToolTipText(EsbMessages.CloudConnectorInputConnector_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !incomingLinks.getTable().isEnabled()) {
			incomingLinks.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorInputConnectorPropertiesEditionPart#updateIncomingLinks()
	 * 
	 */
	public void updateIncomingLinks() {
	incomingLinks.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorInputConnectorPropertiesEditionPart#addFilterIncomingLinks(ViewerFilter filter)
	 * 
	 */
	public void addFilterToIncomingLinks(ViewerFilter filter) {
		incomingLinksFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorInputConnectorPropertiesEditionPart#addBusinessFilterIncomingLinks(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToIncomingLinks(ViewerFilter filter) {
		incomingLinksBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorInputConnectorPropertiesEditionPart#isContainedInIncomingLinksTable(EObject element)
	 * 
	 */
	public boolean isContainedInIncomingLinksTable(EObject element) {
		return ((ReferencesTableSettings)incomingLinks.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CloudConnectorInputConnector_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
