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
package org.eclipse.bpel.ui.editors.xpath;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextViewer;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 25, 2006
 *
 */

 public class XPathSourceDoubleClickStrategy implements ITextDoubleClickStrategy {

	 protected XPathWordDetector fWordDetector = new XPathWordDetector();
	 
	 protected ITextViewer fText;

 	/**
 	 * Do something on double-click. For us, this means selecting the right amount of 
 	 * characters to form word or string.
 	 * 
 	 * @see org.eclipse.jface.text.ITextDoubleClickStrategy#doubleClicked(org.eclipse.jface.text.ITextViewer)
 	 */
 	public void doubleClicked (ITextViewer part) {
         
 		int pos = part.getSelectedRange().x;

 		if (pos < 0) {
 			return;
 		}

 		fText = part;

 		if (!selectComment(pos)) {
 			selectWord(pos);
 		}
 	}
 	
 	
 	protected boolean selectComment(int caretPos) {
 		IDocument doc = fText.getDocument();
 		int startPos, endPos;

 		try {
 			int pos = caretPos;
 			char c = ' ';

 			while (pos >= 0) {
 				c = doc.getChar(pos);
 				if (c == '\\') {
 					pos -= 2;
 					continue;
 				}
 				if (c == Character.LINE_SEPARATOR || c == '\"')
 					break;
 				--pos;
 			}

 			if (c != '\"')
 				return false;

 			startPos = pos;

 			pos = caretPos;
 			int length = doc.getLength();
 			c = ' ';

 			while (pos < length) {
 				c = doc.getChar(pos);
 				if (c == Character.LINE_SEPARATOR || c == '\"')
 					break;
 				++pos;
 			}
 			if (c != '\"')
 				return false;

 			endPos = pos;

 			int offset = startPos + 1;
 			int len = endPos - offset;
 			fText.setSelectedRange(offset, len);
 			return true;
 		} catch (BadLocationException x) {
 		}

 		return false;
 	}
 	
 	
 	protected boolean selectWord(int caretPos) {

 		IDocument doc = fText.getDocument();
 		int startPos, endPos;

 		try {

 			int pos = caretPos;
 			char c;

 			while (pos >= 0) {
 				c = doc.getChar(pos);
 				if (! fWordDetector.isWordPart(c))
 					break;
 				--pos;
 			}

 			startPos = pos;

 			pos = caretPos;
 			int length = doc.getLength();

 			while (pos < length) {
 				c = doc.getChar(pos);
 				if (!fWordDetector.isWordPart(c))
 					break;
 				++pos;
 			}

 			endPos = pos;
 			selectRange(startPos, endPos);
 			return true;

 		} catch (BadLocationException x) {
 		}

 		return false;
 	}

 	private void selectRange(int startPos, int stopPos) {
 		int offset = startPos + 1;
 		int length = stopPos - offset;
 		fText.setSelectedRange(offset, length);
 	}
 }
