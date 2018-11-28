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
import org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageProcessorParameterPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class MessageProcessorParameterPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, MessageProcessorParameterPropertiesEditionPart {

	protected Text parameterName;
	protected Text parameterValue;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MessageProcessorParameterPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence messageProcessorParameterStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = messageProcessorParameterStep.addStep(EsbViewsRepository.MessageProcessorParameter.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessorParameter.Properties.parameterName);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessorParameter.Properties.parameterValue);
		
		
		composer = new PartComposer(messageProcessorParameterStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.MessageProcessorParameter.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.MessageProcessorParameter.Properties.parameterName) {
					return createParameterNameText(parent);
				}
				if (key == EsbViewsRepository.MessageProcessorParameter.Properties.parameterValue) {
					return createParameterValueText(parent);
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
		propertiesGroup.setText(EsbMessages.MessageProcessorParameterPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createParameterNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessorParameter.Properties.parameterName, EsbMessages.MessageProcessorParameterPropertiesEditionPart_ParameterNameLabel);
		parameterName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData parameterNameData = new GridData(GridData.FILL_HORIZONTAL);
		parameterName.setLayoutData(parameterNameData);
		parameterName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorParameterPropertiesEditionPartImpl.this, EsbViewsRepository.MessageProcessorParameter.Properties.parameterName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterName.getText()));
			}

		});
		parameterName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorParameterPropertiesEditionPartImpl.this, EsbViewsRepository.MessageProcessorParameter.Properties.parameterName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterName.getText()));
				}
			}

		});
		EditingUtils.setID(parameterName, EsbViewsRepository.MessageProcessorParameter.Properties.parameterName);
		EditingUtils.setEEFtype(parameterName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessorParameter.Properties.parameterName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createParameterNameText

		// End of user code
		return parent;
	}

	
	protected Composite createParameterValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessorParameter.Properties.parameterValue, EsbMessages.MessageProcessorParameterPropertiesEditionPart_ParameterValueLabel);
		parameterValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData parameterValueData = new GridData(GridData.FILL_HORIZONTAL);
		parameterValue.setLayoutData(parameterValueData);
		parameterValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorParameterPropertiesEditionPartImpl.this, EsbViewsRepository.MessageProcessorParameter.Properties.parameterValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterValue.getText()));
			}

		});
		parameterValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorParameterPropertiesEditionPartImpl.this, EsbViewsRepository.MessageProcessorParameter.Properties.parameterValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, parameterValue.getText()));
				}
			}

		});
		EditingUtils.setID(parameterValue, EsbViewsRepository.MessageProcessorParameter.Properties.parameterValue);
		EditingUtils.setEEFtype(parameterValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessorParameter.Properties.parameterValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageProcessorParameterPropertiesEditionPart#getParameterName()
	 * 
	 */
	public String getParameterName() {
		return parameterName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageProcessorParameterPropertiesEditionPart#setParameterName(String newValue)
	 * 
	 */
	public void setParameterName(String newValue) {
		if (newValue != null) {
			parameterName.setText(newValue);
		} else {
			parameterName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessorParameter.Properties.parameterName);
		if (eefElementEditorReadOnlyState && parameterName.isEnabled()) {
			parameterName.setEnabled(false);
			parameterName.setToolTipText(EsbMessages.MessageProcessorParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterName.isEnabled()) {
			parameterName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageProcessorParameterPropertiesEditionPart#getParameterValue()
	 * 
	 */
	public String getParameterValue() {
		return parameterValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageProcessorParameterPropertiesEditionPart#setParameterValue(String newValue)
	 * 
	 */
	public void setParameterValue(String newValue) {
		if (newValue != null) {
			parameterValue.setText(newValue);
		} else {
			parameterValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessorParameter.Properties.parameterValue);
		if (eefElementEditorReadOnlyState && parameterValue.isEnabled()) {
			parameterValue.setEnabled(false);
			parameterValue.setToolTipText(EsbMessages.MessageProcessorParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterValue.isEnabled()) {
			parameterValue.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.MessageProcessorParameter_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
