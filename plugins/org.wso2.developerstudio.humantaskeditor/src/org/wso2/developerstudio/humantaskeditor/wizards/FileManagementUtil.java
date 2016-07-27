/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.humantaskeditor.wizards;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.wso2.developerstudio.humantaskeditor.Activator;
import org.wso2.developerstudio.humantaskeditor.HumantaskEditorConstants;

public class FileManagementUtil {
    private static final Logger logger = Logger.getLogger(Activator.PLUGIN_ID);

    public static void copyDirectory(File srcPath, File dstPath, List<String> filesToBeCopied) throws IOException {

        if (srcPath.isDirectory()) {
            if (!dstPath.exists()) {
                dstPath.mkdir();
            }
            String files[] = srcPath.list();
            if (files != null) {
                for (String file : files) {
                    copyDirectory(new File(srcPath, file), new File(dstPath, file), filesToBeCopied);
                }
            }
        } else {
            if (!filesToBeCopied.contains(srcPath.getAbsolutePath()))
                return;
            if (srcPath.exists()) {
                FileManagementUtil.copy(srcPath, dstPath);
            }
        }
    }

    public static List<String> getAllFilesPresentInFolder(File srcPath) {
        List<String> fileList = new ArrayList<>();
        if (srcPath.isDirectory()) {
            String files[] = srcPath.list();
            if (files != null) {
                for (String file : files) {
                    fileList.addAll(getAllFilesPresentInFolder(new File(srcPath, file)));
                }
            }
        } else {
            fileList.add(srcPath.getAbsolutePath());
        }
        return fileList;
    }

    public static void removeEmptyDirectories(File srcPath) {
        if (srcPath.isDirectory()) {
            String files[] = srcPath.list();
            if (files != null) {
                for (String file : files) {
                    removeEmptyDirectories(new File(srcPath, file));
                }
                if (files.length == 0) {
                    srcPath.delete();
                }
            }
        }
    }

    static public void zipFolder(String srcFolder, String destZipFile) {
        ZipOutputStream zip;
        FileOutputStream fileWriter;
        try {
            fileWriter = new FileOutputStream(destZipFile);
            zip = new ZipOutputStream(fileWriter);
            addFolderContentsToZip(srcFolder, zip);
            zip.flush();
            zip.close();
        } catch (IOException ex) {
            logger.log(Level.FINE, HumantaskEditorConstants.ERROR_CREATING_CORRESPONDING_ZIP_FILE, ex);
        }
    }

    static private void addToZip(String path, String srcFile, ZipOutputStream zip) {

        File folder = new File(srcFile);

        if (folder.isDirectory()) {
            addFolderToZip(path, srcFile, zip);
        } else {
            // Transfer bytes from in to out
            if (!srcFile.equals(".project")) {
                byte[] buf = new byte[1024];
                int len;
                try {
                    FileInputStream in = new FileInputStream(srcFile);
                    String location = folder.getName();
                    if (!path.equalsIgnoreCase("")) {
                        location = path + File.separator + folder.getName();
                    }
                    zip.putNextEntry(new ZipEntry(location));
                    while ((len = in.read(buf)) > 0) {
                        zip.write(buf, 0, len);
                    }
                    in.close();
                } catch (IOException e) {
                    logger.log(Level.FINE, HumantaskEditorConstants.ERROR_CREATING_CORRESPONDING_ZIP_FILE, e);
                }
            }
        }
    }

    static private void addFolderContentsToZip(String srcFolder, ZipOutputStream zip) {
        File folder = new File(srcFolder);
        String fileListArray[] = folder.list();
        int i = 0;
        if (fileListArray != null) {
            while (i < fileListArray.length) {
                addToZip("", srcFolder + File.separator + fileListArray[i], zip);
                i++;
            }
        }
    }

    static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) {
        File folder = new File(srcFolder);
        String fileListArray[] = folder.list();
        int i = 0;
        while (i < fileListArray.length) {
            String newPath = folder.getName();
            if (!path.equalsIgnoreCase("")) {
                newPath = path + File.separator + newPath;
            }
            addToZip(newPath, srcFolder + File.separator + fileListArray[i], zip);
            i++;
        }

    }

    public static void deleteDirectories(File dir) {
        File[] children = dir.listFiles();
        if (children != null) {
            for (File aChildren : children) {
                if (aChildren.list() != null && aChildren.list().length > 0) {
                    deleteDirectories(aChildren);
                } else {
                    aChildren.delete();
                }
            }
        }
        dir.delete();
    }

    // Copies src file to dst file.
    // If the dst file does not exist, it is created
    public static void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
}
