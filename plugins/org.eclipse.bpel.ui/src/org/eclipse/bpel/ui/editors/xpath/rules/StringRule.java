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
 * A rule for recognizing a sequence of characters, whatever that
 * might be ...
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Nov 17, 2006 
 */

public class StringRule implements IRule {

	IToken fToken;

	String fSequence;

	/**
	 * Return a brand new shiny String Rule ...
	 * 
	 * @param token
	 * @param sequence
	 */
	
	public StringRule(IToken token, String sequence) {
		assert token != null;
		fToken = token;
		assert sequence != null;
		fSequence = sequence;
	}

	/**
	 * 
	 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
	 */
	public IToken evaluate(ICharacterScanner scanner) {
		int cnt = 0;

		for (int i = 0, j = fSequence.length(); i < j; i++) {

			int ch = scanner.read();
			cnt += 1;

			if (ch != fSequence.charAt(i)) {
				//
				for (int x = 0; x < cnt; x++) {
					scanner.unread();
				}
				return Token.UNDEFINED;
			}
		}

		return fToken;
	}
}
