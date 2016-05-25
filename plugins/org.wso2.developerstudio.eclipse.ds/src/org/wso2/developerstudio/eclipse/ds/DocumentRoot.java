/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getCallQuery <em>Call Query</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getData <em>Data</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getHasheader <em>Hasheader</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getMaxrowcount <em>Maxrowcount</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getProperty <em>Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getSql <em>Sql</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getStartingrow <em>Startingrow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
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
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Call Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Query</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Query</em>' containment reference.
	 * @see #setCallQuery(CallQuery)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDocumentRoot_CallQuery()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='call-query' namespace='##targetNamespace'"
	 * @generated
	 */
	CallQuery getCallQuery();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getCallQuery <em>Call Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Query</em>' containment reference.
	 * @see #getCallQuery()
	 * @generated
	 */
	void setCallQuery(CallQuery value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference.
	 * @see #setData(DataService)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDocumentRoot_Data()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='data' namespace='##targetNamespace'"
	 * @generated
	 */
	DataService getData();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(DataService value);

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
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDocumentRoot_Hasheader()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='hasheader' namespace='##targetNamespace'"
	 * @generated
	 */
	HasHeader getHasheader();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getHasheader <em>Hasheader</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hasheader</em>' containment reference.
	 * @see #getHasheader()
	 * @generated
	 */
	void setHasheader(HasHeader value);

	/**
	 * Returns the value of the '<em><b>Maxrowcount</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maxrowcount</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maxrowcount</em>' containment reference.
	 * @see #setMaxrowcount(MaxRowCount)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDocumentRoot_Maxrowcount()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='maxrowcount' namespace='##targetNamespace'"
	 * @generated
	 */
	MaxRowCount getMaxrowcount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getMaxrowcount <em>Maxrowcount</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maxrowcount</em>' containment reference.
	 * @see #getMaxrowcount()
	 * @generated
	 */
	void setMaxrowcount(MaxRowCount value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference.
	 * @see #setProperty(ConfigurationProperty)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDocumentRoot_Property()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
	 * @generated
	 */
	ConfigurationProperty getProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getProperty <em>Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' containment reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(ConfigurationProperty value);

	/**
	 * Returns the value of the '<em><b>Sql</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sql</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sql</em>' containment reference.
	 * @see #setSql(Sql)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDocumentRoot_Sql()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='sql' namespace='##targetNamespace'"
	 * @generated
	 */
	Sql getSql();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getSql <em>Sql</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sql</em>' containment reference.
	 * @see #getSql()
	 * @generated
	 */
	void setSql(Sql value);

	/**
	 * Returns the value of the '<em><b>Startingrow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startingrow</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Startingrow</em>' containment reference.
	 * @see #setStartingrow(StartingRow)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getDocumentRoot_Startingrow()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='startingrow' namespace='##targetNamespace'"
	 * @generated
	 */
	StartingRow getStartingrow();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getStartingrow <em>Startingrow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startingrow</em>' containment reference.
	 * @see #getStartingrow()
	 * @generated
	 */
	void setStartingrow(StartingRow value);

} // DocumentRoot
