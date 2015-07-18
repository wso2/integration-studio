/*
 * Copyright 2009-2015 WSO2, Inc. (http://wso2.com)
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

import java.util.List;

import org.apache.synapse.config.SynapseConfiguration;
import org.apache.synapse.core.axis2.ProxyService;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;

/**
 * Defines the interface used to transform a ESB visual model object into the
 * corresponding ESB server configuration element(s).
 */
public interface EsbNodeTransformer {
	
	/**
	 * Transforms the given subject node into corresponding ESB configuration
	 * element (s).
	 * 
	 * @param synapseConfiguration
	 *            {@link SynapseConfiguration} object which is being built.
	 * @param rootService
	 *            {@link ProxyService} to which this node corresponds to.
	 * @param parentMediator
	 *            parent mediator under which this node is to be adopted.
	 * @param subject
	 *            subject visual model node.
	 * @throws Exception
	 *             if an error occurs during the transformation.
	 */
	void transform(TransformationInfo information, EsbNode subject) throws TransformerException;
	void createSynapseObject(TransformationInfo info,EObject subject,List<Endpoint> endPoints) throws TransformerException;
	void transformWithinSequence(TransformationInfo information, EsbNode subject,SequenceMediator sequence) throws TransformerException;
}
