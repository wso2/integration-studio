package org.wso2.developerstudio.eclipse.registry.core.exception;

public class RegistryContentRetrieveException extends CSRegistryException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4198062295911446014L;

	public RegistryContentRetrieveException(Throwable e) {
		this("Error occurred while trying to retreive registry content", e);
	}
	
	public RegistryContentRetrieveException(String message, Throwable e) {
		super(message, e);
	}

}
