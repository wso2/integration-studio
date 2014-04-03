package org.wso2.datamapper.engine.models;

import java.io.InputStream;

public class MappingResourceModel {
	
	InputStream inputSchema;
	InputStream outPutSchema;
	InputStream mappingConfig;
	
	public MappingResourceModel(InputStream inputSchema,InputStream outPutSchema,InputStream mappingConfig) {
	    this.inputSchema = inputSchema;
	    this.outPutSchema = outPutSchema;
	    this.mappingConfig = mappingConfig;
	}

	public InputStream getInputSchema() {
		return inputSchema;
	}

	public InputStream getOutPutSchema() {
		return outPutSchema;
	}

	public InputStream getMappingConfig() {
		return mappingConfig;
	}

}
