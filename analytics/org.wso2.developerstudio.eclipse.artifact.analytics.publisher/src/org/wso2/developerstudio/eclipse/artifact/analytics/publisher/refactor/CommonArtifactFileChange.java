/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.artifact.analytics.publisher.refactor;

import org.eclipse.core.resources.IFile;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.wso2.developerstudio.eclipse.artifact.analytics.publisher.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CommonArtifactFileChange extends TextFileChange {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IFile artifactFile;
	private String newName;
	private String originalName;

	public CommonArtifactFileChange(String name, IFile file, String originalName, String newName) {
		super(name, file);
		artifactFile = file;
		this.originalName = originalName;
		this.newName = newName;
		addTextEdits();
	}

	private void addTextEdits() {
		MultiTextEdit multiTextEdit = new MultiTextEdit();
		setEdit(multiTextEdit);
		setSaveMode(FORCE_SAVE);

		try {
			if (artifactFile.exists()) {
				identifyReplaces();
			}
		} catch (IOException e) {
			log.error("Encoutered an IO Error trying to manipulate the file", e);
		}
	}

	private void identifyReplaces() throws IOException {
		int fullIndex = 0;
		FileReader fileReader = new FileReader(artifactFile.getLocation().toFile());
		BufferedReader reader = new BufferedReader(fileReader);

		String line = reader.readLine();
		
		String regJson = "\"(name)\"\\s*?:\\s*\"("+originalName+")\"";
		String regSiddhiql = "\\@(Plan:name)\\('("+originalName+")'\\)";
		String regXml = "(name)\\s*?=\\s*?\"("+originalName+")\"";
		
		Pattern patternJson = Pattern.compile(regJson);
		Pattern patternSiddhiql = Pattern.compile(regSiddhiql);
		Pattern patternXml = Pattern.compile(regXml);
		
		while (line != null) {

			Matcher matcherJson = patternJson.matcher(line);
			Matcher matcherSiddhiql = patternSiddhiql.matcher(line);
			Matcher matcherXml = patternXml.matcher(line);	
			
			if(matcherJson.find())
			{
				int case1LineIndex = matcherJson.start(2);
				addEdit(new ReplaceEdit(fullIndex + case1LineIndex, originalName.length(),
				                        newName));
			}else if(matcherSiddhiql.find()){
				int case1LineIndex = matcherSiddhiql.start(2);
				addEdit(new ReplaceEdit(fullIndex + case1LineIndex, originalName.length(),
				                        newName));
			}else if(matcherXml.find()){
				int case1LineIndex = matcherXml.start(2);
				addEdit(new ReplaceEdit(fullIndex + case1LineIndex, originalName.length(),
				                        newName));
			}

			fullIndex += charsOnTheLine(line);
			line = reader.readLine();
		}
		fileReader.close();
		reader.close();
	}

	private int charsOnTheLine(String line) {
		// Here we need to add one to represent the newline character
		return line.length() + 1;
	}
}
