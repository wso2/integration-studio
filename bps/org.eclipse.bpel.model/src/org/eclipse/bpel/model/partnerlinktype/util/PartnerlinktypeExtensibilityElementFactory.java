/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.model.partnerlinktype.util;

import org.eclipse.bpel.model.BPELPlugin;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.wst.wsdl.ExtensibilityElement;
import org.eclipse.wst.wsdl.WSDLFactory;
import org.eclipse.wst.wsdl.util.ExtensibilityElementFactory;


public class PartnerlinktypeExtensibilityElementFactory implements ExtensibilityElementFactory
{
    public ExtensibilityElement createExtensibilityElement(String namespace, String localName)
    {
        if (PartnerlinktypeConstants.isPartnerLinkTypeNamespace(namespace))
        {
            if (PartnerlinktypeConstants.PARTNER_LINK_TYPE_ELEMENT_TAG.equals(localName))
            {
                return PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();
            }
            else if (PartnerlinktypeConstants.ROLE_ELEMENT_TAG.equals(localName))
            {
                return PartnerlinktypeFactory.eINSTANCE.createRole();
            }
            else
            {
            	BPELPlugin.getPlugin().log("PartnerlinktypeExtensibilityElementFactory: Unhandled localName: " + localName);
                return WSDLFactory.eINSTANCE.createUnknownExtensibilityElement();
            }
        }
        else
        {
        	BPELPlugin.getPlugin().log("PartnerlinktypeExtensibilityElementFactory: Unhandled namespace: " + namespace);
            return WSDLFactory.eINSTANCE.createUnknownExtensibilityElement();
        }
    }
}
