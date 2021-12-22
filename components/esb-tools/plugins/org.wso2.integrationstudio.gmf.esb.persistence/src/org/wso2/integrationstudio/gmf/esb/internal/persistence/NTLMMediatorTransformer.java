/*
* Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.Mediator;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.integrationstudio.gmf.esb.EsbNode;
import org.wso2.integrationstudio.gmf.esb.NTLMMediator;
import org.wso2.integrationstudio.gmf.esb.persistence.TransformationInfo;
import org.wso2.integrationstudio.gmf.esb.persistence.TransformerException;

public class NTLMMediatorTransformer extends AbstractEsbNodeTransformer{

    @Override
    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
     // Check subject.
        Assert.isTrue(subject instanceof NTLMMediator, "Invalid subject.");
        NTLMMediator visualLog = (NTLMMediator) subject;

        information.getParentSequence().addChild(createNTLMMediator(visualLog));
        // Transform the ntlm mediator output data flow path.
        doTransform(information, visualLog.getOutputConnector());
        
    }

    private Mediator createNTLMMediator(NTLMMediator visualNtlm) {
        org.apache.synapse.mediators.builtin.NTLMMediator ntlmMediator = new org.apache.synapse.mediators.builtin.NTLMMediator();
        setCommonProperties(ntlmMediator, visualNtlm);
        
        String username = visualNtlm.getUsername();
        String password = visualNtlm.getPassword();
        String host = visualNtlm.getHost();
        String domain = visualNtlm.getDomain();
        String ntlmVersion = visualNtlm.getNtlmVersion();
        
        if(username != null) {
            ntlmMediator.setUsername(username);
        }else {
            ntlmMediator.setUsername("");
        }
        if(password != null) {
            ntlmMediator.setPassword(password);
        }else {
            ntlmMediator.setPassword("");
        }
        if(host != null) {
            ntlmMediator.setHost(host);
        }else {
            ntlmMediator.setHost("");
        }
        if(domain != null) {
            ntlmMediator.setDomain(domain);
        }else {
            ntlmMediator.setDomain("");
        }
        if(ntlmVersion != null) {
            ntlmMediator.setNtlmVersion(ntlmVersion);
        }else {
            ntlmMediator.setNtlmVersion("");
        }
        
        return ntlmMediator;
    }

    @Override
    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
            throws TransformerException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        Assert.isTrue(subject instanceof NTLMMediator, "Invalid subject");
        NTLMMediator visualNtlm = (NTLMMediator) subject;
        org.apache.synapse.mediators.builtin.NTLMMediator ntlmMediator = (org.apache.synapse.mediators.builtin.NTLMMediator) createNTLMMediator(visualNtlm);
        
        sequence.addChild(ntlmMediator);
        doTransformWithinSequence(information, ((NTLMMediator) subject).getOutputConnector().getOutgoingLink(), sequence);
        
    }

}
