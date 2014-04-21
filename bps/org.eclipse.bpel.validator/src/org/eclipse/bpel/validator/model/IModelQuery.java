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
package org.eclipse.bpel.validator.model;

import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;

/**
 * This interface represents the query interface that the validator uses to ask
 * of items in the model. 
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 21, 2006
 *
 */

public interface IModelQuery extends IModelQueryLookups {
	
	/**
	 * Return error message from XSDComparer if assignments are incompatible
	 *
	 * https://jira.jboss.org/browse/JBIDE-7351
	 */
	public String getDiagnostic(int index);

	/**
	 * Answer the priority with which this implementation of ModelQuery ought to
	 * be called with.
	 * 
	 * @return the priority. Higher number, implies higher place in chain.
	 */
	
	public int priority ();
	
	
	/**
	 * Answer if the current model has support for the current 
	 * item with the given value.
	 * 
	 * @param item the item that it has support for
	 * @param value the value 
	 * @return true, false depending if support is provided.
	 */
	public boolean hasSupport ( int item, String value ) ;
	
		
	/**
	 * Return true of the two nodes are the same in the model which
	 * the validator is facading. Otherwise return false.
	 * @param test  
	 * @param n1 the first node
	 * @param n2 the second node (optional) 
	 * @return true if test passes, false otherwise.
	 */
	
	
	public boolean check ( int test, INode n1, INode n2 );
	
	
	/**
	 * Return the meta information about the function passed. 
	 * Typically, this information is provided by the model.
	 * 
	 * @param language the query/expression language namespace
	 * @param ns the namespace of the function
	 * @param name the name of the function
	 * @return the function meta 
	 */
	public IFunctionMeta lookupFunction ( String language, String ns, String name ) ;
	
	
	

    /**
	 * Lookup an INode in the model. The context node can be anything technically, but
	 * it will be most often the node that most likely makes sense for the query. So to lookup
	 * a variable in the model you will be given a reference to a context node that is most closely 
	 * logically as the place to start searching.
	 * <p>
	 * The return of the lookup method is important in the following way. 
	 * <ul>
	 *  <li> an INode which responds isResolve() == true indicates that the lookup succeeded
	 *  and that such node exist in the model.
	 *  <li> an INode which responds isResolved() == false indicates that the lookup failed
	 *  and that such node does not exist in the model.
	 *  <li> finally, a return of null means that the arguments most likely did not make sense,
	 *  most commonly that name (the 3rd argument) was null since it is assumed that context
	 *  cannot ever be null.
	 *  
	 * 
	 * @param context the context node.
	 * @param what the thing to lookup.
	 * @param name the name of the object to lookup.
	 * @return the looked-up node or null.
	 */
	
	public INode lookup ( INode context, int what, String name );
	
    
	 /**
	 * Lookup an INode in the model. 
	 * 
	 * @param context the context node.
	 * @param what the thing to lookup.
	 * @param qname the qualified name of the object to lookup.
	 * @return the looked-up node or null.
	 */
	
	public INode lookup ( INode context, int what, QName qname );
	
 
    /**
     * Lookup a certain value in the model object that normally is represented as a string
     * or text.
     *  
     * @param context the context node
     * @param what to lookup
     * @param key the value to lookup
     * @param def the default value to return, if lookup does not succeed.
     * @return the looked up value.
     */
    
    public String lookup ( INode context, int what, String key , String def);                

    /**
     * Lookup a number quantity in the model.
     * 
     * @param context
     * @param what
     * @param def
     * @return the looked-up value.
     */
    
    public int lookup (INode context, int what, int def );
    
    
    
    /**
     * Adapt a target to the class specified.
     * 
     * @param <T> the target type
     * @param target the target object
     * @param clazz the target class
     * @param hint how the target should be adapted.
     * @return the adapted object or null
     */
    
    public <T extends Object> T adapt (Object target, Class<T> clazz, int hint) ;
    
    
    /**
     * Create the QName from the name specified, using the context node as a 
     * reference point for namespace resolution.
     * 
     * @param context
     * @param name
     * @return the QName created.
     */
    
    public QName createQName ( INode context, String name ) ;
           
    /**
     * Searches all imports in the given Process for conflicting XSD definitions
     * 
     * @param process the containing Process
     * @param node the XSD element reference
     * @return the list of Imports that contain conflicting definitions or null
     * if there are no conflicts.
     * @see https://issues.jboss.org/browse/JBIDE-8088
     */
    public List<Import> findConflictingXSD(Process process, INode node);

    /**
     * Returns the Process that corresponds to the given node
     * 
     * @param node the Process element
     * @return the Process or null
     * @see https://issues.jboss.org/browse/JBIDE-8088
     */
    public Process lookupProcess(INode node);
}
