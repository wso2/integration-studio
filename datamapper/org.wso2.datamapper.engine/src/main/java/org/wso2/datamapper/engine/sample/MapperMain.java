package org.wso2.datamapper.engine.sample;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.wso2.datamapper.engine.core.MappingHandler;
import org.wso2.datamapper.engine.core.MappingResourceLoader;
import org.wso2.datamapper.engine.inputAdapters.InputDataReaderAdapter;
import org.wso2.datamapper.engine.inputAdapters.ReaderRegistry;
import org.wso2.datamapper.engine.outputAdapters.DummyEncoder;
import org.wso2.datamapper.engine.outputAdapters.WriterRegistry;
import org.wso2.avroSchemaGen.AvroSchemaBuilder;

/**
 * This is a Test class will be removed in the future
 *
 */
public class MapperMain {

	public static void main(String[] args) throws Exception {

		InputStream inStream = new FileInputStream(new File("./resources/input2.xml"));
		InputStream config = new FileInputStream(new File("./resources/MappingConfig2.js"));
		/*InputStream inputSchema = new FileInputStream(new File("./resources/inputSchema2.avsc"));
		InputStream outputSchema = new FileInputStream(new File("./resources/outputSchema2.avsc"));*/
		
		AvroSchemaBuilder avroSchemaBuilder = new AvroSchemaBuilder();
		
		InputStream inputSchemaStream = avroSchemaBuilder.getAvroSchema("org.wso2.avroSchemaGen.Employee");
	    InputStream outputSchemaStream = avroSchemaBuilder.getAvroSchema("org.wso2.avroSchemaGen.Engineer");
		
		//Contexts are anti-pattern and no need getters/setters for access static class, just used for code readability 
		MappingContext context = new MappingContext();
		context.setInputStream(inStream);
		context.setConfig(config);
		context.setInputSchema(inputSchemaStream);
		context.setOutputSchema(outputSchemaStream);
		
		//CSV : text/csv
		//XML : application/xml	
		//XML : application/json
		
		context.setInputType("application/xml");
		context.setOutputType("application/xml");
		
		String output = map(context);
		
		//Print output
	    System.out.println("\n\n-- output -- \n");
		System.out.println(output.toString());
			
		inStream.close();

	}
	
	private static String map(MappingContext c) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Encoder encoder = new DummyEncoder(baos);

		MappingResourceLoader configModel = new MappingResourceLoader(c.getInputSchema(), c.getOutputSchema(),
				c.getConfig());
		InputDataReaderAdapter reader = ReaderRegistry.getInstance().get(c.getInputType()).newInstance();
		
		GenericRecord result = MappingHandler.doMap(c.getInputStream(), configModel, reader);

		DatumWriter<GenericRecord> writer = WriterRegistry.getInstance().get(c.getOutputType()).newInstance();
		writer.setSchema(result.getSchema());

		writer.write(result, encoder);
		encoder.flush();

		return baos.toString();
	} 
	
	static class MappingContext {
		
		public InputStream getInputStream() {
			return inputStream;
		}
		public void setInputStream(InputStream inputStream) {
			this.inputStream = inputStream;
		}
		public InputStream getConfig() {
			return config;
		}
		public void setConfig(InputStream config) {
			this.config = config;
		}
		public InputStream getInputSchema() {
			return inputSchema;
		}
		public void setInputSchema(InputStream inputSchema) {
			this.inputSchema = inputSchema;
		}
		public InputStream getOutputSchema() {
			return outputSchema;
		}
		public void setOutputSchema(InputStream outputSchema) {
			this.outputSchema = outputSchema;
		}
		public String getInputType() {
			return inputType;
		}
		public void setInputType(String inputType) {
			this.inputType = inputType;
		}
		public String getOutputType() {
			return outputType;
		}
		public void setOutputType(String outputType) {
			this.outputType = outputType;
		}
		
		private InputStream inputStream;
		private InputStream config;
		private InputStream inputSchema;
		private InputStream outputSchema;
		private String inputType;
		private String outputType;
	}

}
