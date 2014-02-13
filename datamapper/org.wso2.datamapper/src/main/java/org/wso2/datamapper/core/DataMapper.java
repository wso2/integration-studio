/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.datamapper.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.avro.Schema;
import org.apache.avro.Schema.Parser;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.axiom.om.OMElement;
import org.codehaus.jackson.JsonNode;
import org.stringtemplate.v4.compiler.CodeGenerator.primary_return;
import org.wso2.datamapper.model.ConfigDataModel;
import org.wso2.datamapper.model.OutputDataModel;
import org.wso2.datamapper.parsers.MappingLexer;
import org.wso2.datamapper.parsers.MappingParser;
import org.wso2.datamapper.core.FunctionExecuter;
import org.wso2.datamapper.inputAdapters.InputDataReaderAdapter;
import org.wso2.datamapper.inputAdapters.XmlInputReader;

public class DataMapper {

	private File outputSchema;
	private BufferedWriter outputWriter;
	private Map<String, String> dataTypes;
	

	public DataMapper() throws IOException {
		outputWriter = new BufferedWriter(new FileWriter(new File("./resource/output.json")));
	}

	public void doMapping(File configFile, File inputFile, File inputSchema, File outputSchema) {

		ANTLRInputStream inputStream;
	    List<GenericRecord> resulRecordtList = new ArrayList<GenericRecord>();

		try {
			inputStream = new ANTLRInputStream(new FileInputStream(configFile));
			MappingLexer lexer = new MappingLexer(inputStream);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			MappingParser parser = new MappingParser(tokens);

			ParseTree tree = parser.statment();
			ParseTreeWalker walker = new ParseTreeWalker();

			ConfigModelGenerator conGen = new ConfigModelGenerator();
			walker.walk(conGen, tree);

			InputDataReaderAdapter reader = new XmlInputReader();
			reader.setInputReader(inputFile);
			Schema inSchema = new Parser().parse(inputSchema);
			Schema outSchema = new Parser().parse(outputSchema);

			FunctionExecuter funcExecuter = new FunctionExecuter();
			ConfigDataModel confDataModel = conGen.getConfigModel();

			String inputType = confDataModel.getInputDatatype();
			String outputtype = confDataModel.getOutputdataType();

			System.out.println("data types " + inputType + " " + outputtype);

			Iterator<GenericRecord> inRecordsItr = reader.getChildItr(inputType, inSchema);
			OutputDataModel outModel = confDataModel.getOutDataModel();
			
			GenericRecord outRecord;
			

			while (inRecordsItr.hasNext()) {
				GenericRecord inRecord = inRecordsItr.next();
				outRecord = funcExecuter.executeFunction(inRecord, outModel, outSchema);
				System.out.println("result "+outRecord);
				outputWriter.write(outRecord.toString());
				 
			}
			
			outputWriter.flush();
			outputWriter.close(); 
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public OMElement getChild(OMElement element) {
		OMElement chilElement = null;
		if (this.dataTypes.containsKey(element.getLocalName())) {
			Iterator<OMElement> childs = element.getChildElements();
			while (childs.hasNext()) {
				chilElement = childs.next();

			}
		}
		return getChild(chilElement);
	}

}
