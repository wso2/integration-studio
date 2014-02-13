package org.wso2.developerstudio.eclipse.esb.project.artifact;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;
import org.wso2.developerstudio.eclipse.capp.core.manifest.ArtifactDependency;

public class Artifacts extends AbstractXMLDoc{
	private List<ArtifactDependency> artifactDependencies=new ArrayList<ArtifactDependency>();
	
	public List<ArtifactDependency> getArtifactDependencies() {
		return artifactDependencies;
	}

	public void setArtifactDependencies(List<ArtifactDependency> artifactDependencies) {
		this.artifactDependencies = artifactDependencies;
	}

	@Override
	protected void deserialize(OMElement documentElement) throws Exception {
		List<OMElement> artifactsElements = getChildElements(documentElement, "artifact");
		for (OMElement omElement : artifactsElements) {
			List<OMElement> artifactElements = getChildElements(omElement, "dependency");			
			for (OMElement omElement2 : artifactElements) {				
				ArtifactDependency artifactDependency=new ArtifactDependency(null, null); 
				artifactDependency.setName(omElement2.getAttributeValue(new QName("artifact")));
				artifactDependencies.add(artifactDependency);
			}
        }		
	}

	@Override
	protected String serialize() {
		return null;
	}

	@Override
	protected String getDefaultName() {
		return null;
	}

}
