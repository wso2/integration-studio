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
package org.eclipse.bpel.validator.helpers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.util.XSDUtil;
import org.eclipse.bpel.validator.EmfModelQuery;
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IConstants;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IFunctionMeta;
import org.eclipse.bpel.validator.model.IModelQuery;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.NodeAttributeValueFilter;
import org.eclipse.bpel.validator.model.NodeNameFilter;
import org.eclipse.bpel.validator.model.Selector;
import org.eclipse.bpel.validator.model.UndefinedNode;
import org.eclipse.bpel.validator.model.XNotImplemented;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 * Base implementation of the IModelQuery interface with references
 * only to DOM elements. 
 *  
 * This does not fully implement the IModelQuery interface contract as
 * type look ups, WSDL information look ups are not implemented here.
 * This is meant to be a starting point for implementing your own
 * model backend to the IModelQuer interface.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 21, 2006
 *
 */

@SuppressWarnings("nls")

public class ModelQueryImpl  implements IModelQuery {	
	
	/**
	 * The handle to the EMF root of the BPEL process that we will
	 * validate. 
	 */
	
	static final protected Selector mSelector = new Selector();
		
	/**
	 * https://jira.jboss.org/browse/JBIDE-7351
	 * Need an EmfModelQuery to contain the XSDComparer object so that
	 * we can grab diagnostics from it after a failed XSD compare (used
	 * for error reporting!)
	 */
	protected EmfModelQuery emfModelQuery;
	

	/**
	 * Protected constructor, just to initialize the basics the basics.
	 *
	 */
	
	public ModelQueryImpl () {
		emfModelQuery = new EmfModelQuery();
	}

	/**
	 * Return error message from XSDComparer if assignments are incompatible
	 *
	 * https://jira.jboss.org/browse/JBIDE-7351
	 */
	public String getDiagnostic(int index)
	{
		return emfModelQuery.getXSDComparer().getDiagnostic(index);
	}
	/**
	 * Return an answer that decides whether the model has support for 
	 * the given aspects that the validator wants.
	 * @param item 
	 * @param value 
	 * @return true if support present, false otherwise.
	 * 
	 * @see org.eclipse.bpel.validator.model.IModelQuery#hasSupport(int, java.lang.String)
	 */
	
	public boolean hasSupport (int item, String value) {
		
		switch (item) {
		case SUPPORT_QUERY_LANGUAGE :		
			return 
			IConstants.XMLNS_XPATH_QUERY_LANGUAGE.equals ( value ) ||
			IConstants.XMLNS_XPATH_QUERY_LANGUAGE_2.equals( value );
		
		case SUPPORT_EXPRESSION_LANGUAGE :
			return 
			IConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE.equals ( value ) ||
			IConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE_2.equals( value );			

		case SUPPORT_IMPORT_TYPE :
			return IConstants.AT_VAL_IMPORT_XSD.equals ( value ) || 
			IConstants.AT_VAL_IMPORT_WSDL.equals ( value ) ;
		
		case SUPPORT_EXTENSION :

			return 
			IConstants.XMLNS_E4X.equals(value)|| // Support for E4X; 
			IConstants.XMLNS_BPEL4PEOPLE.equals(value); // Support for bpel4people; 
			

		}
				
		throw new XNotImplemented("Not implemented: hasSupport(item=" + item + ")");
	}

	
	/**
	 * Answer if these two nodes are the same thing.
	 * @param test the test to perform 
	 * @param n1 node 1
	 * @param n2 node 2
	 * 
	 * @return true/false depending if the objects are the same.
	 */
	
	public boolean check ( int test, INode n1, INode n2 ) {
		
		switch (test) {
		case TEST_EQUAL :

			// is this enough for EMF model ?
			if (n1 == n2) {
				return true;
			}
			
			if (n1 == null || n2 == null) {
				return false;
			}

			// TODO: this is not this simple ...
			
			Object v1 = n1.nodeValue();
			Object v2 = n2.nodeValue();

			// both identical or null
			if (v1 == v2) {
				return true;
			}
			
			// not identical and *not* both null.
			if (v1 != null) {
				return v1.equals(v2);
			}
			// v1 is null and not identical to v2 so false.
			return false;
		
		case TEST_COMPATIBLE_PARTNER_ACTIVITY_MESSAGE:
			// n1 is source 
			// n2 is destination
			break;

			
		case TEST_COMPATIBLE_TYPE :
			// n1 is the source
			// n2 is the destination
			break;			
			
		case TEST_IS_SIMPLE_TYPE : 
			if (n1 == null || n1.isResolved() == false) {
				return false;
			}
			break;
			
		case TEST_RESOVLED :
			if (n1 == null) {
				return false;
			}
			return n1.isResolved();
		}
		
		throw new XNotImplemented("Not implemented: check(test=" + test + ")");		
	}

