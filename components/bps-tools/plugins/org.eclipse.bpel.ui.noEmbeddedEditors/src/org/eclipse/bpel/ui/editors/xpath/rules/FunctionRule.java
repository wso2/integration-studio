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

import org.eclipse.bpel.ui.editors.xpath.XPathWhitespaceDetector;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;

/**
 * Functions in XPath start with QName and are followed by a ( The exception are
 * the basic nodes XML nodes like
 * 
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 26, 2006
 * 
 */

public class FunctionRule extends WordRule {

	static final XPathWhitespaceDetector fWhiteSpaceDetector = new XPathWhitespaceDetector ();
	/**
	 * @param detector
	 */

	public FunctionRule(IWordDetector detector) {
		super(detector);

	}

	/**
	 * @param words
	 * @param token
	 */
	public void addWords(String[] words, IToken token) {
		for (int i = 0; i < words.length; i++) {
			addWord(words[i], token);
		}
	}

	
	/**
	 * 
	 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
	 */

	
	@Override
	public IToken evaluate (ICharacterScanner scanner) {

		IToken token = super.evaluate(scanner);
		if (token == Token.UNDEFINED) {
			return token;
		}

		// check if the following character is a ( - which is an argument list
		// for a
		// function. if so then this is a function call name

		int cnt = 0;
		int ch;
		do {
			ch = scanner.read();
			cnt += 1;
		} while (fWhiteSpaceDetector.isWhitespace((char) ch));

		if (ch == '(') {

			// bingo !
			while (cnt > 0) {
				scanner.unread();
				cnt -= 1;
			}

			return token;
		}

		// not a function call, so this is not a valid presentation
		unreadBuffer(scanner);

		return Token.UNDEFINED;
	}
}
