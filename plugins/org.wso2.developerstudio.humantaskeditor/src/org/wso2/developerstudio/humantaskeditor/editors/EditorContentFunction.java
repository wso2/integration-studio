/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.humantaskeditor.editors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractEditorFunctionExecutor;
import org.wso2.developerstudio.humantaskeditor.Activator;

public class EditorContentFunction implements AbstractEditorFunctionExecutor {
    private static String text;
    private static String projectName;
    private static final Logger logger = Logger.getLogger(Activator.PLUGIN_ID);

    @Override
    public Object executeFunction(String functionName, Object[] parameters) {
        if (functionName.equals("settext")) {
            EditorContentFunction.setText((String) parameters[1]);
            return null;
        } else if (functionName.equals("gettext")) {
            return EditorContentFunction.getText();
        } else if (functionName.equals("getWSDL")) {
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            IResource resource = null;
            resource = workspace.getRoot().getProject(getProjectName()).findMember(parameters[1] + "CBTask.wsdl");

            if (resource.exists()) {
                File file = resource.getLocation().toFile();
                StringBuffer sb = new StringBuffer();
                if (!file.exists()) {
                    return "No File";
                } else {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        while (true) {
                            String line = reader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                            
                        }
                      
                    } catch (FileNotFoundException e1) {
                        logger.log(Level.FINE, "Error Finding Corresponding WSDL File", e1);
                    } catch (IOException e) {
                        logger.log(Level.FINE, "Error Creating Corresponding WSDL File", e);
                    }
                    return sb.toString();
                }
            } else {
                return "undefined";
            }

        } else if (functionName.equals("removeWSDL")) {
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            File taskFile = workspace.getRoot().getProject(getProjectName()).findMember(parameters[1] + "CBTask.wsdl")
                    .getLocation().toFile();
            IResource[] memberArray;
            try {
                memberArray = workspace.getRoot().getProject(getProjectName()).members();
                for (int i = 0; i < memberArray.length; i++) {
                    String memberFileExtention = memberArray[i].getFileExtension();
                    if (memberFileExtention.equals("wsdl")) {
                        System.out.println("Equals : " + memberArray[i].getName());
                    }
                }
            } catch (CoreException e) {
                logger.log(Level.FINE, "Error Finding Corresponding WSDL File", e);
            }

            // if(taskFile.exists())taskFile.delete();

            /*
             * if(cbTaskFile.exists())cbTaskFile.delete();
             * for(int i=1;i<parameters.length;i++){
             * System.out.println(parameters[i]);
             * }
             */
            return null;
        } else {
            return null;
        }

    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        EditorContentFunction.text = text;
    }

    public static String getProjectName() {
        return projectName;
    }

    public static void setProjectName(String projectName) {
        EditorContentFunction.projectName = projectName;
    }

}
