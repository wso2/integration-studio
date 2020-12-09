/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface ValidateSchemaPropertiesEditionPart {

	/**
	 * @return the validateSchemaKeyType
	 * 
	 */
	public Enumerator getValidateSchemaKeyType();

	/**
	 * Init the validateSchemaKeyType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initValidateSchemaKeyType(Object input, Enumerator current);

	/**
	 * Defines a new validateSchemaKeyType
	 * @param newValue the new validateSchemaKeyType to set
	 * 
	 */
	public void setValidateSchemaKeyType(Enumerator newValue);


	/**
	 * @return the schemaKey
	 * 
	 */
	public EObject getSchemaKey();

	/**
	 * Init the schemaKey
	 * @param settings the combo setting
	 */
	public void initSchemaKey(EObjectFlatComboSettings settings);

	/**
	 * Defines a new schemaKey
	 * @param newValue the new schemaKey to set
	 * 
	 */
	public void setSchemaKey(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setSchemaKeyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the schemaKey edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSchemaKey(ViewerFilter filter);

	/**
	 * Adds the given filter to the schemaKey edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSchemaKey(ViewerFilter filter);




	// Start of user code for staticSchemaKey specific getters and setters declaration
	public RegistryKeyProperty getStaticSchemaKey();
    
    public void setStaticSchemaKey(RegistryKeyProperty registryKeyProperty);

	// End of user code
	// Start of user code for dynamicSchemaKey specific getters and setters declaration
    public NamespacedProperty getDynamicSchemaKey();
    
    public void setDynamicSchemaKey(NamespacedProperty nameSpacedProperty);
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
