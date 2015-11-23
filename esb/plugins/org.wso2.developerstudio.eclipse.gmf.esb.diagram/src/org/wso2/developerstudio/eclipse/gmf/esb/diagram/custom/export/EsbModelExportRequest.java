/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.export;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;

/**
 * Request for exporting a ESB visual model.
 */
public class EsbModelExportRequest extends AbstractEditCommandRequest {
	/**
	 * Creates a new {@link EsbModelExportRequest} instance.
	 * 
	 * @param editingDomain {@link TransactionalEditingDomain} instance.
	 */
	public EsbModelExportRequest(TransactionalEditingDomain editingDomain) {
		super(editingDomain);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Object getEditHelperContext() {
		return null;
	}
}
