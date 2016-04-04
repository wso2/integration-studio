/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.validator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.proxy.MessageProxy;
import org.eclipse.bpel.model.proxy.OperationProxy;
import org.eclipse.bpel.model.proxy.PartProxy;
import org.eclipse.bpel.model.proxy.PartnerLinkTypeProxy;
import org.eclipse.bpel.model.proxy.PortTypeProxy;
import org.eclipse.bpel.model.proxy.PropertyProxy;
import org.eclipse.bpel.model.proxy.RoleProxy;
import org.eclipse.bpel.model.proxy.XSDElementDeclarationProxy;
import org.eclipse.bpel.model.proxy.XSDTypeDefinitionProxy;
import org.eclipse.bpel.model.util.ImportResolver;
import org.eclipse.bpel.model.util.ImportResolverRegistry;
import org.eclipse.bpel.model.util.WSDLUtil;
import org.eclipse.bpel.model.util.XSDComparer;
import org.eclipse.bpel.model.util.XSDUtil;
import org.eclipse.bpel.validator.factory.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Fault;
import org.eclipse.wst.wsdl.Input;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Output;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;

/**
 * 
 * This class glues the validator code to the EMF model and performs various queries
 * on the model.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 13, 2006
 *
 */

@SuppressWarnings("nls")

public class EmfModelQuery {
		
	static final String CONTEXT_MSG = "The EMF context object object cannot be null";

	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// https://jira.jboss.org/browse/JBIDE-7351
	// we need an instance of this so we can get diagnostics for error reporting
	XSDComparer xsdComparer;
	
	
	public EmfModelQuery() {
		xsdComparer = new XSDComparer();
		// if debug mode is set in the builder, force XSD comparison
		xsdComparer.setDebug(AdapterFactory.DEBUG);
	}
	
	public XSDComparer getXSDComparer() {
		return xsdComparer;
	}
	
	/**
	 * @param eObj
	 * @param qname
	 * @return the partner link type
	 */
	
	public static EObject lookupPartnerLinkType (EObject eObj, QName qname) {

		EObject top = getRoot ( eObj );
		
		if (top instanceof Definition) {
			return WSDLUtil.resolveBPELPartnerLinkType((Definition) top, qname);
		}
		if (top instanceof Process) {		
			return scanImports ( (Process) top, qname, WSDLUtil.BPEL_PARTNER_LINK_TYPE );
		}
		return null;
	}

	/**
	 * @param eObj
	 * @param qname
	 * @return the port type, or null if it cannot be found.
	 */
	
	public static EObject lookupPortType (EObject eObj, QName qname) {
		
		EObject top = getRoot ( eObj );	
		
		// Look within this definition
		if (top instanceof Definition) {			
			return WSDLUtil.resolvePortType((Definition) top, qname);
		}
		
		// Look within imports of process
		if (top instanceof Process) {			
			return scanImports ( (Process) top, qname, WSDLUtil.WSDL_PORT_TYPE );			
		}		
		return null;
	}

	/**
	 * Lookup the XSD type by the QName given.
	 * 
	 * @param eObj
	 * @param qname
	 * @return the XSD Type
	 */
	
	public static EObject lookupXSDType (EObject eObj, QName qname) {
		
		EObject top = getRoot ( eObj );
				
		// Look within this definition
		if (top instanceof Definition) {			
			return WSDLUtil.resolveXSDTypeDefinition((Definition) top, qname);
		}		
		// They could be in a schema as well
		if (top instanceof XSDSchema) {
			return XSDUtil.resolveTypeDefinition((XSDSchema) top, qname);
		}
		
		// Look within imports of process
		if (top instanceof Process) {			
			return scanImports ( (Process) top, qname, XSDUtil.XSD_TYPE_DEFINITION );			
		}		
		return null;
	}

	
	/**
	 * Lookup message by the QName given.
	 * 
	 * @param eObj the the object to query
	 * @param qname
	 * @return the message EOBject
	 */
	
	public static EObject lookupMessage (EObject eObj, QName qname) {
		
		EObject top = getRoot ( eObj );
		
		// Look within this definition
		if (top instanceof Definition) {			
			return WSDLUtil.resolveMessage( (Definition) top, qname);
		}
				
		// Look within imports of process
		if (top instanceof Process) {			
			return scanImports ( (Process) top, qname, WSDLUtil.WSDL_MESSAGE );			
		}
		return null;	
	}
	

