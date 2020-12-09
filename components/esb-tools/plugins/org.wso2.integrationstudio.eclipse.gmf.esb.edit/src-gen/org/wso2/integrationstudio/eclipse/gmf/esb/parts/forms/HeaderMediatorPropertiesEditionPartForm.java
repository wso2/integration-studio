/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

import org.eclipse.emf.common.util.EList;
// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

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
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.eclipse.gmf.esb.HeaderAction;
import org.wso2.integrationstudio.eclipse.gmf.esb.HeaderValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * @generated NOT
 */
public class HeaderMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, HeaderMediatorPropertiesEditionPart {

	protected EMFComboViewer headerAction;
	protected EMFComboViewer valueType;
	protected EMFComboViewer scope;
	protected Text valueLiteral;
	protected Text valueInline;
	// Start of user code  for headerName widgets declarations
	protected Composite propertiesGroup;
	
	protected NamespacedProperty headerName;
	protected Text headerNameText;
	protected Control[] headerNameElements;
	// End of user code

	// Start of user code  for valueExpression widgets declarations
	protected NamespacedProperty valueExpression;
	protected Text valueExpressionText;
	protected Control[] valueExpressionElements;
	protected Control[] headerActionElements;
	protected Control[] scopeElements;
	protected Control[] valueTypeElements;
	protected Control[] valueInlineElements;
	protected Control[] valueLiteralElements;
	protected Control[] descriptionElements;
	
	protected Text commentsList;
    protected Button editCommentsList;
    protected EList commentsListList;
    protected Button reverse;
    
    protected Composite headerValueSubsectionGroup;
	// End of user code

	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public HeaderMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public HeaderMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		Form form = widgetFactory.createForm(parent);
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return form;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
        // Start of user code
		CompositionSequence headerMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = headerMediatorStep.addStep(EsbViewsRepository.HeaderMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.HeaderMediator.Properties.headerName);
		propertiesStep.addStep(EsbViewsRepository.HeaderMediator.Properties.headerAction);
		propertiesStep.addStep(EsbViewsRepository.HeaderMediator.Properties.scope);
		propertiesStep.addStep(EsbViewsRepository.HeaderMediator.Properties.valueType);
		propertiesStep.addStep(EsbViewsRepository.HeaderMediator.Properties.valueLiteral);
		propertiesStep.addStep(EsbViewsRepository.HeaderMediator.Properties.valueInline);
		propertiesStep.addStep(EsbViewsRepository.HeaderMediator.Properties.valueExpression);
		propertiesStep.addStep(EsbViewsRepository.HeaderMediator.Properties.description);
        // End of user code
		
