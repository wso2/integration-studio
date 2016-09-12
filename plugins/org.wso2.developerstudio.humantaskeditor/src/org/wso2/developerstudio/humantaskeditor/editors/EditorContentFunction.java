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

package org.wso2.developerstudio.humantaskeditor.editors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.prefs.Preferences;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractEditorFunctionExecutor;
import org.wso2.developerstudio.humantaskeditor.Activator;
import org.wso2.developerstudio.humantaskeditor.HumantaskEditorConstants;

public class EditorContentFunction implements AbstractEditorFunctionExecutor {

    private String text;
    private String projectName;
    private static final Logger logger = Logger.getLogger(Activator.PLUGIN_ID);

    @Override
    public Object executeFunction(String functionName, Object[] parameters) {
        if (HumantaskEditorConstants.JS_CUSTOMFUNC_SETTEXT.equals(functionName)) {
            setText((String) parameters[1]);
            return null;
        } else if (HumantaskEditorConstants.JS_CUSTOMFUNC_GETTEXT.equals(functionName)) {
            return getText();
        } else if (HumantaskEditorConstants.JS_CUSTOMFUNC_GET_WSDL.equals(functionName)) {
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            IResource resource = workspace
                    .getRoot()
                    .getProject(this.projectName)
                    .findMember(
                            Paths.get(HumantaskEditorConstants.BASE_FOLDER_NAME,
                                    parameters[1] + HumantaskEditorConstants.CALLBACK_TASK_WSDL_SUFFIX).toString());

            if (resource.exists()) {
                File file = resource.getLocation().toFile();
                StringBuffer sb = new StringBuffer();
                if (!file.exists()) {
                    return HumantaskEditorConstants.FILE_NOT_FOUND_MESSAGE;
                } else {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),
                            HumantaskEditorConstants.UTF8_STRING))) {
                        String sCurrentLine;

                        while ((sCurrentLine = reader.readLine()) != null) {
                            sb.append(sCurrentLine);
                        }

                    } catch (FileNotFoundException e1) {
                        logger.log(Level.FINE, HumantaskEditorConstants.ERROR_FINDING_CORRESPONDING_WSDL_FILE, e1);
                    } catch (IOException e) {
                        logger.log(Level.FINE, HumantaskEditorConstants.ERROR_CREATING_CORRESPONDING_WSDL_FILE, e);
                    }
                    return sb.toString();
                }
            } else {
                return HumantaskEditorConstants.UNDEFINED_LITERAL;
            }
        } else if (HumantaskEditorConstants.JS_CUSTOMFUNC_REMOVE_WSDL.equals(functionName)) {
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            IResource resource = workspace
                    .getRoot()
                    .getProject(this.projectName)
                    .findMember(
                            Paths.get(HumantaskEditorConstants.BASE_FOLDER_NAME,
                                    parameters[1] + HumantaskEditorConstants.TASK_WSDL_SUFFIX).toString());
            IResource cbResource = workspace
                    .getRoot()
                    .getProject(this.projectName)
                    .findMember(
                            Paths.get(HumantaskEditorConstants.BASE_FOLDER_NAME,
                                    parameters[1] + HumantaskEditorConstants.CALLBACK_TASK_WSDL_SUFFIX).toString());
            if (resource.exists()) {
                File file = resource.getLocation().toFile();
                File cbFile = cbResource.getLocation().toFile();
                if (!file.exists()) {
                    return HumantaskEditorConstants.FILE_NOT_FOUND_MESSAGE;
                } else if (!cbFile.exists()) {
                    return HumantaskEditorConstants.FILE_NOT_FOUND_MESSAGE;
                } else {
                    try {
                        boolean deleted = file.delete();
                        boolean cbDeleted = cbFile.delete();
                        if (deleted && cbDeleted) {
                            logger.log(Level.FINE, HumantaskEditorConstants.WSDL_DELETED_SUCCESSFULLY);
                        } else {
                            logger.log(Level.FINE, HumantaskEditorConstants.ERROR_DELETING_CORRESPONDING_WSDL_FILE);
                        }
                    } catch (SecurityException e) {
                        logger.log(Level.FINE, HumantaskEditorConstants.ERROR_DELETING_CORRESPONDING_WSDL_FILE, e);
                    }
                    return HumantaskEditorConstants.DELETED_SUCCESSFULLY_MESSAGE;
                }
            } else {
                return HumantaskEditorConstants.UNDEFINED_LITERAL;
            }
        } else if (HumantaskEditorConstants.JS_CUSTOMFUNC_ALERT.equals(functionName)) { // ("alert","title","message")
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, (String) parameters[2]);
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    (String) parameters[1], null, editorStatus);
            return null;
        } else if (HumantaskEditorConstants.JS_CUSTOMFUNC_SAVEPREF.equals(functionName)) { // (savepreference,"preferencename","preferencevalue")
            Preferences preferences = InstanceScope.INSTANCE.getNode(HumantaskEditorConstants.PLUGIN_ID);
            Preferences projectNode = preferences.node(this.projectName);
            projectNode.put((String) parameters[1], (String) parameters[2]);
            return null;
        } else if (HumantaskEditorConstants.JS_CUSTOMFUNC_GETPREF.equals(functionName)) { // (getpreference,"preferencename")
            Preferences preferences = InstanceScope.INSTANCE.getNode(HumantaskEditorConstants.PLUGIN_ID);
            Preferences projectNode = preferences.node(this.projectName);
            return projectNode.get((String) parameters[1], null);
        } else {
            return null;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}
