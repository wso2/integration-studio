/*
 *     Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *     WSO2 Inc. licenses this file to you under the Apache License,
 *     Version 2.0 (the "License"); you may not use this file except
 *     in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 */

package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang.StringUtils;
import org.wso2.developerstudio.eclipse.esb.dashboard.templates.Activator;

public class FileManagementUtil {
    private static final Logger logger = Logger.getLogger(Activator.PLUGIN_ID);

    public static void removeEmptyDirectories(File srcPath) {
        if (srcPath.isDirectory()) {
            String files[] = srcPath.list();
            if (files != null) {
                for (String file : files) {
                    removeEmptyDirectories(new File(srcPath, file));
                }
                if (files.length == 0) {
                    boolean srcDeleted = srcPath.delete();
                    if (srcDeleted) {
                        logger.log(Level.FINE, TemplateProjectConstants.SRC_DELETED_SUCCESSFULLY);
                    } else {
                        logger.log(Level.FINE, TemplateProjectConstants.ERROR_CREATING_CORRESPONDING_ZIP_FILE);
                    }
                }
            }
        }
    }

    static public void zipFolder(String srcFolder, String destZipFile) {
        try (FileOutputStream fileWriter = new FileOutputStream(destZipFile);
                ZipOutputStream zip = new ZipOutputStream(fileWriter)) {
            addFolderContentsToZip(srcFolder, zip);
            zip.flush();
            zip.close();
        } catch (IOException ex) {
            logger.log(Level.FINE, TemplateProjectConstants.ERROR_CREATING_CORRESPONDING_ZIP_FILE, ex);
        }
    }

    static private void addToZip(String path, String srcFile, ZipOutputStream zip) {

        File folder = new File(srcFile);

        if (folder.isDirectory()) {
            addFolderToZip(path, srcFile, zip);
        } else {
            // Transfer bytes from in to out
            if (!".project".equals(srcFile)) {
                byte[] buf = new byte[1024];
                int len;
                try (FileInputStream in = new FileInputStream(srcFile)) {
                    String location = folder.getName();
                    if (!StringUtils.isBlank(path)) {
                        location = Paths.get(path,folder.getName()).toString();
                    }
                    zip.putNextEntry(new ZipEntry(location));
                    while ((len = in.read(buf)) > 0) {
                        zip.write(buf, 0, len);
                    }
                    in.close();
                } catch (IOException e) {
                    logger.log(Level.FINE, TemplateProjectConstants.ERROR_CREATING_CORRESPONDING_ZIP_FILE, e);
                }
            }
        }
    }

    static private void addFolderContentsToZip(String srcFolder, ZipOutputStream zip) {
        File folder = new File(srcFolder);
        String fileListArray[] = folder.list();
        int index = 0;
        if (fileListArray != null) {
            while (index < fileListArray.length) {
                addToZip(TemplateProjectConstants.EMPTY_STRING, Paths.get(srcFolder, fileListArray[index]).toString(),
                        zip);
                index++;
            }
        }
    }

    static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) {
        File folder = new File(srcFolder);
        String fileListArray[] = folder.list();
        int index = 0;
        if (fileListArray != null) {
            while (index < fileListArray.length) {
                String newPath = folder.getName();
                if (!StringUtils.isBlank(path)) {
                    newPath = Paths.get(path, newPath).toString();
                }
                addToZip(newPath, Paths.get(srcFolder, fileListArray[index]).toString(), zip);
                index++;
            }
        }
    }
}
