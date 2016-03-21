/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDAttributeGroupDefinition;
import org.eclipse.xsd.XSDAttributeUse;
import org.eclipse.xsd.XSDAttributeUseCategory;
import org.eclipse.xsd.XSDComplexTypeContent;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDConstraint;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFeature;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDModelGroupDefinition;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDParticleContent;
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
	
		
	private static List<XSDSimpleTypeDefinition> advancedPrimitives = new ArrayList<XSDSimpleTypeDefinition> ();
	private static final AtomicBoolean advancedPrimitiveWasSet = new AtomicBoolean( false );
	
	
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
		supportedPrimitives.add("NMTOKENS"); //$NON-NLS-1$
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
	 * Like getPrimitives(), this returns a list of XSDSimpleTypeDefinition.  However where getPrimitives() 
	 * returns the basic set supported by the editor, getAdvancedPrimitives returns every known XSD
	 * primitive type.
	 * 
	 * @return list of simple type definitions.
	 */
	public static List<XSDSimpleTypeDefinition> getAdvancedPrimitives() {
		
		// (VZ) FIXME: use a singleton instance of a set of static methods
		if( ! advancedPrimitiveWasSet.get()) {
		
			// Get the schema for schemas instance to use when resolving primitives
			XSDSchema schemaForSchemas = XSDUtil.getSchemaForSchema(XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001);
			
			// Start adding the simple types using the supportedPrimitives list
			for(String typeName : supportedPrimitives) {
				XSDSimpleTypeDefinition type = schemaForSchemas.resolveSimpleTypeDefinition(typeName);
				advancedPrimitives.add(type);
			}

			// Return primitives in alpha order
			Collections.sort(advancedPrimitives, new Comparator<XSDSimpleTypeDefinition>() {
				public int compare(XSDSimpleTypeDefinition o1, XSDSimpleTypeDefinition o2) {
					if(o1 == null || o2 == null || o1.getName() == null)
						return 0;
					return o1.getName().compareToIgnoreCase(o2.getName());
				}
			});
			
			advancedPrimitiveWasSet.set( true );
		}
		
		return advancedPrimitives;		
	}
	
	/**
	 * Retrieves all the root Data types defined in the schema including complex types, user-defined simple types and anonymous
	 * complex types.  If there's an anonymous complex type definition (from a root element declaration) then we return
	 * the element declaration's anonymous type.
	 * @param schema
	 * @return list of type definitions.
	 */
	
	public static List<XSDTypeDefinition> getAllDataTypes(XSDSchema schema)
	{
		if (schema==null) {
			return Collections.emptyList();
		}
		
		List<XSDTypeDefinition> bos = new ArrayList<XSDTypeDefinition>();
		        
        for (Object item : schema.getContents()) {
			if (item instanceof XSDTypeDefinition) {
				bos.add( (XSDTypeDefinition) item);
			} else if (item instanceof XSDElementDeclaration) {
				XSDElementDeclaration element = (XSDElementDeclaration) item;
				if (element.getAnonymousTypeDefinition() instanceof XSDComplexTypeDefinition) {
					bos.add(element.getAnonymousTypeDefinition());
				}
			}
		}        
		return bos;
	}
	
	/**
	 * Given a BO (XSD Complex Type), return a list of the attributes 
	 * within the complexType.
	 * @param bo
	 * @return List of XSDAttributeDeclaration
	 */
	public static List<XSDAttributeDeclaration> getChildAttributes (XSDComplexTypeDefinition bo)
	{
		EList attrContents = bo.getAttributeContents();
		List<XSDAttributeDeclaration> attrs = new ArrayList<XSDAttributeDeclaration>();
		
		for (int i=0; i< attrContents.size(); i++)
		{
			Object next = attrContents.get(i);
			
			// Attribute contents may include actual attribute declarations (wrapped in XSDAttributeUses) or
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
	 * within the complexType's modelGroup (sequence, choice, etc.)
	 * @param bo
	 * @return list of features
	 */
	public static List<XSDParticleContent> getChildElements (XSDComplexTypeDefinition bo) 
	{
		List<XSDParticleContent> children = new ArrayList<XSDParticleContent>();
		children.addAll(getChildElements(getModelGroup(bo)));
		if(bo.getBaseTypeDefinition() instanceof XSDComplexTypeDefinition){
			children.addAll(getChildElements(getModelGroup((XSDComplexTypeDefinition)bo.getBaseTypeDefinition())));		}
		return children;
	}

	/**
	 * Given an XSDFeature, return a list of the XSDFeatures 
	 * within the complexType's modelGroup (sequence, choice, etc.)
	 * @param elem
	 * @return list of the XSDFeatures within the complexType's modelGroup
	 */
	public static List<XSDParticleContent> getChildElements(XSDFeature elem) 
	{
		XSDComplexTypeDefinition cType = getResolvedComplexType(elem);
		if (cType != null) {
			return getChildElements(cType);
		}
		return Collections.emptyList();		
	}
	
	
	/**
	 * Given a Model group, return a list of the XSDFeatures 
	 * declared within.
	 * @param group
	 * @return  the child elements.
	 */
	
	public static List<XSDParticleContent> getChildElements (XSDModelGroup group) 
	{
    	if(group == null) {
    		return new ArrayList<XSDParticleContent>();
    	}
    	
		List<XSDParticleContent> children = new ArrayList<XSDParticleContent>();
		
		for (XSDParticle next : group.getContents() ) {			
    		if(next.getContent() instanceof XSDFeature) {
    			children.add(next.getContent());
    		} else if (next.getTerm() instanceof XSDModelGroup) {
    			children.addAll(getChildElements((XSDModelGroup) next.getTerm()));
    		}
		}		
    	return children;
	}
	

	/**
	 * Given an XSD Complex Type Definition, return the model group containing
	 * its child elements. 
	 * @param cType
	 * @return the model group
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
	 * Return the type definition for the primitive with name xsdName (note, this is not the human-readable 
	 * name, but the actual XSD type name.)  Return null if a type with this name is not in the list of 
	 * all primitives
	 * @param xsdName
	 * @return the simple type definition with the given xsdName
	 */
	public static XSDSimpleTypeDefinition getPrimitive(String xsdName) {
		for(XSDSimpleTypeDefinition next : getAdvancedPrimitives() ) {
			if(next.getName().equals(xsdName)) {
				return next; 
			}
		}
		return null;
	}
	
	/**
	 * Return a collection of all types referenced by the attributes (XSDFeatures) of source.  This
	 * method is non-recursive (i.e. the list only contains direct references, not references-of-references)
	 * Will not return null, but may return an empty set.  This will not return a BO reference if the file
	 * has been deleted (or just doesn't exist).  
	 * @param source  The complex type to examine for references
	 * @return a Collection of XSDComplexTypeDefinition instances -- no duplicates
	 */
	public static Collection<XSDTypeDefinition> getReferencedTypes(XSDComplexTypeDefinition source) {
		
		if(source == null) {
			return Collections.emptySet();
		}
		
		List<XSDTypeDefinition> results = new ArrayList<XSDTypeDefinition>();
		XSDFeature element = null;
		XSDComplexTypeDefinition elementType = null;
		for(Iterator<XSDParticleContent> i = getChildElements(source).iterator(); i.hasNext(); ) {
			element = (XSDFeature) i.next();
			elementType = getResolvedComplexType(element); 
			if(elementType != null && !results.contains(elementType) && !XSDConstants.isSchemaForSchemaNamespace(elementType.getTargetNamespace()))
				results.add(elementType);
		}
		return results;
	}

	/**
	 * Return a collection of all types referenced by the attributes (XSDFeatures) of source.  This
	 * method is non-recursive (i.e. the list only contains direct references, not references-of-references)
	 * Will not return null, but may return an empty set.  This will return a BO reference if the file
	 * has been deleted (or just doesn't exist).  
	 * @param source  The complex type to examine for references
	 * @return a Collection of XSDTypeDefinition (could be complex or simple type) instances -- no duplicates
	 */
	public static Collection<XSDTypeDefinition> getAllReferencedTypes(XSDComplexTypeDefinition source)
	{
		return getAllReferencedTypes(source, false);
	}

	/**
	 * Return a collection of all types referenced by the attributes (XSDFeatures) of source.  This
	 * method is non-recursive (i.e. the list only contains direct references, not references-of-references)
	 * Will not return null, but may return an empty set.  This will return a BO reference if the file
	 * has been deleted (or just doesn't exist).  
	 * @param source  The complex type to examine for references
	 * @param includeAnonymous if true, the returned list will include anonymous inlined types as well.  These
	 * are not technically "referenced", however it allows this method to be used as a way to get all non-primitive
	 * types used in any way by source 
	 * @return a Collection of XSDTypeDefinition (could be complex or simple type) instances -- no duplicates
	 */
	public static Collection<XSDTypeDefinition> getAllReferencedTypes(XSDComplexTypeDefinition source, boolean includeAnonymous)
	{
		if (source == null) {
			return Collections.emptySet();
		}

		List<XSDTypeDefinition> results = new ArrayList<XSDTypeDefinition>();
		XSDTypeDefinition elementType = null;
		for (Iterator<XSDParticleContent> i = getChildElements(source).iterator(); i.hasNext();)
		{
			XSDFeature next = (XSDFeature) i.next();
			elementType = getResolvedType(next);
			
			// Only add non-null, non-duplicate, non-primitive types.  If includeAnonymous is false, 
			// anonymous types should be filtered out as well
			if(	elementType != null && 
				!results.contains(elementType) && 
				!XSDConstants.isSchemaForSchemaNamespace(elementType.getTargetNamespace()) &&
				(includeAnonymous || elementType.eContainer() != next) ) {				
					results.add(elementType);
			}
		}
		return results;
	}

	/**
	 * Given an element, return its complex type, or null if it does not have a complex type.  This is 
	 * slightly more complicated than just calling getType() since an element may not have a type at all, it
	 * may reference another element.
	 * @param feature 
	 * 
	 * @return the complex type of the element (if any) 
	 */
	public static XSDComplexTypeDefinition getResolvedComplexType(XSDFeature feature) {
		// The contents of this method have been adapted to the more general getResolvedType,
		// but this method is maintained for compatibility and convenience 
		XSDTypeDefinition resolvedType = getResolvedType(feature);
		if(resolvedType instanceof XSDComplexTypeDefinition)
			return (XSDComplexTypeDefinition) resolvedType;
		return null;
	}

	/**
	 * Given an element, return its type, or null if it does not have a type.  This is 
	 * slightly more complicated than just calling getType() since an element may not have 
	 * a type at all, it may reference another element.
	 * @param feature
	 * @return the type of the element
	 */
	public static XSDTypeDefinition getResolvedType(XSDFeature feature) {
						
		// Special case of elements referencing stale XSD complex types
		if (feature instanceof XSDElementDeclaration && ((XSDElementDeclaration) feature).getTypeDefinition() instanceof XSDComplexTypeDefinition) {
			
			XSDElementDeclaration element = (XSDElementDeclaration) feature;

			// We have a type, but types can be proxies, and proxies can become
			// stale if the referenced
			// type changes, so before we return it, re-resolve the proxy and
			// then return it
			XSDComplexTypeDefinition oldType = (XSDComplexTypeDefinition) element.getTypeDefinition();
			EObject newType = EcoreUtil.resolve(element.getTypeDefinition(), element);
			if (oldType != newType) {
			    // We only return the resolved type if the name and the namespace has not changed.  Changing the name
			    // and namespace is essentially an unresolved BO.
			    String oldName = oldType.getName();
			    String newName = ((XSDTypeDefinition)newType).getName();
			    String oldTNS = oldType.getTargetNamespace();
			    String newTNS = ((XSDTypeDefinition)newType).getTargetNamespace();
			    
			    if ( ((oldName==newName) || (oldName!=null && oldName.equals(newName))) &&
			          ((oldTNS==newTNS) || (oldTNS!=null && oldTNS.equals(newTNS)))  )
			        element.setTypeDefinition((XSDTypeDefinition) newType);
			}
			return element.getTypeDefinition();

		} else if (feature.getType() != null) {
			return feature.getType();
		} else if (feature.getResolvedFeature() != null && feature.getResolvedFeature().getType() != null) {
			// We reference another element
			return feature.getResolvedFeature().getType();
		} else {
			return null;
		}
	}
	
	/**
	 * Return the base type from which this type inherits - that is, all xsd types are
	 * either xsd:anyType or xsd:anySimpleType at the topmost level of inheritance, so return the second
	 * topmost level of type's inheritance.  The first specific type from which type inherits. 
	 * @param type
	 * @return the root type definition
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
	 * Given a schema, return the list of XSDSimpleTypeDefinitions found within it.  Will not return null,
	 * but may return an empty list
	 * @param schema
	 * @return the user defined simple types.
	 */
	
	public static List<XSDSimpleTypeDefinition> getUserDefinedSimpleTypes(XSDSchema schema) {
		if(schema == null) {
			return Collections.emptyList();
		}
		
		List<XSDSimpleTypeDefinition> result = new ArrayList<XSDSimpleTypeDefinition>();
		for(Object next : schema.getContents()) {			
			if(next instanceof XSDSimpleTypeDefinition)
				result.add((XSDSimpleTypeDefinition) next);
		}
		return result;
	}
	
	
	
	/**
	 * Return true if type is a descendant of a primitive xsd type.  Will not return true for primitives
	 * themselves.
	 * @param type
	 * @return if type is a descendant of a primitive XSD type.
	 */
	
	public static boolean isRestrictedPrimitiveType(XSDTypeDefinition type) {
		if(type instanceof XSDComplexTypeDefinition) {
			return false;
		}
		
		XSDTypeDefinition baseType = getRootType(type);
		return getAdvancedPrimitives().contains(baseType);
	}
	
	/**
	 * Gets the "minOccurs" attribute value for the given XSDFeature, if
	 * there is none then it returns the default 1.
	 * @param xsdElem
	 * @return min occurs 
	 */
	public static int getMinOccurs (XSDFeature xsdElem)
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
	 * @return max occurs
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
	
	static final String EMPTY_STRING = ""; //$NON-NLS-1$
	
	/**
	 * Gets the "default" attribute value for the given XSDFeature, if there
	 * is none then it returns an empty string.
	 * @param xsdElem
	 * @return the default value string
	 */
	public static String getDefaultValue(XSDFeature xsdElem)
	{
		XSDConstraint constraint = null;
		if (xsdElem instanceof XSDAttributeDeclaration)
		{
			// attribute declarations store their default values in
			// their containers (attribute uses)
			XSDAttributeUse use = (XSDAttributeUse)xsdElem.getContainer();
			if (use.isSetConstraint()) {
				constraint = use.getConstraint();
			}
			
			if (constraint!=null && constraint.equals(XSDConstraint.DEFAULT_LITERAL)) {
				if (use.getLexicalValue()!=null) {
					return use.getLexicalValue();
				}
				return EMPTY_STRING; 
			}
		}
		else if (xsdElem instanceof XSDElementDeclaration)
		{
			if (xsdElem.isSetConstraint())
				constraint = xsdElem.getConstraint();
			
			if (constraint!=null && constraint.equals(XSDConstraint.DEFAULT_LITERAL)) {
				if (xsdElem.getLexicalValue()!=null) {
					return xsdElem.getLexicalValue();
				}
				return EMPTY_STRING;
			}
		}
		
		return EMPTY_STRING;
	}
	
	/**
	 * Return the enclosing Complex Type definition.
	 * @param component
	 * @return Return the enclosing Complex Type definition.
	 */
	public static XSDComplexTypeDefinition getEnclosingTypeDefinition(EObject component)
	{
		if (component == null) {
			return null;
		}
		
		if (component instanceof XSDComplexTypeDefinition)
			return (XSDComplexTypeDefinition)component;

		return getEnclosingTypeDefinition(component.eContainer());
	}
			
}
