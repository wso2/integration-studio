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

package org.wso2.developerstudio.datamapper.diagram.schemagen.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.eclipse.wst.xml.core.internal.contentmodel.CMDocument;
import org.eclipse.wst.xml.ui.internal.wizards.*;
import org.eclipse.wst.common.uriresolver.internal.util.URIHelper;

public class SchemaGeneratorForXSD extends AbstractSchemaGenerator implements ISchemaGenerator {

	private static final String XML_VERSION_1_0_ENCODING_UTF_8 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public String getSchemaContent(String filePath, FileType option, String delimiter) throws IOException {
		String schemaContent = null;
		File xsdFile = new File(filePath);
		InputStream xsdInputStream = new FileInputStream(xsdFile);
		IFile xsdRegResource = generateRegistryResource(xsdInputStream);
		if (xsdRegResource != null) {
			String[] errorInfo = new String[2];
			@SuppressWarnings("restriction")
			CMDocument cmDocument = NewXMLGenerator.createCMDocument(URIHelper.getPlatformURI(xsdRegResource),
					errorInfo);
			XSD2XMLGenerator xsd2xmlGenerator = new XSD2XMLGenerator();
			try {
				String generatedXMLContent = xsd2xmlGenerator.createXML(cmDocument);
				if (generatedXMLContent != null) {
					String xmlSchemaContent = XML_VERSION_1_0_ENCODING_UTF_8 + generatedXMLContent;
					SchemaGeneratorForXML schemaGeneratorForXML = new SchemaGeneratorForXML();
					// Replacing attributes with elements because SchemaGeneratorForXML requires so.
					xmlSchemaContent = schemaGeneratorForXML.replaceAttributesWithElements(xmlSchemaContent);
					schemaContent = schemaGeneratorForXML.getSchemaContent(xmlSchemaContent, FileType.XML, null);
				}
				deleteRegResourcesCreated(xsdRegResource);
			} catch (Exception e) {
				log.error("could not generate the XML content from the loaded XSD.");
				deleteRegResourcesCreated(xsdRegResource);
			}
		}

		return schemaContent;

	}

	public IFile generateRegistryResource(InputStream is) {

		IEditorInput editorInput = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor().getEditorInput();
		IFile configFile = null;

		if (editorInput instanceof IFileEditorInput) {
			IFile diagramFile = ((FileEditorInput) editorInput).getFile();
			String configFilePath = diagramFile.getFullPath().toString();
			configFilePath = configFilePath.replaceAll(".datamapper_diagram$", ".xsd"); //$NON-NLS-1$ //$NON-NLS-2$
			configFile = diagramFile.getWorkspace().getRoot().getFile(new Path(configFilePath));
			try {
				if (configFile.exists()) {
					configFile.setContents(is, true, true, null);
				} else {
					configFile.create(is, true, null);
				}

			} catch (Exception e) {
				log.warn("Could not save file " + configFile + " : " + e); //$NON-NLS-1$
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						// ignore.
					}
				}
			}
		}
		return configFile;
	}

	private void deleteRegResourcesCreated(IFile regResource) {
		if (regResource.exists()) {
			try {
				regResource.delete(true, null);
			} catch (CoreException e) {
				log.error("could not delete the generated XSD file");
			}
		}
	}

}
