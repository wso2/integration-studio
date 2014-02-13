package org.wso2.developerstudio.eclipse.esb.project.artifact;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

public class Artifact extends AbstractXMLDoc{

	private List<org.wso2.developerstudio.eclipse.capp.core.manifest.Artifact> artifacts=new ArrayList<org.wso2.developerstudio.eclipse.capp.core.manifest.Artifact>();
	
	public List<org.wso2.developerstudio.eclipse.capp.core.manifest.Artifact> getArtifacts() {
		return artifacts;
	}

	public void setArtifacts(
			List<org.wso2.developerstudio.eclipse.capp.core.manifest.Artifact> artifacts) {
		this.artifacts = artifacts;
	}

	@Override
	protected void deserialize(OMElement documentElement) throws Exception {
		List<OMElement> artifactsElements = getChildElements(documentElement, "subArtifacts");
		for (OMElement omElement : artifactsElements) {
			List<OMElement> artifactElements = getChildElements(omElement, "artifact");			
			for (OMElement omElement2 : artifactElements) {				
				org.wso2.developerstudio.eclipse.capp.core.manifest.Artifact artifact=new org.wso2.developerstudio.eclipse.capp.core.manifest.Artifact(); 
				artifact.setName(omElement2.getAttributeValue(new QName("name")));
				artifacts.add(artifact);
			}
        }
		
	}

	@Override
	protected String serialize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDefaultName() {
		// TODO Auto-generated method stub
		return null;
	}

}
