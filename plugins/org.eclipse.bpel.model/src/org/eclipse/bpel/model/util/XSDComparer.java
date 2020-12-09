/*
 * Copyright (c) 2010 JBoss, Inc. and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.bpel.model.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDAttributeGroupContent;
import org.eclipse.xsd.XSDAttributeGroupDefinition;
import org.eclipse.xsd.XSDAttributeUse;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDDiagnostic;
import org.eclipse.xsd.XSDDiagnosticSeverity;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDModelGroupDefinition;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDParticleContent;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.XSDWildcard;
import org.eclipse.xsd.util.XSDConstants;

/**
 * Compares two XSD fragments for structure and data type compatibility.
 * Optional components in either the left or right schema may be skipped
 * over during the comparison unless a strict match is requested (see
 * <code>setStrict()<code>).
 * 
 * Components which have a "minOccurs" of 0 are considered optional.
 * Wildcard components (<xsd:any> elements) will match any component
 * in the other schema.
 * 
 * After the comparison, diagnostics are available which indicate the
 * components in the left and right schema that do not match. Warning
 * diagnostics are generated whenever optional components were skipped
 * to force a match.
 *
 * @see https://jira.jboss.org/browse/JBIDE-7351
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
 * @author Bob Brodt
 * @date Oct 29, 2010
 */
public class XSDComparer {

	protected boolean strict = false;
	protected boolean debug = false;
	protected List<XSDDiagnostic> diagnostics;
	protected Hashtable<XSDTerm,XSDTerm> terms = new Hashtable<XSDTerm,XSDTerm>();
	
	public void setStrict(boolean flag) {
		strict = flag;
	}

	public void setDebug(boolean flag) {
		debug = flag;
	}
	
	protected boolean alreadyCompared(XSDTerm term1, XSDTerm term2) {
		XSDTerm t = terms.get(term1);
		if (t==term2)
			return true;
		t = terms.get(term2);
		if (t==term1)
			return true;
		return false;
	}
	
	/**
	 * The main comparison function that compares two XSD type definitions.
	 * These may be the entire schema or just fragments within a schema.
	 * 
	 * @param type1 - the "left" type definition
	 * @param type2 - the "right" type definition
	 * @return true if the types are compatible, false if not.
	 * Warning diagnostics may still be generated for a successful match. 
	 */
	public boolean compare(XSDTypeDefinition type1, XSDTypeDefinition type2) {
		boolean result = false;
		if (type1==null || type2==null)
			throw new IllegalArgumentException("XSDComparer: XSD types may not be null");
		
		try {
			// always clear out diagnostics before we start
			if (diagnostics!=null)
				diagnostics.clear();
			
			// for debugging only: run through the exercises even if the
			// two objects are one and the same
			if (!debug && type1==type2)
				return true;
			
			result = compare(getChildTerms(type1), getChildTerms(type2), 0);
		} catch (Exception e) {
			return false;
		}

		return result;
	}