	/**
	 * Lookup the function meta which is identified by this QName.
	 * @return the function name 
	 * @see org.eclipse.bpel.validator.model.IModelQuery#lookupFunction(String language, String ns, String name)
	 */
	
	public IFunctionMeta lookupFunction (String language, String ns, String name) {
		// TODO Fill in function meta
		return null;
	}

	/**
	 * Lookup the variable which has this name, starting at the current 
	 * context node. Since this is a local BPEL file lookup, we simply
	 * do it using the INode facade.
	 * 
	 * @see org.eclipse.bpel.validator.model.IModelQuery#lookupVariable(org.eclipse.bpel.validator.model.INode, java.lang.String)
	 */
		
	protected INode lookupVariable (INode context, final String name) {
		
		IFilter<INode> aFilterByName = new NodeAttributeValueFilter(IConstants.AT_NAME, name );
		IFilter<INode> aFilterByFaultVariable = new NodeAttributeValueFilter(IConstants.AT_FAULT_VARIABLE, name );
		IFilter<INode> aFilterByVariable = new NodeAttributeValueFilter(IConstants.AT_VARIABLE, name );
		IFilter<INode> aFilterByCounterName = new NodeAttributeValueFilter(IConstants.AT_COUNTER_NAME, name );
		IFilter<INode> nFilterForEach = new NodeNameFilter(IConstants.ND_FOR_EACH);

		while (context != null) {				
			if (Filters.SCOPE_OR_PROCESS.select (context) ) {
				// select variables defined in a scope or process
				INode var = mSelector.selectNode(context,IConstants.ND_VARIABLES,IConstants.ND_VARIABLE,aFilterByName);								
				if (var != null) {
					return var;
				}
				// select catch name defined in faultHandlers
				var = mSelector.selectNode(context,IConstants.ND_FAULT_HANDLERS,IConstants.ND_CATCH,aFilterByFaultVariable);								
				if (var != null) {
					return var;
				}
				// https://issues.jboss.org/browse/JBIDE-8044
				// select variable defined in onEvent of eventHandlers
				var = mSelector.selectNode(context,IConstants.ND_EVENT_HANDLERS,IConstants.ND_ON_EVENT,aFilterByVariable);								
				if (var != null) {
					return var;
				}
				// select counterName defined in forEach
				INode parent = mSelector.selectParent(context,nFilterForEach);
				if (parent != null) {
					if (aFilterByCounterName.select(parent)) {
						return parent;
					}
				}
			}
			context = context.parentNode();
		}
		return null;
	}
	
	
	/**
	 * Lookup the partner link specified using the context node. Scoping
	 * rules as in variables are used. The lookup is in the local BPEL file,
	 * so we simply use the INode facade for that.
	 * 
	 * @param context
	 * @param name
	 * @return the partner link found, or nothing.
	 */
	
	protected INode lookupPartnerLink (INode context, String name) {
		IFilter<INode> aFilter = new NodeAttributeValueFilter(IConstants.AT_NAME,name );
		while (context != null) {								
			if (Filters.SCOPE_OR_PROCESS.select(context) ) {
				INode obj = mSelector.selectNode(context, IConstants.ND_PARTNER_LINKS, IConstants.ND_PARTNER_LINK, aFilter);
				if (obj != null) {
					return obj; 					
				}
			}			
			context = context.parentNode();
		}
		return null;
					
	}

	/**
	 * Lookup the correlation set by the name given starting at current 
	 * reference object.
	 * 
	 * @param context
	 * @param name
	 * @return the correlation set or null
	 */
	
