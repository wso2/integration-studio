/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouteBranchPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ConditionalRouteBranchPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ConditionalRouteBranchPropertiesEditionPart {

	protected Button breakAfterRoute;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ConditionalRouteBranchPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence conditionalRouteBranchStep = new BindingCompositionSequence(propertiesEditionComponent);
		conditionalRouteBranchStep
			.addStep(EsbViewsRepository.ConditionalRouteBranch.Properties.class)
			.addStep(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute);
		
		
		composer = new PartComposer(conditionalRouteBranchStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ConditionalRouteBranch.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute) {
					return createBreakAfterRouteCheckbox(parent);
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
		propertiesGroup.setText(EsbMessages.ConditionalRouteBranchPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createBreakAfterRouteCheckbox(Composite parent) {
		breakAfterRoute = new Button(parent, SWT.CHECK);
		breakAfterRoute.setText(getDescription(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute, EsbMessages.ConditionalRouteBranchPropertiesEditionPart_BreakAfterRouteLabel));
		breakAfterRoute.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouteBranchPropertiesEditionPartImpl.this, EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(breakAfterRoute.getSelection())));
			}

		});
		GridData breakAfterRouteData = new GridData(GridData.FILL_HORIZONTAL);
		breakAfterRouteData.horizontalSpan = 2;
		breakAfterRoute.setLayoutData(breakAfterRouteData);
		EditingUtils.setID(breakAfterRoute, EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute);
		EditingUtils.setEEFtype(breakAfterRoute, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	
	// End of user code


}
