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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.wst.wsdl.Service;
import org.eclipse.wst.wsdl.Types;
import org.eclipse.wst.wsdl.WSDLPackage;
import org.eclipse.wst.wsdl.XSDSchemaExtensibilityElement;
import org.eclipse.wst.wsdl.internal.impl.ImportImpl;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.impl.XSDSchemaImpl;
import org.eclipse.xsd.util.XSDConstants;



/**
 * WSDLUtil supplies resolution (lookup) of various things that are useful in the BPEL
 * world.
 *
 */

public class WSDLUtil
{
	/** The WSDL Message attribute/name, most likely "message" */

    public static final String WSDL_MESSAGE = WSDLPackage.eINSTANCE.getMessage().getName();

    /** The WSDL Port Type attribute/name, most likely "portType" */
    public static final String WSDL_PORT_TYPE = WSDLPackage.eINSTANCE.getPortType().getName();

    /** The WSDL Operation attribute/name, most likely "operation" */
    public static final String WSDL_OPERATION = WSDLPackage.eINSTANCE.getOperation().getName();

    /** The WSDL Part attribute/name, most likely "part" */
    public static final String WSDL_PART = WSDLPackage.eINSTANCE.getPart().getName();

    /** The WSDL Service attribute/name, most likely "service" */
    public static final String WSDL_SERVICE = WSDLPackage.eINSTANCE.getService().getName();

    /** The XSD Type Definition attribute/name, most likely "type" */
    public static final String XSD_TYPE_DEFINITION = XSDPackage.eINSTANCE.getXSDTypeDefinition().getName();

    /** The XSD Element Declaration attribute/name, most likely "element" */
    public static final String XSD_ELEMENT_DECLARATION = XSDPackage.eINSTANCE.getXSDElementDeclaration().getName();

    /** The BPEL Partner Link Type attribute/name, most likely "partnerLinkType" */
    public static final String BPEL_PARTNER_LINK_TYPE = PartnerlinktypePackage.eINSTANCE.getPartnerLinkType().getName();

    /** The BPEL Role attribute/name, most likely "role" */
    public static final String BPEL_ROLE = PartnerlinktypePackage.eINSTANCE.getRole().getName();

    /** The BPEL Property attribute/name, most likely "property" */
    public static final String BPEL_PROPERTY = MessagepropertiesPackage.eINSTANCE.getProperty().getName();

    /** This should be a preference that can be easily turned on/off */
	private static boolean RESOLVING_DEEPLY = true;  // TODO: Preference based ?


    /**
     * Answer true if the type name passed is a WSDL thing.
     *
     * @param typeName
     * @return true if yes, false if no.
     */

    public static boolean isWSDLType(String typeName)
    {
        return typeName == null ? false :
            WSDL_MESSAGE.equals(typeName)
            || WSDL_PORT_TYPE.equals(typeName)
            || WSDL_OPERATION.equals(typeName)
            || WSDL_PART.equals(typeName)
            || WSDL_SERVICE.equals(typeName)
            || XSD_TYPE_DEFINITION.equals(typeName)
            || XSD_ELEMENT_DECLARATION.equals(typeName)
            || BPEL_PARTNER_LINK_TYPE.equals(typeName)
            || BPEL_ROLE.equals(typeName)
            || BPEL_PROPERTY.equals(typeName);
    }


    /**
     * Set to resolve deeply.
     * @param resolveDeeply
     */

    public static void setResolveDeeply ( boolean resolveDeeply ) {
    	RESOLVING_DEEPLY = resolveDeeply;
    }

    /**
     * Answer if resolving deeply.
     * @return answer true if resolving deeply, false otherwise.
     */

    public static boolean isResolvingDeeply () {
    	return RESOLVING_DEEPLY;
    }

    /**
     * Resolve with the given definition the QName given.
     * @param definition the definition to use.
     * @param qname the QName to resolve.
     * @param name
     * @param refType what to resolve (that things from WSDL that we can resolve).
     * @return  the EMF object that the QName resolves to.
     */

