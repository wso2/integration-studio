/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface CacheMediatorPropertiesEditionPart {

	/**
	 * @return the cacheType
	 * 
	 */
	public Enumerator getCacheType();

	/**
	 * Init the cacheType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initCacheType(Object input, Enumerator current);

	/**
	 * Defines a new cacheType
	 * @param newValue the new cacheType to set
	 * 
	 */
	public void setCacheType(Enumerator newValue);


	/**
	 * @return the cacheTimeout
	 * 
	 */
	public String getCacheTimeout();

	/**
	 * Defines a new cacheTimeout
	 * @param newValue the new cacheTimeout to set
	 * 
	 */
	public void setCacheTimeout(String newValue);


	/**
	 * @return the maxMessageSize
	 * 
	 */
	public String getMaxMessageSize();

	/**
	 * Defines a new maxMessageSize
	 * @param newValue the new maxMessageSize to set
	 * 
	 */
	public void setMaxMessageSize(String newValue);


	/**
	 * @return the maxEntryCount
	 * 
	 */
	public String getMaxEntryCount();

	/**
	 * Defines a new maxEntryCount
	 * @param newValue the new maxEntryCount to set
	 * 
	 */
	public void setMaxEntryCount(String newValue);


	/**
	 * @return the sequenceType
	 * 
	 */
	public Enumerator getSequenceType();

	/**
	 * Init the sequenceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new sequenceType
	 * @param newValue the new sequenceType to set
	 * 
	 */
	public void setSequenceType(Enumerator newValue);


	/**
	 * @return the cacheProtocolType
	 * 
	 */
	public Enumerator getCacheProtocolType();

	/**
	 * Init the cacheProtocolType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initCacheProtocolType(Object input, Enumerator current);

	/**
	 * Defines a new cacheProtocolType
	 * @param newValue the new cacheProtocolType to set
	 * 
	 */
	public void setCacheProtocolType(Enumerator newValue);


	/**
	 * @return the cacheProtocolMethods
	 * 
	 */
	public String getCacheProtocolMethods();

	/**
	 * Defines a new cacheProtocolMethods
	 * @param newValue the new cacheProtocolMethods to set
	 * 
	 */
	public void setCacheProtocolMethods(String newValue);


	/**
	 * @return the headersToExcludeInHash
	 * 
	 */
	public String getHeadersToExcludeInHash();

	/**
	 * Defines a new headersToExcludeInHash
	 * @param newValue the new headersToExcludeInHash to set
	 * 
	 */
	public void setHeadersToExcludeInHash(String newValue);


	/**
	 * @return the responseCodes
	 * 
	 */
	public String getResponseCodes();

	/**
	 * Defines a new responseCodes
	 * @param newValue the new responseCodes to set
	 * 
	 */
	public void setResponseCodes(String newValue);


	/**
	 * @return the enableCacheControl
	 * 
	 */
	public Boolean getEnableCacheControl();

	/**
	 * Defines a new enableCacheControl
	 * @param newValue the new enableCacheControl to set
	 * 
	 */
	public void setEnableCacheControl(Boolean newValue);


	/**
	 * @return the includeAgeHeader
	 * 
	 */
	public Boolean getIncludeAgeHeader();

	/**
	 * Defines a new includeAgeHeader
	 * @param newValue the new includeAgeHeader to set
	 * 
	 */
	public void setIncludeAgeHeader(Boolean newValue);


	/**
	 * @return the hashGenerator
	 * 
	 */
	public String getHashGenerator();

	/**
	 * Defines a new hashGenerator
	 * @param newValue the new hashGenerator to set
	 * 
	 */
	public void setHashGenerator(String newValue);


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




	// Start of user code for sequenceKey specific getters and setters declaration
	
	public void setSequenceKey(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getSequenceKey();
	
	// End of user code

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
