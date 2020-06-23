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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateParameterPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class TemplateParameterPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TemplateParameterPropertiesEditionPart {

	protected Text name;



	protected Button isMandatory;
  protected Text defaultValue;



  /**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TemplateParameterPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence templateParameterStep = new BindingCompositionSequence(propertiesEditionComponent);
		templateParameterStep
			.addStep(EsbViewsRepository.TemplateParameter.Properties.class)
			.addStep(EsbViewsRepository.TemplateParameter.Properties.name)
			.addStep(EsbViewsRepository.TemplateParameter.Properties.isMandatory)
			.addStep(EsbViewsRepository.TemplateParameter.Properties.defaultValue);
		
		
		composer = new PartComposer(templateParameterStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.TemplateParameter.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.TemplateParameter.Properties.name) {
					return createNameText(parent);
				}
				if (key == EsbViewsRepository.TemplateParameter.Properties.isMandatory) {
                    return createIsMandatoryCheckbox(parent);
                }
                if (key == EsbViewsRepository.TemplateParameter.Properties.defaultValue) {
                    return createDefaultValueText(parent);
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
		propertiesGroup.setText(EsbMessages.TemplateParameterPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.TemplateParameter.Properties.name, EsbMessages.TemplateParameterPropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateParameterPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateParameter.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyReleased(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateParameterPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateParameter.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EsbViewsRepository.TemplateParameter.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateParameter.Properties.name, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}


	protected Composite createIsMandatoryCheckbox(Composite parent) {
    isMandatory = new Button(parent, SWT.CHECK);
    isMandatory.setText(getDescription(EsbViewsRepository.TemplateParameter.Properties.isMandatory, EsbMessages.TemplateParameterPropertiesEditionPart_IsMandatoryLabel));
    isMandatory.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateParameterPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateParameter.Properties.isMandatory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isMandatory.getSelection())));
      }

    });
    GridData isMandatoryData = new GridData(GridData.FILL_HORIZONTAL);
    isMandatoryData.horizontalSpan = 2;
    isMandatory.setLayoutData(isMandatoryData);
    EditingUtils.setID(isMandatory, EsbViewsRepository.TemplateParameter.Properties.isMandatory);
    EditingUtils.setEEFtype(isMandatory, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateParameter.Properties.isMandatory, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createIsMandatoryCheckbox

    // End of user code
    return parent;
  }

  protected Composite createDefaultValueText(Composite parent) {
    createDescription(parent, EsbViewsRepository.TemplateParameter.Properties.defaultValue, EsbMessages.TemplateParameterPropertiesEditionPart_DefaultValueLabel);
    defaultValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
    GridData defaultValueData = new GridData(GridData.FILL_HORIZONTAL);
    defaultValue.setLayoutData(defaultValueData);
    defaultValue.addFocusListener(new FocusAdapter() {

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
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateParameterPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateParameter.Properties.defaultValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValue.getText()));
      }

    });
    defaultValue.addKeyListener(new KeyAdapter() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
       * 
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void keyPressed(KeyEvent e) {
          if (propertiesEditionComponent != null)
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateParameterPropertiesEditionPartImpl.this, EsbViewsRepository.TemplateParameter.Properties.defaultValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValue.getText()));
        }

    });
    EditingUtils.setID(defaultValue, EsbViewsRepository.TemplateParameter.Properties.defaultValue);
    EditingUtils.setEEFtype(defaultValue, "eef::Text"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.TemplateParameter.Properties.defaultValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createDefaultValueText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateParameterPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateParameterPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateParameter.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EsbMessages.TemplateParameter_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}






	/**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateParameterPropertiesEditionPart#getIsMandatory()
   * 
   */
  public Boolean getIsMandatory() {
    return Boolean.valueOf(isMandatory.getSelection());
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateParameterPropertiesEditionPart#setIsMandatory(Boolean newValue)
   * 
   */
  public void setIsMandatory(Boolean newValue) {
    if (newValue != null) {
      isMandatory.setSelection(newValue.booleanValue());
    } else {
      isMandatory.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateParameter.Properties.isMandatory);
    if (eefElementEditorReadOnlyState && isMandatory.isEnabled()) {
      isMandatory.setEnabled(false);
      isMandatory.setToolTipText(EsbMessages.TemplateParameter_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !isMandatory.isEnabled()) {
      isMandatory.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateParameterPropertiesEditionPart#getDefaultValue()
   * 
   */
  public String getDefaultValue() {
    return defaultValue.getText();
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TemplateParameterPropertiesEditionPart#setDefaultValue(String newValue)
   * 
   */
  public void setDefaultValue(String newValue) {
    if (newValue != null) {
      defaultValue.setText(newValue);
    } else {
      defaultValue.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.TemplateParameter.Properties.defaultValue);
    if (eefElementEditorReadOnlyState && defaultValue.isEnabled()) {
      defaultValue.setEnabled(false);
      defaultValue.setToolTipText(EsbMessages.TemplateParameter_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !defaultValue.isEnabled()) {
      defaultValue.setEnabled(true);
    }	
    
  }

  /**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.TemplateParameter_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
