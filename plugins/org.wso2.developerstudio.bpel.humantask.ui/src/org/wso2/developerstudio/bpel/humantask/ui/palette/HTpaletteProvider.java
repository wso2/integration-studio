/**
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
 * 
 */
package org.wso2.developerstudio.bpel.humantask.ui.palette;

import org.eclipse.bpel.common.ui.palette.IPaletteProvider;
import org.eclipse.bpel.common.ui.palette.PaletteCategory;
import org.eclipse.bpel.ui.util.BPELCreationToolEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.wso2.developerstudio.bpel.humantask.model.ModelPackage;
import org.wso2.developerstudio.bpel.humantask.ui.factories.HTUIObjectFactory;

public class HTpaletteProvider implements IPaletteProvider{

	
	public void contributeItems(PaletteRoot paletteRoot) {
		
		PaletteCategory category = new PaletteCategory("BPEL4People");
		category.setCategoryId("bpel4peopel");
		category.setOrder(30);
		
		category
		.add(new BPELCreationToolEntry("Remote Task", "Remote Task Activity"
				, new HTUIObjectFactory(ModelPackage.eINSTANCE.getPeopleActivityRT())));
		category
		.add(new BPELCreationToolEntry("Remote Notification", "Remote Notification Activity"
				, new HTUIObjectFactory(ModelPackage.eINSTANCE.getPeopleActivityRN())));
		
		paletteRoot.add(category);
	}

}
