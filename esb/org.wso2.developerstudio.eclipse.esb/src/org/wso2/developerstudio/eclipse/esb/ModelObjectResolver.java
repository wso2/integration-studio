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
package org.wso2.developerstudio.eclipse.esb;

import org.w3c.dom.Element;

/**
 * A utility interface for resolving model objects.
 */
public interface ModelObjectResolver {
	/**
	 * Resoves the {@link ModelObject} that corresponds to the specified
	 * {@link Element} and parent {@link ModelObject}.
	 * 
	 * @param elem
	 *            {@link Element} which holds the definition of a
	 *            {@link ModelObject}.
	 * @param parent
	 *            parent {@link ModelObject} under which this
	 *            {@link ModelObject} is to be nested.
	 * @return un-initialized {@link ModelObject} instance corresponding to
	 *         the specified parameters.
	 */
	public ModelObject resolve(Element elem, ModelObject parent);
}