    public static EObject resolveWSDLReference(Definition definition, QName qname, String name, String refType)
    {
	    EObject resolvedObject = null;

	    if (WSDL_PORT_TYPE.equals(refType))  {
	        resolvedObject = resolvePortType(definition, qname);
	    } else if (WSDL_MESSAGE.equals(refType)) {
	        resolvedObject = resolveMessage(definition, qname);
	    } else if (WSDL_OPERATION.equals(refType))  {
	        resolvedObject = resolveOperation(definition, qname, name);
	    } else if (WSDL_PART.equals(refType)) {
	        resolvedObject = resolvePart(definition, qname, name);
	    } else if (WSDL_SERVICE.equals(refType)) {
            resolvedObject = resolveService(definition, qname);
        } else if (XSD_TYPE_DEFINITION.equals(refType)) {
	        resolvedObject = resolveXSDTypeDefinition(definition, qname);
	    } else if (XSD_ELEMENT_DECLARATION.equals(refType)) {
	        resolvedObject = resolveXSDElementDeclaration(definition, qname);
	    } else if (BPEL_PARTNER_LINK_TYPE.equals(refType)) {
	        resolvedObject = resolveBPELPartnerLinkType(definition, qname);
	    } else if (BPEL_ROLE.equals(refType)) {
            resolvedObject = resolveBPELRole(definition, qname, name);
        } else if (BPEL_PROPERTY.equals(refType)) {
	        resolvedObject = resolveBPELProperty(definition, qname);
	    } else {
	        System.err.println(WSDLUtil.class.getName() + ": unrecognized refType: " + refType); //$NON-NLS-1$
	    }

	    return resolvedObject;
    }



    /**
     * Use Java generics to write the "finders" of various elements, so that the general code
     * which does the lookups and follows imports does not need to be repeated.
     *
     * @author Michal Chmielewski (michal.chmielewski@oracle.com)
     * @date Feb 27, 2007
     *
     * @param <T> the type that we are looking up (PortType, Message, PartnerLinkType)
     */

    interface Finder<S,T> {
    	/**
    	 * Find the thing in the container
    	 *
    	 * @param source the source where to look (definition, schema)
    	 * @param qname the QName to lookup
    	 * @return the resolved entity, or null
    	 */
    	T find (S source, QName qname);
    }


    /** Generic way of looking up port types */
	static final Finder<Definition,PortType> PORT_TYPE_FINDER = new Finder<Definition, PortType>() {
		@Override
		public PortType find (Definition defn, QName qname) {
			return (PortType) defn.getPortType(qname) ;
		}
    };

    /** Generic way of looking up messages */
    static final Finder<Definition,Message> MESSAGE_FINDER = new Finder<Definition,Message> () {
    	@Override
		public Message find (Definition defn, QName qname) {
    		return (Message) defn.getMessage(qname);
    	}
    };

    /** Generic way of looking up partner link types */
    static final Finder<Definition,PartnerLinkType> PARTNER_LINK_TYPE_FINDER = new Finder<Definition,PartnerLinkType>() {

    	@Override
		public PartnerLinkType find (Definition defn, QName qname) {

    		if (defn.getTargetNamespace() == null)
    			return null;

	        if (defn.getTargetNamespace().equals(qname.getNamespaceURI()) == false) {
	        	return null;
	        }
	        Iterator<?> it = defn.getExtensibilityElements().iterator();
	        while (it.hasNext()) {
	        	Object e = it.next();
	        	if (e instanceof PartnerLinkType) {
	        		PartnerLinkType plt = (PartnerLinkType) e;
	                if (plt.getName().equals(qname.getLocalPart())) {
	                    return plt;
	                }
	        	}
	        }
	        return null;
    	}
    };

    /** Generic way of lookup up BPEL properties */
    static final Finder<Definition,Property> PROPERTY_FINDER = new Finder<Definition,Property>() {

		@Override
		public Property find(Definition defn, QName qname) {
	        if (defn.getTargetNamespace().equals(qname.getNamespaceURI()) == false) {
	        	return null;
	        }
	        Iterator<?> it = defn.getExtensibilityElements().iterator();
		    while (it.hasNext()) {
	            Object e = it.next();
	            if (e instanceof Property)  {
	                Property property = (Property) e;
	                if (property.getName().equals(qname.getLocalPart())) {
	                    return property;
	                }
	            }
	        }
		    return null;
		}
    };

    /** Type definition finder */
    static private final Finder<XSDSchema,XSDTypeDefinition> TYPE_DEFINITION_FINDER = new Finder<XSDSchema,XSDTypeDefinition>() {

		@Override
		public XSDTypeDefinition find(XSDSchema schema, QName typeName) {
	    	// Perhaps this is what we want ...
	    	//    http://www.eclipse.org/modeling/emf/faq/#dev20040602-1383194195
	    	//
	    	XSDTypeDefinition typeDef = schema.resolveTypeDefinition(typeName.getNamespaceURI(), typeName.getLocalPart());
	    	if (typeDef.getContainer() == null) {
	    		return null;
	    	}
	    	return typeDef;
		}
    };

