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

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.eclipse.bpel.fnmeta.FunctionLibrary;
import org.eclipse.bpel.fnmeta.FunctionRegistry;
import org.eclipse.bpel.model.adapters.AdapterRegistry;
import org.eclipse.bpel.validator.helpers.ModelQueryImpl;
import org.eclipse.bpel.validator.model.IConstants;
import org.eclipse.bpel.validator.model.IFunctionMeta;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.UndefinedNode;
import org.eclipse.bpel.validator.model.XNotImplemented;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.WSDLElement;
import org.eclipse.wst.wsdl.util.WSDLParser;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.util.XSDParser;
import org.w3c.dom.Element;



/**
 * Implementation of the IModelQuery interface for the EMF BPEL 
 * object model used in the designer.
 * <p>
 * Basically, the validation model is much thinner as the BPEL EMF model.
 * Because of this, various BPEL entity models (such as the EMF) one
 * can be adapted to the validator BPEL model. 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 21, 2006
 *
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
 * @see https://jira.jboss.org/browse/JBIDE-7351
 * EMFModelQuery is no longer static because of XSDComparer object
 * for fetching diagnostics of comparison
 */

@SuppressWarnings("nls")

public class ModelQuery extends ModelQueryImpl {		
		
	/**
	 * Return an answer that decides whether the model has support for 
	 * the given aspects that the validator wants.
	 * @param item 
	 * @param value 
	 * @return true if support present, false otherwise.
	 * 
	 * @see org.eclipse.bpel.validator.model.IModelQuery#hasSupport(int, java.lang.String)
	 */
	
