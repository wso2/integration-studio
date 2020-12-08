package org.wso2.developerstudio.eclipse.registry.core.exception;

public class UnknownRegistryException extends CSRegistryException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3331563274465107905L;

	public UnknownRegistryException(Throwable e) {
		this("Unknown error occured: "+e.getMessage(), e);
	}
	
	public UnknownRegistryException(String message, Throwable e) {
		super(message, e);
	}

}
