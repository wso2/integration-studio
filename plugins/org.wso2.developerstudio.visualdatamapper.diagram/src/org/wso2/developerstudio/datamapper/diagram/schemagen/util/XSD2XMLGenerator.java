/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.datamapper.diagram.schemagen.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.wst.xml.core.internal.contentmodel.CMAttributeDeclaration;
import org.eclipse.wst.xml.core.internal.contentmodel.CMContent;
import org.eclipse.wst.xml.core.internal.contentmodel.CMDataType;
import org.eclipse.wst.xml.core.internal.contentmodel.CMDocument;
import org.eclipse.wst.xml.core.internal.contentmodel.CMElementDeclaration;
import org.eclipse.wst.xml.core.internal.contentmodel.CMGroup;
import org.eclipse.wst.xml.core.internal.contentmodel.CMNamedNodeMap;
import org.eclipse.wst.xml.core.internal.contentmodel.CMNode;
import org.eclipse.wst.xml.core.internal.contentmodel.CMNodeList;
import org.eclipse.wst.xml.core.internal.contentmodel.ContentModelManager;
import org.eclipse.wst.xml.core.internal.contentmodel.basic.CMElementDeclarationImpl;
import org.eclipse.wst.xml.core.internal.contentmodel.basic.CMNamedNodeMapImpl;
import org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilder;
import org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl;
import org.eclipse.wst.xml.core.internal.contentmodel.util.DOMNamespaceInfoManager;
import org.eclipse.wst.xml.core.internal.contentmodel.util.DOMWriter;
import org.eclipse.wst.xml.core.internal.contentmodel.util.NamespaceInfo;
import org.eclipse.wst.xml.ui.internal.wizards.NewXMLGenerator;
import org.eclipse.wst.xsd.contentmodel.internal.XSDImpl.XSDAttributeUseAdapter;
import org.eclipse.wst.xsd.contentmodel.internal.XSDImpl.XSDElementDeclarationAdapter;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDAttributeUse;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDEnumerationFacet;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.impl.XSDElementDeclarationImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * This extends the internal NewXMLGenerator and fixes some issues with <choice> elements
 *
 * @see https://jira.jboss.org/browse/JBIDE-6748, https://jira.jboss.org/browse/JBIDE-7351
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
 * @author Bob Brodt
 * @date Oct 29, 2010
 */
@SuppressWarnings("restriction")
public class XSD2XMLGenerator extends NewXMLGenerator {
	
	// this mess is an attempt to insulate ourselves from changes in the DOMCOntentBuilder API
	public static final int BUILD_OPTIONAL_ATTRIBUTES = 1;
	public static final int BUILD_OPTIONAL_ELEMENTS = 1 << 1;
	public static final int BUILD_FIRST_CHOICE = 1 << 2;
	public static final int BUILD_TEXT_NODES = 1 << 3;
	public static final int BUILD_FIRST_SUBSTITUTION = 1 << 4;
	public static final int BUILD_STRUCTURE_ONLY = 1 << 5;
	
	public static final int BUILD_ONLY_REQUIRED_CONTENT =
		BUILD_FIRST_CHOICE
		| BUILD_TEXT_NODES;
	public static final int BUILD_ALL_CONTENT =
		BUILD_OPTIONAL_ATTRIBUTES
		| BUILD_OPTIONAL_ELEMENTS
		| BUILD_FIRST_CHOICE
		| BUILD_TEXT_NODES;

	MyDOMContentBuilderImpl contentBuilder = null;
	protected String queryPath[] = new String[0];
	protected int myBuildPolicy = BUILD_ONLY_REQUIRED_CONTENT;
	protected String xsdURI = null;
	
	/**
	 * @param xsdURI
	 * @param rootElementName
	 */
	public XSD2XMLGenerator(String xsdURI, String rootName) {
		setRootElementName(rootName);
		this.xsdURI = xsdURI;
	}
	

	/**
	 * Default constructor requires a call to setRoot() which will determine
	 * the root element name and XSD uri
	 */
	public XSD2XMLGenerator() {
		super();
	}

