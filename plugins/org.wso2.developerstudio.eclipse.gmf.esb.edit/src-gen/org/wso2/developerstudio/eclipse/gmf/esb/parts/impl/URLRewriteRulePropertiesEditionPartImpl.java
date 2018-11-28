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
import org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteRulePropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class URLRewriteRulePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, URLRewriteRulePropertiesEditionPart {

	protected ReferencesTable rewriteRuleAction;
	protected List<ViewerFilter> rewriteRuleActionBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> rewriteRuleActionFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public URLRewriteRulePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence uRLRewriteRuleStep = new BindingCompositionSequence(propertiesEditionComponent);
		uRLRewriteRuleStep
			.addStep(EsbViewsRepository.URLRewriteRule.Properties.class)
			.addStep(EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction);
		
		
		composer = new PartComposer(uRLRewriteRuleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.URLRewriteRule.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction) {
					return createRewriteRuleActionAdvancedTableComposition(parent);
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
		propertiesGroup.setText(EsbMessages.URLRewriteRulePropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createRewriteRuleActionAdvancedTableComposition(Composite parent) {
		this.rewriteRuleAction = new ReferencesTable(getDescription(EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, EsbMessages.URLRewriteRulePropertiesEditionPart_RewriteRuleActionLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRulePropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				rewriteRuleAction.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRulePropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				rewriteRuleAction.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRulePropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				rewriteRuleAction.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRulePropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				rewriteRuleAction.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.rewriteRuleActionFilters) {
			this.rewriteRuleAction.addFilter(filter);
		}
		this.rewriteRuleAction.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, EsbViewsRepository.SWT_KIND));
		this.rewriteRuleAction.createControls(parent);
		this.rewriteRuleAction.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRulePropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData rewriteRuleActionData = new GridData(GridData.FILL_HORIZONTAL);
		rewriteRuleActionData.horizontalSpan = 3;
		this.rewriteRuleAction.setLayoutData(rewriteRuleActionData);
		this.rewriteRuleAction.setLowerBound(0);
		this.rewriteRuleAction.setUpperBound(-1);
		rewriteRuleAction.setID(EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction);
		rewriteRuleAction.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createRewriteRuleActionAdvancedTableComposition

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteRulePropertiesEditionPart#initRewriteRuleAction(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRewriteRuleAction(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		rewriteRuleAction.setContentProvider(contentProvider);
		rewriteRuleAction.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction);
		if (eefElementEditorReadOnlyState && rewriteRuleAction.isEnabled()) {
			rewriteRuleAction.setEnabled(false);
			rewriteRuleAction.setToolTipText(EsbMessages.URLRewriteRule_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !rewriteRuleAction.isEnabled()) {
			rewriteRuleAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteRulePropertiesEditionPart#updateRewriteRuleAction()
	 * 
	 */
	public void updateRewriteRuleAction() {
	rewriteRuleAction.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteRulePropertiesEditionPart#addFilterRewriteRuleAction(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRewriteRuleAction(ViewerFilter filter) {
		rewriteRuleActionFilters.add(filter);
		if (this.rewriteRuleAction != null) {
			this.rewriteRuleAction.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteRulePropertiesEditionPart#addBusinessFilterRewriteRuleAction(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRewriteRuleAction(ViewerFilter filter) {
		rewriteRuleActionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteRulePropertiesEditionPart#isContainedInRewriteRuleActionTable(EObject element)
	 * 
	 */
	public boolean isContainedInRewriteRuleActionTable(EObject element) {
		return ((ReferencesTableSettings)rewriteRuleAction.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.URLRewriteRule_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
