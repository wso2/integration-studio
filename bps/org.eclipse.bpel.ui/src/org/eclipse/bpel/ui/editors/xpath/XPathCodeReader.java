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

import java.io.IOException;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

/**
 * Reads from a document either forwards or backwards. May be configured to skip
 * comments and strings.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 27, 2006
 * 
 */

public class XPathCodeReader {

	/** The EOF character */
	public static final int EOF = -1;

	private boolean fSkipStrings = false;

	private boolean fForward = false;

	private IDocument fDocument;

	private int fOffset;

	private int fEnd = -1;


	/**
	 * Return an XPathCodeReader.
	 *
	 */
	
	public XPathCodeReader() {
		
	}

	/**
	 * Returns the offset of the last read character. Should only be called
	 * after read has been called.
	 * @return offset
	 */
	
	public int getOffset() {
		return fForward ? fOffset - 1 : fOffset;
	}

	/**
	 * 
	 * @param document
	 * @param offset
	 * @param length
	 * @param skipStrings
	 */
	
	public void configureForwardReader (IDocument document, int offset,	int length, boolean skipStrings) {
		fDocument = document;
		fOffset = offset;
		fSkipStrings = skipStrings;

		fForward = true;
		fEnd = Math.min(fDocument.getLength(), fOffset + length);
	}

	/**
	 * 
	 * @param document
	 * @param offset
	 * @param skipStrings
	 * @throws IOException
	 */
	
	public void configureBackwardReader(IDocument document, int offset, boolean skipStrings) throws IOException {
		fDocument = document;
		fOffset = offset;
		fSkipStrings = skipStrings;

		fForward = false;
		try {
			fDocument.getLineOfOffset(fOffset);
		} catch (BadLocationException x) {
			throw new IOException(x.getMessage());
		}
	}

	/**
	 * 
	 */
	public void close()  {
		fDocument = null;
	}

	/**
	 * @return the next character read, in either the forward or reverse direction. 
	 * @throws IOException if bad location (passed start or end)
	 * 
	 */
	
	public int read() throws IOException {
		try {
			return fForward ? readForwards() : readBackwards();
		} catch (BadLocationException x) {
			throw new IOException(x.getMessage());
		}
	}

	private void gotoStringEnd(char delimiter) throws BadLocationException {
		while (fOffset < fEnd) {
			char current = fDocument.getChar(fOffset++);
			if (current == '\\') {
				// ignore escaped characters
				++fOffset;
			} else if (current == delimiter) {
				return;
			}
		}
	}

	@SuppressWarnings("unused")
	private void gotoLineEnd() throws BadLocationException {
		int line = fDocument.getLineOfOffset(fOffset);
		fOffset = fDocument.getLineOffset(line + 1);
	}

	
	private int readForwards() throws BadLocationException {
		while (fOffset < fEnd) {
			char current = fDocument.getChar(fOffset++);

			switch (current) {

			case '"':
			case '\'':

				if (fSkipStrings) {
					gotoStringEnd(current);
					continue;
				}

				return current;
			}

			return current;
		}

		return EOF;
	}


	private void gotoStringStart(char delimiter) throws BadLocationException {
		while (0 < fOffset) {
			char current = fDocument.getChar(fOffset);
			if (current == delimiter) {
				if (!(0 <= fOffset && fDocument.getChar(fOffset - 1) == '\\'))
					return;
			}
			--fOffset;
		}
	}

	private int readBackwards() throws BadLocationException {

		while (0 < fOffset) {
			--fOffset;

			char current = fDocument.getChar(fOffset);
			switch (current) {

			case '"':
			case '\'':

				if (fSkipStrings) {
					--fOffset;
					gotoStringStart(current);
					continue;
				}

				return current;
			}

			return current;
		}

		return EOF;
	}
}
