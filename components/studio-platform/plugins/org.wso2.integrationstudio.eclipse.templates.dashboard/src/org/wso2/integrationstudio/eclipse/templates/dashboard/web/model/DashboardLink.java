/**
 * Copyright 2009-2018 WSO2, Inc. (http://wso2.com)
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

package org.wso2.integrationstudio.eclipse.templates.dashboard.web.model;

public class DashboardLink {

    private String id;
    private String title;
    private String linkImage;
    private String name;
    private int priority = Integer.MAX_VALUE;
    private String description;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toJson() {
        return "{ \"id\" :\"" + id + "\", \"name\":\"" + name + "\", \"priority\":\"" + priority
                + "\", \"description\":\"" + description + "\", \"title\":\"" + title + "\", \"image\":\"" + linkImage + "\"}";
    }

    @Override
    public String toString() {
        return name + "[" + id + "]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String imgPath) {
        this.linkImage = imgPath;
    }

}
