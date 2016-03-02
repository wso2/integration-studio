/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.persistence;

public class TransformerException extends Exception {

	private static final long serialVersionUID = 2788705051694062245L;

	public TransformerException() {
		super();
	}

	/**
	 * @param message
	 */
	public TransformerException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TransformerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public TransformerException(Throwable cause) {
		super(cause);
	}
}