	/**
	 * 
	 * @param eObj the reference context object.
	 * @param qname the QName of the declaration.
	 * @return the XSDElement for for the given name or null if it does not exist
	 */
	
	public static EObject lookupXSDElement(EObject eObj, QName qname) {
		
		EObject top = getRoot(eObj);		
		
		// Look within this definition
		if (top instanceof Definition) {			
			return WSDLUtil.resolveXSDElementDeclaration((Definition) top, qname);
		}
		// They could be in a schema as well
		if (top instanceof XSDSchema) {
			return XSDUtil.resolveElementDeclaration((XSDSchema) top, qname);
		}
		// Look within imports of process
		if (top instanceof Process) {			
			return scanImports ( (Process) top, qname, XSDUtil.XSD_ELEMENT_DECLARATION );			
		}		
		return null;
	}

	
	/**
	 * Since roles are part of a partner link type, the context object in this
	 * case must be the partner link type object.
	 *  
	 * @param eObj
	 * @param name
	 * @return the role object.
	 */
	
	
	@SuppressWarnings("nls")
	public static EObject lookupRole (EObject eObj, String name) {
		assertTrue(eObj != null, "Context object cannot be null");
		
		if (eObj instanceof PartnerLink) {
			eObj = ((PartnerLink)eObj).getPartnerLinkType();
		}
		
		if (eObj instanceof PartnerLinkType) {			
			return WSDLUtil.findRole ( (PartnerLinkType) eObj , name );
		}
		
		return null;
	}



	/**
	 * 
	 * @param eObj the context object.
	 * @param name the name of the operation.
	 * @return the operation or null
	 */
	
	@SuppressWarnings("nls")
	public static EObject lookupOperation (EObject eObj, String name) {
		
		assertTrue(eObj != null, CONTEXT_MSG);
		
		// partner link -> partner link type
		if (eObj instanceof PartnerLink) {
			eObj = ((PartnerLink) eObj).getPartnerLinkType();			
		}

		// if partner link type -> it has to be an operation on one of the roles
		// 
		if (eObj instanceof PartnerLinkType) {			
			PartnerLinkType plt = (PartnerLinkType) eObj;
			// This is a bit screwy. The partner link can have potentially 2 roles.
			for(Object n : plt.getRole()) {
				Role r = (Role) n;			
				eObj = lookupOperation(r, name);
				if (eObj != null) {
					return eObj;
				}
			}					
		}
		
		if (eObj instanceof Role) {
			return lookupOperation((Role) eObj, name);
		}
		return null;
	}
	
	
	
	static EObject lookupOperation (Role role, String name) {
		
		// a role has the port type which must have the operation		
		PortType portType = (PortType) role.getPortType();				
		return WSDLUtil.findOperation(portType,name);				
	}
	

	
	/**
	 * @param eObj
	 * @param qname
	 * @param axis the axis to use
	 * @return the reference to the name step lookup.
	 */
	
