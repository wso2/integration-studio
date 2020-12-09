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
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ClassPropertyPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ClassPropertyPropertiesEditionPart {

	protected Text propertyName;
	protected EMFComboViewer propertyValueType;
	protected Text propertyValue;
	// Start of user code  for propertyExpression widgets declarations
	
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public ClassPropertyPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ClassPropertyPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence classPropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = classPropertyStep.addStep(EsbViewsRepository.ClassProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ClassProperty.Properties.propertyName);
		propertiesStep.addStep(EsbViewsRepository.ClassProperty.Properties.propertyValueType);
		propertiesStep.addStep(EsbViewsRepository.ClassProperty.Properties.propertyValue);
		propertiesStep.addStep(EsbViewsRepository.ClassProperty.Properties.propertyExpression);
		
		
		composer = new PartComposer(classPropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ClassProperty.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ClassProperty.Properties.propertyName) {
					return createPropertyNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ClassProperty.Properties.propertyValueType) {
					return createPropertyValueTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ClassProperty.Properties.propertyValue) {
					return createPropertyValueText(widgetFactory, parent);
				}
				// Start of user code for propertyExpression addToPart creation
				
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
		propertiesSection.setText(EsbMessages.ClassPropertyPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createPropertyNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ClassProperty.Properties.propertyName, EsbMessages.ClassPropertyPropertiesEditionPart_PropertyNameLabel);
		propertyName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyNameData = new GridData(GridData.FILL_HORIZONTAL);
		propertyName.setLayoutData(propertyNameData);
		propertyName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ClassPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.ClassProperty.Properties.propertyName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ClassPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.ClassProperty.Properties.propertyName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, propertyName.getText()));
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
									ClassPropertyPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		propertyName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClassPropertyPropertiesEditionPartForm.this, EsbViewsRepository.ClassProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
				}
			}
		});
		EditingUtils.setID(propertyName, EsbViewsRepository.ClassProperty.Properties.propertyName);
		EditingUtils.setEEFtype(propertyName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ClassProperty.Properties.propertyName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyNameText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createPropertyValueTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ClassProperty.Properties.propertyValueType, EsbMessages.ClassPropertyPropertiesEditionPart_PropertyValueTypeLabel);
		propertyValueType = new EMFComboViewer(parent);
		propertyValueType.setContentProvider(new ArrayContentProvider());
		propertyValueType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyValueTypeData = new GridData(GridData.FILL_HORIZONTAL);
		propertyValueType.getCombo().setLayoutData(propertyValueTypeData);
                propertyValueType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		propertyValueType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClassPropertyPropertiesEditionPartForm.this, EsbViewsRepository.ClassProperty.Properties.propertyValueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyValueType()));
			}

		});
		propertyValueType.setID(EsbViewsRepository.ClassProperty.Properties.propertyValueType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ClassProperty.Properties.propertyValueType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyValueTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ClassProperty.Properties.propertyValue, EsbMessages.ClassPropertyPropertiesEditionPart_PropertyValueLabel);
		propertyValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
		propertyValue.setLayoutData(propertyValueData);
		propertyValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ClassPropertyPropertiesEditionPartForm.this,
							EsbViewsRepository.ClassProperty.Properties.propertyValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ClassPropertyPropertiesEditionPartForm.this,
									EsbViewsRepository.ClassProperty.Properties.propertyValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, propertyValue.getText()));
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
									ClassPropertyPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		propertyValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClassPropertyPropertiesEditionPartForm.this, EsbViewsRepository.ClassProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
				}
			}
		});
		EditingUtils.setID(propertyValue, EsbViewsRepository.ClassProperty.Properties.propertyValue);
		EditingUtils.setEEFtype(propertyValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ClassProperty.Properties.propertyValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyValueText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#getPropertyName()
	 * 
	 */
	public String getPropertyName() {
		return propertyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#setPropertyName(String newValue)
	 * 
	 */
	public void setPropertyName(String newValue) {
		if (newValue != null) {
			propertyName.setText(newValue);
		} else {
			propertyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ClassProperty.Properties.propertyName);
		if (eefElementEditorReadOnlyState && propertyName.isEnabled()) {
			propertyName.setEnabled(false);
			propertyName.setToolTipText(EsbMessages.ClassProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyName.isEnabled()) {
			propertyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#getPropertyValueType()
	 * 
	 */
	public Enumerator getPropertyValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyValueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#initPropertyValueType(Object input, Enumerator current)
	 */
	public void initPropertyValueType(Object input, Enumerator current) {
		propertyValueType.setInput(input);
		propertyValueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ClassProperty.Properties.propertyValueType);
		if (eefElementEditorReadOnlyState && propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(false);
			propertyValueType.setToolTipText(EsbMessages.ClassProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#setPropertyValueType(Enumerator newValue)
	 * 
	 */
	public void setPropertyValueType(Enumerator newValue) {
		propertyValueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ClassProperty.Properties.propertyValueType);
		if (eefElementEditorReadOnlyState && propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(false);
			propertyValueType.setToolTipText(EsbMessages.ClassProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#getPropertyValue()
	 * 
	 */
	public String getPropertyValue() {
		return propertyValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#setPropertyValue(String newValue)
	 * 
	 */
	public void setPropertyValue(String newValue) {
		if (newValue != null) {
			propertyValue.setText(newValue);
		} else {
			propertyValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ClassProperty.Properties.propertyValue);
		if (eefElementEditorReadOnlyState && propertyValue.isEnabled()) {
			propertyValue.setEnabled(false);
			propertyValue.setToolTipText(EsbMessages.ClassProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValue.isEnabled()) {
			propertyValue.setEnabled(true);
		}	
		
	}






	// Start of user code for propertyExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getPropertyExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPropertyExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ClassProperty_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