	/**
	 * Compares a list of the immediate children of a component; called recursively
	 * for children that are complex elements.
	 * 
	 * @param list1 - children of the "left" schema
	 * @param list2 - children of the "right" schema
	 * @param level - recursion level (for debug printing)
	 * @return true if the left and right children lists are compatible.
	 */
	protected boolean compare(List<XSDTerm> list1, List<XSDTerm> list2, int level) {

		XSDTerm term1 = null;
		XSDTerm term2 = null;
		
		try {
			int index1 = 0;
			int index2 = 0;
			int size1 = list1.size();
			int size2 = list2.size();
			while (index1 < size1 && index2 < size2) {
				term1 = list1.get(index1);
				term2 = list2.get(index2);
				if (alreadyCompared(term1,term2)) {
					dump("Skipping ",term1,null,level);
				}
				else {
					terms.put(term1,term2);
					if ( term1 instanceof XSDElementDeclaration && term2 instanceof XSDElementDeclaration) {
    					XSDElementDeclaration elem1 = (XSDElementDeclaration)term1;
    					XSDElementDeclaration elem2 = (XSDElementDeclaration)term2;
    					XSDTypeDefinition type1 = elem1.getTypeDefinition();
    					XSDTypeDefinition type2 = elem2.getTypeDefinition();
    					if (type1 instanceof XSDSimpleTypeDefinition && type2 instanceof XSDSimpleTypeDefinition) {
    						dump("Comparing ", elem1, type1, level);
    						dump("       to ", elem2, type2, level);
    						if (!compareQNames(elem1, elem2)) {
    							addError("different QNames: " + elem1.getQName() + " vs " + elem2.getQName(), term1,term2);
    							return false;
    						}
    						String s1 = getTypeNameHierarchy(elem1);
    						String s2 = getTypeNameHierarchy(elem2);
    						if (!s1.equals(s2)) {
    							addError("different data types: "+s1+" vs "+s2,elem1,elem2);
    							return false;
    						}
    					} else if (type1 instanceof XSDComplexTypeDefinition && type2 instanceof XSDComplexTypeDefinition) {
    						dump("Comparing ", elem1, type1, level);
    						dump("       to ", elem2, type2, level);
    						if (!compareQNames(elem1, elem2)) {
    							addError("different QNames: " + elem1.getQName() + " vs " + elem2.getQName(), term1,term2);
    							return false;
    						}
    						int min1 = getMinOccurs(term1);
    						int min2 = getMinOccurs(term2);
    						int max1 = getMaxOccurs(term1);
    						int max2 = getMaxOccurs(term2);
    						if (strict) {
    							if (min1 != min2 || max1 != max2) {
    								addError("different cardinality: " + min1 + " to " + max1 + " vs " + min2 + " to " + max2, term1,term2);
    								return false;
    							}
    						} else {
    							if ((max2>0 && min1 > max2) || (max1>0 && min2 > max1)) {
    								addError("incompatible cardinality: " + min1 + " to " + max1 + " vs " + min2 + " to " + max2, term1,term2);
    								return false;
    							}
    						}
    						boolean result = compare(getChildTerms(elem1), getChildTerms(elem2), level + 1);
    						if (!result) {
    							addError("different complex element structures",elem1,elem2);
    							return false;
    						}
    					} else {
    						if (!strict) {
    							// try shifting optional elements and continue from there
    							dump("Elements out of sync - skipping optional elements");
    							if (isOptional(elem1)) {
    								// skip over this one and compare remaining elements
    								List<XSDTerm> newList1 = new ArrayList<XSDTerm>();
    								List<XSDTerm> newList2 = new ArrayList<XSDTerm>();
    								for (int i = index1 + 1; i < size1; ++i)
    									newList1.add(list1.get(i));
    								for (int i = index2; i < size2; ++i)
    									newList2.add(list2.get(i));
    								if (compare(newList1, newList2, level)) {
    									addWarning("skipped optional element(s) in left schema",elem1,elem2);
    									return true;
    								}
    								addError("different complex element structures",elem1,elem2);
    							}
    							if (isOptional(elem2)) {
    								// skip over this one and compare remaining elements
    								List<XSDTerm> newList1 = new ArrayList<XSDTerm>();
    								List<XSDTerm> newList2 = new ArrayList<XSDTerm>();
    								for (int i = index1; i < size1; ++i)
    									newList1.add(list1.get(i));
    								for (int i = index2 + 1; i < size2; ++i)
    									newList2.add(list2.get(i));
    								if (compare(newList1, newList2, level)) {
    									addWarning("skipped optional element(s) in right schema",elem1,elem2);
    									return true;
    								}
    								addError("different complex element structures",elem1,elem2);
    							}
    						}
    						addError("different complex element structures",elem1,elem2);
    						return false;
    					}
    					
    					List<XSDAttributeDeclaration> attrs1 = getAttributeDeclarations(elem1);
    					List<XSDAttributeDeclaration> attrs2 = getAttributeDeclarations(elem2);
    					if (attrs1.size() != attrs2.size()) {
    						addError("different number of attributes",elem1,elem2);
    						return false;
    					}
    					for (int i = 0; i < attrs1.size(); ++i) {
    						XSDAttributeDeclaration attr1 = attrs1.get(i);
    						XSDAttributeDeclaration attr2 = attrs2.get(i);
    						if (!attr1.getQName().equals(attr2.getQName())) {
    							addError("different attribute names: "+attr1.getQName()+" vs "+attr2.getQName(),elem1,elem2);
    							return false;
    						}
    						String value1 = attr1.getLexicalValue(); 
    						String value2 = attr2.getLexicalValue();
    						if (value1==null)
    							value1 = "";
    						if (value2==null)
    							value2 = "";
    						if (!value1.equals(value2)) {
    							addError("different attribute values: "+attr1.getLexicalValue()+" vs "+attr2.getLexicalValue(),elem1,elem2);
    							return false;
    						}
    					}
    					
    				} else if (term1 instanceof XSDWildcard && !(term2 instanceof XSDWildcard) ) {
    					// left schema term is a wildcard, right schema is not
    					int min = getMinOccurs(term1);
    					int max = getMinOccurs(term1);
    					if (max==-1)
    						max = size1;
    					
    					for (int n=min; n<=max; ++n) {
    						// skip over this one and compare remaining elements
    						List<XSDTerm> newList1 = new ArrayList<XSDTerm>();
    						List<XSDTerm> newList2 = new ArrayList<XSDTerm>();
    						for (int i = index1 + 1 + n; i < size1; ++i)
    							newList1.add(list1.get(i));
    						for (int i = index2; i < size2; ++i)
    							newList2.add(list2.get(i));
    						if (compare(newList1, newList2, level)) {
    							addWarning("skipped optional element(s) in left schema",term1,term2);
    							return true;
    						}
    					}
    					addError("different complex element structures",term1,term2);
    					return false;
    				} else if (term1 instanceof XSDWildcard && !(term2 instanceof XSDWildcard) ) {
    					// right schema is a wildcard, left schema is not
    					int min = getMinOccurs(term2);
    					int max = getMinOccurs(term2);
    					if (max==-1)
    						max = size2;
    					
    					for (int n=min; n<=max; ++n) {
    						// skip over this one and compare remaining elements
    						List<XSDTerm> newList1 = new ArrayList<XSDTerm>();
    						List<XSDTerm> newList2 = new ArrayList<XSDTerm>();
    						for (int i = index1; i < size1; ++i)
    							newList1.add(list1.get(i));
    						for (int i = index2 + 1 + n; i < size2; ++i)
    							newList2.add(list2.get(i));
    						if (compare(newList1, newList2, level)) {
    							addWarning("skipped optional element(s) in right schema",term1,term2);
    							return true;
    						}
    					}
    					addError("different complex element structures",term1,term2);
    					return false;
    				} else if (term1 instanceof XSDWildcard && term2 instanceof XSDWildcard) {
    					// both wildcards - it's a match!
    					int min1 = getMinOccurs(term1);
    					int max1 = getMinOccurs(term1);
    					int min2 = getMinOccurs(term2);
    					int max2 = getMinOccurs(term2);
    					if (min1!=min2 || max1!=max2) {
    						// not possible
    						addError("different <xsd:any> cardinality: "+min1+" to "+max1+" vs "+min2+" to "+max2,term1,term2);
    					}
    				}
				}
				
				++index1;
				++index2;
			}

			// any leftovers? they must be optional
			if (strict && size1 != size2) {
				addError("different number of elements: "+size1+" vs "+size2,term1,term2);
				return false;
			}

			if (index1 < size1) {
				dump("Additional elements in left schema");
				while (index1 < size1) {
					term1 = list1.get(index1);
					if (isOptional(term1)) {
						dump("Ignoring optional element", term1, null, 1);
						addWarning("skipped optional element in left schema",term1,term2);
						term1 = list2.get(++index1);
					} else {
						addError("additional elements in left schema",term1,term2);
						return false;
					}
				}
			}

			if (index2 < size2) {
				dump("Additional elements in right schema");
				while (index2 < size2) {
					term2 = list2.get(index2);
					if (isOptional(term2)) {
						dump("Ignoring optional element", term2, null, 1);
						addWarning("skipped optional element in right schema",term1,term2);
						term2 = list2.get(++index2);
					} else {
						addError("additional elements in right schema",term1,term2);
						return false;
					}
				}
			}

		} catch (Exception e) {
			addError("caught exception: "+e.toString(),term1,term2);
			e.printStackTrace();
			return false;
		}
		
		if (level==0)
			dump("*** Schemas are compatible");

		return true;
	}

