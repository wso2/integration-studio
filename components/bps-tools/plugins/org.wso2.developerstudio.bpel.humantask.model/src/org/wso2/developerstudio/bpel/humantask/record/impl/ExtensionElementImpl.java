/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.bpel.humantask.record.impl;

import org.eclipse.bpel.model.impl.BPELExtensibleElementImpl;
import org.eclipse.bpel.model.impl.ExtensionActivityImpl;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.wst.wsdl.WSDLElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.wso2.developerstudio.bpel.humantask.record.ExtensionElement;
import org.wso2.developerstudio.bpel.humantask.record.RecordPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ExtensionElementImpl extends BPELExtensibleElementImpl implements ExtensionElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	protected EClass eStaticClass() {
		return RecordPackage.Literals.EXTENSION_ELEMENT;
	}

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @customized
   */
  
  public Element fixElement(Document document) {
    if (getElement() == null && !isUpdatingDOM()) {
      try {
        setUpdatingDOM(true);
        setElement(createFixedElement(document));
      } finally {
        setUpdatingDOM(false);
      }
    }
    return getElement();
  }

  protected abstract Element createFixedElement(Document document);

  protected <E extends ExtensionElement> void replaceChild(E oldElement, E newElement) {
    if (shouldReconcile()) {
      if (newElement.fixElement(getElement().getOwnerDocument()) != null) {
        ReconciliationHelper.replaceChild(this, oldElement, newElement);
      }
    }
  }

  protected boolean shouldReconcile() {
    return !isReconciling() && !isUpdatingDOM() && getElement() != null && !ReconciliationHelper.isLoading(this);
  }

  /**
   * @see org.eclipse.bpel.model.impl.ExtensibleElementImpl#setUpdatingDOM(boolean)
   */
  
  public void setUpdatingDOM(boolean updatingDOM) {
    super.setUpdatingDOM(updatingDOM);
    // Adjust extension activity
    WSDLElement container = getContainer();
    while (container != null) {
      if (container instanceof ExtensionActivityImpl) {
        ((ExtensionActivityImpl) container).setUpdatingDOM(updatingDOM);
        return;
      }
      container = container.getContainer();
    }
  }

} // ExtensionElementImpl
