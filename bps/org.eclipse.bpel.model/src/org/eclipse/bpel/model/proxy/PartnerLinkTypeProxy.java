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

import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.model.partnerlinktype.impl.PartnerLinkTypeImpl;
import org.eclipse.bpel.model.util.BPELProxyURI;
import org.eclipse.emf.common.util.URI;


public class PartnerLinkTypeProxy extends PartnerLinkTypeImpl implements IBPELServicesProxy
{
    private BPELProxyURI proxyURI;

    public PartnerLinkTypeProxy(URI baseURI, QName qname)
    {
        proxyURI = new BPELProxyURI(PartnerlinktypePackage.eINSTANCE.getPartnerLinkType(), baseURI, qname);
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

    public QName getQName()
    {
        return proxyURI.getQName();
    }
}