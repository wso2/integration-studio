/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

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

import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class RuleFactPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RuleFactPropertiesEditionPart {

	protected EMFComboViewer factType;
	protected Text factCustomType;
	protected Text factName;
	protected EMFComboViewer valueType;
	protected Text valueLiteral;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RuleFactPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence ruleFactStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = ruleFactStep.addStep(EsbViewsRepository.RuleFact.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.factType);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.factCustomType);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.factName);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.valueType);
		propertiesStep.addStep(EsbViewsRepository.RuleFact.Properties.valueLiteral);
		
		
		composer = new PartComposer(ruleFactStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RuleFact.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.RuleFact.Properties.factType) {
					return createFactTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.RuleFact.Properties.factCustomType) {
					return createFactCustomTypeText(parent);
				}
				if (key == EsbViewsRepository.RuleFact.Properties.factName) {
					return createFactNameText(parent);
				}
				if (key == EsbViewsRepository.RuleFact.Properties.valueType) {
					return createValueTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.RuleFact.Properties.valueLiteral) {
					return createValueLiteralText(parent);
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
		propertiesGroup.setText(EsbMessages.RuleFactPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createFactTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleFact.Properties.factType, EsbMessages.RuleFactPropertiesEditionPart_FactTypeLabel);
		factType = new EMFComboViewer(parent);
		factType.setContentProvider(new ArrayContentProvider());
		factType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData factTypeData = new GridData(GridData.FILL_HORIZONTAL);
		factType.getCombo().setLayoutData(factTypeData);
		factType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartImpl.this, EsbViewsRepository.RuleFact.Properties.factType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFactType()));
			}

		});
		factType.setID(EsbViewsRepository.RuleFact.Properties.factType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleFact.Properties.factType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFactTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createFactCustomTypeText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleFact.Properties.factCustomType, EsbMessages.RuleFactPropertiesEditionPart_FactCustomTypeLabel);
		factCustomType = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData factCustomTypeData = new GridData(GridData.FILL_HORIZONTAL);
		factCustomType.setLayoutData(factCustomTypeData);
		factCustomType.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartImpl.this, EsbViewsRepository.RuleFact.Properties.factCustomType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, factCustomType.getText()));
			}

		});
		factCustomType.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartImpl.this, EsbViewsRepository.RuleFact.Properties.factCustomType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, factCustomType.getText()));
				}
			}

		});
		EditingUtils.setID(factCustomType, EsbViewsRepository.RuleFact.Properties.factCustomType);
		EditingUtils.setEEFtype(factCustomType, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleFact.Properties.factCustomType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFactCustomTypeText

		// End of user code
		return parent;
	}

	
	protected Composite createFactNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleFact.Properties.factName, EsbMessages.RuleFactPropertiesEditionPart_FactNameLabel);
		factName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData factNameData = new GridData(GridData.FILL_HORIZONTAL);
		factName.setLayoutData(factNameData);
		factName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartImpl.this, EsbViewsRepository.RuleFact.Properties.factName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, factName.getText()));
			}

		});
		factName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartImpl.this, EsbViewsRepository.RuleFact.Properties.factName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, factName.getText()));
				}
			}

		});
		EditingUtils.setID(factName, EsbViewsRepository.RuleFact.Properties.factName);
		EditingUtils.setEEFtype(factName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleFact.Properties.factName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFactNameText

		// End of user code
		return parent;
	}

	
	protected Composite createValueTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleFact.Properties.valueType, EsbMessages.RuleFactPropertiesEditionPart_ValueTypeLabel);
		valueType = new EMFComboViewer(parent);
		valueType.setContentProvider(new ArrayContentProvider());
		valueType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData valueTypeData = new GridData(GridData.FILL_HORIZONTAL);
		valueType.getCombo().setLayoutData(valueTypeData);
		valueType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartImpl.this, EsbViewsRepository.RuleFact.Properties.valueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
			}

		});
		valueType.setID(EsbViewsRepository.RuleFact.Properties.valueType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleFact.Properties.valueType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createValueLiteralText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleFact.Properties.valueLiteral, EsbMessages.RuleFactPropertiesEditionPart_ValueLiteralLabel);
		valueLiteral = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData valueLiteralData = new GridData(GridData.FILL_HORIZONTAL);
		valueLiteral.setLayoutData(valueLiteralData);
		valueLiteral.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartImpl.this, EsbViewsRepository.RuleFact.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
			}

		});
		valueLiteral.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleFactPropertiesEditionPartImpl.this, EsbViewsRepository.RuleFact.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
				}
			}

		});
		EditingUtils.setID(valueLiteral, EsbViewsRepository.RuleFact.Properties.valueLiteral);
		EditingUtils.setEEFtype(valueLiteral, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleFact.Properties.valueLiteral, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#getFactType()
	 * 
	 */
	public Enumerator getFactType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) factType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#initFactType(Object input, Enumerator current)
	 */
	public void initFactType(Object input, Enumerator current) {
		factType.setInput(input);
		factType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.factType);
		if (eefElementEditorReadOnlyState && factType.isEnabled()) {
			factType.setEnabled(false);
			factType.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !factType.isEnabled()) {
			factType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#setFactType(Enumerator newValue)
	 * 
	 */
	public void setFactType(Enumerator newValue) {
		factType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.factType);
		if (eefElementEditorReadOnlyState && factType.isEnabled()) {
			factType.setEnabled(false);
			factType.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !factType.isEnabled()) {
			factType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#getFactCustomType()
	 * 
	 */
	public String getFactCustomType() {
		return factCustomType.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#setFactCustomType(String newValue)
	 * 
	 */
	public void setFactCustomType(String newValue) {
		if (newValue != null) {
			factCustomType.setText(newValue);
		} else {
			factCustomType.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.factCustomType);
		if (eefElementEditorReadOnlyState && factCustomType.isEnabled()) {
			factCustomType.setEnabled(false);
			factCustomType.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !factCustomType.isEnabled()) {
			factCustomType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#getFactName()
	 * 
	 */
	public String getFactName() {
		return factName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#setFactName(String newValue)
	 * 
	 */
	public void setFactName(String newValue) {
		if (newValue != null) {
			factName.setText(newValue);
		} else {
			factName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.factName);
		if (eefElementEditorReadOnlyState && factName.isEnabled()) {
			factName.setEnabled(false);
			factName.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !factName.isEnabled()) {
			factName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#getValueType()
	 * 
	 */
	public Enumerator getValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) valueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#initValueType(Object input, Enumerator current)
	 */
	public void initValueType(Object input, Enumerator current) {
		valueType.setInput(input);
		valueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#setValueType(Enumerator newValue)
	 * 
	 */
	public void setValueType(Enumerator newValue) {
		valueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#getValueLiteral()
	 * 
	 */
	public String getValueLiteral() {
		return valueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleFactPropertiesEditionPart#setValueLiteral(String newValue)
	 * 
	 */
	public void setValueLiteral(String newValue) {
		if (newValue != null) {
			valueLiteral.setText(newValue);
		} else {
			valueLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleFact.Properties.valueLiteral);
		if (eefElementEditorReadOnlyState && valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(false);
			valueLiteral.setToolTipText(EsbMessages.RuleFact_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.RuleFact_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
