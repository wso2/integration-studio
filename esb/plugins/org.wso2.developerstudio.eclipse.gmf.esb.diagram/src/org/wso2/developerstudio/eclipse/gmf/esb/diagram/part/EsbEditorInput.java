/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbEditorInput;


public class EsbEditorInput extends FileEditorInput implements IEsbEditorInput {
private Resource diagramResource;
private IFile xmlResource;
private String artifatcType;

	public IFile getXmlResource() {
		return xmlResource;
	}

	public void setXmlResource(IFile xmlResource) {
		this.xmlResource = xmlResource;
	}

	public EsbEditorInput(Resource diagramResource,IFile xmlResource, String artifatcType) {
		super(xmlResource);
 		this.diagramResource = diagramResource;
 		this.xmlResource = xmlResource;
 		this.artifatcType = artifatcType;
 	}
 
 	public boolean exists() {
 		return true;
 	}
 
 	public ImageDescriptor getImageDescriptor() {
 		return ImageDescriptor.getMissingImageDescriptor();
 	}
 
 	public String getName() {
 		return "sampleName";
 	}
 
 	public IPersistableElement getPersistable() {
 		return this;
 	}
 
 	public String getToolTipText() {
 		return "Developer Studio Dashboard";
 	}
 
 	public Object getAdapter(Class adapter) {
 		return null;
 	}
 
 	public void setDiagramResource(Resource diagramResource) {
 		this.diagramResource = diagramResource;
 	}
 
 	public Resource getDiagramResource() {
 		return diagramResource;
 	}
 	
	public String getArtifatcType() {
		return artifatcType;
	}

	public void setArtifatcType(String artifatcType) {
		this.artifatcType = artifatcType;
	}
	
	@Override
	public boolean equals(Object o) {
		return this == o || o instanceof FileEditorInput && xmlResource.equals(((FileEditorInput) o).getFile())
				|| o instanceof EsbEditorInput && xmlResource.equals(((EsbEditorInput) o).getXmlResource());
	}
}