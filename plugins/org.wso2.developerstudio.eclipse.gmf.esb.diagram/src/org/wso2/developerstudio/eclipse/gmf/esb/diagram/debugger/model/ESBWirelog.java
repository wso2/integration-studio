package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model;

import com.google.gson.JsonObject;

public class ESBWirelog {
	
	private JsonObject mediatorId;
	private String requestWireLog;
	private String responseWireLog;
	
	public JsonObject getMediatorId() {
		return mediatorId;
	}
	public void setMediatorId(JsonObject mediatorId) {
		this.mediatorId = mediatorId;
	}
	
	public String getRequestWireLog() {
		return requestWireLog;
	}
	public void setRequestWireLog(String requestWireLog) {
		this.requestWireLog = requestWireLog;
	}
	public String getResponseWireLog() {
		return responseWireLog;
	}
	public void setResponseWireLog(String responseWireLog) {
		this.responseWireLog = responseWireLog;
	}	
}
