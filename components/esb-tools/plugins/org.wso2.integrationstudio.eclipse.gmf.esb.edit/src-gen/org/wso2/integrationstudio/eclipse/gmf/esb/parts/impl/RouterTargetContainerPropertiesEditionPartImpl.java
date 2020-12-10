/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterTargetContainerPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class RouterTargetContainerPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RouterTargetContainerPropertiesEditionPart {

	protected Button breakAfterRoute;
	protected Text routePattern;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RouterTargetContainerPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence routerTargetContainerStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = routerTargetContainerStep.addStep(EsbViewsRepository.RouterTargetContainer.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute);
		propertiesStep.addStep(EsbViewsRepository.RouterTargetContainer.Properties.routePattern);
		
		
		composer = new PartComposer(routerTargetContainerStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RouterTargetContainer.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute) {
					return createBreakAfterRouteCheckbox(parent);
				}
				if (key == EsbViewsRepository.RouterTargetContainer.Properties.routePattern) {
					return createRoutePatternText(parent);
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
		propertiesGroup.setText(EsbMessages.RouterTargetContainerPropertiesEditionPart_PropertiesGroupLabel);
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
		breakAfterRoute.setText(getDescription(EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute, EsbMessages.RouterTargetContainerPropertiesEditionPart_BreakAfterRouteLabel));
		breakAfterRoute.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterTargetContainerPropertiesEditionPartImpl.this, EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(breakAfterRoute.getSelection())));
			}

		});
		GridData breakAfterRouteData = new GridData(GridData.FILL_HORIZONTAL);
		breakAfterRouteData.horizontalSpan = 2;
		breakAfterRoute.setLayoutData(breakAfterRouteData);
		EditingUtils.setID(breakAfterRoute, EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute);
		EditingUtils.setEEFtype(breakAfterRoute, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createBreakAfterRouteCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createRoutePatternText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RouterTargetContainer.Properties.routePattern, EsbMessages.RouterTargetContainerPropertiesEditionPart_RoutePatternLabel);
		routePattern = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData routePatternData = new GridData(GridData.FILL_HORIZONTAL);
		routePattern.setLayoutData(routePatternData);
		routePattern.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterTargetContainerPropertiesEditionPartImpl.this, EsbViewsRepository.RouterTargetContainer.Properties.routePattern, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, routePattern.getText()));
			}

		});
		routePattern.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterTargetContainerPropertiesEditionPartImpl.this, EsbViewsRepository.RouterTargetContainer.Properties.routePattern, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, routePattern.getText()));
				}
			}

		});
		EditingUtils.setID(routePattern, EsbViewsRepository.RouterTargetContainer.Properties.routePattern);
		EditingUtils.setEEFtype(routePattern, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RouterTargetContainer.Properties.routePattern, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRoutePatternText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterTargetContainerPropertiesEditionPart#getBreakAfterRoute()
	 * 
	 */
	public Boolean getBreakAfterRoute() {
		return Boolean.valueOf(breakAfterRoute.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterTargetContainerPropertiesEditionPart#setBreakAfterRoute(Boolean newValue)
	 * 
	 */
	public void setBreakAfterRoute(Boolean newValue) {
		if (newValue != null) {
			breakAfterRoute.setSelection(newValue.booleanValue());
		} else {
			breakAfterRoute.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute);
		if (eefElementEditorReadOnlyState && breakAfterRoute.isEnabled()) {
			breakAfterRoute.setEnabled(false);
			breakAfterRoute.setToolTipText(EsbMessages.RouterTargetContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !breakAfterRoute.isEnabled()) {
			breakAfterRoute.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterTargetContainerPropertiesEditionPart#getRoutePattern()
	 * 
	 */
	public String getRoutePattern() {
		return routePattern.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterTargetContainerPropertiesEditionPart#setRoutePattern(String newValue)
	 * 
	 */
	public void setRoutePattern(String newValue) {
		if (newValue != null) {
			routePattern.setText(newValue);
		} else {
			routePattern.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RouterTargetContainer.Properties.routePattern);
		if (eefElementEditorReadOnlyState && routePattern.isEnabled()) {
			routePattern.setEnabled(false);
			routePattern.setToolTipText(EsbMessages.RouterTargetContainer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !routePattern.isEnabled()) {
			routePattern.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.RouterTargetContainer_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
