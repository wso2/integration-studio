package org.wso2.developerstudio.eclipse.registry.core.exception;

public class InvalidRegistryURLException extends CSRegistryException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidRegistryURLException(Throwable e) {
		super("Invalid registry url",e);
	}



}