		composer = new PartComposer(headerMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.HeaderMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.HeaderMediator.Properties.headerAction) {
					return createHeaderActionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.HeaderMediator.Properties.valueType) {
					return createValueTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.HeaderMediator.Properties.scope) {
					return createScopeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.HeaderMediator.Properties.valueLiteral) {
					return createValueLiteralText(widgetFactory, headerValueSubsectionGroup);
				}
				if (key == EsbViewsRepository.HeaderMediator.Properties.valueInline) {
					return createValueInlineText(widgetFactory, headerValueSubsectionGroup);
				}
				// Start of user code for headerName addToPart creation
				if ( key == EsbViewsRepository.HeaderMediator.Properties.headerName) {
					return createHeaderName(widgetFactory, parent);
				}
				// End of user code
				// Start of user code for valueExpression addToPart creation
				if ( key == EsbViewsRepository.HeaderMediator.Properties.valueExpression) {
					return createValueExpression(widgetFactory, headerValueSubsectionGroup);
				}
				// End of user code
				if (key == EsbViewsRepository.HeaderMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	
	/**
     * @generated NOT
     */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.HeaderMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createHeaderActionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control headerActionLabel = createDescription(parent, EsbViewsRepository.HeaderMediator.Properties.headerAction, EsbMessages.HeaderMediatorPropertiesEditionPart_HeaderActionLabel);
		headerAction = new EMFComboViewer(parent);
		headerAction.setContentProvider(new ArrayContentProvider());
		headerAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData headerActionData = new GridData(GridData.FILL_HORIZONTAL);
		headerAction.getCombo().setLayoutData(headerActionData);
                headerAction.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		headerAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HeaderMediatorPropertiesEditionPartForm.this, EsbViewsRepository.HeaderMediator.Properties.headerAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getHeaderAction()));
			}

		});
		headerAction.setID(EsbViewsRepository.HeaderMediator.Properties.headerAction);
		Control headerActionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.HeaderMediator.Properties.headerAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createHeaderActionEMFComboViewer
		headerActionElements = new Control[] {headerActionLabel, headerAction.getCombo(), headerActionHelp};
		headerAction.addSelectionChangedListener(new ISelectionChangedListener() {
            
            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createValueTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    headerValueSubsectionGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Header Value", true);
		Control valueTypeLabel = createDescription(headerValueSubsectionGroup, EsbViewsRepository.HeaderMediator.Properties.valueType, EsbMessages.HeaderMediatorPropertiesEditionPart_ValueTypeLabel);
		valueType = new EMFComboViewer(headerValueSubsectionGroup);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HeaderMediatorPropertiesEditionPartForm.this, EsbViewsRepository.HeaderMediator.Properties.valueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
			}

		});
		valueType.setID(EsbViewsRepository.HeaderMediator.Properties.valueType);
		Control valueTypeHelp = FormUtils.createHelpButton(widgetFactory, headerValueSubsectionGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.HeaderMediator.Properties.valueType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueTypeEMFComboViewer
		valueTypeElements = new Control[] {valueTypeLabel, valueType.getCombo(), valueTypeHelp};
		valueType.addSelectionChangedListener(new ISelectionChangedListener() {
            
            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createScopeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control scopeLabel = createDescription(parent, EsbViewsRepository.HeaderMediator.Properties.scope, EsbMessages.HeaderMediatorPropertiesEditionPart_ScopeLabel);
		scope = new EMFComboViewer(parent);
		scope.setContentProvider(new ArrayContentProvider());
		scope.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData scopeData = new GridData(GridData.FILL_HORIZONTAL);
		scope.getCombo().setLayoutData(scopeData);
                scope.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		scope.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HeaderMediatorPropertiesEditionPartForm.this, EsbViewsRepository.HeaderMediator.Properties.scope, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getScope()));
			}

		});
		scope.setID(EsbViewsRepository.HeaderMediator.Properties.scope);
		Control scopeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.HeaderMediator.Properties.scope, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createScopeEMFComboViewer
		scopeElements = new Control[] {scopeLabel, scope.getCombo(), scopeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createValueLiteralText(FormToolkit widgetFactory, Composite parent) {
		Control valueLiteralLabel = createDescription(parent, EsbViewsRepository.HeaderMediator.Properties.valueLiteral, EsbMessages.HeaderMediatorPropertiesEditionPart_ValueLiteralLabel);
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
							HeaderMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.HeaderMediator.Properties.valueLiteral,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									HeaderMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.HeaderMediator.Properties.valueLiteral,
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
									HeaderMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HeaderMediatorPropertiesEditionPartForm.this, EsbViewsRepository.HeaderMediator.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
				}
			}
		});
		EditingUtils.setID(valueLiteral, EsbViewsRepository.HeaderMediator.Properties.valueLiteral);
		EditingUtils.setEEFtype(valueLiteral, "eef::Text"); //$NON-NLS-1$
		Control valueLiteralHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.HeaderMediator.Properties.valueLiteral, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueLiteralText
		valueLiteralElements = new Control[] {valueLiteralLabel, valueLiteral, valueLiteralHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createValueInlineText(FormToolkit widgetFactory, Composite parent) {
		Control valueInlineLabel = createDescription(parent, EsbViewsRepository.HeaderMediator.Properties.valueInline, EsbMessages.HeaderMediatorPropertiesEditionPart_ValueInlineLabel);
		valueInline = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		valueInline.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueInlineData = new GridData(GridData.FILL_HORIZONTAL);
		valueInline.setLayoutData(valueInlineData);
		valueInline.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							HeaderMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.HeaderMediator.Properties.valueInline,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueInline.getText()));
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
									HeaderMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.HeaderMediator.Properties.valueInline,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, valueInline.getText()));
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
									HeaderMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		valueInline.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HeaderMediatorPropertiesEditionPartForm.this, EsbViewsRepository.HeaderMediator.Properties.valueInline, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueInline.getText()));
				}
			}
		});
		EditingUtils.setID(valueInline, EsbViewsRepository.HeaderMediator.Properties.valueInline);
		EditingUtils.setEEFtype(valueInline, "eef::Text"); //$NON-NLS-1$
		Control valueInlineHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.HeaderMediator.Properties.valueInline, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueInlineText
		valueInlineElements = new Control[] {valueInlineLabel, valueInline, valueInlineHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.HeaderMediator.Properties.description, EsbMessages.HeaderMediatorPropertiesEditionPart_DescriptionLabel);
		description = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		description.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							HeaderMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.HeaderMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									HeaderMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.HeaderMediator.Properties.description,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, description.getText()));
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
									HeaderMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		description.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HeaderMediatorPropertiesEditionPartForm.this, EsbViewsRepository.HeaderMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.HeaderMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.HeaderMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] {descriptionLabel, description, descriptionHelp};
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#getHeaderAction()
	 * 
	 */
	public Enumerator getHeaderAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) headerAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#initHeaderAction(Object input, Enumerator current)
	 */
	public void initHeaderAction(Object input, Enumerator current) {
		headerAction.setInput(input);
		headerAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.HeaderMediator.Properties.headerAction);
		if (eefElementEditorReadOnlyState && headerAction.isEnabled()) {
			headerAction.setEnabled(false);
			headerAction.setToolTipText(EsbMessages.HeaderMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !headerAction.isEnabled()) {
			headerAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#setHeaderAction(Enumerator newValue)
	 * 
	 */
	public void setHeaderAction(Enumerator newValue) {
		headerAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.HeaderMediator.Properties.headerAction);
		if (eefElementEditorReadOnlyState && headerAction.isEnabled()) {
			headerAction.setEnabled(false);
			headerAction.setToolTipText(EsbMessages.HeaderMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !headerAction.isEnabled()) {
			headerAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#getValueType()
	 * 
	 */
	public Enumerator getValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) valueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#initValueType(Object input, Enumerator current)
	 */
	public void initValueType(Object input, Enumerator current) {
		valueType.setInput(input);
		valueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.HeaderMediator.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.HeaderMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#setValueType(Enumerator newValue)
	 * 
	 */
	public void setValueType(Enumerator newValue) {
		valueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.HeaderMediator.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.HeaderMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#getScope()
	 * 
	 */
	public Enumerator getScope() {
		Enumerator selection = (Enumerator) ((StructuredSelection) scope.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#initScope(Object input, Enumerator current)
	 */
	public void initScope(Object input, Enumerator current) {
		scope.setInput(input);
		scope.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.HeaderMediator.Properties.scope);
		if (eefElementEditorReadOnlyState && scope.isEnabled()) {
			scope.setEnabled(false);
			scope.setToolTipText(EsbMessages.HeaderMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scope.isEnabled()) {
			scope.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#setScope(Enumerator newValue)
	 * 
	 */
	public void setScope(Enumerator newValue) {
		scope.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.HeaderMediator.Properties.scope);
		if (eefElementEditorReadOnlyState && scope.isEnabled()) {
			scope.setEnabled(false);
			scope.setToolTipText(EsbMessages.HeaderMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scope.isEnabled()) {
			scope.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#getValueLiteral()
	 * 
	 */
	public String getValueLiteral() {
		return valueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#setValueLiteral(String newValue)
	 * 
	 */
	public void setValueLiteral(String newValue) {
		if (newValue != null) {
			valueLiteral.setText(newValue);
		} else {
			valueLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.HeaderMediator.Properties.valueLiteral);
		if (eefElementEditorReadOnlyState && valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(false);
			valueLiteral.setToolTipText(EsbMessages.HeaderMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#getValueInline()
	 * 
	 */
	public String getValueInline() {
		return valueInline.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#setValueInline(String newValue)
	 * 
	 */
	public void setValueInline(String newValue) {
		if (newValue != null) {
			valueInline.setText(newValue);
		} else {
			valueInline.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.HeaderMediator.Properties.valueInline);
		if (eefElementEditorReadOnlyState && valueInline.isEnabled()) {
			valueInline.setEnabled(false);
			valueInline.setToolTipText(EsbMessages.HeaderMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueInline.isEnabled()) {
			valueInline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.HeaderMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.HeaderMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	// Start of user code for headerName specific getters and setters implementation
	@Override
	public NamespacedProperty getHeaderName() {
		return headerName;
	}

	@Override
	public void setHeaderName(NamespacedProperty namespacedProperty) {
		if (namespacedProperty != null) {
			headerName = namespacedProperty;
			headerNameText.setText(namespacedProperty.getPropertyValue());
		}
	}
	// End of user code

	// Start of user code for valueExpression specific getters and setters implementation
	@Override
	public NamespacedProperty getValueExpression() {
		return valueExpression;
	}

	@Override
	public void setValueExpression(NamespacedProperty namespacedProperty) {
		if (namespacedProperty != null) {
			valueExpression = namespacedProperty;
			valueExpressionText.setText(namespacedProperty.getPropertyValue());
		}
	}
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.HeaderMediator_Part_Title;
	}
	
	// Start of user code additional methods
	
	/**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#getCommentsList()
     * 
     */
    public EList getCommentsList() {
        return commentsListList;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#setCommentsList(EList newValue)
     * 
     */
    public void setCommentsList(EList newValue) {
        commentsListList = newValue;
        if (newValue != null) {
            commentsList.setText(commentsListList.toString());
        } else {
            commentsList.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.HeaderMediator.Properties.commentsList);
        if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
            commentsList.setEnabled(false);
            commentsList.setToolTipText(EsbMessages.HeaderMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !commentsList.isEnabled()) {
            commentsList.setEnabled(true);
        }   
        
    }

    public void addToCommentsList(Object newValue) {
        commentsListList.add(newValue);
        if (newValue != null) {
            commentsList.setText(commentsListList.toString());
        } else {
            commentsList.setText(""); //$NON-NLS-1$
        }
    }

    public void removeToCommentsList(Object newValue) {
        commentsListList.remove(newValue);
        if (newValue != null) {
            commentsList.setText(commentsListList.toString());
        } else {
            commentsList.setText(""); //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#getReverse()
     * 
     */
    public Boolean getReverse() {
        return Boolean.valueOf(reverse.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart#setReverse(Boolean newValue)
     * 
     */
    public void setReverse(Boolean newValue) {
        if (newValue != null) {
            reverse.setSelection(newValue.booleanValue());
        } else {
            reverse.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.HeaderMediator.Properties.reverse);
        if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
            reverse.setEnabled(false);
            reverse.setToolTipText(EsbMessages.HeaderMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
            reverse.setEnabled(true);
        }   
        
    }
	
    // Start of user code additional methods
	protected Composite createHeaderName(FormToolkit widgetFactory, final Composite parent) {
		Control headerNameLabel = createDescription(parent, EsbViewsRepository.HeaderMediator.Properties.headerName, EsbMessages.HeaderMediatorPropertiesEditionPart_HeaderNameLabel);
        widgetFactory.paintBordersFor(parent);
        if(headerName == null) {
            headerName = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initHeaderName = headerName.getPropertyValue().isEmpty() ? "" : headerName.getPropertyValue();
        headerNameText = widgetFactory.createText(parent, initHeaderName, 8);
        headerNameText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        headerNameText.setLayoutData(valueData);
        
        headerNameText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                openNamespacedPropertyEditorHeaderName(parent);
            }
            
        });
        
        headerNameText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {}
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openNamespacedPropertyEditorHeaderName(parent);
                }
            }
            
        });
        
        EditingUtils.setID(headerNameText, EsbViewsRepository.HeaderMediator.Properties.headerName);
        EditingUtils.setEEFtype(headerNameText, "eef::Text");
        Control headerNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.HeaderMediator.Properties.headerName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        headerNameElements = new Control[] {headerNameLabel, headerNameText, headerNameHelp};
        return parent;
	}
	
    private void openNamespacedPropertyEditorHeaderName(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                headerName);
        headerName = nspd.open();
        headerNameText.setText(headerName.getPropertyValue());
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                HeaderMediatorPropertiesEditionPartForm.this, EsbViewsRepository.HeaderMediator.Properties.headerName,
                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getHeaderName()));
    }
    
    private void openNamespacedPropertyEditorValueExpression(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                valueExpression);
        valueExpression = nspd.open();
        valueExpressionText.setText(valueExpression.getPropertyValue());
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                HeaderMediatorPropertiesEditionPartForm.this, EsbViewsRepository.HeaderMediator.Properties.valueExpression,
                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueExpression()));
    }
	
    /**
     * 
     * @generated NOT
     */
	protected Composite createValueExpression(FormToolkit widgetFactory, final Composite parent) {
		Control valueExpressionLabel = createDescription(parent, EsbViewsRepository.HeaderMediator.Properties.valueExpression, EsbMessages.HeaderMediatorPropertiesEditionPart_ValueExpressionLabel);
        widgetFactory.paintBordersFor(parent);
        if(valueExpression == null) {
            valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = valueExpression.getPropertyValue().isEmpty() ? "" : valueExpression.getPropertyValue();
        valueExpressionText = widgetFactory.createText(parent, initValueExpression, 8);
        valueExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueExpressionData = new GridData(GridData.FILL_HORIZONTAL);
        valueExpressionText.setLayoutData(valueExpressionData);

        valueExpressionText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                openNamespacedPropertyEditorValueExpression(parent);
            }
            
        });
        
        valueExpressionText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {}
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openNamespacedPropertyEditorValueExpression(parent);
                }
            }
            
        });
        
        EditingUtils.setID(valueExpressionText, EsbViewsRepository.HeaderMediator.Properties.valueExpression);
        EditingUtils.setEEFtype(valueExpressionText, "eef::Text");
        Control valueExpressionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.HeaderMediator.Properties.valueExpression, EsbViewsRepository.FORM_KIND), null);
        valueExpressionElements = new Control[] {valueExpressionLabel, valueExpressionText, valueExpressionHelp};
        return parent;
	}
	
	@Override
    public void refresh() {
        super.refresh();
        validate();
    }
	
	public void validate() {
	    EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
	    eu.clearElements(new Composite[] { propertiesGroup });
	    eu.showEntry(headerActionElements, false);
	    eu.showEntry(scopeElements, false);
        
        if (getHeaderAction().getName().equals(HeaderAction.SET.getName())) {
            eu.showEntry(new Control[] {headerValueSubsectionGroup.getParent()}, false);
            eu.clearElements(new Composite[] { headerValueSubsectionGroup });
            eu.showEntry(valueTypeElements, false);
            
            if (getValueType() != null && getValueType().getName().equals(HeaderValueType.INLINE.getName())) {
            	//inline
                eu.showEntry(valueInlineElements, false);
                
            } else if (getValueType() != null && getValueType().getName().equals(HeaderValueType.EXPRESSION.getName())) {
            	//expression
                eu.showEntry(headerNameElements, false);
                eu.showEntry(valueExpressionElements, false);
                
            } else {
            	//literal
                eu.showEntry(headerNameElements, false);
                eu.showEntry(valueLiteralElements, false);

            }
            
        } else if (getHeaderAction().getName().equals(HeaderAction.REMOVE.getName())) {
            eu.showEntry(headerNameElements, false);
        }
        
        eu.showEntry(descriptionElements, false);
        
        view.layout(true, true);
    }
	// End of user code


}
