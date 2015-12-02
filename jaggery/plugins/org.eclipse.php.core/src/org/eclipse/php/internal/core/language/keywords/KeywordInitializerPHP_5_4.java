/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Zend Technologies
 *******************************************************************************/
package org.eclipse.php.internal.core.language.keywords;

import java.util.Collection;

import org.eclipse.php.internal.core.language.keywords.PHPKeywords.KeywordData;

/**
 * Keywords initializer for PHP 5.3
 */

public class KeywordInitializerPHP_5_4 implements IPHPKeywordsInitializer {

	public void initialize(Collection<KeywordData> list) {
		// super.initialize(list);

		list.add(new KeywordData("and", WHITESPACE_SUFFIX, 1)); //$NON-NLS-1$
		list.add(new KeywordData("Array", PARENTESES_SUFFIX, 1)); //$NON-NLS-1$
		list.add(new KeywordData("break", SEMICOLON_SUFFIX, 1));
		list.add(new KeywordData("case", WHITESPACE_COLON_SUFFIX, 2));
		list.add(new KeywordData("catch", OPEN_BLOCK_SUFFIX, 2));
		list.add(new KeywordData("class", WHITESPACE_SUFFIX, 1)); //$NON-NLS-1$
		list.add(new KeywordData("const", WHITESPACE_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("continue", SEMICOLON_SUFFIX, 1));
		list.add(new KeywordData("Database", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("default", COLON_SUFFIX, 1));
		// list.add(new KeywordData("del", PARENTESES_SUFFIX, 1));
		list.add(new KeywordData("delete", WHITESPACE_SUFFIX, 1));
		list.add(new KeywordData("do", WHITESPACE_SUFFIX, 1));
		list.add(new KeywordData("else", WHITESPACE_SUFFIX, 1));
		list.add(new KeywordData("else if", WHITESPACE_PARENTESES_SUFFIX, 2)); //$NON-NLS-1$
		list.add(new KeywordData("eval", PARENTESES_SUFFIX, 1)); //$NON-NLS-1$
		list.add(new KeywordData("false", EMPTY_SUFFIX, 0));
		list.add(new KeywordData("finally", OPEN_BLOCK_SUFFIX, 2));
		list.add(new KeywordData("for", WHITESPACE_PARENTESES_SUFFIX, 2));
		list.add(new KeywordData("function", WHITESPACE_PARENTESES_SUFFIX, 2));
		// list.add(new KeywordData("get", PARENTESES_SUFFIX, 1));
		// list.add(new KeywordData("getContent", PARENTESES_SUFFIX, 1));
		// list.add(new KeywordData("getContentType", PARENTESES_SUFFIX, 1));
		// list.add(new KeywordData("getMethod", PARENTESES_SUFFIX, 1));
		// list.add(new KeywordData("getProtocol", PARENTESES_SUFFIX, 1));
		// list.add(new KeywordData("getQueryString", PARENTESES_SUFFIX, 1));
		list.add(new KeywordData("if", WHITESPACE_PARENTESES_SUFFIX, 2));
		list.add(new KeywordData("in", WHITESPACE_SUFFIX, 1));
		list.add(new KeywordData("include", WHITESPACE_PARENTESES_SUFFIX, 2));
		list.add(new KeywordData("Infinity", EMPTY_SUFFIX, 0));
		list.add(new KeywordData("instanceof", WHITESPACE_SUFFIX, 1));
		list.add(new KeywordData("let", WHITESPACE_SUFFIX, 1));
		list.add(new KeywordData("NaN", EMPTY_SUFFIX, 0));
		list.add(new KeywordData("new", WHITESPACE_SUFFIX, 1));
		list.add(new KeywordData("null", EMPTY_SUFFIX, 0));
		list.add(new KeywordData("open", PARENTESES_SUFFIX, 1));
		list.add(new KeywordData("or", WHITESPACE_SUFFIX, 1)); //$NON-NLS-1$
		// list.add(new KeywordData("parse", PARENTESES_SUFFIX, 1));
		// list.add(new KeywordData("post", PARENTESES_SUFFIX, 1));
		list.add(new KeywordData("print", PARENTESES_SUFFIX, 1));
		// list.add(new KeywordData("put", PARENTESES_SUFFIX, 1));
		// list.add(new KeywordData("request", EMPTY_SUFFIX, 0));
		list.add(new KeywordData("require", WHITESPACE_PARENTESES_SUFFIX, 2));
		list.add(new KeywordData("return", WHITESPACE_SUFFIX, 1));
		// list.add(new KeywordData("stringify", PARENTESES_SUFFIX, 1));
		list.add(new KeywordData("switch", WHITESPACE_PARENTESES_SUFFIX, 2));
		list.add(new KeywordData("throw", WHITESPACE_SUFFIX, 1));
		list.add(new KeywordData("true", EMPTY_SUFFIX, 0));
		list.add(new KeywordData("try", OPEN_BLOCK_SUFFIX, 2));
		list.add(new KeywordData("typeof", WHITESPACE_SUFFIX, 1));
		list.add(new KeywordData("undefined", EMPTY_SUFFIX, 0));
		list.add(new KeywordData("var", WHITESPACE_SUFFIX, 1));
		list.add(new KeywordData("while", WHITESPACE_PARENTESES_SUFFIX, 2));
		list.add(new KeywordData("with", WHITESPACE_SUFFIX, 1));
		list.add(new KeywordData("WSRequest", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("Log", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("WSStub", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("XML", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("XMLHTTPRequest", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("URIMatcher", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("File", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("Feed", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("Entry", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("Database", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("MetadataStore", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("Sender", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));
		list.add(new KeywordData("OAuthProvider", PARENTESES_SUFFIX, 1,
				PHPKeywords.CLASS_BODY));

	}

	public void initializeSpecific(Collection<KeywordData> list) {
	}
}
