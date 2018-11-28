/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface MessageStorePropertiesEditionPart {

	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);


	/**
	 * @return the commentsList
	 * 
	 */
	public EList getCommentsList();

	/**
	 * Defines a new commentsList
	 * @param newValue the new commentsList to set
	 * 
	 */
	public void setCommentsList(EList newValue);

	/**
	 * Add a value to the commentsList multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToCommentsList(Object newValue);

	/**
	 * Remove a value to the commentsList multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToCommentsList(Object newValue);


	/**
	 * @return the storeName
	 * 
	 */
	public String getStoreName();

	/**
	 * Defines a new storeName
	 * @param newValue the new storeName to set
	 * 
	 */
	public void setStoreName(String newValue);


	/**
	 * @return the storeType
	 * 
	 */
	public Enumerator getStoreType();

	/**
	 * Init the storeType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initStoreType(Object input, Enumerator current);

	/**
	 * Defines a new storeType
	 * @param newValue the new storeType to set
	 * 
	 */
	public void setStoreType(Enumerator newValue);


	/**
	 * @return the initialContextFactory
	 * 
	 */
	public String getInitialContextFactory();

	/**
	 * Defines a new initialContextFactory
	 * @param newValue the new initialContextFactory to set
	 * 
	 */
	public void setInitialContextFactory(String newValue);


	/**
	 * @return the providerURL
	 * 
	 */
	public String getProviderURL();

	/**
	 * Defines a new providerURL
	 * @param newValue the new providerURL to set
	 * 
	 */
	public void setProviderURL(String newValue);


	/**
	 * @return the jndiQueueName
	 * 
	 */
	public String getJndiQueueName();

	/**
	 * Defines a new jndiQueueName
	 * @param newValue the new jndiQueueName to set
	 * 
	 */
	public void setJndiQueueName(String newValue);


	/**
	 * @return the connectionFactory
	 * 
	 */
	public String getConnectionFactory();

	/**
	 * Defines a new connectionFactory
	 * @param newValue the new connectionFactory to set
	 * 
	 */
	public void setConnectionFactory(String newValue);


	/**
	 * @return the userName
	 * 
	 */
	public String getUserName();

	/**
	 * Defines a new userName
	 * @param newValue the new userName to set
	 * 
	 */
	public void setUserName(String newValue);


	/**
	 * @return the password
	 * 
	 */
	public String getPassword();

	/**
	 * Defines a new password
	 * @param newValue the new password to set
	 * 
	 */
	public void setPassword(String newValue);


	/**
	 * @return the cacheConnection
	 * 
	 */
	public Boolean getCacheConnection();

	/**
	 * Defines a new cacheConnection
	 * @param newValue the new cacheConnection to set
	 * 
	 */
	public void setCacheConnection(Boolean newValue);


	/**
	 * @return the jmsSpecVersion
	 * 
	 */
	public Enumerator getJmsSpecVersion();

	/**
	 * Init the jmsSpecVersion
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initJmsSpecVersion(Object input, Enumerator current);

	/**
	 * Defines a new jmsSpecVersion
	 * @param newValue the new jmsSpecVersion to set
	 * 
	 */
	public void setJmsSpecVersion(Enumerator newValue);


	/**
	 * @return the enableCaching
	 * 
	 */
	public Boolean getEnableCaching();

	/**
	 * Defines a new enableCaching
	 * @param newValue the new enableCaching to set
	 * 
	 */
	public void setEnableCaching(Boolean newValue);


	/**
	 * @return the providerClass
	 * 
	 */
	public String getProviderClass();

	/**
	 * Defines a new providerClass
	 * @param newValue the new providerClass to set
	 * 
	 */
	public void setProviderClass(String newValue);


	/**
	 * @return the rabbitMQServerHostName
	 * 
	 */
	public String getRabbitMQServerHostName();

	/**
	 * Defines a new rabbitMQServerHostName
	 * @param newValue the new rabbitMQServerHostName to set
	 * 
	 */
	public void setRabbitMQServerHostName(String newValue);


	/**
	 * @return the rabbitMQServerHostPort
	 * 
	 */
	public String getRabbitMQServerHostPort();

	/**
	 * Defines a new rabbitMQServerHostPort
	 * @param newValue the new rabbitMQServerHostPort to set
	 * 
	 */
	public void setRabbitMQServerHostPort(String newValue);


	/**
	 * @return the rabbitMQQueueName
	 * 
	 */
	public String getRabbitMQQueueName();

	/**
	 * Defines a new rabbitMQQueueName
	 * @param newValue the new rabbitMQQueueName to set
	 * 
	 */
	public void setRabbitMQQueueName(String newValue);


	/**
	 * @return the rabbitMQExchangeName
	 * 
	 */
	public String getRabbitMQExchangeName();

	/**
	 * Defines a new rabbitMQExchangeName
	 * @param newValue the new rabbitMQExchangeName to set
	 * 
	 */
	public void setRabbitMQExchangeName(String newValue);


	/**
	 * @return the routingKey
	 * 
	 */
	public String getRoutingKey();

	/**
	 * Defines a new routingKey
	 * @param newValue the new routingKey to set
	 * 
	 */
	public void setRoutingKey(String newValue);


	/**
	 * @return the rabbitMQUserName
	 * 
	 */
	public String getRabbitMQUserName();

	/**
	 * Defines a new rabbitMQUserName
	 * @param newValue the new rabbitMQUserName to set
	 * 
	 */
	public void setRabbitMQUserName(String newValue);


	/**
	 * @return the rabbitMQPassword
	 * 
	 */
	public String getRabbitMQPassword();

	/**
	 * Defines a new rabbitMQPassword
	 * @param newValue the new rabbitMQPassword to set
	 * 
	 */
	public void setRabbitMQPassword(String newValue);


	/**
	 * @return the virtualHost
	 * 
	 */
	public String getVirtualHost();

	/**
	 * Defines a new virtualHost
	 * @param newValue the new virtualHost to set
	 * 
	 */
	public void setVirtualHost(String newValue);


	/**
	 * @return the jdbcDatabaseTable
	 * 
	 */
	public String getJdbcDatabaseTable();

	/**
	 * Defines a new jdbcDatabaseTable
	 * @param newValue the new jdbcDatabaseTable to set
	 * 
	 */
	public void setJdbcDatabaseTable(String newValue);


	/**
	 * @return the jdbcConnectionInformation
	 * 
	 */
	public Enumerator getJdbcConnectionInformation();

	/**
	 * Init the jdbcConnectionInformation
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initJdbcConnectionInformation(Object input, Enumerator current);

	/**
	 * Defines a new jdbcConnectionInformation
	 * @param newValue the new jdbcConnectionInformation to set
	 * 
	 */
	public void setJdbcConnectionInformation(Enumerator newValue);


	/**
	 * @return the jdbcDriver
	 * 
	 */
	public String getJdbcDriver();

	/**
	 * Defines a new jdbcDriver
	 * @param newValue the new jdbcDriver to set
	 * 
	 */
	public void setJdbcDriver(String newValue);


	/**
	 * @return the jdbcURL
	 * 
	 */
	public String getJdbcURL();

	/**
	 * Defines a new jdbcURL
	 * @param newValue the new jdbcURL to set
	 * 
	 */
	public void setJdbcURL(String newValue);


	/**
	 * @return the jdbcUser
	 * 
	 */
	public String getJdbcUser();

	/**
	 * Defines a new jdbcUser
	 * @param newValue the new jdbcUser to set
	 * 
	 */
	public void setJdbcUser(String newValue);


	/**
	 * @return the jdbcPassword
	 * 
	 */
	public String getJdbcPassword();

	/**
	 * Defines a new jdbcPassword
	 * @param newValue the new jdbcPassword to set
	 * 
	 */
	public void setJdbcPassword(String newValue);


	/**
	 * @return the jdbcDatasourceName
	 * 
	 */
	public String getJdbcDatasourceName();

	/**
	 * Defines a new jdbcDatasourceName
	 * @param newValue the new jdbcDatasourceName to set
	 * 
	 */
	public void setJdbcDatasourceName(String newValue);




	/**
	 * Init the parameters
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initParameters(ReferencesTableSettings settings);

	/**
	 * Update the parameters
	 * @param newValue the parameters to update
	 * 
	 */
	public void updateParameters();

	/**
	 * Adds the given filter to the parameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToParameters(ViewerFilter filter);

	/**
	 * Adds the given filter to the parameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToParameters(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the parameters table
	 * 
	 */
	public boolean isContainedInParametersTable(EObject element);


	/**
	 * @return the enableProducerGuaranteedDelivery
	 * 
	 */
	public Boolean getEnableProducerGuaranteedDelivery();

	/**
	 * Defines a new enableProducerGuaranteedDelivery
	 * @param newValue the new enableProducerGuaranteedDelivery to set
	 * 
	 */
	public void setEnableProducerGuaranteedDelivery(Boolean newValue);


	/**
	 * @return the failoverMessageStore
	 * 
	 */
	public String getFailoverMessageStore();

	/**
	 * Defines a new failoverMessageStore
	 * @param newValue the new failoverMessageStore to set
	 * 
	 */
	public void setFailoverMessageStore(String newValue);


	/**
	 * @return the resequencepolling
	 * 
	 */
	public String getResequencepolling();

	/**
	 * Defines a new resequencepolling
	 * @param newValue the new resequencepolling to set
	 * 
	 */
	public void setResequencepolling(String newValue);


	/**
	 * @return the resequenceDatabaseTable
	 * 
	 */
	public String getResequenceDatabaseTable();

	/**
	 * Defines a new resequenceDatabaseTable
	 * @param newValue the new resequenceDatabaseTable to set
	 * 
	 */
	public void setResequenceDatabaseTable(String newValue);


	/**
	 * @return the resequenceConnectionInformation
	 * 
	 */
	public Enumerator getResequenceConnectionInformation();

	/**
	 * Init the resequenceConnectionInformation
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initResequenceConnectionInformation(Object input, Enumerator current);

	/**
	 * Defines a new resequenceConnectionInformation
	 * @param newValue the new resequenceConnectionInformation to set
	 * 
	 */
	public void setResequenceConnectionInformation(Enumerator newValue);


	/**
	 * @return the resequenceDriver
	 * 
	 */
	public String getResequenceDriver();

	/**
	 * Defines a new resequenceDriver
	 * @param newValue the new resequenceDriver to set
	 * 
	 */
	public void setResequenceDriver(String newValue);


	/**
	 * @return the resequenceURL
	 * 
	 */
	public String getResequenceURL();

	/**
	 * Defines a new resequenceURL
	 * @param newValue the new resequenceURL to set
	 * 
	 */
	public void setResequenceURL(String newValue);


	/**
	 * @return the resequenceUser
	 * 
	 */
	public String getResequenceUser();

	/**
	 * Defines a new resequenceUser
	 * @param newValue the new resequenceUser to set
	 * 
	 */
	public void setResequenceUser(String newValue);


	/**
	 * @return the resequencePassword
	 * 
	 */
	public String getResequencePassword();

	/**
	 * Defines a new resequencePassword
	 * @param newValue the new resequencePassword to set
	 * 
	 */
	public void setResequencePassword(String newValue);


	/**
	 * @return the resequenceDatasourceName
	 * 
	 */
	public String getResequenceDatasourceName();

	/**
	 * Defines a new resequenceDatasourceName
	 * @param newValue the new resequenceDatasourceName to set
	 * 
	 */
	public void setResequenceDatasourceName(String newValue);


	/**
	 * @return the resequenceXpath
	 * 
	 */
	public String getResequenceXpath();

	/**
	 * Defines a new resequenceXpath
	 * @param newValue the new resequenceXpath to set
	 * 
	 */
	public void setResequenceXpath(String newValue);


	/**
	 * @return the resequenceXpathAttr
	 * 
	 */
	public EObject getResequenceXpathAttr();

	/**
	 * Init the resequenceXpathAttr
	 * @param settings the combo setting
	 */
	public void initResequenceXpathAttr(EObjectFlatComboSettings settings);

	/**
	 * Defines a new resequenceXpathAttr
	 * @param newValue the new resequenceXpathAttr to set
	 * 
	 */
	public void setResequenceXpathAttr(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setResequenceXpathAttrButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the resequenceXpathAttr edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToResequenceXpathAttr(ViewerFilter filter);

	/**
	 * Adds the given filter to the resequenceXpathAttr edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToResequenceXpathAttr(ViewerFilter filter);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
