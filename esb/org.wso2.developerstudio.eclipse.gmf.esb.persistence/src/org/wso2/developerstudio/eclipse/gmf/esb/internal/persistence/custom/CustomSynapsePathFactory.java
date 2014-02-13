/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.util.xpath.SynapseJsonPath;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.jaxen.JaxenException;

/**
 * This class will create SynapsePath instance based on the 
 * given expression.
 *
 */
public class CustomSynapsePathFactory {

	private static final Log log = LogFactory.getLog(CustomSynapsePathFactory.class);

	public static SynapsePath getSynapsePath(String expression) throws JaxenException {

		SynapsePath path = null;
		if (StringUtils.isNotBlank(expression)) {

			if (expression.startsWith("json-eval(")) {
				path = new SynapseJsonPath(expression.substring(10, expression.length() - 1));
			} else {
				path = new SynapseXPath(expression);
			}

		} else {
			handleException("Invalid path expression");
		}

		return path;
	}

	private static void handleException(String message) {
		log.error(message);
	}
}