	public static EObject lookupNameStep (EObject eObj, QName qname, int axis ) {
		
		assertTrue(eObj != null,CONTEXT_MSG);
		
		eObj = resolveNameStepContext (eObj);
		
		/** 
		 * This is the meat of this method. Once we have the element declaration and
		 * type we should be able to ascertain if the QName step passed is correct.
		 */
		
		if (eObj instanceof XSDElementDeclaration) {
			// This is the case where we may have something like (^^ denotes context) 
			//   $foo.payload/tns:bar/tns:foo
			//                ^^^^^^^
			XSDElementDeclaration elm = (XSDElementDeclaration) eObj;
			// check if this step is valid or not			
			eObj = elm.getType();
		}
		
		eObj = XSDUtils.getEnclosingTypeDefinition(eObj);
		
		String localName = qname.getLocalPart();
		String nsURI = qname.getNamespaceURI();
		
		// (VZ) FIXME: this condition will always be true. To be reviewed!
		if (eObj instanceof XSDComplexTypeDefinition) {
			
			XSDComplexTypeDefinition type = (XSDComplexTypeDefinition) eObj;
			
			// System.out.println("_______ Looking for: " + qname );
			// System.out.println("Type: " + type.getName() + "{" + type.getTargetNamespace() + "}");
			
			if (axis == 0) {
				// Look in the child elements
				for(Object item : XSDUtils.getChildElements(type)) {
					XSDElementDeclaration next = (XSDElementDeclaration) item;				
					// System.out.println("Element Declaration: " + next.getName() + "{" + next.getTargetNamespace() + "}");
					if (localName.equals( next.getName()) && sameNamespace(nsURI,next.getTargetNamespace())) {
						return next.getType();
					}
				}
			} else if (axis == 1) {
				
				// Look in attributes
				for(XSDAttributeDeclaration next : XSDUtils.getChildAttributes( type )) {
					if (localName.equals( next.getName()) && sameNamespace(nsURI,next.getTargetNamespace())) {
						return next.getType();
					}
				}
				
			}
			
			
		} else if (eObj instanceof XSDSimpleTypeDefinition) {
			
			XSDSimpleTypeDefinition type = (XSDSimpleTypeDefinition) eObj;
			if (localName.equals ( type.getName() ) && sameNamespace(nsURI,type.getTargetNamespace()) ) {					
				return type;
			}
			
		}
		
		return null;
	}


	
	static EObject resolveNameStepContext ( EObject eObj ) {
		
		if (eObj instanceof Variable) {
			// This is the case where we may have something like (^^ denotes context) 
			//   $foo/tns:bar
			//    ^^^
			Variable v = (Variable) eObj;
			eObj = v.getXSDElement();
			if (eObj == null) {
				eObj = v.getType();
			}
			if (eObj == null) {
				eObj = v.getMessageType();
			}
		}

		// WSDL Message
		if (eObj instanceof Message) {
			Message msg = (Message) eObj;
			List<?> parts = msg.getEParts();
			if (parts.size() == 1) {
				eObj = (Part) parts.get(0);
			}			
		}
		
		// Part of a message
		if (eObj instanceof Part) {
			// This is the case where we may have something like (^^ denotes context) 
			//   $foo.payload/tns:bar 
			//        ^^^^^^^
			Part part = (Part) eObj;
			eObj = part.getElementDeclaration();
			if (eObj == null) {
				eObj = part.getTypeDefinition();
			}			
		}

		return eObj;
	}
	
	
	/**
	 * @param eObj
	 * @param name
	 * @return the message part 
	 */
	
	@SuppressWarnings("nls")
	public static EObject lookupMessagePart (EObject eObj, String name) {
		assertTrue(eObj != null,CONTEXT_MSG);
		
		if (eObj instanceof Variable) {
			eObj = ((Variable)eObj).getMessageType();
		}		
		if (eObj instanceof Message) {						
			return WSDLUtil.findPart( (Message) eObj, name );
		}
		
		if (eObj instanceof Part) {
			return eObj;
		}
		return null;
	}

	
	/**
	 * Look up the import. Here we lookup the import to get either the schema or
	 * the WSDL definitions. If the context node is Import and the name is  
	 * @param eObj the reference object.
	 * @param name
	 * 
	 * @return the root of the model represented by this import.
	 */
	
	@SuppressWarnings("nls")
	public static EObject lookupImport (EObject eObj, String name) {
		
		assertTrue( eObj != null, CONTEXT_MSG );
		
		if (eObj instanceof Import) {
			
			Import imp = (Import) eObj;
			                         	   
    	    for (ImportResolver r : ImportResolverRegistry.INSTANCE.getResolvers(imp.getImportType()) ) {
    	    	EObject result =  r.resolve(imp,null,null,ImportResolver.TOP);
    	    	if (result != null) {
                    return result;
                }
    	    }
		}
		
		return null;
	}


	
	/**
	 * Get the root element in the resource.
	 * 
	 * @param eObj
	 * @return the root object 
	 * @see https://issues.jboss.org/browse/JBIDE-8088 - made public
	 */
	@SuppressWarnings("nls")
	public static EObject getRoot ( EObject eObj ) {
	
		assertTrue( eObj != null, CONTEXT_MSG );
		EObject top = eObj;
		while( top != null && top.eContainer() != null ) {
			top = top.eContainer();
		}		
		
		assertTrue( top != null, "The top object cannot be null" );
		return top ;
	}
	
