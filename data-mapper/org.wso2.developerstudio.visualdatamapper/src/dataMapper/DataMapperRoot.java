/**
 */
package dataMapper;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataMapper.DataMapperRoot#getDataMapperDiagram <em>Data Mapper Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataMapper.DataMapperPackage#getDataMapperRoot()
 * @model
 * @generated
 */
public interface DataMapperRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Mapper Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Mapper Diagram</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Mapper Diagram</em>' containment reference.
	 * @see #setDataMapperDiagram(DataMapperDiagram)
	 * @see dataMapper.DataMapperPackage#getDataMapperRoot_DataMapperDiagram()
	 * @model containment="true"
	 * @generated
	 */
	DataMapperDiagram getDataMapperDiagram();

	/**
	 * Sets the value of the '{@link dataMapper.DataMapperRoot#getDataMapperDiagram <em>Data Mapper Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Mapper Diagram</em>' containment reference.
	 * @see #getDataMapperDiagram()
	 * @generated
	 */
	void setDataMapperDiagram(DataMapperDiagram value);

} // DataMapperRoot
