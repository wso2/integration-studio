/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.esb.project.ui.wizard;

import java.io.File;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.wso2.integrationstudio.platform.core.manifest.AbstractXMLDoc;

public class ConnectorExporter extends AbstractXMLDoc{

	private String connectorExporterName = null;
	private String connectorExporterFilePath = null;
	public void setConnectorExporterFilePath(String connectorExporterFilePath) {
        this.connectorExporterFilePath = connectorExporterFilePath;
    }

    final String CONNECTOR_NATURE = "org.wso2.developerstudio.eclipse.artifact.connector.project.nature";

	public String getConnectorExporterName() {
		return connectorExporterName;
	}

	public void setConnectorExporterName(String connectorExporterName) {
		this.connectorExporterName = connectorExporterName;
	}


	@Override
	protected void deserialize(OMElement documentElement) throws Exception {	
	    
	    List<OMElement> natures = getChildElements(documentElement, "natures");
	    
	    for (OMElement omElement : natures) {
	        String nature = getChildElements(omElement, "nature").get(0).getText();
	        if(nature != null && CONNECTOR_NATURE.equals(nature)) {
	            String name = getChildElements(documentElement, "name").get(0).getText();
	            setConnectorExporterName(name);
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

    public String getConnectorExporterFilePath() {
        
        return connectorExporterFilePath;
    }


}
