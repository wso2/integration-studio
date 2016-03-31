/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.general.project.refactor;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;

import java.io.File;
import java.io.IOException;

public class RegistryResourceEsbFileChange extends TextFileChange {
	private static final String ESB_EXTENSION = ".esb";
	private static final String ESB_DIAGRAM_EXTENSION = ".esb_diagram";
	private IFile esbFile;
	private String match;
	private String replace;

	public RegistryResourceEsbFileChange(String name, IFile file, String originalName,
	                                     String newName) {
		super(name, file);
		esbFile = file;
		if (esbFile.getName().endsWith(ESB_EXTENSION)) {
			match = originalName;
			replace = newName;
		} else if(esbFile.getName().endsWith(ESB_DIAGRAM_EXTENSION)){
			match = "_" + originalName;
			replace = "_" + newName;
		}
		addTextEdits();
	}

	private void addTextEdits() {
		MultiTextEdit multiTextEdit = new MultiTextEdit();
		setEdit(multiTextEdit);
		setSaveMode(FORCE_SAVE);

		try {
			if (esbFile.exists()) {
				identifyReplaces();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void identifyReplaces() throws IOException {
		String fileContent =
		                     FileUtils.readFileToString(new File(esbFile.getRawLocation()
		                                                                .toString()));
		int i = 0;
		while ((i = (fileContent.indexOf(match, i) + 1)) > 0) {
			addEdit(new ReplaceEdit(i - 1, match.length(), replace));
		}
	}
}
