/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

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
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class XQueryVariablePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, XQueryVariablePropertiesEditionPart {

	protected Text variableName;
	protected EMFComboViewer variableType;
	protected EMFComboViewer valueType;
	protected Text valueLiteral;
	// Start of user code  for valueExpression widgets declarations
	
	// End of user code

	// Start of user code  for valueKey widgets declarations
	
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public XQueryVariablePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public XQueryVariablePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence xQueryVariableStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = xQueryVariableStep.addStep(EsbViewsRepository.XQueryVariable.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.variableName);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.variableType);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.valueType);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.valueLiteral);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.valueExpression);
		propertiesStep.addStep(EsbViewsRepository.XQueryVariable.Properties.valueKey);
		
		
		composer = new PartComposer(xQueryVariableStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.XQueryVariable.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XQueryVariable.Properties.variableName) {
					return createVariableNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XQueryVariable.Properties.variableType) {
					return createVariableTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XQueryVariable.Properties.valueType) {
					return createValueTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XQueryVariable.Properties.valueLiteral) {
					return createValueLiteralText(widgetFactory, parent);
				}
				// Start of user code for valueExpression addToPart creation
				
				// End of user code
				// Start of user code for valueKey addToPart creation
				
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
		propertiesSection.setText(EsbMessages.XQueryVariablePropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createVariableNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.XQueryVariable.Properties.variableName, EsbMessages.XQueryVariablePropertiesEditionPart_VariableNameLabel);
		variableName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		variableName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData variableNameData = new GridData(GridData.FILL_HORIZONTAL);
		variableName.setLayoutData(variableNameData);
		variableName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							XQueryVariablePropertiesEditionPartForm.this,
							EsbViewsRepository.XQueryVariable.Properties.variableName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, variableName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									XQueryVariablePropertiesEditionPartForm.this,
									EsbViewsRepository.XQueryVariable.Properties.variableName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, variableName.getText()));
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
									XQueryVariablePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		variableName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartForm.this, EsbViewsRepository.XQueryVariable.Properties.variableName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, variableName.getText()));
				}
			}
		});
		EditingUtils.setID(variableName, EsbViewsRepository.XQueryVariable.Properties.variableName);
		EditingUtils.setEEFtype(variableName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryVariable.Properties.variableName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createVariableNameText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createVariableTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.XQueryVariable.Properties.variableType, EsbMessages.XQueryVariablePropertiesEditionPart_VariableTypeLabel);
		variableType = new EMFComboViewer(parent);
		variableType.setContentProvider(new ArrayContentProvider());
		variableType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData variableTypeData = new GridData(GridData.FILL_HORIZONTAL);
		variableType.getCombo().setLayoutData(variableTypeData);
                variableType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		variableType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartForm.this, EsbViewsRepository.XQueryVariable.Properties.variableType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVariableType()));
			}

		});
		variableType.setID(EsbViewsRepository.XQueryVariable.Properties.variableType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryVariable.Properties.variableType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createVariableTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createValueTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.XQueryVariable.Properties.valueType, EsbMessages.XQueryVariablePropertiesEditionPart_ValueTypeLabel);
		valueType = new EMFComboViewer(parent);
		valueType.setContentProvider(new ArrayContentProvider());
		valueType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData valueTypeData = new GridData(GridData.FILL_HORIZONTAL);
		valueType.getCombo().setLayoutData(valueTypeData);
                valueType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		valueType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartForm.this, EsbViewsRepository.XQueryVariable.Properties.valueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
			}

		});
		valueType.setID(EsbViewsRepository.XQueryVariable.Properties.valueType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryVariable.Properties.valueType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createValueLiteralText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.XQueryVariable.Properties.valueLiteral, EsbMessages.XQueryVariablePropertiesEditionPart_ValueLiteralLabel);
		valueLiteral = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		valueLiteral.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueLiteralData = new GridData(GridData.FILL_HORIZONTAL);
		valueLiteral.setLayoutData(valueLiteralData);
		valueLiteral.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							XQueryVariablePropertiesEditionPartForm.this,
							EsbViewsRepository.XQueryVariable.Properties.valueLiteral,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									XQueryVariablePropertiesEditionPartForm.this,
									EsbViewsRepository.XQueryVariable.Properties.valueLiteral,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, valueLiteral.getText()));
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
									XQueryVariablePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		valueLiteral.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryVariablePropertiesEditionPartForm.this, EsbViewsRepository.XQueryVariable.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
				}
			}
		});
		EditingUtils.setID(valueLiteral, EsbViewsRepository.XQueryVariable.Properties.valueLiteral);
		EditingUtils.setEEFtype(valueLiteral, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryVariable.Properties.valueLiteral, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueLiteralText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#getVariableName()
	 * 
	 */
	public String getVariableName() {
		return variableName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#setVariableName(String newValue)
	 * 
	 */
	public void setVariableName(String newValue) {
		if (newValue != null) {
			variableName.setText(newValue);
		} else {
			variableName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.variableName);
		if (eefElementEditorReadOnlyState && variableName.isEnabled()) {
			variableName.setEnabled(false);
			variableName.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !variableName.isEnabled()) {
			variableName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#getVariableType()
	 * 
	 */
	public Enumerator getVariableType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) variableType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#initVariableType(Object input, Enumerator current)
	 */
	public void initVariableType(Object input, Enumerator current) {
		variableType.setInput(input);
		variableType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.variableType);
		if (eefElementEditorReadOnlyState && variableType.isEnabled()) {
			variableType.setEnabled(false);
			variableType.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !variableType.isEnabled()) {
			variableType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#setVariableType(Enumerator newValue)
	 * 
	 */
	public void setVariableType(Enumerator newValue) {
		variableType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.variableType);
		if (eefElementEditorReadOnlyState && variableType.isEnabled()) {
			variableType.setEnabled(false);
			variableType.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !variableType.isEnabled()) {
			variableType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#getValueType()
	 * 
	 */
	public Enumerator getValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) valueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#initValueType(Object input, Enumerator current)
	 */
	public void initValueType(Object input, Enumerator current) {
		valueType.setInput(input);
		valueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#setValueType(Enumerator newValue)
	 * 
	 */
	public void setValueType(Enumerator newValue) {
		valueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#getValueLiteral()
	 * 
	 */
	public String getValueLiteral() {
		return valueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart#setValueLiteral(String newValue)
	 * 
	 */
	public void setValueLiteral(String newValue) {
		if (newValue != null) {
			valueLiteral.setText(newValue);
		} else {
			valueLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryVariable.Properties.valueLiteral);
		if (eefElementEditorReadOnlyState && valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(false);
			valueLiteral.setToolTipText(EsbMessages.XQueryVariable_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(true);
		}	
		
	}






	// Start of user code for valueExpression specific getters and setters implementation
    @Override
    public void setValueExpression(NamespacedProperty namespacedProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public NamespacedProperty getValueExpression() {
        // TODO Auto-generated method stub
        return null;
    }
	// End of user code

	// Start of user code for valueKey specific getters and setters implementation
    @Override
    public void setValueKey(RegistryKeyProperty registryKeyProperty) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RegistryKeyProperty getValueKey() {
        // TODO Auto-generated method stub
        return null;
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.XQueryVariable_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