	/**
	 * Scan the imports and resolve the items requested.
	 * 
	 * @param process
	 * @param qname
	 * @param refType
	 * @return the object resolved by scanning the imports.
	 */
	
	static EObject scanImports (  Process process, QName qname , String refType ) {
		
		EObject result = null;
		
		for(Object n : process.getImports()) {
            Import imp = (Import) n;                                    
            if (imp.getLocation() == null ) {
            	continue;
            }
            
    	    ImportResolver[] resolvers = ImportResolverRegistry.INSTANCE.getResolvers(imp.getImportType());
    	    for(ImportResolver r : resolvers) {
                result = r.resolve(imp, qname, null, refType);
                if (result != null) {
                	return result;
                }                
            }
    	    
        } 
        
        return null;
	}

	/**
	 * Search all process imports for the given QName reference
	 * 
	 * @param process
	 * @param qname
	 * @param refType
	 * @return list of Imports
	 * @see https://issues.jboss.org/browse/JBIDE-8088 - added
	 */
	public static List<Import> scanAllImports (  Process process, QName qname , String refType ) {
		
		List<Import> imports = new ArrayList<Import>();
		EObject result = null;
		
		for(Object n : process.getImports()) {
            Import imp = (Import) n;                                    
            if (imp.getLocation() == null ) {
            	continue;
            }
            
    	    ImportResolver[] resolvers = ImportResolverRegistry.INSTANCE.getResolvers(imp.getImportType());
    	    for(ImportResolver r : resolvers) {
                result = r.resolve(imp, qname, null, refType);
                if (result != null) {
                	imports.add(imp);
                }                
            }
    	    
        } 
        
        return imports;
	}

	public static EObject resolveProxy( Process process, EObject obj) {
		if (obj instanceof MessageProxy) {
			return scanImports ( process, ((MessageProxy)obj).getQName(), WSDLUtil.WSDL_MESSAGE );
		}
		else if (obj instanceof PortTypeProxy) {
			return scanImports ( process, ((PortTypeProxy)obj).getQName(), WSDLUtil.WSDL_PORT_TYPE );
		}
		else if (obj instanceof PartnerLinkTypeProxy) {
			return scanImports ( process, ((PartnerLinkTypeProxy)obj).getQName(), WSDLUtil.BPEL_PARTNER_LINK_TYPE );
		}
		else if (obj instanceof RoleProxy) {
			return scanImports ( process, ((RoleProxy)obj).getQName(), WSDLUtil.BPEL_ROLE );
		}
		else if (obj instanceof PropertyProxy) {
			return scanImports ( process, ((PropertyProxy)obj).getQName(), WSDLUtil.BPEL_PROPERTY );
		}
		else if (obj instanceof OperationProxy) {
			QName qname = new QName(((OperationProxy)obj).getName());
			return scanImports ( process, qname, WSDLUtil.WSDL_OPERATION );
		}
		else if (obj instanceof PartProxy) {
			QName qname = new QName(((PartProxy)obj).getName());
			return scanImports ( process, qname, WSDLUtil.WSDL_PART );
		}
		else if (obj instanceof XSDTypeDefinitionProxy) {
			QName qname = new QName(((XSDTypeDefinitionProxy)obj).getName());
			return scanImports ( process, qname, WSDLUtil.XSD_TYPE_DEFINITION );
		}
		else if (obj instanceof XSDElementDeclarationProxy) {
			QName qname = new QName(((XSDElementDeclarationProxy)obj).getName());
			return scanImports ( process, qname, WSDLUtil.XSD_ELEMENT_DECLARATION );
		}
		return obj;
	}

	static void assertTrue ( boolean mustBeTrue , String msg ) {
		if (!mustBeTrue) {
			throw new RuntimeException( msg );
		}
	}
	
	
	static boolean isEmpty ( String value ) {
    	return value == null || value.length() == 0;
    }

