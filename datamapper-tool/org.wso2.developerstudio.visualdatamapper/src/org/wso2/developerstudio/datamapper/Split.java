/**
 */
package org.wso2.developerstudio.datamapper;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Split</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.Split#getDelimiter <em>Delimiter</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Split#getArrayOutput <em>Array Output</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Split#getArrayOutputResultOmitingIndices <em>Array Output Result Omiting Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getSplit()
 * @model
 * @generated
 */
public interface Split extends Operator {

	/**
	 * Returns the value of the '<em><b>Delimiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delimiter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delimiter</em>' attribute.
	 * @see #setDelimiter(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getSplit_Delimiter()
	 * @model
	 * @generated
	 */
	String getDelimiter();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Split#getDelimiter <em>Delimiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delimiter</em>' attribute.
	 * @see #getDelimiter()
	 * @generated
	 */
	void setDelimiter(String value);

    /**
	 * Returns the value of the '<em><b>Array Output</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Array Output</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Output</em>' attribute.
	 * @see #setArrayOutput(int)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getSplit_ArrayOutput()
	 * @model default="-1"
	 * @generated
	 */
    int getArrayOutput();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Split#getArrayOutput <em>Array Output</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array Output</em>' attribute.
	 * @see #getArrayOutput()
	 * @generated
	 */
    void setArrayOutput(int value);

				/**
	 * Returns the value of the '<em><b>Array Output Result Omiting Indices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Output Result Omiting Indices</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Output Result Omiting Indices</em>' attribute.
	 * @see #setArrayOutputResultOmitingIndices(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getSplit_ArrayOutputResultOmitingIndices()
	 * @model
	 * @generated
	 */
	String getArrayOutputResultOmitingIndices();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Split#getArrayOutputResultOmitingIndices <em>Array Output Result Omiting Indices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array Output Result Omiting Indices</em>' attribute.
	 * @see #getArrayOutputResultOmitingIndices()
	 * @generated
	 */
	void setArrayOutputResultOmitingIndices(String value);
} // Split
