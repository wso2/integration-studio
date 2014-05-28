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
package org.eclipse.bpel.validator.junit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;

import junit.framework.Assert;

import org.eclipse.bpel.validator.Main;
import org.eclipse.bpel.validator.helpers.CmdValidator;
import org.eclipse.bpel.validator.model.IProblem;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 28, 2008
 *
 */
@SuppressWarnings("nls")
public class SimpleRunner {

	Main fValidator ;
			
	/** Problems generated from the validation */
	IProblem[] fProblems;
	
	/** Problems read from the problems file */
	IProblem[] fExpectedProblems;	
	
	String fTestCase = "t?";
	
	URL fInput;
	
	/**
	 * @param testCase
	 */
	public SimpleRunner (String testCase) {
		fTestCase = testCase;
	}
	
	/**
	 * @throws Exception
	 */
		
	public void run () throws Exception {
		
		fValidator = new Main();		
		
		String input = fTestCase + "/" + fTestCase + ".bpel";		
		fInput = getURL(input);
		Assert.assertNotNull("Not found: " + input + "; check classpath for 'tests'" , fInput);
				
		String output = input + ".xml";	
		InputStream os = get(output);
		
		// expected results are empty, ok
		if (os == null) {
			fExpectedProblems = new IProblem[] {};
		} else {
			fExpectedProblems = CmdValidator.readMessages( os, output );
		}
		
		fProblems = fValidator.validate( fInput );							
	}

	
	/**
	 * @throws Exception
	 */
	public void save ( ) throws Exception {
		// save them
		
		if ( "file".equals( fInput.getProtocol() ) ) {
			
			String saveOutput = fInput.toString() + ".out.xml";
			URL out = new URL(saveOutput);
			out.getFile();			
			
			File log = new File( out.getFile() );						
			PrintStream ps = null;
			try {
				ps = new PrintStream( log );
				fValidator.log(fProblems, ps);
			} catch (FileNotFoundException e) {
				// 
			} finally {
				if (ps != null) {
					ps.close();
				}
			}							
			return ;
		} 
		
		throw new Exception("Cannot save to non-file URLs " + fInput );			
	}
	

	/**
	 * @throws Exception
	 */
	public void saveListing ( ) throws Exception {
		// save them
		
		if ( "file".equals( fInput.getProtocol() ) ) {
			
			String saveOutput = fInput.toString() + ".log";
			URL out = new URL(saveOutput);
			out.getFile();
			
			File log = new File( out.getFile() );						
			PrintStream ps = null;
			try {
				ps = new PrintStream( log );
				fValidator.errorListing(fInput.openStream(), fProblems, ps);
			} catch (FileNotFoundException e) {
				// 
			} finally {
				if (ps != null) {
					ps.close();
				}
			}							
			return ;
		} 
		
		throw new Exception("Cannot save to non-file URLs");			
	}
	
	
	InputStream get (String name) {
		return getClass().getClassLoader().getResourceAsStream(name);
	}
	URL getURL (String name) {
		return getClass().getClassLoader().getResource(name);
	}
	
}
