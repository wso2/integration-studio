/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.util.EcoreAdapterFactory;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

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

import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CallTemplateParameterPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, CallTemplateParameterPropertiesEditionPart {

	protected Text parameterName;
	protected EMFComboViewer templateParameterType;
	protected Text parameterValue;
	// Start of user code  for parameterExpression widgets declarations
	
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public CallTemplateParameterPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CallTemplateParameterPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence callTemplateParameterStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = callTemplateParameterStep.addStep(EsbViewsRepository.CallTemplateParameter.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateParameter.Properties.parameterName);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateParameter.Properties.parameterValue);
		propertiesStep.addStep(EsbViewsRepository.CallTemplateParameter.Properties.parameterExpression);
		
		
		composer = new PartComposer(callTemplateParameterStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CallTemplateParameter.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallTemplateParameter.Properties.parameterName) {
					return createParameterNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType) {
					return createTemplateParameterTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CallTemplateParameter.Properties.parameterValue) {
					return createParameterValueText(widgetFactory, parent);
				}
				// Start of user code for parameterExpression addToPart creation
				
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
		propertiesSection.setText(EsbMessages.CallTemplateParameterPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createParameterNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CallTemplateParameter.Properties.parameterName, EsbMessages.CallTemplateParameterPropertiesEditionPart_ParameterNameLabel);
		parameterName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		parameterName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData parameterNameData = new GridData(GridData.FILL_HORIZONTAL);
		parameterName.setLayoutData(parameterNameData);
		parameterName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CallTemplateParameterPropertiesEditionPartForm.this,
							EsbViewsRepository.CallTemplateParameter.Properties.parameterName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CallTemplateParameterPropertiesEditionPartForm.this,
									EsbViewsRepository.CallTemplateParameter.Properties.parameterName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, parameterName.getText()));
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
									CallTemplateParameterPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		parameterName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateParameterPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateParameter.Properties.parameterName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterName.getText()));
				}
			}
		});
		EditingUtils.setID(parameterName, EsbViewsRepository.CallTemplateParameter.Properties.parameterName);
		EditingUtils.setEEFtype(parameterName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallTemplateParameter.Properties.parameterName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createParameterNameText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createTemplateParameterTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType, EsbMessages.CallTemplateParameterPropertiesEditionPart_TemplateParameterTypeLabel);
		templateParameterType = new EMFComboViewer(parent);
		templateParameterType.setContentProvider(new ArrayContentProvider());
		templateParameterType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData templateParameterTypeData = new GridData(GridData.FILL_HORIZONTAL);
		templateParameterType.getCombo().setLayoutData(templateParameterTypeData);
                templateParameterType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		templateParameterType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateParameterPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTemplateParameterType()));
			}

		});
		templateParameterType.setID(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTemplateParameterTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createParameterValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CallTemplateParameter.Properties.parameterValue, EsbMessages.CallTemplateParameterPropertiesEditionPart_ParameterValueLabel);
		parameterValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		parameterValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData parameterValueData = new GridData(GridData.FILL_HORIZONTAL);
		parameterValue.setLayoutData(parameterValueData);
		parameterValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CallTemplateParameterPropertiesEditionPartForm.this,
							EsbViewsRepository.CallTemplateParameter.Properties.parameterValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CallTemplateParameterPropertiesEditionPartForm.this,
									EsbViewsRepository.CallTemplateParameter.Properties.parameterValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, parameterValue.getText()));
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
									CallTemplateParameterPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		parameterValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CallTemplateParameterPropertiesEditionPartForm.this, EsbViewsRepository.CallTemplateParameter.Properties.parameterValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterValue.getText()));
				}
			}
		});
		EditingUtils.setID(parameterValue, EsbViewsRepository.CallTemplateParameter.Properties.parameterValue);
		EditingUtils.setEEFtype(parameterValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CallTemplateParameter.Properties.parameterValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createParameterValueText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#getParameterName()
	 * 
	 */
	public String getParameterName() {
		return parameterName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#setParameterName(String newValue)
	 * 
	 */
	public void setParameterName(String newValue) {
		if (newValue != null) {
			parameterName.setText(newValue);
		} else {
			parameterName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateParameter.Properties.parameterName);
		if (eefElementEditorReadOnlyState && parameterName.isEnabled()) {
			parameterName.setEnabled(false);
			parameterName.setToolTipText(EsbMessages.CallTemplateParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterName.isEnabled()) {
			parameterName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#getTemplateParameterType()
	 * 
	 */
	public Enumerator getTemplateParameterType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) templateParameterType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#initTemplateParameterType(Object input, Enumerator current)
	 */
	public void initTemplateParameterType(Object input, Enumerator current) {
		templateParameterType.setInput(input);
		templateParameterType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType);
		if (eefElementEditorReadOnlyState && templateParameterType.isEnabled()) {
			templateParameterType.setEnabled(false);
			templateParameterType.setToolTipText(EsbMessages.CallTemplateParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !templateParameterType.isEnabled()) {
			templateParameterType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#setTemplateParameterType(Enumerator newValue)
	 * 
	 */
	public void setTemplateParameterType(Enumerator newValue) {
		templateParameterType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateParameter.Properties.templateParameterType);
		if (eefElementEditorReadOnlyState && templateParameterType.isEnabled()) {
			templateParameterType.setEnabled(false);
			templateParameterType.setToolTipText(EsbMessages.CallTemplateParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !templateParameterType.isEnabled()) {
			templateParameterType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#getParameterValue()
	 * 
	 */
	public String getParameterValue() {
		return parameterValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallTemplateParameterPropertiesEditionPart#setParameterValue(String newValue)
	 * 
	 */
	public void setParameterValue(String newValue) {
		if (newValue != null) {
			parameterValue.setText(newValue);
		} else {
			parameterValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CallTemplateParameter.Properties.parameterValue);
		if (eefElementEditorReadOnlyState && parameterValue.isEnabled()) {
			parameterValue.setEnabled(false);
			parameterValue.setToolTipText(EsbMessages.CallTemplateParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterValue.isEnabled()) {
			parameterValue.setEnabled(true);
		}	
		
	}






	// Start of user code for parameterExpression specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CallTemplateParameter_Part_Title;
	}

	// Start of user code additional methods

    @Override
    public NamespacedProperty getParameterExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setParameterExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }
	// End of user code


}
