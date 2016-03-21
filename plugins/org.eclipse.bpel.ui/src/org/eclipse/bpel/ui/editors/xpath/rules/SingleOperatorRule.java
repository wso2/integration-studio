/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.editors.xpath.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

/**
 * Rule for a single operator. Things like +,-, *, /
 * 
 * Make sure that none of the single operators follow the single operator that
 * we specify here.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 26, 2006
 * 
 */
public class SingleOperatorRule implements IRule {
	IToken fToken;

	String fChars;

	/**
	 * Return a brand new shiny Single Operator Rule object.
	 * @param token
	 * @param chars
	 */
	public SingleOperatorRule(IToken token, String chars) {
		assert token != null;
		fToken = token;
		assert chars != null;
		fChars = chars;
	}

	/**
	 * 
	 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
	 */
	public IToken evaluate(ICharacterScanner scanner) {
		int ch = scanner.read();

		if (fChars.indexOf(ch) >= 0) {
			// look ahead ... make sure we don't have any combination of that
			// character with the next one.
			int ch2 = scanner.read();
			scanner.unread();

			if (fChars.indexOf(ch2) >= 0) {
				scanner.unread();
				return Token.UNDEFINED;
			}
			return fToken;
		}

		scanner.unread();
		return Token.UNDEFINED;
	}
}
