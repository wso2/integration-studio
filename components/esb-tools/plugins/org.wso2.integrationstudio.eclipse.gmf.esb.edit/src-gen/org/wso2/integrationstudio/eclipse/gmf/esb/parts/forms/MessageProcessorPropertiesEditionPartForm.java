/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class MessageProcessorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, MessageProcessorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Text processorName;
	protected EMFComboViewer processorType;
	protected Text messageProcessorProvider;
	protected Text messageStore;
	protected Text sourceMessageStore;
	protected Text targetMessageStore;
	protected EMFComboViewer processorState;
	protected Text retryInterval;
	protected Text forwardingInterval;
	protected Text samplingInterval;
	protected Text samplingConcurrency;
	protected Text maxDeliveryAttempts;
	protected EMFComboViewer dropMessageAfterMaximumDeliveryAttempts;
	protected Text axis2ClientRepository;
	protected Text axis2Configuration;
	protected Text quartzConfigFilePath;
	protected Text cronExpression;
	protected Text nonRetryHttpStatusCodes;
	protected ReferencesTable parameters;
	protected List<ViewerFilter> parametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> parametersFilters = new ArrayList<ViewerFilter>();
	protected Text taskCount;
	protected Text maxStoreConnectionAttempts;
	protected Text storeConnectionInterval;
	protected Text failMessagesStore;



	/**
	 * For {@link ISection} use only.
	 */
	public MessageProcessorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MessageProcessorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence messageProcessorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = messageProcessorStep.addStep(EsbViewsRepository.MessageProcessor.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.processorName);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.processorType);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.messageStore);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.targetMessageStore);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.processorState);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.retryInterval);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.forwardingInterval);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.samplingInterval);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.axis2Configuration);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.cronExpression);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.parameters);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.taskCount);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval);
		propertiesStep.addStep(EsbViewsRepository.MessageProcessor.Properties.failMessagesStore);
		
		
		composer = new PartComposer(messageProcessorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.MessageProcessor.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.processorName) {
					return createProcessorNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.processorType) {
					return createProcessorTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider) {
					return createMessageProcessorProviderText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.messageStore) {
					return createMessageStoreText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore) {
					return createSourceMessageStoreText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.targetMessageStore) {
					return createTargetMessageStoreText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.processorState) {
					return createProcessorStateEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.retryInterval) {
					return createRetryIntervalText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.forwardingInterval) {
					return createForwardingIntervalText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.samplingInterval) {
					return createSamplingIntervalText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency) {
					return createSamplingConcurrencyText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts) {
					return createMaxDeliveryAttemptsText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts) {
					return createDropMessageAfterMaximumDeliveryAttemptsEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository) {
					return createAxis2ClientRepositoryText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.axis2Configuration) {
					return createAxis2ConfigurationText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath) {
					return createQuartzConfigFilePathText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.cronExpression) {
					return createCronExpressionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes) {
					return createNonRetryHttpStatusCodesText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.parameters) {
					return createParametersTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.taskCount) {
					return createTaskCountText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts) {
					return createMaxStoreConnectionAttemptsText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval) {
					return createStoreConnectionIntervalText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageProcessor.Properties.failMessagesStore) {
					return createFailMessagesStoreText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.MessageProcessorPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.description, EsbMessages.MessageProcessorPropertiesEditionPart_DescriptionLabel);
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
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.description,
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
									MessageProcessorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.MessageProcessor.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		EditingUtils.setID(commentsList, EsbViewsRepository.MessageProcessor.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.MessageProcessor.Properties.commentsList, EsbMessages.MessageProcessorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "MessageProcessor", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.MessageProcessor.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createProcessorNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.processorName, EsbMessages.MessageProcessorPropertiesEditionPart_ProcessorNameLabel);
		processorName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		processorName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData processorNameData = new GridData(GridData.FILL_HORIZONTAL);
		processorName.setLayoutData(processorNameData);
		processorName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.processorName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, processorName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.processorName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, processorName.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		processorName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.processorName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, processorName.getText()));
				}
			}
		});
		EditingUtils.setID(processorName, EsbViewsRepository.MessageProcessor.Properties.processorName);
		EditingUtils.setEEFtype(processorName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.processorName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createProcessorNameText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createProcessorTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.processorType, EsbMessages.MessageProcessorPropertiesEditionPart_ProcessorTypeLabel);
		processorType = new EMFComboViewer(parent);
		processorType.setContentProvider(new ArrayContentProvider());
		processorType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData processorTypeData = new GridData(GridData.FILL_HORIZONTAL);
		processorType.getCombo().setLayoutData(processorTypeData);
                processorType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		processorType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.processorType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getProcessorType()));
			}

		});
		processorType.setID(EsbViewsRepository.MessageProcessor.Properties.processorType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.processorType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createProcessorTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createMessageProcessorProviderText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider, EsbMessages.MessageProcessorPropertiesEditionPart_MessageProcessorProviderLabel);
		messageProcessorProvider = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		messageProcessorProvider.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData messageProcessorProviderData = new GridData(GridData.FILL_HORIZONTAL);
		messageProcessorProvider.setLayoutData(messageProcessorProviderData);
		messageProcessorProvider.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, messageProcessorProvider.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, messageProcessorProvider.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		messageProcessorProvider.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, messageProcessorProvider.getText()));
				}
			}
		});
		EditingUtils.setID(messageProcessorProvider, EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider);
		EditingUtils.setEEFtype(messageProcessorProvider, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMessageProcessorProviderText

		// End of user code
		return parent;
	}

	
	protected Composite createMessageStoreText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.messageStore, EsbMessages.MessageProcessorPropertiesEditionPart_MessageStoreLabel);
		messageStore = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		messageStore.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData messageStoreData = new GridData(GridData.FILL_HORIZONTAL);
		messageStore.setLayoutData(messageStoreData);
		messageStore.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.messageStore,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, messageStore.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.messageStore,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, messageStore.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		messageStore.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.messageStore, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, messageStore.getText()));
				}
			}
		});
		EditingUtils.setID(messageStore, EsbViewsRepository.MessageProcessor.Properties.messageStore);
		EditingUtils.setEEFtype(messageStore, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.messageStore, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMessageStoreText

		// End of user code
		return parent;
	}

	
	protected Composite createSourceMessageStoreText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore, EsbMessages.MessageProcessorPropertiesEditionPart_SourceMessageStoreLabel);
		sourceMessageStore = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		sourceMessageStore.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData sourceMessageStoreData = new GridData(GridData.FILL_HORIZONTAL);
		sourceMessageStore.setLayoutData(sourceMessageStoreData);
		sourceMessageStore.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceMessageStore.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, sourceMessageStore.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		sourceMessageStore.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceMessageStore.getText()));
				}
			}
		});
		EditingUtils.setID(sourceMessageStore, EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore);
		EditingUtils.setEEFtype(sourceMessageStore, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceMessageStoreText

		// End of user code
		return parent;
	}

	
	protected Composite createTargetMessageStoreText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.targetMessageStore, EsbMessages.MessageProcessorPropertiesEditionPart_TargetMessageStoreLabel);
		targetMessageStore = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		targetMessageStore.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData targetMessageStoreData = new GridData(GridData.FILL_HORIZONTAL);
		targetMessageStore.setLayoutData(targetMessageStoreData);
		targetMessageStore.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.targetMessageStore,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetMessageStore.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.targetMessageStore,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, targetMessageStore.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		targetMessageStore.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.targetMessageStore, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetMessageStore.getText()));
				}
			}
		});
		EditingUtils.setID(targetMessageStore, EsbViewsRepository.MessageProcessor.Properties.targetMessageStore);
		EditingUtils.setEEFtype(targetMessageStore, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.targetMessageStore, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetMessageStoreText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createProcessorStateEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.processorState, EsbMessages.MessageProcessorPropertiesEditionPart_ProcessorStateLabel);
		processorState = new EMFComboViewer(parent);
		processorState.setContentProvider(new ArrayContentProvider());
		processorState.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData processorStateData = new GridData(GridData.FILL_HORIZONTAL);
		processorState.getCombo().setLayoutData(processorStateData);
                processorState.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		processorState.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.processorState, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getProcessorState()));
			}

		});
		processorState.setID(EsbViewsRepository.MessageProcessor.Properties.processorState);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.processorState, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createProcessorStateEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createRetryIntervalText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.retryInterval, EsbMessages.MessageProcessorPropertiesEditionPart_RetryIntervalLabel);
		retryInterval = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		retryInterval.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData retryIntervalData = new GridData(GridData.FILL_HORIZONTAL);
		retryInterval.setLayoutData(retryIntervalData);
		retryInterval.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.retryInterval,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryInterval.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.retryInterval,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, retryInterval.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		retryInterval.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.retryInterval, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, retryInterval.getText()));
				}
			}
		});
		EditingUtils.setID(retryInterval, EsbViewsRepository.MessageProcessor.Properties.retryInterval);
		EditingUtils.setEEFtype(retryInterval, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.retryInterval, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRetryIntervalText

		// End of user code
		return parent;
	}

	
	protected Composite createForwardingIntervalText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.forwardingInterval, EsbMessages.MessageProcessorPropertiesEditionPart_ForwardingIntervalLabel);
		forwardingInterval = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		forwardingInterval.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData forwardingIntervalData = new GridData(GridData.FILL_HORIZONTAL);
		forwardingInterval.setLayoutData(forwardingIntervalData);
		forwardingInterval.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.forwardingInterval,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, forwardingInterval.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.forwardingInterval,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, forwardingInterval.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		forwardingInterval.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.forwardingInterval, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, forwardingInterval.getText()));
				}
			}
		});
		EditingUtils.setID(forwardingInterval, EsbViewsRepository.MessageProcessor.Properties.forwardingInterval);
		EditingUtils.setEEFtype(forwardingInterval, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.forwardingInterval, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createForwardingIntervalText

		// End of user code
		return parent;
	}

	
	protected Composite createSamplingIntervalText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.samplingInterval, EsbMessages.MessageProcessorPropertiesEditionPart_SamplingIntervalLabel);
		samplingInterval = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		samplingInterval.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData samplingIntervalData = new GridData(GridData.FILL_HORIZONTAL);
		samplingInterval.setLayoutData(samplingIntervalData);
		samplingInterval.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.samplingInterval,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, samplingInterval.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.samplingInterval,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, samplingInterval.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		samplingInterval.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.samplingInterval, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, samplingInterval.getText()));
				}
			}
		});
		EditingUtils.setID(samplingInterval, EsbViewsRepository.MessageProcessor.Properties.samplingInterval);
		EditingUtils.setEEFtype(samplingInterval, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.samplingInterval, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSamplingIntervalText

		// End of user code
		return parent;
	}

	
	protected Composite createSamplingConcurrencyText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency, EsbMessages.MessageProcessorPropertiesEditionPart_SamplingConcurrencyLabel);
		samplingConcurrency = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		samplingConcurrency.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData samplingConcurrencyData = new GridData(GridData.FILL_HORIZONTAL);
		samplingConcurrency.setLayoutData(samplingConcurrencyData);
		samplingConcurrency.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, samplingConcurrency.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, samplingConcurrency.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		samplingConcurrency.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, samplingConcurrency.getText()));
				}
			}
		});
		EditingUtils.setID(samplingConcurrency, EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency);
		EditingUtils.setEEFtype(samplingConcurrency, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSamplingConcurrencyText

		// End of user code
		return parent;
	}

	
	protected Composite createMaxDeliveryAttemptsText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts, EsbMessages.MessageProcessorPropertiesEditionPart_MaxDeliveryAttemptsLabel);
		maxDeliveryAttempts = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		maxDeliveryAttempts.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData maxDeliveryAttemptsData = new GridData(GridData.FILL_HORIZONTAL);
		maxDeliveryAttempts.setLayoutData(maxDeliveryAttemptsData);
		maxDeliveryAttempts.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxDeliveryAttempts.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, maxDeliveryAttempts.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		maxDeliveryAttempts.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxDeliveryAttempts.getText()));
				}
			}
		});
		EditingUtils.setID(maxDeliveryAttempts, EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts);
		EditingUtils.setEEFtype(maxDeliveryAttempts, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxDeliveryAttemptsText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createDropMessageAfterMaximumDeliveryAttemptsEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts, EsbMessages.MessageProcessorPropertiesEditionPart_DropMessageAfterMaximumDeliveryAttemptsLabel);
		dropMessageAfterMaximumDeliveryAttempts = new EMFComboViewer(parent);
		dropMessageAfterMaximumDeliveryAttempts.setContentProvider(new ArrayContentProvider());
		dropMessageAfterMaximumDeliveryAttempts.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData dropMessageAfterMaximumDeliveryAttemptsData = new GridData(GridData.FILL_HORIZONTAL);
		dropMessageAfterMaximumDeliveryAttempts.getCombo().setLayoutData(dropMessageAfterMaximumDeliveryAttemptsData);
                dropMessageAfterMaximumDeliveryAttempts.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		dropMessageAfterMaximumDeliveryAttempts.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDropMessageAfterMaximumDeliveryAttempts()));
			}

		});
		dropMessageAfterMaximumDeliveryAttempts.setID(EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDropMessageAfterMaximumDeliveryAttemptsEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createAxis2ClientRepositoryText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository, EsbMessages.MessageProcessorPropertiesEditionPart_Axis2ClientRepositoryLabel);
		axis2ClientRepository = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		axis2ClientRepository.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData axis2ClientRepositoryData = new GridData(GridData.FILL_HORIZONTAL);
		axis2ClientRepository.setLayoutData(axis2ClientRepositoryData);
		axis2ClientRepository.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, axis2ClientRepository.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, axis2ClientRepository.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		axis2ClientRepository.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, axis2ClientRepository.getText()));
				}
			}
		});
		EditingUtils.setID(axis2ClientRepository, EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository);
		EditingUtils.setEEFtype(axis2ClientRepository, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAxis2ClientRepositoryText

		// End of user code
		return parent;
	}

	
	protected Composite createAxis2ConfigurationText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.axis2Configuration, EsbMessages.MessageProcessorPropertiesEditionPart_Axis2ConfigurationLabel);
		axis2Configuration = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		axis2Configuration.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData axis2ConfigurationData = new GridData(GridData.FILL_HORIZONTAL);
		axis2Configuration.setLayoutData(axis2ConfigurationData);
		axis2Configuration.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.axis2Configuration,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, axis2Configuration.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.axis2Configuration,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, axis2Configuration.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		axis2Configuration.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.axis2Configuration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, axis2Configuration.getText()));
				}
			}
		});
		EditingUtils.setID(axis2Configuration, EsbViewsRepository.MessageProcessor.Properties.axis2Configuration);
		EditingUtils.setEEFtype(axis2Configuration, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.axis2Configuration, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAxis2ConfigurationText

		// End of user code
		return parent;
	}

	
	protected Composite createQuartzConfigFilePathText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath, EsbMessages.MessageProcessorPropertiesEditionPart_QuartzConfigFilePathLabel);
		quartzConfigFilePath = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		quartzConfigFilePath.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData quartzConfigFilePathData = new GridData(GridData.FILL_HORIZONTAL);
		quartzConfigFilePath.setLayoutData(quartzConfigFilePathData);
		quartzConfigFilePath.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, quartzConfigFilePath.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, quartzConfigFilePath.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		quartzConfigFilePath.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, quartzConfigFilePath.getText()));
				}
			}
		});
		EditingUtils.setID(quartzConfigFilePath, EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath);
		EditingUtils.setEEFtype(quartzConfigFilePath, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createQuartzConfigFilePathText

		// End of user code
		return parent;
	}

	
	protected Composite createCronExpressionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.cronExpression, EsbMessages.MessageProcessorPropertiesEditionPart_CronExpressionLabel);
		cronExpression = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		cronExpression.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData cronExpressionData = new GridData(GridData.FILL_HORIZONTAL);
		cronExpression.setLayoutData(cronExpressionData);
		cronExpression.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.cronExpression,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cronExpression.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.cronExpression,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, cronExpression.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		cronExpression.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.cronExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cronExpression.getText()));
				}
			}
		});
		EditingUtils.setID(cronExpression, EsbViewsRepository.MessageProcessor.Properties.cronExpression);
		EditingUtils.setEEFtype(cronExpression, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.cronExpression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCronExpressionText

		// End of user code
		return parent;
	}

	
	protected Composite createNonRetryHttpStatusCodesText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes, EsbMessages.MessageProcessorPropertiesEditionPart_NonRetryHttpStatusCodesLabel);
		nonRetryHttpStatusCodes = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		nonRetryHttpStatusCodes.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nonRetryHttpStatusCodesData = new GridData(GridData.FILL_HORIZONTAL);
		nonRetryHttpStatusCodes.setLayoutData(nonRetryHttpStatusCodesData);
		nonRetryHttpStatusCodes.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nonRetryHttpStatusCodes.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, nonRetryHttpStatusCodes.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		nonRetryHttpStatusCodes.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nonRetryHttpStatusCodes.getText()));
				}
			}
		});
		EditingUtils.setID(nonRetryHttpStatusCodes, EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes);
		EditingUtils.setEEFtype(nonRetryHttpStatusCodes, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNonRetryHttpStatusCodesText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createParametersTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.parameters = new ReferencesTable(getDescription(EsbViewsRepository.MessageProcessor.Properties.parameters, EsbMessages.MessageProcessorPropertiesEditionPart_ParametersLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				parameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				parameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				parameters.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				parameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.parametersFilters) {
			this.parameters.addFilter(filter);
		}
		this.parameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.parameters, EsbViewsRepository.FORM_KIND));
		this.parameters.createControls(parent, widgetFactory);
		this.parameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.parameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData parametersData = new GridData(GridData.FILL_HORIZONTAL);
		parametersData.horizontalSpan = 3;
		this.parameters.setLayoutData(parametersData);
		this.parameters.setLowerBound(0);
		this.parameters.setUpperBound(-1);
		parameters.setID(EsbViewsRepository.MessageProcessor.Properties.parameters);
		parameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createParametersTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createTaskCountText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.taskCount, EsbMessages.MessageProcessorPropertiesEditionPart_TaskCountLabel);
		taskCount = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		taskCount.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData taskCountData = new GridData(GridData.FILL_HORIZONTAL);
		taskCount.setLayoutData(taskCountData);
		taskCount.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.taskCount,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, taskCount.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.taskCount,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, taskCount.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		taskCount.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.taskCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, taskCount.getText()));
				}
			}
		});
		EditingUtils.setID(taskCount, EsbViewsRepository.MessageProcessor.Properties.taskCount);
		EditingUtils.setEEFtype(taskCount, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.taskCount, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTaskCountText

		// End of user code
		return parent;
	}

	
	protected Composite createMaxStoreConnectionAttemptsText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts, EsbMessages.MessageProcessorPropertiesEditionPart_MaxStoreConnectionAttemptsLabel);
		maxStoreConnectionAttempts = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		maxStoreConnectionAttempts.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData maxStoreConnectionAttemptsData = new GridData(GridData.FILL_HORIZONTAL);
		maxStoreConnectionAttempts.setLayoutData(maxStoreConnectionAttemptsData);
		maxStoreConnectionAttempts.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxStoreConnectionAttempts.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, maxStoreConnectionAttempts.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		maxStoreConnectionAttempts.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxStoreConnectionAttempts.getText()));
				}
			}
		});
		EditingUtils.setID(maxStoreConnectionAttempts, EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts);
		EditingUtils.setEEFtype(maxStoreConnectionAttempts, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxStoreConnectionAttemptsText

		// End of user code
		return parent;
	}

	
	protected Composite createStoreConnectionIntervalText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval, EsbMessages.MessageProcessorPropertiesEditionPart_StoreConnectionIntervalLabel);
		storeConnectionInterval = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		storeConnectionInterval.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData storeConnectionIntervalData = new GridData(GridData.FILL_HORIZONTAL);
		storeConnectionInterval.setLayoutData(storeConnectionIntervalData);
		storeConnectionInterval.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, storeConnectionInterval.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, storeConnectionInterval.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		storeConnectionInterval.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, storeConnectionInterval.getText()));
				}
			}
		});
		EditingUtils.setID(storeConnectionInterval, EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval);
		EditingUtils.setEEFtype(storeConnectionInterval, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStoreConnectionIntervalText

		// End of user code
		return parent;
	}

	
	protected Composite createFailMessagesStoreText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageProcessor.Properties.failMessagesStore, EsbMessages.MessageProcessorPropertiesEditionPart_FailMessagesStoreLabel);
		failMessagesStore = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		failMessagesStore.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData failMessagesStoreData = new GridData(GridData.FILL_HORIZONTAL);
		failMessagesStore.setLayoutData(failMessagesStoreData);
		failMessagesStore.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageProcessorPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageProcessor.Properties.failMessagesStore,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failMessagesStore.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageProcessorPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageProcessor.Properties.failMessagesStore,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, failMessagesStore.getText()));
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
									MessageProcessorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		failMessagesStore.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageProcessorPropertiesEditionPartForm.this, EsbViewsRepository.MessageProcessor.Properties.failMessagesStore, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failMessagesStore.getText()));
				}
			}
		});
		EditingUtils.setID(failMessagesStore, EsbViewsRepository.MessageProcessor.Properties.failMessagesStore);
		EditingUtils.setEEFtype(failMessagesStore, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageProcessor.Properties.failMessagesStore, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFailMessagesStoreText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getProcessorName()
	 * 
	 */
	public String getProcessorName() {
		return processorName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setProcessorName(String newValue)
	 * 
	 */
	public void setProcessorName(String newValue) {
		if (newValue != null) {
			processorName.setText(newValue);
		} else {
			processorName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.processorName);
		if (eefElementEditorReadOnlyState && processorName.isEnabled()) {
			processorName.setEnabled(false);
			processorName.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !processorName.isEnabled()) {
			processorName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getProcessorType()
	 * 
	 */
	public Enumerator getProcessorType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) processorType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#initProcessorType(Object input, Enumerator current)
	 */
	public void initProcessorType(Object input, Enumerator current) {
		processorType.setInput(input);
		processorType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.processorType);
		if (eefElementEditorReadOnlyState && processorType.isEnabled()) {
			processorType.setEnabled(false);
			processorType.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !processorType.isEnabled()) {
			processorType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setProcessorType(Enumerator newValue)
	 * 
	 */
	public void setProcessorType(Enumerator newValue) {
		processorType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.processorType);
		if (eefElementEditorReadOnlyState && processorType.isEnabled()) {
			processorType.setEnabled(false);
			processorType.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !processorType.isEnabled()) {
			processorType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getMessageProcessorProvider()
	 * 
	 */
	public String getMessageProcessorProvider() {
		return messageProcessorProvider.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setMessageProcessorProvider(String newValue)
	 * 
	 */
	public void setMessageProcessorProvider(String newValue) {
		if (newValue != null) {
			messageProcessorProvider.setText(newValue);
		} else {
			messageProcessorProvider.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.messageProcessorProvider);
		if (eefElementEditorReadOnlyState && messageProcessorProvider.isEnabled()) {
			messageProcessorProvider.setEnabled(false);
			messageProcessorProvider.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !messageProcessorProvider.isEnabled()) {
			messageProcessorProvider.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getMessageStore()
	 * 
	 */
	public String getMessageStore() {
		return messageStore.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setMessageStore(String newValue)
	 * 
	 */
	public void setMessageStore(String newValue) {
		if (newValue != null) {
			messageStore.setText(newValue);
		} else {
			messageStore.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.messageStore);
		if (eefElementEditorReadOnlyState && messageStore.isEnabled()) {
			messageStore.setEnabled(false);
			messageStore.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !messageStore.isEnabled()) {
			messageStore.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getSourceMessageStore()
	 * 
	 */
	public String getSourceMessageStore() {
		return sourceMessageStore.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setSourceMessageStore(String newValue)
	 * 
	 */
	public void setSourceMessageStore(String newValue) {
		if (newValue != null) {
			sourceMessageStore.setText(newValue);
		} else {
			sourceMessageStore.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.sourceMessageStore);
		if (eefElementEditorReadOnlyState && sourceMessageStore.isEnabled()) {
			sourceMessageStore.setEnabled(false);
			sourceMessageStore.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceMessageStore.isEnabled()) {
			sourceMessageStore.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getTargetMessageStore()
	 * 
	 */
	public String getTargetMessageStore() {
		return targetMessageStore.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setTargetMessageStore(String newValue)
	 * 
	 */
	public void setTargetMessageStore(String newValue) {
		if (newValue != null) {
			targetMessageStore.setText(newValue);
		} else {
			targetMessageStore.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.targetMessageStore);
		if (eefElementEditorReadOnlyState && targetMessageStore.isEnabled()) {
			targetMessageStore.setEnabled(false);
			targetMessageStore.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetMessageStore.isEnabled()) {
			targetMessageStore.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getProcessorState()
	 * 
	 */
	public Enumerator getProcessorState() {
		Enumerator selection = (Enumerator) ((StructuredSelection) processorState.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#initProcessorState(Object input, Enumerator current)
	 */
	public void initProcessorState(Object input, Enumerator current) {
		processorState.setInput(input);
		processorState.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.processorState);
		if (eefElementEditorReadOnlyState && processorState.isEnabled()) {
			processorState.setEnabled(false);
			processorState.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !processorState.isEnabled()) {
			processorState.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setProcessorState(Enumerator newValue)
	 * 
	 */
	public void setProcessorState(Enumerator newValue) {
		processorState.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.processorState);
		if (eefElementEditorReadOnlyState && processorState.isEnabled()) {
			processorState.setEnabled(false);
			processorState.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !processorState.isEnabled()) {
			processorState.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getRetryInterval()
	 * 
	 */
	public String getRetryInterval() {
		return retryInterval.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setRetryInterval(String newValue)
	 * 
	 */
	public void setRetryInterval(String newValue) {
		if (newValue != null) {
			retryInterval.setText(newValue);
		} else {
			retryInterval.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.retryInterval);
		if (eefElementEditorReadOnlyState && retryInterval.isEnabled()) {
			retryInterval.setEnabled(false);
			retryInterval.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !retryInterval.isEnabled()) {
			retryInterval.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getForwardingInterval()
	 * 
	 */
	public String getForwardingInterval() {
		return forwardingInterval.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setForwardingInterval(String newValue)
	 * 
	 */
	public void setForwardingInterval(String newValue) {
		if (newValue != null) {
			forwardingInterval.setText(newValue);
		} else {
			forwardingInterval.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.forwardingInterval);
		if (eefElementEditorReadOnlyState && forwardingInterval.isEnabled()) {
			forwardingInterval.setEnabled(false);
			forwardingInterval.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !forwardingInterval.isEnabled()) {
			forwardingInterval.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getSamplingInterval()
	 * 
	 */
	public String getSamplingInterval() {
		return samplingInterval.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setSamplingInterval(String newValue)
	 * 
	 */
	public void setSamplingInterval(String newValue) {
		if (newValue != null) {
			samplingInterval.setText(newValue);
		} else {
			samplingInterval.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.samplingInterval);
		if (eefElementEditorReadOnlyState && samplingInterval.isEnabled()) {
			samplingInterval.setEnabled(false);
			samplingInterval.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !samplingInterval.isEnabled()) {
			samplingInterval.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getSamplingConcurrency()
	 * 
	 */
	public String getSamplingConcurrency() {
		return samplingConcurrency.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setSamplingConcurrency(String newValue)
	 * 
	 */
	public void setSamplingConcurrency(String newValue) {
		if (newValue != null) {
			samplingConcurrency.setText(newValue);
		} else {
			samplingConcurrency.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.samplingConcurrency);
		if (eefElementEditorReadOnlyState && samplingConcurrency.isEnabled()) {
			samplingConcurrency.setEnabled(false);
			samplingConcurrency.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !samplingConcurrency.isEnabled()) {
			samplingConcurrency.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getMaxDeliveryAttempts()
	 * 
	 */
	public String getMaxDeliveryAttempts() {
		return maxDeliveryAttempts.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setMaxDeliveryAttempts(String newValue)
	 * 
	 */
	public void setMaxDeliveryAttempts(String newValue) {
		if (newValue != null) {
			maxDeliveryAttempts.setText(newValue);
		} else {
			maxDeliveryAttempts.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.maxDeliveryAttempts);
		if (eefElementEditorReadOnlyState && maxDeliveryAttempts.isEnabled()) {
			maxDeliveryAttempts.setEnabled(false);
			maxDeliveryAttempts.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maxDeliveryAttempts.isEnabled()) {
			maxDeliveryAttempts.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getDropMessageAfterMaximumDeliveryAttempts()
	 * 
	 */
	public Enumerator getDropMessageAfterMaximumDeliveryAttempts() {
		Enumerator selection = (Enumerator) ((StructuredSelection) dropMessageAfterMaximumDeliveryAttempts.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#initDropMessageAfterMaximumDeliveryAttempts(Object input, Enumerator current)
	 */
	public void initDropMessageAfterMaximumDeliveryAttempts(Object input, Enumerator current) {
		dropMessageAfterMaximumDeliveryAttempts.setInput(input);
		dropMessageAfterMaximumDeliveryAttempts.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts);
		if (eefElementEditorReadOnlyState && dropMessageAfterMaximumDeliveryAttempts.isEnabled()) {
			dropMessageAfterMaximumDeliveryAttempts.setEnabled(false);
			dropMessageAfterMaximumDeliveryAttempts.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dropMessageAfterMaximumDeliveryAttempts.isEnabled()) {
			dropMessageAfterMaximumDeliveryAttempts.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setDropMessageAfterMaximumDeliveryAttempts(Enumerator newValue)
	 * 
	 */
	public void setDropMessageAfterMaximumDeliveryAttempts(Enumerator newValue) {
		dropMessageAfterMaximumDeliveryAttempts.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.dropMessageAfterMaximumDeliveryAttempts);
		if (eefElementEditorReadOnlyState && dropMessageAfterMaximumDeliveryAttempts.isEnabled()) {
			dropMessageAfterMaximumDeliveryAttempts.setEnabled(false);
			dropMessageAfterMaximumDeliveryAttempts.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dropMessageAfterMaximumDeliveryAttempts.isEnabled()) {
			dropMessageAfterMaximumDeliveryAttempts.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getAxis2ClientRepository()
	 * 
	 */
	public String getAxis2ClientRepository() {
		return axis2ClientRepository.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setAxis2ClientRepository(String newValue)
	 * 
	 */
	public void setAxis2ClientRepository(String newValue) {
		if (newValue != null) {
			axis2ClientRepository.setText(newValue);
		} else {
			axis2ClientRepository.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.axis2ClientRepository);
		if (eefElementEditorReadOnlyState && axis2ClientRepository.isEnabled()) {
			axis2ClientRepository.setEnabled(false);
			axis2ClientRepository.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !axis2ClientRepository.isEnabled()) {
			axis2ClientRepository.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getAxis2Configuration()
	 * 
	 */
	public String getAxis2Configuration() {
		return axis2Configuration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setAxis2Configuration(String newValue)
	 * 
	 */
	public void setAxis2Configuration(String newValue) {
		if (newValue != null) {
			axis2Configuration.setText(newValue);
		} else {
			axis2Configuration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.axis2Configuration);
		if (eefElementEditorReadOnlyState && axis2Configuration.isEnabled()) {
			axis2Configuration.setEnabled(false);
			axis2Configuration.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !axis2Configuration.isEnabled()) {
			axis2Configuration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getQuartzConfigFilePath()
	 * 
	 */
	public String getQuartzConfigFilePath() {
		return quartzConfigFilePath.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setQuartzConfigFilePath(String newValue)
	 * 
	 */
	public void setQuartzConfigFilePath(String newValue) {
		if (newValue != null) {
			quartzConfigFilePath.setText(newValue);
		} else {
			quartzConfigFilePath.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.quartzConfigFilePath);
		if (eefElementEditorReadOnlyState && quartzConfigFilePath.isEnabled()) {
			quartzConfigFilePath.setEnabled(false);
			quartzConfigFilePath.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !quartzConfigFilePath.isEnabled()) {
			quartzConfigFilePath.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getCronExpression()
	 * 
	 */
	public String getCronExpression() {
		return cronExpression.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setCronExpression(String newValue)
	 * 
	 */
	public void setCronExpression(String newValue) {
		if (newValue != null) {
			cronExpression.setText(newValue);
		} else {
			cronExpression.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.cronExpression);
		if (eefElementEditorReadOnlyState && cronExpression.isEnabled()) {
			cronExpression.setEnabled(false);
			cronExpression.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cronExpression.isEnabled()) {
			cronExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getNonRetryHttpStatusCodes()
	 * 
	 */
	public String getNonRetryHttpStatusCodes() {
		return nonRetryHttpStatusCodes.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setNonRetryHttpStatusCodes(String newValue)
	 * 
	 */
	public void setNonRetryHttpStatusCodes(String newValue) {
		if (newValue != null) {
			nonRetryHttpStatusCodes.setText(newValue);
		} else {
			nonRetryHttpStatusCodes.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.nonRetryHttpStatusCodes);
		if (eefElementEditorReadOnlyState && nonRetryHttpStatusCodes.isEnabled()) {
			nonRetryHttpStatusCodes.setEnabled(false);
			nonRetryHttpStatusCodes.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !nonRetryHttpStatusCodes.isEnabled()) {
			nonRetryHttpStatusCodes.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#initParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		parameters.setContentProvider(contentProvider);
		parameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.parameters);
		if (eefElementEditorReadOnlyState && parameters.isEnabled()) {
			parameters.setEnabled(false);
			parameters.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameters.isEnabled()) {
			parameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#updateParameters()
	 * 
	 */
	public void updateParameters() {
	parameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#addFilterParameters(ViewerFilter filter)
	 * 
	 */
	public void addFilterToParameters(ViewerFilter filter) {
		parametersFilters.add(filter);
		if (this.parameters != null) {
			this.parameters.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#addBusinessFilterParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToParameters(ViewerFilter filter) {
		parametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#isContainedInParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInParametersTable(EObject element) {
		return ((ReferencesTableSettings)parameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getTaskCount()
	 * 
	 */
	public String getTaskCount() {
		return taskCount.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setTaskCount(String newValue)
	 * 
	 */
	public void setTaskCount(String newValue) {
		if (newValue != null) {
			taskCount.setText(newValue);
		} else {
			taskCount.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.taskCount);
		if (eefElementEditorReadOnlyState && taskCount.isEnabled()) {
			taskCount.setEnabled(false);
			taskCount.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !taskCount.isEnabled()) {
			taskCount.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getMaxStoreConnectionAttempts()
	 * 
	 */
	public String getMaxStoreConnectionAttempts() {
		return maxStoreConnectionAttempts.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setMaxStoreConnectionAttempts(String newValue)
	 * 
	 */
	public void setMaxStoreConnectionAttempts(String newValue) {
		if (newValue != null) {
			maxStoreConnectionAttempts.setText(newValue);
		} else {
			maxStoreConnectionAttempts.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.maxStoreConnectionAttempts);
		if (eefElementEditorReadOnlyState && maxStoreConnectionAttempts.isEnabled()) {
			maxStoreConnectionAttempts.setEnabled(false);
			maxStoreConnectionAttempts.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maxStoreConnectionAttempts.isEnabled()) {
			maxStoreConnectionAttempts.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getStoreConnectionInterval()
	 * 
	 */
	public String getStoreConnectionInterval() {
		return storeConnectionInterval.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setStoreConnectionInterval(String newValue)
	 * 
	 */
	public void setStoreConnectionInterval(String newValue) {
		if (newValue != null) {
			storeConnectionInterval.setText(newValue);
		} else {
			storeConnectionInterval.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.storeConnectionInterval);
		if (eefElementEditorReadOnlyState && storeConnectionInterval.isEnabled()) {
			storeConnectionInterval.setEnabled(false);
			storeConnectionInterval.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !storeConnectionInterval.isEnabled()) {
			storeConnectionInterval.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#getFailMessagesStore()
	 * 
	 */
	public String getFailMessagesStore() {
		return failMessagesStore.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageProcessorPropertiesEditionPart#setFailMessagesStore(String newValue)
	 * 
	 */
	public void setFailMessagesStore(String newValue) {
		if (newValue != null) {
			failMessagesStore.setText(newValue);
		} else {
			failMessagesStore.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageProcessor.Properties.failMessagesStore);
		if (eefElementEditorReadOnlyState && failMessagesStore.isEnabled()) {
			failMessagesStore.setEnabled(false);
			failMessagesStore.setToolTipText(EsbMessages.MessageProcessor_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !failMessagesStore.isEnabled()) {
			failMessagesStore.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.MessageProcessor_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
