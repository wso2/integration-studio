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


// End of user code

/**
 * 
 * 
 */
public interface DBReportMediatorPropertiesEditionPart {

	/**
	 * @return the connectionType
	 * 
	 */
	public Enumerator getConnectionType();

	/**
	 * Init the connectionType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initConnectionType(Object input, Enumerator current);

	/**
	 * Defines a new connectionType
	 * @param newValue the new connectionType to set
	 * 
	 */
	public void setConnectionType(Enumerator newValue);


	/**
	 * @return the connectionDsType
	 * 
	 */
	public Enumerator getConnectionDsType();

	/**
	 * Init the connectionDsType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initConnectionDsType(Object input, Enumerator current);

	/**
	 * Defines a new connectionDsType
	 * @param newValue the new connectionDsType to set
	 * 
	 */
	public void setConnectionDsType(Enumerator newValue);


	/**
	 * @return the connectionDbType
	 * 
	 */
	public Enumerator getConnectionDbType();

	/**
	 * Init the connectionDbType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initConnectionDbType(Object input, Enumerator current);

	/**
	 * Defines a new connectionDbType
	 * @param newValue the new connectionDbType to set
	 * 
	 */
	public void setConnectionDbType(Enumerator newValue);


	/**
	 * @return the connectionDbDriver
	 * 
	 */
	public String getConnectionDbDriver();

	/**
	 * Defines a new connectionDbDriver
	 * @param newValue the new connectionDbDriver to set
	 * 
	 */
	public void setConnectionDbDriver(String newValue);


	/**
	 * @return the connectionDsInitialContext
	 * 
	 */
	public String getConnectionDsInitialContext();

	/**
	 * Defines a new connectionDsInitialContext
	 * @param newValue the new connectionDsInitialContext to set
	 * 
	 */
	public void setConnectionDsInitialContext(String newValue);


	/**
	 * @return the connectionDsName
	 * 
	 */
	public String getConnectionDsName();

	/**
	 * Defines a new connectionDsName
	 * @param newValue the new connectionDsName to set
	 * 
	 */
	public void setConnectionDsName(String newValue);


	/**
	 * @return the connectionURL
	 * 
	 */
	public String getConnectionURL();

	/**
	 * Defines a new connectionURL
	 * @param newValue the new connectionURL to set
	 * 
	 */
	public void setConnectionURL(String newValue);


	/**
	 * @return the connectionUsername
	 * 
	 */
	public String getConnectionUsername();

	/**
	 * Defines a new connectionUsername
	 * @param newValue the new connectionUsername to set
	 * 
	 */
	public void setConnectionUsername(String newValue);


	/**
	 * @return the connectionPassword
	 * 
	 */
	public String getConnectionPassword();

	/**
	 * Defines a new connectionPassword
	 * @param newValue the new connectionPassword to set
	 * 
	 */
	public void setConnectionPassword(String newValue);


	/**
	 * @return the connectionUseTransaction
	 * 
	 */
	public Boolean getConnectionUseTransaction();

	/**
	 * Defines a new connectionUseTransaction
	 * @param newValue the new connectionUseTransaction to set
	 * 
	 */
	public void setConnectionUseTransaction(Boolean newValue);




	/**
	 * Init the sqlStatements
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initSqlStatements(ReferencesTableSettings settings);

	/**
	 * Update the sqlStatements
	 * @param newValue the sqlStatements to update
	 * 
	 */
	public void updateSqlStatements();

	/**
	 * Adds the given filter to the sqlStatements edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSqlStatements(ViewerFilter filter);

	/**
	 * Adds the given filter to the sqlStatements edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSqlStatements(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the sqlStatements table
	 * 
	 */
	public boolean isContainedInSqlStatementsTable(EObject element);


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
	 * @return the propertyAutocommit
	 * 
	 */
	public Enumerator getPropertyAutocommit();

