package org.wso2.datamapper.engine.sample;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Parser;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.DatumWriter;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.json.JSONException;
import org.wso2.datamapper.engine.core.MappingHandler;
import org.wso2.datamapper.engine.core.MappingResourceLoader;
import org.wso2.datamapper.engine.core.writer.DummyEncoder;
import org.wso2.datamapper.engine.core.writer.WriterRegistry;
import org.wso2.datamapper.engine.inputAdapters.CsvInputReader;
/**
 * This is a Test class will be removed in the future
 *
 */
public class MapperMain {

	public static void main(String[] args) throws FileNotFoundException, JSONException {

		InputStream inStream = new FileInputStream(new File("./resources/jiraInput.xml"));
		InputStream config = new FileInputStream(new File("./resources/mappingConfigJira.js"));
		InputStream inputSchema = new FileInputStream(new File("./resources/csvInput.avsc"));
		InputStream outputSchema = new FileInputStream(new File("./resources/jiraoutput.avsc"));
		
		try {
	
			
			OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(inStream);
		    OMElement documentElement = builder.getDocumentElement(); 
		    
		    MappingResourceLoader configModel = new MappingResourceLoader(inputSchema,outputSchema, config);
		    GenericRecord result = MappingHandler.doMap(documentElement,configModel,new CsvInputReader());			
		 
			
	         ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
			
			//CSV : text/csv
			//XML : application/xml
		    
		  /*  DatumWriter<GenericRecord> writer = WriterRegistry.getInstance().get("text/csv").newInstance(); 
		    writer.setSchema(result.getSchema());
		    Encoder encoder =  new DummyEncoder(baos);
		 
		    writer.write(result, encoder);
		    encoder.flush();

		    //Print CSV
		    System.out.println("-- CSV -- \n");
			System.out.println(baos.toString());*/
			
			
			baos = new ByteArrayOutputStream();
			Encoder encoder =  new DummyEncoder(baos);
		    DatumWriter<GenericRecord>  writer = WriterRegistry.getInstance().get("application/xml").newInstance(); 
		    writer.setSchema(result.getSchema());
		    encoder =  new DummyEncoder(baos);
		 
		    writer.write(result, encoder);
		    encoder.flush();

		    //Print XML
		    System.out.println("\n\n-- XML -- \n");
			System.out.println(baos.toString());
			
			inStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
