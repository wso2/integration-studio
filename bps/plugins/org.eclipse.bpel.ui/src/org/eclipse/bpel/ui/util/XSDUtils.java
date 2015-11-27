/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDAttributeGroupDefinition;
import org.eclipse.xsd.XSDAttributeUse;
import org.eclipse.xsd.XSDAttributeUseCategory;
import org.eclipse.xsd.XSDComplexTypeContent;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDFeature;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDModelGroupDefinition;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDConstants;
import org.eclipse.xsd.util.XSDUtil;

/**
 * Collection of utility methods for dealing with navigation of the XSD model
 */
public class XSDUtils {

	// singleton lists of XSD simple type definitions for supported primitives (see getPrimitives()) and
	// all xsd primitives (see getAdvancedPrimitives()) respectively
	private static List<XSDSimpleTypeDefinition> primitives;
	private static List<XSDTypeDefinition> advancedPrimitives;

	// XSD short list -- these are the types presented to the user by default, rather than inundating them with
	// all the available types
	private static List<String> xsdShortList = new ArrayList<String>();
	static
	{
		xsdShortList.add("string"); //$NON-NLS-1$
		xsdShortList.add("int"); //$NON-NLS-1$
		xsdShortList.add("double"); //$NON-NLS-1$
		xsdShortList.add("date"); //$NON-NLS-1$
		xsdShortList.add("time"); //$NON-NLS-1$
		xsdShortList.add("dateTime"); //$NON-NLS-1$
		xsdShortList.add("boolean"); //$NON-NLS-1$
		xsdShortList.add("hexBinary"); //$NON-NLS-1$
		xsdShortList.add("float"); //$NON-NLS-1$
	}


	// A list of all supported XSD types.  Usually the user will not be presented with the full list, but
	// rather with the xsd short list
	private static List<String> supportedPrimitives = new ArrayList<String>();
	static {
		supportedPrimitives.add("anyType"); //$NON-NLS-1$
		supportedPrimitives.add("anyURI"); //$NON-NLS-1$
		supportedPrimitives.add("base64Binary"); //$NON-NLS-1$
		supportedPrimitives.add("boolean"); //$NON-NLS-1$
		supportedPrimitives.add("byte"); //$NON-NLS-1$
		supportedPrimitives.add("date"); //$NON-NLS-1$
		supportedPrimitives.add("dateTime"); //$NON-NLS-1$
		supportedPrimitives.add("decimal"); //$NON-NLS-1$
		supportedPrimitives.add("double"); //$NON-NLS-1$
		supportedPrimitives.add("duration"); //$NON-NLS-1$
		supportedPrimitives.add("ENTITIES"); //$NON-NLS-1$
		supportedPrimitives.add("ENTITY"); //$NON-NLS-1$
		supportedPrimitives.add("float"); //$NON-NLS-1$
		supportedPrimitives.add("gDay"); //$NON-NLS-1$
		supportedPrimitives.add("gMonth"); //$NON-NLS-1$
		supportedPrimitives.add("gMonthDay"); //$NON-NLS-1$
		supportedPrimitives.add("gYear"); //$NON-NLS-1$
		supportedPrimitives.add("gYearMonth"); //$NON-NLS-1$
		supportedPrimitives.add("hexBinary"); //$NON-NLS-1$
		supportedPrimitives.add("ID"); //$NON-NLS-1$
		supportedPrimitives.add("IDREF"); //$NON-NLS-1$
		supportedPrimitives.add("IDREFS"); //$NON-NLS-1$
		supportedPrimitives.add("int"); //$NON-NLS-1$
		supportedPrimitives.add("integer"); //$NON-NLS-1$
		supportedPrimitives.add("language"); //$NON-NLS-1$
		supportedPrimitives.add("long"); //$NON-NLS-1$
		supportedPrimitives.add("Name"); //$NON-NLS-1$
		supportedPrimitives.add("NCName"); //$NON-NLS-1$
		supportedPrimitives.add("negativeInteger"); //$NON-NLS-1$
		supportedPrimitives.add("NMTOKEN"); //$NON-NLS-1$
		supportedPrimitives.add("NMTOKENS"); //$NON-NLS-1$, "NMTOKENS");
		supportedPrimitives.add("nonNegativeInteger"); //$NON-NLS-1$
		supportedPrimitives.add("nonPositiveInteger"); //$NON-NLS-1$
		supportedPrimitives.add("normalizedString"); //$NON-NLS-1$
		supportedPrimitives.add("NOTATION"); //$NON-NLS-1$
		supportedPrimitives.add("positiveInteger"); //$NON-NLS-1$
		supportedPrimitives.add("QName"); //$NON-NLS-1$
		supportedPrimitives.add("short"); //$NON-NLS-1$
		supportedPrimitives.add("string"); //$NON-NLS-1$
		supportedPrimitives.add("time"); //$NON-NLS-1$
		supportedPrimitives.add("token"); //$NON-NLS-1$
		supportedPrimitives.add("unsignedByte"); //$NON-NLS-1$
		supportedPrimitives.add("unsignedInt"); //$NON-NLS-1$
		supportedPrimitives.add("unsignedLong"); //$NON-NLS-1$
		supportedPrimitives.add("unsignedShort"); //$NON-NLS-1$
	}

