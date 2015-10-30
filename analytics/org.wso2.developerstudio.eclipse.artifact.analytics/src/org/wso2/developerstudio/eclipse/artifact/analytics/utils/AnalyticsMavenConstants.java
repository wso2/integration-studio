package org.wso2.developerstudio.eclipse.artifact.analytics.utils;

public class AnalyticsMavenConstants {

	public static final String WSO2_ANALYTICS_EXECUTIONPLAN_VERSION = "1.0.0";
	public static final String WSO2_ANALYTICS_STREAM_VERSION = "1.0.0";
	public static final String WSO2_ANALYTICS_PUBLISHER_VERSION = "1.0.0";
	public static final String WSO2_ANALYTICS_RECEIVER_VERSION = "1.0.0";
	
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
