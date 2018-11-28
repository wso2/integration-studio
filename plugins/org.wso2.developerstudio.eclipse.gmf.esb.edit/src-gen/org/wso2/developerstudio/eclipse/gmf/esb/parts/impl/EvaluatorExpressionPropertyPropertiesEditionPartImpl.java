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
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class EvaluatorExpressionPropertyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EvaluatorExpressionPropertyPropertiesEditionPart {

	protected Text prettyName;
	protected Text evaluatorName;
	protected Text evaluatorValue;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EvaluatorExpressionPropertyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence evaluatorExpressionPropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = evaluatorExpressionPropertyStep.addStep(EsbViewsRepository.EvaluatorExpressionProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName);
		propertiesStep.addStep(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName);
		propertiesStep.addStep(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue);
		
		
		composer = new PartComposer(evaluatorExpressionPropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.EvaluatorExpressionProperty.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName) {
					return createPrettyNameText(parent);
				}
				if (key == EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName) {
					return createEvaluatorNameText(parent);
				}
				if (key == EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue) {
					return createEvaluatorValueText(parent);
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
		propertiesGroup.setText(EsbMessages.EvaluatorExpressionPropertyPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createPrettyNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName, EsbMessages.EvaluatorExpressionPropertyPropertiesEditionPart_PrettyNameLabel);
		prettyName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData prettyNameData = new GridData(GridData.FILL_HORIZONTAL);
		prettyName.setLayoutData(prettyNameData);
		prettyName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvaluatorExpressionPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, prettyName.getText()));
			}

		});
		prettyName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvaluatorExpressionPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, prettyName.getText()));
				}
			}

		});
		EditingUtils.setID(prettyName, EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName);
		EditingUtils.setEEFtype(prettyName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPrettyNameText

		// End of user code
		return parent;
	}

	
	protected Composite createEvaluatorNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName, EsbMessages.EvaluatorExpressionPropertyPropertiesEditionPart_EvaluatorNameLabel);
		evaluatorName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData evaluatorNameData = new GridData(GridData.FILL_HORIZONTAL);
		evaluatorName.setLayoutData(evaluatorNameData);
		evaluatorName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvaluatorExpressionPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, evaluatorName.getText()));
			}

		});
		evaluatorName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvaluatorExpressionPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, evaluatorName.getText()));
				}
			}

		});
		EditingUtils.setID(evaluatorName, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName);
		EditingUtils.setEEFtype(evaluatorName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEvaluatorNameText

		// End of user code
		return parent;
	}

	
	protected Composite createEvaluatorValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue, EsbMessages.EvaluatorExpressionPropertyPropertiesEditionPart_EvaluatorValueLabel);
		evaluatorValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData evaluatorValueData = new GridData(GridData.FILL_HORIZONTAL);
		evaluatorValue.setLayoutData(evaluatorValueData);
		evaluatorValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvaluatorExpressionPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, evaluatorValue.getText()));
			}

		});
		evaluatorValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvaluatorExpressionPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, evaluatorValue.getText()));
				}
			}

		});
		EditingUtils.setID(evaluatorValue, EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue);
		EditingUtils.setEEFtype(evaluatorValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEvaluatorValueText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#getPrettyName()
	 * 
	 */
	public String getPrettyName() {
		return prettyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#setPrettyName(String newValue)
	 * 
	 */
	public void setPrettyName(String newValue) {
		if (newValue != null) {
			prettyName.setText(newValue);
		} else {
			prettyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EvaluatorExpressionProperty.Properties.prettyName);
		if (eefElementEditorReadOnlyState && prettyName.isEnabled()) {
			prettyName.setEnabled(false);
			prettyName.setToolTipText(EsbMessages.EvaluatorExpressionProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !prettyName.isEnabled()) {
			prettyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#getEvaluatorName()
	 * 
	 */
	public String getEvaluatorName() {
		return evaluatorName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#setEvaluatorName(String newValue)
	 * 
	 */
	public void setEvaluatorName(String newValue) {
		if (newValue != null) {
			evaluatorName.setText(newValue);
		} else {
			evaluatorName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorName);
		if (eefElementEditorReadOnlyState && evaluatorName.isEnabled()) {
			evaluatorName.setEnabled(false);
			evaluatorName.setToolTipText(EsbMessages.EvaluatorExpressionProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !evaluatorName.isEnabled()) {
			evaluatorName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#getEvaluatorValue()
	 * 
	 */
	public String getEvaluatorValue() {
		return evaluatorValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EvaluatorExpressionPropertyPropertiesEditionPart#setEvaluatorValue(String newValue)
	 * 
	 */
	public void setEvaluatorValue(String newValue) {
		if (newValue != null) {
			evaluatorValue.setText(newValue);
		} else {
			evaluatorValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EvaluatorExpressionProperty.Properties.evaluatorValue);
		if (eefElementEditorReadOnlyState && evaluatorValue.isEnabled()) {
			evaluatorValue.setEnabled(false);
			evaluatorValue.setToolTipText(EsbMessages.EvaluatorExpressionProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !evaluatorValue.isEnabled()) {
			evaluatorValue.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.EvaluatorExpressionProperty_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
