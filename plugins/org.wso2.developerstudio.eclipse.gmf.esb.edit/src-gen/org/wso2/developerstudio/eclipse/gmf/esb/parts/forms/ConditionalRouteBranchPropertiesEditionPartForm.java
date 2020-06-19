/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
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

import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouteBranchPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ConditionalRouteBranchPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ConditionalRouteBranchPropertiesEditionPart {

	protected Button breakAfterRoute;
	// Start of user code  for targetSequence widgets declarations
	
	// End of user code

	// Start of user code  for evaluatorExpression widgets declarations
	
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public ConditionalRouteBranchPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ConditionalRouteBranchPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence conditionalRouteBranchStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = conditionalRouteBranchStep.addStep(EsbViewsRepository.ConditionalRouteBranch.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute);
		propertiesStep.addStep(EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence);
		
		conditionalRouteBranchStep.addStep(EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression);
		
		composer = new PartComposer(conditionalRouteBranchStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ConditionalRouteBranch.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute) {
					return createBreakAfterRouteCheckbox(widgetFactory, parent);
				}
				// Start of user code for targetSequence addToPart creation
				
				// End of user code
				// Start of user code for evaluatorExpression addToPart creation
				
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
		propertiesSection.setText(EsbMessages.ConditionalRouteBranchPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createBreakAfterRouteCheckbox(FormToolkit widgetFactory, Composite parent) {
		breakAfterRoute = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute, EsbMessages.ConditionalRouteBranchPropertiesEditionPart_BreakAfterRouteLabel), SWT.CHECK);
		breakAfterRoute.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouteBranchPropertiesEditionPartForm.this, EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(breakAfterRoute.getSelection())));
			}

		});
		GridData breakAfterRouteData = new GridData(GridData.FILL_HORIZONTAL);
		breakAfterRouteData.horizontalSpan = 2;
		breakAfterRoute.setLayoutData(breakAfterRouteData);
		EditingUtils.setID(breakAfterRoute, EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute);
		EditingUtils.setEEFtype(breakAfterRoute, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createBreakAfterRouteCheckbox

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouteBranchPropertiesEditionPart#getBreakAfterRoute()
	 * 
	 */
	public Boolean getBreakAfterRoute() {
		return Boolean.valueOf(breakAfterRoute.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouteBranchPropertiesEditionPart#setBreakAfterRoute(Boolean newValue)
	 * 
	 */
	public void setBreakAfterRoute(Boolean newValue) {
		if (newValue != null) {
			breakAfterRoute.setSelection(newValue.booleanValue());
		} else {
			breakAfterRoute.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute);
		if (eefElementEditorReadOnlyState && breakAfterRoute.isEnabled()) {
			breakAfterRoute.setEnabled(false);
			breakAfterRoute.setToolTipText(EsbMessages.ConditionalRouteBranch_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !breakAfterRoute.isEnabled()) {
			breakAfterRoute.setEnabled(true);
		}	
		
	}






	// Start of user code for targetSequence specific getters and setters implementation
	
	// End of user code

	// Start of user code for evaluatorExpression specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ConditionalRouteBranch_Part_Title;
	}


	// Start of user code additional methods

    @Override
    public RegistryKeyProperty getTargetSequence() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTargetSequence(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public EvaluatorExpressionProperty getEvaluatorExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setEvaluatorExpression(EvaluatorExpressionProperty evaluatorExpressionProperty) {
        // TODO Auto-generated method stub
        
    }
	// End of user code


}
