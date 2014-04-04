package org.wso2.datamapper.engine.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Parser;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

public class MappingResourceLoader {
	
	private Schema inputAvroSchema;
	private Schema outputAvroSchema;
	private InputStream mappingConfig;
	private String inputRootelement;
	private String outputRootelement;
	private Context context;
	private Scriptable scope;
	private Function function;
	
	public MappingResourceLoader(InputStream inputSchema, InputStream outPutSchema,
			InputStream mappingConfig) throws IOException {

		this.inputAvroSchema = getAvroSchema(inputSchema);
		this.outputAvroSchema = getAvroSchema(outPutSchema);
		this.inputRootelement = inputAvroSchema.getName();
		this.outputRootelement = outputAvroSchema.getName();
		this.mappingConfig = mappingConfig;
		this.function = getFunction(mappingConfig);
	}

	public Schema getInputSchema() {
		return inputAvroSchema;
	}

	public Schema getOutputSchema() {
		return outputAvroSchema;
	}

	public InputStream getMappingConfig() {
		return mappingConfig;
	}

	public String getInputRootelement() {
		return inputRootelement;
	}

	public String getOutputRootelement() {
		return outputRootelement;
	}
	public Context getContext() {
		return context;
	}

	public Scriptable getScope() {
		return scope;
	}

	public Function getFunction() {
		return function;
	}

	private Schema getAvroSchema(InputStream schema) throws IOException{
		return new Parser().parse(schema);
	}
	
	private Function getFunction(InputStream mappingConfig) throws IOException {

		initScriptEnviroment();

		BufferedReader configReader = new BufferedReader(new InputStreamReader(mappingConfig));
		Pattern functionIdPattern = Pattern.compile("(function )(map_(L|S)_" + inputRootelement
				+ "_(L|S)_" + outputRootelement + ")");
		String fnName = null;
		String configLine = "";
		StringBuilder configScriptbuilder = new StringBuilder();
		while ((configLine = configReader.readLine()) != null) {
			configScriptbuilder.append(configLine);
			Matcher matcher = functionIdPattern.matcher(configLine);
			if (matcher.find()) {
				fnName = matcher.group(2);
			}
		}
		
		if (fnName != null) {
			context.evaluateString(scope, configScriptbuilder.toString(), "	", 1, null);
			return (Function) scope.get(fnName, scope);
		}

		return null;
	}

	private void initScriptEnviroment() {
		context = Context.enter();
		context.setOptimizationLevel(-1);
		scope = context.initStandardObjects();
	}
}
