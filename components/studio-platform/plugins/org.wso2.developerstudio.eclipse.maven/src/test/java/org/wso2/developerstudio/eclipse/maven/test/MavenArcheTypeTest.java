/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.maven.test;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;
import org.wso2.developerstudio.eclipse.maven.executor.MavenEnv;
import org.wso2.developerstudio.eclipse.maven.internal.executor.impl.MavenExecutorImpl;
import org.wso2.developerstudio.eclipse.maven.types.MavenArcheType;
import org.wso2.developerstudio.eclipse.maven.types.MavenProjectType;

/**
 * This test class test the project generation via maven archetype.
 * 
 * @since 1.1.0
 * 
 */

public class MavenArcheTypeTest extends TestCase {

	private static final String USER_HOME = "user.home";

	/**
	 * Test method for
	 * {@link org.wso2.developerstudio.eclipse.maven.executor.MavenExecutorImpl#createArcheType(boolean, boolean, org.wso2.developerstudio.eclipse.build.invoker.maven.util.ArcheTypeParameter, org.wso2.developerstudio.eclipse.build.invoker.maven.util.GeneratedProjectParameter)}
	 * .
	 * @throws Exception 
	 */
	@Test
	public void testTriggerMavenArcheType() throws Exception {
		MavenArcheType archeParam =
		                            new MavenArcheType("org.apache.maven.archetypes",
		                                               "maven-archetype-quickstart", "1.0");
		MavenProjectType projectParam =
		                                new MavenProjectType("MavenArcheTypeTest_" +
		                                                             System.currentTimeMillis(),
		                                                     "1.0.0", "org.wso2.test");
		assertTrue(MavenEnv.getExecutor().createArcheType(true, true, archeParam, projectParam, new File(
                System.getProperty(USER_HOME) +
                File.separator +
                "MavenTests")));
	}

}
