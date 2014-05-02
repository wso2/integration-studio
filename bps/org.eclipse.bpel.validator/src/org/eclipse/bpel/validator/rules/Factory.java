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
package org.eclipse.bpel.validator.rules;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;

import org.eclipse.bpel.validator.model.IConstants;
import org.eclipse.bpel.validator.model.IFactory;
import org.eclipse.bpel.validator.model.Validator;


/**
 * This rule factory creates the appropriate node validator (in this case the XPath
 * validator). It is used validate expressions in the various nodes in the BPEL process.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jan 12, 2007
 */

public class Factory implements IFactory<Validator> {

	static final String PACKAGE_NAME = Factory.class.getPackage().getName();

	/**
	 * The singleton instance
	 */
	
	public static final IFactory<Validator> INSTANCE = new Factory();
	
	Logger mLogger = Logger.getLogger(getClass().getName());
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.IFactory#create(javax.xml.namespace.QName)
	 */
	
	public Validator create(QName qname) {
			
		String nsURI = qname.getNamespaceURI();
		
		if (nsURI.equals(IConstants.XMLNS_BPEL) || nsURI.equals(IConstants.XMLNS_BPEL20_OLD)) {
			// Bugzilla 324165
			// handle unknown BPEL elements
			Validator validator = createValidator ( qname.getLocalPart() );
			if (validator==null)
				validator = new UnknownElementValidator();
			return validator;
		}
		
		return null;	
	}
	
	@SuppressWarnings("nls")
	Validator createValidator ( String nodeName ) {
		
		String name = Character.toUpperCase(nodeName.charAt(0)) + nodeName.substring(1);
		
		String validatorClass = PACKAGE_NAME + "."
								+ name 
								+ "Validator";

		Object obj;
		Class<?> clazz;
		try {
			clazz = Class.forName ( validatorClass );
		} catch (Throwable t) {
			mLogger.log(Level.FINE, "Validator not found in this factory {0}",t.getMessage());			
			return null;			
		}
		
		try {
			obj = clazz.newInstance();
		} catch (Throwable t) {
			mLogger.log(Level.WARNING, "Validator class cannot be created.",t);
			return null;
		}
		
		
		if (obj instanceof Validator) {
			return (Validator) obj;
		} 
		mLogger.log(Level.WARNING, "Object is {0} is not a validator",obj);
		return null;	        
	}
	
	
}
