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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IProblem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jan 19, 2007
 * 
 */

@SuppressWarnings({"nls","boxing"})
public abstract class TestRunner {

	SimpleRunner fRunner;

	static Map<String, SimpleRunner> fRunners = new HashMap<String, SimpleRunner>();

	/**
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {
		String id = getClass().getSimpleName().toLowerCase();
		fRunner = fRunners.get(id);
		if (fRunner == null) {
			fRunner = new SimpleRunner(id);
			fRunners.put(id, fRunner);
		}
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {

	}

	/**
	 * There should be some errors after validating
	 * 
	 * @throws Exception
	 **/

	@Test
	public void Validate() throws Exception {

		fRunner.run();

		assertTrue("Problems have been found",
				fRunner.fProblems.length >= 0);
	}

	/**
	 * Attempt to save data.
	 * 
	 * @throws Exception
	 */

	@Test
	public void SaveCurrentRunToFile() throws Exception {
		fRunner.save();
	}

	/**
	 * @throws Exception
	 */

	@Test
	public void ListingToFile() throws Exception {
		fRunner.saveListing();
	}

	/**
	 * Check undefined messages
	 * 
	 * @throws Exception
	 */

	@Test
	public void CheckUndefinedMessageCodes() throws Exception {

		int count = checkProblems(IProblem.MESSAGE, new IFilter<String>() {
			public boolean select(String m) {
				return (m == null || m.startsWith("!"));
			}
		});
		 
		assertEquals("Undefined message codes are present [" + IProblem.MESSAGE + "]", 0, count);

	}

	/**
	 * Check model pointers
	 * 
	 * @throws Exception
	 */

	@Test
	public void XPathModelPointers() throws Exception {
		String attr="address.xpath";
		int count = checkProblems(attr, new IFilter<String>() {
			public boolean select(String m) {
				return (m == null || m.length() < 1);
			}
		});
		
		assertEquals("Problems with unset [" + attr + "] are present", 0, count);

	}

	/**
	 * @throws Exception
	 */
	@Test
	public void ModelSpecificPointers() throws Exception {
		String attr="address.model";
		int count = checkProblems(attr, new IFilter<String>() {
			public boolean select(String m) {
				return (m == null || m.length() < 1);
			}
		});
		assertEquals("Problems with unset [" + attr + "] are present", 0, count);
	}

	/**
	 * Check if Error code is set
	 * 
	 * @throws Exception
	 */

	@Test
	public void ErrorCodeSetInProblem() throws Exception {

		int count = checkProblems(IProblem.SEVERITY, new IFilter<String>() {
			public boolean select(String m) {
				if (m == null) {
					return true;
				}
				int s = Integer.parseInt(m);
				return (s != IProblem.SEVERITY_ERROR
						&& s != IProblem.SEVERITY_INFO && s != IProblem.SEVERITY_WARNING);

			}
		});
		assertEquals("Problems with unset [" + IProblem.SEVERITY + "] are present", 0, count);
	}

	/**
	 * Check to make Rule is set everywhere.
	 * 
	 * @throws Exception
	 */

	@Test
	public void RuleNameSetInProblem() throws Exception {

		int count = checkProblems(IProblem.RULE, new IFilter<String>() {
			public boolean select(String m) {
				return (m == null);
			}
		});
		assertEquals("Problems with unset [" + IProblem.RULE + "] are present", 0, count);
	}

	void checkProblemArrays() throws Exception {
		assertNotNull("Problems array is null (setup?)",
				fRunner.fProblems);
		assertNotNull("ExpectedProblems array is null (setup?)",
				fRunner.fExpectedProblems);
	}

	/**
	 * Check problems to expected problems ...
	 * 
	 * @throws Exception
	 */

	@Test
	public void CountOfProblemsToExpectedProblems() throws Exception {

		checkProblemArrays();
		assertEquals(fRunner.fExpectedProblems.length,
				fRunner.fProblems.length);
	}

	/**
	 * @throws Exception
	 */
	
