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

import java.util.List;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INITIAL_HASH_CODE_RESULT_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATOR_POSITION_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.HASHCODE_MULTIPLIER_VALUE;

/**
 * This class holds the mediator position in a ESB Artifact in the form of <code>List<<code>Interger<code>></code>.
 * <p>
 * Eg: {i,j,k,...}
 * <p>
 * <u1>
 * <li>i'th child mediator position with respect to artifact's bottom sequence</li>
 * <li>j'th child mediator position with respect to his parent</li>
 * <li>k'th child mediator position with respect to his parent ... so on</li> <u1>
 */
public class ESBMediatorPosition {

    private List<Integer> position;

    public ESBMediatorPosition(List<Integer> position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object mediatorPosition) {
        if (mediatorPosition instanceof ESBMediatorPosition) {
            if (getPosition().equals(((ESBMediatorPosition) mediatorPosition).getPosition())) {
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
        result = HASHCODE_MULTIPLIER_VALUE * result + getPosition().hashCode() + MEDIATOR_POSITION_LABEL.hashCode();
        return result;
    }

    public List<Integer> getPosition() {
        return position;
    }

    public void setPosition(List<Integer> position) {
        this.position = position;
    }

}
