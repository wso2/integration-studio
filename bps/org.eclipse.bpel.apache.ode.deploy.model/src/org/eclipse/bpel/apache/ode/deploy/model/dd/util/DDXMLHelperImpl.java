/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.model.dd.util;

import java.util.List;
import java.util.StringTokenizer;

import javax.wsdl.PortType;
import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;

public class DDXMLHelperImpl extends XMLHelperImpl {

	protected boolean bIsNewQName = false;
	protected QName   m_qName   	  = null;

	public DDXMLHelperImpl() {
		super();
	}

	public DDXMLHelperImpl(XMLResource resource) {
		super(resource);
	}

	protected Object createFromString(EFactory eFactory, EDataType eDataType, String value) {
		Object obj = eFactory.createFromString(eDataType, value);          
		if (extendedMetaData != null)
		{          
			if (obj instanceof List)
			{
				@SuppressWarnings("unchecked")        
				List<Object> list = (List<Object>)obj;
				for (int i = 0; i < list.size(); i++)
				{
					Object item = list.get(i);
					Object replacement = updateQNameURI(item);
					if (replacement != item)
					{
						list.set(i, replacement);
					}
				}
			}
			else
			{
				obj = updateQNameURI(obj);
			}
		}

		if (bIsNewQName) {
			bIsNewQName = false;
			return m_qName;
		} else
			return obj;
	}

	protected String updateQNamePrefix(EFactory factory, EDataType dataType, Object value, boolean list) {
		
		if (value instanceof PortType) {
			QName qname = ((PortType) value).getQName();
			return handleQName(list, qname);
		} 
			
		if (value instanceof QName) {
			return handleQName(list, (QName) value);
		}

		if (list == false) {
			return factory.convertToString(dataType, value);
		} else {
			return null;
		}
	}

	private String handleQName(boolean list, QName qname) {

		String namespace = qname.getNamespaceURI();
		
		if (namespace.length() == 0) {
			return qname.getLocalPart();
		}
		
		EPackage ePackage = extendedMetaData.getPackage(namespace);
		if (ePackage == null) {
			ePackage = extendedMetaData.demandPackage(namespace);
		}

		String prefix = getPrefix(ePackage, true);
		
		if (!packages.containsKey(ePackage)) {
			packages.put(ePackage, prefix);
		}

		if (list == false) {
			//generate a string out of prefix and local Part, separated by :
			String qNameString = new StringBuffer(prefix).append(":").append(qname.getLocalPart()).toString();
			return qNameString;
		} else
			return null;
	}

	protected Object updateQNameURI(Object value)
	{			
		int i=1;
		String strPrefix = null;
		String strLocalName = null;
		String strNamespace = null;
		
		if ( value instanceof QName )
		{
			QName qname = (QName) value;
			strLocalName = qname.getLocalPart();
			strPrefix = qname.getPrefix();

			if (strPrefix == null) {
				//try to parse the prefix get Prefix 
				StringTokenizer tokenizer = new StringTokenizer(strLocalName, ":");
				if (tokenizer.countTokens() > 1) 
				{ 
					while (tokenizer.hasMoreTokens())
					{
						String tmp = tokenizer.nextToken();
						if (i == 1)
							strPrefix = tmp;
						else
							strLocalName = tmp;
						i++;
					}
				}
			}
			
			if (strPrefix == null)  {
				//the string that got passed in does not have a prefix ... and we couldn't parse it... let's see if there is a default XML namespace defined that we could use
				String defaultXMLNamespace = (String) prefixesToURIs.get("");
				if (defaultXMLNamespace != null) 
				{
					if (!(defaultXMLNamespace.equalsIgnoreCase(org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage.eNS_URI))) 
					{
						//a default XML namespace exists, and it is NOT set to the ODE DeploymentDescriptor.eNS_URI - 
						//lets try to use this as namespace URI for the QName to properly support null namespaces 
						strNamespace = defaultXMLNamespace;
						strPrefix = "DEFAULT_NS";
					}
				}	
			}

			// it should always be null, except in cases where no WSDL prefix has been defined 
			if (strNamespace == null) 
			{
				strNamespace = getURI(strPrefix);
			}

			m_qName = new QName(strNamespace, strLocalName);
			bIsNewQName = true;

			if (strPrefix.length() >0 && m_qName.getNamespaceURI().length() == 0)
			{          
				throw new IllegalArgumentException("The prefix '" + strPrefix + "' is not declared for the QName '" + qname.toString() + "'");
			}

			if (strNamespace == null)
			{
				seenEmptyStringMapping = true;
				String uri = (String)prefixesToURIs.get("");
				if (uri != null) {
					prefixesToURIs.put("", strNamespace);
					addNSDeclaration("", uri);          
				}
			} 
			return qname;
		}
		else {
		      return value;
	    }
	}

}
