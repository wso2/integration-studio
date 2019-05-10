/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class MessageStorePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, MessageStorePropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Text storeName;
	protected EMFComboViewer storeType;
	protected Text initialContextFactory;
	protected Text providerURL;
	protected Text jndiQueueName;
	protected Text connectionFactory;
	protected Text userName;
	protected Text password;
	protected Button cacheConnection;
	protected EMFComboViewer jmsSpecVersion;
	protected Button enableCaching;
	protected Text providerClass;
	protected Text rabbitMQServerHostName;
	protected Text rabbitMQServerHostPort;
	protected Text rabbitMQQueueName;
	protected Text rabbitMQExchangeName;
	protected Text routingKey;
	protected Text rabbitMQUserName;
	protected Text rabbitMQPassword;
	protected Text virtualHost;
	protected Text jdbcDatabaseTable;
	protected EMFComboViewer jdbcConnectionInformation;
	protected Text jdbcDriver;
	protected Text jdbcURL;
	protected Text jdbcUser;
	protected Text jdbcPassword;
	protected Text jdbcDatasourceName;
	protected ReferencesTable parameters;
	protected List<ViewerFilter> parametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> parametersFilters = new ArrayList<ViewerFilter>();
	protected Button enableProducerGuaranteedDelivery;
	protected Text failoverMessageStore;
	protected Text resequencepolling;
	protected Text resequenceDatabaseTable;
	protected EMFComboViewer resequenceConnectionInformation;
	protected Text resequenceDriver;
	protected Text resequenceURL;
	protected Text resequenceUser;
	protected Text resequencePassword;
	protected Text resequenceDatasourceName;
	protected Text resequenceXpath;
	protected EObjectFlatComboViewer resequenceXpathAttr;



	/**
	 * For {@link ISection} use only.
	 */
	public MessageStorePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MessageStorePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence messageStoreStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = messageStoreStep.addStep(EsbViewsRepository.MessageStore.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.storeName);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.storeType);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.initialContextFactory);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.providerURL);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.jndiQueueName);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.connectionFactory);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.userName);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.password);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.cacheConnection);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.jmsSpecVersion);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.enableCaching);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.providerClass);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.routingKey);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.rabbitMQUserName);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.rabbitMQPassword);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.virtualHost);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.jdbcDriver);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.jdbcURL);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.jdbcUser);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.jdbcPassword);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.parameters);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.failoverMessageStore);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.resequencepolling);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.resequenceDriver);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.resequenceURL);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.resequenceUser);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.resequencePassword);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.resequenceXpath);
		propertiesStep.addStep(EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr);
		
		
		composer = new PartComposer(messageStoreStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.MessageStore.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.storeName) {
					return createStoreNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.storeType) {
					return createStoreTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.initialContextFactory) {
					return createInitialContextFactoryText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.providerURL) {
					return createProviderURLText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.jndiQueueName) {
					return createJndiQueueNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.connectionFactory) {
					return createConnectionFactoryText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.userName) {
					return createUserNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.password) {
					return createPasswordText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.cacheConnection) {
					return createCacheConnectionCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.jmsSpecVersion) {
					return createJmsSpecVersionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.enableCaching) {
					return createEnableCachingCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.providerClass) {
					return createProviderClassText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName) {
					return createRabbitMQServerHostNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort) {
					return createRabbitMQServerHostPortText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName) {
					return createRabbitMQQueueNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName) {
					return createRabbitMQExchangeNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.routingKey) {
					return createRoutingKeyText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQUserName) {
					return createRabbitMQUserNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQPassword) {
					return createRabbitMQPasswordText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.virtualHost) {
					return createVirtualHostText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable) {
					return createJdbcDatabaseTableText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation) {
					return createJdbcConnectionInformationEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.jdbcDriver) {
					return createJdbcDriverText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.jdbcURL) {
					return createJdbcURLText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.jdbcUser) {
					return createJdbcUserText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.jdbcPassword) {
					return createJdbcPasswordText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName) {
					return createJdbcDatasourceNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.parameters) {
					return createParametersTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery) {
					return createEnableProducerGuaranteedDeliveryCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.failoverMessageStore) {
					return createFailoverMessageStoreText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.resequencepolling) {
					return createResequencepollingText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable) {
					return createResequenceDatabaseTableText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation) {
					return createResequenceConnectionInformationEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.resequenceDriver) {
					return createResequenceDriverText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.resequenceURL) {
					return createResequenceURLText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.resequenceUser) {
					return createResequenceUserText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.resequencePassword) {
					return createResequencePasswordText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName) {
					return createResequenceDatasourceNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.resequenceXpath) {
					return createResequenceXpathText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr) {
					return createResequenceXpathAttrFlatComboViewer(parent, widgetFactory);
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
		propertiesSection.setText(EsbMessages.MessageStorePropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.description, EsbMessages.MessageStorePropertiesEditionPart_DescriptionLabel);
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
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.description,
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
									MessageStorePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.MessageStore.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		EditingUtils.setID(commentsList, EsbViewsRepository.MessageStore.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.MessageStore.Properties.commentsList, EsbMessages.MessageStorePropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "MessageStore", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.MessageStore.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createStoreNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.storeName, EsbMessages.MessageStorePropertiesEditionPart_StoreNameLabel);
		storeName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		storeName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData storeNameData = new GridData(GridData.FILL_HORIZONTAL);
		storeName.setLayoutData(storeNameData);
		storeName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.storeName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, storeName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.storeName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, storeName.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		storeName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.storeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, storeName.getText()));
				}
			}
		});
		EditingUtils.setID(storeName, EsbViewsRepository.MessageStore.Properties.storeName);
		EditingUtils.setEEFtype(storeName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.storeName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStoreNameText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createStoreTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.storeType, EsbMessages.MessageStorePropertiesEditionPart_StoreTypeLabel);
		storeType = new EMFComboViewer(parent);
		storeType.setContentProvider(new ArrayContentProvider());
		storeType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData storeTypeData = new GridData(GridData.FILL_HORIZONTAL);
		storeType.getCombo().setLayoutData(storeTypeData);
                storeType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		storeType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.storeType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getStoreType()));
			}

		});
		storeType.setID(EsbViewsRepository.MessageStore.Properties.storeType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.storeType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStoreTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createInitialContextFactoryText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.initialContextFactory, EsbMessages.MessageStorePropertiesEditionPart_InitialContextFactoryLabel);
		initialContextFactory = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		initialContextFactory.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData initialContextFactoryData = new GridData(GridData.FILL_HORIZONTAL);
		initialContextFactory.setLayoutData(initialContextFactoryData);
		initialContextFactory.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.initialContextFactory,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, initialContextFactory.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.initialContextFactory,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, initialContextFactory.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		initialContextFactory.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.initialContextFactory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, initialContextFactory.getText()));
				}
			}
		});
		EditingUtils.setID(initialContextFactory, EsbViewsRepository.MessageStore.Properties.initialContextFactory);
		EditingUtils.setEEFtype(initialContextFactory, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.initialContextFactory, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInitialContextFactoryText

		// End of user code
		return parent;
	}

	
	protected Composite createProviderURLText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.providerURL, EsbMessages.MessageStorePropertiesEditionPart_ProviderURLLabel);
		providerURL = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		providerURL.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData providerURLData = new GridData(GridData.FILL_HORIZONTAL);
		providerURL.setLayoutData(providerURLData);
		providerURL.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.providerURL,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, providerURL.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.providerURL,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, providerURL.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		providerURL.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.providerURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, providerURL.getText()));
				}
			}
		});
		EditingUtils.setID(providerURL, EsbViewsRepository.MessageStore.Properties.providerURL);
		EditingUtils.setEEFtype(providerURL, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.providerURL, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createProviderURLText

		// End of user code
		return parent;
	}

	
	protected Composite createJndiQueueNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.jndiQueueName, EsbMessages.MessageStorePropertiesEditionPart_JndiQueueNameLabel);
		jndiQueueName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		jndiQueueName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData jndiQueueNameData = new GridData(GridData.FILL_HORIZONTAL);
		jndiQueueName.setLayoutData(jndiQueueNameData);
		jndiQueueName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.jndiQueueName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jndiQueueName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.jndiQueueName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, jndiQueueName.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		jndiQueueName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.jndiQueueName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jndiQueueName.getText()));
				}
			}
		});
		EditingUtils.setID(jndiQueueName, EsbViewsRepository.MessageStore.Properties.jndiQueueName);
		EditingUtils.setEEFtype(jndiQueueName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.jndiQueueName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createJndiQueueNameText

		// End of user code
		return parent;
	}

	
	protected Composite createConnectionFactoryText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.connectionFactory, EsbMessages.MessageStorePropertiesEditionPart_ConnectionFactoryLabel);
		connectionFactory = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		connectionFactory.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData connectionFactoryData = new GridData(GridData.FILL_HORIZONTAL);
		connectionFactory.setLayoutData(connectionFactoryData);
		connectionFactory.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.connectionFactory,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionFactory.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.connectionFactory,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, connectionFactory.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		connectionFactory.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.connectionFactory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionFactory.getText()));
				}
			}
		});
		EditingUtils.setID(connectionFactory, EsbViewsRepository.MessageStore.Properties.connectionFactory);
		EditingUtils.setEEFtype(connectionFactory, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.connectionFactory, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectionFactoryText

		// End of user code
		return parent;
	}

	
	protected Composite createUserNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.userName, EsbMessages.MessageStorePropertiesEditionPart_UserNameLabel);
		userName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		userName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData userNameData = new GridData(GridData.FILL_HORIZONTAL);
		userName.setLayoutData(userNameData);
		userName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.userName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, userName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.userName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, userName.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		userName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.userName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, userName.getText()));
				}
			}
		});
		EditingUtils.setID(userName, EsbViewsRepository.MessageStore.Properties.userName);
		EditingUtils.setEEFtype(userName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.userName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createUserNameText

		// End of user code
		return parent;
	}

	
	protected Composite createPasswordText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.password, EsbMessages.MessageStorePropertiesEditionPart_PasswordLabel);
		password = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		password.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData passwordData = new GridData(GridData.FILL_HORIZONTAL);
		password.setLayoutData(passwordData);
		password.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.password,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, password.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.password,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, password.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		password.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.password, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, password.getText()));
				}
			}
		});
		EditingUtils.setID(password, EsbViewsRepository.MessageStore.Properties.password);
		EditingUtils.setEEFtype(password, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.password, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPasswordText

		// End of user code
		return parent;
	}

	
	protected Composite createCacheConnectionCheckbox(FormToolkit widgetFactory, Composite parent) {
		cacheConnection = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.MessageStore.Properties.cacheConnection, EsbMessages.MessageStorePropertiesEditionPart_CacheConnectionLabel), SWT.CHECK);
		cacheConnection.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.cacheConnection, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(cacheConnection.getSelection())));
			}

		});
		GridData cacheConnectionData = new GridData(GridData.FILL_HORIZONTAL);
		cacheConnectionData.horizontalSpan = 2;
		cacheConnection.setLayoutData(cacheConnectionData);
		EditingUtils.setID(cacheConnection, EsbViewsRepository.MessageStore.Properties.cacheConnection);
		EditingUtils.setEEFtype(cacheConnection, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.cacheConnection, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCacheConnectionCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createJmsSpecVersionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.jmsSpecVersion, EsbMessages.MessageStorePropertiesEditionPart_JmsSpecVersionLabel);
		jmsSpecVersion = new EMFComboViewer(parent);
		jmsSpecVersion.setContentProvider(new ArrayContentProvider());
		jmsSpecVersion.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData jmsSpecVersionData = new GridData(GridData.FILL_HORIZONTAL);
		jmsSpecVersion.getCombo().setLayoutData(jmsSpecVersionData);
                jmsSpecVersion.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		jmsSpecVersion.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.jmsSpecVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getJmsSpecVersion()));
			}

		});
		jmsSpecVersion.setID(EsbViewsRepository.MessageStore.Properties.jmsSpecVersion);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.jmsSpecVersion, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createJmsSpecVersionEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createEnableCachingCheckbox(FormToolkit widgetFactory, Composite parent) {
		enableCaching = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.MessageStore.Properties.enableCaching, EsbMessages.MessageStorePropertiesEditionPart_EnableCachingLabel), SWT.CHECK);
		enableCaching.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.enableCaching, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(enableCaching.getSelection())));
			}

		});
		GridData enableCachingData = new GridData(GridData.FILL_HORIZONTAL);
		enableCachingData.horizontalSpan = 2;
		enableCaching.setLayoutData(enableCachingData);
		EditingUtils.setID(enableCaching, EsbViewsRepository.MessageStore.Properties.enableCaching);
		EditingUtils.setEEFtype(enableCaching, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.enableCaching, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEnableCachingCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createProviderClassText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.providerClass, EsbMessages.MessageStorePropertiesEditionPart_ProviderClassLabel);
		providerClass = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		providerClass.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData providerClassData = new GridData(GridData.FILL_HORIZONTAL);
		providerClass.setLayoutData(providerClassData);
		providerClass.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.providerClass,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, providerClass.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.providerClass,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, providerClass.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		providerClass.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.providerClass, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, providerClass.getText()));
				}
			}
		});
		EditingUtils.setID(providerClass, EsbViewsRepository.MessageStore.Properties.providerClass);
		EditingUtils.setEEFtype(providerClass, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.providerClass, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createProviderClassText

		// End of user code
		return parent;
	}

	
	protected Composite createRabbitMQServerHostNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName, EsbMessages.MessageStorePropertiesEditionPart_RabbitMQServerHostNameLabel);
		rabbitMQServerHostName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		rabbitMQServerHostName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData rabbitMQServerHostNameData = new GridData(GridData.FILL_HORIZONTAL);
		rabbitMQServerHostName.setLayoutData(rabbitMQServerHostNameData);
		rabbitMQServerHostName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQServerHostName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, rabbitMQServerHostName.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		rabbitMQServerHostName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQServerHostName.getText()));
				}
			}
		});
		EditingUtils.setID(rabbitMQServerHostName, EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName);
		EditingUtils.setEEFtype(rabbitMQServerHostName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRabbitMQServerHostNameText

		// End of user code
		return parent;
	}

	
	protected Composite createRabbitMQServerHostPortText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort, EsbMessages.MessageStorePropertiesEditionPart_RabbitMQServerHostPortLabel);
		rabbitMQServerHostPort = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		rabbitMQServerHostPort.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData rabbitMQServerHostPortData = new GridData(GridData.FILL_HORIZONTAL);
		rabbitMQServerHostPort.setLayoutData(rabbitMQServerHostPortData);
		rabbitMQServerHostPort.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQServerHostPort.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, rabbitMQServerHostPort.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		rabbitMQServerHostPort.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQServerHostPort.getText()));
				}
			}
		});
		EditingUtils.setID(rabbitMQServerHostPort, EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort);
		EditingUtils.setEEFtype(rabbitMQServerHostPort, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRabbitMQServerHostPortText

		// End of user code
		return parent;
	}

	
	protected Composite createRabbitMQQueueNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName, EsbMessages.MessageStorePropertiesEditionPart_RabbitMQQueueNameLabel);
		rabbitMQQueueName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		rabbitMQQueueName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData rabbitMQQueueNameData = new GridData(GridData.FILL_HORIZONTAL);
		rabbitMQQueueName.setLayoutData(rabbitMQQueueNameData);
		rabbitMQQueueName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQQueueName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, rabbitMQQueueName.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		rabbitMQQueueName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQQueueName.getText()));
				}
			}
		});
		EditingUtils.setID(rabbitMQQueueName, EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName);
		EditingUtils.setEEFtype(rabbitMQQueueName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRabbitMQQueueNameText

		// End of user code
		return parent;
	}

	
	protected Composite createRabbitMQExchangeNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName, EsbMessages.MessageStorePropertiesEditionPart_RabbitMQExchangeNameLabel);
		rabbitMQExchangeName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		rabbitMQExchangeName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData rabbitMQExchangeNameData = new GridData(GridData.FILL_HORIZONTAL);
		rabbitMQExchangeName.setLayoutData(rabbitMQExchangeNameData);
		rabbitMQExchangeName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQExchangeName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, rabbitMQExchangeName.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		rabbitMQExchangeName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQExchangeName.getText()));
				}
			}
		});
		EditingUtils.setID(rabbitMQExchangeName, EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName);
		EditingUtils.setEEFtype(rabbitMQExchangeName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRabbitMQExchangeNameText

		// End of user code
		return parent;
	}

	
	protected Composite createRoutingKeyText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.routingKey, EsbMessages.MessageStorePropertiesEditionPart_RoutingKeyLabel);
		routingKey = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		routingKey.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData routingKeyData = new GridData(GridData.FILL_HORIZONTAL);
		routingKey.setLayoutData(routingKeyData);
		routingKey.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.routingKey,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, routingKey.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.routingKey,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, routingKey.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		routingKey.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.routingKey, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, routingKey.getText()));
				}
			}
		});
		EditingUtils.setID(routingKey, EsbViewsRepository.MessageStore.Properties.routingKey);
		EditingUtils.setEEFtype(routingKey, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.routingKey, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRoutingKeyText

		// End of user code
		return parent;
	}

	
	protected Composite createRabbitMQUserNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.rabbitMQUserName, EsbMessages.MessageStorePropertiesEditionPart_RabbitMQUserNameLabel);
		rabbitMQUserName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		rabbitMQUserName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData rabbitMQUserNameData = new GridData(GridData.FILL_HORIZONTAL);
		rabbitMQUserName.setLayoutData(rabbitMQUserNameData);
		rabbitMQUserName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.rabbitMQUserName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQUserName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.rabbitMQUserName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, rabbitMQUserName.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		rabbitMQUserName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.rabbitMQUserName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQUserName.getText()));
				}
			}
		});
		EditingUtils.setID(rabbitMQUserName, EsbViewsRepository.MessageStore.Properties.rabbitMQUserName);
		EditingUtils.setEEFtype(rabbitMQUserName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.rabbitMQUserName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRabbitMQUserNameText

		// End of user code
		return parent;
	}

	
	protected Composite createRabbitMQPasswordText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.rabbitMQPassword, EsbMessages.MessageStorePropertiesEditionPart_RabbitMQPasswordLabel);
		rabbitMQPassword = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		rabbitMQPassword.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData rabbitMQPasswordData = new GridData(GridData.FILL_HORIZONTAL);
		rabbitMQPassword.setLayoutData(rabbitMQPasswordData);
		rabbitMQPassword.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.rabbitMQPassword,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQPassword.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.rabbitMQPassword,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, rabbitMQPassword.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		rabbitMQPassword.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.rabbitMQPassword, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, rabbitMQPassword.getText()));
				}
			}
		});
		EditingUtils.setID(rabbitMQPassword, EsbViewsRepository.MessageStore.Properties.rabbitMQPassword);
		EditingUtils.setEEFtype(rabbitMQPassword, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.rabbitMQPassword, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRabbitMQPasswordText

		// End of user code
		return parent;
	}

	
	protected Composite createVirtualHostText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.virtualHost, EsbMessages.MessageStorePropertiesEditionPart_VirtualHostLabel);
		virtualHost = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		virtualHost.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData virtualHostData = new GridData(GridData.FILL_HORIZONTAL);
		virtualHost.setLayoutData(virtualHostData);
		virtualHost.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.virtualHost,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, virtualHost.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.virtualHost,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, virtualHost.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		virtualHost.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.virtualHost, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, virtualHost.getText()));
				}
			}
		});
		EditingUtils.setID(virtualHost, EsbViewsRepository.MessageStore.Properties.virtualHost);
		EditingUtils.setEEFtype(virtualHost, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.virtualHost, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createVirtualHostText

		// End of user code
		return parent;
	}

	
	protected Composite createJdbcDatabaseTableText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable, EsbMessages.MessageStorePropertiesEditionPart_JdbcDatabaseTableLabel);
		jdbcDatabaseTable = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		jdbcDatabaseTable.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData jdbcDatabaseTableData = new GridData(GridData.FILL_HORIZONTAL);
		jdbcDatabaseTable.setLayoutData(jdbcDatabaseTableData);
		jdbcDatabaseTable.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcDatabaseTable.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, jdbcDatabaseTable.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		jdbcDatabaseTable.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcDatabaseTable.getText()));
				}
			}
		});
		EditingUtils.setID(jdbcDatabaseTable, EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable);
		EditingUtils.setEEFtype(jdbcDatabaseTable, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createJdbcDatabaseTableText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createJdbcConnectionInformationEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation, EsbMessages.MessageStorePropertiesEditionPart_JdbcConnectionInformationLabel);
		jdbcConnectionInformation = new EMFComboViewer(parent);
		jdbcConnectionInformation.setContentProvider(new ArrayContentProvider());
		jdbcConnectionInformation.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData jdbcConnectionInformationData = new GridData(GridData.FILL_HORIZONTAL);
		jdbcConnectionInformation.getCombo().setLayoutData(jdbcConnectionInformationData);
                jdbcConnectionInformation.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		jdbcConnectionInformation.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getJdbcConnectionInformation()));
			}

		});
		jdbcConnectionInformation.setID(EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createJdbcConnectionInformationEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createJdbcDriverText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.jdbcDriver, EsbMessages.MessageStorePropertiesEditionPart_JdbcDriverLabel);
		jdbcDriver = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		jdbcDriver.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData jdbcDriverData = new GridData(GridData.FILL_HORIZONTAL);
		jdbcDriver.setLayoutData(jdbcDriverData);
		jdbcDriver.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.jdbcDriver,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcDriver.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.jdbcDriver,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, jdbcDriver.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		jdbcDriver.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.jdbcDriver, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcDriver.getText()));
				}
			}
		});
		EditingUtils.setID(jdbcDriver, EsbViewsRepository.MessageStore.Properties.jdbcDriver);
		EditingUtils.setEEFtype(jdbcDriver, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.jdbcDriver, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createJdbcDriverText

		// End of user code
		return parent;
	}

	
	protected Composite createJdbcURLText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.jdbcURL, EsbMessages.MessageStorePropertiesEditionPart_JdbcURLLabel);
		jdbcURL = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		jdbcURL.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData jdbcURLData = new GridData(GridData.FILL_HORIZONTAL);
		jdbcURL.setLayoutData(jdbcURLData);
		jdbcURL.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.jdbcURL,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcURL.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.jdbcURL,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, jdbcURL.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		jdbcURL.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.jdbcURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcURL.getText()));
				}
			}
		});
		EditingUtils.setID(jdbcURL, EsbViewsRepository.MessageStore.Properties.jdbcURL);
		EditingUtils.setEEFtype(jdbcURL, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.jdbcURL, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createJdbcURLText

		// End of user code
		return parent;
	}

	
	protected Composite createJdbcUserText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.jdbcUser, EsbMessages.MessageStorePropertiesEditionPart_JdbcUserLabel);
		jdbcUser = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		jdbcUser.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData jdbcUserData = new GridData(GridData.FILL_HORIZONTAL);
		jdbcUser.setLayoutData(jdbcUserData);
		jdbcUser.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.jdbcUser,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcUser.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.jdbcUser,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, jdbcUser.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		jdbcUser.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.jdbcUser, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcUser.getText()));
				}
			}
		});
		EditingUtils.setID(jdbcUser, EsbViewsRepository.MessageStore.Properties.jdbcUser);
		EditingUtils.setEEFtype(jdbcUser, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.jdbcUser, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createJdbcUserText

		// End of user code
		return parent;
	}

	
	protected Composite createJdbcPasswordText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.jdbcPassword, EsbMessages.MessageStorePropertiesEditionPart_JdbcPasswordLabel);
		jdbcPassword = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		jdbcPassword.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData jdbcPasswordData = new GridData(GridData.FILL_HORIZONTAL);
		jdbcPassword.setLayoutData(jdbcPasswordData);
		jdbcPassword.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.jdbcPassword,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcPassword.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.jdbcPassword,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, jdbcPassword.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		jdbcPassword.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.jdbcPassword, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcPassword.getText()));
				}
			}
		});
		EditingUtils.setID(jdbcPassword, EsbViewsRepository.MessageStore.Properties.jdbcPassword);
		EditingUtils.setEEFtype(jdbcPassword, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.jdbcPassword, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createJdbcPasswordText

		// End of user code
		return parent;
	}

	
	protected Composite createJdbcDatasourceNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName, EsbMessages.MessageStorePropertiesEditionPart_JdbcDatasourceNameLabel);
		jdbcDatasourceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		jdbcDatasourceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData jdbcDatasourceNameData = new GridData(GridData.FILL_HORIZONTAL);
		jdbcDatasourceName.setLayoutData(jdbcDatasourceNameData);
		jdbcDatasourceName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcDatasourceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, jdbcDatasourceName.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		jdbcDatasourceName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jdbcDatasourceName.getText()));
				}
			}
		});
		EditingUtils.setID(jdbcDatasourceName, EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName);
		EditingUtils.setEEFtype(jdbcDatasourceName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createJdbcDatasourceNameText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createParametersTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.parameters = new ReferencesTable(getDescription(EsbViewsRepository.MessageStore.Properties.parameters, EsbMessages.MessageStorePropertiesEditionPart_ParametersLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				parameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				parameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				parameters.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				parameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.parametersFilters) {
			this.parameters.addFilter(filter);
		}
		this.parameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.parameters, EsbViewsRepository.FORM_KIND));
		this.parameters.createControls(parent, widgetFactory);
		this.parameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.parameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData parametersData = new GridData(GridData.FILL_HORIZONTAL);
		parametersData.horizontalSpan = 3;
		this.parameters.setLayoutData(parametersData);
		this.parameters.setLowerBound(0);
		this.parameters.setUpperBound(-1);
		parameters.setID(EsbViewsRepository.MessageStore.Properties.parameters);
		parameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createParametersTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createEnableProducerGuaranteedDeliveryCheckbox(FormToolkit widgetFactory, Composite parent) {
		enableProducerGuaranteedDelivery = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery, EsbMessages.MessageStorePropertiesEditionPart_EnableProducerGuaranteedDeliveryLabel), SWT.CHECK);
		enableProducerGuaranteedDelivery.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(enableProducerGuaranteedDelivery.getSelection())));
			}

		});
		GridData enableProducerGuaranteedDeliveryData = new GridData(GridData.FILL_HORIZONTAL);
		enableProducerGuaranteedDeliveryData.horizontalSpan = 2;
		enableProducerGuaranteedDelivery.setLayoutData(enableProducerGuaranteedDeliveryData);
		EditingUtils.setID(enableProducerGuaranteedDelivery, EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery);
		EditingUtils.setEEFtype(enableProducerGuaranteedDelivery, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEnableProducerGuaranteedDeliveryCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createFailoverMessageStoreText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.failoverMessageStore, EsbMessages.MessageStorePropertiesEditionPart_FailoverMessageStoreLabel);
		failoverMessageStore = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		failoverMessageStore.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData failoverMessageStoreData = new GridData(GridData.FILL_HORIZONTAL);
		failoverMessageStore.setLayoutData(failoverMessageStoreData);
		failoverMessageStore.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.failoverMessageStore,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failoverMessageStore.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.failoverMessageStore,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, failoverMessageStore.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		failoverMessageStore.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.failoverMessageStore, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, failoverMessageStore.getText()));
				}
			}
		});
		EditingUtils.setID(failoverMessageStore, EsbViewsRepository.MessageStore.Properties.failoverMessageStore);
		EditingUtils.setEEFtype(failoverMessageStore, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.failoverMessageStore, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFailoverMessageStoreText

		// End of user code
		return parent;
	}

	
	protected Composite createResequencepollingText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.resequencepolling, EsbMessages.MessageStorePropertiesEditionPart_ResequencepollingLabel);
		resequencepolling = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		resequencepolling.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData resequencepollingData = new GridData(GridData.FILL_HORIZONTAL);
		resequencepolling.setLayoutData(resequencepollingData);
		resequencepolling.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.resequencepolling,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequencepolling.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.resequencepolling,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, resequencepolling.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		resequencepolling.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.resequencepolling, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequencepolling.getText()));
				}
			}
		});
		EditingUtils.setID(resequencepolling, EsbViewsRepository.MessageStore.Properties.resequencepolling);
		EditingUtils.setEEFtype(resequencepolling, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.resequencepolling, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResequencepollingText

		// End of user code
		return parent;
	}

	
	protected Composite createResequenceDatabaseTableText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable, EsbMessages.MessageStorePropertiesEditionPart_ResequenceDatabaseTableLabel);
		resequenceDatabaseTable = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		resequenceDatabaseTable.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData resequenceDatabaseTableData = new GridData(GridData.FILL_HORIZONTAL);
		resequenceDatabaseTable.setLayoutData(resequenceDatabaseTableData);
		resequenceDatabaseTable.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceDatabaseTable.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, resequenceDatabaseTable.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		resequenceDatabaseTable.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceDatabaseTable.getText()));
				}
			}
		});
		EditingUtils.setID(resequenceDatabaseTable, EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable);
		EditingUtils.setEEFtype(resequenceDatabaseTable, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResequenceDatabaseTableText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createResequenceConnectionInformationEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation, EsbMessages.MessageStorePropertiesEditionPart_ResequenceConnectionInformationLabel);
		resequenceConnectionInformation = new EMFComboViewer(parent);
		resequenceConnectionInformation.setContentProvider(new ArrayContentProvider());
		resequenceConnectionInformation.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData resequenceConnectionInformationData = new GridData(GridData.FILL_HORIZONTAL);
		resequenceConnectionInformation.getCombo().setLayoutData(resequenceConnectionInformationData);
                resequenceConnectionInformation.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		resequenceConnectionInformation.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getResequenceConnectionInformation()));
			}

		});
		resequenceConnectionInformation.setID(EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResequenceConnectionInformationEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createResequenceDriverText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.resequenceDriver, EsbMessages.MessageStorePropertiesEditionPart_ResequenceDriverLabel);
		resequenceDriver = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		resequenceDriver.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData resequenceDriverData = new GridData(GridData.FILL_HORIZONTAL);
		resequenceDriver.setLayoutData(resequenceDriverData);
		resequenceDriver.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.resequenceDriver,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceDriver.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.resequenceDriver,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, resequenceDriver.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		resequenceDriver.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.resequenceDriver, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceDriver.getText()));
				}
			}
		});
		EditingUtils.setID(resequenceDriver, EsbViewsRepository.MessageStore.Properties.resequenceDriver);
		EditingUtils.setEEFtype(resequenceDriver, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.resequenceDriver, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResequenceDriverText

		// End of user code
		return parent;
	}

	
	protected Composite createResequenceURLText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.resequenceURL, EsbMessages.MessageStorePropertiesEditionPart_ResequenceURLLabel);
		resequenceURL = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		resequenceURL.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData resequenceURLData = new GridData(GridData.FILL_HORIZONTAL);
		resequenceURL.setLayoutData(resequenceURLData);
		resequenceURL.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.resequenceURL,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceURL.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.resequenceURL,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, resequenceURL.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		resequenceURL.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.resequenceURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceURL.getText()));
				}
			}
		});
		EditingUtils.setID(resequenceURL, EsbViewsRepository.MessageStore.Properties.resequenceURL);
		EditingUtils.setEEFtype(resequenceURL, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.resequenceURL, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResequenceURLText

		// End of user code
		return parent;
	}

	
	protected Composite createResequenceUserText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.resequenceUser, EsbMessages.MessageStorePropertiesEditionPart_ResequenceUserLabel);
		resequenceUser = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		resequenceUser.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData resequenceUserData = new GridData(GridData.FILL_HORIZONTAL);
		resequenceUser.setLayoutData(resequenceUserData);
		resequenceUser.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.resequenceUser,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceUser.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.resequenceUser,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, resequenceUser.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		resequenceUser.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.resequenceUser, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceUser.getText()));
				}
			}
		});
		EditingUtils.setID(resequenceUser, EsbViewsRepository.MessageStore.Properties.resequenceUser);
		EditingUtils.setEEFtype(resequenceUser, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.resequenceUser, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResequenceUserText

		// End of user code
		return parent;
	}

	
	protected Composite createResequencePasswordText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.resequencePassword, EsbMessages.MessageStorePropertiesEditionPart_ResequencePasswordLabel);
		resequencePassword = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		resequencePassword.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData resequencePasswordData = new GridData(GridData.FILL_HORIZONTAL);
		resequencePassword.setLayoutData(resequencePasswordData);
		resequencePassword.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.resequencePassword,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequencePassword.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.resequencePassword,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, resequencePassword.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		resequencePassword.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.resequencePassword, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequencePassword.getText()));
				}
			}
		});
		EditingUtils.setID(resequencePassword, EsbViewsRepository.MessageStore.Properties.resequencePassword);
		EditingUtils.setEEFtype(resequencePassword, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.resequencePassword, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResequencePasswordText

		// End of user code
		return parent;
	}

	
	protected Composite createResequenceDatasourceNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName, EsbMessages.MessageStorePropertiesEditionPart_ResequenceDatasourceNameLabel);
		resequenceDatasourceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		resequenceDatasourceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData resequenceDatasourceNameData = new GridData(GridData.FILL_HORIZONTAL);
		resequenceDatasourceName.setLayoutData(resequenceDatasourceNameData);
		resequenceDatasourceName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceDatasourceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, resequenceDatasourceName.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		resequenceDatasourceName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceDatasourceName.getText()));
				}
			}
		});
		EditingUtils.setID(resequenceDatasourceName, EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName);
		EditingUtils.setEEFtype(resequenceDatasourceName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResequenceDatasourceNameText

		// End of user code
		return parent;
	}

	
	protected Composite createResequenceXpathText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.resequenceXpath, EsbMessages.MessageStorePropertiesEditionPart_ResequenceXpathLabel);
		resequenceXpath = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		resequenceXpath.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData resequenceXpathData = new GridData(GridData.FILL_HORIZONTAL);
		resequenceXpath.setLayoutData(resequenceXpathData);
		resequenceXpath.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageStorePropertiesEditionPartForm.this,
							EsbViewsRepository.MessageStore.Properties.resequenceXpath,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceXpath.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageStorePropertiesEditionPartForm.this,
									EsbViewsRepository.MessageStore.Properties.resequenceXpath,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, resequenceXpath.getText()));
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
									MessageStorePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		resequenceXpath.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.resequenceXpath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resequenceXpath.getText()));
				}
			}
		});
		EditingUtils.setID(resequenceXpath, EsbViewsRepository.MessageStore.Properties.resequenceXpath);
		EditingUtils.setEEFtype(resequenceXpath, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.resequenceXpath, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResequenceXpathText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createResequenceXpathAttrFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr, EsbMessages.MessageStorePropertiesEditionPart_ResequenceXpathAttrLabel);
		resequenceXpathAttr = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr, EsbViewsRepository.FORM_KIND));
		widgetFactory.adapt(resequenceXpathAttr);
		resequenceXpathAttr.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData resequenceXpathAttrData = new GridData(GridData.FILL_HORIZONTAL);
		resequenceXpathAttr.setLayoutData(resequenceXpathAttrData);
		resequenceXpathAttr.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageStorePropertiesEditionPartForm.this, EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getResequenceXpathAttr()));
			}

		});
		resequenceXpathAttr.setID(EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResequenceXpathAttrFlatComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.MessageStore_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getStoreName()
	 * 
	 */
	public String getStoreName() {
		return storeName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setStoreName(String newValue)
	 * 
	 */
	public void setStoreName(String newValue) {
		if (newValue != null) {
			storeName.setText(newValue);
		} else {
			storeName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.storeName);
		if (eefElementEditorReadOnlyState && storeName.isEnabled()) {
			storeName.setEnabled(false);
			storeName.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !storeName.isEnabled()) {
			storeName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getStoreType()
	 * 
	 */
	public Enumerator getStoreType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) storeType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#initStoreType(Object input, Enumerator current)
	 */
	public void initStoreType(Object input, Enumerator current) {
		storeType.setInput(input);
		storeType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.storeType);
		if (eefElementEditorReadOnlyState && storeType.isEnabled()) {
			storeType.setEnabled(false);
			storeType.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !storeType.isEnabled()) {
			storeType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setStoreType(Enumerator newValue)
	 * 
	 */
	public void setStoreType(Enumerator newValue) {
		storeType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.storeType);
		if (eefElementEditorReadOnlyState && storeType.isEnabled()) {
			storeType.setEnabled(false);
			storeType.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !storeType.isEnabled()) {
			storeType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getInitialContextFactory()
	 * 
	 */
	public String getInitialContextFactory() {
		return initialContextFactory.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setInitialContextFactory(String newValue)
	 * 
	 */
	public void setInitialContextFactory(String newValue) {
		if (newValue != null) {
			initialContextFactory.setText(newValue);
		} else {
			initialContextFactory.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.initialContextFactory);
		if (eefElementEditorReadOnlyState && initialContextFactory.isEnabled()) {
			initialContextFactory.setEnabled(false);
			initialContextFactory.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !initialContextFactory.isEnabled()) {
			initialContextFactory.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getProviderURL()
	 * 
	 */
	public String getProviderURL() {
		return providerURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setProviderURL(String newValue)
	 * 
	 */
	public void setProviderURL(String newValue) {
		if (newValue != null) {
			providerURL.setText(newValue);
		} else {
			providerURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.providerURL);
		if (eefElementEditorReadOnlyState && providerURL.isEnabled()) {
			providerURL.setEnabled(false);
			providerURL.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !providerURL.isEnabled()) {
			providerURL.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getJndiQueueName()
	 * 
	 */
	public String getJndiQueueName() {
		return jndiQueueName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setJndiQueueName(String newValue)
	 * 
	 */
	public void setJndiQueueName(String newValue) {
		if (newValue != null) {
			jndiQueueName.setText(newValue);
		} else {
			jndiQueueName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.jndiQueueName);
		if (eefElementEditorReadOnlyState && jndiQueueName.isEnabled()) {
			jndiQueueName.setEnabled(false);
			jndiQueueName.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jndiQueueName.isEnabled()) {
			jndiQueueName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getConnectionFactory()
	 * 
	 */
	public String getConnectionFactory() {
		return connectionFactory.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setConnectionFactory(String newValue)
	 * 
	 */
	public void setConnectionFactory(String newValue) {
		if (newValue != null) {
			connectionFactory.setText(newValue);
		} else {
			connectionFactory.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.connectionFactory);
		if (eefElementEditorReadOnlyState && connectionFactory.isEnabled()) {
			connectionFactory.setEnabled(false);
			connectionFactory.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionFactory.isEnabled()) {
			connectionFactory.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getUserName()
	 * 
	 */
	public String getUserName() {
		return userName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setUserName(String newValue)
	 * 
	 */
	public void setUserName(String newValue) {
		if (newValue != null) {
			userName.setText(newValue);
		} else {
			userName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.userName);
		if (eefElementEditorReadOnlyState && userName.isEnabled()) {
			userName.setEnabled(false);
			userName.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !userName.isEnabled()) {
			userName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getPassword()
	 * 
	 */
	public String getPassword() {
		return password.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setPassword(String newValue)
	 * 
	 */
	public void setPassword(String newValue) {
		if (newValue != null) {
			password.setText(newValue);
		} else {
			password.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.password);
		if (eefElementEditorReadOnlyState && password.isEnabled()) {
			password.setEnabled(false);
			password.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !password.isEnabled()) {
			password.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getCacheConnection()
	 * 
	 */
	public Boolean getCacheConnection() {
		return Boolean.valueOf(cacheConnection.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setCacheConnection(Boolean newValue)
	 * 
	 */
	public void setCacheConnection(Boolean newValue) {
		if (newValue != null) {
			cacheConnection.setSelection(newValue.booleanValue());
		} else {
			cacheConnection.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.cacheConnection);
		if (eefElementEditorReadOnlyState && cacheConnection.isEnabled()) {
			cacheConnection.setEnabled(false);
			cacheConnection.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cacheConnection.isEnabled()) {
			cacheConnection.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getJmsSpecVersion()
	 * 
	 */
	public Enumerator getJmsSpecVersion() {
		Enumerator selection = (Enumerator) ((StructuredSelection) jmsSpecVersion.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#initJmsSpecVersion(Object input, Enumerator current)
	 */
	public void initJmsSpecVersion(Object input, Enumerator current) {
		jmsSpecVersion.setInput(input);
		jmsSpecVersion.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.jmsSpecVersion);
		if (eefElementEditorReadOnlyState && jmsSpecVersion.isEnabled()) {
			jmsSpecVersion.setEnabled(false);
			jmsSpecVersion.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jmsSpecVersion.isEnabled()) {
			jmsSpecVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setJmsSpecVersion(Enumerator newValue)
	 * 
	 */
	public void setJmsSpecVersion(Enumerator newValue) {
		jmsSpecVersion.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.jmsSpecVersion);
		if (eefElementEditorReadOnlyState && jmsSpecVersion.isEnabled()) {
			jmsSpecVersion.setEnabled(false);
			jmsSpecVersion.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jmsSpecVersion.isEnabled()) {
			jmsSpecVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getEnableCaching()
	 * 
	 */
	public Boolean getEnableCaching() {
		return Boolean.valueOf(enableCaching.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setEnableCaching(Boolean newValue)
	 * 
	 */
	public void setEnableCaching(Boolean newValue) {
		if (newValue != null) {
			enableCaching.setSelection(newValue.booleanValue());
		} else {
			enableCaching.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.enableCaching);
		if (eefElementEditorReadOnlyState && enableCaching.isEnabled()) {
			enableCaching.setEnabled(false);
			enableCaching.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !enableCaching.isEnabled()) {
			enableCaching.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getProviderClass()
	 * 
	 */
	public String getProviderClass() {
		return providerClass.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setProviderClass(String newValue)
	 * 
	 */
	public void setProviderClass(String newValue) {
		if (newValue != null) {
			providerClass.setText(newValue);
		} else {
			providerClass.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.providerClass);
		if (eefElementEditorReadOnlyState && providerClass.isEnabled()) {
			providerClass.setEnabled(false);
			providerClass.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !providerClass.isEnabled()) {
			providerClass.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getRabbitMQServerHostName()
	 * 
	 */
	public String getRabbitMQServerHostName() {
		return rabbitMQServerHostName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setRabbitMQServerHostName(String newValue)
	 * 
	 */
	public void setRabbitMQServerHostName(String newValue) {
		if (newValue != null) {
			rabbitMQServerHostName.setText(newValue);
		} else {
			rabbitMQServerHostName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName);
		if (eefElementEditorReadOnlyState && rabbitMQServerHostName.isEnabled()) {
			rabbitMQServerHostName.setEnabled(false);
			rabbitMQServerHostName.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !rabbitMQServerHostName.isEnabled()) {
			rabbitMQServerHostName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getRabbitMQServerHostPort()
	 * 
	 */
	public String getRabbitMQServerHostPort() {
		return rabbitMQServerHostPort.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setRabbitMQServerHostPort(String newValue)
	 * 
	 */
	public void setRabbitMQServerHostPort(String newValue) {
		if (newValue != null) {
			rabbitMQServerHostPort.setText(newValue);
		} else {
			rabbitMQServerHostPort.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort);
		if (eefElementEditorReadOnlyState && rabbitMQServerHostPort.isEnabled()) {
			rabbitMQServerHostPort.setEnabled(false);
			rabbitMQServerHostPort.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !rabbitMQServerHostPort.isEnabled()) {
			rabbitMQServerHostPort.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getRabbitMQQueueName()
	 * 
	 */
	public String getRabbitMQQueueName() {
		return rabbitMQQueueName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setRabbitMQQueueName(String newValue)
	 * 
	 */
	public void setRabbitMQQueueName(String newValue) {
		if (newValue != null) {
			rabbitMQQueueName.setText(newValue);
		} else {
			rabbitMQQueueName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName);
		if (eefElementEditorReadOnlyState && rabbitMQQueueName.isEnabled()) {
			rabbitMQQueueName.setEnabled(false);
			rabbitMQQueueName.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !rabbitMQQueueName.isEnabled()) {
			rabbitMQQueueName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getRabbitMQExchangeName()
	 * 
	 */
	public String getRabbitMQExchangeName() {
		return rabbitMQExchangeName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setRabbitMQExchangeName(String newValue)
	 * 
	 */
	public void setRabbitMQExchangeName(String newValue) {
		if (newValue != null) {
			rabbitMQExchangeName.setText(newValue);
		} else {
			rabbitMQExchangeName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName);
		if (eefElementEditorReadOnlyState && rabbitMQExchangeName.isEnabled()) {
			rabbitMQExchangeName.setEnabled(false);
			rabbitMQExchangeName.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !rabbitMQExchangeName.isEnabled()) {
			rabbitMQExchangeName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getRoutingKey()
	 * 
	 */
	public String getRoutingKey() {
		return routingKey.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setRoutingKey(String newValue)
	 * 
	 */
	public void setRoutingKey(String newValue) {
		if (newValue != null) {
			routingKey.setText(newValue);
		} else {
			routingKey.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.routingKey);
		if (eefElementEditorReadOnlyState && routingKey.isEnabled()) {
			routingKey.setEnabled(false);
			routingKey.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !routingKey.isEnabled()) {
			routingKey.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getRabbitMQUserName()
	 * 
	 */
	public String getRabbitMQUserName() {
		return rabbitMQUserName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setRabbitMQUserName(String newValue)
	 * 
	 */
	public void setRabbitMQUserName(String newValue) {
		if (newValue != null) {
			rabbitMQUserName.setText(newValue);
		} else {
			rabbitMQUserName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.rabbitMQUserName);
		if (eefElementEditorReadOnlyState && rabbitMQUserName.isEnabled()) {
			rabbitMQUserName.setEnabled(false);
			rabbitMQUserName.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !rabbitMQUserName.isEnabled()) {
			rabbitMQUserName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getRabbitMQPassword()
	 * 
	 */
	public String getRabbitMQPassword() {
		return rabbitMQPassword.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setRabbitMQPassword(String newValue)
	 * 
	 */
	public void setRabbitMQPassword(String newValue) {
		if (newValue != null) {
			rabbitMQPassword.setText(newValue);
		} else {
			rabbitMQPassword.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.rabbitMQPassword);
		if (eefElementEditorReadOnlyState && rabbitMQPassword.isEnabled()) {
			rabbitMQPassword.setEnabled(false);
			rabbitMQPassword.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !rabbitMQPassword.isEnabled()) {
			rabbitMQPassword.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getVirtualHost()
	 * 
	 */
	public String getVirtualHost() {
		return virtualHost.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setVirtualHost(String newValue)
	 * 
	 */
	public void setVirtualHost(String newValue) {
		if (newValue != null) {
			virtualHost.setText(newValue);
		} else {
			virtualHost.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.virtualHost);
		if (eefElementEditorReadOnlyState && virtualHost.isEnabled()) {
			virtualHost.setEnabled(false);
			virtualHost.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !virtualHost.isEnabled()) {
			virtualHost.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getJdbcDatabaseTable()
	 * 
	 */
	public String getJdbcDatabaseTable() {
		return jdbcDatabaseTable.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setJdbcDatabaseTable(String newValue)
	 * 
	 */
	public void setJdbcDatabaseTable(String newValue) {
		if (newValue != null) {
			jdbcDatabaseTable.setText(newValue);
		} else {
			jdbcDatabaseTable.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable);
		if (eefElementEditorReadOnlyState && jdbcDatabaseTable.isEnabled()) {
			jdbcDatabaseTable.setEnabled(false);
			jdbcDatabaseTable.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jdbcDatabaseTable.isEnabled()) {
			jdbcDatabaseTable.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getJdbcConnectionInformation()
	 * 
	 */
	public Enumerator getJdbcConnectionInformation() {
		Enumerator selection = (Enumerator) ((StructuredSelection) jdbcConnectionInformation.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#initJdbcConnectionInformation(Object input, Enumerator current)
	 */
	public void initJdbcConnectionInformation(Object input, Enumerator current) {
		jdbcConnectionInformation.setInput(input);
		jdbcConnectionInformation.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation);
		if (eefElementEditorReadOnlyState && jdbcConnectionInformation.isEnabled()) {
			jdbcConnectionInformation.setEnabled(false);
			jdbcConnectionInformation.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jdbcConnectionInformation.isEnabled()) {
			jdbcConnectionInformation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setJdbcConnectionInformation(Enumerator newValue)
	 * 
	 */
	public void setJdbcConnectionInformation(Enumerator newValue) {
		jdbcConnectionInformation.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation);
		if (eefElementEditorReadOnlyState && jdbcConnectionInformation.isEnabled()) {
			jdbcConnectionInformation.setEnabled(false);
			jdbcConnectionInformation.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jdbcConnectionInformation.isEnabled()) {
			jdbcConnectionInformation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getJdbcDriver()
	 * 
	 */
	public String getJdbcDriver() {
		return jdbcDriver.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setJdbcDriver(String newValue)
	 * 
	 */
	public void setJdbcDriver(String newValue) {
		if (newValue != null) {
			jdbcDriver.setText(newValue);
		} else {
			jdbcDriver.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.jdbcDriver);
		if (eefElementEditorReadOnlyState && jdbcDriver.isEnabled()) {
			jdbcDriver.setEnabled(false);
			jdbcDriver.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jdbcDriver.isEnabled()) {
			jdbcDriver.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getJdbcURL()
	 * 
	 */
	public String getJdbcURL() {
		return jdbcURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setJdbcURL(String newValue)
	 * 
	 */
	public void setJdbcURL(String newValue) {
		if (newValue != null) {
			jdbcURL.setText(newValue);
		} else {
			jdbcURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.jdbcURL);
		if (eefElementEditorReadOnlyState && jdbcURL.isEnabled()) {
			jdbcURL.setEnabled(false);
			jdbcURL.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jdbcURL.isEnabled()) {
			jdbcURL.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getJdbcUser()
	 * 
	 */
	public String getJdbcUser() {
		return jdbcUser.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setJdbcUser(String newValue)
	 * 
	 */
	public void setJdbcUser(String newValue) {
		if (newValue != null) {
			jdbcUser.setText(newValue);
		} else {
			jdbcUser.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.jdbcUser);
		if (eefElementEditorReadOnlyState && jdbcUser.isEnabled()) {
			jdbcUser.setEnabled(false);
			jdbcUser.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jdbcUser.isEnabled()) {
			jdbcUser.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getJdbcPassword()
	 * 
	 */
	public String getJdbcPassword() {
		return jdbcPassword.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setJdbcPassword(String newValue)
	 * 
	 */
	public void setJdbcPassword(String newValue) {
		if (newValue != null) {
			jdbcPassword.setText(newValue);
		} else {
			jdbcPassword.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.jdbcPassword);
		if (eefElementEditorReadOnlyState && jdbcPassword.isEnabled()) {
			jdbcPassword.setEnabled(false);
			jdbcPassword.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jdbcPassword.isEnabled()) {
			jdbcPassword.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getJdbcDatasourceName()
	 * 
	 */
	public String getJdbcDatasourceName() {
		return jdbcDatasourceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setJdbcDatasourceName(String newValue)
	 * 
	 */
	public void setJdbcDatasourceName(String newValue) {
		if (newValue != null) {
			jdbcDatasourceName.setText(newValue);
		} else {
			jdbcDatasourceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName);
		if (eefElementEditorReadOnlyState && jdbcDatasourceName.isEnabled()) {
			jdbcDatasourceName.setEnabled(false);
			jdbcDatasourceName.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jdbcDatasourceName.isEnabled()) {
			jdbcDatasourceName.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#initParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		parameters.setContentProvider(contentProvider);
		parameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.parameters);
		if (eefElementEditorReadOnlyState && parameters.isEnabled()) {
			parameters.setEnabled(false);
			parameters.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameters.isEnabled()) {
			parameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#updateParameters()
	 * 
	 */
	public void updateParameters() {
	parameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#addFilterParameters(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#addBusinessFilterParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToParameters(ViewerFilter filter) {
		parametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#isContainedInParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInParametersTable(EObject element) {
		return ((ReferencesTableSettings)parameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getEnableProducerGuaranteedDelivery()
	 * 
	 */
	public Boolean getEnableProducerGuaranteedDelivery() {
		return Boolean.valueOf(enableProducerGuaranteedDelivery.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setEnableProducerGuaranteedDelivery(Boolean newValue)
	 * 
	 */
	public void setEnableProducerGuaranteedDelivery(Boolean newValue) {
		if (newValue != null) {
			enableProducerGuaranteedDelivery.setSelection(newValue.booleanValue());
		} else {
			enableProducerGuaranteedDelivery.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery);
		if (eefElementEditorReadOnlyState && enableProducerGuaranteedDelivery.isEnabled()) {
			enableProducerGuaranteedDelivery.setEnabled(false);
			enableProducerGuaranteedDelivery.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !enableProducerGuaranteedDelivery.isEnabled()) {
			enableProducerGuaranteedDelivery.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getFailoverMessageStore()
	 * 
	 */
	public String getFailoverMessageStore() {
		return failoverMessageStore.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setFailoverMessageStore(String newValue)
	 * 
	 */
	public void setFailoverMessageStore(String newValue) {
		if (newValue != null) {
			failoverMessageStore.setText(newValue);
		} else {
			failoverMessageStore.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.failoverMessageStore);
		if (eefElementEditorReadOnlyState && failoverMessageStore.isEnabled()) {
			failoverMessageStore.setEnabled(false);
			failoverMessageStore.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !failoverMessageStore.isEnabled()) {
			failoverMessageStore.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getResequencepolling()
	 * 
	 */
	public String getResequencepolling() {
		return resequencepolling.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setResequencepolling(String newValue)
	 * 
	 */
	public void setResequencepolling(String newValue) {
		if (newValue != null) {
			resequencepolling.setText(newValue);
		} else {
			resequencepolling.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequencepolling);
		if (eefElementEditorReadOnlyState && resequencepolling.isEnabled()) {
			resequencepolling.setEnabled(false);
			resequencepolling.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequencepolling.isEnabled()) {
			resequencepolling.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getResequenceDatabaseTable()
	 * 
	 */
	public String getResequenceDatabaseTable() {
		return resequenceDatabaseTable.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setResequenceDatabaseTable(String newValue)
	 * 
	 */
	public void setResequenceDatabaseTable(String newValue) {
		if (newValue != null) {
			resequenceDatabaseTable.setText(newValue);
		} else {
			resequenceDatabaseTable.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable);
		if (eefElementEditorReadOnlyState && resequenceDatabaseTable.isEnabled()) {
			resequenceDatabaseTable.setEnabled(false);
			resequenceDatabaseTable.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequenceDatabaseTable.isEnabled()) {
			resequenceDatabaseTable.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getResequenceConnectionInformation()
	 * 
	 */
	public Enumerator getResequenceConnectionInformation() {
		Enumerator selection = (Enumerator) ((StructuredSelection) resequenceConnectionInformation.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#initResequenceConnectionInformation(Object input, Enumerator current)
	 */
	public void initResequenceConnectionInformation(Object input, Enumerator current) {
		resequenceConnectionInformation.setInput(input);
		resequenceConnectionInformation.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation);
		if (eefElementEditorReadOnlyState && resequenceConnectionInformation.isEnabled()) {
			resequenceConnectionInformation.setEnabled(false);
			resequenceConnectionInformation.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequenceConnectionInformation.isEnabled()) {
			resequenceConnectionInformation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setResequenceConnectionInformation(Enumerator newValue)
	 * 
	 */
	public void setResequenceConnectionInformation(Enumerator newValue) {
		resequenceConnectionInformation.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation);
		if (eefElementEditorReadOnlyState && resequenceConnectionInformation.isEnabled()) {
			resequenceConnectionInformation.setEnabled(false);
			resequenceConnectionInformation.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequenceConnectionInformation.isEnabled()) {
			resequenceConnectionInformation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getResequenceDriver()
	 * 
	 */
	public String getResequenceDriver() {
		return resequenceDriver.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setResequenceDriver(String newValue)
	 * 
	 */
	public void setResequenceDriver(String newValue) {
		if (newValue != null) {
			resequenceDriver.setText(newValue);
		} else {
			resequenceDriver.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequenceDriver);
		if (eefElementEditorReadOnlyState && resequenceDriver.isEnabled()) {
			resequenceDriver.setEnabled(false);
			resequenceDriver.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequenceDriver.isEnabled()) {
			resequenceDriver.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getResequenceURL()
	 * 
	 */
	public String getResequenceURL() {
		return resequenceURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setResequenceURL(String newValue)
	 * 
	 */
	public void setResequenceURL(String newValue) {
		if (newValue != null) {
			resequenceURL.setText(newValue);
		} else {
			resequenceURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequenceURL);
		if (eefElementEditorReadOnlyState && resequenceURL.isEnabled()) {
			resequenceURL.setEnabled(false);
			resequenceURL.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequenceURL.isEnabled()) {
			resequenceURL.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getResequenceUser()
	 * 
	 */
	public String getResequenceUser() {
		return resequenceUser.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setResequenceUser(String newValue)
	 * 
	 */
	public void setResequenceUser(String newValue) {
		if (newValue != null) {
			resequenceUser.setText(newValue);
		} else {
			resequenceUser.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequenceUser);
		if (eefElementEditorReadOnlyState && resequenceUser.isEnabled()) {
			resequenceUser.setEnabled(false);
			resequenceUser.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequenceUser.isEnabled()) {
			resequenceUser.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getResequencePassword()
	 * 
	 */
	public String getResequencePassword() {
		return resequencePassword.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setResequencePassword(String newValue)
	 * 
	 */
	public void setResequencePassword(String newValue) {
		if (newValue != null) {
			resequencePassword.setText(newValue);
		} else {
			resequencePassword.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequencePassword);
		if (eefElementEditorReadOnlyState && resequencePassword.isEnabled()) {
			resequencePassword.setEnabled(false);
			resequencePassword.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequencePassword.isEnabled()) {
			resequencePassword.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getResequenceDatasourceName()
	 * 
	 */
	public String getResequenceDatasourceName() {
		return resequenceDatasourceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setResequenceDatasourceName(String newValue)
	 * 
	 */
	public void setResequenceDatasourceName(String newValue) {
		if (newValue != null) {
			resequenceDatasourceName.setText(newValue);
		} else {
			resequenceDatasourceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName);
		if (eefElementEditorReadOnlyState && resequenceDatasourceName.isEnabled()) {
			resequenceDatasourceName.setEnabled(false);
			resequenceDatasourceName.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequenceDatasourceName.isEnabled()) {
			resequenceDatasourceName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getResequenceXpath()
	 * 
	 */
	public String getResequenceXpath() {
		return resequenceXpath.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setResequenceXpath(String newValue)
	 * 
	 */
	public void setResequenceXpath(String newValue) {
		if (newValue != null) {
			resequenceXpath.setText(newValue);
		} else {
			resequenceXpath.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequenceXpath);
		if (eefElementEditorReadOnlyState && resequenceXpath.isEnabled()) {
			resequenceXpath.setEnabled(false);
			resequenceXpath.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequenceXpath.isEnabled()) {
			resequenceXpath.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#getResequenceXpathAttr()
	 * 
	 */
	public EObject getResequenceXpathAttr() {
		if (resequenceXpathAttr.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) resequenceXpathAttr.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#initResequenceXpathAttr(EObjectFlatComboSettings)
	 */
	public void initResequenceXpathAttr(EObjectFlatComboSettings settings) {
		resequenceXpathAttr.setInput(settings);
		if (current != null) {
			resequenceXpathAttr.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr);
		if (eefElementEditorReadOnlyState && resequenceXpathAttr.isEnabled()) {
			resequenceXpathAttr.setEnabled(false);
			resequenceXpathAttr.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequenceXpathAttr.isEnabled()) {
			resequenceXpathAttr.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setResequenceXpathAttr(EObject newValue)
	 * 
	 */
	public void setResequenceXpathAttr(EObject newValue) {
		if (newValue != null) {
			resequenceXpathAttr.setSelection(new StructuredSelection(newValue));
		} else {
			resequenceXpathAttr.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr);
		if (eefElementEditorReadOnlyState && resequenceXpathAttr.isEnabled()) {
			resequenceXpathAttr.setEnabled(false);
			resequenceXpathAttr.setToolTipText(EsbMessages.MessageStore_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resequenceXpathAttr.isEnabled()) {
			resequenceXpathAttr.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#setResequenceXpathAttrButtonMode(ButtonsModeEnum newValue)
	 */
	public void setResequenceXpathAttrButtonMode(ButtonsModeEnum newValue) {
		resequenceXpathAttr.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#addFilterResequenceXpathAttr(ViewerFilter filter)
	 * 
	 */
	public void addFilterToResequenceXpathAttr(ViewerFilter filter) {
		resequenceXpathAttr.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart#addBusinessFilterResequenceXpathAttr(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToResequenceXpathAttr(ViewerFilter filter) {
		resequenceXpathAttr.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.MessageStore_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