	/**
	 * Returns the data type name of the given element, including base types.
	 * 
	 * @param elem - the element
	 * @return data type name hierarchy as a ":" separated string 
	 */
	protected String getTypeNameHierarchy(XSDElementDeclaration elem) {
		String s = "";
		Stack<String> names = new Stack<String>();
		XSDTypeDefinition type = elem.getType();
		while (type != type.getBaseType()) {
			String name = type.getName();
			if (name != null)
				names.push(name);
			type = type.getBaseType();
		}
		while (!names.isEmpty()) {
			if (s.isEmpty())
				s = names.pop();
			else
				s = s + ":" + names.pop();
		}
		return s;
	}
	
	private boolean compareQNames(XSDNamedComponent elem1, XSDNamedComponent elem2) {

		String name1 = elem1.getName();
		String name2 = elem2.getName();
		if (name1==null || name2==null) {
			if (name1==name2)
				return true;
			return false;
		}
		if (name1.equals(name2)) {
			if (elem1.getTargetNamespace() == null || elem1.getTargetNamespace().isEmpty()
					&& elem2.getTargetNamespace() == null || elem2.getTargetNamespace().isEmpty())
				return true;

			if (elem1.getTargetNamespace().equals(elem2.getTargetNamespace()))
				return true;
			
			if ( elem1.getSchema().getTargetNamespace().equals(elem2.getSchema().getTargetNamespace()) )
				return true;
		}
		
		return false;
	}

