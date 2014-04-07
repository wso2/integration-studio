package org.wso2.datamapper.engine.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.avro.generic.GenericRecord;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.wso2.datamapper.engine.core.MappingHandler;
import org.wso2.datamapper.engine.core.MappingResourceLoader;
import org.wso2.datamapper.engine.utils.OutputJsonBuilder;
/**
 * This is a Test class will be removed in the future
 * @author jasintha
 *
 */
public class MapperMain {

	public static void main(String[] args) throws FileNotFoundException, JSONException {

		InputStream inStream = new FileInputStream(new File("./resources/sf-input.xml"));
		InputStream config = new FileInputStream(new File("./resources/MappingConfigSF.js"));
		InputStream inputSchema = new FileInputStream(new File("./resources/sf-inputavroschema.avsc"));
		InputStream outputSchema = new FileInputStream(new File("./resources/sf-outputavroschema.avsc"));
		
		try {
	
			MappingResourceLoader configModel = new MappingResourceLoader(inputSchema,outputSchema, config);
			OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(inStream);
		    OMElement documentElement = builder.getDocumentElement();

		    GenericRecord result = MappingHandler.doMap(documentElement,configModel);			
			
			
			OutputJsonBuilder outJsonBuilder = new OutputJsonBuilder();
			JSONObject resultJson = outJsonBuilder.getOutPut(result, configModel.getOutputRootelement());
		
			System.out.println(resultJson.toString());  
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
