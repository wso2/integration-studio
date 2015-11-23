/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.ds.CallQuery;
import org.wso2.developerstudio.eclipse.ds.ConfigurationProperty;
import org.wso2.developerstudio.eclipse.ds.DataService;
import org.wso2.developerstudio.eclipse.ds.Description;
import org.wso2.developerstudio.eclipse.ds.DocumentRoot;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.HasHeader;
import org.wso2.developerstudio.eclipse.ds.MaxRowCount;
import org.wso2.developerstudio.eclipse.ds.Sql;
import org.wso2.developerstudio.eclipse.ds.StartingRow;
import org.wso2.developerstudio.eclipse.ds.Subscription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl#getCallQuery <em>Call Query</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl#getHasheader <em>Hasheader</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl#getMaxrowcount <em>Maxrowcount</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl#getSql <em>Sql</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl#getStartingrow <em>Startingrow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	protected EClass eStaticClass() {
		return DsPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, DsPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallQuery getCallQuery() {
		return (CallQuery)getMixed().get(DsPackage.Literals.DOCUMENT_ROOT__CALL_QUERY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallQuery(CallQuery newCallQuery, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.DOCUMENT_ROOT__CALL_QUERY, newCallQuery, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallQuery(CallQuery newCallQuery) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.DOCUMENT_ROOT__CALL_QUERY, newCallQuery);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataService getData() {
		return (DataService)getMixed().get(DsPackage.Literals.DOCUMENT_ROOT__DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetData(DataService newData, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.DOCUMENT_ROOT__DATA, newData, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(DataService newData) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.DOCUMENT_ROOT__DATA, newData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasHeader getHasheader() {
		return (HasHeader)getMixed().get(DsPackage.Literals.DOCUMENT_ROOT__HASHEADER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHasheader(HasHeader newHasheader, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.DOCUMENT_ROOT__HASHEADER, newHasheader, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasheader(HasHeader newHasheader) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.DOCUMENT_ROOT__HASHEADER, newHasheader);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxRowCount getMaxrowcount() {
		return (MaxRowCount)getMixed().get(DsPackage.Literals.DOCUMENT_ROOT__MAXROWCOUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxrowcount(MaxRowCount newMaxrowcount, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.DOCUMENT_ROOT__MAXROWCOUNT, newMaxrowcount, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxrowcount(MaxRowCount newMaxrowcount) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.DOCUMENT_ROOT__MAXROWCOUNT, newMaxrowcount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationProperty getProperty() {
		return (ConfigurationProperty)getMixed().get(DsPackage.Literals.DOCUMENT_ROOT__PROPERTY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperty(ConfigurationProperty newProperty,
	                                          NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.DOCUMENT_ROOT__PROPERTY, newProperty, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(ConfigurationProperty newProperty) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.DOCUMENT_ROOT__PROPERTY, newProperty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sql getSql() {
		return (Sql)getMixed().get(DsPackage.Literals.DOCUMENT_ROOT__SQL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSql(Sql newSql, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.DOCUMENT_ROOT__SQL, newSql, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSql(Sql newSql) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.DOCUMENT_ROOT__SQL, newSql);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartingRow getStartingrow() {
		return (StartingRow)getMixed().get(DsPackage.Literals.DOCUMENT_ROOT__STARTINGROW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartingrow(StartingRow newStartingrow, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.DOCUMENT_ROOT__STARTINGROW, newStartingrow, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartingrow(StartingRow newStartingrow) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.DOCUMENT_ROOT__STARTINGROW, newStartingrow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
	                                        NotificationChain msgs) {
		switch (featureID) {
			case DsPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case DsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case DsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case DsPackage.DOCUMENT_ROOT__CALL_QUERY:
				return basicSetCallQuery(null, msgs);
			case DsPackage.DOCUMENT_ROOT__DATA:
				return basicSetData(null, msgs);
			case DsPackage.DOCUMENT_ROOT__HASHEADER:
				return basicSetHasheader(null, msgs);
			case DsPackage.DOCUMENT_ROOT__MAXROWCOUNT:
				return basicSetMaxrowcount(null, msgs);
			case DsPackage.DOCUMENT_ROOT__PROPERTY:
				return basicSetProperty(null, msgs);
			case DsPackage.DOCUMENT_ROOT__SQL:
				return basicSetSql(null, msgs);
			case DsPackage.DOCUMENT_ROOT__STARTINGROW:
				return basicSetStartingrow(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DsPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case DsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case DsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case DsPackage.DOCUMENT_ROOT__CALL_QUERY:
				return getCallQuery();
			case DsPackage.DOCUMENT_ROOT__DATA:
				return getData();
			case DsPackage.DOCUMENT_ROOT__HASHEADER:
				return getHasheader();
			case DsPackage.DOCUMENT_ROOT__MAXROWCOUNT:
				return getMaxrowcount();
			case DsPackage.DOCUMENT_ROOT__PROPERTY:
				return getProperty();
			case DsPackage.DOCUMENT_ROOT__SQL:
				return getSql();
			case DsPackage.DOCUMENT_ROOT__STARTINGROW:
				return getStartingrow();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DsPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case DsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case DsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case DsPackage.DOCUMENT_ROOT__CALL_QUERY:
				setCallQuery((CallQuery)newValue);
				return;
			case DsPackage.DOCUMENT_ROOT__DATA:
				setData((DataService)newValue);
				return;
			case DsPackage.DOCUMENT_ROOT__HASHEADER:
				setHasheader((HasHeader)newValue);
				return;
			case DsPackage.DOCUMENT_ROOT__MAXROWCOUNT:
				setMaxrowcount((MaxRowCount)newValue);
				return;
			case DsPackage.DOCUMENT_ROOT__PROPERTY:
				setProperty((ConfigurationProperty)newValue);
				return;
			case DsPackage.DOCUMENT_ROOT__SQL:
				setSql((Sql)newValue);
				return;
			case DsPackage.DOCUMENT_ROOT__STARTINGROW:
				setStartingrow((StartingRow)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DsPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case DsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case DsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case DsPackage.DOCUMENT_ROOT__CALL_QUERY:
				setCallQuery((CallQuery)null);
				return;
			case DsPackage.DOCUMENT_ROOT__DATA:
				setData((DataService)null);
				return;
			case DsPackage.DOCUMENT_ROOT__HASHEADER:
				setHasheader((HasHeader)null);
				return;
			case DsPackage.DOCUMENT_ROOT__MAXROWCOUNT:
				setMaxrowcount((MaxRowCount)null);
				return;
			case DsPackage.DOCUMENT_ROOT__PROPERTY:
				setProperty((ConfigurationProperty)null);
				return;
			case DsPackage.DOCUMENT_ROOT__SQL:
				setSql((Sql)null);
				return;
			case DsPackage.DOCUMENT_ROOT__STARTINGROW:
				setStartingrow((StartingRow)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DsPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case DsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case DsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case DsPackage.DOCUMENT_ROOT__CALL_QUERY:
				return getCallQuery() != null;
			case DsPackage.DOCUMENT_ROOT__DATA:
				return getData() != null;
			case DsPackage.DOCUMENT_ROOT__HASHEADER:
				return getHasheader() != null;
			case DsPackage.DOCUMENT_ROOT__MAXROWCOUNT:
				return getMaxrowcount() != null;
			case DsPackage.DOCUMENT_ROOT__PROPERTY:
				return getProperty() != null;
			case DsPackage.DOCUMENT_ROOT__SQL:
				return getSql() != null;
			case DsPackage.DOCUMENT_ROOT__STARTINGROW:
				return getStartingrow() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} // DocumentRootImpl