	/**
	 * Check compatible partner activity type.
	 * 
	 * @param src
	 * @param dst
	 * @return true if compatible, false if not.
	 */
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// https://jira.jboss.org/browse/JBIDE-7351
	// no longer static because of xsdComparer object
	public boolean compatiblePartnerActivityMessages (EObject src, EObject dst) {
		
		assertTrue(src != null, CONTEXT_MSG);
		assertTrue(dst != null, CONTEXT_MSG);
		
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7116
		// quick exit
		// https://jira.jboss.org/browse/JBIDE-7351
		// ...unless we're in debug mode!
		if (AdapterFactory.DEBUG==false)
			if (src==dst)
				return true;
		
		Message srcMsg = null;
		Message dstMsg = null;
		
		if (src instanceof Message) {
			srcMsg = (Message) src;			
		}
		if (dst instanceof Message) {
			dstMsg = (Message) dst;
		}
		
		// both messages, and both non null - check if same.
		if (srcMsg != null && dstMsg != null) {
			// https://jira.jboss.org/browse/JBIDE-7116
			return compatibleType(srcMsg, dstMsg);
		}
		
		// either source OR destination is not a message, check for the XSDElement variant.
		
		XSDElementDeclaration srcXSD = null;
		XSDElementDeclaration dstXSD = null;
		
		if (src instanceof XSDElementDeclaration) {
			srcXSD = (XSDElementDeclaration) src;
		}
		if (dst instanceof XSDElementDeclaration) {
			dstXSD = (XSDElementDeclaration) dst;
		}
		
		// source is XSD element, destination message may have 1 part defined as that element
		if (srcXSD != null && dstMsg != null) {
			
			List<?> parts = dstMsg.getEParts();
			if (parts.size() != 1) {
				return false;
			}
			
			Part part = (Part) parts.get(0);
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7116
			return compatibleType(srcXSD, part.getElementDeclaration());			
		}
		
		// destination is XSD element, source message may have 1 part defined as that element
		if (dstXSD != null && srcMsg != null) {
			
			List<?> parts = srcMsg.getEParts();
			if (parts.size() != 1) {
				return false;
			}
			
			Part part = (Part) parts.get(0);
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7116
			return compatibleType(dstXSD, part.getElementDeclaration());						
		}
		
		// otherwise, incompatible partner activity messages
		return false;
	}

	/**
	 * Lookup property by name.
	 * 
	 * @param eObj the reference object
	 * @param qname QName the name of the property
	 * @return the property 
	 */
	public static EObject lookupProperty(EObject eObj, QName qname) {
		
		EObject top = getRoot(eObj);		
		
		// Look within this definition
		if (top instanceof Definition) {			
			return WSDLUtil.resolveBPELProperty((Definition) top, qname);
		}
		// Look within imports of process
		if (top instanceof Process) {			
			return scanImports ( (Process) top, qname, WSDLUtil.BPEL_PROPERTY );			
		}		
		return null;
	}

