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


import org.xml.sax.SAXException;

import org.apache.xerces.parsers.DOMParser;
import org.apache.xerces.xni.*;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 20, 2007
 * 
 * This is per //
 * http://src.opensolaris.org/source/xref/sfw/usr/src/cmd/tomcat/xerces-2_8_0/samples/dom/DOMAddLines.java
 * 
 */
public class LocationCapturingDOMParser extends DOMParser {

	protected XMLLocator mLocator;

	protected int fLineNo = 0;

	protected int fColumnNo = 0;

	protected int fOffset = 0;

	/**
	 * 
	 */
	
	@SuppressWarnings({ "nls", "boxing" })
	public LocationCapturingDOMParser() {

		try {
			// setProperty("http://xml.org/sax/features/namespaces",true);
			setFeature(
					"http://apache.org/xml/features/dom/defer-node-expansion",
					false);
			setFeature("http://apache.org/xml/features/xinclude", false);
		} catch (SAXException sax) {
			// 
		}
	}


	void lastSource() {

		fLineNo = mLocator.getLineNumber();
		fColumnNo = mLocator.getColumnNumber();
		fOffset = mLocator.getCharacterOffset();

		// p(" - lastSource.mark : r={0},c={1},o={2}",fLineNo,
		// fColumnNo,fOffset );
	}

	/**
	 * @see org.apache.xerces.parsers.AbstractDOMParser#startDocument(org.apache.xerces.xni.XMLLocator,
	 *      java.lang.String, org.apache.xerces.xni.NamespaceContext,
	 *      org.apache.xerces.xni.Augmentations)
	 */
	@Override
	public void startDocument(XMLLocator arg0, String arg1,
			NamespaceContext arg2, Augmentations arg3) throws XNIException {
		mLocator = arg0;
		super.startDocument(arg0, arg1, arg2, arg3);
		lastSource();
	}

	/**
	 * @see org.apache.xerces.parsers.AbstractDOMParser#characters(org.apache.xerces.xni.XMLString,
	 *      org.apache.xerces.xni.Augmentations)
	 */
	@Override
	public void characters(XMLString arg0, Augmentations arg1)
			throws XNIException {
		super.characters(arg0, arg1);
		lastSource();
	}

	/**
	 * @see org.apache.xerces.parsers.AbstractDOMParser#comment(org.apache.xerces.xni.XMLString,
	 *      org.apache.xerces.xni.Augmentations)
	 */
	@Override
	public void comment(XMLString arg0, Augmentations arg1) throws XNIException {
		super.comment(arg0, arg1);
		lastSource();

	}

	/**
	 * 
	 * @see org.apache.xerces.parsers.AbstractDOMParser#textDecl(java.lang.String,
	 *      java.lang.String, org.apache.xerces.xni.Augmentations)
	 */
	@Override
	public void textDecl(String arg0, String arg1, Augmentations arg2)
			throws XNIException {
		super.textDecl(arg0, arg1, arg2);
		lastSource();
	}

	/**
	 * @see org.apache.xerces.parsers.AbstractDOMParser#startElement(org.apache.xerces.xni.QName,
	 *      org.apache.xerces.xni.XMLAttributes,
	 *      org.apache.xerces.xni.Augmentations)
	 */
	@SuppressWarnings( { "nls", "boxing" })
	@Override
	public void startElement(QName arg0,
			XMLAttributes arg1, Augmentations arg2) throws XNIException {
		super.startElement(arg0, arg1, arg2);
		// p("startElement: {0} {1}", arg0,arg1);

		if (fCurrentNode != null) {
			// p(" - start.mark:
			// r={0},c={1},o={2}",fLineNo,fColumnNo,fOffset+1);
			// start of element
			fCurrentNode.setUserData("location.line", fLineNo, null);
			fCurrentNode.setUserData("location.column", fColumnNo, null);
			fCurrentNode.setUserData("location.charStart", fOffset + 1, null);
			fCurrentNode.setUserData("location.charEnd", fOffset
					+ arg0.rawname.length() + 1, null);

			// p(" - end.mark: r={0},c={1},o={2}",mLocator.getLineNumber(),
			// mLocator.getColumnNumber(),mLocator.getCharacterOffset() );
			// end of element
			fCurrentNode.setUserData("location2.line",
					mLocator.getLineNumber(), null);
			fCurrentNode.setUserData("location2.column", mLocator
					.getColumnNumber(), null);
			fCurrentNode.setUserData("location2.charStart", mLocator
					.getCharacterOffset(), null);
			fCurrentNode.setUserData("location2.charEnd", mLocator
					.getCharacterOffset(), null);
		}
		lastSource();
	}

	/**
	 * @see org.apache.xerces.parsers.AbstractDOMParser#startCDATA(org.apache.xerces.xni.Augmentations)
	 */
	@Override
	public void startCDATA(Augmentations aug) {
		super.startCDATA(aug);
		lastSource();

	}

	/**
	 * @see org.apache.xerces.parsers.AbstractDOMParser#endCDATA(org.apache.xerces.xni.Augmentations)
	 */
	@Override
	public void endCDATA(Augmentations aug) {
		super.endCDATA(aug);
		lastSource();
	}

	/**
	 * @see org.apache.xerces.parsers.AbstractDOMParser#endElement(org.apache.xerces.xni.QName,
	 *      org.apache.xerces.xni.Augmentations)
	 */
	@Override
	public void endElement(QName element,
			Augmentations aug) {
		super.endElement(element, aug);
		// p("endElement: {0}", element);
		lastSource();
	}

}
