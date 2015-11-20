/*
 * Copyright (C) WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom;

import org.apache.synapse.message.processor.impl.AbstractMessageProcessor;

public class DummyMessageProcessor extends AbstractMessageProcessor {
	private String className;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public boolean start() {
		return false;
		// TODO Auto-generated method stub
		
	}

	public boolean stop() {
		return false;
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setDestroyed() {
		// TODO Auto-generated method stub
		
	}

	public boolean activate() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deactivate() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDeactivated() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPaused() {
		// TODO Auto-generated method stub
		return false;
	}

	public void pauseService() {
		// TODO Auto-generated method stub
		
	}

	public void resumeService() {
		// TODO Auto-generated method stub
		
	}

	public void cleanupLocalResources() {
		// TODO Auto-generated method stub
		
	}

}
