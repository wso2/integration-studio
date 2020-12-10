/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface RouterRoutePropertiesEditionPart {

	/**
	 * @return the breakAfterRoute
	 * 
	 */
	public Boolean getBreakAfterRoute();

	/**
	 * Defines a new breakAfterRoute
	 * @param newValue the new breakAfterRoute to set
	 * 
	 */
	public void setBreakAfterRoute(Boolean newValue);


	/**
	 * @return the routeExpression
	 * 
	 */
	public EObject getRouteExpression();

	/**
	 * Init the routeExpression
	 * @param settings the combo setting
	 */
	public void initRouteExpression(EObjectFlatComboSettings settings);

	/**
	 * Defines a new routeExpression
	 * @param newValue the new routeExpression to set
	 * 
	 */
	public void setRouteExpression(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setRouteExpressionButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the routeExpression edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToRouteExpression(ViewerFilter filter);

	/**
	 * Adds the given filter to the routeExpression edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToRouteExpression(ViewerFilter filter);


	/**
	 * @return the routePattern
	 * 
	 */
	public String getRoutePattern();

	/**
	 * Defines a new routePattern
	 * @param newValue the new routePattern to set
	 * 
	 */
	public void setRoutePattern(String newValue);





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