	/**
	 * Init the propertyAutocommit
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPropertyAutocommit(Object input, Enumerator current);

	/**
	 * Defines a new propertyAutocommit
	 * @param newValue the new propertyAutocommit to set
	 * 
	 */
	public void setPropertyAutocommit(Enumerator newValue);


	/**
	 * @return the propertyIsolation
	 * 
	 */
	public Enumerator getPropertyIsolation();

	/**
	 * Init the propertyIsolation
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPropertyIsolation(Object input, Enumerator current);

	/**
	 * Defines a new propertyIsolation
	 * @param newValue the new propertyIsolation to set
	 * 
	 */
	public void setPropertyIsolation(Enumerator newValue);


	/**
	 * @return the propertyMaxactive
	 * 
	 */
	public String getPropertyMaxactive();

	/**
	 * Defines a new propertyMaxactive
	 * @param newValue the new propertyMaxactive to set
	 * 
	 */
	public void setPropertyMaxactive(String newValue);


	/**
	 * @return the propertyMaxidle
	 * 
	 */
	public String getPropertyMaxidle();

	/**
	 * Defines a new propertyMaxidle
	 * @param newValue the new propertyMaxidle to set
	 * 
	 */
	public void setPropertyMaxidle(String newValue);


	/**
	 * @return the propertyMaxopenstatements
	 * 
	 */
	public String getPropertyMaxopenstatements();

	/**
	 * Defines a new propertyMaxopenstatements
	 * @param newValue the new propertyMaxopenstatements to set
	 * 
	 */
	public void setPropertyMaxopenstatements(String newValue);


	/**
	 * @return the propertyMaxwait
	 * 
	 */
	public String getPropertyMaxwait();

	/**
	 * Defines a new propertyMaxwait
	 * @param newValue the new propertyMaxwait to set
	 * 
	 */
	public void setPropertyMaxwait(String newValue);


	/**
	 * @return the propertyMinidle
	 * 
	 */
	public String getPropertyMinidle();

	/**
	 * Defines a new propertyMinidle
	 * @param newValue the new propertyMinidle to set
	 * 
	 */
	public void setPropertyMinidle(String newValue);


	/**
	 * @return the propertyPoolstatements
	 * 
	 */
	public Enumerator getPropertyPoolstatements();

	/**
	 * Init the propertyPoolstatements
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPropertyPoolstatements(Object input, Enumerator current);

	/**
	 * Defines a new propertyPoolstatements
	 * @param newValue the new propertyPoolstatements to set
	 * 
	 */
	public void setPropertyPoolstatements(Enumerator newValue);


	/**
	 * @return the propertyTestonborrow
	 * 
	 */
	public Enumerator getPropertyTestonborrow();

	/**
	 * Init the propertyTestonborrow
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPropertyTestonborrow(Object input, Enumerator current);

	/**
	 * Defines a new propertyTestonborrow
	 * @param newValue the new propertyTestonborrow to set
	 * 
	 */
	public void setPropertyTestonborrow(Enumerator newValue);


	/**
	 * @return the propertyTestwhileidle
	 * 
	 */
	public Enumerator getPropertyTestwhileidle();

	/**
	 * Init the propertyTestwhileidle
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPropertyTestwhileidle(Object input, Enumerator current);

	/**
	 * Defines a new propertyTestwhileidle
	 * @param newValue the new propertyTestwhileidle to set
	 * 
	 */
	public void setPropertyTestwhileidle(Enumerator newValue);


	/**
	 * @return the propertyValidationquery
	 * 
	 */
	public String getPropertyValidationquery();

	/**
	 * Defines a new propertyValidationquery
	 * @param newValue the new propertyValidationquery to set
	 * 
	 */
	public void setPropertyValidationquery(String newValue);


	/**
	 * @return the propertyInitialsize
	 * 
	 */
	public String getPropertyInitialsize();

	/**
	 * Defines a new propertyInitialsize
	 * @param newValue the new propertyInitialsize to set
	 * 
	 */
	public void setPropertyInitialsize(String newValue);


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




	// Start of user code for Database Configuration specific getters and setters declaration
	
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
