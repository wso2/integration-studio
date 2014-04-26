/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Excel Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getWorkbookname <em>Workbookname</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getHasheader <em>Hasheader</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getStartingrow <em>Startingrow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getMaxrowcount <em>Maxrowcount</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getExcelQuery()
 * @model extendedMetaData="name='excel_._type' kind='mixed'"
 * @generated
 */
public interface ExcelQuery extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getExcelQuery_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Workbookname</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workbookname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workbookname</em>' containment reference.
	 * @see #setWorkbookname(WorkBookName)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getExcelQuery_Workbookname()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='workbookname' namespace='##targetNamespace'"
	 * @generated
	 */
	WorkBookName getWorkbookname();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getWorkbookname <em>Workbookname</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workbookname</em>' containment reference.
	 * @see #getWorkbookname()
	 * @generated
	 */
	void setWorkbookname(WorkBookName value);

	/**
	 * Returns the value of the '<em><b>Hasheader</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hasheader</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hasheader</em>' containment reference.
	 * @see #setHasheader(HasHeader)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getExcelQuery_Hasheader()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='hasheader' namespace='##targetNamespace'"
	 * @generated
	 */
	HasHeader getHasheader();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getHasheader <em>Hasheader</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hasheader</em>' containment reference.
	 * @see #getHasheader()
	 * @generated
	 */
	void setHasheader(HasHeader value);

	/**
	 * Returns the value of the '<em><b>Startingrow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startingrow</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Startingrow</em>' containment reference.
	 * @see #setStartingrow(StartingRow)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getExcelQuery_Startingrow()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='startingrow' namespace='##targetNamespace'"
	 * @generated
	 */
	StartingRow getStartingrow();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getStartingrow <em>Startingrow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startingrow</em>' containment reference.
	 * @see #getStartingrow()
	 * @generated
	 */
	void setStartingrow(StartingRow value);

	/**
	 * Returns the value of the '<em><b>Maxrowcount</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maxrowcount</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maxrowcount</em>' containment reference.
	 * @see #setMaxrowcount(MaxRowCount)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getExcelQuery_Maxrowcount()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='maxrowcount' namespace='##targetNamespace'"
	 * @generated
	 */
	MaxRowCount getMaxrowcount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getMaxrowcount <em>Maxrowcount</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maxrowcount</em>' containment reference.
	 * @see #getMaxrowcount()
	 * @generated
	 */
	void setMaxrowcount(MaxRowCount value);

} // ExcelQuery
