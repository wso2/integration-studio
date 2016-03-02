/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_RESOURCE_METHOD_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.HASHCODE_MULTIPLIER_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INITIAL_HASH_CODE_RESULT_VALUE;

/**
 * This class holds attributes which identifies API Resource with in API
 * artifact uniquely and defined in ESB Mediation Debugger communication API's *
 * <p>
 * Attribute values this class holding are : <u1>
 * <li>Method</li>
 * <li>URLMapping</li>
 * <li>URITemplate</li><u1>
 */
public class ESBAPIResourceBean {

    private String method;
    private String urlMapping;
    private String uriTemplate;

    public ESBAPIResourceBean(String method, String uriMapping, String uriTemplate) {
        this.method = method;
        this.urlMapping = uriMapping;
        this.uriTemplate = uriTemplate;
    }

    @Override
    public boolean equals(Object apiBean) {
        if (apiBean instanceof ESBAPIResourceBean) {
            ESBAPIResourceBean apiBeanTemp = (ESBAPIResourceBean) apiBean;
            if (!(getMethod().equals((apiBeanTemp).getMethod()))) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = INITIAL_HASH_CODE_RESULT_VALUE;
        result = HASHCODE_MULTIPLIER_VALUE * result + getMethod().hashCode() + API_RESOURCE_METHOD_LABEL.hashCode();
        return result;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrlMapping() {
        return urlMapping;
    }

    public void setUrlMapping(String uriMapping) {
        this.urlMapping = uriMapping;
    }

    public String getUriTemplate() {
        return uriTemplate;
    }

    public void setUriTemplate(String uriTemplate) {
        this.uriTemplate = uriTemplate;
    }

}
