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
 * Single character rule. If the character is matched, the token is returned and
 * the style is applied.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 26, 2006
 * 
 */

public class SingleCharRule implements IRule {

	IToken fToken;

	String fChars;

	/**
	 * Return a brand new shiny Single Character Rule.
	 * 
	 * @param token
	 * @param chars
	 */
	
	public SingleCharRule(IToken token, String chars) {
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
			return fToken;
		}
		scanner.unread();

		return Token.UNDEFINED;
	}
}