    /** Element declaration finder */
    static private final Finder<XSDSchema,XSDElementDeclaration> ELEMENT_DECLARATION_FINDER = new Finder<XSDSchema,XSDElementDeclaration> () {

		@Override
		public XSDElementDeclaration find(XSDSchema schema, QName qn) {
	    	XSDElementDeclaration decl = schema.resolveElementDeclaration( qn.getNamespaceURI(), qn.getLocalPart());

	    	// TODO: (Hack)
	    	// Why has this started returning instances of XSDElementDeclrarion that are not proxies or null
	    	// if the element declaration is missing in the schema ?
	    	// Perhaps this is what we want: http://www.eclipse.org/modeling/emf/faq/#dev20040602-1383194195

	    	if (decl.getContainer() == null) {
	    		return null;
	    	}
	    	return decl;
		}
    };

    /**
     * Resolve the port type in the definition given.
     *
     * @param definition the WSDL definition
     * @param qname the QName of the portType
     * @return the resolved portType, or null
     */

    public static PortType resolvePortType (Definition definition, QName qname)
    {
    	return  resolveUsingFinder ( definition, qname, PORT_TYPE_FINDER, new HashSet<Definition>() );
    }


    /**
     * Resolve using finder resolves the QName in the definitions passed. The return object
     * extends from EObject (so PortType, Message, PartnerLinkType, etc). The finder has the actual lookup
     * code while the general code flow that deals with following the imports is shared among the lookup
     * methods in this class.
     *
     * @param <T> the type
     * @param defn the definition to use as the lookup
     * @param qname the QName to lookup
     * @param finder the finder to use.
     * @param seen the seen set
     * @return the object to be resolved.
     */

    @SuppressWarnings("restriction")
	static <T extends EObject> T resolveUsingFinder ( Definition defn, QName qname, Finder<Definition,T> finder , Set<Definition> seen) {

    	if (seen.contains(defn)) {
    		return null;
    	}
    	seen.add(defn);

    	T result = finder.find ( defn, qname );

    	if (result != null || RESOLVING_DEEPLY == false) {
    		return result;
    	}

    	Iterator<?> it = defn.getImports(qname.getNamespaceURI()).iterator();
    	while (it.hasNext() && result == null) {
             ImportImpl imp = (ImportImpl) it.next();
             imp.importDefinitionOrSchema();
             Definition importedDefinition = (Definition) imp.getDefinition();
             if (importedDefinition != null) {
                 result = resolveUsingFinder (importedDefinition, qname, finder, seen );
             }
        }
    	return result;
    }




    /**
     * Resolve the message name in the definitions passed.
     * @param definition the definitions
     * @param qname the message name
     * @return the message name or null
     */

    public static Message resolveMessage(Definition definition, QName qname)
    {
    	return resolveUsingFinder(definition, qname, MESSAGE_FINDER, new HashSet<Definition>());
    }


    /**
     * Resolve operation within a portType. First lookup portType, then find the operation by name given.
     * @param definition the definition to search
     * @param portTypeQName QName of the portType to lookup operation on
     * @param operationName the operation name.
     * @return the operation or null
     */

    public static Operation resolveOperation(Definition definition, QName portTypeQName, String operationName)
    {
        PortType portType = resolvePortType(definition, portTypeQName);
        return findOperation(portType, operationName);
    }

    /**
     * Resolve the part within a message.
     * @param definition the definition to use
     * @param qname QName of the message
     * @param name the name of the message part.
     * @return the part, or null
     */

    public static Part resolvePart(Definition definition, QName qname, String name)
    {
        return findPart( resolveMessage(definition, qname) , name );
    }



    /**
     * Resolve (lookup) a partner link type in the definitions given.
     * @param defn the definitions to use
     * @param qname the QName to lookup
     * @return the partner link type or null
     */

    public static PartnerLinkType resolveBPELPartnerLinkType(Definition defn, QName qname)
    {
    	return resolveUsingFinder(defn, qname, PARTNER_LINK_TYPE_FINDER, new HashSet<Definition>() );
    }

    /**
     * Resolve BPEL Role on the partner link specified.
     *
     * @param definition the definition to use
     * @param qname QNAme of the partner link type
     * @param name the name of the role on that partner link type
     * @return the BPEL role, or null
     */

    public static EObject resolveBPELRole(Definition definition, QName qname, String name)
    {
        return findRole (  resolveBPELPartnerLinkType(definition, qname) , name );
    }


    /**
     * Lookup the BPEL property in the definition given.
     *
     * @param defn the definition
     * @param qname the property QName to lookup
     * @return the property or null
     */

    public static Property resolveBPELProperty(Definition defn, QName qname)
    {
    	return resolveUsingFinder(defn, qname, PROPERTY_FINDER, new HashSet<Definition>());
    }



