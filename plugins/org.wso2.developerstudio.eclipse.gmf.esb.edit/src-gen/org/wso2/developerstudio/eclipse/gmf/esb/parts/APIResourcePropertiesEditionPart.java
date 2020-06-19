/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface APIResourcePropertiesEditionPart {



	/**
	 * Init the inSequenceInputConnectors
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initInSequenceInputConnectors(ReferencesTableSettings settings);

	/**
	 * Update the inSequenceInputConnectors
	 * @param newValue the inSequenceInputConnectors to update
	 * 
	 */
	public void updateInSequenceInputConnectors();

	/**
	 * Adds the given filter to the inSequenceInputConnectors edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToInSequenceInputConnectors(ViewerFilter filter);

	/**
	 * Adds the given filter to the inSequenceInputConnectors edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToInSequenceInputConnectors(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the inSequenceInputConnectors table
	 * 
	 */
	public boolean isContainedInInSequenceInputConnectorsTable(EObject element);


	/**
	 * @return the urlStyle
	 * 
	 */
	public Enumerator getUrlStyle();

	/**
	 * Init the urlStyle
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initUrlStyle(Object input, Enumerator current);

	/**
	 * Defines a new urlStyle
	 * @param newValue the new urlStyle to set
	 * 
	 */
	public void setUrlStyle(Enumerator newValue);


	/**
	 * @return the uriTemplate
	 * 
	 */
	public String getUriTemplate();

	/**
	 * Defines a new uriTemplate
	 * @param newValue the new uriTemplate to set
	 * 
	 */
	public void setUriTemplate(String newValue);


	/**
	 * @return the urlMapping
	 * 
	 */
	public String getUrlMapping();

	/**
	 * Defines a new urlMapping
	 * @param newValue the new urlMapping to set
	 * 
	 */
	public void setUrlMapping(String newValue);


	/**
	 * @return the protocol
	 * 
	 */
	public Enumerator getProtocol();

	/**
	 * Init the protocol
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initProtocol(Object input, Enumerator current);

	/**
	 * Defines a new protocol
	 * @param newValue the new protocol to set
	 * 
	 */
	public void setProtocol(Enumerator newValue);


	/**
	 * @return the allowGet
	 * 
	 */
	public Boolean getAllowGet();

	/**
	 * Defines a new allowGet
	 * @param newValue the new allowGet to set
	 * 
	 */
	public void setAllowGet(Boolean newValue);


	/**
	 * @return the allowPost
	 * 
	 */
	public Boolean getAllowPost();

	/**
	 * Defines a new allowPost
	 * @param newValue the new allowPost to set
	 * 
	 */
	public void setAllowPost(Boolean newValue);


	/**
	 * @return the allowPut
	 * 
	 */
	public Boolean getAllowPut();

	/**
	 * Defines a new allowPut
	 * @param newValue the new allowPut to set
	 * 
	 */
	public void setAllowPut(Boolean newValue);


	/**
	 * @return the allowDelete
	 * 
	 */
	public Boolean getAllowDelete();

	/**
	 * Defines a new allowDelete
	 * @param newValue the new allowDelete to set
	 * 
	 */
	public void setAllowDelete(Boolean newValue);


	/**
	 * @return the allowOptions
	 * 
	 */
	public Boolean getAllowOptions();

	/**
	 * Defines a new allowOptions
	 * @param newValue the new allowOptions to set
	 * 
	 */
	public void setAllowOptions(Boolean newValue);


	/**
	 * @return the allowHead
	 * 
	 */
	public Boolean getAllowHead();

	/**
	 * Defines a new allowHead
	 * @param newValue the new allowHead to set
	 * 
	 */
	public void setAllowHead(Boolean newValue);


	/**
	 * @return the allowPatch
	 * 
	 */
	public Boolean getAllowPatch();

	/**
	 * Defines a new allowPatch
	 * @param newValue the new allowPatch to set
	 * 
	 */
	public void setAllowPatch(Boolean newValue);


	/**
	 * @return the inSequenceType
	 * 
	 */
	public Enumerator getInSequenceType();

	/**
	 * Init the inSequenceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initInSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new inSequenceType
	 * @param newValue the new inSequenceType to set
	 * 
	 */
	public void setInSequenceType(Enumerator newValue);


	/**
	 * @return the inSequenceName
	 * 
	 */
	public String getInSequenceName();

	/**
	 * Defines a new inSequenceName
	 * @param newValue the new inSequenceName to set
	 * 
	 */
	public void setInSequenceName(String newValue);


	/**
	 * @return the outSequenceType
	 * 
	 */
	public Enumerator getOutSequenceType();

	/**
	 * Init the outSequenceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initOutSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new outSequenceType
	 * @param newValue the new outSequenceType to set
	 * 
	 */
	public void setOutSequenceType(Enumerator newValue);


	/**
	 * @return the outSequenceName
	 * 
	 */
	public String getOutSequenceName();

	/**
	 * Defines a new outSequenceName
	 * @param newValue the new outSequenceName to set
	 * 
	 */
	public void setOutSequenceName(String newValue);


	/**
	 * @return the faultSequenceType
	 * 
	 */
	public Enumerator getFaultSequenceType();

	/**
	 * Init the faultSequenceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initFaultSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new faultSequenceType
	 * @param newValue the new faultSequenceType to set
	 * 
	 */
	public void setFaultSequenceType(Enumerator newValue);


	/**
	 * @return the faultSequenceName
	 * 
	 */
	public String getFaultSequenceName();

	/**
	 * Defines a new faultSequenceName
	 * @param newValue the new faultSequenceName to set
	 * 
	 */
	public void setFaultSequenceName(String newValue);




	// Start of user code for inSequenceKey specific getters and setters declaration
	public void setInSequenceKey(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getInSequenceKey();
	
	// End of user code
	// Start of user code for outSequenceKey specific getters and setters declaration
	public void setOutSequenceKey(RegistryKeyProperty registryKeyProperty);
    
    public RegistryKeyProperty getOutSequenceKey();
	
	// End of user code
	// Start of user code for faultSequenceKey specific getters and setters declaration
    public void setFaultSequenceKey(RegistryKeyProperty registryKeyProperty);
    
    public RegistryKeyProperty getFaultSequenceKey();
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
