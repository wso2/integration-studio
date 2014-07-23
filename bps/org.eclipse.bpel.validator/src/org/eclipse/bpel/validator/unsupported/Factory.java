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
package org.eclipse.bpel.validator.unsupported;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;

import org.eclipse.bpel.validator.model.IConstants;
import org.eclipse.bpel.validator.model.IFactory;
import org.eclipse.bpel.validator.model.Validator;


/**
 * This rule factory creates the appropriate node validators.
 * 
 * This particular node validator is used as the default final factory for
 * unsupported versions of our favorite elements.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 12, 2007
 */

public class Factory implements IFactory<Validator>  {

	static final String PACKAGE_NAME = Factory.class.getPackage().getName();

	
	/**
	 * 
	 */
	public static final IFactory<Validator> INSTANCE = new Factory();
	
	Logger mLogger = Logger.getLogger(getClass().getName());
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.IFactory#create(javax.xml.namespace.QName)
	 */
	
	public Validator create(QName qname) {
		
		String nsURI = qname.getNamespaceURI();
		
		if (nsURI.equals(IConstants.XMLNS_BPEL) || nsURI.equals(IConstants.XMLNS_BPEL20_OLD)) {
			return null;
						
		}		
		return createValidator ( qname.getLocalPart() );		
	}
	
	@SuppressWarnings("nls")
	Validator createValidator ( String nodeName ) {
		
		String name = Character.toUpperCase(nodeName.charAt(0)) + nodeName.substring(1);
		
		String validatorClass = PACKAGE_NAME + "." + name;

		Object obj;
		Class<?> clazz;
		try {
			clazz = Class.forName ( validatorClass );
		} catch (ClassNotFoundException e) {					
			return null;			
		}
		
		try {
			obj = clazz.newInstance();
		} catch (Exception ex) {
			mLogger.log(Level.WARNING, "Validator class cannot be created.",ex);
			return null;
		}
		
		
		if (obj instanceof Validator) {
			return (Validator) obj;
		} 
		mLogger.log(Level.WARNING, "Object is {0} is not a validator",obj);
		return null;	        
	}
	
	
}
