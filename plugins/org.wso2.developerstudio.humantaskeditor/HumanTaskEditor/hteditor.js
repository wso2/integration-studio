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
function createFile(currentTaskName) { //createFile

    // Create Task WSDL
    $.get('resources/dummy.wsdl', function(data) {
        try {
            wsdlDom = marshalEditorTextContent(data);
            generateInputWSDL(wsdlDom, currentTaskName);
            saveWSDL(wsdlDom, currentTaskName + "Task");

        } catch (err) {
            alert(err);
        }

    });
    // Create Task Callback WSDL
    $.get('resources/dummy.wsdl', function(data) {
        try {
            wsdlCBDom = marshalEditorTextContent(data);
            generateOutputWSDL(wsdlCBDom, currentTaskName);
            saveWSDL(wsdlCBDom, currentTaskName + "CBTask");

        } catch (err) {
            alert(err);
        }

    });
}

/*
 * Signature: addTask(){...}
 * 
 * This method generates creates a new task. This method add a dummy task node into the ht file and adds a new task tab and Ui elements respectively
 * 
 * 
 */
function addTask() { //createFile
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
        addTask();
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
                $('#' + taskDivName +' #taskInputMappingType' + mappingNo).val(inputNodes[i].getAttribute("type").replace("xsd:", ""));
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
                $('#' + taskDivName +' #taskOutputMappingType' + mappingNo).val(outputNodes[i].getAttribute("type").replace("xsd:", ""));
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
            inputNodes[i].setAttribute("type","xsd:" + $(
                '#' + taskDivName + " #taskInputMappingType" + inputmapping).val());
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
            outputNodes[i].setAttribute("type","xsd:" + $(
                '#' + taskDivName + " #taskOutputMappingType" + outputmapping).val());
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
        alert($(
            '#' + taskDivName + " #potentialOwnersRole").val());
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

    createFile(taskName);
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
