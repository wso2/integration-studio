/******************************************************************************* 
 * Copyright (c) 2010, 2012 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/

package org.eclipse.bpel.ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.xerces.parsers.SAXParser;
import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLAttributes;
import org.apache.xerces.xni.XNIException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.ITextContentDescriber;
import org.xml.sax.InputSource;

/**
 * @author Bob Brodt
 * 
 * added for https://jira.jboss.org/browse/JBIDE-6006
 */
public class BPELContentDescriber implements ITextContentDescriber {

	private static final String WSBPEL_2_NAMESPACE = "http://docs.oasis-open.org/wsbpel/2.0/process/executable"; //$NON-NLS-1$
	// https://issues.jboss.org/browse/JBIDE-8068
	private static final String WSBPEL_2_ABSTRACT_NAMESPACE = "http://docs.oasis-open.org/wsbpel/2.0/process/abstract"; //$NON-NLS-1$
	private static final String ROOT_ELEMENT = "process"; //$NON-NLS-1$

	private RootElementParser parser;

	public BPELContentDescriber() {
	}

	public int describe(Reader contents, IContentDescription description) throws IOException {
		return doDescribe(contents) == null ? INVALID : VALID;
	}

	public int describe(InputStream contents, IContentDescription description) throws IOException {
		return describe(new InputStreamReader(contents), description);
	}

	private synchronized String doDescribe(Reader contents) throws IOException {
		try {
			InputSource source = new InputSource(contents);
			parser = new RootElementParser();
			parser.parse(source);
		} catch (AcceptedException e) {
			return e.acceptedRootElement;
		} catch (RejectedException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
		finally {
			parser = null;
		}

		return null;
	}

	public QualifiedName[] getSupportedOptions() {
		return null;
	}

	private class RootElementParser extends SAXParser {
		public void startElement(QName qName, XMLAttributes attributes, Augmentations augmentations) throws XNIException {

			super.startElement(qName, attributes, augmentations);

			if (ROOT_ELEMENT.equals(qName.localpart)) {
				String namespace = fNamespaceContext.getURI(qName.prefix);
				// https://issues.jboss.org/browse/JBIDE-8068
				if (WSBPEL_2_NAMESPACE.equals(namespace) || WSBPEL_2_ABSTRACT_NAMESPACE.equals(namespace))
					throw new AcceptedException(qName.localpart);
				else
					throw new RejectedException();
			} else
				throw new RejectedException();
		}
	}

	private class AcceptedException extends RuntimeException {
		public String acceptedRootElement;

		public AcceptedException(String acceptedRootElement) {
			this.acceptedRootElement = acceptedRootElement;
		}

		private static final long serialVersionUID = 1L;
	}

	private class RejectedException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