	protected INode lookupCorrelationSet (INode context, String name) {
		IFilter<INode> aFilter = new NodeAttributeValueFilter(IConstants.AT_NAME,name );
		while (context != null) {								
			if (Filters.SCOPE_OR_PROCESS.select(context) ) {
				INode obj = mSelector.selectNode(context, IConstants.ND_CORRELATION_SETS, IConstants.ND_CORRELATION_SET, aFilter);
				if (obj != null) {
					return obj; 					
				}
			}			
			context = context.parentNode();
		}
		return null;

	}
	
	
	/**
	 * Lookup and return the specified link name based on the context node.
	 * @param context
	 * @param name
	 * @return the link node or null,
	 */
	
	public INode lookupLink ( INode context, String name ) {
		IFilter<INode> aFilter = new NodeAttributeValueFilter(IConstants.AT_NAME, name );
		while (context != null) {
			QName contextNodeName = context.nodeName();
			if (contextNodeName.equals(IConstants.ND_FLOW)) {
				INode link = mSelector.selectNode(context,IConstants.ND_LINKS,IConstants.ND_LINK, aFilter);
				if (link != null) {
					return link;
				}
			}
			context = context.parentNode();
		}
		
		return null;
	}
		
	
	/**
	 * General node lookup.
	 * 
	 * @param context
	 * @param what
	 * @param name
	 * @return the result of the lookup
	 */
	
	public INode lookup (INode context, int what, String name ) {
		if (isEmpty(name)) {
			return null;			
		}
		//
		if (name.indexOf(':') >= 0) {
			return lookup(context,what,createQName(context, name));
		}
		return lookup (context, what, new QName(name) );
	}

	/**
	 * General node lookup.
	 * 
	 * @param context the context node, it cannot be null.
	 * @param what the thing to lookup
	 * @param qname the QName of the node to lookup
	 * @return the result of the lookup
	 */
	