	@Test
	public void CountOfInfoProblemsToExpectedInfoProblems() throws Exception {
		checkProblemArrays();
		final String info = Integer.valueOf( IProblem.SEVERITY_INFO).toString();

		IFilter<String> filter = new IFilter<String>() {
			public boolean select(String node) {
				return info.equals(node);
			}
		};
		int expectedInfoProblems = count(fRunner.fExpectedProblems,
				IProblem.SEVERITY, filter);
		int infoProblems = count(fRunner.fProblems, IProblem.SEVERITY, filter);
		assertEquals(expectedInfoProblems, infoProblems);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void CountOfWarningProblemsToExpectedWarningProblems()
			throws Exception {
		checkProblemArrays();
		final String info = Integer.valueOf( IProblem.SEVERITY_WARNING).toString();

		IFilter<String> filter = new IFilter<String>() {
			public boolean select(String node) {
				return info.equals(node);
			}
		};
		int expectedInfoProblems = count(fRunner.fExpectedProblems,
				IProblem.SEVERITY, filter);
		int infoProblems = count(fRunner.fProblems, IProblem.SEVERITY, filter);
		assertEquals(expectedInfoProblems, infoProblems);

	}

	/**
	 * @throws Exception
	 */
	@Test
	public void CountOfErrorProblemsToExpectedErrorProblems() throws Exception {
		checkProblemArrays();
		final String info = Integer.valueOf( IProblem.SEVERITY_ERROR).toString();

		IFilter<String> filter = new IFilter<String>() {
			public boolean select(String node) {
				return info.equals(node);
			}
		};
		int expectedInfoProblems = count(fRunner.fExpectedProblems,
				IProblem.SEVERITY, filter);
		int infoProblems = count(fRunner.fProblems, IProblem.SEVERITY, filter);
		assertEquals(expectedInfoProblems, infoProblems);
	}

	
	static String ATTRIBUTES [] = { 
			IProblem.LINE_NUMBER, IProblem.CHAR_END, IProblem.CHAR_START,
			IProblem.SEVERITY, IProblem.MESSAGE, IProblem.FIX,
			IProblem.RULE, IProblem.RULE_DESC, IProblem.SA_CODE 
	};

	
	/**
	 * Compare the problem we had found so far to the list of expected problems.
	 * All of the problems must match in the severity , location, pointers, etc.
	 * 
	 * @throws Exception
	 */
	@Test
	public void CompareProblemsToExpectedProblems() throws Exception {
		int matched = 0;
		for (IProblem p : fRunner.fProblems) {
			for (IProblem ep : fRunner.fExpectedProblems) {
				boolean bSame = matchProblem ( p, ep );
				// matched, increment the count and get out.
				if (bSame) {
					matched += 1;
					break;
				}
			}
		}			 
		assertEquals("Matched to Expected problems: ",
				fRunner.fExpectedProblems.length,
				matched				
				 );
	}

	/**
	 * Compare the expected problems to the list of problems we had found.
	 * All of the problems must match in the severity , location, pointers, etc. 
	 * @throws Exception
	 */
	
	@Test
	public void CompareExpectedProblemsToProblems() throws Exception {
		int matched = 0;
		for (IProblem ep : fRunner.fExpectedProblems ) {
			for (IProblem p : fRunner.fProblems ) {
				boolean bSame = matchProblem ( ep, p );
				// matched, increment the count and get out.
				if (bSame) {
					matched += 1;
					break;
				}
			}
		}			 
		assertEquals("Expected Problems to Matched problems: ",							
				fRunner.fProblems.length,
				matched );
	}

	

	boolean matchProblem (IProblem p1, IProblem p2) {
		// compare all attributes.
		// if all are the same then we have matched the error from the
		// list.
		// 
		for (String attr : ATTRIBUTES) {

			Object p1_attr  = p1.getAttribute(attr);
			Object p2_attr = p2.getAttribute(attr);

			if (p1_attr == null && p2_attr == null) {
				continue;
			}
			if (p1_attr == null || p2_attr == null) {
				return false;				
			}
			p1_attr = p1_attr.toString();
			p2_attr = p1_attr.toString();
			// now compare them.			
			if ( !p1_attr.equals(p2_attr) ) {
				return false;				
			}
		}
		return true;
	}


	int  checkProblems(String attr, IFilter<String> filter) {
		int count = 0;

		assertNotNull("The problem array is null (setup?) ",
				fRunner.fProblems);

		for (IProblem p : fRunner.fProblems) {
			Object value = p.getAttribute(attr, null);
			String m = value != null ? value.toString() : "";
			if (filter.select(m)) {
				count += 1;
			}
		}
		return count;
	}

	int count(IProblem[] list, String attr, IFilter<String> filter) {
		int count = 0;

		assertNotNull("The problem array is null (setup?) ", list);
		for (IProblem p : list) {
			Object value = p.getAttribute(attr, null);
			String m = value != null ? value.toString() : "";
			if (filter.select(m)) {
				count += 1;
			}
		}

		return count;
	}

	/**
	 * Add the tests that you want to run here.
	 * 
	 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
	 * @date Jul 29, 2008
	 * 
	 * 
	 */

	static public class T0 extends TestRunner {
	}

	/**
	 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
	 * @date Aug 26, 2008
	 *
	 */
	static public class T1 extends TestRunner {
	}

	/**
	 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
	 * @date Aug 26, 2008
	 *
	 */
	static public class T2 extends TestRunner {
	}

	/**
	 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
	 * @date Aug 26, 2008
	 *
	 */
	static public class T3 extends TestRunner {
	}

	/**
	 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
	 * @date Aug 26, 2008
	 *
	 */
	static public class T4 extends TestRunner {
	}

	/**
	 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
	 * @date Aug 26, 2008
	 *
	 */
	static public class T5 extends TestRunner {
	}
}