	/**
	 * Like getPrimitives(), this returns a list of XSDTypeDefinitions.  However where getPrimitives()
	 * returns the basic set supported by the editor, getAdvancedPrimitives returns every known XSD
	 * primitive type.
	 * @return
	 */
	public static List<XSDTypeDefinition> getAdvancedPrimitives() {
		advancedPrimitives = null;
		if(advancedPrimitives == null) {
			advancedPrimitives = new ArrayList<XSDTypeDefinition>();

			// Get the schema for schemas instance to use when resolving primitives
			XSDSchema schemaForSchemas = XSDUtil.getSchemaForSchema(XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001);

			// Start adding the simple types using the supportedPrimitives list
			for (String typeName : supportedPrimitives) {
				XSDTypeDefinition type = schemaForSchemas.resolveSimpleTypeDefinition(typeName);
				advancedPrimitives.add(type);
			}

			// Return primitives in alpha order
			Collections.sort(advancedPrimitives, new Comparator() {

				@Override
				public int compare(Object o1, Object o2) {
					if(o1 == null || o2 == null || ((XSDTypeDefinition) o1).getName() == null)
						return 0;
					return ((XSDTypeDefinition) o1).getName().compareToIgnoreCase(((XSDTypeDefinition) o2).getName());
				}
			});
		}
		return advancedPrimitives;
	}

	/**
	 * Given a BO (XSD Complex Type), return a list of the attributes
	 * within the complexType.
	 * @param bo
	 * @return List of XSDAttributeDeclaration
	 */
	public static List<XSDAttributeDeclaration> getChildAttributes(XSDComplexTypeDefinition bo)
	{
		EList attrContents = bo.getAttributeContents();
		List<XSDAttributeDeclaration> attrs = new ArrayList<XSDAttributeDeclaration>();
		for (int i=0; i< attrContents.size(); i++)
		{
			Object next = attrContents.get(i);

			// Attribute contents may include actual attribute delcarations (wrapped in XSDAttributeUses) or
			// attribute group definitions, containing bundles of attributes
			if(next instanceof XSDAttributeUse) {
				attrs.add( ((XSDAttributeUse) next).getContent().getResolvedAttributeDeclaration() );

			} else if (next instanceof XSDAttributeGroupDefinition) {

				// Add these attributes to the end of attrContents to be processed in turn
				XSDAttributeGroupDefinition attrGroup = (XSDAttributeGroupDefinition) next;
				if(attrGroup.getResolvedAttributeGroupDefinition() != null)
					attrContents.addAll(attrGroup.getResolvedAttributeGroupDefinition().getAttributeUses());

			}
		}
		return attrs;
	}

	/**
	 * Given a BO (XSD Complex Type), return a list of the XSDFeatures
	 * within the complexType's modelgroup (sequence, choice, etc.)
	 * @param bo
	 * @return
	 */
	public static List<XSDFeature> getChildElements(XSDComplexTypeDefinition bo) {
   		return XSDUtils.getChildElements( getModelGroup(bo) );
	}

	/**
	 * Given a Model group, return a list of the XSDFeatures
	 * declared within.
	 * @param group
	 * @return
	 */
	public static List<XSDFeature> getChildElements(XSDModelGroup group)
	{
    	if(group == null)
    		return new ArrayList<XSDFeature>();

		List<XSDFeature> children = new ArrayList<XSDFeature>();
    	for( XSDParticle next : group.getContents() ) {
    		if(next.getContent() instanceof XSDFeature)
    			children.add((XSDFeature) next.getContent());
    		else if (next.getTerm() instanceof XSDModelGroup)
    			children.addAll(getChildElements((XSDModelGroup) next.getTerm()));
    	}
    	return children;
	}

