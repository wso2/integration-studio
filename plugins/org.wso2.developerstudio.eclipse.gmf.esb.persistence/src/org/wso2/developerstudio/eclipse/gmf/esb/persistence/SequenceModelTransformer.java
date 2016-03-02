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
package org.wso2.developerstudio.eclipse.gmf.esb.persistence;

import java.io.File;

import org.eclipse.emf.ecore.resource.Resource;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.SequenceModelTranformerImpl;

/**
 * Defines the interface used to export ESB visual model into other persisted
 * models / languages.
 */
public interface SequenceModelTransformer {
	/**
	 * TODO: Use a factory instead.
	 */
	SequenceModelTransformer instance = new SequenceModelTranformerImpl();
	
	/**
	 * Exports the given ESB visual model into specified destination file.
	 * 
	 * @param resource ESB visual model container.
	 * @param destination destination file.
	 * @throws Exception if an error occurs while performing the export operation.
	 */
	void export(Resource resource, File destination) throws Exception;
	
	String designToSource(EsbSequence sequenceModel) throws Exception;
	
	EsbSequence sourceToDesign(String source,EsbSequence esbServer) throws Exception;
}