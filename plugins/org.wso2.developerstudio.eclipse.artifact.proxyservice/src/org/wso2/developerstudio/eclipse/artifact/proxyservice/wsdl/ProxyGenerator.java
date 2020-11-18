/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.proxyservice.wsdl;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.AnonymousListMediator;
import org.apache.synapse.config.xml.SwitchCase;
import org.apache.synapse.core.axis2.ProxyService;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.RespondMediator;
import org.apache.synapse.mediators.filters.SwitchMediator;
import org.apache.synapse.mediators.transform.PayloadFactoryMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.jaxen.JaxenException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ProxyGenerator {
    private static final String PAYLOAD_FACTORY_OPERATION_FORMAT = "<message>Action %s is not implemented</message>";
    private static final String PAYLOAD_FACTORY_ACTION_NOT_FOUND = "<message>Action not implemented</message>";
    private static final String XML_TYPE = "xml";
    private static final String SOAP_ACTION_PATH = "get-property('Action')";
    private static final String DEFAULT_REGEX = ".*+";
    private static final ArrayList<String> TRANSPORT_LIST = new ArrayList<String>(Arrays.asList("http", "https"));

    /**
     * Generates a Synapse ProxyService with a SwitchMediator with the provided SOAP operations
     *
     * @param proxyServiceName Name of the proxy service that needs to be generated
     * @param operations List of operations for the Switch cases to be generated
     * @param wsdlUrl WSDL URL of the original WebService whose operations were extracted
     * @return Synapse Proxy Service with generated SwitchMediator and dummy PayloadFactory mediator
     */
    public static ProxyService generateProxyWithOperations(String proxyServiceName, List<String> operations,
            String wsdlUrl) {
        ProxyService proxyService = new ProxyService(proxyServiceName);
        proxyService.setTransports(TRANSPORT_LIST);

        // Create Target Sequence for the proxy
        SequenceMediator inlineTargetSeq = new SequenceMediator();
        inlineTargetSeq.addChild(generateSwitchMediator(operations));
        inlineTargetSeq.addChild(new RespondMediator());

        proxyService.setTargetInLineInSequence(inlineTargetSeq);
        try {
            proxyService.setWsdlURI(new URI(wsdlUrl));
        } catch (URISyntaxException e) {
            // TODO: Add proper logger here
            e.printStackTrace();
        }
        return proxyService;
    }

    /**
     * Generates a Switch mediator with Switch cases for each operation provided.
     *
     * @param operations List of operations for the Switch cases to be generated
     * @return Synapse Switch Mediator
     */
    public static SwitchMediator generateSwitchMediator(List<String> operations) {
        SwitchMediator switchMediator = new SwitchMediator();
        SynapseXPath xpath = null;
        try {
            xpath = new SynapseXPath(SOAP_ACTION_PATH);
        } catch (JaxenException e) {
            // TODO: Add proper logger here
            e.printStackTrace();
        }
        switchMediator.setSource(xpath);

        // Create the switch cases
        for (String operation : operations) {
            SwitchCase switchCase = new SwitchCase();
            switchCase.setRegex(Pattern.compile(operation));
            switchMediator.addCase(addSwitchCaseChild(switchCase, genDummyPayloadFacForOperation(operation)));
        }

        // create default case for Switch mediator
        SwitchCase defaultSwitchCase = new SwitchCase();
        defaultSwitchCase.setRegex(Pattern.compile(DEFAULT_REGEX));
        switchMediator.addCase(addSwitchCaseChild(defaultSwitchCase, genDummyPayloadFacForOperation("")));

        return switchMediator;
    }

    /**
     * Generates a Payload Factory mediator with an inline template with the operation Name in it
     *
     * @param operationName Operation Name to be included in the PayloadFactory inline text
     * @return Synapse PayloadFactory Mediator
     */
    public static PayloadFactoryMediator genDummyPayloadFacForOperation(String operationName) {
        PayloadFactoryMediator pf = new PayloadFactoryMediator();
        if (StringUtils.isEmpty(operationName)) {
            pf.setFormat(PAYLOAD_FACTORY_ACTION_NOT_FOUND);
        } else {
            pf.setFormat(String.format(PAYLOAD_FACTORY_OPERATION_FORMAT, operationName));
        }
        pf.setType(XML_TYPE);
        return pf;
    }

    /**
     * Attaches the provided childMediator to the SwitchCase mediator and returns it
     *
     * @param switchCase SwitchCase to attach the childMediator
     * @param childMediator Child mediator that was generated
     * @return Synapse Switchcase with Child mediator attached
     */
    private static SwitchCase addSwitchCaseChild(SwitchCase switchCase, Mediator childMediator) {
        AnonymousListMediator anonymousListMediator = new AnonymousListMediator();
        anonymousListMediator.addChild(childMediator);
        switchCase.setCaseMediator(anonymousListMediator);
        return switchCase;
    }
}
