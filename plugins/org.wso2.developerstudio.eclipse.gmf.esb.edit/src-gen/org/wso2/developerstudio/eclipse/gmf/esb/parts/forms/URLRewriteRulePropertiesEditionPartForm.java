/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

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
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
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
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteRulePropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class URLRewriteRulePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, URLRewriteRulePropertiesEditionPart {

	protected ReferencesTable rewriteRuleAction;
	protected List<ViewerFilter> rewriteRuleActionBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> rewriteRuleActionFilters = new ArrayList<ViewerFilter>();
	// Start of user code  for urlRewriteRuleCondition widgets declarations
	
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public URLRewriteRulePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public URLRewriteRulePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence uRLRewriteRuleStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = uRLRewriteRuleStep.addStep(EsbViewsRepository.URLRewriteRule.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteRule.Properties.urlRewriteRuleCondition);
		
		
		composer = new PartComposer(uRLRewriteRuleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.URLRewriteRule.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction) {
					return createRewriteRuleActionTableComposition(widgetFactory, parent);
				}
				// Start of user code for urlRewriteRuleCondition addToPart creation
				
				// End of user code
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
		propertiesSection.setText(EsbMessages.URLRewriteRulePropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createRewriteRuleActionTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.rewriteRuleAction = new ReferencesTable(getDescription(EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, EsbMessages.URLRewriteRulePropertiesEditionPart_RewriteRuleActionLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRulePropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				rewriteRuleAction.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRulePropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				rewriteRuleAction.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRulePropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				rewriteRuleAction.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRulePropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				rewriteRuleAction.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.rewriteRuleActionFilters) {
			this.rewriteRuleAction.addFilter(filter);
		}
		this.rewriteRuleAction.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, EsbViewsRepository.FORM_KIND));
		this.rewriteRuleAction.createControls(parent, widgetFactory);
		this.rewriteRuleAction.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteRulePropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createRewriteRuleActionTableComposition

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






	// Start of user code for urlRewriteRuleCondition specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.URLRewriteRule_Part_Title;
	}

	@Override
	public EvaluatorExpressionProperty getUrlRewriteRuleCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUrlRewriteRuleCondition(EvaluatorExpressionProperty evaluatorExpressionProperty) {
		// TODO Auto-generated method stub
		
	}

	// Start of user code additional methods
	
	// End of user code


}
