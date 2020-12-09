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
package org.eclipse.bpel.model.extensions;

import java.util.HashMap;
import java.util.Map;

import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionDeserializer;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.ExtensionSerializer;
import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EPackage;

/**
 * An extension registry for BPEL extensions instead of WSDL extensions.
 */

@SuppressWarnings("nls")

public class BPELExtensionRegistry extends ExtensionRegistry 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2780795931782427742L;
	
	protected Map<String,ServiceReferenceSerializer> serviceReferenceSerializers;
	protected Map<String,ServiceReferenceDeserializer> serviceReferenceDeserializers;
	
	protected Map<QName,BPELActivitySerializer> activitySerializers;
	protected Map<QName,BPELActivityDeserializer> activityDeserializers;
	
	/** Extension registry instance */
	public static BPELExtensionRegistry INSTANCE;

	private BPELExtensionRegistry() {
		serviceReferenceSerializers = new HashMap<String,ServiceReferenceSerializer> ();
		serviceReferenceDeserializers = new HashMap<String,ServiceReferenceDeserializer>();
		
		activitySerializers = new HashMap<QName,BPELActivitySerializer>();		
		activityDeserializers = new HashMap<QName,BPELActivityDeserializer>();
	}
	
	/** 
	 * @return Returns a singleton instance. 
	 */
	public synchronized static BPELExtensionRegistry getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BPELExtensionRegistry();
			INSTANCE.setDefaultDeserializer(new BPELUnknownExtensionDeserializer());
			INSTANCE.setDefaultSerializer(new BPELUnknownExtensionSerializer());
		}
		return INSTANCE;
	}
	
	/**
	 * @see javax.wsdl.extensions.ExtensionRegistry#createExtension(Class, QName)
	 */
	@Override
	public ExtensibilityElement createExtension (Class parentType, QName qname) throws WSDLException {
		
		// Make sure that the EMF package corresponding to the given namespace is initialized
		EPackage.Registry.INSTANCE.getEPackage(qname.getNamespaceURI());
		
		return super.createExtension(parentType, qname);
	}

	/**
	 * @see javax.wsdl.extensions.ExtensionRegistry#queryDeserializer(Class, QName)
	 */
	@Override
	public ExtensionDeserializer queryDeserializer (Class parentType, QName qname) throws WSDLException {

		// Make sure that the EMF package corresponding to the given namespace is initialized
		EPackage.Registry.INSTANCE.getEPackage(qname.getNamespaceURI());
		
		return super.queryDeserializer(parentType, qname);
	}

	/**
	 * @see javax.wsdl.extensions.ExtensionRegistry#querySerializer(Class, QName)
	 */
	@Override
	public ExtensionSerializer querySerializer (Class parentType, QName qname) throws WSDLException {

		// Make sure that the EMF package corresponding to the given namespace is initialized
		EPackage.Registry.INSTANCE.getEPackage(qname.getNamespaceURI());
		
		return super.querySerializer(parentType, qname);
	}

	/**
	 * @param es must be a {@link BPELExtensionSerializer}
	 */
	
	@Override
	public void registerSerializer (Class parentType, QName elementType, ExtensionSerializer es) {
		
        if (!(es instanceof BPELExtensionSerializer)) {
            throw new IllegalArgumentException("ExtensionSerializer is not a BPELExtensionSerializer");
        }
        super.registerSerializer(parentType, elementType, es);
    }
	
	/**
	 * @param ed deserializer must be a {@link BPELExtensionDeserializer}
	 */
	@Override
	public void registerDeserializer(Class parentType, QName elementType, ExtensionDeserializer ed) {
	    if (!(ed instanceof BPELExtensionDeserializer)) {
	        throw new IllegalArgumentException("ExtensionDeserializer is not a BPELExtensionDeserializer");
	    }
        super.registerDeserializer(parentType, elementType, ed);
    }
	
	/**
	 * @param referenceScheme
	 * @param serializer
	 */
	public void registerServiceReferenceSerializer(String referenceScheme, ServiceReferenceSerializer serializer) {
		serviceReferenceSerializers.put(referenceScheme, serializer);
	}

	/**
	 * @param referenceScheme
	 * @param deserializer
	 */
	public void registerServiceReferenceDeserializer(String referenceScheme, ServiceReferenceDeserializer deserializer) {
		serviceReferenceDeserializers.put(referenceScheme, deserializer);
	}
	
	/**
	 * @param referenceScheme
	 * @return return the ServiceReferenceSerializer for the given reference scheme.
	 */
	public ServiceReferenceSerializer getServiceReferenceSerializer(String referenceScheme) {
		if (referenceScheme == null) {
			return null;
		}
		return serviceReferenceSerializers.get(referenceScheme);
	}

	/**
	 * @param referenceScheme
	 * @return return the ServiceReferenceDeserializer for the given reference scheme.
	 */
	public ServiceReferenceDeserializer getServiceReferenceDeserializer(String referenceScheme) {
		if (referenceScheme == null) {
			return null;
		}
		return serviceReferenceDeserializers.get(referenceScheme);
	}
	
	/**
	 * Register activity serializer.
	 * 
	 * @param qname
	 * @param serializer
	 */
	public void registerActivitySerializer (QName qname, BPELActivitySerializer serializer) {
		activitySerializers.put(qname, serializer);
	}

	/**
	 * @param qname
	 * @param deserializer
	 */
	public void registerActivityDeserializer (QName qname, BPELActivityDeserializer deserializer) {
		activityDeserializers.put(qname, deserializer);
	}
	
	/**
	 * @param qname
	 * @return return the activity serializer.
	 */
	public BPELActivitySerializer getActivitySerializer(QName qname) {
		if (qname == null) {
			return null;
		}
		return activitySerializers.get(qname);
	}

	/**
	 * @param qname
	 * @return return the activity deserializer.
	 */
	public BPELActivityDeserializer getActivityDeserializer(QName qname) {
		if (qname == null) {
			return null;
		}
		return activityDeserializers.get(qname);
	}	
}