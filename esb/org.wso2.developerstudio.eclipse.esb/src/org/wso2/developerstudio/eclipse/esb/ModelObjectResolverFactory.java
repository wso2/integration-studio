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

/**
 * A factory interface which creates {@link ModelObjectResolver} instances
 * corresponding to dom element local names.
 */
public interface ModelObjectResolverFactory {
	/**
	 * Attempts to locate a {@link ModelObjectResolver} instance that can
	 * resolve the model object corresponding to the element bearing the given
	 * local name.
	 * 
	 * @param localName local name of the DOM element.
	 * @return {@link ModelObjectResolver} corresponding to the specified DOM element.
	 */
	ModelObjectResolver getResolver(String localName);
}
