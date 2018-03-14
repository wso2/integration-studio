/*
 *     Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *     WSO2 Inc. licenses this file to you under the Apache License,
 *     Version 2.0 (the "License"); you may not use this file except
 *     in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 */
/*
 * Signature: saveWSDL(inputWsdl, fileName) {...}
 * 
 * This method saves generated wsdl dom with the modifications done in
 * generateWSDL methods into the WSDL file created. A WSDL dom(inputWSDL) and a
 * file name(fileName) should be provided as the parameters
 * 
 * 
 */
var HUMANTASK_CONTENT_FOLDER_NAME = "humantaskcontent";
var FILE_TYPE_WSDL = "wsdl";
var FILE_TYPE_XML = "xml";
/*Namespace Definitions*/
var HIC_NAMESPACE = "http://wso2.org/ht/schema/deployment/config";
var XSD_NAMESPACE = "http://www.w3.org/2001/XMLSchema";
var WSDL_NAMESPACE = "http://schemas.xmlsoap.org/wsdl/";
var SOAP_NAMESPACE = "http://schemas.xmlsoap.org/wsdl/soap/";
var BPEL_NAMESPACE = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803";
/*TagName Definitions*/
var SCHEMA_TAGNAME = "schema";
var DEFINITIONS_TAGNAME = "definitions";
var HT_DEPLOYMENT_CONFIG_TAGNAME = "HTDeploymentConfig";
var TASK_TAGNAME = "task";
var HUMAN_INTERACTIONS_TAGNAME = "humanInteractions";
/*Attribute Definitions*/
var NAME_ATTRIBUTE = "name";
var PORT_ATTRIBUTE = "port";
var TARGET_NAMESPACE_ATTRIBUTE = "targetNamespace";
var XMLNS_TASK_ATTRIBUTE = "xmlns:task";
var XMLNS_TNS_ATTRIBUTE = "xmlns:tns";
var TYPE_ATTRIBUTE = "type";
var ELEMENT_ATTRIBUTE = "element";
var MESSAGE_ATTRIBUTE = "message";
var STYLE_ATTRIBUTE = "style";
var TRANSPORT_ATTRIBUTE = "transport";
var SOAP_ACTION_ATTRIBUTE = "soapAction";
var BINDING_ATTRIBUTE = "binding";
var LOCATION_ATTRIBUTE = "location";

function saveWSDL(inputWsdl, fileName) {
    // Read contents of the file.
    wsdlContent = new XMLSerializer().serializeToString((inputWsdl));
    try {
        IDESaveContentWithExtention(wsdlContent, HUMANTASK_CONTENT_FOLDER_NAME, fileName, FILE_TYPE_WSDL);
    } catch (err) {
        handleError("Error saving WSDL" + err.message);
    }
}

function saveHTConfig(inputWsdl) {
    // Read contents of the file.
    htconfigContent = new XMLSerializer().serializeToString((inputWsdl));
    try {
        IDESaveContentWithExtention(htconfigContent, HUMANTASK_CONTENT_FOLDER_NAME, "htconfig", FILE_TYPE_XML);
    } catch (err) {
        handleError("Error saving HTConfig" + err.message);
    }
}

