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

package org.wso2.integrationstudio.visualdatamapper.diagram.avro.generators;

import org.wso2.integrationstudio.visualdatamapper.diagram.avro.generator.util.AvroType;
import org.wso2.integrationstudio.visualdatamapper.diagram.avro.generator.util.NamedAvroType;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.fmt.JTextFile;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.Plugin;
import com.sun.tools.xjc.model.CClassInfo;
import com.sun.tools.xjc.model.CEnumLeafInfo;
import com.sun.tools.xjc.model.Model;
import com.sun.tools.xjc.model.nav.NClass;
import com.sun.tools.xjc.outline.Outline;
import com.sun.tools.xjc.outline.PackageOutline;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.ObjectMapper;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 *          XJC plugin which walks the generated code model and creates a
 *          parallel Avro schema. Running the plugin requires making sure that
 *          XJC can see this compiled class at runtime when it is identifying
 *          plugins.
 *
 *          As well, a special META-INF file called 'com'sun.tools.xjc.Plugin'
 *          must be created with a reference to this plugin class. This is how
 *          XJC detects new plugin services at runtime.
 *
 *
 *          TODO maybe switch to IDL format instead of individual schemas.
 */
public class AvroSchemagenPlugin extends Plugin {
	public static final String PLUGIN_NAME = "XavroSchemagen";
	private static final String OUTPUT_DIRECTORY = "avroSchemas";
	public static final String AVRO_NAMESPACE_APPEND = ".avro";
	public static final String XSD_NAESPACE_PARAM = "targetNamespace";
	protected static ObjectMapper mapper = new ObjectMapper();
	private SchemagenHelper helper;
	private static String finalOutput;
	static {
		// don't auto detect anything that we haven't annotated
		mapper.setVisibilityChecker(mapper.getVisibilityChecker().with(
				JsonAutoDetect.Visibility.NONE));
	}

	/**
	 * Returns the directory which the schemas have been written to.
	 *
	 * @param outputDirectory
	 *            base directory of the output
	 * @return the schema directory, relative to the base output directory
	 */
	public static File getSchemaDirectory(File outputDirectory) {
		return new File(outputDirectory.getAbsoluteFile() + File.separator
				+ OUTPUT_DIRECTORY);
	}

	/*
	 * XJC run method.
	 */
	@Override
	public boolean run(Outline outline, Options options,
			ErrorHandler errorHandler) throws SAXException {
		helper = new SchemagenHelper(outline);

		// set up special schemas
		helper.getSpecialSchemas().put(ReferenceAvroType.class,
				new HashSet<String>());
		helper.getSpecialSchemas().put(DateAvroType.class,
				new HashSet<String>());

		// do the work
		inferAvroSchema(outline);

		// true because we're done and processing should continue
		return true;
	}

	/*
	 * Infer schemas from enums and beans, then generate the files.
	 */
	private void inferAvroSchema(Outline outline) {
		Model model = outline.getModel();
		Set<NamedAvroType> avroTypes = new HashSet<NamedAvroType>();

		// enums
		for (Map.Entry<NClass, CEnumLeafInfo> entry : model.enums().entrySet()) {
			CEnumLeafInfo info = entry.getValue();
			NamedAvroType type = helper.avroFromEnum(info);
			avroTypes.add(type);
		}

		// regular classes
		for (Map.Entry<NClass, CClassInfo> entry : model.beans().entrySet()) {
			CClassInfo info = entry.getValue();
			NamedAvroType type = helper.avroFromClass(info);
			avroTypes.add(type);
		}

		// grab a package context, write the schemas
		PackageOutline aPackage = outline.getAllPackageContexts().iterator()
				.next();
		JPackage rootPackage = aPackage._package().owner().rootPackage();
		generateAvroSchemas(rootPackage, avroTypes);
	}

	/*
	 * Generate the actual Avro schemas and write to file system. Checks for
	 * name collisions, sorts by dependencies, writes out schema files, special
	 * schemas, and debug summary information.
	 */
	private void generateAvroSchemas(JPackage rootPackage,
			Set<NamedAvroType> avroTypes) {
		JPackage avroPackage = rootPackage.subPackage("avroSchemas");

		// check for name collisions
		checkForCollisions(avroTypes);

		// sort results by dependency
		List<NamedAvroType> orderedTypes = topologicalSort(avroTypes);

		// add in special types
		for (String ns : helper.getSpecialSchemas().get(DateAvroType.class)) {
			orderedTypes.add(0, DateAvroType.getSchema(ns));
		}

		for (String ns : helper.getSpecialSchemas()
				.get(ReferenceAvroType.class)) {
			orderedTypes.add(0, ReferenceAvroType.getSchema(ns));
		}

		// output in an ordered way
		outputSchema(avroPackage, orderedTypes);

		// output debug summary
		JTextFile avroSchema = new JTextFile("avroSchemas.json");
		StringBuilder sb = new StringBuilder();

		int objectSize = orderedTypes.size();

		String rootNode = getJson(orderedTypes.get(objectSize - 1));

		int index = 2;
		while (objectSize - index >= 0) {
			int currIndex = objectSize - index;
			NamedAvroType avroElem = orderedTypes.get(currIndex);

			String nameSpacename = avroElem.namespace.toString() + "."
					+ avroElem.name.toString();
			String stringToReplace = "\"" + nameSpacename + "\"";

			if (rootNode.contains(stringToReplace)) {
				rootNode = rootNode.replace(stringToReplace, getJson(avroElem));

			}
			index = index + 1;

		}
		finalOutput = rootNode;
		sb.append(rootNode);

		avroSchema.setContents(sb.toString());
		rootPackage.addResourceFile(avroSchema);
	}

