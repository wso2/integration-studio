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
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CommandPropertyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CommandPropertyPropertiesEditionPart {

	protected Text propertyName;
	protected EMFComboViewer valueType;
	protected Text valueLiteral;
	protected Text valueContextPropertyName;
	protected EMFComboViewer contextAction;
	protected EMFComboViewer messageAction;
	
	// Start of user code
	protected Group propertiesGroup;
	
	protected NamespacedProperty valueMessageElementXpath;
	protected Text valueMessageElementXpathText;

    protected Control[] propertyNameControls;
	protected Control[] valueTypeControls;
	protected Control[] valueLiteralControls;
	protected Control[] valueContextPropertyNameControls;
	protected Control[] contextActionControls;
	protected Control[] messageActionControls;
	protected Control[] valueMessageElementXpathControls;
	// End of user code


	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CommandPropertyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence commandPropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = commandPropertyStep.addStep(EsbViewsRepository.CommandProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.CommandProperty.Properties.propertyName);
		propertiesStep.addStep(EsbViewsRepository.CommandProperty.Properties.valueType);
		propertiesStep.addStep(EsbViewsRepository.CommandProperty.Properties.valueLiteral);
		propertiesStep.addStep(EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName);
		propertiesStep.addStep(EsbViewsRepository.CommandProperty.Properties.contextAction);
		propertiesStep.addStep(EsbViewsRepository.CommandProperty.Properties.messageAction);
		propertiesStep.addStep(EsbViewsRepository.CommandProperty.Properties.valueMessageElementXpath);
		
		composer = new PartComposer(commandPropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CommandProperty.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.CommandProperty.Properties.propertyName) {
					return createPropertyNameText(parent);
				}
				if (key == EsbViewsRepository.CommandProperty.Properties.valueType) {
					return createValueTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CommandProperty.Properties.valueLiteral) {
					return createValueLiteralText(parent);
				}
				if (key == EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName) {
					return createValueContextPropertyNameText(parent);
				}
				if (key == EsbViewsRepository.CommandProperty.Properties.contextAction) {
					return createContextActionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.CommandProperty.Properties.messageAction) {
					return createMessageActionEMFComboViewer(parent);
				}
				// Start of user code for valueMessageContextXPath
				if (key == EsbViewsRepository.CommandProperty.Properties.valueMessageElementXpath) {
                    return createValueMessageElementXpathText(parent);
                }
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.CommandPropertyPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createPropertyNameText(Composite parent) {
		Control propertyNameTextLabel = createDescription(parent, EsbViewsRepository.CommandProperty.Properties.propertyName, EsbMessages.CommandPropertyPropertiesEditionPart_PropertyNameLabel);
		propertyName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData propertyNameData = new GridData(GridData.FILL_HORIZONTAL);
		propertyName.setLayoutData(propertyNameData);
		propertyName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommandPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.CommandProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
			}

		});
		propertyName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommandPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.CommandProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
				}
			}

		});
		EditingUtils.setID(propertyName, EsbViewsRepository.CommandProperty.Properties.propertyName);
		EditingUtils.setEEFtype(propertyName, "eef::Text"); //$NON-NLS-1$
		Control propertyNameTextHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CommandProperty.Properties.propertyName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyNameText
		propertyNameControls = new Control[] { propertyNameTextLabel, propertyName, propertyNameTextHelp};
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createValueTypeEMFComboViewer(Composite parent) {
		Control valueTypeLabel = createDescription(parent, EsbViewsRepository.CommandProperty.Properties.valueType, EsbMessages.CommandPropertyPropertiesEditionPart_ValueTypeLabel);
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
				if (propertiesEditionComponent != null) {
				    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommandPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.CommandProperty.Properties.valueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
				}
				validate();
			}

		});
		valueType.setID(EsbViewsRepository.CommandProperty.Properties.valueType);
		Control valueTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CommandProperty.Properties.valueType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueTypeEMFComboViewer
		valueTypeControls =  new Control[] { valueTypeLabel, valueType.getCombo(), valueTypeHelp };
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createValueLiteralText(Composite parent) {
		Control valueLiteralLabel = createDescription(parent, EsbViewsRepository.CommandProperty.Properties.valueLiteral, EsbMessages.CommandPropertyPropertiesEditionPart_ValueLiteralLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommandPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.CommandProperty.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
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
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommandPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.CommandProperty.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
				}
			}

		});
		EditingUtils.setID(valueLiteral, EsbViewsRepository.CommandProperty.Properties.valueLiteral);
		EditingUtils.setEEFtype(valueLiteral, "eef::Text"); //$NON-NLS-1$
		Control valueLiteralHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CommandProperty.Properties.valueLiteral, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueLiteralText
		valueLiteralControls = new Control[] { valueLiteralLabel, valueLiteral, valueLiteralHelp};
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createValueContextPropertyNameText(Composite parent) {
		Control valueContextPropertyNameLabel = createDescription(parent, EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName, EsbMessages.CommandPropertyPropertiesEditionPart_ValueContextPropertyNameLabel);
		valueContextPropertyName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData valueContextPropertyNameData = new GridData(GridData.FILL_HORIZONTAL);
		valueContextPropertyName.setLayoutData(valueContextPropertyNameData);
		valueContextPropertyName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommandPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueContextPropertyName.getText()));
			}

		});
		valueContextPropertyName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommandPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueContextPropertyName.getText()));
				}
			}

		});
		EditingUtils.setID(valueContextPropertyName, EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName);
		EditingUtils.setEEFtype(valueContextPropertyName, "eef::Text"); //$NON-NLS-1$
		Control valueContextPropertyNameHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueContextPropertyNameText
		valueContextPropertyNameControls = new Control[] { valueContextPropertyNameLabel, valueContextPropertyName, valueContextPropertyNameHelp };
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createContextActionEMFComboViewer(Composite parent) {
		Control contextActionLabel = createDescription(parent, EsbViewsRepository.CommandProperty.Properties.contextAction, EsbMessages.CommandPropertyPropertiesEditionPart_ContextActionLabel);
		contextAction = new EMFComboViewer(parent);
		contextAction.setContentProvider(new ArrayContentProvider());
		contextAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData contextActionData = new GridData(GridData.FILL_HORIZONTAL);
		contextAction.getCombo().setLayoutData(contextActionData);
                contextAction.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		contextAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommandPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.CommandProperty.Properties.contextAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getContextAction()));
			}

		});
		contextAction.setID(EsbViewsRepository.CommandProperty.Properties.contextAction);
		Control contextActionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CommandProperty.Properties.contextAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createContextActionEMFComboViewer
		contextActionControls = new Control[] { contextActionLabel, contextAction.getCombo(), contextActionHelp };
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createMessageActionEMFComboViewer(Composite parent) {
		Control messageActionLabel = createDescription(parent, EsbViewsRepository.CommandProperty.Properties.messageAction, EsbMessages.CommandPropertyPropertiesEditionPart_MessageActionLabel);
		messageAction = new EMFComboViewer(parent);
		messageAction.setContentProvider(new ArrayContentProvider());
		messageAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData messageActionData = new GridData(GridData.FILL_HORIZONTAL);
		messageAction.getCombo().setLayoutData(messageActionData);
                messageAction.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		messageAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommandPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.CommandProperty.Properties.messageAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getMessageAction()));
			}

		});
		messageAction.setID(EsbViewsRepository.CommandProperty.Properties.messageAction);
		Control messageActionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CommandProperty.Properties.messageAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMessageActionEMFComboViewer
		messageActionControls = new Control[] { messageActionLabel, messageAction.getCombo(), messageActionHelp };
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#getPropertyName()
	 * 
	 */
	public String getPropertyName() {
		return propertyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#setPropertyName(String newValue)
	 * 
	 */
	public void setPropertyName(String newValue) {
		if (newValue != null) {
			propertyName.setText(newValue);
		} else {
			propertyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CommandProperty.Properties.propertyName);
		if (eefElementEditorReadOnlyState && propertyName.isEnabled()) {
			propertyName.setEnabled(false);
			propertyName.setToolTipText(EsbMessages.CommandProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyName.isEnabled()) {
			propertyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#getValueType()
	 * 
	 */
	public Enumerator getValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) valueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#initValueType(Object input, Enumerator current)
	 */
	public void initValueType(Object input, Enumerator current) {
		valueType.setInput(input);
		valueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CommandProperty.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.CommandProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#setValueType(Enumerator newValue)
	 * 
	 */
	public void setValueType(Enumerator newValue) {
		valueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CommandProperty.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.CommandProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#getValueLiteral()
	 * 
	 */
	public String getValueLiteral() {
		return valueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#setValueLiteral(String newValue)
	 * 
	 */
	public void setValueLiteral(String newValue) {
		if (newValue != null) {
			valueLiteral.setText(newValue);
		} else {
			valueLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CommandProperty.Properties.valueLiteral);
		if (eefElementEditorReadOnlyState && valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(false);
			valueLiteral.setToolTipText(EsbMessages.CommandProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#getValueContextPropertyName()
	 * 
	 */
	public String getValueContextPropertyName() {
		return valueContextPropertyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#setValueContextPropertyName(String newValue)
	 * 
	 */
	public void setValueContextPropertyName(String newValue) {
		if (newValue != null) {
			valueContextPropertyName.setText(newValue);
		} else {
			valueContextPropertyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName);
		if (eefElementEditorReadOnlyState && valueContextPropertyName.isEnabled()) {
			valueContextPropertyName.setEnabled(false);
			valueContextPropertyName.setToolTipText(EsbMessages.CommandProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueContextPropertyName.isEnabled()) {
			valueContextPropertyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#getContextAction()
	 * 
	 */
	public Enumerator getContextAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) contextAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#initContextAction(Object input, Enumerator current)
	 */
	public void initContextAction(Object input, Enumerator current) {
		contextAction.setInput(input);
		contextAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CommandProperty.Properties.contextAction);
		if (eefElementEditorReadOnlyState && contextAction.isEnabled()) {
			contextAction.setEnabled(false);
			contextAction.setToolTipText(EsbMessages.CommandProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !contextAction.isEnabled()) {
			contextAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#setContextAction(Enumerator newValue)
	 * 
	 */
	public void setContextAction(Enumerator newValue) {
		contextAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CommandProperty.Properties.contextAction);
		if (eefElementEditorReadOnlyState && contextAction.isEnabled()) {
			contextAction.setEnabled(false);
			contextAction.setToolTipText(EsbMessages.CommandProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !contextAction.isEnabled()) {
			contextAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#getMessageAction()
	 * 
	 */
	public Enumerator getMessageAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) messageAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#initMessageAction(Object input, Enumerator current)
	 */
	public void initMessageAction(Object input, Enumerator current) {
		messageAction.setInput(input);
		messageAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CommandProperty.Properties.messageAction);
		if (eefElementEditorReadOnlyState && messageAction.isEnabled()) {
			messageAction.setEnabled(false);
			messageAction.setToolTipText(EsbMessages.CommandProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !messageAction.isEnabled()) {
			messageAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart#setMessageAction(Enumerator newValue)
	 * 
	 */
	public void setMessageAction(Enumerator newValue) {
		messageAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CommandProperty.Properties.messageAction);
		if (eefElementEditorReadOnlyState && messageAction.isEnabled()) {
			messageAction.setEnabled(false);
			messageAction.setToolTipText(EsbMessages.CommandProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !messageAction.isEnabled()) {
			messageAction.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CommandProperty_Part_Title;
	}
	
	// Start of user code for valueMessageElementXpath specific getters and setters implementation
	@Override
    public NamespacedProperty getValueMessageElementXpath() {
        return valueMessageElementXpath;
    }
	
	@Override
    public void setValueMessageElementXpath(NamespacedProperty valueMessageElementXpath) {
        if (valueMessageElementXpath != null) {
            valueMessageElementXpathText.setText(valueMessageElementXpath.getPropertyValue());
            this.valueMessageElementXpath = valueMessageElementXpath;
        }
    }
    // End of user code

	// Start of user code additional method
	
    protected Composite createValueMessageElementXpathText(final Composite parent) {
        Control valueMessageElementXpathLabel = createDescription(parent,
                EsbViewsRepository.CommandProperty.Properties.valueMessageElementXpath,
                EsbMessages.CommandPropertyPropertiesEditionPart_ValueMessageElementXpathLabel);
        if (valueMessageElementXpath == null) {
            valueMessageElementXpath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        valueMessageElementXpathText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY); // $NON-NLS-1$
        GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
        valueMessageElementXpathText.setLayoutData(propertyValueData);

        EditingUtils.setID(valueMessageElementXpathText,
                EsbViewsRepository.CommandProperty.Properties.valueMessageElementXpath);
        EditingUtils.setEEFtype(valueMessageElementXpathText, "eef::Text"); //$NON-NLS-1$
        Control valueMessageElementXpathHelp = SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.CommandProperty.Properties.valueMessageElementXpath,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for valueMessageElementXpathText
        valueMessageElementXpathControls = new Control[] { valueMessageElementXpathLabel, valueMessageElementXpathText,
                valueMessageElementXpathHelp };
        // End of user code

        valueMessageElementXpathText.addMouseListener(new MouseListener() {

            @Override
            public void mouseDown(MouseEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, valueMessageElementXpath);
                nspd.open();
                valueMessageElementXpathText.setText(valueMessageElementXpath.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommandPropertyPropertiesEditionPartImpl.this, 
                        EsbViewsRepository.CommandProperty.Properties.valueMessageElementXpath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                        null, getValueMessageElementXpath()));
            }

            @Override
            public void mouseUp(MouseEvent e) {}

            @Override
            public void mouseDoubleClick(MouseEvent e) {}

        });

        valueMessageElementXpathText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, valueMessageElementXpath);
                nspd.open();
                valueMessageElementXpathText.setText(valueMessageElementXpath.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CommandPropertyPropertiesEditionPartImpl.this, 
                        EsbViewsRepository.CommandProperty.Properties.valueMessageElementXpath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                        null, getValueMessageElementXpath()));
            }

            @Override
            public void keyPressed(KeyEvent e) {}

        });

        return parent;
    }

    public void validate() {
        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { propertiesGroup });
        
        eu.showEntry(propertyNameControls, false);
        eu.showEntry(valueTypeControls, false);
        
        if (getValueType().getName().equals("LITERAL")) {
            eu.showEntry(valueLiteralControls, false);
        } else if (getValueType().getName().equals("MESSAGE_ELEMENT")) {
            eu.showEntry(messageActionControls, false);
            eu.showEntry(valueMessageElementXpathControls, false);
        } else if (getValueType().getName().equals("CONTEXT_PROPERTY")) {
            eu.showEntry(valueContextPropertyNameControls, false);
            eu.showEntry(contextActionControls, false);
        }
        
        view.layout(true, true);
    }
    
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }
    
	// End of user code


}
