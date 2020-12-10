/*
 * Copyright (c) 2011-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IFileEditorMapping;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer.Deserializer;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.part.EsbEditorInput;
import org.wso2.integrationstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.integrationstudio.eclipse.platform.ui.utils.UnrecogizedArtifactTypeException;

public class GraphicalEditorStartupUtils implements Openable {
    private static final String XML_EXTENSION = "xml";
    private static final String XML_EDITOR_ID = "org.eclipse.wst.xml.ui.internal.tabletree.XMLMultiPageEditorPart";

    @Override
    public IEditorPart editorOpen(String name, String type, String locatioin, String source) throws Exception {
        return editorOpen(name, type, locatioin, source, null);
    }

    @Override
    public IEditorPart editorOpen(String type, String source, IFile xmlFile) throws Exception {
        OpenEditorUtils oeUtils = new OpenEditorUtils();

        IEditorPart openSeparateEditor = oeUtils.openSeparateEditor(xmlFile);
        // return editorOpen("", type, "", source,xmlFile);
        return openSeparateEditor;
    }

    private IEditorPart editorOpen(String name, String type, String locatioin, final String source, IFile xmlFile)
            throws Exception {
        Integer val;
        String locatioin_ = locatioin;
        String name_ = name;
        if (type.contains("endpoint")) {
            String[] types = type.split("-");
            if (types.length > 1) {
                type = types[0];
                val = new Integer(types[1]);
            }
        }

        if (xmlFile == null) {
            xmlFile = (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(locatioin_ + "/" + name_));
        }

        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        // IEditorPart openEditor = activePage.openEditor(new EsbEditorInput(null, xmlFile, type), EsbDiagramEditor.ID,
        // true, IWorkbenchPage.MATCH_INPUT);

        String defaultEditorID = EsbDiagramEditor.ID;
        IEditorRegistry editorReg = PlatformUI.getWorkbench().getEditorRegistry();
        IFileEditorMapping[] mappings = editorReg.getFileEditorMappings();
        for (IFileEditorMapping mapping : mappings) {
            if (XML_EXTENSION.equals(mapping.getExtension())) {
                String tmpDefaultEditorID = mapping.getDefaultEditor().getId();
                if (XML_EDITOR_ID.equals(tmpDefaultEditorID)) {
                    defaultEditorID = tmpDefaultEditorID;
                }
                break;
            }
        }

        IEditorInput editorInput;
        if (EsbDiagramEditor.ID.equals(defaultEditorID)) {
            editorInput = new EsbEditorInput(null, xmlFile, type);
        } else {
            editorInput = new FileEditorInput(xmlFile);
        }
        IEditorPart openEditor = activePage.openEditor(editorInput, defaultEditorID, true, IWorkbenchPage.MATCH_INPUT);

        if ("endpoint".equals(type)) {
            EditorUtils.updateToolpalette();
        } else if ("sequence".equals(type)) {
            // EditorUtils.updateToolpalette();
        }
        return openEditor;
    }

    @Override
    public Enumerator artifactTypeResolver(String source) throws UnrecogizedArtifactTypeException, Exception {
        Deserializer deserializer = Deserializer.getInstance();
        return deserializer.getArtifactType(source);
    }

}
