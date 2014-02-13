/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation
 *******************************************************************************/

package org.eclipse.bpel.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.Templates;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.operation.IRunnableWithProgress;


/**
 * This class defines the BPEL Project creation operation.
 * 
 * @author Edwin Khodabakchian (edwin.khodabakchian@oracle.com)
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 */

public class BPELCreateOperation implements IRunnableWithProgress {

    // The element to open
    private IResource mElementToOpen;        
    
    // Process name, namespace from the wizard pages
    private Map mArgs ;
     
    // The container where we should create the BPEL file/process
    private IContainer mContainer ;
    
    // The template from which we will be creating the file(s)
    private Templates.Template mTemplate;
    
    
	public void setArgs(Map args) {
		mArgs = args;
	}

	
	public void setContainer(IContainer container) {
		mContainer = container;
	}
	
	public void setTemplate(Templates.Template template) {
		mTemplate = template;
	}



	/**
     * Runs the creation operation. This basically involves getting the templates and
     * creating the initial project.
     * 
     * @param monitor the monitor to use
     * @throws InvocationTargetException 
     * @throws InterruptedException 
     * 
     * @see IRunnableWithProgress#run(IProgressMonitor)
     */
    
    public void run(IProgressMonitor monitor) 	
    			throws InvocationTargetException, InterruptedException 
    {
        if (monitor == null) {
            monitor= new NullProgressMonitor();
        }
        mElementToOpen = null;
        
        
        List resources = mTemplate.getResources();
        monitor.beginTask(Messages.BPELCreateOperation_0, resources.size());
        
        Iterator ii = resources.iterator();
        while (ii.hasNext()) {
        	
        	Templates.TemplateResource resource = (Templates.TemplateResource) ii.next();
        	
        	String result = resource.process( mArgs );
        	try {
	        	IFile file = save (mContainer, resource.getName( mArgs ), result );
	        	if (mElementToOpen == null && resource.isProcess ()) {
	        		mElementToOpen = file;
	        	}
        	} catch (CoreException ce) {
        		BPELUIPlugin.log(ce);
        	}
        	monitor.worked(1);
        }

        monitor.done();
        
    }       
    
    
	/**
	 * Return the resource to open when when a base definition of the project is created.
	 * @return an IResource that should be auto-magically opened.
	 */
	
	public IResource getElementToOpen() {
        return mElementToOpen;
    }
    
    /**
     * Save the content of the file indicated by fName to the container passed.
     * May throw an exception
     * 
     * @param container the container where the save should take place.
     * @param fName the file name where the save should take place.
     * @param content the content to save	 * 
	 * @throws CoreException if something bad happens
	 * 
	 */
    
	private IFile save ( IContainer container, 
                             String fName, 
                             String content                              
                             ) throws CoreException
	{
        IFile file = container.getFile(new Path(fName));
        InputStream stream = new ByteArrayInputStream( content.getBytes() );
        try 
        {            
            if (file.exists()) 
            {
                file.setContents(stream, true, true, null);
            } 
            else 
            {
                file.create(stream, true, null);
            }            
        } 
        finally
        {
            try {
                stream.close();
            } catch (Exception ex) {
                // ignore
            }
        }
        
        return file;
	}

}