	public INode lookup ( INode context, int what, QName qname ) {
				
		String name = qname.getLocalPart();			
				
		Object modelObject = null;
		INode result = null;
		 
		// Make sure all the lookup items are switched.
		switch (what) {
		
		case LOOKUP_NODE_VARIABLE :
			if (context.isResolved()) {
				result = lookupVariable(context,name);
			}			
			if (result == null) {
				result =  new UndefinedNode(IConstants.ND_VARIABLE, IConstants.AT_NAME, name);
			}
			break;
			
		case LOOKUP_NODE_LINK :
			if (context.isResolved()) {
				result = lookupLink(context, name);	
			}			
			if (result == null) {
				result = new UndefinedNode(IConstants.ND_LINK,IConstants.AT_NAME,name);
			}
			break;
			
			
		case LOOKUP_NODE_IMPORT :
			
			if (context.isResolved()) {
				// lookup in model
				modelObject = null;
			}
			
			if (modelObject == null) {
				result = new UndefinedNode(IConstants.ND_IMPORT);
			}
			break;
			
		case LOOKUP_NODE_PARTNER_LINK :
			if (context.isResolved() ) {
				result = lookupPartnerLink (context, name);				
			}						
			if (result == null) {
				result = new UndefinedNode(IConstants.ND_PARTNER_LINK,IConstants.AT_NAME,name);
			}
			break;
					
			
		case LOOKUP_NODE_CORRELLETION_SET :
			if (context.isResolved()) {
				result = lookupCorrelationSet (context,name);
			}
			if (result == null) {
				result = new UndefinedNode(IConstants.ND_CORRELATION_SET,IConstants.AT_NAME,name);
			}
			break;	
			
			
			/**
			 * The items below are queried from the EMF model. These are largely resolved
			 * by the model and we rely on that resolution to produce the right result.
			 * 
			 */
			
		case LOOKUP_NODE_PARTNER_LINK_TYPE :	
			if ( context.isResolved() ) {
				// lookup in model
				modelObject = null; 				
			}			
			if (modelObject == null) {
				result = new UndefinedNode(IConstants.PLNK_ND_PARTNER_LINK_TYPE, IConstants.AT_NAME, qname.getLocalPart() );
			}
			break;
			
		case LOOKUP_NODE_ROLE :
			if ( context.isResolved() ) {
				// lookup in model
				modelObject = null;
			}			
			if (modelObject == null) {
				result = new UndefinedNode(IConstants.PLNK_ND_PARTNER_LINK_TYPE, IConstants.AT_NAME, name );				
			}
			break;				
			
		case LOOKUP_NODE_OPERATION :
			if ( context.isResolved()) {
				// lookup in model
				modelObject = null;
			}			
			if (modelObject == null) {
				result = new UndefinedNode ( IConstants.WSDL_ND_OPERATION, IConstants.AT_NAME, name );
			}
			break;			
			
		case LOOKUP_NODE_PORT_TYPE :	
			if ( context.isResolved() ) {
				// lookup in model
				modelObject = null;				
			}				
			if (modelObject == null) {
				result = new UndefinedNode ( IConstants.WSDL_ND_PORT_TYPE, IConstants.AT_NAME, qname.getLocalPart() );
			}
			break;
			
		case LOOKUP_NODE_MESSAGE_TYPE :	
			if ( context.isResolved() ) {
				// lookup in model
				modelObject = null;
			}					
			if (modelObject == null) {
				result = new UndefinedNode(IConstants.WSDL_ND_MESSAGE, IConstants.AT_NAME, qname.getLocalPart() );
			}
			break;			

		case LOOKUP_NODE_MESSAGE_PART :
			
			if (modelObject == null) {
				result = new UndefinedNode(IConstants.WSDL_ND_PART, IConstants.AT_NAME, qname.getLocalPart() );
			}
			break;
			
		case LOOKUP_NODE_XSD_ELEMENT :
			if ( context.isResolved() )  {
				// lookup model object
				modelObject = null;
			}
			if (modelObject == null) {				
				result = new UndefinedNode(IConstants.AT_ELEMENT,IConstants.AT_NAME, qname.getLocalPart());
			}
			break;
			
		case LOOKUP_NODE_XSD_TYPE :			
			if (context.isResolved()) {				
				modelObject = null;				
			}
			if (modelObject == null) {
				result = new UndefinedNode(IConstants.AT_TYPE,IConstants.AT_NAME, qname.getLocalPart());	
			}
			break;
			
		case LOOKUP_NODE_PROPERTY :
			if (context.isResolved()) {				
				modelObject = null;				
			}
			if (modelObject == null) {
				result = new UndefinedNode(IConstants.VPROP_ND_PROPERTY, IConstants.AT_NAME, qname.getLocalPart());	
			}
			break;
			
		case LOOKUP_NODE_NAME_STEP :			
			if (context.isResolved()) {
				modelObject = null;
			}
			if (modelObject == null) {
				result = new UndefinedNode(IConstants.AT_ELEMENT,IConstants.AT_NAME,qname.getLocalPart() );	
			}
			break;
		

		case LOOKUP_NODE_NAME_STEP_ATTRIBUTE :			
			if (context.isResolved()) {
				modelObject = null;
			}
			if (modelObject == null) {
				result =  new UndefinedNode(IConstants.AT_ELEMENT,IConstants.AT_NAME,qname.getLocalPart() );	
			}
			break;
			
		case LOOKUP_NODE_TYPE_OF_PART : 
			if (context.isResolved()) {
				modelObject = null;				
			}
			if (modelObject == null) {
				result = new UndefinedNode(IConstants.AT_ELEMENT,IConstants.AT_NAME,"Unknown");
			}
			break ;
		
		default :
			throw new XNotImplemented("Not implemented: lookupNode(item=" + what + ")");
		}

		if (modelObject == null) {
			return result ;
		}
		
		
		return adapt ( modelObject, INode.class, ADAPT_HINT_NONE );
				
	}	
	
	
	/**
	 * Lookup some text related item in the model object.
	 * 
	 * @param context the context node
	 * @param what what to lookup
	 * @param key the value to lookup
	 * @param def the default value to return
	 * @return the looked up value.
	 * 
	 */
	
