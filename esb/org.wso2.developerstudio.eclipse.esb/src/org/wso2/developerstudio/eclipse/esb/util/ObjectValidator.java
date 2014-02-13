package org.wso2.developerstudio.eclipse.esb.util;

import java.util.Map;

public class ObjectValidator {
	private Map<String, String> mediatorErrorMap;

	public void setMediatorErrorMap(Map<String, String> mediatorErrorMap) {
		this.mediatorErrorMap = mediatorErrorMap;
	}

	public Map<String, String> getMediatorErrorMap() {
		return mediatorErrorMap;
	}
}