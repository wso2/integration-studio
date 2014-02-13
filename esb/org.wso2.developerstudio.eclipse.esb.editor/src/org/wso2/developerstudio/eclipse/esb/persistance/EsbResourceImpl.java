/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.esb.persistance;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.util.EsbUtils;

/**
 * Custom resource class which overrides default resource loading and saving
 * mechanism.
 */
public class EsbResourceImpl extends ResourceImpl {
	/**
	 * URI constructor.
	 * 
	 * @param uri {@link URI} of the loaded resource.
	 */
	public EsbResourceImpl(URI uri) {
		super(uri);
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		// Read the configuration xml (stream) and realize a model object.
		EsbFactory esbFactory = EsbFactory.eINSTANCE;
		Element rootElem = null;
		ModelObject modelObj = null;		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputStream);
			rootElem = doc.getDocumentElement();			
		} catch (Exception ex) {
			throw new IOException(String.format("Error while parsing esb configuration file: %s", ex.getMessage()));
		}
		
		modelObj = esbFactory.loadModelObject(rootElem, ModelObject.class, null);
		if (null != modelObj) {
			// Add the model object as the root object of this resource.
			getContents().add(modelObj);

			// If there are problems with the loaded resource...
			List<IStatus> loadErrors = esbFactory.extractLoadErrors(modelObj);
			if (!loadErrors.isEmpty()) {
				final MultiStatus multi = new MultiStatus("org.wso2.developerstudio.eclipse.esb.editor", 0, loadErrors
						.toArray(new IStatus[] {}), "One or more errors were encountered while loading esb model.",
						null);

				if (!multi.isOK()) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							ErrorDialog.openError(null, "Incomplete ESB Configuration",
									"Problems encountered while loading esb configuration file.", multi);
						}
					});
				}
			}
		} else {
			throw new IOException("Corrupted or invalid esb configuration file.");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		// Retrieve the root object and save.
		EObject eObj = getContents().get(0);
		try {
			Element elem = EsbFactory.eINSTANCE.serializeToElement((ModelObject) eObj);
			EsbUtils.renderElement(elem, outputStream, false);
		} catch (Exception ex) {
			throw new IOException(String.format("Error while serializing esb model: %s", ex.getMessage()));
		}
	}	
}
