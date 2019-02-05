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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class SmooksMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SmooksMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer inputType;
	protected EMFComboViewer outputType;
	protected Text outputProperty;
	protected EMFComboViewer outputAction;
	protected EMFComboViewer outputMethod;



	/**
	 * For {@link ISection} use only.
	 */
	public SmooksMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SmooksMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence smooksMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = smooksMediatorStep.addStep(EsbViewsRepository.SmooksMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.inputType);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.outputType);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.outputProperty);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.outputAction);
		propertiesStep.addStep(EsbViewsRepository.SmooksMediator.Properties.outputMethod);
		
		
		composer = new PartComposer(smooksMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.SmooksMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.inputType) {
					return createInputTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.outputType) {
					return createOutputTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.outputProperty) {
					return createOutputPropertyText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.outputAction) {
					return createOutputActionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SmooksMediator.Properties.outputMethod) {
					return createOutputMethodEMFComboViewer(widgetFactory, parent);
				}
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
		propertiesSection.setText(EsbMessages.SmooksMediatorPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Properties.description, EsbMessages.SmooksMediatorPropertiesEditionPart_DescriptionLabel);
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
							SmooksMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.SmooksMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmooksMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.SmooksMediator.Properties.description,
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
									SmooksMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.SmooksMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

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
		EditingUtils.setID(commentsList, EsbViewsRepository.SmooksMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.SmooksMediator.Properties.commentsList, EsbMessages.SmooksMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "SmooksMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.SmooksMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.SmooksMediator.Properties.reverse, EsbMessages.SmooksMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.SmooksMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createInputTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Properties.inputType, EsbMessages.SmooksMediatorPropertiesEditionPart_InputTypeLabel);
		inputType = new EMFComboViewer(parent);
		inputType.setContentProvider(new ArrayContentProvider());
		inputType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData inputTypeData = new GridData(GridData.FILL_HORIZONTAL);
		inputType.getCombo().setLayoutData(inputTypeData);
		inputType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Properties.inputType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInputType()));
			}

		});
		inputType.setID(EsbViewsRepository.SmooksMediator.Properties.inputType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Properties.inputType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOutputTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Properties.outputType, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputTypeLabel);
		outputType = new EMFComboViewer(parent);
		outputType.setContentProvider(new ArrayContentProvider());
		outputType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData outputTypeData = new GridData(GridData.FILL_HORIZONTAL);
		outputType.getCombo().setLayoutData(outputTypeData);
		outputType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Properties.outputType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputType()));
			}

		});
		outputType.setID(EsbViewsRepository.SmooksMediator.Properties.outputType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Properties.outputType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOutputPropertyText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Properties.outputProperty, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputPropertyLabel);
		outputProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		outputProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData outputPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		outputProperty.setLayoutData(outputPropertyData);
		outputProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SmooksMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.SmooksMediator.Properties.outputProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SmooksMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.SmooksMediator.Properties.outputProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, outputProperty.getText()));
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
									SmooksMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		outputProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Properties.outputProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputProperty.getText()));
				}
			}
		});
		EditingUtils.setID(outputProperty, EsbViewsRepository.SmooksMediator.Properties.outputProperty);
		EditingUtils.setEEFtype(outputProperty, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Properties.outputProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputPropertyText

		// End of user code
		return parent;
	}

	
	protected Composite createOutputActionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Properties.outputAction, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputActionLabel);
		outputAction = new EMFComboViewer(parent);
		outputAction.setContentProvider(new ArrayContentProvider());
		outputAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData outputActionData = new GridData(GridData.FILL_HORIZONTAL);
		outputAction.getCombo().setLayoutData(outputActionData);
		outputAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Properties.outputAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputAction()));
			}

		});
		outputAction.setID(EsbViewsRepository.SmooksMediator.Properties.outputAction);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Properties.outputAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputActionEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOutputMethodEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.SmooksMediator.Properties.outputMethod, EsbMessages.SmooksMediatorPropertiesEditionPart_OutputMethodLabel);
		outputMethod = new EMFComboViewer(parent);
		outputMethod.setContentProvider(new ArrayContentProvider());
		outputMethod.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData outputMethodData = new GridData(GridData.FILL_HORIZONTAL);
		outputMethod.getCombo().setLayoutData(outputMethodData);
		outputMethod.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SmooksMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SmooksMediator.Properties.outputMethod, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputMethod()));
			}

		});
		outputMethod.setID(EsbViewsRepository.SmooksMediator.Properties.outputMethod);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SmooksMediator.Properties.outputMethod, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputMethodEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getInputType()
	 * 
	 */
	public Enumerator getInputType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inputType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#initInputType(Object input, Enumerator current)
	 */
	public void initInputType(Object input, Enumerator current) {
		inputType.setInput(input);
		inputType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.inputType);
		if (eefElementEditorReadOnlyState && inputType.isEnabled()) {
			inputType.setEnabled(false);
			inputType.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputType.isEnabled()) {
			inputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setInputType(Enumerator newValue)
	 * 
	 */
	public void setInputType(Enumerator newValue) {
		inputType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.inputType);
		if (eefElementEditorReadOnlyState && inputType.isEnabled()) {
			inputType.setEnabled(false);
			inputType.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputType.isEnabled()) {
			inputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getOutputType()
	 * 
	 */
	public Enumerator getOutputType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outputType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#initOutputType(Object input, Enumerator current)
	 */
	public void initOutputType(Object input, Enumerator current) {
		outputType.setInput(input);
		outputType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.outputType);
		if (eefElementEditorReadOnlyState && outputType.isEnabled()) {
			outputType.setEnabled(false);
			outputType.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputType.isEnabled()) {
			outputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setOutputType(Enumerator newValue)
	 * 
	 */
	public void setOutputType(Enumerator newValue) {
		outputType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.outputType);
		if (eefElementEditorReadOnlyState && outputType.isEnabled()) {
			outputType.setEnabled(false);
			outputType.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputType.isEnabled()) {
			outputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getOutputProperty()
	 * 
	 */
	public String getOutputProperty() {
		return outputProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setOutputProperty(String newValue)
	 * 
	 */
	public void setOutputProperty(String newValue) {
		if (newValue != null) {
			outputProperty.setText(newValue);
		} else {
			outputProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.outputProperty);
		if (eefElementEditorReadOnlyState && outputProperty.isEnabled()) {
			outputProperty.setEnabled(false);
			outputProperty.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputProperty.isEnabled()) {
			outputProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getOutputAction()
	 * 
	 */
	public Enumerator getOutputAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outputAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#initOutputAction(Object input, Enumerator current)
	 */
	public void initOutputAction(Object input, Enumerator current) {
		outputAction.setInput(input);
		outputAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.outputAction);
		if (eefElementEditorReadOnlyState && outputAction.isEnabled()) {
			outputAction.setEnabled(false);
			outputAction.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputAction.isEnabled()) {
			outputAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setOutputAction(Enumerator newValue)
	 * 
	 */
	public void setOutputAction(Enumerator newValue) {
		outputAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.outputAction);
		if (eefElementEditorReadOnlyState && outputAction.isEnabled()) {
			outputAction.setEnabled(false);
			outputAction.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputAction.isEnabled()) {
			outputAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#getOutputMethod()
	 * 
	 */
	public Enumerator getOutputMethod() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outputMethod.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#initOutputMethod(Object input, Enumerator current)
	 */
	public void initOutputMethod(Object input, Enumerator current) {
		outputMethod.setInput(input);
		outputMethod.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.outputMethod);
		if (eefElementEditorReadOnlyState && outputMethod.isEnabled()) {
			outputMethod.setEnabled(false);
			outputMethod.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputMethod.isEnabled()) {
			outputMethod.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart#setOutputMethod(Enumerator newValue)
	 * 
	 */
	public void setOutputMethod(Enumerator newValue) {
		outputMethod.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SmooksMediator.Properties.outputMethod);
		if (eefElementEditorReadOnlyState && outputMethod.isEnabled()) {
			outputMethod.setEnabled(false);
			outputMethod.setToolTipText(EsbMessages.SmooksMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputMethod.isEnabled()) {
			outputMethod.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.SmooksMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