	/**
	 * Given an XSD Complex Type Definition, return the model group containing
	 * its child elements.
	 * @param element
	 * @return
	 */
	public static XSDModelGroup getModelGroup(XSDComplexTypeDefinition cType)
	{
		XSDParticle particle = cType.getComplexType();

		// In cases where cType doesn't have a model group AND cType has a parent with a modelgroup, the
		// call above will rather unexpectedly give us cType's PARENT's model group, rather than the null we
		// might expect.  We don't want that here, if the model group returned is null or belongs to someone
		// other than us, return null
		if (particle==null || particle.eContainer() != cType) {
			return null;
		}

		// get the model group
		Object particleContent = particle.getContent();
		XSDModelGroup group = null;

		if (particleContent instanceof XSDModelGroupDefinition) {
		    group = ((XSDModelGroupDefinition)particleContent).getResolvedModelGroupDefinition().getModelGroup();
		} else if (particleContent instanceof XSDModelGroup) {
		    group = (XSDModelGroup)particleContent;
		}

		if (group == null) {
		    return null;
		}

		// if the content of the complex type is empty then the content
		// must be in the complexContent, ie. we're extending another BO.
		// if the group and the type are not in the same resource then
		// we are extending another BO and we don't want to show inherited
		// attributes.
		if ( group.getContents().isEmpty() || group.eResource() != cType.eResource())
		{
			// if we are extending another BO then get the elements
			// we are adding
			if (cType.getBaseType()!=null)
			{
				XSDComplexTypeContent content = cType.getContent();

				if (content instanceof XSDParticle) {
					particleContent = ((XSDParticle)content).getContent();
					if (particleContent instanceof XSDModelGroupDefinition) {
					    group = ((XSDModelGroupDefinition)particleContent).getResolvedModelGroupDefinition().getModelGroup();
					} else if (particleContent instanceof XSDModelGroup) {
					    group = (XSDModelGroup)particleContent;
					}
				}

			}
		}

		return group;
	}

	/**
	 * Try a variety of methods to get a human readable name for type.  In order, this method will
	 * - check whether type is null, and if so return null
	 * - check whether type is a restriction of a primitive type, if so return its parent's name
	 * - check whether type is a complex anonymous (un-named) inner type of a named element, and if so, return the element's name
	 * - check whether type is a primitive type, and if so return a human-readable version of that type
	 * - check whether type is a named, non-primitive type, and if so, return its name
	 * @param xsdType
	 * @return
	 */
	public static String getDisplayNameFromXSDType(XSDTypeDefinition type) {
		return getDisplayNameFromXSDType(type, true);
	}

	/**
	 * Try a variety of methods to get a human readable name for type.  In order, this method will
	 * - check whether type is null, and if so return null
	 * - check whether type is a complex anonymous (un-named) inner type of a named element, and if so, return the element's name
	 * - check whether type is a primitive type, and if so return a human-readable version of that type
	 * - check whether type is a named, non-primitive type, and if so, return its name
	 * - if returnPrimitiveParents is true, check whether type is a restriction of a primitive type,
	 * if so return its parent's name
	 * @param xsdType
	 * @param returnPrimitiveParents if true, and if type is an anonymous restriction of an xsd primitive
	 * type, this method will return the name of the parent primitive type.  If false, restrictions of
	 * primitive types will not be treated differently from other types, and their container hierarchy will
	 * be walked, instead of their inheritance hierarchy.
	 * @return
	 */
	public static String getDisplayNameFromXSDType(XSDTypeDefinition type, boolean returnPrimitiveParents) {
		if(type == null)
			return null;

		// Does type have a name?  If not, walk up the container tree to try and find one
		if(type.getName() == null || type.getName().length() == 0) {

			// In the special case where type is a restriction on a primitive type, just return the parent's
			// name (which will either be a primitive itself, or a named simple type)
			if(returnPrimitiveParents && isRestrictedPrimitiveType(type)) {
				return getDisplayNameFromXSDType(type.getBaseType());
			}

			EObject container = type.eContainer();

			while(container != null) {
				if(container instanceof XSDNamedComponent && ((XSDNamedComponent) container).getName() != null) {
					return ((XSDNamedComponent) container).getName();
				}
				container = container.eContainer();
			}
			// Type doesn't have a name, or a container with a name, nothing useful
			return null;
		} else
			return type.getName();
	}

	/**
	 * Return the type definition for the primitive with name xsdName (note, this is not the human-readable
	 * name, but the actual XSD type name.)  Return null if a type with this name is not in the list of
	 * all primitives
	 * @param xsdName
	 * @return
	 */
	public static XSDSimpleTypeDefinition getPrimitive(String xsdName) {
		for( XSDTypeDefinition xsdTypeDefinition : getAdvancedPrimitives() ) {
			XSDSimpleTypeDefinition next = (XSDSimpleTypeDefinition) xsdTypeDefinition;
			if(next.getName().equals(xsdName)) {
				return next;
			}
		}
		return null;
	}

