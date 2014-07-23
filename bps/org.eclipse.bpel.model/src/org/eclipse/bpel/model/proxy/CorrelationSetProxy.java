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

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.impl.CorrelationSetImpl;
import org.eclipse.bpel.model.util.BPELProxyURI;
import org.eclipse.emf.common.util.URI;


public class CorrelationSetProxy extends CorrelationSetImpl {

    private BPELProxyURI proxyURI;

    public CorrelationSetProxy(URI baseURI, String name) {
        proxyURI = new BPELProxyURI(BPELPackage.eINSTANCE.getCorrelationSet(), baseURI, new QName("process", name));
    }

    @Override
	public boolean eIsProxy() {
        return true;
    }

    @Override
	public URI eProxyURI() {
        return proxyURI.getProxyURI();
    }

    @Override
	public String getName() {
        return proxyURI.getQName().getLocalPart();
    }
}