	@SuppressWarnings("nls")
	public String lookup ( INode context, int what, String key, String def) {
				
		Element elm ;		
		
		switch (what) {
		
		case LOOKUP_TEXT_LOCATION :
			// Should this be anything else ?
			return context.nodeName().getLocalPart();
			
		case LOOKUP_TEXT_NS2PREFIX : 
			if (key == null) {
				break;
			}
			elm = adapt(context,Element.class,ADAPT_HINT_NONE);
			if (elm != null) {
				String result = elm.lookupPrefix(key);
				return result != null ? result : def;
			}				
			break;
			
		case LOOKUP_TEXT_PREFIX2NS :
			if (key == null) {
				break;
			}		
			elm = adapt(context,Element.class,ADAPT_HINT_NONE);
			if (elm != null) {
				String result = elm.lookupNamespaceURI(key);
				return result != null ? result : def;
			}
			break;
			
		case LOOKUP_TEXT_TEXT :
			elm = adapt(context,Element.class,ADAPT_HINT_NONE);
			if (elm == null) {
				break;
			}			
			StringBuilder text = new StringBuilder();
			Node n = elm.getFirstChild();
			while (n != null) {
				text.append( n.getTextContent() );
				n = n.getNextSibling();
			}
			return text.toString();		
 
		case LOOKUP_TEXT_HREF :
			// not implement here.
			break;
			
		case LOOKUP_TEXT_RESOURCE_PATH :
			elm = adapt(context,Element.class,ADAPT_HINT_NONE);
			if (elm == null) {
				return def;
			}
			Document document = elm.getOwnerDocument();
			return document.getDocumentURI();
												
			
		case LOOKUP_TEXT_HREF_XPATH :
			elm = adapt(context,Element.class,ADAPT_HINT_NONE);
			if (elm == null) {
				return def;
			}			
			return computeXPathTo ( elm );
			
		default : 
			throw new XNotImplemented("Not implemented: lookupText(item=" + what + ")");
		}
		
		return def;
	}
	
	
	/**
	 * Lookup a number value or parameter in the model.
	 * @param context 
	 * @param what 
	 * @param def 
	 * @return the looked-up value, or the default return value passed.
	 * 
	 */
	@SuppressWarnings("nls")
	
	public int lookup ( INode context, int what, int def ) {
		
		Element elm = adapt(context,Element.class,ADAPT_HINT_NONE);
		if (elm == null) {
			return def;
		}
		
		String key = null;
		switch (what) {
		case LOOKUP_NUMBER_LINE_NO :
			key = "location.line";
			break;		
		case LOOKUP_NUMBER_COLUMN_NO :
			key = "location.column";
			break;		
		case LOOKUP_NUMBER_CHAR_START :
			key = "location.charStart";
			break;
		case LOOKUP_NUMBER_CHAR_END :
			key = "location.charEnd";
			break;
		
		case LOOKUP_NUMBER_LINE_NO_2 :
			key = "location2.line";
			break;
		case LOOKUP_NUMBER_COLUMN_NO_2 :
			key = "location2.column";
			break;
		case LOOKUP_NUMBER_CHAR_START_2 :
			key = "location2.charStart";
			break;
		case LOOKUP_NUMBER_CHAR_END_2 :
			key = "location2.charEnd";
			break;
			
		default : 
			throw new XNotImplemented("Not implemented: lookupNumber(item=" + what + ")");			
		}
		
		try {
			return ((Number)elm.getUserData(key)).intValue();
		} catch (Throwable t) {
			// 
		}			
		return def;
	}
	

	
	/**
	 * Create the QName from the name indicated. The context node is used to resolve 
	 * namespaces prefixes. 
	 * 
	 * @param context the context node
	 * @param name
	 * @return the QName parsed out from name.
	 */
	@SuppressWarnings("nls")
	public QName createQName ( INode context, String name ) {
		
		int index = name.indexOf(':');
		String prefix = (index != -1)? name.substring(0, index): "";
		String localPart = name.substring(index + 1);
		
		String namespaceURI = lookup(context, LOOKUP_TEXT_PREFIX2NS, prefix, null );
	
		// namespaceURI may be null. That's okay.
		return new QName(namespaceURI, localPart, prefix );
	}
	
	
	
	/**
	 * Adapt the target to a type. This goes through the platform adapter 
	 * mechanism.
	 * 
	 * @param <T>  
	 * @param target
	 * @param type
	 * @param hint hint for the adapter
	 * @return an object that is the adapter the target with the given class.
	 */
		
