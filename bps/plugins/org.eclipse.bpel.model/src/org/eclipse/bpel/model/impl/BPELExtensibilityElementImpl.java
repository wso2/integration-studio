/*******************************************************************************
 * Copyright (c) 2007 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dennis Ushakov, Intel - Initial API and Implementation
 *
 * Bugzilla 340654 - renamed to avoid confusion with WSDL's ExtensibilityElement
 *******************************************************************************/
package org.eclipse.bpel.model.impl;

import org.eclipse.wst.wsdl.ExtensibilityElement;
import org.eclipse.wst.wsdl.WSDLElement;
import org.eclipse.wst.wsdl.internal.impl.WSDLElementImpl;
import org.w3c.dom.Element;

@SuppressWarnings("restriction")
public class BPELExtensibilityElementImpl extends org.eclipse.wst.wsdl.internal.impl.ExtensibilityElementImpl implements ExtensibilityElement {

	@Override
	protected void reconcile(Element changedElement) {
	    reconcileAttributes(changedElement);
	    reconcileContents(changedElement);
//		ReconciliationHelper.getInstance().reconcile(this, changedElement);
	}
	
	@Override
	public void elementChanged(Element changedElement) {
		if (!isUpdatingDOM()) {
			if (!isReconciling) {
				isReconciling = true;
				try {
					reconcile(changedElement);

					WSDLElement theContainer = getContainer();
					if (theContainer != null && theContainer.getElement() == changedElement) {
						((WSDLElementImpl)theContainer).elementChanged(changedElement);
					}
				} finally {
					isReconciling = false;
				}
				traverseToRootForPatching();
			} 
	    } 
	}
	
	@Override
	public boolean isUpdatingDOM() {
		return super.isUpdatingDOM();
	}
	
	public void setUpdatingDOM(boolean updatingDOM) {
		this.updatingDOM = updatingDOM;
	}
}
