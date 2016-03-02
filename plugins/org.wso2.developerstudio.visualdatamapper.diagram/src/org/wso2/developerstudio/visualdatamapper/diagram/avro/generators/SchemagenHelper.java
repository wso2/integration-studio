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

package org.wso2.developerstudio.visualdatamapper.diagram.avro.generators;

import org.wso2.developerstudio.visualdatamapper.diagram.avro.generator.util.*;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;
import com.sun.tools.xjc.model.*;
import com.sun.tools.xjc.model.nav.NType;
import com.sun.tools.xjc.outline.Aspect;
import com.sun.tools.xjc.outline.Outline;
import com.sun.xml.xsom.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.*;

/**
 */
public class SchemagenHelper {
	private static final String PARENT_FIELD = "_parent";    // name of parent field for type hierarchies
	private final Outline theOutline;
	private final Map<Class, Set<String>> specialSchemas = new HashMap<Class, Set<String>>(); // a list of special schemas to consider


	public SchemagenHelper(Outline outline) {
		theOutline = outline;
	}

	public Map<Class, Set<String>> getSpecialSchemas() {
		return specialSchemas;
	}

	// -------------------------------------------------------------------------- //

	/*
		Builds an enum type from a single enum info object. The symbol names are
		taken directly from the names of the constants.
	 */
	public NamedAvroType avroFromEnum(CEnumLeafInfo info) {
		List<String> constants = new ArrayList<String>();

		for (CEnumConstant constant : info.getConstants()) {
			constants.add(constant.getName());
		}

		AvroEnum enumType = new AvroEnum(constants);
		enumType.name = info.shortName;
		enumType.namespace = makePackageName(info.parent.getOwnerPackage());

		return enumType;
	}

	/*
		Builds a record from a single bean. Inspects properties to determine
		the fields of the record type.
	 */
	public NamedAvroType avroFromClass(CClassInfo info) {
		AvroRecord record = new AvroRecord();

		// class properties (as fields)
		for (CPropertyInfo property : info.getProperties()) {
			AvroType field = avroFromProperty(property, info.getOwnerPackage());
			record.addField(property.getName(false), field, field.getDefaultValue());
		}

		// super class reference (also as a field)
		CClassInfo parent = info.getBaseClass();
		if (parent != null) {
			String name = makePackageName(parent.getOwnerPackage()) + "." + parent.getSqueezedName();
			record.addField(PARENT_FIELD, new DummyAvroType(name), null);
		}

		record.name = info.getSqueezedName();
		record.namespace = makePackageName(info.getOwnerPackage());
		return record;
	}

	/*
		Determine the best fit for a single property.
	 */
	private AvroType avroFromProperty(CPropertyInfo info, JPackage _package) {
		// collections
		if (info.isCollection()) {
			List<AvroType> elements = new ArrayList<AvroType>();

			// for every type in the collection
			for (CTypeInfo typeInfo : info.ref()) {
				elements.add(avroFromProperty(info, typeInfo.getType(), _package, false));
			}

			AvroType type;

			if (elements.size() == 1) {
				type = new AvroArray(elements.get(0));
			} else {
				type = new AvroArray(new AvroUnion(elements));
			}

			if (!isPropertyRequired(info)) {
				type = new AvroUnion(AvroPrimitive.NULL_TYPE, type);
			}

			return type;

		// single elements
		} else {
			assertThat(info.ref().size() == 1, "can't handle multiple refs here");
			NType type = info.ref().iterator().next().getType();
			return avroFromProperty(info, type, _package, true);
		}
	}

	private AvroType avroFromProperty(CPropertyInfo info, NType type, JPackage _package, boolean unionNull) {
		AvroType returnType = avroFromType(type, _package);
		String defaultValue = extractDefaultValue(info.getSchemaComponent());

		if (!isPropertyRequired(info) && unionNull) {
			if (returnType instanceof AvroUnion) {
				throw new SchemagenException("nested unions are not allowed");
			}

			returnType = new AvroUnion(AvroPrimitive.PrimitiveType.NULL.newInstance(), returnType);
			if (defaultValue == null) { defaultValue = AvroPrimitive.PrimitiveType.NULL.defaultValue; }
		}

		if (defaultValue != null) {
			returnType.setDefaultValue(defaultValue);
		}

		return returnType;
	}

	private String extractDefaultValue(XSComponent component) {
		XmlString defaultValue = null, fixedValue = null;

		// transform attribute use to declaration
		if (component instanceof XSAttributeUse) {
			XSAttributeUse attribute = (XSAttributeUse) component;
			component = attribute.getDecl();
		}

		if (component instanceof XSAttributeDecl) {
			XSAttributeDecl attribute = (XSAttributeDecl) component;
			defaultValue = attribute.getDefaultValue();
			fixedValue = attribute.getFixedValue();
		} else if (component instanceof XSElementDecl) {
			XSElementDecl element = (XSElementDecl) component;
			defaultValue = element.getDefaultValue();
			fixedValue = element.getFixedValue();
		}

		if (defaultValue != null && fixedValue != null) {
			throw new SchemagenException(
				"schema elements should either contain a fixed or a default value, but not both"
			);
		} else if (defaultValue != null) {
			return defaultValue.value;
		} else if (fixedValue != null) {
			return fixedValue.value;
		} else {
			return null;
		}
	}

