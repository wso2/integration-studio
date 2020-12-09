/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.ds.data;

import org.apache.xerces.impl.xs.XMLSchemaLoader;
import org.apache.xerces.impl.xs.XSAttributeUseImpl;
import org.apache.xerces.impl.xs.XSComplexTypeDecl;
import org.apache.xerces.impl.xs.XSElementDecl;
import org.apache.xerces.impl.xs.XSModelGroupImpl;
import org.apache.xerces.impl.xs.XSParticleDecl;
import org.apache.xerces.xs.XSConstants;
import org.apache.xerces.xs.XSModel;
import org.apache.xerces.xs.XSNamedMap;
import org.apache.xerces.xs.XSNamespaceItem;
import org.apache.xerces.xs.XSNamespaceItemList;
import org.apache.xerces.xs.XSObjectList;
import org.wso2.developerstudio.eclipse.ds.model.DataserviceAttributeElement;
import org.wso2.developerstudio.eclipse.ds.model.DataserviceTagElement;
import org.wso2.developerstudio.eclipse.ds.util.DataserviceUtils;

public class DataserviceTemplate {
	private static DataserviceTemplate INSTANCE = new DataserviceTemplate();
	private static DataserviceTagElement rootElement;

	private DataserviceTemplate() {
	}

	public static DataserviceTemplate getInstance() {
		return INSTANCE;
	}

	static {
		XMLSchemaLoader xmlSchemaLoader = new XMLSchemaLoader();
		XSModel model =
		                xmlSchemaLoader.loadURI(DataserviceUtils.getDataserviceSchemaPath().toURI()
		                                                        .toString());
		printXS(model.getNamespaceItems(), -1);
	}

	private static void printXS(XSNamespaceItemList objs, int level) {
		for (int i = 0; i < objs.getLength(); i++) {
			XSNamespaceItem item = objs.item(i);
			printXS(item, level + 1);
		}
	}

	private static void printXS(XSNamespaceItem obj, int level) {
		XSNamedMap components = obj.getComponents(XSConstants.ELEMENT_DECLARATION);
		for (int i = 0; i < components.getLength(); i++) {
			XSElementDecl item = (XSElementDecl) components.item(i);
			DataserviceTagElement dataserviceTagElement =
			                                              new DataserviceTagElement(null,
			                                                                        item.getName());
			setRootElement(dataserviceTagElement);
			printXS(getRootElement(), item, level);

		}
	}

	private static void printXS(DataserviceTagElement parentElement, XSElementDecl item, int level) {
		// System.out.print(getSpaces(level)+item.getName());
		if (item.getTypeDefinition() instanceof XSComplexTypeDecl) {
			XSComplexTypeDecl typeDef = (XSComplexTypeDecl) item.getTypeDefinition();
			XSObjectList attributeUses = typeDef.getAttributeUses();
			if (attributeUses.getLength() > 0) {
				// System.out.print(" [");
				for (int j = 0; j < attributeUses.getLength(); j++) {
					XSAttributeUseImpl attr = (XSAttributeUseImpl) attributeUses.item(j);
					String name = attr.getAttrDeclaration().getName();
					parentElement.getAttributes()
					             .add(new DataserviceAttributeElement(name, attr.getRequired()));
					// if (j==0){
					// System.out.print(name);
					// }else{
					// System.out.print(", "+name);
					// }
				}
				// System.out.println("]");
			} else {
				// System.out.println();
			}
			if (typeDef.getParticle() != null &&
			    typeDef.getParticle().getTerm() instanceof XSModelGroupImpl) {
				// parentElement.setMaxOccurances(typeDef.getParticle().getMaxOccurs());
				// parentElement.setMinOccurances(typeDef.getParticle().getMinOccurs());
				XSModelGroupImpl grp = (XSModelGroupImpl) typeDef.getParticle().getTerm();
				for (int j = 0; j < grp.getParticles().getLength(); j++) {
					if (grp.getParticles().item(j) instanceof XSParticleDecl) {
						XSParticleDecl part = (XSParticleDecl) grp.getParticles().item(j);
						if (part.fValue instanceof XSElementDecl) {
							DataserviceTagElement docElement =
							                                   new DataserviceTagElement(
							                                                             parentElement,
							                                                             ((XSElementDecl) part.fValue).getName());
							parentElement.getSubElements().add(docElement);
							docElement.setMaxOccurances(part.getMaxOccurs());
							docElement.setMinOccurances(part.getMinOccurs());
							printXS(docElement, (XSElementDecl) part.fValue, level + 1);
						}
					}

				}
			}
		}
	}

	public static void setRootElement(DataserviceTagElement rootElement) {
		DataserviceTemplate.rootElement = rootElement;
	}

	public static DataserviceTagElement getRootElement() {
		return rootElement;
	}
}
