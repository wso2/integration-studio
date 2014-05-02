/*
 * Copyright (c) 2010 JBoss, Inc. and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.bpel.model.resource;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.xml.sax.SAXParseException;

/*
 * This class represents a SAX parser diagnostic. These are added to the EMF resource.
 *
 * @see Bugzilla 324165
 * @author Bob Brodt
 * @date Aug 13, 2010
 */
public class SAXParseDiagnostic implements Diagnostic
{
	protected SAXParseException exception;
	protected int severity;
	
	public static final int WARNING = 1;
	public static final int ERROR = 2;
	public static final int FATAL_ERROR = 3;
	
	SAXParseDiagnostic(SAXParseException exception, int severity)
	{
		this.exception = exception;
		this.severity = severity;
	}

	public int getColumn() {
		return exception.getColumnNumber();
	}

	public int getLine() {
		return exception.getLineNumber();
	}

	public String getLocation() {
		return exception.getPublicId();
	}

	public String getMessage() {
		return exception.getLocalizedMessage();
	}
	
	public int getSeverity() {
		return severity;
	}
}