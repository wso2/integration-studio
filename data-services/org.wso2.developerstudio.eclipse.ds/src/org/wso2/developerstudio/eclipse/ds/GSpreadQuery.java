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
 * A representation of the model object '<em><b>GSpread Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getWorksheetnumber <em>Worksheetnumber</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getStartingrow <em>Startingrow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getMaxrowcount <em>Maxrowcount</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getHasheader <em>Hasheader</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getGSpreadQuery()
 * @model extendedMetaData="name='gspread_._type' kind='mixed'"
 * @generated
 */
public interface GSpreadQuery extends EObject {
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
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getGSpreadQuery_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Worksheetnumber</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Worksheetnumber</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Worksheetnumber</em>' containment reference.
	 * @see #setWorksheetnumber(WorkSheetNumber)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getGSpreadQuery_Worksheetnumber()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='worksheetnumber' namespace='##targetNamespace'"
	 * @generated
	 */
	WorkSheetNumber getWorksheetnumber();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getWorksheetnumber <em>Worksheetnumber</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Worksheetnumber</em>' containment reference.
	 * @see #getWorksheetnumber()
	 * @generated
	 */
	void setWorksheetnumber(WorkSheetNumber value);

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
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getGSpreadQuery_Startingrow()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='startingrow' namespace='##targetNamespace'"
	 * @generated
	 */
	StartingRow getStartingrow();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getStartingrow <em>Startingrow</em>}' containment reference.
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
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getGSpreadQuery_Maxrowcount()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='maxrowcount' namespace='##targetNamespace'"
	 * @generated
	 */
	MaxRowCount getMaxrowcount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getMaxrowcount <em>Maxrowcount</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maxrowcount</em>' containment reference.
	 * @see #getMaxrowcount()
	 * @generated
	 */
	void setMaxrowcount(MaxRowCount value);

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
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getGSpreadQuery_Hasheader()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='hasheader' namespace='##targetNamespace'"
	 * @generated
	 */
	HasHeader getHasheader();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getHasheader <em>Hasheader</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hasheader</em>' containment reference.
	 * @see #getHasheader()
	 * @generated
	 */
	void setHasheader(HasHeader value);

} // GSpreadQuery
