/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

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
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class BeanMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, BeanMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text class_;
	protected EMFComboViewer action;
	protected Text var;
	protected Text property;
	protected EMFComboViewer valueType;
	protected Text valueLiteral;
	protected EMFComboViewer targetType;
	protected Text targetLiteral;
	// Start of user code  for targetExpression widgets declarations
    protected NamespacedProperty targetExpression;
    protected Text targetExpressionText;
	// End of user code

	// Start of user code  for valueExpression widgets declarations
    protected NamespacedProperty valueExpression;
    protected Text valueExpressionText;
    protected Control[] descriptionElements;
    protected Control[] valueExpressionElements;
    protected Control[] class_TextElements;
    protected Control[] actionElements;
    protected Control[] varTextElements;
    protected Control[] propertyTextElements;
    protected Control[] valueTypeElements;
    protected Control[] valueLiteralElements;
    protected Control[] targetTypeElements;
    protected Control[] targetLiteralElements;
    protected Control[] targetExpressionElements;
    protected Composite propertiesGroup;
    
    protected Composite filterValueSubPropertiesGroup;
    protected Composite filterTargetSubPropertiesGroup;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public BeanMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public BeanMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
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
	 * @generated NOT
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence beanMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = beanMediatorStep.addStep(EsbViewsRepository.BeanMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.action);
        propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.class_);
		propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.var);
		propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.property);
		propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.valueType);
		propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.valueLiteral);
		propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.targetType);
		propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.targetLiteral);
		propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.targetExpression);
		propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.valueExpression);
        propertiesStep.addStep(EsbViewsRepository.BeanMediator.Properties.description);
		
		composer = new PartComposer(beanMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
			    // Start of user code for addToPart creation
				if (key == EsbViewsRepository.BeanMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.BeanMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.BeanMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.BeanMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.BeanMediator.Properties.class_) {
					return createClass_Text(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.BeanMediator.Properties.action) {
					return createActionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.BeanMediator.Properties.var) {
					return createVarText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.BeanMediator.Properties.property) {
					return createPropertyText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.BeanMediator.Properties.valueType) {
					return createValueTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.BeanMediator.Properties.valueLiteral) {
					return createValueLiteralText(widgetFactory, filterValueSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.BeanMediator.Properties.targetType) {
					return createTargetTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.BeanMediator.Properties.targetLiteral) {
					return createTargetLiteralText(widgetFactory, filterTargetSubPropertiesGroup);
				}
                if(key == EsbViewsRepository.BeanMediator.Properties.targetExpression) {
                    return createTargetExpressionWidget(widgetFactory, filterTargetSubPropertiesGroup);
                }
                if(key == EsbViewsRepository.BeanMediator.Properties.valueExpression) {
                    return createValueExpressionWidget(widgetFactory, filterValueSubPropertiesGroup);
                }
				// End of user code
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
		propertiesSection.setText(EsbMessages.BeanMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
		createDescription(parent, EsbViewsRepository.BeanMediator.Properties.description, EsbMessages.BeanMediatorPropertiesEditionPart_DescriptionLabel);
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
							BeanMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.BeanMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BeanMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.BeanMediator.Properties.description,
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
									BeanMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this, EsbViewsRepository.BeanMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.BeanMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		Control [] newControls = propertiesGroup.getChildren();
        descriptionElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.BeanMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.BeanMediator.Properties.commentsList, EsbMessages.BeanMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
		GridData editCommentsListData = new GridData();
		editCommentsList.setLayoutData(editCommentsListData);
		editCommentsList.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						commentsList.getShell(), "BeanMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this, EsbViewsRepository.BeanMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.BeanMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.BeanMediator.Properties.reverse, EsbMessages.BeanMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this, EsbViewsRepository.BeanMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.BeanMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createClass_Text(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
		createDescription(parent, EsbViewsRepository.BeanMediator.Properties.class_, EsbMessages.BeanMediatorPropertiesEditionPart_Class_Label);
		class_ = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		class_.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData class_Data = new GridData(GridData.FILL_HORIZONTAL);
		class_.setLayoutData(class_Data);
		class_.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							BeanMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.BeanMediator.Properties.class_,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, class_.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BeanMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.BeanMediator.Properties.class_,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, class_.getText()));
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
									BeanMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		class_.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this, EsbViewsRepository.BeanMediator.Properties.class_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, class_.getText()));
				}
			}
		});
		EditingUtils.setID(class_, EsbViewsRepository.BeanMediator.Properties.class_);
		EditingUtils.setEEFtype(class_, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.class_, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createClass_Text
		Control [] newControls = propertiesGroup.getChildren();
        class_TextElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createActionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
		createDescription(parent, EsbViewsRepository.BeanMediator.Properties.action, EsbMessages.BeanMediatorPropertiesEditionPart_ActionLabel);
		action = new EMFComboViewer(parent);
		action.setContentProvider(new ArrayContentProvider());
		action.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData actionData = new GridData(GridData.FILL_HORIZONTAL);
		action.getCombo().setLayoutData(actionData);
                action.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		action.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this, EsbViewsRepository.BeanMediator.Properties.action, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAction()));
			}

		});
		action.setID(EsbViewsRepository.BeanMediator.Properties.action);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.action, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createActionEMFComboViewer
		Control [] newControls = propertiesGroup.getChildren();
        actionElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
        action.addSelectionChangedListener(new ISelectionChangedListener() {

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
	protected Composite createVarText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
		createDescription(parent, EsbViewsRepository.BeanMediator.Properties.var, EsbMessages.BeanMediatorPropertiesEditionPart_VarLabel);
		var = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		var.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData varData = new GridData(GridData.FILL_HORIZONTAL);
		var.setLayoutData(varData);
		var.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							BeanMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.BeanMediator.Properties.var,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, var.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BeanMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.BeanMediator.Properties.var,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, var.getText()));
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
									BeanMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		var.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this, EsbViewsRepository.BeanMediator.Properties.var, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, var.getText()));
				}
			}
		});
		EditingUtils.setID(var, EsbViewsRepository.BeanMediator.Properties.var);
		EditingUtils.setEEFtype(var, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.var, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createVarText
		Control [] newControls = propertiesGroup.getChildren();
        varTextElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createPropertyText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
		createDescription(parent, EsbViewsRepository.BeanMediator.Properties.property, EsbMessages.BeanMediatorPropertiesEditionPart_PropertyLabel);
		property = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		property.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyData = new GridData(GridData.FILL_HORIZONTAL);
		property.setLayoutData(propertyData);
		property.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							BeanMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.BeanMediator.Properties.property,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, property.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BeanMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.BeanMediator.Properties.property,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, property.getText()));
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
									BeanMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		property.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this, EsbViewsRepository.BeanMediator.Properties.property, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, property.getText()));
				}
			}
		});
		EditingUtils.setID(property, EsbViewsRepository.BeanMediator.Properties.property);
		EditingUtils.setEEFtype(property, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.property, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyText
		Control [] newControls = propertiesGroup.getChildren();
        propertyTextElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createValueTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    filterValueSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Value", true);
	    Control [] previousControls = filterValueSubPropertiesGroup.getChildren();
		createDescription(filterValueSubPropertiesGroup, EsbViewsRepository.BeanMediator.Properties.valueType, EsbMessages.BeanMediatorPropertiesEditionPart_ValueTypeLabel);
		valueType = new EMFComboViewer(filterValueSubPropertiesGroup);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this, EsbViewsRepository.BeanMediator.Properties.valueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getValueType()));
			}

		});
		valueType.setID(EsbViewsRepository.BeanMediator.Properties.valueType);
		FormUtils.createHelpButton(widgetFactory, filterValueSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.valueType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueTypeEMFComboViewer
		Control [] newControls = filterValueSubPropertiesGroup.getChildren();
        valueTypeElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
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
	protected Composite createValueLiteralText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = filterValueSubPropertiesGroup.getChildren();
		createDescription(parent, EsbViewsRepository.BeanMediator.Properties.valueLiteral, EsbMessages.BeanMediatorPropertiesEditionPart_ValueLiteralLabel);
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
							BeanMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.BeanMediator.Properties.valueLiteral,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BeanMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.BeanMediator.Properties.valueLiteral,
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
									BeanMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this, EsbViewsRepository.BeanMediator.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
				}
			}
		});
		EditingUtils.setID(valueLiteral, EsbViewsRepository.BeanMediator.Properties.valueLiteral);
		EditingUtils.setEEFtype(valueLiteral, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.valueLiteral, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueLiteralText
		Control [] newControls = filterValueSubPropertiesGroup.getChildren();
        valueLiteralElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createTargetTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    filterTargetSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Target", true);
	    Control [] previousControls = filterTargetSubPropertiesGroup.getChildren();
		createDescription(filterTargetSubPropertiesGroup, EsbViewsRepository.BeanMediator.Properties.targetType, EsbMessages.BeanMediatorPropertiesEditionPart_TargetTypeLabel);
		targetType = new EMFComboViewer(filterTargetSubPropertiesGroup);
		targetType.setContentProvider(new ArrayContentProvider());
		targetType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData targetTypeData = new GridData(GridData.FILL_HORIZONTAL);
		targetType.getCombo().setLayoutData(targetTypeData);
                targetType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		targetType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this, EsbViewsRepository.BeanMediator.Properties.targetType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetType()));
			}

		});
		targetType.setID(EsbViewsRepository.BeanMediator.Properties.targetType);
		FormUtils.createHelpButton(widgetFactory, filterTargetSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.targetType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetTypeEMFComboViewer
		Control [] newControls = filterTargetSubPropertiesGroup.getChildren();
        targetTypeElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
        targetType.addSelectionChangedListener(new ISelectionChangedListener() {

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
	protected Composite createTargetLiteralText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = filterTargetSubPropertiesGroup.getChildren();
		createDescription(parent, EsbViewsRepository.BeanMediator.Properties.targetLiteral, EsbMessages.BeanMediatorPropertiesEditionPart_TargetLiteralLabel);
		targetLiteral = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		targetLiteral.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData targetLiteralData = new GridData(GridData.FILL_HORIZONTAL);
		targetLiteral.setLayoutData(targetLiteralData);
		targetLiteral.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							BeanMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.BeanMediator.Properties.targetLiteral,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetLiteral.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BeanMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.BeanMediator.Properties.targetLiteral,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, targetLiteral.getText()));
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
									BeanMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		targetLiteral.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this, EsbViewsRepository.BeanMediator.Properties.targetLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetLiteral.getText()));
				}
			}
		});
		EditingUtils.setID(targetLiteral, EsbViewsRepository.BeanMediator.Properties.targetLiteral);
		EditingUtils.setEEFtype(targetLiteral, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.targetLiteral, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetLiteralText
		Control [] newControls = filterTargetSubPropertiesGroup.getChildren();
        targetLiteralElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#getClass_()
	 * 
	 */
	public String getClass_() {
		return class_.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#setClass_(String newValue)
	 * 
	 */
	public void setClass_(String newValue) {
		if (newValue != null) {
			class_.setText(newValue);
		} else {
			class_.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.class_);
		if (eefElementEditorReadOnlyState && class_.isEnabled()) {
			class_.setEnabled(false);
			class_.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !class_.isEnabled()) {
			class_.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#getAction()
	 * 
	 */
	public Enumerator getAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) action.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#initAction(Object input, Enumerator current)
	 */
	public void initAction(Object input, Enumerator current) {
		action.setInput(input);
		action.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.action);
		if (eefElementEditorReadOnlyState && action.isEnabled()) {
			action.setEnabled(false);
			action.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !action.isEnabled()) {
			action.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#setAction(Enumerator newValue)
	 * 
	 */
	public void setAction(Enumerator newValue) {
		action.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.action);
		if (eefElementEditorReadOnlyState && action.isEnabled()) {
			action.setEnabled(false);
			action.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !action.isEnabled()) {
			action.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#getVar()
	 * 
	 */
	public String getVar() {
		return var.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#setVar(String newValue)
	 * 
	 */
	public void setVar(String newValue) {
		if (newValue != null) {
			var.setText(newValue);
		} else {
			var.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.var);
		if (eefElementEditorReadOnlyState && var.isEnabled()) {
			var.setEnabled(false);
			var.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !var.isEnabled()) {
			var.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#getProperty()
	 * 
	 */
	public String getProperty() {
		return property.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#setProperty(String newValue)
	 * 
	 */
	public void setProperty(String newValue) {
		if (newValue != null) {
			property.setText(newValue);
		} else {
			property.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.property);
		if (eefElementEditorReadOnlyState && property.isEnabled()) {
			property.setEnabled(false);
			property.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !property.isEnabled()) {
			property.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#getValueType()
	 * 
	 */
	public Enumerator getValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) valueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#initValueType(Object input, Enumerator current)
	 */
	public void initValueType(Object input, Enumerator current) {
		valueType.setInput(input);
		valueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#setValueType(Enumerator newValue)
	 * 
	 */
	public void setValueType(Enumerator newValue) {
		valueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.valueType);
		if (eefElementEditorReadOnlyState && valueType.isEnabled()) {
			valueType.setEnabled(false);
			valueType.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueType.isEnabled()) {
			valueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#getValueLiteral()
	 * 
	 */
	public String getValueLiteral() {
		return valueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#setValueLiteral(String newValue)
	 * 
	 */
	public void setValueLiteral(String newValue) {
		if (newValue != null) {
			valueLiteral.setText(newValue);
		} else {
			valueLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.valueLiteral);
		if (eefElementEditorReadOnlyState && valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(false);
			valueLiteral.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#getTargetType()
	 * 
	 */
	public Enumerator getTargetType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#initTargetType(Object input, Enumerator current)
	 */
	public void initTargetType(Object input, Enumerator current) {
		targetType.setInput(input);
		targetType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#setTargetType(Enumerator newValue)
	 * 
	 */
	public void setTargetType(Enumerator newValue) {
		targetType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#getTargetLiteral()
	 * 
	 */
	public String getTargetLiteral() {
		return targetLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart#setTargetLiteral(String newValue)
	 * 
	 */
	public void setTargetLiteral(String newValue) {
		if (newValue != null) {
			targetLiteral.setText(newValue);
		} else {
			targetLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.BeanMediator.Properties.targetLiteral);
		if (eefElementEditorReadOnlyState && targetLiteral.isEnabled()) {
			targetLiteral.setEnabled(false);
			targetLiteral.setToolTipText(EsbMessages.BeanMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetLiteral.isEnabled()) {
			targetLiteral.setEnabled(true);
		}	
		
	}






	// Start of user code for targetExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getTargetExpression() {
        // TODO Auto-generated method stub
        return targetExpression;
    }

    @Override
    public void setTargetExpression(NamespacedProperty namespacedProperty) {
        if(namespacedProperty != null) {
            targetExpressionText.setText(namespacedProperty.getPropertyValue());
            targetExpression = namespacedProperty;
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
        if(namespacedProperty != null) {
            valueExpressionText.setText(namespacedProperty.getPropertyValue());
            valueExpression = namespacedProperty;
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
		return EsbMessages.BeanMediator_Part_Title;
	}




	// Start of user code additional methods
    protected Composite createValueExpressionWidget(FormToolkit widgetFactory,final Composite parent) {
        Control valueExpressionLabel = createDescription(parent, EsbViewsRepository.BeanMediator.Properties.valueExpression, EsbMessages.BeanMediatorPropertiesEditionPart_ValueExpressionLabel);
        widgetFactory.paintBordersFor(parent);
        if(valueExpression == null) {
            valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = valueExpression.getPropertyValue().isEmpty() ? "" : valueExpression.getPropertyValue();
        valueExpressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        valueExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        valueExpressionText.setLayoutData(valueData);
        
        valueExpressionText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                openValueExpressionWidgetNamespacedPropertyEditor(parent);
            }
            
        });
        
        valueExpressionText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openValueExpressionWidgetNamespacedPropertyEditor(parent);
                }
            }
                        
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(valueExpressionText, EsbViewsRepository.BeanMediator.Properties.valueExpression);
        EditingUtils.setEEFtype(valueExpressionText, "eef::Text");
        Control valueExpressionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.valueExpression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        valueExpressionElements = new Control[] {valueExpressionLabel, valueExpressionText, valueExpressionHelp};
        return parent;
    }

    protected Composite createTargetExpressionWidget(FormToolkit widgetFactory,final Composite parent) {
        Control targetExpressionLabel = createDescription(parent, EsbViewsRepository.BeanMediator.Properties.targetExpression, EsbMessages.BeanMediatorPropertiesEditionPart_TargetExpressionLabel);
        widgetFactory.paintBordersFor(parent);
        if(targetExpression == null) {
            targetExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = targetExpression.getPropertyValue().isEmpty() ? "" : targetExpression.getPropertyValue();
        targetExpressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        targetExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData targetData = new GridData(GridData.FILL_HORIZONTAL);
        targetExpressionText.setLayoutData(targetData);
        
        targetExpressionText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                openTargetExpressionWidgetNamespacedPropertyEditor(parent);
            }
            
        });
        
        targetExpressionText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openTargetExpressionWidgetNamespacedPropertyEditor(parent);
                }
            }
                        
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(targetExpressionText, EsbViewsRepository.BeanMediator.Properties.targetExpression);
        EditingUtils.setEEFtype(targetExpressionText, "eef::Text");
        Control targetExpressionHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.BeanMediator.Properties.targetExpression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        targetExpressionElements = new Control[] {targetExpressionLabel, targetExpressionText, targetExpressionHelp};
        return parent;
    }
    
    private void openValueExpressionWidgetNamespacedPropertyEditor(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                valueExpression);
        valueExpression = nspd.open();
        valueExpressionText.setText(valueExpression.getPropertyValue());
        propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.BeanMediator.Properties.valueExpression, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getValueExpression()));
    }
    
    private void openTargetExpressionWidgetNamespacedPropertyEditor(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                targetExpression);
        targetExpression = nspd.open();
        targetExpressionText.setText(targetExpression.getPropertyValue());
        propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(BeanMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.BeanMediator.Properties.targetExpression, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getValueExpression()));
    }
    
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] {propertiesGroup});

        epv.showEntry(actionElements, false);
        epv.showEntry(varTextElements, false);
        epv.showEntry(descriptionElements, false);

        switch (getAction().getLiteral()) {
        case "CREATE":
            epv.showEntry(class_TextElements, false);
            break;
        case "SET_PROPERTY":
            epv.showEntry(new Control[] { filterValueSubPropertiesGroup.getParent() }, false);
            epv.clearElements(new Composite[] { filterValueSubPropertiesGroup });
            epv.showEntry(propertyTextElements, false);
            epv.showEntry(valueTypeElements, false);
            break;
        case "GET_PROPERTY":
            epv.showEntry(new Control[] { filterTargetSubPropertiesGroup.getParent() }, false);
            epv.clearElements(new Composite[] { filterTargetSubPropertiesGroup });
            epv.showEntry(propertyTextElements, false);
            epv.showEntry(targetTypeElements, false);
            break;
        case "REMOVE":
            break;
        }

        if (getAction().equals(BeanMediatorAction.SET_PROPERTY)) {
            switch (getValueType().getLiteral()) {
            case "LITERAL":
                epv.showEntry(valueLiteralElements, false);
                break;
            case "EXPRESSION":
                epv.showEntry(valueExpressionElements, false);
                break;
            }
        } else if (getAction().equals(BeanMediatorAction.GET_PROPERTY)) {
            switch (getTargetType().getLiteral()) {
            case "LITERAL":
                epv.showEntry(targetLiteralElements, false);
                break;
            case "EXPRESSION":
                epv.showEntry(targetExpressionElements, false);
                break;
            }
        }

        view.layout(true, true);
    }
	// End of user code


}
