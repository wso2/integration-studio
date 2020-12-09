/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

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
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class RouterRoutePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RouterRoutePropertiesEditionPart {

	protected Button breakAfterRoute;
	protected EObjectFlatComboViewer routeExpression;
	protected Text routePattern;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RouterRoutePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence routerRouteStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = routerRouteStep.addStep(EsbViewsRepository.RouterRoute.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.RouterRoute.Properties.breakAfterRoute);
		propertiesStep.addStep(EsbViewsRepository.RouterRoute.Properties.routeExpression);
		propertiesStep.addStep(EsbViewsRepository.RouterRoute.Properties.routePattern);
		
		
		composer = new PartComposer(routerRouteStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RouterRoute.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.RouterRoute.Properties.breakAfterRoute) {
					return createBreakAfterRouteCheckbox(parent);
				}
				if (key == EsbViewsRepository.RouterRoute.Properties.routeExpression) {
					return createRouteExpressionFlatComboViewer(parent);
				}
				if (key == EsbViewsRepository.RouterRoute.Properties.routePattern) {
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
		propertiesGroup.setText(EsbMessages.RouterRoutePropertiesEditionPart_PropertiesGroupLabel);
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
		breakAfterRoute.setText(getDescription(EsbViewsRepository.RouterRoute.Properties.breakAfterRoute, EsbMessages.RouterRoutePropertiesEditionPart_BreakAfterRouteLabel));
		breakAfterRoute.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterRoutePropertiesEditionPartImpl.this, EsbViewsRepository.RouterRoute.Properties.breakAfterRoute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(breakAfterRoute.getSelection())));
			}

		});
		GridData breakAfterRouteData = new GridData(GridData.FILL_HORIZONTAL);
		breakAfterRouteData.horizontalSpan = 2;
		breakAfterRoute.setLayoutData(breakAfterRouteData);
		EditingUtils.setID(breakAfterRoute, EsbViewsRepository.RouterRoute.Properties.breakAfterRoute);
		EditingUtils.setEEFtype(breakAfterRoute, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RouterRoute.Properties.breakAfterRoute, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createBreakAfterRouteCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createRouteExpressionFlatComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.RouterRoute.Properties.routeExpression, EsbMessages.RouterRoutePropertiesEditionPart_RouteExpressionLabel);
		routeExpression = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EsbViewsRepository.RouterRoute.Properties.routeExpression, EsbViewsRepository.SWT_KIND));
		routeExpression.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		routeExpression.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterRoutePropertiesEditionPartImpl.this, EsbViewsRepository.RouterRoute.Properties.routeExpression, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getRouteExpression()));
			}

		});
		GridData routeExpressionData = new GridData(GridData.FILL_HORIZONTAL);
		routeExpression.setLayoutData(routeExpressionData);
		routeExpression.setID(EsbViewsRepository.RouterRoute.Properties.routeExpression);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RouterRoute.Properties.routeExpression, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRouteExpressionFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createRoutePatternText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RouterRoute.Properties.routePattern, EsbMessages.RouterRoutePropertiesEditionPart_RoutePatternLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterRoutePropertiesEditionPartImpl.this, EsbViewsRepository.RouterRoute.Properties.routePattern, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, routePattern.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterRoutePropertiesEditionPartImpl.this, EsbViewsRepository.RouterRoute.Properties.routePattern, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, routePattern.getText()));
				}
			}

		});
		EditingUtils.setID(routePattern, EsbViewsRepository.RouterRoute.Properties.routePattern);
		EditingUtils.setEEFtype(routePattern, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RouterRoute.Properties.routePattern, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#getBreakAfterRoute()
	 * 
	 */
	public Boolean getBreakAfterRoute() {
		return Boolean.valueOf(breakAfterRoute.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#setBreakAfterRoute(Boolean newValue)
	 * 
	 */
	public void setBreakAfterRoute(Boolean newValue) {
		if (newValue != null) {
			breakAfterRoute.setSelection(newValue.booleanValue());
		} else {
			breakAfterRoute.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RouterRoute.Properties.breakAfterRoute);
		if (eefElementEditorReadOnlyState && breakAfterRoute.isEnabled()) {
			breakAfterRoute.setEnabled(false);
			breakAfterRoute.setToolTipText(EsbMessages.RouterRoute_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !breakAfterRoute.isEnabled()) {
			breakAfterRoute.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#getRouteExpression()
	 * 
	 */
	public EObject getRouteExpression() {
		if (routeExpression.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) routeExpression.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#initRouteExpression(EObjectFlatComboSettings)
	 */
	public void initRouteExpression(EObjectFlatComboSettings settings) {
		routeExpression.setInput(settings);
		if (current != null) {
			routeExpression.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RouterRoute.Properties.routeExpression);
		if (eefElementEditorReadOnlyState && routeExpression.isEnabled()) {
			routeExpression.setEnabled(false);
			routeExpression.setToolTipText(EsbMessages.RouterRoute_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !routeExpression.isEnabled()) {
			routeExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#setRouteExpression(EObject newValue)
	 * 
	 */
	public void setRouteExpression(EObject newValue) {
		if (newValue != null) {
			routeExpression.setSelection(new StructuredSelection(newValue));
		} else {
			routeExpression.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RouterRoute.Properties.routeExpression);
		if (eefElementEditorReadOnlyState && routeExpression.isEnabled()) {
			routeExpression.setEnabled(false);
			routeExpression.setToolTipText(EsbMessages.RouterRoute_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !routeExpression.isEnabled()) {
			routeExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#setRouteExpressionButtonMode(ButtonsModeEnum newValue)
	 */
	public void setRouteExpressionButtonMode(ButtonsModeEnum newValue) {
		routeExpression.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#addFilterRouteExpression(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRouteExpression(ViewerFilter filter) {
		routeExpression.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#addBusinessFilterRouteExpression(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRouteExpression(ViewerFilter filter) {
		routeExpression.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#getRoutePattern()
	 * 
	 */
	public String getRoutePattern() {
		return routePattern.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#setRoutePattern(String newValue)
	 * 
	 */
	public void setRoutePattern(String newValue) {
		if (newValue != null) {
			routePattern.setText(newValue);
		} else {
			routePattern.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RouterRoute.Properties.routePattern);
		if (eefElementEditorReadOnlyState && routePattern.isEnabled()) {
			routePattern.setEnabled(false);
			routePattern.setToolTipText(EsbMessages.RouterRoute_ReadOnly);
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
		return EsbMessages.RouterRoute_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