function generateHTConfig(configDom, xmlDom, currentTask) {
    currentTaskName = currentTask + "wrapper";
    serviceURL = $('#' + currentTaskName + ' #taskCallbackServiceURL').val();
    operationName = $('#' + currentTaskName + ' #taskCallbackOperationName')
        .val();
    serviceName = $('#' + currentTaskName + ' #taskCallbackServiceName').val();
    portName = currentTask + "Port";
    inputElements = $('#' + currentTaskName + ' #inputmappingTable tr');
    wsdlHTDeploymentConfig = configDom.getElementsByTagNameNS(HIC_NAMESPACE, HT_DEPLOYMENT_CONFIG_TAGNAME)[0];
    tasksList = xmlDom.getElementsByTagNameNS(BPEL_NAMESPACE, TASK_TAGNAME);
    if (xmlDom.getElementsByTagNameNS(BPEL_NAMESPACE, HUMAN_INTERACTIONS_TAGNAME).length != 0) {
        targetnamespace = xmlDom.getElementsByTagNameNS(BPEL_NAMESPACE, HUMAN_INTERACTIONS_TAGNAME)[0].getAttribute(TARGET_NAMESPACE_ATTRIBUTE);
        if (configDom.getElementsByTagNameNS(HIC_NAMESPACE, HT_DEPLOYMENT_CONFIG_TAGNAME).length != 0) {
            configDom.getElementsByTagNameNS(HIC_NAMESPACE, HT_DEPLOYMENT_CONFIG_TAGNAME)[0].setAttribute(XMLNS_TASK_ATTRIBUTE, targetnamespace);
        }
    }
    for (l = 0; l < tasksList.length; l++) {

        var taskName = tasksList[l].getAttribute(NAME_ATTRIBUTE);
        var divTaskName = taskName + "wrapper";
        newTask = configDom.createElementNS(HIC_NAMESPACE,
            "hic:task"); // scheme.appendchild()
        newTask.setAttribute(NAME_ATTRIBUTE, "task:" + taskName);
        newPublish = configDom.createElementNS(HIC_NAMESPACE,
            "hic:publish");
        newPublishService = configDom.createElementNS(HIC_NAMESPACE,
            "hic:service");
        newPublishService.setAttribute(NAME_ATTRIBUTE, "task:" + taskName + "Service");
        newPublishService.setAttribute(PORT_ATTRIBUTE, taskName + "Port");
        newPublish.appendChild(newPublishService);
        newCallback = configDom.createElementNS(HIC_NAMESPACE,
            "hic:callback");
        newCallbackService = configDom.createElementNS(HIC_NAMESPACE,
            "hic:service");
        newCallbackService.setAttribute(NAME_ATTRIBUTE, "task:" + $('#' + divTaskName + ' #taskCallbackServiceName').val());
        newCallbackService.setAttribute(PORT_ATTRIBUTE, taskName + "CBPort");
        newCallback.appendChild(newCallbackService);
        newTask.appendChild(newPublish);
        newTask.appendChild(newCallback);
        wsdlHTDeploymentConfig.appendChild(newTask);
    }
}

/*
 * Signature: generateInputWSDL(wsdlDom, currentTaskName) {...}
 * 
 * This method fills the empty wsdl DOM created for the new WSDL file with the
 * respective data. The data is acquired from the elements in the UI editor. The
 * initial WSDL DOM from the dummy wsdl(wsdlDom) and the current task
 * name(currentTaskName) should be provided.
 * 
 */
