/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

import java.util.Iterator;
import java.util.Map;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.InvokeMediatorSerializer;
import org.apache.synapse.config.xml.ValueSerializer;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.template.InvokeMediator;

public class CloudConnectorOperationExtSerializer extends InvokeMediatorSerializer {
	
	@Override
	protected OMElement serializeSpecificMediator(Mediator m) {
		CloudConnectorOperationExt cloudConnectorOperation=(CloudConnectorOperationExt)m;
		OMElement mediatorElem = fac.createOMElement(cloudConnectorOperation.getConnectorComponentName()+"."+cloudConnectorOperation.getOperation(), synNS);
		saveTracingState(mediatorElem, cloudConnectorOperation);
		String configRef = cloudConnectorOperation.getConfigRef();
		if(configRef!=null && !configRef.equals("")){			
			mediatorElem.addAttribute(fac.createOMAttribute("configKey", nullNS, configRef));
		}
		serializeParams(mediatorElem, cloudConnectorOperation);
		return mediatorElem;
	}
	
    private void serializeParams(OMElement invokeElem, InvokeMediator mediator) {
        Map<String, Value> paramsMap = mediator.getpName2ExpressionMap();
        Iterator<String> paramIterator = paramsMap.keySet().iterator();
        while (paramIterator.hasNext()) {
            String paramName = paramIterator.next();
            if (!"".equals(paramName)) {
                OMElement paramEl = fac.createOMElement(paramName,
                		synNS);
                
                //serialize value attribute
                Value value = paramsMap.get(paramName);
                if (StringUtils.isNotBlank(value.getKeyValue()) || value.getExpression() != null) {
                	// Fixing TOOLS-2222 (do not serialize empty attributes)
                	new ValueSerializer().serializeTextValue(value, "value", paramEl);  
                	invokeElem.addChild(paramEl);
                }
                            
               // paramEl.setText(value.getKeyValue());
               // new ValueSerializer().serializeValue(value, "value", paramEl);
                
            }
        }

    }
	
    public String getMediatorClassName() {
        return CloudConnectorOperationExt.class.getName();
    }
}