	public <T extends Object> T adapt (Object target, Class<T> type, int hint) {
		
		if (type.isInstance(target) || target == null) {
			return type.cast(target);
		}
		
		if (target instanceof Node) {
		
			Node node = (Node) target;
			// Node -> INode
			if (type == INode.class) {
							
				Object adapter = node.getUserData(DOMNodeAdapter.KEY);
				if (adapter instanceof DOMNodeAdapter) {
					return type.cast(adapter);
				}
				adapter = new DOMNodeAdapter( node );
				node.setUserData(DOMNodeAdapter.KEY, adapter, null );
				return type.cast(adapter);							
			}
		}
		
		if (target instanceof INode) {
			
			INode aTarget = (INode) target;
			// INode -> ... whatever 
			Object value = aTarget.nodeValue();
			
			if (type.isInstance(value)) {
				return type.cast(value);
			}
		}
		
		return null;
	}
	
	
	static protected boolean isEmpty ( String value ) {
    	return value == null || value.length() == 0;
    }
	
	 /** 
	  * Compute the the XPath to the node child from the root of the XML
     * tree. Since this is just based on the instance of this document,
     * we must proceed every element selection by an index [] of the element.
     * @param child
     * @return the XPath from the root of the document tree.
     */

    @SuppressWarnings("nls")
	static public String computeXPathTo (Node child) {
    	
        Stack<String> stack = new Stack<String>();
        
        Node parent = null;
        if (child.getNodeType() == Node.CDATA_SECTION_NODE) {
            return "--No XPath to CDATA NODE exists --";
        }

        // Attribute nodes are special since they are children of
        // the element node.
        if (child.getNodeType() == Node.ATTRIBUTE_NODE) {
            Attr att = (Attr) child;
            stack.push("/@" + att.getName());
            child = att.getOwnerElement();
        }
        parent = child.getParentNode();

        while (parent != null && parent != child) {
        	
            NodeList nl = parent.getChildNodes();
            int idx = 1;
            int cnt = 0;
            for (int i = 0, j = nl.getLength(); i < j; i++) {
                Node anode = nl.item(i);

                if (anode.getNodeType() != child.getNodeType()) {
                    continue;
                }
                if (anode.getNodeName().equals(child.getNodeName()) == false) {
                    continue;
                }
                // We have seen cnt nodes that match the type and the name
                // to the one that we are. In other words, our parent
                // has "cnt" children nodes.
                cnt += 1;
                if (anode.equals(child)) {
                    idx = cnt;
                }
            }
            // this is the node, figure how to get here.
            // Since this is based on the instance of XML document,
            // we can figure out the path by doing some shortcuts.
            String cmd = "";
            switch (child.getNodeType()) {
                case Node.TEXT_NODE:
                    cmd = "/text()";
                    break;
                case Node.COMMENT_NODE:
                    cmd = "/comment()";
                    break;
                default :
                    String ns = child.getNamespaceURI();
                    if (ns == null || ns.length() == 0) {
                        cmd = "/" + child.getNodeName();
                    } else if (child.getPrefix() == null) {
                        cmd = "/:" + child.getLocalName();
                    } else {
                        cmd = "/" + child.getPrefix() + ":" + child.getLocalName();
                    }
                    break;
            }
            stack.push(cmd + (cnt == 1 ? "" : "[" + idx + "]"));

            // Go up
            parent = parent.getParentNode();
            child = child.getParentNode();
        }
        // Now we are done.
        StringBuilder xpath = new StringBuilder(256);
        while (stack.isEmpty() == false) {
            xpath.append(stack.pop());
        }
        return xpath.toString();
    }
    
    
    /**
     * Return our priority.
     * @return we are at priority 0
     */
    
    public int priority () {
    	return 0;
    }
    
    
    
    
    
    
    /**
     * The rest is a static implementation which deals with collecting model query
     * implementations from other plugins.
     */
    
    
    static IModelQuery   gModelQuery = null;
    static IModelQuery[] gaModelQuery = {};
    
    static ArrayList<IModelQuery> gModelQueryList = new ArrayList<IModelQuery> (8) ;
    
    
    /**
     * 
     * @param mq
     */
    
    static public final void register ( IModelQuery mq ) {
    	
    	gModelQuery = mq;
    	gModelQueryList.add(mq);
    	
    	// Force re computation of the query model chain.
    	gaModelQuery = null;
    }
    
    
    /**
     * @return the model query interface.
     */
    