function generateInputWSDL(wsdlDom, xmlDom, currentTask) {
    currentTaskName = currentTask + "wrapper";
    // Get internal parameters
    serviceURL = "http://localhost:9763/services/" + currentTask + "Service";
    operationName = $('#' + currentTaskName + ' #taskOperation')
        .val();
    serviceName = currentTask + "Service";
    portName = currentTask + "Port";
    inputElements = $('#' + currentTaskName + ' #inputmappingTable tr');
    wsdlSchema = wsdlDom.getElementsByTagNameNS(XSD_NAMESPACE, SCHEMA_TAGNAME)[0];
    if (xmlDom.getElementsByTagNameNS(BPEL_NAMESPACE, HUMAN_INTERACTIONS_TAGNAME).length != 0) {
        targetnamespace = xmlDom.getElementsByTagNameNS(BPEL_NAMESPACE, HUMAN_INTERACTIONS_TAGNAME)[0].getAttribute(TARGET_NAMESPACE_ATTRIBUTE);
        if (wsdlDom.getElementsByTagNameNS(WSDL_NAMESPACE, DEFINITIONS_TAGNAME).length != 0) {
            wsdlDom.getElementsByTagNameNS(WSDL_NAMESPACE, DEFINITIONS_TAGNAME)[0].setAttribute(XMLNS_TNS_ATTRIBUTE, targetnamespace);
        }
        if (wsdlDom.getElementsByTagNameNS(WSDL_NAMESPACE, DEFINITIONS_TAGNAME).length != 0) {
            wsdlDom.getElementsByTagNameNS(WSDL_NAMESPACE, DEFINITIONS_TAGNAME)[0].setAttribute(TARGET_NAMESPACE_ATTRIBUTE, targetnamespace);
        }
        wsdlSchema.setAttribute(TARGET_NAMESPACE_ATTRIBUTE, targetnamespace);
    }
    // get Definitions node and Schema node from dummy wsdl dom
    wsdlSchema = wsdlDom.getElementsByTagNameNS(XSD_NAMESPACE, SCHEMA_TAGNAME)[0];
    wsdlDefinitions = wsdlDom.getElementsByTagNameNS(WSDL_NAMESPACE, DEFINITIONS_TAGNAME)[0];

    // create Data type elements
    newComplexType = wsdlDom.createElementNS(
        XSD_NAMESPACE, "xsd:complexType");
    newComplexType.setAttribute(NAME_ATTRIBUTE, currentTask + "DataType"); // Data type Name
    newSequence = wsdlDom.createElementNS(XSD_NAMESPACE,
        "xsd:sequence");

    // Loop towards the rows of input data mapping table
    inputElements.each(function(i, obj) {
        if (i != 0) { // skip header
            k = $(this).find("input#taskInputMappingid").val();
            type = $("#" + currentTaskName + " #taskInputMappingType" + k)
                .val();
            newSubElement = wsdlDom.createElementNS(
                XSD_NAMESPACE, "xsd:element");
            newSubElement.setAttribute(NAME_ATTRIBUTE, $(this).find(
                "input#taskInputMappingElementName" + k).val()); // Data
            newSubElement.setAttribute(TYPE_ATTRIBUTE, type); // Data element (Input)
            newSequence.appendChild(newSubElement);
        }
    });
    newComplexType.appendChild(newSequence);

    // create Element element
    newElement = wsdlDom.createElementNS(XSD_NAMESPACE,
        "xsd:element"); // scheme.appendchild()
    newElement.setAttribute(NAME_ATTRIBUTE, currentTask + "Data");
    newElement.setAttribute(TYPE_ATTRIBUTE, "tns:" + currentTask + "DataType");
    wsdlSchema.appendChild(newElement);
    wsdlSchema.appendChild(newComplexType);

    // create Message element
    newMessage = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:message");
    newMessage.setAttribute(NAME_ATTRIBUTE, currentTask + "Request");
    newPart = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:part");
    newPart.setAttribute(NAME_ATTRIBUTE, newMessage.getAttribute(NAME_ATTRIBUTE));
    newPart.setAttribute(ELEMENT_ATTRIBUTE, "tns:" + newElement.getAttribute(NAME_ATTRIBUTE)); // Data binding
    newMessage.appendChild(newPart);
    wsdlDefinitions.appendChild(newMessage);

    // create portType element
    newPortType = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:portType");
    newPortType.setAttribute(NAME_ATTRIBUTE, currentTask + "PT"); // Interface PortType
    newOperation = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:operation");
    newOperation.setAttribute(NAME_ATTRIBUTE, operationName); // Interface Operation
    newInput = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:input");
    newInput.setAttribute(MESSAGE_ATTRIBUTE, "tns:" + newMessage.getAttribute(NAME_ATTRIBUTE)); // message binding
    newOperation.appendChild(newInput);
    newPortType.appendChild(newOperation);
    wsdlDefinitions.appendChild(newPortType);

    // create Binding element
    newBinding = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:binding");
    newBinding.setAttribute(NAME_ATTRIBUTE, currentTask + "Binding"); // Data element name
    newBinding.setAttribute(TYPE_ATTRIBUTE, "tns:" + newPortType.getAttribute(NAME_ATTRIBUTE)); // PortTypeName
    newSoapBinding = wsdlDom.createElementNS(
        SOAP_NAMESPACE, "soap:binding");
    newSoapBinding.setAttribute(STYLE_ATTRIBUTE, "document"); // part element
    newSoapBinding.setAttribute(TRANSPORT_ATTRIBUTE,
        "http://schemas.xmlsoap.org/soap/http"); // tns:complextypename
    newWSDLBindingOperation = wsdlDom.createElementNS(
        WSDL_NAMESPACE, "wsdl:operation");
    newWSDLBindingOperation.setAttribute(NAME_ATTRIBUTE, operationName); // Operation
    // Name
    newWSDLBindingSoapOperation = wsdlDom.createElementNS(
        SOAP_NAMESPACE, "soap:operation");
    newWSDLBindingSoapOperation.setAttribute(SOAP_ACTION_ATTRIBUTE, "urn:" + operationName);
    newWSDLBindingSoapOperation.setAttribute(STYLE_ATTRIBUTE, "document");
    newWSDLBindingInput = wsdlDom.createElementNS(
        WSDL_NAMESPACE, "wsdl:input");
    newSoapInputBody = wsdlDom.createElementNS(
        SOAP_NAMESPACE, "soap:body");
    newSoapInputBody.setAttribute("use", "literal");
    newWSDLBindingInput.appendChild(newSoapInputBody);
    newWSDLBindingOperation.appendChild(newWSDLBindingSoapOperation);
    newWSDLBindingOperation.appendChild(newWSDLBindingInput);
    newBinding.appendChild(newSoapBinding);
    newBinding.appendChild(newWSDLBindingOperation);
    wsdlDefinitions.appendChild(newBinding);

    // create service element
    newService = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:service");
    newService.setAttribute(NAME_ATTRIBUTE, serviceName); // Data element name
    newPort = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:port");
    newPort.setAttribute(NAME_ATTRIBUTE, portName); // part element
    newPort.setAttribute(BINDING_ATTRIBUTE, "tns:" + newBinding.getAttribute(NAME_ATTRIBUTE)); // tns:complextypename
    newAddress = wsdlDom.createElementNS(
        SOAP_NAMESPACE, "soap:address");
    newAddress.setAttribute(LOCATION_ATTRIBUTE, serviceURL); // Service URL
    newPort.appendChild(newAddress);
    newService.appendChild(newPort);
    wsdlDefinitions.appendChild(newService);

}