	/**
	 * Returns a list of immediate children for the specified element.
	 * 
	 * @param element - the parent element
	 * @return A list of XSDTerm objects
	 */
	protected final List<XSDTerm> getChildTerms(XSDElementDeclaration element) {
		return getChildTerms(element.getType());
	}

	/**
	 * Returns a list of immediate children for the specified XSD type.
	 * 
	 * @param type - the parent type
	 * @return A list of XSDTerm objects
	 */
	protected final List<XSDTerm> getChildTerms(XSDTypeDefinition type) {
		final ArrayList<XSDTerm> terms = new ArrayList<XSDTerm>();

		TypeWalker.Visitor visitor = new TypeWalker.Visitor() {
			public boolean visit(XSDTypeDefinition type) {
				// simple types don't have children
				if (type instanceof XSDSimpleTypeDefinition)
					return true;

				XSDComplexTypeDefinition cType = (XSDComplexTypeDefinition) type;

				visitTerms(cType, new TermVisitor() {
					public void visit(XSDParticle particle) {
						// element declaration, or wildcard: add to list
						XSDParticleContent content = particle.getContent();
						if (content instanceof XSDElementDeclaration) {
							XSDElementDeclaration decl = (XSDElementDeclaration) particle.getContent();

							if (decl.isElementDeclarationReference())
								decl = decl.getResolvedElementDeclaration();
							// System.out.println("Adding "+decl.getName());
							terms.add(decl);
						} else if (content instanceof XSDWildcard) {
							// System.out.println("Adding <xsd:any>");
							terms.add((XSDWildcard) content);
						}
					}
				});

				return true;
			}
		};

		TypeWalker walker = new TypeWalker(type);
		walker.walk(visitor);

		return terms;
	}

	/**
	 * Returns the value of the "minOccurs" attribute for the given XSD element.
	 * 
	 * @param term - the XSD element
	 * @return numerical value of "minOccurs" or 1 if the element does not specify
	 */
	public int getMinOccurs(XSDTerm term) {
		String smin = term.getElement().getAttribute("minOccurs");
		int min = 1;
		if (smin!=null && !smin.isEmpty()) {
			try {
				min = Integer.parseInt(smin);
			} catch (NumberFormatException e) {
			}
		}
		return min;
	}

	/**
	 * Returns the value of the "maxOccurs" attribute for the given XSD element.
	 * 
	 * @param term - the XSD element
	 * @return numerical value of "maxOccurs" or 1 if the element does not specify
	 */
	public int getMaxOccurs(XSDTerm term) {
		String smax = term.getElement().getAttribute("maxOccurs");
		int max = 1;
		if (smax!=null && !smax.isEmpty()) {
			try {
				max = Integer.parseInt(smax);
			} catch (NumberFormatException e) {
				if (smax.equalsIgnoreCase("unbounded"))
					max = -1;
			}
		}
		return max;
	}
	
