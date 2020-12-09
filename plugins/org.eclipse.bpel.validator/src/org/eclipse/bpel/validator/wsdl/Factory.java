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
package org.eclipse.bpel.validator.wsdl;

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
	 * Singleton instance
	 */
	public static final IFactory<Validator> INSTANCE = new Factory();
	
	Logger mLogger = Logger.getLogger(getClass().getName());
			
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.IFactory#create(javax.xml.namespace.QName)
	 */
	
	public Validator create(QName qname) {
		
		String nsURI = qname.getNamespaceURI();
		if (IConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE.equals ( nsURI ) ||
			IConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE_2.equals (nsURI ) ||
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7107
			// oops - also create validator for Definitions
			IConstants.XMLNS_WSDL.equals (nsURI )) 
		{
			return createValidator( qname.getLocalPart() );
		}		
		return null;
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
			mLogger.log(Level.FINE, "Validator not found in this factory {0}",e.getMessage());			
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