/*
 * Signature: generateOutputWSDL(wsdlDom, currentTaskName) {...}
 * 
 * This method fills the empty wsdl DOM created for the new WSDL file with the
 * respective callback service data. The data is acquired from the elements in
 * the UI editor. The initial WSDL DOM from the dummy wsdl(wsdlDom) and the
 * current task name(currentTaskName) should be provided.
 * 
 */
function generateOutputWSDL(wsdlDom, xmlDom, currentTask, serviceURL, operationName, serviceName, outputElements) {
    currentTaskName = currentTask + "wrapper";
    portName = currentTask + "CBPort";
    // get Definitions
    wsdlSchema = wsdlDom.getElementsByTagNameNS(XSD_NAMESPACE, SCHEMA_TAGNAME)[0];
    wsdlDefinitions = wsdlDom.getElementsByTagNameNS(WSDL_NAMESPACE, DEFINITIONS_TAGNAME)[0];
    // create types(data)
    newComplexType = wsdlDom.createElementNS(
        XSD_NAMESPACE, "xsd:complexType");
    newComplexType.setAttribute(NAME_ATTRIBUTE, currentTask + "CBDataType"); // Data type Name
    if (xmlDom.getElementsByTagNameNS(BPEL_NAMESPACE, HUMAN_INTERACTIONS_TAGNAME).length != 0) {
        targetnamespace = xmlDom.getElementsByTagNameNS(BPEL_NAMESPACE, HUMAN_INTERACTIONS_TAGNAME)[0].getAttribute(TARGET_NAMESPACE_ATTRIBUTE);
        if (wsdlDom.getElementsByTagNameNS(WSDL_NAMESPACE, DEFINITIONS_TAGNAME).length != 0) {
            wsdlDom.getElementsByTagNameNS(WSDL_NAMESPACE, DEFINITIONS_TAGNAME)[0].setAttribute(XMLNS_TNS_ATTRIBUTE, targetnamespace);
        }
        if (wsdlDom.getElementsByTagNameNS(WSDL_NAMESPACE, DEFINITIONS_TAGNAME).length != 0) {
            wsdlDom.getElementsByTagNameNS(WSDL_NAMESPACE, DEFINITIONS_TAGNAME)[0].setAttribute(TARGET_NAMESPACE_ATTRIBUTE, targetnamespace);
        }
        wsdlSchema.setAttribute(TARGET_NAMESPACE_ATTRIBUTE, targetnamespace);
    }
    newSequence = wsdlDom.createElementNS(XSD_NAMESPACE,
        "xsd:sequence");
    // should loop for input types
    outputElements.each(function(i, obj) {
        if (i != 0) {
            k = $(this).find("input#taskOutputMappingid").val();
            type = $("#" + currentTaskName + " #taskOutputMappingType" + k)
                .val();
            newSubElement = wsdlDom.createElementNS(
                XSD_NAMESPACE, "xsd:element");
            newSubElement.setAttribute(NAME_ATTRIBUTE, $(this).find(
                "input#taskOutputMappingElementName" + k).val()); // Data element name field
            newSubElement.setAttribute(TYPE_ATTRIBUTE, type); // Data element type field
            newSequence.appendChild(newSubElement);
        }
    });

    // should loop for input types
    newComplexType.appendChild(newSequence);

    // createElement
    newElement = wsdlDom.createElementNS(XSD_NAMESPACE,
        "xsd:element");
    newElement.setAttribute(NAME_ATTRIBUTE, currentTask + "CBData"); // part element
    newElement.setAttribute(TYPE_ATTRIBUTE, "tns:" + currentTask + "CBDataType"); // tns: complextypename
    wsdlSchema.appendChild(newElement);
    wsdlSchema.appendChild(newComplexType);
    // create message
    newMessage = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:message");
    newMessage.setAttribute(NAME_ATTRIBUTE, currentTask + "CBResponse");
    newPart = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:part");
    newPart.setAttribute(NAME_ATTRIBUTE, newMessage.getAttribute(NAME_ATTRIBUTE)); // ClaimApprovalRequest
    newPart.setAttribute(ELEMENT_ATTRIBUTE, "tns:" + newElement.getAttribute(NAME_ATTRIBUTE)); // Data binding
    newMessage.appendChild(newPart);
    wsdlDefinitions.appendChild(newMessage);
    // create portType
    newPortType = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:portType");
    newPortType.setAttribute(NAME_ATTRIBUTE, currentTask + "CBPT"); // Interface PortType
    newOperation = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:operation");
    newOperation.setAttribute(NAME_ATTRIBUTE, operationName); // Interface Operation
    newInput = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:input");
    newInput.setAttribute(MESSAGE_ATTRIBUTE, "tns:" + newMessage.getAttribute(NAME_ATTRIBUTE)); // message binding
    newOperation.appendChild(newInput);
    newPortType.appendChild(newOperation);
    wsdlDefinitions.appendChild(newPortType);
    // {create service element}
    newBinding = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:binding");
    newBinding.setAttribute(NAME_ATTRIBUTE, currentTask + "CBBinding"); // Data element name
    newBinding.setAttribute(TYPE_ATTRIBUTE, "tns:" + newPortType.getAttribute(NAME_ATTRIBUTE)); // PortTypeName
    newSoapBinding = wsdlDom.createElementNS(
        SOAP_NAMESPACE, "soap:binding");
    newSoapBinding.setAttribute(STYLE_ATTRIBUTE, "document"); // part element
    newSoapBinding.setAttribute(TRANSPORT_ATTRIBUTE,
        "http://schemas.xmlsoap.org/soap/http"); // tns: complextypename
    newWSDLBindingOperation = wsdlDom.createElementNS(
        WSDL_NAMESPACE, "wsdl:operation");
    newWSDLBindingOperation.setAttribute(NAME_ATTRIBUTE, operationName); // Operation Name
    newWSDLBindingSoapOperation = wsdlDom.createElementNS(
        SOAP_NAMESPACE, "soap:operation");
    newWSDLBindingSoapOperation.setAttribute(SOAP_ACTION_ATTRIBUTE, "urn:" + operationName);
    newWSDLBindingSoapOperation.setAttribute(STYLE_ATTRIBUTE, "document");
    newWSDLBindingInput = wsdlDom.createElementNS(
        WSDL_NAMESPACE, "wsdl:input");
    newSoapInputBody = wsdlDom.createElementNS(
        SOAP_NAMESPACE, "soap:body");
    newSoapInputBody.setAttribute("use", "literal");
    newWSDLBindingInput.appendChild(newSoapInputBody);
    newWSDLBindingOperation.appendChild(newWSDLBindingSoapOperation);
    newWSDLBindingOperation.appendChild(newWSDLBindingInput);
    newBinding.appendChild(newSoapBinding);
    newBinding.appendChild(newWSDLBindingOperation);
    wsdlDefinitions.appendChild(newBinding);
    // {create binding}
    newService = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:service");
    newService.setAttribute(NAME_ATTRIBUTE, serviceName); // Data element name
    newPort = wsdlDom.createElementNS(WSDL_NAMESPACE,
        "wsdl:port");
    newPort.setAttribute(NAME_ATTRIBUTE, portName); // part element
    newPort.setAttribute(BINDING_ATTRIBUTE, "tns:" + newBinding.getAttribute(NAME_ATTRIBUTE)); // tns:complextypename
    newAddress = wsdlDom.createElementNS(
        SOAP_NAMESPACE, "soap:address");
    newAddress.setAttribute(LOCATION_ATTRIBUTE, serviceURL); // Service URL
    newPort.appendChild(newAddress);
    newService.appendChild(newPort);
    wsdlDefinitions.appendChild(newService);

}