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

package org.wso2.developerstudio.visualdatamapper.diagram.jsonschema.generator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXResult;
import javax.xml.transform.stax.StAXSource;

import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLOutputFactory;

public class JSONSchemaGeneratorforXSD {
	
	  /**
     * Copy/format XML as JSON using {@link Transformer#transform(Source, Result)}.
     * @param args ignored
     * @throws TransformerException
     * @throws XMLStreamException
     */
    public String convertXMLToJson(String inputFile) throws TransformerException, XMLStreamException, IOException {
        InputStream input = JSONSchemaGeneratorforXSD.class.getResourceAsStream(inputFile);
        OutputStream output = System.out;
        /*
         * If we want to insert JSON array boundaries for multiple elements,
         * we need to set the <code>autoArray</code> property.
         * If our XML source was decorated with <code>&lt;?xml-multiple?&gt;</code>
         * processing instructions, we'd set the <code>multiplePI</code>
         * property instead.
         * With the <code>autoPrimitive</code> property set, element text gets
         * automatically converted to JSON primitives (number, boolean, null).
         */
        JsonXMLConfig config = new JsonXMLConfigBuilder()
            .autoArray(true)
            .autoPrimitive(true)
            .prettyPrint(true)
            .build();
        try {
            /*
             * Create source (XML).
             */
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(input);
            Source source = new StAXSource(reader);

            /*
             * Create result (JSON).
             */
            XMLStreamWriter writer = new JsonXMLOutputFactory(config).createXMLStreamWriter(output);
            Result result = new StAXResult(writer);

            /*
             * Copy source to result via "identity transform".
             */
             TransformerFactory.newInstance().newTransformer().transform(source, result);
        } finally {
            /*
             * As per StAX specification, XMLStreamReader/Writer.close() doesn't close
             * the underlying stream.
             */
            output.close();
            input.close();
        }
        
        return Source.class.toString();
    }

}
