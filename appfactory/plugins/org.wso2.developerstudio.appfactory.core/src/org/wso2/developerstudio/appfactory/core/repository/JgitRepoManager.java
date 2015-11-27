/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.appfactory.core.repository;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.*;
import org.eclipse.jgit.api.CreateBranchCommand.SetupUpstreamMode;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.wso2.developerstudio.appfactory.core.Activator;
import org.wso2.developerstudio.appfactory.core.authentication.Authenticator;
import org.wso2.developerstudio.appfactory.core.authentication.UserPasswordCredentials;
import org.wso2.developerstudio.appfactory.core.model.AppUserInfo;
import org.wso2.developerstudio.appfactory.core.model.AppVersionInfo;
import org.wso2.developerstudio.eclipse.distribution.project.ui.wizard.ProjectsImportPage;
import org.wso2.developerstudio.eclipse.distribution.project.ui.wizard.ProjectsImportPage.ProjectRecord;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class JgitRepoManager {

    private String localPath;
    private String remotePath;
    private Repository localRepo;
    private Git git;
    private boolean cloned;
    UsernamePasswordCredentialsProvider provider;
    AppVersionInfo appVersionInfo;
    private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

    public JgitRepoManager(String localPath,String uri) throws IOException {
    	 this.localPath =localPath;
         this.remotePath = uri;
         File gitDir = new File(localPath +File.separator+ ".git");
         localRepo = FileRepositoryBuilder.create(gitDir);
         git = new Git(localRepo);
         if(remotePath.equals(git.getRepository().getConfig().getString("remote","origin", "url"))){
             setCloned(true);
         }
         UserPasswordCredentials credentials = Authenticator.getInstance().getCredentials();
         provider = new UsernamePasswordCredentialsProvider(credentials.getGitUser(), credentials.getPassword());       
         
	}

    public JgitRepoManager(AppVersionInfo info) throws IOException {
        this(info.getLocalRepo(), info.getRepoURL());
        this.appVersionInfo = info;
    }

    public void createGitRepo() {
        try {
            File gitDir = new File(localPath + File.separator + ".git");
            localRepo = FileRepositoryBuilder.create(gitDir);
            // localRepo = new FileRepository(localPath +File.separator +".git");
            localRepo.create();
        } catch (Exception e) {
            log.error("Git Repository creation Error : ", e);
        }
    }

    public void gitClone() throws InvalidRemoteException, TransportException, GitAPIException, IOException   {     
         Git.cloneRepository() 
           .setCredentialsProvider(provider)
           .setURI(remotePath)
           .setDirectory(new File(localPath))
           .call();
         setRepoAuthor();
    }

    private void setRepoAuthor() throws IOException {
        String currentUser = Authenticator.getInstance().getCredentials().getGitUser();
        List<AppUserInfo> applicationDevelopers = appVersionInfo.getVersionGroup().getApplication()
                .getApplicationDevelopers();
        for (AppUserInfo user : applicationDevelopers) {
            if (currentUser.equals(user.getEmail())) {
                localRepo.getConfig().setString("user", null, "name", user.getFirstName() + " " + user.getLastName());
                localRepo.getConfig().setString("user", null, "email", user.getEmail());
                localRepo.getConfig().save();
            }
        }
    }

	public void branchCreate(String branch) throws IOException,
			JGitInternalException, GitAPIException {
			git.branchCreate()
				.setForce(true)
				.setName(branch)
				.setStartPoint("origin/" + branch)
				.call();
	}
	
	public void update() throws WrongRepositoryStateException,
			InvalidConfigurationException, DetachedHeadException,
			InvalidRemoteException, CanceledException, RefNotFoundException,
			NoHeadException, TransportException, GitAPIException {
		git.fetch()
		   .setCredentialsProvider(provider)
		   .call();
	}
	
    public void checkout(String branch) throws RefAlreadyExistsException, RefNotFoundException,
            InvalidRefNameException, CheckoutConflictException, GitAPIException, IOException {
        if ("trunk".equals(branch)) {
            branch = "master";
        }
        Ref ref = git.getRepository().getRef(branch);
        if (ref == null) {
            checkoutRemoteBranch(branch);
        } else {
            checkoutLocalBranch(branch);
        }
    }

	public void checkoutRemoteBranch(String branch) throws RefAlreadyExistsException,
			RefNotFoundException, InvalidRefNameException,
			CheckoutConflictException, GitAPIException {
	         git.fetch().setRemote("origin").setCredentialsProvider(provider).call();
		     git.checkout()
				.setCreateBranch(true)
				.setName(branch)
				.setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.TRACK)
				.setStartPoint("origin/" + branch)
				.setForce(true)
				.call();
		     trackBranch(branch);

	}
	
	public void checkoutLocalBranch(String branch) throws RefAlreadyExistsException,
	RefNotFoundException, InvalidRefNameException,
	CheckoutConflictException, GitAPIException {
     git.checkout()
		.setCreateBranch(false)
		.setName(branch)
		.setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.TRACK)
		.setStartPoint("origin/" + branch)
		.setForce(true)
		.call();

    }

	public void trackBranch(String branch)
			throws RefAlreadyExistsException, RefNotFoundException,
			InvalidRefNameException, GitAPIException {
		    git.branchCreate()
		       .setName(branch)
			   .setUpstreamMode(SetupUpstreamMode.SET_UPSTREAM)
			   .setStartPoint("origin/"+ branch)
			   .setForce(true)
			   .call();
	}
    public void importProject(ProjectRecord[] projects){
    	ProjectsImportPage importMainPage = new ProjectsImportPage();
    	importMainPage.createProjects(projects);
    }
   
    public void CloseRepo(){
    	localRepo.close();
    }
	public boolean isCloned() {
		return cloned;
	}
	public void setCloned(boolean cloned) {
		this.cloned = cloned;
	}
}