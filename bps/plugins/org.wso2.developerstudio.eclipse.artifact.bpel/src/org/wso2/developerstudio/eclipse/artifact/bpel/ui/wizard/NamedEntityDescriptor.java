/*
  * Copyright 2010 - 2015 WSO2, Inc. (http://wso2.com)
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
 package org.wso2.developerstudio.eclipse.artifact.bpel.ui.wizard;
 
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 
 /**
  * Utility class for describing named entities that can be targetted from key
  * references.
  */
 public class NamedEntityDescriptor {
 	/**
 	 * Descriptor literal pattern.
 	 */
 	private static final Pattern descriptorPattern = Pattern.compile("(.*)\\[([^\\]]* )\\]");
 
 	/**
 	 * Entity name.
 	 */
 	private String name;
 
 	/**
 	 * Entity type.
 	 */
 	private NamedEntityType type;
 
 	/**
 	 * Identifies the named entity type.
 	 */
 	public enum NamedEntityType {
 		/**
 		 * Sequence.
 		 */
 		SEQUENCE("sequence"),
 
 		/**
 		 * Endpoint.
 		 */
 		ENDPOINT("endpoint"),
 
 		/**
 		 * Proxy service.
 		 */
 		PROXY_SERVICE("proxy-service"),
 
 		/**
 		 * Local entry.
 		 */
 		LOCAL_ENTRY("local-entry");
 
 		/**
 		 * Array of enum constants.
 		 */
 		private static final NamedEntityType[] values = new NamedEntityType[] { SEQUENCE, ENDPOINT,
 		                                                                       PROXY_SERVICE,
 		                                                                       LOCAL_ENTRY, };
 
 		/**
 		 * Quantifier used to identify the entity type.
 		 */
 		private String quantifier;
 
 		/**
 		 * {@link NamedEntityType} enum constructor.
 		 * 
 		 * @param quantifier
 		 *            string used to identify the entity type.
 		 */
 		private NamedEntityType(String quantifier) {
 			this.quantifier = quantifier;
 		}
 
 		/**
 		 * @return the quantifier.
 		 */
 		public String getQuantifier() {
 			return quantifier;
 		}
 
 		/**
 		 * {@inheritDoc}
 		 */
 		public String toString() {
 			return getQuantifier();
 		}
 
 		/**
 		 * Utility method for constructing a {@link NamedEntityType} from a
 		 * quantifier string.
 		 * 
 		 * @param quantifier
 		 *            quantifier string.
 		 * @return a {@link NamedEntityType} corresponding to the specified
 		 *         quantifier string or null.
 		 */
 		public static NamedEntityType get(String quantifier) {
 			for (int i = 0; i < values.length; i ++) {
 				if (values[i].getQuantifier().equals(quantifier)) {
 					return values[i];
 				}
 			}
 			return null;
 		}
 	}
 
 	/**
 	 * Creates a new {@link NamedEntityDescriptor} instance.
 	 * 
 	 * @param name
 	 *            entity name.
 	 * @param type
 	 *            entity type.
 	 */
 	public NamedEntityDescriptor(String name, NamedEntityType type) {
 		this.name = name;
 		this.type = type;
 	}
 
 	/**
 	 * @return entity name.
 	 */
 	public String getName() {
 		return name;
 	}
 
 	/**
 	 * @return entity type.
 	 */
 	public NamedEntityType getType() {
 		return type;
 	}
 
 	/**
 	 * {@inheritDoc}
 	 */
 	public String toString() {
 		return String.format("%s [%s]", getName(), getType());
 	}
 
 	/**
 	 * Utility method for constructing a {@link NamedEntityDescriptor} from the
 	 * corresponding string literal.
 	 * 
 	 * @param descriptorString
 	 *            descriptor literal string.
 	 * @return {@link NamedEntityDescriptor} corresponding to the input string
 	 *         or null.
 	 */
 	public static NamedEntityDescriptor fromString(String descriptorString) {
 		Matcher matcher = descriptorPattern.matcher(descriptorString);
 		if (matcher.matches()) {
 			String nameString = matcher.group(1);
 			String typeString = matcher.group(2);
 			NamedEntityType entityType = NamedEntityType.get(typeString);
 			if (null != entityType) {
 				return new NamedEntityDescriptor(nameString, entityType);
 			}
 		}
 		return null;
 	}
 }