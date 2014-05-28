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
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;


/**
 * Rule for recognizing axis.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 20, 2006
 *
 */
public class AxisRule extends WordRule {

	/**
	 * @param detector
	 */

	public AxisRule(IWordDetector detector) {
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
	 * Axis names are (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.WordRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
	 */
	@Override
	public IToken evaluate(ICharacterScanner scanner) {

		IToken token = super.evaluate(scanner);
		if (token == Token.UNDEFINED) {
			return token;
		}
		// otherwise we have matched the axis name, however, for it to be valid
		// it must be followed by ::
		// so ...
		int ch1 = scanner.read();
		int ch2 = scanner.read();
		if (ch1 == ch2 && ch1 == ':') {
			scanner.unread();
			scanner.unread();
			return token;
		}

		// not it
		unreadBuffer(scanner);
		return Token.UNDEFINED;
	}
}
