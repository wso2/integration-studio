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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.TypeRelation;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.NamedEntityDescriptor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.NamedEntityDescriptor.NamedEntityType;

/**
 * Utility  class for RegistryKeyProperty
 * 
 */
public class RegistryKeyPropertyUtil {

	/**
	 * Utility method for querying current named local entities that can be the
	 * target of registry key attributes.
	 * 
	 * @param obj {@link EObject} which is part of the current resource being edited.
	 * @return a list of local named entities.
	 */
	
	public static List<NamedEntityDescriptor> findLocalNamedEntities(Object obj) {
		List<NamedEntityDescriptor> result = new ArrayList<NamedEntityDescriptor>();
		if (obj instanceof EObject) {
			EObject rootObj = EcoreUtil.getRootContainer((EObject) obj);
			
			// Condition for filtering sequences.
			EObjectCondition isSequence = new EObjectTypeRelationCondition(EsbPackage.eINSTANCE.getMediatorSequence(),
					TypeRelation.SAMETYPE_LITERAL);
			
			// Condition for filtering endpoints.
			EObjectCondition isEndpoint = new EObjectTypeRelationCondition(EsbPackage.eINSTANCE.getEndPoint(),
					TypeRelation.SUBTYPE_LITERAL);
			
			// Condition for filtering proxy services.
			EObjectCondition isProxyService = new EObjectTypeRelationCondition(EsbPackage.eINSTANCE.getProxyService(),
					TypeRelation.SAMETYPE_LITERAL);
			
			// Condition for local entries.
			EObjectCondition isLocalEntry = new EObjectTypeRelationCondition(EsbPackage.eINSTANCE.getLocalEntry(),
					TypeRelation.SAMETYPE_LITERAL);
			
			// Construct the final query.
			SELECT stmt = new SELECT(new FROM(rootObj), new WHERE(isSequence.OR(isEndpoint).OR(isProxyService).OR(
					isLocalEntry)));
			
			// Execute.
			IQueryResult queryResult = stmt.execute();
			
			// Extract named entity descriptors.
			for (EObject object : queryResult.getEObjects()) {
				switch (object.eClass().getClassifierID()) {
					case EsbPackage.MEDIATOR_SEQUENCE:
						MediatorSequence sequence = (MediatorSequence) object;
						if (!sequence.isAnonymous()) {
							result.add(new NamedEntityDescriptor(sequence.getSequenceName(), NamedEntityType.SEQUENCE));
						}
						break;
					case EsbPackage.DEFAULT_END_POINT:
					case EsbPackage.ADDRESS_END_POINT:
					case EsbPackage.WSDL_END_POINT:
					case EsbPackage.LOAD_BALANCE_END_POINT:
					case EsbPackage.FAILOVER_END_POINT:
					//case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT:
						EndPoint endpoint = (EndPoint) object;
						if (!endpoint.isAnonymous()) {
							result.add(new NamedEntityDescriptor(endpoint.getEndPointName(), NamedEntityType.ENDPOINT));
						}
						break;
					case EsbPackage.PROXY_SERVICE:
						ProxyService proxyService = (ProxyService) object;
						result.add(new NamedEntityDescriptor(proxyService.getName(), NamedEntityType.PROXY_SERVICE));
						break;
					case EsbPackage.LOCAL_ENTRY:
						LocalEntry localEntry = (LocalEntry) object;
						result.add(new NamedEntityDescriptor(localEntry.getEntryName(), NamedEntityType.LOCAL_ENTRY));
						break;
					default:
						// TODO: Log the unexpected result.
				}
			}
		}
		
		return result;
	}
}
