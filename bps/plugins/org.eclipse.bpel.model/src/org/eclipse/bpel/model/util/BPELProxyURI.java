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
package org.eclipse.bpel.model.util;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;

public final class BPELProxyURI {
	/** The resource that can resolve this proxy URI. */
	private URI baseURI = null;

	/** The optional proxy "mime" type. */
	private String proxyType = null;

	/** The Java type referenced by this proxy URI */
	private EClass type = null;

	private String typeName = null;

	/** The qName that identifies the referenced element. */
	private QName qName = null;

	private String optionalID = null;

	public BPELProxyURI(String proxyType, EClass type, URI baseURI, QName qName) {
		this(type, baseURI, qName);
		this.proxyType = proxyType;
	}

	public BPELProxyURI(EClass type, URI baseURI, QName qName) {
		this.type = type;
		this.typeName = type.getName();
		this.baseURI = baseURI;
		this.qName = qName;
		if (qName == null || qName.getNamespaceURI() == null
				|| qName.getNamespaceURI().equals("")) {
			// System.err.println("BPELProxyURI expects a QName with a
			// namespace: " + qName);
		}
	}

	public BPELProxyURI(EClass type, URI baseURI, QName qName, String optionalID) {
		this(type, baseURI, qName);
		this.optionalID = optionalID;
	}

	public BPELProxyURI(String uriFragment) {
		// The format of the uriFragment is:
		// [optionalProxyType:]typeName{namespace}localPart[:optionalID]
		//
		// The format of the qname {namespace}localPart is dependent upon the
		// implementation of QName.toString()
		// and the {namespace} part is optional so in theory this may not always
		// parse correctly.
		// The URIs we are dealing with may not have a namespace, so take this
		// into account.

		int qNameLHS = uriFragment.indexOf('{');
		int qNameRHS = uriFragment.indexOf('}', qNameLHS);
		int idLHS = uriFragment.indexOf(':', qNameRHS);
		if (qNameLHS > 0 && qNameRHS > qNameLHS) {
			int alRHS = uriFragment.substring(0, qNameLHS).indexOf(':');
			if (alRHS > 0) {
				this.proxyType = uriFragment.substring(0, alRHS);
				this.typeName = uriFragment.substring(alRHS + 1, qNameLHS);
			} else {
				this.typeName = uriFragment.substring(0, qNameLHS);
			}

			if (idLHS > 0) {
				this.qName = parseQName(uriFragment.substring(qNameLHS, idLHS));
				this.optionalID = uriFragment.substring(idLHS + 1);
			} else {
				this.qName = parseQName(uriFragment.substring(qNameLHS));
			}
		}
	}

	@SuppressWarnings("nls")
	private QName parseQName(String qNameAsString) {
    	
    	if (qNameAsString == null) {
    		throw new IllegalArgumentException("QName cannot be null");    		
    	}
    	
    	// We have to take care of the specification with null-namespace
    	// {}localPart - which is used in BPELProxyURI
    	try {
            int qNameLHS = qNameAsString.indexOf('{');
            int qNameRHS = qNameAsString.indexOf('}');
            
            // if we find a null-namespace, we have to preprocess it and strip
			// the {}, thus passing only the localPart to the
            // QName.valueOf() method.
            if (qNameRHS != -1 && qNameLHS != -1 && qNameRHS > qNameLHS) {
            	String namespace = qNameAsString.substring(qNameLHS+1, qNameRHS);
            	if (namespace == null || namespace.trim().equals("")) {
            		return QName.valueOf(qNameAsString.substring(qNameRHS+1));
            	}
            	return QName.valueOf(qNameAsString);
            }            
        } catch (Exception e) {
               BPELPlugin.log("Error parsing QName " + qNameAsString, e);   
        }
        return null;
        
    }

	public String getProxyType() {
		return proxyType;
	}

	public String getTypeName() {
		return typeName;
	}

	public QName getQName() {
		return qName;
	}

	public String getID() {
		return optionalID;
	}

	public String getFragment() {
		// The qname may or may not have a namespace. In the case that it
		// doesn't,
		// we still need the fragment URI string to contain {} so that our
		// parsing
		// algorithm works correctly. If necessary, insert it now.
		String fragmentQName = qName.toString();
		if (qName.getNamespaceURI() == null
				|| qName.getNamespaceURI().length() == 0) {
			fragmentQName = "{}" + fragmentQName;
		}
		return (proxyType == null ? "" : proxyType + ":") + typeName
				+ fragmentQName + (optionalID == null ? "" : ":" + optionalID);
	}

	public URI getProxyURI() {
		return baseURI.appendFragment(getFragment());
	}

	@Override
	public String toString() {
		return super.toString() + "[baseURI=" + baseURI + ", proxyType="
				+ proxyType + ", typeName=" + typeName + ", qName=" + qName
				+ ", optionalID=" + optionalID + "]";
	}
}
