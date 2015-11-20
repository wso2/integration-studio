/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Topic Filter From Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTopicFilterFromType()
 * @model
 * @generated
 */
public enum TopicFilterFromType implements Enumerator {
	/**
	 * The '<em><b>Filter From Whitelist</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILTER_FROM_WHITELIST_VALUE
	 * @generated
	 * @ordered
	 */
	FILTER_FROM_WHITELIST(0, "filterFromWhitelist", "filter.from.whitelist"),

	/**
	 * The '<em><b>Filter From Blacklist</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILTER_FROM_BLACKLIST_VALUE
	 * @generated
	 * @ordered
	 */
	FILTER_FROM_BLACKLIST(1, "filterFromBlacklist", "filter.from.blacklist");

	/**
	 * The '<em><b>Filter From Whitelist</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Filter From Whitelist</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILTER_FROM_WHITELIST
	 * @model name="filterFromWhitelist" literal="filter.from.whitelist"
	 * @generated
	 * @ordered
	 */
	public static final int FILTER_FROM_WHITELIST_VALUE = 0;

	/**
	 * The '<em><b>Filter From Blacklist</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Filter From Blacklist</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILTER_FROM_BLACKLIST
	 * @model name="filterFromBlacklist" literal="filter.from.blacklist"
	 * @generated
	 * @ordered
	 */
	public static final int FILTER_FROM_BLACKLIST_VALUE = 1;

	/**
	 * An array of all the '<em><b>Topic Filter From Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TopicFilterFromType[] VALUES_ARRAY =
		new TopicFilterFromType[] {
			FILTER_FROM_WHITELIST,
			FILTER_FROM_BLACKLIST,
		};

	/**
	 * A public read-only list of all the '<em><b>Topic Filter From Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TopicFilterFromType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Topic Filter From Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TopicFilterFromType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TopicFilterFromType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Topic Filter From Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TopicFilterFromType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TopicFilterFromType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Topic Filter From Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TopicFilterFromType get(int value) {
		switch (value) {
			case FILTER_FROM_WHITELIST_VALUE: return FILTER_FROM_WHITELIST;
			case FILTER_FROM_BLACKLIST_VALUE: return FILTER_FROM_BLACKLIST;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TopicFilterFromType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TopicFilterFromType
