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

package org.wso2.developerstudio.eclipse.logging.internal.impl;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.wso2.developerstudio.eclipse.logging.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;

public class DeveloperStudioLog implements IDeveloperStudioLog {
	private String pluginId;
	private Class<Object> classObj;
	private static final ILog LOG=Activator.getDefault().getLog();
	
	public DeveloperStudioLog(String pluginId) {
		setPluginId(pluginId);
    }
	
	public DeveloperStudioLog(String pluginId, Class<Object> classObj) {
		setPluginId(pluginId);
		setClassObj(classObj);
    }
	
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.logging.internal.impl.IDeveloperStudioLog#setPluginId(java.lang.String)
     */
	public void setPluginId(String pluginId) {
	    this.pluginId = pluginId;
    }
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.logging.internal.impl.IDeveloperStudioLog#getPluginId()
     */
	public String getPluginId() {
	    return pluginId;
    }

	public static ILog getLog() {
	    return LOG;
    }

	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.logging.internal.impl.IDeveloperStudioLog#setClassObj(java.lang.Class)
     */
	public void setClassObj(Class<Object> classObj) {
	    this.classObj = classObj;
    }

	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.logging.internal.impl.IDeveloperStudioLog#getClassObj()
     */
	public Class<Object> getClassObj() {
	    return classObj;
    }

	private String getWrappedMessage(String message){
		if (getClassObj()==null){
			return message;
		}else{
			return classObj.getName()+": "+message;
		}
	}
	
	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.logging.internal.impl.IDeveloperStudioLog#info(java.lang.String)
     */
	public void info(String message){
		info(message, null);
	}

	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.logging.internal.impl.IDeveloperStudioLog#info(java.lang.String, java.lang.Exception)
     */
	public void info(String message, Exception e){
		log(getStatusObject(IStatus.INFO, message, e));
	}

	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.logging.internal.impl.IDeveloperStudioLog#warn(java.lang.String)
     */
	public void warn(String message){
		warn(message, null);
	}

	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.logging.internal.impl.IDeveloperStudioLog#warn(java.lang.String, java.lang.Exception)
     */
	public void warn(String message, Exception e){
		log(getStatusObject(IStatus.WARNING, message, e));
	}

	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.logging.internal.impl.IDeveloperStudioLog#error(java.lang.String)
     */
	public void error(String message){
		error(message,null);
	}

	/* (non-Javadoc)
     * @see org.wso2.developerstudio.eclipse.logging.internal.impl.IDeveloperStudioLog#error(java.lang.String, java.lang.Exception)
     */
	public void error(String message, Exception e){
		log(getStatusObject(IStatus.ERROR, message, e));
	}

	private void log(IStatus status){
		getLog().log(status);
	}
	
	private IStatus getStatusObject(int severity, String msg, Exception exception){
		IStatus result;
		if (exception==null){
			result=new Status(severity,getPluginId(),msg==null?"<NO_MESSAGE>":getWrappedMessage(msg));
		}else{
			result=new Status(severity,getPluginId(),msg==null?exception.getMessage():getWrappedMessage(msg),exception);
			exception.printStackTrace();
		}
		return result;
	}

    public void error(Exception e) {
    	error(null, e);
    }

    public void error(Throwable e) {
    	error(null, new Exception(e));
    }
    
	public void error(String message, Throwable e){
		error(message, new Exception(e));
	}

    public void info(Throwable e) {
    	info(null, new Exception(e));
    }
    
	public void info(String message, Throwable e){
		info(message, new Exception(e));
	}
	
    public void warn(Throwable e) {
    	warn(null, new Exception(e));
    }
    
	public void warn(String message, Throwable e){
		warn(message, new Exception(e));
	}
}