	/**
	 * @param src the source type
	 * @param dst the destination type
	 * @return if the types are compatible, false otherwise
	 */
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// https://jira.jboss.org/browse/JBIDE-7351
	// no longer static because of xsdComparer object
	public boolean compatibleType(EObject src, EObject dst) {
		assertTrue(src != null, CONTEXT_MSG);
		assertTrue(dst != null, CONTEXT_MSG);
		
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7116
		// quick exit
		if (AdapterFactory.DEBUG==false)
			if (src==dst)
				return true;
		
		Message srcMsg = null;
		Message dstMsg = null;
		
		if (src instanceof Message) {
			srcMsg = (Message) src;			
		}
		if (dst instanceof Message) {
			dstMsg = (Message) dst;
		}
		
		// both messages, and both non null - check if same.
		if (srcMsg != null && dstMsg != null) {
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7116
			return compatibleType(srcMsg, dstMsg);
		}
		
		// either source OR destination is not a message, check for the XSDElement variant.
		
		XSDElementDeclaration srcXSD = null;
		XSDElementDeclaration dstXSD = null;
		
		if (src instanceof XSDElementDeclaration) {
			srcXSD = (XSDElementDeclaration) src;
		}
		if (dst instanceof XSDElementDeclaration) {
			dstXSD = (XSDElementDeclaration) dst;
		}
		
		if (srcXSD != null && dstXSD != null) {
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7116
			return compatibleType(srcXSD, dstXSD);
		}
		
		XSDTypeDefinition srcType = null;
		XSDTypeDefinition dstType = null;
		
		if (src instanceof XSDTypeDefinition) {
			srcType = (XSDTypeDefinition) src;
		}
		if (dst instanceof XSDTypeDefinition) {
			dstType = (XSDTypeDefinition) dst;
		}
		
		if (srcType != null && dstType != null) {
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7116
			// https://jira.jboss.org/browse/JBIDE-7351
			// use XSDComparer
			if (xsdComparer.compare(srcType,dstType)) {
				return true;
			}

			// construct a new comparer to prevent the original
			// diagnostics from being cleared
			XSDComparer comp = new XSDComparer();
			
			// check if src is derived from dst.
			//   1) src is NCName, dst is string --> compatible.
			//   2) reverse is not always true			
			XSDTypeDefinition baseType = srcType.getBaseType();			
			do {
				// System.out.println("Checking: " + dstType + " against baseType: " + baseType);
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
				// https://jira.jboss.org/browse/JBIDE-7116
				if (comp.compare(baseType,dstType)) {
					return true;
				}
				baseType = baseType.getBaseType();
			} while (baseType!=baseType.getBaseType());
			
			return false;
		}
		
		PortType srcPort = null;
		PortType dstPort = null;
		if (src instanceof PortType)
			srcPort = (PortType)src;
		if (dst instanceof PortType)
			dstPort = (PortType)dst;
		if (srcPort != null && dstPort != null)
			return compatibleType(srcPort, dstPort);
		
		// otherwise, incompatible partner activity messages
		return false;
	}
	
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// https://jira.jboss.org/browse/JBIDE-7116
	// new: compare contents of messages
	// https://jira.jboss.org/browse/JBIDE-7351
	// no longer static because of xsdComparer object
	public boolean compatibleType(Message src, Message dst) {
		assertTrue(src != null, CONTEXT_MSG);
		assertTrue(dst != null, CONTEXT_MSG);
		
		if (AdapterFactory.DEBUG==false)
			if (src==dst)
				return true;
		
		if (!src.getQName().equals(dst.getQName()))
			return false;

		if (src.eResource().getURI().equals(dst.eResource().getURI()))
			return true;
		
		EList<Part> parts1 = src.getEParts();
		EList<Part> parts2 = dst.getEParts();
		if (parts1.size() != parts2.size())
			return false;
		
		for (int i=0; i<parts1.size(); ++i) {
			Part part1 = parts1.get(i);
			Part part2 = parts2.get(i);
			if (!part1.getName().equals(part2.getName()))
				return false;
			if (!compatibleType(part1.getTypeDefinition(), part2.getTypeDefinition()))
				return false;
		}
		
		return true;
	}
	
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// https://jira.jboss.org/browse/JBIDE-7116
	// new: compare XSDElementDeclaractions
	// https://jira.jboss.org/browse/JBIDE-7351
	// no longer static because of xsdComparer object
	public boolean compatibleType(XSDElementDeclaration src, XSDElementDeclaration dst) {
		assertTrue(src != null, CONTEXT_MSG);
		assertTrue(dst != null, CONTEXT_MSG);
		
		if (AdapterFactory.DEBUG==false)
			if (src==dst)
				return true;
		
		return compatibleType(src.getTypeDefinition(),dst.getTypeDefinition());
	}
	
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// https://jira.jboss.org/browse/JBIDE-7116
	// new: compare XSDTypeDefinitions
	// https://jira.jboss.org/browse/JBIDE-7351
	// no longer static because of xsdComparer object
	public boolean compatibleType(XSDTypeDefinition src, XSDTypeDefinition dst) {
		assertTrue(src != null, CONTEXT_MSG);
		assertTrue(dst != null, CONTEXT_MSG);
		
		if (AdapterFactory.DEBUG==false)
			if (src==dst)
				return true;

		return xsdComparer.compare(src,dst);
	}
	
