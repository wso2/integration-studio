package org.wso2.developerstudio.eclipse.maven.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class MavenExecutorTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(MavenExecutorTestSuite.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(MavenArcheTypeTest.class);
		suite.addTestSuite(MavenGoalExecuteTest.class);
		//$JUnit-END$
		return suite;
	}

}
