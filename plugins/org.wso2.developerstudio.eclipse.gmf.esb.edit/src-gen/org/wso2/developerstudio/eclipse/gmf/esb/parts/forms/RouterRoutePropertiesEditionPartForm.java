/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

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
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class RouterRoutePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, RouterRoutePropertiesEditionPart {

	protected Button breakAfterRoute;
	protected EObjectFlatComboViewer routeExpression;
	protected Text routePattern;



	/**
	 * For {@link ISection} use only.
	 */
	public RouterRoutePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RouterRoutePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence routerRouteStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = routerRouteStep.addStep(EsbViewsRepository.RouterRoute.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.RouterRoute.Properties.breakAfterRoute);
		propertiesStep.addStep(EsbViewsRepository.RouterRoute.Properties.routeExpression);
		propertiesStep.addStep(EsbViewsRepository.RouterRoute.Properties.routePattern);
		
		
		composer = new PartComposer(routerRouteStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RouterRoute.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RouterRoute.Properties.breakAfterRoute) {
					return createBreakAfterRouteCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RouterRoute.Properties.routeExpression) {
					return createRouteExpressionFlatComboViewer(parent, widgetFactory);
				}
				if (key == EsbViewsRepository.RouterRoute.Properties.routePattern) {
					return createRoutePatternText(widgetFactory, parent);
				}
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
		propertiesSection.setText(EsbMessages.RouterRoutePropertiesEditionPart_PropertiesGroupLabel);
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
		breakAfterRoute = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.RouterRoute.Properties.breakAfterRoute, EsbMessages.RouterRoutePropertiesEditionPart_BreakAfterRouteLabel), SWT.CHECK);
		breakAfterRoute.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterRoutePropertiesEditionPartForm.this, EsbViewsRepository.RouterRoute.Properties.breakAfterRoute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(breakAfterRoute.getSelection())));
			}

		});
		GridData breakAfterRouteData = new GridData(GridData.FILL_HORIZONTAL);
		breakAfterRouteData.horizontalSpan = 2;
		breakAfterRoute.setLayoutData(breakAfterRouteData);
		EditingUtils.setID(breakAfterRoute, EsbViewsRepository.RouterRoute.Properties.breakAfterRoute);
		EditingUtils.setEEFtype(breakAfterRoute, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RouterRoute.Properties.breakAfterRoute, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createBreakAfterRouteCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createRouteExpressionFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EsbViewsRepository.RouterRoute.Properties.routeExpression, EsbMessages.RouterRoutePropertiesEditionPart_RouteExpressionLabel);
		routeExpression = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EsbViewsRepository.RouterRoute.Properties.routeExpression, EsbViewsRepository.FORM_KIND));
		widgetFactory.adapt(routeExpression);
		routeExpression.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData routeExpressionData = new GridData(GridData.FILL_HORIZONTAL);
		routeExpression.setLayoutData(routeExpressionData);
		routeExpression.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterRoutePropertiesEditionPartForm.this, EsbViewsRepository.RouterRoute.Properties.routeExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRouteExpression()));
			}

		});
		routeExpression.setID(EsbViewsRepository.RouterRoute.Properties.routeExpression);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RouterRoute.Properties.routeExpression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRouteExpressionFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createRoutePatternText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RouterRoute.Properties.routePattern, EsbMessages.RouterRoutePropertiesEditionPart_RoutePatternLabel);
		routePattern = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		routePattern.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData routePatternData = new GridData(GridData.FILL_HORIZONTAL);
		routePattern.setLayoutData(routePatternData);
		routePattern.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RouterRoutePropertiesEditionPartForm.this,
							EsbViewsRepository.RouterRoute.Properties.routePattern,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, routePattern.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RouterRoutePropertiesEditionPartForm.this,
									EsbViewsRepository.RouterRoute.Properties.routePattern,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, routePattern.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RouterRoutePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		routePattern.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RouterRoutePropertiesEditionPartForm.this, EsbViewsRepository.RouterRoute.Properties.routePattern, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, routePattern.getText()));
				}
			}
		});
		EditingUtils.setID(routePattern, EsbViewsRepository.RouterRoute.Properties.routePattern);
		EditingUtils.setEEFtype(routePattern, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RouterRoute.Properties.routePattern, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#getBreakAfterRoute()
	 * 
	 */
	public Boolean getBreakAfterRoute() {
		return Boolean.valueOf(breakAfterRoute.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#setBreakAfterRoute(Boolean newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#getRouteExpression()
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#initRouteExpression(EObjectFlatComboSettings)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#setRouteExpression(EObject newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#setRouteExpressionButtonMode(ButtonsModeEnum newValue)
	 */
	public void setRouteExpressionButtonMode(ButtonsModeEnum newValue) {
		routeExpression.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#addFilterRouteExpression(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRouteExpression(ViewerFilter filter) {
		routeExpression.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#addBusinessFilterRouteExpression(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRouteExpression(ViewerFilter filter) {
		routeExpression.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#getRoutePattern()
	 * 
	 */
	public String getRoutePattern() {
		return routePattern.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart#setRoutePattern(String newValue)
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
