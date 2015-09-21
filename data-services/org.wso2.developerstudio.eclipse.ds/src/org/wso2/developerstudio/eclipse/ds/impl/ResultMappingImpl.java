/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.ds.AttributeMapping;
import org.wso2.developerstudio.eclipse.ds.CallQuery;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.ElementMapping;
import org.wso2.developerstudio.eclipse.ds.ResultMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl#getCallQuery <em>Call Query</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl#getDefaultNamespace <em>Default Namespace</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl#getElementName <em>Element Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl#getRowName <em>Row Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl#isUseColumnNumbers <em>Use Column Numbers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl#isEscapeNonPrintableChar <em>Escape Non Printable Char</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl#getXsltPath <em>Xslt Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl#getOutputType <em>Output Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultMappingImpl extends EObjectImpl implements ResultMapping {
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
     * The default value of the '{@link #getDefaultNamespace() <em>Default Namespace</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDefaultNamespace()
     * @generated
     * @ordered
     */
	protected static final String DEFAULT_NAMESPACE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getDefaultNamespace() <em>Default Namespace</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDefaultNamespace()
     * @generated
     * @ordered
     */
	protected String defaultNamespace = DEFAULT_NAMESPACE_EDEFAULT;

	/**
     * The default value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getElementName()
     * @generated
     * @ordered
     */
	protected static final String ELEMENT_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getElementName()
     * @generated
     * @ordered
     */
	protected String elementName = ELEMENT_NAME_EDEFAULT;

	/**
     * The default value of the '{@link #getRowName() <em>Row Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRowName()
     * @generated
     * @ordered
     */
	protected static final String ROW_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getRowName() <em>Row Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRowName()
     * @generated
     * @ordered
     */
	protected String rowName = ROW_NAME_EDEFAULT;

	/**
     * The default value of the '{@link #isUseColumnNumbers() <em>Use Column Numbers</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isUseColumnNumbers()
     * @generated
     * @ordered
     */
	protected static final boolean USE_COLUMN_NUMBERS_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isUseColumnNumbers() <em>Use Column Numbers</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isUseColumnNumbers()
     * @generated
     * @ordered
     */
	protected boolean useColumnNumbers = USE_COLUMN_NUMBERS_EDEFAULT;

	/**
     * The default value of the '{@link #isEscapeNonPrintableChar() <em>Escape Non Printable Char</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isEscapeNonPrintableChar()
     * @generated
     * @ordered
     */
	protected static final boolean ESCAPE_NON_PRINTABLE_CHAR_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isEscapeNonPrintableChar() <em>Escape Non Printable Char</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isEscapeNonPrintableChar()
     * @generated
     * @ordered
     */
	protected boolean escapeNonPrintableChar = ESCAPE_NON_PRINTABLE_CHAR_EDEFAULT;

	/**
     * The default value of the '{@link #getXsltPath() <em>Xslt Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getXsltPath()
     * @generated
     * @ordered
     */
	protected static final String XSLT_PATH_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getXsltPath() <em>Xslt Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getXsltPath()
     * @generated
     * @ordered
     */
	protected String xsltPath = XSLT_PATH_EDEFAULT;

	/**
     * The default value of the '{@link #getOutputType() <em>Output Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputType()
     * @generated
     * @ordered
     */
    protected static final String OUTPUT_TYPE_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getOutputType() <em>Output Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputType()
     * @generated
     * @ordered
     */
    protected String outputType = OUTPUT_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ResultMappingImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */

	@Override
	protected EClass eStaticClass() {
        return DsPackage.Literals.RESULT_MAPPING;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FeatureMap getMixed() {
        if (mixed == null) {
            mixed = new BasicFeatureMap(this, DsPackage.RESULT_MAPPING__MIXED);
        }
        return mixed;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ElementMapping> getElement() {
        return getMixed().list(DsPackage.Literals.RESULT_MAPPING__ELEMENT);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<AttributeMapping> getAttribute() {
        return getMixed().list(DsPackage.Literals.RESULT_MAPPING__ATTRIBUTE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<CallQuery> getCallQuery() {
        return getMixed().list(DsPackage.Literals.RESULT_MAPPING__CALL_QUERY);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getDefaultNamespace() {
        return defaultNamespace;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDefaultNamespace(String newDefaultNamespace) {
        String oldDefaultNamespace = defaultNamespace;
        defaultNamespace = newDefaultNamespace;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.RESULT_MAPPING__DEFAULT_NAMESPACE, oldDefaultNamespace, defaultNamespace));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getElementName() {
        return elementName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setElementName(String newElementName) {
        String oldElementName = elementName;
        elementName = newElementName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.RESULT_MAPPING__ELEMENT_NAME, oldElementName, elementName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getRowName() {
        return rowName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRowName(String newRowName) {
        String oldRowName = rowName;
        rowName = newRowName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.RESULT_MAPPING__ROW_NAME, oldRowName, rowName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isUseColumnNumbers() {
        return useColumnNumbers;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setUseColumnNumbers(boolean newUseColumnNumbers) {
        boolean oldUseColumnNumbers = useColumnNumbers;
        useColumnNumbers = newUseColumnNumbers;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.RESULT_MAPPING__USE_COLUMN_NUMBERS, oldUseColumnNumbers, useColumnNumbers));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isEscapeNonPrintableChar() {
        return escapeNonPrintableChar;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEscapeNonPrintableChar(boolean newEscapeNonPrintableChar) {
        boolean oldEscapeNonPrintableChar = escapeNonPrintableChar;
        escapeNonPrintableChar = newEscapeNonPrintableChar;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.RESULT_MAPPING__ESCAPE_NON_PRINTABLE_CHAR, oldEscapeNonPrintableChar, escapeNonPrintableChar));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getXsltPath() {
        return xsltPath;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setXsltPath(String newXsltPath) {
        String oldXsltPath = xsltPath;
        xsltPath = newXsltPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.RESULT_MAPPING__XSLT_PATH, oldXsltPath, xsltPath));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOutputType() {
        return outputType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutputType(String newOutputType) {
        String oldOutputType = outputType;
        outputType = newOutputType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.RESULT_MAPPING__OUTPUT_TYPE, oldOutputType, outputType));
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
            case DsPackage.RESULT_MAPPING__MIXED:
                return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
            case DsPackage.RESULT_MAPPING__ELEMENT:
                return ((InternalEList<?>)getElement()).basicRemove(otherEnd, msgs);
            case DsPackage.RESULT_MAPPING__ATTRIBUTE:
                return ((InternalEList<?>)getAttribute()).basicRemove(otherEnd, msgs);
            case DsPackage.RESULT_MAPPING__CALL_QUERY:
                return ((InternalEList<?>)getCallQuery()).basicRemove(otherEnd, msgs);
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
            case DsPackage.RESULT_MAPPING__MIXED:
                if (coreType) return getMixed();
                return ((FeatureMap.Internal)getMixed()).getWrapper();
            case DsPackage.RESULT_MAPPING__ELEMENT:
                return getElement();
            case DsPackage.RESULT_MAPPING__ATTRIBUTE:
                return getAttribute();
            case DsPackage.RESULT_MAPPING__CALL_QUERY:
                return getCallQuery();
            case DsPackage.RESULT_MAPPING__DEFAULT_NAMESPACE:
                return getDefaultNamespace();
            case DsPackage.RESULT_MAPPING__ELEMENT_NAME:
                return getElementName();
            case DsPackage.RESULT_MAPPING__ROW_NAME:
                return getRowName();
            case DsPackage.RESULT_MAPPING__USE_COLUMN_NUMBERS:
                return isUseColumnNumbers();
            case DsPackage.RESULT_MAPPING__ESCAPE_NON_PRINTABLE_CHAR:
                return isEscapeNonPrintableChar();
            case DsPackage.RESULT_MAPPING__XSLT_PATH:
                return getXsltPath();
            case DsPackage.RESULT_MAPPING__OUTPUT_TYPE:
                return getOutputType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case DsPackage.RESULT_MAPPING__MIXED:
                ((FeatureMap.Internal)getMixed()).set(newValue);
                return;
            case DsPackage.RESULT_MAPPING__ELEMENT:
                getElement().clear();
                getElement().addAll((Collection<? extends ElementMapping>)newValue);
                return;
            case DsPackage.RESULT_MAPPING__ATTRIBUTE:
                getAttribute().clear();
                getAttribute().addAll((Collection<? extends AttributeMapping>)newValue);
                return;
            case DsPackage.RESULT_MAPPING__CALL_QUERY:
                getCallQuery().clear();
                getCallQuery().addAll((Collection<? extends CallQuery>)newValue);
                return;
            case DsPackage.RESULT_MAPPING__DEFAULT_NAMESPACE:
                setDefaultNamespace((String)newValue);
                return;
            case DsPackage.RESULT_MAPPING__ELEMENT_NAME:
                setElementName((String)newValue);
                return;
            case DsPackage.RESULT_MAPPING__ROW_NAME:
                setRowName((String)newValue);
                return;
            case DsPackage.RESULT_MAPPING__USE_COLUMN_NUMBERS:
                setUseColumnNumbers((Boolean)newValue);
                return;
            case DsPackage.RESULT_MAPPING__ESCAPE_NON_PRINTABLE_CHAR:
                setEscapeNonPrintableChar((Boolean)newValue);
                return;
            case DsPackage.RESULT_MAPPING__XSLT_PATH:
                setXsltPath((String)newValue);
                return;
            case DsPackage.RESULT_MAPPING__OUTPUT_TYPE:
                setOutputType((String)newValue);
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
            case DsPackage.RESULT_MAPPING__MIXED:
                getMixed().clear();
                return;
            case DsPackage.RESULT_MAPPING__ELEMENT:
                getElement().clear();
                return;
            case DsPackage.RESULT_MAPPING__ATTRIBUTE:
                getAttribute().clear();
                return;
            case DsPackage.RESULT_MAPPING__CALL_QUERY:
                getCallQuery().clear();
                return;
            case DsPackage.RESULT_MAPPING__DEFAULT_NAMESPACE:
                setDefaultNamespace(DEFAULT_NAMESPACE_EDEFAULT);
                return;
            case DsPackage.RESULT_MAPPING__ELEMENT_NAME:
                setElementName(ELEMENT_NAME_EDEFAULT);
                return;
            case DsPackage.RESULT_MAPPING__ROW_NAME:
                setRowName(ROW_NAME_EDEFAULT);
                return;
            case DsPackage.RESULT_MAPPING__USE_COLUMN_NUMBERS:
                setUseColumnNumbers(USE_COLUMN_NUMBERS_EDEFAULT);
                return;
            case DsPackage.RESULT_MAPPING__ESCAPE_NON_PRINTABLE_CHAR:
                setEscapeNonPrintableChar(ESCAPE_NON_PRINTABLE_CHAR_EDEFAULT);
                return;
            case DsPackage.RESULT_MAPPING__XSLT_PATH:
                setXsltPath(XSLT_PATH_EDEFAULT);
                return;
            case DsPackage.RESULT_MAPPING__OUTPUT_TYPE:
                setOutputType(OUTPUT_TYPE_EDEFAULT);
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
            case DsPackage.RESULT_MAPPING__MIXED:
                return mixed != null && !mixed.isEmpty();
            case DsPackage.RESULT_MAPPING__ELEMENT:
                return !getElement().isEmpty();
            case DsPackage.RESULT_MAPPING__ATTRIBUTE:
                return !getAttribute().isEmpty();
            case DsPackage.RESULT_MAPPING__CALL_QUERY:
                return !getCallQuery().isEmpty();
            case DsPackage.RESULT_MAPPING__DEFAULT_NAMESPACE:
                return DEFAULT_NAMESPACE_EDEFAULT == null ? defaultNamespace != null : !DEFAULT_NAMESPACE_EDEFAULT.equals(defaultNamespace);
            case DsPackage.RESULT_MAPPING__ELEMENT_NAME:
                return ELEMENT_NAME_EDEFAULT == null ? elementName != null : !ELEMENT_NAME_EDEFAULT.equals(elementName);
            case DsPackage.RESULT_MAPPING__ROW_NAME:
                return ROW_NAME_EDEFAULT == null ? rowName != null : !ROW_NAME_EDEFAULT.equals(rowName);
            case DsPackage.RESULT_MAPPING__USE_COLUMN_NUMBERS:
                return useColumnNumbers != USE_COLUMN_NUMBERS_EDEFAULT;
            case DsPackage.RESULT_MAPPING__ESCAPE_NON_PRINTABLE_CHAR:
                return escapeNonPrintableChar != ESCAPE_NON_PRINTABLE_CHAR_EDEFAULT;
            case DsPackage.RESULT_MAPPING__XSLT_PATH:
                return XSLT_PATH_EDEFAULT == null ? xsltPath != null : !XSLT_PATH_EDEFAULT.equals(xsltPath);
            case DsPackage.RESULT_MAPPING__OUTPUT_TYPE:
                return OUTPUT_TYPE_EDEFAULT == null ? outputType != null : !OUTPUT_TYPE_EDEFAULT.equals(outputType);
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
        result.append(", defaultNamespace: ");
        result.append(defaultNamespace);
        result.append(", elementName: ");
        result.append(elementName);
        result.append(", rowName: ");
        result.append(rowName);
        result.append(", useColumnNumbers: ");
        result.append(useColumnNumbers);
        result.append(", escapeNonPrintableChar: ");
        result.append(escapeNonPrintableChar);
        result.append(", xsltPath: ");
        result.append(xsltPath);
        result.append(", outputType: ");
        result.append(outputType);
        result.append(')');
        return result.toString();
    }

} // ResultMappingImpl
