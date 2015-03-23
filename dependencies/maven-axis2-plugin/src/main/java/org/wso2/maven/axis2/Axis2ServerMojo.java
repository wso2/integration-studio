package org.wso2.maven.axis2;

import java.util.List;

import org.apache.axis2.wsdl.WSDL2Java;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Generate server stubs.
 *
 * @goal axis2-server
 * @phase process-resources
 */
public class Axis2ServerMojo extends Axis2Mojo {

	private static final String GENERATE_SERVER_SIDE_CODE = "-ss";

	/**
	 * Generate server side code (i.e. skeletons). Option : -ss
	 *
	 * @parameter expression="false"
	 */
	private boolean generateServerSideCode;

	public void execute() throws MojoExecutionException, MojoFailureException {

		List<String> parameterList = getParameterList();
		if (generateServerSideCode) {
			parameterList.add(GENERATE_SERVER_SIDE_CODE);
		}
		try {
			WSDL2Java.main(getParameterArray(parameterList));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
