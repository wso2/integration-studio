/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Element#getValue <em>Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Element#getOutNode <em>Out Node</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Element#getInNode <em>In Node</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Element#getFieldParent <em>Field Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Element#getSchemaDataType <em>Schema Data Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Element#getLevel <em>Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Element#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getElement_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Element#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Out Node</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.OutNode#getElementParent <em>Element Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Node</em>' containment reference.
	 * @see #setOutNode(OutNode)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getElement_OutNode()
	 * @see org.wso2.developerstudio.datamapper.OutNode#getElementParent
	 * @model opposite="elementParent" containment="true"
	 * @generated
	 */
	OutNode getOutNode();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Element#getOutNode <em>Out Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Node</em>' containment reference.
	 * @see #getOutNode()
	 * @generated
	 */
	void setOutNode(OutNode value);

	/**
	 * Returns the value of the '<em><b>In Node</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.InNode#getElementParent <em>Element Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Node</em>' containment reference.
	 * @see #setInNode(InNode)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getElement_InNode()
	 * @see org.wso2.developerstudio.datamapper.InNode#getElementParent
	 * @model opposite="elementParent" containment="true"
	 * @generated
	 */
	InNode getInNode();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Element#getInNode <em>In Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Node</em>' containment reference.
	 * @see #getInNode()
	 * @generated
	 */
	void setInNode(InNode value);

	/**
	 * Returns the value of the '<em><b>Field Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.TreeNode#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Parent</em>' container reference.
	 * @see #setFieldParent(TreeNode)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getElement_FieldParent()
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getElement
	 * @model opposite="element" transient="false"
	 * @generated
	 */
	TreeNode getFieldParent();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Element#getFieldParent <em>Field Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Parent</em>' container reference.
	 * @see #getFieldParent()
	 * @generated
	 */
	void setFieldParent(TreeNode value);

    /**
	 * Returns the value of the '<em><b>Schema Data Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.datamapper.SchemaDataType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Schema Data Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Data Type</em>' attribute.
	 * @see org.wso2.developerstudio.datamapper.SchemaDataType
	 * @see #setSchemaDataType(SchemaDataType)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getElement_SchemaDataType()
	 * @model
	 * @generated
	 */
    SchemaDataType getSchemaDataType();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Element#getSchemaDataType <em>Schema Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema Data Type</em>' attribute.
	 * @see org.wso2.developerstudio.datamapper.SchemaDataType
	 * @see #getSchemaDataType()
	 * @generated
	 */
    void setSchemaDataType(SchemaDataType value);

    /**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Level</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(int)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getElement_Level()
	 * @model
	 * @generated
	 */
    int getLevel();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Element#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
    void setLevel(int value);

} // Element
