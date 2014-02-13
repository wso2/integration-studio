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
package org.wso2.developerstudio.eclipse.esb.persistance;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * A custom resource factory class.
 */
public class EsbResourceFactoryImpl extends ResourceFactoryImpl {		
	/**
	 * Creates a new {@link EsbResourceFactoryImpl} instance.
	 */
	public EsbResourceFactoryImpl() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Resource createResource(URI uri)
	{
		return new EsbResourceImpl(uri);
	}
}