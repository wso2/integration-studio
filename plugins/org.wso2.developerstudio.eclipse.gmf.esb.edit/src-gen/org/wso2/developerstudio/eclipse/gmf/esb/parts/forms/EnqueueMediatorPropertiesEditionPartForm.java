/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class EnqueueMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, EnqueueMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text executor;
	protected Text priority;
	// Start of user code  for sequenceKey widgets declarations
	protected RegistryKeyProperty sequenceKey;
	
	protected Text sequenceKeyText;
	
	protected Control[] sequenceKeyElements;
	protected Control[] priorityElements;
	protected Control[] executorElements;
	protected Control[] descriptionElements;
	
	protected Composite propertiesGroup;
	
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public EnqueueMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EnqueueMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence enqueueMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = enqueueMediatorStep.addStep(EsbViewsRepository.EnqueueMediator.Properties.class);
		// Start of user code for createControls
		propertiesStep.addStep(EsbViewsRepository.EnqueueMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.EnqueueMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.EnqueueMediator.Properties.executor);
		propertiesStep.addStep(EsbViewsRepository.EnqueueMediator.Properties.priority);
		propertiesStep.addStep(EsbViewsRepository.EnqueueMediator.Properties.sequenceKey);
		propertiesStep.addStep(EsbViewsRepository.EnqueueMediator.Properties.description);
		// End of user code
		
		composer = new PartComposer(enqueueMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.EnqueueMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnqueueMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnqueueMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnqueueMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnqueueMediator.Properties.executor) {
					return createExecutorText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnqueueMediator.Properties.priority) {
					return createPriorityText(widgetFactory, parent);
				}
				// Start of user code for sequenceKey addToPart creation
				if (key == EsbViewsRepository.EnqueueMediator.Properties.sequenceKey) {
                    return createSequenceKey(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.EnqueueMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.EnqueueMediator.Properties.description, EsbMessages.EnqueueMediatorPropertiesEditionPart_DescriptionLabel);
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
							EnqueueMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EnqueueMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EnqueueMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EnqueueMediator.Properties.description,
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
									EnqueueMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnqueueMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnqueueMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.EnqueueMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnqueueMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] {descriptionLabel, description, descriptionHelp};
		// End of user code
		return parent;
	}

	 /**
     * @generated NOT
     */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.EnqueueMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.EnqueueMediator.Properties.commentsList, EsbMessages.EnqueueMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "EnqueueMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnqueueMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnqueueMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.EnqueueMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	 /**
     * @generated NOT
     */
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.EnqueueMediator.Properties.reverse, EsbMessages.EnqueueMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnqueueMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnqueueMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.EnqueueMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnqueueMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	 /**
     * @generated NOT
     */
	protected Composite createExecutorText(FormToolkit widgetFactory, Composite parent) {
		Control executorLabel =  createDescription(parent, EsbViewsRepository.EnqueueMediator.Properties.executor, EsbMessages.EnqueueMediatorPropertiesEditionPart_ExecutorLabel);
		executor = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		executor.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData executorData = new GridData(GridData.FILL_HORIZONTAL);
		executor.setLayoutData(executorData);
		executor.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EnqueueMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EnqueueMediator.Properties.executor,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, executor.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EnqueueMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EnqueueMediator.Properties.executor,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, executor.getText()));
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
									EnqueueMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		executor.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnqueueMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnqueueMediator.Properties.executor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, executor.getText()));
				}
			}
		});
		EditingUtils.setID(executor, EsbViewsRepository.EnqueueMediator.Properties.executor);
		EditingUtils.setEEFtype(executor, "eef::Text"); //$NON-NLS-1$
		Control executorHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnqueueMediator.Properties.executor, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createExecutorText
		executorElements = new Control[] {executorLabel, executor, executorHelp};
		// End of user code
		return parent;
	}

	 /**
     * @generated NOT
     */
	protected Composite createPriorityText(FormToolkit widgetFactory, Composite parent) {
		Control priorityLabel = createDescription(parent, EsbViewsRepository.EnqueueMediator.Properties.priority, EsbMessages.EnqueueMediatorPropertiesEditionPart_PriorityLabel);
		priority = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		priority.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData priorityData = new GridData(GridData.FILL_HORIZONTAL);
		priority.setLayoutData(priorityData);
		priority.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EnqueueMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EnqueueMediator.Properties.priority,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, priority.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EnqueueMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EnqueueMediator.Properties.priority,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, priority.getText()));
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
									EnqueueMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		priority.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnqueueMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnqueueMediator.Properties.priority, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, priority.getText()));
				}
			}
		});
		EditingUtils.setID(priority, EsbViewsRepository.EnqueueMediator.Properties.priority);
		EditingUtils.setEEFtype(priority, "eef::Text"); //$NON-NLS-1$
		Control priorityHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnqueueMediator.Properties.priority, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPriorityText
		priorityElements = new Control[] {priorityLabel, priority, priorityHelp};
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnqueueMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.EnqueueMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnqueueMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.EnqueueMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnqueueMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.EnqueueMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart#getExecutor()
	 * 
	 */
	public String getExecutor() {
		return executor.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart#setExecutor(String newValue)
	 * 
	 */
	public void setExecutor(String newValue) {
		if (newValue != null) {
			executor.setText(newValue);
		} else {
			executor.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnqueueMediator.Properties.executor);
		if (eefElementEditorReadOnlyState && executor.isEnabled()) {
			executor.setEnabled(false);
			executor.setToolTipText(EsbMessages.EnqueueMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !executor.isEnabled()) {
			executor.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart#getPriority()
	 * 
	 */
	public String getPriority() {
		return priority.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnqueueMediatorPropertiesEditionPart#setPriority(String newValue)
	 * 
	 */
	public void setPriority(String newValue) {
		if (newValue != null) {
			priority.setText(newValue);
		} else {
			priority.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnqueueMediator.Properties.priority);
		if (eefElementEditorReadOnlyState && priority.isEnabled()) {
			priority.setEnabled(false);
			priority.setToolTipText(EsbMessages.EnqueueMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !priority.isEnabled()) {
			priority.setEnabled(true);
		}	
		
	}






	// Start of user code for sequenceKey specific getters and setters implementation
    @Override
    public void setSequenceKey(RegistryKeyProperty registryKeyProperty) {
        if (sequenceKey != null) {
            sequenceKey = registryKeyProperty;
            sequenceKeyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getSequenceKey() {
        return sequenceKey;
    }
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.EnqueueMediator_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createSequenceKey(FormToolkit widgetFactory, final Composite parent) {
        Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.EnqueueMediator.Properties.sequenceKey,
                EsbMessages.EnqueueMediatorPropertiesEditionPart_SequenceKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (sequenceKey == null) {
            sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initSequenceKey = sequenceKey.getKeyValue().isEmpty() ? "" : sequenceKey.getKeyValue();
        sequenceKeyText = widgetFactory.createText(parent, initSequenceKey, SWT.READ_ONLY);
        sequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        sequenceKeyText.setLayoutData(valueData);
        sequenceKeyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                sequenceKeyText.setText(sequenceKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(EnqueueMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.EnqueueMediator.Properties.sequenceKey, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getSequenceKey()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        EditingUtils.setID(sequenceKeyText, EsbViewsRepository.EnqueueMediator.Properties.sequenceKey);
        EditingUtils.setEEFtype(sequenceKeyText, "eef::Text");
        Control sequenceKeyHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.EnqueueMediator.Properties.sequenceKey, EsbViewsRepository.FORM_KIND),
                        null);
        sequenceKeyElements = new Control[] { sequenceKeyLabel, sequenceKeyText, sequenceKeyHelp };
        return parent;
    }
	
	public void refresh() {
        super.refresh();
        validate();
    }
	
	public void validate() {
	    EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { propertiesGroup });
        
        eu.showEntry(descriptionElements, false);
        eu.showEntry(sequenceKeyElements, false);
        eu.showEntry(executorElements, false);
        eu.showEntry(priorityElements, false);
	}
	
	// End of user code


}
