package org.wso2.developerstudio.samplewebeditor.editor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.wso2.datamapper.engine.core.MappingHandler;
import org.wso2.datamapper.engine.core.MappingResourceLoader;
import org.wso2.datamapper.engine.inputAdapters.InputDataReaderAdapter;
import org.wso2.datamapper.engine.inputAdapters.ReaderRegistry;
import org.wso2.datamapper.engine.outputAdapters.DummyEncoder;
import org.wso2.datamapper.engine.outputAdapters.WriterRegistry;
import org.wso2.developerstudio.eclipse.artifact.analytics.ui.wizard.AnalyticsProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.model.MavenInfo;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractEditorFunctionExecutor;

public class DataMapperFunctionExecutor implements AbstractEditorFunctionExecutor {

	@Override
	public Object executeFunction(String functionName, Object[] args) {
		
		if (functionName.equals("map")) {
			String payload = (String)args[1];
			String inSchema = (String)args[2];
			String outSchema = (String)args[3];
			String mappingConfig = (String)args[4];
			InputStream inStream = new ByteArrayInputStream(payload.getBytes(StandardCharsets.UTF_8));
			InputStream inputSchema = new ByteArrayInputStream(inSchema.getBytes(StandardCharsets.UTF_8));
			InputStream outputSchema = new ByteArrayInputStream(outSchema.getBytes(StandardCharsets.UTF_8));
			InputStream config = new ByteArrayInputStream(mappingConfig.getBytes(StandardCharsets.UTF_8));
			
			MappingContext context = new MappingContext();
			context.setInputStream(inStream);
			context.setConfig(config);
			context.setInputSchema(inputSchema);
			context.setOutputSchema(outputSchema);
			context.setInputType("application/xml");
			context.setOutputType("application/xml");
			
			String output = "";
			try {
				output = map(context);
			} catch (Exception e1) {
				output = "Mapping failed";
				e1.printStackTrace();
			}
			try {
				inStream.close();
			} catch (IOException e) {
				//ignore as we cannot do anything here
				e.printStackTrace();
			}

		    return output;
		} else if (functionName.equals("newAnalyticsProject")) {
			AnalyticsProjectCreationWizard wizard = new AnalyticsProjectCreationWizard();
			JSONObject projectObj = null;
			try {
				projectObj = new JSONObject((String)args[1]);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProjectDataModel analyticsProjectModel = ((AbstractWSO2ProjectCreationWizard)wizard).getModel();
			
			try {
				analyticsProjectModel.setSelectedOption("new.analyticsProject");
				analyticsProjectModel.setProjectName((String)projectObj.get("name"));
				analyticsProjectModel.setLocation(new File((String)projectObj.get("location")));
				JSONObject mavenObj = (JSONObject) projectObj.get("mavenInfo");
				MavenInfo mavenInfo = new MavenInfo((String)mavenObj.getString("groupId"),
													(String)mavenObj.getString("artifactId"), 
													(String)mavenObj.getString("version"));
				analyticsProjectModel.setMavenInfo(mavenInfo);
				
			} catch (ObserverFailedException | JSONException e) {
				e.printStackTrace();
			}
			
			return wizard.performFinish();
		}
		return null;
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