	/*
		Given a type, try to find a good Avro schema type which will apply.
		For primitives and generated objects, this work is fairly straightforward.
		For reference types, special types, and other cases, a best guess is
		made.
	 */
	private AvroType avroFromType(NType type, JPackage _package) {
		AvroType returnType;
		JType implType = type.toType(theOutline, Aspect.IMPLEMENTATION);

		// arrays
		if (implType.isArray()) {
			JType elementType = implType.elementType();
			throw new SchemagenException("arrays are not yet supported");

		// primitives
		} else if (implType.isPrimitive()) {
			returnType = AvroPrimitive.fromType(implType.name());

		// might be a boxed primitive
		} else if (type.isBoxedType()) {
			returnType =  AvroPrimitive.fromType(implType.unboxify().name());

		// might be a String, which is special
		} else if ("java.lang.String".equals(type.fullName())) {
			returnType = AvroPrimitive.fromType("string");

		// might be an Object, in which case it's assumed to be a reference
		} else if ("java.lang.Object".equals(type.fullName())) {
			String pName = makePackageName(_package);
			returnType = new ReferenceAvroType(pName);
			specialSchemas.get(ReferenceAvroType.class).add(pName);

		} else {
			// a generated class
			if (type instanceof CClassInfo) {
				CClassInfo classInfo = (CClassInfo) type;
				String name = makePackageName(classInfo.getOwnerPackage()) + "." + classInfo.getSqueezedName();
				returnType = new DummyAvroType(name);

			// a generated enum
			} else if (type instanceof CEnumLeafInfo) {
				CEnumLeafInfo enumInfo = (CEnumLeafInfo) type;
				String name = makePackageName(enumInfo.parent.getOwnerPackage()) + "." + enumInfo.shortName;
				returnType = new DummyAvroType(name);

			// a reference type (most likely)
			} else if (type instanceof CElementInfo) {
				CElementInfo elemInfo = (CElementInfo) type;

				if ("javax.xml.bind.JAXBElement<java.lang.Object>".equals(elemInfo.fullName())) {
					String pName = makePackageName(_package);
					returnType = new ReferenceAvroType(pName);
					specialSchemas.get(ReferenceAvroType.class).add(pName);
				} else {
					throw new SchemagenException("unknown element type: " + type.fullName());
				}

			// some other defined class, but not generated
			} else if (implType instanceof JClass) {
				returnType = avroFromSpecialTypes((JClass) implType, _package);

				if (returnType == null) {
					throw new SchemagenException("Unable to handle defined type '"+ type.fullName() +"'.");
				}

			// give up  :(
			} else {
				throw new SchemagenException("can't handle this type! " + type.fullName());
			}
		}

		return returnType;
	}

	/*
		We know about some special types, but these are very dependent on how JAXB
		interprets XML types such as xs:date. Again, we make a best guess before
		giving up.
	 */
	private AvroType avroFromSpecialTypes(JClass clazz, JPackage _package) {
		String pName = makePackageName(_package);

		if (clazz.isAssignableFrom(clazz.owner().ref(XMLGregorianCalendar.class))) {
			specialSchemas.get(DateAvroType.class).add(pName);
			return new DateAvroType(pName);
		}

		if (clazz.isAssignableFrom(clazz.owner().ref(BigInteger.class))) {
			return AvroPrimitive.PrimitiveType.STRING.newInstance();
		}

		return null;
	}

	/**
	 * Try to figure out if the property is required.
	 * We know about some subclasses which retain this information, so when
	 * possible we get the real answer. Otherwise we play it safe and say that
	 * it is likely required. Note that even though an attribute like an xs:IDREF
	 * may be required in practice, if it is not explicitly set to 'required=true'
	 * then it may not register as actually being required.
	 *
	 * @param info a property info object to test
	 * @return property.isRequired() where available, otherwise true
	 */
	private boolean isPropertyRequired(CPropertyInfo info) {
		if (info.isOptionalPrimitive()) {
			return false;
		}

		if (info instanceof CElementPropertyInfo) {
			CElementPropertyInfo _info = (CElementPropertyInfo) info;
			return _info.isRequired();
		}

		if (info instanceof CAttributePropertyInfo) {
			CAttributePropertyInfo _info = (CAttributePropertyInfo) info;
			return _info.isRequired();
		}

		if (info instanceof CReferencePropertyInfo) {
			CReferencePropertyInfo _info = (CReferencePropertyInfo) info;
			return _info.isRequired();
		}

		//throw new RuntimeException("Can't handle property type '" + info.getClass() + "'.");
		return true;

		// TODO what about ID's? (nb they *should* be marked required, but is that really our problem?)
	}


	/**
	 * Make the 'standard' package name from any existing name.
	 * The current behavior is simply to add ".avro" to existing
	 * package names to create subpackages.
	 *
	 * @param _package the base package
	 * @return base package name + custom subpackage
	 */
	private static String makePackageName(JPackage _package) {
		String front = _package.name();
		if (front.trim().isEmpty())
			return "avro";
		else
			return front + ".avro";
	}

	/// ----------------- simple assertion handling ------------------------ //

	private static void assertThat(boolean condition, String message) {
		if (!condition) {
			throw new SchemagenException(message);
		}
	}

	private static void assertThat(boolean condition) {
		assertThat(condition, "assertion failure");
	}
}
