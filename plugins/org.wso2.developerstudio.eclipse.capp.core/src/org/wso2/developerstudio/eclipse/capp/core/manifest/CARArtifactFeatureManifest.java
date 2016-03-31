/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.capp.core.manifest;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.wso2.developerstudio.eclipse.capp.core.Activator;
import org.wso2.developerstudio.eclipse.capp.core.data.Bundle;
import org.wso2.developerstudio.eclipse.capp.core.data.ImportFeature;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CARArtifactFeatureManifest extends AbstractXMLDoc{
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private String featureId;
	private String version;
	private Artifact artifact;
	
	private List<ImportFeature> importFeatures;
	private List<Bundle> bundles;

	private static OMFactory factory = OMAbstractFactory.getOMFactory();

	public CARArtifactFeatureManifest(Artifact artifact) {
		setArtifact(artifact);
    }
	
	/**
	 * @return the featureId
	 */
	public String getFeatureId() {
		return featureId;
	}

	/**
	 * @param featureId
	 *            the featureId to set
	 */
	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the importedFeatures
	 */
	public List<ImportFeature> getImportFeatures() {
		if (importFeatures == null) {
			importFeatures = new ArrayList<ImportFeature>();
		}
		return importFeatures;
	}

	public void addImportFeature(ImportFeature importFeature) {
		getImportFeatures().add(importFeature);
	}

	public void addImportFeature(String id, String version, String compatibility) {
		ImportFeature importFeature = new ImportFeature();
		importFeature.setFeatureId(id);
		importFeature.setVersion(version);
		importFeature.setCompatibility(compatibility);
		addImportFeature(importFeature);
	}

	private OMElement getDocumentElement() {
		OMElement featureElement = getElement("feature", "");
		addAttribute(featureElement, "id", getFeatureId());
		addAttribute(featureElement, "label", getFeatureId());
		addAttribute(featureElement, "version", getVersion());
		
		// FIXME provider name should be parameterised
		addAttribute(featureElement, "provider-name", "WSO2");
		
		featureElement.addChild(getDescriptionElement());
		featureElement.addChild(getCopyrightElement());
		featureElement.addChild(getLicenceElement());
		
		OMElement[] pluginElements = getPluginElements();
		for (OMElement element : pluginElements) {
			featureElement.addChild(element);
        }
		featureElement.addChild(getRequireElement());
		return featureElement;
	}
	
	private OMElement getDescriptionElement() {
	    return getElement("description",getFeatureId());
    }
	
	private OMElement getCopyrightElement() {
		return getElement("description","%copyright");
    }
	
	private OMElement getLicenceElement() {
		return addAttribute(getElement("licence", "%licence"),"url","%licenceURL");
	}
	
	private OMElement getRequireElement() {
		OMElement requireElement = getElement("require","");
		OMElement[] importFeatureElements = getImportFeatureElements();
		for (OMElement element : importFeatureElements) {
	        requireElement.addChild(element);
        }
		return requireElement;
    }
	
	private OMElement[] getImportFeatureElements() {
		List<OMElement> list=new ArrayList<OMElement>();
		for(ImportFeature importFeature:getImportFeatures()){
			list.add(getImportFeatureElement(importFeature));
		}
		return list.toArray(new OMElement[]{});
	}
	
	private OMElement[] getPluginElements() {
		List<OMElement> list=new ArrayList<OMElement>();
		for(Bundle bundle:getBundles()){
			OMElement element = getElement("plugin", "");
			addAttribute(element, "id", bundle.getName());
			addAttribute(element, "version", bundle.getVersion());
			addAttribute(element, "unpack", Boolean.toString(bundle.isUnpack()));
			list.add(element);
		}
		return list.toArray(new OMElement[]{});
	}
	
	private OMElement getImportFeatureElement(ImportFeature importFeature) {
		OMElement importElement = getElement("import", "");
		addAttribute(importElement, "feature", importFeature.getFeatureId());
		addAttribute(importElement, "version", importFeature.getVersion());
		addAttribute(importElement, "match", importFeature.getCompatibility());
		return importElement;
    }
	
	public void setArtifact(Artifact artifact) {
	    this.artifact = artifact;
	    setFeatureId(artifact.getName());
	    setVersion(artifact.getVersion());
	    List<ArtifactDependency> dependencies = artifact.getDependencies();
	    for (ArtifactDependency dependency : dependencies) {
	    	ImportFeature f = new ImportFeature();
	    	f.setFeatureId(dependency.getName());
	    	f.setVersion(dependency.getVersion());
	    	f.setCompatibility("equivalent");
	        getImportFeatures().add(f);
        }
    }

	public Artifact getArtifact() {
	    return artifact;
    }

	public void setBundles(List<Bundle> bundles) {
	    this.bundles = bundles;
    }

	public List<Bundle> getBundles() {
		if (bundles == null) {
			bundles = new ArrayList<Bundle>();
		}
	    return bundles;
    }

    protected String getDefaultName() {
	    return "feature.xml";
    }

    protected void deserialize(OMElement documentElement) {
	    
    }

    protected String serialize() {
		OMDocument document = factory.createOMDocument();
		document.addChild(getDocumentElement());
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
	        document.serialize(outputStream);
        } catch (XMLStreamException e) {
	        log.error(e);
	        return null;
        }
		return outputStream.toString();
	}
}
