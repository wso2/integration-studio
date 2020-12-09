/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;


// End of user code

/**
 * 
 * 
 */
public interface EJBMediatorPropertiesEditionPart {

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
	 * @return the beanstalk
	 * 
	 */
	public String getBeanstalk();

	/**
	 * Defines a new beanstalk
	 * @param newValue the new beanstalk to set
	 * 
	 */
	public void setBeanstalk(String newValue);


	/**
	 * @return the class
	 * 
	 */
	public String getClass_();

	/**
	 * Defines a new class
	 * @param newValue the new class to set
	 * 
	 */
	public void setClass_(String newValue);


	/**
	 * @return the method
	 * 
	 */
	public String getMethod();

	/**
	 * Defines a new method
	 * @param newValue the new method to set
	 * 
	 */
	public void setMethod(String newValue);


	/**
	 * @return the sessionIdType
	 * 
	 */
	public Enumerator getSessionIdType();

	/**
	 * Init the sessionIdType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initSessionIdType(Object input, Enumerator current);

	/**
	 * Defines a new sessionIdType
	 * @param newValue the new sessionIdType to set
	 * 
	 */
	public void setSessionIdType(Enumerator newValue);


	/**
	 * @return the sessionIdLiteral
	 * 
	 */
	public String getSessionIdLiteral();

	/**
	 * Defines a new sessionIdLiteral
	 * @param newValue the new sessionIdLiteral to set
	 * 
	 */
	public void setSessionIdLiteral(String newValue);


	/**
	 * @return the remove
	 * 
	 */
	public Boolean getRemove();

	/**
	 * Defines a new remove
	 * @param newValue the new remove to set
	 * 
	 */
	public void setRemove(Boolean newValue);


	/**
	 * @return the target
	 * 
	 */
	public String getTarget();

	/**
	 * Defines a new target
	 * @param newValue the new target to set
	 * 
	 */
	public void setTarget(String newValue);


	/**
	 * @return the JNDIName
	 * 
	 */
	public String getJNDIName();

	/**
	 * Defines a new JNDIName
	 * @param newValue the new JNDIName to set
	 * 
	 */
	public void setJNDIName(String newValue);




	/**
	 * Init the methodArguments
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initMethodArguments(ReferencesTableSettings settings);

	/**
	 * Update the methodArguments
	 * @param newValue the methodArguments to update
	 * 
	 */
	public void updateMethodArguments();

	/**
	 * Adds the given filter to the methodArguments edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToMethodArguments(ViewerFilter filter);

	/**
	 * Adds the given filter to the methodArguments edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToMethodArguments(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the methodArguments table
	 * 
	 */
	public boolean isContainedInMethodArgumentsTable(EObject element);




	// Start of user code for sessionIdExpression specific getters and setters declaration
    public NamespacedProperty getSessionIdExpression();

    public void setSessionIdExpression(NamespacedProperty nameSpacedProperty);

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
