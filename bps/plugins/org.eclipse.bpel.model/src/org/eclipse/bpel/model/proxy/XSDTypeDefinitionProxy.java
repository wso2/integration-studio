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
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.impl.XSDTypeDefinitionImpl;


public class XSDTypeDefinitionProxy extends XSDTypeDefinitionImpl
{
    private BPELProxyURI proxyURI;
	
	public XSDTypeDefinitionProxy(URI baseURI, QName qName)
	{
	    proxyURI = new BPELProxyURI(XSDPackage.eINSTANCE.getXSDTypeDefinition(), baseURI, qName);
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
	public String getTargetNamespace()
    {
    	return proxyURI.getQName().getNamespaceURI();
    }
	
	@Override
	public String getName()
	{
	    return proxyURI.getQName().getLocalPart();
	}
}
