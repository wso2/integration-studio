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
package org.eclipse.bpel.model.proxy;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.util.BPELProxyURI;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.WSDLPackage;
import org.eclipse.wst.wsdl.internal.impl.PartImpl;


public class PartProxy extends PartImpl
{
    private BPELProxyURI proxyURI;

    public PartProxy(Resource resource, Message message, String name)
    {
        URI baseURI = resource.getURI();
        QName qName = (message == null) ? null : message.getQName();
        proxyURI = new BPELProxyURI(WSDLPackage.eINSTANCE.getPart(), baseURI, qName, name);
    }

    @Override
	public boolean eIsProxy()
    {
        return true;
    }

    @Override
	public URI eProxyURI()
    {
        return proxyURI.getProxyURI();
    }
    
    @Override
	public String getName()
    {
        return proxyURI.getID();
    }
}