	/**
	 * Returns true if the specified XSD element is optional.
	 * 
	 * @param term
	 * @return true if the element has "minOccurs=0"
	 */
	protected boolean isOptional(XSDTerm term) {

		if (getMinOccurs(term)==0)
			return true;
		return false;
	}

	/**
	 * Examine the content of a complex type and visit each of its particles.
	 * This will expand <xsd:sequence>, <xsd:choice>, <xsd:all>, <xsd:group>
	 * and <xsd:any> elements.
	 * 
	 * @param cType - the complex type to examine
	 * @param visitor - a TermVisitor which will be called for each particle found
	 */
	private void visitTerms(XSDComplexTypeDefinition cType, TermVisitor visitor) {

		// simple types are leaf nodes
		if (cType.getContent() == null || (cType.getContent() instanceof XSDSimpleTypeDefinition))
			return;

		// the last particle visited; used to detect <xsd:any> elements
		XSDParticleContent lastVisited = null;
		
		// use a queue to simulate the recursion
		LinkedList<XSDParticle> queue = new LinkedList<XSDParticle>();
		queue.addLast((XSDParticle) cType.getContent());

		while (!queue.isEmpty()) {
			XSDParticle particle = (XSDParticle) queue.removeFirst();

			// analyze type of particle content
			int pType = org.eclipse.xsd.util.XSDUtil.nodeType(particle.getElement());
			if (pType == XSDConstants.ELEMENT_ELEMENT) {
				lastVisited = particle.getContent();
				visitor.visit(particle);
			} else {
				// model group
				XSDModelGroup modelGroup = null;
				switch (pType) {
				case XSDConstants.GROUP_ELEMENT:
					XSDModelGroupDefinition grpDef = (XSDModelGroupDefinition) particle.getContent();
					if (grpDef.isModelGroupDefinitionReference())
						grpDef = grpDef.getResolvedModelGroupDefinition();

					modelGroup = grpDef.getModelGroup();
					break;

				case XSDConstants.CHOICE_ELEMENT:
				case XSDConstants.ALL_ELEMENT:
				case XSDConstants.SEQUENCE_ELEMENT:
					modelGroup = (XSDModelGroup) particle.getContent();
					break;

				case XSDConstants.ANY_ELEMENT:
					// see forum post at:
					// http://www.eclipse.org/forums/index.php?t=msg&th=20437&start=0&S=52ae90dcc09745f37034e330b91695cd
					//
					// The XSDWildcard seems to be emitted in the case where an element has no type information;
					// and it is also emitted in response to an actual xsd:any element appearing in the schema.
					//
					// In both cases, the XSDWildcard appears the same (surprisingly it refers to a DOM element
					// from Xerces of xsd:any). there is confusion here between elements of type anyType, i..e.,
					// <xsd:element name="x" type=xsd:anyType"/> verses element wildcards <xsd:any>. When matching
					// element content using the DFA returned by XSDParticle, each element will match either an
					// element declaration or a wildcard, which you can tell apart easily by whether you've matched
					// an XSDElementDeclaration or an XSDWildcard.
					if (lastVisited!=null) {
						// found an <xsd:any> element - go visit it!
						lastVisited = particle.getContent();
						visitor.visit(particle);
					}
					break;
					
				default:
					// TODO: do we need to handle additional XSD node types?
					break;
				}

				if (modelGroup != null) {
					// enque all particles in the group
					List<XSDParticle> particles = modelGroup.getParticles();
					for (XSDParticle p : particles) {
						queue.addLast(p);
					}

					lastVisited = null;
				}
			}
		}
	}

