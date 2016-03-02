/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

import java.util.Map;

import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.MediatorSerializer;
import org.apache.synapse.config.xml.MediatorSerializerFinder;

public class MediatorSerializerRegister {
	static MediatorSerializerFinder mediatorSerializerFinder = null;

	static {
		mediatorSerializerFinder = MediatorSerializerFinder.getInstance();
	}
	
	/* custom mediator serializers */
	@SuppressWarnings("rawtypes")
	private static final Class[] mediatorSerializers = { 
		ClassMediatorExtSerializer.class,
		POJOCommandMediatorExtSerializer.class,
		BuilderMediatorExtSerializer.class,
		RuleMediatorExtSerialize.class,
		EJBMediatorExtSerializer.class,
		BeanMediatorExtSerializer.class,
		CloudConnectorOperationExtSerializer.class,
		EntitlementMediatorExtSerializer.class
		};

	public static synchronized void registerSerializers() {
		Map<String, MediatorSerializer> serializerMap = mediatorSerializerFinder.getSerializerMap();
		for (@SuppressWarnings("rawtypes") Class c : mediatorSerializers) {
			try {
				MediatorSerializer ser = (MediatorSerializer) c.newInstance();
				String mediatorClassName = ser.getMediatorClassName();
				if (!serializerMap.containsKey(mediatorClassName)) {
					serializerMap.put(ser.getMediatorClassName(), ser);
				}
			} catch (Exception e) {
				throw new SynapseException("Error instantiating " + c.getName(), e);
			}
		}
	}

}