	// https://jira.jboss.org/browse/JBIDE-7116
	// new: compare PortTypes
	// https://jira.jboss.org/browse/JBIDE-7351
	// no longer static because of xsdComparer object
	public boolean compatibleType(PortType src, PortType dst) {
		assertTrue(src != null, CONTEXT_MSG);
		assertTrue(dst != null, CONTEXT_MSG);
		
		if (AdapterFactory.DEBUG==false)
			if (src==dst)
				return true;
		
		// do portTypes have to be defined in the same WSDL?
//		URI uri1 = src.eResource().getURI();
//		URI uri2 = dst.eResource().getURI();
//		if ( !src.eResource().getURI().equals(dst.eResource().getURI()) )
//			return false;
		
		// check names
		if (src.getQName()==null || !src.getQName().equals(dst.getQName()))
			return false;
		
		// check operations
		EList<Operation> ops1 = src.getEOperations();
		EList<Operation> ops2 = dst.getEOperations();
		if (ops1.size()!=ops2.size())
			return false;
		for (int i=0; i<ops1.size(); ++i) {
			Operation op1 = ops1.get(i);
			Operation op2 = ops2.get(i);
			if (!compatibleType(op1, op2))
				return false;
		}
		return true;
	}
	
	// https://jira.jboss.org/browse/JBIDE-7116
	// new: compare Operations
	// https://jira.jboss.org/browse/JBIDE-7351
	// no longer static because of xsdComparer object
	public boolean compatibleType(Operation src, Operation dst) {
		assertTrue(src != null, CONTEXT_MSG);
		assertTrue(dst != null, CONTEXT_MSG);
		
		if (AdapterFactory.DEBUG==false)
			if (src==dst)
				return true;
		
		if (src.getName()==null || !src.getName().equals(dst.getName()))
			return false;
		
		if (!src.getStyle().equals(dst.getStyle()))
			return false;
		
		// check inputs, outputs and faults
		Input in1 = src.getEInput();
		Input in2 = dst.getEInput();
		if (in1!=null && in2!=null) {
			if (!compatibleType(in1.getEMessage(), in2.getEMessage()))
				return false;
		}
		else if ( (in1==null) != (in2==null) )
			return false;
		
		Output out1 = src.getEOutput();
		Output out2 = dst.getEOutput();
		if (out1!=null && out2!=null) {
			if (!compatibleType(out1.getEMessage(), out2.getEMessage()))
				return false;
		}
		else if ( (out1==null) != (out2==null) )
			return false;
		
		EList<Fault> faults1 = src.getEFaults();
		EList<Fault> faults2 = dst.getEFaults();
		if (faults1.size() != faults2.size())
			return false;
		for (int i=0; i<faults1.size(); ++i) {
			if (!compatibleType(faults1.get(i).getEMessage(), faults2.get(i).getEMessage()))
				return false;
		}
		return true;
	}
	/**
	 * @param eObj the object
	 * @return returns if simple type, false otherwise.
	 */
	
	public static boolean isSimpleType(EObject eObj) {
		assertTrue(eObj != null, CONTEXT_MSG);
		
		if (eObj instanceof XSDSimpleTypeDefinition) {
			return true;
		}
		return false;
	}

	/**
	 * Lookup type of the part of the message.
	 * @param eObj the reference object
	 * @param qname the part name.
	 * @return the type of the part
	 */
	
	public static EObject lookupTypeOfPart (EObject eObj, QName qname) {
		EObject obj = lookupMessagePart(eObj, qname.getLocalPart());
		if (obj == null || obj instanceof Part == false) {
			return null;
		}
		Part part = (Part) obj;
		if (part.getElementDeclaration() != null) {
			return part.getElementDeclaration().getTypeDefinition();
		}
		return part.getTypeDefinition();
	}
	
	
	/**
	 * An null NS URI is the default namespace "". 
	 * EMF seems to return null as the default target namespace.
	 * 
	 * @param nsURI
	 * @param nsURI2
	 * @return true if the namespaces are the same, false otherwise. 
	 */
	static boolean sameNamespace ( String nsURI, String nsURI2 ) {
		
		if (nsURI == null) {
			nsURI = XMLConstants.NULL_NS_URI;
		}
		if (nsURI2 == null) {
			nsURI2 = XMLConstants.NULL_NS_URI;
		}
		return nsURI.equals(nsURI2);
	}
	
}
