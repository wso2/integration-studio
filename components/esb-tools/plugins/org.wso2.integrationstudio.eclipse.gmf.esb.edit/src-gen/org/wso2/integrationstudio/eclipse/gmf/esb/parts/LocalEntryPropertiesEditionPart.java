/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;


// End of user code

/**
 * 
 * 
 */
public interface LocalEntryPropertiesEditionPart {

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
	 * @return the entryName
	 * 
	 */
	public String getEntryName();

	/**
	 * Defines a new entryName
	 * @param newValue the new entryName to set
	 * 
	 */
	public void setEntryName(String newValue);


	/**
	 * @return the localEntryType
	 * 
	 */
	public Enumerator getLocalEntryType();

	/**
	 * Init the localEntryType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initLocalEntryType(Object input, Enumerator current);

	/**
	 * Defines a new localEntryType
	 * @param newValue the new localEntryType to set
	 * 
	 */
	public void setLocalEntryType(Enumerator newValue);


	/**
	 * @return the valueLiteral
	 * 
	 */
	public String getValueLiteral();

	/**
	 * Defines a new valueLiteral
	 * @param newValue the new valueLiteral to set
	 * 
	 */
	public void setValueLiteral(String newValue);


	/**
	 * @return the valueXML
	 * 
	 */
	public String getValueXML();

	/**
	 * Defines a new valueXML
	 * @param newValue the new valueXML to set
	 * 
	 */
	public void setValueXML(String newValue);


	/**
	 * @return the valueURL
	 * 
	 */
	public String getValueURL();

	/**
	 * Defines a new valueURL
	 * @param newValue the new valueURL to set
	 * 
	 */
	public void setValueURL(String newValue);





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