	@Override
	public boolean hasSupport (int item, String value) {
		
		switch (item) {
		case SUPPORT_QUERY_LANGUAGE :		
			return 
			IConstants.XMLNS_XPATH_QUERY_LANGUAGE.equals ( value ) ||
			IConstants.XMLNS_XPATH_QUERY_LANGUAGE_XPATH2.equals ( value ) ||
			IConstants.XMLNS_XPATH_QUERY_LANGUAGE_2.equals( value );
		
		case SUPPORT_EXPRESSION_LANGUAGE :
			return 
			IConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE.equals ( value ) ||
			IConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE_XPATH2.equals( value ) ||
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
	
	@Override
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
			return emfModelQuery.compatiblePartnerActivityMessages ( 
					adapt(n1,EObject.class,ADAPT_HINT_NONE), 
					adapt(n2,EObject.class,ADAPT_HINT_NONE) );
			
		case TEST_COMPATIBLE_TYPE :
			// n1 is the source
			// n2 is the destination
			return emfModelQuery.compatibleType ( adapt(n1,EObject.class,ADAPT_HINT_NONE), adapt(n2,EObject.class,ADAPT_HINT_NONE)); 
			
		case TEST_IS_SIMPLE_TYPE : 
			if (n1 == null || n1.isResolved() == false) {
				return false;
			}
			return emfModelQuery.isSimpleType ( adapt(n1,EObject.class,ADAPT_HINT_NONE) ) ;
			
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
	
	@Override
	public IFunctionMeta lookupFunction (String language, String ns, String name) {
		
		FunctionRegistry registry = FunctionLibrary.INSTANCE.getRegistryForLanguage(language);
		if (registry == null) {
			return null;
		}
		return AdapterRegistry.INSTANCE.adapt(registry.lookupFunction ( ns, name ) , IFunctionMeta.class);		
	}



	
	


	 /** Make sure there is a reference from the element
	  * to the EMF model.
	  * 
	  * @param eObj
	  * @param elm
	  */
	 

	void ensureEMFReference (EObject eObj, Element elm) {
		 
		 Object obj = elm.getUserData("emf.model");
		 
		 // check if already set
		 if (obj != null && obj == eObj) {
			 return ;
		 }
		 		 
		 // set it.
//			System.out.println(elm.getOwnerDocument().getDocumentURI() + " " + elm.getLocalName() + "----" + obj);

		 elm.setUserData("emf.model", eObj, null);

		 
		 // set it on all the children of this element as well.
		 //
		 Iterator<EObject> it = eObj.eAllContents();
		 
		 while (it.hasNext()) {
			 Object next = it.next();
			 Element domElement = null;
			 
			 if (next instanceof WSDLElement) {
				 domElement = ((WSDLElement)next).getElement();
			 } else if (next instanceof XSDConcreteComponent) {
				 domElement = ((XSDConcreteComponent)next).getElement();
			 } 
			 if ( domElement != null ) {
//					System.out.println(elm.getOwnerDocument().getDocumentURI() + " " + elm.getLocalName() + "----" + next);

				 domElement.setUserData("emf.model",next,null);
			 }			 
		 }
	 }
	
	 
	
	
	/**
	 * General node lookup.
	 * 
	 * @param context the context node, it cannot be null.
	 * @param what the thing to lookup
	 * @param qname the QName of the node to lookup
	 * @return the result of the lookup
	 */
	
	@Override
	public INode lookup ( INode context, int what, QName qname ) {
			
		if (qname == null) {
			return null;
		}
		String name = qname.getLocalPart();			
				
		EObject eObj = null;
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
				eObj = emfModelQuery.lookupImport(adapt(context,EObject.class,ADAPT_HINT_NONE), name );				
			}
			
			if (eObj == null) {
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
				eObj = emfModelQuery.lookupPartnerLinkType ( adapt(context,EObject.class,ADAPT_HINT_NONE), qname ); 				
			}			
			if (eObj == null) {
				result = new UndefinedNode(IConstants.PLNK_ND_PARTNER_LINK_TYPE, IConstants.AT_NAME, qname.getLocalPart() );
			}
			break;
			
		case LOOKUP_NODE_ROLE :
			if ( context.isResolved() ) {
				eObj =  emfModelQuery.lookupRole ( adapt(context,EObject.class,ADAPT_HINT_NONE), name ) ;
			}			
			if (eObj == null) {
				result = new UndefinedNode(IConstants.PLNK_ND_PARTNER_LINK_TYPE, IConstants.AT_NAME, name );				
			}
			break;				
			
		case LOOKUP_NODE_OPERATION :
			if ( context.isResolved()) {				
				eObj = emfModelQuery.lookupOperation ( adapt(context,EObject.class,ADAPT_HINT_NONE), name );
			}			
			if (eObj == null) {
				result = new UndefinedNode ( IConstants.WSDL_ND_OPERATION, IConstants.AT_NAME, name );
			}
			break;			
			
		case LOOKUP_NODE_PORT_TYPE :	
			if ( context.isResolved() ) {
				eObj = emfModelQuery.lookupPortType ( adapt(context,EObject.class,ADAPT_HINT_NONE), qname) ;					
			}				
			if (eObj == null) {
				result = new UndefinedNode ( IConstants.WSDL_ND_PORT_TYPE, IConstants.AT_NAME, qname.getLocalPart() );
			}
			break;
			
		case LOOKUP_NODE_MESSAGE_TYPE :	
			if ( context.isResolved() ) {
				eObj = emfModelQuery.lookupMessage ( adapt(context,EObject.class,ADAPT_HINT_NONE), qname) ;				
			}					
			if (eObj == null) {
				result = new UndefinedNode(IConstants.WSDL_ND_MESSAGE, IConstants.AT_NAME, qname.getLocalPart() );
			}
			break;			

		case LOOKUP_NODE_MESSAGE_PART :
			return adapt(emfModelQuery.lookupMessagePart ( adapt(context,EObject.class,ADAPT_HINT_NONE), name),INode.class,ADAPT_HINT_NONE );
			
		case LOOKUP_NODE_XSD_ELEMENT :
			if ( context.isResolved() )  {
				eObj = emfModelQuery.lookupXSDElement ( adapt(context,EObject.class,ADAPT_HINT_NONE), qname);
			}
			if (eObj == null) {				
				result = new UndefinedNode(IConstants.AT_ELEMENT,IConstants.AT_NAME, qname.getLocalPart());
			}
			break;
			
		case LOOKUP_NODE_XSD_TYPE :			
			if (context.isResolved()) {				
				eObj = emfModelQuery.lookupXSDType ( adapt(context,EObject.class,ADAPT_HINT_NONE), qname);				
			}
			if (eObj == null) {
				result = new UndefinedNode(IConstants.AT_TYPE,IConstants.AT_NAME, qname.getLocalPart());	
			}
			break;
			
		case LOOKUP_NODE_PROPERTY :
			if (context.isResolved()) {				
				eObj = emfModelQuery.lookupProperty ( adapt(context,EObject.class,ADAPT_HINT_NONE), qname  );				
			}
			if (eObj == null) {
				result = new UndefinedNode(IConstants.VPROP_ND_PROPERTY, IConstants.AT_NAME, qname.getLocalPart());	
			}
			break;
			
		case LOOKUP_NODE_NAME_STEP :			
			if (context.isResolved()) {
				eObj = emfModelQuery.lookupNameStep( adapt(context,EObject.class,ADAPT_HINT_NONE), qname, 0 );
			}
			if (eObj == null) {
				result =  new UndefinedNode(IConstants.AT_ELEMENT,IConstants.AT_NAME,qname.getLocalPart() );	
			}
			break;
		
		case LOOKUP_NODE_NAME_STEP_ATTRIBUTE :			
			if (context.isResolved()) {
				eObj = emfModelQuery.lookupNameStep( adapt(context,EObject.class,ADAPT_HINT_NONE), qname, 1 );
			}
			if (eObj == null) {
				result =  new UndefinedNode(IConstants.AT_ELEMENT,IConstants.AT_NAME,qname.getLocalPart() );	
			}
			break;
			
		case LOOKUP_NODE_TYPE_OF_PART : 
			if (context.isResolved()) {
				eObj = emfModelQuery.lookupTypeOfPart ( adapt(context,EObject.class,ADAPT_HINT_NONE), qname );
			}
			if (eObj == null) {
				result = new UndefinedNode(IConstants.AT_ELEMENT,IConstants.AT_NAME,"Unknown");
			}
			break ;
		
		default :
			throw new XNotImplemented("Not implemented: lookupNode(item=" + what + ")");
		}

		if (eObj == null) {
			return result ;
		}
		return adapt ( eObj , INode.class,ADAPT_HINT_NONE );
				
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
	
	@Override
	@SuppressWarnings("nls")
	public String lookup ( INode context, int what, String key, String def) {
						
		EObject eObj;
		
		switch (what) {
		
		case LOOKUP_TEXT_LOCATION :
			// Should this be anything else ?
			return context.nodeName().getLocalPart();
			
		case LOOKUP_TEXT_NS2PREFIX : 
			return super.lookup(context,what,key,def);
			
		case LOOKUP_TEXT_PREFIX2NS :
			return super.lookup(context, what,key,def);
			
		case LOOKUP_TEXT_TEXT :
			return super.lookup(context, what,key,def);
 
		case LOOKUP_TEXT_HREF :
			eObj = adapt(context,EObject.class,ADAPT_HINT_NONE);
			if (eObj == null || eObj.eResource() == null) {
				break;
			}			
			return eObj.eResource().getURIFragment(eObj);
			
		case LOOKUP_TEXT_RESOURCE_PATH :
			eObj = adapt(context,EObject.class,ADAPT_HINT_NONE);
			if (eObj == null || eObj.eResource() == null ) {
				break;
			}
			URI uri = eObj.eResource().getURI();
			if (uri.isFile()) {
				return uri.toFileString();
			}
			return uri.toString();					
			
		case LOOKUP_TEXT_HREF_XPATH :
			return super.lookup(context, what,key,def);
			
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
	@Override
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
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7107
			// this was added as a result of https://jira.jboss.org/browse/JBIDE-7116 since we need to
			// be able to report line information for various types of WSDL objects...
			// if the requested item is line/column information, maybe it's in an imported WSDL or XSD.
			// We'll have to get this info from the WSDLParser or XSDParser. Luckily we remembered to set
			// the TRACK_LOCATION loader option for the WSDL Resource loader, right?
			EObject eObj = (EObject) elm.getUserData("emf.model");
			if (eObj instanceof XSDConcreteComponent) {
				switch (what) {
				case LOOKUP_NUMBER_LINE_NO :
					def = XSDParser.getStartLine( ((XSDConcreteComponent)eObj).getElement() );
					break;		
				case LOOKUP_NUMBER_COLUMN_NO :
					def = XSDParser.getStartColumn( ((XSDConcreteComponent)eObj).getElement() );
					break;		
				default:
					return def;
				}				
			}
			else if (eObj instanceof WSDLElement) {
				switch (what) {
				case LOOKUP_NUMBER_LINE_NO :
					def = WSDLParser.getStartLine( ((WSDLElement)eObj).getElement() );
					break;		
				case LOOKUP_NUMBER_COLUMN_NO :
					def = WSDLParser.getStartColumn( ((WSDLElement)eObj).getElement() );
					break;		
				default:
					return def;
				}				
			}
			else
				return def;
			
			// found it! Set this info in the adaptable Element for next time
			elm.setUserData(key, Integer.valueOf( def ), null);
		}			
		return def;
	}
	
	
	
	/**
	 * Adapt the target to a type. This goes through the platform adapter 
	 * mechanism.
	 * 
	 * @param target
	 * @param type
	 * @param hint the hint 
	 * @return an object that is the adapter the target with the given class.
	 */
		
	@Override
	public <T extends Object> T adapt (Object target, Class<T> type, int hint ) {
		
		// short cut
		if (type.isInstance( target ) ||  target == null) {
			return type.cast(target);
		}
		
		T result = super.adapt(target,type,hint);
		if (result != null) {
			return result;
		}
		
		if (target instanceof INode) {
			
			INode aTarget = (INode) target;
			// INode -> Element
			
			if (type == Element.class) {
				return type.cast(adaptINode2Element ( aTarget ));
			}
			
			if (type == EObject.class) {
				return type.cast( adaptINode2EObject ( aTarget ) );
			}						
		}
		
		if (target instanceof EObject) {	
			EObject aTarget = (EObject)target;
			if (type == INode.class) {
				return type.cast(adaptEObject2INode ( aTarget ));
			}
		}
		
		IAdapterManager manager = AdapterManagerHelper.getAdapterManager();
		return type.cast(manager.getAdapter(target, type));		
	}
	

    
	
	Element adaptINode2Element ( INode context ) {
		
		Object value = context.nodeValue();
		if (value instanceof Element) {
			return (Element) value;
		} else if (value instanceof WSDLElement) {
			return ((WSDLElement)value).getElement();			
		} else if (value instanceof XSDConcreteComponent) {
			return ((XSDConcreteComponent) value).getElement();
		}
		return null;		
	}

	/**
	 * Adapt the target object to INode. 
	 * 
	 * @param target the target object to adapt
	 * @return the adapter for the EObject
	 */
	
	INode adaptEObject2INode (EObject target) {
		
		if (target == null) {
			return null;
		}
		Element domElement = null;
		
		// Try to adapt the DOM element first.
		
		if (target instanceof WSDLElement) {						
			domElement = ((WSDLElement)target).getElement();
		} else if (target instanceof XSDConcreteComponent) {
			domElement = ((XSDConcreteComponent)target).getElement();
		}
		
		if (domElement != null) {
			ensureEMFReference( target,domElement );
			return adapt (domElement, INode.class,ADAPT_HINT_NONE);			
		}		
		return null;
	}
	
 


	@SuppressWarnings("nls")
	EObject adaptINode2EObject ( INode context ) {
		
		Object value = context.nodeValue();
		if (value instanceof Element) {
			Element elm = (Element) value;
			return  (EObject) elm.getUserData("emf.model"); 
		} else if (value instanceof EObject) {
			return (EObject) value;
		} else if (context.isResolved() == false) {
			return null;
		}
		
		throw new RuntimeException("getEObject() - cannot find EMF Object");
	}
    
}
		
