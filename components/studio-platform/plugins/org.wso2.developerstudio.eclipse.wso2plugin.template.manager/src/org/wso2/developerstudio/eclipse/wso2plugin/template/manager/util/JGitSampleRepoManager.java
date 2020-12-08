package org.wso2.developerstudio.eclipse.wso2plugin.template.manager.util;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.*;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.Activator;

public class JGitSampleRepoManager {

	private String remotePath;
	private String localPath;
	private static Git git;
	private boolean cloned;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public JGitSampleRepoManager(String localPath, String uri) throws IOException {
		this.localPath = localPath;
		this.remotePath = uri;

	}

	public static void gitClone(String remotePathDynamic, String localPathDynamic) throws InvalidRemoteException,
	                                                                              TransportException, GitAPIException,
	                                                                              IOException {
		Git.cloneRepository().setURI(remotePathDynamic).setDirectory(new File(localPathDynamic)).call();
	}

	public static void gitPull(String localPathDynamic) {
		Repository localRepo;
		try {
			localRepo = FileRepositoryBuilder.create(new File(localPathDynamic + File.separator + ".git"));
			git = new Git(localRepo);
			PullCommand pullCmd = git.pull();
			pullCmd.call();
		} catch (IOException | GitAPIException e) {
			log.error("Error in pulling content from the git repository, hence proceeding with the previously cloned content ," + e);
		} 

	}

	public boolean isCloned() {
		return cloned;
	}

	public void setCloned(boolean cloned) {
		this.cloned = cloned;
	}
}
