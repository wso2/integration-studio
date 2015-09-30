/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.artifact.analytics.publisher.refactor;

import org.apache.commons.io.FilenameUtils;
import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.developerstudio.eclipse.artifact.analytics.publisher.Activator;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsArtifactModel;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsConstants;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsProjectArtifactCreator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import javax.xml.stream.FactoryConfigurationError;
import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

public class RefactorUtils {
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public static Dependency getDependencyForTheProject(IFile file) {
        IProject project = file.getProject();
        MavenProject mavenProject = getMavenProject(project);

        String groupId = mavenProject.getGroupId();
        String artifactId = mavenProject.getArtifactId();
        String version = mavenProject.getVersion();

        String filePath = file.getLocation().toOSString();
        int startIndex = (project.getLocation().toOSString() + File.separator + "src" + File.separator + "main" + File.separator).length();
        int endIndex = filePath.lastIndexOf(File.separator);

        String typeString;

        String typeStringFromPath = filePath.substring(startIndex, endIndex);
        if (typeStringFromPath.equalsIgnoreCase(AnalyticsConstants.ANALYTICS_EXECUTION_PLAN_DIR)) {
            typeString = AnalyticsConstants.ANALYTICS_EXECUTION_PLAN_DIR;
        } else if (typeStringFromPath.equalsIgnoreCase(AnalyticsConstants.ANALYTICS_PUBLISHER_DIR)) {
            typeString = AnalyticsConstants.ANALYTICS_PUBLISHER_DIR;
        } else if (typeStringFromPath.equalsIgnoreCase(AnalyticsConstants.ANALYTICS_RECEIVER_DIR)) {
            typeString = AnalyticsConstants.ANALYTICS_RECEIVER_DIR;
        } else {
            typeString = AnalyticsConstants.ANALYTICS_STREAM_DIR;
        }
        Dependency dependency = new Dependency();
        dependency.setGroupId(groupId + "." + typeString);
        dependency.setArtifactId(artifactId);
        dependency.setVersion(version);

        return dependency;
    }

    public static MavenProject getMavenProject(IProject project) {
        try {
            return MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile());
        } catch (Exception e) {
            log.error("Failed to retrive the maven project for the given project", e);
        }
        return null;
    }

    public static boolean isDependenciesEqual(Dependency source, Dependency target) {
        return (source.getGroupId().equalsIgnoreCase(target.getGroupId()) && source.getArtifactId().equalsIgnoreCase(target.getArtifactId())
                && source.getVersion().equalsIgnoreCase(target.getVersion()));
    }

    public static int charsOnTheLine(String line) {
        // Here we need to add one to represent the newline character
        return line.length() + 1;
    }

    public static AnalyticsArtifactModel getAnalyticsArtifactFromFile(IFile refactoredFile, String projectNatureFilter) {
        IProject analyticsProject = refactoredFile.getProject();
        try {
            analyticsProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            if (analyticsProject.isOpen() && analyticsProject.hasNature(projectNatureFilter)) {

                AnalyticsProjectArtifactCreator analyticsProjectArtifact = new AnalyticsProjectArtifactCreator();
                analyticsProjectArtifact.fromFile(analyticsProject.getFile("artifact.xml")
                        .getLocation().toFile());
                List<AnalyticsArtifactModel> allAnalyticsArtifacts = analyticsProjectArtifact.getAllAnalyticsArtifacts();

                String originalFileRelativePath = FileUtils.getRelativePath(analyticsProject.getLocation()
                        .toFile(), refactoredFile.getLocation().toFile()).replaceAll(Pattern.quote(File.separator), "/");

                for (AnalyticsArtifactModel analyticsArtifact : allAnalyticsArtifacts) {
                    if (analyticsArtifact.getFile().equals(originalFileRelativePath)) {
                        return analyticsArtifact;
                    }
                }
            }
        } catch (CoreException e) {
            log.error("Core exception: " + e.getMessage(), e);
        } catch (FactoryConfigurationError e) {
            log.error("Factory configuration error: " + e.getMessage(), e);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage(), e);
        }

        return null;
    }

    public static String getFilenameWOExtension(String filename) {
        String fileNameWOExt = null;
        if (FilenameUtils.indexOfExtension(filename) == -1) {
            fileNameWOExt = filename;
        } else {
            fileNameWOExt = FilenameUtils.removeExtension(filename);
        }
        return fileNameWOExt;
    }

    public static String getFilenameExtension(String filename) {
        String fileNameExt = "";
        if (FilenameUtils.indexOfExtension(filename) != -1) {
            fileNameExt = FilenameUtils.getExtension(filename);
        }
        return fileNameExt;
    }

}
