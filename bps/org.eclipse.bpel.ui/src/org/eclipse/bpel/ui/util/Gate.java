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
package org.eclipse.bpel.ui.util;

import java.lang.reflect.Method;



/**
 *  This is a good example of a dynamic proxy in Java.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Nov 3, 2006
 *
 */
public class Gate implements IGate, java.lang.reflect.InvocationHandler {

    private Object fObj;
    
    /**
     * Should access be synchronized around the proxy object.
     */
    boolean bSync = false;
    
    /**
     * Is the Gate armed ? If so, no traffic is allowed.
     */
    boolean fArmed = false;
        
    /** 
     * Create a new instance of an IGate that also responds to the 
     * protocol of the object passed.
     * 
     * @param obj whose method access will be gated.
     * @return a new instance of the dynamic proxy
     */
    
    public static final Object newInstance ( Object obj ) {
    	return newInstance ( obj, false );
    }
    
    /** 
     * Create a new instance of an IGate that also responds to the 
     * protocol of the object passed.
     * 
     * @param obj whose method access will be gated.
     * @param sync if set to true, method invocations will be synchronized.
     * @return a new instance of the dynamic proxy
     */
    
    public static final Object newInstance ( Object obj , boolean sync) {

    	Class[] i1 = obj.getClass().getInterfaces();
    	Class[] i2 = new Class[] { IGate.class };
    	Class[] iA = new Class[ i1.length + i2.length ];
    	System.arraycopy(i1, 0, iA, 0, i1.length);
    	System.arraycopy(i2, 0, iA, i1.length, i2.length); 
    	
		return java.lang.reflect.Proxy.newProxyInstance(
					obj.getClass().getClassLoader(),
					iA,
					new Gate(obj, sync) );
    }

    /**
     * Private constructor, so the only way to get instances is via
     * newInstance().
     * 
     * @param obj
     * @param sync
     */
    
    Gate (Object obj, boolean sync) {
    	fObj = obj;
    	bSync = sync;
    }
    
    
    /**
     * The invocation handler of the dynamic proxy.
     * 
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    
    public Object invoke (Object proxy, Method m, Object[] args) throws Throwable
    {    	
    	try {
    		// if the method invocation succeeds on us, then the method was
    		// on one of the interfaces that we implement. Otherwise, it is
    		return m.invoke(this, args);
    	} catch (Throwable t) {
    		// not for us; fall through, continue proxy execution.    		
    	}
    	
    	if (fArmed) {
    		return null;
    	}
    	
    	if (bSync) {
    		synchronized (fObj) {
    			return m.invoke(fObj,args);
    		}
    	} 
    	
    	return m.invoke(fObj, args);
    }

    
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.ui.util.IGate#off()
	 */
    
	public void off() {
		fArmed = false;		
	}

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.ui.util.IGate#on()
	 */
	
	public void on() {
		fArmed = true;		
	}	    
        
}

