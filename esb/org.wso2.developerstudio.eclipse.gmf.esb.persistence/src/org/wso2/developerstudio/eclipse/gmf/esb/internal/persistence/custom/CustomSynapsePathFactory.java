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
import org.wso2.developerstudio.eclipse.gmf.esb.MediaType;

/**
 * This class will create SynapsePath instance based on the
 * given expression.
 *
 */
public class CustomSynapsePathFactory {

	private static final Log log = LogFactory.getLog(CustomSynapsePathFactory.class);

	/**
	 * In Payload factory ESB supports JSON-PAth without the json-eval prefix in
	 * the JSON path expression, the XPATH and the JSON path should be
	 * differentiated by using the evaluator media type set in the payload
	 * factory expression, to support this the getSynapsePath method is
	 * overloaded to evaluate the media type in case of Payload Factory
	 * Mediator.If the user has provided the expression with json-eval prefix we
	 * ignore the evaluator and process it as a JSON path
	 * 
	 * @param expression
	 *            JSON, XML expression
	 * @param evaluator
	 *            media type of the expression
	 * @return the JSON path or the XPATH
	 * @throws JaxenException
	 *             Exception thrown
	 */
	public static SynapsePath getSynapsePath(String expression, MediaType evaluator)
	                                                                                throws JaxenException {
		SynapsePath path = null;
		if (StringUtils.isNotBlank(expression)) {
			if (expression.startsWith("json-eval(")) {
				path = getSynapsePath(expression);
			} else {
				if (evaluator != null) {
					if (evaluator == MediaType.JSON) {
						path = new SynapseJsonPath(expression);
					} else if (evaluator == MediaType.XML) {
						path = new SynapseXPath(expression);
					} else {
						handleException("Invalid Evalautor Type, Evaluator Type should be XML or JSON");
					}
				}
			}
		} else {
			handleException("Invalid path expression");
		}
		return path;
	}

	/**
	 * This getSynapsePath supports log,switch, property and filter mediators
	 * which supports JSON paths when the expression is pre-fixed with json-eval
	 * string
	 * 
	 * @param expression
	 *            JSON or XPATH expressions
	 * @return the JSON path or the XPATH
	 * @throws JaxenException
	 *             Exceptions thrown
	 */
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
