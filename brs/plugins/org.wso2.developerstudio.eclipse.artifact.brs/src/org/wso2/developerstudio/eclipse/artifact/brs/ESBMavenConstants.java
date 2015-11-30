package org.wso2.developerstudio.eclipse.artifact.brs;

public class ESBMavenConstants {
	
	public static final String WSO2_ESB_ENDPOINT_VERSION="2.1.0";
	public static final String WSO2_ESB_LOCAL_ENTRY_VERSION="2.1.0";
	public static final String WSO2_ESB_PROXY_VERSION="2.1.0";
	public static final String WSO2_ESB_SEQUENCE_VERSION="2.1.0";
	public static final String WSO2_ESB_SYNAPSE_VERSION="2.1.0";
	public static final String WSO2_ESB_API_VERSION="2.1.0";
	public static final String WSO2_ESB_TASK_VERSION="2.1.0";
	public static final String WSO2_ESB_TEMPLATE_VERSION="2.1.0";
	public static final String WSO2_ESB_INBOUND_ENDPOINT_VERSION="1.0.0";
	public static final String WSO2_ESB_CONNECTOR_VERSION="1.0.0";
	public static final String WSO2_GENERAL_PROJECT_VERSION="2.1.0";
	public static final String WSO2_ESB_MESSAGE_STORE_PLUGIN_VERSION="1.1.0";
	public static final String WSO2_ESB_MESSAGE_PROCESSOR_PLUGIN_VERSION="1.1.0";
	public static final String PACKAGE_PHASE = "package";
	public static final String INSTALL_PHASE = "install";
	public static final String DEPLOY_PHASE = "deploy";
	public static final String EXEC_GOAL = "exec";
	public static final String EXECUTABLE_TAG = "executable";
	public static final String EXECUTABLE_VALUE = "mvn";
	public static final String WORKING_DIRECTORY_TAG = "workingDirectory";
	public static final String WORKING_DIRECTORY_VALUE = "${project.build.directory}";
	public static final String ARGUMENTS_TAG = "arguments";
	public static final String ARGUMENT_TAG = "argument";
	public static final String ARGUMENT_VALUE_CLEAN = "clean";
	public static final String ARGUMENT_VALUE_SKIP_TESTS = "-Dmaven.test.skip=${maven.test.skip}";
}
