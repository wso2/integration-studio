/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

function makeDirty() {
    IDESetDirty(true);
}

/*
 * Signature: CreateFile(currentTaskName){...}
 * 
 * This method generates WSDL files related to the Tasks. It copies content from
 * the dummy wsdl file in the project and creates new wsdl with the intended
 * name. Then a DOM from the created dummy is created and sent to further
 * processing. The Task Name which is used for generating the wsdl should be
 * given.
 * 
 * 
 */
function CreateFile(currentTaskName) { //createFile

    // Create Task WSDL
    $.get('resources/dummy.wsdl', function(data) {
        try {
            wsdlDom = marshalEditorTextContent(data);
            generateInputWSDL(wsdlDom, currentTaskName);
            SaveWSDL(wsdlDom, currentTaskName + "Task");

        } catch (err) {
            alert(err);
        }

    });
    // Create Task Callback WSDL
    $.get('resources/dummy.wsdl', function(data) {
        try {
            wsdlCBDom = marshalEditorTextContent(data);
            generateOutputWSDL(wsdlCBDom, currentTaskName);
            SaveWSDL(wsdlCBDom, currentTaskName + "CBTask");

        } catch (err) {
            alert(err);
        }

    });
}

/*
 * Signature: AddTask(){...}
 * 
 * This method generates creates a new task. This method add a dummy task node into the ht file and adds a new task tab and Ui elements respectively
 * 
 * 
 */
function AddTask() { //createFile
     $.get('resources/dummytask.ht', function(data) {
        try {
            taskPartDom = marshalEditorTextContent(data);
            tasks = xmlDom.getElementsByTagName("tasks")[0];
            alert(taskPartDom.getElementsByTagName("task")[0]);
            i = parseInt($('#nooftasks').val());
            alert("inside" + i);
            taskPartDom.getElementsByTagName("task")[0].setAttribute("name", i + "approveClaim");

            //xmlDom.adoptNode(taskPartDom);
            xmlDom.getElementsByTagName("tasks")[0].appendChild(xmlDom.importNode(taskPartDom.getElementsByTagName("task")[0], true));
            IDESaveContent(new XMLSerializer().serializeToString((xmlDom)));
            generateUI();
        } catch (err) {
            alert(err);
        }

    });
 }

/*
 * Signature: SaveWSDL(inputWsdl, fileName) {...}
 * 
 * This method saves generated wsdl dom with the modifications done in
 * generateWSDL methods into the WSDL file created. A WSDL dom(inputWSDL) and a
 * file name(fileName) should be provided as the parameters
 * 
 * 
 */
