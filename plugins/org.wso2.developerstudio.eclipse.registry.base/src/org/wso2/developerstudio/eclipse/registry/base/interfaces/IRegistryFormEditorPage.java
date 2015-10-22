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

package org.wso2.developerstudio.eclipse.registry.base.interfaces;

public interface IRegistryFormEditorPage {
	public final static int ACTION_ADD_ASSOCIATION = 0;
	public final static int ACTION_ADD_COLLECTION = 1;
	public final static int ACTION_ADD_COMMENT = 2;
	public final static int ACTION_ADD_DEPENDENCY = 3;
	public final static int ACTION_ADD_PROPERTY = 4;
	public final static int ACTION_ADD_RESOURCE = 5;
	public final static int ACTION_ADD_TAGS = 6;
	public final static int ACTION_VIEW_INFORMATION = 7;

	public final static int PAGE_ASSOCIATIONS = 0;
	public final static int PAGE_COLLECTION = 1;
	public final static int PAGE_COMMENTS = 2;
	public final static int PAGE_DEPENDENCY = 3;
	public final static int PAGE_PROPERTIES = 4;
	public final static int PAGE_RESOURCE = 5;
	public final static int PAGE_TAGS = 6;

	public void executeAction(int actionID, Object object);

	public int getPageType();

	public void validate() throws Exception;

	public void doFinish() throws Exception;

	public boolean isPageDirty();

}
