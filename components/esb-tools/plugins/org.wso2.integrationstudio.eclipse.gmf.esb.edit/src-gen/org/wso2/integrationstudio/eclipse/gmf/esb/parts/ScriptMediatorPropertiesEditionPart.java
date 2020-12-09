/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface ScriptMediatorPropertiesEditionPart {

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
	 * @return the Reverse
	 * 
	 */
	public Boolean getReverse();

	/**
	 * Defines a new Reverse
	 * @param newValue the new Reverse to set
	 * 
	 */
	public void setReverse(Boolean newValue);


	/**
	 * @return the scriptType
	 * 
	 */
	public Enumerator getScriptType();

	/**
	 * Init the scriptType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initScriptType(Object input, Enumerator current);

	/**
	 * Defines a new scriptType
	 * @param newValue the new scriptType to set
	 * 
	 */
	public void setScriptType(Enumerator newValue);


	/**
	 * @return the scriptLanguage
	 * 
	 */
	public Enumerator getScriptLanguage();

	/**
	 * Init the scriptLanguage
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initScriptLanguage(Object input, Enumerator current);

	/**
	 * Defines a new scriptLanguage
	 * @param newValue the new scriptLanguage to set
	 * 
	 */
	public void setScriptLanguage(Enumerator newValue);


	/**
	 * @return the mediateFunction
	 * 
	 */
	public String getMediateFunction();

	/**
	 * Defines a new mediateFunction
	 * @param newValue the new mediateFunction to set
	 * 
	 */
	public void setMediateFunction(String newValue);


	/**
	 * @return the scriptBody
	 * 
	 */
	public String getScriptBody();

	/**
	 * Defines a new scriptBody
	 * @param newValue the new scriptBody to set
	 * 
	 */
	public void setScriptBody(String newValue);


	/**
	 * @return the keyType
	 * 
	 */
	public Enumerator getKeyType();

	/**
	 * Init the keyType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initKeyType(Object input, Enumerator current);

	/**
	 * Defines a new keyType
	 * @param newValue the new keyType to set
	 * 
	 */
	public void setKeyType(Enumerator newValue);




	/**
	 * Init the scriptKeys
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initScriptKeys(ReferencesTableSettings settings);

	/**
	 * Update the scriptKeys
	 * @param newValue the scriptKeys to update
	 * 
	 */
	public void updateScriptKeys();

	/**
	 * Adds the given filter to the scriptKeys edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToScriptKeys(ViewerFilter filter);

	/**
	 * Adds the given filter to the scriptKeys edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToScriptKeys(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the scriptKeys table
	 * 
	 */
	public boolean isContainedInScriptKeysTable(EObject element);




	// Start of user code for Script Static Key specific getters and setters declaration
    public RegistryKeyProperty getScriptStaticKey();
    
    public void setScriptStaticKey(RegistryKeyProperty registryKeyProperty);
	// End of user code
	// Start of user code for Script Dynamic Key specific getters and setters declaration
	public NamespacedProperty getScriptDynamicKey();
    
    public void setScriptDynamicKey(NamespacedProperty nameSpacedProperty);
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