function SaveWSDL(inputWsdl, fileName) {
    // Read contents of the file.
    wsdlContent = new XMLSerializer().serializeToString((inputWsdl));
    try {
        IDESaveContentWithExtention(wsdlContent, "", fileName, "wsdl");
    } catch (err) {
        alert(err);
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
function generateInputWSDL(wsdlDom, currentTask) {
    currentTaskName = currentTask + "wrapper";
    // Get internal parameters
    serviceURL = $('#' + currentTaskName + ' #taskCallbackServiceURL').val();
    operationName = $('#' + currentTaskName + ' #taskCallbackOperationName')
        .val();
    serviceName = $('#' + currentTaskName + ' #taskCallbackServiceName').val();
    portName = currentTask + "Port";
    inputElements = $('#' + currentTaskName + ' #inputmappingTable tr');

    // get Definitions node and Schema node from dummy wsdl dom
    wsdlSchema = wsdlDom.getElementsByTagName("schema")[0];
    wsdlDefinitions = wsdlDom.getElementsByTagName("definitions")[0];

    // create Data type elements
    newComplexType = wsdlDom.createElementNS(
        "http://www.w3.org/2001/XMLSchema", "xsd:complexType");
    newComplexType.setAttribute("name", currentTask + "DataType"); // Data type
    // Name
    newSequence = wsdlDom.createElementNS("http://www.w3.org/2001/XMLSchema",
        "xsd:sequence");

    // Loop towards the rows of input data mapping table
    inputElements.each(function(i, obj) {
        if (i != 0) { // skip header
            k = $(this).find("input#taskInputMappingid").val();
            type = "xsd:" + $("#" + currentTaskName + " #taskInputMappingType" + k)
                .val();
            newSubElement = wsdlDom.createElementNS(
                "http://www.w3.org/2001/XMLSchema", "xsd:element");
            newSubElement.setAttribute("name", $(this).find(
                "input#taskInputMappingElementName" + k).val()); // Data
            // element
            // (Input
            // Data
            // Mapping)
            // name
            // field
            newSubElement.setAttribute("type", type); // Data element (Input
            // Data Mapping) type
            // field
            newSequence.appendChild(newSubElement);
        }
    });
    newComplexType.appendChild(newSequence);

    // create Element element
    newElement = wsdlDom.createElementNS("http://www.w3.org/2001/XMLSchema",
        "xsd:element"); // scheme.appendchild()
    newElement.setAttribute("name", currentTask + "Data");
    newElement.setAttribute("type", "tns:" + currentTask + "DataType");
    wsdlSchema.appendChild(newElement);
    wsdlSchema.appendChild(newComplexType);

    // create Message element
    newMessage = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:message");
    newMessage.setAttribute("name", currentTask + "Request");
    newPart = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:part");
    newPart.setAttribute("name", newMessage.getAttribute("name"));
    newPart.setAttribute("element", "tschema:" + newElement.getAttribute("name")); // Data binding
    newMessage.appendChild(newPart);
    wsdlDefinitions.appendChild(newMessage);

    // create portType element
    newPortType = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:portType");
    newPortType.setAttribute("name", currentTask + "PT"); // Interface Port
    // Type
    newOperation = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:operation");
    newOperation.setAttribute("name", operationName); // Interface Operation
    newInput = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:input");
    newInput.setAttribute("message", newMessage.getAttribute("name")); // message
    // binding
    newOperation.appendChild(newInput);
    newPortType.appendChild(newOperation);
    wsdlDefinitions.appendChild(newPortType);

    // create Binding element
    newBinding = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:binding");
    newBinding.setAttribute("name", currentTask + "Binding"); // Data element
    // name
    newBinding.setAttribute("type", "tns:" + newPortType.getAttribute("name")); // PortTypeName
    newSoapBinding = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/soap/", "soap:binding");
    newSoapBinding.setAttribute("style", "document"); // part element
    newSoapBinding.setAttribute("transport",
        "http://schemas.xmlsoap.org/soap/http"); // tns: complextypename
    newWSDLBindingOperation = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/", "wsdl:operation");
    newWSDLBindingOperation.setAttribute("name", operationName); // Operation
    // Name
    newWSDLBindingSoapOperation = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/soap/", "soap:operation");
    newWSDLBindingSoapOperation.setAttribute("soapAction", "urn:" + operationName);
    newWSDLBindingSoapOperation.setAttribute("style", "document");
    newWSDLBindingInput = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/", "wsdl:input");
    newSoapInputBody = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/soap/", "soap:body");
    newSoapInputBody.setAttribute("use", "literal");
    newWSDLBindingInput.appendChild(newSoapInputBody);
    newWSDLBindingOperation.appendChild(newWSDLBindingSoapOperation);
    newWSDLBindingOperation.appendChild(newWSDLBindingInput);
    newBinding.appendChild(newSoapBinding);
    newBinding.appendChild(newWSDLBindingOperation);
    wsdlDefinitions.appendChild(newBinding);

    // create service element
    newService = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:service");
    newService.setAttribute("name", serviceName); // Data element name
    newPort = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:port");
    newPort.setAttribute("name", portName); // part element
    newPort.setAttribute("binding", newBinding.getAttribute("name")); // tns:complextypename
    newAddress = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/soap/", "soap:address");
    newAddress.setAttribute("location", serviceURL); // Service URL
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
function generateOutputWSDL(wsdlDom, currentTask) {
    currentTaskName = currentTask + "wrapper";
    serviceURL = $('#' + currentTaskName + ' #taskCallbackServiceURL').val();
    operationName = $('#' + currentTaskName + ' #taskCallbackOperationName')
        .val();
    serviceName = $('#' + currentTaskName + ' #taskCallbackServiceName').val();
    portName = currentTask + "CBPort";
    outputElements = $('#' + currentTaskName + ' #outputmappingTable tr');
    // get Definitions
    wsdlSchema = wsdlDom.getElementsByTagName("schema")[0];
    wsdlDefinitions = wsdlDom.getElementsByTagName("definitions")[0];
    // create types(data)
    newComplexType = wsdlDom.createElementNS(
        "http://www.w3.org/2001/XMLSchema", "xsd:complexType");
    newComplexType.setAttribute("name", currentTask + "CBDataType"); // Data
    // type
    // Name
    newSequence = wsdlDom.createElementNS("http://www.w3.org/2001/XMLSchema",
        "xsd:sequence");
    // should loop for input types
    outputElements.each(function(i, obj) {
        if (i != 0) {
            k = $(this).find("input#taskOutputMappingid").val();
            type = "xsd:" + $("#" + currentTaskName + " #taskOutputMappingType" + k)
                .val();
            newSubElement = wsdlDom.createElementNS(
                "http://www.w3.org/2001/XMLSchema", "xsd:element");
            newSubElement.setAttribute("name", $(this).find(
                "input#taskOutputMappingElementName" + k).val()); // Data
            // element
            // name
            // field
            newSubElement.setAttribute("type", type); // Data element type
            // field
            newSequence.appendChild(newSubElement);
        }
    });

    // should loop for input types
    newComplexType.appendChild(newSequence);

    // createElement
    newElement = wsdlDom.createElementNS("http://www.w3.org/2001/XMLSchema",
        "xsd:element"); // scheme.appendchild()
    newElement.setAttribute("name", currentTask + "CBData"); // part element
    newElement.setAttribute("type", "tns:" + currentTask + "CBDataType"); // tns:
    // complextypename
    wsdlSchema.appendChild(newElement);
    wsdlSchema.appendChild(newComplexType);
    // create message
    newMessage = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:message");
    newMessage.setAttribute("name", currentTask + "CBRequest");
    newPart = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:part");
    newPart.setAttribute("name", newMessage.getAttribute("name")); // ClaimApprovalRequest
    newPart.setAttribute("element", "tschema:" + newElement.getAttribute("name")); // Data
    // binding
    newMessage.appendChild(newPart);
    wsdlDefinitions.appendChild(newMessage);
    // create portType
    newPortType = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:portType");
    newPortType.setAttribute("name", currentTask + "CBPT"); // Interface Port
    // Type
    newOperation = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:operation");
    newOperation.setAttribute("name", operationName); // Interface Operation
    newInput = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:input");
    newInput.setAttribute("message", newMessage.getAttribute("name")); // message
    // binding
    newOperation.appendChild(newInput);
    newPortType.appendChild(newOperation);
    wsdlDefinitions.appendChild(newPortType);
    // {create service element}
    newBinding = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:binding");
    newBinding.setAttribute("name", currentTask + "CBBinding"); // Data element
    // name
    newBinding.setAttribute("type", "tns:" + newPortType.getAttribute("name")); // PortTypeName
    newSoapBinding = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/soap/", "soap:binding");
    newSoapBinding.setAttribute("style", "document"); // part element
    newSoapBinding.setAttribute("transport",
        "http://schemas.xmlsoap.org/soap/http"); // tns: complextypename
    newWSDLBindingOperation = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/", "wsdl:operation");
    newWSDLBindingOperation.setAttribute("name", operationName); // Operation
    // Name'
    newWSDLBindingSoapOperation = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/soap/", "soap:operation");
    newWSDLBindingSoapOperation.setAttribute("soapAction", "urn:" + operationName);
    newWSDLBindingSoapOperation.setAttribute("style", "document");
    newWSDLBindingInput = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/", "wsdl:input");
    newSoapInputBody = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/soap/", "soap:body");
    newSoapInputBody.setAttribute("use", "literal");
    newWSDLBindingInput.appendChild(newSoapInputBody);
    newWSDLBindingOperation.appendChild(newWSDLBindingSoapOperation);
    newWSDLBindingOperation.appendChild(newWSDLBindingInput);
    newBinding.appendChild(newSoapBinding);
    newBinding.appendChild(newWSDLBindingOperation);
    wsdlDefinitions.appendChild(newBinding);
    // {create binding}
    newService = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:service");
    newService.setAttribute("name", serviceName); // Data element name
    newPort = wsdlDom.createElementNS("http://schemas.xmlsoap.org/wsdl/",
        "wsdl:port");
    newPort.setAttribute("name", portName); // part element
    newPort.setAttribute("binding", newBinding.getAttribute("name")); // tns:complextypename
    newAddress = wsdlDom.createElementNS(
        "http://schemas.xmlsoap.org/wsdl/soap/", "soap:address");
    newAddress.setAttribute("location", serviceURL); // Service URL
    newPort.appendChild(newAddress);
    newService.appendChild(newPort);
    wsdlDefinitions.appendChild(newService);

}

var xmlDom;
process();

/*
 * Signature: saveSource() {...}
 * 
 * This method is called on page change when switching from UI editor to text
 * editor. This method calls generateTasks method which creates ht dom from UI
 * elements. After this method marshals the xml DOM into the text editor on page
 * 1
 * 
 */
function saveSource() {
    try {
        if (xmlDom.getElementsByTagName("task").length != 0) {
            generateTasks();
            IDESaveContent(new XMLSerializer().serializeToString((xmlDom)));
        } else {
            IDESaveContent("");
        }
    } catch (err) {
        alert(err);
    }

}

/*
 * Signature: process() {...}
 * 
 * This method is called on page change from text editor to UI editor. This
 * method calls generateUI method which generates the UI in the UI editor with
 * the respective values.
 * 
 */
function process() {
    try {
        generateUI();

    } catch (err) {
        alert(err);
    }
}

/*
 * Signature: generateTasks() {...}
 * 
 * This method traverses the humantask DOM and calls fills out the values for
 * each task in the dom.
 * 
 */
function generateTasks() {
    // Generate Menu Items
    tasksList = xmlDom.getElementsByTagName("task");
    nodes = Array.prototype.slice.call(tasksList, 0);
    nodes.forEach(function(taskNode) {
        generateText(taskNode);
    });
}

/*
 * Signature: generateUI() {...}
 * 
 * This method iterates over the task nodes and creates the UI elements(using
 * generateTaskDiv function) for each task node in the human task dom.
 * 
 */
function generateUI() {
    xmlDom = marshalEditorTextContent(IDEGetFileContent());
    // Generate Menu Items
    tasksList = xmlDom.getElementsByTagName("task");
    nodes = Array.prototype.slice.call(tasksList, 0);
    $("#page-content-wrapper #tabNames li").remove();
    $('#nooftasks').val(0);
    nodes.forEach(function(taskNode) {
        taskName = taskNode.getAttribute("name");
        generateTaskDiv(taskNode); // create respective Div for each task
        $("#page-content-wrapper #tabNames").append("<li class='taskDivHolder' ><a href='#" + taskName + "wrapper'>" + taskName + "</a></li>");
    });
    //$('.taskDiv').hide();
    $("#page-content-wrapper #tabNames li:contains('+')").remove();
    $("#page-content-wrapper #tabNames").append("<li><a id='addNewTask' href=''>+</a></li>");
    $('#addNewTask').click(function() {
        AddTask();
    });

    $("#page-content-wrapper").tabs();
    $("#page-content-wrapper").tabs("refresh");
}

/*
 * Signature: toTitleCase(str) {...}
 * 
 * This is a util function which converts a String to Titlecase.
 * 
 */
function toTitleCase(str) {
    if (str != undefined)
        return str.replace(/(?:^|\s)\w/g, function(match) {
            return match.toUpperCase();
        });
    else {
        return str;
    }
}

/*
 * Signature: generateTaskDiv(taskNode) {...}
 * 
 * This method converts humantask dom's task node into UI. A task node of
 * humantask DOM should be provided as a parameter(taskNode)
 * 
 */
function generateTaskDiv(taskNode) {
    var formDiv = $('#genericForm').clone(true, true).val("");
    taskName = taskNode.getAttribute("name");
    taskDivName = taskName + "wrapper";
    $('#genericForm').hide();
    //$("#page-content-wrapper #tabNames li:contains('"+taskName+"')").remove();
    $("#page-content-wrapper div #" + taskDivName).remove();
    $("#page-content-wrapper").append("<div id='" + taskDivName + "'></div>");
    $('#' + taskDivName).html(formDiv);
    $('#' + taskDivName).off();
    $('#' + taskDivName + " #taskMappingNo").val(0);
    $('#' + taskDivName + " #taskOutputMappingNo").val(0);
    i = parseInt($('#nooftasks').val());
    //alert(i);
    i++;
    $('#nooftasks').val(i);
    // Add input mapping row
    $('#' + taskDivName + " #addInput").off('click');
    $('#' + taskDivName + " #addInput")
        .off()
        .click(
            function(e) {
                // create DOM node for new input
                var inputNode = taskNode.getElementsByTagName("renderings")[0]
                    .getElementsByTagName("inputs")[0];
                var newInputElement = xmlDom.createElementNS(
                    "http://wso2.org/ht/schema/renderings/",
                    "wso2:element");
                newInputElement.setAttribute("id", "Dummy"); //place holder
                newLabel = xmlDom.createElementNS(
                    "http://wso2.org/ht/schema/renderings/",
                    "wso2:label");
                newLabelText = xmlDom.createTextNode("Dummy");
                newLabel.appendChild(newLabelText);
                newInputElement.appendChild(newLabel);
                newValue = xmlDom.createElementNS(
                    "http://wso2.org/ht/schema/renderings/",
                    "wso2:value");
                newValueText = xmlDom.createTextNode("Dummy");
                newValue.appendChild(newValueText);
                newInputElement.appendChild(newValue);
                inputNode.appendChild(newInputElement);

                // bind click event
                e.preventDefault();
                var mappingNo = parseInt($('#' + taskNode.getAttribute("name") + "wrapper #taskMappingNo").val());
                mapping = '<tr id="inputmapping' + mappingNo + '"><td width="25%"><input name="taskInputMappingid" type="hidden" id="taskInputMappingid" value="' + mappingNo + '"><input name="textfield6" type="text" id="taskInputMappingElementName' + mappingNo + '" value="dummy"></td><td width="25%"><input name="textfield7" type="text" id="taskInputMappingDisplayName' + mappingNo + '" value="dummy"></td><td width="10%"><input name="textfield8" type="text" id="taskInputMappingOrder' + mappingNo + '" value="' + $(
                    '#' + taskNode.getAttribute("name") + "wrapper #taskMappingNo").val() + '"></td><td width="20%"><label><select id="taskInputMappingType' + mappingNo + '" name="select3"><option value="string" selected>string</option><option value="int">int</option><option value="double">double</option><option value="float">float</option><option value="boolean">boolean</option><option value="organizationalEntity">organizationalEntity</option></select></label></td><td><label><input type="button" class="inputDeleteButton" name="deleteButton' + mappingNo + '" id="deleteButton' + mappingNo + '" value="Delete"></label></td></tr>';
                //	alert(mapping);
                $(
                    "#" + taskNode.getAttribute("name") + "wrapper #inputmappingTable").append(
                    mapping);

                // delete button click event
                $(
                        '#' + taskNode.getAttribute("name") + 'wrapper .inputDeleteButton')
                    .off()
                    .click(
                        function(er) {
                            er.preventDefault();
                            try {
                                deleteId = er.target.id
                                    .replace(/[^\d.]/g, '');
                                alert(er.target.id);
                                $('#' + taskNode.getAttribute("name") + "wrapper #inputmapping" + deleteId + "").html('');
                                alert(newInputElement.getAttribute("id"));
                                inputNode
                                    .removeChild(newInputElement);

                            } catch (err) {

                                alert("This is delete " + err);
                            }
                            generateText(taskNode);
                            generateTaskDiv(taskNode);

                        });
                mappingNo++;
                //alert(mappingNo);
                $(
                    '#' + taskNode.getAttribute("name") + "wrapper #taskMappingNo").val(
                    mappingNo);
                /*alert($(
								'#' + taskNode.getAttribute("name")
										+ "wrapper #taskMappingNo").val());*/
            });

    // Add output mapping row
    $('#' + taskDivName + " #addOutput")
        .off()
        .click(
            function(el) {
                try {

                    // create dom node
                    var outputNode = taskNode
                        .getElementsByTagName("renderings")[0]
                        .getElementsByTagName("outputs")[0];
                    var newOutputElement = xmlDom.createElementNS(
                        "http://wso2.org/ht/schema/renderings/",
                        "wso2:element");
                    newOutputElement.setAttribute("id", "");
                    newLabel = xmlDom.createElementNS(
                        "http://wso2.org/ht/schema/renderings/",
                        "wso2:label");
                    newLabelText = xmlDom.createTextNode("");
                    newLabel.appendChild(newLabelText);
                    newOutputElement.appendChild(newLabel);
                    newXpath = xmlDom.createElementNS(
                        "http://wso2.org/ht/schema/renderings/",
                        "wso2:xpath");
                    newXpathText = xmlDom.createTextNode("");
                    newXpath.appendChild(newXpathText);
                    newOutputElement.appendChild(newXpath);
                    newValue = xmlDom.createElementNS(
                        "http://wso2.org/ht/schema/renderings/",
                        "wso2:value");
                    newValueText = xmlDom.createTextNode("");
                    newValue.appendChild(newValueText);
                    newOutputElement.appendChild(newValue);
                    newDefault = xmlDom.createElementNS(
                        "http://wso2.org/ht/schema/renderings/",
                        "wso2:default");
                    newDefaultText = xmlDom.createTextNode("");
                    newDefault.appendChild(newDefaultText);
                    newOutputElement.appendChild(newDefault);
                    outputNode.appendChild(newOutputElement);

                    // bind click event
                    el.preventDefault();
                    var outputmappingNo = parseInt($(
                            '#' + taskNode.getAttribute("name") + "wrapper #taskOutputMappingNo")
                        .val());
                    outputmapping = '<tr id="outputmapping' + outputmappingNo + '"><td width="25%"><input name="taskOutputMappingid" type="hidden" id="taskOutputMappingid" value="' + outputmappingNo + '"><input name="textfield6" type="text" id="taskOutputMappingElementName' + outputmappingNo + '" value="dummy"></td><td width="25%"><input name="textfield7" type="text" id="taskOutputMappingDisplayName' + outputmappingNo + '" value="dummy"></td><td width="10%"><input name="textfield8" type="text" id="taskOutputMappingOrder' + outputmappingNo + '" value="dummy"></td><td width="20%"><label><select id="taskOutputMappingType' + outputmappingNo + '" name="select3"><option value="string" selected>string</option><option value="int">int</option><option value="double">double</option><option value="float">float</option><option value="boolean">boolean</option><option value="organizationalEntity">organizationalEntity</option></select></label></td><td width="10%"><label><input name="textfield12" type="text" id="taskOutputMappingDefaultValues' + outputmappingNo + '" value="dummy"></label></td><td><label><input type="button" class="outputDeleteButton" name="outputDeleteButton' + outputmappingNo + '" id="outputDeleteButton' + outputmappingNo + '" value="Delete"></label></td></tr>';
                    $(
                            "#" + taskNode.getAttribute("name") + "wrapper #outputmappingTable")
                        .append(outputmapping);
                    // delete button click event
                    $(
                            '#' + taskNode.getAttribute("name") + 'wrapper .outputDeleteButton')
                        .off()
                        .click(function(eo) {
                            eo.preventDefault();
                            try {
                                deleteId = el.target.id
                                    .replace(/[^\d.]/g,
                                        '');
                                $('#' + taskNode.getAttribute("name") + "wrapper #outputmapping" + deleteId + "").html(
                                    '');
                                alert(newOutputElement);
                                outputNode
                                    .removeChild(newOutputElement);
                            } catch (err) {
                                alert(err);
                            }
                            generateText(taskNode);
                            generateTaskDiv(taskNode);

                        });
                    outputmappingNo++;
                    $(
                            '#' + taskNode.getAttribute("name") + "wrapper #taskOutputMappingNo")
                        .val(outputmappingNo);

                } catch (err) {
                    alert(err);
                }
            });

    // sync rendering values into input mapping table
    var inputNodes = taskNode.getElementsByTagName("renderings")[0]
        .getElementsByTagName("inputs")[0].childNodes;
    $("#" + taskDivName + " #inputmappingTable")
        .html(
            '<tr><th width="25%" scope="col">Element Name</th><th width="25%" scope="col">Display Name</th><th width="10%" scope="col">Value</th><th width="20%" scope="col">Type</th></tr>');
    for (i = 0; i < inputNodes.length; i++) {
        if (inputNodes[i].nodeName != "#text") {
            try {
                var mappingNo = parseInt($(
                    '#' + taskDivName + " #taskMappingNo").val());
                mapping = '<tr id="inputmapping' + mappingNo + '"><td width="25%"><input name="taskInputMappingid" type="hidden" id="taskInputMappingid" value="' + mappingNo + '"/><input name="textfield6" type="text" id="taskInputMappingElementName' + mappingNo + '" value="' + inputNodes[i].getAttribute("id") + '"/></td><td width="25%"><input name="textfield7" type="text" id="taskInputMappingDisplayName' + mappingNo + '" value="' + inputNodes[i].getElementsByTagName("label")[0].childNodes[0].nodeValue + '"/></td><td width="10%"><input name="textfield8" type="text" id="taskInputMappingOrder' + mappingNo + '" value="' + inputNodes[i].getElementsByTagName("value")[0].childNodes[0].nodeValue + '"/></td><td width="20%"><label><select id="taskInputMappingType' + mappingNo + '" name="select3"><option value="string" selected>string</option><option value="int">int</option><option value="double">double</option><option value="float">float</option><option value="boolean">boolean</option><option value="organizationalEntity">organizationalEntity</option></select></label></td><td><label><input type="button" class="inputDeleteButton" name="deleteButton' + mappingNo + '" id="deleteButton' + mappingNo + '" value="Delete"></label></td></tr>';
                $("#" + taskDivName + " #inputmappingTable").append(mapping);

                // bind delete event
                $('#' + taskDivName + ' .inputDeleteButton')
                    .off()
                    .click(
                        function(er) {
                            er.preventDefault();
                            try {
                                k = i;
                                var deleteId = er.target.id.replace(
                                    /[^\d.]/g, '');
                                var deleteNodeId = 0;
                                for (j = 0; j < inputNodes.length; j++) {
                                    if (inputNodes[j].nodeName != "#text") {
                                        if (parseInt(deleteId) === deleteNodeId) {
                                            taskNode
                                                .getElementsByTagName("renderings")[0]
                                                .getElementsByTagName("inputs")[0]
                                                .removeChild(inputNodes[j]);

                                            break;
                                        }
                                        deleteNodeId++;
                                    }
                                }
                                generateTaskDiv(taskNode);
                            } catch (err) {
                                alert(err);
                            }
                        });
                mappingNo++;
                $('#' + taskDivName + " #taskMappingNo").val(mappingNo);
            } catch (err) {
                alert(err);
            }
        }

    }

    // sync output rendering values into output mapping table
    var outputNodes = taskNode.getElementsByTagName("renderings")[0]
        .getElementsByTagName("outputs")[0].childNodes;
    $("#" + taskDivName + " #outputmappingTable")
        .html(
            '<tr><th width="25%" scope="col">Element Name</th><th width="25%" scope="col">Display Name</th><th width="10%" scope="col">Value</th><th width="20%" scope="col">Type</th><th width="20%" scope="col">Default Values</th></tr>');
    for (i = 0; i < outputNodes.length; i++) {
        if (outputNodes[i].nodeName != "#text") {
            try {
                var outputmappingNo = parseInt($(
                    '#' + taskDivName + " #taskOutputMappingNo").val());
                outputmapping = '<tr id="outputmapping' + outputmappingNo + '"><td width="25%"><input name="taskOutputMappingid" type="hidden" id="taskOutputMappingid" value="' + outputmappingNo + '"><input name="textfield6" type="text" id="taskOutputMappingElementName' + outputmappingNo + '" value="' + outputNodes[i].getAttribute("id") + '"></td><td width="25%"><input name="textfield7" type="text" id="taskOutputMappingDisplayName' + outputmappingNo + '" value="' + outputNodes[i].getElementsByTagName("label")[0].childNodes[0].nodeValue + '"></td><td width="10%"><input name="textfield8" type="text" id="taskOutputMappingOrder' + outputmappingNo + '" value="' + outputNodes[i].getElementsByTagName("value")[0].childNodes[0].nodeValue + '"></td><td width="20%"><label><select id="taskOutputMappingType' + outputmappingNo + '" name="select3"><option value="string" selected>string</option><option value="int">int</option><option value="double">double</option><option value="float">float</option><option value="boolean">boolean</option><option value="organizationalEntity">organizationalEntity</option></select></label></td><td width="10%"><label><input name="textfield12" type="text" id="taskOutputMappingDefaultValues' + outputmappingNo + '" value="' + outputNodes[i].getElementsByTagName("default")[0].childNodes[0].nodeValue + '"></label></td><td><label><input type="button" class="outputDeleteButton" name="outputDeleteButton' + outputmappingNo + '" id="outputDeleteButton' + outputmappingNo + '" value="Delete"></label></td></tr>';
                $("#" + taskDivName + " #outputmappingTable").append(
                    outputmapping);

                // bind delete event
                $('#' + taskDivName + ' .outputDeleteButton')
                    .off()
                    .click(
                        function(eo) {
                            eo.preventDefault();
                            try {
                                k = i;
                                // alert(inputNodes[k].getAttribute("id"));
                                var deleteId = eo.target.id.replace(
                                    /[^\d.]/g, '');
                                // $('#'+taskDivName+" #inputmapping"+
                                // deleteId+"").html('');
                                var deleteNodeId = 0;
                                for (j = 0; j < outputNodes.length; j++) {
                                    if (outputNodes[j].nodeName != "#text") {
                                        if (parseInt(deleteId) === deleteNodeId) {
                                            taskNode
                                                .getElementsByTagName("renderings")[0]
                                                .getElementsByTagName("outputs")[0]
                                                .removeChild(outputNodes[j]);
                                            break;
                                        }
                                        deleteNodeId++;
                                    }
                                }
                                generateTaskDiv(taskNode);
                            } catch (err) {
                                alert(err);
                            }
                        });
                outputmappingNo++;
                $('#' + taskDivName + " #taskOutputMappingNo").val(
                    outputmappingNo);
            } catch (err) {
                alert(err);
            }
        }
    }

    // sync other fields
    // $('#' + taskDivName + " #taskTitle").text(taskName.trim());
    $('#' + taskDivName + " #taskName").val(taskName.trim());
    $('#' + taskDivName + " #taskDocumentation")
        .val(
            taskNode.getElementsByTagName("documentation")[0].childNodes[0].nodeValue
            .trim());
    $('#' + taskDivName + " #taskPriority")
        .val(
            taskNode.getElementsByTagName("priority")[0].childNodes[0].nodeValue
            .trim());
    $('#' + taskDivName + " #taskOperation").val(
        taskNode.getElementsByTagName("interface")[0].getAttribute(
            "operation").trim());
    // service URL mapping
    $('#' + taskDivName + " #taskCallbackOperationName").val(
        taskNode.getElementsByTagName("interface")[0].getAttribute(
            "responseOperation").trim());

    $('#' + taskDivName + " #presentationElementDisplayName").val(
        taskNode.getElementsByTagName("presentationElements")[0]
        .getElementsByTagName("name")[0].childNodes[0].nodeValue
        .trim());
    $('#' + taskDivName + " #presentationElementDisplaySubject").val(
        taskNode.getElementsByTagName("presentationElements")[0]
        .getElementsByTagName("subject")[0].childNodes[0].nodeValue
        .trim());
    $('#' + taskDivName + " #presentationElementDescription")
        .val(
            taskNode.getElementsByTagName("presentationElements")[0]
            .getElementsByTagName("description")[0].childNodes[0].nodeValue
            .trim());

    // sync People assinments potential owners
    ownerType = toTitleCase(taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("potentialOwners")[0]
        .getElementsByTagName("argument")[0].getAttribute("name"));
    $(
        '#' + taskDivName + " input[name=potentialOwners][value=potentialOwners" + ownerType + "]").prop("checked", true);
    $('#' + taskDivName + " #potentialOwnersRole")
        .val(
            taskNode.getElementsByTagName("peopleAssignments")[0]
            .getElementsByTagName("potentialOwners")[0]
            .getElementsByTagName("argument")[0].childNodes[0].nodeValue
            .trim());
    ownerType = toTitleCase(taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("businessAdministrators")[0]
        .getElementsByTagName("argument")[0].getAttribute("name"));
    $(
        '#' + taskDivName + " input[name=businessAdministrators][value=businessAdministrators" + ownerType + "]").prop("checked", true);
    $('#' + taskDivName + " #businessAdministratorsRole")
        .val(
            taskNode.getElementsByTagName("peopleAssignments")[0]
            .getElementsByTagName("businessAdministrators")[0]
            .getElementsByTagName("argument")[0].childNodes[0].nodeValue
            .trim());
    $('#' + taskDivName + ' .taskDiv').show();

}

/*
 * Signature: generateText(taskNode) {...}
 * 
 * This method fills XML dom from UI elements in the editor.
 * 
 */

function generateText(taskNode) {
    taskName = taskNode.getAttribute("name");
    taskDivName = taskName + "wrapper";

    // fill general details
    taskNode.setAttribute("name", $('#' + taskDivName + " #taskName").val());
    taskNode.getElementsByTagName("documentation")[0].childNodes[0].nodeValue = $(
        '#' + taskDivName + " #taskDocumentation").val();
    taskNode.getElementsByTagName("priority")[0].childNodes[0].nodeValue = $(
        '#' + taskDivName + " #taskPriority").val();
    taskNode.getElementsByTagName("interface")[0].setAttribute("operation", $(
        '#' + taskDivName + " #taskOperation").val());
    taskNode.getElementsByTagName("presentationElements")[0]
        .getElementsByTagName("name")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #presentationElementDisplayName").val();
    taskNode.getElementsByTagName("presentationElements")[0]
        .getElementsByTagName("subject")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #presentationElementDisplaySubject").val();
    taskNode.getElementsByTagName("presentationElements")[0]
        .getElementsByTagName("description")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #presentationElementDescription").val();
    taskNode.getElementsByTagName("interface")[0].setAttribute("operation", $(
        '#' + taskDivName + " #taskOperation").val());
    taskNode.getElementsByTagName("interface")[0].getAttribute(
        "responseOperation", $(
            '#' + taskDivName + " #taskCallbackOperationName").val())
    taskNode.getElementsByTagName("interface")[0].getAttribute("portType",
        taskName + "PT");
    taskNode.getElementsByTagName("interface")[0].getAttribute(
            "responsePortType", taskName + "CBPT")
        // fill input mappings
    inputmappingNo = parseInt($('#' + taskDivName + " #taskMappingNo").val());
    inputNodes = taskNode.getElementsByTagName("renderings")[0]
        .getElementsByTagName("inputs")[0].childNodes;
    inputmapping = 0;
    for (i = 0; i < inputNodes.length; i++) {
        if (inputNodes[i].nodeName != '#text') {
            inputNodes[i].setAttribute("id", $(
                '#' + taskDivName + " #taskInputMappingElementName" + inputmapping).val());
            inputNodes[i].getElementsByTagName("label")[0].childNodes[0].nodeValue = $(
                '#' + taskDivName + " #taskInputMappingDisplayName" + inputmapping).val();
            inputNodes[i].getElementsByTagName("value")[0].childNodes[0].nodeValue = $(
                '#' + taskDivName + " #taskInputMappingOrder" + inputmapping).val();
            inputmapping++;
        }
    }

    // fill output mappings
    outputmappingNo = parseInt($('#' + taskDivName + " #taskOutputMappingNo")
        .val());
    outputNodes = taskNode.getElementsByTagName("renderings")[0]
        .getElementsByTagName("outputs")[0].childNodes;

    outputmapping = 0;
    for (i = 0; i < outputNodes.length; i++) {
        if (outputNodes[i].nodeName != '#text') {
            outputNodes[i].setAttribute("id", $(
                '#' + taskDivName + " #taskOutputMappingElementName" + outputmapping).val());
            outputNodes[i].getElementsByTagName("label")[0].childNodes[0].nodeValue = $(
                '#' + taskDivName + " #taskOutputMappingDisplayName" + outputmapping).val();
            outputNodes[i].getElementsByTagName("value")[0].childNodes[0].nodeValue = $(
                '#' + taskDivName + " #taskOutputMappingOrder" + outputmapping).val();
            outputNodes[i].getElementsByTagName("default")[0].childNodes[0].nodeValue = $(
                '#' + taskDivName + " #taskOutputMappingDefaultValues" + outputmapping).val();
            outputmapping++;
        }
    }

    // fill people assignments
    if (taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("potentialOwners").length != 0)
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("potentialOwners")[0]
        .getElementsByTagName("argument")[0]
        .setAttribute(
            "name",
            getArgumentName($(
                    '#' + taskDivName + " input[name=potentialOwners]:checked")
                .val()));
    if ($('#' + taskDivName + " input[name=potentialOwners]:checked").val() == "potentialOwnersRole")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("potentialOwners")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #potentialOwnersRole").val();
    // Set Literal Values
    /*
     * if($('#'+taskDivName+"
     * input[name=potentialOwners]:checked").val()=="potentialOwnersLiteral"){
     * taskNode.getElementsByTagName("peopleAssignments")[0].getElementsByTagName("potentialOwners")[0].getElementsByTagName("argument")[0].childNodes[0].nodeValue =
     * $('#'+taskDivName+" #potentialOwnersExpression").val();
     * taskNode.getElementsByTagName("peopleAssignments")[0].getElementsByTagName("potentialOwners")[0].getElementsByTagName("argument")[1].childNodes[0].nodeValue =
     * $('#'+taskDivName+" #potentialOwnersExpression").val(); }
     */
    if ($('#' + taskDivName + " input[name=potentialOwners]:checked").val() == "potentialOwnersExpression")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("potentialOwners")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #potentialOwnersExpression").val();

    if (taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("businessAdministrators").length != 0)
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("businessAdministrators")[0]
        .getElementsByTagName("argument")[0]
        .setAttribute(
            "name",
            getArgumentName($(
                    '#' + taskDivName + " input[name=businessAdministrators]:checked")
                .val()));
    if ($('#' + taskDivName + " input[name=businessAdministrators]:checked")
        .val() == "businessAdministratorsRole")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("businessAdministrators")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #businessAdministratorsRole").val();
    // Set Literal Values
    if ($('#' + taskDivName + " input[name=businessAdministrators]:checked")
        .val() == "businessAdministratorsExpression")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("businessAdministrators")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #businessAdministratorsExpression").val();

    if (taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("excludedOwners").length != 0)
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("excludedOwners")[0]
        .getElementsByTagName("argument")[0]
        .setAttribute("name", getArgumentName($(
            '#' + taskDivName + " input[name=excludedOwners]:checked").val()));
    if ($('#' + taskDivName + " input[name=excludedOwners]:checked").val() == "excludedOwnersRole")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("excludedOwners")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #excludedOwnersRole").val();
    // Set Literal Values
    if ($('#' + taskDivName + " input[name=excludedOwners]:checked").val() == "excludedOwnersExpression")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("excludedOwners")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #excludedOwnersExpression").val();

    if (taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskInitiator").length != 0)
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskInitiator")[0]
        .getElementsByTagName("argument")[0].setAttribute("name",
            getArgumentName($(
                '#' + taskDivName + " input[name=taskInitiator]:checked").val()));
    if ($('#' + taskDivName + " input[name=taskInitiator]:checked").val() == "taskInitiatorRole")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskInitiator")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #taskInitiatorRole").val();
    // Set Literal Values
    if ($('#' + taskDivName + " input[name=taskInitiator]:checked").val() == "taskInitiatorExpression")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskInitiator")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #taskInitiatorExpression").val();

    if (taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskStakeholders").length != 0)
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskStakeholders")[0]
        .getElementsByTagName("argument")[0].setAttribute("name",
            getArgumentName($(
                    '#' + taskDivName + " input[name=taskStakeholders]:checked")
                .val()));
    if ($('#' + taskDivName + " input[name=taskStakeholders]:checked").val() == "taskStakeholdersRole")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskStakeholders")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #taskStakeholdersRole").val();
    // Set Literal Values
    if ($('#' + taskDivName + " input[name=taskStakeholders]:checked").val() == "taskStakeholdersExpression")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskStakeholders")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #taskStakeholdersExpression").val();
    // if(toTitleCase($('#'+taskDivName+"
    // input[name=businessAdministrators]:checked").val())=="Expression")taskNode.getElementsByTagName("peopleAssignments")[0].getElementsByTagName("potentialOwners")[0].getElementsByTagName("argument")[0].childNodes[0].nodeValue
    // = $('#'+taskDivName+" #businessAdministratorsExpression").val();

    /*
     * if(toTitleCase($('#'+taskDivName+"
     * #input[name=excludedOwners]:checked").val())=="Role")taskNode.getElementsByTagName("peopleAssignments")[0].getElementsByTagName("excludedOwners")[0].getElementsByTagName("argument")[0].setAttribute("name",$('#'+taskDivName+"
     * #input[name=excludedOwners]:checked").val())
     * taskNode.getElementsByTagName("peopleAssignments")[0].getElementsByTagName("excludedOwners")[0].getElementsByTagName("argument")[0].childNodes[0].nodeValue =
     * $('#'+taskDivName+" #excludedOwnersRole").val();
     * if(toTitleCase($('#'+taskDivName+"
     * #input[name=taskInitiator]:checked").val())=="Role")taskNode.getElementsByTagName("peopleAssignments")[0].getElementsByTagName("taskInitiator")[0].getElementsByTagName("argument")[0].setAttribute("name",$('#'+taskDivName+"
     * #input[name=taskInitiator]:checked").val())
     * taskNode.getElementsByTagName("peopleAssignments")[0].getElementsByTagName("taskInitiator")[0].getElementsByTagName("argument")[0].childNodes[0].nodeValue =
     * $('#'+taskDivName+" #taskInitiatorRole").val();
     * if(toTitleCase($('#'+taskDivName+"
     * #input[name=taskStakeholders]:checked").val())=="Role")taskNode.getElementsByTagName("peopleAssignments")[0].getElementsByTagName("taskStakeholders")[0].getElementsByTagName("argument")[0].setAttribute("name",$('#'+taskDivName+"
     * #input[name=taskStakeholders]:checked").val())
     * taskNode.getElementsByTagName("peopleAssignments")[0].getElementsByTagName("taskStakeholders")[0].getElementsByTagName("argument")[0].childNodes[0].nodeValue =
     * $('#'+taskDivName+" #taskStakeholdersRole").val();
     */

    CreateFile(taskName);
}

function getArgumentName(nameValue) {
    if (nameValue) {
        if (nameValue.indexOf("Role") != -1)
            return "Role";
        else if (nameValue.indexOf("Literal") != -1)
            return "Literal";
        else if (nameValue.indexOf("Expression") != -1)
            return "Expression";
        else
            return "None";
    } else {
        //alert("Returns None");
        return "None";
    }
}

function marshalEditorTextContent(textContent) {
    try {
        var parser = new DOMParser();
        var root = parser.parseFromString(textContent, "text/xml");
    } catch (err) {
        alert(err);
    }
    return root;
}

function loadFileContent() {
    // Read contents of the file.
    var fileContent = IDEGetFileContent();

}

$('.sectionHeader').click(function() {
    $(this).parent().find('.taskSection').slideToggle(500);

});