    private static Service resolveService(Definition definition, QName qname) {
        return (Service) definition.getService(qname);
    }



    /**
     * Common code for resolving XSDTypeDefinitions and XSDElementDeclarations
     */
    @SuppressWarnings("restriction")
	static <T> T resolveXSD (Definition definition, QName qname, Finder<XSDSchema,T> finder, Set<Definition> seen )
    {
        T result = null;

        if (seen.contains(definition)) {
        	return result;
        }
        seen.add(definition);

        // Check for built-in types
        // TODO Slightly inefficient to evaluate this when recursing

        XSDSchema schema = null;
        String namespace = qname.getNamespaceURI();

        if ("".equals(namespace)) { //$NON-NLS-1$
            namespace = null;
        }

        if (XSDConstants.isSchemaForSchemaNamespace(namespace)) {
            schema = XSDSchemaImpl.getSchemaForSchema(namespace);
        } else if (XSDConstants.isSchemaInstanceNamespace(namespace)) {
            schema = XSDSchemaImpl.getSchemaInstance(namespace);
        }
        if (schema != null) {
            result = finder.find(schema, qname);
            if (result != null) {
                return result;
            }
        }

        // Check in-line schema
        Types types = definition.getETypes();
        if (types != null) {
        	Iterator<?> it = types.getExtensibilityElements().iterator();
        	while (it.hasNext()) {
                Object e = it.next();
                if (e instanceof XSDSchemaExtensibilityElement == false) {
                	continue;
                }
                XSDSchemaExtensibilityElement schemaEE = (XSDSchemaExtensibilityElement) e;
                schema = schemaEE.getSchema();
                if (schema != null) {
                    result = finder.find(schema, qname);
                    if (result != null)
                        return result;
                }
            }
        }

        /**
          * Check imported schemas and definitions.
          * If we are here, then result is still null
          */

        // TODO: I think I need to check all imports, not just those
        // matching the same namespace...

        Iterator<?> it = definition.getImports(qname.getNamespaceURI()).iterator();
        while (it.hasNext()) {
            ImportImpl imp = (ImportImpl) it.next();
            imp.importDefinitionOrSchema();
            schema = imp.getESchema();
            if (schema != null) {
                result = finder.find(schema, qname);
                if (result != null)
                    return result;
            }
            Definition importedDefinition = imp.getEDefinition();
            if (importedDefinition != null) {
                result = resolveXSD(importedDefinition, qname, finder, seen );
                if (result != null) {
                    return result;
                }
            }
        }
        return result;
    }


    /**
     * Resolve type definition. Basically lookup type by QName.
     *
     * @param definition
     * @param qname
     * @return the XSDTypeDefinition found or null if it does not exist.
     */

    public static XSDTypeDefinition resolveXSDTypeDefinition(Definition definition, QName qname)
    {
        return resolveXSD(definition, qname ,TYPE_DEFINITION_FINDER, new HashSet<Definition>() );
    }

    /**
     * Resolve the XSDElement declaration in this definition. Basically, lookup element declaration using the
     * QName specified in the definition indicated.
     *
     * @param definition
     * @param qname
     * @return the XSDElement declaration if found. null otherwise.
     */

    public static XSDElementDeclaration resolveXSDElementDeclaration(Definition definition, QName qname)
    {
        return resolveXSD(definition, qname, ELEMENT_DECLARATION_FINDER, new HashSet<Definition>() );
    }




    /**
     * Find a role in the partner link type.
     * @param plt the partner link type
     * @param name the role name to find.
     * @return the found role or null if it does not exist.
     */
	public static Role findRole ( PartnerLinkType plt, String name ) {

    	if (plt != null) {
    		Iterator<Role> it = plt.getRole().iterator();
    		while (it.hasNext()) {
    			Role role = it.next();
    			if (name.equals(role.getName())) {
	                return role;
	            }
    		}
    	}
    	return null;
    }


    /**
     * Find the operation in the port type.
     * @param portType the port type
     * @param operationName the operation name
     * @return return the operation in the port type or null
     */

    @SuppressWarnings("unchecked")
	public static Operation findOperation (PortType portType, String operationName) {
        if (portType != null) {
        	Iterator<Operation> it = portType.getOperations().iterator();
        	while (it.hasNext()) {
                Operation operation = it.next();
                if (operation.getName().equals(operationName)) {
                    return operation;
                }
            }
        }
        return null;
    }

	/**
	 * Find the message part in the message structure.
	 * @param message
	 * @param name
	 * @return the part or null
	 */
	public static Part findPart(Message message, String name) {
		Part result = null;
        if (message != null) {
            result = (Part) message.getPart(name);
        }
	    return result;
	}
}