	/**
	 *
	 * @return Returns a list of XSDSimpleTypeDefinitions representing each of the supported primitives.
	 * These will have their XSD spec names (e.g. xsd:dateTime) so they will likely need to be fed to
	 * getDisplayName() if they are going to be presented to humans
	 */
	public static List<XSDSimpleTypeDefinition> getPrimitives() {
		if(primitives == null) {
			primitives = new ArrayList<XSDSimpleTypeDefinition>();

			// Get the schema for schemas instance to use when resolving primitives
			XSDSchema schemaForSchemas = XSDUtil.getSchemaForSchema(XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001);

			// Start adding the simple types from the XSD short list
			for( String typeName : xsdShortList ) {
				XSDSimpleTypeDefinition type = schemaForSchemas.resolveSimpleTypeDefinition(typeName);
				primitives.add(type);
			}

			// Return primitives in alpha order
			Collections.sort(primitives, new Comparator() {

				@Override
				public int compare(Object o1, Object o2) {
					if(o1 == null || o2 == null || getDisplayNameFromXSDType((XSDTypeDefinition) o1) == null)
						return 0;
					return getDisplayNameFromXSDType((XSDTypeDefinition) o1).compareTo(getDisplayNameFromXSDType((XSDTypeDefinition) o2));
				}
			});
		}
		return primitives;
	}

	/**
	 * Return the base type from which this type inherits - that is, all xsd types are
	 * either xsd:anyType or xsd:anySimpleType at the topmost level of inheritance, so return the second
	 * topmost level of type's inheritance.  The first specific type from which type inherits.
	 * @param type
	 * @return
	 */
	public static XSDTypeDefinition getRootType(XSDTypeDefinition type) {
		if(type == null)
			return null;

		XSDTypeDefinition baseType = type.getBaseType();
		while(baseType != null && !XSDConstants.isAnySimpleType(baseType) && !XSDConstants.isAnyType(baseType)) {
			// walk one more step up the hierarchy
			type = baseType;
			baseType = type.getBaseType();
		}

		// Since baseType, type's immediate parent, broke the while condition, we know that type is now
		// as high up the tree as we want to be
		return type;
	}

	/**
	 * Return true if type is a descendant of a primitive xsd type.  Will not return true for primitives
	 * themselves.
	 * @param type
	 * @return
	 */
	public static boolean isRestrictedPrimitiveType(XSDTypeDefinition type) {
		if(type instanceof XSDComplexTypeDefinition)
			return false;

		XSDTypeDefinition baseType = getRootType(type);
		return getAdvancedPrimitives().contains(baseType);
	}

	/**
	 * Gets the "minOccurs" attribute value for the given XSDFeature, if
	 * there is none then it returns the default 1.
	 * @param xsdElem
	 * @return
	 */
	public static int getMinOccurs(XSDFeature xsdElem)
	{
		if (xsdElem.eContainer() instanceof XSDAttributeUse)
		{
			return (((XSDAttributeUse)xsdElem.eContainer()).getUse()==XSDAttributeUseCategory.REQUIRED_LITERAL?1:0);
		}

		XSDParticle particle = (XSDParticle)xsdElem.eContainer();
		int min = 1;
		if (particle.isSetMinOccurs())
			min = particle.getMinOccurs();

		return min;
	}

	/**
	 * Gets the "maxOccurs" attribute value for the given XSDFeature, if
	 * there is none then it returns the default 1.
	 * @param xsdElem
	 * @return
	 */
	public static int getMaxOccurs(XSDFeature xsdElem)
	{
		int max = 1;

		// not a particle means an attribute use.  attributes are maxed at 1.
		if ( !(xsdElem.eContainer() instanceof XSDParticle) )
			return max;

		XSDParticle particle = (XSDParticle)xsdElem.eContainer();
		if (particle.isSetMaxOccurs())
			max = particle.getMaxOccurs();

		return max;
	}

	/**
	 * Return the enclosing Complex Type definition.
	 * @param component
	 * @return
	 */
	public static XSDComplexTypeDefinition getEnclosingTypeDefinition(EObject component)
	{
		if (component == null)
			return null;

		if (component instanceof XSDComplexTypeDefinition)
			return (XSDComplexTypeDefinition)component;

		return getEnclosingTypeDefinition(component.eContainer());
	}

	/**
	 * Given an XSD complex type, return a list of the XSDFeatures (element
	 * and attribute declarations) within the complex type.
	 */
	public static List<XSDFeature> getXSDElementsAndAttributes(XSDComplexTypeDefinition complexType) {
		List<XSDFeature> result = getChildElements(complexType);
		result.addAll( getChildAttributes(complexType));

		return result;
	}
}