	/*
	 * Checks for collisions with type names.
	 * 
	 * TODO can be made more specific by checking names per namespace rather
	 * than globally.
	 */
	private void checkForCollisions(Set<NamedAvroType> types) {
		Set<String> names = new HashSet<String>();

		for (NamedAvroType type : types) {
			String name = type.name;

			if (names.contains(name)) {
				throw new SchemagenException(
						"Duplicate type names found under '" + name + "'!");
			}

			names.add(name);
		}
	}

	/*
	 * Dependency sort, done via a standard topological sort. As types are
	 * encountered for the first time, they are stubbed, with the assumption
	 * that they will come up later.
	 * 
	 * TODO Though circular references shouldn't be possible, it might be good
	 * to check.
	 */
	private List<NamedAvroType> topologicalSort(Set<NamedAvroType> types) {
		Map<String, Node> nodesByName = new HashMap<String, Node>();

		for (NamedAvroType type : types) {
			String typeName = type.namespace + "." + type.name;
			Node node = nodesByName.get(typeName);

			// create if not present
			if (node == null) {
				node = new Node(type);
				nodesByName.put(typeName, node);

				// stub needs its type set
			} else {
				node.type = type;
			}

			for (String dependentType : type.getDependencies()) {
				Node dependent = nodesByName.get(dependentType);

				// stub
				if (dependent == null) {
					dependent = new Node(null);
					nodesByName.put(dependentType, dependent);
				}

				// create the dependency
				node.parents.add(dependent);
				dependent.children.add(node);
			}
		}

		// turn into an ordered list
		Set<Node> allNodes = new HashSet<Node>(nodesByName.values());
		List<NamedAvroType> sequence = new ArrayList<NamedAvroType>();

		while (!allNodes.isEmpty()) {
			Set<Node> removals = new HashSet<Node>();

			for (Node node : allNodes) {
				if (node.parents.isEmpty()) {
					sequence.add(node.type);

					for (Node child : node.children) {
						child.parents.remove(node);
					}

					removals.add(node);
				}
			}

			allNodes.removeAll(removals);
		}

		return sequence;
	}

	/*
	 * Write the actual schema files. Uses a counter to keep files ordered on
	 * the filesystem, using 0 prefixes where necessary to guarantee ordering.
	 */
	private void outputSchema(JPackage avroPackage, List<NamedAvroType> types) {
		// set up the correct format for leading zeros (ensures proper order in
		// filesystem)
		StringBuilder digits = new StringBuilder();
		for (int i = 0; i < Integer.toString(types.size()).length(); ++i) {
			digits.append("0");
		}

		DecimalFormat format = new java.text.DecimalFormat(digits.toString());
		AtomicInteger counter = new AtomicInteger(1);

		for (NamedAvroType type : types) {
			String id = format.format(counter.getAndIncrement());
			JTextFile avroSchema = new JTextFile("avroSchema-" + id + "_"
					+ type.name + ".txt");
			avroSchema.setContents(getJson(type));
			avroPackage.addResourceFile(avroSchema);
		}
	}

	/**
	 * Use the Jackson mapper to create a JSON string from an Avro schema
	 * object.
	 *
	 * @param type
	 *            the type to map
	 * @return a JSON schema string for the type
	 */
	private String getJson(AvroType type) {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(
					type);
		} catch (Exception ex) {
			throw new SchemagenException(ex);
		}
	}

	/**
	 * Node class supporting Avro types. Used for dependency sorting.
	 */
	private static class Node {
		NamedAvroType type;
		final Set<Node> parents = new HashSet<Node>();
		final Set<Node> children = new HashSet<Node>();

		Node(NamedAvroType type) {
			this.type = type;
		}
	}

	// other XJC plugin methods

	/**
	 * @return the name of this plugin
	 */
	@Override
	public String getOptionName() {
		return PLUGIN_NAME;
	}

	/**
	 * @return the usage string for this plugin
	 */
	@Override
	public String getUsage() {
		return "  -" + PLUGIN_NAME + "    :  generate a parallel avro schema";
	}

	/**
	 * replace the name-spaces of the generated code from the actual name-spaces
	 * of the XSD
	 * 
	 * @param args
	 * @return
	 */
	public static String replaceNamespace(String insertedNamespace,
			String xsdFileLoc) {
		String existingNamespace = insertedNamespace + AVRO_NAMESPACE_APPEND;
		Document doc = readXSDFileContent(xsdFileLoc);
		doc.getDocumentElement().normalize();
		Element root = doc.getDocumentElement();
		String namespaceAttribute = root.getAttribute(XSD_NAESPACE_PARAM);
		finalOutput = finalOutput
				.replace(existingNamespace, namespaceAttribute);
		return finalOutput;

	}

	public static void insertXSDAttrtoAvro(String xsdFileLoc) {
		Document doc = readXSDFileContent(xsdFileLoc);
	}

	private static Document readXSDFileContent(String xsdResource) {
		File xsdFile = new File(xsdResource);
		String namespaceAttribute = null;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(xsdFile);
		} catch (ParserConfigurationException e) {
			// log exception
		} catch (SAXException e) {
			// log exception
		} catch (IOException e) {
			// log exception
		}
		return doc;
	}
}