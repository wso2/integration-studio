/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.bpel.humantask.record;

import org.eclipse.bpel.model.BPELExtensibleElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.wso2.developerstudio.bpel.humantask.record.RecordPackage#getExtensionElement()
 * @model abstract="true"
 * @generated
 */
public interface ExtensionElement extends BPELExtensibleElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.wst.wsdl.DOMElement" documentDataType="org.eclipse.wst.wsdl.DOMDocument"
	 * @generated
	 */
	Element fixElement(Document document);

} // ExtensionElement