	/**
	 * Returns a list of all attribute declarations declared in the type or any
	 * base type, of the specified element.
	 * 
	 * @param element - the element
	 * @return a list of XSDAttributeDeclaration objects
	 */
	public final List<XSDAttributeDeclaration> getAttributeDeclarations(XSDElementDeclaration element) {
		final ArrayList<XSDAttributeDeclaration> attributes = new ArrayList<XSDAttributeDeclaration>();

		// walk up the type hierarchy of the element to generate a list of atts
		TypeWalker walker = new TypeWalker(element.getType());

		TypeWalker.Visitor visitor = new TypeWalker.Visitor() {
			public boolean visit(XSDTypeDefinition type) {

				// simple types dont have attributes
				if (type instanceof XSDSimpleTypeDefinition)
					return true;

				XSDComplexTypeDefinition cType = (XSDComplexTypeDefinition) type;

				// get all the attribute content (groups,or uses) and add to list
				List<XSDAttributeGroupContent> contents = cType.getAttributeContents();
				for (XSDAttributeGroupContent content : contents) {
					if (content instanceof XSDAttributeUse) {
						// an attribute, add it to the list
						XSDAttributeUse use = (XSDAttributeUse) content;
						attributes.add(use.getAttributeDeclaration());
					} else if (content instanceof XSDAttributeGroupDefinition) {
						// attribute group, add all atts in group to list
						XSDAttributeGroupDefinition attGrp = (XSDAttributeGroupDefinition) content;

						if (attGrp.isAttributeGroupDefinitionReference()) {
							attGrp = attGrp.getResolvedAttributeGroupDefinition();
						}

						List<XSDAttributeUse> uses = attGrp.getAttributeUses();
						for (XSDAttributeUse use : uses) {
							attributes.add(use.getAttributeDeclaration());
						}
					}
				}

				return true;
			}
		};

		walker.walk(visitor);
		return attributes;
	}

	/**
	 * Returns a list diagnostics of that may have been created
	 * during the comparison
	 * 
	 * @return a list of XSDDiagnostic objects
	 */
	public List<XSDDiagnostic> getDiagnostics() {
		if (diagnostics==null) {
			diagnostics = new ArrayList<XSDDiagnostic>();
		}
		return diagnostics;
	}
	
	/**
	 * Convenience method for formatting diagnostics as strings
	 * 
	 * @param index - the index into the diagnostics array
	 * @return a nicely formatted string
	 */
	public String getDiagnostic(int index) {
		String msg = "";
		
		if (diagnostics!=null && index>=0 && index<diagnostics.size()) {
			XSDDiagnostic d = diagnostics.get(index);
			String name1 = "";
			String name2 = "";
			String schema1 = "";
			String schema2 = "";
			XSDTerm comp1 = null;
			XSDTerm comp2 = null;
			EList<XSDConcreteComponent> components = d.getComponents();
			if (components.size()>0 && components.get(0) instanceof XSDTerm)
				comp1 = (XSDTerm)components.get(0);
			if (components.size()>1 && components.get(1) instanceof XSDTerm)
				comp2 = (XSDTerm)components.get(1);
			
			if (comp1 instanceof XSDElementDeclaration) {
				name1 = ((XSDElementDeclaration)comp1).getQName();
				schema1 = comp1.eResource().getURI().toString();
			}
			else if (comp1 instanceof XSDWildcard) {
				name1 = "<xsd:any>";
				schema1 = comp1.eResource().getURI().toString();
			}
			if (comp2 instanceof XSDElementDeclaration) {
				name2 = ((XSDElementDeclaration)comp2).getQName();
				schema2 = comp2.eResource().getURI().toString();
			}
			else if (comp2 instanceof XSDWildcard) {
				name2 = "<xsd:any>";
				schema2 = comp2.eResource().getURI().toString();
			}
			
			if ( comp1!=null && comp2!=null ) {
				msg = "Element <" + name1 + ">" +
				" in " + schema1 +
				" differs from <" + name2 + ">";
				if (!schema1.equals(schema2))
					msg += " in " + schema2;
				msg += " - " + d.getMessage();
			}
			else {
				msg =
				"Schema " + d.getLocationURI() +
				" - " + d.getMessage();
			}
		}
		return msg;
	}
	
