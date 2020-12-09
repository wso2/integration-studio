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

package org.wso2.developerstudio.eclipse.ds;

import org.apache.xerces.impl.xs.XSAttributeUseImpl;
import org.apache.xerces.impl.xs.XSComplexTypeDecl;
import org.apache.xerces.impl.xs.XSElementDecl;
import org.apache.xerces.impl.xs.XSModelGroupImpl;
import org.apache.xerces.impl.xs.XSParticleDecl;
import org.apache.xerces.xs.XSConstants;
import org.apache.xerces.xs.XSNamedMap;
import org.apache.xerces.xs.XSNamespaceItem;
import org.apache.xerces.xs.XSNamespaceItemList;
import org.apache.xerces.xs.XSObjectList;
import org.wso2.developerstudio.eclipse.ds.data.DataserviceTemplate;
import org.wso2.developerstudio.eclipse.ds.model.DataserviceAttributeElement;
import org.wso2.developerstudio.eclipse.ds.model.DataserviceTagElement;

public class Test {

	public enum Contants {
		ABC, AABC, CB;
	}

	public static void main(String[] args) {
		// for (Contants c : Contants.values()) {
		// System.out.println(c.toString());
		// }
		// XMLSchemaLoader xmlSchemaLoader = new XMLSchemaLoader();
		// XSModel model =
		// xmlSchemaLoader.loadURI("file:/home/saminda/workspaces/dataservice-workspace/ABC/schema/DataService.xsd");
		// StringList namespaces = model.getNamespaces();
		// System.out.println(namespaces.getLength());
		// for (int i = 0; i < namespaces.getLength(); i++) {
		// System.out.println(namespaces.item(i));
		// }
		// for (short i = 0; i < 256; i++) {
		// XSTypeDefinition typeDefinition = model.getTypeDefinition("data",
		// null);
		// printXS(model.getNamespaceItems(),-1);
		// XSNamedMap components = model.getComponents((short)
		// XSConstants.ELEMENT_DECLARATION);
		// for (int i = 0; i < components.getLength(); i++) {
		// XSObject item = components.item(i);
		// System.out.println(item.getName());
		// }
		// System.out.println(components.getLength());

		// }
		// SchemaGrammar schemaGrammar = SchemaGrammar.BuiltinSchemaGrammar.;
		// XSModelImpl
		// XSModelImpl xsModelImpl = new XSModelImpl();
		DataserviceTagElement rootElement = DataserviceTemplate.getRootElement();
		if (rootElement != null) {
			printDocElement(rootElement, 0);
		}

	}

	private static void printDocElement(DataserviceTagElement ele, int level) {
		System.out.print(getSpaces(level) + ele.getName());
		System.out.print("(" + ele.getMinOccurances() + "," + ele.getMaxOccurances() + ")");
		if (ele.getAttributes().size() > 0) {
			System.out.print(" [");
			String attrList = null;
			for (DataserviceAttributeElement attr : ele.getAttributes()) {
				if (attrList == null) {
					attrList = attr.getName();
				} else {
					attrList += ", " + attr.getName();
				}
				if (attr.isOptional())
					attrList += "(optional)";
			}
			System.out.print(attrList + "]");
		}
		System.out.println();
		for (DataserviceTagElement subElement : ele.getSubElements()) {
			printDocElement(subElement, level + 1);
		}
	}

	private static void printXS(XSNamespaceItemList objs, int level) {
		for (int i = 0; i < objs.getLength(); i++) {
			printXS(objs.item(i), level + 1);
		}
	}

	private static String getSpaces(int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += "  ";
		}
		return result;
	}

	private static void printXS(XSNamespaceItem obj, int level) {
		XSNamedMap components = obj.getComponents(XSConstants.ELEMENT_DECLARATION);
		for (int i = 0; i < components.getLength(); i++) {
			XSElementDecl item = (XSElementDecl) components.item(i);
			printXS(item, level);

		}
	}

	private static void printXS(XSElementDecl item, int level) {
		System.out.print(getSpaces(level) + item.getName());
		if (item.getTypeDefinition() instanceof XSComplexTypeDecl) {
			XSComplexTypeDecl typeDef = (XSComplexTypeDecl) item.getTypeDefinition();
			XSObjectList attributeUses = typeDef.getAttributeUses();
			if (attributeUses.getLength() > 0) {
				System.out.print(" [");
				for (int j = 0; j < attributeUses.getLength(); j++) {
					XSAttributeUseImpl attr = (XSAttributeUseImpl) attributeUses.item(j);
					String name = attr.getAttrDeclaration().getName();
					if (j == 0) {
						System.out.print(name);
					} else {
						System.out.print(", " + name);
					}
				}
				System.out.println("]");
			} else {
				System.out.println();
			}
			if (typeDef.getParticle() != null &&
			    typeDef.getParticle().getTerm() instanceof XSModelGroupImpl) {
				XSModelGroupImpl grp = (XSModelGroupImpl) typeDef.getParticle().getTerm();
				for (int j = 0; j < grp.getParticles().getLength(); j++) {
					if (grp.getParticles().item(j) instanceof XSParticleDecl) {
						XSParticleDecl part = (XSParticleDecl) grp.getParticles().item(j);
						if (part.fValue instanceof XSElementDecl) {
							printXS((XSElementDecl) part.fValue, level + 1);
						}
					}

				}
			}
		}
	}

	// private static void printXS(XSObject obj, int level) {
	// XSNamespaceItem namespaceItem = obj.getNamespaceItem();
	// printXS(namespaceItem, level);
	// }

	// public Grammar loadGrammar(XMLInputSource source)
	// throws IOException, XNIException {
	//
	// // REVISIT: this method should have a namespace parameter specified by
	// // user. In this case we can easily detect if a schema asked to be loaded
	// // is already in the local cache.
	//
	// reset(fLoaderConfig);
	// fSettingsChanged = false;
	// XSDDescription desc = new XSDDescription();
	// desc.fContextType = XSDDescription.CONTEXT_PREPARSE;
	// desc.setBaseSystemId(source.getBaseSystemId());
	// desc.setLiteralSystemId( source.getSystemId());
	// // none of the other fields make sense for preparsing
	// Hashtable locationPairs = new Hashtable();
	// // Process external schema location properties.
	// // We don't call tokenizeSchemaLocationStr here, because we also want
	// // to check whether the values are valid URI.
	// processExternalHints(fExternalSchemas, fExternalNoNSSchema,
	// locationPairs, fErrorReporter);
	// SchemaGrammar grammar = loadSchema(desc, source, locationPairs);
	//
	// if(grammar != null && fGrammarPool != null) {
	// fGrammarPool.cacheGrammars(XMLGrammarDescription.XML_SCHEMA,
	// fGrammarBucket.getGrammars());
	// // NOTE: we only need to verify full checking in case the schema was not
	// provided via JAXP
	// // since full checking already verified for all JAXP schemas
	// if(fIsCheckedFully && fJAXPCache.get(grammar) != grammar) {
	// XSConstraints.fullSchemaChecking(fGrammarBucket, fSubGroupHandler,
	// fCMBuilder, fErrorReporter);
	// }
	// }
	// return grammar;
	// } // loadGrammar(XMLInputSource): Grammar

}
