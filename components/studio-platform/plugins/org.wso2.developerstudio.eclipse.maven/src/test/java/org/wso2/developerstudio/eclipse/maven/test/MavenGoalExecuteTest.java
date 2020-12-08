package org.wso2.developerstudio.eclipse.maven.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.wso2.developerstudio.eclipse.maven.executor.MavenEnv;
import org.wso2.developerstudio.eclipse.maven.types.MavenArcheType;
import org.wso2.developerstudio.eclipse.maven.types.MavenProjectType;

public class MavenGoalExecuteTest  extends TestCase {

	private static final String USER_HOME = "user.home";

	/**
	 * Test method for
	 * {@link org.wso2.developerstudio.eclipse.maven.executor.MavenExecutorImpl#executeMavenGoal(java.io.File, java.util.List, boolean)}
	 * .
	 * @throws Exception 
	 */
	@Test
	public void testExecuteMavenGoal() throws Exception {
		String projectName = "MavenArcheTypeTest_" + System.currentTimeMillis();
		MavenArcheType archeParam =
		                            new MavenArcheType("org.apache.maven.archetypes",
		                                               "maven-archetype-quickstart", "1.0");
		MavenProjectType projectParam =
		                                new MavenProjectType("org.wso2.test", projectName, "1.0.0",
		                                                     "org.wso2.test");
		assertTrue(MavenEnv.getExecutor().createArcheType(true, true, archeParam, projectParam,new File(
                System.getProperty(USER_HOME) +
                File.separator +
                "MavenTests")));

		List<String> goalsList = new ArrayList<String>();
		goalsList.add("clean");
		goalsList.add("install");
		assertTrue(MavenEnv.getExecutor().executeMavenGoal(new File(System.getProperty(USER_HOME) +
		                                                   File.separator + "MavenTests" +
		                                                   File.separator + projectName),
		                                          goalsList, true));
	}

}
