/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface RouterTargetPropertiesEditionPart {

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
	 * @return the sequence
	 * 
	 */
	public EObject getSequence();

	/**
	 * Init the sequence
	 * @param settings the combo setting
	 */
	public void initSequence(EObjectFlatComboSettings settings);

	/**
	 * Defines a new sequence
	 * @param newValue the new sequence to set
	 * 
	 */
	public void setSequence(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setSequenceButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the sequence edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSequence(ViewerFilter filter);

	/**
	 * Adds the given filter to the sequence edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSequence(ViewerFilter filter);


	/**
	 * @return the endpointType
	 * 
	 */
	public Enumerator getEndpointType();

	/**
	 * Init the endpointType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initEndpointType(Object input, Enumerator current);

	/**
	 * Defines a new endpointType
	 * @param newValue the new endpointType to set
	 * 
	 */
	public void setEndpointType(Enumerator newValue);





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