	/**
	 * Creates a new diagnostic and adds it to our list.
	 * 
	 * @param severity - one of the XSDDiagnosticSeverity values (WARNING, ERROR, etc.)
	 * @param msg - a human-readable message to associate with the diagnostic
	 * @param comp1 - the "left" schema component
	 * @param comp2 - the "right" schema component
	 * @return a newly constructed XSDDiagnostic object
	 */
	protected XSDDiagnostic addDiagnostic(int severity, String msg, XSDConcreteComponent comp1, XSDConcreteComponent comp2) {
		XSDDiagnostic diag = XSDFactory.eINSTANCE.createXSDDiagnostic();
		diag.setSeverity(XSDDiagnosticSeverity.get(severity));
		diag.setMessage(msg);
		diag.getComponents().add(comp1);
		diag.getComponents().add(comp2);
		getDiagnostics().add(diag);
		
		if (debug)
			dump(getDiagnostic(getDiagnostics().size()-1));
		
		return diag;
	}
	
	/**
	 * Convenience method for creating a WARNING diagnostic
	 * 
	 * @param msg - a human-readable message to associate with the diagnostic
	 * @param comp1 - the "left" schema component
	 * @param comp2 - the "right" schema component
	 * @return a newly constructed XSDDiagnostic object
	 */
	protected XSDDiagnostic addWarning(String msg, XSDConcreteComponent comp1, XSDConcreteComponent comp2) {
		return addDiagnostic(XSDDiagnosticSeverity.WARNING, msg, comp1, comp2);
	}
	
	/**
	 * Convenience method for creating a WARNING diagnostic
	 * 
	 * @param msg - a human-readable message to associate with the diagnostic
	 * @param comp1 - the "left" schema component
	 * @param comp2 - the "right" schema component
	 * @return a newly constructed XSDDiagnostic object
	 */
	protected XSDDiagnostic addError(String msg, XSDConcreteComponent comp1, XSDConcreteComponent comp2) {
		return addDiagnostic(XSDDiagnosticSeverity.ERROR, msg, comp1, comp2);
	}

	/**
	 * Debug message printer
	 * 
	 * @param label - a text string to print to stderr
	 */
	private void dump(String label) {
		
		if (debug)
			dump(label, null, null, 0);
	}

	/**
	 * Debug message printer
	 * 
	 * @param label - text string
	 * @param term - an XSD element to dump 
	 * @param type - and its type
	 * @param level - indent level
	 */
	private void dump(String label, XSDTerm term, XSDTypeDefinition type, int level) {
		
		if (debug) {
			if (term != null) {
				StringBuilder indent = new StringBuilder();
				for (int i = 0; i < level; ++i)
					indent.append( "    " );
				
				if (term instanceof XSDElementDeclaration) {
					XSDElementDeclaration decl = (XSDElementDeclaration) term;
					if (type instanceof XSDSimpleTypeDefinition)
						System.err.println(label + indent + "<" + decl.getName() + "> type=\""
								+ this.getTypeNameHierarchy(decl)+"\"");
					else if (type instanceof XSDComplexTypeDefinition || type == null)
						System.err.println(label + indent + "<" + decl.getName() + ">");
					else
						System.err.println("dump: unknown XSD type: " + type.getClass().toString());
				} else if (term instanceof XSDWildcard) {
					System.err.println(label + indent + "<any/>");
				} else
					System.err.println("dump: unknown term: " + term.getClass().toString());
			} else
				System.err.println(label);
		}
	}

	/**
	 * Simple visitor interface for complex types
	 */
	private interface TermVisitor {
		void visit(XSDParticle particle);
	}

	/**
	 * XSD type hierarchy walker that visits each XSD type from the bottom-up
	 */
	private static class TypeWalker {

		// bottom of the type hierarchy
		XSDTypeDefinition base;

		public TypeWalker(XSDTypeDefinition base) {
			this.base = base;
		}

		public void walk(Visitor visitor) {
			
			XSDTypeDefinition type = base; 
				
			while(type != null) {
				if (!visitor.visit(type))
					break;
				// walk up the type hierarchy to the top
				if (type.equals(type.getBaseType()))
					break;
				type = type.getBaseType();
			}
		}

		public interface Visitor {
			boolean visit(XSDTypeDefinition type);
		}
	}
	
	private static class XSDTermTuple {
		public XSDTerm term1, term2;
		public XSDTermTuple(XSDTerm term1, XSDTerm term2) {
			this.term1 = term1;
			this.term2 = term2;
		}
	}
}
