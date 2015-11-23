/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.registry.handler.util;

import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.TextEdit;

public class JavaCodeFormatter {
	
	/**
	 * Format java source code
	 * @param code Code as string
	 * @param javaProject Java project to get format settings
	 * @return formatted code as string
	 */
	@SuppressWarnings("unchecked")
    public static String format(String code, IJavaProject javaProject) {
		String lineSeparator = System.getProperty("line.separator");
		Map<String, String> options= null;
		if (javaProject != null) {
			options = javaProject.getOptions(true);
		} else {
			options = DefaultCodeFormatterConstants.getEclipseDefaultSettings();
			// initialize the compiler settings to be able to format 1.6 code
			options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_6);
			options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_6);
			options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_6);
		}
		int type = CodeFormatter.K_COMPILATION_UNIT;
		int indent =0;
		final CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(options);
		final TextEdit edit = codeFormatter.format(type, code, 0, code.length(),
		                                           indent, lineSeparator);
		if (edit == null) {
			return code;
		} else {
			IDocument document = new Document(code);
			try {
				edit.apply(document);
			} catch (Exception e) {
				return code;
			}
			return document.get();
		}
	}
	/**
	 * Format java source code with default settings for java 1.6 
	 * @param code Code as string
	 * @return formatted code as string
	 */
	public static String format(String code) {
		return format(code,null);
	}
}
