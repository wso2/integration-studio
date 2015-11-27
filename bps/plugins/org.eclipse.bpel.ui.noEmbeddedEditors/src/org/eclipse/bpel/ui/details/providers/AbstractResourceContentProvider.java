/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation
 *******************************************************************************/
package org.eclipse.bpel.ui.details.providers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * Content provider for EMF objects that can be read from the Workspace 
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 */

public abstract class AbstractResourceContentProvider extends AbstractContentProvider  {	
	
	static private final String SLASH = "/"; //$NON-NLS-1$
	
	/**
	 * Append the schemas that are present in the object passed to the list
	 * indicated.   
	 * 
	 * @param input an object that has or is schema definitions.
	 * @param list the list where the schemas are put.
	 */
	
	
	ResourceSet fResourceSet;
	 
	public AbstractResourceContentProvider ( ResourceSet set ) {

		fResourceSet = set;
	}
	
	
	protected void doCollectElements ( Object input, List list) throws CoreException {
		
		if (input == null) {
			return ;
		}
		
		if (input instanceof IContainer) {			
			findCandidates((IContainer) input,list, getKindClass() );
			return;
		}
		
 
		if (isAcceptableKind(input)) {
			list.add(input);			
			return;
		}

		Object[] arr = null;
		
		if (input.getClass().isArray()) {			
			arr = (Object[]) input;
		} else if (input instanceof List) {
			arr = ((List)input).toArray();
		}
		
		if (arr == null) {
			return;
		}
		
		for(int i=0; i < arr.length; i++) {
			doCollectElements ( arr[i], list );
		}					
	}
		
	

	@Override
	public void collectElements (Object input, List list) {
		try {
			doCollectElements ( input, list );
		} catch (CoreException e) {
			BPELUIPlugin.log(e);
		}	
	}				
	
	
	
	/**
	 * Check of the object passed is of the acceptable kind. This simply
	 * checks to see if the the result returned by {@link #getKindClass()}
	 * matches the object passed.
	 *  
	 * @param obj the object to test.
	 * @return true/false, depending on outcomee.
	 */
	
	protected boolean isAcceptableKind ( Object obj ) {
		
		Class [] kind = getKindClass();
		
		if (kind == null) {
			return true;
		}
		
		for(int i=0; i < kind.length; i++) {
			if (kind[i].isInstance(obj)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	/**
	 * Find the candidate objects to load.
	 * 
	 * @param container
	 * @param list
	 * @param the kind of EMF objects that we want back
	 * @return
	 * @throws CoreException
	 */
	
	protected List findCandidates ( IContainer container, List list, Class [] kind ) throws CoreException {
		
		if (list == null) {
			list = new LinkedList();
		}		
		
		Iterator i = findCandidates( container ).iterator();
		while (i.hasNext()) {
			IResource r = (IResource) i.next();
			try {
				Object obj = load(r);
				if ( isAcceptableKind (obj) ) {
					list.add(obj);
				} 
			} catch (Exception ex) {
				BPELUIPlugin.log(ex);
			}
		}
		return list;
	}	

	
	/**
	 * Load the EMF model from the resource indicated. Return the top EMF object for the model. 
	 *  
	 * @param r
	 * @return
	 */
	
	protected Object load ( IResource r ) 
    {
    	// Format: /Project/path    	
    	String uri = SLASH + r.getProject().getName() + SLASH + r.getProjectRelativePath();
        URI locationURI = URI.createPlatformResourceURI( uri );       
            
        Resource resource = fResourceSet.getResource(locationURI, true);        
        return resource.getContents().get(0);               
    }

	
	
	protected abstract String[] getKind () ;
	
	
	/**
	 * Return the kind of objects that we as a provider are interested in
	 * 
	 * @return an array of kind of objects that we are interested in
	 */
	
	protected Class[] getKindClass () {
		return null;
	}
	
	
	/**
	 * Return the depth at which discover for new resources will abort if none is found
	 * at the current level and the level below.
	 * 
	 * @return the max depth to search, including current level
	 */
	
	protected int getDepth ( ) {
		return 2;
	}
	
	
	/**
	 * Find candidate resourcesin the container passed. The container is searched
	 * up to a certain depth. If resources are found in that container then the next
	 * level is searched. Otherwise the search at that level stops. So not exactly a full
	 * workspace scan.
	 * 
	 * @param container the container to search (project, folder, workspace root)
	 * @return the list of schemas found
	 * @throws CoreException
	 */
	
	protected List findCandidates ( IContainer container ) throws CoreException {
		
		LinkedList list = new LinkedList();
		
		// Workspace root contains Projects ...
		if (container instanceof IWorkspaceRoot) {
			return findCandidates( container, list, getKind(), getDepth() + 1 );
		}		
		return findCandidates( container, list, getKind(), getDepth() );		
	}
	
	
	
	
	protected List findCandidates ( IContainer container, List list, String [] kind , int depth ) throws CoreException {
		
		if (depth <= 0 || container.isAccessible() == false) {
			return list;
		}
		
		depth -= 1;
		
		boolean bFound = false;
		
		IResource [] rlist = container.members();
			
		for(int i=0; i< rlist.length; i++) {
			
			IResource r = rlist[i];
			if ( r.getType() != IResource.FILE) {
				continue;
			}			
			String name = r.getFileExtension();
			for(int j=0; j < kind.length; j++) {
				if (name != null && name.equalsIgnoreCase(kind[j])) {
					bFound = true;
					list.add( r );
					break;
				}
			}				
		}
		
		// if found some candidates at this level, look only in the next level (and
		// so on). Eventually, not all levels are searched, just the ones that contain
		// xsd resources and their descendant folders
		
		if (bFound) {
			depth = 1;
		}
			
		for(int i=0; i < rlist.length; i++) {
			IResource r = rlist[i];
			if (r instanceof IContainer) {
				findCandidates((IContainer) r, list, kind, depth);
			}
		}
		
		return list;
	}
	
	
}
