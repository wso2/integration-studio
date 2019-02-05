/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.JDBCConnectionInformationType;
import org.wso2.developerstudio.eclipse.gmf.esb.JMSSpecVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStore;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.MessageStorePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class MessageStorePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for parameters ReferencesTable
	 */
	protected ReferencesTableSettings parametersSettings;
	
	/**
	 * Settings for resequenceXpathAttr EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings resequenceXpathAttrSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public MessageStorePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject messageStore, String editing_mode) {
		super(editingContext, messageStore, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.MessageStore.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final MessageStore messageStore = (MessageStore)elt;
			final MessageStorePropertiesEditionPart basePart = (MessageStorePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getDescription()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.commentsList))
				basePart.setCommentsList(messageStore.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.storeName))
				basePart.setStoreName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getStoreName()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.storeType)) {
				basePart.initStoreType(EEFUtils.choiceOfValues(messageStore, EsbPackage.eINSTANCE.getMessageStore_StoreType()), messageStore.getStoreType());
			}
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.initialContextFactory))
				basePart.setInitialContextFactory(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getInitialContextFactory()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.providerURL))
				basePart.setProviderURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getProviderURL()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.jndiQueueName))
				basePart.setJndiQueueName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getJndiQueueName()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.connectionFactory))
				basePart.setConnectionFactory(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getConnectionFactory()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.userName))
				basePart.setUserName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getUserName()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.password))
				basePart.setPassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getPassword()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.cacheConnection)) {
				basePart.setCacheConnection(messageStore.isCacheConnection());
			}
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.jmsSpecVersion)) {
				basePart.initJmsSpecVersion(EEFUtils.choiceOfValues(messageStore, EsbPackage.eINSTANCE.getMessageStore_JmsSpecVersion()), messageStore.getJmsSpecVersion());
			}
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.enableCaching)) {
				basePart.setEnableCaching(messageStore.isEnableCaching());
			}
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.providerClass))
				basePart.setProviderClass(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getProviderClass()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName))
				basePart.setRabbitMQServerHostName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getRabbitMQServerHostName()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort))
				basePart.setRabbitMQServerHostPort(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getRabbitMQServerHostPort()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName))
				basePart.setRabbitMQQueueName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getRabbitMQQueueName()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName))
				basePart.setRabbitMQExchangeName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getRabbitMQExchangeName()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.routingKey))
				basePart.setRoutingKey(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getRoutingKey()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQUserName))
				basePart.setRabbitMQUserName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getRabbitMQUserName()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQPassword))
				basePart.setRabbitMQPassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getRabbitMQPassword()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.virtualHost))
				basePart.setVirtualHost(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getVirtualHost()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable))
				basePart.setJdbcDatabaseTable(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getJdbcDatabaseTable()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation)) {
				basePart.initJdbcConnectionInformation(EEFUtils.choiceOfValues(messageStore, EsbPackage.eINSTANCE.getMessageStore_JdbcConnectionInformation()), messageStore.getJdbcConnectionInformation());
			}
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcDriver))
				basePart.setJdbcDriver(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getJdbcDriver()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcURL))
				basePart.setJdbcURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getJdbcURL()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcUser))
				basePart.setJdbcUser(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getJdbcUser()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcPassword))
				basePart.setJdbcPassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getJdbcPassword()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName))
				basePart.setJdbcDatasourceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getJdbcDatasourceName()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.parameters)) {
				parametersSettings = new ReferencesTableSettings(messageStore, EsbPackage.eINSTANCE.getMessageStore_Parameters());
				basePart.initParameters(parametersSettings);
			}
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery)) {
				basePart.setEnableProducerGuaranteedDelivery(messageStore.isEnableProducerGuaranteedDelivery());
			}
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.failoverMessageStore))
				basePart.setFailoverMessageStore(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getFailoverMessageStore()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.resequencepolling))
				basePart.setResequencepolling(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getResequencepolling()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable))
				basePart.setResequenceDatabaseTable(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getResequenceDatabaseTable()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation)) {
				basePart.initResequenceConnectionInformation(EEFUtils.choiceOfValues(messageStore, EsbPackage.eINSTANCE.getMessageStore_ResequenceConnectionInformation()), messageStore.getResequenceConnectionInformation());
			}
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceDriver))
				basePart.setResequenceDriver(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getResequenceDriver()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceURL))
				basePart.setResequenceURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getResequenceURL()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceUser))
				basePart.setResequenceUser(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getResequenceUser()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.resequencePassword))
				basePart.setResequencePassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getResequencePassword()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName))
				basePart.setResequenceDatasourceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getResequenceDatasourceName()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceXpath))
				basePart.setResequenceXpath(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, messageStore.getResequenceXpath()));
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr)) {
				// init part
				resequenceXpathAttrSettings = new EObjectFlatComboSettings(messageStore, EsbPackage.eINSTANCE.getMessageStore_ResequenceXpathAttr());
				basePart.initResequenceXpathAttr(resequenceXpathAttrSettings);
				// set the button mode
				basePart.setResequenceXpathAttrButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.parameters)) {
				basePart.addFilterToParameters(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof MessageStoreParameter); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for parameters
				// End of user code
			}
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr)) {
				basePart.addFilterToResequenceXpathAttr(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof NamespacedProperty); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for resequenceXpathAttr
				// End of user code
			}
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}













































	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EsbViewsRepository.MessageStore.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.storeName) {
			return EsbPackage.eINSTANCE.getMessageStore_StoreName();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.storeType) {
			return EsbPackage.eINSTANCE.getMessageStore_StoreType();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.initialContextFactory) {
			return EsbPackage.eINSTANCE.getMessageStore_InitialContextFactory();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.providerURL) {
			return EsbPackage.eINSTANCE.getMessageStore_ProviderURL();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.jndiQueueName) {
			return EsbPackage.eINSTANCE.getMessageStore_JndiQueueName();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.connectionFactory) {
			return EsbPackage.eINSTANCE.getMessageStore_ConnectionFactory();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.userName) {
			return EsbPackage.eINSTANCE.getMessageStore_UserName();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.password) {
			return EsbPackage.eINSTANCE.getMessageStore_Password();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.cacheConnection) {
			return EsbPackage.eINSTANCE.getMessageStore_CacheConnection();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.jmsSpecVersion) {
			return EsbPackage.eINSTANCE.getMessageStore_JmsSpecVersion();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.enableCaching) {
			return EsbPackage.eINSTANCE.getMessageStore_EnableCaching();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.providerClass) {
			return EsbPackage.eINSTANCE.getMessageStore_ProviderClass();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName) {
			return EsbPackage.eINSTANCE.getMessageStore_RabbitMQServerHostName();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort) {
			return EsbPackage.eINSTANCE.getMessageStore_RabbitMQServerHostPort();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName) {
			return EsbPackage.eINSTANCE.getMessageStore_RabbitMQQueueName();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName) {
			return EsbPackage.eINSTANCE.getMessageStore_RabbitMQExchangeName();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.routingKey) {
			return EsbPackage.eINSTANCE.getMessageStore_RoutingKey();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.rabbitMQUserName) {
			return EsbPackage.eINSTANCE.getMessageStore_RabbitMQUserName();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.rabbitMQPassword) {
			return EsbPackage.eINSTANCE.getMessageStore_RabbitMQPassword();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.virtualHost) {
			return EsbPackage.eINSTANCE.getMessageStore_VirtualHost();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable) {
			return EsbPackage.eINSTANCE.getMessageStore_JdbcDatabaseTable();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation) {
			return EsbPackage.eINSTANCE.getMessageStore_JdbcConnectionInformation();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.jdbcDriver) {
			return EsbPackage.eINSTANCE.getMessageStore_JdbcDriver();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.jdbcURL) {
			return EsbPackage.eINSTANCE.getMessageStore_JdbcURL();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.jdbcUser) {
			return EsbPackage.eINSTANCE.getMessageStore_JdbcUser();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.jdbcPassword) {
			return EsbPackage.eINSTANCE.getMessageStore_JdbcPassword();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName) {
			return EsbPackage.eINSTANCE.getMessageStore_JdbcDatasourceName();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.parameters) {
			return EsbPackage.eINSTANCE.getMessageStore_Parameters();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery) {
			return EsbPackage.eINSTANCE.getMessageStore_EnableProducerGuaranteedDelivery();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.failoverMessageStore) {
			return EsbPackage.eINSTANCE.getMessageStore_FailoverMessageStore();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.resequencepolling) {
			return EsbPackage.eINSTANCE.getMessageStore_Resequencepolling();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable) {
			return EsbPackage.eINSTANCE.getMessageStore_ResequenceDatabaseTable();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation) {
			return EsbPackage.eINSTANCE.getMessageStore_ResequenceConnectionInformation();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.resequenceDriver) {
			return EsbPackage.eINSTANCE.getMessageStore_ResequenceDriver();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.resequenceURL) {
			return EsbPackage.eINSTANCE.getMessageStore_ResequenceURL();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.resequenceUser) {
			return EsbPackage.eINSTANCE.getMessageStore_ResequenceUser();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.resequencePassword) {
			return EsbPackage.eINSTANCE.getMessageStore_ResequencePassword();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName) {
			return EsbPackage.eINSTANCE.getMessageStore_ResequenceDatasourceName();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.resequenceXpath) {
			return EsbPackage.eINSTANCE.getMessageStore_ResequenceXpath();
		}
		if (editorKey == EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr) {
			return EsbPackage.eINSTANCE.getMessageStore_ResequenceXpathAttr();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		MessageStore messageStore = (MessageStore)semanticObject;
		if (EsbViewsRepository.MessageStore.Properties.description == event.getAffectedEditor()) {
			messageStore.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				messageStore.getCommentsList().clear();
				messageStore.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.MessageStore.Properties.storeName == event.getAffectedEditor()) {
			messageStore.setStoreName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.storeType == event.getAffectedEditor()) {
			messageStore.setStoreType((MessageStoreType)event.getNewValue());
		}
		if (EsbViewsRepository.MessageStore.Properties.initialContextFactory == event.getAffectedEditor()) {
			messageStore.setInitialContextFactory((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.providerURL == event.getAffectedEditor()) {
			messageStore.setProviderURL((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.jndiQueueName == event.getAffectedEditor()) {
			messageStore.setJndiQueueName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.connectionFactory == event.getAffectedEditor()) {
			messageStore.setConnectionFactory((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.userName == event.getAffectedEditor()) {
			messageStore.setUserName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.password == event.getAffectedEditor()) {
			messageStore.setPassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.cacheConnection == event.getAffectedEditor()) {
			messageStore.setCacheConnection((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.MessageStore.Properties.jmsSpecVersion == event.getAffectedEditor()) {
			messageStore.setJmsSpecVersion((JMSSpecVersion)event.getNewValue());
		}
		if (EsbViewsRepository.MessageStore.Properties.enableCaching == event.getAffectedEditor()) {
			messageStore.setEnableCaching((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.MessageStore.Properties.providerClass == event.getAffectedEditor()) {
			messageStore.setProviderClass((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName == event.getAffectedEditor()) {
			messageStore.setRabbitMQServerHostName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort == event.getAffectedEditor()) {
			messageStore.setRabbitMQServerHostPort((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName == event.getAffectedEditor()) {
			messageStore.setRabbitMQQueueName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName == event.getAffectedEditor()) {
			messageStore.setRabbitMQExchangeName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.routingKey == event.getAffectedEditor()) {
			messageStore.setRoutingKey((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.rabbitMQUserName == event.getAffectedEditor()) {
			messageStore.setRabbitMQUserName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.rabbitMQPassword == event.getAffectedEditor()) {
			messageStore.setRabbitMQPassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.virtualHost == event.getAffectedEditor()) {
			messageStore.setVirtualHost((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable == event.getAffectedEditor()) {
			messageStore.setJdbcDatabaseTable((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation == event.getAffectedEditor()) {
			messageStore.setJdbcConnectionInformation((JDBCConnectionInformationType)event.getNewValue());
		}
		if (EsbViewsRepository.MessageStore.Properties.jdbcDriver == event.getAffectedEditor()) {
			messageStore.setJdbcDriver((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.jdbcURL == event.getAffectedEditor()) {
			messageStore.setJdbcURL((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.jdbcUser == event.getAffectedEditor()) {
			messageStore.setJdbcUser((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.jdbcPassword == event.getAffectedEditor()) {
			messageStore.setJdbcPassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName == event.getAffectedEditor()) {
			messageStore.setJdbcDatasourceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.parameters == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, parametersSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				parametersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				parametersSettings.move(event.getNewIndex(), (MessageStoreParameter) event.getNewValue());
			}
		}
		if (EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery == event.getAffectedEditor()) {
			messageStore.setEnableProducerGuaranteedDelivery((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.MessageStore.Properties.failoverMessageStore == event.getAffectedEditor()) {
			messageStore.setFailoverMessageStore((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.resequencepolling == event.getAffectedEditor()) {
			messageStore.setResequencepolling((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable == event.getAffectedEditor()) {
			messageStore.setResequenceDatabaseTable((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation == event.getAffectedEditor()) {
			messageStore.setResequenceConnectionInformation((JDBCConnectionInformationType)event.getNewValue());
		}
		if (EsbViewsRepository.MessageStore.Properties.resequenceDriver == event.getAffectedEditor()) {
			messageStore.setResequenceDriver((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.resequenceURL == event.getAffectedEditor()) {
			messageStore.setResequenceURL((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.resequenceUser == event.getAffectedEditor()) {
			messageStore.setResequenceUser((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.resequencePassword == event.getAffectedEditor()) {
			messageStore.setResequencePassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName == event.getAffectedEditor()) {
			messageStore.setResequenceDatasourceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.resequenceXpath == event.getAffectedEditor()) {
			messageStore.setResequenceXpath((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				resequenceXpathAttrSettings.setToReference((NamespacedProperty)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				NamespacedProperty eObject = EsbFactory.eINSTANCE.createNamespacedProperty();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				resequenceXpathAttrSettings.setToReference(eObject);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			MessageStorePropertiesEditionPart basePart = (MessageStorePropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.commentsList)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setCommentsList((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setCommentsList(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setCommentsList(newValueAsList);
				}
			}
			
			if (EsbPackage.eINSTANCE.getMessageStore_StoreName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.storeName)) {
				if (msg.getNewValue() != null) {
					basePart.setStoreName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setStoreName("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_StoreType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.MessageStore.Properties.storeType))
				basePart.setStoreType((MessageStoreType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getMessageStore_InitialContextFactory().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.initialContextFactory)) {
				if (msg.getNewValue() != null) {
					basePart.setInitialContextFactory(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInitialContextFactory("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_ProviderURL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.providerURL)) {
				if (msg.getNewValue() != null) {
					basePart.setProviderURL(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setProviderURL("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_JndiQueueName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.jndiQueueName)) {
				if (msg.getNewValue() != null) {
					basePart.setJndiQueueName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setJndiQueueName("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_ConnectionFactory().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.connectionFactory)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionFactory(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionFactory("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_UserName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.userName)) {
				if (msg.getNewValue() != null) {
					basePart.setUserName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setUserName("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_Password().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.password)) {
				if (msg.getNewValue() != null) {
					basePart.setPassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_CacheConnection().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.cacheConnection))
				basePart.setCacheConnection((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getMessageStore_JmsSpecVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.MessageStore.Properties.jmsSpecVersion))
				basePart.setJmsSpecVersion((JMSSpecVersion)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getMessageStore_EnableCaching().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.enableCaching))
				basePart.setEnableCaching((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getMessageStore_ProviderClass().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.providerClass)) {
				if (msg.getNewValue() != null) {
					basePart.setProviderClass(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setProviderClass("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_RabbitMQServerHostName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName)) {
				if (msg.getNewValue() != null) {
					basePart.setRabbitMQServerHostName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRabbitMQServerHostName("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_RabbitMQServerHostPort().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort)) {
				if (msg.getNewValue() != null) {
					basePart.setRabbitMQServerHostPort(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRabbitMQServerHostPort("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_RabbitMQQueueName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName)) {
				if (msg.getNewValue() != null) {
					basePart.setRabbitMQQueueName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRabbitMQQueueName("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_RabbitMQExchangeName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName)) {
				if (msg.getNewValue() != null) {
					basePart.setRabbitMQExchangeName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRabbitMQExchangeName("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_RoutingKey().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.routingKey)) {
				if (msg.getNewValue() != null) {
					basePart.setRoutingKey(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRoutingKey("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_RabbitMQUserName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQUserName)) {
				if (msg.getNewValue() != null) {
					basePart.setRabbitMQUserName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRabbitMQUserName("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_RabbitMQPassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.rabbitMQPassword)) {
				if (msg.getNewValue() != null) {
					basePart.setRabbitMQPassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRabbitMQPassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_VirtualHost().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.virtualHost)) {
				if (msg.getNewValue() != null) {
					basePart.setVirtualHost(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setVirtualHost("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_JdbcDatabaseTable().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable)) {
				if (msg.getNewValue() != null) {
					basePart.setJdbcDatabaseTable(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setJdbcDatabaseTable("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_JdbcConnectionInformation().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation))
				basePart.setJdbcConnectionInformation((JDBCConnectionInformationType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getMessageStore_JdbcDriver().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcDriver)) {
				if (msg.getNewValue() != null) {
					basePart.setJdbcDriver(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setJdbcDriver("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_JdbcURL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcURL)) {
				if (msg.getNewValue() != null) {
					basePart.setJdbcURL(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setJdbcURL("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_JdbcUser().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcUser)) {
				if (msg.getNewValue() != null) {
					basePart.setJdbcUser(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setJdbcUser("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_JdbcPassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcPassword)) {
				if (msg.getNewValue() != null) {
					basePart.setJdbcPassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setJdbcPassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_JdbcDatasourceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName)) {
				if (msg.getNewValue() != null) {
					basePart.setJdbcDatasourceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setJdbcDatasourceName("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_Parameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.MessageStore.Properties.parameters))
				basePart.updateParameters();
			if (EsbPackage.eINSTANCE.getMessageStore_EnableProducerGuaranteedDelivery().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery))
				basePart.setEnableProducerGuaranteedDelivery((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getMessageStore_FailoverMessageStore().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.failoverMessageStore)) {
				if (msg.getNewValue() != null) {
					basePart.setFailoverMessageStore(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFailoverMessageStore("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_Resequencepolling().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.resequencepolling)) {
				if (msg.getNewValue() != null) {
					basePart.setResequencepolling(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setResequencepolling("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_ResequenceDatabaseTable().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable)) {
				if (msg.getNewValue() != null) {
					basePart.setResequenceDatabaseTable(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setResequenceDatabaseTable("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_ResequenceConnectionInformation().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation))
				basePart.setResequenceConnectionInformation((JDBCConnectionInformationType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getMessageStore_ResequenceDriver().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceDriver)) {
				if (msg.getNewValue() != null) {
					basePart.setResequenceDriver(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setResequenceDriver("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_ResequenceURL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceURL)) {
				if (msg.getNewValue() != null) {
					basePart.setResequenceURL(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setResequenceURL("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_ResequenceUser().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceUser)) {
				if (msg.getNewValue() != null) {
					basePart.setResequenceUser(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setResequenceUser("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_ResequencePassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.resequencePassword)) {
				if (msg.getNewValue() != null) {
					basePart.setResequencePassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setResequencePassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_ResequenceDatasourceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName)) {
				if (msg.getNewValue() != null) {
					basePart.setResequenceDatasourceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setResequenceDatasourceName("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_ResequenceXpath().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceXpath)) {
				if (msg.getNewValue() != null) {
					basePart.setResequenceXpath(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setResequenceXpath("");
				}
			}
			if (EsbPackage.eINSTANCE.getMessageStore_ResequenceXpathAttr().equals(msg.getFeature()) && basePart != null && isAccessible(EsbViewsRepository.MessageStore.Properties.resequenceXpathAttr))
				basePart.setResequenceXpathAttr((EObject)msg.getNewValue());
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			EsbPackage.eINSTANCE.getEsbElement_Description(),
			EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
			EsbPackage.eINSTANCE.getMessageStore_StoreName(),
			EsbPackage.eINSTANCE.getMessageStore_StoreType(),
			EsbPackage.eINSTANCE.getMessageStore_InitialContextFactory(),
			EsbPackage.eINSTANCE.getMessageStore_ProviderURL(),
			EsbPackage.eINSTANCE.getMessageStore_JndiQueueName(),
			EsbPackage.eINSTANCE.getMessageStore_ConnectionFactory(),
			EsbPackage.eINSTANCE.getMessageStore_UserName(),
			EsbPackage.eINSTANCE.getMessageStore_Password(),
			EsbPackage.eINSTANCE.getMessageStore_CacheConnection(),
			EsbPackage.eINSTANCE.getMessageStore_JmsSpecVersion(),
			EsbPackage.eINSTANCE.getMessageStore_EnableCaching(),
			EsbPackage.eINSTANCE.getMessageStore_ProviderClass(),
			EsbPackage.eINSTANCE.getMessageStore_RabbitMQServerHostName(),
			EsbPackage.eINSTANCE.getMessageStore_RabbitMQServerHostPort(),
			EsbPackage.eINSTANCE.getMessageStore_RabbitMQQueueName(),
			EsbPackage.eINSTANCE.getMessageStore_RabbitMQExchangeName(),
			EsbPackage.eINSTANCE.getMessageStore_RoutingKey(),
			EsbPackage.eINSTANCE.getMessageStore_RabbitMQUserName(),
			EsbPackage.eINSTANCE.getMessageStore_RabbitMQPassword(),
			EsbPackage.eINSTANCE.getMessageStore_VirtualHost(),
			EsbPackage.eINSTANCE.getMessageStore_JdbcDatabaseTable(),
			EsbPackage.eINSTANCE.getMessageStore_JdbcConnectionInformation(),
			EsbPackage.eINSTANCE.getMessageStore_JdbcDriver(),
			EsbPackage.eINSTANCE.getMessageStore_JdbcURL(),
			EsbPackage.eINSTANCE.getMessageStore_JdbcUser(),
			EsbPackage.eINSTANCE.getMessageStore_JdbcPassword(),
			EsbPackage.eINSTANCE.getMessageStore_JdbcDatasourceName(),
			EsbPackage.eINSTANCE.getMessageStore_Parameters(),
			EsbPackage.eINSTANCE.getMessageStore_EnableProducerGuaranteedDelivery(),
			EsbPackage.eINSTANCE.getMessageStore_FailoverMessageStore(),
			EsbPackage.eINSTANCE.getMessageStore_Resequencepolling(),
			EsbPackage.eINSTANCE.getMessageStore_ResequenceDatabaseTable(),
			EsbPackage.eINSTANCE.getMessageStore_ResequenceConnectionInformation(),
			EsbPackage.eINSTANCE.getMessageStore_ResequenceDriver(),
			EsbPackage.eINSTANCE.getMessageStore_ResequenceURL(),
			EsbPackage.eINSTANCE.getMessageStore_ResequenceUser(),
			EsbPackage.eINSTANCE.getMessageStore_ResequencePassword(),
			EsbPackage.eINSTANCE.getMessageStore_ResequenceDatasourceName(),
			EsbPackage.eINSTANCE.getMessageStore_ResequenceXpath(),
			EsbPackage.eINSTANCE.getMessageStore_ResequenceXpathAttr()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EsbViewsRepository.MessageStore.Properties.storeName)
			return "Name"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.storeType)
			return "Message-Store Type"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.initialContextFactory)
			return "Initial Context Factory"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.providerURL)
			return "Provider URL"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.jndiQueueName)
			return "JNDI Queue Name"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.connectionFactory)
			return "Connection factory"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.userName)
			return "UserName"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.password)
			return "Password"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.jmsSpecVersion)
			return "JMS API specification Version"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.enableCaching)
			return "Enable Connection caching"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.providerClass)
			return "Provider Class"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName)
			return "RabbitMQ Server Host Name"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort)
			return "RabbitMQ Server Host Port"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName)
			return "RabbitMQ Queue Name"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName)
			return "RabbitMQ Exchange Name"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.routingKey)
			return "Routing Key"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQUserName)
			return "RabbitMQ User Name"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.rabbitMQPassword)
			return "RabbitMQ password"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.virtualHost)
			return "Virtual Host"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable)
			return "Database Table"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation)
			return "Connection Information"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.jdbcDriver)
			return "Driver"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.jdbcURL)
			return "URL"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.jdbcUser)
			return "User"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.jdbcPassword)
			return "Password"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName)
			return "Datasource Name"; //$NON-NLS-1$
		if (key == EsbViewsRepository.MessageStore.Properties.parameters)
			return "Message Store Parameters"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (EsbViewsRepository.MessageStore.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.MessageStore.Properties.storeName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_StoreName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_StoreName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.storeType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_StoreType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_StoreType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.initialContextFactory == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_InitialContextFactory().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_InitialContextFactory().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.providerURL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_ProviderURL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_ProviderURL().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.jndiQueueName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_JndiQueueName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_JndiQueueName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.connectionFactory == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_ConnectionFactory().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_ConnectionFactory().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.userName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_UserName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_UserName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.password == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_Password().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_Password().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.cacheConnection == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_CacheConnection().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_CacheConnection().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.jmsSpecVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_JmsSpecVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_JmsSpecVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.enableCaching == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_EnableCaching().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_EnableCaching().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.providerClass == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_ProviderClass().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_ProviderClass().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_RabbitMQServerHostName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_RabbitMQServerHostName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.rabbitMQServerHostPort == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_RabbitMQServerHostPort().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_RabbitMQServerHostPort().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.rabbitMQQueueName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_RabbitMQQueueName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_RabbitMQQueueName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.rabbitMQExchangeName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_RabbitMQExchangeName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_RabbitMQExchangeName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.routingKey == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_RoutingKey().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_RoutingKey().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.rabbitMQUserName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_RabbitMQUserName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_RabbitMQUserName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.rabbitMQPassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_RabbitMQPassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_RabbitMQPassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.virtualHost == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_VirtualHost().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_VirtualHost().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.jdbcDatabaseTable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_JdbcDatabaseTable().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_JdbcDatabaseTable().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.jdbcConnectionInformation == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_JdbcConnectionInformation().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_JdbcConnectionInformation().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.jdbcDriver == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_JdbcDriver().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_JdbcDriver().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.jdbcURL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_JdbcURL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_JdbcURL().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.jdbcUser == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_JdbcUser().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_JdbcUser().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.jdbcPassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_JdbcPassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_JdbcPassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.jdbcDatasourceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_JdbcDatasourceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_JdbcDatasourceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.enableProducerGuaranteedDelivery == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_EnableProducerGuaranteedDelivery().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_EnableProducerGuaranteedDelivery().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.failoverMessageStore == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_FailoverMessageStore().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_FailoverMessageStore().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.resequencepolling == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_Resequencepolling().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_Resequencepolling().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.resequenceDatabaseTable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_ResequenceDatabaseTable().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_ResequenceDatabaseTable().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.resequenceConnectionInformation == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_ResequenceConnectionInformation().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_ResequenceConnectionInformation().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.resequenceDriver == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_ResequenceDriver().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_ResequenceDriver().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.resequenceURL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_ResequenceURL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_ResequenceURL().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.resequenceUser == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_ResequenceUser().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_ResequenceUser().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.resequencePassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_ResequencePassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_ResequencePassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.resequenceDatasourceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_ResequenceDatasourceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_ResequenceDatasourceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MessageStore.Properties.resequenceXpath == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMessageStore_ResequenceXpath().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMessageStore_ResequenceXpath().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
