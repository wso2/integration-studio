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

package org.eclipse.bpel.xpath10.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.RecognitionException;

import org.antlr.runtime.CommonTokenStream;
import org.eclipse.bpel.xpath10.Expr;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 23, 2008
 *
 */
public class XPath10Factory {

	/**
	 * @param source
	 * @return a brand new shiny xpath expr [ whatever it may be ]
	 * @throws XPath10Exception
	 */
	static public Expr create (String source) throws XPath10Exception
	{
		XPath10Parser parser = createParser(source);
		try {
			return parser.expr().result;
		} catch (RecognitionException re) {
			throw new XPath10Exception(re.getLocalizedMessage(),re.getCause(),re.index);
		} catch (XPath10Exception ex) {
			throw ex;
		} catch (Throwable t) {
			throw new XPath10Exception(t.getLocalizedMessage(),t.getCause(),-1);
		}
	}
	

    static protected XPath10Parser createParser(String source) {                
        return new XPath10Parser(new CommonTokenStream(createLexer(source)));        
    }

    static XPath10Lexer createLexer(String testString)  {
        return new XPath10Lexer(new ANTLRStringStream(testString));        
    }
}
