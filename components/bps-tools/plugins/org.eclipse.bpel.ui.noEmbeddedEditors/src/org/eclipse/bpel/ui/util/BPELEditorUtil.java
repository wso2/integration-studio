/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.util;


import java.util.HashMap;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.wst.wsdl.WSDLElement;
import org.w3c.dom.Element;

public class BPELEditorUtil extends BPELConstants
{
  protected static BPELEditorUtil instance = new BPELEditorUtil();
  protected BPELNodeAssociationManager nodeAssociationManager = new BPELNodeAssociationManager();

  protected HashMap elementNameToTypeMap = new HashMap();

  public static final int ELEMENT = 14;
  public static final int TYPE = 15;

  public static BPELEditorUtil getInstance() {
    return instance;
  }

  private BPELEditorUtil()
  {
    //FIXME add bpel tags here
	  /*elementNameToTypeMap.put(BINDING_ELEMENT_TAG, new Integer(BINDING));
    elementNameToTypeMap.put(DEFINITION_ELEMENT_TAG, new Integer(DEFINITION));
    elementNameToTypeMap.put(DOCUMENTATION_ELEMENT_TAG, new Integer(DOCUMENTATION));
    elementNameToTypeMap.put(FAULT_ELEMENT_TAG, new Integer(FAULT));
    elementNameToTypeMap.put(IMPORT_ELEMENT_TAG, new Integer(IMPORT));
    elementNameToTypeMap.put(INPUT_ELEMENT_TAG, new Integer(INPUT));
    elementNameToTypeMap.put(MESSAGE_ELEMENT_TAG, new Integer(MESSAGE));
    elementNameToTypeMap.put(OPERATION_ELEMENT_TAG, new Integer(OPERATION));
    elementNameToTypeMap.put(OUTPUT_ELEMENT_TAG, new Integer(OUTPUT));
    elementNameToTypeMap.put(PART_ELEMENT_TAG, new Integer(PART));
    elementNameToTypeMap.put(PORT_ELEMENT_TAG, new Integer(PORT));
    elementNameToTypeMap.put(PORT_TYPE_ELEMENT_TAG, new Integer(PORT_TYPE));
    elementNameToTypeMap.put(SERVICE_ELEMENT_TAG, new Integer(SERVICE));
    elementNameToTypeMap.put(TYPES_ELEMENT_TAG, new Integer(TYPES));*/
  }

  public String getBPELType(Element element) {
    return element.getLocalName();
  }

  public Object findModelObjectForElement(Process process, Element targetElement)
  {
    Object o = this.nodeAssociationManager.getModelObjectForNode(process, targetElement);
    return o;
  }

  public Element getElementForObject(Object o)
  {
    return ((WSDLElement)o).getElement();
  }
}
