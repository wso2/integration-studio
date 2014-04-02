package org.wso2.datamapper.engine.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.json.JSONException;
import org.wso2.datamapper.engine.core.DataMapper;
import org.wso2.datamapper.engine.models.MappingResourceModel;

public class MapperMain {

	public static void main(String[] args) throws FileNotFoundException, JSONException {
		
		DataMapper mapper = new DataMapper();
		InputStream inStream = new FileInputStream(new File("./resources/sf-input.xml"));
		InputStream config = new FileInputStream(new File("./resources/MappingConfigSF.js"));
		InputStream inputSchema = new FileInputStream(new File("./resources/sf-inputavroschema.avsc"));
		InputStream outputSchema = new FileInputStream(new File("./resources/sf-outputavroschema.avsc"));
		
		try {
	
			MappingResourceModel configModel = new MappingResourceModel(inputSchema,outputSchema, config);
			OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(inStream);
		    OMElement documentElement = builder.getDocumentElement();
			String doMap = mapper.doMap(documentElement,configModel);			
			
			System.out.println(doMap);  
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