    static public final IModelQuery getModelQuery () {
    	
    	if (gModelQuery != null) {    		
    		return gModelQuery;
    	}
    	
    	gaModelQuery = gModelQueryList.toArray(gaModelQuery);
    	
    	if (gaModelQuery.length == 0) {
    		
    		gModelQuery = new ModelQueryImpl();
    		
    	} else if (gaModelQuery.length == 1) {
    		
    		gModelQuery = gaModelQuery[0];
    		
    	} else {
    		
    		Arrays.sort(gaModelQuery, new Comparator<IModelQuery>() {
				public int compare(IModelQuery o1, IModelQuery o2) {
					return o1.priority() - o2.priority();
				}    			
    		});
    		
    		gModelQuery = (IModelQuery) java.lang.reflect.Proxy.newProxyInstance( 
    				ModelQueryImpl.class.getClassLoader(), 
    				
    				new Class<?>[]{ IModelQuery.class },
    				
    				new InvocationHandler () {

						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							
							Object result = null;
							for(IModelQuery mq : gaModelQuery) {
								try {
									result =  method.invoke(mq, args);
									
									if (result != null) {
										return result;
									}
									
								} catch (XNotImplemented xnotImpl) {
									// not implemented by this model query instance
								}
							}
							return result;
						}    					
    				});
    		
    	}
    	
    	
    	// Return the model query object
    	return gModelQuery;
    }
    
    /**
     * Searches all imports in the given Process for conflicting XSD definitions
     * 
     * @param process the containing Process
     * @param node the XSD element reference
     * @return the list of Imports that contain conflicting definitions or null
     * if there are no conflicts.
     * @see https://issues.jboss.org/browse/JBIDE-8088
     */
	@Override
	public List<Import> findConflictingXSD(Process process, INode node) {

		EObject o1 = adapt(node, EObject.class, ADAPT_HINT_NONE);
		List<Import> imports = null;
		List<Import> conflicts = new ArrayList<Import>();
		QName qname = null;

		if (o1 instanceof XSDTypeDefinition) {
			qname = this.createQName(node, ((XSDTypeDefinition) o1).getName());
			if ("".equals(qname.getNamespaceURI())) {
				qname = new QName(((XSDTypeDefinition) o1).getTargetNamespace(), qname.getLocalPart());
			}
			imports = emfModelQuery.scanAllImports(process, qname, XSDUtil.XSD_TYPE_DEFINITION);
		} else if (o1 instanceof XSDElementDeclaration) {
			qname = this.createQName(node, ((XSDElementDeclaration) o1).getName());
			if ("".equals(qname.getNamespaceURI())) {
				qname = new QName(((XSDElementDeclaration) o1).getTargetNamespace(), qname.getLocalPart());
			}
			imports = emfModelQuery.scanAllImports(process, qname, XSDUtil.XSD_ELEMENT_DECLARATION);
		}

		if (imports != null && imports.size() > 1) {
			EObject o2 = null;
			o1 = null;
			for (Import imp : imports) {
				EObject resolvedImport = emfModelQuery.lookupImport(imp, null);
				if (o1 == null) {
					if (o1 instanceof XSDTypeDefinition) {
						o1 = emfModelQuery.lookupXSDType(resolvedImport, qname);
					} else {
						o1 = emfModelQuery.lookupXSDElement(resolvedImport, qname);
					}
					conflicts.add(imp);
				} else {
					if (o2 instanceof XSDTypeDefinition) {
						o2 = emfModelQuery.lookupXSDType(resolvedImport, qname);
					} else {
						o2 = emfModelQuery.lookupXSDElement(resolvedImport, qname);
					}
					if (!emfModelQuery.compatibleType(o1, o2)) {
						conflicts.add(imp);
					}
				}
			}
		}
		
		return conflicts.size()>1 ? conflicts : null;
	}


    /**
     * Returns the Process that corresponds to the given node
     * 
     * @param node the Process element
     * @return the Process or null
     * @see https://issues.jboss.org/browse/JBIDE-8088
     */
	@Override
	public Process lookupProcess(INode node) {
		EObject root = emfModelQuery.getRoot( adapt(node, EObject.class, ADAPT_HINT_NONE) );
		if (root instanceof Process)
			return (Process) root;
		return null;
	}
    
    
}
		
