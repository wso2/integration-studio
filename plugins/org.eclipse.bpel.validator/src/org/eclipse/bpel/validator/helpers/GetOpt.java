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
package org.eclipse.bpel.validator.helpers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Mar 6, 2007
 * 
 */

@SuppressWarnings({"nls","boxing"})
public class GetOpt {

	List<String> mParams = new ArrayList<String>(8);
	
	/** this way arguments come in order of appearance */
	Map<Character,String> mOpt = new LinkedHashMap<Character,String>(11);

	/**
	 * Create a brand new shiny GetOpt object.
	 * 
	 * @param strControl
	 * @param args
	 * @throws Exception
	 */


	public GetOpt(String strControl, String args[]) throws Exception {

		for (int i=0; i < args.length; i++) {
			String sOpt = args[i];
			if (sOpt.length() < 1) {
				// probably parameters
				mParams.add(sOpt);
				continue;
			}
			char ch1 = sOpt.charAt(0);
			// Use only - to switch, the windows switches / do not work with unix 
			// absolute paths.
			
			if (ch1 != '-') {
				// probably parameters
				mParams.add(sOpt);
				continue;
			}

			// silently ignore bogus command line entries
			if (sOpt.length() < 2) {
				continue;
			}

			char ch2 = sOpt.charAt(1);
			int nIndex = strControl.indexOf(ch2);
			if (nIndex < 0) {
				throw new Exception("Unknown command option " + ch2 );
			}

			// argument ?
			if (nIndex >= 0 && (nIndex + 1) < strControl.length()
					&& strControl.charAt(nIndex + 1) == ':') {

				if (sOpt.length() > 2) {
					mOpt.put(ch2, sOpt.substring(2));
				} else if ((i + 1) < args.length) {
					i += 1;
					mOpt.put(ch2, args[i]);
				} else {
					throw new Exception("Expected argument for option " + ch2);
				}

			} else {
				for (int j = 1; j < sOpt.length(); j++) {
					mOpt.put(sOpt.charAt(j), "1");
				}
			}

		}
	}

	/**
	 * Respond with the option/key set
	 * 
	 * @return key set
	 */

	public char[] getOptions() {
		char options[] = new char[ mOpt.size() ];
		int x = 0;
		for(char ch : mOpt.keySet()) {
			options[x++] = ch;
		}
		return options;
	}

	/** 
	 * @param c
	 * @return Answer if the option is present
	 */

	public boolean hasOption(char c) {
		return mOpt.containsKey(c);
	}

	/**
	 * Get option identified by the character passed.
	 * @param c
	 * @return the option
	 */
	public String getOption(char c) {
		return mOpt.get(c);
	}
	
	/**
	 * Return the list of parameters collected that are not options
	 * @return the list of parameters collected.
	 */
	public List<String> parameters() {
		return mParams;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(32);		
		sb.append("[GetOpt=").append(mOpt).append(",").append(mParams)
				.append("]");
		return sb.toString();
	}
}
