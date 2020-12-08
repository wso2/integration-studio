/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.distribution.project.model;

import org.apache.maven.model.Dependency;

public class DependencyData {
private Dependency dependency;
private String cApptype= "";
private Object self;
private Object parent;
private String serverRole;

/**
 * @return the dependency
 */
public Dependency getDependency() {
	return dependency;
}
/**
 * @param dependency the dependency to set
 */
public void setDependency(Dependency dependency) {
	this.dependency = dependency;
}
/**
 * @return the cApptype
 */
public String getCApptype() {
	return cApptype;
}
/**
 * @param cApptype the cApptype to set
 */
public void setCApptype(String cApptype) {
	this.cApptype = cApptype;
}
/**
 * @return the self
 */
public Object getSelf() {
	return self;
}
/**
 * @param self the self to set
 */
public void setSelf(Object self) {
	this.self = self;
}
/**
 * @return the parent
 */
public Object getParent() {
	return parent;
}
/**
 * @param parent the parent to set
 */
public void setParent(Object parent) {
	this.parent = parent;
}

public void setServerRole(String serverRole) {
	this.serverRole = serverRole;
}

public String getServerRole() {
	return serverRole;
}

}
