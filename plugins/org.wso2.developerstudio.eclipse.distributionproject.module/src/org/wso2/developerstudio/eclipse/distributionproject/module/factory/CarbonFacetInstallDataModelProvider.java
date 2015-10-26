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

package org.wso2.developerstudio.eclipse.distributionproject.module.factory;

import org.eclipse.wst.common.componentcore.datamodel.FacetInstallDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.project.facet.core.ProjectFacetsManager;

public class CarbonFacetInstallDataModelProvider extends FacetInstallDataModelProvider {
	public CarbonFacetInstallDataModelProvider() {
		super();
		setDataModel(DataModelFactory.createDataModel(this));
	    setProperty(FACET_ID, "org.wso2.developerstudio.eclipse.carbon.facetId");
	    setProperty(FACET_VERSION, ProjectFacetsManager.getProjectFacet("org.wso2.developerstudio.eclipse.carbon.facetId").getVersion("1.0"));//new FacetVersion());
    }
}
