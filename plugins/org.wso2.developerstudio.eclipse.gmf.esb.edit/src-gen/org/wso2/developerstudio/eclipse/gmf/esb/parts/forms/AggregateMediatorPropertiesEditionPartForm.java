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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class AggregateMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, AggregateMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text aggregateID;
	protected Text completionTimeout;
	protected EMFComboViewer completionMinMessagesType;
	protected EMFComboViewer completionMaxMessagesType;
	protected Text completionMinMessagesValue;
	protected Text completionMaxMessagesValue;
	protected EMFComboViewer sequenceType;
	protected Text enclosingElementProperty;



	/**
	 * For {@link ISection} use only.
	 */
	public AggregateMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AggregateMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence aggregateMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = aggregateMediatorStep.addStep(EsbViewsRepository.AggregateMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.aggregateID);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionTimeout);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.sequenceType);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty);
		
		
		composer = new PartComposer(aggregateMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.AggregateMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.aggregateID) {
					return createAggregateIDText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.completionTimeout) {
					return createCompletionTimeoutText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType) {
					return createCompletionMinMessagesTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType) {
					return createCompletionMaxMessagesTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue) {
					return createCompletionMinMessagesValueText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue) {
					return createCompletionMaxMessagesValueText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.sequenceType) {
					return createSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty) {
					return createEnclosingElementPropertyText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.AggregateMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.description, EsbMessages.AggregateMediatorPropertiesEditionPart_DescriptionLabel);
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
							AggregateMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.AggregateMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AggregateMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.AggregateMediator.Properties.description,
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
									AggregateMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.AggregateMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		EditingUtils.setID(commentsList, EsbViewsRepository.AggregateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AggregateMediator.Properties.commentsList, EsbMessages.AggregateMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "AggregateMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.AggregateMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.AggregateMediator.Properties.reverse, EsbMessages.AggregateMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.AggregateMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAggregateIDText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.aggregateID, EsbMessages.AggregateMediatorPropertiesEditionPart_AggregateIDLabel);
		aggregateID = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		aggregateID.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData aggregateIDData = new GridData(GridData.FILL_HORIZONTAL);
		aggregateID.setLayoutData(aggregateIDData);
		aggregateID.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AggregateMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.AggregateMediator.Properties.aggregateID,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, aggregateID.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AggregateMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.AggregateMediator.Properties.aggregateID,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, aggregateID.getText()));
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
									AggregateMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		aggregateID.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.aggregateID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, aggregateID.getText()));
				}
			}
		});
		EditingUtils.setID(aggregateID, EsbViewsRepository.AggregateMediator.Properties.aggregateID);
		EditingUtils.setEEFtype(aggregateID, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.aggregateID, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAggregateIDText

		// End of user code
		return parent;
	}

	
	protected Composite createCompletionTimeoutText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.completionTimeout, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionTimeoutLabel);
		completionTimeout = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		completionTimeout.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData completionTimeoutData = new GridData(GridData.FILL_HORIZONTAL);
		completionTimeout.setLayoutData(completionTimeoutData);
		completionTimeout.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AggregateMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.AggregateMediator.Properties.completionTimeout,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionTimeout.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AggregateMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.AggregateMediator.Properties.completionTimeout,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, completionTimeout.getText()));
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
									AggregateMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		completionTimeout.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.completionTimeout, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionTimeout.getText()));
				}
			}
		});
		EditingUtils.setID(completionTimeout, EsbViewsRepository.AggregateMediator.Properties.completionTimeout);
		EditingUtils.setEEFtype(completionTimeout, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionTimeout, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionTimeoutText

		// End of user code
		return parent;
	}

	
	protected Composite createCompletionMinMessagesTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionMinMessagesTypeLabel);
		completionMinMessagesType = new EMFComboViewer(parent);
		completionMinMessagesType.setContentProvider(new ArrayContentProvider());
		completionMinMessagesType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData completionMinMessagesTypeData = new GridData(GridData.FILL_HORIZONTAL);
		completionMinMessagesType.getCombo().setLayoutData(completionMinMessagesTypeData);
		completionMinMessagesType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCompletionMinMessagesType()));
			}

		});
		completionMinMessagesType.setID(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMinMessagesTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createCompletionMaxMessagesTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionMaxMessagesTypeLabel);
		completionMaxMessagesType = new EMFComboViewer(parent);
		completionMaxMessagesType.setContentProvider(new ArrayContentProvider());
		completionMaxMessagesType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData completionMaxMessagesTypeData = new GridData(GridData.FILL_HORIZONTAL);
		completionMaxMessagesType.getCombo().setLayoutData(completionMaxMessagesTypeData);
		completionMaxMessagesType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCompletionMaxMessagesType()));
			}

		});
		completionMaxMessagesType.setID(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMaxMessagesTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createCompletionMinMessagesValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionMinMessagesValueLabel);
		completionMinMessagesValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		completionMinMessagesValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData completionMinMessagesValueData = new GridData(GridData.FILL_HORIZONTAL);
		completionMinMessagesValue.setLayoutData(completionMinMessagesValueData);
		completionMinMessagesValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AggregateMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionMinMessagesValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AggregateMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, completionMinMessagesValue.getText()));
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
									AggregateMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		completionMinMessagesValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionMinMessagesValue.getText()));
				}
			}
		});
		EditingUtils.setID(completionMinMessagesValue, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue);
		EditingUtils.setEEFtype(completionMinMessagesValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMinMessagesValueText

		// End of user code
		return parent;
	}

	
	protected Composite createCompletionMaxMessagesValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionMaxMessagesValueLabel);
		completionMaxMessagesValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		completionMaxMessagesValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData completionMaxMessagesValueData = new GridData(GridData.FILL_HORIZONTAL);
		completionMaxMessagesValue.setLayoutData(completionMaxMessagesValueData);
		completionMaxMessagesValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AggregateMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionMaxMessagesValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AggregateMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, completionMaxMessagesValue.getText()));
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
									AggregateMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		completionMaxMessagesValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, completionMaxMessagesValue.getText()));
				}
			}
		});
		EditingUtils.setID(completionMaxMessagesValue, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue);
		EditingUtils.setEEFtype(completionMaxMessagesValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMaxMessagesValueText

		// End of user code
		return parent;
	}

	
	protected Composite createSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.sequenceType, EsbMessages.AggregateMediatorPropertiesEditionPart_SequenceTypeLabel);
		sequenceType = new EMFComboViewer(parent);
		sequenceType.setContentProvider(new ArrayContentProvider());
		sequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		sequenceType.getCombo().setLayoutData(sequenceTypeData);
		sequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.sequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceType()));
			}

		});
		sequenceType.setID(EsbViewsRepository.AggregateMediator.Properties.sequenceType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.sequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createEnclosingElementPropertyText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty, EsbMessages.AggregateMediatorPropertiesEditionPart_EnclosingElementPropertyLabel);
		enclosingElementProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		enclosingElementProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData enclosingElementPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		enclosingElementProperty.setLayoutData(enclosingElementPropertyData);
		enclosingElementProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AggregateMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, enclosingElementProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AggregateMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, enclosingElementProperty.getText()));
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
									AggregateMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		enclosingElementProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, enclosingElementProperty.getText()));
				}
			}
		});
		EditingUtils.setID(enclosingElementProperty, EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty);
		EditingUtils.setEEFtype(enclosingElementProperty, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEnclosingElementPropertyText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getAggregateID()
	 * 
	 */
	public String getAggregateID() {
		return aggregateID.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setAggregateID(String newValue)
	 * 
	 */
	public void setAggregateID(String newValue) {
		if (newValue != null) {
			aggregateID.setText(newValue);
		} else {
			aggregateID.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.aggregateID);
		if (eefElementEditorReadOnlyState && aggregateID.isEnabled()) {
			aggregateID.setEnabled(false);
			aggregateID.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !aggregateID.isEnabled()) {
			aggregateID.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionTimeout()
	 * 
	 */
	public String getCompletionTimeout() {
		return completionTimeout.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionTimeout(String newValue)
	 * 
	 */
	public void setCompletionTimeout(String newValue) {
		if (newValue != null) {
			completionTimeout.setText(newValue);
		} else {
			completionTimeout.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionTimeout);
		if (eefElementEditorReadOnlyState && completionTimeout.isEnabled()) {
			completionTimeout.setEnabled(false);
			completionTimeout.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionTimeout.isEnabled()) {
			completionTimeout.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMinMessagesType()
	 * 
	 */
	public Enumerator getCompletionMinMessagesType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) completionMinMessagesType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#initCompletionMinMessagesType(Object input, Enumerator current)
	 */
	public void initCompletionMinMessagesType(Object input, Enumerator current) {
		completionMinMessagesType.setInput(input);
		completionMinMessagesType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType);
		if (eefElementEditorReadOnlyState && completionMinMessagesType.isEnabled()) {
			completionMinMessagesType.setEnabled(false);
			completionMinMessagesType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMinMessagesType.isEnabled()) {
			completionMinMessagesType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMinMessagesType(Enumerator newValue)
	 * 
	 */
	public void setCompletionMinMessagesType(Enumerator newValue) {
		completionMinMessagesType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType);
		if (eefElementEditorReadOnlyState && completionMinMessagesType.isEnabled()) {
			completionMinMessagesType.setEnabled(false);
			completionMinMessagesType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMinMessagesType.isEnabled()) {
			completionMinMessagesType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMaxMessagesType()
	 * 
	 */
	public Enumerator getCompletionMaxMessagesType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) completionMaxMessagesType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#initCompletionMaxMessagesType(Object input, Enumerator current)
	 */
	public void initCompletionMaxMessagesType(Object input, Enumerator current) {
		completionMaxMessagesType.setInput(input);
		completionMaxMessagesType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType);
		if (eefElementEditorReadOnlyState && completionMaxMessagesType.isEnabled()) {
			completionMaxMessagesType.setEnabled(false);
			completionMaxMessagesType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMaxMessagesType.isEnabled()) {
			completionMaxMessagesType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMaxMessagesType(Enumerator newValue)
	 * 
	 */
	public void setCompletionMaxMessagesType(Enumerator newValue) {
		completionMaxMessagesType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType);
		if (eefElementEditorReadOnlyState && completionMaxMessagesType.isEnabled()) {
			completionMaxMessagesType.setEnabled(false);
			completionMaxMessagesType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMaxMessagesType.isEnabled()) {
			completionMaxMessagesType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMinMessagesValue()
	 * 
	 */
	public String getCompletionMinMessagesValue() {
		return completionMinMessagesValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMinMessagesValue(String newValue)
	 * 
	 */
	public void setCompletionMinMessagesValue(String newValue) {
		if (newValue != null) {
			completionMinMessagesValue.setText(newValue);
		} else {
			completionMinMessagesValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue);
		if (eefElementEditorReadOnlyState && completionMinMessagesValue.isEnabled()) {
			completionMinMessagesValue.setEnabled(false);
			completionMinMessagesValue.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMinMessagesValue.isEnabled()) {
			completionMinMessagesValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMaxMessagesValue()
	 * 
	 */
	public String getCompletionMaxMessagesValue() {
		return completionMaxMessagesValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMaxMessagesValue(String newValue)
	 * 
	 */
	public void setCompletionMaxMessagesValue(String newValue) {
		if (newValue != null) {
			completionMaxMessagesValue.setText(newValue);
		} else {
			completionMaxMessagesValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue);
		if (eefElementEditorReadOnlyState && completionMaxMessagesValue.isEnabled()) {
			completionMaxMessagesValue.setEnabled(false);
			completionMaxMessagesValue.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !completionMaxMessagesValue.isEnabled()) {
			completionMaxMessagesValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getSequenceType()
	 * 
	 */
	public Enumerator getSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#initSequenceType(Object input, Enumerator current)
	 */
	public void initSequenceType(Object input, Enumerator current) {
		sequenceType.setInput(input);
		sequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setSequenceType(Enumerator newValue)
	 * 
	 */
	public void setSequenceType(Enumerator newValue) {
		sequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getEnclosingElementProperty()
	 * 
	 */
	public String getEnclosingElementProperty() {
		return enclosingElementProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setEnclosingElementProperty(String newValue)
	 * 
	 */
	public void setEnclosingElementProperty(String newValue) {
		if (newValue != null) {
			enclosingElementProperty.setText(newValue);
		} else {
			enclosingElementProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty);
		if (eefElementEditorReadOnlyState && enclosingElementProperty.isEnabled()) {
			enclosingElementProperty.setEnabled(false);
			enclosingElementProperty.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !enclosingElementProperty.isEnabled()) {
			enclosingElementProperty.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.AggregateMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
