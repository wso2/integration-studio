/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.utils;

public class UnrecogizedArtifactTypeException extends Exception {

	/**
	 * This class used by editors when opening the artifact
	 */
	private static final long serialVersionUID = 1L;

	public UnrecogizedArtifactTypeException() {

	}

	public UnrecogizedArtifactTypeException(String message) {
		super(message);

	}

	public UnrecogizedArtifactTypeException(Throwable cause) {
		super(cause);

	}

	public UnrecogizedArtifactTypeException(String message, Throwable cause) {
		super(message, cause);

	}

}
