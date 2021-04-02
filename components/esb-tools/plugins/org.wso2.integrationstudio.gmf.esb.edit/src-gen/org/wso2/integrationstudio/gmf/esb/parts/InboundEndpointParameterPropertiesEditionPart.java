/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts;

import org.eclipse.emf.common.util.Enumerator;
import org.wso2.integrationstudio.gmf.esb.RegistryKeyProperty;

// Start of user code for imports



// End of user code

/**
 * 
 * 
 */
public interface InboundEndpointParameterPropertiesEditionPart {

	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


	/**
	 * @return the value
	 * 
	 */
	public String getValue();

	/**
	 * Defines a new value
	 * @param newValue the new value to set
	 * 
	 */
	public void setValue(String newValue);


    /**
     * @return the type
     * 
     */
    public Enumerator getType();

    /**
     * Init the type
     * @param input the viewer input
     * @param current the current value
     */
    public void initType(Object input, Enumerator current);

    /**
     * Defines a new type
     * @param newValue the new type to set
     * 
     */
    public void setType(Enumerator newValue);




    // Start of user code for key specific getters and setters declaration
    
    // End of user code

	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	public RegistryKeyProperty getKey();

	public void setKey(RegistryKeyProperty keyProperty);

	// Start of user code for additional methods
	
	// End of user code

}
