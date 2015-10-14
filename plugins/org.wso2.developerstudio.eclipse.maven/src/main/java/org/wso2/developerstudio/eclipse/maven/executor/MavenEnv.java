package org.wso2.developerstudio.eclipse.maven.executor;

import java.io.File;

import org.wso2.developerstudio.eclipse.maven.internal.executor.impl.MavenExecutorImpl;

public class MavenEnv {
	private static IMavenExecutor executor=MavenExecutorImpl.getInstance();
	public static IMavenExecutor getExecutor(){
		return executor;
	}
	
	public static File getMavenHome(){
		return new File((System.getenv("MAVEN_HOME") != null ? System
				.getenv("MAVEN_HOME")
				: (System.getenv("M2_HOME") != null ? System.getenv("M2_HOME")
						: "")));
	}
	
	static {
		System.setProperty("maven.home", getMavenHome().toString());
	}
	
	public static boolean isMavenExecutionModeOnline(){
		return true;
	}
	
	public static boolean isMavenExecutionModeOffline(){
		return !isMavenExecutionModeOnline();
	}
	
	public static boolean isMavenExecutionModeOnline(MavenExecuteMode executionMode){
		return (executionMode==MavenExecuteMode.ONLINE? true:(executionMode==MavenExecuteMode.OFFLINE? false:isMavenExecutionModeOnline()));
	}
	
	public static boolean isMavenExecutionModeOffline(MavenExecuteMode executionMode){
		return !isMavenExecutionModeOnline(executionMode);
	}

}
