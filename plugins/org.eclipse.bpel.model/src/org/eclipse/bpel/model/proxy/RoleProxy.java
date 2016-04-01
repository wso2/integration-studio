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
import org.eclipse.bpel.model.partnerlinktype.impl.RoleImpl;
import org.eclipse.bpel.model.util.BPELProxyURI;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;


public class RoleProxy extends RoleImpl
{
    private BPELProxyURI proxyURI;

    public RoleProxy(Resource resource, PartnerLinkTypeProxy plt, String name)
    {
        URI baseURI = resource.getURI();
        proxyURI = new BPELProxyURI(PartnerlinktypePackage.eINSTANCE.getRole(), baseURI, plt.getQName(), name);
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
    
    @Override
	public String getName()
    {
        return proxyURI.getID();
    }
}
