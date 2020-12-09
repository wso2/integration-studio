/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;

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
import org.wso2.integrationstudio.eclipse.gmf.esb.AggregateSequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CompletionMessagesType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

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
	protected EMFComboViewer aggregateElementType;
    // Start of user code  for correlationExpression widgets declarations
    protected NamespacedProperty correlationExpression;
    protected Text correlationExpressionText;
	// End of user code

	// Start of user code  for completionMinMessages widgets declarations
    protected NamespacedProperty completionMinMessagesExpression;
    protected Text completionMinMessagesText;
	// End of user code

	// Start of user code  for completionMaxMessages widgets declarations
    protected NamespacedProperty completionMaxMessagesExpression;
    protected Text completionMaxMessagesText;
	// End of user code

	// Start of user code  for aggregationExpression widgets declarations
    protected NamespacedProperty aggregationExpression;
    protected Text aggregationExpressionText;
	// End of user code

	// Start of user code  for sequenceKey widgets declarations
    protected RegistryKeyProperty sequenceKey;
    protected Text sequenceKeyText;
    protected Control[] aggregateIDElements;
    protected Control[] completionTimeoutElements;
    protected Control[] completionMinMessagesTypeElements;
    protected Control[] completionMaxMessagesTypeElements;
    protected Control[] completionMinMessagesValueElements;
    protected Control[] completionMaxMessagesValueElements;
    protected Control[] sequenceTypeElements;
    protected Control[] enclosingElementElements;
    protected Control[] correlationExpressionElements;
    protected Control[] completionMinMessagesExpressionElements;
    protected Control[] completionMaxMessagesExpressionElements;
    protected Control[] aggregationExpressionElements;
    protected Control[] sequenceKeyElements;
    protected Composite propertiesGroup;
    protected Composite onCompleteGroup;
    protected Composite completeConditionSubGroup;
    protected Control[] aggregateElementTypeElements;

	// End of user code




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
		CompositionSequence aggregateMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = aggregateMediatorStep.addStep(EsbViewsRepository.AggregateMediator.Properties.class);
		// Start of user code 
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionTimeout);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMinMessages);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessages);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.aggregateID);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.correlationExpression);
		propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.aggregateElementType);
        CompositionStep onCompleteStep = aggregateMediatorStep
                .addStep(EsbViewsRepository.AggregateMediator.OnComplete.class);
        onCompleteStep.addStep(EsbViewsRepository.AggregateMediator.OnComplete.aggregationExpression);
        onCompleteStep.addStep(EsbViewsRepository.AggregateMediator.OnComplete.sequenceType);
        onCompleteStep.addStep(EsbViewsRepository.AggregateMediator.OnComplete.sequenceKey);
        propertiesStep.addStep(EsbViewsRepository.AggregateMediator.Properties.description);
        // End of user code
		composer = new PartComposer(aggregateMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.AggregateMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
                if (key == EsbViewsRepository.AggregateMediator.OnComplete.class) {
                    return createOnCompleteGroup(widgetFactory, parent);
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
				if (key == EsbViewsRepository.AggregateMediator.OnComplete.sequenceType) {
					return createSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty) {
					return createEnclosingElementPropertyText(widgetFactory, parent);
				}
				// Start of user code for correlationExpression addToPart creation
				if(key == EsbViewsRepository.AggregateMediator.Properties.correlationExpression) {
                    return createCorrelationExpressionWidget(widgetFactory, parent);
                }
				// End of user code
				// Start of user code for aggregateElementType addToPart creation
				if (key == EsbViewsRepository.AggregateMediator.Properties.aggregateElementType) {
                    return createAggregateElementTypeEMFComboViewer(widgetFactory, parent);
                }
				// End of user code
				// Start of user code for completionMinMessages addToPart creation
                if(key == EsbViewsRepository.AggregateMediator.Properties.completionMinMessages) {
                    return createCompletionMinMessagesExpressionWidget(widgetFactory, parent);
                }
				// End of user code
				// Start of user code for completionMaxMessages addToPart creation
                if(key == EsbViewsRepository.AggregateMediator.Properties.completionMaxMessages) {
                    return createCompletionMaxMessagesExpressionWidget(widgetFactory, parent);
                }
				// End of user code
				// Start of user code for aggregationExpression addToPart creation
                if(key == EsbViewsRepository.AggregateMediator.OnComplete.aggregationExpression) {
                    return createAggregationExpressionWidget(widgetFactory, parent);
                }
				// End of user code
				// Start of user code for sequenceKey addToPart creation
                if(key == EsbViewsRepository.AggregateMediator.OnComplete.sequenceKey) {
                    return createsequenceKeyWidget(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.AggregateMediatorPropertiesEditionPart_PropertiesGroupLabel);
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

	/**
     * @generated NOT
     */
	protected Composite createAggregateIDText(FormToolkit widgetFactory, Composite parent) {
		Control aggregateIDLabel = createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.aggregateID, EsbMessages.AggregateMediatorPropertiesEditionPart_AggregateIDLabel);
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
		Control aggregateIDHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.aggregateID, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAggregateIDText
		aggregateIDElements = new Control[] {aggregateIDLabel, aggregateID, aggregateIDHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createCompletionTimeoutText(FormToolkit widgetFactory, Composite parent) {
	    completeConditionSubGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent,
                "Complete Condition", true);
	    Control completionTimeoutLabel = createDescription(completeConditionSubGroup, EsbViewsRepository.AggregateMediator.Properties.completionTimeout, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionTimeoutLabel);
		completionTimeout = widgetFactory.createText(completeConditionSubGroup, ""); //$NON-NLS-1$
		completionTimeout.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(completeConditionSubGroup);
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
		Control completionTimeoutHelp = FormUtils.createHelpButton(widgetFactory, completeConditionSubGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionTimeout, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionTimeoutText
		completionTimeoutElements = new Control[] {completionTimeoutLabel, completionTimeout, completionTimeoutHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createCompletionMinMessagesTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control completionMinMessagesTypeLabel = createDescription(completeConditionSubGroup, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionMinMessagesTypeLabel);
		completionMinMessagesType = new EMFComboViewer(completeConditionSubGroup);
		completionMinMessagesType.setContentProvider(new ArrayContentProvider());
		completionMinMessagesType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData completionMinMessagesTypeData = new GridData(GridData.FILL_HORIZONTAL);
		completionMinMessagesType.getCombo().setLayoutData(completionMinMessagesTypeData);
                completionMinMessagesType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
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
		Control completionMinMessagesTypeHelp = FormUtils.createHelpButton(widgetFactory, completeConditionSubGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMinMessagesTypeEMFComboViewer
		completionMinMessagesTypeElements = new Control[] {completionMinMessagesTypeLabel, completionMinMessagesType.getCombo(), completionMinMessagesTypeHelp};
		completionMinMessagesType.addSelectionChangedListener(new ISelectionChangedListener() {
            
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
	protected Composite createCompletionMaxMessagesTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control completionMaxMessagesTypeLabel = createDescription(completeConditionSubGroup, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType, EsbMessages.AggregateMediatorPropertiesEditionPart_CompletionMaxMessagesTypeLabel);
		completionMaxMessagesType = new EMFComboViewer(completeConditionSubGroup);
		completionMaxMessagesType.setContentProvider(new ArrayContentProvider());
		completionMaxMessagesType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData completionMaxMessagesTypeData = new GridData(GridData.FILL_HORIZONTAL);
		completionMaxMessagesType.getCombo().setLayoutData(completionMaxMessagesTypeData);
                completionMaxMessagesType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
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
		Control completionMaxMessagesTypeHelp = FormUtils.createHelpButton(widgetFactory, completeConditionSubGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMaxMessagesTypeEMFComboViewer
        completionMaxMessagesTypeElements = new Control[] {completionMaxMessagesTypeLabel, completionMaxMessagesType.getCombo(), completionMaxMessagesTypeHelp};
        completionMaxMessagesType.addSelectionChangedListener(new ISelectionChangedListener() {
            
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
	protected Composite createCompletionMinMessagesValueText(FormToolkit widgetFactory, Composite parent) {
		Control completionMinMessagesValueLabel = createDescription(completeConditionSubGroup, EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue, "Completion Min Messages");
		completionMinMessagesValue = widgetFactory.createText(completeConditionSubGroup, ""); //$NON-NLS-1$
		completionMinMessagesValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(completeConditionSubGroup);
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
		Control completionMinMessagesValueHelp = FormUtils.createHelpButton(widgetFactory, completeConditionSubGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMinMessagesValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMinMessagesValueText
		completionMinMessagesValueElements = new Control[] {completionMinMessagesValueLabel, completionMinMessagesValue, completionMinMessagesValueHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createCompletionMaxMessagesValueText(FormToolkit widgetFactory, Composite parent) {
		Control completionMaxMessagesValueLabel = createDescription(completeConditionSubGroup, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue, "Completion Max Messages");
		completionMaxMessagesValue = widgetFactory.createText(completeConditionSubGroup, ""); //$NON-NLS-1$
		completionMaxMessagesValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(completeConditionSubGroup);
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
		Control completionMaxMessagesValueHelp = FormUtils.createHelpButton(widgetFactory, completeConditionSubGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessagesValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCompletionMaxMessagesValueText
		completionMaxMessagesValueElements = new Control[] {completionMaxMessagesValueLabel, completionMaxMessagesValue, completionMaxMessagesValueHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control sequenceTypeLabel = createDescription(parent, EsbViewsRepository.AggregateMediator.OnComplete.sequenceType, EsbMessages.AggregateMediatorPropertiesEditionPart_SequenceTypeLabel);
		sequenceType = new EMFComboViewer(parent);
		sequenceType.setContentProvider(new ArrayContentProvider());
		sequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		sequenceType.getCombo().setLayoutData(sequenceTypeData);
                sequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
        
                    }
                });
		sequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.OnComplete.sequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceType()));
			}

		});
		sequenceType.setID(EsbViewsRepository.AggregateMediator.OnComplete.sequenceType);
		Control sequenceTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.OnComplete.sequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceTypeEMFComboViewer
		sequenceTypeElements = new Control[] {sequenceTypeLabel, sequenceType.getCombo(), sequenceTypeHelp};

		sequenceType.addSelectionChangedListener(new ISelectionChangedListener() {
                    
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
	protected Composite createEnclosingElementPropertyText(FormToolkit widgetFactory, Composite parent) {
		Control enclosingElementPropertyLabel = createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty, EsbMessages.AggregateMediatorPropertiesEditionPart_EnclosingElementPropertyLabel);
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
		Control enclosingElementPropertyHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.enclosingElementProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEnclosingElementPropertyText
		enclosingElementElements = new Control[] {enclosingElementPropertyLabel, enclosingElementProperty, enclosingElementPropertyHelp};

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
    protected Composite createAggregateElementTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
    	Control aggregateElementTypeLabel = createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.aggregateElementType, EsbMessages.AggregateMediatorPropertiesEditionPart_AggregateElementTypeLabel);
        aggregateElementType = new EMFComboViewer(parent);
        aggregateElementType.setContentProvider(new ArrayContentProvider());
        aggregateElementType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData aggregateElementTypeData = new GridData(GridData.FILL_HORIZONTAL);
        aggregateElementType.getCombo().setLayoutData(aggregateElementTypeData);
        aggregateElementType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
        
        aggregateElementType.addSelectionChangedListener(new ISelectionChangedListener() {
    
          /**
           * {@inheritDoc}
           * 
           * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
           * 	
           */
          public void selectionChanged(SelectionChangedEvent event) {
            if (propertiesEditionComponent != null)
              propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.aggregateElementType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAggregateElementType()));
          }
    
        });
        aggregateElementType.setID(EsbViewsRepository.AggregateMediator.Properties.aggregateElementType);
        Control aggregateElementTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.aggregateElementType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        // Start of user code for createAggregateElementTypeEMFComboViewer
        aggregateElementTypeElements = new Control[] {aggregateElementTypeLabel, aggregateElementType.getCombo(), aggregateElementTypeHelp};
        aggregateElementType.addSelectionChangedListener(new ISelectionChangedListener() {
            
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
  protected Composite createOnCompleteGroup(FormToolkit widgetFactory, final Composite parent) {
    Section onCompleteSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
    onCompleteSection.setText(EsbMessages.AggregateMediatorPropertiesEditionPart_OnCompleteGroupLabel);
    GridData onCompleteSectionData = new GridData(GridData.FILL_HORIZONTAL);
    onCompleteSectionData.horizontalSpan = 3;
    onCompleteSection.setLayoutData(onCompleteSectionData);
    onCompleteGroup = widgetFactory.createComposite(onCompleteSection);
    GridLayout onCompleteGroupLayout = new GridLayout();
    onCompleteGroupLayout.numColumns = 3;
    onCompleteGroup.setLayout(onCompleteGroupLayout);
    onCompleteSection.setClient(onCompleteGroup);
    return onCompleteGroup;
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setDescription(String newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCommentsList(EList newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setReverse(Boolean newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getAggregateID()
	 * 
	 */
	public String getAggregateID() {
		return aggregateID.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setAggregateID(String newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionTimeout()
	 * 
	 */
	public String getCompletionTimeout() {
		return completionTimeout.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionTimeout(String newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMinMessagesType()
	 * 
	 */
	public Enumerator getCompletionMinMessagesType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) completionMinMessagesType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#initCompletionMinMessagesType(Object input, Enumerator current)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMinMessagesType(Enumerator newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMaxMessagesType()
	 * 
	 */
	public Enumerator getCompletionMaxMessagesType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) completionMaxMessagesType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#initCompletionMaxMessagesType(Object input, Enumerator current)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMaxMessagesType(Enumerator newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMinMessagesValue()
	 * 
	 */
	public String getCompletionMinMessagesValue() {
		return completionMinMessagesValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMinMessagesValue(String newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getCompletionMaxMessagesValue()
	 * 
	 */
	public String getCompletionMaxMessagesValue() {
		return completionMaxMessagesValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setCompletionMaxMessagesValue(String newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getSequenceType()
	 * 
	 */
	public Enumerator getSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#initSequenceType(Object input, Enumerator current)
	 */
	public void initSequenceType(Object input, Enumerator current) {
		sequenceType.setInput(input);
		sequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.OnComplete.sequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setSequenceType(Enumerator newValue)
	 * 
	 */
	public void setSequenceType(Enumerator newValue) {
		sequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.OnComplete.sequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getEnclosingElementProperty()
	 * 
	 */
	public String getEnclosingElementProperty() {
		return enclosingElementProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setEnclosingElementProperty(String newValue)
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
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#getAggregateElementType()
   * 
   */
  public Enumerator getAggregateElementType() {
    Enumerator selection = (Enumerator) ((StructuredSelection) aggregateElementType.getSelection()).getFirstElement();
    return selection;
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#initAggregateElementType(Object input, Enumerator current)
   */
  public void initAggregateElementType(Object input, Enumerator current) {
    aggregateElementType.setInput(input);
    aggregateElementType.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.aggregateElementType);
    if (eefElementEditorReadOnlyState && aggregateElementType.isEnabled()) {
      aggregateElementType.setEnabled(false);
      aggregateElementType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !aggregateElementType.isEnabled()) {
      aggregateElementType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.AggregateMediatorPropertiesEditionPart#setAggregateElementType(Enumerator newValue)
   * 
   */
  public void setAggregateElementType(Enumerator newValue) {
    aggregateElementType.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AggregateMediator.Properties.aggregateElementType);
    if (eefElementEditorReadOnlyState && aggregateElementType.isEnabled()) {
      aggregateElementType.setEnabled(false);
      aggregateElementType.setToolTipText(EsbMessages.AggregateMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !aggregateElementType.isEnabled()) {
      aggregateElementType.setEnabled(true);
    }	
    
  }

    // Start of user code for correlationExpression specific getters and setters implementation

    @Override
    public NamespacedProperty getCorrelationExpression() {
        return correlationExpression;
    }

    @Override
    public void setCorrelationExpression(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
            correlationExpressionText.setText(nameSpacedProperty.getPropertyValue());
            correlationExpression = nameSpacedProperty;
        }
    }
	// End of user code

	// Start of user code for completionMinMessages specific getters and setters implementation
    @Override
    public NamespacedProperty getCompletionMinMessagesExpression() {
        return completionMinMessagesExpression;
    }

    @Override
    public void setCompletionMinMessagesExpression(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
            completionMinMessagesText.setText(nameSpacedProperty.getPropertyValue());
            completionMinMessagesExpression = nameSpacedProperty;
        }
    }
	// End of user code

	// Start of user code for completionMaxMessages specific getters and setters implementation
    @Override
    public NamespacedProperty getCompletionMaxMessagesExpression() {
        return completionMaxMessagesExpression;
    }

    @Override
    public void setCompletionMaxMessagesExpression(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
            completionMaxMessagesText.setText(nameSpacedProperty.getPropertyValue());
            completionMaxMessagesExpression = nameSpacedProperty;
        }
        
    }
	// End of user code

	// Start of user code for aggregationExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getAggregationExpression() {
        return aggregationExpression;
    }

    @Override
    public void setAggregationExpression(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
            aggregationExpressionText.setText(nameSpacedProperty.getPropertyValue());
            aggregationExpression = nameSpacedProperty;
        }
        
    }
	// End of user code

	// Start of user code for sequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getSequenceKey() {
        return sequenceKey;
    }

    @Override
    public void setSequenceKey(RegistryKeyProperty registryKeyProperty) {
        if(registryKeyProperty != null) {
            sequenceKeyText.setText(registryKeyProperty.getKeyValue());
            sequenceKey = registryKeyProperty;
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
		return EsbMessages.AggregateMediator_Part_Title;
	}

	// Start of user code additional methods
    protected Composite createsequenceKeyWidget(FormToolkit widgetFactory, Composite parent) {
        Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.AggregateMediator.OnComplete.sequenceKey, EsbMessages.AggregateMediatorPropertiesEditionPart_SequenceKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if(sequenceKey == null) {
            sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        } 
        String initValueExpression = sequenceKey.getKeyValue().isEmpty() ? "" : sequenceKey.getKeyValue();
        sequenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        sequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        sequenceKeyText.setLayoutData(valueData);
        
        sequenceKeyText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                sequenceKeyText.setText(sequenceKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(
                        new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.AggregateMediator.OnComplete.sequenceKey,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceKey()));
            }
            
        });
        
        sequenceKeyText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    sequenceKeyText.setText(sequenceKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.AggregateMediator.OnComplete.sequenceKey,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceKey()));
                }
            }
            
        });
        
        EditingUtils.setID(sequenceKeyText, EsbViewsRepository.AggregateMediator.OnComplete.sequenceKey);
        EditingUtils.setEEFtype(sequenceKeyText, "eef::Text");
        Control sequenceKeyHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.OnComplete.sequenceKey, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        sequenceKeyElements = new Control[] {sequenceKeyLabel, sequenceKeyText, sequenceKeyHelp};
        return parent;
    }

    protected Composite createAggregationExpressionWidget(FormToolkit widgetFactory, final Composite parent) {
        Control aggregationExpressionLabel = createDescription(parent, EsbViewsRepository.AggregateMediator.OnComplete.aggregationExpression, EsbMessages.AggregateMediatorPropertiesEditionPart_AggregationExpressionLabel);
        widgetFactory.paintBordersFor(parent);
        if(aggregationExpression == null) {
            aggregationExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = aggregationExpression.getPropertyValue().isEmpty() ? "/default/expression" : aggregationExpression.getPropertyValue();
        aggregationExpressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        aggregationExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        aggregationExpressionText.setLayoutData(valueData);
        
        aggregationExpressionText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, aggregationExpression);
                aggregationExpression = nspd.open();
                aggregationExpressionText.setText(aggregationExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.OnComplete.aggregationExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAggregationExpression()));
            }
            
        });
        
        aggregationExpressionText.addKeyListener(new KeyListener() {
      
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, aggregationExpression);
                    aggregationExpression = nspd.open();
                    aggregationExpressionText.setText(aggregationExpression.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.AggregateMediator.OnComplete.aggregationExpression,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getAggregationExpression()));
                }
            }
            
        });;
        
        EditingUtils.setID(aggregationExpressionText, EsbViewsRepository.AggregateMediator.OnComplete.aggregationExpression);
        EditingUtils.setEEFtype(aggregationExpressionText, "eef::Text");
        Control aggregationExpressionHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.OnComplete.aggregationExpression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        aggregationExpressionElements = new Control[] {aggregationExpressionLabel, aggregationExpressionText, aggregationExpressionHelp};
        return parent;
    }

    protected Composite createCompletionMaxMessagesExpressionWidget(FormToolkit widgetFactory, final Composite parent) {
        Control completionMaxMessagesExpressionLabel = createDescription(completeConditionSubGroup, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessages, "Completion Max Messages");
        widgetFactory.paintBordersFor(completeConditionSubGroup);
        if(completionMaxMessagesExpression == null) {
            completionMaxMessagesExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = completionMaxMessagesExpression.getPropertyValue().isEmpty() ? "" : completionMaxMessagesExpression.getPropertyValue();
        completionMaxMessagesText = widgetFactory.createText(completeConditionSubGroup, initValueExpression, SWT.READ_ONLY);
        completionMaxMessagesText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(completeConditionSubGroup);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        completionMaxMessagesText.setLayoutData(valueData);
        
        completionMaxMessagesText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, completionMaxMessagesExpression);
                completionMaxMessagesExpression = nspd.open();
                completionMaxMessagesText.setText(completionMaxMessagesExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCompletionMaxMessagesExpression()));
            }
            
        });
        
        completionMaxMessagesText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
            }            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, completionMaxMessagesExpression);
                    completionMaxMessagesExpression = nspd.open();
                    completionMaxMessagesText.setText(completionMaxMessagesExpression.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.AggregateMediator.Properties.completionMaxMessages,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getCompletionMaxMessagesExpression()));
                }
            }
            
        });;

        EditingUtils.setID(completionMaxMessagesText, EsbViewsRepository.AggregateMediator.Properties.completionMaxMessages);
        EditingUtils.setEEFtype(completionMaxMessagesText, "eef::Text");
        Control completionMaxMessagesHelp =FormUtils.createHelpButton(widgetFactory, completeConditionSubGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMaxMessages, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        completionMaxMessagesExpressionElements = new Control[] {completionMaxMessagesExpressionLabel, completionMaxMessagesText, completionMaxMessagesHelp};
        return parent;
    }

    protected Composite createCompletionMinMessagesExpressionWidget(FormToolkit widgetFactory, final Composite parent) {
        Control completionMinMessagesExpressionLabel = createDescription(completeConditionSubGroup, EsbViewsRepository.AggregateMediator.Properties.completionMinMessages, "Completion Min Messages");
        widgetFactory.paintBordersFor(completeConditionSubGroup);
        if(completionMinMessagesExpression == null) {
            completionMinMessagesExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = completionMinMessagesExpression.getPropertyValue().isEmpty() ? "" : completionMinMessagesExpression.getPropertyValue();
        completionMinMessagesText = widgetFactory.createText(completeConditionSubGroup, initValueExpression, SWT.READ_ONLY);
        completionMinMessagesText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(completeConditionSubGroup);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        completionMinMessagesText.setLayoutData(valueData);
        
        completionMinMessagesText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, completionMinMessagesExpression);
                completionMinMessagesExpression = nspd.open();
                completionMinMessagesText.setText(completionMinMessagesExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.completionMinMessages, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCompletionMinMessagesExpression()));
            }
            
        });
        
        completionMinMessagesText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, completionMinMessagesExpression);
                    completionMinMessagesExpression = nspd.open();
                    completionMinMessagesText.setText(completionMinMessagesExpression.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.AggregateMediator.Properties.completionMinMessages,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getCompletionMinMessagesExpression()));
                }
            }
            
        });;
        
        EditingUtils.setID(completionMinMessagesText, EsbViewsRepository.AggregateMediator.Properties.completionMinMessages);
        EditingUtils.setEEFtype(completionMinMessagesText, "eef::Text");
        Control completionMinMessagesHelp =FormUtils.createHelpButton(widgetFactory, completeConditionSubGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.completionMinMessages, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        completionMinMessagesExpressionElements = new Control[] {completionMinMessagesExpressionLabel, completionMinMessagesText, completionMinMessagesHelp};
        return parent;
    }

    protected Composite createCorrelationExpressionWidget(FormToolkit widgetFactory, final Composite parent) {
        Control correlationExpressionLabel = createDescription(parent, EsbViewsRepository.AggregateMediator.Properties.correlationExpression, EsbMessages.AggregateMediatorPropertiesEditionPart_CorrelationExpressionLabel);
        widgetFactory.paintBordersFor(parent);
        if(correlationExpression == null) {
            correlationExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = correlationExpression.getPropertyValue().isEmpty() ? "" : correlationExpression.getPropertyValue();
        correlationExpressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        correlationExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        correlationExpressionText.setLayoutData(valueData);
        
        correlationExpressionText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, correlationExpression);
                correlationExpression = nspd.open();
                correlationExpressionText.setText(correlationExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this, EsbViewsRepository.AggregateMediator.Properties.correlationExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCorrelationExpression()));
            }
            
        });
        
        correlationExpressionText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, correlationExpression);
                    correlationExpression = nspd.open();
                    correlationExpressionText.setText(correlationExpression.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(AggregateMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.AggregateMediator.Properties.correlationExpression,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getCorrelationExpression()));
                }
            }

        });;
        
        EditingUtils.setID(correlationExpressionText, EsbViewsRepository.AggregateMediator.Properties.correlationExpression);
        EditingUtils.setEEFtype(correlationExpressionText, "eef::Text");
        Control correlationExpressionHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AggregateMediator.Properties.correlationExpression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        correlationExpressionElements = new Control[] {correlationExpressionLabel, correlationExpressionText, correlationExpressionHelp};
        return parent;
    }
    
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] { propertiesGroup });
        epv.clearElements(new Composite[] { onCompleteGroup });
        epv.showEntry(new Control[] {completeConditionSubGroup.getParent()}, false);
        epv.clearElements(new Composite[] { completeConditionSubGroup });
        epv.showEntry(aggregateIDElements, false);
        epv.showEntry(correlationExpressionElements, false);
        epv.showEntry(aggregateElementTypeElements, false);
        epv.showEntry(completionTimeoutElements, false);
        epv.showEntry(completionMinMessagesTypeElements, false);
        epv.showEntry(completionMaxMessagesTypeElements, false);
        if (getCompletionMinMessagesType().getName().equals(CompletionMessagesType.VALUE.getName())) {

            epv.showEntry(completionMinMessagesValueElements, false);
        } else {

            epv.showEntry(completionMinMessagesExpressionElements, false);
        }

        if (getCompletionMaxMessagesType().getName().equals(CompletionMessagesType.VALUE.getName())) {

            epv.showEntry(completionMaxMessagesValueElements, false);
        } else {

            epv.showEntry(completionMaxMessagesExpressionElements, false);
        }
        epv.showEntry(aggregationExpressionElements, false);
        epv.showEntry(sequenceTypeElements, false);
        
        if (getSequenceType().getName().equals(AggregateSequenceType.REGISTRY_REFERENCE.getName())) {
            epv.showEntry(sequenceKeyElements, false);
        }

        epv.showEntry(enclosingElementElements, false);
        view.layout(true, true);
    }

	// End of user code
}
