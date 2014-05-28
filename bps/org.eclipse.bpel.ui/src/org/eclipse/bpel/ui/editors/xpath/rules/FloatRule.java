/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.editors.xpath.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

/**
 * Read and understand the floating point numbers and numbers in XPath.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 26, 2006
 */

public class FloatRule implements IRule {

	IToken fToken;

	/**
	 * Return a brand new shiny FloatRule.
	 * 
	 * @param token
	 */
	
	public FloatRule(IToken token) {
		fToken = token;
		assert token != null;
	}

	boolean isDigit(int c) {
		return c >= 0x30 && c <= 0x39; // [0-9]
	}

	/**
	 * 
	 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
	 */

	public IToken evaluate(ICharacterScanner scanner) {
		int cnt = 0;

		int c = scanner.read();
		cnt += 1;

		if (isDigit(c)) {
			do {
				c = scanner.read();
				cnt += 1;
			} while (isDigit(c));
		}

		scanner.unread();
		cnt -= 1;

		// either we start with . or continue with .
		c = scanner.read();
		cnt += 1;

		if (c == '.') {
			int cnt2 = cnt;
			do {
				c = scanner.read();
				cnt += 1;
			} while (isDigit(c));
			scanner.unread();
			cnt -= 1;

			// we have not read any digits after the .
			// so we reject this as a number
			if (cnt == cnt2) {
				// spit out the whole thing.
				while (cnt > 0) {
					scanner.unread();
					cnt -= 1;
				}
				return Token.UNDEFINED;
			}

			// we have seen a number of the format
			// [0-9]+.[0-9]+ or .[0-9]+
			return fToken;
		}

		scanner.unread();
		cnt -= 1;

		return (cnt > 0 ? fToken : Token.UNDEFINED);
	}

}