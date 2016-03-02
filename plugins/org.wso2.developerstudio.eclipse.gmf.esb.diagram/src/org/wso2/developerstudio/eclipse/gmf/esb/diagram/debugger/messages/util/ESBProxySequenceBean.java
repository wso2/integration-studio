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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.HASHCODE_MULTIPLIER_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INITIAL_HASH_CODE_RESULT_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROXY_LABEL;

/**
 * This class holds {@link ESBProxyBean} which identifies Proxy Artifact
 * uniquely and defined in ESB Mediation Debugger communication channel
 *
 */
public class ESBProxySequenceBean {

    private ESBProxyBean proxy;

    public ESBProxySequenceBean(ESBProxyBean proxy) {
        this.proxy = proxy;
    }

    @Override
    public boolean equals(Object proxySeqBean) {
        if (proxySeqBean instanceof ESBProxySequenceBean) {
            if (getProxy().equals(((ESBProxySequenceBean) proxySeqBean).getProxy())) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = INITIAL_HASH_CODE_RESULT_VALUE;
        result = HASHCODE_MULTIPLIER_VALUE * result + getProxy().hashCode() + PROXY_LABEL.hashCode();

        return result;
    }

    public ESBProxyBean getProxy() {
        return proxy;
    }

    public void setProxy(ESBProxyBean proxy) {
        this.proxy = proxy;
    }

}
