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

package org.wso2.developerstudio.eclipse.utils.internal.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class TempFileTag implements ITemporaryFileTag {
	private String id;
	private boolean tagEnded;
	private List<File> locations;
	
	public TempFileTag(String id) {
	    setId(id);
    }
	
	public TempFileTag() {
	    setId(String.valueOf(Calendar.getInstance().getTime().getTime()));
    }
	
	private void setId(String id) {
	    this.id = id;
    }
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.utils.internal.model.ITemporaryFileTag#getId()
     */
	public String getId() {
	    return id;
    }
	private void setTagEnded(boolean tagEnded) {
	    this.tagEnded = tagEnded;
    }
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.utils.internal.model.ITemporaryFileTag#isTagEnded()
     */
	public boolean isTagEnded() {
	    return tagEnded;
    }

	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.utils.internal.model.ITemporaryFileTag#getLocations()
     */
	public List<File> getLocations() {
		if (locations==null){
			locations=new ArrayList<File>();
		}
	    return locations;
    }
	
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.utils.internal.model.ITemporaryFileTag#removeMe()
     */
	public void removeMe() {

    }
	
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.utils.internal.model.ITemporaryFileTag#clear()
     */
	public void clear(){
		for(File file:getLocations()){
			if (file.exists()){
				if (file.isFile()){
					boolean isFileDeleted = org.apache.commons.io.FileUtils.deleteQuietly(file);
					if(!isFileDeleted){
						file.deleteOnExit();
					}
				}else{
					FileUtils.deleteDirectories(file);
				}
			}
		}
	}
	
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.utils.internal.model.ITemporaryFileTag#endTag()
     */
	public void endTag() {
	    setTagEnded(true);
    }
	
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.utils.internal.model.ITemporaryFileTag#pauseTag()
     */
	public void pauseTag() {
		endTag();
    }
	
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.utils.internal.model.ITemporaryFileTag#clearAndEnd()
     */
	public void clearAndEnd(){
		clear();
		endTag();
	}
	
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.utils.internal.model.ITemporaryFileTag#restartTag()
     */
	public void restartTag(){
		setTagEnded(false);
	}
	
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.utils.internal.model.ITemporaryFileTag#resumeTag()
     */
	public void resumeTag() {
		restartTag();
    }
}