	/**
	 * @param path
	 */
	public void setQueryPath(String path)
	{
		if (path!=null && path.length()>0) {
			this.queryPath = path.split("/");
			if (this.queryPath!=null && this.queryPath.length>0) {
				for (int i=0; i<this.queryPath.length; ++i) {
					this.queryPath[i] = this.queryPath[i].replaceFirst(".*:", "");
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.wst.xml.ui.internal.wizards.NewXMLGenerator#setBuildPolicy(int)
	 */
	@Override
	public void setBuildPolicy(int buildPolicy) {
		this.myBuildPolicy = buildPolicy;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String createXML(CMDocument cmDocument) throws Exception {
		
		
		setCMDocument(cmDocument);
		createNamespaceInfoList();

		// create the xml model
		CMNamedNodeMap map = cmDocument.getElements();
		CMElementDeclaration cmRootElement = null;
		String myName = getRootElementName();
		
		cmRootElement = (CMElementDeclaration) map.getNamedItem(cmDocument.getElements().item(0).getNodeName());
		if (cmRootElement==null)
			throw new IllegalArgumentException("XML Generator: Root element \'"+getRootElementName()+"\' is not defined in this XSD");

		Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		createContentBuilder(xmlDocument);
		
		// do the dirty deed!
		contentBuilder.createDefaultRootContent(cmDocument, cmRootElement, namespaceInfoList);

		// create an output stream so we can generate a string
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

		DOMWriter domWriter = new DOMWriter(outputStreamWriter);

		// TODO... instead of relying on file extensions, we need to keep
		// track of the grammar type...
		// better yet we should create an SSE document so that we can format
		// it nicely before saving then we won't need the DOMWriter at all
		domWriter.print(xmlDocument);
		outputStream.flush();
		outputStream.close();

		return outputStream.toString();
	}
	
	/**
	 * @param xmlDocument
	 */
	private void createContentBuilder(Document xmlDocument) {
		contentBuilder = new MyDOMContentBuilderImpl(xmlDocument);
		
		// convert our build policy to theirs
		int bp = 0;
		if ((myBuildPolicy|BUILD_OPTIONAL_ATTRIBUTES) != 0) bp |= DOMContentBuilder.BUILD_OPTIONAL_ATTRIBUTES;
		if ((myBuildPolicy|BUILD_OPTIONAL_ELEMENTS) != 0) bp |= DOMContentBuilder.BUILD_OPTIONAL_ELEMENTS;
		if ((myBuildPolicy|BUILD_FIRST_CHOICE) != 0) bp |= DOMContentBuilder.BUILD_FIRST_CHOICE;
		if ((myBuildPolicy|BUILD_TEXT_NODES) != 0) bp |= DOMContentBuilder.BUILD_TEXT_NODES;
		if ((myBuildPolicy|BUILD_FIRST_SUBSTITUTION) != 0) bp |= DOMContentBuilder.BUILD_FIRST_SUBSTITUTION;
		contentBuilder.setBuildPolicy(bp);
	}

	
	/**
	 * Given a CMNode object, determine the XSD type definition for the Node
	 * 
	 * @param cmNode - a CMNode object encapsulating either an Element or an Attribute
	 * @return XSD type definition, or null
	 */
	public static XSDTypeDefinition getXSDType(CMNode cmNode) {
		// this code snippet was obtained here: https://bugs.eclipse.org/bugs/show_bug.cgi?id=265274
		XSDTypeDefinition xsdType = null;
		
		if(cmNode instanceof CMElementDeclaration) {
		   CMElementDeclaration cmElementDeclaration = (CMElementDeclaration)cmNode;
		   if(cmElementDeclaration instanceof XSDElementDeclarationAdapter) {
		      XSDElementDeclarationAdapter xsdElementDeclarationAdapter = (XSDElementDeclarationAdapter)cmElementDeclaration;
		      Notifier target = xsdElementDeclarationAdapter.getTarget();
		      if(target instanceof XSDElementDeclaration) {
		         XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration)target;
		         xsdType = xsdElementDeclaration.getResolvedElementDeclaration().getTypeDefinition();
		      }
		   }
		}
		else if(cmNode instanceof CMAttributeDeclaration) {
		   CMAttributeDeclaration cmAttributeDeclaration = (CMAttributeDeclaration)cmNode;
		   if(cmAttributeDeclaration instanceof XSDAttributeUseAdapter) {
		      XSDAttributeUseAdapter xsdAttributeUseAdapter = (XSDAttributeUseAdapter)cmAttributeDeclaration;
		      Notifier target = xsdAttributeUseAdapter.getTarget();
		      if(target instanceof XSDAttributeUse) {
		         XSDAttributeUse xsdAttributeUse = (XSDAttributeUse)target;
		         XSDAttributeDeclaration xsdAttributeDeclaration = xsdAttributeUse.getAttributeDeclaration();
		         if(xsdAttributeDeclaration != null) {
		            xsdType = xsdAttributeDeclaration.getResolvedAttributeDeclaration().getTypeDefinition();
		         }
		      }
		   }
		}

		return xsdType;
	}
	
	/**
	 * Internal class that extends the actual XML generator.
	 * There are a couple of, let's call them "misbehaviors", of the DOMContentBuilder
	 * implementation that we need to correct:
	 * 1. if the caller specified an XPath and if any of the elements in that path are
	 * "choices" then generate the XML for those particular choices, instead of picking
	 * the first choice in the sequence.
	 * 2. if the generated "choice" contains an "enumeration" element, generate the correct
	 * text value for that element, instead of picking the first enumeration value derived
	 * from the base type.
	 */
	public class MyDOMContentBuilderImpl extends DOMContentBuilderImpl {

		// need to keep track of the current parent CMNode object so we can determine the
		// XSD type definition when trying to build text content for a node (see createTextNode())
		protected Stack<CMNode> cmNodeStack = new Stack<CMNode>();

		public MyDOMContentBuilderImpl(Document document) {
			super(document);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl#createDefaultRootContent(org.eclipse.wst.xml.core.internal.contentmodel.CMDocument, org.eclipse.wst.xml.core.internal.contentmodel.CMElementDeclaration)
		 */
		@Override
		public void createDefaultRootContent(CMDocument cmDocument,
				CMElementDeclaration rootCMElementDeclaration) throws Exception {
			if (namespaceInfoList != null) {
				DOMNamespaceInfoManager manager = new DOMNamespaceInfoManager();
				String name = rootCMElementDeclaration.getNodeName();
				if (namespaceInfoList.size() > 0) {
					NamespaceInfo info = (NamespaceInfo) namespaceInfoList.get(0);
					if (info.prefix != null && info.prefix.length() > 0) {
						name = info.prefix + ":" + name; //$NON-NLS-1$
					}
				}
				rootElement = createElement(rootCMElementDeclaration, name, document);
				if ((myBuildPolicy & BUILD_STRUCTURE_ONLY)==0)
					manager.addNamespaceInfo(rootElement, namespaceInfoList, true);
			}
			createDefaultContent(document, rootCMElementDeclaration);
		}

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl#createDefaultContent(org.w3c.dom.
         * Node, org.eclipse.wst.xml.core.internal.contentmodel.CMElementDeclaration)
         */
        @Override
        public void createDefaultContent(Node parent, CMElementDeclaration ed) {
            currentParent = parent;
            alwaysVisit = true;
            visitCMElementDeclaration(ed);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl#visitCMElementDeclaration(org.
         * eclipse.wst.xml.core.internal.contentmodel.CMElementDeclaration)
         */
        @Override
        public void visitCMElementDeclaration(CMElementDeclaration ed) {
            int forcedMin = (buildOptionalElements(buildPolicy) || alwaysVisit) ? 1 : 0;
            int min = Math.max(ed.getMinOccur(), forcedMin);

            // Correct the min value if the element is contained in
            // a group.
            if (!cmGroupStack.isEmpty()) {
                CMGroup group = (CMGroup) cmGroupStack.peek();
                int gmin = group.getMinOccur();
                if (gmin == 0)
                    if (buildOptionalElements(buildPolicy)) {
                        /* do nothing: min = min */
                    } else {
                        min = min * gmin; // min = 0
                    }
                else {
                    min = min * gmin;
                }
            }

            int max = Math.min(ed.getMaxOccur(), getNumOfRepeatableElements());
            if (max == -1) {
                // If the maxOccurs is unbounded, max will be -1. To indicate it as an array we add 2 elements of the
                // kind.
                max = 2;
            } else if (max < min) {
                max = min;
            }

            alwaysVisit = false;

            // Note - ed may not be abstract but has substitutionGroups
            // involved.
            if (buildFirstSubstitution(buildPolicy) || isAbstract(ed)) // leave
                                                                       // this
                                                                       // for
                                                                       // backward
                                                                       // compatibility
                                                                       // for now
            {
                // Note - To change so that if ed is optional, we do not
                // generate anything here.
                ed = getSubstitution(ed);

                // Note - the returned ed may be an abstract element in
                // which case the xml will be invalid.
            }

            if (min > 0 && !visitedCMElementDeclarationList.contains(ed)) {
                visitedCMElementDeclarationList.add(ed);
                for (int i = 1; i <= max; i++) {
                    // create an Element for each
                    Element element = null;
                    if (rootElement != null) {
                        element = rootElement;
                        rootElement = null;
                    } else {
                        element = createElement(ed, computeName(ed, currentParent), currentParent);
                    }

                    // visit the children of the GrammarElement
                    Node oldParent = currentParent;
                    currentParent = element;
                    handlePushParent(element, ed);

                    namespaceTable.addElement(element);

                    boolean oldAttachNodesToParent = attachNodesToParent;
                    attachNodesToParent = true;

                    // instead of calling super.visitCMElementDeclaration()
                    // we duplicate the code with some minor modifications
                    CMNamedNodeMap nodeMap = ed.getAttributes();
                    int size = nodeMap.getLength();
                    for (int j = 0; j < size; j++) {
                        visitCMNode(nodeMap.item(j));
                    }

                    CMContent content = ed.getContent();
                    if (content != null) {
                        visitCMNode(content);
                    }

                    if (ed.getContentType() == CMElementDeclaration.PCDATA) {
                        CMDataType dataType = ed.getDataType();
                        if (dataType != null) {
                            visitCMDataType(dataType);
                        }
                    }
                    // end duplication
                    attachNodesToParent = oldAttachNodesToParent;
                    handlePopParent(element, ed);
                    currentParent = oldParent;
                    linkNode(element);
                }
                int size = visitedCMElementDeclarationList.size();
                visitedCMElementDeclarationList.remove(size - 1);
            }
        }
		
		/* (non-Javadoc)
		 * @see org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl#visitCMGroup(org.eclipse.wst.xml.core.internal.contentmodel.CMGroup)
		 */
		@Override
		public void visitCMGroup(CMGroup e) {
			// this was copied directly from DOMContentBuilderImpl because there is apparently
			// no way of having CMNode return the "contentHint" property (see original implementation)
			// short of subclassing CMNode...an example provided by the wtp team would have
			// helped here.
			cmGroupStack.push(e);

			int forcedMin = (buildOptionalElements(myBuildPolicy) || alwaysVisit) ? 1 : 0;
			int min = Math.max(e.getMinOccur(), forcedMin);

			int max = 0;
			if (e.getMaxOccur() == -1) // unbounded
				max = getNumOfRepeatableElements();
			else
				max = Math.min(e.getMaxOccur(), getNumOfRepeatableElements());

			if (max < min)
				max = min;

			alwaysVisit = false;

			for (int i = 1; i <= max; i++) {
				if (e.getOperator() == CMGroup.CHOICE && buildFirstChoice(myBuildPolicy)) {
					CMNode cmNode = null;

					if (domLevel>0 && domLevel<=queryPath.length)
					{
						for (int n=0; n<e.getChildNodes().getLength(); ++n ) {
							CMNode cn = e.getChildNodes().item(n);
							if (cn.getNodeName().equals(queryPath[domLevel-1])) {
								cmNode = cn;
								break;
							}
						}
					}

					// if no cmNode has been determined from the path, just use the first choice
					if (cmNode == null) {
						CMNodeList nodeList = e.getChildNodes();
						if (nodeList.getLength() > 0) {
							cmNode = nodeList.item(0);
						}
					}

					if (cmNode != null) {
						visitCMNode(cmNode);
					}
				}
				else if (e.getOperator() == CMGroup.ALL // ALL
							|| e.getOperator() == CMGroup.SEQUENCE) // SEQUENCE
				{
					// visit all of the content
					super.visitCMGroup(e);
				}
			}

			cmGroupStack.pop();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl#handlePushParent(org.w3c.dom.Element, org.eclipse.wst.xml.core.internal.contentmodel.CMElementDeclaration)
		 */
		@Override
		protected void handlePushParent(Element parent, CMElementDeclaration ed) {
			super.handlePushParent(parent, ed);
			cmNodeStack.push(ed);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl#handlePopParent(org.w3c.dom.Element, org.eclipse.wst.xml.core.internal.contentmodel.CMElementDeclaration)
		 */
		@Override
		protected void handlePopParent(Element element, CMElementDeclaration ed) {
			super.handlePopParent(element, ed);
			cmNodeStack.pop();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl#createElement(org.eclipse.wst.xml.core.internal.contentmodel.CMElementDeclaration, java.lang.String, org.w3c.dom.Node)
		 */
		@Override
		protected org.w3c.dom.Element createElement(CMElementDeclaration ed, String name, Node parent) {
			// if building XML that represents only structure, use a generic element name
			// (either "simpleElem" or "complexElem") instead of the elements actual tag name
			if ((myBuildPolicy & BUILD_STRUCTURE_ONLY) != 0) {
				CMDataType dt = ed.getDataType();
				if (dt!=null)
					return document.createElement("simpleElem");
				return document.createElement("complexElem");
			}
			return document.createElement(name);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl#createAttribute(org.eclipse.wst.xml.core.internal.contentmodel.CMAttributeDeclaration, java.lang.String, org.w3c.dom.Node)
		 */
		@Override
		protected org.w3c.dom.Attr createAttribute(CMAttributeDeclaration ad, String name, Node parent) {
			// TODO: I think attribute names MUST match even if we're only building XML structure
			// for the purposes of comparing two XSD fragments...
			return document.createAttribute(name);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl#createTextNode(org.eclipse.wst.xml.core.internal.contentmodel.CMDataType, java.lang.String, org.w3c.dom.Node)
		 */
		@Override
		protected org.w3c.dom.Text createTextNode(CMDataType dataType, String value, Node parent) {

			// get XSD type definition from parent object currently at the top of our stack
			// so that we can get the (reduced) enumeration value types for that element
			// instead of for the base type (which is what XSDImpl#getEnumeratedValuesForType() does!)
			if (cmNodeStack.size()>0) {
				XSDTypeDefinition xsdType = getXSDType(cmNodeStack.peek());
				if (xsdType!=null) {
			   	    List result = new ArrayList();
			        getEnumeratedValuesForSimpleType(xsdType, result);
			        if (!result.isEmpty()) {
			        	value = (String)result.get(0);
						return document.createTextNode(value);
			        }
				}
			}
			
			// if building XML that represents only structure, use a generic text value
			// (the data type) instead of the value determined by the generator (see
			// XSDTypeUtil#getInstanceValue() for example...)
			if ((myBuildPolicy & BUILD_STRUCTURE_ONLY) != 0)
				value = dataType.getDataTypeName();
			
			return document.createTextNode(value);
		}
		
		/* (non-Javadoc)
		 * Method in the super class create an attribute element.
		 * If type of the attribute is string, it sets attribute element value to "".
		 * Then, attribute element type will be refer to as NULL when generating json schema.
		 * To avoid that, this method set value to attribute name if value is empty.
		 *
		 * @see org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl#visitCMAttributeDeclaration(org.eclipse.wst.xml.core.internal.contentmodel.CMAttributeDeclaration)
		 */
		@Override
		public void visitCMAttributeDeclaration(CMAttributeDeclaration ad) {
			super.visitCMAttributeDeclaration(ad);
			int size = currentParent.getAttributes().getLength();
			if (size > 0) {
				Attr attr = (Attr) currentParent.getAttributes()
						.item(currentParent.getAttributes().getLength() - 1);
				if (attr.getValue().isEmpty()) {
					attr.setValue(attr.getName());
				}
			}
		}

		/**
		 * This was stolen directly from XSDImpl. It builds a list of the enumeration
		 * values for the given XSD type definition.
		 * 
		 * @param type - an XSD type definition (presumably determined from a CMNode)
		 * @param result - List to which we will add our results
		 */
		public void getEnumeratedValuesForSimpleType(XSDTypeDefinition type, List result) {
			List enumerationFacets = ((XSDSimpleTypeDefinition) type)
					.getEnumerationFacets();
			for (Iterator i = enumerationFacets.iterator(); i.hasNext();) {
				XSDEnumerationFacet enumFacet = (XSDEnumerationFacet) i.next();
				List values = enumFacet.getValue();
				for (Iterator j = values.iterator(); j.hasNext();) {
					Object o = j.next();
					if (o != null) {
						if (!result.contains(o)) {
							result.add(o.toString());
						}
					}
				}
			}
		}
	}	
}
