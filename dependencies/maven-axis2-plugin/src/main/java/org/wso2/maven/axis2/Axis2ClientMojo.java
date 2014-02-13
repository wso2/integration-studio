package org.wso2.maven.axis2;

import org.apache.axis2.wsdl.WSDL2Java;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Generate client stubs.
 *
 * @goal axis2-client
 * @phase process-resources
 */
public class Axis2ClientMojo extends Axis2Mojo {

	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			WSDL2Java.main(getParameterArray(getParameterList()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
